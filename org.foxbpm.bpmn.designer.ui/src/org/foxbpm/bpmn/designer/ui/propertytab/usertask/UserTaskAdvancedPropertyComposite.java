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

public class UserTaskAdvancedPropertyComposite extends AbstractFoxBPMComposite {
	private UserTask userTask;
	private FoxBPMExpViewer inputDatasetViewer;//输入数据集
	private FoxBPMExpViewer inputItemViewer;//输入数据集
	private FoxBPMExpViewer outputItemViewer;//输入数据集
	private FoxBPMExpViewer outputDatasetViewer;//输入数据集
	private FoxBPMExpViewer fulfillConditionViewer;//输入数据集

	public UserTaskAdvancedPropertyComposite(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public String setDescId() {
		return null;
	}

	@Override
	public Composite createUI(Composite parent) {
		Composite containerComposite=new Composite(parent, SWT.NONE);
		containerComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		containerComposite.setLayout(new GridLayout(1,false));
		
		Composite detailComposite=new Composite(containerComposite, SWT.NONE);
		detailComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		detailComposite.setLayout(new GridLayout(2, false));
		
		Button nullRadio = new Button(detailComposite, SWT.RADIO);
		GridData gd_nullRadio = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_nullRadio.widthHint = 60;
		nullRadio.setLayoutData(gd_nullRadio);
		nullRadio.setText("无");
		nullRadio.setSelection(true);
		Button multiInstanceRadio = new Button(detailComposite, SWT.RADIO);
		GridData gd_multiInstanceRadio = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_multiInstanceRadio.widthHint = 60;
		multiInstanceRadio.setLayoutData(gd_multiInstanceRadio);
		multiInstanceRadio.setText("多实例");
		
		final Composite multiComposite=new Composite(containerComposite, SWT.NONE);
		multiComposite.setLayout(new GridLayout(4, false));
		multiComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		multiComposite.setVisible(false);//默认不可见
		
		Button conrurrentRadio = new Button(multiComposite, SWT.RADIO);
		GridData gd_conrurrentRadio = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_conrurrentRadio.widthHint = 60;
		conrurrentRadio.setLayoutData(gd_conrurrentRadio);
		conrurrentRadio.setText("并行");
		Button sequenceRadio = new Button(multiComposite, SWT.RADIO);
		GridData gd_sequenceRadio = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_sequenceRadio.widthHint = 60;
		sequenceRadio.setLayoutData(gd_sequenceRadio);
		sequenceRadio.setText("顺序");
		new Label(multiComposite, SWT.NONE);
		new Label(multiComposite, SWT.NONE);
		
		Label inputDataSetLabel = new Label(multiComposite, SWT.NONE);
		inputDataSetLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		inputDataSetLabel.setAlignment(SWT.RIGHT);
		inputDataSetLabel.setText("输入数据集");
		inputDatasetViewer=new FoxBPMExpViewer(multiComposite, SWT.BORDER);
		Control control = inputDatasetViewer.getControl();
		control.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		
		Label inputItemLabel = new Label(multiComposite, SWT.NONE);
		inputItemLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		inputItemLabel.setText("输入项");
		inputItemViewer=new FoxBPMExpViewer(multiComposite, SWT.BORDER);
		Control control_1 = inputItemViewer.getControl();
		control_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label outputItemLabel = new Label(multiComposite, SWT.NONE);
		outputItemLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		outputItemLabel.setText("输出项");
		outputItemViewer=new FoxBPMExpViewer(multiComposite, SWT.BORDER);
		Control control_2 = outputItemViewer.getControl();
		control_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label outputDataSetLabel = new Label(multiComposite, SWT.NONE);
		outputDataSetLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		outputDataSetLabel.setAlignment(SWT.RIGHT);
		outputDataSetLabel.setText("输出数据集");
		outputDatasetViewer=new FoxBPMExpViewer(multiComposite, SWT.BORDER);
		Control control_3 = outputDatasetViewer.getControl();
		control_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		
		Label fulfillConditionLabel = new Label(multiComposite, SWT.NONE);
		fulfillConditionLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		fulfillConditionLabel.setAlignment(SWT.RIGHT);
		fulfillConditionLabel.setText("完成条件");
		fulfillConditionViewer=new FoxBPMExpViewer(multiComposite, SWT.BORDER);
		Control control_4 = fulfillConditionViewer.getControl();
		control_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		
		nullRadio.addSelectionListener(new SelectionAdapter() {

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				multiComposite.setVisible(false);
			}
			
		});
		multiInstanceRadio.addSelectionListener(new SelectionAdapter() {

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				multiComposite.setVisible(true);
			}
			
		});
		
		return parent;
	}

	@Override
	public void createUIBindings(EObject eObject) {
		userTask=(UserTask)eObject;
	}
}
