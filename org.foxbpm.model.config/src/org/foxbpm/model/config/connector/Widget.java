/**
 */
package org.foxbpm.model.config.connector;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Widget</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.connector.Widget#getId <em>Id</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.Widget#getName <em>Name</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.Widget#getInputId <em>Input Id</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.Widget#getWidgetExpression <em>Widget Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.config.connector.ConnectorPackage#getWidget()
 * @model abstract="true"
 *        extendedMetaData="name='widget'"
 * @generated
 */
public interface Widget extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getWidget_Id()
	 * @model extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.connector.Widget#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getWidget_Name()
	 * @model extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.connector.Widget#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Input Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Id</em>' attribute.
	 * @see #setInputId(String)
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getWidget_InputId()
	 * @model extendedMetaData="name='inputId' kind='attribute'"
	 * @generated
	 */
	String getInputId();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.connector.Widget#getInputId <em>Input Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Id</em>' attribute.
	 * @see #getInputId()
	 * @generated
	 */
	void setInputId(String value);

	/**
	 * Returns the value of the '<em><b>Widget Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Widget Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Widget Expression</em>' containment reference.
	 * @see #setWidgetExpression(WidgetExpression)
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getWidget_WidgetExpression()
	 * @model containment="true"
	 *        extendedMetaData="name='widgetExpression' kind='element'"
	 * @generated
	 */
	WidgetExpression getWidgetExpression();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.connector.Widget#getWidgetExpression <em>Widget Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Widget Expression</em>' containment reference.
	 * @see #getWidgetExpression()
	 * @generated
	 */
	void setWidgetExpression(WidgetExpression value);

} // Widget
