/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openiaml.model.model.domain;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.openiaml.model.model.ModelPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.openiaml.model.model.domain.DomainFactory
 * @model kind="package"
 *        annotation="http://openiaml.org/comment added='0.2'"
 * @generated
 */
public interface DomainPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "domain";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://openiaml.org/model/domain";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "iaml.domain";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DomainPackage eINSTANCE = org.openiaml.model.model.domain.impl.DomainPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.openiaml.model.model.domain.impl.AbstractDomainStoreImpl <em>Abstract Domain Store</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.openiaml.model.model.domain.impl.AbstractDomainStoreImpl
	 * @see org.openiaml.model.model.domain.impl.DomainPackageImpl#getAbstractDomainStore()
	 * @generated
	 */
	int ABSTRACT_DOMAIN_STORE = 0;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_STORE__OPERATIONS = ModelPackage.CONTAINS_OPERATIONS__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Event Triggers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_STORE__EVENT_TRIGGERS = ModelPackage.CONTAINS_OPERATIONS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Generated By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_STORE__GENERATED_BY = ModelPackage.CONTAINS_OPERATIONS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_STORE__IS_GENERATED = ModelPackage.CONTAINS_OPERATIONS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_STORE__ID = ModelPackage.CONTAINS_OPERATIONS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Generated Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_STORE__GENERATED_RULE = ModelPackage.CONTAINS_OPERATIONS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_STORE__NAME = ModelPackage.CONTAINS_OPERATIONS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Wires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_STORE__WIRES = ModelPackage.CONTAINS_OPERATIONS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Generated Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_STORE__GENERATED_ELEMENTS = ModelPackage.CONTAINS_OPERATIONS_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Overridden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_STORE__OVERRIDDEN = ModelPackage.CONTAINS_OPERATIONS_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_STORE__CHILDREN = ModelPackage.CONTAINS_OPERATIONS_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_STORE__PROPERTIES = ModelPackage.CONTAINS_OPERATIONS_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Views</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_STORE__VIEWS = ModelPackage.CONTAINS_OPERATIONS_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Abstract Domain Store</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_STORE_FEATURE_COUNT = ModelPackage.CONTAINS_OPERATIONS_FEATURE_COUNT + 12;

	/**
	 * The meta object id for the '{@link org.openiaml.model.model.domain.impl.AbstractDomainObjectImpl <em>Abstract Domain Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.openiaml.model.model.domain.impl.AbstractDomainObjectImpl
	 * @see org.openiaml.model.model.domain.impl.DomainPackageImpl#getAbstractDomainObject()
	 * @generated
	 */
	int ABSTRACT_DOMAIN_OBJECT = 1;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_OBJECT__OPERATIONS = ModelPackage.APPLICATION_ELEMENT__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Generated By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_OBJECT__GENERATED_BY = ModelPackage.APPLICATION_ELEMENT__GENERATED_BY;

	/**
	 * The feature id for the '<em><b>Is Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_OBJECT__IS_GENERATED = ModelPackage.APPLICATION_ELEMENT__IS_GENERATED;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_OBJECT__ID = ModelPackage.APPLICATION_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Generated Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_OBJECT__GENERATED_RULE = ModelPackage.APPLICATION_ELEMENT__GENERATED_RULE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_OBJECT__NAME = ModelPackage.APPLICATION_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Event Triggers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_OBJECT__EVENT_TRIGGERS = ModelPackage.APPLICATION_ELEMENT__EVENT_TRIGGERS;

	/**
	 * The feature id for the '<em><b>Wires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_OBJECT__WIRES = ModelPackage.APPLICATION_ELEMENT__WIRES;

	/**
	 * The feature id for the '<em><b>Out Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_OBJECT__OUT_EDGES = ModelPackage.APPLICATION_ELEMENT__OUT_EDGES;

	/**
	 * The feature id for the '<em><b>In Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_OBJECT__IN_EDGES = ModelPackage.APPLICATION_ELEMENT__IN_EDGES;

	/**
	 * The feature id for the '<em><b>Generated Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_OBJECT__GENERATED_ELEMENTS = ModelPackage.APPLICATION_ELEMENT__GENERATED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Overridden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_OBJECT__OVERRIDDEN = ModelPackage.APPLICATION_ELEMENT__OVERRIDDEN;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_OBJECT__CONDITIONS = ModelPackage.APPLICATION_ELEMENT__CONDITIONS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_OBJECT__PROPERTIES = ModelPackage.APPLICATION_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_OBJECT__VALUES = ModelPackage.APPLICATION_ELEMENT__VALUES;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_OBJECT__ATTRIBUTES = ModelPackage.APPLICATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Domain Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_OBJECT_FEATURE_COUNT = ModelPackage.APPLICATION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.openiaml.model.model.domain.impl.AbstractDomainAttributeImpl <em>Abstract Domain Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.openiaml.model.model.domain.impl.AbstractDomainAttributeImpl
	 * @see org.openiaml.model.model.domain.impl.DomainPackageImpl#getAbstractDomainAttribute()
	 * @generated
	 */
	int ABSTRACT_DOMAIN_ATTRIBUTE = 2;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_ATTRIBUTE__OPERATIONS = ModelPackage.APPLICATION_ELEMENT__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Generated By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_ATTRIBUTE__GENERATED_BY = ModelPackage.APPLICATION_ELEMENT__GENERATED_BY;

	/**
	 * The feature id for the '<em><b>Is Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_ATTRIBUTE__IS_GENERATED = ModelPackage.APPLICATION_ELEMENT__IS_GENERATED;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_ATTRIBUTE__ID = ModelPackage.APPLICATION_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Generated Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_ATTRIBUTE__GENERATED_RULE = ModelPackage.APPLICATION_ELEMENT__GENERATED_RULE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_ATTRIBUTE__NAME = ModelPackage.APPLICATION_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Event Triggers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_ATTRIBUTE__EVENT_TRIGGERS = ModelPackage.APPLICATION_ELEMENT__EVENT_TRIGGERS;

	/**
	 * The feature id for the '<em><b>Wires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_ATTRIBUTE__WIRES = ModelPackage.APPLICATION_ELEMENT__WIRES;

	/**
	 * The feature id for the '<em><b>Out Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_ATTRIBUTE__OUT_EDGES = ModelPackage.APPLICATION_ELEMENT__OUT_EDGES;

	/**
	 * The feature id for the '<em><b>In Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_ATTRIBUTE__IN_EDGES = ModelPackage.APPLICATION_ELEMENT__IN_EDGES;

	/**
	 * The feature id for the '<em><b>Generated Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_ATTRIBUTE__GENERATED_ELEMENTS = ModelPackage.APPLICATION_ELEMENT__GENERATED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Overridden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_ATTRIBUTE__OVERRIDDEN = ModelPackage.APPLICATION_ELEMENT__OVERRIDDEN;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_ATTRIBUTE__CONDITIONS = ModelPackage.APPLICATION_ELEMENT__CONDITIONS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_ATTRIBUTE__PROPERTIES = ModelPackage.APPLICATION_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_ATTRIBUTE__VALUES = ModelPackage.APPLICATION_ELEMENT__VALUES;

	/**
	 * The number of structural features of the '<em>Abstract Domain Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DOMAIN_ATTRIBUTE_FEATURE_COUNT = ModelPackage.APPLICATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.openiaml.model.model.domain.impl.FileDomainStoreImpl <em>File Domain Store</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.openiaml.model.model.domain.impl.FileDomainStoreImpl
	 * @see org.openiaml.model.model.domain.impl.DomainPackageImpl#getFileDomainStore()
	 * @generated
	 */
	int FILE_DOMAIN_STORE = 3;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_STORE__OPERATIONS = ABSTRACT_DOMAIN_STORE__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Event Triggers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_STORE__EVENT_TRIGGERS = ABSTRACT_DOMAIN_STORE__EVENT_TRIGGERS;

	/**
	 * The feature id for the '<em><b>Generated By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_STORE__GENERATED_BY = ABSTRACT_DOMAIN_STORE__GENERATED_BY;

	/**
	 * The feature id for the '<em><b>Is Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_STORE__IS_GENERATED = ABSTRACT_DOMAIN_STORE__IS_GENERATED;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_STORE__ID = ABSTRACT_DOMAIN_STORE__ID;

	/**
	 * The feature id for the '<em><b>Generated Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_STORE__GENERATED_RULE = ABSTRACT_DOMAIN_STORE__GENERATED_RULE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_STORE__NAME = ABSTRACT_DOMAIN_STORE__NAME;

	/**
	 * The feature id for the '<em><b>Wires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_STORE__WIRES = ABSTRACT_DOMAIN_STORE__WIRES;

	/**
	 * The feature id for the '<em><b>Generated Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_STORE__GENERATED_ELEMENTS = ABSTRACT_DOMAIN_STORE__GENERATED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Overridden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_STORE__OVERRIDDEN = ABSTRACT_DOMAIN_STORE__OVERRIDDEN;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_STORE__CHILDREN = ABSTRACT_DOMAIN_STORE__CHILDREN;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_STORE__PROPERTIES = ABSTRACT_DOMAIN_STORE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Views</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_STORE__VIEWS = ABSTRACT_DOMAIN_STORE__VIEWS;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_STORE__FILE = ABSTRACT_DOMAIN_STORE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>File Domain Store</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_STORE_FEATURE_COUNT = ABSTRACT_DOMAIN_STORE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.openiaml.model.model.domain.impl.FileDomainObjectImpl <em>File Domain Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.openiaml.model.model.domain.impl.FileDomainObjectImpl
	 * @see org.openiaml.model.model.domain.impl.DomainPackageImpl#getFileDomainObject()
	 * @generated
	 */
	int FILE_DOMAIN_OBJECT = 4;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_OBJECT__OPERATIONS = ABSTRACT_DOMAIN_OBJECT__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Generated By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_OBJECT__GENERATED_BY = ABSTRACT_DOMAIN_OBJECT__GENERATED_BY;

	/**
	 * The feature id for the '<em><b>Is Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_OBJECT__IS_GENERATED = ABSTRACT_DOMAIN_OBJECT__IS_GENERATED;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_OBJECT__ID = ABSTRACT_DOMAIN_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Generated Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_OBJECT__GENERATED_RULE = ABSTRACT_DOMAIN_OBJECT__GENERATED_RULE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_OBJECT__NAME = ABSTRACT_DOMAIN_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Event Triggers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_OBJECT__EVENT_TRIGGERS = ABSTRACT_DOMAIN_OBJECT__EVENT_TRIGGERS;

	/**
	 * The feature id for the '<em><b>Wires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_OBJECT__WIRES = ABSTRACT_DOMAIN_OBJECT__WIRES;

	/**
	 * The feature id for the '<em><b>Out Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_OBJECT__OUT_EDGES = ABSTRACT_DOMAIN_OBJECT__OUT_EDGES;

	/**
	 * The feature id for the '<em><b>In Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_OBJECT__IN_EDGES = ABSTRACT_DOMAIN_OBJECT__IN_EDGES;

	/**
	 * The feature id for the '<em><b>Generated Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_OBJECT__GENERATED_ELEMENTS = ABSTRACT_DOMAIN_OBJECT__GENERATED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Overridden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_OBJECT__OVERRIDDEN = ABSTRACT_DOMAIN_OBJECT__OVERRIDDEN;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_OBJECT__CONDITIONS = ABSTRACT_DOMAIN_OBJECT__CONDITIONS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_OBJECT__PROPERTIES = ABSTRACT_DOMAIN_OBJECT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_OBJECT__VALUES = ABSTRACT_DOMAIN_OBJECT__VALUES;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_OBJECT__ATTRIBUTES = ABSTRACT_DOMAIN_OBJECT__ATTRIBUTES;

	/**
	 * The number of structural features of the '<em>File Domain Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_OBJECT_FEATURE_COUNT = ABSTRACT_DOMAIN_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.openiaml.model.model.domain.impl.FileDomainAttributeImpl <em>File Domain Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.openiaml.model.model.domain.impl.FileDomainAttributeImpl
	 * @see org.openiaml.model.model.domain.impl.DomainPackageImpl#getFileDomainAttribute()
	 * @generated
	 */
	int FILE_DOMAIN_ATTRIBUTE = 5;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_ATTRIBUTE__OPERATIONS = ABSTRACT_DOMAIN_ATTRIBUTE__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Generated By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_ATTRIBUTE__GENERATED_BY = ABSTRACT_DOMAIN_ATTRIBUTE__GENERATED_BY;

	/**
	 * The feature id for the '<em><b>Is Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_ATTRIBUTE__IS_GENERATED = ABSTRACT_DOMAIN_ATTRIBUTE__IS_GENERATED;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_ATTRIBUTE__ID = ABSTRACT_DOMAIN_ATTRIBUTE__ID;

	/**
	 * The feature id for the '<em><b>Generated Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_ATTRIBUTE__GENERATED_RULE = ABSTRACT_DOMAIN_ATTRIBUTE__GENERATED_RULE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_ATTRIBUTE__NAME = ABSTRACT_DOMAIN_ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Event Triggers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_ATTRIBUTE__EVENT_TRIGGERS = ABSTRACT_DOMAIN_ATTRIBUTE__EVENT_TRIGGERS;

	/**
	 * The feature id for the '<em><b>Wires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_ATTRIBUTE__WIRES = ABSTRACT_DOMAIN_ATTRIBUTE__WIRES;

	/**
	 * The feature id for the '<em><b>Out Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_ATTRIBUTE__OUT_EDGES = ABSTRACT_DOMAIN_ATTRIBUTE__OUT_EDGES;

	/**
	 * The feature id for the '<em><b>In Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_ATTRIBUTE__IN_EDGES = ABSTRACT_DOMAIN_ATTRIBUTE__IN_EDGES;

	/**
	 * The feature id for the '<em><b>Generated Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_ATTRIBUTE__GENERATED_ELEMENTS = ABSTRACT_DOMAIN_ATTRIBUTE__GENERATED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Overridden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_ATTRIBUTE__OVERRIDDEN = ABSTRACT_DOMAIN_ATTRIBUTE__OVERRIDDEN;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_ATTRIBUTE__CONDITIONS = ABSTRACT_DOMAIN_ATTRIBUTE__CONDITIONS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_ATTRIBUTE__PROPERTIES = ABSTRACT_DOMAIN_ATTRIBUTE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_ATTRIBUTE__VALUES = ABSTRACT_DOMAIN_ATTRIBUTE__VALUES;

	/**
	 * The number of structural features of the '<em>File Domain Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_DOMAIN_ATTRIBUTE_FEATURE_COUNT = ABSTRACT_DOMAIN_ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '<em>File Reference</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.openiaml.model.FileReference
	 * @see org.openiaml.model.model.domain.impl.DomainPackageImpl#getFileReference()
	 * @generated
	 */
	int FILE_REFERENCE = 6;


	/**
	 * Returns the meta object for class '{@link org.openiaml.model.model.domain.AbstractDomainStore <em>Abstract Domain Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Domain Store</em>'.
	 * @see org.openiaml.model.model.domain.AbstractDomainStore
	 * @generated
	 */
	EClass getAbstractDomainStore();

	/**
	 * Returns the meta object for the containment reference list '{@link org.openiaml.model.model.domain.AbstractDomainStore#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.openiaml.model.model.domain.AbstractDomainStore#getChildren()
	 * @see #getAbstractDomainStore()
	 * @generated
	 */
	EReference getAbstractDomainStore_Children();

	/**
	 * Returns the meta object for the containment reference list '{@link org.openiaml.model.model.domain.AbstractDomainStore#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.openiaml.model.model.domain.AbstractDomainStore#getProperties()
	 * @see #getAbstractDomainStore()
	 * @generated
	 */
	EReference getAbstractDomainStore_Properties();

	/**
	 * Returns the meta object for the reference list '{@link org.openiaml.model.model.domain.AbstractDomainStore#getViews <em>Views</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Views</em>'.
	 * @see org.openiaml.model.model.domain.AbstractDomainStore#getViews()
	 * @see #getAbstractDomainStore()
	 * @generated
	 */
	EReference getAbstractDomainStore_Views();

	/**
	 * Returns the meta object for class '{@link org.openiaml.model.model.domain.AbstractDomainObject <em>Abstract Domain Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Domain Object</em>'.
	 * @see org.openiaml.model.model.domain.AbstractDomainObject
	 * @generated
	 */
	EClass getAbstractDomainObject();

	/**
	 * Returns the meta object for the containment reference list '{@link org.openiaml.model.model.domain.AbstractDomainObject#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see org.openiaml.model.model.domain.AbstractDomainObject#getAttributes()
	 * @see #getAbstractDomainObject()
	 * @generated
	 */
	EReference getAbstractDomainObject_Attributes();

	/**
	 * Returns the meta object for class '{@link org.openiaml.model.model.domain.AbstractDomainAttribute <em>Abstract Domain Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Domain Attribute</em>'.
	 * @see org.openiaml.model.model.domain.AbstractDomainAttribute
	 * @generated
	 */
	EClass getAbstractDomainAttribute();

	/**
	 * Returns the meta object for class '{@link org.openiaml.model.model.domain.FileDomainStore <em>File Domain Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Domain Store</em>'.
	 * @see org.openiaml.model.model.domain.FileDomainStore
	 * @generated
	 */
	EClass getFileDomainStore();

	/**
	 * Returns the meta object for the attribute '{@link org.openiaml.model.model.domain.FileDomainStore#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File</em>'.
	 * @see org.openiaml.model.model.domain.FileDomainStore#getFile()
	 * @see #getFileDomainStore()
	 * @generated
	 */
	EAttribute getFileDomainStore_File();

	/**
	 * Returns the meta object for class '{@link org.openiaml.model.model.domain.FileDomainObject <em>File Domain Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Domain Object</em>'.
	 * @see org.openiaml.model.model.domain.FileDomainObject
	 * @generated
	 */
	EClass getFileDomainObject();

	/**
	 * Returns the meta object for class '{@link org.openiaml.model.model.domain.FileDomainAttribute <em>File Domain Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Domain Attribute</em>'.
	 * @see org.openiaml.model.model.domain.FileDomainAttribute
	 * @generated
	 */
	EClass getFileDomainAttribute();

	/**
	 * Returns the meta object for data type '{@link org.openiaml.model.FileReference <em>File Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>File Reference</em>'.
	 * @see org.openiaml.model.FileReference
	 * @model instanceClass="org.openiaml.model.FileReference"
	 * @generated
	 */
	EDataType getFileReference();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DomainFactory getDomainFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.openiaml.model.model.domain.impl.AbstractDomainStoreImpl <em>Abstract Domain Store</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.openiaml.model.model.domain.impl.AbstractDomainStoreImpl
		 * @see org.openiaml.model.model.domain.impl.DomainPackageImpl#getAbstractDomainStore()
		 * @generated
		 */
		EClass ABSTRACT_DOMAIN_STORE = eINSTANCE.getAbstractDomainStore();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_DOMAIN_STORE__CHILDREN = eINSTANCE.getAbstractDomainStore_Children();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_DOMAIN_STORE__PROPERTIES = eINSTANCE.getAbstractDomainStore_Properties();

		/**
		 * The meta object literal for the '<em><b>Views</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_DOMAIN_STORE__VIEWS = eINSTANCE.getAbstractDomainStore_Views();

		/**
		 * The meta object literal for the '{@link org.openiaml.model.model.domain.impl.AbstractDomainObjectImpl <em>Abstract Domain Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.openiaml.model.model.domain.impl.AbstractDomainObjectImpl
		 * @see org.openiaml.model.model.domain.impl.DomainPackageImpl#getAbstractDomainObject()
		 * @generated
		 */
		EClass ABSTRACT_DOMAIN_OBJECT = eINSTANCE.getAbstractDomainObject();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_DOMAIN_OBJECT__ATTRIBUTES = eINSTANCE.getAbstractDomainObject_Attributes();

		/**
		 * The meta object literal for the '{@link org.openiaml.model.model.domain.impl.AbstractDomainAttributeImpl <em>Abstract Domain Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.openiaml.model.model.domain.impl.AbstractDomainAttributeImpl
		 * @see org.openiaml.model.model.domain.impl.DomainPackageImpl#getAbstractDomainAttribute()
		 * @generated
		 */
		EClass ABSTRACT_DOMAIN_ATTRIBUTE = eINSTANCE.getAbstractDomainAttribute();

		/**
		 * The meta object literal for the '{@link org.openiaml.model.model.domain.impl.FileDomainStoreImpl <em>File Domain Store</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.openiaml.model.model.domain.impl.FileDomainStoreImpl
		 * @see org.openiaml.model.model.domain.impl.DomainPackageImpl#getFileDomainStore()
		 * @generated
		 */
		EClass FILE_DOMAIN_STORE = eINSTANCE.getFileDomainStore();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_DOMAIN_STORE__FILE = eINSTANCE.getFileDomainStore_File();

		/**
		 * The meta object literal for the '{@link org.openiaml.model.model.domain.impl.FileDomainObjectImpl <em>File Domain Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.openiaml.model.model.domain.impl.FileDomainObjectImpl
		 * @see org.openiaml.model.model.domain.impl.DomainPackageImpl#getFileDomainObject()
		 * @generated
		 */
		EClass FILE_DOMAIN_OBJECT = eINSTANCE.getFileDomainObject();

		/**
		 * The meta object literal for the '{@link org.openiaml.model.model.domain.impl.FileDomainAttributeImpl <em>File Domain Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.openiaml.model.model.domain.impl.FileDomainAttributeImpl
		 * @see org.openiaml.model.model.domain.impl.DomainPackageImpl#getFileDomainAttribute()
		 * @generated
		 */
		EClass FILE_DOMAIN_ATTRIBUTE = eINSTANCE.getFileDomainAttribute();

		/**
		 * The meta object literal for the '<em>File Reference</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.openiaml.model.FileReference
		 * @see org.openiaml.model.model.domain.impl.DomainPackageImpl#getFileReference()
		 * @generated
		 */
		EDataType FILE_REFERENCE = eINSTANCE.getFileReference();

	}

} //DomainPackage
