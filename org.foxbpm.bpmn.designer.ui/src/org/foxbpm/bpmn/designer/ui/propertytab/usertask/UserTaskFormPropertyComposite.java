package org.foxbpm.bpmn.designer.ui.propertytab.usertask;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpmn2.UserTask;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMComposite;
import org.foxbpm.bpmn.designer.ui.expdialog.FoxBPMExpViewer;

public class UserTaskFormPropertyComposite extends AbstractFoxBPMComposite {
	private UserTask userTask;
	private FoxBPMExpViewer optFormViewer;//操作表单
	private FoxBPMExpViewer browseFormViewer;//浏览表单
	private TableViewer formParamsViewer;//表单参数查看器
	//表格中列的索引号
	public static final int PARAM=0;
	public static final int TYPE=1;
	public static final int VALUE=2;
	public static final String[] COLUMN_NAMES=new String[]{"参数","类型","值"};
	public static final String[] PARAM_TYPES=new String[]{"String","Date","int","float"};

	public UserTaskFormPropertyComposite(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public String setDescId() {
		return null;
	}

	@Override
	public Composite createUI(Composite parent) {
		Composite detailComposite=new Composite(parent, SWT.NONE);
		detailComposite.setLayout(new GridLayout(2, false));
		detailComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label optFormLabel=new Label(detailComposite, SWT.NONE);
		optFormLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		optFormLabel.setText("操作表单");
		optFormViewer=new FoxBPMExpViewer(detailComposite, SWT.BORDER);
		Control control = optFormViewer.getControl();
		control.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label browseFormLabel=new Label(detailComposite, SWT.NONE);
		browseFormLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		browseFormLabel.setText("浏览表单");
		browseFormViewer=new FoxBPMExpViewer(detailComposite, SWT.BORDER);
		Control control_1 = browseFormViewer.getControl();
		control_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		ViewForm viewForm = new ViewForm(detailComposite, SWT.BORDER);
		GridData gd_viewForm = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		gd_viewForm.heightHint = 200;
		viewForm.setLayoutData(gd_viewForm);
		ToolBar toolBar=new ToolBar(viewForm, SWT.NONE);
		final ToolItem addItem=new ToolItem(toolBar, SWT.PUSH);
		addItem.setToolTipText("增加参数");
		addItem.setText("+");
		final ToolItem deleteItem=new ToolItem(toolBar, SWT.PUSH);
		deleteItem.setToolTipText("删除参数");
		deleteItem.setText("x");
		viewForm.setTopRight(toolBar);
		
		Label formParaLabel=new Label(viewForm, SWT.NULL);
		formParaLabel.setText("表单参数");
		viewForm.setTopLeft(formParaLabel);
		
		Composite tableComposite=new Composite(viewForm, SWT.NONE);
		tableComposite.setLayout(new GridLayout(1, false));
		tableComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		//创建tableViewer对象
		formParamsViewer=new TableViewer(tableComposite,SWT.FULL_SELECTION);
		final Table formParamsTable=formParamsViewer.getTable();
		//创建表头
		for (int i = 0; i < COLUMN_NAMES.length; i++) {
			TableColumn tableColumn=new TableColumn(formParamsTable, SWT.CENTER);
			tableColumn.setText(COLUMN_NAMES[i]);
			if (i==0) {
				tableColumn.setWidth(200);
			}else if (i==1) {
				tableColumn.setWidth(150);
			}else if (i==2) {
				tableColumn.setWidth(350);
			}
		}
		formParamsTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		//设置表头和表格线可见
		formParamsTable.setHeaderVisible(true);
		formParamsTable.setLinesVisible(true);
		formParamsViewer.setContentProvider(new ArrayContentProvider());
		formParamsViewer.setLabelProvider(new FormParamLabelProvider()); 
		formParamsViewer.setInput(new ArrayList<FormParamsEO>());
		
		//设置列属性
		formParamsViewer.setColumnProperties(COLUMN_NAMES);
		//设置单元格编辑器对象数组
		CellEditor[] cellEditors=new CellEditor[3];
		cellEditors[0]=new TextCellEditor(formParamsTable);
		cellEditors[1]=new ComboBoxCellEditor(formParamsTable, PARAM_TYPES,SWT.READ_ONLY);
		cellEditors[2]=new TextCellEditor(formParamsTable);
		formParamsViewer.setCellEditors(cellEditors);
		formParamsViewer.setCellModifier(new ICellModifier() {
			
			@Override
			public void modify(Object element, String property, Object value) {
				TableItem tableItem=(TableItem)element;
				FormParamsEO formParamsEO=(FormParamsEO)tableItem.getData();
				if (property.equals(COLUMN_NAMES[0])) {
					formParamsEO.setParameter(value.toString());
				}else if (property.equals(COLUMN_NAMES[1])) {
					int selectedIndex=(Integer)value;
					if (selectedIndex==-1) {
						return;
					}
					formParamsEO.setType(PARAM_TYPES[selectedIndex]);
				}else if (property.equals(COLUMN_NAMES[2])) {
					formParamsEO.setValue(value.toString());
				}
				formParamsViewer.refresh();
			}
			
			@Override
			public Object getValue(Object element, String property) {
				FormParamsEO formParamsEO=(FormParamsEO)element;
				if (property.equals(COLUMN_NAMES[0])) {
					return formParamsEO.getParameter();
				}else if (property.equals(COLUMN_NAMES[1])) {
					return getTypeIndex(formParamsEO.getType());
				}else if (property.equals(COLUMN_NAMES[2])) {
					return formParamsEO.getValue();
				}
				return null;
			}
			
			@Override
			public boolean canModify(Object element, String property) {
				return true;
			}
			
			/**
			 * @param typeValue
			 * @return 选中下拉框的索引值
			 */
			private Integer getTypeIndex(String typeValue){
				for (int i = 0; i < PARAM_TYPES.length; i++) {
					if (typeValue.equals(PARAM_TYPES[i])) {
						return i;
					}
				}
				return -1;
			}
		});
		
		viewForm.setContent(tableComposite);
		
		Listener listener=new Listener() {
			
			@Override
			@SuppressWarnings("unchecked")
			public void handleEvent(Event event) {
				if (event.widget==addItem) {
					List<FormParamsEO> fomFormParamsEOs=(List<FormParamsEO>)formParamsViewer.getInput();
					fomFormParamsEOs.add(new FormParamsEO("","String",""));
					formParamsViewer.refresh();
				}else if (event.widget==deleteItem) {
					if (formParamsTable.getSelectionIndex()>-1) {
						List<FormParamsEO> fomFormParamsEOs=(List<FormParamsEO>)formParamsViewer.getInput();
						fomFormParamsEOs.remove(formParamsTable.getSelectionIndex());
						formParamsViewer.refresh();
					}
				}
			}
		};
		addItem.addListener(SWT.Selection,listener);
		deleteItem.addListener(SWT.Selection, listener);
		
		return parent;
	}

	@Override
	public void createUIBindings(EObject eObject) {
		userTask=(UserTask)eObject;
		
	}
	
	private class FormParamsEO{
		private String parameter;//参数
		private String type;//类型
		private String value;//值
		
		public FormParamsEO(){
			
		}
		
		public FormParamsEO(String parameter){
			this.parameter=parameter;
		}
		public FormParamsEO(String parameter,String type,String value){
			this(parameter);
			this.type=type;
			this.value=value;
		}
		/**
		 * @return the parameter
		 */
		public String getParameter() {
			return parameter;
		}
		/**
		 * @param parameter the parameter to set
		 */
		public void setParameter(String parameter) {
			this.parameter = parameter;
		}
		/**
		 * @return the type
		 */
		public String getType() {
			return type;
		}
		/**
		 * @param type the type to set
		 */
		public void setType(String type) {
			this.type = type;
		}
		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}
		/**
		 * @param value the value to set
		 */
		public void setValue(String value) {
			this.value = value;
		}

//		@Override
//		public int hashCode() {
//			final int prime = 31;
//			int result = 1;
//			result = prime * result + ((parameter == null) ? 0 : parameter.hashCode());
//			return result;
//		}
//
//		@Override
//		public boolean equals(Object obj) {
//			if (this==obj) {
//				return true;
//			}
//			if (obj instanceof FormParamsEO) {
//				if (getClass()!=obj.getClass()) {
//					return false;
//				}
//				FormParamsEO other=(FormParamsEO)obj;
//				return other.getParameter().equals(parameter);
//			}
//			return false;
//		}
		
	}
	
	private class FormParamLabelProvider extends LabelProvider implements ITableLabelProvider{

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			FormParamsEO formParamsEO=(FormParamsEO)element;
			if (columnIndex==PARAM) {
				return formParamsEO.getParameter();
			}else if (columnIndex==TYPE) {
				return formParamsEO.getType();
			}else if (columnIndex==VALUE) {
				return formParamsEO.getValue();
			}
			return "";
		}
		
	}
	

}
