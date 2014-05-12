/**
 */
package org.foxbpm.model.config.connector;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.connector.Group#getOptional <em>Optional</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.Group#getWidget <em>Widget</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.config.connector.ConnectorPackage#getGroup()
 * @model extendedMetaData="name='group'"
 * @generated
 */
public interface Group extends Widget {
	/**
	 * Returns the value of the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optional</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Optional</em>' attribute.
	 * @see #setOptional(String)
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getGroup_Optional()
	 * @model extendedMetaData="name='optional' kind='attribute'"
	 * @generated
	 */
	String getOptional();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.connector.Group#getOptional <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optional</em>' attribute.
	 * @see #getOptional()
	 * @generated
	 */
	void setOptional(String value);

	/**
	 * Returns the value of the '<em><b>Widget</b></em>' containment reference list.
	 * The list contents are of type {@link org.foxbpm.model.config.connector.Widget}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Widget</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Widget</em>' containment reference list.
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getGroup_Widget()
	 * @model containment="true"
	 *        extendedMetaData="name='widget' kind='element'"
	 * @generated
	 */
	EList<Widget> getWidget();

} // Group
