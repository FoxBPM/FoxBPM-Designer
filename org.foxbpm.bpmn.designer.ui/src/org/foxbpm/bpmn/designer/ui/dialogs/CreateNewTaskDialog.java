package org.foxbpm.bpmn.designer.ui.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpmn2.FormalExpression;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.foxbpm.bpmn.designer.ui.custom.CommandParamDialogCellEditor;
import org.foxbpm.bpmn.designer.ui.custom.CommandParamTo;
import org.foxbpm.bpmn.designer.ui.expdialog.ExpressionChangedEvent;
import org.foxbpm.bpmn.designer.ui.expdialog.FoxBPMExpViewer;
import org.foxbpm.bpmn.designer.ui.expdialog.IExpressionChangedListener;
import org.foxbpm.bpmn.designer.ui.utils.TaskCommandUtil;
import org.foxbpm.model.bpmn.foxbpm.CommandParam;
import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;
import org.foxbpm.model.bpmn.foxbpm.Param;
import org.foxbpm.model.bpmn.foxbpm.TaskCommand;
import org.foxbpm.model.config.foxbpmconfig.TaskCommandDefinition;

public class CreateNewTaskDialog extends TitleAreaDialog {
	private Text idtext;
	private Text nametext;
	private Combo typecombo;
	private TaskCommand taskCommand;
	private TreeViewer treeViewer;
	private FoxBPMExpViewer expressionComboViewer;
	private String title = "";
	private EObject be;
	private Table table;
	private Table table_1;
	private Table table_2;
	private TableViewer uicollectTableViewer;
	private TableViewer uicontrolTableViewer;
	private TableViewer engineexeTableViewer;
	private TransactionalEditingDomain editingDomain;
	private Composite composite;
	private Group group_2;
	private Composite advanceparamcomposite;
	private Section section;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 * @wbp.parser.constructor
	 */
	public CreateNewTaskDialog(Shell parentShell) {
		super(parentShell);
		setShellStyle(SWT.BORDER | SWT.CLOSE | SWT.RESIZE | SWT.PRIMARY_MODAL);
		setHelpAvailable(false);
	}
			
	public CreateNewTaskDialog(EObject be, Shell parentShell, TreeViewer treeViewer, TransactionalEditingDomain editingDomain) {
		super(parentShell);
		setHelpAvailable(false);
		this.treeViewer = treeViewer;
		setShellStyle(SWT.RESIZE | SWT.TITLE | SWT.PRIMARY_MODAL);
		title = "创建处理命令";
		this.be = be;
		this.editingDomain = editingDomain;
	}

	public CreateNewTaskDialog(EObject be, Shell parentShell, TaskCommand taskCommand, TreeViewer treeViewer, TransactionalEditingDomain editingDomain) {
		super(parentShell);
		setHelpAvailable(false);
		this.taskCommand = taskCommand;
		this.treeViewer = treeViewer;
		setShellStyle(SWT.RESIZE | SWT.TITLE | SWT.PRIMARY_MODAL);
		title = "编辑处理命令";
		this.be = be;
		this.editingDomain = editingDomain;
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

		composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		GridLayout gl_composite = new GridLayout(2, false);
		gl_composite.marginRight = 10;
		gl_composite.marginTop = 10;
		gl_composite.marginLeft = 10;
		composite.setLayout(gl_composite);

		Label idLabel = new Label(composite, SWT.NONE);
		idLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		idLabel.setText("编号");

		idtext = new Text(composite, SWT.BORDER);
		GridData gd_idtext = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_idtext.widthHint = 407;
		idtext.setLayoutData(gd_idtext);

		Label nameLabel = new Label(composite, SWT.NONE);
		nameLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		nameLabel.setText("名称");

		nametext = new Text(composite, SWT.BORDER);
		GridData gd_nametext = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_nametext.widthHint = 366;
		nametext.setLayoutData(gd_nametext);

		Label typeLabel = new Label(composite, SWT.NONE);
		typeLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		typeLabel.setText("类型");

		typecombo = new Combo(composite, SWT.READ_ONLY);
		GridData gd_typecombo = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_typecombo.widthHint = 358;
		typecombo.setLayoutData(gd_typecombo);
		typecombo.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {//TODO
				nametext.setText(typecombo.getData(typecombo.getSelectionIndex() + "") == null ? "" : getType(((TaskCommandDefinition)typecombo.getData(typecombo.getSelectionIndex() + "")).getId()));
				//清空各个tableviewer并重新设值
				
//				if(TaskCommandUtil.getTaskCommandParamByType((TaskCommandDefinition) typecombo.getData(typecombo.getSelectionIndex()+""), "ExecuteParam").size()==0) {
//					getShell().setSize(655, 646);
//					
//					GridData data = (GridData) group_2.getLayoutData();
//		            data.exclude = TaskCommandUtil.getTaskCommandParamByType((TaskCommandDefinition) typecombo.getData(typecombo.getSelectionIndex()+""), "ExecuteParam").size()==0;
//		            data.heightHint = 100;
//		            group_2.setVisible(!data.exclude);
//		                
//		            GridData data2 = (GridData) advanceparamcomposite.getLayoutData();
//		            data2.exclude = true;
//				}else {
//					getShell().setSize(655, 450);
//					
//		            group_2.setVisible(true);
//		            GridData data2 = (GridData) advanceparamcomposite.getLayoutData();
//		            data2.exclude = true;
//				}
				
				initTableViewers("select");
				getShell().layout();
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
		GridData gd_viewControl = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_viewControl.widthHint = 423;
		viewControl.setLayoutData(gd_viewControl);

		Label label = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

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
		
		initCombo();
		
		group_2 = new Group(composite, SWT.NONE);
		group_2.setText("引擎执行参数");
		group_2.setLayout(new GridLayout(1, false));
		group_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));
		
		engineexeTableViewer = new TableViewer(group_2, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		table_2 = engineexeTableViewer.getTable();
		table_2.setLinesVisible(true);
		table_2.setHeaderVisible(true);
		GridData gd_table_2 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_table_2.heightHint = 50;
		table_2.setLayoutData(gd_table_2);
		
		TableViewerColumn tableViewerColumn_9 = new TableViewerColumn(engineexeTableViewer, SWT.NONE);
		TableColumn tableColumn_7 = tableViewerColumn_9.getColumn();
		tableColumn_7.setWidth(100);
		tableColumn_7.setText("参数");
		
		TableViewerColumn tableViewerColumn_10 = new TableViewerColumn(engineexeTableViewer, SWT.NONE);
		TableColumn tableColumn_8 = tableViewerColumn_10.getColumn();
		tableColumn_8.setWidth(100);
		tableColumn_8.setText("名称");
		
		TableViewerColumn tableViewerColumn_11 = new TableViewerColumn(engineexeTableViewer, SWT.NONE);
		TableColumn tableColumn_9 = tableViewerColumn_11.getColumn();
		tableColumn_9.setWidth(100);
		tableColumn_9.setText("类型");
		
		TableViewerColumn tableViewerColumn_12 = new TableViewerColumn(engineexeTableViewer, SWT.NONE);
		TableColumn tableColumn_10 = tableViewerColumn_12.getColumn();
		tableColumn_10.setWidth(100);
		tableColumn_10.setText("值");
		
		TableViewerColumn tableViewerColumn_13 = new TableViewerColumn(engineexeTableViewer, SWT.NONE);
		TableColumn tableColumn_11 = tableViewerColumn_13.getColumn();
		tableColumn_11.setWidth(100);
		tableColumn_11.setText("描述");
		
//			Composite composite_2 = new Composite(group_2, SWT.NONE);
//			GridLayout gl_composite_2 = new GridLayout(1, false);
//			gl_composite_2.verticalSpacing = 1;
//			gl_composite_2.marginWidth = 0;
//			gl_composite_2.marginHeight = 0;
//			gl_composite_2.horizontalSpacing = 0;
//			composite_2.setLayout(gl_composite_2);
		
//			Button addEngineParamButton = new Button(composite_2, SWT.NONE);
//			addEngineParamButton.setSize(80, 27);
//			addEngineParamButton.setText("添加");
//			addEngineParamButton.addListener(SWT.Selection, new Listener() {
//				@Override
//				public void handleEvent(Event event) {
//					CommandParamTo commandParamTo = new CommandParamTo();
//					commandParamTo.setBizType("ExecuteParam");
//					commandParamTo.setDataType("String");
//					commandParamTo.setDescription("");
//					Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
//					expression.setName("");
//					expression.setValue("");
//					commandParamTo.setExpression(expression);
//					commandParamTo.setKey("param");
//					commandParamTo.setName("参数");
//					
//					((List<CommandParamTo>)engineexeTableViewer.getInput()).add(commandParamTo);
//					engineexeTableViewer.refresh();
//				}
//			});
//			
//			Button deleteEngineParamButton = new Button(composite_2, SWT.NONE);
//			deleteEngineParamButton.setText("删除");
//			deleteEngineParamButton.addListener(SWT.Selection, new Listener() {
//				@Override
//				public void handleEvent(Event event) {
//					ISelection sel = uicontrolTableViewer.getSelection();
//					if (sel == null)
//						return;
//					Object[] objs = ((IStructuredSelection) sel).toArray();
//					if (objs == null || objs.length == 0)
//						return;
//					boolean b = MessageDialog.openConfirm(null, "警告", "你确认要删除吗？");
//					if (!b)
//						return;
//
//					for (int i = 0; i < objs.length; i++) {
//						CommandParamTo col = (CommandParamTo) objs[i];
//						((List<CommandParamTo>)engineexeTableViewer.getInput()).remove(col);
//					}
//					engineexeTableViewer.refresh();				
//				}
//			});
		
		engineexeTableViewer.setContentProvider(new ArrayContentProvider());
		engineexeTableViewer.setLabelProvider(new EngineExeTableLabelProvider());
		
		FormToolkit formToolkit = new FormToolkit(Display.getCurrent());
		section = formToolkit.createSection(composite, Section.TWISTIE | Section.TITLE_BAR);
		GridData gd_section = new GridData(SWT.FILL, SWT.TOP, false, true, 2, 1);
		gd_section.widthHint = 371;
		section.setLayoutData(gd_section);
		section.setText("高级参数");
		section.setExpanded(true);
//		section.addExpansionListener(new IExpansionListener() {
//			
//			@Override
//			public void expansionStateChanging(ExpansionEvent e) {//TODO
// 				if(e.getState()) {
//					getShell().setSize(655, 646);
//					Point point = getShell().getLocation();
//					point.y -= 100; 
//					getShell().setLocation(point);
//					
//					
//					GridData data = (GridData) group_2.getLayoutData();
//		            data.exclude = TaskCommandUtil.getTaskCommandParamByType((TaskCommandDefinition) typecombo.getData(typecombo.getSelectionIndex()+""), "ExecuteParam").size()==0;
//		            data.heightHint = 100;
//		            group_2.setVisible(!data.exclude);
//		                
//		            getShell().layout();
//					
//				}else {
//					getShell().setSize(655, 450);
//					Point point = getShell().getLocation();
//					point.y += 100; 
//					getShell().setLocation(point);
//					
////					GridData data = (GridData) group_2.getLayoutData();
////		            data.exclude = TaskCommandUtil.getTaskCommandParamByType((TaskCommandDefinition) typecombo.getData(typecombo.getSelectionIndex()+""), "ExecuteParam").size()==0;
//		            group_2.setVisible(true);
//		            
//		            getShell().layout();
//				}
//				
//			}
//			
//			@Override
//			public void expansionStateChanged(ExpansionEvent e) {
//				e.getState();
//			}
//		});
		
		advanceparamcomposite = formToolkit.createComposite(section);
		GridLayout gl_advanceparamcomposite = new GridLayout(1, false);
		advanceparamcomposite.setLayout(gl_advanceparamcomposite);
		advanceparamcomposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		section.setClient(advanceparamcomposite);
		
		Group group = new Group(advanceparamcomposite, SWT.NONE);
		group.setLayout(new GridLayout(1, false));
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		group.setText("界面收集参数");
		
		uicollectTableViewer = new TableViewer(group, SWT.BORDER | SWT.FULL_SELECTION);
		table = uicollectTableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		GridData gd_table = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_table.heightHint = 70;
		table.setLayoutData(gd_table);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(uicollectTableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("参数");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(uicollectTableViewer, SWT.NONE);
		TableColumn tableColumn = tableViewerColumn_1.getColumn();
		tableColumn.setWidth(100);
		tableColumn.setText("名称");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(uicollectTableViewer, SWT.NONE);
		TableColumn tableColumn_1 = tableViewerColumn_2.getColumn();
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("类型");
		
		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(uicollectTableViewer, SWT.NONE);
		TableColumn tableColumn_2 = tableViewerColumn_3.getColumn();
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("描述");
		uicollectTableViewer.setContentProvider(new ArrayContentProvider());
		uicollectTableViewer.setLabelProvider(new UiCollectTableLabelProvider());
		
		Group group_1 = new Group(advanceparamcomposite, SWT.NONE);
		group_1.setText("界面控制参数");
		group_1.setLayout(new GridLayout(2, false));
		group_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		
		uicontrolTableViewer = new TableViewer(group_1, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		table_1 = uicontrolTableViewer.getTable();
		table_1.setLinesVisible(true);
		table_1.setHeaderVisible(true);
		GridData gd_table_1 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_table_1.heightHint = 100;
		table_1.setLayoutData(gd_table_1);
		
		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(uicontrolTableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_1 = tableViewerColumn_4.getColumn();
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("参数");
		
		TableViewerColumn tableViewerColumn_5 = new TableViewerColumn(uicontrolTableViewer, SWT.NONE);
		TableColumn tableColumn_3 = tableViewerColumn_5.getColumn();
		tableColumn_3.setWidth(100);
		tableColumn_3.setText("名称");
		
		TableViewerColumn tableViewerColumn_6 = new TableViewerColumn(uicontrolTableViewer, SWT.NONE);
		TableColumn tableColumn_4 = tableViewerColumn_6.getColumn();
		tableColumn_4.setWidth(100);
		tableColumn_4.setText("类型");
		
		TableViewerColumn tableViewerColumn_7 = new TableViewerColumn(uicontrolTableViewer, SWT.NONE);
		TableColumn tableColumn_5 = tableViewerColumn_7.getColumn();
		tableColumn_5.setWidth(100);
		tableColumn_5.setText("值");
		
		TableViewerColumn tableViewerColumn_8 = new TableViewerColumn(uicontrolTableViewer, SWT.NONE);
		TableColumn tableColumn_6 = tableViewerColumn_8.getColumn();
		tableColumn_6.setWidth(100);
		tableColumn_6.setText("描述");
		
		Composite composite_1 = new Composite(group_1, SWT.NONE);
		GridLayout gl_composite_1 = new GridLayout(1, false);
		gl_composite_1.marginWidth = 0;
		gl_composite_1.horizontalSpacing = 0;
		gl_composite_1.marginHeight = 0;
		gl_composite_1.verticalSpacing = 1;
		composite_1.setLayout(gl_composite_1);
		
		Button addControlParamButton = new Button(composite_1, SWT.NONE);
		addControlParamButton.setText("添加");
		addControlParamButton.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				CommandParamTo commandParamTo = new CommandParamTo();
				commandParamTo.setBizType("ControlParam");
				commandParamTo.setDataType("String");
				commandParamTo.setDescription("");
				Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
				expression.setName("");
				expression.setValue("");
				commandParamTo.setExpression(expression);
				commandParamTo.setKey("param");
				commandParamTo.setName("参数");
				
				((List<CommandParamTo>)uicontrolTableViewer.getInput()).add(commandParamTo);
				uicontrolTableViewer.refresh();
			}
		});
		
		Button deleteControlParamButton = new Button(composite_1, SWT.NONE);
		deleteControlParamButton.setText("删除");
		deleteControlParamButton.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				ISelection sel = uicontrolTableViewer.getSelection();
				if (sel == null)
					return;
				Object[] objs = ((IStructuredSelection) sel).toArray();
				if (objs == null || objs.length == 0)
					return;
				boolean b = MessageDialog.openConfirm(null, "警告", "你确认要删除吗？");
				if (!b)
					return;

				for (int i = 0; i < objs.length; i++) {
					CommandParamTo col = (CommandParamTo) objs[i];
					((List<CommandParamTo>)uicontrolTableViewer.getInput()).remove(col);
				}
				uicontrolTableViewer.refresh();				
			}
		});
		
		uicontrolTableViewer.setContentProvider(new ArrayContentProvider());
		uicontrolTableViewer.setLabelProvider(new UiControlTableLabelProvider());

		createUiCollectCellModifier();
		createUiControlCellModifier();
		createEngineExeCellModifier();
		
		initTableViewers("init");
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
		return new Point(655, 670);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void okPressed() {

		if (nametext.getText().equals("")) {
			MessageDialog.openWarning(null, "警告", "名称不能为空");
			return;
		}
		final TaskCommand taskCommand = FoxBPMFactory.eINSTANCE.createTaskCommand();
		taskCommand.setId(idtext.getText() == null ? "" : idtext.getText());
		taskCommand.setName(nametext.getText() == null ? "" : nametext.getText());
		taskCommand.setCommandType(((TaskCommandDefinition)typecombo.getData(typecombo.getSelectionIndex() + "")).getId());

		final Expression expression = expressionComboViewer.getExpression();
		if (expression != null) {
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
				@Override
				protected void doExecute() {
					taskCommand.setExpression(expression);
				}
				
			});
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

		//循环加入命令参数
		addParamsToTaskCommand(taskCommand, uicollectTableViewer);
		addParamsToTaskCommand(taskCommand, uicontrolTableViewer);
		addParamsToTaskCommand(taskCommand, engineexeTableViewer);
		
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

			// 初始化
			if (taskCommand.getExpression() != null) {
				expressionComboViewer.setExpression(taskCommand.getExpression());
				expressionComboViewer.getTextControl().setText(taskCommand.getExpression().getName());
			}

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
			List<TaskCommandDefinition> nameList = TaskCommandUtil.getTaskCommandNames();
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
	 * 初始化Combo，加入items
	 */
	private void initCombo() {
		// 添加扩展
		List<TaskCommandDefinition> nameList = TaskCommandUtil.getTaskCommandNames();

		int i = 0;
		for (TaskCommandDefinition taskCommand : nameList) {
			typecombo.add(taskCommand.getName());
			typecombo.setData(i + "", taskCommand);
			i = i + 1;

		}

		typecombo.select(0);

		// 默认名称为选中的类型
		nametext.setText(typecombo.getData(typecombo.getSelectionIndex() + "") == null ? "" : getType(((TaskCommandDefinition)typecombo.getData(typecombo.getSelectionIndex() + "")).getId()));
	}
	
	private void createUiCollectCellModifier() {
		final CellEditor[] cellEditor = new CellEditor[table.getColumnCount()];
		cellEditor[0] = new TextCellEditor(table, SWT.READ_ONLY);
		cellEditor[1] = new TextCellEditor(table, SWT.READ_ONLY);
		cellEditor[2] = new TextCellEditor(table, SWT.READ_ONLY);
		cellEditor[3] = new TextCellEditor(table, SWT.READ_ONLY);
		
		uicollectTableViewer.setColumnProperties(new String[] { "UICOLLECTPARAM", "UICOLLECTNAME", "UICOLLECTTYPE", "UICOLLECTDESC" });
		uicollectTableViewer.setCellEditors(cellEditor);
		uicollectTableViewer.setCellModifier(new ICellModifier() {
			
			@Override
			public void modify(Object element, String property, Object value) {
				
			}
			
			@Override
			public Object getValue(Object element, String property) {
				return null;
			}
			
			@Override
			public boolean canModify(Object element, String property) {
				return false;
			}
		});
	}
	
	private void createUiControlCellModifier() {
		final CellEditor[] cellEditor = new CellEditor[table_1.getColumnCount()];
		cellEditor[0] = new TextCellEditor(table_1, SWT.NONE);
		cellEditor[1] = new TextCellEditor(table_1, SWT.NONE);
		cellEditor[2] = new TextCellEditor(table_1, SWT.NONE);
		cellEditor[3] = new CommandParamDialogCellEditor(table_1, getParentShell(), editingDomain, uicontrolTableViewer);
		cellEditor[4] = new FoxBPMInputCellEditor(table_1, getShell());
		
		uicontrolTableViewer.setColumnProperties(new String[] { "UICONTROLPARAM", "UICONTROLNAME", "UICONTROLTYPE", "UICONTROLVALUE", "UICONTROLDESC" });
		uicontrolTableViewer.setCellEditors(cellEditor);
		uicontrolTableViewer.setCellModifier(new ICellModifier() {
			
			@Override
			public void modify(Object element, String property, Object value) {
				TableItem tableitem = (TableItem) element;
				CommandParamTo commandParamTo = (CommandParamTo) tableitem.getData();
				if (property.equals("UICONTROLPARAM")) {
					commandParamTo.setKey(((String)value));
				}
				if (property.equals("UICONTROLNAME")) {
					commandParamTo.setName(((String)value));
				}
				if (property.equals("UICONTROLTYPE")) {
					commandParamTo.setDataType(((String)value));
				}
				if(property.equals("UICONTROLVALUE")) {
					Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
					expression.setName(((String)value));
					expression.setValue(((String)value));
					commandParamTo.setExpression(expression);
				}
				if(property.equals("UICONTROLDESC")) {
					((FoxBPMInputCellEditor)cellEditor[4]).setText(((String)value));
					commandParamTo.setDescription(((String)value));
				}
				
				uicontrolTableViewer.refresh();
			}
			
			@Override
			public Object getValue(Object element, String property) {
				CommandParamTo commandParamTo = (CommandParamTo) element;
				if (property.equals("UICONTROLPARAM")) {
					return commandParamTo.getKey();
				}
				if (property.equals("UICONTROLNAME")) {
					return commandParamTo.getName();
				}
				if (property.equals("UICONTROLTYPE")) {
					return commandParamTo.getDataType();
				}
				if(property.equals("UICONTROLVALUE")) {
					return commandParamTo.getExpression()==null?"":commandParamTo.getExpression().getName();
				}
				if(property.equals("UICONTROLDESC")) {
					((FoxBPMInputCellEditor)cellEditor[4]).setText(commandParamTo.getDescription());
					return commandParamTo.getDescription();
				}
				return null;
			}
			
			@Override
			public boolean canModify(Object element, String property) {
				if(element instanceof CommandParam) {
					CommandParamTo commandParamTo = (CommandParamTo) element;
					if(commandParamTo.getType()!=null && commandParamTo.getType().equals("config")) {
						return false;
					}else{
						return true;
					}
				}
				return false;
			}
		});
	}
	
	private void createEngineExeCellModifier() {
		final CellEditor[] cellEditor = new CellEditor[table_2.getColumnCount()];
//		cellEditor[0] = new TextCellEditor(table_2, SWT.READ_ONLY);
//		cellEditor[1] = new TextCellEditor(table_2, SWT.READ_ONLY);
//		cellEditor[2] = new TextCellEditor(table_2, SWT.READ_ONLY);
		cellEditor[3] = new CommandParamDialogCellEditor(table_2, getParentShell(), editingDomain, engineexeTableViewer);
		cellEditor[4] = new FoxBPMInputCellEditor(table_2, getShell());
		
		engineexeTableViewer.setColumnProperties(new String[] { "ENGINEEXEPARAM", "ENGINEEXENAME", "ENGINEEXETYPE", "ENGINEEXEVALUE", "ENGINEEXEDESC" });
		engineexeTableViewer.setCellEditors(cellEditor);
		engineexeTableViewer.setCellModifier(new ICellModifier() {
			
			@Override
			public void modify(Object element, String property, Object value) {
				TableItem tableitem = (TableItem) element;
				CommandParamTo commandParamTo = (CommandParamTo) tableitem.getData();
				if (property.equals("ENGINEEXEPARAM")) {
					commandParamTo.setKey(((String)value));
				}
				if (property.equals("ENGINEEXENAME")) {
					commandParamTo.setName(((String)value));
				}
				if (property.equals("ENGINEEXETYPE")) {
					commandParamTo.setDataType(((String)value));
				}
				if(property.equals("ENGINEEXEVALUE")) {
					Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
					expression.setName(((String)value));
					expression.setValue(((String)value));
					commandParamTo.setExpression(expression);
				}
				if(property.equals("ENGINEEXEDESC")) {
					((FoxBPMInputCellEditor)cellEditor[4]).setText(((String)value));
					commandParamTo.setDescription(((String)value));
				}
				
				engineexeTableViewer.refresh();
			}
			
			@Override
			public Object getValue(Object element, String property) {
				CommandParamTo commandParamTo = (CommandParamTo) element;
				if (property.equals("ENGINEEXEPARAM")) {
					return commandParamTo.getKey();
				}
				if (property.equals("ENGINEEXENAME")) {
					return commandParamTo.getName();
				}
				if (property.equals("ENGINEEXETYPE")) {
					return commandParamTo.getDataType();
				}
				if(property.equals("ENGINEEXEVALUE")) {
					return commandParamTo.getExpression()==null?"":commandParamTo.getExpression().getName();
				}
				if(property.equals("ENGINEEXEDESC")) {
					((FoxBPMInputCellEditor)cellEditor[4]).setText(commandParamTo.getDescription());
					return commandParamTo.getDescription();
				}
				return null;
			}
			
			@Override
			public boolean canModify(Object element, String property) {
				if(element instanceof CommandParamTo) {
//					CommandParamTo commandParamTo = (CommandParamTo) element;
//					if(commandParamTo.getType()!=null && commandParamTo.getType().equals("config")) {
//						return false;
//					}else{
//						return true;
//					}
					return true;
				}
				return false;
			}
		});
	}
	
	private class UiCollectTableLabelProvider extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}
		public String getColumnText(Object element, int columnIndex) {
			CommandParam commandParam = (CommandParam) element;
			switch (columnIndex) {
			case 0:
				return commandParam.getKey();
			case 1:
				return commandParam.getName();
			case 2:
				return commandParam.getDataType();
			case 3:
				return commandParam.getDescription();
			}
			return null;
		}
	}
	
	private class UiControlTableLabelProvider extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}
		public String getColumnText(Object element, int columnIndex) {
			CommandParamTo commandParamTo = (CommandParamTo) element;
			switch (columnIndex) {
			case 0:
				return commandParamTo.getKey();
			case 1:
				return commandParamTo.getName();
			case 2:
				return commandParamTo.getDataType();
			case 3:
				return commandParamTo.getExpression()==null?"":commandParamTo.getExpression().getName();
			case 4:
				return commandParamTo.getDescription();
			}
			return null;
		}
	}
	
	private class EngineExeTableLabelProvider extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}
		public String getColumnText(Object element, int columnIndex) {
			CommandParamTo commandParamTo = (CommandParamTo) element;
			switch (columnIndex) {
			case 0:
				return commandParamTo.getKey();
			case 1:
				return commandParamTo.getName();
			case 2:
				return commandParamTo.getDataType();
			case 3:
				return commandParamTo.getExpression()==null?"":commandParamTo.getExpression().getName();
			case 4:
				return commandParamTo.getDescription();
			}
			return null;
		}
	}
	
	/**
	 * 初始化各个tableviewer的值
	 */
	private void initTableViewers(String type){
		engineexeTableViewer.setInput(TaskCommandUtil.getTaskCommandParamByType((TaskCommandDefinition) typecombo.getData(typecombo.getSelectionIndex()+""), "ExecuteParam"));
		uicollectTableViewer.setInput(TaskCommandUtil.getTaskCommandParamByType((TaskCommandDefinition) typecombo.getData(typecombo.getSelectionIndex()+""), "InputParam"));
		uicontrolTableViewer.setInput(TaskCommandUtil.getTaskCommandParamByType((TaskCommandDefinition) typecombo.getData(typecombo.getSelectionIndex()+""), "ControlParam"));
		
		if(taskCommand!=null && type.equals("init")) {
//			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
//				@Override
//				protected void doExecute() {
//					
//				}
//				
//			});
			
			List<CommandParamTo> uicollectCommandParamTos = new ArrayList<CommandParamTo>();
			List<CommandParamTo> uicontrolCommandParamTos = new ArrayList<CommandParamTo>();
			List<CommandParamTo> engineexeCommandParamTos = new ArrayList<CommandParamTo>();
			for (Param param : taskCommand.getParams()) {
				CommandParam commandParam = (CommandParam) param;
				CommandParamTo commandParamTo = new CommandParamTo();
				if(commandParam.getBizType().equals("InputParam")) {
					convertCommandParam2To(commandParam, commandParamTo, uicollectCommandParamTos);
				}
				if(commandParam.getBizType().equals("ControlParam")) {
					convertCommandParam2To(commandParam, commandParamTo, uicontrolCommandParamTos);
				}
				if(commandParam.getBizType().equals("ExecuteParam")) {
					convertCommandParam2To(commandParam, commandParamTo, engineexeCommandParamTos);
				}
			}
			
			uicollectTableViewer.setInput(uicollectCommandParamTos);
			uicontrolTableViewer.setInput(uicontrolCommandParamTos);
			engineexeTableViewer.setInput(engineexeCommandParamTos);
		}
		
		uicollectTableViewer.refresh();
		uicontrolTableViewer.refresh();
		engineexeTableViewer.refresh();
	}
	
	/**
	 * commandparam转to类
	 * @param commandParam
	 * @param commandParamTo
	 * @param commandParamTos
	 */
	private void convertCommandParam2To(CommandParam commandParam, CommandParamTo commandParamTo, List<CommandParamTo> commandParamTos) {
		commandParamTo.setBizType(commandParam.getBizType());
		commandParamTo.setDataType(commandParam.getDataType());
		commandParamTo.setDescription(commandParam.getDescription());
		Expression expression = EcoreUtil.copy(commandParam.getExpression())==null?FoxBPMFactory.eINSTANCE.createExpression():EcoreUtil.copy(commandParam.getExpression());
		commandParamTo.setExpression(expression);
		commandParamTo.setName(commandParam.getName());
		commandParamTo.setKey(commandParam.getKey());
		
		commandParamTos.add(commandParamTo);
	}
	
	/**
	 * 从tableviewer中拿到参数值放入taskcommand中
	 * @param taskCommand
	 * @param tableViewer
	 */
	private void addParamsToTaskCommand(TaskCommand taskCommand, TableViewer tableViewer) {
		for (CommandParamTo commandParamTo : ((List<CommandParamTo>)tableViewer.getInput())) {
			CommandParam commandParam = FoxBPMFactory.eINSTANCE.createCommandParam();
			commandParam.setBizType(commandParamTo.getBizType());
			commandParam.setDataType(commandParamTo.getDataType());
			commandParam.setDescription(commandParamTo.getDescription());
			commandParam.setExpression(commandParamTo.getExpression());
			commandParam.setKey(commandParamTo.getKey());
			commandParam.setName(commandParamTo.getName());
			taskCommand.getParams().add(commandParam);
		}
	}
}

