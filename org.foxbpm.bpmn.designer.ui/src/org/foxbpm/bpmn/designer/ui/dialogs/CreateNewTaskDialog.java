package org.foxbpm.bpmn.designer.ui.dialogs;

import java.util.List;

import org.eclipse.bpmn2.FormalExpression;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.foxbpm.bpmn.designer.base.utils.FoxBPMDesignerUtil;
import org.foxbpm.bpmn.designer.ui.expdialog.ExpressionChangedEvent;
import org.foxbpm.bpmn.designer.ui.expdialog.FoxBPMExpViewer;
import org.foxbpm.bpmn.designer.ui.expdialog.IExpressionChangedListener;
import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;
import org.foxbpm.model.bpmn.foxbpm.TaskCommand;
import org.foxbpm.model.config.foxbpmconfig.TaskCommandDefinition;

public class CreateNewTaskDialog extends TitleAreaDialog {

	private Text idtext;
	private Text nametext;
	private Combo typecombo;
	private TaskCommand taskCommand;
	private TreeViewer treeViewer;
	private FoxBPMExpViewer expressionComboViewer;
	private FoxBPMExpViewer expressionComboViewerparam;
	private String title = "";
	private Button isVerify;
	private Button isSaveData;
	private Button isSimulation;
	private EObject be;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 * @wbp.parser.constructor
	 */
	public CreateNewTaskDialog(EObject be, Shell parentShell) {
		super(parentShell);
		setHelpAvailable(false);
		setShellStyle(SWT.CLOSE | SWT.RESIZE | SWT.TITLE | SWT.PRIMARY_MODAL);
		title = "创建处理命令";
		this.be = be;
	}

	public CreateNewTaskDialog(EObject be, Shell parentShell, TreeViewer treeViewer) {
		super(parentShell);
		setHelpAvailable(false);
		this.treeViewer = treeViewer;
		setShellStyle(SWT.RESIZE | SWT.TITLE | SWT.PRIMARY_MODAL);
		title = "创建处理命令";
		this.be = be;
	}

	public CreateNewTaskDialog(EObject be, Shell parentShell, TaskCommand taskCommand, TreeViewer treeViewer) {
		super(parentShell);
		setHelpAvailable(false);
		this.taskCommand = taskCommand;
		this.treeViewer = treeViewer;
		setShellStyle(SWT.RESIZE | SWT.TITLE | SWT.PRIMARY_MODAL);
		title = "编辑处理命令";
		this.be = be;
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle(title);
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout gl_container = new GridLayout(1, false);
		gl_container.horizontalSpacing = 0;
		gl_container.verticalSpacing = 0;
		gl_container.marginWidth = 0;
		gl_container.marginHeight = 0;
		container.setLayout(gl_container);

		Composite composite = new Composite(container, SWT.NONE);
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_composite.widthHint = 160;
		composite.setLayoutData(gd_composite);
		GridLayout gl_composite = new GridLayout(2, false);
		gl_composite.horizontalSpacing = 15;
		gl_composite.marginBottom = 15;
		gl_composite.verticalSpacing = 10;
		gl_composite.marginRight = 25;
		gl_composite.marginHeight = 15;
		gl_composite.marginLeft = 25;
		composite.setLayout(gl_composite);

		Label idLabel = new Label(composite, SWT.NONE);
		GridData gd_idLabel = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_idLabel.widthHint = 28;
		idLabel.setLayoutData(gd_idLabel);
		idLabel.setText("编号");

		idtext = new Text(composite, SWT.BORDER);
		idtext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label nameLabel = new Label(composite, SWT.NONE);
		nameLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		nameLabel.setText("名称");

		nametext = new Text(composite, SWT.BORDER);
		nametext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label typeLabel = new Label(composite, SWT.NONE);
		typeLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		typeLabel.setText("类型");

		typecombo = new Combo(composite, SWT.READ_ONLY);
		typecombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		typecombo.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				nametext.setText(getType(typecombo.getData(typecombo.getSelectionIndex() + "").toString()));
//				getCheckBox();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});

		Label expLabel = new Label(composite, SWT.NONE);
		expLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		expLabel.setText("执行表达式");

		expressionComboViewer = new FoxBPMExpViewer(composite, SWT.BORDER, be);
		Control viewControl = expressionComboViewer.getControl();
		viewControl.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setText("参数表达式");

		expressionComboViewerparam = new FoxBPMExpViewer(composite, SWT.BORDER, be);
		Control viewControlParam = expressionComboViewerparam.getControl();
		viewControlParam.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		Label label = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		if (treeViewer != null) {
			String str = "HandleCommand_";
			int count = (treeViewer.getTree().getItemCount() + 1);
			for (int i = 0; i < ((List<TaskCommand>) treeViewer.getInput()).size(); i++) {
				if (((List<TaskCommand>) treeViewer.getInput()).get(i).getId().equals(str + count) && !idtext.getText().equals(str + count)) {
					count++;
				}
			}
			idtext.setText(str + count);
		}

		Composite composite_1 = new Composite(composite, SWT.NONE);
		GridLayout gl_composite_1 = new GridLayout(3, false);
		gl_composite_1.horizontalSpacing = 15;
		composite_1.setLayout(gl_composite_1);
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));

		isVerify = new Button(composite_1, SWT.CHECK);
		isVerify.setText("是否验证");

		isSaveData = new Button(composite_1, SWT.CHECK);
		isSaveData.setText("是否保存");

		isSimulation = new Button(composite_1, SWT.CHECK);
		isSimulation.setText("是否虚拟运行");

		//先隐藏
		composite_1.setVisible(false);
		
		// ControlDecorateUtil.addDecorate(typecombo,
		// "createNewTaskDialog_commandType");
		// ControlDecorateUtil.addDecorate(expressionComboViewer.getCombo(),
		// "createNewTaskDialog_taskCommand");
		// ControlDecorateUtil.addDecorate(isVerify,
		// "createNewTaskDialog_isVerification");
		// ControlDecorateUtil.addDecorate(isSaveData,
		// "createNewTaskDialog_isSaveData");
		// ControlDecorateUtil.addDecorate(isSimulation,
		// "createNewTaskDialog_isSimulationRun");

		initCombo();
//		getCheckBox();
		init();
		return container;
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		Button button = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		button.setText("确定");
		Button button_1 = createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
		button_1.setText("取消");
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(440, 400);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void okPressed() {

		if (nametext.getText().equals("")) {
			MessageDialog.openWarning(null, "警告", "名称不能为空");
			return;
		}
		TaskCommand taskCommand = FoxBPMFactory.eINSTANCE.createTaskCommand();
		taskCommand.setId(idtext.getText() == null ? "" : idtext.getText());
		taskCommand.setName(nametext.getText() == null ? "" : nametext.getText());
		taskCommand.setCommandType(typecombo.getData(typecombo.getSelectionIndex() + "") == null ? "" : typecombo.getData(typecombo.getSelectionIndex() + "").toString());

		/*
		 * Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
		 * expression
		 * .setValue((DataVarTo)comboViewer.getElementAt(comboViewer.getCombo
		 * ().getSelectionIndex()) == null ? "" :
		 * ((DataVarTo)comboViewer.getElementAt
		 * (comboViewer.getCombo().getSelectionIndex())).getValue());
		 * taskCommand.setExpression(expression);
		 */

		Expression expression = expressionComboViewer.getExpression();
		if (expression != null) {
			taskCommand.setExpression(expression);
		}

		Expression expressionParam = expressionComboViewerparam.getExpression();
		if (expressionParam != null) {
			taskCommand.setParameterExpression(expressionParam);
		}

		if (treeViewer != null && this.taskCommand != null) {
			for (TaskCommand taskCommand2 : ((List<TaskCommand>) treeViewer.getInput())) {
				if (taskCommand2.getId().equals(taskCommand.getId()) && !idtext.getText().equals(this.taskCommand.getId())) {
					MessageDialog.openWarning(null, "警告", "ID不能相同");
					return;
				}
			}
		} else {
			for (TaskCommand taskCommand2 : ((List<TaskCommand>) treeViewer.getInput())) {
				if (taskCommand2.getId().equals(taskCommand.getId())) {
					MessageDialog.openWarning(null, "警告", "ID不能相同");
					return;
				}
			}
		}

//		taskCommand.setIsVerification(isVerify.getSelection() ? "true" : "false");
//		taskCommand.setIsSaveData(isSaveData.getSelection() ? "true" : "false");
//		taskCommand.setIsSimulationRun(isSimulation.getSelection() ? "true" : "false");

		setTaskCommand(taskCommand);

		super.okPressed();
	}

	public TaskCommand getTaskCommand() {
		return taskCommand;
	}

	public void setTaskCommand(TaskCommand taskCommand) {
		this.taskCommand = taskCommand;
	}

	/**
	 * 初始化回填值
	 */
	public void init() {
		if (taskCommand != null) {

			idtext.setText(taskCommand.getId() == null ? "" : taskCommand.getId());
			nametext.setText(taskCommand.getName() == null ? "" : taskCommand.getName());
			typecombo.setText(taskCommand.getCommandType() == null ? "" : getType(taskCommand.getCommandType()));
			// comboViewer.getCombo().setText(taskCommand.getExpression() ==
			// null ? "" : taskCommand.getExpression().getValue());

			// 初始化
			if (taskCommand.getExpression() != null) {
				expressionComboViewer.setExpression(taskCommand.getExpression());
				expressionComboViewer.getTextControl().setText(taskCommand.getExpression().getName());
			}

			if (taskCommand.getParameterExpression() != null) {
				expressionComboViewerparam.setExpression(taskCommand.getParameterExpression());
				expressionComboViewerparam.getTextControl().setText(taskCommand.getParameterExpression().getName());
			}

//			if (taskCommand.getIsVerification() != null || taskCommand.getIsSaveData() != null || taskCommand.getIsSimulationRun() != null) {
//				isVerify.setSelection(taskCommand.getIsVerification().equals("true") ? true : false);
//				isSaveData.setSelection(taskCommand.getIsSaveData().equals("true") ? true : false);
//				isSimulation.setSelection(taskCommand.getIsSimulationRun().equals("true") ? true : false);
//			} else {
//				isVerify.setSelection(true);
//				isSaveData.setSelection(true);
//				isSimulation.setSelection(false);
//			}
		}

		expressionComboViewer.addExpressionChangedListeners(new IExpressionChangedListener() {
			
			@Override
			public void expressionChanged(ExpressionChangedEvent event) {
				Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
				FormalExpression formalExpression = event.getFormalExpression();
				expression.setName(formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
				expression.setValue(formalExpression.getBody());
				expressionComboViewer.setExpression(expression);
			}
		});
		
		expressionComboViewerparam.addExpressionChangedListeners(new IExpressionChangedListener() {
			
			@Override
			public void expressionChanged(ExpressionChangedEvent event) {
				Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
				FormalExpression formalExpression = event.getFormalExpression();
				expression.setName(formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
				expression.setValue(formalExpression.getBody());
				expressionComboViewerparam.setExpression(expression);
			}
		});
	}

	/**
	 * 返回中文名称
	 * 
	 * @param type
	 * @return
	 */
	public String getType(String type) {
		String cntype = "";
		if (type.equals("general")) {
			cntype = "通用";
			return cntype;
		}
		/*
		 * if(type.equals("rollBack")){ cntype = "退回"; return cntype; }
		 * if(type.equals("transfer")){ cntype = "转发"; return cntype; }
		 * if(type.equals("submit")){ cntype = "提交"; return cntype; }
		 */
		else {
			List<TaskCommandDefinition> nameList = FoxBPMDesignerUtil.getTaskCommandNames(FoxBPMDesignerUtil.getFoxBPMConfig());
			for (int i = 0; i < nameList.size(); i++) {
				if (type.equals(nameList.get(i).getId())) {
					cntype = nameList.get(i).getName();
					break;
				}
			}
		}

		return cntype;
	}

	/**
	 * 勾默认值
	 */
//	private void getCheckBox() {
//		List<TaskCommandDefinition> nameList = FoxBPMDesignerUtil.getTaskCommandNames(FoxBPMDesignerUtil.getFoxBPMConfig());
//		for (TaskCommandDefinition taskCommand : nameList) {
//			if (typecombo.getData(typecombo.getSelectionIndex() + "").equals(taskCommand.getId()) && taskCommand.getIsVerification() != null && taskCommand.getIsSaveData() != null
//					&& taskCommand.getIsSimulationRun() != null) {
//				isVerify.setSelection(taskCommand.getIsVerification().equals("true") ? true : false);
//				isSaveData.setSelection(taskCommand.isSaveData().equals("true") ? true : false);
//				isSimulation.setSelection(taskCommand.getIsSimulationRun().equals("true") ? true : false);
//				break;
//			} else {
//				isVerify.setSelection(true);
//				isSaveData.setSelection(true);
//				isSimulation.setSelection(false);
//			}
//		}
//	}

	/**
	 * 初始化Combo，加入items
	 */
	private void initCombo() {
		// 添加扩展
		List<TaskCommandDefinition> nameList = FoxBPMDesignerUtil.getTaskCommandNames(FoxBPMDesignerUtil.getFoxBPMConfig());

		int i = 0;
		for (TaskCommandDefinition taskCommand : nameList) {
			typecombo.add(taskCommand.getName());
			typecombo.setData(i + "", taskCommand.getId());
			i = i + 1;

		}

		typecombo.select(0);

		// 默认名称为选中的类型
		nametext.setText(typecombo.getData(typecombo.getSelectionIndex() + "") == null ? "" : getType(typecombo.getData(typecombo.getSelectionIndex() + "").toString()));
	}
}
