package org.foxbpm.bpmn.designer.ui.propertytab.variable;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpmn2.BaseElement;
import org.eclipse.bpmn2.Bpmn2Factory;
import org.eclipse.bpmn2.ExtensionAttributeValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl.SimpleFeatureMapEntry;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMComposite;
import org.foxbpm.bpmn.designer.ui.dialogs.DataVariableDialog;
import org.foxbpm.bpmn.designer.ui.utils.DataVarUtil;
import org.foxbpm.bpmn.designer.ui.utils.ImageUtil;
import org.foxbpm.model.bpmn.foxbpm.ConnectorInstance;
import org.foxbpm.model.bpmn.foxbpm.DataVariable;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;
import org.foxbpm.model.config.variableconfig.DataVariableBizType;
import org.eclipse.swt.widgets.Label;

public class DataVariablePropertyComposite extends AbstractFoxBPMComposite {
	private Tree tree;
	private TreeViewer treeViewer;
	private Button editButton;
	private Button removeButton;

	public DataVariablePropertyComposite(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public void createUIBindings(EObject eObject) {
		treeViewer.setInput(getDataVariable());
	}

	@Override
	public Composite createUI(Composite parent) {

		GridLayout gridLayout = (GridLayout) parent.getLayout();
		gridLayout.numColumns = 1;
		Composite detailComposite = new Composite(parent, SWT.NONE);
		detailComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		detailComposite.setLayout(new GridLayout(1, false));

		PatternFilter filter = new PatternFilter();

		Composite composite = new Composite(detailComposite, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		FilteredTree filteredTree = new FilteredTree(composite, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER, filter, true);
		treeViewer = filteredTree.getViewer();
		tree = treeViewer.getTree();
		treeViewer.setLabelProvider(new ViewerLabelProvider());
		treeViewer.setContentProvider(new TreeContentProvider());

		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				updateButtons();
			}
		});

		Composite buttonsComposite = new Composite(composite, SWT.NONE);
		GridData gd_buttonsComposite = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_buttonsComposite.heightHint = 150;
		buttonsComposite.setLayoutData(gd_buttonsComposite);
		buttonsComposite.setSize(45, 139);
		GridLayout gl_buttonsComposite = new GridLayout(1, false);
		gl_buttonsComposite.verticalSpacing = 1;
		gl_buttonsComposite.marginWidth = 0;
		gl_buttonsComposite.marginHeight = 0;
		gl_buttonsComposite.horizontalSpacing = 0;
		buttonsComposite.setLayout(gl_buttonsComposite);

		Button addButton = new Button(buttonsComposite, SWT.NONE);
		GridData gd_addButton = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_addButton.widthHint = 80;
		addButton.setLayoutData(gd_addButton);
		addButton.setText("添加...");
		addButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				DataVariableDialog dvd = new DataVariableDialog(getBusinessObject(), getShell());
				dvd.setBlockOnOpen(true);
				if (dvd != null && dvd.open() == InputDialog.OK) {
					((List<DataVariable>) treeViewer.getInput()).add(dvd.getDataVariable());
					treeViewer.refresh();
					addDataVariable(dvd.getDataVariable());
					updateButtons();
				}
			}
		});

		editButton = new Button(buttonsComposite, SWT.NONE);
		editButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		editButton.setText("编辑...");
		editButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				if (!treeViewer.getSelection().isEmpty()) {
					IStructuredSelection selection = (IStructuredSelection) treeViewer.getSelection();
					DataVariable dataVariable = (DataVariable) selection.getFirstElement();
					DataVariableDialog dvd = new DataVariableDialog(getBusinessObject(), getShell(), dataVariable);
					dvd.setBlockOnOpen(true);
					if (dvd != null && dvd.open() == InputDialog.OK) {
						DataVariable newDataVariable = dvd.getDataVariable();
						editDataVariable(dataVariable, newDataVariable);
						int index = ((List<DataVariable>) treeViewer.getInput()).indexOf(dataVariable);
						((List<DataVariable>) treeViewer.getInput()).remove(dataVariable);
						((List<DataVariable>) treeViewer.getInput()).add(index, newDataVariable);
						treeViewer.refresh();
					}
				}
			}
		});
		
				removeButton = new Button(buttonsComposite, SWT.NONE);
				removeButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
				removeButton.setText("删除");
				removeButton.addListener(SWT.Selection, new Listener() {

					@SuppressWarnings("unchecked")
					@Override
					public void handleEvent(Event event) {
						ISelection sel = treeViewer.getSelection();
						if (sel == null)
							return;
						Object[] objs = ((IStructuredSelection) sel).toArray();
						if (objs == null || objs.length == 0)
							return;
						boolean b = MessageDialog.openConfirm(null, "警告", "你确认要删除吗？");
						if (!b)
							return;

						for (int i = 0; i < objs.length; i++) {
							DataVariable col = (DataVariable) objs[i];
							deleteDataVariable(col);
							((List<DataVariable>) treeViewer.getInput()).remove(col);
						}
						treeViewer.refresh();
						updateButtons();
					}
				});
		
		Button importButton = new Button(buttonsComposite, SWT.NONE);
		importButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		importButton.setText("导入...");
		importButton.setVisible(false);

		updateButtons();
		return parent;
	}

	@Override
	public String setDescId() {
		return "";
	}

	private static class ViewerLabelProvider extends StyledCellLabelProvider implements ILabelProvider {
		public Image getImage(Object element) {
			Image image = ImageUtil.getImageFromName("/datavar/datavar_16.png");
			if (element instanceof DataVariable) {
				DataVariable dataVariable = (DataVariable) element;
				if(dataVariable.getBizType()!=null && !dataVariable.getBizType().equals("")) {
					image = ImageUtil.getImageFromName("/datavar/" + DataVarUtil.getDataVariableBizType(dataVariable.getBizType()).getImg());
				}
				
				return image;
			}
			return null;
		}

		public String getText(Object element) {
			DataVariable treeElement = (DataVariable) element;
			return treeElement.getId() + " -- " + DataVarUtil.getDataTypeDefByDataVariableDataType(treeElement.getDataType()).getId();
		}

		@Override
		public void update(ViewerCell cell) {
			if (cell.getElement() instanceof DataVariable) {
				DataVariable d = (DataVariable) cell.getElement();
				StyledString styledString = new StyledString();
				String decoration = "【" + DataVarUtil.getDataTypeDefByDataVariableDataType(d.getDataType()).getName() + "】";

				DataVariableBizType dataVariableBizType = DataVarUtil.getDataVariableBizType(d.getBizType());
				if (dataVariableBizType != null) {
					decoration = decoration + "【" + dataVariableBizType.getTypeName() + "】";
				}

				styledString.append(d.getId() == null ? "" : d.getId());
				styledString.append(decoration, StyledString.DECORATIONS_STYLER);
				cell.setText(styledString.getString());
				cell.setImage(getImage(d));
				cell.setStyleRanges(styledString.getStyleRanges());
			}
		}
	}

	private static class TreeContentProvider implements ITreeContentProvider {
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof List) {
				@SuppressWarnings("rawtypes")
				List list = (List) inputElement;
				return list.toArray();
			} else {
				return new Object[0];
			}
		}

		public Object[] getChildren(Object parentElement) {
			return null;
		}

		public Object getParent(Object element) {
			return null;
		}

		public boolean hasChildren(Object element) {
			return false;
		}
	}

	/**
	 * 设置按钮可用性
	 */
	@SuppressWarnings("unchecked")
	public void updateButtons() {
		Object selectedPage = ((IStructuredSelection) treeViewer.getSelection()).getFirstElement();
		int index = 0;
		while (selectedPage != null && ((List<ConnectorInstance>) treeViewer.getInput()).get(index) != null && !selectedPage.equals(((List<ConnectorInstance>) treeViewer.getInput()).get(index))) {
			index++;
		}
		removeButton.setEnabled(selectedPage != null);
		editButton.setEnabled(selectedPage != null);
	}

	private void addDataVariable(final DataVariable dataVariable) {
		TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				BaseElement baseElement = (BaseElement) getBusinessObject();

				if (baseElement.getExtensionValues().size() > 0) {

					for (ExtensionAttributeValue extensionAttributeValue : baseElement.getExtensionValues()) {

						FeatureMap extensionElements = extensionAttributeValue.getValue();
						Object objectElement = extensionElements.get(FoxBPMPackage.Literals.DOCUMENT_ROOT__DATA_VARIABLE, true);
						if (objectElement != null) {
							FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__DATA_VARIABLE,
									dataVariable);
							extensionElements.add(extensionElementEntry);
						}

					}
				} else {
					ExtensionAttributeValue extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
					baseElement.getExtensionValues().add(extensionElement);
					FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__DATA_VARIABLE,
							dataVariable);
					extensionElement.getValue().add(extensionElementEntry);
				}
			}
		});
	}

	private void editDataVariable(final DataVariable oldDataVariable, final DataVariable newDataVariable) {
		TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				BaseElement baseElement = (BaseElement) getBusinessObject();

				if (baseElement.getExtensionValues().size() > 0) {

					for (ExtensionAttributeValue extensionAttributeValue : baseElement.getExtensionValues()) {

						FeatureMap.Entry oldextensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__DATA_VARIABLE,
								oldDataVariable);
						FeatureMap.Entry newextensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__DATA_VARIABLE,
								newDataVariable);
						FeatureMap extensionElements = extensionAttributeValue.getValue();
						extensionElements.remove(oldextensionElementEntry);
						extensionElements.add(newextensionElementEntry);
					}
				}
			}
		});
	}

	private void deleteDataVariable(final DataVariable dataVariable) {
		TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				BaseElement baseElement = (BaseElement) getBusinessObject();

				if (baseElement.getExtensionValues().size() > 0) {

					for (ExtensionAttributeValue extensionAttributeValue : baseElement.getExtensionValues()) {

						FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__DATA_VARIABLE,
								dataVariable);
						FeatureMap extensionElements = extensionAttributeValue.getValue();
						extensionElements.remove(extensionElementEntry);

					}
				}
			}
		});
	}

	@SuppressWarnings("unchecked")
	private List<DataVariable> getDataVariable() {
		BaseElement baseElement = (BaseElement) getBusinessObject();
		List<DataVariable> dataVariables = new ArrayList<DataVariable>();

		if (baseElement.getExtensionValues().size() > 0) {
			for (ExtensionAttributeValue extensionAttributeValue : baseElement.getExtensionValues()) {
				FeatureMap extensionElements = extensionAttributeValue.getValue();
				Object objectElement = extensionElements.get(FoxBPMPackage.Literals.DOCUMENT_ROOT__DATA_VARIABLE, true);
				if (objectElement != null) {
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
	 * 删除多个EMF元素
	 * 
	 * @param removedataVariables
	 */
	private void deleteDataVariables(final List<DataVariable> removedataVariables) {
		TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				List<FeatureMap.Entry> entries = new ArrayList<FeatureMap.Entry>();

				BaseElement baseElement = (BaseElement) getBusinessObject();

				if (baseElement.getExtensionValues().size() > 0) {

					for (ExtensionAttributeValue extensionAttributeValue : baseElement.getExtensionValues()) {

						for (DataVariable dataVariable2 : removedataVariables) {
							FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__DATA_VARIABLE,
									dataVariable2);
							entries.add(extensionElementEntry);
						}

						FeatureMap extensionElements = extensionAttributeValue.getValue();
						extensionElements.removeAll(entries);

					}
				}
			}
		});
	}

	/**
	 * 增加多个EMF元素
	 * 
	 * @param dataVariables
	 */
	private void addDataVariables(final List<DataVariable> dataVariables) {
		TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				List<FeatureMap.Entry> entries = new ArrayList<FeatureMap.Entry>();

				BaseElement baseElement = (BaseElement) getBusinessObject();

				if (baseElement.getExtensionValues().size() > 0) {

					for (ExtensionAttributeValue extensionAttributeValue : baseElement.getExtensionValues()) {

						FeatureMap extensionElements = extensionAttributeValue.getValue();
						Object objectElement = extensionElements.get(FoxBPMPackage.Literals.DOCUMENT_ROOT__DATA_VARIABLE, true);
						if (objectElement != null) {
							for (DataVariable dataVariable2 : dataVariables) {
								FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry(
										(org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__DATA_VARIABLE, dataVariable2);
								entries.add(extensionElementEntry);
							}

							extensionElements.addAll(entries);
						}

					}
				} else {
					ExtensionAttributeValue extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
					baseElement.getExtensionValues().add(extensionElement);
					for (DataVariable dataVariable2 : dataVariables) {
						FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__DATA_VARIABLE,
								dataVariable2);
						entries.add(extensionElementEntry);
					}
					extensionElement.getValue().addAll(entries);
				}
			}
		});
	}
}
