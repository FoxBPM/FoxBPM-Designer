package org.foxbpm.bpmn.designer.ui.propertytab.usertask;

import org.eclipse.bpmn2.UserTask;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMComposite;
import org.foxbpm.bpmn.designer.ui.expdialog.FoxBPMExpViewer;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Control;

public class UserTaskTaskPropertyComposite extends AbstractFoxBPMComposite {
	private UserTask userTask;
	private Combo priorityCombo;//优先级
	private Combo taskTypeCombo;//任务类型
	private FoxBPMExpViewer taskNameViewer;//任务名称
	private FoxBPMExpViewer taskDescriptionViewer;//任务描述
	private FoxBPMExpViewer filishedDescriptionViewer;//完成后的描述
	private Spinner predictDaysSpinner;//预计持续天数
	private Spinner predictHoursSpinner;//预计持续小时
	private Spinner predictMiniutesSpinner;//预计持续分钟

	public UserTaskTaskPropertyComposite(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public String setDescId() {
		return null;
	}

	@Override
	public Composite createUI(Composite parent) {
		Composite detailComposite=new Composite(parent,SWT.NONE);
		detailComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		detailComposite.setLayout(new GridLayout(2, false));
		
		Label priorityLabel = new Label(detailComposite, SWT.NONE);
		priorityLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		priorityLabel.setText("优先级");
		priorityCombo=new Combo(detailComposite, SWT.READ_ONLY);
		GridData gd_priorityCombo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_priorityCombo.widthHint = 100;
		priorityCombo.setLayoutData(gd_priorityCombo);
		priorityCombo.setItems(new String[]{"非常低","低","一般","高","非常高"});
		priorityCombo.select(2);
		
		Label taskTypeLabel = new Label(detailComposite, SWT.NONE);
		taskTypeLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		taskTypeLabel.setText("任务类型");
		taskTypeCombo=new Combo(detailComposite, SWT.READ_ONLY);
		GridData gd_taskTypeCombo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_taskTypeCombo.widthHint = 100;
		taskTypeCombo.setLayoutData(gd_taskTypeCombo);
		taskTypeCombo.setItems(new String[]{"通用任务","通知任务","默认通用任务"});
		taskTypeCombo.select(0);
		
		Label taskNameLabel = new Label(detailComposite, SWT.NONE);
		taskNameLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		taskNameLabel.setText("任务名称");
		taskNameViewer=new FoxBPMExpViewer(detailComposite, SWT.BORDER);
		Control control = taskNameViewer.getControl();
		control.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label taskDescriptionLabel = new Label(detailComposite, SWT.NONE);
		taskDescriptionLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		taskDescriptionLabel.setText("任务描述");
		taskDescriptionViewer=new FoxBPMExpViewer(detailComposite, SWT.BORDER);
		Control control_1 = taskDescriptionViewer.getControl();
		control_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label filishedDescriptionLabel = new Label(detailComposite, SWT.NONE);
		filishedDescriptionLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		filishedDescriptionLabel.setText("完成后的描述");
		filishedDescriptionViewer=new FoxBPMExpViewer(detailComposite, SWT.BORDER);
		Control control_2 = filishedDescriptionViewer.getControl();
		control_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label durationLabel = new Label(detailComposite, SWT.NONE);
		durationLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		durationLabel.setText("预计持续时间");
		Composite durationTime=new Composite(detailComposite, SWT.NONE);
		durationTime.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		durationTime.setLayout(new GridLayout(6, false));
		
		Label daysLabel = new Label(durationTime, SWT.NONE);
		daysLabel.setText("天");
		predictDaysSpinner=new Spinner(durationTime, SWT.BORDER | SWT.READ_ONLY);
		
		Label hoursLabel = new Label(durationTime, SWT.NONE);
		hoursLabel.setText("小时");
		predictHoursSpinner=new Spinner(durationTime, SWT.BORDER | SWT.READ_ONLY);
		
		Label miniutesLabel = new Label(durationTime, SWT.NONE);
		miniutesLabel.setText("分");
		predictMiniutesSpinner=new Spinner(durationTime, SWT.BORDER | SWT.READ_ONLY);
		return parent;
	}

	@Override
	public void createUIBindings(EObject eObject) {
		userTask=(UserTask)eObject;

	}

}
