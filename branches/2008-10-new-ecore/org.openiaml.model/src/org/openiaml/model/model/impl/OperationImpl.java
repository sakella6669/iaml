/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openiaml.model.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.openiaml.model.model.ActivityNode;
import org.openiaml.model.model.DataFlowEdge;
import org.openiaml.model.model.DataFlowEdgeDestination;
import org.openiaml.model.model.DataFlowEdgesSource;
import org.openiaml.model.model.ExecutionEdge;
import org.openiaml.model.model.ExecutionEdgeDestination;
import org.openiaml.model.model.ModelPackage;
import org.openiaml.model.model.NamedElement;
import org.openiaml.model.model.Operation;
import org.openiaml.model.model.Parameter;
import org.openiaml.model.model.WireEdge;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.openiaml.model.model.impl.OperationImpl#getInEdges <em>In Edges</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.OperationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.OperationImpl#getInFlows <em>In Flows</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.OperationImpl#getInExecutions <em>In Executions</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.OperationImpl#getOutFlows <em>Out Flows</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.OperationImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class OperationImpl extends EObjectImpl implements Operation {
	/**
	 * The cached value of the '{@link #getInEdges() <em>In Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<WireEdge> inEdges;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInFlows() <em>In Flows</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInFlows()
	 * @generated
	 * @ordered
	 */
	protected EList<DataFlowEdge> inFlows;

	/**
	 * The cached value of the '{@link #getInExecutions() <em>In Executions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInExecutions()
	 * @generated
	 * @ordered
	 */
	protected EList<ExecutionEdge> inExecutions;

	/**
	 * The cached value of the '{@link #getOutFlows() <em>Out Flows</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutFlows()
	 * @generated
	 * @ordered
	 */
	protected EList<DataFlowEdge> outFlows;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WireEdge> getInEdges() {
		if (inEdges == null) {
			inEdges = new EObjectWithInverseResolvingEList<WireEdge>(WireEdge.class, this, ModelPackage.OPERATION__IN_EDGES, ModelPackage.WIRE_EDGE__TO);
		}
		return inEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.OPERATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataFlowEdge> getInFlows() {
		if (inFlows == null) {
			inFlows = new EObjectWithInverseResolvingEList<DataFlowEdge>(DataFlowEdge.class, this, ModelPackage.OPERATION__IN_FLOWS, ModelPackage.DATA_FLOW_EDGE__TO);
		}
		return inFlows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExecutionEdge> getInExecutions() {
		if (inExecutions == null) {
			inExecutions = new EObjectWithInverseResolvingEList<ExecutionEdge>(ExecutionEdge.class, this, ModelPackage.OPERATION__IN_EXECUTIONS, ModelPackage.EXECUTION_EDGE__TO);
		}
		return inExecutions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataFlowEdge> getOutFlows() {
		if (outFlows == null) {
			outFlows = new EObjectWithInverseResolvingEList<DataFlowEdge>(DataFlowEdge.class, this, ModelPackage.OPERATION__OUT_FLOWS, ModelPackage.DATA_FLOW_EDGE__FROM);
		}
		return outFlows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, ModelPackage.OPERATION__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.OPERATION__IN_EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInEdges()).basicAdd(otherEnd, msgs);
			case ModelPackage.OPERATION__IN_FLOWS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInFlows()).basicAdd(otherEnd, msgs);
			case ModelPackage.OPERATION__IN_EXECUTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInExecutions()).basicAdd(otherEnd, msgs);
			case ModelPackage.OPERATION__OUT_FLOWS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutFlows()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.OPERATION__IN_EDGES:
				return ((InternalEList<?>)getInEdges()).basicRemove(otherEnd, msgs);
			case ModelPackage.OPERATION__IN_FLOWS:
				return ((InternalEList<?>)getInFlows()).basicRemove(otherEnd, msgs);
			case ModelPackage.OPERATION__IN_EXECUTIONS:
				return ((InternalEList<?>)getInExecutions()).basicRemove(otherEnd, msgs);
			case ModelPackage.OPERATION__OUT_FLOWS:
				return ((InternalEList<?>)getOutFlows()).basicRemove(otherEnd, msgs);
			case ModelPackage.OPERATION__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.OPERATION__IN_EDGES:
				return getInEdges();
			case ModelPackage.OPERATION__NAME:
				return getName();
			case ModelPackage.OPERATION__IN_FLOWS:
				return getInFlows();
			case ModelPackage.OPERATION__IN_EXECUTIONS:
				return getInExecutions();
			case ModelPackage.OPERATION__OUT_FLOWS:
				return getOutFlows();
			case ModelPackage.OPERATION__PARAMETERS:
				return getParameters();
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
			case ModelPackage.OPERATION__IN_EDGES:
				getInEdges().clear();
				getInEdges().addAll((Collection<? extends WireEdge>)newValue);
				return;
			case ModelPackage.OPERATION__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.OPERATION__IN_FLOWS:
				getInFlows().clear();
				getInFlows().addAll((Collection<? extends DataFlowEdge>)newValue);
				return;
			case ModelPackage.OPERATION__IN_EXECUTIONS:
				getInExecutions().clear();
				getInExecutions().addAll((Collection<? extends ExecutionEdge>)newValue);
				return;
			case ModelPackage.OPERATION__OUT_FLOWS:
				getOutFlows().clear();
				getOutFlows().addAll((Collection<? extends DataFlowEdge>)newValue);
				return;
			case ModelPackage.OPERATION__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
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
			case ModelPackage.OPERATION__IN_EDGES:
				getInEdges().clear();
				return;
			case ModelPackage.OPERATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.OPERATION__IN_FLOWS:
				getInFlows().clear();
				return;
			case ModelPackage.OPERATION__IN_EXECUTIONS:
				getInExecutions().clear();
				return;
			case ModelPackage.OPERATION__OUT_FLOWS:
				getOutFlows().clear();
				return;
			case ModelPackage.OPERATION__PARAMETERS:
				getParameters().clear();
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
			case ModelPackage.OPERATION__IN_EDGES:
				return inEdges != null && !inEdges.isEmpty();
			case ModelPackage.OPERATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.OPERATION__IN_FLOWS:
				return inFlows != null && !inFlows.isEmpty();
			case ModelPackage.OPERATION__IN_EXECUTIONS:
				return inExecutions != null && !inExecutions.isEmpty();
			case ModelPackage.OPERATION__OUT_FLOWS:
				return outFlows != null && !outFlows.isEmpty();
			case ModelPackage.OPERATION__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == NamedElement.class) {
			switch (derivedFeatureID) {
				case ModelPackage.OPERATION__NAME: return ModelPackage.NAMED_ELEMENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == DataFlowEdgeDestination.class) {
			switch (derivedFeatureID) {
				case ModelPackage.OPERATION__IN_FLOWS: return ModelPackage.DATA_FLOW_EDGE_DESTINATION__IN_FLOWS;
				default: return -1;
			}
		}
		if (baseClass == ExecutionEdgeDestination.class) {
			switch (derivedFeatureID) {
				case ModelPackage.OPERATION__IN_EXECUTIONS: return ModelPackage.EXECUTION_EDGE_DESTINATION__IN_EXECUTIONS;
				default: return -1;
			}
		}
		if (baseClass == ActivityNode.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == DataFlowEdgesSource.class) {
			switch (derivedFeatureID) {
				case ModelPackage.OPERATION__OUT_FLOWS: return ModelPackage.DATA_FLOW_EDGES_SOURCE__OUT_FLOWS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == NamedElement.class) {
			switch (baseFeatureID) {
				case ModelPackage.NAMED_ELEMENT__NAME: return ModelPackage.OPERATION__NAME;
				default: return -1;
			}
		}
		if (baseClass == DataFlowEdgeDestination.class) {
			switch (baseFeatureID) {
				case ModelPackage.DATA_FLOW_EDGE_DESTINATION__IN_FLOWS: return ModelPackage.OPERATION__IN_FLOWS;
				default: return -1;
			}
		}
		if (baseClass == ExecutionEdgeDestination.class) {
			switch (baseFeatureID) {
				case ModelPackage.EXECUTION_EDGE_DESTINATION__IN_EXECUTIONS: return ModelPackage.OPERATION__IN_EXECUTIONS;
				default: return -1;
			}
		}
		if (baseClass == ActivityNode.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == DataFlowEdgesSource.class) {
			switch (baseFeatureID) {
				case ModelPackage.DATA_FLOW_EDGES_SOURCE__OUT_FLOWS: return ModelPackage.OPERATION__OUT_FLOWS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //OperationImpl
