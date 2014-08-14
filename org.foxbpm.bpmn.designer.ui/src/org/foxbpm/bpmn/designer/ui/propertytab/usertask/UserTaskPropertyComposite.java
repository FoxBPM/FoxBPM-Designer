package org.foxbpm.bpmn.designer.ui.propertytab.usertask;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.UserTask;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMComposite;
import org.foxbpm.bpmn.designer.ui.expdialog.FoxBPMExpViewer;
import org.eclipse.swt.widgets.Control;

public class UserTaskPropertyComposite extends AbstractFoxBPMComposite{
	private UserTask userTask;
	private Text descText;
	private Text idText;
	private Text nameText;

	public UserTaskPropertyComposite(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public void createUIBindings(EObject eObject) {
		userTask = (UserTask) eObject;
		bindText(Bpmn2Package.Literals.BASE_ELEMENT__ID, idText, userTask);
		bindText(Bpmn2Package.Literals.FLOW_ELEMENT__NAME, nameText, userTask);
		bindDocumentation(Bpmn2Package.Literals.BASE_ELEMENT__DOCUMENTATION, descText);
	
		addDecorate(nameText, "activityAdvance_loopDataInputCollection");
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
		return "user_task_desc";
	}
}
