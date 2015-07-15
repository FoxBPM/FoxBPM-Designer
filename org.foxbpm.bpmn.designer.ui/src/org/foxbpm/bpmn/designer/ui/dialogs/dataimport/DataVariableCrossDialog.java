package org.foxbpm.bpmn.designer.ui.dialogs.dataimport;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpmn2.Process;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
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
import org.foxbpm.bpmn.designer.ui.utils.BpmnModelUtil;
import org.foxbpm.bpmn.designer.ui.utils.DataVarUtil;
import org.foxbpm.model.bpmn.foxbpm.DataVariable;
import org.foxbpm.model.config.variableconfig.DataTypeDef;
import org.foxbpm.model.config.variableconfig.DataVariableBizType;

public class DataVariableCrossDialog extends TitleAreaDialog {
	private DataObjImport dataObjImport;
	private Table unImportTable;
	private Table importedTable;
	private Text keyText;
	private Process process;
	private List<DataVariable> unImportDataVars;
	private List<DataVariable> importedDataVars;
	private TableViewer unImportTableViewer;
	private TableViewer importedTableViewer;
	private String tableName;
	private String selectedDB;
	private boolean isShowComments;
	private String importType;
	private List<DataVariable> dataVariables;
	private Button setKeyButton;
	private DataVariable keyDataVariable;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 * @wbp.parser.constructor
	 */
	public DataVariableCrossDialog(Shell parentShell, DataObjImport dataObjImport, String tableName, Process process, String selectedDB, boolean isShowComments, String importType) {
		super(parentShell);
		setShellStyle(SWT.CLOSE | SWT.RESIZE | SWT.TITLE | SWT.PRIMARY_MODAL);
		setHelpAvailable(false);
		this.dataObjImport = dataObjImport;
		this.process = process;
		this.tableName = tableName;
		this.selectedDB = selectedDB;
		this.isShowComments = isShowComments;
		this.importType = importType;
		unImportDataVars = getUnImportDataVar();
		importedDataVars = getImportedDataVar();
		
		List<DataVariable> filterDataVariables = new ArrayList<DataVariable>();
		
		for (DataVariable dataVariable : importedDataVars) {
			if(unImportDataVars.size()>0 && unImportDataVars.get(unImportDataVars.size()-1).getBizType().equals(dataVariable.getBizType())) {
				filterDataVariables.add(dataVariable);
			}else if(dataVariable.getId().equals("_BizName") || dataVariable.getId().equals("_BizKeyField")) {
				continue;
			}else if(unImportDataVars.size()==0) {
				filterDataVariables.add(dataVariable);
			}
		}
		
		importedDataVars = filterDataVariables;
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setMessage("请选择要导入的变量");
		setTitle("数据变量导入");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		GridLayout gl_container = new GridLayout(3, false);
		gl_container.marginRight = 15;
		gl_container.marginLeft = 15;
		container.setLayout(gl_container);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setText("未导入变量");
		new Label(container, SWT.NONE);

		Label lblNewLabel_2 = new Label(container, SWT.NONE);
		lblNewLabel_2.setText("关联键");

		unImportTableViewer = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		unImportTable = unImportTableViewer.getTable();
		unImportTable.setHeaderVisible(true);
		unImportTable.setLinesVisible(true);
		unImportTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 3));

		TableColumn tblclmnNewColumn = new TableColumn(unImportTable, SWT.NONE);
		tblclmnNewColumn.setWidth(130);
		tblclmnNewColumn.setText("名称");
		
		TableColumn unDataTypeColumn = new TableColumn(unImportTable, SWT.NONE);
		unDataTypeColumn.setWidth(80);
		unDataTypeColumn.setText("数据类型");

		TableColumn unTypeColumn = new TableColumn(unImportTable, SWT.NONE);
		unTypeColumn.setWidth(100);
		unTypeColumn.setText("业务类型");
		unImportTableViewer.setLabelProvider(new TableLabelProvider());
		unImportTableViewer.setContentProvider(new ArrayContentProvider());
		unImportTableViewer.setInput(unImportDataVars);
		unImportTableViewer.addDoubleClickListener(new IDoubleClickListener() {
			
			@Override
			public void doubleClick(DoubleClickEvent event) {
				moveTableData(unImportTableViewer, ((List<DataVariable>)unImportTableViewer.getInput()), importedTableViewer, ((List<DataVariable>)importedTableViewer.getInput()), false);
			}
		});
		new Label(container, SWT.NONE);

		keyText = new Text(container, SWT.BORDER);
		keyText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		keyText.setEnabled(false);
		new Label(container, SWT.NONE);

		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setText("已导入变量");

		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		Button single2RButton = new Button(composite, SWT.NONE);
		single2RButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		single2RButton.setBounds(0, 0, 80, 27);
		single2RButton.setText("=>");
		single2RButton.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				moveTableData(unImportTableViewer, ((List<DataVariable>)unImportTableViewer.getInput()), importedTableViewer, ((List<DataVariable>)importedTableViewer.getInput()), false);
			}
		});

		Button all2RButton = new Button(composite, SWT.NONE);
		all2RButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		all2RButton.setText(">>");
		all2RButton.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				moveTableData(unImportTableViewer, ((List<DataVariable>)unImportTableViewer.getInput()), importedTableViewer, ((List<DataVariable>)importedTableViewer.getInput()), true);
			}
		});

		Button single2LButton = new Button(composite, SWT.NONE);
		single2LButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		single2LButton.setText("<=");
		single2LButton.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				moveTableData(importedTableViewer, ((List<DataVariable>)importedTableViewer.getInput()), unImportTableViewer, ((List<DataVariable>)unImportTableViewer.getInput()), false);
			}
		});

		Button all2LButton = new Button(composite, SWT.NONE);
		all2LButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		all2LButton.setText("<<");
		all2LButton.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				moveTableData(importedTableViewer, ((List<DataVariable>)importedTableViewer.getInput()), unImportTableViewer, ((List<DataVariable>)unImportTableViewer.getInput()), true);
			}
		});

		setKeyButton = new Button(composite, SWT.NONE);
		setKeyButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		setKeyButton.setText("关联键");
		setKeyButton.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				IStructuredSelection iStructuredSelection = (IStructuredSelection) importedTableViewer.getSelection();
				DataVariable dataVariable = (DataVariable) iStructuredSelection.getFirstElement();
				if(dataVariable!=null && (dataVariable.getBizType().equals("formVariable") || dataVariable.getBizType().equals("dataBaseVariable"))) {
					keyText.setText(dataVariable.getId());
					keyText.setData(dataVariable);
				}else {
					MessageDialog.openInformation(getShell(), "提示", "请从已导入的数据变量列表中选择一个业务类型为表单变量或数据库变量的数据变量设置关联键");
				}
			}
		});

		importedTableViewer = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		importedTable = importedTableViewer.getTable();
		importedTable.setLinesVisible(true);
		importedTable.setHeaderVisible(true);
		importedTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		TableColumn tableColumn = new TableColumn(importedTable, SWT.NONE);
		tableColumn.setWidth(130);
		tableColumn.setText("名称");
		
		TableColumn imDataTypeColumn = new TableColumn(importedTable, SWT.NONE);
		imDataTypeColumn.setWidth(80);
		imDataTypeColumn.setText("数据类型");

		TableColumn imTypeColumn = new TableColumn(importedTable, SWT.NONE);
		imTypeColumn.setWidth(100);
		imTypeColumn.setText("业务类型");

		importedTableViewer.setLabelProvider(new TableLabelProvider());
		importedTableViewer.setContentProvider(new ArrayContentProvider());
		importedTableViewer.setInput(importedDataVars);
		importedTableViewer.addDoubleClickListener(new IDoubleClickListener() {
			
			@Override
			public void doubleClick(DoubleClickEvent event) {
				moveTableData(importedTableViewer, ((List<DataVariable>)importedTableViewer.getInput()), unImportTableViewer, ((List<DataVariable>)unImportTableViewer.getInput()), false);				
			}
		});
		
		/*importedTableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection iStructuredSelection = (IStructuredSelection) importedTableViewer.getSelection();
				DataVariable dataVariable = (DataVariable) iStructuredSelection.getFirstElement();
				if(dataVariable!=null && (dataVariable.getBizType().equals("formVariable") || dataVariable.getBizType().equals("dataBaseVariable"))) {
					setKeyButton.setEnabled(true);
				}else {
					setKeyButton.setEnabled(false);
				}
			}
		});*/
		
		getBizKey();
		return area;
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, "确定", true);
		createButton(parent, IDialogConstants.CANCEL_ID, "取消", false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(750, 535);
	}

	@Override
	protected void okPressed() {
		
		if(keyText.getText()==null || keyText.getText().equals("")) {
			MessageDialog.openInformation(getShell(), "提示", "请先设置关联键");
			return;
		}
		
		dataVariables = ((List<DataVariable>)importedTableViewer.getInput());
		
		if(keyText.getData()!=null) {
			setKeyDataVariable((DataVariable) keyText.getData());
		}
		setDataVariables(dataVariables);
		super.okPressed();
	}

	/**
	 * 取未导入的数据变量
	 * 
	 * @return
	 */
	private List<DataVariable> getUnImportDataVar() {
		List<DataVariable> unImportDataVariables = new ArrayList<DataVariable>();
		
		if(dataObjImport!=null) {
			unImportDataVariables.addAll(dataObjImport.getDataVariables());
//			List<String> froms = FormUtil.getHtmlFilesRealPathFromBizobjId(dataObjImport.getId() , dataObjImport.getFilePath());
//			
//			for(String form : froms){
//				
//				if(form.indexOf(".html")>=0||form.indexOf(".htm")>=0||form.indexOf(".jsp")>=0){
//					DataVariable dataVariable = FoxBPMFactory.eINSTANCE.createDataVariable();
//					dataVariable.setId(FormUtil.getFormNameByFormPath(form).replace(".html", "").replace(".htm", ""));
//					dataVariable.setDataType("java.lang.String");
//					Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
//					expression.setName(dataVariable.getId());
//					expression.setValue("\""+form+"\"");
//					dataVariable.setExpression(expression);
//					dataVariable.setBizType("form");
//					
//					unImportDataVariables.add(dataVariable);
//				}
//				
//			}
//			
//			
//			List<DataVariableImport> dataVariableImports = dataObjImport.getDataVariableList(process, importType);
//			
//			for (DataVariableImport dataVariableImport : dataVariableImports) {
//
//				
//				
//				DataVariable dataVariable = FoxBPMFactory.eINSTANCE.createDataVariable();
//				Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
//				if(isShowComments){
//					dataVariable.setId(dataVariableImport.getName());
//					expression.setName(dataVariableImport.getName());
//				}else{
//					
//					dataVariable.setId(dataVariableImport.getId());
//					expression.setName(dataVariableImport.getId());
//				}
//				
//				dataVariable.setDataType(dataVariableImport.getDataType());
//				
//				dataVariable.setFileName(dataVariableImport.getId());
//				
//				//expression.setName(dataVariable.getId());
//				expression.setValue(dataVariableImport.getVariableValue());
//				dataVariable.setExpression(expression);
//				dataVariable.setBizType(dataVariableImport.getBizType());
////				dataVariable.setBizType(importType.equals("form") ? "formVariable" : "dataBaseVariable");
//				
//				unImportDataVariables.add(dataVariable);
//			}
			
			
		} else {
//			unImportDataVariables = DataVariableConfigUtil.getDataBaseDataVariable(selectedDB, tableName, isShowComments);
//			
//
//			DataVariable column1 = FoxBPMFactory.eINSTANCE.createDataVariable();
//			column1.setId("Fix_BizName");
//			column1.setFileName("Fix_BizName");
//			column1.setDataType("String");
//			Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
//			expression.setName("Fix_BizName");
//			expression.setValue("\""+tableName+"\"");
//			column1.setExpression(expression);
//			column1.setBizType("bizObjVariable");
//			
//			unImportDataVariables.add(column1);
//			
//			
//			
//			DataVariable column2 = FoxBPMFactory.eINSTANCE.createDataVariable();
//			column2.setId("Fix_BizKeyFile");
//			column2.setFileName("Fix_BizKeyFile");
//			column2.setDataType("String");
//			Expression expression2 = FoxBPMFactory.eINSTANCE.createExpression();
//			expression2.setName("Fix_BizKeyFile");
//			expression2.setValue("");
//			column2.setExpression(expression2);
//			column2.setBizType("relatedFieldVariable");
//			unImportDataVariables.add(column2);
//			
//			
//			DataVariable column3 = FoxBPMFactory.eINSTANCE.createDataVariable();
//			column3.setId("Fix_DataBaseId");
//			column3.setFileName("Fix_DataBaseId");
//			column3.setDataType("String");
//			Expression expression3 = FoxBPMFactory.eINSTANCE.createExpression();
//			expression3.setName("Fix_DataBaseId");
//			expression3.setValue("\""+selectedDB+"\"");
//			column3.setExpression(expression3);
//			column3.setBizType("customVariable");
//			unImportDataVariables.add(column3);
			
			
			
		}
		
		List<DataVariable> removeDataVariables = new ArrayList<DataVariable>();
		
		for (DataVariable undataVariable : unImportDataVariables) {
			for (DataVariable imdataVariable : getImportedDataVar()) {
				if(undataVariable.getId()==null)
					continue;
				if(undataVariable.getId().equals(imdataVariable.getId())){
					removeDataVariables.add(undataVariable);
				}
			}
		}
		
		unImportDataVariables.removeAll(removeDataVariables);
		return unImportDataVariables;
	}

	private List<DataVariable> getImportedDataVar() {
		List<DataVariable> importedDataVariables = BpmnModelUtil.getDataVariable(process);
		return importedDataVariables;
	}

	/**
	 * 表间移动数据
	 * 
	 * @param source
	 * @param target
	 * @param targetResult
	 * @param isAll
	 */

	private void moveTableData(TableViewer source, List<DataVariable> sourceData, TableViewer target, List<DataVariable> targetData, boolean isAll) {
		if (isAll)
			source.getTable().selectAll();

		ISelection sel = source.getSelection();
		if (sel == null)
			return;
		Object[] objs = ((IStructuredSelection) sel).toArray();
		if (objs == null || objs.length == 0)
			return;
		
		for (Object obj : objs) {
			DataVariable dataVariable = (DataVariable) obj;
			targetData.add(dataVariable);
			sourceData.remove(dataVariable);

		}
		source.refresh();
		target.refresh();

	}

	private class TableLabelProvider extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}
		public String getColumnText(Object element, int columnIndex) {
			DataVariable dataVariable = (DataVariable) element;
			switch(columnIndex){
			case 0:
				return dataVariable.getId();
			case 1:
				return getDataType(dataVariable);
			case 2:
				return getBizType(dataVariable);
			}
			return null;
		}
	}
	
	private String getBizType(DataVariable dataVariable) {
		String type = "";
		if(dataVariable.getBizType()==null) {
			return type;
		}else {
			DataVariableBizType dataVariableBizType=DataVarUtil.getDataVariableBizType(dataVariable.getBizType());
			if(dataVariableBizType!=null)
				type=dataVariableBizType.getTypeName();
		}
		return type;
	}
	
	private String getDataType(DataVariable dataVariable) {
		String type = "";
		if(dataVariable.getDataType()==null) {
			return type;
		}else {
			DataTypeDef dataTypeDef = DataVarUtil.getDataTypeDefByDataVariableDataType(dataVariable.getDataType());
			type=dataTypeDef.getName();
		}
		return type;
	}

	public void getBizKey(){
		for (DataVariable dataVariable : BpmnModelUtil.getDataVariable(process)) {
			if(dataVariable.getId().equals("_BizKeyField")){
				keyText.setText(dataVariable.getExpression().getName());
				keyText.setData(dataVariable);
			}
		}
	}
		
	
	public List<DataVariable> getDataVariables() {
		return dataVariables;
	}

	public void setDataVariables(List<DataVariable> dataVariables) {
		this.dataVariables = dataVariables;
	}

	public DataVariable getKeyDataVariable() {
		return keyDataVariable;
	}

	public void setKeyDataVariable(DataVariable keyDataVariable) {
		this.keyDataVariable = keyDataVariable;
	}

}
