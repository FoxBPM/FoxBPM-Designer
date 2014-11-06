/**
 */
package org.foxbpm.model.config.connectormenu;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flow Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.connectormenu.FlowConnector#getNode <em>Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.config.connectormenu.ConnectormenuPackage#getFlowConnector()
 * @model
 * @generated
 */
public interface FlowConnector extends EObject {
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
	 * @see org.foxbpm.model.config.connectormenu.ConnectormenuPackage#getFlowConnector_Node()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Node' namespace=''"
	 * @generated
	 */
	EList<Node> getNode();

} // FlowConnector
