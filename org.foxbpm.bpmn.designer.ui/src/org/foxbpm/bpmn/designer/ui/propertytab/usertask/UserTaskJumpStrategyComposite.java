package org.foxbpm.bpmn.designer.ui.propertytab.usertask;

import org.eclipse.bpmn2.Activity;
import org.eclipse.bpmn2.BaseElement;
import org.eclipse.bpmn2.Bpmn2Factory;
import org.eclipse.bpmn2.ExtensionAttributeValue;
import org.eclipse.bpmn2.FormalExpression;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl.SimpleFeatureMapEntry;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMComposite;
import org.foxbpm.bpmn.designer.ui.expdialog.ExpressionChangedEvent;
import org.foxbpm.bpmn.designer.ui.expdialog.FoxBPMExpViewer;
import org.foxbpm.bpmn.designer.ui.expdialog.IExpressionChangedListener;
import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;
import org.foxbpm.model.bpmn.foxbpm.SkipAssignee;
import org.foxbpm.model.bpmn.foxbpm.SkipComment;
import org.foxbpm.model.bpmn.foxbpm.SkipStrategy;

public class UserTaskJumpStrategyComposite extends AbstractFoxBPMComposite {
	private Activity activity;
	private FoxBPMExpViewer jumpStrategyViewer;// 跳过策略
	private FoxBPMExpViewer handlerViewer;// 处理者
	private FoxBPMExpViewer jumpAdviceViewer;// 跳过意见
	private Button enableJumpStrategyCheckbox;// 启动跳过策略
	private Button jumpRecordCheckbox;// 跳过记录
	private SkipStrategy skipStrategy;

	public UserTaskJumpStrategyComposite(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public String setDescId() {
		return null;
	}

	@Override
	public Composite createUI(Composite parent) {
		Composite detailComposite = new Composite(parent, SWT.NONE);
		detailComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		detailComposite.setLayout(new GridLayout(2, false));

		enableJumpStrategyCheckbox = new Button(detailComposite, SWT.CHECK);
		enableJumpStrategyCheckbox.setText("启用跳过策略");

		new Label(detailComposite, SWT.NONE);

		jumpRecordCheckbox = new Button(detailComposite, SWT.CHECK);
		jumpRecordCheckbox.setText("跳过记录");

		new Label(detailComposite, SWT.NONE);

		Label jumpStrategyLabel = new Label(detailComposite, SWT.NONE);
		jumpStrategyLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		jumpStrategyLabel.setAlignment(SWT.RIGHT);
		jumpStrategyLabel.setText("跳过策略");
		jumpStrategyViewer = new FoxBPMExpViewer(detailComposite, SWT.BORDER);
		Control control = jumpStrategyViewer.getControl();
		control.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label handlerLabel = new Label(detailComposite, SWT.NONE);
		handlerLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		handlerLabel.setAlignment(SWT.RIGHT);
		handlerLabel.setText("处理者");
		handlerViewer = new FoxBPMExpViewer(detailComposite, SWT.BORDER);
		Control control_1 = handlerViewer.getControl();
		control_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label jumpAdviceLabel = new Label(detailComposite, SWT.NONE);
		jumpAdviceLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		jumpAdviceLabel.setAlignment(SWT.RIGHT);
		jumpAdviceLabel.setText("跳过意见");
		jumpAdviceViewer = new FoxBPMExpViewer(detailComposite, SWT.BORDER);
		Control control_2 = jumpAdviceViewer.getControl();
		control_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		setDefaultState();
		return parent;
	}

	@Override
	public void createUIBindings(EObject eObject) {
		activity = (Activity) eObject;
		jumpStrategyViewer.seteObject(activity);
		handlerViewer.seteObject(activity);
		jumpAdviceViewer.seteObject(activity);

		if (activity.getExtensionValues().size() > 0) {
			for (ExtensionAttributeValue extensionAttributeValue : activity.getExtensionValues()) {
				skipStrategy = (SkipStrategy) extensionAttributeValue.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__SKIP_STRATEGY);
			}
			if (skipStrategy == null) {
				skipStrategy = FoxBPMFactory.eINSTANCE.createSkipStrategy();
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						activity.getExtensionValues().get(0).getValue().add(FoxBPMPackage.Literals.DOCUMENT_ROOT__SKIP_STRATEGY, skipStrategy);
					}
				});
			}
		} else {
			skipStrategy = FoxBPMFactory.eINSTANCE.createSkipStrategy();
			FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__SKIP_STRATEGY, skipStrategy);
			final ExtensionAttributeValue extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
			extensionElement.getValue().add(extensionElementEntry);
		}

		Expression skipStrategyExpression = null;
		if (skipStrategy.getExpression() == null) {
			skipStrategyExpression = FoxBPMFactory.eINSTANCE.createExpression();
			skipStrategyExpression.setName("");
			skipStrategyExpression.setValue("");
		} else {
			skipStrategyExpression = (Expression) skipStrategy.getExpression();
		}

		Expression skipAssigneeExpression = null;
		if (skipStrategy.getSkipAssignee() == null) {
			skipAssigneeExpression = FoxBPMFactory.eINSTANCE.createExpression();
			skipAssigneeExpression.setName("");
			skipAssigneeExpression.setValue("");
		} else {
			skipAssigneeExpression = (Expression) skipStrategy.getSkipAssignee().getExpression();
		}

		if (skipStrategy != null && skipStrategy.isIsEnable()) {
			enableJumpStrategyCheckbox.setSelection(true);
			jumpRecordCheckbox.setEnabled(true);
			jumpStrategyViewer.setEnabled(true);
		}else{
			enableJumpStrategyCheckbox.setSelection(false);
			jumpRecordCheckbox.setEnabled(false);
			jumpStrategyViewer.setEnabled(false);
		}

		if (skipStrategy != null && skipStrategy.isIsCreateSkipProcess()) {
			jumpRecordCheckbox.setSelection(true);
			handlerViewer.setEnabled(true);
			jumpAdviceViewer.setEnabled(true);
		}else{
			jumpRecordCheckbox.setSelection(false);
			handlerViewer.setEnabled(false);
			jumpAdviceViewer.setEnabled(false);
		}

		Expression skipCommentExpression = null;
		if (skipStrategy.getSkipComment() == null) {
			skipCommentExpression = FoxBPMFactory.eINSTANCE.createExpression();
			skipCommentExpression.setName("");
			skipCommentExpression.setValue("");
		} else {
			skipCommentExpression = (Expression) skipStrategy.getSkipComment().getExpression();
		}

		// viewer上控件值
		jumpStrategyViewer.getTextControl().setText(skipStrategyExpression == null ? "" : skipStrategyExpression.getName());
		handlerViewer.getTextControl().setText(skipAssigneeExpression == null ? "" : skipAssigneeExpression.getName());
		jumpAdviceViewer.getTextControl().setText(skipCommentExpression == null ? "" : skipCommentExpression.getName());

		// 传递表达式对象
		jumpStrategyViewer.setExpression(skipStrategyExpression);
		handlerViewer.setExpression(skipAssigneeExpression);
		jumpAdviceViewer.setExpression(skipCommentExpression);

		jumpStrategyViewer.addExpressionChangedListeners(new IExpressionChangedListener() {

			@Override
			public void expressionChanged(final ExpressionChangedEvent event) {
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						setSkipStrategyExpression(activity, event.getFormalExpression());

						FormalExpression formalExpression = event.getFormalExpression();
						Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
						if (formalExpression != null) {
							Object expName = formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME);
							expression.setName(expName == null ? "" : expName.toString());
							expression.setValue(formalExpression.getBody());
						}

						// 传递表达式对象
						jumpStrategyViewer.setExpression(expression);
					}
				});

			}
		});

		handlerViewer.addExpressionChangedListeners(new IExpressionChangedListener() {

			@Override
			public void expressionChanged(final ExpressionChangedEvent event) {
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						setSkipAssigneeExpression(activity, event.getFormalExpression());

						FormalExpression formalExpression = event.getFormalExpression();
						Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
						if (formalExpression != null) {
							Object expName = formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME);
							expression.setName(expName == null ? "" : expName.toString());
							expression.setValue(formalExpression.getBody());
						}

						// 传递表达式对象
						handlerViewer.setExpression(expression);
					}
				});

			}
		});

		jumpAdviceViewer.addExpressionChangedListeners(new IExpressionChangedListener() {

			@Override
			public void expressionChanged(final ExpressionChangedEvent event) {
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						setSkipCommentExpression(activity, event.getFormalExpression());

						FormalExpression formalExpression = event.getFormalExpression();
						Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
						if (formalExpression != null) {
							Object expName = formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME);
							expression.setName(expName == null ? "" : expName.toString());
							expression.setValue(formalExpression.getBody());
						}

						// 传递表达式对象
						jumpAdviceViewer.setExpression(expression);
					}
				});

			}
		});

		enableJumpStrategyCheckbox.addSelectionListener(new SelectionAdapter() {	

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (enableJumpStrategyCheckbox.getSelection()) {
					jumpRecordCheckbox.setEnabled(true);
					jumpStrategyViewer.setEnabled(true);

					TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
					editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
						@Override
						protected void doExecute() {

							skipStrategy.setIsEnable(true);

						}
					});
				} else {
					jumpRecordCheckbox.setEnabled(false);
					jumpStrategyViewer.setEnabled(false);

					TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
					editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
						@Override
						protected void doExecute() {

							skipStrategy.setIsEnable(false);
							activity.getExtensionValues().remove(skipStrategy);
							jumpStrategyViewer.cleanData();

						}
					});
				}
			}

		});

		jumpRecordCheckbox.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (jumpRecordCheckbox.getSelection()) {
					handlerViewer.setEnabled(true);
					jumpAdviceViewer.setEnabled(true);

					TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
					editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
						@Override
						protected void doExecute() {

							skipStrategy.setIsCreateSkipProcess(true);

						}
					});
				} else {
					handlerViewer.setEnabled(false);
					jumpAdviceViewer.setEnabled(false);

					TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
					editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
						@Override
						protected void doExecute() {

							skipStrategy.setIsCreateSkipProcess(false);
							skipStrategy.setSkipComment(null);
							skipStrategy.setSkipAssignee(null);
							handlerViewer.getTextControl().setText("");
							jumpAdviceViewer.getTextControl().setText("");
						}
					});
				}
			}

		});

	}

	private void setSkipStrategyExpression(BaseElement baseElement, FormalExpression formalExpression) {

		for (ExtensionAttributeValue extensionAttributeValue : baseElement.getExtensionValues()) {

			FeatureMap extensionElements = extensionAttributeValue.getValue();
			for (Entry entry : extensionElements) {
				if (entry.getValue() instanceof SkipStrategy) {
					if (formalExpression == null) {
						extensionElements.remove(entry);
					} else {
						SkipStrategy skipStrategy = (SkipStrategy) entry.getValue();
						Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
						expression.setName(formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
						expression.setValue(formalExpression.getBody());
						skipStrategy.setExpression(expression);
					}

					return;
				}
			}

		}
		if (formalExpression != null) {
			SkipStrategy skipStrategy = FoxBPMFactory.eINSTANCE.createSkipStrategy();

			Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
			expression.setName(formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
			expression.setValue(formalExpression.getBody());
			skipStrategy.setExpression(expression);

			FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__SKIP_STRATEGY, skipStrategy);

			if (baseElement.getExtensionValues().size() > 0) {
				baseElement.getExtensionValues().get(0).getValue().add(extensionElementEntry);
			} else {
				ExtensionAttributeValue extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
				extensionElement.getValue().add(extensionElementEntry);
				baseElement.getExtensionValues().add(extensionElement);
			}
		}
	}

	private void setSkipAssigneeExpression(BaseElement baseElement, FormalExpression formalExpression) {

		for (ExtensionAttributeValue extensionAttributeValue : baseElement.getExtensionValues()) {

			FeatureMap extensionElements = extensionAttributeValue.getValue();
			for (Entry entry : extensionElements) {
				if (entry.getValue() instanceof SkipStrategy) {
					if (formalExpression == null) {
						extensionElements.remove(entry);
					} else {
						SkipStrategy skipStrategy = (SkipStrategy) entry.getValue();
						SkipAssignee skipAssignee = FoxBPMFactory.eINSTANCE.createSkipAssignee();
						Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
						skipAssignee.setExpression(expression);
						skipAssignee.getExpression().setName(formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
						skipAssignee.getExpression().setValue(formalExpression.getBody());
						skipStrategy.setSkipAssignee(skipAssignee);
						// skipStrategy.getSkipAssignee().getExpression().setName(formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
						// skipStrategy.getSkipAssignee().getExpression().setValue(formalExpression.getBody());
					}

					return;
				}
			}

		}
		if (formalExpression != null) {
			SkipStrategy skipStrategy = FoxBPMFactory.eINSTANCE.createSkipStrategy();

			Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
			expression.setName(formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
			expression.setValue(formalExpression.getBody());
			if (skipStrategy.getSkipAssignee() != null) {
				skipStrategy.getSkipAssignee().setExpression(expression);
			} else {
				SkipAssignee skipAssignee = FoxBPMFactory.eINSTANCE.createSkipAssignee();
				skipAssignee.setExpression(expression);
				skipStrategy.setSkipAssignee(skipAssignee);
			}

			FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__SKIP_STRATEGY, skipStrategy);

			if (baseElement.getExtensionValues().size() > 0) {
				baseElement.getExtensionValues().get(0).getValue().add(extensionElementEntry);
			} else {
				ExtensionAttributeValue extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
				extensionElement.getValue().add(extensionElementEntry);
				baseElement.getExtensionValues().add(extensionElement);
			}
		}
	}

	private void setSkipCommentExpression(BaseElement baseElement, FormalExpression formalExpression) {

		for (ExtensionAttributeValue extensionAttributeValue : baseElement.getExtensionValues()) {

			FeatureMap extensionElements = extensionAttributeValue.getValue();
			for (Entry entry : extensionElements) {
				if (entry.getValue() instanceof SkipStrategy) {
					if (formalExpression == null) {
						extensionElements.remove(entry);
					} else {
						SkipStrategy skipStrategy = (SkipStrategy) entry.getValue();
						SkipComment skipComment = FoxBPMFactory.eINSTANCE.createSkipComment();
						Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
						skipComment.setExpression(expression);
						skipComment.getExpression().setName(formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
						skipComment.getExpression().setValue(formalExpression.getBody());
						skipStrategy.setSkipComment(skipComment);
						// skipStrategy.getSkipComment().getExpression().setName(formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
						// skipStrategy.getSkipComment().getExpression().setValue(formalExpression.getBody());
					}

					return;
				}
			}

		}
		if (formalExpression != null) {
			SkipStrategy skipStrategy = FoxBPMFactory.eINSTANCE.createSkipStrategy();

			Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
			expression.setName(formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
			expression.setValue(formalExpression.getBody());
			if (skipStrategy.getSkipComment() != null) {
				skipStrategy.getSkipComment().setExpression(expression);
			} else {
				SkipComment skipComment = FoxBPMFactory.eINSTANCE.createSkipComment();
				skipComment.setExpression(expression);
				skipStrategy.setSkipComment(skipComment);
			}

			FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__SKIP_STRATEGY, skipStrategy);

			if (baseElement.getExtensionValues().size() > 0) {
				baseElement.getExtensionValues().get(0).getValue().add(extensionElementEntry);
			} else {
				ExtensionAttributeValue extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
				extensionElement.getValue().add(extensionElementEntry);
				baseElement.getExtensionValues().add(extensionElement);
			}
		}
	}

	/**
	 * 设置默认的控件状态
	 */
	private void setDefaultState() {
		jumpRecordCheckbox.setSelection(false);
		jumpRecordCheckbox.setEnabled(false);
		jumpStrategyViewer.setEnabled(false);
		handlerViewer.setEnabled(false);
		jumpAdviceViewer.setEnabled(false);
	}

}
