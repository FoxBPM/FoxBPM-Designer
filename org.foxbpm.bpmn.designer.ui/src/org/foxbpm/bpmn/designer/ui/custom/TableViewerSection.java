package org.foxbpm.bpmn.designer.ui.custom;


import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.foxbpm.bpmn.designer.ui.utils.WidgetsUtil;

public class TableViewerSection extends Composite {
	private Composite composite;
	private TableViewer tableViewer;
	private Table table;
	private TableColumn tblclmnNewColumn;
	private TableViewerColumn tableViewerColumn;
	private Section section;
	private int columnNum;
	private String[] columnName;
	private String title;
	private int[] columnWidth;
	private ToolBarManager toolBarManager;
	private List<Action> actions;
	private String style;

	/**
	 * 
	 * @param parent
	 * @param paraMap colNum 列数 colWidths 列宽 colNames 列名 actions 按钮list
	 * @param editListMap eidtingSupportMap
	 * @wbp.parser.constructor
	 */
	@SuppressWarnings("unchecked")
	public TableViewerSection(Composite parent, Map<String, Object> paraMap) {
		super(parent, SWT.NONE);
		//为了WB展现这么写
		if(paraMap!=null) {
			this.columnName = (String[]) (paraMap.get("colNames")==null?new String[]{}:paraMap.get("colNames"));
			this.columnNum = columnName.length;
//			this.columnNum = (Integer) (paraMap.get("colNum")==null?0:paraMap.get("colNum"));
			this.columnWidth = (int[]) (paraMap.get("colWidths")==null?new int[]{}:paraMap.get("colWidths"));
			this.actions = (List<Action>) (paraMap.get("actions")==null?Collections.EMPTY_LIST:paraMap.get("actions"));
			this.style = (String) (paraMap.get("style")==null?"":paraMap.get("style"));
		}else {
			this.columnNum = 0;
			this.columnName = new String[]{};
			this.columnWidth = new int[]{};
			this.actions = Collections.EMPTY_LIST;
			this.style = "";
		}
		drawUI();
	}

	public void drawUI() {
		FormToolkit formToolkit = new FormToolkit(Display.getCurrent());
		GridLayout gl_composite_1 = new GridLayout(1, false);
		gl_composite_1.verticalSpacing = 0;
		gl_composite_1.marginWidth = 0;
		gl_composite_1.marginHeight = 0;
		gl_composite_1.horizontalSpacing = 0;
		this.setLayout(gl_composite_1);
		this.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));
		formToolkit.adapt(this);
		formToolkit.paintBordersFor(this);
		section = formToolkit.createSection(this, Section.TITLE_BAR);
		section.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		section.setText(title==null?"":title);
		section.setExpanded(true);

		toolBarManager = new ToolBarManager(SWT.FLAT);
		ToolBar toolbar = toolBarManager.createControl(section);
		section.setTextClient(toolbar);

		composite = new Composite(section, SWT.NONE);
		formToolkit.adapt(composite);
		formToolkit.paintBordersFor(composite);
		section.setClient(composite);
		GridLayout gl_composite = new GridLayout(1, false);
		gl_composite.marginWidth = 0;
		gl_composite.marginHeight = 0;
		composite.setLayout(gl_composite);

		/**
		 * 为了WB展现这里要改的
		 */
		if(style.equals("check")) {
			tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI | SWT.CHECK);
		}else {
			tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		}

		table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setBounds(0, 0, 85, 85);
		table.addListener(SWT.MeasureItem, new Listener() {
			public void handleEvent(Event event) {
				// 设置行高度
				event.height = (int) Math.floor(event.gc.getFontMetrics().getHeight() * 1.5);
			}
		});
		formToolkit.paintBordersFor(table);

		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setText("序号");
		tblclmnNewColumn.setWidth(50);
		
		for (int i = 0; i < columnNum; i++) {
			tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
			tblclmnNewColumn = tableViewerColumn.getColumn();
			tblclmnNewColumn.setText(columnName[i]);
			tblclmnNewColumn.setWidth(columnWidth[i]);
			tableViewerColumn.setEditingSupport(new EditingSupport(tableViewer) {
				
				@Override
				protected void setValue(Object element, Object value) {
					
				}
				
				@Override
				protected Object getValue(Object element) {
					return null;
				}
				
				@Override
				protected CellEditor getCellEditor(Object element) {
					return null;
				}
				
				@Override
				protected boolean canEdit(Object element) {
					return false;
				}
			});
		}

		//添加toolbar
		for (Action action : actions) {
			toolBarManager.add(action);
		}
		toolBarManager.update(true);
	}

	/**
	 * 动态加载editsupport
	 */
	public void configEditingSupport(List<Map<String, Object>> editListMap) {
		TableViewerColumn[] tableViewerColumns = WidgetsUtil.getTableViewerColumns(tableViewer);
		for (Map<String, Object> editMap : editListMap) {
			tableViewerColumns[(Integer) editMap.get("index")].setEditingSupport((EditingSupport) editMap.get("editSupport"));
		}
	}

	public TableViewer getTableViewer() {
		return tableViewer;
	}

	public void setTableViewer(TableViewer tableViewer) {
		this.tableViewer = tableViewer;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public ToolBarManager getToolBarManager() {
		return toolBarManager;
	}
}
