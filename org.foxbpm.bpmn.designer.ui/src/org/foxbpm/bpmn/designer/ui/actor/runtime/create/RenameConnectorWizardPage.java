package org.foxbpm.bpmn.designer.ui.actor.runtime.create;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class RenameConnectorWizardPage extends WizardPage {

	private Label namelabel;
	
	private Button checkButton;

	private Text connectNameText;

	private Text connectDescriptionText;

	private Text connectNameErrorText;

	private EObject be;
	
	private Label label_1;

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
		setMessage("指定选择器的参数", INFORMATION);

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
		proGroup.setText("选择器详细设置");

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
		label_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1));
		label_1.setText("描述");

		// 创建文本框
		connectDescriptionText = new Text(proGroup, SWT.BORDER | SWT.WRAP);
		GridData gd_connectDescriptionText = new GridData(400, 60);
		gd_connectDescriptionText.verticalAlignment = SWT.FILL;
		gd_connectDescriptionText.grabExcessVerticalSpace = true;
		gd_connectDescriptionText.horizontalAlignment = SWT.FILL;
		connectDescriptionText.setLayoutData(gd_connectDescriptionText); // 布局
		connectDescriptionText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {

			}
		});

//		label = new Label(proGroup, SWT.NONE);
//		label.setText("选择事件");

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

//		if (be instanceof Process) {
//			lifeCycle = new LifeCycleWidget(proGroup, "process-start", LifeCycleWidget.PROCESS_LIFE_CYCLE, null);
//		} else if (be instanceof UserTask) {
//			lifeCycle = new LifeCycleWidget(proGroup, "node-enter", LifeCycleWidget.USERTASK_LIFE_CYCLE, null);
//		} else {
//			lifeCycle = new LifeCycleWidget(proGroup, "node-enter", LifeCycleWidget.OTHER_LIFE_CYCLE, null);
//		}
//
//		GridData gd1 = new GridData(lifeCycle.getWidth(), lifeCycle.getHeight());
//		gd1.horizontalIndent = 0;
//		lifeCycle.setLayoutData(gd1);
//
//		lifeCycle.addSelectionListener(new SelectionAdapter() {
//
//			public void widgetSelected(SelectionEvent e) {
//				// setEvent(lifeCycle.getEvent());
//			}
//		});
//		
//		label = new Label(proGroup, SWT.NONE);
//		label.setText("跳过策略");

//		expressionComboViewer = new ExpressionComboViewer(be, proGroup);
//		combo = expressionComboViewer.getExpressionCombo();
//		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
//		Group group = new Group(proGroup, SWT.NONE);
//		group.setText("定时器配置");
//		group.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
//		GridLayout gl_group = new GridLayout(2, false);
//		gl_group.verticalSpacing = 5;
//		gl_group.horizontalSpacing = 0;
//		gl_group.marginWidth = 0;
//		gl_group.marginHeight = 0;
//		group.setLayout(gl_group);
//		
//		checkButton = new Button(group, SWT.CHECK);
//		checkButton.setToolTipText("终止、结束事件中定时器无效");
//		checkButton.setText("启用定时器");
		
//		new Label(group, SWT.NONE);
		
//		label = new Label(group, SWT.NONE);
//		label.setText("时间表达式");

//		timeExpressionComboViewer = new ExpressionComboViewer(be, group);
//		timecombo = timeExpressionComboViewer.getExpressionCombo();
//		timecombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
//		timecombo.setEnabled(false);
		
//		label = new Label(group, SWT.NONE);
//		label.setText("定时器跳过策略");
		
//		skipExpressionComboViewer = new ExpressionComboViewer(be, group);
//		skipcombo = skipExpressionComboViewer.getExpressionCombo();
//		skipcombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
//		skipcombo.setEnabled(false);
		
//		checkButton.addListener(SWT.Selection, new Listener() {
//			
//			@Override
//			public void handleEvent(Event event) {
//				if(checkButton.getSelection()) {
//					timecombo.setEnabled(true);
//					skipcombo.setEnabled(true);
//					//timeExpressionComboViewer.setExpressionInput(null);
//					timeExpressionComboViewer.getExpressionCombo().setExpressionTo(null);
//					skipExpressionComboViewer.getExpressionCombo().setExpressionTo(null);
//				}else{
//					timecombo.setEnabled(false);
//					skipcombo.setEnabled(false);
//					//timeExpressionComboViewer.setExpressionInput(null);
//					timeExpressionComboViewer.getExpressionCombo().setExpressionTo(null);
//					skipExpressionComboViewer.getExpressionCombo().setExpressionTo(null);
//				}
//			}
//		});
//
//		label = new Label(proGroup, SWT.NONE);
//		label.setText("如果连接器失效");
//
//		// 创建文本框
//		connectExceptionCombo = new Combo(proGroup, SWT.BORDER | SWT.READ_ONLY);
//		connectExceptionCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL)); // 布局
//		connectExceptionCombo.setItems(new String[] { "抛出异常", "忽略错误并继续该流程", "抛出错误事件" });
//		connectExceptionCombo.select(0);
//		connectExceptionCombo.addModifyListener(new ModifyListener() {
//
//			public void modifyText(ModifyEvent e) {
//				if (connectExceptionCombo.getSelectionIndex() == 2) {
//					connectNameErrorText.setEnabled(true);
//				} else {
//					connectNameErrorText.setText("");
//					connectNameErrorText.setEnabled(false);
//				}
//				setPageComplete(isPageComplete());
//			}
//		});
//
//		label = new Label(proGroup, SWT.NONE);
//		label.setText("命名错误");
//
//		// 创建文本框
//		connectNameErrorText = new Text(proGroup, SWT.BORDER);
//		connectNameErrorText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL)); // 布局
//		connectNameErrorText.setEnabled(false);
//		new Label(proGroup, SWT.NONE);
//		connectNameErrorText.addModifyListener(new ModifyListener() {
//
//			public void modifyText(ModifyEvent e) {
//
//				// org.eclipse.bpmn2.Error
//				// error=Bpmn2Factory.eINSTANCE.createError();
//				// error.setErrorCode(connectNameErrorText.getText());
//				// error.setId(value)
//				// SectionBpmnElement.definitions.getRootElements().add(error);
//
//				setPageComplete(isPageComplete());
//
//			}
//		});
//		
//		combo.addModifyListener();
//		timecombo.addModifyListener();
//		skipcombo.addModifyListener();

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
//		if (connectExceptionCombo.getSelectionIndex() == 2 && (null == connectNameErrorText.getText() || connectNameErrorText.getText().equals(""))) {
//			if (sb.length() > 0)
//				sb.append(",");
//			sb.append("命名错误为空");
//		}

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

	public Text getConnectNameErrorText() {
		return connectNameErrorText;
	}

	public void setConnectNameErrorText(Text connectNameErrorText) {
		this.connectNameErrorText = connectNameErrorText;
	}

	public Button getCheckButton() {
		return checkButton;
	}

	public void setCheckButton(Button checkButton) {
		this.checkButton = checkButton;
	}
	
}
