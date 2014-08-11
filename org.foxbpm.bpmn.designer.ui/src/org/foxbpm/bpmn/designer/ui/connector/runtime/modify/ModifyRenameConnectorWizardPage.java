package org.foxbpm.bpmn.designer.ui.connector.runtime.modify;

import org.eclipse.bpmn2.FormalExpression;
import org.eclipse.bpmn2.UserTask;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
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
import org.foxbpm.bpmn.designer.ui.expdialog.ExpressionChangedEvent;
import org.foxbpm.bpmn.designer.ui.expdialog.FoxBPMExpViewer;
import org.foxbpm.bpmn.designer.ui.expdialog.IExpressionChangedListener;
import org.foxbpm.model.bpmn.foxbpm.ConnectorInstance;
import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;
import org.foxbpm.model.bpmn.foxbpm.SkipComment;

public class ModifyRenameConnectorWizardPage extends WizardPage {

	private Label namelabel;
	
	private Button checkButton;

	private FoxBPMExpViewer skipBpmExpViewer;
	
	private Text skipText;

	private Text connectNameText;

	private Text connectDescriptionText;

	// private Combo connectEventCombo;

	private Combo connectExceptionText;

	private FoxBPMExpViewer timeBpmExpViewer;
	
	
	private FoxBPMExpViewer foxBPMExpViewer;

	private Text text;
	
	private Text timeText;

	private Text connectNameErrorText;

	private ConnectorInstance connectorInstance;

	private LifeCycleWidget lifeCycle;
	private EObject be;

	/**
	 * @param pageName
	 * @wbp.parser.constructor
	 */
	public ModifyRenameConnectorWizardPage(String pageName) {
		super(pageName);
	}

	/**
	 * @param pageName
	 * @param title
	 * @param titleImage
	 */
	public ModifyRenameConnectorWizardPage(EObject be, String pageName, String title, ImageDescriptor titleImage, ConnectorInstance connectorInstance) {
		super(pageName, title, titleImage);
		this.connectorInstance = connectorInstance;
		this.be = be;

		// title信息
		setTitle(title);

		// 消息信息
		setMessage("指定连接器的参数", INFORMATION);

		// 设置图片
		setImageDescriptor(titleImage);
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
		connectNameText.setText(connectorInstance.getConnectorInstanceName());
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
		namelabel.setText("(    " + connectorInstance.getConnectorInstanceName() + "    )");

		label = new Label(proGroup, SWT.NONE);
		label.setText("描述");

		// 创建文本框
		connectDescriptionText = new Text(proGroup, SWT.BORDER | SWT.WRAP);
		connectDescriptionText.setLayoutData(new GridData(400, 60)); // 布局
		connectDescriptionText.setText(connectorInstance.getDocumentation().getValue() == null ? "" : connectorInstance.getDocumentation().getValue());
		connectDescriptionText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {

			}
		});

		label = new Label(proGroup, SWT.NONE);
		label.setText("选择事件");

		/*
		 * //创建文本框 connectEventCombo = new Combo(proGroup, SWT.BORDER |
		 * SWT.READ_ONLY); connectEventCombo.setLayoutData(new
		 * GridData(GridData.FILL_HORIZONTAL)); //布局
		 * connectEventCombo.setItems(new String[] {"enter", "cancel", "abort",
		 * "finish"});
		 * connectEventCombo.setText(connectorInstance.getEventType() == null ?
		 * "" : connectorInstance.getEventType());
		 * connectEventCombo.addModifyListener(new ModifyListener() {
		 * 
		 * public void modifyText(ModifyEvent e) {
		 * 
		 * } });
		 */

		if (be instanceof org.eclipse.bpmn2.Process) {
			lifeCycle = new LifeCycleWidget(proGroup, connectorInstance.getEventType(), LifeCycleWidget.PROCESS_LIFE_CYCLE, null);
		} else if (be instanceof UserTask) {
			lifeCycle = new LifeCycleWidget(proGroup, connectorInstance.getEventType(), LifeCycleWidget.USERTASK_LIFE_CYCLE, null);
		} else {
			lifeCycle = new LifeCycleWidget(proGroup, connectorInstance.getEventType(), LifeCycleWidget.OTHER_LIFE_CYCLE, null);
		}

		GridData gd1 = new GridData(lifeCycle.getWidth(), lifeCycle.getHeight());
		gd1.horizontalIndent = 0;
		lifeCycle.setLayoutData(gd1);

		lifeCycle.addSelectionListener(new SelectionAdapter() {

			/*
			 * public void widgetSelected(SelectionEvent e) {
			 * lifeCycle.setEvent(connectorInstance.getEventType() == null ? ""
			 * : connectorInstance.getEventType()); }
			 */
		});	
		
		
		label = new Label(proGroup, SWT.NONE);
		label.setText("跳过策略");

		foxBPMExpViewer = new FoxBPMExpViewer(proGroup, SWT.BORDER, be);
		Control control = foxBPMExpViewer.getControl();
		control.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		text = foxBPMExpViewer.getTextControl();
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		SkipComment skipComment = connectorInstance.getSkipComment();
		if(skipComment!=null){
			Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
			expression.setName(skipComment == null ? "" : skipComment.getExpression().getName());
			expression.setValue(skipComment == null ? "" : skipComment.getExpression().getValue());
			foxBPMExpViewer.setExpression(expression);
			foxBPMExpViewer.getTextControl().setText(expression.getName());
		}
		
		foxBPMExpViewer.addExpressionChangedListeners(new IExpressionChangedListener() {
			
			@Override
			public void expressionChanged(ExpressionChangedEvent event) {
				Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
				FormalExpression formalExpression = event.getFormalExpression();
				expression.setName(formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
				expression.setValue(formalExpression.getBody());
				foxBPMExpViewer.setExpression(expression);
			}
		});
		
		new Label(proGroup, SWT.NONE);
		

		Group group = new Group(proGroup, SWT.NONE);
		group.setText("定时器配置");
		group.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		GridLayout gl_group = new GridLayout(2, false);
		gl_group.verticalSpacing = 5;
		gl_group.horizontalSpacing = 0;
		gl_group.marginWidth = 0;
		gl_group.marginHeight = 0;
		group.setLayout(gl_group);
		
		checkButton = new Button(group, SWT.CHECK);
		checkButton.setToolTipText("终止、结束事件中定时器无效");
		checkButton.setText("启用定时器");
		
		new Label(group, SWT.NONE);
		
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
		
		if(connectorInstance.isIsTimeExecute()){
			checkButton.setSelection(true);
			Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
			expression.setName(connectorInstance.getTimeExpression() == null || connectorInstance.getTimeExpression().getExpression()==null ? "" : connectorInstance.getTimeExpression().getExpression().getName());
			expression.setValue(connectorInstance.getTimeExpression() == null || connectorInstance.getTimeExpression().getExpression()==null ? "" : connectorInstance.getTimeExpression().getExpression().getValue());
			timeBpmExpViewer.setExpression(expression);
			timeBpmExpViewer.getTextControl().setText(expression.getName());
			timeBpmExpViewer.setEnabled(true);
			skipBpmExpViewer.setEnabled(true);
			
			Expression expressionToSkip = FoxBPMFactory.eINSTANCE.createExpression();
			expressionToSkip.setName(connectorInstance.getTimeSkipExpression() == null || connectorInstance.getTimeSkipExpression().getExpression()==null ? "" : connectorInstance.getTimeSkipExpression().getExpression().getName());
			expressionToSkip.setValue(connectorInstance.getTimeSkipExpression() == null || connectorInstance.getTimeSkipExpression().getExpression()==null ? "" : connectorInstance.getTimeSkipExpression().getExpression().getValue());
			skipBpmExpViewer.setExpression(expressionToSkip);
			skipBpmExpViewer.getTextControl().setText(expressionToSkip.getName());
		}
		
		timeBpmExpViewer.addExpressionChangedListeners(new IExpressionChangedListener() {
			
			@Override
			public void expressionChanged(ExpressionChangedEvent event) {
				Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
				FormalExpression formalExpression = event.getFormalExpression();
				expression.setName(formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
				expression.setValue(formalExpression.getBody());
				timeBpmExpViewer.setExpression(expression);
			}
		});
		
		skipBpmExpViewer.addExpressionChangedListeners(new IExpressionChangedListener() {
			
			@Override
			public void expressionChanged(ExpressionChangedEvent event) {
				Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
				FormalExpression formalExpression = event.getFormalExpression();
				expression.setName(formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
				expression.setValue(formalExpression.getBody());
				skipBpmExpViewer.setExpression(expression);
			}
		});
		
		checkButton.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				if(checkButton.getSelection()) {
					timeBpmExpViewer.setEnabled(true);
					skipBpmExpViewer.setEnabled(true);
					//timeBpmExpViewer.setExpressionInput(null);
					timeBpmExpViewer.setExpression(null);
					skipBpmExpViewer.setExpression(null);
				}else{
					timeBpmExpViewer.setEnabled(false);
					skipBpmExpViewer.setEnabled(false);
					//timeBpmExpViewer.setExpressionInput(null);
					timeBpmExpViewer.setExpression(null);
					skipBpmExpViewer.setExpression(null);
				}
			}
		});
		
		
//		skipText.addModifyListener();
//		timeText.addModifyListener();
		
		label = new Label(proGroup, SWT.NONE);
		label.setText("如果连接器失效");

		// 创建文本框
		connectExceptionText = new Combo(proGroup, SWT.BORDER | SWT.READ_ONLY);
		connectExceptionText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL)); // 布局
		connectExceptionText.setItems(new String[] { "抛出异常", "忽略错误并继续该流程", "抛出错误事件" });
		connectExceptionText.setText(connectorInstance.getErrorHandling() == null ? "" : connectorInstance.getErrorHandling());
		connectExceptionText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				if (connectExceptionText.getSelectionIndex() == 2) {
					connectNameErrorText.setEnabled(true);
				} else {
					connectNameErrorText.setText("");
					connectNameErrorText.setEnabled(false);
				}
				setPageComplete(isPageComplete());
			}
		});

		label = new Label(proGroup, SWT.NONE);
		label.setText("命名错误");

		// 创建文本框
		connectNameErrorText = new Text(proGroup, SWT.BORDER);
		connectNameErrorText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL)); // 布局
		if (connectExceptionText.getSelectionIndex() == 2) {
			connectNameErrorText.setEnabled(true);
		} else {
			connectNameErrorText.setEnabled(false);
		}
		connectNameErrorText.setText(connectorInstance.getErrorCode() == null ? "" : connectorInstance.getErrorCode());
		new Label(proGroup, SWT.NONE);
		connectNameErrorText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				setPageComplete(isPageComplete());
			}
		});

		// 初始化的时候先使‘完成’按钮不可用
		// setPageComplete(false);

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
	 * //使‘完成’和‘下一步’两个按钮不可用 return; }
	 * if(connectExceptionText.getSelectionIndex() == 2 &&
	 * connectNameErrorText.getText().equals("")) {
	 * setErrorMessage("'命名错误'不能空"); //提示错误信息 setPageComplete(false);
	 * //使‘完成’和‘下一步’两个按钮不可用 return; }
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
		if (connectExceptionText.getSelectionIndex() == 2 && (null == connectNameErrorText.getText() || connectNameErrorText.getText().equals(""))) {
			if (sb.length() > 0)
				sb.append(",");
			sb.append("命名错误为空");
		}

		if (sb.length() > 0) {
			ModifyRenameConnectorWizardPage.this.setErrorMessage(sb.toString());
			return false;
		} else {
			ModifyRenameConnectorWizardPage.this.setErrorMessage(null);
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
		return connectExceptionText;
	}

	public void setConnectExceptionCombo(Combo connectExceptionText) {
		this.connectExceptionText = connectExceptionText;
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

	public Button getCheckButton() {
		return checkButton;
	}

	public void setCheckButton(Button checkButton) {
		this.checkButton = checkButton;
	}
	
	public FoxBPMExpViewer getTimeBpmExpViewer() {
		return timeBpmExpViewer;
	}

	public FoxBPMExpViewer getSkipBpmExpViewer() {
		return skipBpmExpViewer;
	}
}
