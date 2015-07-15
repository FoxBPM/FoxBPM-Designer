package org.foxbpm.bpmn.designer.ui.propertytab.usertask;

import org.eclipse.bpmn2.BaseElement;
import org.eclipse.bpmn2.Bpmn2Factory;
import org.eclipse.bpmn2.ExtensionAttributeValue;
import org.eclipse.bpmn2.FormalExpression;
import org.eclipse.bpmn2.UserTask;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl.SimpleFeatureMapEntry;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.eclipse.emf.ecore.util.FeatureMapUtil.FeatureEList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.foxbpm.bpmn.designer.base.utils.StringUtil;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMComposite;
import org.foxbpm.bpmn.designer.ui.expdialog.ExpressionChangedEvent;
import org.foxbpm.bpmn.designer.ui.expdialog.FoxBPMExpViewer;
import org.foxbpm.bpmn.designer.ui.expdialog.IExpressionChangedListener;
import org.foxbpm.model.bpmn.foxbpm.CompleteTaskDescription;
import org.foxbpm.model.bpmn.foxbpm.ExpectedExecutionTime;
import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;
import org.foxbpm.model.bpmn.foxbpm.TaskDescription;
import org.foxbpm.model.bpmn.foxbpm.TaskPriority;
import org.foxbpm.model.bpmn.foxbpm.TaskSubject;

public class UserTaskTaskPropertyComposite extends AbstractFoxBPMComposite {
	private UserTask userTask;
//	private Combo priorityCombo;// 优先级
//	private Combo taskTypeCombo;// 任务类型
	private FoxBPMExpViewer taskNameViewer;// 任务名称
//	private FoxBPMExpViewer taskDescriptionViewer;// 任务描述
//	private FoxBPMExpViewer filishedDescriptionViewer;// 完成后的描述
//	private Spinner predictDaysSpinner;// 预计持续天数
//	private Spinner predictHoursSpinner;// 预计持续小时
//	private Spinner predictMiniutesSpinner;// 预计持续分钟
//	private ExpectedExecutionTime expectedExecutionTime;
//	private String[] items;

	public UserTaskTaskPropertyComposite(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public String setDescId() {
		return null;
	}

	@Override
	public Composite createUI(Composite parent) {
		Composite detailComposite = new Composite(parent, SWT.NONE);
		detailComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		detailComposite.setLayout(new GridLayout(2, false));
		
//		Label priorityLabel = new Label(detailComposite, SWT.NONE);
//		priorityLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
//		priorityLabel.setText("优先级");
//		priorityCombo = new Combo(detailComposite, SWT.READ_ONLY);
//		GridData gd_priorityCombo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
//		gd_priorityCombo.widthHint = 100;
//		items = new String[] { "非常低", "低", "一般", "高", "非常高" };
//		priorityCombo.setLayoutData(gd_priorityCombo);
//		priorityCombo.setItems(items);
//		priorityCombo.setData("非常低", "20");
//		priorityCombo.setData("低", "40");
//		priorityCombo.setData("一般", "50");
//		priorityCombo.setData("高", "80");
//		priorityCombo.setData("非常高", "100");
//		priorityCombo.select(2);

		Label taskNameLabel = new Label(detailComposite, SWT.NONE);
		taskNameLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		taskNameLabel.setText("任务主题");
		taskNameViewer = new FoxBPMExpViewer(detailComposite, SWT.BORDER);
		Control control = taskNameViewer.getControl();
		control.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

//		Label durationLabel = new Label(detailComposite, SWT.NONE);
//		durationLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
//		durationLabel.setText("预计持续时间");
//		Composite durationTime = new Composite(detailComposite, SWT.NONE);
//		durationTime.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
//		durationTime.setLayout(new GridLayout(6, false));
//
//		Label daysLabel = new Label(durationTime, SWT.NONE);
//		daysLabel.setText("天");
//		predictDaysSpinner = new Spinner(durationTime, SWT.BORDER | SWT.READ_ONLY);
//
//		Label hoursLabel = new Label(durationTime, SWT.NONE);
//		hoursLabel.setText("小时");
//		predictHoursSpinner = new Spinner(durationTime, SWT.BORDER | SWT.READ_ONLY);
//
//		Label miniutesLabel = new Label(durationTime, SWT.NONE);
//		miniutesLabel.setText("分");
//		predictMiniutesSpinner = new Spinner(durationTime, SWT.BORDER | SWT.READ_ONLY);
//		
//		Label taskTypeLabel = new Label(detailComposite, SWT.NONE);
//		taskTypeLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
//		taskTypeLabel.setText("任务类型");
//		taskTypeLabel.setVisible(false);
//		taskTypeCombo = new Combo(detailComposite, SWT.READ_ONLY);
//		GridData gd_taskTypeCombo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
//		gd_taskTypeCombo.widthHint = 100;
//		taskTypeCombo.setLayoutData(gd_taskTypeCombo);
//		// taskTypeCombo.setItems(new String[]{"通用任务","通知任务","默认通用任务"});
//		// taskTypeCombo.setData("通用任务", "FIXFLOWTASK");
//		// taskTypeCombo.setData("通知任务", "FIXNOTICETASK");
//		// taskTypeCombo.setData("默认通用任务", "FIXREMIND");
//		taskTypeCombo.setItems(new String[] { "foxbpmtask" });
//		taskTypeCombo.select(0);
//		taskTypeCombo.setVisible(false);
//		
//		Label taskDescriptionLabel = new Label(detailComposite, SWT.NONE);
//		taskDescriptionLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
//		taskDescriptionLabel.setText("任务描述");
//		taskDescriptionLabel.setVisible(false);
//		taskDescriptionViewer = new FoxBPMExpViewer(detailComposite, SWT.BORDER);
//		Control control_1 = taskDescriptionViewer.getControl();
//		control_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
//		taskDescriptionViewer.getControl().setVisible(false);
//		
//		Label filishedDescriptionLabel = new Label(detailComposite, SWT.NONE);
//		filishedDescriptionLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
//		filishedDescriptionLabel.setText("完成后的描述");
//		filishedDescriptionLabel.setVisible(false);
//		filishedDescriptionViewer = new FoxBPMExpViewer(detailComposite, SWT.BORDER);
//		Control control_2 = filishedDescriptionViewer.getControl();
//		control_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
//		filishedDescriptionViewer.getControl().setVisible(false);
		
		return parent;
	}

	@Override
	public void createUIBindings(EObject eObject) {
		userTask = (UserTask) eObject;

		ExtensionAttributeValue extensionElement = null;
		if (userTask.getExtensionValues().size() > 0) {
			extensionElement = userTask.getExtensionValues().get(0);
		} else {
			extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
		}

		TaskSubject taskSubject = null;
		FeatureMap extensionElements = extensionElement.getValue();
		for (Entry entry : extensionElements) {
			if (entry.getValue() instanceof TaskSubject) {
				taskSubject = (TaskSubject) entry.getValue();
			}
		}
		
		Expression taskSubjectExp = null;
		if (taskSubject == null) {
			taskSubjectExp = FoxBPMFactory.eINSTANCE.createExpression();
			taskSubjectExp.setName("");
			taskSubjectExp.setValue("");
		} else {
			taskSubjectExp = taskSubject.getExpression();
		}
		
		TaskDescription taskDescription = (TaskDescription) extensionElement.getValue().get(FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_DESCRIPTION, true);
		CompleteTaskDescription completeTaskDescription = (CompleteTaskDescription) extensionElement.getValue().get(FoxBPMPackage.Literals.DOCUMENT_ROOT__COMPLETE_TASK_DESCRIPTION, true);

		Expression taskDescriptionExp = null;
		if (taskDescription == null) {
			taskDescriptionExp = FoxBPMFactory.eINSTANCE.createExpression();
			taskDescriptionExp.setName("");
			taskDescriptionExp.setValue("");
		} else {
			taskDescriptionExp = taskDescription.getExpression();
		}

		Expression completeTaskDescriptionExp = null;
		if (completeTaskDescription == null) {
			completeTaskDescriptionExp = FoxBPMFactory.eINSTANCE.createExpression();
			completeTaskDescriptionExp.setName("");
			completeTaskDescriptionExp.setValue("");
		} else {
			completeTaskDescriptionExp = completeTaskDescription.getExpression();
		}

//		// viewer上控件值
//		taskNameViewer.getTextControl().setText(taskSubjectExp == null ? "" : taskSubjectExp.getName());
//		taskDescriptionViewer.getTextControl().setText(taskDescriptionExp == null ? "" : taskDescriptionExp.getName());
//		filishedDescriptionViewer.getTextControl().setText(completeTaskDescriptionExp == null ? "" : completeTaskDescriptionExp.getName());
//
//		// 传递表达式对象
//		taskNameViewer.setExpression(taskSubjectExp);
//		taskDescriptionViewer.setExpression(taskDescriptionExp);
//		filishedDescriptionViewer.setExpression(completeTaskDescriptionExp);
//
//		taskNameViewer.seteObject(userTask);
//		taskDescriptionViewer.seteObject(userTask);
//		filishedDescriptionViewer.seteObject(userTask);

		taskNameViewer.addExpressionChangedListeners(new IExpressionChangedListener() {

			@Override
			public void expressionChanged(final ExpressionChangedEvent event) {
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						setTaskSubjectExtensionExpression(userTask, event.getFormalExpression());
						
						FormalExpression formalExpression = event.getFormalExpression();
						Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
						if(formalExpression!=null) {
							Object expName = formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME);
							expression.setName(expName==null?"":expName.toString());
							expression.setValue(formalExpression.getBody());
						}
						
						//传递表达式对象
						taskNameViewer.setExpression(expression);
					}
				});
			}
		});

//		taskDescriptionViewer.addExpressionChangedListeners(new IExpressionChangedListener() {
//
//			@Override
//			public void expressionChanged(final ExpressionChangedEvent event) {
//				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
//				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
//					@Override
//					protected void doExecute() {
//						setTaskDescriptionExtensionExpression(userTask, event.getFormalExpression());
//					
//						FormalExpression formalExpression = event.getFormalExpression();
//						Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
//						if(formalExpression!=null) {
//							Object expName = formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME);
//							expression.setName(expName==null?"":expName.toString());
//							expression.setValue(formalExpression.getBody());
//						}
//						
//						//传递表达式对象
//						taskDescriptionViewer.setExpression(expression);
//					}
//				});
//			}
//		});
//
//		filishedDescriptionViewer.addExpressionChangedListeners(new IExpressionChangedListener() {
//
//			@Override
//			public void expressionChanged(final ExpressionChangedEvent event) {
//				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
//				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
//					@Override
//					protected void doExecute() {
//						setCompeleteTaskDescriptionExtensionExpression(userTask, event.getFormalExpression());
//					
//						FormalExpression formalExpression = event.getFormalExpression();
//						Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
//						if(formalExpression!=null) {
//							Object expName = formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME);
//							expression.setName(expName==null?"":expName.toString());
//							expression.setValue(formalExpression.getBody());
//						}
//						
//						//传递表达式对象
//						filishedDescriptionViewer.setExpression(expression);
//					}
//				});
//			}
//		});
//
//		Object taskPriorityObj = extensionElement.getValue().get(FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_PRIORITY, true);
//		if (taskPriorityObj == null) {
//			// 默认给值
//			TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
//			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
//				@Override
//				protected void doExecute() {
//					// 默认的任务优先级值
//					Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
//					expression.setName(priorityCombo.getText());
//					expression.setValue(priorityCombo.getData(priorityCombo.getText()).toString());
//
//					TaskPriority taskPriority = FoxBPMFactory.eINSTANCE.createTaskPriority();
//					taskPriority.setExpression(expression);
//
//					if (userTask.getExtensionValues().size() > 0) {
//						ExtensionAttributeValue extensionElement = userTask.getExtensionValues().get(0);
//						Object taskPriorityObj = extensionElement.getValue().get(FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_PRIORITY, true);
//						if (taskPriorityObj == null) {
//							FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_PRIORITY,
//									taskPriority);
//							extensionElement.getValue().add(extensionElementEntry);
//						}
//					} else {
//						ExtensionAttributeValue extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
//						userTask.getExtensionValues().add(extensionElement);
//						Object taskPriorityObj = extensionElement.getValue().get(FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_PRIORITY, true);
//						if (taskPriorityObj == null) {
//							FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_PRIORITY,
//									taskPriority);
//							extensionElement.getValue().add(extensionElementEntry);
//						}
//					}
//				}
//			});
//		} else {
//			TaskPriority taskPriority = (TaskPriority) taskPriorityObj;
//			String value = taskPriority.getExpression().getValue();
//			for (int i = 0; i < items.length; i++) {
//				if (value.equals(priorityCombo.getData(items[i]))) {
//					priorityCombo.select(i);
//					break;
//				}
//			}
//		}
//
//		if (userTask.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_TYPE) == null) {
//			// 默认给值
//			TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
//			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
//				@Override
//				protected void doExecute() {
//					// 默认的任务类型值
//					userTask.eSet(FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_TYPE, "foxbpmtask");
//				}
//			});
//		}
//
//		bindCombo(FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_TYPE, taskTypeCombo, userTask);
//
//		priorityCombo.addSelectionListener(new SelectionListener() {
//
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//
//				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
//				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
//					@Override
//					protected void doExecute() {
//						Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
//						expression.setName(priorityCombo.getText());
//						expression.setValue(priorityCombo.getData(priorityCombo.getText()).toString());
//
//						if (userTask.getExtensionValues().size() > 0) {
//							for (ExtensionAttributeValue extensionAttributeValue : userTask.getExtensionValues()) {
//								FeatureMap extensionElements = extensionAttributeValue.getValue();
//								Object objectElement = extensionElements.get(FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_PRIORITY, true);
//								if (objectElement != null) {
//									TaskPriority taskPriority = (TaskPriority) objectElement;
//									taskPriority.setExpression(expression);
//								} else {
//									TaskPriority taskPriority = FoxBPMFactory.eINSTANCE.createTaskPriority();
//									taskPriority.setExpression(expression);
//									FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry(
//											(org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_PRIORITY, taskPriority);
//									extensionElements.add(extensionElementEntry);
//								}
//							}
//						}
//					}
//				});
//			}
//
//			@Override
//			public void widgetDefaultSelected(SelectionEvent e) {
//
//			}
//		});
//
//		expectedExecutionTime = (ExpectedExecutionTime) extensionElement.getValue().get(FoxBPMPackage.Literals.DOCUMENT_ROOT__EXPECTED_EXECUTION_TIME, true);
//
//		if (expectedExecutionTime == null) {
//			expectedExecutionTime = FoxBPMFactory.eINSTANCE.createExpectedExecutionTime();
//
//			final FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__EXPECTED_EXECUTION_TIME,
//					expectedExecutionTime);
//
//			TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
//			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
//				@Override
//				protected void doExecute() {
//
//					if (userTask.getExtensionValues().size() > 0) {
//						userTask.getExtensionValues().get(0).getValue().add(extensionElementEntry);
//					} else {
//						ExtensionAttributeValue extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
//						extensionElement.getValue().add(extensionElementEntry);
//						userTask.getExtensionValues().add(extensionElement);
//					}
//
//				}
//			});
//		} else {
//			predictDaysSpinner.setSelection(expectedExecutionTime.getDay());
//			predictHoursSpinner.setSelection(expectedExecutionTime.getHour());
//			predictMiniutesSpinner.setSelection(expectedExecutionTime.getMinute());
//		}
//
//		IObservableValue textObserver = SWTObservables.observeSelection(predictDaysSpinner);
//		textObserver.addValueChangeListener(new IValueChangeListener() {
//
//			@Override
//			public void handleValueChange(final ValueChangeEvent e) {
//
//				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
//				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
//					@Override
//					protected void doExecute() {
//						expectedExecutionTime.setDay(StringUtil.getInt(e.diff.getNewValue()));
//					}
//				});
//			}
//
//		});
//
//		IObservableValue textObserver1 = SWTObservables.observeSelection(predictHoursSpinner);
//		textObserver1.addValueChangeListener(new IValueChangeListener() {
//
//			@Override
//			public void handleValueChange(final ValueChangeEvent e) {
//
//				if (Integer.parseInt(e.diff.getNewValue().toString()) > 23) {
//					predictHoursSpinner.setSelection(23);
//					return;
//				}
//
//				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
//				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
//					@Override
//					protected void doExecute() {
//
//						expectedExecutionTime.setHour(StringUtil.getInt(e.diff.getNewValue()));
//					}
//				});
//			}
//
//		});
//
//		IObservableValue textObserver2 = SWTObservables.observeSelection(predictMiniutesSpinner);
//		textObserver2.addValueChangeListener(new IValueChangeListener() {
//
//			@Override
//			public void handleValueChange(final ValueChangeEvent e) {
//
//				if (Integer.parseInt(e.diff.getNewValue().toString()) > 59) {
//					predictMiniutesSpinner.setSelection(59);
//					return;
//				}
//
//				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
//				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
//					@Override
//					protected void doExecute() {
//						expectedExecutionTime.setMinute(StringUtil.getInt(e.diff.getNewValue()));
//					}
//				});
//			}
//
//		});
	}

	private void setTaskSubjectExtensionExpression(BaseElement baseElement, FormalExpression formalExpression) {

		for (ExtensionAttributeValue extensionAttributeValue : baseElement.getExtensionValues()) {

			FeatureMap extensionElements = extensionAttributeValue.getValue();
			for (Entry entry : extensionElements) {
				if (entry.getValue() instanceof TaskSubject) {
					if (formalExpression == null) {
						extensionElements.remove(entry);
					} else {
						TaskSubject taskSubject = (TaskSubject) entry.getValue();
						taskSubject.getExpression().setName(formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
						taskSubject.getExpression().setValue(formalExpression.getBody());
					}

					return;
				}
			}

		}
		if (formalExpression != null) {
			TaskSubject taskSubject = FoxBPMFactory.eINSTANCE.createTaskSubject();

			Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
			expression.setName(formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
			expression.setValue(formalExpression.getBody());
			taskSubject.setExpression(expression);

			FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_SUBJECT, taskSubject);

			if (baseElement.getExtensionValues().size() > 0) {
				baseElement.getExtensionValues().get(0).getValue().add(extensionElementEntry);
			} else {
				ExtensionAttributeValue extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
				extensionElement.getValue().add(extensionElementEntry);
				baseElement.getExtensionValues().add(extensionElement);
			}
		}
	}

	private void setTaskDescriptionExtensionExpression(BaseElement baseElement, FormalExpression formalExpression) {

		for (ExtensionAttributeValue extensionAttributeValue : baseElement.getExtensionValues()) {

			FeatureMap extensionElements = extensionAttributeValue.getValue();
			for (Entry entry : extensionElements) {
				if (entry.getValue() instanceof TaskDescription) {
					if (formalExpression == null) {
						extensionElements.remove(entry);
					} else {
						TaskDescription taskDescription = (TaskDescription) entry.getValue();
						taskDescription.getExpression().setName(formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
						taskDescription.getExpression().setValue(formalExpression.getBody());
					}

					return;
				}
			}

		}
		if (formalExpression != null) {
			TaskDescription taskDescription = FoxBPMFactory.eINSTANCE.createTaskDescription();

			Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
			expression.setName(formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
			expression.setValue(formalExpression.getBody());
			taskDescription.setExpression(expression);

			FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_DESCRIPTION, taskDescription);

			if (baseElement.getExtensionValues().size() > 0) {
				baseElement.getExtensionValues().get(0).getValue().add(extensionElementEntry);
			} else {
				ExtensionAttributeValue extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
				extensionElement.getValue().add(extensionElementEntry);
				baseElement.getExtensionValues().add(extensionElement);
			}
		}
	}
	
	private void setCompeleteTaskDescriptionExtensionExpression(BaseElement baseElement, FormalExpression formalExpression) {

		for (ExtensionAttributeValue extensionAttributeValue : baseElement.getExtensionValues()) {

			FeatureMap extensionElements = extensionAttributeValue.getValue();
			for (Entry entry : extensionElements) {
				if (entry.getValue() instanceof CompleteTaskDescription) {
					if (formalExpression == null) {
						extensionElements.remove(entry);
					} else {
						CompleteTaskDescription completeTaskDescription = (CompleteTaskDescription) entry.getValue();
						completeTaskDescription.getExpression().setName(formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
						completeTaskDescription.getExpression().setValue(formalExpression.getBody());
					}

					return;
				}
			}

		}
		if (formalExpression != null) {
			CompleteTaskDescription completeTaskDescription = FoxBPMFactory.eINSTANCE.createCompleteTaskDescription();

			Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
			expression.setName(formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
			expression.setValue(formalExpression.getBody());
			completeTaskDescription.setExpression(expression);

			FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__COMPLETE_TASK_DESCRIPTION, completeTaskDescription);

			if (baseElement.getExtensionValues().size() > 0) {
				baseElement.getExtensionValues().get(0).getValue().add(extensionElementEntry);
			} else {
				ExtensionAttributeValue extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
				extensionElement.getValue().add(extensionElementEntry);
				baseElement.getExtensionValues().add(extensionElement);
			}
		}
	}
}
