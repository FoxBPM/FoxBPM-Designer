/**
 */
package org.foxbpm.model.config.connector;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Select</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.connector.Select#getItems <em>Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.config.connector.ConnectorPackage#getSelect()
 * @model extendedMetaData="name='select'"
 * @generated
 */
public interface Select extends Widget {
	/**
	 * Returns the value of the '<em><b>Items</b></em>' containment reference list.
	 * The list contents are of type {@link org.foxbpm.model.config.connector.Items}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' containment reference list.
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getSelect_Items()
	 * @model containment="true"
	 *        extendedMetaData="name='items' kind='element'"
	 * @generated
	 */
	EList<Items> getItems();

} // Select
