package org.foxbpm.bpmn.designer.ui.propertytab.usertask;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpmn2.Bpmn2Factory;
import org.eclipse.bpmn2.ExtensionAttributeValue;
import org.eclipse.bpmn2.UserTask;
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
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.foxbpm.bpmn.designer.base.utils.FoxBPMDesignerUtil;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMComposite;
import org.foxbpm.bpmn.designer.ui.dialogs.CreateNewTaskDialog;
import org.foxbpm.bpmn.designer.ui.utils.ImageUtil;
import org.foxbpm.model.bpmn.foxbpm.ConnectorInstance;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;
import org.foxbpm.model.bpmn.foxbpm.TaskCommand;
import org.foxbpm.model.bpmn.foxbpm.impl.TaskCommandImpl;
import org.foxbpm.model.config.foxbpmconfig.TaskCommandDefinition;

public class UserTaskCommandPropertyComposite extends AbstractFoxBPMComposite {
	private Tree tree;
	private TreeViewer treeViewer;
	private Button editButton;
	private Button removeButton;
	private Button upButton;
	private Button downButton;

	public UserTaskCommandPropertyComposite(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public void createUIBindings(EObject eObject) {
		 treeViewer.setInput(getAdvanceTaskCommands());
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
				CreateNewTaskDialog cnd = new CreateNewTaskDialog(getBusinessObject(), getShell(), treeViewer);
				cnd.setBlockOnOpen(true);
				if (cnd != null && cnd.open() == InputDialog.OK) {
					((List<TaskCommand>) treeViewer.getInput()).add(cnd.getTaskCommand());
					treeViewer.refresh();
					addTaskCommand(cnd.getTaskCommand());
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
					TaskCommand taskCommand = (TaskCommand) selection.getFirstElement();
					CreateNewTaskDialog cnd = new CreateNewTaskDialog(getBusinessObject(), getShell(), taskCommand, treeViewer);
					cnd.setBlockOnOpen(true);
					if (cnd != null && cnd.open() == InputDialog.OK) {
						TaskCommand newTaskCommand = cnd.getTaskCommand();
						int index = ((List<TaskCommand>) treeViewer.getInput()).indexOf(taskCommand);
						editTaskCommand(taskCommand, newTaskCommand, index + 1);
						((List<TaskCommand>) treeViewer.getInput()).remove(taskCommand);
						((List<TaskCommand>) treeViewer.getInput()).add(index, newTaskCommand);
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
					TaskCommand taskCommand = (TaskCommand) selection.getFirstElement();
					deleteTaskCommand(taskCommand);
					((List<TaskCommand>) treeViewer.getInput()).remove(taskCommand);
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
				TaskCommand taskCommand = (TaskCommand) selection.getFirstElement();
				int idx = ((List<TaskCommand>) treeViewer.getInput()).indexOf(taskCommand);
				if (idx != 0) {
					((List<TaskCommand>) treeViewer.getInput()).remove(taskCommand);
					deleteTaskCommand(taskCommand);
					((List<TaskCommand>) treeViewer.getInput()).add(idx - 1, taskCommand);
					addTaskCommand(taskCommand, idx - 1);
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
				TaskCommand taskCommand = (TaskCommand) selection.getFirstElement();
				int idx = ((List<TaskCommand>) treeViewer.getInput()).indexOf(taskCommand);
				if (idx != ((List<TaskCommand>) treeViewer.getInput()).size() - 1) {
					((List<TaskCommand>) treeViewer.getInput()).remove(taskCommand);
					deleteTaskCommand(taskCommand);
					((List<TaskCommand>) treeViewer.getInput()).add(idx + 1, taskCommand);
					addTaskCommand(taskCommand, idx + 1);
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

	private static class ViewerLabelProvider extends StyledCellLabelProvider implements ILabelProvider {
		public Image getImage(Object element) {
			Image image = ImageUtil.getImageFromName("/property/chulimingling_16.png");
			if (element instanceof TaskCommand) {
				return image;
			}
			return null;
		}

		public String getText(Object element) {
			TaskCommand treeElement = (TaskCommand) element;
			return treeElement.getName() + " -- " + getType(treeElement.getCommandType());
		}

		public String getType(String type) {
			String cntype = "";
			List<TaskCommandDefinition> nameList = FoxBPMDesignerUtil.getTaskCommandNames(FoxBPMDesignerUtil.getFoxBPMConfig());
			for (int i = 0; i < nameList.size(); i++) {
				if (type.equals(nameList.get(i).getId())) {
					cntype = nameList.get(i).getName();
					break;
				}
			}

			return cntype;
		}

		@Override
		public void update(ViewerCell cell) {
			if (cell.getElement() instanceof TaskCommand) {
				TaskCommand d = (TaskCommand) cell.getElement();
				StyledString styledString = new StyledString();
				String decoration = " -- " + getType(d.getCommandType());
				styledString.append(d.getName());
				styledString.append(decoration, StyledString.DECORATIONS_STYLER);
				cell.setText(styledString.getString());
				cell.setImage(getImage(d));
				cell.setStyleRanges(styledString.getStyleRanges());
			}
		}
	}

	@SuppressWarnings("unchecked")
	private List<TaskCommand> getAdvanceTaskCommands() {
		UserTask userTask = (UserTask) getBusinessObject();
		List<TaskCommand> taskCommands = new ArrayList<TaskCommand>();

		if (userTask.getExtensionValues().size() > 0) {
			for (ExtensionAttributeValue extensionAttributeValue : userTask.getExtensionValues()) {
				FeatureMap extensionElements = extensionAttributeValue.getValue();
				Object objectElement = extensionElements.get(FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_COMMAND, true);
				if (objectElement != null) {
					List<TaskCommand> taskCommandList = (List<TaskCommand>) objectElement;
					for (TaskCommand taskCommand : taskCommandList) {
						taskCommands.add(taskCommand);
					}
				}
			}
		}

		return taskCommands;
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
		upButton.setEnabled(selectedPage != null && index != 0);
		downButton.setEnabled(selectedPage != null && index != treeViewer.getTree().getItemCount() - 1);
	}

	/**
	 * EMF添加处理命令
	 * 
	 * @param taskC
	 */
	private void addTaskCommand(final TaskCommand taskC) {
		TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				UserTask userTask = (UserTask) getBusinessObject();

				if (userTask.getExtensionValues().size() > 0) {

					for (ExtensionAttributeValue extensionAttributeValue : userTask.getExtensionValues()) {

						FeatureMap extensionElements = extensionAttributeValue.getValue();
						Object objectElement = extensionElements.get(FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_COMMAND, true);
						if (objectElement != null) {
							FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_COMMAND,
									taskC);
							extensionElements.add(extensionElementEntry);
						}

					}
				} else {
					ExtensionAttributeValue extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
					userTask.getExtensionValues().add(extensionElement);
					FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_COMMAND, taskC);
					extensionElement.getValue().add(extensionElementEntry);
				}
			}
		});
	}

	/**
	 * 向上向下时方法
	 * 
	 * @param taskC
	 */
	private void addTaskCommand(final TaskCommand taskC, final int index) {
		TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				UserTask userTask = (UserTask) getBusinessObject();

				if (userTask.getExtensionValues().size() > 0) {

					for (ExtensionAttributeValue extensionAttributeValue : userTask.getExtensionValues()) {

						FeatureMap extensionElements = extensionAttributeValue.getValue();
						List<FeatureMap.Entry> objlist = new ArrayList<FeatureMap.Entry>();

						for (int i = 0; i < extensionElements.size(); i++) {
							FeatureMap.Entry objectElement = extensionElements.get(i);
							if (objectElement.getValue() instanceof TaskCommandImpl)
								objlist.add(objectElement);
						}

						extensionElements.removeAll(objlist);

						if (objlist.size() > 0) {
							FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_COMMAND,
									taskC);
							objlist.remove(extensionElementEntry);
							objlist.add(index, extensionElementEntry);
							for (FeatureMap.Entry entry : objlist) {
								extensionElements.add(entry);
							}
						}

					}
				} else {
					ExtensionAttributeValue extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
					userTask.getExtensionValues().add(extensionElement);
					FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_COMMAND, taskC);
					extensionElement.getValue().add(index, extensionElementEntry);
				}
			}
		});
	}

	/**
	 * EMF删除处理命令
	 * 
	 * @param taskC
	 */
	private void deleteTaskCommand(final TaskCommand taskC) {
		TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				UserTask userTask = (UserTask) getBusinessObject();

				if (userTask.getExtensionValues().size() > 0) {

					for (ExtensionAttributeValue extensionAttributeValue : userTask.getExtensionValues()) {

						FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_COMMAND,
								taskC);
						FeatureMap extensionElements = extensionAttributeValue.getValue();
						extensionElements.remove(extensionElementEntry);

					}
				}
			}
		});
	}

	/**
	 * EMF编辑处理命令(不打乱顺序)
	 * 
	 * @param oldtask
	 * @param newtask
	 */
	private void editTaskCommand(final TaskCommand oldtask, final TaskCommand newtask, final int index) {
		TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				UserTask userTask = (UserTask) getBusinessObject();

				if (userTask.getExtensionValues().size() > 0) {

					for (ExtensionAttributeValue extensionAttributeValue : userTask.getExtensionValues()) {

						FeatureMap.Entry oldextensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_COMMAND,
								oldtask);
						FeatureMap.Entry newextensionElementEntry = new SimpleFeatureMapEntry((org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_COMMAND,
								newtask);
						FeatureMap extensionElements = extensionAttributeValue.getValue();
						extensionElements.remove(oldextensionElementEntry);
						extensionElements.add(index, newextensionElementEntry);
					}
				}
			}
		});
	}
}
