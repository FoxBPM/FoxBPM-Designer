/**
 */
package org.foxbpm.model.config.connector;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Widget Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.connector.WidgetExpression#getExpressionValue <em>Expression Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.config.connector.ConnectorPackage#getWidgetExpression()
 * @model extendedMetaData="name='widgetExpression'"
 * @generated
 */
public interface WidgetExpression extends EObject {
	/**
	 * Returns the value of the '<em><b>Expression Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression Value</em>' attribute.
	 * @see #setExpressionValue(String)
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getWidgetExpression_ExpressionValue()
	 * @model extendedMetaData="name='expressionValue' kind='attribute'"
	 * @generated
	 */
	String getExpressionValue();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.connector.WidgetExpression#getExpressionValue <em>Expression Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression Value</em>' attribute.
	 * @see #getExpressionValue()
	 * @generated
	 */
	void setExpressionValue(String value);

} // WidgetExpression
