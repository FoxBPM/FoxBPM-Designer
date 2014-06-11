package org.foxbpm.bpmn.designer.ui.expdialog;

import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
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
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jdt.ui.PreferenceConstants;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.ide.FileStoreEditorInput;
import org.eclipse.ui.texteditor.ChainedPreferenceStore;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.foxbpm.bpmn.designer.base.utils.FoxBPMDesignerUtil;
import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage.Literals;

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

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 * @wbp.parser.constructor
	 */
	public FoxBPMExpDialog(Shell parentShell) {
		super(parentShell);
		setShellStyle(SWT.DIALOG_TRIM | SWT.RESIZE | SWT.PRIMARY_MODAL);
	}

	public FoxBPMExpDialog(Shell parentShell, Expression expression, Text text) {
		super(parentShell);
		setShellStyle(SWT.DIALOG_TRIM | SWT.RESIZE | SWT.PRIMARY_MODAL);
		this.expression = expression;
		if(this.expression == null) {
			this.expression = FoxBPMFactory.eINSTANCE.createExpression();
			this.expression.setName("");
			this.expression.setValue("");
		}
		this.textcontrol = text;
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

		Composite orgComposite = new Composite(container, SWT.NONE);
		orgComposite.setLayout(new GridLayout(1, false));
		orgComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));

		Label label = new Label(orgComposite, SWT.NONE);
		label.setText("组织结构");

		TreeViewer treeViewer = new TreeViewer(orgComposite, SWT.BORDER);
		Tree tree = treeViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		Label lblNewLabel = new Label(orgComposite, SWT.NONE);
		lblNewLabel.setText("流程变量");

		ListViewer listViewer = new ListViewer(orgComposite, SWT.BORDER | SWT.V_SCROLL);
		List list = listViewer.getList();
		list.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));

		Composite editorComposite = new Composite(container, SWT.NONE);
		editorComposite.setLayout(new GridLayout(4, false));
		editorComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		Label label_2 = new Label(editorComposite, SWT.NONE);
		label_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_2.setText("显示名称");

		displaytext = new Text(editorComposite, SWT.BORDER);
		displaytext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label label_3 = new Label(editorComposite, SWT.NONE);
		label_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_3.setText("脚本引擎");

		Combo combo = new Combo(editorComposite, SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Composite toolbarComposite = new Composite(editorComposite, SWT.NONE);
		toolbarComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 4, 1));
		toolbarComposite.setLayout(new GridLayout(2, false));

		createEditor(editorComposite);

		createToolBar(toolbarComposite);

		Composite docComposite = new Composite(container, SWT.NONE);
		docComposite.setLayout(new GridLayout(1, false));
		docComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));

		Label lblNewLabel_1 = new Label(docComposite, SWT.NONE);
		lblNewLabel_1.setBounds(0, 0, 61, 17);
		lblNewLabel_1.setText("分类");

		ListViewer listViewer_1 = new ListViewer(docComposite, SWT.BORDER | SWT.V_SCROLL);
		List list_1 = listViewer_1.getList();
		list_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));

		Label label_1 = new Label(docComposite, SWT.NONE);
		label_1.setText("函数");

		ListViewer listViewer_2 = new ListViewer(docComposite, SWT.BORDER | SWT.V_SCROLL);
		List list_2 = listViewer_2.getList();
		list_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));

		Label label_4 = new Label(docComposite, SWT.NONE);
		label_4.setText("文档");

		ListViewer listViewer_3 = new ListViewer(docComposite, SWT.BORDER | SWT.V_SCROLL);
		List list_3 = listViewer_3.getList();
		list_3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));

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
		return new Point(719, 626);
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

//		ToolItem tltmNewItem_Name = new ToolItem(toolBar, SWT.NONE);
//		tltmNewItem_Name.setText("ExpressionName");
//		tltmNewItem_Name.addSelectionListener(new GroovyOperatorSelectionAdapter("//FixFlow_ExpressionName:", document, control));
	}

	private void createEditor(Composite composite) {
		Composite editorcomposite = new Composite(composite, SWT.NONE);
		FillLayout fl_editorcomposite = new FillLayout(SWT.HORIZONTAL);
		editorcomposite.setLayout(fl_editorcomposite);
		editorcomposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 4, 1));

		workbench = PlatformUI.getWorkbench();

		IPreferenceStore store = new ChainedPreferenceStore(new IPreferenceStore[] { PreferenceConstants.getPreferenceStore(), EditorsUI.getPreferenceStore() });

		site = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorSite();

		diagramEditorSelectionProvider = site.getSelectionProvider();

//		IPath path = Path.fromOSString(FoxBPMDesignerUtil.getFakeGroovyFilePath());
//		IFile ifile = ResourcesPlugin.getWorkspace().getRoot().getFile(path);

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
		if(expression!=null) {
			expression = FoxBPMFactory.eINSTANCE.createExpression();
		}
		ModelUtil.setID(expression);
		expression.setName(displaytext.getText());
		expression.setValue(document.get());
		setExpression(expression);
		super.okPressed();
		
		close();
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
		if(expression!=null) {
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
}
