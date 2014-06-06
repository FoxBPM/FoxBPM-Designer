package org.foxbpm.bpmn.designer.ui.propertytab.usertask;

import org.eclipse.bpmn2.Bpmn2Factory;
import org.eclipse.bpmn2.ExtensionAttributeValue;
import org.eclipse.bpmn2.UserTask;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl.SimpleFeatureMapEntry;
import org.eclipse.emf.ecore.util.FeatureMap;
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
import org.foxbpm.bpmn.designer.ui.expdialog.FoxBPMExpViewer;
import org.foxbpm.model.bpmn.foxbpm.ExpectedExecutionTime;
import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;
import org.foxbpm.model.bpmn.foxbpm.TaskPriority;

public class UserTaskTaskPropertyComposite extends AbstractFoxBPMComposite {
	private UserTask userTask;
	private Combo priorityCombo;// 优先级
	private Combo taskTypeCombo;// 任务类型
	private FoxBPMExpViewer taskNameViewer;// 任务名称
	private FoxBPMExpViewer taskDescriptionViewer;// 任务描述
	private FoxBPMExpViewer filishedDescriptionViewer;// 完成后的描述
	private Spinner predictDaysSpinner;// 预计持续天数
	private Spinner predictHoursSpinner;// 预计持续小时
	private Spinner predictMiniutesSpinner;// 预计持续分钟
	private ExpectedExecutionTime expectedExecutionTime;
	private String[] items;

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

		Label priorityLabel = new Label(detailComposite, SWT.NONE);
		priorityLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		priorityLabel.setText("优先级");
		priorityCombo = new Combo(detailComposite, SWT.READ_ONLY);
		GridData gd_priorityCombo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_priorityCombo.widthHint = 100;
		items = new String[] { "非常低", "低", "一般", "高", "非常高" };
		priorityCombo.setLayoutData(gd_priorityCombo);
		priorityCombo.setItems(items);
		priorityCombo.setData("非常低", "lowest");
		priorityCombo.setData("低", "low");
		priorityCombo.setData("一般", "normal");
		priorityCombo.setData("高", "high");
		priorityCombo.setData("非常高", "highest");
		priorityCombo.select(2);

		Label taskTypeLabel = new Label(detailComposite, SWT.NONE);
		taskTypeLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		taskTypeLabel.setText("任务类型");
		taskTypeCombo = new Combo(detailComposite, SWT.READ_ONLY);
		GridData gd_taskTypeCombo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_taskTypeCombo.widthHint = 100;
		taskTypeCombo.setLayoutData(gd_taskTypeCombo);
		// taskTypeCombo.setItems(new String[]{"通用任务","通知任务","默认通用任务"});
		// taskTypeCombo.setData("通用任务", "FIXFLOWTASK");
		// taskTypeCombo.setData("通知任务", "FIXNOTICETASK");
		// taskTypeCombo.setData("默认通用任务", "FIXREMIND");
		taskTypeCombo.setItems(new String[] { "foxbpmtask" });
		taskTypeCombo.select(0);

		Label taskNameLabel = new Label(detailComposite, SWT.NONE);
		taskNameLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		taskNameLabel.setText("任务名称");
		taskNameViewer = new FoxBPMExpViewer(detailComposite, SWT.BORDER);
		Control control = taskNameViewer.getControl();
		control.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label taskDescriptionLabel = new Label(detailComposite, SWT.NONE);
		taskDescriptionLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		taskDescriptionLabel.setText("任务描述");
		taskDescriptionViewer = new FoxBPMExpViewer(detailComposite, SWT.BORDER);
		Control control_1 = taskDescriptionViewer.getControl();
		control_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label filishedDescriptionLabel = new Label(detailComposite, SWT.NONE);
		filishedDescriptionLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		filishedDescriptionLabel.setText("完成后的描述");
		filishedDescriptionViewer = new FoxBPMExpViewer(detailComposite, SWT.BORDER);
		Control control_2 = filishedDescriptionViewer.getControl();
		control_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label durationLabel = new Label(detailComposite, SWT.NONE);
		durationLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		durationLabel.setText("预计持续时间");
		Composite durationTime = new Composite(detailComposite, SWT.NONE);
		durationTime.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		durationTime.setLayout(new GridLayout(6, false));

		Label daysLabel = new Label(durationTime, SWT.NONE);
		daysLabel.setText("天");
		predictDaysSpinner = new Spinner(durationTime, SWT.BORDER | SWT.READ_ONLY);

		Label hoursLabel = new Label(durationTime, SWT.NONE);
		hoursLabel.setText("小时");
		predictHoursSpinner = new Spinner(durationTime, SWT.BORDER | SWT.READ_ONLY);

		Label miniutesLabel = new Label(durationTime, SWT.NONE);
		miniutesLabel.setText("分");
		predictMiniutesSpinner = new Spinner(durationTime, SWT.BORDER | SWT.READ_ONLY);
		return parent;
	}

	@Override
	public void createUIBindings(EObject eObject) {
		userTask = (UserTask) eObject;

		ExtensionAttributeValue extensionElement = userTask.getExtensionValues().get(0);
		Object taskPriorityObj = extensionElement.getValue().get(FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_PRIORITY, true);
		if (taskPriorityObj == null) {
			// 默认给值
			TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
				@Override
				protected void doExecute() {
					// 默认的任务优先级值
					Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
					expression.setName(priorityCombo.getText());
					expression.setValue(priorityCombo.getData(priorityCombo.getText()).toString());

					TaskPriority taskPriority = FoxBPMFactory.eINSTANCE.createTaskPriority();
					taskPriority.setExpression(expression);

					if (userTask.getExtensionValues().size() > 0) {
						ExtensionAttributeValue extensionElement = userTask.getExtensionValues().get(0);
						Object taskPriorityObj = extensionElement.getValue().get(FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_PRIORITY, true);
						if (taskPriorityObj == null) {
							FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_PRIORITY,
									taskPriority);
							extensionElement.getValue().add(extensionElementEntry);
						}
					} else {
						ExtensionAttributeValue extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
						userTask.getExtensionValues().add(extensionElement);
						Object taskPriorityObj = extensionElement.getValue().get(FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_PRIORITY, true);
						if (taskPriorityObj == null) {
							FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_PRIORITY,
									taskPriority);
							extensionElement.getValue().add(extensionElementEntry);
						}
					}
				}
			});
		} else {
			TaskPriority taskPriority = (TaskPriority) taskPriorityObj;
			String value = taskPriority.getExpression().getValue();
			for (int i = 0; i < items.length; i++) {
				if (value.equals(priorityCombo.getData(items[i]))) {
					priorityCombo.select(i);
					break;
				}
			}
		}

		if (userTask.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_TYPE) == null) {
			// 默认给值
			TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
				@Override
				protected void doExecute() {
					// 默认的任务类型值
					userTask.eSet(FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_TYPE, "foxbpmtask");
				}
			});
		}

		bindCombo(FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_TYPE, taskTypeCombo, userTask);

		priorityCombo.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
						expression.setName(priorityCombo.getText());
						expression.setValue(priorityCombo.getData(priorityCombo.getText()).toString());

						if (userTask.getExtensionValues().size() > 0) {
							for (ExtensionAttributeValue extensionAttributeValue : userTask.getExtensionValues()) {
								FeatureMap extensionElements = extensionAttributeValue.getValue();
								Object objectElement = extensionElements.get(FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_PRIORITY, true);
								if (objectElement != null) {
									TaskPriority taskPriority = (TaskPriority) objectElement;
									taskPriority.setExpression(expression);
								} else {
									TaskPriority taskPriority = FoxBPMFactory.eINSTANCE.createTaskPriority();
									taskPriority.setExpression(expression);
									FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry(
											(org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_PRIORITY, taskPriority);
									extensionElements.add(extensionElementEntry);
								}
							}
						}
					}
				});
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});

		expectedExecutionTime = (ExpectedExecutionTime) extensionElement.getValue().get(FoxBPMPackage.Literals.DOCUMENT_ROOT__EXPECTED_EXECUTION_TIME, true);

		if (expectedExecutionTime == null) {
			expectedExecutionTime = FoxBPMFactory.eINSTANCE.createExpectedExecutionTime();

			final FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__EXPECTED_EXECUTION_TIME,
					expectedExecutionTime);

			TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
				@Override
				protected void doExecute() {

					if (userTask.getExtensionValues().size() > 0) {
						userTask.getExtensionValues().get(0).getValue().add(extensionElementEntry);
					} else {
						ExtensionAttributeValue extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
						extensionElement.getValue().add(extensionElementEntry);
						userTask.getExtensionValues().add(extensionElement);
					}

				}
			});
		} else {
			predictDaysSpinner.setSelection(expectedExecutionTime.getDay());
			predictHoursSpinner.setSelection(expectedExecutionTime.getHour());
			predictMiniutesSpinner.setSelection(expectedExecutionTime.getMinute());
		}

		IObservableValue textObserver = SWTObservables.observeSelection(predictDaysSpinner);
		textObserver.addValueChangeListener(new IValueChangeListener() {

			@Override
			public void handleValueChange(final ValueChangeEvent e) {

				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						expectedExecutionTime.setDay(StringUtil.getInt(e.diff.getNewValue()));
					}
				});
			}

		});

		IObservableValue textObserver1 = SWTObservables.observeSelection(predictHoursSpinner);
		textObserver1.addValueChangeListener(new IValueChangeListener() {

			@Override
			public void handleValueChange(final ValueChangeEvent e) {

				if (Integer.parseInt(e.diff.getNewValue().toString()) > 23) {
					predictHoursSpinner.setSelection(23);
					return;
				}

				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {

						expectedExecutionTime.setHour(StringUtil.getInt(e.diff.getNewValue()));
					}
				});
			}

		});

		IObservableValue textObserver2 = SWTObservables.observeSelection(predictMiniutesSpinner);
		textObserver2.addValueChangeListener(new IValueChangeListener() {

			@Override
			public void handleValueChange(final ValueChangeEvent e) {

				if (Integer.parseInt(e.diff.getNewValue().toString()) > 59) {
					predictMiniutesSpinner.setSelection(59);
					return;
				}

				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						expectedExecutionTime.setMinute(StringUtil.getInt(e.diff.getNewValue()));
					}
				});
			}

		});
	}
}
