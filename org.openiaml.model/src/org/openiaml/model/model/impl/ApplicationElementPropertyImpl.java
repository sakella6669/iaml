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
import org.openiaml.model.model.ApplicationElementProperty;
import org.openiaml.model.model.ContainsWires;
import org.openiaml.model.model.DataFlowEdge;
import org.openiaml.model.model.DataFlowEdgeDestination;
import org.openiaml.model.model.DataFlowEdgesSource;
import org.openiaml.model.model.GeneratesElements;
import org.openiaml.model.model.ModelPackage;
import org.openiaml.model.model.ShouldntContainWires;
import org.openiaml.model.model.WireEdge;
import org.openiaml.model.model.WireEdgeDestination;
import org.openiaml.model.model.WireEdgesSource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application Element Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.openiaml.model.model.impl.ApplicationElementPropertyImpl#getGeneratedBy <em>Generated By</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.ApplicationElementPropertyImpl#isIsGenerated <em>Is Generated</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.ApplicationElementPropertyImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.ApplicationElementPropertyImpl#getWires <em>Wires</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.ApplicationElementPropertyImpl#getOutEdges <em>Out Edges</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.ApplicationElementPropertyImpl#getInEdges <em>In Edges</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.ApplicationElementPropertyImpl#getOutFlows <em>Out Flows</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.ApplicationElementPropertyImpl#getInFlows <em>In Flows</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ApplicationElementPropertyImpl extends EObjectImpl implements ApplicationElementProperty {
	/**
	 * The cached value of the '{@link #getGeneratedBy() <em>Generated By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneratedBy()
	 * @generated
	 * @ordered
	 */
	protected GeneratesElements generatedBy;

	/**
	 * The default value of the '{@link #isIsGenerated() <em>Is Generated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsGenerated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_GENERATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsGenerated() <em>Is Generated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsGenerated()
	 * @generated
	 * @ordered
	 */
	protected boolean isGenerated = IS_GENERATED_EDEFAULT;

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
	 * The cached value of the '{@link #getWires() <em>Wires</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWires()
	 * @generated
	 * @ordered
	 */
	protected EList<WireEdge> wires;

	/**
	 * The cached value of the '{@link #getOutEdges() <em>Out Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<WireEdge> outEdges;

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
	 * The cached value of the '{@link #getOutFlows() <em>Out Flows</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutFlows()
	 * @generated
	 * @ordered
	 */
	protected EList<DataFlowEdge> outFlows;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplicationElementPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.APPLICATION_ELEMENT_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratesElements getGeneratedBy() {
		if (generatedBy != null && generatedBy.eIsProxy()) {
			InternalEObject oldGeneratedBy = (InternalEObject)generatedBy;
			generatedBy = (GeneratesElements)eResolveProxy(oldGeneratedBy);
			if (generatedBy != oldGeneratedBy) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.APPLICATION_ELEMENT_PROPERTY__GENERATED_BY, oldGeneratedBy, generatedBy));
			}
		}
		return generatedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratesElements basicGetGeneratedBy() {
		return generatedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGeneratedBy(GeneratesElements newGeneratedBy, NotificationChain msgs) {
		GeneratesElements oldGeneratedBy = generatedBy;
		generatedBy = newGeneratedBy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.APPLICATION_ELEMENT_PROPERTY__GENERATED_BY, oldGeneratedBy, newGeneratedBy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeneratedBy(GeneratesElements newGeneratedBy) {
		if (newGeneratedBy != generatedBy) {
			NotificationChain msgs = null;
			if (generatedBy != null)
				msgs = ((InternalEObject)generatedBy).eInverseRemove(this, ModelPackage.GENERATES_ELEMENTS__GENERATED_ELEMENTS, GeneratesElements.class, msgs);
			if (newGeneratedBy != null)
				msgs = ((InternalEObject)newGeneratedBy).eInverseAdd(this, ModelPackage.GENERATES_ELEMENTS__GENERATED_ELEMENTS, GeneratesElements.class, msgs);
			msgs = basicSetGeneratedBy(newGeneratedBy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.APPLICATION_ELEMENT_PROPERTY__GENERATED_BY, newGeneratedBy, newGeneratedBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsGenerated() {
		return isGenerated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsGenerated(boolean newIsGenerated) {
		boolean oldIsGenerated = isGenerated;
		isGenerated = newIsGenerated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.APPLICATION_ELEMENT_PROPERTY__IS_GENERATED, oldIsGenerated, isGenerated));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.APPLICATION_ELEMENT_PROPERTY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WireEdge> getOutEdges() {
		if (outEdges == null) {
			outEdges = new EObjectWithInverseResolvingEList<WireEdge>(WireEdge.class, this, ModelPackage.APPLICATION_ELEMENT_PROPERTY__OUT_EDGES, ModelPackage.WIRE_EDGE__FROM);
		}
		return outEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WireEdge> getInEdges() {
		if (inEdges == null) {
			inEdges = new EObjectWithInverseResolvingEList<WireEdge>(WireEdge.class, this, ModelPackage.APPLICATION_ELEMENT_PROPERTY__IN_EDGES, ModelPackage.WIRE_EDGE__TO);
		}
		return inEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataFlowEdge> getOutFlows() {
		if (outFlows == null) {
			outFlows = new EObjectWithInverseResolvingEList<DataFlowEdge>(DataFlowEdge.class, this, ModelPackage.APPLICATION_ELEMENT_PROPERTY__OUT_FLOWS, ModelPackage.DATA_FLOW_EDGE__FROM);
		}
		return outFlows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataFlowEdge> getInFlows() {
		if (inFlows == null) {
			inFlows = new EObjectWithInverseResolvingEList<DataFlowEdge>(DataFlowEdge.class, this, ModelPackage.APPLICATION_ELEMENT_PROPERTY__IN_FLOWS, ModelPackage.DATA_FLOW_EDGE__TO);
		}
		return inFlows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WireEdge> getWires() {
		if (wires == null) {
			wires = new EObjectContainmentEList<WireEdge>(WireEdge.class, this, ModelPackage.APPLICATION_ELEMENT_PROPERTY__WIRES);
		}
		return wires;
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
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__GENERATED_BY:
				if (generatedBy != null)
					msgs = ((InternalEObject)generatedBy).eInverseRemove(this, ModelPackage.GENERATES_ELEMENTS__GENERATED_ELEMENTS, GeneratesElements.class, msgs);
				return basicSetGeneratedBy((GeneratesElements)otherEnd, msgs);
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__OUT_EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutEdges()).basicAdd(otherEnd, msgs);
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__IN_EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInEdges()).basicAdd(otherEnd, msgs);
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__OUT_FLOWS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutFlows()).basicAdd(otherEnd, msgs);
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__IN_FLOWS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInFlows()).basicAdd(otherEnd, msgs);
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
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__GENERATED_BY:
				return basicSetGeneratedBy(null, msgs);
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__WIRES:
				return ((InternalEList<?>)getWires()).basicRemove(otherEnd, msgs);
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__OUT_EDGES:
				return ((InternalEList<?>)getOutEdges()).basicRemove(otherEnd, msgs);
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__IN_EDGES:
				return ((InternalEList<?>)getInEdges()).basicRemove(otherEnd, msgs);
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__OUT_FLOWS:
				return ((InternalEList<?>)getOutFlows()).basicRemove(otherEnd, msgs);
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__IN_FLOWS:
				return ((InternalEList<?>)getInFlows()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__GENERATED_BY:
				if (resolve) return getGeneratedBy();
				return basicGetGeneratedBy();
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__IS_GENERATED:
				return isIsGenerated() ? Boolean.TRUE : Boolean.FALSE;
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__NAME:
				return getName();
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__WIRES:
				return getWires();
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__OUT_EDGES:
				return getOutEdges();
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__IN_EDGES:
				return getInEdges();
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__OUT_FLOWS:
				return getOutFlows();
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__IN_FLOWS:
				return getInFlows();
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
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__GENERATED_BY:
				setGeneratedBy((GeneratesElements)newValue);
				return;
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__IS_GENERATED:
				setIsGenerated(((Boolean)newValue).booleanValue());
				return;
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__WIRES:
				getWires().clear();
				getWires().addAll((Collection<? extends WireEdge>)newValue);
				return;
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__OUT_EDGES:
				getOutEdges().clear();
				getOutEdges().addAll((Collection<? extends WireEdge>)newValue);
				return;
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__IN_EDGES:
				getInEdges().clear();
				getInEdges().addAll((Collection<? extends WireEdge>)newValue);
				return;
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__OUT_FLOWS:
				getOutFlows().clear();
				getOutFlows().addAll((Collection<? extends DataFlowEdge>)newValue);
				return;
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__IN_FLOWS:
				getInFlows().clear();
				getInFlows().addAll((Collection<? extends DataFlowEdge>)newValue);
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
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__GENERATED_BY:
				setGeneratedBy((GeneratesElements)null);
				return;
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__IS_GENERATED:
				setIsGenerated(IS_GENERATED_EDEFAULT);
				return;
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__WIRES:
				getWires().clear();
				return;
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__OUT_EDGES:
				getOutEdges().clear();
				return;
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__IN_EDGES:
				getInEdges().clear();
				return;
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__OUT_FLOWS:
				getOutFlows().clear();
				return;
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__IN_FLOWS:
				getInFlows().clear();
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
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__GENERATED_BY:
				return generatedBy != null;
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__IS_GENERATED:
				return isGenerated != IS_GENERATED_EDEFAULT;
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__WIRES:
				return wires != null && !wires.isEmpty();
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__OUT_EDGES:
				return outEdges != null && !outEdges.isEmpty();
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__IN_EDGES:
				return inEdges != null && !inEdges.isEmpty();
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__OUT_FLOWS:
				return outFlows != null && !outFlows.isEmpty();
			case ModelPackage.APPLICATION_ELEMENT_PROPERTY__IN_FLOWS:
				return inFlows != null && !inFlows.isEmpty();
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
		if (baseClass == ContainsWires.class) {
			switch (derivedFeatureID) {
				case ModelPackage.APPLICATION_ELEMENT_PROPERTY__WIRES: return ModelPackage.CONTAINS_WIRES__WIRES;
				default: return -1;
			}
		}
		if (baseClass == ShouldntContainWires.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == WireEdgesSource.class) {
			switch (derivedFeatureID) {
				case ModelPackage.APPLICATION_ELEMENT_PROPERTY__OUT_EDGES: return ModelPackage.WIRE_EDGES_SOURCE__OUT_EDGES;
				default: return -1;
			}
		}
		if (baseClass == WireEdgeDestination.class) {
			switch (derivedFeatureID) {
				case ModelPackage.APPLICATION_ELEMENT_PROPERTY__IN_EDGES: return ModelPackage.WIRE_EDGE_DESTINATION__IN_EDGES;
				default: return -1;
			}
		}
		if (baseClass == DataFlowEdgesSource.class) {
			switch (derivedFeatureID) {
				case ModelPackage.APPLICATION_ELEMENT_PROPERTY__OUT_FLOWS: return ModelPackage.DATA_FLOW_EDGES_SOURCE__OUT_FLOWS;
				default: return -1;
			}
		}
		if (baseClass == DataFlowEdgeDestination.class) {
			switch (derivedFeatureID) {
				case ModelPackage.APPLICATION_ELEMENT_PROPERTY__IN_FLOWS: return ModelPackage.DATA_FLOW_EDGE_DESTINATION__IN_FLOWS;
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
		if (baseClass == ContainsWires.class) {
			switch (baseFeatureID) {
				case ModelPackage.CONTAINS_WIRES__WIRES: return ModelPackage.APPLICATION_ELEMENT_PROPERTY__WIRES;
				default: return -1;
			}
		}
		if (baseClass == ShouldntContainWires.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == WireEdgesSource.class) {
			switch (baseFeatureID) {
				case ModelPackage.WIRE_EDGES_SOURCE__OUT_EDGES: return ModelPackage.APPLICATION_ELEMENT_PROPERTY__OUT_EDGES;
				default: return -1;
			}
		}
		if (baseClass == WireEdgeDestination.class) {
			switch (baseFeatureID) {
				case ModelPackage.WIRE_EDGE_DESTINATION__IN_EDGES: return ModelPackage.APPLICATION_ELEMENT_PROPERTY__IN_EDGES;
				default: return -1;
			}
		}
		if (baseClass == DataFlowEdgesSource.class) {
			switch (baseFeatureID) {
				case ModelPackage.DATA_FLOW_EDGES_SOURCE__OUT_FLOWS: return ModelPackage.APPLICATION_ELEMENT_PROPERTY__OUT_FLOWS;
				default: return -1;
			}
		}
		if (baseClass == DataFlowEdgeDestination.class) {
			switch (baseFeatureID) {
				case ModelPackage.DATA_FLOW_EDGE_DESTINATION__IN_FLOWS: return ModelPackage.APPLICATION_ELEMENT_PROPERTY__IN_FLOWS;
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
		result.append(" (isGenerated: ");
		result.append(isGenerated);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ApplicationElementPropertyImpl
