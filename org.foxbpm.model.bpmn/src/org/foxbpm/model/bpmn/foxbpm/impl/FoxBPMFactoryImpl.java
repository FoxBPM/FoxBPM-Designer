/**
 */
package org.foxbpm.model.bpmn.foxbpm.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.foxbpm.model.bpmn.foxbpm.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FoxBPMFactoryImpl extends EFactoryImpl implements FoxBPMFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FoxBPMFactory init() {
		try {
			FoxBPMFactory theFoxBPMFactory = (FoxBPMFactory)EPackage.Registry.INSTANCE.getEFactory(FoxBPMPackage.eNS_URI);
			if (theFoxBPMFactory != null) {
				return theFoxBPMFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FoxBPMFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FoxBPMFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case FoxBPMPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case FoxBPMPackage.EXPRESSION: return createExpression();
			case FoxBPMPackage.TASK_SUBJECT: return createTaskSubject();
			case FoxBPMPackage.TASK_COMMAND_MODEL: return createTaskCommandModel();
			case FoxBPMPackage.RESOURCE_FILTER: return createResourceFilter();
			case FoxBPMPackage.DATA_VARIABLE: return createDataVariable();
			case FoxBPMPackage.DOCUMENTATION: return createDocumentation();
			case FoxBPMPackage.CONNECTOR_INSTANCE: return createConnectorInstance();
			case FoxBPMPackage.CONNECTOR_PARAMETER_INPUT: return createConnectorParameterInput();
			case FoxBPMPackage.CONNECTOR_PARAMETER_OUTPUT: return createConnectorParameterOutput();
			case FoxBPMPackage.LOOP_DATA_INPUT_COLLECTION: return createLoopDataInputCollection();
			case FoxBPMPackage.LOOP_DATA_OUTPUT_COLLECTION: return createLoopDataOutputCollection();
			case FoxBPMPackage.CONNECTOR_PARAMETER_OUTPUT_DEF: return createConnectorParameterOutputDef();
			case FoxBPMPackage.FORM_URI: return createFormUri();
			case FoxBPMPackage.LOOP_MAXIMUM: return createLoopMaximum();
			case FoxBPMPackage.SKIP_STRATEGY: return createSkipStrategy();
			case FoxBPMPackage.MESSAGE_OBJ: return createMessageObj();
			case FoxBPMPackage.FILTER_CONDITIONS: return createFilterConditions();
			case FoxBPMPackage.RECEIVE_MESSAGE: return createReceiveMessage();
			case FoxBPMPackage.TOKEN_VARIABLE: return createTokenVariable();
			case FoxBPMPackage.PROCESS_INSTANCE_VARIABLE: return createProcessInstanceVariable();
			case FoxBPMPackage.EXPECTED_EXECUTION_TIME: return createExpectedExecutionTime();
			case FoxBPMPackage.DATA_SOURCE_TO_SUB_PROCESS_MAPPING: return createDataSourceToSubProcessMapping();
			case FoxBPMPackage.SUB_PROCESS_TO_DATA_SOURCE_MAPPING: return createSubProcessToDataSourceMapping();
			case FoxBPMPackage.DATA_VARIABLE_MAPPING: return createDataVariableMapping();
			case FoxBPMPackage.FORM_URI_VIEW: return createFormUriView();
			case FoxBPMPackage.TASK_PRIORITY: return createTaskPriority();
			case FoxBPMPackage.ASSIGN_POLICY_TYPE: return createAssignPolicyType();
			case FoxBPMPackage.SKIP_ASSIGNEE: return createSkipAssignee();
			case FoxBPMPackage.SKIP_COMMENT: return createSkipComment();
			case FoxBPMPackage.CONNECTOR_INSTANCE_ELEMENTS: return createConnectorInstanceElements();
			case FoxBPMPackage.TIME_EXPRESSION: return createTimeExpression();
			case FoxBPMPackage.TIME_SKIP_EXPRESSION: return createTimeSkipExpression();
			case FoxBPMPackage.TABLE_EXPRESSION: return createTableExpression();
			case FoxBPMPackage.LIST_EXPRESSION: return createListExpression();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case FoxBPMPackage.PROCESS_VALIDATION_LEVEL:
				return createProcessValidationLevelFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case FoxBPMPackage.PROCESS_VALIDATION_LEVEL:
				return convertProcessValidationLevelToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression createExpression() {
		ExpressionImpl expression = new ExpressionImpl();
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskSubject createTaskSubject() {
		TaskSubjectImpl taskSubject = new TaskSubjectImpl();
		return taskSubject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskCommandModel createTaskCommandModel() {
		TaskCommandModelImpl taskCommandModel = new TaskCommandModelImpl();
		return taskCommandModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceFilter createResourceFilter() {
		ResourceFilterImpl resourceFilter = new ResourceFilterImpl();
		return resourceFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataVariable createDataVariable() {
		DataVariableImpl dataVariable = new DataVariableImpl();
		return dataVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Documentation createDocumentation() {
		DocumentationImpl documentation = new DocumentationImpl();
		return documentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectorInstance createConnectorInstance() {
		ConnectorInstanceImpl connectorInstance = new ConnectorInstanceImpl();
		return connectorInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectorParameterInput createConnectorParameterInput() {
		ConnectorParameterInputImpl connectorParameterInput = new ConnectorParameterInputImpl();
		return connectorParameterInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectorParameterOutput createConnectorParameterOutput() {
		ConnectorParameterOutputImpl connectorParameterOutput = new ConnectorParameterOutputImpl();
		return connectorParameterOutput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopDataInputCollection createLoopDataInputCollection() {
		LoopDataInputCollectionImpl loopDataInputCollection = new LoopDataInputCollectionImpl();
		return loopDataInputCollection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopDataOutputCollection createLoopDataOutputCollection() {
		LoopDataOutputCollectionImpl loopDataOutputCollection = new LoopDataOutputCollectionImpl();
		return loopDataOutputCollection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectorParameterOutputDef createConnectorParameterOutputDef() {
		ConnectorParameterOutputDefImpl connectorParameterOutputDef = new ConnectorParameterOutputDefImpl();
		return connectorParameterOutputDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormUri createFormUri() {
		FormUriImpl formUri = new FormUriImpl();
		return formUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopMaximum createLoopMaximum() {
		LoopMaximumImpl loopMaximum = new LoopMaximumImpl();
		return loopMaximum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SkipStrategy createSkipStrategy() {
		SkipStrategyImpl skipStrategy = new SkipStrategyImpl();
		return skipStrategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageObj createMessageObj() {
		MessageObjImpl messageObj = new MessageObjImpl();
		return messageObj;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilterConditions createFilterConditions() {
		FilterConditionsImpl filterConditions = new FilterConditionsImpl();
		return filterConditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReceiveMessage createReceiveMessage() {
		ReceiveMessageImpl receiveMessage = new ReceiveMessageImpl();
		return receiveMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TokenVariable createTokenVariable() {
		TokenVariableImpl tokenVariable = new TokenVariableImpl();
		return tokenVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessInstanceVariable createProcessInstanceVariable() {
		ProcessInstanceVariableImpl processInstanceVariable = new ProcessInstanceVariableImpl();
		return processInstanceVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpectedExecutionTime createExpectedExecutionTime() {
		ExpectedExecutionTimeImpl expectedExecutionTime = new ExpectedExecutionTimeImpl();
		return expectedExecutionTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataSourceToSubProcessMapping createDataSourceToSubProcessMapping() {
		DataSourceToSubProcessMappingImpl dataSourceToSubProcessMapping = new DataSourceToSubProcessMappingImpl();
		return dataSourceToSubProcessMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubProcessToDataSourceMapping createSubProcessToDataSourceMapping() {
		SubProcessToDataSourceMappingImpl subProcessToDataSourceMapping = new SubProcessToDataSourceMappingImpl();
		return subProcessToDataSourceMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataVariableMapping createDataVariableMapping() {
		DataVariableMappingImpl dataVariableMapping = new DataVariableMappingImpl();
		return dataVariableMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormUriView createFormUriView() {
		FormUriViewImpl formUriView = new FormUriViewImpl();
		return formUriView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskPriority createTaskPriority() {
		TaskPriorityImpl taskPriority = new TaskPriorityImpl();
		return taskPriority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignPolicyType createAssignPolicyType() {
		AssignPolicyTypeImpl assignPolicyType = new AssignPolicyTypeImpl();
		return assignPolicyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SkipAssignee createSkipAssignee() {
		SkipAssigneeImpl skipAssignee = new SkipAssigneeImpl();
		return skipAssignee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SkipComment createSkipComment() {
		SkipCommentImpl skipComment = new SkipCommentImpl();
		return skipComment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectorInstanceElements createConnectorInstanceElements() {
		ConnectorInstanceElementsImpl connectorInstanceElements = new ConnectorInstanceElementsImpl();
		return connectorInstanceElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeExpression createTimeExpression() {
		TimeExpressionImpl timeExpression = new TimeExpressionImpl();
		return timeExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeSkipExpression createTimeSkipExpression() {
		TimeSkipExpressionImpl timeSkipExpression = new TimeSkipExpressionImpl();
		return timeSkipExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableExpression createTableExpression() {
		TableExpressionImpl tableExpression = new TableExpressionImpl();
		return tableExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListExpression createListExpression() {
		ListExpressionImpl listExpression = new ListExpressionImpl();
		return listExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessValidationLevel createProcessValidationLevelFromString(EDataType eDataType, String initialValue) {
		ProcessValidationLevel result = ProcessValidationLevel.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertProcessValidationLevelToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FoxBPMPackage getFoxBPMPackage() {
		return (FoxBPMPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FoxBPMPackage getPackage() {
		return FoxBPMPackage.eINSTANCE;
	}

} //FoxBPMFactoryImpl
