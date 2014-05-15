package org.foxbpm.bpmn.designer.ui.connector.runtime.create;

import org.eclipse.bpmn2.Process;
import org.eclipse.bpmn2.UserTask;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.foxbpm.bpmn.designer.ui.connector.runtime.LifeCycleWidget;
import org.foxbpm.bpmn.designer.ui.expdialog.FoxBPMExpViewer;

public class RenameConnectorWizardPage extends WizardPage {

	private Label namelabel;

	private Button checkButton;

	private Text connectNameText;

	private Text connectDescriptionText;

	// private Combo connectEventCombo;

	private Combo connectExceptionCombo;

	private FoxBPMExpViewer timeBpmExpViewer;

	private FoxBPMExpViewer skipBpmExpViewer;

	private FoxBPMExpViewer foxBPMExpViewer;

	private Text text;

	private Text timeText;

	private Text skipText;

	private Text connectNameErrorText;

	private LifeCycleWidget lifeCycle;

	private EObject be;

	private Label label_1;
	private Label label_2;
	private Label label_3;
	private Label label_4;

	/**
	 * @param pageName
	 * @wbp.parser.constructor
	 */
	public RenameConnectorWizardPage(String pageName) {
		super(pageName);
	}

	/**
	 * @param pageName
	 * @param title
	 * @param titleImage
	 */
	public RenameConnectorWizardPage(EObject be, String pageName, String title, ImageDescriptor titleImage) {
		super(pageName, title, titleImage);
		// title信息
		setTitle(title);

		// 消息信息
		setMessage("指定连接器的参数", INFORMATION);

		// 设置图片
		setImageDescriptor(titleImage);

		this.be = be;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets
	 * .Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		// 创建一个底层的Composite，并使用GridLayout布局
		Composite newComposite = new Composite(parent, SWT.NULL);
		newComposite.setLayout(new FillLayout());

		// 创建布局
		GridLayout gridLayout = new GridLayout();
		gridLayout.verticalSpacing = 10;
		gridLayout.numColumns = 2; // grid分为2列

		// 创建一个组
		Group proGroup = new Group(newComposite, SWT.NONE);
		proGroup.setLayout(gridLayout);
		proGroup.setText("连接器详细设置");

		// 创建label
		Label label = new Label(proGroup, SWT.NONE);
		label.setText("名称");

		// 创建文本框
		connectNameText = new Text(proGroup, SWT.BORDER);
		connectNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL)); // 布局
		connectNameText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				if (connectNameText.getText().equals("")) {
					namelabel.setText("(       )");
				} else {
					namelabel.setText("( " + connectNameText.getText() + " )");
				}

				// 验证输入内容
				setPageComplete(isPageComplete());
			}
		});

		new Label(proGroup, SWT.NONE);

		namelabel = new Label(proGroup, SWT.NONE);
		namelabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL)); // 布局
		namelabel.setText("(       )");

		label_1 = new Label(proGroup, SWT.NONE);
		label_1.setText("描述");

		// 创建文本框
		connectDescriptionText = new Text(proGroup, SWT.BORDER | SWT.WRAP);
		connectDescriptionText.setLayoutData(new GridData(400, 60)); // 布局
		connectDescriptionText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {

			}
		});

		label_2 = new Label(proGroup, SWT.NONE);
		label_2.setText("选择事件");

		/*
		 * //创建文本框 connectEventCombo = new Combo(proGroup, SWT.BORDER |
		 * SWT.READ_ONLY); connectEventCombo.setLayoutData(new
		 * GridData(GridData.FILL_HORIZONTAL)); //布局
		 * connectEventCombo.setItems(new String[] {"enter", "cancel", "abort",
		 * "finish"}); connectEventCombo.addModifyListener(new ModifyListener()
		 * {
		 * 
		 * public void modifyText(ModifyEvent e) {
		 * 
		 * } });
		 */

		if (be instanceof Process) {
			lifeCycle = new LifeCycleWidget(proGroup, "process-start", LifeCycleWidget.PROCESS_LIFE_CYCLE, null);
		} else if (be instanceof UserTask) {
			lifeCycle = new LifeCycleWidget(proGroup, "node-enter", LifeCycleWidget.USERTASK_LIFE_CYCLE, null);
		} else {
			lifeCycle = new LifeCycleWidget(proGroup, "node-enter", LifeCycleWidget.OTHER_LIFE_CYCLE, null);
		}

		GridData gd1 = new GridData(lifeCycle.getWidth(), lifeCycle.getHeight());
		gd1.horizontalIndent = 0;
		lifeCycle.setLayoutData(gd1);

		lifeCycle.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				// setEvent(lifeCycle.getEvent());
			}
		});

		label = new Label(proGroup, SWT.NONE);
		label.setText("跳过策略");

		foxBPMExpViewer = new FoxBPMExpViewer(proGroup, SWT.BORDER, be);
		Control control = foxBPMExpViewer.getControl();
		control.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		text = foxBPMExpViewer.getTextControl();
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(proGroup, SWT.NONE);

		Group group = new Group(proGroup, SWT.NONE);
		group.setText("定时器配置");
		group.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		GridLayout gl_group = new GridLayout(2, false);
		gl_group.verticalSpacing = 5;
		gl_group.horizontalSpacing = 0;
		gl_group.marginWidth = 0;
		gl_group.marginHeight = 0;
		group.setLayout(gl_group);

		checkButton = new Button(group, SWT.CHECK);
		checkButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		checkButton.setToolTipText("终止、结束事件中定时器无效");
		checkButton.setText("启用定时器");

		label = new Label(group, SWT.NONE);
		label.setText("时间表达式");

		timeBpmExpViewer = new FoxBPMExpViewer(group, SWT.BORDER, be);
		Control control_1 = timeBpmExpViewer.getControl();
		control_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		timeText = timeBpmExpViewer.getTextControl();
		timeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		timeBpmExpViewer.setEnabled(false);

		label = new Label(group, SWT.NONE);
		label.setText("定时器跳过策略");

		skipBpmExpViewer = new FoxBPMExpViewer(group, SWT.BORDER, be);
		Control control_2 = skipBpmExpViewer.getControl();
		control_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		skipText = skipBpmExpViewer.getTextControl();
		skipText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		skipBpmExpViewer.setEnabled(false);

		checkButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				if (checkButton.getSelection()) {
					timeBpmExpViewer.setEnabled(true);
					skipBpmExpViewer.setEnabled(true);
					// timeBpmExpViewer.setExpressionInput(null);
					timeBpmExpViewer.getTextControl().setText("");
					skipBpmExpViewer.getTextControl().setText("");
				} else {
					timeBpmExpViewer.setEnabled(false);
					skipBpmExpViewer.setEnabled(false);
					// timeBpmExpViewer.setExpressionInput(null);
					timeBpmExpViewer.getTextControl().setText("");
					skipBpmExpViewer.getTextControl().setText("");
				}
			}
		});

		label_3 = new Label(proGroup, SWT.NONE);
		label_3.setText("如果连接器失效");

		// 创建文本框
		connectExceptionCombo = new Combo(proGroup, SWT.BORDER | SWT.READ_ONLY);
		connectExceptionCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL)); // 布局
		connectExceptionCombo.setItems(new String[] { "抛出异常", "忽略错误并继续该流程", "抛出错误事件" });
		connectExceptionCombo.select(0);
		connectExceptionCombo.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				if (connectExceptionCombo.getSelectionIndex() == 2) {
					connectNameErrorText.setEnabled(true);
				} else {
					connectNameErrorText.setText("");
					connectNameErrorText.setEnabled(false);
				}
				setPageComplete(isPageComplete());
			}
		});

		label_4 = new Label(proGroup, SWT.NONE);
		label_4.setText("命名错误");

		// 创建文本框
		connectNameErrorText = new Text(proGroup, SWT.BORDER);
		connectNameErrorText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL)); // 布局
		connectNameErrorText.setEnabled(false);
		connectNameErrorText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {

				// org.eclipse.bpmn2.Error
				// error=Bpmn2Factory.eINSTANCE.createError();
				// error.setErrorCode(connectNameErrorText.getText());
				// error.setId(value)
				// SectionBpmnElement.definitions.getRootElements().add(error);

				setPageComplete(isPageComplete());

			}
		});

		// text.addModifyListener(null);
		// timeText.addModifyListener(null);
		// skipText.addModifyListener(null);

		// 初始化的时候先使‘完成’按钮不可用
		setPageComplete(false);

		// 必须要的，将新的Composite放入
		setControl(newComposite);
	}

	/**
	 * 验证输入内容
	 */
	/*
	 * private void dataChange() {
	 * if(connectNameText.getText().trim().equals("")) {
	 * setErrorMessage("名称输入不能空"); //提示错误信息 setPageComplete(false);
	 * //使‘完成’和‘下一步’两个按钮不可用 } if(connectExceptionCombo.getSelectionIndex() == 2
	 * && connectNameErrorText.getText().equals("")) {
	 * setErrorMessage("'命名错误'不能空"); //提示错误信息 setPageComplete(false);
	 * //使‘完成’和‘下一步’两个按钮不可用 }
	 * 
	 * setErrorMessage(null); //清空错误信息 setPageComplete(true);
	 * //使‘完成’和‘下一步’两个按钮可用 }
	 */

	/**
	 * 重写验证
	 */
	@Override
	public boolean isPageComplete() {
		StringBuffer sb = new StringBuffer();

		if (null == connectNameText.getText() || connectNameText.getText().trim().equals("")) {
			sb.append("名称为空");
		}
		if (connectExceptionCombo.getSelectionIndex() == 2 && (null == connectNameErrorText.getText() || connectNameErrorText.getText().equals(""))) {
			if (sb.length() > 0)
				sb.append(",");
			sb.append("命名错误为空");
		}

		if (sb.length() > 0) {
			RenameConnectorWizardPage.this.setErrorMessage(sb.toString());
			return false;
		} else {
			RenameConnectorWizardPage.this.setErrorMessage(null);
			return true;
		}
	}

	@Override
	public IWizardPage getPreviousPage() {
		return null;
	}

	public Text getConnectNameText() {
		return connectNameText;
	}

	public void setConnectNameText(Text connectNameText) {
		this.connectNameText = connectNameText;
	}

	public Text getConnectDescriptionText() {
		return connectDescriptionText;
	}

	public void setConnectDescriptionText(Text connectDescriptionText) {
		this.connectDescriptionText = connectDescriptionText;
	}

	/*
	 * public Combo getConnectEventCombo() { return connectEventCombo; }
	 * 
	 * public void setConnectEventCombo(Combo connectEventCombo) {
	 * this.connectEventCombo = connectEventCombo; }
	 */

	public Combo getConnectExceptionCombo() {
		return connectExceptionCombo;
	}

	public void setConnectExceptionCombo(Combo connectExceptionCombo) {
		this.connectExceptionCombo = connectExceptionCombo;
	}

	public Text getConnectNameErrorText() {
		return connectNameErrorText;
	}

	public void setConnectNameErrorText(Text connectNameErrorText) {
		this.connectNameErrorText = connectNameErrorText;
	}

	public LifeCycleWidget getLifeCycle() {
		return lifeCycle;
	}

	public void setLifeCycle(LifeCycleWidget lifeCycle) {
		this.lifeCycle = lifeCycle;
	}

	public FoxBPMExpViewer getFoxBPMExpViewer() {
		return foxBPMExpViewer;
	}

	public void setFoxBPMExpViewer(FoxBPMExpViewer foxBPMExpViewer) {
		this.foxBPMExpViewer = foxBPMExpViewer;
	}

	public Button getCheckButton() {
		return checkButton;
	}

	public void setCheckButton(Button checkButton) {
		this.checkButton = checkButton;
	}

	public FoxBPMExpViewer getTimeFoxBPMExpViewer() {
		return timeBpmExpViewer;
	}

	public void setTimeFoxBPMExpViewer(FoxBPMExpViewer timeBpmExpViewer) {
		this.timeBpmExpViewer = timeBpmExpViewer;
	}

	public FoxBPMExpViewer getSkipFoxBPMExpViewer() {
		return skipBpmExpViewer;
	}

	public void setSkipFoxBPMExpViewer(FoxBPMExpViewer skipBpmExpViewer) {
		this.skipBpmExpViewer = skipBpmExpViewer;
	}
}
