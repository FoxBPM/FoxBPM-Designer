/**
 */
package org.foxbpm.model.bpmn.foxbpm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.TableExpression#getExpressions <em>Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getTableExpression()
 * @model extendedMetaData="name='tableExpression'"
 * @generated
 */
public interface TableExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link org.foxbpm.model.bpmn.foxbpm.ListExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expressions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expressions</em>' containment reference list.
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getTableExpression_Expressions()
	 * @model containment="true"
	 *        extendedMetaData="name='expressions' kind='element' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ListExpression> getExpressions();

} // TableExpression
