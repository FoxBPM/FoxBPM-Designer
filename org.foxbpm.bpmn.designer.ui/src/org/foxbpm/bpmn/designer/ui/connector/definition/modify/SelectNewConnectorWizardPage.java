/*package org.foxbpm.bpmn.designer.ui.connector.definition.modify;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.foxbpm.bpmn.designer.base.utils.FoxBPMDesignerUtil;
import org.foxbpm.bpmn.designer.ui.connector.runtime.ConnectorFilter;
import org.foxbpm.bpmn.designer.ui.tree.DefinitionTreeViewerFactory;
import org.foxbpm.bpmn.designer.ui.tree.ITreeElement;
import org.foxbpm.bpmn.designer.ui.tree.TreeViewerContentProvider;
import org.foxbpm.bpmn.designer.ui.tree.TreeViewerLabelProvider;
import org.foxbpm.bpmn.designer.ui.utils.DefinitionConnectorUtil;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;
import org.foxbpm.model.config.connector.ConnectorDefinition;
import org.foxbpm.model.config.connectormenu.Connector;
import org.foxbpm.model.config.connectormenu.Menu;
import org.foxbpm.model.config.connectormenu.Node;
import org.foxbpm.model.config.foxbpmconfig.ResourcePath;

public class SelectNewConnectorWizardPage extends WizardPage {
	private Text searchtext;
	private ConnectorFilter filter;
	private TreeViewer treeViewer;
	private ConnectorDefinition connector;
	private EditConnectorWizard editConnectorWizard;
	private List<ITreeElement> elements;
	private Button deleteButton;
	private String MenuNodeId;
	private File file;
	private List<String> menuConnectorIdStringList = new ArrayList<String>();
	private String parentIdString = "";
	private ITreeElement expandToElement = null;
	private Node nodesel; // 记录删除节点的时候所选的连接器是属于哪个节点。
	private int intLevel;

	*//**
	 * Create the wizard.
	 *//*
	public SelectNewConnectorWizardPage(EditConnectorWizard editConnectorWizard) {
		super("wizardPage");
		setTitle("选择连接器");
		setDescription("选择你想编辑的连接器");
		filter = new ConnectorFilter();
		this.editConnectorWizard = editConnectorWizard;
	}

	*//**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 *//*
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		GridLayout gl_container = new GridLayout(1, false);
		gl_container.verticalSpacing = 0;
		gl_container.marginHeight = 0;
		gl_container.marginWidth = 0;
		gl_container.horizontalSpacing = 0;
		container.setLayout(gl_container);

		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		composite.setBounds(0, 0, 64, 64);
		composite.setLayout(new GridLayout(2, false));

		Label searchLabel = new Label(composite, SWT.NONE);
		searchLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		searchLabel.setText("搜索:");

		searchtext = new Text(composite, SWT.BORDER | SWT.SEARCH);
		searchtext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		searchtext.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				filter.setSearchText(searchtext.getText());

				treeViewer.refresh();
				treeViewer.expandAll();

				if (treeViewer.getSelection().isEmpty()) {
					setPageComplete(false);
				}
			}
		});

		new Label(composite, SWT.NONE);

		treeViewer = new TreeViewer(composite, SWT.BORDER);
		Tree tree = treeViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		new Label(composite, SWT.NONE);

		deleteButton = new Button(composite, SWT.NONE);
		deleteButton.setText("删除连接器");
		deleteButton.setEnabled(false);
		deleteButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				if (connector != null) {
					boolean b = MessageDialog.openConfirm(null, "警告", "你确认要删除吗？");
					if (!b)
						return;

					// 删除目录
					File file = new File(DefinitionConnectorUtil.getFlowConnectorPathById(connector.getId(), connector.getCategoryId()));
					// File file = new
					// File(ConnectorUtil.getConnectorPathById(connector.getConnectorId()));
					deleteFile(file);
					FoxBPMDesignerUtil.refresh(file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf(File.separator)));

					// 读取Menu的XML
					ResourceSet resourceSet = new ResourceSetImpl();
					resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xml", new XMIResourceFactoryImpl());
					ResourcePath resourcePath = DefinitionConnectorUtil.getResourcePathByConnectorPackageName(connector);
					XMIResource menuresource = (XMIResource) resourceSet.getResource(URI.createFileURI(DefinitionConnectorUtil.getConnectorMenuPath(resourcePath)), true);
					menuresource.setEncoding("UTF-8");
					Menu root = (Menu) menuresource.getContents().get(0);
					List<Connector> connectors = new ArrayList<Connector>();
					// 由于已经涉及多层嵌套的node，所以不仅仅是只要根就可以而是需要递归的，不然得不到子节点下的对应node
					nodesel = null;// 先初始化下下
					for (Node node : root.getFlowConnector().getNode()) {
						if (node.getId().equals(connector.getCategoryId())) {
							nodesel = node;
						} else {
							getBelongNodeById(node.getNode(), connector.getCategoryId());
						}
					}
					if (nodesel != null) {
						parentIdString = nodesel.getId();
						for (Connector connector : nodesel.getConnector()) {
							if (connector.getId().equals(connector.getId())) {
								connectors.add(connector);
							}
						}
						nodesel.getConnector().removeAll(connectors);
					}

					// 保存XML
					try {
						menuresource.save(Collections.EMPTY_MAP);
					} catch (IOException e) {
						e.printStackTrace();
					}

					MessageDialog.openInformation(null, "提示", "连接器删除成功");

					// 刷新树
					elements = (List<ITreeElement>) DefinitionTreeViewerFactory.reloadTree();
					treeViewer.setInput(elements);
					if (!parentIdString.equals("")) {
						getTreeElementById(elements, parentIdString);
						if (null != expandToElement) {
							intLevel = 1;
							getParentAndLevel(expandToElement);
							treeViewer.expandToLevel(expandToElement, intLevel);
						}
					}
					treeViewer.refresh();

				} else {
					boolean b = MessageDialog.openConfirm(null, "警告", "你确认要删除此目录及此目录下的所有目录和所有连接器吗？");
					if (!b)
						return;

					List<Node> nodes = new ArrayList<Node>();
					// 读取Menu的XML
					
					 * XMIResource menuresource = (XMIResource) new
					 * ResourceSetImpl
					 * ().getResource(URI.createFileURI(ConnectorUtil
					 * .getMenuConnectorPath()), true);
					 * menuresource.setEncoding("UTF-8"); Menu root = (Menu)
					 * menuresource.getContents().get(0);
					 
					// Menu root =
					// EMFUtil.getConnectorMenuConfig(ConnectorUtil.getMenuConnectorPath());

					ResourceSet resourceSet = new ResourceSetImpl();
					resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xml", new XMIResourceFactoryImpl());
					ResourcePath resourcePath = DefinitionConnectorUtil.getResourcePathByConnectorPackageName(connector);
					Resource resource = resourceSet.getResource(URI.createFileURI(DefinitionConnectorUtil.getFlowConnectorMenuPath(resourcePath)), true);
					// register package in local resource registry
					resourceSet.getPackageRegistry().put(FoxBPMPackage.eINSTANCE.getNsURI(), FoxBPMPackage.eINSTANCE);
					// load resource
					try {
						resource.load(null);
					} catch (IOException e) {
						e.printStackTrace();
					}

					Menu root = (Menu) resource.getContents().get(0);

					nodesel = null;// 先初始化下下
					for (Node node : root.getFlowConnector().getNode()) {
						if (node.getId().equals(MenuNodeId)) {
							nodesel = node;
						} else {
							getBelongNodeById(node.getNode(), MenuNodeId);
						}
					}
					// 先找到所有的连接器类名，放到一起后删除对应文件夹
					if (nodesel != null) {
						getAllMenuConnector(nodesel);
						if (menuConnectorIdStringList.size() > 0) {
							for (String idString : menuConnectorIdStringList) {
								file = new File(DefinitionConnectorUtil.getFlowConnectorPathById(idString, nodesel.getId()));
								deleteFile(file);
								FoxBPMDesignerUtil.refresh(file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf(File.separator)));
							}
						}
					}
					// 删除nodesel之前需要先取到nodesel的父节点的对应的id，到时候根据这个id取得刷新时候的树对应的节点对象供展开
					for (Node node : root.getFlowConnector().getNode()) {
						if (!node.getId().equals(nodesel.getId())) {
							getparentIdString(node, nodesel);
						}
					}
					// 接着需要删除node本身
					deleteNodeFromRoot(root.getFlowConnector().getNode(), nodesel);
					// 保存XML
					try {
						resource.save(Collections.EMPTY_MAP);
					} catch (IOException e) {
						e.printStackTrace();
					}

					MessageDialog.openInformation(null, "提示", "删除成功");

					// 刷新树
					elements = (List<ITreeElement>) DefinitionTreeViewerFactory.reloadTree();
					treeViewer.setInput(elements);
					treeViewer.refresh();
					if (!parentIdString.equals("")) {
						getTreeElementById(elements, parentIdString);
						if (null != expandToElement) {
							intLevel = 1;
							getParentAndLevel(expandToElement);
							treeViewer.expandToLevel(expandToElement, intLevel);
						}
					}
					treeViewer.refresh();
				}
			}
		});

		treeViewer.addFilter(filter);
		// tableViewer获取数据
		elements = (List<ITreeElement>) DefinitionTreeViewerFactory.reloadTree();

		if (elements != null && elements.size() > 0) {
			// 设置内容提供器
			treeViewer.setContentProvider(new TreeViewerContentProvider());

			// 设置标签提供器
			treeViewer.setLabelProvider(new TreeViewerLabelProvider());

			// 设置内容
			treeViewer.setInput(elements);
		}

		treeViewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(DoubleClickEvent event) {
				// 根据所选的连接器的id动态的加载向导页所需要的页面
				IStructuredSelection selection = (IStructuredSelection) treeViewer.getSelection();
				ITreeElement selectElement = (ITreeElement) selection.getFirstElement();

				if (treeViewer.getExpandedState(selectElement)) {
					// 如果展开就收起
					treeViewer.collapseToLevel(selectElement, 1);
				} else {
					// 展现下一层文件夹
					treeViewer.expandToLevel(selectElement, 1);
				}
			}
		});

		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				// 根据所选的连接器的id动态的加载向导页所需要的页面
				IStructuredSelection selection = (IStructuredSelection) treeViewer.getSelection();
				ITreeElement element = (ITreeElement) selection.getFirstElement();

				// 改变显示规则
				if (element != null && !element.getRealPath().equals("")) {
					deleteButton.setEnabled(true);

					setPageComplete(true);

					// 先将之前加入的删除掉
					if (editConnectorWizard.getPageCount() > 2) {
						for (int i = 2; i < editConnectorWizard.getPageCount();) {
							editConnectorWizard.removePage(i);
						}
					}

					// 获取该connetor
					connector = DefinitionTreeViewerFactory.getConnector(element.getId(), element.getRealName());//realName存的是node的Id);

					editConnectorWizard.getchChooseFlowConnectorFileToEditWizardPage().setConnector(connector);

					editConnectorWizard.getchChooseFlowConnectorFileToEditWizardPage().getCheckboxTreeViewer()
							.setInput(editConnectorWizard.getchChooseFlowConnectorFileToEditWizardPage().getFilesInConnectorPath());

				} else if (element != null && element.getRealPath().equals("")) {
					connector = null;
					MenuNodeId = element.getId();
					deleteButton.setEnabled(true);
					setPageComplete(false);
				} else {
					deleteButton.setEnabled(false);
					setPageComplete(false);
				}
			}
		});

		// 初始化的时候先使‘完成’按钮不可用
		setPageComplete(false);

		// 必须要的，将新的Composite放入
		setControl(container);
	}

	*//**
	 * 删除文件夹
	 * 
	 * @param file
	 *//*
	private void deleteFile(File file) {
		if (file.exists()) { // 判断文件是否存在
			if (file.isFile()) { // 判断是否是文件
				file.delete(); // delete()方法 你应该知道 是删除的意思;
			} else if (file.isDirectory()) { // 否则如果它是一个目录
				File files[] = file.listFiles(); // 声明目录下所有的文件 files[];
				for (int i = 0; i < files.length; i++) { // 遍历目录下所有的文件
					this.deleteFile(files[i]); // 把每个文件 用这个方法进行迭代
				}
			}
			file.delete();
		} else {
			System.out.println("所删除的文件不存在！" + '\n');
		}
	}

	public ConnectorDefinition getConnector() {
		return connector;
	}

	public void setConnector(ConnectorDefinition connector) {
		this.connector = connector;
	}

	*//**
	 * 用于获取所有节点下的子节点递归
	 * 
	 * @param listNodes
	 * @param node
	 *//*
	private void getBelongNodeById(List<Node> listNodes, String idString) {
		for (Node ndtemp : listNodes) {
			if (ndtemp.getId().equals(idString)) {
				nodesel = ndtemp;
			} else {
				if (ndtemp.getNode() != null && ndtemp.getNode().size() > 0) {
					getBelongNodeById(ndtemp.getNode(), idString);
				}
			}
		}
	}

	private void getAllMenuConnector(Node nodedel) {
		// 1:先找出该目录下所有的连接器供删除文件夹用
		if (nodedel.getConnector() != null && nodedel.getConnector().size() > 0) {
			for (Connector connector : nodedel.getConnector()) {
				menuConnectorIdStringList.add(connector.getId());
			}
		}
		if (nodedel.getNode().size() > 0 && nodedel.getNode() != null) {
			// 如果下面存在子节点就同时需要删除子节点下所有node还有连接器
			for (Node itemNode : nodedel.getNode()) {
				getAllMenuConnector(itemNode);
			}
		}
	}

	private void deleteNodeFromRoot(List<Node> nodelists, Node nodetodel) {
		for (Node node : nodelists) {
			if (node.getId().equals(nodetodel.getId())) {
				nodelists.remove(node);
				break;
			} else {
				deleteNodeFromRoot(node.getNode(), nodetodel);
			}
		}
	}

	private void getparentIdString(Node nodepare, Node nodetodel) {
		for (Node node : nodepare.getNode()) {
			if (node.getId().equals(nodetodel.getId())) {
				parentIdString = nodepare.getId();
				break;
			} else {
				getparentIdString(node, nodetodel);
			}
		}
	}

	private void getTreeElementById(List<ITreeElement> lists, String id) {
		for (ITreeElement item : lists) {
			if (item.getId().equals(id)) {
				expandToElement = item;
				break;
			} else {
				if (item.hasChildren()) {
					getTreeElementById(item.getChildren(), id);
				}
			}
		}
	}

	private void getParentAndLevel(ITreeElement treeElement) {
		if (null != treeElement.getParent()) {
			intLevel++;
			expandToElement = treeElement.getParent();
			getParentAndLevel(expandToElement);
		}
	}
}
*/