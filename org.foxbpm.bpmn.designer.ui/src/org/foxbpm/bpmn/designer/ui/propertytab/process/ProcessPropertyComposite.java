package org.foxbpm.bpmn.designer.ui.propertytab.process;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.Process;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMComposite;
import org.foxbpm.bpmn.designer.ui.utils.BpmnModelUtil;
import org.eclipse.swt.widgets.Control;
import org.foxbpm.bpmn.designer.ui.expdialog.FoxBPMExpViewer;

public class ProcessPropertyComposite extends AbstractFoxBPMComposite {
	private Process process;
	private Text descText;
	private Text idText;
	private Text nameText;
	private Text uniText;
	private Text categoryText;

	public ProcessPropertyComposite(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public void createUIBindings(EObject eObject) {
		process = BpmnModelUtil.getProcessByEobj(eObject);
		bindText(Bpmn2Package.Literals.BASE_ELEMENT__ID, idText, process);
		bindText(Bpmn2Package.Literals.CALLABLE_ELEMENT__NAME, nameText, process);
		bindDocumentation(Bpmn2Package.Literals.BASE_ELEMENT__DOCUMENTATION, descText, process);
	}

	@Override
	public Composite createUI(Composite parent) {
		Composite detailComposite = new Composite(parent, SWT.NONE);
		detailComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		detailComposite.setLayout(new GridLayout(4, false));
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

		FoxBPMExpViewer tasksubjectViewer = new FoxBPMExpViewer(detailComposite, SWT.BORDER);
		Control control_1 = tasksubjectViewer.getControl();
		control_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));

		Label operformLabel = new Label(detailComposite, SWT.NONE);
		operformLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		operformLabel.setText("操作表单");

		FoxBPMExpViewer operformViewer = new FoxBPMExpViewer(detailComposite, SWT.BORDER);
		Control control = operformViewer.getControl();
		control.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		Label viewformLabel = new Label(detailComposite, SWT.NONE);
		viewformLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		viewformLabel.setText("浏览表单");

		FoxBPMExpViewer viewformViewer = new FoxBPMExpViewer(detailComposite, SWT.BORDER);
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
}
