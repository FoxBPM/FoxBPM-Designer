package org.foxbpm.bpmn.designer.ui.dialogs.dataimport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.bpmn2.Process;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.foxbpm.model.bpmn.foxbpm.DataVariable;
import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;

public class DataVariableImportDialog extends TitleAreaDialog {
	private DataBindingContext m_bindingContext;
	private Text text;
	private Table table;
	private List<DataObjImport> dataObjImports;
	private TableViewer tableViewer;
	private Button okbutton;
	private Button canclebutton;
	private DataObjImport dataObjImport;
	private BizObjFilter filter;
	private StringFilter stringFilter;
	private String importType;
//	Button btnRadioButtonForm;
//	Button btnRadioButtonDB;
//	private Button btnRadioButtonDBnoFix;
	private Composite fixVarComposite;
	private Composite varComposite;
	private Label lblNewLabel_1;
	private Combo dataSourceCombo;
	private Label lblNewLabel_2;
	private Text searchText;
	private Table varTable;
	private TableViewer varTableViewer;
	private Composite stackComposite;
	private StackLayout stackLayout;
	private TableColumn tableNameColumn;
	private List<String> varTableInput;
	private String tableName;
	private Process process;
	private Button isShowCommentsButton;
	private List<DataVariable> dataVariables;
	private DataVariable keyDataVariable;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public DataVariableImportDialog(Shell parentShell, Process process) {
		super(parentShell);
		setHelpAvailable(false);
		setShellStyle(SWT.CLOSE | SWT.RESIZE | SWT.TITLE | SWT.PRIMARY_MODAL);
		this.dataObjImports = DataObjImportFactory.createDataObjImports();
		this.process = process;
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("数据变量导入");
		Composite area = (Composite) super.createDialogArea(parent);
		GridLayout gl_area = new GridLayout(1, false);
		gl_area.verticalSpacing = 0;
		gl_area.marginWidth = 0;
		gl_area.horizontalSpacing = 0;
		gl_area.marginHeight = 0;
		area.setLayout(gl_area);
		Composite container = new Composite(area, SWT.NONE);
		GridLayout gl_container = new GridLayout(1, false);
		gl_container.marginBottom = 15;
		gl_container.marginHeight = 15;
		gl_container.marginRight = 25;
		gl_container.marginLeft = 25;
		container.setLayout(gl_container);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		composite.setLayout(new GridLayout(DataObjCache.dataVarTypes.size() + 1, false));

		for (Object type : DataObjCache.cachemap.values()) {
			Map<String, Object> map = (Map<String, Object>) type;
			final Button button = new Button(composite, SWT.RADIO);
			//设置名称
			button.setText(map.get("name").toString());
			//存ID
			button.setData(map.get("id").toString());
			button.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					Button button = (Button) e.getSource();
					importType = button.getData().toString();
					for (Object cachemap : DataObjCache.cachemap.values()) {
						Map<String, Object> map = (Map<String, Object>) cachemap;
						if(importType.equals(map.get("id"))) {
							dataObjImports = (List<DataObjImport>) map.get("dataobjs");
							initDataBindings();
							tableViewer.refresh();
						}
					}
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					
				}
			});
		}
		
//		btnRadioButtonForm = new Button(composite, SWT.RADIO);
//		btnRadioButtonForm.setText("表单变量(EMAP)");
//		btnRadioButtonForm.addListener(SWT.Selection, new Listener() {
//			
//			@Override
//			public void handleEvent(Event event) {
//				stackLayout.topControl = fixVarComposite;
//				stackComposite.layout();
//			}
//		});
//
//
//		btnRadioButtonDB = new Button(composite, SWT.RADIO);
//		btnRadioButtonDB.setSelection(true);
//		btnRadioButtonDB.setText("数据库变量(EMAP)");
//		btnRadioButtonDB.addListener(SWT.Selection, new Listener() {
//			
//			@Override
//			public void handleEvent(Event event) {
//				stackLayout.topControl = fixVarComposite;
//				stackComposite.layout();
//			}
//		});
//
//		btnRadioButtonDBnoFix = new Button(composite, SWT.RADIO);
//		btnRadioButtonDBnoFix.setText("数据库变量");
		
		isShowCommentsButton = new Button(composite, SWT.CHECK);
		isShowCommentsButton.setSelection(true);
		isShowCommentsButton.setText("是否显示备注");
//		btnRadioButtonDBnoFix.addListener(SWT.Selection, new Listener() {
//			
//			@Override
//			public void handleEvent(Event event) {
//				stackLayout.topControl = varComposite;
//				stackComposite.layout();
//				dataObjImport = null;
//			}
//		});

		filter = new BizObjFilter();
		stringFilter = new StringFilter();

		stackComposite = new Composite(container, SWT.NONE);
		stackLayout = new StackLayout();
		stackComposite.setLayout(stackLayout);
		stackComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		fixVarComposite = new Composite(stackComposite, SWT.NONE);
		fixVarComposite.setLayout(new GridLayout(2, false));

		Label lblNewLabel = new Label(fixVarComposite, SWT.NONE);
		lblNewLabel.setSize(24, 17);
		lblNewLabel.setText("搜索");

		text = new Text(fixVarComposite, SWT.BORDER | SWT.SEARCH | SWT.ICON_SEARCH | SWT.ICON_CANCEL);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		text.setSize(385, 23);
		text.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				filter.setSearchText(text.getText());
				tableViewer.refresh();
			}
		});

		tableViewer = new TableViewer(fixVarComposite, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, true, 2, 1));
		table.setSize(385, 203);
		tableViewer.addFilter(filter);

		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.addListener(SWT.MeasureItem, new Listener() { //修改行高度
					public void handleEvent(Event event) {
						event.width = table.getGridLineWidth();
						// 设置宽度
						event.height = (int) Math.floor(event.gc.getFontMetrics().getHeight() * 1.5);
					}
				});

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				IStructuredSelection iStructuredSelection = (IStructuredSelection) tableViewer.getSelection();
				if (iStructuredSelection.getFirstElement() != null) {
					dataObjImport = (DataObjImport) iStructuredSelection.getFirstElement();
					okPressed();
				}
			}

			@Override
			public void mouseDown(MouseEvent e) {
				IStructuredSelection iStructuredSelection = (IStructuredSelection) tableViewer.getSelection();
				getButton(IDialogConstants.OK_ID).setEnabled(iStructuredSelection.getFirstElement() != null);
				dataObjImport = (DataObjImport) iStructuredSelection.getFirstElement();
			}
		});

		TableColumn fieldcolumn = new TableColumn(table, SWT.NONE);
		fieldcolumn.setWidth(150);
		fieldcolumn.setText("编号");
		fieldcolumn.setMoveable(true);

		TableColumn displaycolumn = new TableColumn(table, SWT.NONE);
		displaycolumn.setWidth(230);
		displaycolumn.setText("名称");
		displaycolumn.setMoveable(true);

		varComposite = new Composite(stackComposite, SWT.NONE);
		GridLayout gl_varComposite = new GridLayout(2, false);
		gl_varComposite.verticalSpacing = 2;
		varComposite.setLayout(gl_varComposite);

		lblNewLabel_1 = new Label(varComposite, SWT.NONE);
		lblNewLabel_1.setText("数据源");

		dataSourceCombo = new Combo(varComposite, SWT.READ_ONLY);
		dataSourceCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
//		dataSourceCombo.setItems(getFixFlowConfigDB());
		dataSourceCombo.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
//				varTableInput = DataBaseUtil.getTableInfo(dataSourceCombo.getText());
//				varTableViewer.setInput(varTableInput);
//				varTableViewer.refresh();
			}
		});

		lblNewLabel_2 = new Label(varComposite, SWT.NONE);
		lblNewLabel_2.setText("搜索");

		searchText = new Text(varComposite, SWT.BORDER);
		searchText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		searchText.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				stringFilter.setSearchText(searchText.getText());
				varTableViewer.refresh();
			}
		});

		varTableViewer = new TableViewer(varComposite, SWT.BORDER | SWT.FULL_SELECTION);
		varTable = varTableViewer.getTable();
		varTable.addListener(SWT.MeasureItem, new Listener() { //修改行高度
			public void handleEvent(Event event) {
				event.width = table.getGridLineWidth();
				// 设置宽度
				event.height = (int) Math.floor(event.gc.getFontMetrics().getHeight() * 1.5);
			}
		});
		varTable.setLinesVisible(true);
		varTable.setHeaderVisible(true);
		varTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		varTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				IStructuredSelection iStructuredSelection = (IStructuredSelection) varTableViewer.getSelection();
				if (iStructuredSelection.getFirstElement() != null) {
					tableName = iStructuredSelection.getFirstElement().toString();
					okPressed();
				}
			}

			@Override
			public void mouseDown(MouseEvent e) {
				IStructuredSelection iStructuredSelection = (IStructuredSelection) varTableViewer.getSelection();
				getButton(IDialogConstants.OK_ID).setEnabled(iStructuredSelection.getFirstElement() != null);
				tableName = iStructuredSelection.getFirstElement().toString();
			}
		});
		
		tableNameColumn = new TableColumn(varTable, SWT.NONE);
		tableNameColumn.setWidth(380);
		tableNameColumn.setText("表名");
		varTableViewer.setLabelProvider(new TableLabelProvider());
		varTableViewer.setContentProvider(new ArrayContentProvider());
		varTableViewer.addFilter(stringFilter);
		
		stackLayout.topControl = fixVarComposite;
		stackComposite.layout();
		return area;
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		okbutton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		okbutton.setEnabled(false);
		okbutton.setText("导入变量");

		canclebutton = createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
		canclebutton.setText("取消");
		m_bindingContext = initDataBindings();
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(490, 496);
	}

	@Override
	protected void okPressed() {
		setDataObjImport(dataObjImport);
		
		DataVariableCrossDialog dataVariableCrossDialog = new DataVariableCrossDialog(getShell(), dataObjImport, tableName, process, dataSourceCombo.getText(), isShowCommentsButton.getSelection(), importType);
		if (dataVariableCrossDialog != null && dataVariableCrossDialog.open() == InputDialog.OK) {
			setKeyDataVariable(dataVariableCrossDialog.getKeyDataVariable());
			
			dataVariables = new ArrayList<DataVariable>();
			
			for (DataVariable dataVariable : dataVariableCrossDialog.getDataVariables()) {
				if(dataVariable.getId().equals("_BizName") || dataVariable.getId().equals("_BizKeyField")) {
					continue;
				}else {
					dataVariables.add(dataVariable);
				}
			}
			
			//加入两个固定的数据变量
			DataVariable dataVariable2 = FoxBPMFactory.eINSTANCE.createDataVariable();
			dataVariable2.setId("_BizName");
			dataVariable2.setBizType("customVariable");
			dataVariable2.setDataType("String");
			dataVariable2.setIsPersistence(false);
			//值为选中的业务对象ID，也就是表名
			Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
			expression.setName(this.dataObjImport.getId());
			expression.setValue("\"" + this.dataObjImport.getId() + "\"");
			dataVariable2.setExpression(expression);
			dataVariable2.setFieldName("\"" + this.dataObjImport.getId() + "\"");
			DataVariable dataVariable3 = FoxBPMFactory.eINSTANCE.createDataVariable();
			dataVariable3.setId("_BizKeyField");
			dataVariable3.setBizType("customVariable");
			dataVariable3.setDataType("String");
			dataVariable3.setIsPersistence(false);
			//值为关联键
			Expression expression1 = FoxBPMFactory.eINSTANCE.createExpression();
			expression1.setName(getKeyDataVariable().getExpression().getName());
			expression1.setValue("\"" + getKeyDataVariable().getFieldName() + "\"");
			dataVariable3.setExpression(expression1);
			dataVariable3.setFieldName("\"" + getKeyDataVariable().getFieldName() + "\"");
			
			dataVariables.add(dataVariable2);
			dataVariables.add(dataVariable3);
			
			super.okPressed();
		}
	}

	public String getImportType() {
		return importType;

	}

	public DataObjImport getDataObjImport() {
		return dataObjImport;
	}

	public void setDataObjImport(DataObjImport dataObjImport) {
		this.dataObjImport = dataObjImport;
	}
	
	private String[] getFixFlowConfigDB() {
//		EList<DataBase> dataBases = FixFlowConfigUtil.getFixFlowConfig().getDataBaseConfig().getDataBase();
//		String[] strs = new String[dataBases.size()];
//		for (int i=0; i<dataBases.size(); i++) {
//			strs[i] = dataBases.get(i).getId();
//		}
//		
//		return strs;
		return null;
	}
	
	private class TableLabelProvider extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}
		public String getColumnText(Object element, int columnIndex) {
			return element.toString();
		}
	}

	public List<DataVariable> getDataVariables() {
		return dataVariables;
	}

	public DataVariable getKeyDataVariable() {
		return keyDataVariable;
	}

	public void setKeyDataVariable(DataVariable keyDataVariable) {
		this.keyDataVariable = keyDataVariable;
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		IObservableMap[] observeMaps = PojoObservables.observeMaps(listContentProvider.getKnownElements(), DataObjImport.class, new String[]{"id", "name"});
		tableViewer.setLabelProvider(new ObservableMapLabelProvider(observeMaps));
		tableViewer.setContentProvider(listContentProvider);
		//
		IObservableList selfList = Properties.selfList(DataObjImport.class).observe(dataObjImports);
		tableViewer.setInput(selfList);
		//
		return bindingContext;
	}
}
