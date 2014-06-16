package org.foxbpm.bpmn.designer.ui.propertytab.sequenceflow;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.FormalExpression;
import org.eclipse.bpmn2.SequenceFlow;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.foxbpm.bpmn.designer.ui.expdialog.ExpressionChangedEvent;
import org.foxbpm.bpmn.designer.ui.expdialog.FoxBPMExpViewer;
import org.foxbpm.bpmn.designer.ui.expdialog.IExpressionChangedListener;
import org.foxbpm.bpmn.designer.ui.propertytab.FoxBPMParentComposite;
import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;

public class SequenceFlowPropertyComposite extends FoxBPMParentComposite {
	private SequenceFlow sequenceFlow;
	private Text descText;
	private Text idText;
	private Text nameText;
	private Combo ordercombo;
	private FoxBPMExpViewer foxBPMExpViewer;

	public SequenceFlowPropertyComposite(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public void createUIBindings(EObject eObject) {
		sequenceFlow = (SequenceFlow) eObject;
		bindText(Bpmn2Package.Literals.BASE_ELEMENT__ID, idText, sequenceFlow);
		bindText(Bpmn2Package.Literals.FLOW_ELEMENT__NAME, nameText, sequenceFlow);
		bindCombo(FoxBPMPackage.Literals.DOCUMENT_ROOT__ORDER_ID, ordercombo, sequenceFlow);
		bindDocumentation(Bpmn2Package.Literals.BASE_ELEMENT__DOCUMENTATION, descText);
		
		FormalExpression formalExpression = (FormalExpression) sequenceFlow.getConditionExpression();
		final Expression foxexp = FoxBPMFactory.eINSTANCE.createExpression();
		Object expName = null;
		if(formalExpression == null) {
			foxexp.setName("");
			foxexp.setValue("");
		} else {
			expName = formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME);
			foxexp.setName(expName==null?"":expName.toString());
			foxexp.setValue(formalExpression.getBody());
		}
		
		
		//传递表达式对象
		foxBPMExpViewer.setExpression(foxexp);
		
		//viewer上控件值
		foxBPMExpViewer.getTextControl().setText(expName==null? "": expName.toString());
		foxBPMExpViewer.seteObject(eObject);
		foxBPMExpViewer.addExpressionChangedListeners(new IExpressionChangedListener() {

			@Override
			public void expressionChanged(final ExpressionChangedEvent event) {
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						if(event.getFormalExpression() == null) {
							sequenceFlow.setConditionExpression(null);
							//传递表达式对象
							foxexp.setName("");
							foxexp.setValue("");
							foxBPMExpViewer.setExpression(foxexp);
							return;
						}
						
						FormalExpression formalExpression = event.getFormalExpression();
						sequenceFlow.setConditionExpression(formalExpression);
						
						Object expName = formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME);
						foxexp.setName(expName==null?"":expName.toString());
						foxexp.setValue(formalExpression.getBody());
						
						//传递表达式对象
						foxBPMExpViewer.setExpression(foxexp);
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

		Label orderLabel = new Label(detailComposite, SWT.NONE);
		orderLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		orderLabel.setText("排序");

		ordercombo = new Combo(detailComposite, SWT.READ_ONLY);
		ordercombo.setItems(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" });
		ordercombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		ordercombo.select(0);

		Label expLabel = new Label(detailComposite, SWT.NONE);
		expLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		expLabel.setText("表达式");

		foxBPMExpViewer = new FoxBPMExpViewer(detailComposite, SWT.BORDER);
		Control control = foxBPMExpViewer.getControl();
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
		return "sequenceflow_desc";
	}
}
