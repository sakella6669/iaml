/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openiaml.model.model.components;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entry Gate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * When placed into a {@model Scope} (including {@model Session}), all {@model Page} accesses within that Scope must first execute this {@model Gate}. If all incoming {@model ConditionWire}s are true, then access to this {@model Scope} is denied until such time any {@model ConditionWire}s becomes false.
 * <!-- end-model-doc -->
 *
 *
 * @see org.openiaml.model.model.components.ComponentsPackage#getEntryGate()
 * @model annotation="http://openiaml.org/comment added='0.4.2'"
 * @generated
 */
public interface EntryGate extends Gate {
} // EntryGate
