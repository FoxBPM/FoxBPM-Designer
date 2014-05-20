package org.foxbpm.bpmn.designer.ui.propertytab.usertask;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpmn2.BaseElement;
import org.eclipse.bpmn2.Bpmn2Factory;
import org.eclipse.bpmn2.ExtensionAttributeValue;
import org.eclipse.bpmn2.HumanPerformer;
import org.eclipse.bpmn2.PotentialOwner;
import org.eclipse.bpmn2.ResourceRole;
import org.eclipse.bpmn2.UserTask;
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
import org.foxbpm.bpmn.designer.ui.actor.runtime.create.AddNewActorConnectorWizard;
import org.foxbpm.bpmn.designer.ui.actor.runtime.modify.ModifyNewActorConnectorWizard;
import org.foxbpm.bpmn.designer.ui.connector.runtime.OverrideNewWizard;
import org.foxbpm.bpmn.designer.ui.tree.TreeViewerNewFactory;
import org.foxbpm.bpmn.designer.ui.utils.ImageUtil;
import org.foxbpm.model.bpmn.foxbpm.ConnectorInstance;
import org.foxbpm.model.bpmn.foxbpm.ConnectorInstanceElements;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;

public class UserTaskAssignmentPropertyComposite extends AbstractFoxBPMComposite {
	private Tree tree;
	private TreeViewer treeViewer;
	private Button editButton;
	private Button removeButton;
	private Button upButton;
	private Button downButton;

	public UserTaskAssignmentPropertyComposite(Composite parent, int style) {
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
				OverrideNewWizard cstd = new OverrideNewWizard(getShell(), new AddNewActorConnectorWizard(getBusinessObject()));
				cstd.setBlockOnOpen(true);
				if (cstd != null && cstd.open() == InputDialog.OK) {
					((List<ConnectorInstance>) treeViewer.getInput()).add(cstd.getActorAddedValue());
					treeViewer.refresh();
					addConnectorInstance(cstd.getActorAddedValue());
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
					ConnectorInstance connectorInstance = (ConnectorInstance) selection.getFirstElement();
					OverrideNewWizard dialog = new OverrideNewWizard(getShell(), new ModifyNewActorConnectorWizard(getBusinessObject(), (BPMN2Editor) getDiagramEditor(), connectorInstance));
					dialog.setPageSize(-1, 470); // -1代表宽度自适应, 240为高度
					if (dialog.open() == InputDialog.OK) {
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
				if (!treeViewer.getSelection().isEmpty()) {
					IStructuredSelection selection = (IStructuredSelection) treeViewer.getSelection();
					ConnectorInstance connectorInstance = (ConnectorInstance) selection.getFirstElement();
					deleteConnectorInstance(connectorInstance);
					((List<PotentialOwner>) treeViewer.getInput()).remove(connectorInstance);
					treeViewer.refresh();
				}
			}
		});

		upButton = new Button(buttonsComposite, SWT.NONE);
		upButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		upButton.setText("向上");
		upButton.addListener(SWT.Selection, new Listener() {

			@SuppressWarnings("unchecked")
			@Override
			public void handleEvent(Event event) {
				IStructuredSelection selection = (IStructuredSelection) treeViewer.getSelection();

				ConnectorInstance instance = (ConnectorInstance) selection.getFirstElement();
				int idx = ((List<ResourceRole>) treeViewer.getInput()).indexOf(instance);
				if (idx != 0) {
					((List<ConnectorInstance>) treeViewer.getInput()).remove(instance);
					deleteConnectorInstance(instance);
					((List<ConnectorInstance>) treeViewer.getInput()).add(idx - 1, instance);
					addConnectorInstance(instance, idx - 1);
				}

				treeViewer.refresh();
				updateButtons();
			}
		});

		downButton = new Button(buttonsComposite, SWT.NONE);
		downButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		downButton.setText("向下");
		downButton.addListener(SWT.Selection, new Listener() {

			@SuppressWarnings("unchecked")
			@Override
			public void handleEvent(Event event) {
				IStructuredSelection selection = (IStructuredSelection) treeViewer.getSelection();

				ConnectorInstance instance = (ConnectorInstance) selection.getFirstElement();
				int idx = ((List<ConnectorInstance>) treeViewer.getInput()).indexOf(instance);
				if (idx != ((List<ConnectorInstance>) treeViewer.getInput()).size() - 1) {
					((List<ConnectorInstance>) treeViewer.getInput()).remove(instance);
					deleteConnectorInstance(instance);
					((List<ConnectorInstance>) treeViewer.getInput()).add(idx + 1, instance);
					addConnectorInstance(instance, idx + 1);
				}

				treeViewer.refresh();
				updateButtons();
			}
		});

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
//				PotentialOwner potentialOwner = Bpmn2Factory.eINSTANCE.createPotentialOwner();
//				ModelUtil.setID(potentialOwner,userTask.eResource());
//				FeatureMap.Entry extensionAttributeEntry = new SimpleFeatureMapEntry((Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__RESOURCE_TYPE, ((GroupInfoTo)typecomboViewer.getElementAt(typecombo.getSelectionIndex())).getTypeId());
//				potentialOwner.getAnyAttribute().add(extensionAttributeEntry);
//				FeatureMap.Entry extensionAttributeEntry1 = new SimpleFeatureMapEntry((Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__INCLUDE_EXCLUSION, inorexcludecombo.getData(inorexcludecombo.getSelectionIndex()+"").toString());
//				potentialOwner.getAnyAttribute().add(extensionAttributeEntry1);
//				FeatureMap.Entry extensionAttributeEntry2 = new SimpleFeatureMapEntry((Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__IS_CONTAINS_SUB, (containsubCheckButton.getSelection()));
//				potentialOwner.getAnyAttribute().add(extensionAttributeEntry2);
				
				UserTask userTask = (UserTask) getBusinessObject();
				PotentialOwner potentialOwner = null;
				
				if(userTask.getResources().size()==0) {
					potentialOwner = Bpmn2Factory.eINSTANCE.createPotentialOwner();
					userTask.getResources().add(potentialOwner);
				} else {
					potentialOwner = (PotentialOwner) userTask.getResources().get(0);
				}
				
				if (potentialOwner.getExtensionValues().size() > 0) {
					for (ExtensionAttributeValue extensionAttributeValue : potentialOwner.getExtensionValues()) {
						FeatureMap extensionElements = extensionAttributeValue.getValue();
						Object objectElement = extensionElements.get(FoxBPMPackage.Literals.DOCUMENT_ROOT__CONNECTOR_INSTANCE_ELEMENTS, true);
						if (objectElement != null) {
							ConnectorInstanceElements connectorInstanceElements = (ConnectorInstanceElements) objectElement;
							connectorInstanceElements.setConnrctorType("actorconnector");
							connectorInstanceElements.getConnectorInstance().add(connectorInstance);
							FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry(
									(org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__CONNECTOR_INSTANCE_ELEMENTS, connectorInstanceElements);
							extensionElements.add(extensionElementEntry);
						}
					}
				} else {
					ExtensionAttributeValue extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
					ConnectorInstanceElements connectorInstanceElements = FoxBPMFactory.eINSTANCE.createConnectorInstanceElements();
					connectorInstanceElements.getConnectorInstance().add(connectorInstance);
					
					FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__CONNECTOR_INSTANCE_ELEMENTS,
							connectorInstanceElements);
					extensionElement.getValue().add(extensionElementEntry);
					potentialOwner.getExtensionValues().add(extensionElement);
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
				UserTask userTask = (UserTask) getBusinessObject();
				
				PotentialOwner potentialOwner = (PotentialOwner) userTask.getResources().get(0);

				if (potentialOwner.getExtensionValues().size() > 0) {

					for (ExtensionAttributeValue extensionAttributeValue : potentialOwner.getExtensionValues()) {

						FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry(
								(org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__CONNECTOR_INSTANCE_ELEMENTS, connectorInstance);
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
				UserTask userTask = (UserTask) getBusinessObject();
				
				PotentialOwner potentialOwner = (PotentialOwner) userTask.getResources().get(0);
				
				if (potentialOwner.getExtensionValues().size() > 0) {
					for (ExtensionAttributeValue extensionAttributeValue : potentialOwner.getExtensionValues()) {
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
					potentialOwner.getExtensionValues().add(extensionElement);
					FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_COMMAND,
							connectorInstance);
					extensionElement.getValue().add(index, extensionElementEntry);
				}
			}
		});
	}

	private static class ViewerLabelProvider extends StyledCellLabelProvider implements ILabelProvider {
		public Image getImage(Object element) {
			Image image2 = ImageUtil.getImageFromName("/connector/user_16_hot.png");
			Image image1 = ImageUtil.getImageFromName("/connector/group_16.png");
			String image3 = ISharedImages.IMG_OBJS_TASK_TSK;
			if (element instanceof PotentialOwner) {
				return image1;
			}
			if (element instanceof HumanPerformer) {
				return image2;
			}
			if (element instanceof ConnectorInstance) {
				return PlatformUI.getWorkbench().getSharedImages().getImage(image3);
			}
			return null;
		}

		public String getText(Object element) {
			return null;
		}

		public String getType(String type) {
			String rstype = "";
			if (type.equals("INCLUDE")) {
				rstype = "包含";
				return rstype;
			}
			if (type.equals("EXCLUSION")) {
				rstype = "排除";
				return rstype;
			}
			return rstype;
		}

		@Override
		public void update(ViewerCell cell) {
			if (cell.getElement() instanceof ResourceRole) {
				ResourceRole d = (ResourceRole) cell.getElement();
				StyledString styledString = new StyledString();
				String decoration = " -- " + getType(d.getAnyAttribute().get(FoxBPMPackage.Literals.DOCUMENT_ROOT__INCLUDE_EXCLUSION, true).toString());
				styledString.append(d.getName());
				styledString.append(decoration, StyledString.DECORATIONS_STYLER);
				cell.setText(styledString.getString());
				cell.setImage(getImage(d));
				cell.setStyleRanges(styledString.getStyleRanges());
			}
			if (cell.getElement() instanceof ConnectorInstance) {
				ConnectorInstance d = (ConnectorInstance) cell.getElement();
				StyledString styledString = new StyledString();
				String decoration = " -- "
				// + getType(d.getEventType())
				// + " -- "
						+ (TreeViewerNewFactory.getActorConnector(d.getConnectorId()) == null ? "" : TreeViewerNewFactory.getActorConnector(d.getConnectorId()).getName());
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

		public boolean hasChildren(Object element) {
			return false;
		}

		public Object getParent(Object element) {
			return null;
		}

		public Object[] getChildren(Object parentElement) {
			return null;
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
	}

	@SuppressWarnings("unchecked")
	private List<ConnectorInstance> getConnectorInstances() {
		List<ConnectorInstance> connectorInstances = new ArrayList<ConnectorInstance>();
		
		UserTask userTask = (UserTask) getBusinessObject();

		if(userTask.getResources().size()==0){
			return connectorInstances;
		}
		
		PotentialOwner potentialOwner = (PotentialOwner) userTask.getResources().get(0);

		if (potentialOwner.getExtensionValues().size() > 0) {
			for (ExtensionAttributeValue extensionAttributeValue : potentialOwner.getExtensionValues()) {
				FeatureMap extensionElements = extensionAttributeValue.getValue();
				Object objectElement = extensionElements.get(FoxBPMPackage.Literals.DOCUMENT_ROOT__CONNECTOR_INSTANCE, true);
				if (objectElement != null) {

					List<ConnectorInstance> connectorInstanceList = (List<ConnectorInstance>) objectElement;
					for (ConnectorInstance connectorInstance : connectorInstanceList) {
						if (connectorInstance.getType() != null && connectorInstance.getType().equals("actorconnector") || connectorInstance.getType() == null)
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
