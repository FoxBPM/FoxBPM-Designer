/**
 */
package org.foxbpm.model.bpmn.foxbpm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connector Instance Elements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstanceElements#getConnrctorType <em>Connrctor Type</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstanceElements#getConnectorInstance <em>Connector Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getConnectorInstanceElements()
 * @model extendedMetaData="name='connectorInstanceElements'"
 * @generated
 */
public interface ConnectorInstanceElements extends EObject {
	/**
	 * Returns the value of the '<em><b>Connrctor Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connrctor Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connrctor Type</em>' attribute.
	 * @see #setConnrctorType(String)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getConnectorInstanceElements_ConnrctorType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getConnrctorType();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstanceElements#getConnrctorType <em>Connrctor Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connrctor Type</em>' attribute.
	 * @see #getConnrctorType()
	 * @generated
	 */
	void setConnrctorType(String value);

	/**
	 * Returns the value of the '<em><b>Connector Instance</b></em>' containment reference list.
	 * The list contents are of type {@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connector Instance</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connector Instance</em>' containment reference list.
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getConnectorInstanceElements_ConnectorInstance()
	 * @model containment="true"
	 *        extendedMetaData="namespace='##targetNamespace' wildcards='' name='connectorInstance' kind='element'"
	 * @generated
	 */
	EList<ConnectorInstance> getConnectorInstance();

} // ConnectorInstanceElements
