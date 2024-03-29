package org.openiaml.model.migrate;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Migrate model version 0.2 to version 0.4
 *
 * In the future most of this functionality should be refactored into an abstract superclass.
 *
 * Changes in model version 0.3:
 * 
 * <ol>
 *   <li>Domain element changes: (requires migration)
 *   <ol>
 *     <li>DomainStore --> DomainStore[type=db]</li>
 *     <li>DomainObject --> DomainObject</li>
 *     <li>DomainAttribute --> DomainAttribute</li>
 *   </ol></li>
 *   <li>
 *   <ol>Removed elements: (requires migration)
 *     <li>FileDomainStore -> DomainStore[type=file]</li>
 *     <li>FileDomainObject -> DomainObject</li>
 *     <li>FileDomainAttribute -> DomainAttribute</li>
 *     <li>abstract AbstractDomainStore</li>
 *     <li>abstract AbstractDomainObject</li>
 *     <li>abstract AbstractDomainAttribute</li>
 *   </ol></li>
 * </ol>
 * 
 * Changes in model version 0.4:
 * 
 * <ol>
 *   <li>Root namespace changed to "http://openiaml.org/model0.4"</b>: {@link #createElement(Document, String)}</li>
 *   <li>Domain element changes: (requires migration)
 *   <ol>
 *     <li>ChainedOperation --> PrimitiveOperation</li>
 *     <li>SingleOperation --> PrimitiveOperation</li>
 *   </ol></li>
 *   <li>
 *   <ol>Removed attributes:
 *     <li>Scope.domainObjects</li>
 *     <li>Scope.domainViews</li>
 *     <li>Scope.domainInstances</li>
 *   </ol></li>
 * </ol>
 *
 * @see #isVersion(Document) for what defines this model
 * @see #recurseOverDocument(Element, Node, Document) for actual model changes
 * @author jmwright
 *
 */
public class Migrate2To4 extends DomBasedMigrator implements IamlModelMigrator {
	
	public String getName() {
		return "Migrator 0.2 to 0.4";
	}
	
	/**
	 * We can identify a version 0.2 model:
	 * 
	 *  <ol>
	 *   <li>The NS package is http://openiaml.org/model0.2</li>
	 *   <li>The root element has an attribute "id"</li>
	 *  </ol>
	 *
	 * 
	 * @see org.openiaml.model.diagram.custom.migrate.IamlModelMigrator#isVersion(org.eclipse.core.resources.IFile)
	 */
	@Override
	public boolean isVersion(Document doc) throws MigrationException {
		try {
			// get parameters
			String nsPackage = doc.getDocumentElement().getAttribute("xmlns:iaml");
			String nsPackage2 = doc.getDocumentElement().getNamespaceURI();
			if (nsPackage2 != null)
				nsPackage = nsPackage2;
			String rootId = doc.getDocumentElement().getAttribute("id");

			if (nsPackage.equals("http://openiaml.org/model0.2") && 
					!rootId.isEmpty()) {
				// this is us! (version 0.2) 
				return true;
			}
		} catch (Exception e) {
			throw new MigrationException(e);
		}
			
		return false;
	}

	@Override
	public boolean shouldDeleteAttribute(Element element, Element target,
			String name, String value, List<ExpectedMigrationException> errors) {

		// if the type is FileDomain*, return null, so the attribute
		// is not added
		if (name.equals("xsi:type") && (value.equals("iaml.domain:FileDomainStore") ||
				value.equals("iaml.domain:FileDomainObject") || 
				value.equals("iaml.domain:FileDomainAttribute"))) {
			// delete
			return true;
		}
		
		return super.shouldDeleteAttribute(element, target, name, value, errors);
	}

	/* (non-Javadoc)
	 * @see org.openiaml.model.diagram.custom.migrate.DomBasedMigrator#handleElement(org.w3c.dom.Element, org.w3c.dom.Element, java.util.List)
	 */
	@Override
	public void handleElement(Element old, Element element,
			Document document,
			List<ExpectedMigrationException> errors) {
		
		// <domainStores xsi:type="iaml:DomainStore"> 
		// --> <domainStores type="RELATIONAL_DB">
		if (old.getNodeName().equals("domainStores") && old.getAttribute("xsi:type").equals("iaml:DomainStore")) {
			element.removeAttribute("xsi:type");
			element.setAttribute("type", "RELATIONAL_DB");
		}

		// <domainStores xsi:type="iaml.domain:FileDomainStore"> 
		// --> <domainStores type="RELATIONAL_DB">
		if (old.getNodeName().equals("domainStores") && old.getAttribute("xsi:type").equals("iaml.domain:FileDomainStore")) {
			element.removeAttribute("xsi:type");
			element.setAttribute("type", "PROPERTIES_FILE");
		}
		
		// <children xsi:type="iaml.domain:FileDomainObject">
		// --> <children xsi:type="iaml:DomainObject">
		if (old.getNodeName().equals("children") && old.getAttribute("xsi:type").equals("iaml.domain:FileDomainObject")) {
			element.setAttribute("xsi:type", "iaml:DomainObject");
		}

		// <children xsi:type="iaml.domain:FileDomainAttribute">
		// --> <children xsi:type="iaml:DomainAttribute">
		if (old.getNodeName().equals("children") && old.getAttribute("xsi:type").equals("iaml.domain:FileDomainAttribute")) {
			element.setAttribute("xsi:type", "iaml:DomainAttribute");
		}

		// <attributes xsi:type="iaml.domain:FileDomainAttribute">
		// --> <attributes xsi:type="iaml:DomainAttribute">
		if (old.getNodeName().equals("attributes") && old.getAttribute("xsi:type").equals("iaml.domain:FileDomainAttribute")) {
			element.setAttribute("xsi:type", "iaml:DomainAttribute");
		}

	}

	/**
	 * Replace various element types.
	 */
	@Override
	public String replaceType(Element old, String xsiType,
			List<ExpectedMigrationException> errors) {
		
		// <operations xsi:type="iaml:ChainedOperation">
		// --> <operations xsi:type="iaml:PrimitiveOperation">
		if (old.getNodeName().equals("operations") && xsiType.equals("iaml:ChainedOperation")) {
			return "iaml:PrimitiveOperation";
		}

		// <operations xsi:type="iaml:SingleOperation">
		// --> <operations xsi:type="iaml:PrimitiveOperation">
		if (old.getNodeName().equals("operations") && xsiType.equals("iaml:SingleOperation")) {
			return "iaml:PrimitiveOperation";
		}
		
		return super.replaceType(old, xsiType, errors);

	}

	/**
	 * Models of version 0.4 have a different namespace.
	 */
	@Override
	protected String getTargetNamespace() {
		return "http://openiaml.org/model0.4";
	}

	
	
}