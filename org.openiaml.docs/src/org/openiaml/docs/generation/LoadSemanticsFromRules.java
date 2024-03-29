/**
 * 
 */
package org.openiaml.docs.generation;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openiaml.docs.generation.BasicJavadocParser.IJavadocReferenceCreator;
import org.openiaml.docs.generation.semantics.ITagHandler;
import org.openiaml.docs.generation.semantics.SemanticHandlerException;
import org.openiaml.docs.modeldoc.DroolsPackage;
import org.openiaml.docs.modeldoc.DroolsRule;
import org.openiaml.docs.modeldoc.JavaElement;
import org.openiaml.docs.modeldoc.JavadocFragment;
import org.openiaml.docs.modeldoc.ModelDocumentation;
import org.openiaml.docs.modeldoc.ModeldocFactory;
import org.openiaml.model.drools.DroolsInferenceEngine;

/**
 * @author jmwright
 *
 */
public class LoadSemanticsFromRules extends DocumentationHelper implements ILoader {
	
	private DroolsInferenceEngine engine;
	
	private String plugin;
	
	private String ruleBase;

	private DocumentationGenerator generator;
	
	/**
	 * @param engine
	 * @param plugin
	 * @param ruleBase
	 * @param semanticTagHandlers
	 */
	public LoadSemanticsFromRules(DroolsInferenceEngine engine, String plugin,
			String ruleBase, DocumentationGenerator generator) {
		super();
		this.engine = engine;
		this.plugin = plugin;
		this.ruleBase = ruleBase;
		this.generator = generator;
	}

	public List<ITagHandler> getSemanticTagHandlers() {
		return generator.getSemanticTagHandlers();
	}
	
	/**
	 * @param factory
	 * @param root
	 * @throws IOException 
	 */
	public void load(ModeldocFactory factory, ModelDocumentation root) throws DocumentationGenerationException {

		// for each rule file
		for (String file : engine.getRuleFiles()) {
			// load the inference rules
			String[] bits = getSimpleFilename(file);
			try {
				
				loadInferenceSemantics(factory, 
						root,
						plugin /* plugin */,
						bits[0] /* package */,
						bits[1] /* name */,
						new File(ruleBase + file ) );
				
			} catch (IOException e) {
				throw new DocumentationGenerationException(e);
			}
		}
		
	}

	/**
	 * Parse the given Drools file for inference semantics, of
	 * the format
	 * <code># @semantics ...{@model Element} ...</code>
	 * 
	 * @param factory
	 * @param root
	 * @param plugin
	 * @param file
	 * @throws IOException 
	 * @throws DocumentationGenerationException 
	 */
	protected void loadInferenceSemantics(final ModeldocFactory factory,
			ModelDocumentation root, String plugin, String pkg,
			String name, File file) throws IOException, DocumentationGenerationException {
		
		// create a package for this rule file
		final DroolsPackage drools = factory.createDroolsPackage();
		drools.setPlugin(plugin);
		drools.setPackage(pkg);
		drools.setName(name);
		root.getReferences().add(drools);
		
		BasicJavadocParser parser = new BasicJavadocParser(getSemanticTagHandlers());
		
		try {
			// try and find the first comment from the file, in order to
			// provide documentation on the entire rule file
			JavadocFragment packageComment = parser.findFirstCommentOfFile(file, this, factory, drools, root);
			if (packageComment != null) {
				drools.getJavadocs().add(packageComment);
			}
			
			// parse all the semantics from the rules
			String[] lines = parser.findJavadocTagsInTextFile(file, this, factory, root, new IJavadocReferenceCreator() {
				
				public JavaElement createReference(String[] lines, int line) {
					DroolsRule rule = createDroolsRule(factory, line, lines);
					if (rule != null) {
						drools.getRules().add(rule);
					}
					return rule;
				}
				
			});

			// finally, find the number of unique rules
			drools.setUniqueRules(getUniqueRuleCount(factory, lines));

		} catch (SemanticHandlerException e) {
			throw new DocumentationGenerationException("Could not process rule file '" + file + "': " + e.getMessage(), e);
		}

	}
	
	/**
	 * Find the number of unique rules in this file.
	 * It achieves this naively by simply searching for lines that
	 * start with "<code>rule </code>", as per {@link #createDroolsRule(ModeldocFactory, int, String[])}.
	 * 
	 * @param factory
	 * @param lines
	 * @return the number of unique rules found
	 * @see #createDroolsRule(ModeldocFactory, int, String[])
	 */
	protected int getUniqueRuleCount(ModeldocFactory factory, String[] lines) {
		int count = 0;
		for (int line = 0; line < lines.length; line++) {
			if (lines[line].trim().startsWith("rule ")) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Parse down until we find a line starting with 
	 * <code>rule "rule title"</code>.
	 *  
	 * @return a newly created rule, or <code>null</code> if none could be found
	 */
	private DroolsRule createDroolsRule(ModeldocFactory factory, int i, String[] lines) {
		for (int j = i; j < lines.length; j++) {
			if (lines[j].trim().startsWith("rule ")) {
				// found a rule
				String ruleName = lines[j].trim();
				if (!ruleName.contains("\""))
					throw new RuntimeException("Rule does not contain \": '" + lines[j] + "'");
				ruleName = ruleName.substring(ruleName.indexOf("\"") + 1);
				if (!ruleName.contains("\""))
					throw new RuntimeException("Rule does not contain \" twice: '" + lines[j] + "'");
				ruleName = ruleName.substring(0, ruleName.lastIndexOf("\""));
				
				DroolsRule rule = factory.createDroolsRule();
				rule.setName(ruleName);
				rule.setLine(j);
				return rule;
			}
		}
		
		return null;
	}
	
}
