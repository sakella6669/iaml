/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openiaml.docs.modeldoc;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EMF Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.openiaml.docs.modeldoc.EMFClass#getTargetClass <em>Target Class</em>}</li>
 *   <li>{@link org.openiaml.docs.modeldoc.EMFClass#getRuntimeClass <em>Runtime Class</em>}</li>
 *   <li>{@link org.openiaml.docs.modeldoc.EMFClass#getTagline <em>Tagline</em>}</li>
 *   <li>{@link org.openiaml.docs.modeldoc.EMFClass#getDescription <em>Description</em>}</li>
 *   <li>{@link org.openiaml.docs.modeldoc.EMFClass#getOperationalSemantics <em>Operational Semantics</em>}</li>
 *   <li>{@link org.openiaml.docs.modeldoc.EMFClass#getInferenceSemantics <em>Inference Semantics</em>}</li>
 *   <li>{@link org.openiaml.docs.modeldoc.EMFClass#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link org.openiaml.docs.modeldoc.EMFClass#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link org.openiaml.docs.modeldoc.EMFClass#getGraphicalRepresentations <em>Graphical Representations</em>}</li>
 *   <li>{@link org.openiaml.docs.modeldoc.EMFClass#getExamples <em>Examples</em>}</li>
 *   <li>{@link org.openiaml.docs.modeldoc.EMFClass#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.openiaml.docs.modeldoc.ModeldocPackage#getEMFClass()
 * @model
 * @generated
 */
public interface EMFClass extends EObject {
	/**
	 * Returns the value of the '<em><b>Target Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Class</em>' reference.
	 * @see #setTargetClass(EClass)
	 * @see org.openiaml.docs.modeldoc.ModeldocPackage#getEMFClass_TargetClass()
	 * @model
	 * @generated
	 */
	EClass getTargetClass();

	/**
	 * Sets the value of the '{@link org.openiaml.docs.modeldoc.EMFClass#getTargetClass <em>Target Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Class</em>' reference.
	 * @see #getTargetClass()
	 * @generated
	 */
	void setTargetClass(EClass value);

	/**
	 * Returns the value of the '<em><b>Runtime Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Runtime Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Runtime Class</em>' reference.
	 * @see #setRuntimeClass(JavaClass)
	 * @see org.openiaml.docs.modeldoc.ModeldocPackage#getEMFClass_RuntimeClass()
	 * @model
	 * @generated
	 */
	JavaClass getRuntimeClass();

	/**
	 * Sets the value of the '{@link org.openiaml.docs.modeldoc.EMFClass#getRuntimeClass <em>Runtime Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Runtime Class</em>' reference.
	 * @see #getRuntimeClass()
	 * @generated
	 */
	void setRuntimeClass(JavaClass value);

	/**
	 * Returns the value of the '<em><b>Tagline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tagline</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tagline</em>' attribute.
	 * @see #setTagline(String)
	 * @see org.openiaml.docs.modeldoc.ModeldocPackage#getEMFClass_Tagline()
	 * @model
	 * @generated
	 */
	String getTagline();

	/**
	 * Sets the value of the '{@link org.openiaml.docs.modeldoc.EMFClass#getTagline <em>Tagline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tagline</em>' attribute.
	 * @see #getTagline()
	 * @generated
	 */
	void setTagline(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.openiaml.docs.modeldoc.ModeldocPackage#getEMFClass_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.openiaml.docs.modeldoc.EMFClass#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Operational Semantics</b></em>' containment reference list.
	 * The list contents are of type {@link org.openiaml.docs.modeldoc.OperationalSemantic}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operational Semantics</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operational Semantics</em>' containment reference list.
	 * @see org.openiaml.docs.modeldoc.ModeldocPackage#getEMFClass_OperationalSemantics()
	 * @model containment="true"
	 * @generated
	 */
	EList<OperationalSemantic> getOperationalSemantics();

	/**
	 * Returns the value of the '<em><b>Inference Semantics</b></em>' containment reference list.
	 * The list contents are of type {@link org.openiaml.docs.modeldoc.InferenceSemantic}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inference Semantics</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inference Semantics</em>' containment reference list.
	 * @see org.openiaml.docs.modeldoc.ModeldocPackage#getEMFClass_InferenceSemantics()
	 * @model containment="true"
	 * @generated
	 */
	EList<InferenceSemantic> getInferenceSemantics();

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link org.openiaml.docs.modeldoc.Constraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see org.openiaml.docs.modeldoc.ModeldocPackage#getEMFClass_Constraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<Constraint> getConstraints();

	/**
	 * Returns the value of the '<em><b>Extensions</b></em>' containment reference list.
	 * The list contents are of type {@link org.openiaml.docs.modeldoc.ModelExtension}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extensions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extensions</em>' containment reference list.
	 * @see org.openiaml.docs.modeldoc.ModeldocPackage#getEMFClass_Extensions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelExtension> getExtensions();

	/**
	 * Returns the value of the '<em><b>Graphical Representations</b></em>' containment reference list.
	 * The list contents are of type {@link org.openiaml.docs.modeldoc.GraphicalRepresentation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graphical Representations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graphical Representations</em>' containment reference list.
	 * @see org.openiaml.docs.modeldoc.ModeldocPackage#getEMFClass_GraphicalRepresentations()
	 * @model containment="true"
	 * @generated
	 */
	EList<GraphicalRepresentation> getGraphicalRepresentations();

	/**
	 * Returns the value of the '<em><b>Examples</b></em>' containment reference list.
	 * The list contents are of type {@link org.openiaml.docs.modeldoc.Example}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Examples</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Examples</em>' containment reference list.
	 * @see org.openiaml.docs.modeldoc.ModeldocPackage#getEMFClass_Examples()
	 * @model containment="true"
	 * @generated
	 */
	EList<Example> getExamples();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.openiaml.docs.modeldoc.ModelDocumentation#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(ModelDocumentation)
	 * @see org.openiaml.docs.modeldoc.ModeldocPackage#getEMFClass_Parent()
	 * @see org.openiaml.docs.modeldoc.ModelDocumentation#getClasses
	 * @model opposite="classes" transient="false"
	 * @generated
	 */
	ModelDocumentation getParent();

	/**
	 * Sets the value of the '{@link org.openiaml.docs.modeldoc.EMFClass#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(ModelDocumentation value);

} // EMFClass
