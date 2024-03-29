/**
 * 
 */
package org.openiaml.model.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Map;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathExpressionException;

import junit.framework.TestCase;

import org.openiaml.model.tests.xpath.DefaultXpathTestCase;
import org.openiaml.model.xpath.IXpath;
import org.openiaml.model.xpath.IterableElementList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * Helper methods for test cases that use XML-based and properties-based
 * tests.
 * 
 * @author jmwright
 *
 */
public class XmlTestCase extends TestCase implements IXpath {
	
	/**
	 * Resolve an EMF query like '//@figures.0/@descriptors.29/@accessors.0'
	 * to an Element. Fail if the element cannot be found.
	 * 
	 * @param doc
	 * @param query
	 * @return
	 * @throws XPathExpressionException 
	 */
	public Element resolveEmfElement(Document doc, String query) throws XPathExpressionException {
		// we cheat by splitting up the /, replacing the numbers with
		// indexes, and resolving it through xpath
		assertTrue("'" + query + "' must start with '//'", query.startsWith("//"));
		String q2 = query.substring(2);
		
		String out = "/";
		String[] bits = q2.split("/");
		for (String bit : bits) {
			if (bit.contains(".")) {
				// @figures.0
				String index = bit.substring(bit.indexOf(".") + 1);
				out += "/"			// to create the tree 
					+ bit.substring(1, bit.indexOf("."))	// chop off '@' 
					+ "[" 
					+ (new Integer(index).intValue() + 1)
					+ "]";
			} else {
				// @figures
				out += "/"			// to create the tree
					+ bit.substring(1);		// chop off '@'
			}
		}
		
		try {
			return xpathFirst(doc, out);
		} catch (XPathExpressionException e) {
			throw new RuntimeException("XPath query '" + out + "' was not valid: " + e.getMessage(), e);
		}
	}
	
	/**
	 * The reverse of {@link #resolveEmfElement(Document, String)}; 
	 * obtain the 'filename.gmftool#//@figures.0/@descriptors.29/@accessors.0' of a given element.
	 * 
	 * @param filename 'filename.gmftool'
	 * @param root
	 * @return
	 * @throws XPathExpressionException 
	 */
	public String compileEmfReference(String filename, Node root) throws XPathExpressionException {
		if (root.getParentNode() == null) {
			return "/";	// unexpected
		}
		
		// get the '@name.index' for the current node
		int index = 0;
		for (Node node : xpath(root.getParentNode(), root.getNodeName())) {
			if (node.equals(root)) {
				// found it
				break;
			}
			index++;
		}
		
		if (root.getParentNode().equals(root.getOwnerDocument())) {
			// found the root
			// return filename + "#//@" + root.getNodeName();	// assumed to not have any index
			return filename + "#/";		// we ignore the root element
		} else {
			// haven't found the root yet; recurse down
			return compileEmfReference(filename, root.getParentNode()) + "/@" + root.getNodeName() + "." + index;
		}
	}
	
	public Document firstDocument(Map<?,Document> map) {
		return map.values().iterator().next();
	}
	
	/**
	 * Load a properties file.
	 */
	public static Properties loadProperties(String file) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileInputStream(file));
		return p;
	}
	
	/**
	 * Load an XML document.
	 */
	public static Document loadDocument(String filename) throws FileNotFoundException, ParserConfigurationException, SAXException, IOException {
		return loadDocument( new FileInputStream(filename) );
	}

	/**
	 * Load an XML document from a file.
	 */
	public static Document loadDocument(File f) throws FileNotFoundException, ParserConfigurationException, SAXException, IOException {
		return loadDocument( new FileInputStream(f) );
	}
	
	/**
	 * Load an XML document from an input source.
	 */
	public static Document loadDocument(InputStream source) throws ParserConfigurationException, SAXException, IOException {
		// load the model version
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(source);
		
		// done
		source.close();
		
		return doc;
	}

	/**
	 * Try saving an XML document.
	 */
	public static void saveDocument(Document doc, File target) throws IOException, TransformerException {
        TransformerFactory transfac = TransformerFactory.newInstance();
        Transformer trans = transfac.newTransformer();
        trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");	// omit '<?xml version="1.0"?>'
        trans.setOutputProperty(OutputKeys.INDENT, "yes");

        // TODO clean this up into a piped input/output stream setup?
		FileWriter sw = new FileWriter(target);
        StreamResult result = new StreamResult(sw);
        DOMSource source = new DOMSource(doc);
        trans.transform(source, result);
        sw.close();
	}
	
	/**
	 * Assert that the given file exists.
	 * 
	 * @param source
	 */
	public void assertFileExists(File source) {
		assertFileExists("", source);
	}
	
	/**
	 * Assert that the given file exists.
	 * 
	 * @param source
	 */
	public void assertFileExists(String prefix, File source) {
		assertTrue(prefix + "File '" + source.getAbsolutePath() + "' doesn't exist.", source.exists());
	}
	
	/**
	 * Copy a file from the source to the target. 
	 * Ideal for files containing bytes.
	 * 
	 * @see #readFile(File) for reading character files
	 * @param source source file
	 * @param target target file
	 * @throws IOException if the target file exists, or another IO exception occurs
	 */
	public static void copyFile(File source, File target) throws IOException {
		if (target.exists())
			throw new IOException("File '" + target + "' already exists.");
		
		FileInputStream fr = new FileInputStream(source);
		FileOutputStream fw = new FileOutputStream(target);
		
		int bufSize = 1024;
		byte[] buf = new byte[bufSize];
		
		while (true) {
			int read = fr.read(buf);
			if (read == -1)
				break;
			
			fw.write(buf, 0, read);
		}
		
		fr.close();
		fw.close();
	
	}
	
	/**
	 * Read in a file into a string. This should not be used
	 * if the file contains character data; use
	 * {@link #copyFile(File, File)} instead.
	 * 
	 * @see #copyFile(File, File) for copying bytes of data
	 * @throws IOException if an IO exception occurs
	 */
	public static String readFile(File sourceFile) throws IOException {
		if (!sourceFile.exists()) {
			throw new IOException("File " + sourceFile.getAbsolutePath() + " does not exist.");
		}
		
		int bufSize = 128;
		StringBuffer sb = new StringBuffer(bufSize);
		BufferedReader reader = new BufferedReader(new FileReader(sourceFile), bufSize);
				
		char[] chars = new char[bufSize];
		int numRead = 0;
		while ((numRead = reader.read(chars)) > -1) {
			sb.append(String.valueOf(chars).substring(0, numRead));	
		}
		
		reader.close();
		return sb.toString();
	}
	
	/**
	 * Use {@link XmlTestCase#readFile(File)} instead.
	 * 
	 * @deprecated
	 * @see #readFile(File)
	 */
	public static String loadFile(File sourceFile) throws IOException {
		return readFile(sourceFile);
	}
	
	/**
	 * Write a string to a file. If the file exists, it will be
	 * overwritten. 
	 * 
	 * @throws IOException if an IO exception occurs
	 */
	public static void writeFile(File file, String data) throws IOException {
		Writer output = new BufferedWriter(new FileWriter(file));
		output.write(data);
		output.close();
	}

	/**
	 * Helper method: assert A >= B.
	 * 
	 * @param expected expected value (B)
	 * @param actual actual value (A)
	 */
	protected void assertGreaterEq(int expected, int actual) {
		assertTrue("expected >= than " + expected + ", but actually had " + actual, actual >= expected);
	}
	
	/**
	 * Assert that the two elements are not the same.
	 * 
	 * @param string
	 */
	public void assertNotEqual(String message, Object a, Object b) {
		if (a == null) {
			assertNotNull(message + ", expected not equal: '" + a + "' and: '" + b + "'", b);
		} else {
			assertFalse(message + ", expected not equal: '" + a + "' and: '" + b + "'", a.equals(b));
		}
	}
	
	/**
	 * Assert that the two elements are not the same.
	 * 
	 * @param string
	 */
	public void assertNotEqual(Object a, Object b) {
		if (a == null) {
			assertNotNull("Expected not equal: '" + a + "' and: '" + b + "'", b);
		} else {
			assertFalse("Expected not equal: '" + a + "' and: '" + b + "'", a.equals(b));
		}
	}

	/**
	 * XPath helper methods.
	 * @see org.openiaml.model.tests.xpath.IXpath
	 */
	private static IXpath xpath = new DefaultXpathTestCase();

	/* (non-Javadoc)
	 * @see org.openiaml.model.tests.xpath.XpathTestCase#hasXpathFirst(org.w3c.dom.Element, java.lang.String)
	 */
	@Override
	public Element hasXpathFirst(Element e, String query)
			throws XPathExpressionException {
		return xpath.hasXpathFirst(e, query);
	}


	/* (non-Javadoc)
	 * @see org.openiaml.model.tests.xpath.XpathTestCase#hasXpathFirst(org.w3c.dom.Document, java.lang.String)
	 */
	@Override
	public Element hasXpathFirst(Document e, String query)
			throws XPathExpressionException {
		return xpath.hasXpathFirst(e, query);
	}


	/* (non-Javadoc)
	 * @see org.openiaml.model.tests.xpath.XpathTestCase#xpath(org.w3c.dom.Node, java.lang.String)
	 */
	@Override
	public IterableElementList xpath(Node doc, String query)
			throws XPathExpressionException {
		return xpath.xpath(doc, query);
	}


	/* (non-Javadoc)
	 * @see org.openiaml.model.tests.xpath.XpathTestCase#xpathFirst(org.w3c.dom.Document, java.lang.String)
	 */
	@Override
	public Element xpathFirst(Document doc, String query)
			throws XPathExpressionException {
		return xpath.xpathFirst(doc, query);
	}

	/* (non-Javadoc)
	 * @see org.openiaml.model.tests.xpath.XpathTestCase#xpathFirst(org.w3c.dom.Element, java.lang.String)
	 */
	@Override
	public Element xpathFirst(Element e, String query)
			throws XPathExpressionException {
		return xpath.xpathFirst(e, query);
	}

	/**
	 * Assert that the given string ends with the given suffix.
	 * 
	 */
	public void assertEndsWith(String message, String suffix, String string) {
		assertTrue(message + "String '" + string + "' should end with prefix '" + suffix + "'", string.endsWith(suffix));
	}
	
	/**
	 * Saves the given XML document to the given filename.
	 * 
	 * @param doc
	 * @param filename
	 * @throws IOException
	 * @throws TransformerException
	 */
	public static void saveDocument(Document doc, String filename) throws IOException, TransformerException {
		saveDocument(doc, new File(filename));
	}
	
}
