/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openiaml.model.model.components;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
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
 * @see org.openiaml.model.model.components.ComponentsFactory
 * @model kind="package"
 *        annotation="http://openiaml.org/comment added='0.2'"
 * @generated
 */
public interface ComponentsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "components";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://openiaml.org/model/components";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "iaml.components";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ComponentsPackage eINSTANCE = org.openiaml.model.model.components.impl.ComponentsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.openiaml.model.model.components.impl.LoginHandlerImpl <em>Login Handler</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.openiaml.model.model.components.impl.LoginHandlerImpl
	 * @see org.openiaml.model.model.components.impl.ComponentsPackageImpl#getLoginHandler()
	 * @generated
	 */
	int LOGIN_HANDLER = 0;

	/**
	 * The feature id for the '<em><b>Generated Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_HANDLER__GENERATED_ELEMENTS = ModelPackage.GENERATES_ELEMENTS__GENERATED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Overridden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_HANDLER__OVERRIDDEN = ModelPackage.GENERATES_ELEMENTS__OVERRIDDEN;

	/**
	 * The feature id for the '<em><b>In Parameter Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_HANDLER__IN_PARAMETER_EDGES = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_HANDLER__OPERATIONS = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Generated By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_HANDLER__GENERATED_BY = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_HANDLER__IS_GENERATED = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_HANDLER__ID = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Generated Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_HANDLER__GENERATED_RULE = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_HANDLER__NAME = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Wires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_HANDLER__WIRES = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Parameter Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_HANDLER__PARAMETER_EDGES = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Extends Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_HANDLER__EXTENDS_EDGES = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Requires Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_HANDLER__REQUIRES_EDGES = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Provides Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_HANDLER__PROVIDES_EDGES = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Constraint Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_HANDLER__CONSTRAINT_EDGES = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Condition Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_HANDLER__CONDITION_EDGES = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Out Wires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_HANDLER__OUT_WIRES = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>In Wires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_HANDLER__IN_WIRES = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_HANDLER__CONDITIONS = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_HANDLER__PROPERTIES = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_HANDLER__VALUES = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_HANDLER__TYPE = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 19;

	/**
	 * The number of structural features of the '<em>Login Handler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_HANDLER_FEATURE_COUNT = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 20;

	/**
	 * The meta object id for the '{@link org.openiaml.model.model.components.impl.AccessControlHandlerImpl <em>Access Control Handler</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.openiaml.model.model.components.impl.AccessControlHandlerImpl
	 * @see org.openiaml.model.model.components.impl.ComponentsPackageImpl#getAccessControlHandler()
	 * @generated
	 */
	int ACCESS_CONTROL_HANDLER = 1;

	/**
	 * The feature id for the '<em><b>Generated Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_HANDLER__GENERATED_ELEMENTS = ModelPackage.GENERATES_ELEMENTS__GENERATED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Overridden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_HANDLER__OVERRIDDEN = ModelPackage.GENERATES_ELEMENTS__OVERRIDDEN;

	/**
	 * The feature id for the '<em><b>In Parameter Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_HANDLER__IN_PARAMETER_EDGES = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Out Requires Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_HANDLER__OUT_REQUIRES_EDGES = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_HANDLER__OPERATIONS = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Generated By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_HANDLER__GENERATED_BY = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_HANDLER__IS_GENERATED = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_HANDLER__ID = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Generated Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_HANDLER__GENERATED_RULE = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_HANDLER__NAME = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Wires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_HANDLER__WIRES = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Parameter Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_HANDLER__PARAMETER_EDGES = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Extends Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_HANDLER__EXTENDS_EDGES = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Requires Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_HANDLER__REQUIRES_EDGES = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Provides Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_HANDLER__PROVIDES_EDGES = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Constraint Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_HANDLER__CONSTRAINT_EDGES = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Condition Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_HANDLER__CONDITION_EDGES = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Out Wires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_HANDLER__OUT_WIRES = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>In Wires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_HANDLER__IN_WIRES = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_HANDLER__CONDITIONS = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_HANDLER__PROPERTIES = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_HANDLER__VALUES = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 19;

	/**
	 * The number of structural features of the '<em>Access Control Handler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_CONTROL_HANDLER_FEATURE_COUNT = ModelPackage.GENERATES_ELEMENTS_FEATURE_COUNT + 20;

	/**
	 * The meta object id for the '{@link org.openiaml.model.model.components.impl.GateImpl <em>Gate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.openiaml.model.model.components.impl.GateImpl
	 * @see org.openiaml.model.model.components.impl.ComponentsPackageImpl#getGate()
	 * @generated
	 */
	int GATE = 2;

	/**
	 * The feature id for the '<em><b>Generated By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATE__GENERATED_BY = ModelPackage.NAMED_ELEMENT__GENERATED_BY;

	/**
	 * The feature id for the '<em><b>Is Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATE__IS_GENERATED = ModelPackage.NAMED_ELEMENT__IS_GENERATED;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATE__ID = ModelPackage.NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Generated Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATE__GENERATED_RULE = ModelPackage.NAMED_ELEMENT__GENERATED_RULE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATE__NAME = ModelPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Wires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATE__WIRES = ModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameter Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATE__PARAMETER_EDGES = ModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Extends Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATE__EXTENDS_EDGES = ModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Requires Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATE__REQUIRES_EDGES = ModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Provides Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATE__PROVIDES_EDGES = ModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Constraint Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATE__CONSTRAINT_EDGES = ModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Condition Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATE__CONDITION_EDGES = ModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Out Wires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATE__OUT_WIRES = ModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>In Wires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATE__IN_WIRES = ModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Generated Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATE__GENERATED_ELEMENTS = ModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Overridden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATE__OVERRIDDEN = ModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>In Condition Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATE__IN_CONDITION_EDGES = ModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Gate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATE_FEATURE_COUNT = ModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 12;

	/**
	 * The meta object id for the '{@link org.openiaml.model.model.components.impl.EntryGateImpl <em>Entry Gate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.openiaml.model.model.components.impl.EntryGateImpl
	 * @see org.openiaml.model.model.components.impl.ComponentsPackageImpl#getEntryGate()
	 * @generated
	 */
	int ENTRY_GATE = 3;

	/**
	 * The feature id for the '<em><b>Generated By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_GATE__GENERATED_BY = GATE__GENERATED_BY;

	/**
	 * The feature id for the '<em><b>Is Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_GATE__IS_GENERATED = GATE__IS_GENERATED;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_GATE__ID = GATE__ID;

	/**
	 * The feature id for the '<em><b>Generated Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_GATE__GENERATED_RULE = GATE__GENERATED_RULE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_GATE__NAME = GATE__NAME;

	/**
	 * The feature id for the '<em><b>Wires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_GATE__WIRES = GATE__WIRES;

	/**
	 * The feature id for the '<em><b>Parameter Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_GATE__PARAMETER_EDGES = GATE__PARAMETER_EDGES;

	/**
	 * The feature id for the '<em><b>Extends Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_GATE__EXTENDS_EDGES = GATE__EXTENDS_EDGES;

	/**
	 * The feature id for the '<em><b>Requires Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_GATE__REQUIRES_EDGES = GATE__REQUIRES_EDGES;

	/**
	 * The feature id for the '<em><b>Provides Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_GATE__PROVIDES_EDGES = GATE__PROVIDES_EDGES;

	/**
	 * The feature id for the '<em><b>Constraint Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_GATE__CONSTRAINT_EDGES = GATE__CONSTRAINT_EDGES;

	/**
	 * The feature id for the '<em><b>Condition Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_GATE__CONDITION_EDGES = GATE__CONDITION_EDGES;

	/**
	 * The feature id for the '<em><b>Out Wires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_GATE__OUT_WIRES = GATE__OUT_WIRES;

	/**
	 * The feature id for the '<em><b>In Wires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_GATE__IN_WIRES = GATE__IN_WIRES;

	/**
	 * The feature id for the '<em><b>Generated Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_GATE__GENERATED_ELEMENTS = GATE__GENERATED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Overridden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_GATE__OVERRIDDEN = GATE__OVERRIDDEN;

	/**
	 * The feature id for the '<em><b>In Condition Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_GATE__IN_CONDITION_EDGES = GATE__IN_CONDITION_EDGES;

	/**
	 * The number of structural features of the '<em>Entry Gate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_GATE_FEATURE_COUNT = GATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.openiaml.model.model.components.impl.ExitGateImpl <em>Exit Gate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.openiaml.model.model.components.impl.ExitGateImpl
	 * @see org.openiaml.model.model.components.impl.ComponentsPackageImpl#getExitGate()
	 * @generated
	 */
	int EXIT_GATE = 4;

	/**
	 * The feature id for the '<em><b>Generated By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_GATE__GENERATED_BY = GATE__GENERATED_BY;

	/**
	 * The feature id for the '<em><b>Is Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_GATE__IS_GENERATED = GATE__IS_GENERATED;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_GATE__ID = GATE__ID;

	/**
	 * The feature id for the '<em><b>Generated Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_GATE__GENERATED_RULE = GATE__GENERATED_RULE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_GATE__NAME = GATE__NAME;

	/**
	 * The feature id for the '<em><b>Wires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_GATE__WIRES = GATE__WIRES;

	/**
	 * The feature id for the '<em><b>Parameter Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_GATE__PARAMETER_EDGES = GATE__PARAMETER_EDGES;

	/**
	 * The feature id for the '<em><b>Extends Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_GATE__EXTENDS_EDGES = GATE__EXTENDS_EDGES;

	/**
	 * The feature id for the '<em><b>Requires Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_GATE__REQUIRES_EDGES = GATE__REQUIRES_EDGES;

	/**
	 * The feature id for the '<em><b>Provides Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_GATE__PROVIDES_EDGES = GATE__PROVIDES_EDGES;

	/**
	 * The feature id for the '<em><b>Constraint Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_GATE__CONSTRAINT_EDGES = GATE__CONSTRAINT_EDGES;

	/**
	 * The feature id for the '<em><b>Condition Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_GATE__CONDITION_EDGES = GATE__CONDITION_EDGES;

	/**
	 * The feature id for the '<em><b>Out Wires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_GATE__OUT_WIRES = GATE__OUT_WIRES;

	/**
	 * The feature id for the '<em><b>In Wires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_GATE__IN_WIRES = GATE__IN_WIRES;

	/**
	 * The feature id for the '<em><b>Generated Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_GATE__GENERATED_ELEMENTS = GATE__GENERATED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Overridden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_GATE__OVERRIDDEN = GATE__OVERRIDDEN;

	/**
	 * The feature id for the '<em><b>In Condition Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_GATE__IN_CONDITION_EDGES = GATE__IN_CONDITION_EDGES;

	/**
	 * The number of structural features of the '<em>Exit Gate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXIT_GATE_FEATURE_COUNT = GATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.openiaml.model.model.components.LoginHandlerTypes <em>Login Handler Types</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.openiaml.model.model.components.LoginHandlerTypes
	 * @see org.openiaml.model.model.components.impl.ComponentsPackageImpl#getLoginHandlerTypes()
	 * @generated
	 */
	int LOGIN_HANDLER_TYPES = 5;

	/**
	 * Returns the meta object for class '{@link org.openiaml.model.model.components.LoginHandler <em>Login Handler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Login Handler</em>'.
	 * @see org.openiaml.model.model.components.LoginHandler
	 * @generated
	 */
	EClass getLoginHandler();

	/**
	 * Returns the meta object for the attribute '{@link org.openiaml.model.model.components.LoginHandler#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.openiaml.model.model.components.LoginHandler#getType()
	 * @see #getLoginHandler()
	 * @generated
	 */
	EAttribute getLoginHandler_Type();

	/**
	 * Returns the meta object for class '{@link org.openiaml.model.model.components.AccessControlHandler <em>Access Control Handler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Access Control Handler</em>'.
	 * @see org.openiaml.model.model.components.AccessControlHandler
	 * @generated
	 */
	EClass getAccessControlHandler();

	/**
	 * Returns the meta object for class '{@link org.openiaml.model.model.components.Gate <em>Gate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gate</em>'.
	 * @see org.openiaml.model.model.components.Gate
	 * @generated
	 */
	EClass getGate();

	/**
	 * Returns the meta object for class '{@link org.openiaml.model.model.components.EntryGate <em>Entry Gate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entry Gate</em>'.
	 * @see org.openiaml.model.model.components.EntryGate
	 * @generated
	 */
	EClass getEntryGate();

	/**
	 * Returns the meta object for class '{@link org.openiaml.model.model.components.ExitGate <em>Exit Gate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exit Gate</em>'.
	 * @see org.openiaml.model.model.components.ExitGate
	 * @generated
	 */
	EClass getExitGate();

	/**
	 * Returns the meta object for enum '{@link org.openiaml.model.model.components.LoginHandlerTypes <em>Login Handler Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Login Handler Types</em>'.
	 * @see org.openiaml.model.model.components.LoginHandlerTypes
	 * @generated
	 */
	EEnum getLoginHandlerTypes();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ComponentsFactory getComponentsFactory();

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
		 * The meta object literal for the '{@link org.openiaml.model.model.components.impl.LoginHandlerImpl <em>Login Handler</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.openiaml.model.model.components.impl.LoginHandlerImpl
		 * @see org.openiaml.model.model.components.impl.ComponentsPackageImpl#getLoginHandler()
		 * @generated
		 */
		EClass LOGIN_HANDLER = eINSTANCE.getLoginHandler();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOGIN_HANDLER__TYPE = eINSTANCE.getLoginHandler_Type();

		/**
		 * The meta object literal for the '{@link org.openiaml.model.model.components.impl.AccessControlHandlerImpl <em>Access Control Handler</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.openiaml.model.model.components.impl.AccessControlHandlerImpl
		 * @see org.openiaml.model.model.components.impl.ComponentsPackageImpl#getAccessControlHandler()
		 * @generated
		 */
		EClass ACCESS_CONTROL_HANDLER = eINSTANCE.getAccessControlHandler();

		/**
		 * The meta object literal for the '{@link org.openiaml.model.model.components.impl.GateImpl <em>Gate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.openiaml.model.model.components.impl.GateImpl
		 * @see org.openiaml.model.model.components.impl.ComponentsPackageImpl#getGate()
		 * @generated
		 */
		EClass GATE = eINSTANCE.getGate();

		/**
		 * The meta object literal for the '{@link org.openiaml.model.model.components.impl.EntryGateImpl <em>Entry Gate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.openiaml.model.model.components.impl.EntryGateImpl
		 * @see org.openiaml.model.model.components.impl.ComponentsPackageImpl#getEntryGate()
		 * @generated
		 */
		EClass ENTRY_GATE = eINSTANCE.getEntryGate();

		/**
		 * The meta object literal for the '{@link org.openiaml.model.model.components.impl.ExitGateImpl <em>Exit Gate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.openiaml.model.model.components.impl.ExitGateImpl
		 * @see org.openiaml.model.model.components.impl.ComponentsPackageImpl#getExitGate()
		 * @generated
		 */
		EClass EXIT_GATE = eINSTANCE.getExitGate();

		/**
		 * The meta object literal for the '{@link org.openiaml.model.model.components.LoginHandlerTypes <em>Login Handler Types</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.openiaml.model.model.components.LoginHandlerTypes
		 * @see org.openiaml.model.model.components.impl.ComponentsPackageImpl#getLoginHandlerTypes()
		 * @generated
		 */
		EEnum LOGIN_HANDLER_TYPES = eINSTANCE.getLoginHandlerTypes();

	}

} //ComponentsPackage
