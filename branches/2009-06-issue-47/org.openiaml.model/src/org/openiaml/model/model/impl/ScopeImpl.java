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
import org.openiaml.model.model.DerivedView;
import org.openiaml.model.model.DomainObject;
import org.openiaml.model.model.DomainObjectInstance;
import org.openiaml.model.model.GeneratedElement;
import org.openiaml.model.model.ModelPackage;
import org.openiaml.model.model.Scope;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scope</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.openiaml.model.model.impl.ScopeImpl#getGeneratedElements <em>Generated Elements</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.ScopeImpl#isOverridden <em>Overridden</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.ScopeImpl#getDomainObjects <em>Domain Objects</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.ScopeImpl#getDomainViews <em>Domain Views</em>}</li>
 *   <li>{@link org.openiaml.model.model.impl.ScopeImpl#getDomainInstances <em>Domain Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ScopeImpl extends EObjectImpl implements Scope {
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
	 * The cached value of the '{@link #getDomainObjects() <em>Domain Objects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainObjects()
	 * @generated
	 * @ordered
	 */
	protected EList<DomainObject> domainObjects;

	/**
	 * The cached value of the '{@link #getDomainViews() <em>Domain Views</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainViews()
	 * @generated
	 * @ordered
	 */
	protected EList<DerivedView> domainViews;

	/**
	 * The cached value of the '{@link #getDomainInstances() <em>Domain Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<DomainObjectInstance> domainInstances;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScopeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.SCOPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GeneratedElement> getGeneratedElements() {
		if (generatedElements == null) {
			generatedElements = new EObjectWithInverseResolvingEList<GeneratedElement>(GeneratedElement.class, this, ModelPackage.SCOPE__GENERATED_ELEMENTS, ModelPackage.GENERATED_ELEMENT__GENERATED_BY);
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SCOPE__OVERRIDDEN, oldOverridden, overridden));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DomainObject> getDomainObjects() {
		if (domainObjects == null) {
			domainObjects = new EObjectContainmentEList<DomainObject>(DomainObject.class, this, ModelPackage.SCOPE__DOMAIN_OBJECTS);
		}
		return domainObjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DerivedView> getDomainViews() {
		if (domainViews == null) {
			domainViews = new EObjectContainmentEList<DerivedView>(DerivedView.class, this, ModelPackage.SCOPE__DOMAIN_VIEWS);
		}
		return domainViews;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DomainObjectInstance> getDomainInstances() {
		if (domainInstances == null) {
			domainInstances = new EObjectContainmentEList<DomainObjectInstance>(DomainObjectInstance.class, this, ModelPackage.SCOPE__DOMAIN_INSTANCES);
		}
		return domainInstances;
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
			case ModelPackage.SCOPE__GENERATED_ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGeneratedElements()).basicAdd(otherEnd, msgs);
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
			case ModelPackage.SCOPE__GENERATED_ELEMENTS:
				return ((InternalEList<?>)getGeneratedElements()).basicRemove(otherEnd, msgs);
			case ModelPackage.SCOPE__DOMAIN_OBJECTS:
				return ((InternalEList<?>)getDomainObjects()).basicRemove(otherEnd, msgs);
			case ModelPackage.SCOPE__DOMAIN_VIEWS:
				return ((InternalEList<?>)getDomainViews()).basicRemove(otherEnd, msgs);
			case ModelPackage.SCOPE__DOMAIN_INSTANCES:
				return ((InternalEList<?>)getDomainInstances()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.SCOPE__GENERATED_ELEMENTS:
				return getGeneratedElements();
			case ModelPackage.SCOPE__OVERRIDDEN:
				return isOverridden() ? Boolean.TRUE : Boolean.FALSE;
			case ModelPackage.SCOPE__DOMAIN_OBJECTS:
				return getDomainObjects();
			case ModelPackage.SCOPE__DOMAIN_VIEWS:
				return getDomainViews();
			case ModelPackage.SCOPE__DOMAIN_INSTANCES:
				return getDomainInstances();
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
			case ModelPackage.SCOPE__GENERATED_ELEMENTS:
				getGeneratedElements().clear();
				getGeneratedElements().addAll((Collection<? extends GeneratedElement>)newValue);
				return;
			case ModelPackage.SCOPE__OVERRIDDEN:
				setOverridden(((Boolean)newValue).booleanValue());
				return;
			case ModelPackage.SCOPE__DOMAIN_OBJECTS:
				getDomainObjects().clear();
				getDomainObjects().addAll((Collection<? extends DomainObject>)newValue);
				return;
			case ModelPackage.SCOPE__DOMAIN_VIEWS:
				getDomainViews().clear();
				getDomainViews().addAll((Collection<? extends DerivedView>)newValue);
				return;
			case ModelPackage.SCOPE__DOMAIN_INSTANCES:
				getDomainInstances().clear();
				getDomainInstances().addAll((Collection<? extends DomainObjectInstance>)newValue);
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
			case ModelPackage.SCOPE__GENERATED_ELEMENTS:
				getGeneratedElements().clear();
				return;
			case ModelPackage.SCOPE__OVERRIDDEN:
				setOverridden(OVERRIDDEN_EDEFAULT);
				return;
			case ModelPackage.SCOPE__DOMAIN_OBJECTS:
				getDomainObjects().clear();
				return;
			case ModelPackage.SCOPE__DOMAIN_VIEWS:
				getDomainViews().clear();
				return;
			case ModelPackage.SCOPE__DOMAIN_INSTANCES:
				getDomainInstances().clear();
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
			case ModelPackage.SCOPE__GENERATED_ELEMENTS:
				return generatedElements != null && !generatedElements.isEmpty();
			case ModelPackage.SCOPE__OVERRIDDEN:
				return overridden != OVERRIDDEN_EDEFAULT;
			case ModelPackage.SCOPE__DOMAIN_OBJECTS:
				return domainObjects != null && !domainObjects.isEmpty();
			case ModelPackage.SCOPE__DOMAIN_VIEWS:
				return domainViews != null && !domainViews.isEmpty();
			case ModelPackage.SCOPE__DOMAIN_INSTANCES:
				return domainInstances != null && !domainInstances.isEmpty();
		}
		return super.eIsSet(featureID);
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
		result.append(" (overridden: ");
		result.append(overridden);
		result.append(')');
		return result.toString();
	}

} //ScopeImpl
