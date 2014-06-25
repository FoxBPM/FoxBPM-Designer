package org.foxbpm.bpmn.designer.ui.propertytab.scripttask;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.FormalExpression;
import org.eclipse.bpmn2.ScriptTask;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.foxbpm.bpmn.designer.base.utils.FoxBPMDesignerUtil;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMComposite;
import org.foxbpm.bpmn.designer.ui.expdialog.ExpressionChangedEvent;
import org.foxbpm.bpmn.designer.ui.expdialog.FoxBPMExpViewer;
import org.foxbpm.bpmn.designer.ui.expdialog.IExpressionChangedListener;
import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;

public class ScriptTaskPropertyComposite extends AbstractFoxBPMComposite{
	private ScriptTask scriptTask;
	private Text descText;
	private Text idText;
	private Text nameText;
	private FoxBPMExpViewer ExpViewer;

	public ScriptTaskPropertyComposite(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public void createUIBindings(EObject eObject) {
		scriptTask = (ScriptTask) eObject;
		bindText(Bpmn2Package.Literals.BASE_ELEMENT__ID, idText, scriptTask);
		bindText(Bpmn2Package.Literals.FLOW_ELEMENT__NAME, nameText, scriptTask);
		bindDocumentation(Bpmn2Package.Literals.BASE_ELEMENT__DOCUMENTATION, descText);
		
		String name = null;
		Expression expression = null;
		if (scriptTask.getScript() != null) {
			expression = FoxBPMFactory.eINSTANCE.createExpression();

			name = scriptTask.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__SCRIPT_NAME).toString();

			if (name != null) {
				expression.setName(name);
			}

			expression.setValue(scriptTask.getScript());
		}
		
		if (expression == null) {
			expression = FoxBPMFactory.eINSTANCE.createExpression();
			expression.setName("");
			expression.setValue("");
		}
		
		ExpViewer.getTextControl().setText(name==null? "": name);
		ExpViewer.setExpression(expression);
		ExpViewer.seteObject(eObject);

		ExpViewer.addExpressionChangedListeners(new IExpressionChangedListener() {

			@Override
			public void expressionChanged(final ExpressionChangedEvent event) {
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {

						if (event.getFormalExpression() != null) {
							getBusinessObject().eSet(FoxBPMPackage.Literals.DOCUMENT_ROOT__SCRIPT_NAME, event.getFormalExpression().eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
							scriptTask.setScriptFormat(FoxBPMDesignerUtil.getFoxBPMConfig().getScriptLanguageConfig().getSelected()==null?"groovy" : FoxBPMDesignerUtil.getFoxBPMConfig().getScriptLanguageConfig().getSelected());
							scriptTask.setScript(event.getFormalExpression().getBody());
						} else {
							scriptTask.setScriptFormat(null);
							getBusinessObject().eSet(FoxBPMPackage.Literals.DOCUMENT_ROOT__SCRIPT_NAME, null);
							scriptTask.setScript(null);
						}

						FormalExpression formalExpression = event.getFormalExpression();
						Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
						if(formalExpression!=null) {
							Object expName = formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME);
							expression.setName(expName==null?"":expName.toString());
							expression.setValue(formalExpression.getBody());
						}
						//传递表达式对象
						ExpViewer.setExpression(expression);
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
		idLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		idLabel.setText("编号");

		idText = new Text(detailComposite, SWT.BORDER);
		idText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		idText.setEditable(false);
		
		Label nameLabel = new Label(detailComposite, SWT.NONE);
		nameLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		nameLabel.setText("名称");

		nameText = new Text(detailComposite, SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label expLabel = new Label(detailComposite, SWT.NONE);
		expLabel.setText("表达式");
		
		ExpViewer = new FoxBPMExpViewer(detailComposite, SWT.BORDER);
		Control control = ExpViewer.getControl();
		control.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label descLabel = new Label(detailComposite, SWT.NONE);
		descLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		descLabel.setText("描述");
		
		descText = new Text(detailComposite, SWT.BORDER | SWT.WRAP | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL | SWT.MULTI);
		GridData gd_descText = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_descText.heightHint = 50;
		descText.setLayoutData(gd_descText);
		
		return parent;
	}

	@Override
	public String setDescId() {
		return "script_task_desc";
	}
}
