/**
 * 
 */
package org.openiaml.model.tests.inference;

import java.util.List;

import org.jaxen.JaxenException;
import org.openiaml.model.model.ApplicationElementProperty;
import org.openiaml.model.model.InternetApplication;
import org.openiaml.model.model.NamedElement;
import org.openiaml.model.model.domain.FileDomainAttribute;
import org.openiaml.model.model.domain.FileDomainObject;
import org.openiaml.model.model.domain.FileDomainStore;
import org.openiaml.model.model.visual.InputForm;
import org.openiaml.model.model.visual.InputTextField;
import org.openiaml.model.model.visual.Page;
import org.openiaml.model.model.wires.ParameterWire;
import org.openiaml.model.model.wires.RunInstanceWire;
import org.openiaml.model.model.wires.SyncWire;
import org.openiaml.model.tests.InferenceTestCase;

/**
 * Tests inference of sync wires between a .properties
 * FileDomainStore and an InputForm.
 * 
 * @model SyncWireProperties.iaml
 * @author jmwright
 *
 */
public class SyncWireProperties extends InferenceTestCase {

	protected InternetApplication root;
	
	protected void setUp() throws Exception {
		root = loadAndInfer(ROOT + "inference/SyncWiresProperties.iaml");
	}
	
	public void testInference() throws JaxenException {
		Page page = (Page) queryOne(root, "//iaml:children[iaml:name='container']");		
		InputForm form = (InputForm) queryOne(page, "iaml:children[iaml:name='target form']");
		FileDomainStore store = (FileDomainStore) queryOne(root, "//iaml:domainStores[iaml:name='properties file']");
		FileDomainObject properties = (FileDomainObject) queryOne(store, "iaml.domain:children[iaml:name='properties']");
		
		// there should be exactly three fields here (generated)
		List<?> nodes = query(form, "iaml:children");
		assertEquals(3, nodes.size());
		InputTextField f1 = (InputTextField) getNodeWithName(nodes, "fruit");
		InputTextField f2 = (InputTextField) getNodeWithName(nodes, "animal");
		InputTextField f3 = (InputTextField) getNodeWithName(nodes, "country");
		assertEquals(f1.getName(), "fruit");
		assertTrue(f1.isIsGenerated());
		assertEquals(f2.getName(), "animal");
		assertTrue(f2.isIsGenerated());
		assertEquals(f3.getName(), "country");
		assertTrue(f3.isIsGenerated());
		
		// find the sync wire
		SyncWire wire = (SyncWire) queryOne(page, "//iaml:wires[iaml:name='sync properties']");
		assertNotNull(wire);
		assertEquals(wire.getFrom(), form);
		assertEquals(wire.getTo(), properties);

		// there should be exactly 3 attributes
		List<?> nodes2 = query(properties, "iaml.domain:attributes");
		assertEquals(3, nodes2.size());
		FileDomainAttribute a1 = (FileDomainAttribute) getNodeWithName(nodes2, "fruit");		
		FileDomainAttribute a2 = (FileDomainAttribute) getNodeWithName(nodes2, "animal");		
		FileDomainAttribute a3 = (FileDomainAttribute) getNodeWithName(nodes2, "country");
		assertEquals(a1.getName(), "fruit");
		assertEquals(a2.getName(), "animal");
		assertEquals(a3.getName(), "country");
		
		// there should be sync wires between each of these elements
		SyncWire sw1 = (SyncWire) getWireFromTo(form, f1, a1);
		SyncWire sw2 = (SyncWire) getWireFromTo(form, f2, a2);
		SyncWire sw3 = (SyncWire) getWireFromTo(form, f3, a3);
		
		assertTrue(sw1.isIsGenerated());
		assertTrue(sw2.isIsGenerated());
		assertTrue(sw3.isIsGenerated());
		
		// there should be RunInstanceWires on each of these attributes
		// (following from SyncFormDomainObject)
		
		// fields should have fieldValues
		ApplicationElementProperty value1 = (ApplicationElementProperty) queryOne(f1, "iaml:properties[iaml:name='fieldValue']");
		ApplicationElementProperty value2 = (ApplicationElementProperty) queryOne(f2, "iaml:properties[iaml:name='fieldValue']");
		ApplicationElementProperty value3 = (ApplicationElementProperty) queryOne(f3, "iaml:properties[iaml:name='fieldValue']");
		ApplicationElementProperty valuea1 = (ApplicationElementProperty) queryOne(a1, "iaml:properties[iaml:name='fieldValue']");
		ApplicationElementProperty valuea2 = (ApplicationElementProperty) queryOne(a2, "iaml:properties[iaml:name='fieldValue']");
		ApplicationElementProperty valuea3 = (ApplicationElementProperty) queryOne(a3, "iaml:properties[iaml:name='fieldValue']");
		
		// these field values should be parameters to run instance wires
		ParameterWire pw1 = (ParameterWire) getWireFrom(root, value1);
		assertTrue(pw1.toString(), pw1.getTo() instanceof RunInstanceWire);
		ParameterWire pw2 = (ParameterWire) getWireFrom(root, value2);
		assertTrue(pw2.toString(), pw2.getTo() instanceof RunInstanceWire);
		ParameterWire pw3 = (ParameterWire) getWireFrom(root, value3);
		assertTrue(pw3.toString(), pw3.getTo() instanceof RunInstanceWire);
		ParameterWire pwa1 = (ParameterWire) getWireFrom(root, valuea1);
		assertTrue(pwa1.toString(), pwa1.getTo() instanceof RunInstanceWire);
		ParameterWire pwa2 = (ParameterWire) getWireFrom(root, valuea2);
		assertTrue(pwa2.toString(), pwa2.getTo() instanceof RunInstanceWire);
		ParameterWire pwa3 = (ParameterWire) getWireFrom(root, valuea3);
		assertTrue(pwa3.toString(), pwa3.getTo() instanceof RunInstanceWire);
		
	}
	
	protected NamedElement getNodeWithName(List<?> nodes, String name) {
		for (Object n : nodes) {
			if (n instanceof NamedElement && name.equals(((NamedElement) n).getName()))
				return (NamedElement) n;
		}
		fail("No node found with name '" + name + "'");
		return null;
	}
	
}
