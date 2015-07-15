package org.foxbpm.bpmn.designer.ui.connector.definition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.foxbpm.bpmn.designer.ui.custom.TableViewerSection;
import org.foxbpm.bpmn.designer.ui.custom.actions.ViewerAddAction;
import org.foxbpm.bpmn.designer.ui.custom.actions.ViewerDeleteAction;
import org.foxbpm.bpmn.designer.ui.custom.actions.ViewerDownAction;
import org.foxbpm.bpmn.designer.ui.custom.actions.ViewerUpAction;
import org.foxbpm.bpmn.designer.ui.utils.DefinitionConnectorUtil;
import org.foxbpm.model.config.connector.ConnectorDefinition;
import org.foxbpm.model.config.connector.ConnectorFactory;
import org.foxbpm.model.config.connector.Input;
import org.foxbpm.model.config.connector.Items;
import org.foxbpm.model.config.connector.Page;
import org.foxbpm.model.config.connector.Select;
import org.foxbpm.model.config.connector.Widget;
import org.foxbpm.model.config.connector.WidgetExpression;

public class ConnectorWidgetsDialog extends TitleAreaDialog {
	private Text idText;
	private Text nameText;
	private Combo typeCombo;
	private Combo inputCombo;
	private Text descText;
	private List<Input> list;
	private ConnectorFactory ffactory;
	private ConnectorDefinition connector;
	private Page page;
	private boolean isEditor;
	private Widget widget;
	private Button okButton;
	private Button calButton;
	private Composite stackComposite;
	private TableViewerSection tableViewerSection;
	private Composite selectComposite;
	private TableViewer tableViewer;
	private StackLayout stackLayout;
//	private ExpressionComboViewer expressionComboViewer;
	
	@Override
	protected void okPressed() {
		if(setValue())	 
			super.okPressed();
	}

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public ConnectorWidgetsDialog(Shell parentShell,
			ConnectorDefinition connector, Page page, boolean isEditor, Widget widget) {
		super(parentShell);
		setHelpAvailable(false);
		this.list = connector.getInput();	//获取输入变量
		this.connector = connector;
		this.page = page;
		this.isEditor = isEditor;
		this.widget = widget;
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setMessage("连接器部件编辑");
		setTitle("部件");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(2, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("部件编号");
		
		idText = new Text(container, SWT.BORDER);
		idText.setEditable(false);
		idText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_1.setText("部件类型");
		
		typeCombo = new Combo(container, SWT.READ_ONLY);
		typeCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				widget = Constant.WidgetConstant.getWidgetType(typeCombo.getText());
				if(widget instanceof Select) {
					stackLayout.topControl = selectComposite;
					stackComposite.layout();
					tableViewer.setInput(((Select)widget).getItems());
				}
			}
		});
		typeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		
		Label lblNewLabel_2 = new Label(container, SWT.NONE);
		lblNewLabel_2.setText("输入参数");	
		
		inputCombo = new Combo(container, SWT.READ_ONLY);
		inputCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label lblNewLabel_3 = new Label(container, SWT.NONE);
		lblNewLabel_3.setText("显示名称");
		
		nameText = new Text(container, SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label lblNewLabel_4 = new Label(container, SWT.NONE);
		lblNewLabel_4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_4.setText("表达式");
		
		descText = new Text(container, SWT.BORDER | SWT.READ_ONLY);
		descText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ExpressionDialog dialog = new ExpressionDialog(getShell(), 
						descText.getText().trim());
				if(dialog.open() == Dialog.OK) {
					descText.setText(dialog.getValue());
				}
			}
		});
//		gd_text_2.heightHint = 84;
//		combo_1.setLayoutData(gd_text_2);
		descText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		stackComposite = new Composite(container, SWT.NONE);
		stackLayout = new StackLayout();
		stackComposite.setLayout(stackLayout);
		stackComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 2, 1));
		
		selectComposite = new Composite(stackComposite, SWT.NONE);
		GridLayout gl_selectComposite = new GridLayout(1, false);
		gl_selectComposite.marginWidth = 0;
		gl_selectComposite.marginHeight = 0;
		selectComposite.setLayout(gl_selectComposite);
		
		tableViewerSection = new TableViewerSection(selectComposite, createColumnMap());
		tableViewerSection.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tableViewer=tableViewerSection.getTableViewer();
		tableViewer.setContentProvider(new ArrayContentProvider());
		tableViewer.setLabelProvider(new ItemLabelProvider(tableViewer));
		
		//初始化数据
		initValue();
		
		return area;
	}
	
	private void initValue() {
		idText.setText(autoWidgetId());
		typeCombo.setItems(Constant.WidgetConstant.getArray());
		typeCombo.select(0);
		inputCombo.setItems(buildItems(list));
		
		if(isEditor) {
			idText.setText(widget.getId().trim());
			idText.setEditable(false);
			typeCombo.setText(Constant.WidgetConstant.getTypeWidget(widget));
			nameText.setText(widget.getName());
			inputCombo.setText(widget.getInputId());
			descText.setText(widget.getWidgetExpression().getExpressionValue());
		} 
		
		if(inputCombo.getText() == null || inputCombo.getText().equals("")) {
//			getButton(IDialogConstants.OK_ID).setEnabled(false);
		}
		
		if(widget == null)
			widget = Constant.WidgetConstant.getWidgetType(typeCombo.getText());
		
		tableViewerSection.configEditingSupport(getEditListMap());
	}
	
	private boolean setValue() {
		if(inputCombo.getText().equals("")) {
			setErrorMessage("请选择输入参数");
			return false;
		}
		if(idText.getText().equals("")) {
			setErrorMessage("请输入编号");
			return false;
		}
		if(nameText.getText().equals("")) {
			setErrorMessage("请输入名称");
			return false;
		}
		if(!(typeCombo.getText().equals("Text") || typeCombo.getText().equals("Select"))) {
			setErrorMessage("目前FixFlow暂时仅支持Text和Select部件类型");
			return false;
		}
		if(!isEditor) {
			EList<Page> pages = connector.getPage();
			if(pages != null && pages.size() > 0)
				for (Iterator iterator = pages.iterator(); iterator.hasNext();) {
					Page page = (Page) iterator.next();
					EList<Widget> widgets = page.getWidget();
					if(widgets != null && widgets.size() > 0)
						for (Iterator iterator2 = widgets.iterator(); iterator2
								.hasNext();) {
							Widget widget2 = (Widget) iterator2.next();
							if(widget2.getId().equals(idText.getText().trim())) {
								setErrorMessage("已存在相同编号的组件");
								return false;
							}
						}
				}
			else {
				EList<Widget> widgets = page.getWidget();
				if(widgets != null && widgets.size() > 0)
					for (Iterator iterator2 = widgets.iterator(); iterator2
							.hasNext();) {
						Widget widget2 = (Widget) iterator2.next();
						if(widget2.getId().equals(idText.getText().trim())) {
							setErrorMessage("已存在相同编号的组件");
							return false;
						}
					}
			}
		}
		
		setErrorMessage(null);	
		
		widget.setId(idText.getText().trim());
		widget.setName(nameText.getText().trim());
		widget.setInputId(inputCombo.getText());
		
		WidgetExpression expression = DefinitionConnectorUtil.createWidgetExpression();
		expression.setExpressionValue(descText.getText().trim());
		widget.setWidgetExpression(expression);
		
		return true;
	}
	
	/**
	 * 自动填充widget编号
	 * @return
	 */
	private String autoWidgetId() {
		List<String> widgetIds = new ArrayList<String>();
		EList<Page> pages = connector.getPage();
		if(pages != null && pages.size() > 0)
			for (Iterator iterator = pages.iterator(); iterator.hasNext();) {
				Page page = (Page) iterator.next();
				EList<Widget> widgets = page.getWidget();
				if(widgets != null && widgets.size() > 0)
					for (Iterator iterator2 = widgets.iterator(); iterator2
							.hasNext();) {
						Widget widget2 = (Widget) iterator2.next();
						if(!widgetIds.contains(widget2.getId())
								&& widget2.getId().startsWith("Widget_"))
							widgetIds.add(widget2.getId());
					}
			}
		else {
			EList<Widget> widgets = page.getWidget();
			if(widgets != null && widgets.size() > 0)
				for (Iterator iterator2 = widgets.iterator(); iterator2
						.hasNext();) {
					Widget widget2 = (Widget) iterator2.next();
					if(!widgetIds.contains(widget2.getId())
							&& widget2.getId().startsWith("Widget_"))
						widgetIds.add(widget2.getId());
				}
		}
		
		if(widgetIds.size() <= 0) {
			return "Widget_0";
		}
		
		String maxWidgetId = Collections.max(widgetIds, new Comparator<String>() {	//取最大的
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		
		return maxWidgetId.substring(0, maxWidgetId.lastIndexOf("_") + 1) +
				(Integer.parseInt(maxWidgetId.substring(maxWidgetId.lastIndexOf("_") + 1)) + 1);
	}

	private String[] buildItems(List<Input> list) {
		String[] array = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i).getId();
		}
		return array;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		okButton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		okButton.setText("确定");
		calButton = createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
		calButton.setText("取消");
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(454, 441);
	}

	public Widget getValue() {
		return widget;
	}
	
	/**
	 * @return
	 */
	private Map<String, Object> createColumnMap() {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("colNum", 2);
		paraMap.put("colWidths", new int[]{150, 150});
		paraMap.put("colNames", new String[]{"显示名称", "实际值"});
		paraMap.put("actions", getActions());
		return paraMap;
	}
	
	private List<Map<String, Object>> getEditListMap() {
		EditingSupport nameEditingSupport = new EditingSupport(tableViewerSection.getTableViewer()) {

			@Override
			protected void setValue(Object element, Object value) {
				Items items = (Items) element;
				if (items.getName().equals((String) value))
					return;
				items.setName((String) value);
				tableViewerSection.getTableViewer().refresh();
//				resizeTableColumn(tableViewerSection.getTableViewer().getTable());
			}

			@Override
			protected Object getValue(Object element) {
				Items items = (Items) element;
				return items.getName();
			}

			@Override
			protected CellEditor getCellEditor(Object element) {
				return new TextCellEditor(tableViewerSection.getTableViewer().getTable());
			}

			@Override
			protected boolean canEdit(Object element) {
				return element instanceof Items;
			}
		};

		EditingSupport valueEditingSupport = new EditingSupport(tableViewerSection.getTableViewer()) {

			@Override
			protected void setValue(Object element, Object value) {
				Items items = (Items) element;
				if (items.getValue().equals((String) value))
					return;
				items.setValue((String) value);
				tableViewerSection.getTableViewer().refresh();
//				resizeTableColumn(tableViewerSection.getTableViewer().getTable());
			}

			@Override
			protected Object getValue(Object element) {
				Items items = (Items) element;
				return items.getValue();
			}

			@Override
			protected CellEditor getCellEditor(Object element) {
				return new TextCellEditor(tableViewerSection.getTableViewer().getTable());
			}

			@Override
			protected boolean canEdit(Object element) {
				return element instanceof Items;
			}
		};
		
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		Map<String, Object> editMap1 = new HashMap<String, Object>();
		editMap1.put("index", 1);
		editMap1.put("editSupport", nameEditingSupport);
		Map<String, Object> editMap2 = new HashMap<String, Object>();
		editMap2.put("index", 2);
		editMap2.put("editSupport", valueEditingSupport);
		
		listMap.add(editMap1);
		listMap.add(editMap2);
		return listMap;
	}
	
	private List<Action> getActions() {
		List<Action> actions = new ArrayList<Action>();
		
		ViewerUpAction upAction = new ViewerUpAction() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				//向上
				TableViewer tableViewer = tableViewerSection.getTableViewer();
				IStructuredSelection selection = (IStructuredSelection) tableViewer.getSelection();
				List<?> selections = selection.toList(); 
				for (Object obj : selections) {
					Items items = (Items) obj;
					int idx = ((List<Items>) tableViewer.getInput()).indexOf(items);
					if (idx != 0) {
						((List<Items>) tableViewer.getInput()).remove(items);
						((List<Items>) tableViewer.getInput()).add(idx - 1, items);
					}
				}
				tableViewer.refresh();
			}
		};
		
		ViewerDownAction downAction = new ViewerDownAction() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				//向下
				TableViewer tableViewer = tableViewerSection.getTableViewer();
				IStructuredSelection selection = (IStructuredSelection) tableViewer.getSelection();
				List<?> selections = selection.toList(); 
				Collections.reverse(selections);
				for (Object obj : selections) {
					Items items = (Items) obj;
					int idx = ((List<Items>) tableViewer.getInput()).indexOf(items);
					if (idx != ((List<Items>) tableViewer.getInput()).size() - 1) {
						((List<Items>) tableViewer.getInput()).remove(items);
						((List<Items>) tableViewer.getInput()).add(idx + 1, items);
					}
				}
				tableViewer.refresh();
			}
		};
		
		ViewerAddAction viewerAddAction = new ViewerAddAction() {
			
			@Override
			public void run() {
				TableViewer tableViewer = tableViewerSection.getTableViewer();
				Items items = ConnectorFactory.eINSTANCE.createItems();
				items.setName("name");
				items.setValue("value");
				((List<Items>)tableViewer.getInput()).add(items);
				tableViewer.refresh();
			}
		};
		
		ViewerDeleteAction viewerDeleteAction = new ViewerDeleteAction() {
			
			@Override
			public void run() {
				TableViewer tableViewer = tableViewerSection.getTableViewer();
				IStructuredSelection iSelection = (IStructuredSelection) tableViewer.getSelection();
				if(!iSelection.isEmpty()) {
					boolean b = MessageDialog.openConfirm(null, "提示", "确定要删除吗？");
					if(b) {
						((List<Items>)tableViewer.getInput()).removeAll(iSelection.toList());
						tableViewer.refresh();
					}
				}
			}
		};
		
		actions.add(viewerAddAction);
		actions.add(viewerDeleteAction);
		actions.add(upAction);
		actions.add(downAction);
		return actions;
	}

	class ItemLabelProvider extends LabelProvider implements ITableLabelProvider {
		private TableViewer tableViewer;
		
		public ItemLabelProvider(TableViewer tableViewer) {
			super();
			this.tableViewer = tableViewer;
		}
		
		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if(element instanceof Items) {
				Items items = (Items) element;
				switch(columnIndex) {
					case 0:
						return String.valueOf(((List<Items>)tableViewer.getInput()).indexOf(items) + 1);
					case 1:
						return items.getName()==null?"":items.getName();
					case 2:
						return items.getValue()==null?"":items.getValue();
				}
			}
			return null;
		}
		
	}
	
//	public void resizeTableColumn(Table table) {
//		for (TableColumn tc : table.getColumns())
//			tc.pack();
//	}
}
