/**
 */
package org.foxbpm.model.bpmn.foxbpm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connector Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getConnectorId <em>Connector Id</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getPackageName <em>Package Name</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getConnectorInstanceId <em>Connector Instance Id</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getConnectorInstanceName <em>Connector Instance Name</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getEventType <em>Event Type</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getErrorHandling <em>Error Handling</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getErrorCode <em>Error Code</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getConnectorParameterInputs <em>Connector Parameter Inputs</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getConnectorParameterOutputs <em>Connector Parameter Outputs</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getConnectorParameterOutputsDef <em>Connector Parameter Outputs Def</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getSkipComment <em>Skip Comment</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getTimeExpression <em>Time Expression</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#isIsTimeExecute <em>Is Time Execute</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getTimeSkipExpression <em>Time Skip Expression</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getVersion <em>Version</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getType <em>Type</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getDocumentation <em>Documentation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getConnectorInstance()
 * @model
 * @generated
 */
public interface ConnectorInstance extends EObject {
	/**
	 * Returns the value of the '<em><b>Connector Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connector Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connector Id</em>' attribute.
	 * @see #setConnectorId(String)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getConnectorInstance_ConnectorId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getConnectorId();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getConnectorId <em>Connector Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connector Id</em>' attribute.
	 * @see #getConnectorId()
	 * @generated
	 */
	void setConnectorId(String value);

	/**
	 * Returns the value of the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package Name</em>' attribute.
	 * @see #setPackageName(String)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getConnectorInstance_PackageName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getPackageName();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getPackageName <em>Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package Name</em>' attribute.
	 * @see #getPackageName()
	 * @generated
	 */
	void setPackageName(String value);

	/**
	 * Returns the value of the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Name</em>' attribute.
	 * @see #setClassName(String)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getConnectorInstance_ClassName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getClassName();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getClassName <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Name</em>' attribute.
	 * @see #getClassName()
	 * @generated
	 */
	void setClassName(String value);

	/**
	 * Returns the value of the '<em><b>Connector Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connector Instance Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connector Instance Id</em>' attribute.
	 * @see #setConnectorInstanceId(String)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getConnectorInstance_ConnectorInstanceId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getConnectorInstanceId();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getConnectorInstanceId <em>Connector Instance Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connector Instance Id</em>' attribute.
	 * @see #getConnectorInstanceId()
	 * @generated
	 */
	void setConnectorInstanceId(String value);

	/**
	 * Returns the value of the '<em><b>Connector Instance Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connector Instance Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connector Instance Name</em>' attribute.
	 * @see #setConnectorInstanceName(String)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getConnectorInstance_ConnectorInstanceName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getConnectorInstanceName();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getConnectorInstanceName <em>Connector Instance Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connector Instance Name</em>' attribute.
	 * @see #getConnectorInstanceName()
	 * @generated
	 */
	void setConnectorInstanceName(String value);

	/**
	 * Returns the value of the '<em><b>Event Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Type</em>' attribute.
	 * @see #setEventType(String)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getConnectorInstance_EventType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getEventType();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getEventType <em>Event Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Type</em>' attribute.
	 * @see #getEventType()
	 * @generated
	 */
	void setEventType(String value);

	/**
	 * Returns the value of the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Documentation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Documentation</em>' containment reference.
	 * @see #setDocumentation(Documentation)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getConnectorInstance_Documentation()
	 * @model containment="true"
	 *        extendedMetaData="name='documentation' kind='element' namespace='##targetNamespace'"
	 * @generated
	 */
	Documentation getDocumentation();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getDocumentation <em>Documentation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Documentation</em>' containment reference.
	 * @see #getDocumentation()
	 * @generated
	 */
	void setDocumentation(Documentation value);

	/**
	 * Returns the value of the '<em><b>Error Handling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Handling</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Handling</em>' attribute.
	 * @see #setErrorHandling(String)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getConnectorInstance_ErrorHandling()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getErrorHandling();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getErrorHandling <em>Error Handling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error Handling</em>' attribute.
	 * @see #getErrorHandling()
	 * @generated
	 */
	void setErrorHandling(String value);

	/**
	 * Returns the value of the '<em><b>Error Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Code</em>' attribute.
	 * @see #setErrorCode(String)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getConnectorInstance_ErrorCode()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getErrorCode();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getErrorCode <em>Error Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error Code</em>' attribute.
	 * @see #getErrorCode()
	 * @generated
	 */
	void setErrorCode(String value);

	/**
	 * Returns the value of the '<em><b>Connector Parameter Inputs</b></em>' containment reference list.
	 * The list contents are of type {@link org.foxbpm.model.bpmn.foxbpm.ConnectorParameterInput}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connector Parameter Inputs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connector Parameter Inputs</em>' containment reference list.
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getConnectorInstance_ConnectorParameterInputs()
	 * @model containment="true"
	 *        extendedMetaData="namespace='##targetNamespace' kind='element'"
	 * @generated
	 */
	EList<ConnectorParameterInput> getConnectorParameterInputs();

	/**
	 * Returns the value of the '<em><b>Connector Parameter Outputs</b></em>' containment reference list.
	 * The list contents are of type {@link org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutput}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connector Parameter Outputs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connector Parameter Outputs</em>' containment reference list.
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getConnectorInstance_ConnectorParameterOutputs()
	 * @model containment="true"
	 *        extendedMetaData="namespace='##targetNamespace' name='connectorParameterOutputs' kind='element'"
	 * @generated
	 */
	EList<ConnectorParameterOutput> getConnectorParameterOutputs();

	/**
	 * Returns the value of the '<em><b>Connector Parameter Outputs Def</b></em>' containment reference list.
	 * The list contents are of type {@link org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutputDef}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connector Parameter Outputs Def</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connector Parameter Outputs Def</em>' containment reference list.
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getConnectorInstance_ConnectorParameterOutputsDef()
	 * @model containment="true"
	 *        extendedMetaData="name='connectorParameterOutputsDef' namespace='##targetNamespace' kind='element'"
	 * @generated
	 */
	EList<ConnectorParameterOutputDef> getConnectorParameterOutputsDef();

	/**
	 * Returns the value of the '<em><b>Skip Comment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Skip Comment</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Skip Comment</em>' containment reference.
	 * @see #setSkipComment(SkipComment)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getConnectorInstance_SkipComment()
	 * @model containment="true"
	 *        extendedMetaData="namespace='##targetNamespace' name='skipComment' kind='element'"
	 * @generated
	 */
	SkipComment getSkipComment();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getSkipComment <em>Skip Comment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Skip Comment</em>' containment reference.
	 * @see #getSkipComment()
	 * @generated
	 */
	void setSkipComment(SkipComment value);

	/**
	 * Returns the value of the '<em><b>Time Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Expression</em>' containment reference.
	 * @see #setTimeExpression(TimeExpression)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getConnectorInstance_TimeExpression()
	 * @model containment="true"
	 *        extendedMetaData="name='timeExpression' kind='element' namespace='##targetNamespace'"
	 * @generated
	 */
	TimeExpression getTimeExpression();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getTimeExpression <em>Time Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Expression</em>' containment reference.
	 * @see #getTimeExpression()
	 * @generated
	 */
	void setTimeExpression(TimeExpression value);

	/**
	 * Returns the value of the '<em><b>Is Time Execute</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Time Execute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Time Execute</em>' attribute.
	 * @see #setIsTimeExecute(boolean)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getConnectorInstance_IsTimeExecute()
	 * @model default="false" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute'"
	 * @generated
	 */
	boolean isIsTimeExecute();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#isIsTimeExecute <em>Is Time Execute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Time Execute</em>' attribute.
	 * @see #isIsTimeExecute()
	 * @generated
	 */
	void setIsTimeExecute(boolean value);

	/**
	 * Returns the value of the '<em><b>Time Skip Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Skip Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Skip Expression</em>' containment reference.
	 * @see #setTimeSkipExpression(TimeSkipExpression)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getConnectorInstance_TimeSkipExpression()
	 * @model containment="true"
	 *        extendedMetaData="name='timeSkipExpression' kind='element' namespace='##targetNamespace'"
	 * @generated
	 */
	TimeSkipExpression getTimeSkipExpression();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getTimeSkipExpression <em>Time Skip Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Skip Expression</em>' containment reference.
	 * @see #getTimeSkipExpression()
	 * @generated
	 */
	void setTimeSkipExpression(TimeSkipExpression value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getConnectorInstance_Version()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * "actorconnector" "flowconnector"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getConnectorInstance_Type()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // ConnectorInstance
