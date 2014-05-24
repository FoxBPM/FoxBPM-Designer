/**
 */
package org.foxbpm.model.bpmn.foxbpm.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.foxbpm.model.bpmn.foxbpm.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage
 * @generated
 */
public class FoxBPMAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static FoxBPMPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FoxBPMAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = FoxBPMPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FoxBPMSwitch<Adapter> modelSwitch =
		new FoxBPMSwitch<Adapter>() {
			@Override
			public Adapter caseDocumentRoot(DocumentRoot object) {
				return createDocumentRootAdapter();
			}
			@Override
			public Adapter caseExpression(Expression object) {
				return createExpressionAdapter();
			}
			@Override
			public Adapter caseTaskSubject(TaskSubject object) {
				return createTaskSubjectAdapter();
			}
			@Override
			public Adapter caseTaskCommand(TaskCommand object) {
				return createTaskCommandAdapter();
			}
			@Override
			public Adapter caseResourceFilter(ResourceFilter object) {
				return createResourceFilterAdapter();
			}
			@Override
			public Adapter caseDataVariable(DataVariable object) {
				return createDataVariableAdapter();
			}
			@Override
			public Adapter caseDocumentation(Documentation object) {
				return createDocumentationAdapter();
			}
			@Override
			public Adapter caseConnectorInstance(ConnectorInstance object) {
				return createConnectorInstanceAdapter();
			}
			@Override
			public Adapter caseConnectorParameterInput(ConnectorParameterInput object) {
				return createConnectorParameterInputAdapter();
			}
			@Override
			public Adapter caseConnectorParameterOutput(ConnectorParameterOutput object) {
				return createConnectorParameterOutputAdapter();
			}
			@Override
			public Adapter caseLoopDataInputCollection(LoopDataInputCollection object) {
				return createLoopDataInputCollectionAdapter();
			}
			@Override
			public Adapter caseLoopDataOutputCollection(LoopDataOutputCollection object) {
				return createLoopDataOutputCollectionAdapter();
			}
			@Override
			public Adapter caseConnectorParameterOutputDef(ConnectorParameterOutputDef object) {
				return createConnectorParameterOutputDefAdapter();
			}
			@Override
			public Adapter caseFormUri(FormUri object) {
				return createFormUriAdapter();
			}
			@Override
			public Adapter caseLoopMaximum(LoopMaximum object) {
				return createLoopMaximumAdapter();
			}
			@Override
			public Adapter caseSkipStrategy(SkipStrategy object) {
				return createSkipStrategyAdapter();
			}
			@Override
			public Adapter caseMessageObj(MessageObj object) {
				return createMessageObjAdapter();
			}
			@Override
			public Adapter caseFilterConditions(FilterConditions object) {
				return createFilterConditionsAdapter();
			}
			@Override
			public Adapter caseReceiveMessage(ReceiveMessage object) {
				return createReceiveMessageAdapter();
			}
			@Override
			public Adapter caseTokenVariable(TokenVariable object) {
				return createTokenVariableAdapter();
			}
			@Override
			public Adapter caseProcessInstanceVariable(ProcessInstanceVariable object) {
				return createProcessInstanceVariableAdapter();
			}
			@Override
			public Adapter caseExpectedExecutionTime(ExpectedExecutionTime object) {
				return createExpectedExecutionTimeAdapter();
			}
			@Override
			public Adapter caseDataSourceToSubProcessMapping(DataSourceToSubProcessMapping object) {
				return createDataSourceToSubProcessMappingAdapter();
			}
			@Override
			public Adapter caseSubProcessToDataSourceMapping(SubProcessToDataSourceMapping object) {
				return createSubProcessToDataSourceMappingAdapter();
			}
			@Override
			public Adapter caseDataVariableMapping(DataVariableMapping object) {
				return createDataVariableMappingAdapter();
			}
			@Override
			public Adapter caseFormUriView(FormUriView object) {
				return createFormUriViewAdapter();
			}
			@Override
			public Adapter caseTaskPriority(TaskPriority object) {
				return createTaskPriorityAdapter();
			}
			@Override
			public Adapter caseAssignPolicyType(AssignPolicyType object) {
				return createAssignPolicyTypeAdapter();
			}
			@Override
			public Adapter caseSkipAssignee(SkipAssignee object) {
				return createSkipAssigneeAdapter();
			}
			@Override
			public Adapter caseSkipComment(SkipComment object) {
				return createSkipCommentAdapter();
			}
			@Override
			public Adapter caseConnectorInstanceElements(ConnectorInstanceElements object) {
				return createConnectorInstanceElementsAdapter();
			}
			@Override
			public Adapter caseTimeExpression(TimeExpression object) {
				return createTimeExpressionAdapter();
			}
			@Override
			public Adapter caseTimeSkipExpression(TimeSkipExpression object) {
				return createTimeSkipExpressionAdapter();
			}
			@Override
			public Adapter caseTableExpression(TableExpression object) {
				return createTableExpressionAdapter();
			}
			@Override
			public Adapter caseListExpression(ListExpression object) {
				return createListExpressionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot
	 * @generated
	 */
	public Adapter createDocumentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.Expression
	 * @generated
	 */
	public Adapter createExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.TaskSubject <em>Task Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.TaskSubject
	 * @generated
	 */
	public Adapter createTaskSubjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.TaskCommand <em>Task Command</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.TaskCommand
	 * @generated
	 */
	public Adapter createTaskCommandAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.ResourceFilter <em>Resource Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.ResourceFilter
	 * @generated
	 */
	public Adapter createResourceFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.DataVariable <em>Data Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.DataVariable
	 * @generated
	 */
	public Adapter createDataVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.Documentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.Documentation
	 * @generated
	 */
	public Adapter createDocumentationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance <em>Connector Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorInstance
	 * @generated
	 */
	public Adapter createConnectorInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorParameterInput <em>Connector Parameter Input</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorParameterInput
	 * @generated
	 */
	public Adapter createConnectorParameterInputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutput <em>Connector Parameter Output</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutput
	 * @generated
	 */
	public Adapter createConnectorParameterOutputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.LoopDataInputCollection <em>Loop Data Input Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.LoopDataInputCollection
	 * @generated
	 */
	public Adapter createLoopDataInputCollectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.LoopDataOutputCollection <em>Loop Data Output Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.LoopDataOutputCollection
	 * @generated
	 */
	public Adapter createLoopDataOutputCollectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutputDef <em>Connector Parameter Output Def</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutputDef
	 * @generated
	 */
	public Adapter createConnectorParameterOutputDefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.FormUri <em>Form Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.FormUri
	 * @generated
	 */
	public Adapter createFormUriAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.LoopMaximum <em>Loop Maximum</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.LoopMaximum
	 * @generated
	 */
	public Adapter createLoopMaximumAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.SkipStrategy <em>Skip Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.SkipStrategy
	 * @generated
	 */
	public Adapter createSkipStrategyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.MessageObj <em>Message Obj</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.MessageObj
	 * @generated
	 */
	public Adapter createMessageObjAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.FilterConditions <em>Filter Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.FilterConditions
	 * @generated
	 */
	public Adapter createFilterConditionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.ReceiveMessage <em>Receive Message</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.ReceiveMessage
	 * @generated
	 */
	public Adapter createReceiveMessageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.TokenVariable <em>Token Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.TokenVariable
	 * @generated
	 */
	public Adapter createTokenVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.ProcessInstanceVariable <em>Process Instance Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.ProcessInstanceVariable
	 * @generated
	 */
	public Adapter createProcessInstanceVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.ExpectedExecutionTime <em>Expected Execution Time</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.ExpectedExecutionTime
	 * @generated
	 */
	public Adapter createExpectedExecutionTimeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.DataSourceToSubProcessMapping <em>Data Source To Sub Process Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.DataSourceToSubProcessMapping
	 * @generated
	 */
	public Adapter createDataSourceToSubProcessMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.SubProcessToDataSourceMapping <em>Sub Process To Data Source Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.SubProcessToDataSourceMapping
	 * @generated
	 */
	public Adapter createSubProcessToDataSourceMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.DataVariableMapping <em>Data Variable Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.DataVariableMapping
	 * @generated
	 */
	public Adapter createDataVariableMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.FormUriView <em>Form Uri View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.FormUriView
	 * @generated
	 */
	public Adapter createFormUriViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.TaskPriority <em>Task Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.TaskPriority
	 * @generated
	 */
	public Adapter createTaskPriorityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.AssignPolicyType <em>Assign Policy Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.AssignPolicyType
	 * @generated
	 */
	public Adapter createAssignPolicyTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.SkipAssignee <em>Skip Assignee</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.SkipAssignee
	 * @generated
	 */
	public Adapter createSkipAssigneeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.SkipComment <em>Skip Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.SkipComment
	 * @generated
	 */
	public Adapter createSkipCommentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstanceElements <em>Connector Instance Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorInstanceElements
	 * @generated
	 */
	public Adapter createConnectorInstanceElementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.TimeExpression <em>Time Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.TimeExpression
	 * @generated
	 */
	public Adapter createTimeExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.TimeSkipExpression <em>Time Skip Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.TimeSkipExpression
	 * @generated
	 */
	public Adapter createTimeSkipExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.TableExpression <em>Table Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.TableExpression
	 * @generated
	 */
	public Adapter createTableExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.bpmn.foxbpm.ListExpression <em>List Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.bpmn.foxbpm.ListExpression
	 * @generated
	 */
	public Adapter createListExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //FoxBPMAdapterFactory
