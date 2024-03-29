package org.openiaml.model.diagram.custom.actions;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.openiaml.model.diagram.visual.edit.parts.InputFormEditPart;
import org.openiaml.model.drools.DroolsInferenceEngine;
import org.openiaml.model.drools.ICreateElementsFactory;
import org.openiaml.model.model.visual.InputForm;

/**
 * Refresh {@link InputForm} mappings with Drools.
 *
 * @author jmwright
 *
 */
public class RefreshFormMappingsWithDrools extends UpdateWithDroolsAction {

	public class RefreshFormMappings extends DroolsInferenceEngine {

		public RefreshFormMappings(ICreateElementsFactory handler) {
			super(handler, false);
		}

		private List<String> ruleFiles = Arrays.asList(
				"/rules/sync-wires.drl",
				"/rules/set-wires.drl",
				"/rules/detail-wires.drl",
				"/rules/new-instance.drl"
				);

		/**
		 * Get the list of rule files used.
		 *
		 * @see #addRuleFile(String)
		 * @return
		 */
		@Override
		public List<String> getRuleFiles() {
			return ruleFiles;
		}

	}

	/* (non-Javadoc)
	 * @see org.openiaml.model.diagram.custom.actions.UpdateWithDroolsAction#getEditPartClass()
	 */
	@Override
	public Class<? extends ShapeNodeEditPart> getEditPartClass() {
		return InputFormEditPart.class;
	}

	/* (non-Javadoc)
	 * @see org.openiaml.model.diagram.custom.actions.UpdateWithDroolsAction#getExpectedEObjectClass()
	 */
	@Override
	public Class<? extends EObject> getExpectedEObjectClass() {
		return InputForm.class;
	}

	/* (non-Javadoc)
	 * @see org.openiaml.model.diagram.custom.actions.UpdateWithDroolsAction#getEngine(org.openiaml.model.inference.ICreateElements)
	 */
	@Override
	public DroolsInferenceEngine getEngine(ICreateElementsFactory handler) {
		return new RefreshFormMappings(handler);
	}

	/**
	 * We want to use the root element, not the selected element.
	 */
	@Override
	public EObject selectRootElement(EObject element) {
		return getRoot(element);
	}

	/* (non-Javadoc)
	 * @see org.openiaml.model.diagram.custom.actions.UpdateWithDroolsAction#getTitle()
	 */
	@Override
	public String getTitle() {
		return "InputForm mappings";
	}

}
