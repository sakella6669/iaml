/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openiaml.model.model.components.impl;

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
import org.openiaml.model.model.Action;
import org.openiaml.model.model.ContainsWires;
import org.openiaml.model.model.GeneratedElement;
import org.openiaml.model.model.GeneratesElements;
import org.openiaml.model.model.ModelPackage;
import org.openiaml.model.model.ShouldntContainWires;
import org.openiaml.model.model.Wire;
import org.openiaml.model.model.WireDestination;
import org.openiaml.model.model.WireSource;
import org.openiaml.model.model.components.ComponentsPackage;
import org.openiaml.model.model.components.Gate;
import org.openiaml.model.model.wires.ConditionEdge;
import org.openiaml.model.model.wires.ConditionEdgeDestination;
import org.openiaml.model.model.wires.ConstraintEdge;
import org.openiaml.model.model.wires.ExtendsEdge;
import org.openiaml.model.model.wires.ParameterEdge;
import org.openiaml.model.model.wires.ProvidesEdge;
import org.openiaml.model.model.wires.RequiresEdge;
import org.openiaml.model.model.wires.WiresPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.openiaml.model.model.components.impl.GateImpl#getGeneratedBy <em>Generated By</em>}</li>
 *   <li>{@link org.openiaml.model.model.components.impl.GateImpl#isIsGenerated <em>Is Generated</em>}</li>
 *   <li>{@link org.openiaml.model.model.components.impl.GateImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.openiaml.model.model.components.impl.GateImpl#getGeneratedRule <em>Generated Rule</em>}</li>
 *   <li>{@link org.openiaml.model.model.components.impl.GateImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.openiaml.model.model.components.impl.GateImpl#getWires <em>Wires</em>}</li>
 *   <li>{@link org.openiaml.model.model.components.impl.GateImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link org.openiaml.model.model.components.impl.GateImpl#getParameterEdges <em>Parameter Edges</em>}</li>
 *   <li>{@link org.openiaml.model.model.components.impl.GateImpl#getExtendsEdges <em>Extends Edges</em>}</li>
 *   <li>{@link org.openiaml.model.model.components.impl.GateImpl#getRequiresEdges <em>Requires Edges</em>}</li>
 *   <li>{@link org.openiaml.model.model.components.impl.GateImpl#getProvidesEdges <em>Provides Edges</em>}</li>
 *   <li>{@link org.openiaml.model.model.components.impl.GateImpl#getConstraintEdges <em>Constraint Edges</em>}</li>
 *   <li>{@link org.openiaml.model.model.components.impl.GateImpl#getConditionEdges <em>Condition Edges</em>}</li>
 *   <li>{@link org.openiaml.model.model.components.impl.GateImpl#getOutWires <em>Out Wires</em>}</li>
 *   <li>{@link org.openiaml.model.model.components.impl.GateImpl#getInWires <em>In Wires</em>}</li>
 *   <li>{@link org.openiaml.model.model.components.impl.GateImpl#getGeneratedElements <em>Generated Elements</em>}</li>
 *   <li>{@link org.openiaml.model.model.components.impl.GateImpl#isOverridden <em>Overridden</em>}</li>
 *   <li>{@link org.openiaml.model.model.components.impl.GateImpl#getInConditionEdges <em>In Condition Edges</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class GateImpl extends EObjectImpl implements Gate {
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
	 * The cached value of the '{@link #getWires() <em>Wires</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWires()
	 * @generated
	 * @ordered
	 */
	protected EList<Wire> wires;

	/**
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> actions;

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
	 * The cached value of the '{@link #getInWires() <em>In Wires</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInWires()
	 * @generated
	 * @ordered
	 */
	protected EList<Wire> inWires;

	/**
	 * The cached value of the '{@link #getGeneratedElements() <em>Generated Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneratedElements()
	 * @generated
	 * @ordered
	 */
	protected EList<GeneratedElement> generatedElements;

	/**
	 * The default value of the '{@link #isOverridden() <em>Overridden</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOverridden()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OVERRIDDEN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOverridden() <em>Overridden</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOverridden()
	 * @generated
	 * @ordered
	 */
	protected boolean overridden = OVERRIDDEN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInConditionEdges() <em>In Condition Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInConditionEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<ConditionEdge> inConditionEdges;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentsPackage.Literals.GATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GeneratesElements> getGeneratedBy() {
		if (generatedBy == null) {
			generatedBy = new EObjectWithInverseResolvingEList.ManyInverse<GeneratesElements>(GeneratesElements.class, this, ComponentsPackage.GATE__GENERATED_BY, ModelPackage.GENERATES_ELEMENTS__GENERATED_ELEMENTS);
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.GATE__IS_GENERATED, oldIsGenerated, isGenerated));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.GATE__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.GATE__GENERATED_RULE, oldGeneratedRule, generatedRule));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.GATE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Wire> getWires() {
		if (wires == null) {
			wires = new EObjectContainmentEList<Wire>(Wire.class, this, ComponentsPackage.GATE__WIRES);
		}
		return wires;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Action> getActions() {
		if (actions == null) {
			actions = new EObjectContainmentEList<Action>(Action.class, this, ComponentsPackage.GATE__ACTIONS);
		}
		return actions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterEdge> getParameterEdges() {
		if (parameterEdges == null) {
			parameterEdges = new EObjectContainmentEList<ParameterEdge>(ParameterEdge.class, this, ComponentsPackage.GATE__PARAMETER_EDGES);
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
			extendsEdges = new EObjectContainmentEList<ExtendsEdge>(ExtendsEdge.class, this, ComponentsPackage.GATE__EXTENDS_EDGES);
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
			requiresEdges = new EObjectContainmentEList<RequiresEdge>(RequiresEdge.class, this, ComponentsPackage.GATE__REQUIRES_EDGES);
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
			providesEdges = new EObjectContainmentEList<ProvidesEdge>(ProvidesEdge.class, this, ComponentsPackage.GATE__PROVIDES_EDGES);
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
			constraintEdges = new EObjectContainmentEList<ConstraintEdge>(ConstraintEdge.class, this, ComponentsPackage.GATE__CONSTRAINT_EDGES);
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
			conditionEdges = new EObjectContainmentEList<ConditionEdge>(ConditionEdge.class, this, ComponentsPackage.GATE__CONDITION_EDGES);
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
			outWires = new EObjectWithInverseResolvingEList<Wire>(Wire.class, this, ComponentsPackage.GATE__OUT_WIRES, ModelPackage.WIRE__FROM);
		}
		return outWires;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Wire> getInWires() {
		if (inWires == null) {
			inWires = new EObjectWithInverseResolvingEList<Wire>(Wire.class, this, ComponentsPackage.GATE__IN_WIRES, ModelPackage.WIRE__TO);
		}
		return inWires;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GeneratedElement> getGeneratedElements() {
		if (generatedElements == null) {
			generatedElements = new EObjectWithInverseResolvingEList.ManyInverse<GeneratedElement>(GeneratedElement.class, this, ComponentsPackage.GATE__GENERATED_ELEMENTS, ModelPackage.GENERATED_ELEMENT__GENERATED_BY);
		}
		return generatedElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOverridden() {
		return overridden;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverridden(boolean newOverridden) {
		boolean oldOverridden = overridden;
		overridden = newOverridden;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.GATE__OVERRIDDEN, oldOverridden, overridden));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConditionEdge> getInConditionEdges() {
		if (inConditionEdges == null) {
			inConditionEdges = new EObjectWithInverseResolvingEList<ConditionEdge>(ConditionEdge.class, this, ComponentsPackage.GATE__IN_CONDITION_EDGES, WiresPackage.CONDITION_EDGE__TO);
		}
		return inConditionEdges;
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
			case ComponentsPackage.GATE__GENERATED_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGeneratedBy()).basicAdd(otherEnd, msgs);
			case ComponentsPackage.GATE__OUT_WIRES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutWires()).basicAdd(otherEnd, msgs);
			case ComponentsPackage.GATE__IN_WIRES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInWires()).basicAdd(otherEnd, msgs);
			case ComponentsPackage.GATE__GENERATED_ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGeneratedElements()).basicAdd(otherEnd, msgs);
			case ComponentsPackage.GATE__IN_CONDITION_EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInConditionEdges()).basicAdd(otherEnd, msgs);
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
			case ComponentsPackage.GATE__GENERATED_BY:
				return ((InternalEList<?>)getGeneratedBy()).basicRemove(otherEnd, msgs);
			case ComponentsPackage.GATE__WIRES:
				return ((InternalEList<?>)getWires()).basicRemove(otherEnd, msgs);
			case ComponentsPackage.GATE__ACTIONS:
				return ((InternalEList<?>)getActions()).basicRemove(otherEnd, msgs);
			case ComponentsPackage.GATE__PARAMETER_EDGES:
				return ((InternalEList<?>)getParameterEdges()).basicRemove(otherEnd, msgs);
			case ComponentsPackage.GATE__EXTENDS_EDGES:
				return ((InternalEList<?>)getExtendsEdges()).basicRemove(otherEnd, msgs);
			case ComponentsPackage.GATE__REQUIRES_EDGES:
				return ((InternalEList<?>)getRequiresEdges()).basicRemove(otherEnd, msgs);
			case ComponentsPackage.GATE__PROVIDES_EDGES:
				return ((InternalEList<?>)getProvidesEdges()).basicRemove(otherEnd, msgs);
			case ComponentsPackage.GATE__CONSTRAINT_EDGES:
				return ((InternalEList<?>)getConstraintEdges()).basicRemove(otherEnd, msgs);
			case ComponentsPackage.GATE__CONDITION_EDGES:
				return ((InternalEList<?>)getConditionEdges()).basicRemove(otherEnd, msgs);
			case ComponentsPackage.GATE__OUT_WIRES:
				return ((InternalEList<?>)getOutWires()).basicRemove(otherEnd, msgs);
			case ComponentsPackage.GATE__IN_WIRES:
				return ((InternalEList<?>)getInWires()).basicRemove(otherEnd, msgs);
			case ComponentsPackage.GATE__GENERATED_ELEMENTS:
				return ((InternalEList<?>)getGeneratedElements()).basicRemove(otherEnd, msgs);
			case ComponentsPackage.GATE__IN_CONDITION_EDGES:
				return ((InternalEList<?>)getInConditionEdges()).basicRemove(otherEnd, msgs);
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
			case ComponentsPackage.GATE__GENERATED_BY:
				return getGeneratedBy();
			case ComponentsPackage.GATE__IS_GENERATED:
				return isIsGenerated();
			case ComponentsPackage.GATE__ID:
				return getId();
			case ComponentsPackage.GATE__GENERATED_RULE:
				return getGeneratedRule();
			case ComponentsPackage.GATE__NAME:
				return getName();
			case ComponentsPackage.GATE__WIRES:
				return getWires();
			case ComponentsPackage.GATE__ACTIONS:
				return getActions();
			case ComponentsPackage.GATE__PARAMETER_EDGES:
				return getParameterEdges();
			case ComponentsPackage.GATE__EXTENDS_EDGES:
				return getExtendsEdges();
			case ComponentsPackage.GATE__REQUIRES_EDGES:
				return getRequiresEdges();
			case ComponentsPackage.GATE__PROVIDES_EDGES:
				return getProvidesEdges();
			case ComponentsPackage.GATE__CONSTRAINT_EDGES:
				return getConstraintEdges();
			case ComponentsPackage.GATE__CONDITION_EDGES:
				return getConditionEdges();
			case ComponentsPackage.GATE__OUT_WIRES:
				return getOutWires();
			case ComponentsPackage.GATE__IN_WIRES:
				return getInWires();
			case ComponentsPackage.GATE__GENERATED_ELEMENTS:
				return getGeneratedElements();
			case ComponentsPackage.GATE__OVERRIDDEN:
				return isOverridden();
			case ComponentsPackage.GATE__IN_CONDITION_EDGES:
				return getInConditionEdges();
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
			case ComponentsPackage.GATE__GENERATED_BY:
				getGeneratedBy().clear();
				getGeneratedBy().addAll((Collection<? extends GeneratesElements>)newValue);
				return;
			case ComponentsPackage.GATE__IS_GENERATED:
				setIsGenerated((Boolean)newValue);
				return;
			case ComponentsPackage.GATE__ID:
				setId((String)newValue);
				return;
			case ComponentsPackage.GATE__GENERATED_RULE:
				setGeneratedRule((String)newValue);
				return;
			case ComponentsPackage.GATE__NAME:
				setName((String)newValue);
				return;
			case ComponentsPackage.GATE__WIRES:
				getWires().clear();
				getWires().addAll((Collection<? extends Wire>)newValue);
				return;
			case ComponentsPackage.GATE__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends Action>)newValue);
				return;
			case ComponentsPackage.GATE__PARAMETER_EDGES:
				getParameterEdges().clear();
				getParameterEdges().addAll((Collection<? extends ParameterEdge>)newValue);
				return;
			case ComponentsPackage.GATE__EXTENDS_EDGES:
				getExtendsEdges().clear();
				getExtendsEdges().addAll((Collection<? extends ExtendsEdge>)newValue);
				return;
			case ComponentsPackage.GATE__REQUIRES_EDGES:
				getRequiresEdges().clear();
				getRequiresEdges().addAll((Collection<? extends RequiresEdge>)newValue);
				return;
			case ComponentsPackage.GATE__PROVIDES_EDGES:
				getProvidesEdges().clear();
				getProvidesEdges().addAll((Collection<? extends ProvidesEdge>)newValue);
				return;
			case ComponentsPackage.GATE__CONSTRAINT_EDGES:
				getConstraintEdges().clear();
				getConstraintEdges().addAll((Collection<? extends ConstraintEdge>)newValue);
				return;
			case ComponentsPackage.GATE__CONDITION_EDGES:
				getConditionEdges().clear();
				getConditionEdges().addAll((Collection<? extends ConditionEdge>)newValue);
				return;
			case ComponentsPackage.GATE__OUT_WIRES:
				getOutWires().clear();
				getOutWires().addAll((Collection<? extends Wire>)newValue);
				return;
			case ComponentsPackage.GATE__IN_WIRES:
				getInWires().clear();
				getInWires().addAll((Collection<? extends Wire>)newValue);
				return;
			case ComponentsPackage.GATE__GENERATED_ELEMENTS:
				getGeneratedElements().clear();
				getGeneratedElements().addAll((Collection<? extends GeneratedElement>)newValue);
				return;
			case ComponentsPackage.GATE__OVERRIDDEN:
				setOverridden((Boolean)newValue);
				return;
			case ComponentsPackage.GATE__IN_CONDITION_EDGES:
				getInConditionEdges().clear();
				getInConditionEdges().addAll((Collection<? extends ConditionEdge>)newValue);
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
			case ComponentsPackage.GATE__GENERATED_BY:
				getGeneratedBy().clear();
				return;
			case ComponentsPackage.GATE__IS_GENERATED:
				setIsGenerated(IS_GENERATED_EDEFAULT);
				return;
			case ComponentsPackage.GATE__ID:
				setId(ID_EDEFAULT);
				return;
			case ComponentsPackage.GATE__GENERATED_RULE:
				setGeneratedRule(GENERATED_RULE_EDEFAULT);
				return;
			case ComponentsPackage.GATE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ComponentsPackage.GATE__WIRES:
				getWires().clear();
				return;
			case ComponentsPackage.GATE__ACTIONS:
				getActions().clear();
				return;
			case ComponentsPackage.GATE__PARAMETER_EDGES:
				getParameterEdges().clear();
				return;
			case ComponentsPackage.GATE__EXTENDS_EDGES:
				getExtendsEdges().clear();
				return;
			case ComponentsPackage.GATE__REQUIRES_EDGES:
				getRequiresEdges().clear();
				return;
			case ComponentsPackage.GATE__PROVIDES_EDGES:
				getProvidesEdges().clear();
				return;
			case ComponentsPackage.GATE__CONSTRAINT_EDGES:
				getConstraintEdges().clear();
				return;
			case ComponentsPackage.GATE__CONDITION_EDGES:
				getConditionEdges().clear();
				return;
			case ComponentsPackage.GATE__OUT_WIRES:
				getOutWires().clear();
				return;
			case ComponentsPackage.GATE__IN_WIRES:
				getInWires().clear();
				return;
			case ComponentsPackage.GATE__GENERATED_ELEMENTS:
				getGeneratedElements().clear();
				return;
			case ComponentsPackage.GATE__OVERRIDDEN:
				setOverridden(OVERRIDDEN_EDEFAULT);
				return;
			case ComponentsPackage.GATE__IN_CONDITION_EDGES:
				getInConditionEdges().clear();
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
			case ComponentsPackage.GATE__GENERATED_BY:
				return generatedBy != null && !generatedBy.isEmpty();
			case ComponentsPackage.GATE__IS_GENERATED:
				return isGenerated != IS_GENERATED_EDEFAULT;
			case ComponentsPackage.GATE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ComponentsPackage.GATE__GENERATED_RULE:
				return GENERATED_RULE_EDEFAULT == null ? generatedRule != null : !GENERATED_RULE_EDEFAULT.equals(generatedRule);
			case ComponentsPackage.GATE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ComponentsPackage.GATE__WIRES:
				return wires != null && !wires.isEmpty();
			case ComponentsPackage.GATE__ACTIONS:
				return actions != null && !actions.isEmpty();
			case ComponentsPackage.GATE__PARAMETER_EDGES:
				return parameterEdges != null && !parameterEdges.isEmpty();
			case ComponentsPackage.GATE__EXTENDS_EDGES:
				return extendsEdges != null && !extendsEdges.isEmpty();
			case ComponentsPackage.GATE__REQUIRES_EDGES:
				return requiresEdges != null && !requiresEdges.isEmpty();
			case ComponentsPackage.GATE__PROVIDES_EDGES:
				return providesEdges != null && !providesEdges.isEmpty();
			case ComponentsPackage.GATE__CONSTRAINT_EDGES:
				return constraintEdges != null && !constraintEdges.isEmpty();
			case ComponentsPackage.GATE__CONDITION_EDGES:
				return conditionEdges != null && !conditionEdges.isEmpty();
			case ComponentsPackage.GATE__OUT_WIRES:
				return outWires != null && !outWires.isEmpty();
			case ComponentsPackage.GATE__IN_WIRES:
				return inWires != null && !inWires.isEmpty();
			case ComponentsPackage.GATE__GENERATED_ELEMENTS:
				return generatedElements != null && !generatedElements.isEmpty();
			case ComponentsPackage.GATE__OVERRIDDEN:
				return overridden != OVERRIDDEN_EDEFAULT;
			case ComponentsPackage.GATE__IN_CONDITION_EDGES:
				return inConditionEdges != null && !inConditionEdges.isEmpty();
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
				case ComponentsPackage.GATE__WIRES: return ModelPackage.CONTAINS_WIRES__WIRES;
				case ComponentsPackage.GATE__ACTIONS: return ModelPackage.CONTAINS_WIRES__ACTIONS;
				case ComponentsPackage.GATE__PARAMETER_EDGES: return ModelPackage.CONTAINS_WIRES__PARAMETER_EDGES;
				case ComponentsPackage.GATE__EXTENDS_EDGES: return ModelPackage.CONTAINS_WIRES__EXTENDS_EDGES;
				case ComponentsPackage.GATE__REQUIRES_EDGES: return ModelPackage.CONTAINS_WIRES__REQUIRES_EDGES;
				case ComponentsPackage.GATE__PROVIDES_EDGES: return ModelPackage.CONTAINS_WIRES__PROVIDES_EDGES;
				case ComponentsPackage.GATE__CONSTRAINT_EDGES: return ModelPackage.CONTAINS_WIRES__CONSTRAINT_EDGES;
				case ComponentsPackage.GATE__CONDITION_EDGES: return ModelPackage.CONTAINS_WIRES__CONDITION_EDGES;
				default: return -1;
			}
		}
		if (baseClass == ShouldntContainWires.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == WireSource.class) {
			switch (derivedFeatureID) {
				case ComponentsPackage.GATE__OUT_WIRES: return ModelPackage.WIRE_SOURCE__OUT_WIRES;
				default: return -1;
			}
		}
		if (baseClass == WireDestination.class) {
			switch (derivedFeatureID) {
				case ComponentsPackage.GATE__IN_WIRES: return ModelPackage.WIRE_DESTINATION__IN_WIRES;
				default: return -1;
			}
		}
		if (baseClass == GeneratesElements.class) {
			switch (derivedFeatureID) {
				case ComponentsPackage.GATE__GENERATED_ELEMENTS: return ModelPackage.GENERATES_ELEMENTS__GENERATED_ELEMENTS;
				case ComponentsPackage.GATE__OVERRIDDEN: return ModelPackage.GENERATES_ELEMENTS__OVERRIDDEN;
				default: return -1;
			}
		}
		if (baseClass == ConditionEdgeDestination.class) {
			switch (derivedFeatureID) {
				case ComponentsPackage.GATE__IN_CONDITION_EDGES: return WiresPackage.CONDITION_EDGE_DESTINATION__IN_CONDITION_EDGES;
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
				case ModelPackage.CONTAINS_WIRES__WIRES: return ComponentsPackage.GATE__WIRES;
				case ModelPackage.CONTAINS_WIRES__ACTIONS: return ComponentsPackage.GATE__ACTIONS;
				case ModelPackage.CONTAINS_WIRES__PARAMETER_EDGES: return ComponentsPackage.GATE__PARAMETER_EDGES;
				case ModelPackage.CONTAINS_WIRES__EXTENDS_EDGES: return ComponentsPackage.GATE__EXTENDS_EDGES;
				case ModelPackage.CONTAINS_WIRES__REQUIRES_EDGES: return ComponentsPackage.GATE__REQUIRES_EDGES;
				case ModelPackage.CONTAINS_WIRES__PROVIDES_EDGES: return ComponentsPackage.GATE__PROVIDES_EDGES;
				case ModelPackage.CONTAINS_WIRES__CONSTRAINT_EDGES: return ComponentsPackage.GATE__CONSTRAINT_EDGES;
				case ModelPackage.CONTAINS_WIRES__CONDITION_EDGES: return ComponentsPackage.GATE__CONDITION_EDGES;
				default: return -1;
			}
		}
		if (baseClass == ShouldntContainWires.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == WireSource.class) {
			switch (baseFeatureID) {
				case ModelPackage.WIRE_SOURCE__OUT_WIRES: return ComponentsPackage.GATE__OUT_WIRES;
				default: return -1;
			}
		}
		if (baseClass == WireDestination.class) {
			switch (baseFeatureID) {
				case ModelPackage.WIRE_DESTINATION__IN_WIRES: return ComponentsPackage.GATE__IN_WIRES;
				default: return -1;
			}
		}
		if (baseClass == GeneratesElements.class) {
			switch (baseFeatureID) {
				case ModelPackage.GENERATES_ELEMENTS__GENERATED_ELEMENTS: return ComponentsPackage.GATE__GENERATED_ELEMENTS;
				case ModelPackage.GENERATES_ELEMENTS__OVERRIDDEN: return ComponentsPackage.GATE__OVERRIDDEN;
				default: return -1;
			}
		}
		if (baseClass == ConditionEdgeDestination.class) {
			switch (baseFeatureID) {
				case WiresPackage.CONDITION_EDGE_DESTINATION__IN_CONDITION_EDGES: return ComponentsPackage.GATE__IN_CONDITION_EDGES;
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
		result.append(", overridden: ");
		result.append(overridden);
		result.append(')');
		return result.toString();
	}

} //GateImpl
