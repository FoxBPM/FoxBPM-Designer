package org.foxbpm.bpmn.designer.ui.propertytab.usertask;

import org.eclipse.bpmn2.UserTask;
import org.eclipse.emf.ecore.EObject;
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
import org.foxbpm.bpmn.designer.ui.expdialog.FoxBPMExpViewer;

public class UserTaskJumpStrategyComposite extends AbstractFoxBPMComposite {
	private UserTask userTask;
	private FoxBPMExpViewer jumpStrategyViewer;//跳过策略
	private FoxBPMExpViewer handlerViewer;//处理者
	private FoxBPMExpViewer jumpAdviceViewer;//跳过意见
	private Button enableJumpStrategyCheckbox;//启动跳过策略
	private Button jumpRecordCheckbox;//跳过记录

	public UserTaskJumpStrategyComposite(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public String setDescId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Composite createUI(Composite parent) {
		Composite detailComposite=new Composite(parent, SWT.NONE);
		detailComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		detailComposite.setLayout(new GridLayout(2, false));
		
		enableJumpStrategyCheckbox = new Button(detailComposite, SWT.CHECK);
		enableJumpStrategyCheckbox.setText("启动跳过策略");
		enableJumpStrategyCheckbox.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (enableJumpStrategyCheckbox.getSelection()) {
					jumpRecordCheckbox.setEnabled(true);
					jumpStrategyViewer.setEnabled(true);
				}else {
					jumpRecordCheckbox.setEnabled(false);
					jumpStrategyViewer.setEnabled(false);
				}
			}
			
		});
		new Label(detailComposite, SWT.NONE);
		
		jumpRecordCheckbox = new Button(detailComposite, SWT.CHECK);
		jumpRecordCheckbox.setText("跳过记录");
		jumpRecordCheckbox.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (jumpRecordCheckbox.getSelection()) {
					handlerViewer.setEnabled(true);
					jumpAdviceViewer.setEnabled(true);
				}else {
					handlerViewer.setEnabled(false);
					jumpAdviceViewer.setEnabled(false);
				}
			}
			
		});
		new Label(detailComposite, SWT.NONE);
		
		Label jumpStrategyLabel = new Label(detailComposite, SWT.NONE);
		jumpStrategyLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		jumpStrategyLabel.setAlignment(SWT.RIGHT);
		jumpStrategyLabel.setText("跳过策略");
		jumpStrategyViewer=new FoxBPMExpViewer(detailComposite, SWT.BORDER);
		Control control = jumpStrategyViewer.getControl();
		control.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label handlerLabel = new Label(detailComposite, SWT.NONE);
		handlerLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		handlerLabel.setAlignment(SWT.RIGHT);
		handlerLabel.setText("处理者");
		handlerViewer=new FoxBPMExpViewer(detailComposite, SWT.BORDER);
		Control control_1 = handlerViewer.getControl();
		control_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label jumpAdviceLabel = new Label(detailComposite, SWT.NONE);
		jumpAdviceLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		jumpAdviceLabel.setAlignment(SWT.RIGHT);
		jumpAdviceLabel.setText("跳过意见");
		jumpAdviceViewer=new FoxBPMExpViewer(detailComposite, SWT.BORDER);
		Control control_2 = jumpAdviceViewer.getControl();
		control_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		setDefaultState();
		return parent;
	}

	@Override
	public void createUIBindings(EObject eObject) {
		userTask=(UserTask)eObject;

	}
	
	/**
	 * 设置默认的控件状态
	 */
	private void setDefaultState(){
		jumpRecordCheckbox.setEnabled(false);
		jumpStrategyViewer.setEnabled(false);
		handlerViewer.setEnabled(false);
		jumpAdviceViewer.setEnabled(false);
	}

}
