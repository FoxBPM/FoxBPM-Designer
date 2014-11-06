/**
 */
package org.foxbpm.model.config.connectormenu;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Menu</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.connectormenu.Menu#getFlowConnector <em>Flow Connector</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connectormenu.Menu#getActorConnector <em>Actor Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.config.connectormenu.ConnectormenuPackage#getMenu()
 * @model extendedMetaData="name='menu'"
 * @generated
 */
public interface Menu extends EObject {
	/**
	 * Returns the value of the '<em><b>Flow Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flow Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flow Connector</em>' containment reference.
	 * @see #setFlowConnector(FlowConnector)
	 * @see org.foxbpm.model.config.connectormenu.ConnectormenuPackage#getMenu_FlowConnector()
	 * @model containment="true" required="true"
	 *        extendedMetaData="name='FlowConnector' namespace='' kind='element'"
	 * @generated
	 */
	FlowConnector getFlowConnector();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.connectormenu.Menu#getFlowConnector <em>Flow Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flow Connector</em>' containment reference.
	 * @see #getFlowConnector()
	 * @generated
	 */
	void setFlowConnector(FlowConnector value);

	/**
	 * Returns the value of the '<em><b>Actor Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actor Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actor Connector</em>' containment reference.
	 * @see #setActorConnector(ActorConnector)
	 * @see org.foxbpm.model.config.connectormenu.ConnectormenuPackage#getMenu_ActorConnector()
	 * @model containment="true" required="true"
	 *        extendedMetaData="name='ActorConnector' kind='element'"
	 * @generated
	 */
	ActorConnector getActorConnector();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.connectormenu.Menu#getActorConnector <em>Actor Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actor Connector</em>' containment reference.
	 * @see #getActorConnector()
	 * @generated
	 */
	void setActorConnector(ActorConnector value);

} // Menu
