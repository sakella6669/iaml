/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openiaml.model.model.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.openiaml.model.model.Accessible;
import org.openiaml.model.model.Action;
import org.openiaml.model.model.ActionDestination;
import org.openiaml.model.model.ActionSource;
import org.openiaml.model.model.ActivityNode;
import org.openiaml.model.model.ApplicationElement;
import org.openiaml.model.model.CanBeSynced;
import org.openiaml.model.model.CompositeCondition;
import org.openiaml.model.model.CompositeOperation;
import org.openiaml.model.model.Condition;
import org.openiaml.model.model.ConditionalEdge;
import org.openiaml.model.model.ContainsConditions;
import org.openiaml.model.model.ContainsOperations;
import org.openiaml.model.model.ContainsWires;
import org.openiaml.model.model.DataFlowEdge;
import org.openiaml.model.model.DataFlowEdgeDestination;
import org.openiaml.model.model.DataFlowEdgesSource;
import org.openiaml.model.model.DomainAttribute;
import org.openiaml.model.model.DomainAttributeInstance;
import org.openiaml.model.model.DomainObject;
import org.openiaml.model.model.DomainObjectInstance;
import org.openiaml.model.model.DomainStore;
import org.openiaml.model.model.DynamicApplicationElementSet;
import org.openiaml.model.model.Editable;
import org.openiaml.model.model.EventTrigger;
import org.openiaml.model.model.ExecutionEdge;
import org.openiaml.model.model.ExecutionEdgeDestination;
import org.openiaml.model.model.ExecutionEdgesSource;
import org.openiaml.model.model.GeneratedElement;
import org.openiaml.model.model.GeneratesElements;
import org.openiaml.model.model.InternetApplication;
import org.openiaml.model.model.ModelPackage;
import org.openiaml.model.model.NamedElement;
import org.openiaml.model.model.Operation;
import org.openiaml.model.model.Parameter;
import org.openiaml.model.model.PrimitiveOperation;
import org.openiaml.model.model.Property;
import org.openiaml.model.model.QueryParameter;
import org.openiaml.model.model.Scope;
import org.openiaml.model.model.ShouldntContainWires;
import org.openiaml.model.model.StaticValue;
import org.openiaml.model.model.TemporaryVariable;
import org.openiaml.model.model.VisibleThing;
import org.openiaml.model.model.Wire;
import org.openiaml.model.model.WireDestination;
import org.openiaml.model.model.WireSource;
import org.openiaml.model.model.wires.ConditionEdgesSource;
import org.openiaml.model.model.wires.ExtendsEdgeDestination;
import org.openiaml.model.model.wires.ExtendsEdgesSource;
import org.openiaml.model.model.wires.ParameterEdgeDestination;
import org.openiaml.model.model.wires.ParameterEdgesSource;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.openiaml.model.model.ModelPackage
 * @generated
 */
public class ModelSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSwitch() {
		if (modelPackage == null) {
			modelPackage = ModelPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ModelPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = caseGeneratedElement(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.WIRE: {
				Wire wire = (Wire)theEObject;
				T result = caseWire(wire);
				if (result == null) result = caseGeneratedElement(wire);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.WIRE_DESTINATION: {
				WireDestination wireDestination = (WireDestination)theEObject;
				T result = caseWireDestination(wireDestination);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.WIRE_SOURCE: {
				WireSource wireSource = (WireSource)theEObject;
				T result = caseWireSource(wireSource);
				if (result == null) result = caseShouldntContainWires(wireSource);
				if (result == null) result = caseContainsWires(wireSource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.EVENT_TRIGGER: {
				EventTrigger eventTrigger = (EventTrigger)theEObject;
				T result = caseEventTrigger(eventTrigger);
				if (result == null) result = caseNamedElement(eventTrigger);
				if (result == null) result = caseWireSource(eventTrigger);
				if (result == null) result = caseActionSource(eventTrigger);
				if (result == null) result = caseGeneratedElement(eventTrigger);
				if (result == null) result = caseShouldntContainWires(eventTrigger);
				if (result == null) result = caseContainsWires(eventTrigger);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.DOMAIN_OBJECT: {
				DomainObject domainObject = (DomainObject)theEObject;
				T result = caseDomainObject(domainObject);
				if (result == null) result = caseApplicationElement(domainObject);
				if (result == null) result = caseParameterEdgesSource(domainObject);
				if (result == null) result = caseExtendsEdgesSource(domainObject);
				if (result == null) result = caseExtendsEdgeDestination(domainObject);
				if (result == null) result = caseEditable(domainObject);
				if (result == null) result = caseCanBeSynced(domainObject);
				if (result == null) result = caseContainsOperations(domainObject);
				if (result == null) result = caseNamedElement(domainObject);
				if (result == null) result = caseGeneratedElement(domainObject);
				if (result == null) result = caseWireSource(domainObject);
				if (result == null) result = caseShouldntContainWires(domainObject);
				if (result == null) result = caseWireDestination(domainObject);
				if (result == null) result = caseGeneratesElements(domainObject);
				if (result == null) result = caseContainsConditions(domainObject);
				if (result == null) result = caseContainsWires(domainObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.DOMAIN_ATTRIBUTE: {
				DomainAttribute domainAttribute = (DomainAttribute)theEObject;
				T result = caseDomainAttribute(domainAttribute);
				if (result == null) result = caseApplicationElement(domainAttribute);
				if (result == null) result = caseParameterEdgesSource(domainAttribute);
				if (result == null) result = caseExtendsEdgesSource(domainAttribute);
				if (result == null) result = caseExtendsEdgeDestination(domainAttribute);
				if (result == null) result = caseEditable(domainAttribute);
				if (result == null) result = caseCanBeSynced(domainAttribute);
				if (result == null) result = caseContainsOperations(domainAttribute);
				if (result == null) result = caseNamedElement(domainAttribute);
				if (result == null) result = caseGeneratedElement(domainAttribute);
				if (result == null) result = caseWireSource(domainAttribute);
				if (result == null) result = caseShouldntContainWires(domainAttribute);
				if (result == null) result = caseWireDestination(domainAttribute);
				if (result == null) result = caseGeneratesElements(domainAttribute);
				if (result == null) result = caseContainsConditions(domainAttribute);
				if (result == null) result = caseContainsWires(domainAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ACTIVITY_NODE: {
				ActivityNode activityNode = (ActivityNode)theEObject;
				T result = caseActivityNode(activityNode);
				if (result == null) result = caseGeneratedElement(activityNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.OPERATION: {
				Operation operation = (Operation)theEObject;
				T result = caseOperation(operation);
				if (result == null) result = caseWireDestination(operation);
				if (result == null) result = caseNamedElement(operation);
				if (result == null) result = caseDataFlowEdgeDestination(operation);
				if (result == null) result = caseExecutionEdgeDestination(operation);
				if (result == null) result = caseDataFlowEdgesSource(operation);
				if (result == null) result = caseActionDestination(operation);
				if (result == null) result = caseGeneratedElement(operation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				T result = caseParameter(parameter);
				if (result == null) result = caseNamedElement(parameter);
				if (result == null) result = caseDataFlowEdgesSource(parameter);
				if (result == null) result = caseGeneratedElement(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PRIMITIVE_OPERATION: {
				PrimitiveOperation primitiveOperation = (PrimitiveOperation)theEObject;
				T result = casePrimitiveOperation(primitiveOperation);
				if (result == null) result = caseOperation(primitiveOperation);
				if (result == null) result = caseExecutionEdgesSource(primitiveOperation);
				if (result == null) result = caseWireSource(primitiveOperation);
				if (result == null) result = caseActionSource(primitiveOperation);
				if (result == null) result = caseWireDestination(primitiveOperation);
				if (result == null) result = caseNamedElement(primitiveOperation);
				if (result == null) result = caseDataFlowEdgeDestination(primitiveOperation);
				if (result == null) result = caseExecutionEdgeDestination(primitiveOperation);
				if (result == null) result = caseDataFlowEdgesSource(primitiveOperation);
				if (result == null) result = caseActionDestination(primitiveOperation);
				if (result == null) result = caseShouldntContainWires(primitiveOperation);
				if (result == null) result = caseGeneratedElement(primitiveOperation);
				if (result == null) result = caseContainsWires(primitiveOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.COMPOSITE_OPERATION: {
				CompositeOperation compositeOperation = (CompositeOperation)theEObject;
				T result = caseCompositeOperation(compositeOperation);
				if (result == null) result = casePrimitiveOperation(compositeOperation);
				if (result == null) result = caseContainsOperations(compositeOperation);
				if (result == null) result = caseGeneratesElements(compositeOperation);
				if (result == null) result = caseContainsConditions(compositeOperation);
				if (result == null) result = caseOperation(compositeOperation);
				if (result == null) result = caseExecutionEdgesSource(compositeOperation);
				if (result == null) result = caseWireSource(compositeOperation);
				if (result == null) result = caseActionSource(compositeOperation);
				if (result == null) result = caseWireDestination(compositeOperation);
				if (result == null) result = caseNamedElement(compositeOperation);
				if (result == null) result = caseDataFlowEdgeDestination(compositeOperation);
				if (result == null) result = caseExecutionEdgeDestination(compositeOperation);
				if (result == null) result = caseDataFlowEdgesSource(compositeOperation);
				if (result == null) result = caseActionDestination(compositeOperation);
				if (result == null) result = caseShouldntContainWires(compositeOperation);
				if (result == null) result = caseGeneratedElement(compositeOperation);
				if (result == null) result = caseContainsWires(compositeOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CONTAINS_OPERATIONS: {
				ContainsOperations containsOperations = (ContainsOperations)theEObject;
				T result = caseContainsOperations(containsOperations);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.APPLICATION_ELEMENT: {
				ApplicationElement applicationElement = (ApplicationElement)theEObject;
				T result = caseApplicationElement(applicationElement);
				if (result == null) result = caseCanBeSynced(applicationElement);
				if (result == null) result = caseContainsOperations(applicationElement);
				if (result == null) result = caseNamedElement(applicationElement);
				if (result == null) result = caseGeneratedElement(applicationElement);
				if (result == null) result = caseWireSource(applicationElement);
				if (result == null) result = caseShouldntContainWires(applicationElement);
				if (result == null) result = caseWireDestination(applicationElement);
				if (result == null) result = caseGeneratesElements(applicationElement);
				if (result == null) result = caseContainsConditions(applicationElement);
				if (result == null) result = caseContainsWires(applicationElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PROPERTY: {
				Property property = (Property)theEObject;
				T result = caseProperty(property);
				if (result == null) result = caseNamedElement(property);
				if (result == null) result = caseWireSource(property);
				if (result == null) result = caseWireDestination(property);
				if (result == null) result = caseDataFlowEdgesSource(property);
				if (result == null) result = caseDataFlowEdgeDestination(property);
				if (result == null) result = caseParameterEdgesSource(property);
				if (result == null) result = caseGeneratedElement(property);
				if (result == null) result = caseShouldntContainWires(property);
				if (result == null) result = caseContainsWires(property);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.STATIC_VALUE: {
				StaticValue staticValue = (StaticValue)theEObject;
				T result = caseStaticValue(staticValue);
				if (result == null) result = caseNamedElement(staticValue);
				if (result == null) result = caseWireSource(staticValue);
				if (result == null) result = caseDataFlowEdgesSource(staticValue);
				if (result == null) result = caseParameterEdgesSource(staticValue);
				if (result == null) result = caseGeneratedElement(staticValue);
				if (result == null) result = caseShouldntContainWires(staticValue);
				if (result == null) result = caseContainsWires(staticValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.VISIBLE_THING: {
				VisibleThing visibleThing = (VisibleThing)theEObject;
				T result = caseVisibleThing(visibleThing);
				if (result == null) result = caseCanBeSynced(visibleThing);
				if (result == null) result = caseParameterEdgesSource(visibleThing);
				if (result == null) result = caseEditable(visibleThing);
				if (result == null) result = caseAccessible(visibleThing);
				if (result == null) result = caseContainsConditions(visibleThing);
				if (result == null) result = caseContainsOperations(visibleThing);
				if (result == null) result = caseWireSource(visibleThing);
				if (result == null) result = caseShouldntContainWires(visibleThing);
				if (result == null) result = caseWireDestination(visibleThing);
				if (result == null) result = caseNamedElement(visibleThing);
				if (result == null) result = caseGeneratedElement(visibleThing);
				if (result == null) result = caseGeneratesElements(visibleThing);
				if (result == null) result = caseContainsWires(visibleThing);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.INTERNET_APPLICATION: {
				InternetApplication internetApplication = (InternetApplication)theEObject;
				T result = caseInternetApplication(internetApplication);
				if (result == null) result = caseContainsOperations(internetApplication);
				if (result == null) result = caseNamedElement(internetApplication);
				if (result == null) result = caseContainsWires(internetApplication);
				if (result == null) result = caseGeneratesElements(internetApplication);
				if (result == null) result = caseContainsConditions(internetApplication);
				if (result == null) result = caseGeneratedElement(internetApplication);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.DOMAIN_STORE: {
				DomainStore domainStore = (DomainStore)theEObject;
				T result = caseDomainStore(domainStore);
				if (result == null) result = caseCanBeSynced(domainStore);
				if (result == null) result = caseContainsOperations(domainStore);
				if (result == null) result = caseNamedElement(domainStore);
				if (result == null) result = caseGeneratedElement(domainStore);
				if (result == null) result = caseContainsConditions(domainStore);
				if (result == null) result = caseGeneratesElements(domainStore);
				if (result == null) result = caseWireSource(domainStore);
				if (result == null) result = caseWireDestination(domainStore);
				if (result == null) result = caseShouldntContainWires(domainStore);
				if (result == null) result = caseContainsWires(domainStore);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.DATA_FLOW_EDGE: {
				DataFlowEdge dataFlowEdge = (DataFlowEdge)theEObject;
				T result = caseDataFlowEdge(dataFlowEdge);
				if (result == null) result = caseGeneratedElement(dataFlowEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.DATA_FLOW_EDGE_DESTINATION: {
				DataFlowEdgeDestination dataFlowEdgeDestination = (DataFlowEdgeDestination)theEObject;
				T result = caseDataFlowEdgeDestination(dataFlowEdgeDestination);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.DATA_FLOW_EDGES_SOURCE: {
				DataFlowEdgesSource dataFlowEdgesSource = (DataFlowEdgesSource)theEObject;
				T result = caseDataFlowEdgesSource(dataFlowEdgesSource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.TEMPORARY_VARIABLE: {
				TemporaryVariable temporaryVariable = (TemporaryVariable)theEObject;
				T result = caseTemporaryVariable(temporaryVariable);
				if (result == null) result = caseNamedElement(temporaryVariable);
				if (result == null) result = caseDataFlowEdgesSource(temporaryVariable);
				if (result == null) result = caseDataFlowEdgeDestination(temporaryVariable);
				if (result == null) result = caseGeneratedElement(temporaryVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.EXECUTION_EDGE: {
				ExecutionEdge executionEdge = (ExecutionEdge)theEObject;
				T result = caseExecutionEdge(executionEdge);
				if (result == null) result = caseNamedElement(executionEdge);
				if (result == null) result = caseGeneratedElement(executionEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.EXECUTION_EDGE_DESTINATION: {
				ExecutionEdgeDestination executionEdgeDestination = (ExecutionEdgeDestination)theEObject;
				T result = caseExecutionEdgeDestination(executionEdgeDestination);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.EXECUTION_EDGES_SOURCE: {
				ExecutionEdgesSource executionEdgesSource = (ExecutionEdgesSource)theEObject;
				T result = caseExecutionEdgesSource(executionEdgesSource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CONDITIONAL_EDGE: {
				ConditionalEdge conditionalEdge = (ConditionalEdge)theEObject;
				T result = caseConditionalEdge(conditionalEdge);
				if (result == null) result = caseExecutionEdge(conditionalEdge);
				if (result == null) result = caseNamedElement(conditionalEdge);
				if (result == null) result = caseGeneratedElement(conditionalEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.DYNAMIC_APPLICATION_ELEMENT_SET: {
				DynamicApplicationElementSet dynamicApplicationElementSet = (DynamicApplicationElementSet)theEObject;
				T result = caseDynamicApplicationElementSet(dynamicApplicationElementSet);
				if (result == null) result = caseApplicationElement(dynamicApplicationElementSet);
				if (result == null) result = caseParameterEdgesSource(dynamicApplicationElementSet);
				if (result == null) result = caseCanBeSynced(dynamicApplicationElementSet);
				if (result == null) result = caseContainsOperations(dynamicApplicationElementSet);
				if (result == null) result = caseNamedElement(dynamicApplicationElementSet);
				if (result == null) result = caseGeneratedElement(dynamicApplicationElementSet);
				if (result == null) result = caseWireSource(dynamicApplicationElementSet);
				if (result == null) result = caseShouldntContainWires(dynamicApplicationElementSet);
				if (result == null) result = caseWireDestination(dynamicApplicationElementSet);
				if (result == null) result = caseGeneratesElements(dynamicApplicationElementSet);
				if (result == null) result = caseContainsConditions(dynamicApplicationElementSet);
				if (result == null) result = caseContainsWires(dynamicApplicationElementSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CONTAINS_WIRES: {
				ContainsWires containsWires = (ContainsWires)theEObject;
				T result = caseContainsWires(containsWires);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.SHOULDNT_CONTAIN_WIRES: {
				ShouldntContainWires shouldntContainWires = (ShouldntContainWires)theEObject;
				T result = caseShouldntContainWires(shouldntContainWires);
				if (result == null) result = caseContainsWires(shouldntContainWires);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.GENERATED_ELEMENT: {
				GeneratedElement generatedElement = (GeneratedElement)theEObject;
				T result = caseGeneratedElement(generatedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.GENERATES_ELEMENTS: {
				GeneratesElements generatesElements = (GeneratesElements)theEObject;
				T result = caseGeneratesElements(generatesElements);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.DOMAIN_OBJECT_INSTANCE: {
				DomainObjectInstance domainObjectInstance = (DomainObjectInstance)theEObject;
				T result = caseDomainObjectInstance(domainObjectInstance);
				if (result == null) result = caseApplicationElement(domainObjectInstance);
				if (result == null) result = caseParameterEdgeDestination(domainObjectInstance);
				if (result == null) result = caseParameterEdgesSource(domainObjectInstance);
				if (result == null) result = caseEditable(domainObjectInstance);
				if (result == null) result = caseCanBeSynced(domainObjectInstance);
				if (result == null) result = caseContainsOperations(domainObjectInstance);
				if (result == null) result = caseNamedElement(domainObjectInstance);
				if (result == null) result = caseGeneratedElement(domainObjectInstance);
				if (result == null) result = caseWireSource(domainObjectInstance);
				if (result == null) result = caseShouldntContainWires(domainObjectInstance);
				if (result == null) result = caseWireDestination(domainObjectInstance);
				if (result == null) result = caseGeneratesElements(domainObjectInstance);
				if (result == null) result = caseContainsConditions(domainObjectInstance);
				if (result == null) result = caseContainsWires(domainObjectInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.SCOPE: {
				Scope scope = (Scope)theEObject;
				T result = caseScope(scope);
				if (result == null) result = caseCanBeSynced(scope);
				if (result == null) result = caseAccessible(scope);
				if (result == null) result = caseActionSource(scope);
				if (result == null) result = caseGeneratesElements(scope);
				if (result == null) result = caseNamedElement(scope);
				if (result == null) result = caseGeneratedElement(scope);
				if (result == null) result = caseWireSource(scope);
				if (result == null) result = caseShouldntContainWires(scope);
				if (result == null) result = caseWireDestination(scope);
				if (result == null) result = caseContainsConditions(scope);
				if (result == null) result = caseContainsOperations(scope);
				if (result == null) result = caseContainsWires(scope);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CONDITION: {
				Condition condition = (Condition)theEObject;
				T result = caseCondition(condition);
				if (result == null) result = caseWireSource(condition);
				if (result == null) result = caseDataFlowEdgesSource(condition);
				if (result == null) result = caseNamedElement(condition);
				if (result == null) result = caseConditionEdgesSource(condition);
				if (result == null) result = caseShouldntContainWires(condition);
				if (result == null) result = caseGeneratedElement(condition);
				if (result == null) result = caseContainsWires(condition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.COMPOSITE_CONDITION: {
				CompositeCondition compositeCondition = (CompositeCondition)theEObject;
				T result = caseCompositeCondition(compositeCondition);
				if (result == null) result = caseContainsConditions(compositeCondition);
				if (result == null) result = caseCondition(compositeCondition);
				if (result == null) result = caseGeneratesElements(compositeCondition);
				if (result == null) result = caseContainsOperations(compositeCondition);
				if (result == null) result = caseWireSource(compositeCondition);
				if (result == null) result = caseDataFlowEdgesSource(compositeCondition);
				if (result == null) result = caseNamedElement(compositeCondition);
				if (result == null) result = caseConditionEdgesSource(compositeCondition);
				if (result == null) result = caseShouldntContainWires(compositeCondition);
				if (result == null) result = caseGeneratedElement(compositeCondition);
				if (result == null) result = caseContainsWires(compositeCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CONTAINS_CONDITIONS: {
				ContainsConditions containsConditions = (ContainsConditions)theEObject;
				T result = caseContainsConditions(containsConditions);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.DOMAIN_ATTRIBUTE_INSTANCE: {
				DomainAttributeInstance domainAttributeInstance = (DomainAttributeInstance)theEObject;
				T result = caseDomainAttributeInstance(domainAttributeInstance);
				if (result == null) result = caseApplicationElement(domainAttributeInstance);
				if (result == null) result = caseExtendsEdgesSource(domainAttributeInstance);
				if (result == null) result = caseExtendsEdgeDestination(domainAttributeInstance);
				if (result == null) result = caseEditable(domainAttributeInstance);
				if (result == null) result = caseCanBeSynced(domainAttributeInstance);
				if (result == null) result = caseContainsOperations(domainAttributeInstance);
				if (result == null) result = caseNamedElement(domainAttributeInstance);
				if (result == null) result = caseGeneratedElement(domainAttributeInstance);
				if (result == null) result = caseWireSource(domainAttributeInstance);
				if (result == null) result = caseShouldntContainWires(domainAttributeInstance);
				if (result == null) result = caseWireDestination(domainAttributeInstance);
				if (result == null) result = caseGeneratesElements(domainAttributeInstance);
				if (result == null) result = caseContainsConditions(domainAttributeInstance);
				if (result == null) result = caseContainsWires(domainAttributeInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.QUERY_PARAMETER: {
				QueryParameter queryParameter = (QueryParameter)theEObject;
				T result = caseQueryParameter(queryParameter);
				if (result == null) result = caseNamedElement(queryParameter);
				if (result == null) result = caseWireSource(queryParameter);
				if (result == null) result = caseDataFlowEdgesSource(queryParameter);
				if (result == null) result = caseParameterEdgesSource(queryParameter);
				if (result == null) result = caseGeneratedElement(queryParameter);
				if (result == null) result = caseShouldntContainWires(queryParameter);
				if (result == null) result = caseContainsWires(queryParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CAN_BE_SYNCED: {
				CanBeSynced canBeSynced = (CanBeSynced)theEObject;
				T result = caseCanBeSynced(canBeSynced);
				if (result == null) result = caseNamedElement(canBeSynced);
				if (result == null) result = caseGeneratesElements(canBeSynced);
				if (result == null) result = caseContainsOperations(canBeSynced);
				if (result == null) result = caseContainsConditions(canBeSynced);
				if (result == null) result = caseWireSource(canBeSynced);
				if (result == null) result = caseWireDestination(canBeSynced);
				if (result == null) result = caseGeneratedElement(canBeSynced);
				if (result == null) result = caseShouldntContainWires(canBeSynced);
				if (result == null) result = caseContainsWires(canBeSynced);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.EDITABLE: {
				Editable editable = (Editable)theEObject;
				T result = caseEditable(editable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ACCESSIBLE: {
				Accessible accessible = (Accessible)theEObject;
				T result = caseAccessible(accessible);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ACTION: {
				Action action = (Action)theEObject;
				T result = caseAction(action);
				if (result == null) result = caseGeneratedElement(action);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ACTION_DESTINATION: {
				ActionDestination actionDestination = (ActionDestination)theEObject;
				T result = caseActionDestination(actionDestination);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ACTION_SOURCE: {
				ActionSource actionSource = (ActionSource)theEObject;
				T result = caseActionSource(actionSource);
				if (result == null) result = caseShouldntContainWires(actionSource);
				if (result == null) result = caseContainsWires(actionSource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Wire</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wire</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWire(Wire object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Wire Destination</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wire Destination</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWireDestination(WireDestination object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Wire Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wire Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWireSource(WireSource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Trigger</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventTrigger(EventTrigger object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDomainObject(DomainObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDomainAttribute(DomainAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivityNode(ActivityNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperation(Operation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveOperation(PrimitiveOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeOperation(CompositeOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Contains Operations</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Contains Operations</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainsOperations(ContainsOperations object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Application Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Application Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseApplicationElement(ApplicationElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProperty(Property object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Static Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Static Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStaticValue(StaticValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visible Thing</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visible Thing</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisibleThing(VisibleThing object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Internet Application</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Internet Application</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInternetApplication(InternetApplication object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain Store</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain Store</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDomainStore(DomainStore object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Flow Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Flow Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataFlowEdge(DataFlowEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Flow Edge Destination</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Flow Edge Destination</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataFlowEdgeDestination(DataFlowEdgeDestination object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Flow Edges Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Flow Edges Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataFlowEdgesSource(DataFlowEdgesSource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Temporary Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Temporary Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemporaryVariable(TemporaryVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execution Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execution Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecutionEdge(ExecutionEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execution Edge Destination</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execution Edge Destination</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecutionEdgeDestination(ExecutionEdgeDestination object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execution Edges Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execution Edges Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecutionEdgesSource(ExecutionEdgesSource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conditional Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conditional Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionalEdge(ConditionalEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic Application Element Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic Application Element Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDynamicApplicationElementSet(DynamicApplicationElementSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Contains Wires</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Contains Wires</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainsWires(ContainsWires object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shouldnt Contain Wires</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shouldnt Contain Wires</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShouldntContainWires(ShouldntContainWires object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generated Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generated Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGeneratedElement(GeneratedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generates Elements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generates Elements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGeneratesElements(GeneratesElements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain Object Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain Object Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDomainObjectInstance(DomainObjectInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scope</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scope</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScope(Scope object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCondition(Condition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeCondition(CompositeCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Contains Conditions</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Contains Conditions</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainsConditions(ContainsConditions object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain Attribute Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain Attribute Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDomainAttributeInstance(DomainAttributeInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Query Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Query Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQueryParameter(QueryParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Can Be Synced</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Can Be Synced</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCanBeSynced(CanBeSynced object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Editable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Editable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEditable(Editable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Accessible</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Accessible</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAccessible(Accessible object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAction(Action object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Destination</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Destination</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionDestination(ActionDestination object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionSource(ActionSource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Edges Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Edges Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterEdgesSource(ParameterEdgesSource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extends Edges Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extends Edges Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtendsEdgesSource(ExtendsEdgesSource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extends Edge Destination</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extends Edge Destination</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtendsEdgeDestination(ExtendsEdgeDestination object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Edge Destination</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Edge Destination</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterEdgeDestination(ParameterEdgeDestination object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Condition Edges Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition Edges Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionEdgesSource(ConditionEdgesSource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //ModelSwitch
