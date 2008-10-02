/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openiaml.model.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.openiaml.model.model.ActivityNode;
import org.openiaml.model.model.CompositeOperation;
import org.openiaml.model.model.DataFlowEdge;
import org.openiaml.model.model.ExecutionEdge;
import org.openiaml.model.model.ModelPackage;
import org.openiaml.model.model.WireEdge;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.openiaml.model.model.impl.CompositeOperationImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.CompositeOperationImpl#getCompositeOperationWires <em>Composite Operation Wires</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.CompositeOperationImpl#getDataEdges <em>Data Edges</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.CompositeOperationImpl#getExecutionEdges <em>Execution Edges</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeOperationImpl extends ChainedOperationImpl implements CompositeOperation {
	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<ActivityNode> nodes;

	/**
	 * The cached value of the '{@link #getCompositeOperationWires() <em>Composite Operation Wires</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositeOperationWires()
	 * @generated
	 * @ordered
	 */
	protected EList<WireEdge> compositeOperationWires;

	/**
	 * The cached value of the '{@link #getDataEdges() <em>Data Edges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<DataFlowEdge> dataEdges;

	/**
	 * The cached value of the '{@link #getExecutionEdges() <em>Execution Edges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<ExecutionEdge> executionEdges;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.COMPOSITE_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ActivityNode> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList<ActivityNode>(ActivityNode.class, this, ModelPackage.COMPOSITE_OPERATION__NODES);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WireEdge> getCompositeOperationWires() {
		if (compositeOperationWires == null) {
			compositeOperationWires = new EObjectContainmentEList<WireEdge>(WireEdge.class, this, ModelPackage.COMPOSITE_OPERATION__COMPOSITE_OPERATION_WIRES);
		}
		return compositeOperationWires;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataFlowEdge> getDataEdges() {
		if (dataEdges == null) {
			dataEdges = new EObjectContainmentEList<DataFlowEdge>(DataFlowEdge.class, this, ModelPackage.COMPOSITE_OPERATION__DATA_EDGES);
		}
		return dataEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExecutionEdge> getExecutionEdges() {
		if (executionEdges == null) {
			executionEdges = new EObjectContainmentEList<ExecutionEdge>(ExecutionEdge.class, this, ModelPackage.COMPOSITE_OPERATION__EXECUTION_EDGES);
		}
		return executionEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.COMPOSITE_OPERATION__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case ModelPackage.COMPOSITE_OPERATION__COMPOSITE_OPERATION_WIRES:
				return ((InternalEList<?>)getCompositeOperationWires()).basicRemove(otherEnd, msgs);
			case ModelPackage.COMPOSITE_OPERATION__DATA_EDGES:
				return ((InternalEList<?>)getDataEdges()).basicRemove(otherEnd, msgs);
			case ModelPackage.COMPOSITE_OPERATION__EXECUTION_EDGES:
				return ((InternalEList<?>)getExecutionEdges()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.COMPOSITE_OPERATION__NODES:
				return getNodes();
			case ModelPackage.COMPOSITE_OPERATION__COMPOSITE_OPERATION_WIRES:
				return getCompositeOperationWires();
			case ModelPackage.COMPOSITE_OPERATION__DATA_EDGES:
				return getDataEdges();
			case ModelPackage.COMPOSITE_OPERATION__EXECUTION_EDGES:
				return getExecutionEdges();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.COMPOSITE_OPERATION__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends ActivityNode>)newValue);
				return;
			case ModelPackage.COMPOSITE_OPERATION__COMPOSITE_OPERATION_WIRES:
				getCompositeOperationWires().clear();
				getCompositeOperationWires().addAll((Collection<? extends WireEdge>)newValue);
				return;
			case ModelPackage.COMPOSITE_OPERATION__DATA_EDGES:
				getDataEdges().clear();
				getDataEdges().addAll((Collection<? extends DataFlowEdge>)newValue);
				return;
			case ModelPackage.COMPOSITE_OPERATION__EXECUTION_EDGES:
				getExecutionEdges().clear();
				getExecutionEdges().addAll((Collection<? extends ExecutionEdge>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.COMPOSITE_OPERATION__NODES:
				getNodes().clear();
				return;
			case ModelPackage.COMPOSITE_OPERATION__COMPOSITE_OPERATION_WIRES:
				getCompositeOperationWires().clear();
				return;
			case ModelPackage.COMPOSITE_OPERATION__DATA_EDGES:
				getDataEdges().clear();
				return;
			case ModelPackage.COMPOSITE_OPERATION__EXECUTION_EDGES:
				getExecutionEdges().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.COMPOSITE_OPERATION__NODES:
				return nodes != null && !nodes.isEmpty();
			case ModelPackage.COMPOSITE_OPERATION__COMPOSITE_OPERATION_WIRES:
				return compositeOperationWires != null && !compositeOperationWires.isEmpty();
			case ModelPackage.COMPOSITE_OPERATION__DATA_EDGES:
				return dataEdges != null && !dataEdges.isEmpty();
			case ModelPackage.COMPOSITE_OPERATION__EXECUTION_EDGES:
				return executionEdges != null && !executionEdges.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CompositeOperationImpl
