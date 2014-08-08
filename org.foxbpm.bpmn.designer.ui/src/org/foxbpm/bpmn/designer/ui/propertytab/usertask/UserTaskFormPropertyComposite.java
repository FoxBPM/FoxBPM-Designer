package org.foxbpm.bpmn.designer.ui.propertytab.usertask;

import java.util.List;

import org.eclipse.bpmn2.BaseElement;
import org.eclipse.bpmn2.Bpmn2Factory;
import org.eclipse.bpmn2.ExtensionAttributeValue;
import org.eclipse.bpmn2.FormalExpression;
import org.eclipse.bpmn2.UserTask;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl.SimpleFeatureMapEntry;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.foxbpm.bpmn.designer.base.utils.FoxBPMDesignerUtil;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMComposite;
import org.foxbpm.bpmn.designer.ui.custom.ExpDialogCellEditor;
import org.foxbpm.bpmn.designer.ui.expdialog.ExpressionChangedEvent;
import org.foxbpm.bpmn.designer.ui.expdialog.FoxBPMExpViewer;
import org.foxbpm.bpmn.designer.ui.expdialog.IExpressionChangedListener;
import org.foxbpm.bpmn.designer.ui.utils.DataVarUtil;
import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FormParam;
import org.foxbpm.model.bpmn.foxbpm.FormParamContainer;
import org.foxbpm.model.bpmn.foxbpm.FormUri;
import org.foxbpm.model.bpmn.foxbpm.FormUriView;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;
import org.foxbpm.model.config.variableconfig.DataTypeDef;
import org.foxbpm.model.config.variableconfig.DataVariableDef;

public class UserTaskFormPropertyComposite extends AbstractFoxBPMComposite {
	private UserTask userTask;
	private FoxBPMExpViewer optFormViewer;// 操作表单
	private FoxBPMExpViewer browseFormViewer;// 浏览表单
	private Table table;
	private TableViewer tableViewer;
	private FormParamContainer formParamContainer;
	private Button addButton;
	private Button removeButton;

	public UserTaskFormPropertyComposite(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public String setDescId() {
		return null;
	}

	@Override
	public Composite createUI(Composite parent) {
		Composite detailComposite = new Composite(parent, SWT.NONE);
		detailComposite.setLayout(new GridLayout(3, false));
		detailComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label optFormLabel = new Label(detailComposite, SWT.NONE);
		optFormLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		optFormLabel.setText("操作表单");
		optFormViewer = new FoxBPMExpViewer(detailComposite, SWT.BORDER);
		Control control = optFormViewer.getControl();
		control.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		Label browseFormLabel = new Label(detailComposite, SWT.NONE);
		browseFormLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		browseFormLabel.setText("浏览表单");
		browseFormViewer = new FoxBPMExpViewer(detailComposite, SWT.BORDER);
		Control control_1 = browseFormViewer.getControl();
		control_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		tableViewer = new TableViewer(detailComposite, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		GridData gd_table = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		gd_table.heightHint = 80;
		table.setLayoutData(gd_table);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn paramKeyColumn = tableViewerColumn.getColumn();
		paramKeyColumn.setWidth(150);
		paramKeyColumn.setText("参数键");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn paramValueColumn = tableViewerColumn_1.getColumn();
		paramValueColumn.setWidth(150);
		paramValueColumn.setText("参数类型");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn expColumn = tableViewerColumn_2.getColumn();
		expColumn.setWidth(300);
		expColumn.setText("表达式");

		Composite composite = new Composite(detailComposite, SWT.NONE);
		GridLayout gl_composite = new GridLayout(1, false);
		gl_composite.verticalSpacing = 1;
		gl_composite.marginWidth = 0;
		gl_composite.marginHeight = 0;
		gl_composite.horizontalSpacing = 0;
		composite.setLayout(gl_composite);

		addButton = new Button(composite, SWT.NONE);
		addButton.setText("添加");

		removeButton = new Button(composite, SWT.NONE);
		removeButton.setSize(80, 27);
		removeButton.setText("删除");

		createCellModifier();
		return parent;
	}

	@Override
	public void createUIBindings(EObject eObject) {
		userTask = (UserTask) eObject;

		optFormViewer.seteObject(userTask);
		browseFormViewer.seteObject(userTask);
		
		addButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				FormParam formParam = FoxBPMFactory.eINSTANCE.createFormParam();
				formParam.setParamKey("参数键" + ((List<FormParam>) tableViewer.getInput()).size());
				formParam.setParamType("String");
				Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
				expression.setName("表达式");
				expression.setValue("");
				formParam.setExpression(expression);
				addFormParam(formParam);
				tableViewer.refresh();
			}
		});

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
					FormParam col = (FormParam) objs[i];
					deleteFormParam(col);
				}
				tableViewer.refresh();
			}
		});

		if (userTask.getExtensionValues().size() > 0) {
			ExtensionAttributeValue extensionAttributeValue = userTask.getExtensionValues().get(0);
			formParamContainer = (FormParamContainer) extensionAttributeValue.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__FORM_PARAM_CONTAINER);
			if (formParamContainer == null) {
				formParamContainer = FoxBPMFactory.eINSTANCE.createFormParamContainer();
			}
		}else {
			formParamContainer = FoxBPMFactory.eINSTANCE.createFormParamContainer();
		}

		tableViewer.setContentProvider(new ContentProvider());
		tableViewer.setLabelProvider(new TableLabelProvider());
		tableViewer.setInput(formParamContainer.getFormParam());
		
//		bindFormParamContainer();

		ExtensionAttributeValue extensionAttributeValue = null;
		if(userTask.getExtensionValues().size()>0) {
			extensionAttributeValue = userTask.getExtensionValues().get(0);
		}else {
			extensionAttributeValue = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
		}
		
		FormUri formUri = (FormUri) extensionAttributeValue.getValue().get(FoxBPMPackage.Literals.DOCUMENT_ROOT__FORM_URI, true);
		FormUriView formUriView = (FormUriView) extensionAttributeValue.getValue().get(FoxBPMPackage.Literals.DOCUMENT_ROOT__FORM_URI_VIEW, true);
		Expression formUriformalExpression = null;
		if(formUri==null) {
			formUriformalExpression = FoxBPMFactory.eINSTANCE.createExpression();
			formUriformalExpression.setName("");
			formUriformalExpression.setValue("");
		}else {
			formUriformalExpression = (Expression) formUri.getExpression();
		}
		
		Expression formUriViewformalExpression = FoxBPMFactory.eINSTANCE.createExpression();
		if(formUriView==null) {
			formUriViewformalExpression = FoxBPMFactory.eINSTANCE.createExpression();
			formUriViewformalExpression.setName("");
			formUriViewformalExpression.setValue("");
		}else {
			formUriViewformalExpression = (Expression) formUriView.getExpression();
		}
		

		//viewer上控件值
		optFormViewer.getTextControl().setText(formUriformalExpression==null? "": formUriformalExpression.getName());
		browseFormViewer.getTextControl().setText(formUriViewformalExpression==null? "": formUriViewformalExpression.getName());
		
		//传递表达式对象
		optFormViewer.setExpression(formUriformalExpression);
		browseFormViewer.setExpression(formUriViewformalExpression);
		
		optFormViewer.addExpressionChangedListeners(new IExpressionChangedListener() {

			@Override
			public void expressionChanged(final ExpressionChangedEvent event) {
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						setFormUriExtensionExpression(userTask, event.getFormalExpression());
						
						FormalExpression formalExpression = event.getFormalExpression();
						Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
						if(formalExpression!=null) {
							Object expName = formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME);
							expression.setName(expName==null?"":expName.toString());
							expression.setValue(formalExpression.getBody());
						}
						
						//传递表达式对象
						optFormViewer.setExpression(expression);
					}
				});

			}
		});

		browseFormViewer.addExpressionChangedListeners(new IExpressionChangedListener() {

			@Override
			public void expressionChanged(final ExpressionChangedEvent event) {
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						setFormUriViewExtensionExpression(userTask, event.getFormalExpression());
						
						FormalExpression formalExpression = event.getFormalExpression();
						Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
						if(formalExpression!=null) {
							Object expName = formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME);
							expression.setName(expName==null?"":expName.toString());
							expression.setValue(formalExpression.getBody());
						}
						//传递表达式对象
						optFormViewer.setExpression(expression);
					}
				});

			}
		});
	}

	private void setFormUriExtensionExpression(BaseElement baseElement, FormalExpression formalExpression) {

		for (ExtensionAttributeValue extensionAttributeValue : baseElement.getExtensionValues()) {

			FeatureMap extensionElements = extensionAttributeValue.getValue();
			for (Entry entry : extensionElements) {
				if (entry.getValue() instanceof FormUri) {
					if (formalExpression == null) {
						extensionElements.remove(entry);
					} else {
						FormUri formUri = (FormUri) entry.getValue();
						formUri.getExpression().setName(formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
						formUri.getExpression().setValue(formalExpression.getBody());
					}

					return;
				}
			}

		}
		if (formalExpression != null) {
			FormUri formUri = FoxBPMFactory.eINSTANCE.createFormUri();

			Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
			expression.setName(formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
			expression.setValue(formalExpression.getBody());
			formUri.setExpression(expression);

			FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__FORM_URI, formUri);

			if (baseElement.getExtensionValues().size() > 0) {
				baseElement.getExtensionValues().get(0).getValue().add(extensionElementEntry);
			} else {
				ExtensionAttributeValue extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
				extensionElement.getValue().add(extensionElementEntry);
				baseElement.getExtensionValues().add(extensionElement);
			}
		}
	}

	private void setFormUriViewExtensionExpression(BaseElement baseElement, FormalExpression formalExpression) {

		for (ExtensionAttributeValue extensionAttributeValue : baseElement.getExtensionValues()) {

			FeatureMap extensionElements = extensionAttributeValue.getValue();
			for (Entry entry : extensionElements) {
				if (entry.getValue() instanceof FormUriView) {
					if (formalExpression == null) {
						extensionElements.remove(entry);
					} else {
						FormUriView formUriView = (FormUriView) entry.getValue();
						formUriView.getExpression().setName(formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
						formUriView.getExpression().setValue(formalExpression.getBody());
					}

					return;
				}
			}

		}
		if (formalExpression != null) {
			FormUriView formUriView = FoxBPMFactory.eINSTANCE.createFormUriView();

			Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
			expression.setName(formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
			expression.setValue(formalExpression.getBody());
			formUriView.setExpression(expression);

			FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__FORM_URI_VIEW, formUriView);

			if (baseElement.getExtensionValues().size() > 0) {
				baseElement.getExtensionValues().get(0).getValue().add(extensionElementEntry);
			} else {
				ExtensionAttributeValue extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
				extensionElement.getValue().add(extensionElementEntry);
				baseElement.getExtensionValues().add(extensionElement);
			}
		}
	}

	private void createCellModifier() {
		TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
		final CellEditor[] cellEditor = new CellEditor[table.getColumnCount()];
		cellEditor[0] = new TextCellEditor(table);
		cellEditor[1] = new ComboBoxViewerCellEditor(table, SWT.READ_ONLY);
		cellEditor[2] = new ExpDialogCellEditor(table, getShell(), editingDomain, tableViewer);
		((ComboBoxViewerCellEditor)cellEditor[1]).setContenProvider(ArrayContentProvider.getInstance());
		((ComboBoxViewerCellEditor)cellEditor[1]).setLabelProvider(new LabelProvider() {
			  @Override
			  public String getText(Object element) {
			    if (element instanceof DataTypeDef) {
			    	DataTypeDef dataTypeDef = (DataTypeDef) element;
			      return dataTypeDef.getName();
			    }
			    return super.getText(element);
			  }
			});
		((ComboBoxViewerCellEditor)cellEditor[1]).setInput(FoxBPMDesignerUtil.getDataVariableConfig().getDataVariableDataType().getDataTypeDef());
		tableViewer.setColumnProperties(new String[] { "PARAMKEY", "PARAMTYPE", "PARAMEMP" });
		tableViewer.setCellEditors(cellEditor);
		tableViewer.setCellModifier(new ICellModifier() {

			public void modify(final Object element, final String property, final Object value) {
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						TableItem tableitem = (TableItem) element;
						FormParam formParam = (FormParam) tableitem.getData();
						if (property.equals("PARAMKEY")) {
							formParam.setParamKey((String) value);
						}
						if (property.equals("PARAMTYPE")) {
							if(value == null) {
								formParam.setParamType(DataVarUtil.getDataTypeDefByDataVariableDataType(formParam.getParamType()).getId());
							}else {
								formParam.setParamType(((DataTypeDef)value).getId());
							}
						}
						if (property.equals("PARAMEMP")) {
//							formParam.setExpression(((ExpDialogCellEditor) cellEditor[2]).getExpression());
						}
					}
				});
				tableViewer.refresh();
			}

			public Object getValue(Object element, String property) {
				FormParam formParam = (FormParam) element;

				if (property.equals("PARAMKEY")) {
					return formParam.getParamKey();
				}
				if (property.equals("PARAMTYPE")) {
					return DataVarUtil.getDataTypeDefByDataVariableDataType(formParam.getParamType());
				}
				if (property.equals("PARAMEMP")) {
					((ExpDialogCellEditor) cellEditor[2]).setExpression(formParam.getExpression());
					return formParam.getExpression().getName();
				}
				return null;
			}

			public boolean canModify(Object element, String property) {
				return element instanceof FormParam;
			}
		});
	}

	private static class ContentProvider implements IStructuredContentProvider {
		public Object[] getElements(Object inputElement) {
			if (inputElement != null) {
				return ((List<FormParam>) inputElement).toArray();
			}
			return new Object[0];
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}

	private class TableLabelProvider extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			FormParam formParam = (FormParam) element;
			switch (columnIndex) {
			case 0:
				return formParam.getParamKey();
			case 1:
				return DataVarUtil.getDataTypeDefByDataVariableDataType(formParam.getParamType()).getName();
			case 2:
				return formParam.getExpression().getName();
			}
			return null;
		}
	}
	
	private void addFormParam(final FormParam formParam) {
		TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				if(formParamContainer == null)
					formParamContainer = FoxBPMFactory.eINSTANCE.createFormParamContainer();
				formParamContainer.getFormParam().add(formParam);
				FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__FORM_PARAM_CONTAINER, formParamContainer);
				
				if (userTask.getExtensionValues().size() > 0) {
					userTask.getExtensionValues().get(0).getValue().add(extensionElementEntry);
				} else {
					ExtensionAttributeValue extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
					extensionElement.getValue().add(extensionElementEntry);
					userTask.getExtensionValues().add(extensionElement);
				}
			}
		});
	}
	
	private void deleteFormParam(final FormParam formParam) {
		TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				if(formParamContainer == null)
					formParamContainer = FoxBPMFactory.eINSTANCE.createFormParamContainer();
				formParamContainer.getFormParam().remove(formParam);
				FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__FORM_PARAM_CONTAINER, formParamContainer);
				
				if (userTask.getExtensionValues().size() > 0) {
					userTask.getExtensionValues().get(0).getValue().remove(extensionElementEntry);
				} else {
					ExtensionAttributeValue extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
					extensionElement.getValue().add(extensionElementEntry);
					userTask.getExtensionValues().remove(extensionElement);
				}
			}
		});
	}
}
