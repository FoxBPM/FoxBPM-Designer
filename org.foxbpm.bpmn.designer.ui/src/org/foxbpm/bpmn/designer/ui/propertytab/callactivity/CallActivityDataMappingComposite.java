package org.foxbpm.bpmn.designer.ui.propertytab.callactivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.eclipse.bpmn2.BaseElement;
import org.eclipse.bpmn2.Bpmn2Factory;
import org.eclipse.bpmn2.CallActivity;
import org.eclipse.bpmn2.ExtensionAttributeValue;
import org.eclipse.bpmn2.Process;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.foxbpm.bpmn.designer.base.utils.FoxBPMDesignerUtil;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMComposite;
import org.foxbpm.bpmn.designer.ui.utils.BpmnModelUtil;
import org.foxbpm.model.bpmn.foxbpm.DataSourceToSubProcessMapping;
import org.foxbpm.model.bpmn.foxbpm.DataVariable;
import org.foxbpm.model.bpmn.foxbpm.DataVariableMapping;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;
import org.foxbpm.model.bpmn.foxbpm.SubProcessToDataSourceMapping;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class CallActivityDataMappingComposite extends AbstractFoxBPMComposite {
	private CallActivity callActivity;
	private TableViewer tableViewer;
	private TableViewer tableViewer2;
	private List<DataVariableMapping> list1;
	private List<DataVariableMapping> list2;
	private Map<String, String> process;
	private Map<String, String> subProcess;
	private Map<String, String> processFan;
	private Map<String, String> subProcessFan;
	private String[] processArray;
	private String[] subProcessArray;
	private CellEditor[] cellEditors;
	private CellEditor[] cellEditors2;
	private DataSourceToSubProcessMapping dataSourceToSubProcessMapping;
	private SubProcessToDataSourceMapping subProcessToDataSourceMapping;

	public CallActivityDataMappingComposite(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public void createUIBindings(EObject eObject) {
		callActivity = (CallActivity) eObject;
		initData(eObject);
	}

	@Override
	public Composite createUI(Composite parent) {
		if (formToolkit == null)// 为了WB展现
			formToolkit = new FormToolkit(Display.getDefault());
		Composite detailComposite = new Composite(parent, SWT.NONE);
		GridData gd_detailComposite = new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1);
		gd_detailComposite.heightHint = 200;
		detailComposite.setLayoutData(gd_detailComposite);
		detailComposite.setLayout(new GridLayout(2, false));

		Composite composite = new Composite(detailComposite, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		composite.setLayout(new GridLayout(2, false));

		Button autoMapButton = new Button(composite, SWT.NONE);
		autoMapButton.setSize(60, 27);
		autoMapButton.setText("自动映射");
		autoMapButton.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						//删除列表数据
						if(list1 != null && list1.size() > 0) {
							for (int i = 0; i < list1.size();) {
								list1.remove(i);
							}
						}
						if(list2 != null && list2.size() > 0) {
							for (int i = 0; i < list2.size();) {
								list2.remove(i);
							}
						}
						
						for (int i = 0; i < process.keySet().size(); i++) {
							String data = process.get(i + "");
							for (int j = 0; j < subProcess.keySet().size(); j++) {
								String subData = subProcess.get(j + "");
								if(data.equals(subData) || ("sub_" + data).equals(subData) ) {
									DataVariableMapping dataVariable = FoxBPMFactory.eINSTANCE.createDataVariableMapping();
									dataVariable.setDataSourceId(data);
									dataVariable.setSubProcesId(subData);
									list1.add(dataVariable);
									
									dataVariable = FoxBPMFactory.eINSTANCE.createDataVariableMapping();
									dataVariable.setDataSourceId(data);
									dataVariable.setSubProcesId(subData);
									list2.add(dataVariable);
									break;
								}
							}
						}
						
						tableViewer.setInput(list1);
						tableViewer2.setInput(list2);
						tableViewer.refresh();
						tableViewer2.refresh();
					}
				});
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setSize(194, 17);
		lblNewLabel.setText("名字相同或前缀都为‘sub_’的变量");

		Section section = formToolkit.createSection(detailComposite, Section.TITLE_BAR);
		// Section section = new Section(detailComposite, Section.TITLE_BAR);
		section.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		section.setText("主流程映射子流程");
		ToolBar toolBar = new ToolBar(section, SWT.FLAT | SWT.RIGHT);
		section.setTextClient(toolBar);

		ToolItem titem = new ToolItem(toolBar, SWT.NONE);
		titem.setToolTipText("添加");
		titem.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ADD));
		titem.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						DataVariableMapping ele = FoxBPMFactory.eINSTANCE.createDataVariableMapping();
						ele.setDataSourceId("");
						ele.setSubProcesId("");
						list1.add(ele);
						refreshContent(tableViewer, list1, ele);
					}
				});
			}
		});

		titem = new ToolItem(toolBar, SWT.NONE);
		titem.setToolTipText("删除");
		titem.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE));
		titem.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						ISelection sel = tableViewer.getSelection();
						if (sel == null)
							return;
						Object[] objs = ((IStructuredSelection) sel).toArray();
						if (objs == null || objs.length == 0)
							return;
						boolean b = MessageDialog.openConfirm(null, "警告", "你确认要删除吗？");
						if (!b)
							return;
						int selected = tableViewer.getTable().getSelectionIndex();
						for (int i = 0; i < objs.length; i++) {
							list1.remove(objs[i]);
						}
						int num = 0; // 删除后选中第几行数据的行数
						if (selected == 0) {
							num = selected;
						} else {
							num = selected - 1;
						}
						refreshContent(tableViewer, list1, list1.size() > 0 ? list1.get(num) : null);
					}
				});
			}
		});

		tableViewer = new TableViewer(section, SWT.BORDER | SWT.FULL_SELECTION);
		tableViewer.setContentProvider(new ArrayContentProvider());
		final Table table = tableViewer.getTable();
		table.addListener(SWT.MeasureItem, new Listener() { // 修改行高度
					public void handleEvent(Event event) {
						event.width = table.getGridLineWidth();
						// 设置宽度
						event.height = (int) Math.floor(event.gc.getFontMetrics().getHeight() * 1.5);
					}
				});
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		section.setClient(table);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("源数据");

		tableViewerColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				DataVariableMapping p = (DataVariableMapping) element;
				return p.getDataSourceId();
			}
		});

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tableColumn = tableViewerColumn_1.getColumn();
		tableColumn.setWidth(100);
		tableColumn.setText("子流程数据");

		tableViewerColumn_1.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				DataVariableMapping p = (DataVariableMapping) element;
				return p.getSubProcesId();
			}
		});

		Section section_1 = formToolkit.createSection(detailComposite, Section.TITLE_BAR);
		// Section section_1 = new Section(detailComposite, Section.TITLE_BAR);
		section_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		section_1.setText("子流程映射主流程");

		ToolBar toolBar_1 = new ToolBar(section_1, SWT.FLAT | SWT.RIGHT);
		section_1.setTextClient(toolBar_1);

		titem = new ToolItem(toolBar_1, SWT.NONE);
		titem.setToolTipText("添加");
		titem.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ADD));
		titem.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						DataVariableMapping ele = FoxBPMFactory.eINSTANCE.createDataVariableMapping();
						ele.setDataSourceId("");
						ele.setSubProcesId("");
						list2.add(ele);
						refreshContent(tableViewer2, list2, ele);
					}
				});
			}
		});

		titem = new ToolItem(toolBar_1, SWT.NONE);
		titem.setToolTipText("删除");
		titem.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE));
		titem.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						ISelection sel = tableViewer2.getSelection();
						if (sel == null)
							return;
						Object[] objs = ((IStructuredSelection) sel).toArray();
						if (objs == null || objs.length == 0)
							return;
						boolean b = MessageDialog.openConfirm(null, "警告", "你确认要删除吗？");
						if (!b)
							return;
						int selected = tableViewer2.getTable().getSelectionIndex();
						for (int i = 0; i < objs.length; i++) {
							list2.remove(objs[i]);
						}
						int num = 0; // 删除后选中第几行数据的行数
						if (selected == 0) {
							num = selected;
						} else {
							num = selected - 1;
						}
						refreshContent(tableViewer2, list2, list2.size() > 0 ? list2.get(num) : null);
					}
				});
			}
		});

		cellEditors = new CellEditor[tableViewer.getTable().getColumnCount()];
		cellEditors[0] = new ComboBoxCellEditor(table, processArray == null ? new String[0] : processArray, SWT.READ_ONLY);
		cellEditors[1] = new ComboBoxCellEditor(table, subProcessArray == null ? new String[0] : subProcessArray, SWT.READ_ONLY);

		tableViewer.setCellEditors(cellEditors);
		tableViewer.setColumnProperties(new String[] { "source", "sonSource" });
		tableViewer.setCellModifier(new ICellModifier() {
			public boolean canModify(Object element, String property) {
				return element instanceof DataVariableMapping;
			}

			public Object getValue(Object element, String property) {
				DataVariableMapping ele = (DataVariableMapping) element;
				if ("source".equals(property)) {
					return processFan.get(ele.getDataSourceId()) == null ? -1 : Integer.parseInt(processFan.get(ele.getDataSourceId()));
				}
				if ("sonSource".equals(property)) {
					return subProcessFan.get(ele.getSubProcesId()) == null ? -1 : Integer.parseInt(subProcessFan.get(ele.getSubProcesId()));
				}
				return null;
			}

			public void modify(Object element, String property, Object value) {
				DataVariableMapping ele = (DataVariableMapping) ((Item) element).getData();
				Object oldValue = getValue(ele, property);
				if (value == null || value.equals(oldValue))
					return;
				if ("source".equals(property)) {
					Integer defaultValue = 0;
					if (value != null)
						defaultValue = (Integer) value;
					setDataSourceId(ele, process.get(defaultValue == -1 ? "" : defaultValue.toString()));
				}
				if ("sonSource".equals(property)) {
					Integer defaultValue = 0;
					if (value != null)
						defaultValue = (Integer) value;
					setSubProcesId(ele, subProcess.get(defaultValue == -1 ? "" : defaultValue.toString()));
				}
				refreshContent(tableViewer, list1, ele);
			}
		});

		tableViewer2 = new TableViewer(section_1, SWT.BORDER | SWT.FULL_SELECTION);
		tableViewer2.setContentProvider(new ArrayContentProvider());
		final Table table2 = tableViewer2.getTable();
		table2.addListener(SWT.MeasureItem, new Listener() { // 修改行高度
					public void handleEvent(Event event) {
						event.width = table.getGridLineWidth();
						// 设置宽度
						event.height = (int) Math.floor(event.gc.getFontMetrics().getHeight() * 1.5);
					}
				});
		table2.setLinesVisible(true);
		table2.setHeaderVisible(true);
		section_1.setClient(table2);

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer2, SWT.NONE);
		TableColumn tableColumn_1 = tableViewerColumn_2.getColumn();
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("子流程数据");
		tableViewerColumn_2.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				DataVariableMapping p = (DataVariableMapping) element;
				return p.getSubProcesId();
			}
		});

		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer2, SWT.NONE);
		TableColumn tableColumn_2 = tableViewerColumn_3.getColumn();
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("源数据");
		tableViewerColumn_3.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				DataVariableMapping p = (DataVariableMapping) element;
				return p.getDataSourceId();
			}
		});

		cellEditors2 = new CellEditor[tableViewer2.getTable().getColumnCount()];
		cellEditors2[0] = new ComboBoxCellEditor(table2, subProcessArray == null ? new String[0] : subProcessArray, SWT.READ_ONLY);
		cellEditors2[1] = new ComboBoxCellEditor(table2, processArray == null ? new String[0] : processArray, SWT.READ_ONLY);

		tableViewer2.setCellEditors(cellEditors2);
		tableViewer2.setColumnProperties(new String[] { "sonSource", "source" });
		tableViewer2.setCellModifier(new ICellModifier() {
			public boolean canModify(Object element, String property) {
				return element instanceof DataVariableMapping;
			}

			public Object getValue(Object element, String property) {
				DataVariableMapping ele = (DataVariableMapping) element;
				if ("source".equals(property)) {
					return processFan.get(ele.getDataSourceId()) == null ? -1 : Integer.parseInt(processFan.get(ele.getDataSourceId()));
				}
				if ("sonSource".equals(property)) {
					return subProcessFan.get(ele.getSubProcesId()) == null ? -1 : Integer.parseInt(subProcessFan.get(ele.getSubProcesId()));
				}
				return null;
			}

			public void modify(Object element, String property, Object value) {
				DataVariableMapping ele = (DataVariableMapping) ((Item) element).getData();
				Object oldValue = getValue(ele, property);
				if (value == null || value.equals(oldValue))
					return;
				if ("source".equals(property)) {
					Integer defaultValue = 0;
					if (value != null)
						defaultValue = (Integer) value;
					setDataSourceId(ele, process.get(defaultValue == -1 ? "" : defaultValue.toString()));
				}
				if ("sonSource".equals(property)) {
					Integer defaultValue = 0;
					if (value != null)
						defaultValue = (Integer) value;
					setSubProcesId(ele, subProcess.get(defaultValue == -1 ? "" : defaultValue.toString()));
				}
				refreshContent(tableViewer2, list2, ele);
			}
		});

		return parent;
	}

	@Override
	public String setDescId() {
		return "";
	}

	/**
	 * 刷新
	 * 
	 * @param tableViewer
	 * @param list
	 * @param selection
	 */
	private void refreshContent(TableViewer tableViewer, List<DataVariableMapping> list, Object selection) {
		tableViewer.setInput(list);
		tableViewer.refresh();
		if (selection != null) {
			tableViewer.setSelection(new StructuredSelection(new Object[] { selection }), true);
		}
	}

	/**
	 * initData(初始化数据)
	 * 
	 * @Title: initData
	 * @param @param be 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	private void initData(final EObject be) {
		list1 = new ArrayList<DataVariableMapping>();
		list2 = new ArrayList<DataVariableMapping>();
		process = new HashMap<String, String>();
		subProcess = new HashMap<String, String>();
		processFan = new HashMap<String, String>();
		subProcessFan = new HashMap<String, String>();
		
		// 获取主流程数据
		List<DataVariable> process = getProcessDataVariable((Process) BpmnModelUtil.getProcessByEobj(be));
		if (process != null && process.size() > 0) {
			processArray = new String[process.size()];
			for (int i = 0; i < process.size(); i++) {
				DataVariable dataVariable = process.get(i);
				this.process.put(i + "", dataVariable.getId());
				this.processFan.put(dataVariable.getId(), i + "");
				processArray[i] = dataVariable.getId();
			}
		}

		// 获取子流程数据
		try {
			List<DataVariable> subProcess = getSubProcessDataVariable((CallActivity) be);
			if (subProcess != null && subProcess.size() > 0) {
				subProcessArray = new String[subProcess.size()];
				for (int i = 0; i < subProcess.size(); i++) {
					DataVariable dataVariable = subProcess.get(i);
					this.subProcess.put(i + "", dataVariable.getId());
					this.subProcessFan.put(dataVariable.getId(), i + "");
					subProcessArray[i] = dataVariable.getId();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(getShell(), "异常", e.toString());
		}

		// 赋值
		((ComboBoxCellEditor) cellEditors[0]).setItems(processArray == null ? new String[0] : processArray);
		((ComboBoxCellEditor) cellEditors[1]).setItems(subProcessArray == null ? new String[0] : subProcessArray);
		((ComboBoxCellEditor) cellEditors2[1]).setItems(processArray == null ? new String[0] : processArray);
		((ComboBoxCellEditor) cellEditors2[0]).setItems(subProcessArray == null ? new String[0] : subProcessArray);

		// 获取emf数据

		dataSourceToSubProcessMapping = getDataSourceToSubProcessMapping((CallActivity) be);
		subProcessToDataSourceMapping = getSubProcessToDataSourceMapping((CallActivity) be);

		// 填充list
		list1 = dataSourceToSubProcessMapping.getDataVariableMapping();
		list2 = subProcessToDataSourceMapping.getDataVariableMapping();

		tableViewer.setInput(list1);
		tableViewer2.setInput(list2);
	}

	/**
	 * 获取主流程数据变量
	 * 
	 * @param process
	 * @return
	 */
	public static List<DataVariable> getProcessDataVariable(Process process) {

		BaseElement baseElement = (BaseElement) process;
		List<DataVariable> dataVariables = new ArrayList<DataVariable>();

		if (baseElement.getExtensionValues().size() > 0) {
			for (ExtensionAttributeValue extensionAttributeValue : baseElement.getExtensionValues()) {
				FeatureMap extensionElements = extensionAttributeValue.getValue();
				Object objectElement = extensionElements.get(FoxBPMPackage.Literals.DOCUMENT_ROOT__DATA_VARIABLE, true);
				if (objectElement != null) {
					@SuppressWarnings("unchecked")
					List<DataVariable> dataVariableList = (List<DataVariable>) objectElement;
					for (DataVariable dataVariable : dataVariableList) {
						dataVariables.add(dataVariable);
					}
				}
			}
		}

		return dataVariables;
	}

	/**
	 * 获取子流程数据变量
	 * 
	 * @param callActivity
	 * @return
	 * @throws Exception
	 */
	public static List<DataVariable> getSubProcessDataVariable(CallActivity callActivity) throws Exception {

		List<DataVariable> dataVariables = new ArrayList<DataVariable>();

		Object processKey = callActivity.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__CALLABLE_ELEMENT_ID);
		Object processVersion = callActivity.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__CALLABLE_ELEMENT_VERSION);

		if (processKey != null && !processKey.equals("")) {

			ClientResource client = FoxBPMDesignerUtil.getClientByUrl("variable-definition/"+processKey+"/"+processVersion+"/variables");
			if(client==null) {
				return dataVariables;
			}
			Representation result = client.get();
			try {
				ObjectMapper objectMapper = new ObjectMapper();
				String resultString = result.getText();
				if(resultString==null) {
					MessageDialog.openInformation(null, "提示", "未找到流程编号为"+ processKey + "版本为" + processVersion + "流程定义");
					return dataVariables;
				}
				JsonNode object= objectMapper.readTree(resultString);
				System.out.println(resultString);
				ArrayNode dataArray = (ArrayNode)object.get("data");
				
				for(JsonNode json :dataArray){
					DataVariable dataVariable = FoxBPMFactory.eINSTANCE.createDataVariable();
					dataVariable.setId(json.get("id")==null?"":json.get("id").asText());
					dataVariable.setBizType(json.get("bizType")==null?"":json.get("bizType").asText());
					dataVariable.setDataType(json.get("dataType")==null?"":json.get("dataType").asText());
//					dataVariable.setExpression(json.get("expressionText")==null?"":json.get("expressionText").asText());
//					dataVariable.setFileName(json.get("id")==null?"":json.get("id").asText());
					dataVariable.setIsList(json.get("isList")==null?false:json.get("isList").asBoolean());
					dataVariable.setIsPersistence(json.get("isPersistence")==null?false:json.get("isPersistence").asBoolean());
					dataVariables.add(dataVariable);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			MessageDialog.openInformation(null, "提示", "请先设置公有子流程的流程编号和版本");
			return dataVariables;
		}

		return dataVariables;

	}

	/**
	 * 获取主流程到子流程的映射
	 * 
	 * @param callActivity
	 */
	public static DataSourceToSubProcessMapping getDataSourceToSubProcessMapping(final CallActivity callActivity) {

		if (callActivity.getExtensionValues().size() > 0) {

			for (ExtensionAttributeValue extensionAttributeValue : callActivity.getExtensionValues()) {

				FeatureMap extensionElements = extensionAttributeValue.getValue();
				Object objectElement = extensionElements.get(FoxBPMPackage.Literals.DOCUMENT_ROOT__DATA_SOURCE_TO_SUB_PROCESS_MAPPING, true);
				if (objectElement != null) {
					return (DataSourceToSubProcessMapping) objectElement;
				} else {
					DataSourceToSubProcessMapping dataSourceToSubProcessMapping = FoxBPMFactory.eINSTANCE.createDataSourceToSubProcessMapping();
					FeatureMap.Entry extensionElementEntry = new org.eclipse.emf.ecore.impl.EStructuralFeatureImpl.SimpleFeatureMapEntry(
							(org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__DATA_SOURCE_TO_SUB_PROCESS_MAPPING, dataSourceToSubProcessMapping);
					extensionAttributeValue.getValue().add(extensionElementEntry);
					return dataSourceToSubProcessMapping;
				}

			}
		} else {

			DataSourceToSubProcessMapping dataSourceToSubProcessMapping = FoxBPMFactory.eINSTANCE.createDataSourceToSubProcessMapping();

			ExtensionAttributeValue extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
			callActivity.getExtensionValues().add(extensionElement);
			FeatureMap.Entry extensionElementEntry = new org.eclipse.emf.ecore.impl.EStructuralFeatureImpl.SimpleFeatureMapEntry(
					(org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__DATA_SOURCE_TO_SUB_PROCESS_MAPPING, dataSourceToSubProcessMapping);
			extensionElement.getValue().add(extensionElementEntry);

			return dataSourceToSubProcessMapping;
		}

		return null;

	}

	/**
	 * 获取子流程到主流程的映射
	 * 
	 * @param callActivity
	 */
	public static SubProcessToDataSourceMapping getSubProcessToDataSourceMapping(final CallActivity callActivity) {

		if (callActivity.getExtensionValues().size() > 0) {

			for (ExtensionAttributeValue extensionAttributeValue : callActivity.getExtensionValues()) {

				FeatureMap extensionElements = extensionAttributeValue.getValue();
				Object objectElement = extensionElements.get(FoxBPMPackage.Literals.DOCUMENT_ROOT__SUB_PROCESS_TO_DATA_SOURCE_MAPPING, true);
				if (objectElement != null) {
					return (SubProcessToDataSourceMapping) objectElement;
				} else {
					SubProcessToDataSourceMapping dataSourceToSubProcessMapping = FoxBPMFactory.eINSTANCE.createSubProcessToDataSourceMapping();
					FeatureMap.Entry extensionElementEntry = new org.eclipse.emf.ecore.impl.EStructuralFeatureImpl.SimpleFeatureMapEntry(
							(org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__SUB_PROCESS_TO_DATA_SOURCE_MAPPING, dataSourceToSubProcessMapping);
					extensionAttributeValue.getValue().add(extensionElementEntry);
					return dataSourceToSubProcessMapping;
				}

			}
		} else {

			SubProcessToDataSourceMapping subProcessToDataSourceMapping = FoxBPMFactory.eINSTANCE.createSubProcessToDataSourceMapping();

			ExtensionAttributeValue extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
			callActivity.getExtensionValues().add(extensionElement);
			FeatureMap.Entry extensionElementEntry = new org.eclipse.emf.ecore.impl.EStructuralFeatureImpl.SimpleFeatureMapEntry(
					(org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__SUB_PROCESS_TO_DATA_SOURCE_MAPPING, subProcessToDataSourceMapping);
			extensionElement.getValue().add(extensionElementEntry);

			return subProcessToDataSourceMapping;
		}

		return null;

	}

	/**
	 * emf赋值
	 * 
	 * @param mapping
	 * @param dataSourceId
	 */
	private void setDataSourceId(final DataVariableMapping mapping, final String dataSourceId) {
		TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				mapping.setDataSourceId(dataSourceId);
			}
		});
	}

	/**
	 * emf赋值
	 * 
	 * @param mapping
	 * @param subProcesId
	 */
	private void setSubProcesId(final DataVariableMapping mapping, final String subProcesId) {
		TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				mapping.setSubProcesId(subProcesId);
			}
		});
	}
}
