/**
 * 
 */
package org.openiaml.docs.generation;

import org.eclipse.emf.ecore.EPackage;
import org.openiaml.docs.modeldoc.Metric;
import org.openiaml.docs.modeldoc.ModelDocumentation;
import org.openiaml.docs.modeldoc.ModeldocFactory;
import org.openiaml.emf.properties.IPropertyInvestigator;
import org.openiaml.emf.properties.IEMFElementSelector.DefaultElementSelector;
import org.openiaml.emf.properties.library.metamodel.AllMetamodelPropertiesLibrary;

/**
 * Calculates metamodel metrics for a particular {@link EPackage}.
 * 
 * @author jmwright
 *
 */
public class LoadMetamodelMetrics extends DocumentationHelper implements ILoader {

	private EPackage rootPackage;
	private String prefix;
	
	/**
	 * Uses an empty prefix, for example the default metamodel.
	 */
	public LoadMetamodelMetrics(EPackage root) {
		this(root, "");
	}

	public LoadMetamodelMetrics(EPackage root, String prefix) {
		super();
		
		this.rootPackage = root;
		this.prefix = prefix;
	}

	/**
	 * Load all of the runtime icons as GraphicalRepresentations.
	 * 
	 * @param factory
	 * @param root
	 */
	public void load(ModeldocFactory factory, ModelDocumentation root) {
		
		// get all the metrics in the library
		for (IPropertyInvestigator m : AllMetamodelPropertiesLibrary.getAllMetamodelProperties(new DefaultElementSelector())) {
			Object result = m.evaluate(rootPackage);
			
			// insert a new metric
			Metric metric = factory.createMetric();
			metric.setName(prefix + m.getName());
			metric.setValue(result.toString());
			root.getMetrics().add(metric);
			
		}
		
	}
	
}
