package org.foxbpm.bpmn.designer.ui.expdialog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.bpmn2.modeler.core.ModelHandlerLocator;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.ui.editor.BPMN2MultiPageEditor;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jdt.ui.PreferenceConstants;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
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
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.ide.FileStoreEditorInput;
import org.eclipse.ui.texteditor.ChainedPreferenceStore;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.foxbpm.bpmn.designer.base.model.GroupDefine;
import org.foxbpm.bpmn.designer.base.utils.EMFUtil;
import org.foxbpm.bpmn.designer.base.utils.FileUtil;
import org.foxbpm.bpmn.designer.base.utils.FoxBPMDesignerUtil;
import org.foxbpm.bpmn.designer.base.utils.JsonDataUtil;
import org.foxbpm.bpmn.designer.base.utils.StringUtil;
import org.foxbpm.bpmn.designer.ui.custom.CommandParamTo;
import org.foxbpm.bpmn.designer.ui.dialogs.DataVarTo;
import org.foxbpm.bpmn.designer.ui.expdialog.widget.event.SearchButtonAction;
import org.foxbpm.bpmn.designer.ui.tree.ITreeElement;
import org.foxbpm.bpmn.designer.ui.utils.BpmnModelUtil;
import org.foxbpm.bpmn.designer.ui.utils.DataVarUtil;
import org.foxbpm.bpmn.designer.ui.utils.ImageUtil;
import org.foxbpm.model.bpmn.foxbpm.DataVariable;
import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FormParam;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage.Literals;
import org.foxbpm.model.bpmn.foxbpm.PotentialStarter;
import org.foxbpm.model.config.variableconfig.DataVariableBizType;
import org.foxbpm.model.config.variableconfig.DataVariableConfig;
import org.foxbpm.model.config.variableconfig.DataVariableDef;
import org.foxbpm.model.config.variableconfig.DataVariableType;
import org.foxbpm.model.config.variableconfig.FoxBPMDataVariable;
import org.foxbpm.model.config.variableconfig.Type;
import org.foxbpm.model.config.variableconfig.impl.FoxBPMDataVariableImpl;

public class FoxBPMExpDialog extends Dialog {
	private DataBindingContext m_bindingContext;
	private ProjectionViewer viewer;
	private IDocument document;
	private FoxBPMGroovyEditor editor;
	private IEditorSite site;
	private ISelectionProvider diagramEditorSelectionProvider;
	private IWorkbench workbench;
	private IHandlerActivation fHandlerActivation;
	private IEditorInput input;
	private Text displaytext;
	private Expression expression;
	private Text textcontrol;
	private FormParam formParam;
	private TransactionalEditingDomain editingDomain;
	private DataVariableConfig dataVariableConfig;
	private Map<String, FoxBPMDataVariable> typeToDataVariableMap;// 维护dataVariableType到FoxBPMDataVariable的映射
	private static final Object[] EMPTY_ARRAY = new Object[0];
	private static final String EMPTY_STRING = "";
	private PotentialStarter potentialStarter;
	private CommandParamTo commandParamTo;
	private TreeViewer datavartreeViewer;
	private java.util.List<DataVarTo> dataVarTos;
	private Composite orgComposite_1;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 * @wbp.parser.constructor
	 */
	public FoxBPMExpDialog(Shell parentShell) {
		super(parentShell);
		setShellStyle(SWT.DIALOG_TRIM | SWT.RESIZE | SWT.PRIMARY_MODAL);
		loadDataVariableConfig();
		MapFoxBPMDataVariableWithType();
		initDataVar();
	}

	public FoxBPMExpDialog(Shell parentShell, Expression expression, Text text) {
		this(parentShell);
		this.expression = expression;
		if (this.expression == null) {
			this.expression = FoxBPMFactory.eINSTANCE.createExpression();
			this.expression.setName("");
			this.expression.setValue("");
		}
		this.textcontrol = text;
		initDataVar();
	}

	public FoxBPMExpDialog(TransactionalEditingDomain editingDomain, FormParam formParam, Shell parentShell, Expression expression,
			Text text) {
		this(parentShell, expression, text);
		this.formParam = formParam;
		this.editingDomain = editingDomain;
		initDataVar();
	}

	public FoxBPMExpDialog(TransactionalEditingDomain editingDomain, PotentialStarter potentialStarter, Shell parentShell,
			Expression expression, Text text) {
		this(parentShell, expression, text);
		this.potentialStarter = potentialStarter;
		this.editingDomain = editingDomain;
		initDataVar();
	}
	
	public FoxBPMExpDialog(TransactionalEditingDomain editingDomain, CommandParamTo commandParamTo, Shell parentShell,
			Expression expression, Text text) {
		this(parentShell, expression, text);
		this.commandParamTo = commandParamTo;
		this.editingDomain = editingDomain;
		initDataVar();
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(3, false));

		orgComposite_1 = new Composite(container, SWT.NONE);
		orgComposite_1.setLayout(new GridLayout(1, false));
		orgComposite_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));

		Label label = new Label(orgComposite_1, SWT.NONE);
		GridData gd_label = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_label.widthHint = 130;
		label.setLayoutData(gd_label);
		label.setText("组织结构");

		// 在当前窗口中创建分组
		Group radioGroup = crateGroupDefine(orgComposite_1);
		// 搜索区域
		Composite searchGroup = new Composite(orgComposite_1, SWT.SHADOW_ETCHED_OUT);
		searchGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.marginLeft = -5;
		searchGroup.setLayout(gridLayout);

		GridData searchGridData = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		searchGridData.widthHint = 90;
		// 搜索
		Text searchText = new Text(searchGroup, SWT.SINGLE | SWT.BORDER | SWT.SEARCH | SWT.ICON_CANCEL);
		searchText.setLayoutData(searchGridData);
		Button searchButton = new Button(searchGroup, SWT.NONE);
		searchGridData = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		searchButton.setLayoutData(searchGridData);
		searchButton.setText("搜索");
		// 表格视图
		TableViewer tableViewer = new TableViewer(orgComposite_1, SWT.BORDER | SWT.FULL_SELECTION);
		// 表格
		Table orgTable = tableViewer.getTable();
		orgTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
		// 显示表头
		orgTable.setHeaderVisible(true);
		// 显示表格线
		orgTable.setLinesVisible(true);
		// 专用于表格的布局
		TableLayout orgTablelayout = new TableLayout();
		orgTable.setLayout(orgTablelayout);
		orgTablelayout.addColumnData(new ColumnWeightData(20));
		// 定义列
		TableColumn tableColumn = new TableColumn(orgTable, SWT.NONE);
		tableColumn.setText("编号");
		tableColumn.setMoveable(true);

		orgTablelayout.addColumnData(new ColumnWeightData(40));
		tableColumn = new TableColumn(orgTable, SWT.NONE);
		tableColumn.setText("名称");
		tableColumn.setMoveable(true);
		tableViewer.addDoubleClickListener(new IDoubleClickListener() {

			@SuppressWarnings("unchecked")
			@Override
			public void doubleClick(DoubleClickEvent event) {
				ISelection selection = event.getSelection();
				if (selection.isEmpty()) {
					return;
				}
				HashMap<String, String> data = (HashMap<String, String>) ((IStructuredSelection) selection).getFirstElement();
				@SuppressWarnings("restriction")
				final SourceViewer srcViewer = (SourceViewer) editor.getViewer();
				IDocument document = srcViewer.getDocument();
				int offset = srcViewer.getTextWidget().getCaretOffset();
				String before = "";
				try {
					before = document.get(0, offset);
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
				// 获取编号,并插入
				String Id = new StringBuffer("\"").append(StringUtil.getString(data.get("1"))).append("\"").toString();
				if (offset == document.get().length()) {
					document.set(before + Id);
				} else {
					String after = document.get().substring(offset, document.get().length());
					document.set(before + Id + after);
				}
				// 更新文档数据长度
				srcViewer.getTextWidget().setCaretOffset(offset + Id.length());
				// 更新焦点
				srcViewer.getTextWidget().setFocus();
			}
		});

		tableViewer.setContentProvider(new IStructuredContentProvider() {
			@SuppressWarnings("rawtypes")
			public Object[] getElements(Object inputElement) {
				if (inputElement instanceof ArrayList) {
					return ((ArrayList) inputElement).toArray();
				} else {
					return new Object[0];
				}
			}

			public void dispose() {
			}

			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}
		});
		// 设置标签器
		tableViewer.setLabelProvider(new ITableLabelProvider() {
			@SuppressWarnings({ "rawtypes" })
			public String getColumnText(Object element, int columnIndex) {
				if (element instanceof Map) {
					Map map = (Map) element;
					return StringUtil.getString(map.get(String.valueOf(columnIndex + 1)));
				}
				return null;
			}

			@Override
			public void addListener(ILabelProviderListener listener) {

			}

			@Override
			public void dispose() {

			}

			@Override
			public boolean isLabelProperty(Object element, String property) {
				return false;
			}

			@Override
			public void removeListener(ILabelProviderListener listener) {

			}

			@Override
			public Image getColumnImage(Object element, int columnIndex) {
				return null;
			}
		});

		searchButton.addSelectionListener(new SearchButtonAction(searchText, radioGroup, tableViewer));

		Label lblNewLabel = new Label(orgComposite_1, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("流程变量");
		
		datavartreeViewer = new TreeViewer(orgComposite_1, SWT.BORDER);
		Tree tree = datavartreeViewer.getTree();
		GridData gd_tree = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_tree.widthHint = 150;
		tree.setLayoutData(gd_tree);
		datavartreeViewer.setContentProvider(new TreeContentProvider());
		datavartreeViewer.setLabelProvider(new ViewerLabelProvider());
		datavartreeViewer.setInput(dataVarTos);
		
		datavartreeViewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection selection = (IStructuredSelection) datavartreeViewer.getSelection();
				ITreeElement selectElement = (ITreeElement) selection.getFirstElement();

				// 这个地方如果数据变量就叫 "数据变量" 的话 会出现选不中的问题!
				// 如果表达式就是为null的话 他会出问题 这个地方要改

				if (((DataVarTo) selectElement).getCantbechoose() == null) {
					StyledText control = viewer.getTextWidget();
					try {
						if (document.get().length() == 0)
							document.set("");
						int offset = control.getCaretOffset();
						String before = document.get(0, offset);

						if (offset == document.get().length()) {
							document.set(before + ((DataVarTo) selectElement).getValue());
						} else {
							String after = document.get().substring(offset, document.get().length());
							document.set(before + ((DataVarTo) selectElement).getValue() + after);
						}

						control.setCaretOffset(offset + ((DataVarTo) selectElement).getValue().length());
						control.setFocus();

					} catch (BadLocationException e) {
						e.printStackTrace();
					}
				}
			}
		});

		Composite editorComposite = new Composite(container, SWT.NONE);
		editorComposite.setLayout(new GridLayout(2, false));
		editorComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		Label label_2 = new Label(editorComposite, SWT.NONE);
		label_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_2.setText("显示名称");

		displaytext = new Text(editorComposite, SWT.BORDER);
		GridData gd_displaytext = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_displaytext.widthHint = 470;
		displaytext.setLayoutData(gd_displaytext);
		
				Label label_3 = new Label(editorComposite, SWT.NONE);
				label_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
				label_3.setText("脚本引擎");
		
				Combo combo = new Combo(editorComposite, SWT.READ_ONLY);
				combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Composite toolbarComposite = new Composite(editorComposite, SWT.NONE);
		toolbarComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));
		toolbarComposite.setLayout(new GridLayout(2, false));

		createEditor(editorComposite);

		createToolBar(toolbarComposite);

		Composite docComposite = new Composite(container, SWT.NONE);
		docComposite.setLayout(new GridLayout(1, false));
		docComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));

		Label classifyLabel = new Label(docComposite, SWT.NONE);
		classifyLabel.setText("分类");

		ListViewer classifyListViewer = new ListViewer(docComposite, SWT.BORDER | SWT.V_SCROLL);
		List classifyList = classifyListViewer.getList();
		GridData gd_classifyList = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_classifyList.widthHint = 160;
		gd_classifyList.heightHint = 120;
		classifyList.setLayoutData(gd_classifyList);
		classifyListViewer.setContentProvider(ArrayContentProvider.getInstance());
		classifyListViewer.setLabelProvider(new LabelProvider() {

			@Override
			public String getText(Object element) {
				org.foxbpm.model.config.variableconfig.Type type = (Type) element;
				FoxBPMDataVariable FoxBPMDataVariable = typeToDataVariableMap.get(type.getId());
				int size = FoxBPMDataVariable == null ? 0 : FoxBPMDataVariable.getDataVariableDef().size();
				return type.getName() + "(" + size + ")";
			}

		});
		classifyListViewer.setInput(dataVariableConfig.getDataVariableType().getType());

		Label functionLabel = new Label(docComposite, SWT.NONE);
		functionLabel.setText("函数");

		PatternFilter filter = new PatternFilter();
		FilteredTree filteredTree = new FilteredTree(docComposite, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER, filter, true);
		final TreeViewer functionTreeViewer = filteredTree.getViewer();
		Tree FunctionTree = functionTreeViewer.getTree();
		GridData gd_FunctionTree = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_FunctionTree.heightHint = 200;
		FunctionTree.setLayoutData(gd_FunctionTree);
		functionTreeViewer.setContentProvider(new FuncitonTreeContentProvider());
		functionTreeViewer.setLabelProvider(new StyledFunctionTreeLabelProvider());

		Label documentLabel = new Label(docComposite, SWT.NONE);
		documentLabel.setText("文档");

		final Text docText = new Text(docComposite, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		GridData gd_docText = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_docText.heightHint = 100;
		docText.setLayoutData(gd_docText);

		// 绑定事件处理
		classifyListViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();
				if (selection.isEmpty()) {
					functionTreeViewer.setInput(EMPTY_ARRAY);
					docText.setText(EMPTY_STRING);
					return;
				}
				Type selectedType = (Type) ((IStructuredSelection) selection).getFirstElement();
				FoxBPMDataVariable FoxBPMDataVariable = typeToDataVariableMap.get(selectedType.getId());
				if (FoxBPMDataVariable == null) {
					functionTreeViewer.setInput(EMPTY_ARRAY);
					docText.setText(EMPTY_STRING);
				} else {
					functionTreeViewer.setInput(FoxBPMDataVariable);
				}

			}
		});

		functionTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();
				if (selection.isEmpty()) {
					docText.setText(EMPTY_STRING);
					return;
				}
				DataVariableDef selectedDataVariableDef = (DataVariableDef) ((IStructuredSelection) selection).getFirstElement();
				docText.setText(selectedDataVariableDef.getDoc());
			}
		});

		functionTreeViewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(DoubleClickEvent event) {
				ISelection selection = event.getSelection();
				if (selection.isEmpty()) {
					return;
				}
				DataVariableDef dataVariableDef = (DataVariableDef) ((IStructuredSelection) selection).getFirstElement();
				@SuppressWarnings("restriction")
				final SourceViewer srcViewer = (SourceViewer) editor.getViewer();
				IDocument document = srcViewer.getDocument();
				int offset = srcViewer.getTextWidget().getCaretOffset();
				String before = "";
				try {
					before = document.get(0, offset);
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
				String toInsert = dataVariableDef.getValue();
				if (offset == document.get().length()) {
					document.set(before + toInsert);
				} else {
					String after = document.get().substring(offset, document.get().length());
					document.set(before + toInsert + after);
				}

				srcViewer.getTextWidget().setCaretOffset(offset + toInsert.length());
				srcViewer.getTextWidget().setFocus();
			}
		});
		m_bindingContext = initDataBindings();
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
		return new Point(916, 634);
	}

	public void createToolBar(Composite operatorcomposite) {
		StyledText control = viewer.getTextWidget();

		ToolBar toolBar = new ToolBar(operatorcomposite, SWT.FLAT | SWT.RIGHT);
		GridData gd_toolBar = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_toolBar.widthHint = 393;
		toolBar.setLayoutData(gd_toolBar);

		ToolItem tltmNewItem = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem.setText("+");
		tltmNewItem.addSelectionListener(new GroovyOperatorSelectionAdapter("+", document, control));

		ToolItem tltmNewItem_1 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_1.setText("-");
		tltmNewItem_1.addSelectionListener(new GroovyOperatorSelectionAdapter("-", document, control));

		ToolItem tltmNewItem_2 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_2.setText("*");
		tltmNewItem_2.addSelectionListener(new GroovyOperatorSelectionAdapter("*", document, control));

		ToolItem tltmNewItem_3 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_3.setText("/");
		tltmNewItem_3.addSelectionListener(new GroovyOperatorSelectionAdapter("/", document, control));

		ToolItem tltmNewItem_4 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_4.setText("<");
		tltmNewItem_4.addSelectionListener(new GroovyOperatorSelectionAdapter("<", document, control));

		ToolItem tltmNewItem_5 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_5.setText("<=");
		tltmNewItem_5.addSelectionListener(new GroovyOperatorSelectionAdapter("<=", document, control));

		ToolItem tltmNewItem_6 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_6.setText("==");
		tltmNewItem_6.addSelectionListener(new GroovyOperatorSelectionAdapter("==", document, control));

		ToolItem tltmNewItem_7 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_7.setText("!=");
		tltmNewItem_7.addSelectionListener(new GroovyOperatorSelectionAdapter("!=", document, control));

		ToolItem tltmNewItem_8 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_8.setText(">=");
		tltmNewItem_8.addSelectionListener(new GroovyOperatorSelectionAdapter(">=", document, control));

		ToolItem tltmNewItem_9 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_9.setText(">");
		tltmNewItem_9.addSelectionListener(new GroovyOperatorSelectionAdapter(">", document, control));

		ToolItem tltmNewItem_10 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_10.setText("And");
		tltmNewItem_10.addSelectionListener(new GroovyOperatorSelectionAdapter("&&", document, control));

		ToolItem tltmNewItem_11 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_11.setText("Or");
		tltmNewItem_11.addSelectionListener(new GroovyOperatorSelectionAdapter("||", document, control));

		ToolItem tltmNewItem_12 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_12.setText("Not");
		tltmNewItem_12.addSelectionListener(new GroovyOperatorSelectionAdapter("!", document, control));

		ToolItem tltmNewItem_13 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_13.setText("true");
		tltmNewItem_13.addSelectionListener(new GroovyOperatorSelectionAdapter("true", document, control));

		ToolItem tltmNewItem_14 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_14.setText("false");
		tltmNewItem_14.addSelectionListener(new GroovyOperatorSelectionAdapter("false", document, control));

		ToolItem tltmNewItem_15 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_15.setText("(");
		tltmNewItem_15.addSelectionListener(new GroovyOperatorSelectionAdapter("(", document, control));

		ToolItem tltmNewItem_16 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_16.setText(")");
		tltmNewItem_16.addSelectionListener(new GroovyOperatorSelectionAdapter(")", document, control));

		Button clearButton = new Button(operatorcomposite, SWT.NONE);
		clearButton.setText("清空");
		clearButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				if (MessageDialog.openConfirm(null, "提示", "确定要清空吗？"))
					;
				document.set("");
			}
		});

		// ToolItem tltmNewItem_Name = new ToolItem(toolBar, SWT.NONE);
		// tltmNewItem_Name.setText("ExpressionName");
		// tltmNewItem_Name.addSelectionListener(new
		// GroovyOperatorSelectionAdapter("//FixFlow_ExpressionName:", document,
		// control));
	}

	private void createEditor(Composite composite) {
		Composite editorcomposite = new Composite(composite, SWT.NONE);
		FillLayout fl_editorcomposite = new FillLayout(SWT.HORIZONTAL);
		editorcomposite.setLayout(fl_editorcomposite);
		editorcomposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 2, 1));

		workbench = PlatformUI.getWorkbench();

		IPreferenceStore store = new ChainedPreferenceStore(new IPreferenceStore[] { PreferenceConstants.getPreferenceStore(),
				EditorsUI.getPreferenceStore() });

		site = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorSite();

		diagramEditorSelectionProvider = site.getSelectionProvider();

		// IPath path =
		// Path.fromOSString(FoxBPMDesignerUtil.getFakeGroovyFilePath());
		// IFile ifile = ResourcesPlugin.getWorkspace().getRoot().getFile(path);

		editor = new FoxBPMGroovyEditor(store);
		try {

			IFileStore fileStore = EFS.getLocalFileSystem().getStore(new Path(FoxBPMDesignerUtil.getFakeGroovyFilePath()));
			if (!fileStore.fetchInfo().isDirectory() && fileStore.fetchInfo().exists()) {
				input = new FileStoreEditorInput(fileStore);
			}

			editor.getDocumentProvider().connect(input);
			document = editor.getDocumentProvider().getDocument(input);
			editor.init(site, input);

			editor.createPartControl(editorcomposite);
			editor.createJavaSourceViewerConfiguration();

			if (editor.getGroovyCompilationUnit() != null) {
				// FoxBPMGroovyUtil.addToVariableScope(editor.getGroovyCompilationUnit(),
				// null);
			}

		} catch (PartInitException e) {
			e.printStackTrace();
		} catch (CoreException e1) {
			e1.printStackTrace();
		}

		viewer = (ProjectionViewer) editor.getViewer();

		// Set up content assist in the viewer
		IHandler handler = new AbstractHandler() {

			@Override
			public Object execute(ExecutionEvent event) throws ExecutionException {
				if (viewer.canDoOperation(ISourceViewer.CONTENTASSIST_PROPOSALS)) {
					viewer.doOperation(ISourceViewer.CONTENTASSIST_PROPOSALS);
				}
				return null;
			}
		};

		IHandlerService handlerService = (IHandlerService) workbench.getAdapter(IHandlerService.class);
		fHandlerActivation = handlerService.activateHandler(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS, handler);
	}

	@Override
	protected void okPressed() {
		if (expression != null) {
			expression = FoxBPMFactory.eINSTANCE.createExpression();
		}
		ModelUtil.setID(expression);
		expression.setName(displaytext.getText());
		expression.setValue(document.get());
		setExpression(expression);
		if (editingDomain != null) {
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
				@Override
				protected void doExecute() {
					if (formParam != null)
						formParam.setExpression(expression);
					if (potentialStarter != null)
						potentialStarter.setExpression(expression);
					if (commandParamTo != null)
						commandParamTo.setExpression(expression);
				}
			});
		}
		super.okPressed();

		close();
	}

	@SuppressWarnings("unchecked")
	private Group crateGroupDefine(Composite orgComposite) {
		ArrayList<GroupDefine> groupDefines = null;
		try {
			String jsonString = FileUtil.readFile2StringUTF8(FoxBPMDesignerUtil.getCachePath() + "/allGroupDefinitions.data");
			JsonDataUtil instance = JsonDataUtil.getInstance();
			groupDefines = (ArrayList<GroupDefine>) instance.analysisJsonToObj(jsonString, GroupDefine.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null == groupDefines) {
			groupDefines = new ArrayList<GroupDefine>();
		}

		// 默认放入用户
		GroupDefine userDefine = new GroupDefine();
		userDefine.setName("用户");
		userDefine.setType("user");
		groupDefines.add(0, userDefine);

		Group radioGroup = new Group(orgComposite, SWT.SHADOW_ETCHED_OUT);
		radioGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		radioGroup.setLayout(new GridLayout(groupDefines.size(), false));
		Button checkBox = null;
		for (GroupDefine groupDefine : groupDefines) {
			checkBox = new Button(radioGroup, SWT.RADIO);
			checkBox.setText(groupDefine.getName());
			checkBox.setData("type", groupDefine.getType());
		}
		return radioGroup;
	}

	@Override
	public boolean close() {
		super.close();

		site.setSelectionProvider(diagramEditorSelectionProvider);

		IHandlerService handlerService = (IHandlerService) workbench.getAdapter(IHandlerService.class);
		handlerService.deactivateHandler(fHandlerActivation);
		// editor.setAction("find", null) ;
		document.set("");
		editor.dispose();

		return true;
	}

	@Override
	public int open() {
		if (PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor() != null) {
			return super.open();
		} else {
			MessageDialog.openError(Display.getDefault().getActiveShell(), "提示", "打开错误");
			return 0;
		}
	}

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	private void init() {
		if (expression != null) {
			document.set(expression.getValue());
		} else {
			document.set(textcontrol.getText());
		}
	}

	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextDisplaytextObserveWidget = WidgetProperties.text(SWT.Modify).observe(displaytext);
		IObservableValue expressionNameObserveValue = EMFObservables.observeValue(expression, Literals.EXPRESSION__NAME);
		bindingContext.bindValue(observeTextDisplaytextObserveWidget, expressionNameObserveValue, null, null);
		//
		return bindingContext;
	}

	/**
	 * 加载dataVariableConfig对象
	 */
	private void loadDataVariableConfig() {
		Resource resource = EMFUtil.readEMFFile(FoxBPMDesignerUtil.getDataVariableConfigPath());
		if (resource != null) {
			dataVariableConfig = (DataVariableConfig) resource.getContents().get(0);
		}

	}

	/**
	 * 映射dataVariableType到FoxBPMDataVariable
	 */
	private void MapFoxBPMDataVariableWithType() {
		if (dataVariableConfig == null) {
			return;
		}
		typeToDataVariableMap = new HashMap<String, FoxBPMDataVariable>();
		DataVariableType dataVariableType = dataVariableConfig.getDataVariableType();
		EList<FoxBPMDataVariable> FoxBPMDataVariableList = dataVariableConfig.getFoxBPMDataVariable();
		for (Type type : dataVariableType.getType()) {
			String type_id = type.getId();
			for (FoxBPMDataVariable FoxBPMDataVariable : FoxBPMDataVariableList) {
				if (type_id.equals(FoxBPMDataVariable.getType())) {
					typeToDataVariableMap.put(type_id, FoxBPMDataVariable);
					break;
				}
			}
		}
	}

	private class StyledFunctionTreeLabelProvider extends StyledCellLabelProvider implements ILabelProvider {

		@Override
		public Image getImage(Object element) {
			return null;
		}

		@Override
		public String getText(Object element) {
			DataVariableDef dataVariableDef = (DataVariableDef) element;
			return dataVariableDef.getName() + " " + dataVariableDef.getDataType() + " " + dataVariableDef.getValue();
		}

		@Override
		public void update(ViewerCell cell) {
			if (cell.getElement() instanceof DataVariableDef) {
				DataVariableDef dataVariableDef = (DataVariableDef) cell.getElement();
				StyledString styledString = new StyledString();
				// 正常样式
				styledString.append(dataVariableDef.getName() + " " + dataVariableDef.getDataType() + " ");
				// 特殊样式
				styledString.append(dataVariableDef.getValue(), StyledString.DECORATIONS_STYLER);
				cell.setText(styledString.getString());
				cell.setStyleRanges(styledString.getStyleRanges());
			}
		}

	}

	private class FuncitonTreeContentProvider implements ITreeContentProvider {

		@Override
		public void dispose() {

		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

		}

		@Override
		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof FoxBPMDataVariableImpl) {
				FoxBPMDataVariableImpl FoxBPMDataVariable = (FoxBPMDataVariableImpl) parentElement;
				return FoxBPMDataVariable.getDataVariableDef().toArray();
			}
			return EMPTY_ARRAY;
		}

		@Override
		public Object getParent(Object element) {
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			return getChildren(element).length > 0;
		}

	}
	
	private static class TreeContentProvider implements ITreeContentProvider {
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof java.util.List) {
				@SuppressWarnings("rawtypes")
				java.util.List list = (java.util.List) inputElement;
				return list.toArray();
			} else {
				return new Object[0];
			}
		}

		public Object[] getChildren(Object parentElement) {
			ITreeElement treeElement = (ITreeElement) parentElement;
			java.util.List<ITreeElement> list = treeElement.getChildren();
			if (list == null || list.isEmpty()) {
				return new Object[0];
			} else {
				return list.toArray();
			}
		}

		public Object getParent(Object element) {
			return null;
		}

		public boolean hasChildren(Object element) {
			DataVarTo dataVarTo = (DataVarTo) element;
			return getChildren(dataVarTo).length > 0;
		}
	}
	
	private static class ViewerLabelProvider extends StyledCellLabelProvider implements ILabelProvider {
		public Image getImage(Object element) {
			// String image1 = ISharedImages.IMG_OBJS_TASK_TSK;
			Image image = ImageUtil.getImageFromName("/expdialog/user_16_hot.png");
			Image image2 = ImageUtil.getImageFromName("/expdialog/bookprev_16.png");
			Image image3 = ImageUtil.getImageFromName("/expdialog/group_16.png");

			if (element instanceof DataVarTo) {
				DataVarTo dataVarTo = (DataVarTo) element;
				if (dataVarTo.getType().equals("分类")) {
					return image2;
				}
				if (dataVarTo.getType().equals("用户")) {
					return image;
				}
				
				if(dataVarTo.getBizType()!=null && !dataVarTo.getBizType().equals("")) {
					return ImageUtil.getImageFromName("/datavar/" + DataVarUtil.getDataVariableBizType(dataVarTo.getBizType()).getImg());
				}
				
				return image3;
			}
			return null;
		}

		public String getText(Object element) {
			DataVarTo treeElement = (DataVarTo) element;
			return treeElement.getId() + " -- " + treeElement.getType();
		}

		@Override
		public void update(ViewerCell cell) {
			if (cell.getElement() instanceof DataVarTo) {
				DataVarTo d = (DataVarTo) cell.getElement();
				StyledString styledString = new StyledString();
				String decoration = " -- " + DataVarUtil.getDataTypeDefByDataVariableDataType(d.getType()).getName();
				styledString.append(d.getId() == null ? "" : d.getId());
				styledString.append(decoration, StyledString.DECORATIONS_STYLER);
				cell.setText(styledString.getString());
				cell.setImage(getImage(d));
				cell.setStyleRanges(styledString.getStyleRanges());
			}
		}
	}
	
	private void initDataVar(){
		dataVarTos = new ArrayList<DataVarTo>();
		
		DataVarTo dataVarTo2 = new DataVarTo();
		dataVarTo2.setId("私有数据变量");
		dataVarTo2.setType("分类");
		dataVarTo2.setCantbechoose("siyou");
		
		IEditorPart iEditorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if(iEditorPart instanceof BPMN2MultiPageEditor) {
			BPMN2MultiPageEditor bpmn2MultiPageEditor = (BPMN2MultiPageEditor) iEditorPart;
			Resource resource = null;
			try {
				resource = ModelHandlerLocator.getModelHandler(bpmn2MultiPageEditor.getDesignEditor().getModelUri()).getResource();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			java.util.List<DataVariable> dataVariables = BpmnModelUtil.getDataVariable(BpmnModelUtil.getProcess(resource));
			
			for (DataVariable dataVariable : dataVariables) {
				DataVarTo dataVarTo = new DataVarTo();
				dataVarTo.setId(dataVariable.getId());
				if (dataVariable.getExpression() != null) {
					dataVarTo.setValue(dataVariable.getExpression().getValue());
				}

				dataVarTo.setType(DataVarUtil.getDataTypeDefByDataVariableDataType(dataVariable.getDataType()).getName());
//				dataVarTo.setDoc(dataVariable.getDocumentation().get(0).getValue());
				dataVarTo2.addChild(dataVarTo);
			}
			
			
			//循环添加分类
			for (DataVariableBizType dataVariableBizType : DataVarUtil.getDataVariableBizTypes()) {
				DataVarTo dataVarTo = new DataVarTo();
				dataVarTo.setId(dataVariableBizType.getTypeName());
				dataVarTo.setCantbechoose("bizType");
				dataVarTo.setType("全局变量");
				dataVarTo.setBizType(dataVariableBizType.getTypeId());
				
				for (DataVariable dataVariable : BpmnModelUtil.getDataVariablesByBizType(BpmnModelUtil.getProcess(resource), dataVariableBizType.getTypeId())) {
					DataVarTo datavarTo = new DataVarTo();
					datavarTo.setId(dataVariable.getId());
					datavarTo.setValue("${" + dataVariable.getId() + "}");
					datavarTo.setType(DataVarUtil.getDataTypeDefByDataVariableDataType(dataVariable.getDataType()).getName());
					if (dataVariable.getDocumentation() != null && dataVariable.getDocumentation().size() > 0) {
						datavarTo.setDoc(dataVariable.getDocumentation().get(0).getValue());
					}
					datavarTo.setBizType(dataVariableBizType.getTypeId());
					dataVarTo.addChild(datavarTo);
				}
				
				dataVarTos.add(dataVarTo);
			}
		}
	}
}
