/**
 * 
 */
package org.openiaml.emf.properties.library;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.openiaml.emf.properties.IEMFElementSelector;
import org.openiaml.emf.properties.IterateOverAll;

/**
 * @author jmwright
 *
 */
public class ReferencesWithoutContainmentsCount extends IterateOverAll {
	
	/**
	 * @param name
	 */
	public ReferencesWithoutContainmentsCount(String name, IEMFElementSelector selector) {
		super(name, selector);
	}
	
	public ReferencesWithoutContainmentsCount(IEMFElementSelector selector) {
		this(ReferencesWithoutContainmentsCount.class.getSimpleName(), selector);
	}

	@Override
	public int get(EObject obj) {
		int result = 0;
		List<EReference> refs = obj.eClass().getEAllReferences();
		for (EReference ref : refs) {
			if (ignoreReference(ref))
				continue;	// ignore
			if (ref.isContainment())
				continue;	// ignore

			if (obj.eGet(ref) != null) {
				result++;
			}
		}
		return result;
	}
}