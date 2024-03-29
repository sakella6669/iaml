/**
 * 
 */
package org.openiaml.model.helpers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.openiaml.model.model.ModelPackage;
import org.openiaml.model.model.Wire;
import org.openiaml.model.model.domain.DomainPackage;
import org.openiaml.model.model.operations.ExecutionEdge;
import org.openiaml.model.model.operations.OperationsPackage;
import org.openiaml.model.model.users.UsersPackage;
import org.openiaml.model.model.wires.WiresPackage;

/**
 * A helper run-time class that lists runtime information about all of the
 * edge types in the system; for example, {@link Wire} or {@link ExecutionEdge}.
 * 
 * <p>TODO In the future, this can be generated automatically from the simplegmf
 * model instance.
 * 
 * @author jmwright
 *
 */
public class EdgeTypes {
	
	/**
	 * Represents a single type of edge, along with its implementing class,
	 * to/from references and their opposites, and the implementing classes
	 * of the source and target of the edge. 
	 * 
	 * @author jmwright
	 *
	 */
	public static class EdgeType {
		private EClass edgeType;
		private EClass edgeSource;
		private EClass edgeDestination;
		private EReference fromRef;
		private EReference toRef;
		private EReference toOpposite;
		private EReference fromOpposite;
		
		/**
		 * @param edgeType
		 * @param edgeSource
		 * @param edgeDestination
		 * @param fromRef
		 * @param toRef
		 * @param fromOpposite 
		 * @param toOpposite 
		 */
		public EdgeType(EClass edgeType, EClass edgeSource,
				EClass edgeDestination, EReference fromRef, EReference toRef, 
				EReference fromOpposite, EReference toOpposite) {
			super();
			this.edgeType = edgeType;
			this.edgeSource = edgeSource;
			this.edgeDestination = edgeDestination;
			this.fromRef = fromRef;
			this.toRef = toRef;
			this.fromOpposite = fromOpposite;
			this.toOpposite = toOpposite;
			
			if (edgeType.equals(edgeSource))
				throw new IllegalArgumentException("EdgeType cannot be EdgeSource: " + edgeType.getName() + ", " + edgeSource.getName());
			if (edgeType.equals(edgeDestination))
				throw new IllegalArgumentException("EdgeType cannot be EdgeDestination: " + edgeType.getName() + ", " + edgeDestination.getName());
			if (edgeSource.equals(edgeDestination))
				throw new IllegalArgumentException("EdgeSource cannot be EdgeDestination: " + edgeSource.getName() + ", " + edgeDestination.getName());

		}
		
		public EClass getEdgeType() {
			return edgeType;
		}
		public EClass getEdgeSource() {
			return edgeSource;
		}
		public EClass getEdgeDestination() {
			return edgeDestination;
		}
		public EReference getFromRef() {
			return fromRef;
		}
		public EReference getToRef() {
			return toRef;
		}
		public EReference getToOpposite() {
			return toOpposite;
		}
		public EReference getFromOpposite() {
			return fromOpposite;
		}

		@Override
		public String toString() {
			return "EdgeType [edgeDestination=" + edgeDestination.getName()
					+ ", edgeSource=" + edgeSource.getName() + ", edgeType=" + edgeType.getName()
					+ ", fromRef=" + fromRef + ", toRef=" + toRef + "]";
		}
				
	}
	
	private static final List<EdgeType> edgeTypes = new ArrayList<EdgeType>();
	
	static {
		edgeTypes.add( new EdgeType(
				ModelPackage.eINSTANCE.getWire(), /* type */
				ModelPackage.eINSTANCE.getWireSource(), /* source */
				ModelPackage.eINSTANCE.getWireDestination(), /* destination */
				ModelPackage.eINSTANCE.getWire_From(), /* from ref */
				ModelPackage.eINSTANCE.getWire_To(), /* to ref */
				ModelPackage.eINSTANCE.getWireSource_OutWires(), /* from opposite */
				ModelPackage.eINSTANCE.getWireDestination_InWires() /* to opposite */
		) );
		
		edgeTypes.add( new EdgeType(
				ModelPackage.eINSTANCE.getECARule(), /* type */
				ModelPackage.eINSTANCE.getActionEdgeSource(), /* source */
				ModelPackage.eINSTANCE.getAction(), /* destination */
				ModelPackage.eINSTANCE.getECARule_Trigger(), /* from ref */
				ModelPackage.eINSTANCE.getECARule_Target(), /* to ref */
				ModelPackage.eINSTANCE.getActionEdgeSource_Listeners(), /* from opposite */
				ModelPackage.eINSTANCE.getAction_Rules() /* to opposite */
		) );

		edgeTypes.add( new EdgeType(
				OperationsPackage.eINSTANCE.getDataFlowEdge(), /* type */
				OperationsPackage.eINSTANCE.getDataFlowEdgesSource(), /* source */
				OperationsPackage.eINSTANCE.getDataFlowEdgeDestination(), /* destination */
				OperationsPackage.eINSTANCE.getDataFlowEdge_From(), /* from ref */
				OperationsPackage.eINSTANCE.getDataFlowEdge_To(), /* to ref */
				OperationsPackage.eINSTANCE.getDataFlowEdgesSource_OutFlows(),
				OperationsPackage.eINSTANCE.getDataFlowEdgeDestination_InFlows()
		) );
		
		edgeTypes.add( new EdgeType(
				ModelPackage.eINSTANCE.getComplexTerm(), /* type */
				ModelPackage.eINSTANCE.getFunction(), /* source */
				WiresPackage.eINSTANCE.getConditionEdgeDestination(), /* destination */
				ModelPackage.eINSTANCE.getComplexTerm_Function(), /* from ref */
				ModelPackage.eINSTANCE.getComplexTerm_Conditioned(), /* to ref */
				ModelPackage.eINSTANCE.getComplexTerm_Conditioned(),
				WiresPackage.eINSTANCE.getConditionEdgeDestination_Conditions()
		) );
		
		edgeTypes.add( new EdgeType(
				WiresPackage.eINSTANCE.getConstraintEdge(), /* type */
				WiresPackage.eINSTANCE.getConstraintEdgesSource(), /* source */
				WiresPackage.eINSTANCE.getConstraintEdgeDestination(), /* destination */
				WiresPackage.eINSTANCE.getConstraintEdge_From(), /* from ref */
				WiresPackage.eINSTANCE.getConstraintEdge_To(), /* to ref */
				WiresPackage.eINSTANCE.getConstraintEdgesSource_OutConstraintEdges(),
				WiresPackage.eINSTANCE.getConstraintEdgeDestination_InConstraintEdges()
		) );
		
		edgeTypes.add( new EdgeType(
				OperationsPackage.eINSTANCE.getExecutionEdge(), /* type */
				OperationsPackage.eINSTANCE.getExecutionEdgesSource(), /* source */
				OperationsPackage.eINSTANCE.getExecutionEdgeDestination(), /* destination */
				OperationsPackage.eINSTANCE.getExecutionEdge_From(), /* from ref */
				OperationsPackage.eINSTANCE.getExecutionEdge_To(), /* to ref */
				OperationsPackage.eINSTANCE.getExecutionEdgesSource_OutExecutions(),
				OperationsPackage.eINSTANCE.getExecutionEdgeDestination_InExecutions()
		) );
		
		edgeTypes.add( new EdgeType(
				WiresPackage.eINSTANCE.getExtendsEdge(), /* type */
				WiresPackage.eINSTANCE.getExtendsEdgesSource(), /* source */
				WiresPackage.eINSTANCE.getExtendsEdgeDestination(), /* destination */
				WiresPackage.eINSTANCE.getExtendsEdge_From(), /* from ref */
				WiresPackage.eINSTANCE.getExtendsEdge_To(), /* to ref */
				WiresPackage.eINSTANCE.getExtendsEdgesSource_OutExtendsEdges(),
				WiresPackage.eINSTANCE.getExtendsEdgeDestination_InExtendsEdges()
		) );
		
		edgeTypes.add( new EdgeType(
				ModelPackage.eINSTANCE.getParameter(), /* type */
				WiresPackage.eINSTANCE.getParameterEdgesSource(), /* source */
				WiresPackage.eINSTANCE.getParameterEdgeDestination(), /* destination */
				ModelPackage.eINSTANCE.getParameter_ParameterValue(), /* from ref */
				ModelPackage.eINSTANCE.getParameter_ParameterTerm(), /* to ref */
				WiresPackage.eINSTANCE.getParameterEdgesSource_OutParameterEdges(),
				WiresPackage.eINSTANCE.getParameterEdgeDestination_InParameterEdges()
		) );
		
		edgeTypes.add( new EdgeType(
				WiresPackage.eINSTANCE.getProvidesEdge(), /* type */
				UsersPackage.eINSTANCE.getProvidesEdgesSource(), /* source */
				UsersPackage.eINSTANCE.getProvidesEdgeDestination(), /* destination */
				WiresPackage.eINSTANCE.getProvidesEdge_From(), /* from ref */
				WiresPackage.eINSTANCE.getProvidesEdge_To(), /* to ref */
				UsersPackage.eINSTANCE.getProvidesEdgesSource_OutProvidesEdges(),
				UsersPackage.eINSTANCE.getProvidesEdgeDestination_InProvidesEdges()
		) );
		
		edgeTypes.add( new EdgeType(
				WiresPackage.eINSTANCE.getRequiresEdge(), /* type */
				UsersPackage.eINSTANCE.getRequiresEdgesSource(), /* source */
				UsersPackage.eINSTANCE.getRequiresEdgeDestination(), /* destination */
				WiresPackage.eINSTANCE.getRequiresEdge_From(), /* from ref */
				WiresPackage.eINSTANCE.getRequiresEdge_To(), /* to ref */
				UsersPackage.eINSTANCE.getRequiresEdgesSource_OutRequiresEdges(),
				UsersPackage.eINSTANCE.getRequiresEdgeDestination_InRequiresEdges()
		) );

		edgeTypes.add( new EdgeType(
				DomainPackage.eINSTANCE.getSelectEdge(), /* type */
				DomainPackage.eINSTANCE.getDomainIterator(), /* source */
				DomainPackage.eINSTANCE.getDomainSource(), /* destination */
				DomainPackage.eINSTANCE.getSelectEdge_From(), /* from ref */
				DomainPackage.eINSTANCE.getSelectEdge_To(), /* to ref */
				DomainPackage.eINSTANCE.getDomainIterator_OutSelects(),
				DomainPackage.eINSTANCE.getDomainSource_InSelects()
		) );

		edgeTypes.add( new EdgeType(
				DomainPackage.eINSTANCE.getSchemaEdge(), /* type */
				DomainPackage.eINSTANCE.getDomainSource(), /* source */
				DomainPackage.eINSTANCE.getDomainType(), /* destination */
				DomainPackage.eINSTANCE.getSchemaEdge_From(), /* from ref */
				DomainPackage.eINSTANCE.getSchemaEdge_To(), /* to ref */
				DomainPackage.eINSTANCE.getDomainSource_OutSchemas(),
				DomainPackage.eINSTANCE.getDomainType_InSchemas()
		) );

	}
	
	public static final List<EClass> getEdgeTypes() {
		List<EClass> edgeTypes = new ArrayList<EClass>();
		
		for (EdgeType typ : EdgeTypes.edgeTypes) {
			edgeTypes.add(typ.getEdgeType());
		}

		return edgeTypes;
	}
	
	/**
	 * Get all the edge source interface classes.
	 * 
	 * @return
	 */
	public static final List<EClass> getEdgeSources() {
		
		List<EClass> edgeTypes = new ArrayList<EClass>();
		
		for (EdgeType typ : EdgeTypes.edgeTypes) {
			edgeTypes.add(typ.getEdgeSource());
		}
		
		return edgeTypes;
		
	}
	
	/**
	 * Get all the edge destination interface classes.
	 * 
	 * @return
	 */
	public static final List<EClass> getEdgeDestinations() {
		
		List<EClass> edgeTypes = new ArrayList<EClass>();
		
		for (EdgeType typ : EdgeTypes.edgeTypes) {
			edgeTypes.add(typ.getEdgeDestination());
		}
		
		return edgeTypes;
		
	}

	/**
	 * Get the collection of data of edge types.
	 * @return
	 */
	public static List<EdgeType> getAllEdgeTypes() {
		return edgeTypes;
	}
	
}
