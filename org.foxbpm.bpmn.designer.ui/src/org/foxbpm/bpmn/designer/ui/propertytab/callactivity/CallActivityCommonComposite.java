package org.foxbpm.bpmn.designer.ui.propertytab.callactivity;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.CallActivity;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.foxbpm.bpmn.designer.base.utils.StringUtil;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMComposite;
import org.foxbpm.bpmn.designer.ui.expdialog.ExpressionChangedEvent;
import org.foxbpm.bpmn.designer.ui.expdialog.FoxBPMExpViewer;
import org.foxbpm.bpmn.designer.ui.expdialog.IExpressionChangedListener;
import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;

public class CallActivityCommonComposite extends AbstractFoxBPMComposite{
	private CallActivity callActivity;
	private Text descText;
	private Text idText;
	private Text nameText;
	private Button asynButton;
	private FoxBPMExpViewer foxBPMExpViewer_1;
	private FoxBPMExpViewer foxBPMExpViewer_2;
	private FoxBPMExpViewer foxBPMExpViewer;

	public CallActivityCommonComposite(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public void createUIBindings(EObject eObject) {
		callActivity = (CallActivity) eObject;
		bindText(Bpmn2Package.Literals.BASE_ELEMENT__ID, idText, callActivity);
		bindText(Bpmn2Package.Literals.FLOW_ELEMENT__NAME, nameText, callActivity);
		bindDocumentation(Bpmn2Package.Literals.BASE_ELEMENT__DOCUMENTATION, descText);
		bindAttributeCheckButton(asynButton, FoxBPMPackage.Literals.DOCUMENT_ROOT__IS_ASYNC);
		
		foxBPMExpViewer.seteObject(eObject);
		foxBPMExpViewer_1.seteObject(eObject);
		foxBPMExpViewer_2.seteObject(eObject);
		
		Object elementId = callActivity.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__CALLABLE_ELEMENT_ID);
		Object elementName = callActivity.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__CALLABLE_ELEMENT_NAME);
		
		if ((elementId != null && !elementId.toString().equals("")) && (elementName != null && !elementName.toString().equals(""))) {
			Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
			expression.setName(elementName.toString());
			expression.setValue(elementId.toString());
			foxBPMExpViewer.setExpression(expression);
		}
		
		Object elementVersion = callActivity.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__CALLABLE_ELEMENT_VERSION);
		Object elementVersionName = callActivity.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__CALLABLE_ELEMENT_VERSION_NAME);

		if ((elementVersion != null && !elementVersion.toString().equals("")) && (elementVersionName != null && !elementVersionName.toString().equals(""))) {

			Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
			expression.setName(elementVersionName.toString());
			expression.setValue(elementVersion.toString());
			foxBPMExpViewer_1.setExpression(expression);

		}
		
		Object callableElementBizKey = callActivity.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__CALLABLE_ELEMENT_BIZ_KEY);
		Object callableElementBizKeyName = callActivity.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__CALLABLE_ELEMENT_BIZ_KEY_NAME);

		if ((callableElementBizKey != null && !callableElementBizKey.toString().equals("")) && (callableElementBizKeyName != null && !callableElementBizKeyName.toString().equals(""))) {

			Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
			expression.setName(callableElementBizKeyName.toString());
			expression.setValue(callableElementBizKey.toString());
			foxBPMExpViewer_2.setExpression(expression);

		}
		
		foxBPMExpViewer.addExpressionChangedListeners(new IExpressionChangedListener() {

			@Override
			public void expressionChanged(final ExpressionChangedEvent event) {
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {

						if (event.getFormalExpression() != null) {
							callActivity.eSet(FoxBPMPackage.Literals.DOCUMENT_ROOT__CALLABLE_ELEMENT_ID, event.getFormalExpression().getBody());
							callActivity.eSet(FoxBPMPackage.Literals.DOCUMENT_ROOT__CALLABLE_ELEMENT_NAME, event.getFormalExpression().eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());

						} else {
							callActivity.eSet(FoxBPMPackage.Literals.DOCUMENT_ROOT__CALLABLE_ELEMENT_ID, null);
							callActivity.eSet(FoxBPMPackage.Literals.DOCUMENT_ROOT__CALLABLE_ELEMENT_NAME, null);
						}

					}
				});
			}
		});

		foxBPMExpViewer_1.addExpressionChangedListeners(new IExpressionChangedListener() {

			@Override
			public void expressionChanged(final ExpressionChangedEvent event) {
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						if (event.getFormalExpression() != null) {
							callActivity.eSet(FoxBPMPackage.Literals.DOCUMENT_ROOT__CALLABLE_ELEMENT_VERSION, event.getFormalExpression().getBody());
							callActivity.eSet(FoxBPMPackage.Literals.DOCUMENT_ROOT__CALLABLE_ELEMENT_VERSION_NAME, event.getFormalExpression().eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());

						} else {
							callActivity.eSet(FoxBPMPackage.Literals.DOCUMENT_ROOT__CALLABLE_ELEMENT_VERSION, null);
							callActivity.eSet(FoxBPMPackage.Literals.DOCUMENT_ROOT__CALLABLE_ELEMENT_VERSION_NAME, null);
						}
					}
				});
			}
		});

		foxBPMExpViewer_2.addExpressionChangedListeners(new IExpressionChangedListener() {

			@Override
			public void expressionChanged(final ExpressionChangedEvent event) {
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						if (event.getFormalExpression() != null) {
							callActivity.eSet(FoxBPMPackage.Literals.DOCUMENT_ROOT__CALLABLE_ELEMENT_BIZ_KEY, event.getFormalExpression().getBody());
							callActivity.eSet(FoxBPMPackage.Literals.DOCUMENT_ROOT__CALLABLE_ELEMENT_BIZ_KEY_NAME, event.getFormalExpression().eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());

						} else {
							callActivity.eSet(FoxBPMPackage.Literals.DOCUMENT_ROOT__CALLABLE_ELEMENT_BIZ_KEY, null);
							callActivity.eSet(FoxBPMPackage.Literals.DOCUMENT_ROOT__CALLABLE_ELEMENT_BIZ_KEY_NAME, null);
						}
					}
				});
			}
		});
	}

	@Override
	public Composite createUI(Composite parent) {
		Composite detailComposite = new Composite(parent, SWT.NONE);
		detailComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		detailComposite.setLayout(new GridLayout(2, false));
		Label idLabel = new Label(detailComposite, SWT.NONE);
		idLabel.setText("编号");

		idText = new Text(detailComposite, SWT.BORDER);
		idText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		idText.setEditable(false);
		
		Label nameLabel = new Label(detailComposite, SWT.NONE);
		nameLabel.setText("名称");

		nameText = new Text(detailComposite, SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label processLabel = new Label(detailComposite, SWT.NONE);
		processLabel.setText("子流程编号");
		
		foxBPMExpViewer = new FoxBPMExpViewer(detailComposite, SWT.BORDER);
		Control control = foxBPMExpViewer.getControl();
		control.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label versionLabel = new Label(detailComposite, SWT.NONE);
		versionLabel.setText("版本");
		
		foxBPMExpViewer_1 = new FoxBPMExpViewer(detailComposite, SWT.BORDER);
		Control control_1 = foxBPMExpViewer_1.getControl();
		control_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label refervalueLabel = new Label(detailComposite, SWT.NONE);
		refervalueLabel.setText("关联值");
		
		foxBPMExpViewer_2 = new FoxBPMExpViewer(detailComposite, SWT.BORDER);
		Control control_2 = foxBPMExpViewer_2.getControl();
		control_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label asynLabel = new Label(detailComposite, SWT.NONE);
		asynLabel.setText("异步");
		
		asynButton = new Button(detailComposite, SWT.CHECK);
		
		Label descLabel = new Label(detailComposite, SWT.NONE);
		descLabel.setText("描述");
		
		descText = new Text(detailComposite, SWT.BORDER | SWT.WRAP | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL | SWT.MULTI);
		GridData gd_descText = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_descText.heightHint = 50;
		descText.setLayoutData(gd_descText);
		
		return parent;
	}

	@Override
	public String setDescId() {
		return "";
	}
	
	public void bindAttributeCheckButton(final Button button, final EStructuralFeature eStructuralFeature) {

		Object eGet = getBusinessObject().eGet(eStructuralFeature);

		if (eGet != null && !eGet.toString().equals("")) {

			boolean isAsynsObj = StringUtil.getBoolean(eGet.toString());

			button.setSelection(isAsynsObj);
		}

		IObservableValue textObserver = SWTObservables.observeSelection(button);// (text,
		// SWT.Modify);
		textObserver.addValueChangeListener(new IValueChangeListener() {

			@Override
			public void handleValueChange(final ValueChangeEvent e) {

				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						getBusinessObject().eSet(eStructuralFeature, e.diff.getNewValue().toString());
					}
				});
			}

		});
	}
}
