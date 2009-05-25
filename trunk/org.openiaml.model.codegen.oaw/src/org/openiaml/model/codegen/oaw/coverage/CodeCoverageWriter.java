/**
 * 
 */
package org.openiaml.model.codegen.oaw.coverage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Methods to write human-readable code-coverage information.
 * 
 * @author jmwright
 *
 */
public class CodeCoverageWriter {


	/**
	 * A helper class to keep track of output summaries.
	 * 
	 * @author jmwright
	 *
	 */
	protected class OutputSummary {
		private File template;
		private File destination;
		private long blocks = 0;
		private long coveredOaw = 0;
		private long coveredPhp = 0;
		private long coveredJs = 0;
		
		/**
		 * 
		 * @param template Input template file
		 * @param destination Destination output file
		 */
		public OutputSummary(File template, File destination) {
			this.template = template;
			this.destination = destination;
		}

		/**
		 * Add another potential execution block.
		 */
		public void addBlock() {
			blocks++;
		}

		/**
		 * Call when a block has been covered with OAW execution.
		 */
		public void coveredInOaw() {
			coveredOaw++;
		}

		/**
		 * Call when a block has been covered with PHP execution.
		 */
		public void coveredInPhp() {
			coveredPhp++;
		}

		/**
		 * Call when a block has been covered with Javascript execution.
		 */
		public void coveredInJs() {
			coveredJs++;
		}

		public File getTemplate() {
			return template;
		}

		public File getDestination() {
			return destination;
		}

		public long getBlocks() {
			return blocks;
		}

		public long getCoveredOaw() {
			return coveredOaw;
		}

		public long getCoveredPhp() {
			return coveredPhp;
		}
		
		public long getCoveredJs() {
			return coveredJs;
		}

	}

	/**
	 * The aim of this method is to take our template files and
	 * the results of the instrumentation, and generate a pretty format
	 * of the code coverage for HTML.
	 * 
	 * @param oawDump instrumented oaw results
	 * @param phpDump instrumented php results
	 * @param jsDump instrumented javascript results
	 * @param templatesDir
	 * @param outputDir
	 * @throws InstrumentationException 
	 * @throws IOException 
	 */
	public void outputCoveredCode(File oawDump, File phpDump, File jsDump, File templatesDir, File outputDir) throws InstrumentationException, IOException {
		// checks
		if (!templatesDir.exists() || !templatesDir.isDirectory()) {
			throw new InstrumentationException("Template directory '" + templatesDir + "' does not exist or is not a directory.");
		}
		if (!outputDir.exists()) {
			boolean created = outputDir.mkdirs();
			if (!created) {
				throw new InstrumentationException("Could not create directory '" + outputDir + "'");
			}
		}
		if (!oawDump.exists()) {
			throw new InstrumentationException("File '" + oawDump + "' does not exist");
		}
		if (!phpDump.exists()) {
			throw new InstrumentationException("File '" + phpDump + "' does not exist");
		}
		if (!jsDump.exists()) {
			throw new InstrumentationException("File '" + jsDump + "' does not exist");
		}
		
		// load the dumps
		Map<String, Map<String, Integer>> oaw = loadInstrumentation(oawDump);
		Map<String, Map<String, Integer>> php = loadInstrumentation(phpDump);
		Map<String, Map<String, Integer>> js = loadInstrumentation(jsDump);
		
		// get templates
		List<File> templates = CoverageUtils.getRecursiveDirectoryContents(templatesDir);
		List<OutputSummary> summaries = new ArrayList<OutputSummary>();
		for (File template : templates) {
			if (template.getAbsolutePath().endsWith(".xpt")) {
				String templateOut = outputDir.getAbsolutePath() + File.separator + getOutputName(template);
				OutputSummary summary = outputCoveredTemplate(oaw, php, js, template, new File(templateOut));
				summaries.add(summary);
			}
		}
		
		// write a summary
		String templateOut = outputDir.getAbsolutePath() + File.separator + "index.html";
		outputSummary(summaries, templateOut); 
	}

	/**
	 * Get the HTML filename result for the given xpt template file.
	 * 
	 * @param template
	 * @return
	 */
	protected String getOutputName(File template) {
		// get root
		File root = new File("");
		String out = template.getAbsolutePath().replace(root.getAbsolutePath() + File.separator, "");
		return out.replaceAll("[^A-Za-z0-9_\\-]", "-").replaceAll("--+", "-") + ".html";		
	}

	/**
	 * Output a summary of all templates to the given file.
	 * 
	 * @param summaries
	 * @param templateOut File to write to
	 * @throws IOException 
	 */
	private void outputSummary(List<OutputSummary> summaries, String templateOut) throws IOException {
		String html = "";
		double barWidth = 200;

		for (OutputSummary summary : summaries) {
			html += "<tr><th><a href=\"" + escapeHtmlQuotes(summary.getDestination().getName()) + "\">" + escapeHtml(formatTemplateName(summary.getTemplate())) + "</a></th>\n";
			{
				double ratio = summary.getCoveredOaw() / (1.0 * summary.getBlocks());
				double ratio2 = summary.getCoveredPhp() / (1.0 * summary.getBlocks());
				double ratio3 = summary.getCoveredJs() / (1.0 * summary.getBlocks());
				html += "<td>" + formatNumber(summary.getCoveredOaw()) + " / " + formatNumber(summary.getBlocks()) + " (" + formatNumber(ratio * 100) + "%) </td>\n";
				html += "<td>" + formatNumber(summary.getCoveredPhp()) + " / " + formatNumber(summary.getBlocks()) + " (" + formatNumber(ratio2 * 100) + "%) </td>\n";
				html += "<td>" + formatNumber(summary.getCoveredJs()) + " / " + formatNumber(summary.getBlocks()) + " (" + formatNumber(ratio3 * 100) + "%) </td>\n";
				html += "<td style=\"border:1px solid #ccc;margin:0;padding:0;background:#f33;\">";
				html += "<div style=\"width:" + Math.floor((barWidth * ratio2)) + "px;background:#3f3;height:1.3em;display:inline-block;\"></div>";
				html += "<div style=\"width:" + Math.floor((barWidth * (ratio - ratio2))) + "px;background:#ff3;height:1.3em;display:inline-block;\"></div>";
				html += "<div style=\"width:" + Math.floor((barWidth * (1.0-ratio))) + "px;background:#f33;height:1.3em;display:inline-block;\"></div>";
				html += "</td>\n";
			}
			html += "</tr>\n";
		}
		
		html = "<html><style>body,html,th,td{font-family:Arial;}</style><body><h1>Summary</h1>\n\n<table><tr><th>Template</th><th>OAW</th><th>PHP</th><th>JS</th><th width=\"" + barWidth + "\">%</th></tr>\n" + html + "</table></html>";
		
		System.out.println("Writing summary '" + templateOut + "'...");
		CoverageUtils.writeFile(new File(templateOut), html);
	}

	/**
	 * @param d
	 * @return
	 */
	private String formatNumber(double d) {
		return formatNumber(new Double(d).longValue());
	}

	/**
	 * @param n
	 * @return
	 */
	private String formatNumber(long n) {
		return new Long(n).toString();
	}
	
	/**
	 * Get an easy-to-read filename of the given file. 
	 * Removes the root directory from the file.
	 * 
	 * @param f
	 * @return
	 */
	private String formatTemplateName(File f) {
		File root = new File("");
		String out = f.getAbsolutePath().replace(root.getAbsolutePath() + File.separator, "");
		return out;
	}

	/**
	 * @param oaw oaw instrumentation results
	 * @param php php instrumentation results
	 * @param js js instrumentation results
	 * @param template the xpt template file itself
	 * @param file file to output results to
	 * @param templates list of templates that we are loading (used to generate hyperlinks)
	 * @return an output summary of the instrumented template
	 * @throws IOException 
	 */
	protected OutputSummary outputCoveredTemplate(Map<String, Map<String, Integer>> oaw,
			Map<String, Map<String, Integer>> php, 
			Map<String, Map<String, Integer>> js, 
			File template,
			File file) throws IOException {
		
		String html = CoverageUtils.readFile(template);
		OutputSummary os = new OutputSummary(template, file);
		
		// escape html
		html = escapeHtml(html);
		
		// elements to worry about: DEFINE|FILE|IF|ELSE|ELSEIF|FOREACH
		html = replaceBinaryTag("DEFINE", "ENDDEFINE", html, template.getAbsolutePath(), oaw, php, js, os);
		html = replaceBinaryTag("FILE", "ENDFILE", html, template.getAbsolutePath(), oaw, php, js, os);
		html = replaceBinaryTag("FOREACH", "ENDFOREACH", html, template.getAbsolutePath(), oaw, php, js, os);
		
		// hopefully this clever little hack works
		html = replaceBinaryTag("IF", "ENDIF", html, template.getAbsolutePath(), oaw, php, js, os);
		html = replaceBinaryTagReverse("ELSE", "ELSE", html, template.getAbsolutePath(), oaw, php, js, os);
		html = replaceBinaryTagReverse("ELSEIF", "ELSEIF", html, template.getAbsolutePath(), oaw, php, js, os);
		
		// create <a> links to template files
		html = replaceLinks(template, html, template.getAbsolutePath());
		
		// TODO load this from actual file
		html = "<html><style>body,html,th,td{font-family:Arial;}.none{background:#fcc;}.oaw{background:#ffc;}.php{color:green;}.js{font-style:italic;}pre{background:#eee;border:1px solid #666;}</style><body><h1>" + template + "</h1>\n\n<a href=\"index.html\">Summary</a><ul><li class=\"none\">no execution</li><li class=\"oaw\">OAW execution</li><li class=\"php\">PHP execution</li><li class=\"js\">Javascript execution</li></ul>\n\n<p><pre>" + html + "</pre></p></html>";
		
		System.out.println("Writing file '" + file + "'...");
		CoverageUtils.writeFile(file, html);
		
		return os;
		
	}

	/**
	 * Replace all EXPAND foo::bar statements with a hyperlink
	 * to the actual template.
	 * 
	 * @param html
	 * @param absolutePath
	 * @param templates
	 * @return
	 */
	protected String replaceLinks(File thisTemplate, String html, String absolutePath) {

		// create <a> links from <expand> to <define>s
		String[] bits = html.split("�EXPAND");
		html = bits[0];
		
		for (int i = 1; i < bits.length; i++) {
			String key = bits[i].substring(0, bits[i].indexOf('�'));
			String remainder = bits[i].substring(bits[i].indexOf('�') + 1);
			
			String[] keyBits = key.split("FOR", 2);
			String href = "foo";
			// remove brackets
			if (keyBits[0].contains("(")) {
				keyBits[0] = keyBits[0].substring(0, keyBits[0].indexOf("("));
			}
			if (keyBits.length == 2 && keyBits[0].contains("::")) {
				// its in a different file
				String lastKey = keyBits[0].substring(keyBits[0].lastIndexOf("::") + 2);
				href = getOutputName(findTemplateFile(thisTemplate, keyBits[0])) + '#' + generateExpandHref(lastKey);
			} else {
				// its in this file
				href = '#' + generateExpandHref(key);
			}
			
			// append
			html += "<a href=\"" + escapeHtmlQuotes(href) + "\">�EXPAND" + key + "�</a>" + remainder;
		}
		
		// now, take all <define>s and add <a name>s so they can be linked
		html = createDefineLinks(html);
		
		return html;
		
	}

	
	/**
	 * @param html
	 * @return
	 */
	private String createDefineLinks(String html) {

		// create <a> links from <expand> to <define>s
		String[] bits = html.split("�DEFINE");
		html = bits[0];
		
		for (int i = 1; i < bits.length; i++) {
			String key = bits[i].substring(0, bits[i].indexOf('�'));
			String remainder = bits[i].substring(bits[i].indexOf('�') + 1);
			
			String href = generateExpandHref(key);
			
			// append
			html += "<a name=\"" + escapeHtmlQuotes(href) + "\">�DEFINE" + key + "�</a>" + remainder;
		}
		
		return html;
	}

	/**
	 * Find the template file for the given string.
	 * 
	 * @param string ' js::Operations::expandEventTriggers'
	 * @return
	 */
	private File findTemplateFile(File thisTemplate, String string) {		
		String[] bits = string.trim().split("::");
		File start = thisTemplate;
		
		// go back to find the common root
		for (int i = 0; i < bits.length - 1; i++) {
			start = start.getParentFile();
		}
		
		// jevon hack: if the file does not contain /template, add it
		if (!bits[0].equals("template") && !start.getAbsolutePath().contains(File.separator + "template")) {
			start = new File(start.getAbsolutePath() + File.separator + "template");
		}
		
		// now add additional bits (folders and filename)
		for (int i = 0; i < bits.length - 1; i++) {
			start = new File(start.getAbsolutePath() + File.separator + bits[i]);
		}
		
		// add file extension
		start = new File(start.getAbsolutePath() + ".xpt");
		
		// this should be the result file
		return start;
	}

	/**
	 * Generate a key into a href target.
	 * @param key
	 * @return
	 */
	protected String generateExpandHref(String key) {
		// remove brackets; we can't do type inference
		if (key.contains("(")) {
			key = key.substring(0, key.indexOf("("));
		}
		// remove FOR: we can't do type inference
		if (key.contains("FOR")) {
			key = key.substring(0, key.indexOf("FOR"));
		}
		
		return getOutputName(new File(key.trim()));
	}

	/**
	 * Escape the given string to HTML
	 * 
	 * @param html
	 * @return
	 */
	protected String escapeHtml(String html) {
		return html.replace("&", "&amp;").replace(">", "&gt;").replace("<", "&lt;");
	}

	/**
	 * Escape the given string to HTML, but also quotes.
	 * 
	 * @param html
	 * @return
	 */
	protected String escapeHtmlQuotes(String html) {
		return escapeHtml(html).replace("\"", "&quot;");
	}
	
	/**
	 * @param html
	 * @param oaw
	 * @param php
	 * @param os output summary to append to
	 * @return
	 */
	private String replaceBinaryTag(String tag,
			String endtag,
			String html,
			String templateFile,
			Map<String, Map<String, Integer>> oaw,
			Map<String, Map<String, Integer>> php, 
			Map<String, Map<String, Integer>> js, 
			OutputSummary os) {

		// find all DEFINEs
		int lineCount = 0;
		String[] bits = html.split("�" + tag);
		html = bits[0];
		lineCount = countOccurrences(bits[0], '\n') + 1;		// generated instrumentation code is out by 1
		
		if (templateFile.toLowerCase().contains("operations.xpt") && tag.equals("DEFINE")) {
			System.out.println("breakpoint");
		}
		
		for (int i = 1; i < bits.length; i++) {
			String key = tag + bits[i].substring(0, bits[i].indexOf('�'));
			key = lineCount + ":" + key;
			
			// add to output summary
			os.addBlock();
			
			// add a <span> with a "title"
			String classes = "";
			String title = "";
			if (oaw.containsKey(templateFile) && oaw.get(templateFile).containsKey(key)) {
				// it's been executed in OAW
				classes += "oaw ";
				title += oaw.get(templateFile).get(key) + " steps in OAW ";
				os.coveredInOaw();
			}
			if (php.containsKey(templateFile) && php.get(templateFile).containsKey(key)) {
				// it's been executed in OAW
				classes += "php ";
				title += php.get(templateFile).get(key) + " steps in PHP ";
				os.coveredInPhp();
			}
			if (js.containsKey(templateFile) && js.get(templateFile).containsKey(key)) {
				// it's been executed in OAW
				classes += "js ";
				title += js.get(templateFile).get(key) + " steps in JS ";
				os.coveredInJs();
			}
			if (classes.isEmpty()) {
				classes = "none";
			}
			title += "(" + templateFile + ": " + key + ")";
			html += "<span class=\"" + classes + "\" title=\"" + title + "\">";
			
			// append
			html += "�" + tag + bits[i];
			lineCount += countOccurrences(bits[i], '\n');
		}
		
		// append all ENDDEFINE with </span>
		html = html.replaceAll("�(" + endtag + "[^'�]*?)�", "�$1�</span>");
		
		return html;
		
	}
	
	/**
	 * Count the occurrences of a given character in the given
	 * string.
	 * 
	 * @see CoverageUtils#countOccurrences(String, char)
	 * @param string 
	 * @param c
	 * @return
	 */
	private int countOccurrences(String string, char c) {
		return CoverageUtils.countOccurrences(string, c);
	}

	/**
	 * @param html
	 * @param oaw
	 * @param php
	 * @param os output summary to append to
	 * @return
	 */
	private String replaceBinaryTagReverse(String tag,
			String endtag,
			String html,
			String templateFile,
			Map<String, Map<String, Integer>> oaw,
			Map<String, Map<String, Integer>> php, 
			Map<String, Map<String, Integer>> js, 
			OutputSummary os) {

		// append all ENDDEFINE with </span>
		// do this replacement first
		// the </span> is also in reverse order
		html = html.replaceAll("�(" + endtag + "[^'�]*?)�", "</span>�$1�");

		// find all DEFINEs
		int lineCount = 0;
		String[] bits = html.split("�" + tag);
		html = bits[0];
		lineCount = countOccurrences(bits[0], '\n') + 1;		// generated instrumentation code is out by 1
		
		if (templateFile.toLowerCase().contains("operations.xpt") && tag.equals("DEFINE")) {
			System.out.println("breakpoint");
		}
		
		for (int i = 1; i < bits.length; i++) {
			String key = tag + bits[i].substring(0, bits[i].indexOf('�'));
			key = lineCount + ":" + key;
			
			// add to output summary
			os.addBlock();
			
			// add a <span> with a "title"
			String classes = "";
			String title = "";
			if (oaw.containsKey(templateFile) && oaw.get(templateFile).containsKey(key)) {
				// it's been executed in OAW
				classes += "oaw ";
				title += oaw.get(templateFile).get(key) + " steps in OAW ";
				os.coveredInOaw();
			}
			if (php.containsKey(templateFile) && php.get(templateFile).containsKey(key)) {
				// it's been executed in OAW
				classes += "php ";
				title += php.get(templateFile).get(key) + " steps in PHP ";
				os.coveredInPhp();
			}
			if (js.containsKey(templateFile) && js.get(templateFile).containsKey(key)) {
				// it's been executed in OAW
				classes += "js ";
				title += js.get(templateFile).get(key) + " steps in JS ";
				os.coveredInJs();
			}
			if (classes.isEmpty()) {
				classes = "none";
			}
			title += "(" + templateFile + ": " + key + ")";
			html += "<span class=\"" + classes + "\" title=\"" + title + "\">";
			
			// append
			html += "�" + tag + bits[i];
			lineCount += countOccurrences(bits[i], '\n');
		}
		
		return html;
		
	}
	
	/**
	 * @param oawDump
	 * @return
	 * @throws InstrumentationException 
	 * @throws IOException 
	 */
	protected Map<String, Map<String, Integer>> loadInstrumentation(File file) throws InstrumentationException, IOException {
		String input = CoverageUtils.readFile(file);
		String[] lines = input.split("\n");
		
		Map<String, Map<String, Integer>> result = new 
			HashMap<String, Map<String, Integer>>();
		Map<String, Integer> current = new HashMap<String, Integer>();
		String currentFilename = "";
		
		for (String line : lines) {
			if (!line.isEmpty()) {
				if (line.charAt(0) == '\t') {
					// add to current
					int pos = line.lastIndexOf(":");
					String part1 = line.substring(0, pos).trim();
					String part2 = line.substring(pos + 1).trim();
					current.put(part1, Integer.valueOf(part2.trim()));
				} else {
					// a filename; insert the current buffer into the result
					result.put(currentFilename, current);
					
					// remove the ':' at the end of the filename
					currentFilename = line.substring(0, line.length() - 1);
					current = new HashMap<String, Integer>();
				}
			}
		}
		
		// put in the last result
		result.put(currentFilename, current);
		
		return result;
	}
	
}
