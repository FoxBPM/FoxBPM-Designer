package org.foxbpm.bpmn.designer.ui.propertytab.connector;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpmn2.BaseElement;
import org.eclipse.bpmn2.Bpmn2Factory;
import org.eclipse.bpmn2.ExtensionAttributeValue;
import org.eclipse.bpmn2.modeler.ui.editor.BPMN2Editor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl.SimpleFeatureMapEntry;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMComposite;
import org.foxbpm.bpmn.designer.ui.connector.runtime.AddNewConnectorWizard;
import org.foxbpm.bpmn.designer.ui.connector.runtime.OverrideNewWizard;
import org.foxbpm.bpmn.designer.ui.tree.TreeViewerNewFactory;
import org.foxbpm.bpmn.designer.ui.utils.ConnectorUtil;
import org.foxbpm.model.bpmn.foxbpm.ConnectorInstance;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;

public class ConnectorPropertyComposite extends AbstractFoxBPMComposite {
	private Tree tree;
	private TreeViewer treeViewer;
	private Button editButton;
	private Button removeButton;
	private Button upButton;
	private Button downButton;

	public ConnectorPropertyComposite(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public void createUIBindings(EObject eObject) {
		treeViewer.setInput(getConnectorInstances());
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
		FilteredTree filteredTree = new FilteredTree(composite, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER, filter, true);
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
		buttonsComposite.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
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
				OverrideNewWizard dialog = new OverrideNewWizard(getShell(), new AddNewConnectorWizard(getBusinessObject()));
				dialog.setPageSize(-1, 500); // -1代表宽度自适应, 240为高度
				if (dialog.open() == InputDialog.OK) {
					// 获取实例
					((List<ConnectorInstance>) treeViewer.getInput()).add(dialog.getAddedValue());
					treeViewer.refresh();
					// 添加实例
					addConnectorInstance(dialog.getAddedValue());
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
//					// 得到当前选中的ConnectorInstance对象
//					IStructuredSelection selection = (IStructuredSelection) treeViewer.getSelection();
//					ConnectorInstance connectorInstance = (ConnectorInstance) selection.getFirstElement();
//
//					// 根据类型启动不同对话框
//					WizardDialog dialog = null;
//					if (connectorInstance.getType() == null || connectorInstance.getType().equals(""))
//						dialog = new OverrideWizard(getShell(), new ModifyConnectorWizard(getBusinessObject(), (BPMN2Editor) getDiagramEditor(), connectorInstance));
//					else
//						dialog = new OverrideNewWizard(getShell(), new ModifyNewConnectorWizard(getBusinessObject(), (BPMN2Editor) getDiagramEditor(), connectorInstance));
//
//					dialog.setPageSize(-1, 470); // -1代表宽度自适应, 240为高度
//					if (dialog.open() == InputDialog.OK) {
//						treeViewer.refresh();
//					}
				}
			}
		});

		removeButton = new Button(buttonsComposite, SWT.NONE);
		removeButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		removeButton.setText("删除");

		upButton = new Button(buttonsComposite, SWT.NONE);
		upButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		upButton.setText("向上");

		downButton = new Button(buttonsComposite, SWT.NONE);
		downButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		downButton.setText("向下");

		updateButtons();
		return parent;
	}

	@Override
	public String setDescId() {
		return "";
	}

	/**
	 * 添加连接器实例
	 * 
	 * @param connectorInstance
	 */
	private void addConnectorInstance(final ConnectorInstance connectorInstance) {
		TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				BaseElement baseElement = (BaseElement) getBusinessObject();
				if (baseElement.getExtensionValues().size() > 0) {
					for (ExtensionAttributeValue extensionAttributeValue : baseElement.getExtensionValues()) {
						FeatureMap extensionElements = extensionAttributeValue.getValue();
						Object objectElement = extensionElements.get(FoxBPMPackage.Literals.DOCUMENT_ROOT__CONNECTOR_INSTANCE, true);
						if (objectElement != null) {
							FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry(
									(org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__CONNECTOR_INSTANCE, connectorInstance);
							extensionElements.add(extensionElementEntry);
						}
					}
				} else {
					ExtensionAttributeValue extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
					baseElement.getExtensionValues().add(extensionElement);
					FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__CONNECTOR_INSTANCE,
							connectorInstance);
					extensionElement.getValue().add(extensionElementEntry);
				}
			}
		});
	}

	/**
	 * 删除连接器实例
	 * 
	 * @param connectorInstance
	 */
	private void deleteConnectorInstance(final ConnectorInstance connectorInstance) {
		TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				BaseElement baseElement = (BaseElement) getBusinessObject();

				if (baseElement.getExtensionValues().size() > 0) {

					for (ExtensionAttributeValue extensionAttributeValue : baseElement.getExtensionValues()) {

						FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry(
								(org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__CONNECTOR_INSTANCE, connectorInstance);
						FeatureMap extensionElements = extensionAttributeValue.getValue();
						extensionElements.remove(extensionElementEntry);

					}
				}
			}
		});
	}

	/**
	 * 向上向下时添加连接器实例
	 * 
	 * @param connectorInstance
	 */
	private void addConnectorInstance(final ConnectorInstance connectorInstance, final int index) {
		TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				BaseElement baseElement = (BaseElement) getBusinessObject();
				if (baseElement.getExtensionValues().size() > 0) {
					for (ExtensionAttributeValue extensionAttributeValue : baseElement.getExtensionValues()) {
						FeatureMap extensionElements = extensionAttributeValue.getValue();
						Object objectElement = extensionElements.get(FoxBPMPackage.Literals.DOCUMENT_ROOT__CONNECTOR_INSTANCE, true);
						if (objectElement != null) {
							FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry(
									(org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__CONNECTOR_INSTANCE, connectorInstance);
							extensionElements.add(index, extensionElementEntry);
						}
					}
				} else {
					ExtensionAttributeValue extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
					baseElement.getExtensionValues().add(extensionElement);
					FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_COMMAND,
							connectorInstance);
					extensionElement.getValue().add(index, extensionElementEntry);
				}
			}
		});
	}

	private static class ViewerLabelProvider extends StyledCellLabelProvider implements ILabelProvider {
		public Image getImage(Object element) {
			@SuppressWarnings("deprecation")
			String image1 = ISharedImages.IMG_OBJS_TASK_TSK;
			if (element instanceof ConnectorInstance) {
				return PlatformUI.getWorkbench().getSharedImages().getImage(image1);
			}
			return null;
		}

		public String getText(Object element) {
			ConnectorInstance treeElement = (ConnectorInstance) element;
			return treeElement.getConnectorInstanceName() + " -- " + getType(treeElement.getEventType()) + "--"
					+ ConnectorUtil.getFlowConnectorByMenuConnectorId(treeElement.getConnectorInstanceId()).getNote();
		}

		public String getType(String type) {
			String cntype = "";
			if (type.equals("process-start")) {
				cntype = "启动";
				return cntype;
			}
			if (type.equals("process-abort")) {
				cntype = "终止";
				return cntype;
			}
			if (type.equals("process-end")) {
				cntype = "结束";
				return cntype;
			}
			if (type.equals("node-enter")) {
				cntype = "进入";
				return cntype;
			}
			if (type.equals("task-assign")) {
				cntype = "分配";
				return cntype;
			}
			if (type.equals("node-leave")) {
				cntype = "离开";
				return cntype;
			}
			return cntype;
		}

		@Override
		public void update(ViewerCell cell) {
			if (cell.getElement() instanceof ConnectorInstance) {
				ConnectorInstance d = (ConnectorInstance) cell.getElement();
				StyledString styledString = new StyledString();
				String decoration = " -- "
						+ getType(d.getEventType())
						+ " -- "
						+ (TreeViewerNewFactory.getConnector(d.getConnectorId()) == null ? (ConnectorUtil.getFlowConnectorByMenuConnectorId(d.getConnectorId()) == null ? "" : ConnectorUtil
								.getFlowConnectorByMenuConnectorId(d.getConnectorId()).getName()) : (TreeViewerNewFactory.getConnector(d.getConnectorId()).getName() == null ? ""
								: TreeViewerNewFactory.getConnector(d.getConnectorId()).getName()));
				styledString.append(d.getConnectorInstanceName());
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

	@SuppressWarnings("unchecked")
	private List<ConnectorInstance> getConnectorInstances() {
		BaseElement baseElement = (BaseElement) getBusinessObject();
		List<ConnectorInstance> connectorInstances = new ArrayList<ConnectorInstance>();

		if (baseElement.getExtensionValues().size() > 0) {
			for (ExtensionAttributeValue extensionAttributeValue : baseElement.getExtensionValues()) {
				FeatureMap extensionElements = extensionAttributeValue.getValue();
				Object objectElement = extensionElements.get(FoxBPMPackage.Literals.DOCUMENT_ROOT__CONNECTOR_INSTANCE, true);
				if (objectElement != null) {

					List<ConnectorInstance> connectorInstanceList = (List<ConnectorInstance>) objectElement;
					for (ConnectorInstance connectorInstance : connectorInstanceList) {
						if (connectorInstance.getType() != null && connectorInstance.getType().equals("flowconnector") || connectorInstance.getType() == null)
							connectorInstances.add(connectorInstance);
					}

				}
			}
		}

		return connectorInstances;
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
		upButton.setEnabled(selectedPage != null && index != 0);
		downButton.setEnabled(selectedPage != null && index != treeViewer.getTree().getItemCount() - 1);
	}
}
