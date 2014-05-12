/**
 */
package org.foxbpm.model.config.connectormenu;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.connectormenu.Node#getId <em>Id</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connectormenu.Node#getName <em>Name</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connectormenu.Node#getIco <em>Ico</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connectormenu.Node#getMenuConnector <em>Menu Connector</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connectormenu.Node#getNode <em>Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.config.connectormenu.ConnectormenuPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends EObject {
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
	 * @see org.foxbpm.model.config.connectormenu.ConnectormenuPackage#getNode_Id()
	 * @model extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.connectormenu.Node#getId <em>Id</em>}' attribute.
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
	 * @see org.foxbpm.model.config.connectormenu.ConnectormenuPackage#getNode_Name()
	 * @model extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.connectormenu.Node#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Ico</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ico</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ico</em>' attribute.
	 * @see #setIco(String)
	 * @see org.foxbpm.model.config.connectormenu.ConnectormenuPackage#getNode_Ico()
	 * @model extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getIco();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.connectormenu.Node#getIco <em>Ico</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ico</em>' attribute.
	 * @see #getIco()
	 * @generated
	 */
	void setIco(String value);

	/**
	 * Returns the value of the '<em><b>Menu Connector</b></em>' containment reference list.
	 * The list contents are of type {@link org.foxbpm.model.config.connectormenu.MenuConnector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Menu Connector</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Menu Connector</em>' containment reference list.
	 * @see org.foxbpm.model.config.connectormenu.ConnectormenuPackage#getNode_MenuConnector()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Connector'"
	 * @generated
	 */
	EList<MenuConnector> getMenuConnector();

	/**
	 * Returns the value of the '<em><b>Node</b></em>' containment reference list.
	 * The list contents are of type {@link org.foxbpm.model.config.connectormenu.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' containment reference list.
	 * @see org.foxbpm.model.config.connectormenu.ConnectormenuPackage#getNode_Node()
	 * @model containment="true"
	 *        extendedMetaData="name='node' kind='element'"
	 * @generated
	 */
	EList<Node> getNode();

} // Node
