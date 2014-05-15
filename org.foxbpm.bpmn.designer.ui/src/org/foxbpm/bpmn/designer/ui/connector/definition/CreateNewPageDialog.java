package org.foxbpm.bpmn.designer.ui.connector.definition;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.foxbpm.model.config.connector.ConnectorDefinition;
import org.foxbpm.model.config.connector.ConnectorFactory;
import org.foxbpm.model.config.connector.ConnectorPackage;
import org.foxbpm.model.config.connector.Input;
import org.foxbpm.model.config.connector.Page;
import org.foxbpm.model.config.connector.Widget;

public class CreateNewPageDialog extends TitleAreaDialog {
	private DataBindingContext m_bindingContext;
	private TableViewer tableViewer;
	private Table table;
	private Text pageidtext;
	private Text pagetitletext;
	private Text pagedesctext;
	private Page page;
	private Button button;
	private Button upButton;
	private Button downButton;
	private Button editorButton;
	private Button removeButton;
	private Button createButton;
	private ConnectorFactory factory;
	// private Outputs outputs;
	private ConnectorDefinition definition;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 * @wbp.parser.constructor
	 */
	public CreateNewPageDialog(Shell parentShell,
	// Outputs outputs,
			ConnectorDefinition definition) {
		super(parentShell);
		setHelpAvailable(false);
		setShellStyle(SWT.CLOSE | SWT.RESIZE | SWT.TITLE);
		// Initialize the model
		ConnectorPackage.eINSTANCE.eClass();
		// Retrieve the default factory singleton
		ConnectorFactory factory = ConnectorFactory.eINSTANCE;
		this.page = factory.createPage();
		this.factory = factory;
		// this.outputs = outputs;
		this.definition = definition;
	}

	/**
	 * 修改时构造函数
	 * 
	 * @param parentShell
	 */
	public CreateNewPageDialog(Shell parentShell, Page page,
	// , Outputs outputs
			ConnectorDefinition definition) {
		super(parentShell);
		setHelpAvailable(false);
		setShellStyle(SWT.RESIZE | SWT.TITLE);
		this.page = page;
		// Initialize the model
		ConnectorPackage.eINSTANCE.eClass();
		// Retrieve the default factory singleton
		ConnectorFactory factory = ConnectorFactory.eINSTANCE;
		this.factory = factory;
		// this.outputs = outputs;
		this.definition = definition;
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("连接器创建");
		Composite container = (Composite) super.createDialogArea(parent);

		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		GridLayout gl_composite = new GridLayout(3, false);
		gl_composite.marginRight = 10;
		gl_composite.marginLeft = 10;
		gl_composite.marginHeight = 10;
		composite.setLayout(gl_composite);

		Label pageidLabel = new Label(composite, SWT.NONE);
		pageidLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		pageidLabel.setText("页面ID");

		pageidtext = new Text(composite, SWT.BORDER);
		pageidtext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		pageidtext.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (button != null)
					button.setEnabled(isRight());
			}
		});

		Label pagetitleLabel = new Label(composite, SWT.NONE);
		pagetitleLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		pagetitleLabel.setText("页标题");

		pagetitletext = new Text(composite, SWT.BORDER);
		pagetitletext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		pagetitletext.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (button != null)
					button.setEnabled(isRight());
			}
		});

		Label pagedescLabel = new Label(composite, SWT.NONE);
		pagedescLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		pagedescLabel.setText("描述");

		pagedesctext = new Text(composite, SWT.BORDER);
		pagedesctext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		pagedesctext.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (button != null)
					button.setEnabled(isRight());
			}
		});

		Label pagedeptLabel = new Label(composite, SWT.NONE);
		pagedeptLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		pagedeptLabel.setText("部件");

		tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				updateButtons();
			}
		});

		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		table.addListener(SWT.MeasureItem, new Listener() {
			public void handleEvent(Event event) {
				// 设置行高度
				event.height = (int) Math.floor(event.gc.getFontMetrics().getHeight() * 1.5);
			}
		});

		TableColumn fieldcolumn = new TableColumn(table, SWT.NONE);
		fieldcolumn.setMoveable(true);
		fieldcolumn.setWidth(144);
		fieldcolumn.setText("部件名称");

		TableColumn datatypecolumn = new TableColumn(table, SWT.NONE);
		datatypecolumn.setMoveable(true);
		datatypecolumn.setWidth(173);
		datatypecolumn.setText("部件类型");

		createCellModifier();

		Composite composite_1 = new Composite(composite, SWT.NONE);
		GridLayout gl_composite_1 = new GridLayout(1, false);
		gl_composite_1.horizontalSpacing = 0;
		gl_composite_1.marginWidth = 0;
		gl_composite_1.marginHeight = 0;
		composite_1.setLayout(gl_composite_1);
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		createButton = new Button(composite_1, SWT.NONE);
		createButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		createButton.setText("创建");
		createButton.addListener(SWT.Selection, new Listener() {

			@SuppressWarnings("unchecked")
			@Override
			public void handleEvent(Event event) {
				// InputParameter inputParameter =
				// factory.createInputParameter();
				//
				// inputParameter.setId("field" +
				// page.getInputParameter().size());
				// inputParameter.setName("name" +
				// page.getInputParameter().size());
				// inputParameter.setDataType("java.lang.String");
				// inputParameter.setControlType("text");
				//
				// ((List<InputParameter>)tableViewer.getInput()).add(inputParameter);
				// page.getInputParameter().add(inputParameter);
				// tableViewer.refresh();
				// tableViewer.editElement(inputParameter, 0);
				// button.setEnabled(isRight());
				// updateButtons();

				// 打开部件编辑对话框
				ConnectorWidgetsDialog widgetsDialog = new ConnectorWidgetsDialog(getShell(), definition, page, false, null);
				if (widgetsDialog.open() == Dialog.OK) {
					Widget widget = widgetsDialog.getValue();
					page.getWidget().add(widget);

					tableViewer.setInput(page.getWidget());
					tableViewer.refresh();

					button.setEnabled(isRight());
					updateButtons();
				}
			}
		});

		editorButton = new Button(composite_1, SWT.NONE);
		editorButton.setText("编辑");
		editorButton.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Widget selectedWidget = (Widget) ((IStructuredSelection) (tableViewer.getSelection())).getFirstElement();
				// 打开部件编辑对话框
				ConnectorWidgetsDialog widgetsDialog = new ConnectorWidgetsDialog(getShell(), definition, page, true, selectedWidget);
				if (widgetsDialog.open() == Dialog.OK) {
					Widget widget = widgetsDialog.getValue();
					EList<Widget> widgets = page.getWidget();

					for (int i = 0; i < widgets.size(); i++) {
						Widget widget2 = widgets.get(i);
						if (widget2.getId().equals(widget.getId())) {
							page.getWidget().remove(widget2);
							page.getWidget().add(i, widget);
							break;
						}
					}

					tableViewer.setInput(page.getWidget());
					tableViewer.refresh();

					button.setEnabled(isRight());
					updateButtons();
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		upButton = new Button(composite_1, SWT.NONE);
		upButton.setText("向上");
		upButton.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				IStructuredSelection selection = (IStructuredSelection) tableViewer.getSelection();
				// InputParameter inputParameter = (InputParameter)
				// selection.getFirstElement();
				// int idx =
				// ((List<InputParameter>)tableViewer.getInput()).indexOf(inputParameter);
				// if (idx != 0) {
				// ((List<InputParameter>)tableViewer.getInput()).remove(inputParameter);
				// ((List<InputParameter>)tableViewer.getInput()).add(idx - 1,
				// inputParameter);
				// }

				Widget widget = (Widget) selection.getFirstElement();
				int idx = ((EList<Widget>) tableViewer.getInput()).indexOf(widget);
				if (idx != 0) {
					((EList<Widget>) tableViewer.getInput()).remove(widget);
					((EList<Widget>) tableViewer.getInput()).add(idx - 1, widget);
				}

				tableViewer.refresh();
				if (selection != null)
					tableViewer.setSelection(selection);
				updateButtons();
			}
		});

		downButton = new Button(composite_1, SWT.NONE);
		downButton.setText("向下");
		downButton.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				IStructuredSelection selection = (IStructuredSelection) tableViewer.getSelection();
				// InputParameter inputParameter = (InputParameter)
				// selection.getFirstElement();
				// int idx =
				// ((List<InputParameter>)tableViewer.getInput()).indexOf(inputParameter);
				// if (idx !=
				// ((List<InputParameter>)tableViewer.getInput()).size() - 1) {
				// ((List<InputParameter>)tableViewer.getInput()).remove(inputParameter);
				// ((List<InputParameter>)tableViewer.getInput()).add(idx + 1,
				// inputParameter);
				// }

				Widget widget = (Widget) selection.getFirstElement();
				int idx = ((EList<Widget>) tableViewer.getInput()).indexOf(widget);
				if (idx != ((EList<Widget>) tableViewer.getInput()).size() - 1) {
					((EList<Widget>) tableViewer.getInput()).remove(widget);
					((EList<Widget>) tableViewer.getInput()).add(idx + 1, widget);
				}

				tableViewer.refresh();
				if (selection != null)
					tableViewer.setSelection(selection);
				updateButtons();
			}
		});

		removeButton = new Button(composite_1, SWT.NONE);
		removeButton.setText("移除");
		removeButton.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				ISelection sel = tableViewer.getSelection();
				if (sel == null)
					return;
				Object[] objs = ((IStructuredSelection) sel).toArray();
				if (objs == null || objs.length == 0)
					return;
				boolean b = MessageDialog.openConfirm(null, "警告", "你确认要删除吗？");
				if (!b)
					return;

				for (int i = 0; i < objs.length; i++) {
					 Input col = (Input) objs[i];
					 ((List<Input>)tableViewer.getInput()).remove(col);
					 page.getWidget().remove(col);

					Widget widget = (Widget) objs[i];
					page.getWidget().remove(widget);

					tableViewer.setInput(page.getWidget());
					tableViewer.refresh();
				}

				button.setEnabled(isRight());
				updateButtons();
			}
		});

		// m_bindingContext = initDataBindings();

		// 初始化
		initValue();

		updateButtons();
		return container;

	}

	private void initValue() {
		pageidtext.setText(page.getId() == null ? "" : page.getId());
		pagetitletext.setText(page.getName() == null ? "" : page.getName());
		pagedesctext.setText(page.getNote() == null ? "" : page.getNote());
		tableViewer.setInput(page.getWidget());
	}

	private void createCellModifier() {
		final String[] sources = new String[] { "java.lang.String" };
		final String[] widgets = new String[] { "text", "textarea" };

		final Map<String, Integer> WIDGETS_MAP = new HashMap<String, Integer>();
		{
			WIDGETS_MAP.put("text", 0);
			WIDGETS_MAP.put("textarea", 1);
		}

		final CellEditor[] cellEditor = new CellEditor[table.getColumnCount()];
		cellEditor[0] = new TextCellEditor(table);

		cellEditor[1] = new ComboBoxViewerCellEditor(table, SWT.READ_ONLY);
		((ComboBoxViewerCellEditor) cellEditor[1]).setContenProvider(new ArrayContentProvider());
		((ComboBoxViewerCellEditor) cellEditor[1]).setLabelProvider(new ViewerLabelProvider());

		// EList<Input> list = null;
		// .createFlowConnectorDefinition().getInput();
		// ((ComboBoxViewerCellEditor)cellEditor[1]).setInput(list);

		tableViewer.setContentProvider(new ArrayContentProvider());
		tableViewer.setLabelProvider(new TableLabelProvider());
		tableViewer.setColumnProperties(new String[] { "ID", "TYPE" });
		tableViewer.setCellEditors(cellEditor);
		// tableViewer.setCellModifier(new ICellModifier() {
		// public void modify(Object element, String property, Object value) {
		// TableItem tableitem = (TableItem) element;
		// // InputParameter inputParameter = (InputParameter)
		// tableitem.getData();
		// if (property.equals("PARAID")) {
		// // inputParameter.setId((String) value);
		// }
		// if (property.equals("PARANAME")) {
		// // inputParameter.setName((String) value);
		// }
		// if (property.equals("ISREQUIRED")) {
		// // inputParameter.setIsRequired(((Boolean)value).booleanValue());
		// }
		// if (property.equals("PARATYPE")) {
		// if(value == null){
		// // inputParameter.setDataType("");
		// }else{
		// // inputParameter.setDataType(((DataTypeDef)value).getTypeValue());
		// }
		// // inputParameter.setDataType(sources[((Integer)value).intValue()]);
		// }
		// if (property.equals("DEPT")) {
		// //
		// inputParameter.setControlType(widgets[((Integer)value).intValue()]);
		// }
		// button.setEnabled(isRight());
		// tableViewer.refresh();
		// }
		// public Object getValue(Object element, String property) {
		// // InputParameter inputParameter = (InputParameter) element;
		//
		// if (property.equals("PARAID")) {
		// // return inputParameter.getId();
		// }
		// if (property.equals("PARANAME")) {
		// // return inputParameter.getName();
		// }
		// if (property.equals("ISREQUIRED")) {
		// // return inputParameter.isIsRequired() ? new Boolean(true) : new
		// Boolean(false);
		// }
		// if (property.equals("PARATYPE")) {
		// // return
		// DataVarUtil.getDataTypeDefByDataVariableDataType(inputParameter.getDataType());
		// }
		// if (property.equals("DEPT")) {
		// // return WIDGETS_MAP.get(inputParameter.getControlType());
		// }
		// return null;
		// }
		// public boolean canModify(Object element, String property) {
		// // return element instanceof InputParameter;
		// return element instanceof Widget;
		// }
		// });
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		button = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		button.setText("确定");
		Button button_1 = createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
		button_1.setText("取消");
		button.setEnabled(isRight());
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(451, 484);
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	@Override
	protected void okPressed() {
		page.setId(pageidtext.getText().trim());
		page.setName(pagetitletext.getText().trim());
		page.setNote(pagedesctext.getText().trim());

		super.okPressed();
	}

	@SuppressWarnings("rawtypes")
	public boolean isRight() {
		boolean allInputParaNamesAreUnique = allParaNamesAreUnique();

		StringBuffer sb = new StringBuffer();
		if (pageidtext.getText() == null || pageidtext.getText().equals(""))
			sb.append("页ID为空");
		if (pagetitletext.getText() == null || pagetitletext.getText().equals("")) {
			if (sb.length() > 0)
				sb.append(",");
			sb.append("页标题为空");
		}
		if (pagedesctext.getText() == null || pagedesctext.getText().equals("")) {
			if (sb.length() > 0)
				sb.append(",");
			sb.append("页描述为空");
		}
		if (tableViewer.getInput() != null) {
			if (((List) tableViewer.getInput()).size() < 1) {
				if (sb.length() > 0)
					sb.append(",");
				sb.append("页面不含任何字段");
			}
		}
		if (tableViewer.getInput() == null) {
			if (sb.length() > 0)
				sb.append(",");
			sb.append("页面不含任何字段");
		}
		if (!allInputParaNamesAreUnique) {
			if (sb.length() > 0)
				sb.append(",");
			sb.append("已存在相同的字段名");
		}
		if (sb.length() > 0) {
			CreateNewPageDialog.this.setErrorMessage(sb.toString());
			return false;
		} else {
			CreateNewPageDialog.this.setErrorMessage(null);
			return true;
		}
	}

	/**
	 * 验证字段名唯一
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private boolean allParaNamesAreUnique() {

		Set<String> parameterNames = new HashSet<String>();
		if (tableViewer.getInput() != null) {
			// for (InputParameter inputParameter :
			// ((List<InputParameter>)tableViewer.getInput())) {
			// if (parameterNames.contains(inputParameter.getId())) {
			// return false;
			// } else {
			// parameterNames.add(inputParameter.getId());
			// }
			// }
		}

		// for (OutputParameter outputParameter : outputs.getOutputParameter())
		// {
		// if (parameterNames.contains(outputParameter.getId())) {
		// return false;
		// } else {
		// parameterNames.add(outputParameter.getId());
		// }
		// }
		return true;
	}

	private class ViewerLabelProvider extends LabelProvider {
		public Image getImage(Object element) {
			return super.getImage(element);
		}

		public String getText(Object element) {
//			DataTypeDef dataTypeDef = (DataTypeDef) element;
//			return dataTypeDef.getName();
			return "test";
		}
	}

	/**
	 * 设置按钮可用性
	 */
	public void updateButtons() {
		Object[] objs = null;
		ISelection sel = tableViewer.getSelection();
		if (sel != null) {
			objs = ((IStructuredSelection) sel).toArray();
		}
		Object selectedPage = ((IStructuredSelection) tableViewer.getSelection()).getFirstElement();
		int index = 0;
		while (selectedPage != null && tableViewer.getElementAt(index) != null && !selectedPage.equals(tableViewer.getElementAt(index))) {
			index++;
		}
		editorButton.setEnabled(selectedPage != null);
		removeButton.setEnabled(selectedPage != null);
		upButton.setEnabled(selectedPage != null && index != 0 && objs != null && objs.length < 2);
		downButton.setEnabled(selectedPage != null && index != tableViewer.getTable().getItemCount() - 1 && objs != null && objs.length < 2);
	}

	/**
	 * 隐藏掉
	 * 
	 * @return
	 */
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		return bindingContext;
	}

	public class TableLabelProvider extends LabelProvider implements ITableLabelProvider {

		/**
		 * 
		 */
		public TableLabelProvider() {
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java
		 * .lang.Object, int)
		 */
		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.
		 * lang.Object, int)
		 */
		@Override
		public String getColumnText(Object element, int columnIndex) {
			Widget widget = (Widget) element;
			switch (columnIndex) {
			case 0:
				return widget.getName();
			default:
				return Constant.WidgetConstant.getTypeWidget(widget);
			}
		}

	}
}
