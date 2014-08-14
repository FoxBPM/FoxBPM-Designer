package org.foxbpm.bpmn.designer.ui.propertytab.actors;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpmn2.Bpmn2Factory;
import org.eclipse.bpmn2.ExtensionAttributeValue;
import org.eclipse.bpmn2.Process;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl.SimpleFeatureMapEntry;
import org.eclipse.emf.ecore.util.FeatureMap;
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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.foxbpm.bpmn.designer.base.model.GroupDefine;
import org.foxbpm.bpmn.designer.base.utils.FileUtil;
import org.foxbpm.bpmn.designer.base.utils.FoxBPMDesignerUtil;
import org.foxbpm.bpmn.designer.base.utils.JsonDataUtil;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMComposite;
import org.foxbpm.bpmn.designer.ui.custom.PotentialStarterDialogCellEditor;
import org.foxbpm.bpmn.designer.ui.dialogs.DataVarTo;
import org.foxbpm.bpmn.designer.ui.utils.BpmnModelUtil;
import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FormUri;
import org.foxbpm.model.bpmn.foxbpm.FormUriView;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;
import org.foxbpm.model.bpmn.foxbpm.PotentialStarter;

public class ActorsPropertyComposite extends AbstractFoxBPMComposite {
	private Process process;
	private Table table;
	private TableViewer tableViewer;
	private Button addButton;
	private Button removeButton;
	private List<PotentialStarter> potentialStarters = new ArrayList<PotentialStarter>();
	private List<DataVarTo> bizTypes;

	public ActorsPropertyComposite(Composite parent, int style) {
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

		tableViewer = new TableViewer(detailComposite, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		GridData gd_table = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		gd_table.heightHint = 80;
		table.setLayoutData(gd_table);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn nameColumn = tableViewerColumn.getColumn();
		nameColumn.setWidth(150);
		nameColumn.setText("名称");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn typeColumn = tableViewerColumn_1.getColumn();
		typeColumn.setWidth(100);
		typeColumn.setText("类型");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn descColumn = tableViewerColumn_2.getColumn();
		descColumn.setWidth(350);
		descColumn.setText("描述");

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
		process = (Process) BpmnModelUtil.getProcessByEobj(eObject);

		addButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				PotentialStarter potentialStarter = FoxBPMFactory.eINSTANCE.createPotentialStarter();
				Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
				expression.setName("名称" + ((List<PotentialStarter>) tableViewer.getInput()).size());
				expression.setValue("");
				potentialStarter.setDescription("");
				potentialStarter.setResourceType("user");
				potentialStarter.setExpression(expression);
				addPotentialStarter(potentialStarter);
				((List<PotentialStarter>) tableViewer.getInput()).add(potentialStarter);
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
					PotentialStarter col = (PotentialStarter) objs[i];
					deletePotentialStarter(col);
					((List<PotentialStarter>)tableViewer.getInput()).remove(col);
				}
				tableViewer.refresh();
			}
		});

		if (process.getExtensionValues().size() > 0) {
			for (ExtensionAttributeValue extensionAttributeValue : process.getExtensionValues()) {
				FeatureMap extensionElements = extensionAttributeValue.getValue();
				for (int i = 0; i < extensionElements.size(); i++) {
					if(extensionElements.getValue(i) instanceof PotentialStarter) {
						potentialStarters.add((PotentialStarter) extensionElements.getValue(i));
					}
				}
			}
		}

		tableViewer.setContentProvider(new ContentProvider());
		tableViewer.setLabelProvider(new TableLabelProvider());
		tableViewer.setInput(potentialStarters);
		
		ExtensionAttributeValue extensionAttributeValue = null;
		if(process.getExtensionValues().size()>0) {
			extensionAttributeValue = process.getExtensionValues().get(0);
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

	}

	private void createCellModifier() {
		bizTypes = new ArrayList<DataVarTo>();
		
		TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
		final CellEditor[] cellEditor = new CellEditor[table.getColumnCount()];
		cellEditor[0] = new PotentialStarterDialogCellEditor(table, getShell(), editingDomain, tableViewer);
		cellEditor[1] = new ComboBoxViewerCellEditor(table, SWT.READ_ONLY);
		cellEditor[2] = new TextCellEditor(table);
		((ComboBoxViewerCellEditor)cellEditor[1]).setContenProvider(ArrayContentProvider.getInstance());
		((ComboBoxViewerCellEditor)cellEditor[1]).setLabelProvider(new LabelProvider() {
			  @Override
			  public String getText(Object element) {
			    if (element instanceof DataVarTo) {
			    	DataVarTo dataVarTo = (DataVarTo) element;
			      return dataVarTo.getName();
			    }
			    return super.getText(element);
			  }
			});
		
		ArrayList<GroupDefine> groupDefines = null;
		try {
			File file = new File(FoxBPMDesignerUtil.getCachePath() + "/allGroupDefinitions.data");
			if(file.exists()) {
				String jsonString = FileUtil.readFile2StringUTF8(FoxBPMDesignerUtil.getCachePath() + "/allGroupDefinitions.data");
				JsonDataUtil instance = JsonDataUtil.getInstance();
				groupDefines = (ArrayList<GroupDefine>) instance.analysisJsonToObj(jsonString, GroupDefine.class);
				
				for (GroupDefine groupDefine : groupDefines) {
					DataVarTo dataVarTo = new DataVarTo();
					dataVarTo.setName(groupDefine.getName());
					dataVarTo.setType(groupDefine.getType());
					bizTypes.add(dataVarTo);
				}
				DataVarTo dataVarTo = new DataVarTo();
				dataVarTo.setName("用户");
				dataVarTo.setType("user");
				bizTypes.add(dataVarTo);
				
			}else {
				MessageDialog.openInformation(null, "提示", "未找到缓存文件，请同步流程资源");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null == groupDefines) {
			groupDefines = new ArrayList<GroupDefine>();
		}

		
		((ComboBoxViewerCellEditor)cellEditor[1]).setInput(bizTypes);
		
		tableViewer.setColumnProperties(new String[] { "STARTORNAME", "STARTORTYPE", "STARTORDESC" });
		tableViewer.setCellEditors(cellEditor);
		tableViewer.setCellModifier(new ICellModifier() {

			public void modify(final Object element, final String property, final Object value) {
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						TableItem tableitem = (TableItem) element;
						PotentialStarter potentialStarter = (PotentialStarter) tableitem.getData();
						if (property.equals("STARTORNAME")) {
//							potentialStarter.setExpression(((ExpDialogCellEditor) cellEditor[0]).getExpression());
						}
						if (property.equals("STARTORTYPE")) {
							if(value==null) {
								potentialStarter.setResourceType(getResourceTypeByValue(potentialStarter.getResourceType()).getType());
							}else {
								potentialStarter.setResourceType(((DataVarTo) value).getType());
							}
						}
						if (property.equals("STARTORDESC")) {
							potentialStarter.setDescription((String) value);
						}
					}
				});
				tableViewer.refresh();
			}

			public Object getValue(Object element, String property) {
				PotentialStarter potentialStarter = (PotentialStarter) element;
				if (property.equals("STARTORNAME")) {
					((PotentialStarterDialogCellEditor) cellEditor[0]).setExpression(potentialStarter.getExpression());
					return potentialStarter.getExpression().getName();
				}
				if (property.equals("STARTORTYPE")) {
					return getResourceTypeByValue(potentialStarter.getResourceType());
				}
				if (property.equals("STARTORDESC")) {
					return potentialStarter.getDescription();
				}
				return null;
			}

			public boolean canModify(Object element, String property) {
				return element instanceof PotentialStarter;
			}
		});
	}

	private static class ContentProvider implements IStructuredContentProvider {
		public Object[] getElements(Object inputElement) {
			if (inputElement != null) {
				return ((List<PotentialStarter>) inputElement).toArray();
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
			PotentialStarter potentialStarter = (PotentialStarter) element;
			switch (columnIndex) {
			case 0:
				return potentialStarter.getExpression().getName();
			case 1:
				return getResourceTypeByValue(potentialStarter.getResourceType()).getName();
			case 2:
				return potentialStarter.getDescription();
			}
			return null;
		}
	}
	
	private DataVarTo getResourceTypeByValue(String value) {
		DataVarTo newdataVarTo = null;
		for (DataVarTo dataVarTo : bizTypes) {
			if(dataVarTo.getType().equals(value)) {
				newdataVarTo = dataVarTo;
				break;
			}
		}
		return newdataVarTo;
	}
	
	private void addPotentialStarter(final PotentialStarter potentialStarter) {
		TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__POTENTIAL_STARTER, potentialStarter);
				
				if (process.getExtensionValues().size() > 0) {
					process.getExtensionValues().get(0).getValue().add(extensionElementEntry);
				} else {
					ExtensionAttributeValue extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
					extensionElement.getValue().add(extensionElementEntry);
					process.getExtensionValues().add(extensionElement);
				}
			}
		});
	}
	
	private void deletePotentialStarter(final PotentialStarter potentialStarter) {
		TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__POTENTIAL_STARTER, potentialStarter);
				
				if (process.getExtensionValues().size() > 0) {
					process.getExtensionValues().get(0).getValue().remove(extensionElementEntry);
				} else {
					ExtensionAttributeValue extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
					extensionElement.getValue().add(extensionElementEntry);
					process.getExtensionValues().remove(extensionElement);
				}
			}
		});
	}
	
}
