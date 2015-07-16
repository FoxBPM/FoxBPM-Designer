/**
 */
package org.foxbpm.model.bpmn.foxbpm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Receive Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ReceiveMessage#getMessageId <em>Message Id</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ReceiveMessage#getFilterConditions <em>Filter Conditions</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ReceiveMessage#getProcessInstanceVariable <em>Process Instance Variable</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ReceiveMessage#getTokenVariable <em>Token Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getReceiveMessage()
 * @model extendedMetaData="name='receiveMessage'"
 * @generated
 */
public interface ReceiveMessage extends EObject {
	/**
	 * Returns the value of the '<em><b>Message Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message Id</em>' attribute.
	 * @see #setMessageId(String)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getReceiveMessage_MessageId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="name='messageId' kind='attribute'"
	 * @generated
	 */
	String getMessageId();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.ReceiveMessage#getMessageId <em>Message Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Id</em>' attribute.
	 * @see #getMessageId()
	 * @generated
	 */
	void setMessageId(String value);

	/**
	 * Returns the value of the '<em><b>Filter Conditions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter Conditions</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filter Conditions</em>' containment reference.
	 * @see #setFilterConditions(FilterConditions)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getReceiveMessage_FilterConditions()
	 * @model containment="true"
	 *        extendedMetaData="name='filterConditions' kind='element' namespace='##targetNamespace'"
	 * @generated
	 */
	FilterConditions getFilterConditions();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.ReceiveMessage#getFilterConditions <em>Filter Conditions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter Conditions</em>' containment reference.
	 * @see #getFilterConditions()
	 * @generated
	 */
	void setFilterConditions(FilterConditions value);

	/**
	 * Returns the value of the '<em><b>Process Instance Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process Instance Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process Instance Variable</em>' containment reference.
	 * @see #setProcessInstanceVariable(ProcessInstanceVariable)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getReceiveMessage_ProcessInstanceVariable()
	 * @model containment="true"
	 *        extendedMetaData="name='processInstanceVariable' kind='element' namespace='##targetNamespace'"
	 * @generated
	 */
	ProcessInstanceVariable getProcessInstanceVariable();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.ReceiveMessage#getProcessInstanceVariable <em>Process Instance Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Process Instance Variable</em>' containment reference.
	 * @see #getProcessInstanceVariable()
	 * @generated
	 */
	void setProcessInstanceVariable(ProcessInstanceVariable value);

	/**
	 * Returns the value of the '<em><b>Token Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Token Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Token Variable</em>' containment reference.
	 * @see #setTokenVariable(TokenVariable)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getReceiveMessage_TokenVariable()
	 * @model containment="true"
	 *        extendedMetaData="name='tokenVariable' kind='element' namespace='##targetNamespace' wildcards=''"
	 * @generated
	 */
	TokenVariable getTokenVariable();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.ReceiveMessage#getTokenVariable <em>Token Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Token Variable</em>' containment reference.
	 * @see #getTokenVariable()
	 * @generated
	 */
	void setTokenVariable(TokenVariable value);

} // ReceiveMessage
