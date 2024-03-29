/**
 * 
 */
package org.openiaml.docs.generation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.openarchitectureware.xtend.ast.Check;
import org.openarchitectureware.xtend.ast.ExtensionFile;
import org.openarchitectureware.xtend.parser.ParseFacade;
import org.openiaml.docs.modeldoc.ChecksReference;
import org.openiaml.docs.modeldoc.Constraint;
import org.openiaml.docs.modeldoc.ConstraintType;
import org.openiaml.docs.modeldoc.EMFClass;
import org.openiaml.docs.modeldoc.FileLineReference;
import org.openiaml.docs.modeldoc.ModelDocumentation;
import org.openiaml.docs.modeldoc.ModeldocFactory;

/**
 * @author jmwright
 *
 */
public class LoadOAWConstraints extends DocumentationHelper implements ILoader {

	/**
	 * The absolute path of the checkfile to load, e.g.
	 * "../org.openiaml.model.codegen.oaw/src/metamodel/Checks.chk".
	 */
	private String checkFile;
	
	/**
	 * The plugin the generated package is stored in, e.g. "org.openiaml.model".
	 */
	private String plugin;
	
	/**
	 * The base of the check file, e.g. "src.metamodel".
	 */
	private String packageBase;
	
	/**
	 * The name of the check file, e.g. "Checks.chk".
	 */
	private String name;

	/**
	 * @param checkFile
	 * @param plugin
	 * @param packageBase
	 * @param name
	 */
	public LoadOAWConstraints(String checkFile, String plugin,
			String packageBase, String name) {
		super();
		this.checkFile = checkFile;
		this.plugin = plugin;
		this.packageBase = packageBase;
		this.name = name;
	}

	/**
	 * Load all of the OAW constraints.
	 */
	public void load(ModeldocFactory factory, ModelDocumentation root) throws DocumentationGenerationException {		
		InputStream in;
		try {
			in = new FileInputStream(checkFile);
		} catch (FileNotFoundException e) {
			throw new DocumentationGenerationException(e);
		}
		
		ChecksReference fr = factory.createChecksReference();
		fr.setPlugin(plugin);
		fr.setPackage(packageBase);
		fr.setName(name);
		fr.setParent(root);
		
		ExtensionFile file = ParseFacade.file(new InputStreamReader(in), checkFile);
		
		for (Check check : file.getChecks()) {
			
			// map the Identifier (the context) to an EMFClass
			EMFClass identifier = mapOAWIdentifier(root, check.getType());
			if (identifier == null)
				continue;	// unidentified type (e.g. emf::EObject)

			// make a new Constraint for this check
			Constraint constraint = factory.createConstraint();
			constraint.setConstraint(check.getConstraint().toString());
			constraint.setType( check.isErrorCheck() ? ConstraintType.ERROR : ConstraintType.WARNING );
			constraint.setMessage( check.getMsg().toString() );

			// make a new FileReference
			FileLineReference line = factory.createFileLineReference();
			line.setFile(fr);
			line.setLine(check.getLine());
			constraint.setReference(line);
			
			// add this constraint
			identifier.getConstraints().add(constraint);
		}
		
		// set number of constraints
		fr.setUniqueConstraints(file.getChecks().size());
		
	}
	
}
