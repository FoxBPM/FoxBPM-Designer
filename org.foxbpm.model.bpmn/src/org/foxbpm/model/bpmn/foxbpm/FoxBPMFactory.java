/**
 */
package org.foxbpm.model.bpmn.foxbpm;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage
 * @generated
 */
public interface FoxBPMFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FoxBPMFactory eINSTANCE = org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Document Root</em>'.
	 * @generated
	 */
	DocumentRoot createDocumentRoot();

	/**
	 * Returns a new object of class '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression</em>'.
	 * @generated
	 */
	Expression createExpression();

	/**
	 * Returns a new object of class '<em>Task Subject</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Task Subject</em>'.
	 * @generated
	 */
	TaskSubject createTaskSubject();

	/**
	 * Returns a new object of class '<em>Task Command</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Task Command</em>'.
	 * @generated
	 */
	TaskCommand createTaskCommand();

	/**
	 * Returns a new object of class '<em>Resource Filter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Filter</em>'.
	 * @generated
	 */
	ResourceFilter createResourceFilter();

	/**
	 * Returns a new object of class '<em>Data Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Variable</em>'.
	 * @generated
	 */
	DataVariable createDataVariable();

	/**
	 * Returns a new object of class '<em>Documentation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Documentation</em>'.
	 * @generated
	 */
	Documentation createDocumentation();

	/**
	 * Returns a new object of class '<em>Connector Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connector Instance</em>'.
	 * @generated
	 */
	ConnectorInstance createConnectorInstance();

	/**
	 * Returns a new object of class '<em>Connector Parameter Input</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connector Parameter Input</em>'.
	 * @generated
	 */
	ConnectorParameterInput createConnectorParameterInput();

	/**
	 * Returns a new object of class '<em>Connector Parameter Output</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connector Parameter Output</em>'.
	 * @generated
	 */
	ConnectorParameterOutput createConnectorParameterOutput();

	/**
	 * Returns a new object of class '<em>Loop Data Input Collection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Loop Data Input Collection</em>'.
	 * @generated
	 */
	LoopDataInputCollection createLoopDataInputCollection();

	/**
	 * Returns a new object of class '<em>Loop Data Output Collection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Loop Data Output Collection</em>'.
	 * @generated
	 */
	LoopDataOutputCollection createLoopDataOutputCollection();

	/**
	 * Returns a new object of class '<em>Connector Parameter Output Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connector Parameter Output Def</em>'.
	 * @generated
	 */
	ConnectorParameterOutputDef createConnectorParameterOutputDef();

	/**
	 * Returns a new object of class '<em>Form Uri</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Form Uri</em>'.
	 * @generated
	 */
	FormUri createFormUri();

	/**
	 * Returns a new object of class '<em>Loop Maximum</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Loop Maximum</em>'.
	 * @generated
	 */
	LoopMaximum createLoopMaximum();

	/**
	 * Returns a new object of class '<em>Skip Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Skip Strategy</em>'.
	 * @generated
	 */
	SkipStrategy createSkipStrategy();

	/**
	 * Returns a new object of class '<em>Message Obj</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Message Obj</em>'.
	 * @generated
	 */
	MessageObj createMessageObj();

	/**
	 * Returns a new object of class '<em>Filter Conditions</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Filter Conditions</em>'.
	 * @generated
	 */
	FilterConditions createFilterConditions();

	/**
	 * Returns a new object of class '<em>Receive Message</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Receive Message</em>'.
	 * @generated
	 */
	ReceiveMessage createReceiveMessage();

	/**
	 * Returns a new object of class '<em>Token Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Token Variable</em>'.
	 * @generated
	 */
	TokenVariable createTokenVariable();

	/**
	 * Returns a new object of class '<em>Process Instance Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process Instance Variable</em>'.
	 * @generated
	 */
	ProcessInstanceVariable createProcessInstanceVariable();

	/**
	 * Returns a new object of class '<em>Expected Execution Time</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expected Execution Time</em>'.
	 * @generated
	 */
	ExpectedExecutionTime createExpectedExecutionTime();

	/**
	 * Returns a new object of class '<em>Data Source To Sub Process Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Source To Sub Process Mapping</em>'.
	 * @generated
	 */
	DataSourceToSubProcessMapping createDataSourceToSubProcessMapping();

	/**
	 * Returns a new object of class '<em>Sub Process To Data Source Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Process To Data Source Mapping</em>'.
	 * @generated
	 */
	SubProcessToDataSourceMapping createSubProcessToDataSourceMapping();

	/**
	 * Returns a new object of class '<em>Data Variable Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Variable Mapping</em>'.
	 * @generated
	 */
	DataVariableMapping createDataVariableMapping();

	/**
	 * Returns a new object of class '<em>Form Uri View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Form Uri View</em>'.
	 * @generated
	 */
	FormUriView createFormUriView();

	/**
	 * Returns a new object of class '<em>Task Priority</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Task Priority</em>'.
	 * @generated
	 */
	TaskPriority createTaskPriority();

	/**
	 * Returns a new object of class '<em>Assign Policy Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assign Policy Type</em>'.
	 * @generated
	 */
	AssignPolicyType createAssignPolicyType();

	/**
	 * Returns a new object of class '<em>Skip Assignee</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Skip Assignee</em>'.
	 * @generated
	 */
	SkipAssignee createSkipAssignee();

	/**
	 * Returns a new object of class '<em>Skip Comment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Skip Comment</em>'.
	 * @generated
	 */
	SkipComment createSkipComment();

	/**
	 * Returns a new object of class '<em>Connector Instance Elements</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connector Instance Elements</em>'.
	 * @generated
	 */
	ConnectorInstanceElements createConnectorInstanceElements();

	/**
	 * Returns a new object of class '<em>Time Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Time Expression</em>'.
	 * @generated
	 */
	TimeExpression createTimeExpression();

	/**
	 * Returns a new object of class '<em>Time Skip Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Time Skip Expression</em>'.
	 * @generated
	 */
	TimeSkipExpression createTimeSkipExpression();

	/**
	 * Returns a new object of class '<em>Table Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Table Expression</em>'.
	 * @generated
	 */
	TableExpression createTableExpression();

	/**
	 * Returns a new object of class '<em>List Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>List Expression</em>'.
	 * @generated
	 */
	ListExpression createListExpression();

	/**
	 * Returns a new object of class '<em>Task Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Task Description</em>'.
	 * @generated
	 */
	TaskDescription createTaskDescription();

	/**
	 * Returns a new object of class '<em>Complete Task Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complete Task Description</em>'.
	 * @generated
	 */
	CompleteTaskDescription createCompleteTaskDescription();

	/**
	 * Returns a new object of class '<em>Form Param Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Form Param Container</em>'.
	 * @generated
	 */
	FormParamContainer createFormParamContainer();

	/**
	 * Returns a new object of class '<em>Form Param</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Form Param</em>'.
	 * @generated
	 */
	FormParam createFormParam();

	/**
	 * Returns a new object of class '<em>Base Config</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Base Config</em>'.
	 * @generated
	 */
	BaseConfig createBaseConfig();

	/**
	 * Returns a new object of class '<em>Param</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Param</em>'.
	 * @generated
	 */
	Param createParam();

	/**
	 * Returns a new object of class '<em>Potential Starter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Potential Starter</em>'.
	 * @generated
	 */
	PotentialStarter createPotentialStarter();

	/**
	 * Returns a new object of class '<em>Potential Owner</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Potential Owner</em>'.
	 * @generated
	 */
	PotentialOwner createPotentialOwner();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	FoxBPMPackage getFoxBPMPackage();

} //FoxBPMFactory
