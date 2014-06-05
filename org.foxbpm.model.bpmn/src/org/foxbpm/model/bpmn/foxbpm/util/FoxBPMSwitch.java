/**
 */
package org.foxbpm.model.bpmn.foxbpm.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.foxbpm.model.bpmn.foxbpm.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage
 * @generated
 */
public class FoxBPMSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static FoxBPMPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FoxBPMSwitch() {
		if (modelPackage == null) {
			modelPackage = FoxBPMPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case FoxBPMPackage.DOCUMENT_ROOT: {
				DocumentRoot documentRoot = (DocumentRoot)theEObject;
				T result = caseDocumentRoot(documentRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.EXPRESSION: {
				Expression expression = (Expression)theEObject;
				T result = caseExpression(expression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.TASK_SUBJECT: {
				TaskSubject taskSubject = (TaskSubject)theEObject;
				T result = caseTaskSubject(taskSubject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.TASK_COMMAND: {
				TaskCommand taskCommand = (TaskCommand)theEObject;
				T result = caseTaskCommand(taskCommand);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.RESOURCE_FILTER: {
				ResourceFilter resourceFilter = (ResourceFilter)theEObject;
				T result = caseResourceFilter(resourceFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.DATA_VARIABLE: {
				DataVariable dataVariable = (DataVariable)theEObject;
				T result = caseDataVariable(dataVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.DOCUMENTATION: {
				Documentation documentation = (Documentation)theEObject;
				T result = caseDocumentation(documentation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.CONNECTOR_INSTANCE: {
				ConnectorInstance connectorInstance = (ConnectorInstance)theEObject;
				T result = caseConnectorInstance(connectorInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.CONNECTOR_PARAMETER_INPUT: {
				ConnectorParameterInput connectorParameterInput = (ConnectorParameterInput)theEObject;
				T result = caseConnectorParameterInput(connectorParameterInput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.CONNECTOR_PARAMETER_OUTPUT: {
				ConnectorParameterOutput connectorParameterOutput = (ConnectorParameterOutput)theEObject;
				T result = caseConnectorParameterOutput(connectorParameterOutput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.LOOP_DATA_INPUT_COLLECTION: {
				LoopDataInputCollection loopDataInputCollection = (LoopDataInputCollection)theEObject;
				T result = caseLoopDataInputCollection(loopDataInputCollection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.LOOP_DATA_OUTPUT_COLLECTION: {
				LoopDataOutputCollection loopDataOutputCollection = (LoopDataOutputCollection)theEObject;
				T result = caseLoopDataOutputCollection(loopDataOutputCollection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.CONNECTOR_PARAMETER_OUTPUT_DEF: {
				ConnectorParameterOutputDef connectorParameterOutputDef = (ConnectorParameterOutputDef)theEObject;
				T result = caseConnectorParameterOutputDef(connectorParameterOutputDef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.FORM_URI: {
				FormUri formUri = (FormUri)theEObject;
				T result = caseFormUri(formUri);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.LOOP_MAXIMUM: {
				LoopMaximum loopMaximum = (LoopMaximum)theEObject;
				T result = caseLoopMaximum(loopMaximum);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.SKIP_STRATEGY: {
				SkipStrategy skipStrategy = (SkipStrategy)theEObject;
				T result = caseSkipStrategy(skipStrategy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.MESSAGE_OBJ: {
				MessageObj messageObj = (MessageObj)theEObject;
				T result = caseMessageObj(messageObj);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.FILTER_CONDITIONS: {
				FilterConditions filterConditions = (FilterConditions)theEObject;
				T result = caseFilterConditions(filterConditions);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.RECEIVE_MESSAGE: {
				ReceiveMessage receiveMessage = (ReceiveMessage)theEObject;
				T result = caseReceiveMessage(receiveMessage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.TOKEN_VARIABLE: {
				TokenVariable tokenVariable = (TokenVariable)theEObject;
				T result = caseTokenVariable(tokenVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.PROCESS_INSTANCE_VARIABLE: {
				ProcessInstanceVariable processInstanceVariable = (ProcessInstanceVariable)theEObject;
				T result = caseProcessInstanceVariable(processInstanceVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.EXPECTED_EXECUTION_TIME: {
				ExpectedExecutionTime expectedExecutionTime = (ExpectedExecutionTime)theEObject;
				T result = caseExpectedExecutionTime(expectedExecutionTime);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.DATA_SOURCE_TO_SUB_PROCESS_MAPPING: {
				DataSourceToSubProcessMapping dataSourceToSubProcessMapping = (DataSourceToSubProcessMapping)theEObject;
				T result = caseDataSourceToSubProcessMapping(dataSourceToSubProcessMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.SUB_PROCESS_TO_DATA_SOURCE_MAPPING: {
				SubProcessToDataSourceMapping subProcessToDataSourceMapping = (SubProcessToDataSourceMapping)theEObject;
				T result = caseSubProcessToDataSourceMapping(subProcessToDataSourceMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.DATA_VARIABLE_MAPPING: {
				DataVariableMapping dataVariableMapping = (DataVariableMapping)theEObject;
				T result = caseDataVariableMapping(dataVariableMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.FORM_URI_VIEW: {
				FormUriView formUriView = (FormUriView)theEObject;
				T result = caseFormUriView(formUriView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.TASK_PRIORITY: {
				TaskPriority taskPriority = (TaskPriority)theEObject;
				T result = caseTaskPriority(taskPriority);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.ASSIGN_POLICY_TYPE: {
				AssignPolicyType assignPolicyType = (AssignPolicyType)theEObject;
				T result = caseAssignPolicyType(assignPolicyType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.SKIP_ASSIGNEE: {
				SkipAssignee skipAssignee = (SkipAssignee)theEObject;
				T result = caseSkipAssignee(skipAssignee);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.SKIP_COMMENT: {
				SkipComment skipComment = (SkipComment)theEObject;
				T result = caseSkipComment(skipComment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.CONNECTOR_INSTANCE_ELEMENTS: {
				ConnectorInstanceElements connectorInstanceElements = (ConnectorInstanceElements)theEObject;
				T result = caseConnectorInstanceElements(connectorInstanceElements);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.TIME_EXPRESSION: {
				TimeExpression timeExpression = (TimeExpression)theEObject;
				T result = caseTimeExpression(timeExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.TIME_SKIP_EXPRESSION: {
				TimeSkipExpression timeSkipExpression = (TimeSkipExpression)theEObject;
				T result = caseTimeSkipExpression(timeSkipExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.TABLE_EXPRESSION: {
				TableExpression tableExpression = (TableExpression)theEObject;
				T result = caseTableExpression(tableExpression);
				if (result == null) result = caseExpression(tableExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.LIST_EXPRESSION: {
				ListExpression listExpression = (ListExpression)theEObject;
				T result = caseListExpression(listExpression);
				if (result == null) result = caseExpression(listExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.TASK_DESCRIPTION: {
				TaskDescription taskDescription = (TaskDescription)theEObject;
				T result = caseTaskDescription(taskDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.COMPLETE_TASK_DESCRIPTION: {
				CompleteTaskDescription completeTaskDescription = (CompleteTaskDescription)theEObject;
				T result = caseCompleteTaskDescription(completeTaskDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.FORM_PARAM_CONTAINER: {
				FormParamContainer formParamContainer = (FormParamContainer)theEObject;
				T result = caseFormParamContainer(formParamContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMPackage.FORM_PARAM: {
				FormParam formParam = (FormParam)theEObject;
				T result = caseFormParam(formParam);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocumentRoot(DocumentRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpression(Expression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task Subject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task Subject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaskSubject(TaskSubject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task Command</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task Command</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaskCommand(TaskCommand object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceFilter(ResourceFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataVariable(DataVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Documentation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Documentation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocumentation(Documentation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectorInstance(ConnectorInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector Parameter Input</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector Parameter Input</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectorParameterInput(ConnectorParameterInput object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector Parameter Output</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector Parameter Output</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectorParameterOutput(ConnectorParameterOutput object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Data Input Collection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Data Input Collection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoopDataInputCollection(LoopDataInputCollection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Data Output Collection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Data Output Collection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoopDataOutputCollection(LoopDataOutputCollection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector Parameter Output Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector Parameter Output Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectorParameterOutputDef(ConnectorParameterOutputDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Form Uri</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Form Uri</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFormUri(FormUri object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Maximum</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Maximum</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoopMaximum(LoopMaximum object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Skip Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Skip Strategy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSkipStrategy(SkipStrategy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message Obj</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Obj</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMessageObj(MessageObj object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Filter Conditions</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Filter Conditions</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFilterConditions(FilterConditions object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Receive Message</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Receive Message</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReceiveMessage(ReceiveMessage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Token Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Token Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTokenVariable(TokenVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Instance Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Instance Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessInstanceVariable(ProcessInstanceVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expected Execution Time</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expected Execution Time</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpectedExecutionTime(ExpectedExecutionTime object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Source To Sub Process Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Source To Sub Process Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataSourceToSubProcessMapping(DataSourceToSubProcessMapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub Process To Data Source Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub Process To Data Source Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubProcessToDataSourceMapping(SubProcessToDataSourceMapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Variable Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Variable Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataVariableMapping(DataVariableMapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Form Uri View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Form Uri View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFormUriView(FormUriView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task Priority</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task Priority</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaskPriority(TaskPriority object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assign Policy Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assign Policy Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssignPolicyType(AssignPolicyType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Skip Assignee</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Skip Assignee</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSkipAssignee(SkipAssignee object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Skip Comment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Skip Comment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSkipComment(SkipComment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector Instance Elements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector Instance Elements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectorInstanceElements(ConnectorInstanceElements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Time Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Time Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimeExpression(TimeExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Time Skip Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Time Skip Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimeSkipExpression(TimeSkipExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Table Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Table Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTableExpression(TableExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>List Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>List Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseListExpression(ListExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaskDescription(TaskDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complete Task Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complete Task Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompleteTaskDescription(CompleteTaskDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Form Param Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Form Param Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFormParamContainer(FormParamContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Form Param</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Form Param</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFormParam(FormParam object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //FoxBPMSwitch
