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
import org.openiaml.model.model.Condition;
import org.openiaml.model.model.DataFlowEdge;
import org.openiaml.model.model.DataFlowEdgesSource;
import org.openiaml.model.model.GeneratedElement;
import org.openiaml.model.model.GeneratesElements;
import org.openiaml.model.model.ModelPackage;
import org.openiaml.model.model.NamedElement;
import org.openiaml.model.model.Wire;
import org.openiaml.model.model.wires.ConditionEdge;
import org.openiaml.model.model.wires.ConditionEdgesSource;
import org.openiaml.model.model.wires.ConstraintEdge;
import org.openiaml.model.model.wires.ExtendsEdge;
import org.openiaml.model.model.wires.ParameterEdge;
import org.openiaml.model.model.wires.ProvidesEdge;
import org.openiaml.model.model.wires.RequiresEdge;
import org.openiaml.model.model.wires.WiresPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.openiaml.model.model.impl.ConditionImpl#getWires <em>Wires</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.ConditionImpl#getParameterEdges <em>Parameter Edges</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.ConditionImpl#getExtendsEdges <em>Extends Edges</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.ConditionImpl#getRequiresEdges <em>Requires Edges</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.ConditionImpl#getProvidesEdges <em>Provides Edges</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.ConditionImpl#getConstraintEdges <em>Constraint Edges</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.ConditionImpl#getConditionEdges <em>Condition Edges</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.ConditionImpl#getOutWires <em>Out Wires</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.ConditionImpl#getOutFlows <em>Out Flows</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.ConditionImpl#getGeneratedBy <em>Generated By</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.ConditionImpl#isIsGenerated <em>Is Generated</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.ConditionImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.ConditionImpl#getGeneratedRule <em>Generated Rule</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.ConditionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.ConditionImpl#getOutConditionEdges <em>Out Condition Edges</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ConditionImpl extends EObjectImpl implements Condition {
	/**
	 * The cached value of the '{@link #getWires() <em>Wires</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWires()
	 * @generated
	 * @ordered
	 */
	protected EList<Wire> wires;

	/**
	 * The cached value of the '{@link #getParameterEdges() <em>Parameter Edges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterEdge> parameterEdges;

	/**
	 * The cached value of the '{@link #getExtendsEdges() <em>Extends Edges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendsEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<ExtendsEdge> extendsEdges;

	/**
	 * The cached value of the '{@link #getRequiresEdges() <em>Requires Edges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiresEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<RequiresEdge> requiresEdges;

	/**
	 * The cached value of the '{@link #getProvidesEdges() <em>Provides Edges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidesEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<ProvidesEdge> providesEdges;

	/**
	 * The cached value of the '{@link #getConstraintEdges() <em>Constraint Edges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<ConstraintEdge> constraintEdges;

	/**
	 * The cached value of the '{@link #getConditionEdges() <em>Condition Edges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<ConditionEdge> conditionEdges;

	/**
	 * The cached value of the '{@link #getOutWires() <em>Out Wires</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutWires()
	 * @generated
	 * @ordered
	 */
	protected EList<Wire> outWires;

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
	 * The cached value of the '{@link #getGeneratedBy() <em>Generated By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneratedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<GeneratesElements> generatedBy;

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
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getGeneratedRule() <em>Generated Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneratedRule()
	 * @generated
	 * @ordered
	 */
	protected static final String GENERATED_RULE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGeneratedRule() <em>Generated Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneratedRule()
	 * @generated
	 * @ordered
	 */
	protected String generatedRule = GENERATED_RULE_EDEFAULT;

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
	 * The cached value of the '{@link #getOutConditionEdges() <em>Out Condition Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutConditionEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<ConditionEdge> outConditionEdges;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Wire> getWires() {
		if (wires == null) {
			wires = new EObjectContainmentEList<Wire>(Wire.class, this, ModelPackage.CONDITION__WIRES);
		}
		return wires;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterEdge> getParameterEdges() {
		if (parameterEdges == null) {
			parameterEdges = new EObjectContainmentEList<ParameterEdge>(ParameterEdge.class, this, ModelPackage.CONDITION__PARAMETER_EDGES);
		}
		return parameterEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExtendsEdge> getExtendsEdges() {
		if (extendsEdges == null) {
			extendsEdges = new EObjectContainmentEList<ExtendsEdge>(ExtendsEdge.class, this, ModelPackage.CONDITION__EXTENDS_EDGES);
		}
		return extendsEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RequiresEdge> getRequiresEdges() {
		if (requiresEdges == null) {
			requiresEdges = new EObjectContainmentEList<RequiresEdge>(RequiresEdge.class, this, ModelPackage.CONDITION__REQUIRES_EDGES);
		}
		return requiresEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProvidesEdge> getProvidesEdges() {
		if (providesEdges == null) {
			providesEdges = new EObjectContainmentEList<ProvidesEdge>(ProvidesEdge.class, this, ModelPackage.CONDITION__PROVIDES_EDGES);
		}
		return providesEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConstraintEdge> getConstraintEdges() {
		if (constraintEdges == null) {
			constraintEdges = new EObjectContainmentEList<ConstraintEdge>(ConstraintEdge.class, this, ModelPackage.CONDITION__CONSTRAINT_EDGES);
		}
		return constraintEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConditionEdge> getConditionEdges() {
		if (conditionEdges == null) {
			conditionEdges = new EObjectContainmentEList<ConditionEdge>(ConditionEdge.class, this, ModelPackage.CONDITION__CONDITION_EDGES);
		}
		return conditionEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Wire> getOutWires() {
		if (outWires == null) {
			outWires = new EObjectWithInverseResolvingEList<Wire>(Wire.class, this, ModelPackage.CONDITION__OUT_WIRES, ModelPackage.WIRE__FROM);
		}
		return outWires;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataFlowEdge> getOutFlows() {
		if (outFlows == null) {
			outFlows = new EObjectWithInverseResolvingEList<DataFlowEdge>(DataFlowEdge.class, this, ModelPackage.CONDITION__OUT_FLOWS, ModelPackage.DATA_FLOW_EDGE__FROM);
		}
		return outFlows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GeneratesElements> getGeneratedBy() {
		if (generatedBy == null) {
			generatedBy = new EObjectWithInverseResolvingEList.ManyInverse<GeneratesElements>(GeneratesElements.class, this, ModelPackage.CONDITION__GENERATED_BY, ModelPackage.GENERATES_ELEMENTS__GENERATED_ELEMENTS);
		}
		return generatedBy;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONDITION__IS_GENERATED, oldIsGenerated, isGenerated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONDITION__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGeneratedRule() {
		return generatedRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeneratedRule(String newGeneratedRule) {
		String oldGeneratedRule = generatedRule;
		generatedRule = newGeneratedRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONDITION__GENERATED_RULE, oldGeneratedRule, generatedRule));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONDITION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConditionEdge> getOutConditionEdges() {
		if (outConditionEdges == null) {
			outConditionEdges = new EObjectWithInverseResolvingEList<ConditionEdge>(ConditionEdge.class, this, ModelPackage.CONDITION__OUT_CONDITION_EDGES, WiresPackage.CONDITION_EDGE__FROM);
		}
		return outConditionEdges;
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
			case ModelPackage.CONDITION__OUT_WIRES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutWires()).basicAdd(otherEnd, msgs);
			case ModelPackage.CONDITION__OUT_FLOWS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutFlows()).basicAdd(otherEnd, msgs);
			case ModelPackage.CONDITION__GENERATED_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGeneratedBy()).basicAdd(otherEnd, msgs);
			case ModelPackage.CONDITION__OUT_CONDITION_EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutConditionEdges()).basicAdd(otherEnd, msgs);
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
			case ModelPackage.CONDITION__WIRES:
				return ((InternalEList<?>)getWires()).basicRemove(otherEnd, msgs);
			case ModelPackage.CONDITION__PARAMETER_EDGES:
				return ((InternalEList<?>)getParameterEdges()).basicRemove(otherEnd, msgs);
			case ModelPackage.CONDITION__EXTENDS_EDGES:
				return ((InternalEList<?>)getExtendsEdges()).basicRemove(otherEnd, msgs);
			case ModelPackage.CONDITION__REQUIRES_EDGES:
				return ((InternalEList<?>)getRequiresEdges()).basicRemove(otherEnd, msgs);
			case ModelPackage.CONDITION__PROVIDES_EDGES:
				return ((InternalEList<?>)getProvidesEdges()).basicRemove(otherEnd, msgs);
			case ModelPackage.CONDITION__CONSTRAINT_EDGES:
				return ((InternalEList<?>)getConstraintEdges()).basicRemove(otherEnd, msgs);
			case ModelPackage.CONDITION__CONDITION_EDGES:
				return ((InternalEList<?>)getConditionEdges()).basicRemove(otherEnd, msgs);
			case ModelPackage.CONDITION__OUT_WIRES:
				return ((InternalEList<?>)getOutWires()).basicRemove(otherEnd, msgs);
			case ModelPackage.CONDITION__OUT_FLOWS:
				return ((InternalEList<?>)getOutFlows()).basicRemove(otherEnd, msgs);
			case ModelPackage.CONDITION__GENERATED_BY:
				return ((InternalEList<?>)getGeneratedBy()).basicRemove(otherEnd, msgs);
			case ModelPackage.CONDITION__OUT_CONDITION_EDGES:
				return ((InternalEList<?>)getOutConditionEdges()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.CONDITION__WIRES:
				return getWires();
			case ModelPackage.CONDITION__PARAMETER_EDGES:
				return getParameterEdges();
			case ModelPackage.CONDITION__EXTENDS_EDGES:
				return getExtendsEdges();
			case ModelPackage.CONDITION__REQUIRES_EDGES:
				return getRequiresEdges();
			case ModelPackage.CONDITION__PROVIDES_EDGES:
				return getProvidesEdges();
			case ModelPackage.CONDITION__CONSTRAINT_EDGES:
				return getConstraintEdges();
			case ModelPackage.CONDITION__CONDITION_EDGES:
				return getConditionEdges();
			case ModelPackage.CONDITION__OUT_WIRES:
				return getOutWires();
			case ModelPackage.CONDITION__OUT_FLOWS:
				return getOutFlows();
			case ModelPackage.CONDITION__GENERATED_BY:
				return getGeneratedBy();
			case ModelPackage.CONDITION__IS_GENERATED:
				return isIsGenerated();
			case ModelPackage.CONDITION__ID:
				return getId();
			case ModelPackage.CONDITION__GENERATED_RULE:
				return getGeneratedRule();
			case ModelPackage.CONDITION__NAME:
				return getName();
			case ModelPackage.CONDITION__OUT_CONDITION_EDGES:
				return getOutConditionEdges();
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
			case ModelPackage.CONDITION__WIRES:
				getWires().clear();
				getWires().addAll((Collection<? extends Wire>)newValue);
				return;
			case ModelPackage.CONDITION__PARAMETER_EDGES:
				getParameterEdges().clear();
				getParameterEdges().addAll((Collection<? extends ParameterEdge>)newValue);
				return;
			case ModelPackage.CONDITION__EXTENDS_EDGES:
				getExtendsEdges().clear();
				getExtendsEdges().addAll((Collection<? extends ExtendsEdge>)newValue);
				return;
			case ModelPackage.CONDITION__REQUIRES_EDGES:
				getRequiresEdges().clear();
				getRequiresEdges().addAll((Collection<? extends RequiresEdge>)newValue);
				return;
			case ModelPackage.CONDITION__PROVIDES_EDGES:
				getProvidesEdges().clear();
				getProvidesEdges().addAll((Collection<? extends ProvidesEdge>)newValue);
				return;
			case ModelPackage.CONDITION__CONSTRAINT_EDGES:
				getConstraintEdges().clear();
				getConstraintEdges().addAll((Collection<? extends ConstraintEdge>)newValue);
				return;
			case ModelPackage.CONDITION__CONDITION_EDGES:
				getConditionEdges().clear();
				getConditionEdges().addAll((Collection<? extends ConditionEdge>)newValue);
				return;
			case ModelPackage.CONDITION__OUT_WIRES:
				getOutWires().clear();
				getOutWires().addAll((Collection<? extends Wire>)newValue);
				return;
			case ModelPackage.CONDITION__OUT_FLOWS:
				getOutFlows().clear();
				getOutFlows().addAll((Collection<? extends DataFlowEdge>)newValue);
				return;
			case ModelPackage.CONDITION__GENERATED_BY:
				getGeneratedBy().clear();
				getGeneratedBy().addAll((Collection<? extends GeneratesElements>)newValue);
				return;
			case ModelPackage.CONDITION__IS_GENERATED:
				setIsGenerated((Boolean)newValue);
				return;
			case ModelPackage.CONDITION__ID:
				setId((String)newValue);
				return;
			case ModelPackage.CONDITION__GENERATED_RULE:
				setGeneratedRule((String)newValue);
				return;
			case ModelPackage.CONDITION__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.CONDITION__OUT_CONDITION_EDGES:
				getOutConditionEdges().clear();
				getOutConditionEdges().addAll((Collection<? extends ConditionEdge>)newValue);
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
			case ModelPackage.CONDITION__WIRES:
				getWires().clear();
				return;
			case ModelPackage.CONDITION__PARAMETER_EDGES:
				getParameterEdges().clear();
				return;
			case ModelPackage.CONDITION__EXTENDS_EDGES:
				getExtendsEdges().clear();
				return;
			case ModelPackage.CONDITION__REQUIRES_EDGES:
				getRequiresEdges().clear();
				return;
			case ModelPackage.CONDITION__PROVIDES_EDGES:
				getProvidesEdges().clear();
				return;
			case ModelPackage.CONDITION__CONSTRAINT_EDGES:
				getConstraintEdges().clear();
				return;
			case ModelPackage.CONDITION__CONDITION_EDGES:
				getConditionEdges().clear();
				return;
			case ModelPackage.CONDITION__OUT_WIRES:
				getOutWires().clear();
				return;
			case ModelPackage.CONDITION__OUT_FLOWS:
				getOutFlows().clear();
				return;
			case ModelPackage.CONDITION__GENERATED_BY:
				getGeneratedBy().clear();
				return;
			case ModelPackage.CONDITION__IS_GENERATED:
				setIsGenerated(IS_GENERATED_EDEFAULT);
				return;
			case ModelPackage.CONDITION__ID:
				setId(ID_EDEFAULT);
				return;
			case ModelPackage.CONDITION__GENERATED_RULE:
				setGeneratedRule(GENERATED_RULE_EDEFAULT);
				return;
			case ModelPackage.CONDITION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.CONDITION__OUT_CONDITION_EDGES:
				getOutConditionEdges().clear();
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
			case ModelPackage.CONDITION__WIRES:
				return wires != null && !wires.isEmpty();
			case ModelPackage.CONDITION__PARAMETER_EDGES:
				return parameterEdges != null && !parameterEdges.isEmpty();
			case ModelPackage.CONDITION__EXTENDS_EDGES:
				return extendsEdges != null && !extendsEdges.isEmpty();
			case ModelPackage.CONDITION__REQUIRES_EDGES:
				return requiresEdges != null && !requiresEdges.isEmpty();
			case ModelPackage.CONDITION__PROVIDES_EDGES:
				return providesEdges != null && !providesEdges.isEmpty();
			case ModelPackage.CONDITION__CONSTRAINT_EDGES:
				return constraintEdges != null && !constraintEdges.isEmpty();
			case ModelPackage.CONDITION__CONDITION_EDGES:
				return conditionEdges != null && !conditionEdges.isEmpty();
			case ModelPackage.CONDITION__OUT_WIRES:
				return outWires != null && !outWires.isEmpty();
			case ModelPackage.CONDITION__OUT_FLOWS:
				return outFlows != null && !outFlows.isEmpty();
			case ModelPackage.CONDITION__GENERATED_BY:
				return generatedBy != null && !generatedBy.isEmpty();
			case ModelPackage.CONDITION__IS_GENERATED:
				return isGenerated != IS_GENERATED_EDEFAULT;
			case ModelPackage.CONDITION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ModelPackage.CONDITION__GENERATED_RULE:
				return GENERATED_RULE_EDEFAULT == null ? generatedRule != null : !GENERATED_RULE_EDEFAULT.equals(generatedRule);
			case ModelPackage.CONDITION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.CONDITION__OUT_CONDITION_EDGES:
				return outConditionEdges != null && !outConditionEdges.isEmpty();
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
		if (baseClass == DataFlowEdgesSource.class) {
			switch (derivedFeatureID) {
				case ModelPackage.CONDITION__OUT_FLOWS: return ModelPackage.DATA_FLOW_EDGES_SOURCE__OUT_FLOWS;
				default: return -1;
			}
		}
		if (baseClass == GeneratedElement.class) {
			switch (derivedFeatureID) {
				case ModelPackage.CONDITION__GENERATED_BY: return ModelPackage.GENERATED_ELEMENT__GENERATED_BY;
				case ModelPackage.CONDITION__IS_GENERATED: return ModelPackage.GENERATED_ELEMENT__IS_GENERATED;
				case ModelPackage.CONDITION__ID: return ModelPackage.GENERATED_ELEMENT__ID;
				case ModelPackage.CONDITION__GENERATED_RULE: return ModelPackage.GENERATED_ELEMENT__GENERATED_RULE;
				default: return -1;
			}
		}
		if (baseClass == NamedElement.class) {
			switch (derivedFeatureID) {
				case ModelPackage.CONDITION__NAME: return ModelPackage.NAMED_ELEMENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == ConditionEdgesSource.class) {
			switch (derivedFeatureID) {
				case ModelPackage.CONDITION__OUT_CONDITION_EDGES: return WiresPackage.CONDITION_EDGES_SOURCE__OUT_CONDITION_EDGES;
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
		if (baseClass == DataFlowEdgesSource.class) {
			switch (baseFeatureID) {
				case ModelPackage.DATA_FLOW_EDGES_SOURCE__OUT_FLOWS: return ModelPackage.CONDITION__OUT_FLOWS;
				default: return -1;
			}
		}
		if (baseClass == GeneratedElement.class) {
			switch (baseFeatureID) {
				case ModelPackage.GENERATED_ELEMENT__GENERATED_BY: return ModelPackage.CONDITION__GENERATED_BY;
				case ModelPackage.GENERATED_ELEMENT__IS_GENERATED: return ModelPackage.CONDITION__IS_GENERATED;
				case ModelPackage.GENERATED_ELEMENT__ID: return ModelPackage.CONDITION__ID;
				case ModelPackage.GENERATED_ELEMENT__GENERATED_RULE: return ModelPackage.CONDITION__GENERATED_RULE;
				default: return -1;
			}
		}
		if (baseClass == NamedElement.class) {
			switch (baseFeatureID) {
				case ModelPackage.NAMED_ELEMENT__NAME: return ModelPackage.CONDITION__NAME;
				default: return -1;
			}
		}
		if (baseClass == ConditionEdgesSource.class) {
			switch (baseFeatureID) {
				case WiresPackage.CONDITION_EDGES_SOURCE__OUT_CONDITION_EDGES: return ModelPackage.CONDITION__OUT_CONDITION_EDGES;
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
		result.append(", id: ");
		result.append(id);
		result.append(", generatedRule: ");
		result.append(generatedRule);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ConditionImpl
