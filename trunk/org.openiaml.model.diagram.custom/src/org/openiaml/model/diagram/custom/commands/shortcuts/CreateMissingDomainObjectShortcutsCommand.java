package org.openiaml.model.diagram.custom.commands.shortcuts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.openiaml.model.model.ApplicationElementProperty;
import org.openiaml.model.model.DomainObject;
import org.openiaml.model.model.EventTrigger;
import org.openiaml.model.model.Operation;
import org.openiaml.model.model.StaticValue;
import org.openiaml.model.model.WireEdge;
import org.openiaml.model.model.WireEdgesSource;
import org.openiaml.model.model.domain.AbstractDomainAttribute;

/**
 * Implementation of the missing shortcuts for DomainStore.
 * 
 * @author jmwright
 *
 */
public class CreateMissingDomainObjectShortcutsCommand extends
		AbstractCreateMissingShortcutsCommand {

	private String modelId;
	
	public CreateMissingDomainObjectShortcutsCommand(GraphicalEditPart root, PreferencesHint prefHint, String modelId) {
		super(root, prefHint);
		this.modelId = modelId;
	}
	
	@Override
	protected List<WireEdge> getEdgesIn(EObject object) {
		DomainObject rootObject = (DomainObject) object;
		
		List<WireEdge> connectionsIn = new ArrayList<WireEdge>();
			
		// StaticValue doesn't have in edges

		// DomainAttribute
		for (AbstractDomainAttribute child : rootObject.getAttributes()) {
			connectionsIn.addAll( child.getInEdges() );
		}

		// EventTrigger doesn't have in edges
		
		// Operation (incl ChainedOperation)
		for (Operation child : rootObject.getOperations()) {
			connectionsIn.addAll( child.getInEdges() );
		}
		
		// ApplicationElementProperty
		for (ApplicationElementProperty child : rootObject.getProperties()) {
			connectionsIn.addAll( child.getInEdges() );
		}
		
		return connectionsIn;
	}

	@Override
	protected List<WireEdge> getEdgesOut(EObject object) {
		DomainObject rootObject = (DomainObject) object;
		
		List<WireEdge> connectionsOut = new ArrayList<WireEdge>();

		// StaticValue
		for (StaticValue child : rootObject.getValues()) {
			connectionsOut.addAll( child.getOutEdges() );
		}
		
		// DomainAttribute
		for (AbstractDomainAttribute child : rootObject.getAttributes()) {
			connectionsOut.addAll( child.getOutEdges() );
		}
		
		// EventTrigger
		for (EventTrigger child : rootObject.getEventTriggers()) {
			connectionsOut.addAll( child.getOutEdges() );
		}
		
		// Operation (incl ChainedOperation)
		for (Operation child : rootObject.getOperations()) {
			// not all Operations have outwards edges
			if (child instanceof WireEdgesSource) {
				connectionsOut.addAll( ((WireEdgesSource) child).getOutEdges() );
			}
		}
		
		// ApplicationElementProperty
		for (ApplicationElementProperty child : rootObject.getProperties()) {
			connectionsOut.addAll( child.getOutEdges() );
		}

		return connectionsOut;

	}

	@Override
	protected String getEditPartModelId() {
		return modelId;
	}

}
