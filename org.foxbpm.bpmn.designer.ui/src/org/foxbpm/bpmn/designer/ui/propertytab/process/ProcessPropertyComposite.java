package org.foxbpm.bpmn.designer.ui.propertytab.process;

import org.eclipse.bpmn2.BaseElement;
import org.eclipse.bpmn2.Bpmn2Factory;
import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.ExtensionAttributeValue;
import org.eclipse.bpmn2.FormalExpression;
import org.eclipse.bpmn2.Process;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl.SimpleFeatureMapEntry;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMComposite;
import org.foxbpm.bpmn.designer.ui.utils.BpmnModelUtil;
import org.eclipse.swt.widgets.Control;
import org.foxbpm.bpmn.designer.ui.expdialog.ExpressionChangedEvent;
import org.foxbpm.bpmn.designer.ui.expdialog.FoxBPMExpViewer;
import org.foxbpm.bpmn.designer.ui.expdialog.IExpressionChangedListener;
import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FormUri;
import org.foxbpm.model.bpmn.foxbpm.FormUriView;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;
import org.foxbpm.model.bpmn.foxbpm.TaskSubject;
import org.eclipse.swt.widgets.Button;

public class ProcessPropertyComposite extends AbstractFoxBPMComposite {
	private Process process;
	private Text descText;
	private Text idText;
	private Text nameText;
	private Text uniText;
	private Text categoryText;
	private FoxBPMExpViewer operformViewer;
	private FoxBPMExpViewer tasksubjectViewer;
	private FoxBPMExpViewer viewformViewer;
	private Button isPersistence;

	public ProcessPropertyComposite(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public void createUIBindings(EObject eObject) {
		initCheckBox();
		process = BpmnModelUtil.getProcessByEobj(eObject);
		
		bindText(Bpmn2Package.Literals.BASE_ELEMENT__ID, idText, process);
		bindText(Bpmn2Package.Literals.CALLABLE_ELEMENT__NAME, nameText, process);
		bindDocumentation(Bpmn2Package.Literals.BASE_ELEMENT__DOCUMENTATION, descText, process);
		
		
		operformViewer.seteObject(process);
		viewformViewer.seteObject(process);
		tasksubjectViewer.seteObject(process);
		
		ExtensionAttributeValue extensionAttributeValue = null;
		if(process.getExtensionValues().size()>0) {
			extensionAttributeValue = process.getExtensionValues().get(0);
		}else {
			extensionAttributeValue = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
		}
		
		TaskSubject taskSubject = null;
		FeatureMap extensionElements = extensionAttributeValue.getValue();
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
		
		
		FormUri formUri = (FormUri) extensionAttributeValue.getValue().get(FoxBPMPackage.Literals.DOCUMENT_ROOT__FORM_URI, true);
		FormUriView formUriView = (FormUriView) extensionAttributeValue.getValue().get(FoxBPMPackage.Literals.DOCUMENT_ROOT__FORM_URI_VIEW, true);
		Expression formUriformalExpression = null;
		if(formUri==null) {
			formUriformalExpression = FoxBPMFactory.eINSTANCE.createExpression();
			formUriformalExpression.setName("");
			formUriformalExpression.setValue("");
		}else {
			formUriformalExpression = (Expression) formUri.getExpression();
		}
		
		Expression formUriViewformalExpression = FoxBPMFactory.eINSTANCE.createExpression();
		if(formUriView==null) {
			formUriViewformalExpression = FoxBPMFactory.eINSTANCE.createExpression();
			formUriViewformalExpression.setName("");
			formUriViewformalExpression.setValue("");
		}else {
			formUriViewformalExpression = (Expression) formUriView.getExpression();
		}
		

		//viewer上控件值
		operformViewer.getTextControl().setText(formUriformalExpression==null? "": formUriformalExpression.getName());
		viewformViewer.getTextControl().setText(formUriViewformalExpression==null? "": formUriViewformalExpression.getName());
		tasksubjectViewer.getTextControl().setText(taskSubjectExp == null ? "" : taskSubjectExp.getName());
		
		//传递表达式对象
		operformViewer.setExpression(formUriformalExpression);
		viewformViewer.setExpression(formUriViewformalExpression);
		tasksubjectViewer.setExpression(taskSubjectExp);
		
		tasksubjectViewer.addExpressionChangedListeners(new IExpressionChangedListener() {

			@Override
			public void expressionChanged(final ExpressionChangedEvent event) {
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						setTaskSubjectExtensionExpression(process, event.getFormalExpression());
						
						FormalExpression formalExpression = event.getFormalExpression();
						Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
						if(formalExpression!=null) {
							Object expName = formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME);
							expression.setName(expName==null?"":expName.toString());
							expression.setValue(formalExpression.getBody());
						}
						
						//传递表达式对象
						tasksubjectViewer.setExpression(expression);
					}
				});
			}
		});
		
		operformViewer.addExpressionChangedListeners(new IExpressionChangedListener() {

			@Override
			public void expressionChanged(final ExpressionChangedEvent event) {
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						setFormUriExtensionExpression(process, event.getFormalExpression());
						
						FormalExpression formalExpression = event.getFormalExpression();
						Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
						if(formalExpression!=null) {
							Object expName = formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME);
							expression.setName(expName==null?"":expName.toString());
							expression.setValue(formalExpression.getBody());
						}
						
						//传递表达式对象
						operformViewer.setExpression(expression);
					}
				});

			}
		});

		viewformViewer.addExpressionChangedListeners(new IExpressionChangedListener() {

			@Override
			public void expressionChanged(final ExpressionChangedEvent event) {
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						setFormUriViewExtensionExpression(process, event.getFormalExpression());
						
						FormalExpression formalExpression = event.getFormalExpression();
						Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
						if(formalExpression!=null) {
							Object expName = formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME);
							expression.setName(expName==null?"":expName.toString());
							expression.setValue(formalExpression.getBody());
						}
						
						//传递表达式对象
						operformViewer.setExpression(expression);
					}
				});

			}
		});
	}

	@Override
	public Composite createUI(Composite parent) {
		Composite detailComposite = new Composite(parent, SWT.NONE);
		detailComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		detailComposite.setLayout(new GridLayout(4, false));
		
		isPersistence = new Button(detailComposite, SWT.CHECK);
		isPersistence.setSelection(true);
		isPersistence.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 4, 1));
		isPersistence.setText("是否持久化");
		
		isPersistence.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(isPersistence.getSelection()) {
					TransactionalEditingDomainImpl editingDomain = (TransactionalEditingDomainImpl) getDiagramEditor().getEditingDomain();
					editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
						@Override
						protected void doExecute() {
							process.eSet(FoxBPMPackage.Literals.DOCUMENT_ROOT__IS_PERSISTENCE, true);
						}
					});
				}else {
					TransactionalEditingDomainImpl editingDomain = (TransactionalEditingDomainImpl) getDiagramEditor().getEditingDomain();
					editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
						@Override
						protected void doExecute() {
							process.eSet(FoxBPMPackage.Literals.DOCUMENT_ROOT__IS_PERSISTENCE, false);
						}
					});
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
		
		Label idLabel = new Label(detailComposite, SWT.NONE);
		idLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		idLabel.setText("编号");

		idText = new Text(detailComposite, SWT.BORDER);
		idText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		idText.setEditable(false);

		Label uniLabel = new Label(detailComposite, SWT.NONE);
		uniLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		uniLabel.setText("唯一编号");

		uniText = new Text(detailComposite, SWT.BORDER);
		uniText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label nameLabel = new Label(detailComposite, SWT.NONE);
		nameLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		nameLabel.setText("名称");

		nameText = new Text(detailComposite, SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label categoryLabel = new Label(detailComposite, SWT.NONE);
		categoryLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		categoryLabel.setText("分类");

		categoryText = new Text(detailComposite, SWT.BORDER);
		categoryText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label tasksubjectLabel = new Label(detailComposite, SWT.NONE);
		tasksubjectLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		tasksubjectLabel.setText("任务主题");

		tasksubjectViewer = new FoxBPMExpViewer(detailComposite, SWT.BORDER);
		Control control_1 = tasksubjectViewer.getControl();
		control_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));

		Label operformLabel = new Label(detailComposite, SWT.NONE);
		operformLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		operformLabel.setText("操作表单");

		operformViewer = new FoxBPMExpViewer(detailComposite, SWT.BORDER);
		Control control = operformViewer.getControl();
		control.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		Label viewformLabel = new Label(detailComposite, SWT.NONE);
		viewformLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		viewformLabel.setText("浏览表单");

		viewformViewer = new FoxBPMExpViewer(detailComposite, SWT.BORDER);
		Control control_2 = viewformViewer.getControl();
		control_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		Label descLabel = new Label(detailComposite, SWT.NONE);
		descLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		descLabel.setText("描述");

		descText = new Text(detailComposite, SWT.BORDER | SWT.WRAP | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL | SWT.MULTI);
		GridData gd_descText = new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1);
		gd_descText.heightHint = 50;
		descText.setLayoutData(gd_descText);

		return parent;
	}

	@Override
	public String setDescId() {
		return "script_task_desc";
	}
	
	private void initCheckBox() {
		Object isP = ((Process)BpmnModelUtil.getProcessByEobj(getBusinessObject())).eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__IS_PERSISTENCE);
		if(isP!=null) {
			boolean persistence = (Boolean) isP;
			if(persistence) {
				isPersistence.setSelection(true);
			}else{
				isPersistence.setSelection(false);
			}
		}
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
	
	private void setFormUriExtensionExpression(BaseElement baseElement, FormalExpression formalExpression) {

		for (ExtensionAttributeValue extensionAttributeValue : baseElement.getExtensionValues()) {

			FeatureMap extensionElements = extensionAttributeValue.getValue();
			for (Entry entry : extensionElements) {
				if (entry.getValue() instanceof FormUri) {
					if (formalExpression == null) {
						extensionElements.remove(entry);
					} else {
						FormUri formUri = (FormUri) entry.getValue();
						formUri.getExpression().setName(formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
						formUri.getExpression().setValue(formalExpression.getBody());
					}

					return;
				}
			}

		}
		if (formalExpression != null) {
			FormUri formUri = FoxBPMFactory.eINSTANCE.createFormUri();

			Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
			expression.setName(formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
			expression.setValue(formalExpression.getBody());
			formUri.setExpression(expression);

			FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__FORM_URI, formUri);

			if (baseElement.getExtensionValues().size() > 0) {
				baseElement.getExtensionValues().get(0).getValue().add(extensionElementEntry);
			} else {
				ExtensionAttributeValue extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
				extensionElement.getValue().add(extensionElementEntry);
				baseElement.getExtensionValues().add(extensionElement);
			}
		}
	}

	private void setFormUriViewExtensionExpression(BaseElement baseElement, FormalExpression formalExpression) {

		for (ExtensionAttributeValue extensionAttributeValue : baseElement.getExtensionValues()) {

			FeatureMap extensionElements = extensionAttributeValue.getValue();
			for (Entry entry : extensionElements) {
				if (entry.getValue() instanceof FormUriView) {
					if (formalExpression == null) {
						extensionElements.remove(entry);
					} else {
						FormUriView formUriView = (FormUriView) entry.getValue();
						formUriView.getExpression().setName(formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
						formUriView.getExpression().setValue(formalExpression.getBody());
					}

					return;
				}
			}

		}
		if (formalExpression != null) {
			FormUriView formUriView = FoxBPMFactory.eINSTANCE.createFormUriView();

			Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
			expression.setName(formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
			expression.setValue(formalExpression.getBody());
			formUriView.setExpression(expression);

			FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__FORM_URI_VIEW, formUriView);

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
