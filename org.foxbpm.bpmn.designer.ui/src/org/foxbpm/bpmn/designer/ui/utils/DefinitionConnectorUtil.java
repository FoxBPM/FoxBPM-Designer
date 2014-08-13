package org.foxbpm.bpmn.designer.ui.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.foxbpm.bpmn.designer.base.utils.EMFUtil;
import org.foxbpm.bpmn.designer.base.utils.FileUtil;
import org.foxbpm.bpmn.designer.base.utils.FoxBPMDesignerUtil;
import org.foxbpm.bpmn.designer.ui.tree.EntityElement;
import org.foxbpm.bpmn.designer.ui.tree.ITreeElement;
import org.foxbpm.model.config.connector.Checkbox;
import org.foxbpm.model.config.connector.Choices;
import org.foxbpm.model.config.connector.ColsCaption;
import org.foxbpm.model.config.connector.ConnectorDefinition;
import org.foxbpm.model.config.connector.ConnectorFactory;
import org.foxbpm.model.config.connector.Group;
import org.foxbpm.model.config.connector.Input;
import org.foxbpm.model.config.connector.Items;
import org.foxbpm.model.config.connector.Output;
import org.foxbpm.model.config.connector.Password;
import org.foxbpm.model.config.connector.RadioGroup;
import org.foxbpm.model.config.connector.ScriptEditor;
import org.foxbpm.model.config.connector.Select;
import org.foxbpm.model.config.connector.Table;
import org.foxbpm.model.config.connector.Text;
import org.foxbpm.model.config.connector.TextArea;
import org.foxbpm.model.config.connector.WidgetExpression;
import org.foxbpm.model.config.connectormenu.Menu;
import org.foxbpm.model.config.connectormenu.MenuConnector;
import org.foxbpm.model.config.connectormenu.Node;
import org.foxbpm.model.config.foxbpmconfig.ResourcePath;

public class DefinitionConnectorUtil {

	public static String DOWNLOADURL = FoxBPMDesignerUtil.getServicePathPath() + "flowconfig";

	public static String FLOWCONNECTORMENU = "FlowConnectorMenu.xml";

	public static String ACTORCONNECTORMENU = "ActorConnectorMenu.xml";

	public static String FLOWCONNECTOR = "FlowConnector.xml";

	public static String ACTORCONNECTOR = "ActorConnector.xml";

	private static String ACTORCATEGORYDEFAULTICON = "connector.png";

	private static String CONNECTORCATEGORYDEFAULTICON = "category.png";

	public static HashMap<String, Object> allFlowConnectors = new HashMap<String, Object>();
	public static HashMap<String, Object> allActorConnectors = new HashMap<String, Object>();

	/**
	 * 过滤掉已关闭的项目
	 * @return
	 */
	public static List<ResourcePath> getOpenProjectResourcePath() {
		HashSet<String> hashSet = new HashSet<String>();
		for (IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
			if(project.isOpen()) {
				hashSet.add(project.getName());
			}
		}
		
		List<ResourcePath> resourcePaths = new ArrayList<ResourcePath>();
		for (ResourcePath resourcePath : FoxBPMDesignerUtil.getFoxBPMConfig().getResourcePathConfig().getResourcePath()) {
			if(hashSet.contains(resourcePath.getProjectName())) {
				resourcePaths.add(resourcePath);
			}
		}
		return resourcePaths;
	}
	
	/**
	 * 获取所有连接器节点
	 * 
	 * @return
	 */
	public static List<Node> getAllFlowConnectorNodes() {
		List<Node> nodes = new ArrayList<Node>();
		List<Node> childnodes = new ArrayList<Node>();
		Menu menu = null;
		for (ResourcePath resourcePath : getOpenProjectResourcePath()) {
			if(resourcePath.getType().equals("flowConnector")) {
				menu = getFlowConnectorMenu(resourcePath);
			}else{
				continue;
			}
			for (Node node : EMFUtil.getAll(menu.eResource(), Node.class)) {
				String xmlFilePath = menu.eResource().getURI().devicePath();
				String path = xmlFilePath.substring(0, xmlFilePath.lastIndexOf("/")) + "/ico/";
				for (MenuConnector connector : node.getMenuConnector()) {
					// connector的具体路径
					String connectorPath = xmlFilePath.substring(0, xmlFilePath.lastIndexOf("/")) + "/" + connector.getId() + "/";
					HashMap<String, Object> map = new HashMap<String, Object>();
					// 连接器对象
					ConnectorDefinition connectorDefinition = ((ConnectorDefinition) EMFUtil.readEMFFile(connectorPath + FLOWCONNECTOR).getContents().get(0));
					// 菜单对象
					map.put("menuobject", connector);
					// 所在节点
					map.put("node", node);
					// 目录
					map.put("path", connectorPath);
					// 图标
					map.put("ico", connectorPath + connectorDefinition.getIcon());
					
					// 对象
					map.put("object", connectorDefinition);
					// 放到map里
					allFlowConnectors.put(connector.getId() + node.getId(), map);
				}
				
				//根节点图标
				node.setIco(path  +  node.getIco());
				
				nodes.add(node);
				
				if(node.getNode().size()>0) {
					childnodes.addAll(node.getNode());
				}
			}
		}
		
		nodes.removeAll(childnodes);
		return nodes;
	}

	/**
	 * 获取所有选择器节点
	 * 
	 * @return
	 */
	public static List<Node> getAllActorConnectorNodes() {
		List<Node> nodes = new ArrayList<Node>();
		List<Node> childnodes = new ArrayList<Node>();
		Menu menu = null;
		for (ResourcePath resourcePath : getOpenProjectResourcePath()) {
			if(resourcePath.getType().equals("actorConnector")) {
				menu = getActorConnectorMenu(resourcePath);
			}else{
				continue;
			}
			for (Node node : EMFUtil.getAll(menu.eResource(), Node.class)) {
				String xmlFilePath = menu.eResource().getURI().devicePath();
				String path = xmlFilePath.substring(0, xmlFilePath.lastIndexOf("/")) + "/ico/";
				for (MenuConnector connector : node.getMenuConnector()) {
					// connector的具体路径
					String connectorPath = xmlFilePath.substring(0, xmlFilePath.lastIndexOf("/")) + "/" + connector.getId() + "/";
					HashMap<String, Object> map = new HashMap<String, Object>();
					// 连接器对象
					ConnectorDefinition connectorDefinition = ((ConnectorDefinition) EMFUtil.readEMFFile(connectorPath + ACTORCONNECTOR).getContents().get(0));
					// 菜单对象
					map.put("menuobject", connector);
					// 所在节点
					map.put("node", node);
					// 目录
					map.put("path", connectorPath);
					// 图标
					map.put("ico", connectorPath + connectorDefinition.getIcon());
					// 对象
					map.put("object", connectorDefinition);
					// 放到map里
					allActorConnectors.put(connector.getId() + node.getId(), map);
				}
				
				//根节点图标
				node.setIco(path  +  node.getIco());
				
				nodes.add(node);
				
				if(node.getNode().size()>0) {
					childnodes.addAll(node.getNode());
				}
			}
		}
		nodes.removeAll(childnodes);
		return nodes;
	}

	/**
	 * 根据处理者选择器ID得到对应处理者选择器文件存放路径
	 * 
	 * @param connectorId
	 * @return
	 */
	public static String getActorConnectorPathById(String connectorId, String nodeId) {
		getAllActorConnectorNodes();
		return ((HashMap<String, Object>) allActorConnectors.get(connectorId + nodeId)).get("path").toString();
	}

	/**
	 * 根据连接器ID得到对应连接器文件存放路径
	 * 
	 * @param connectorId
	 * @return
	 */
	public static String getFlowConnectorPathById(String connectorId, String nodeId) {
		getAllFlowConnectorNodes();
		return ((HashMap<String, Object>) allFlowConnectors.get(connectorId + nodeId)).get("path").toString();
	}

	/**
	 * 拿到连接器的路径
	 * 
	 * @param connectorId
	 * @param resourcePath
	 * @return
	 */
	public static String getConnectorPath(String connectorId, ResourcePath resourcePath) {
		IResource resource = ResourcesPlugin.getWorkspace().getRoot().getProject(resourcePath.getProjectName()).findMember(resourcePath.getVirtualPath() + connectorId);
		String xmlFilePath = resource == null ? null : resource.getLocationURI().getPath();
		return xmlFilePath;
	}

	/**
	 * 拿到连接器根目录的路径
	 * 
	 * @param resourcePath
	 * @return
	 */
	public static String getAllConnectorPath(ResourcePath resourcePath) {
		IResource resource = ResourcesPlugin.getWorkspace().getRoot().getProject(resourcePath.getProjectName()).findMember(resourcePath.getVirtualPath());
		String xmlFilePath = resource == null ? null : resource.getLocationURI().getPath();
		return xmlFilePath;
	}

	/**
	 * 根据处理者选择器ID得到对应处理者选择器定义实例
	 * 
	 * @param connectorId
	 * @return
	 */
	public static ConnectorDefinition getActorConnectorDefinitionById(String connectorId, String nodeId) {
		getAllActorConnectorNodes();
		return (ConnectorDefinition) ((HashMap<String, Object>) allActorConnectors.get(connectorId + nodeId)).get("object");
	}

	/**
	 * 根据连接器ID得到对应连接器定义实例
	 * 
	 * @param connectorId
	 * @return
	 */
	public static ConnectorDefinition getFlowConnectorDefinitionById(String connectorId, String nodeId) {
		getAllFlowConnectorNodes();
		return (ConnectorDefinition) ((HashMap<String, Object>) allFlowConnectors.get(connectorId + nodeId)).get("object");
	}

	/**
	 * 获取处理者选择器菜单对象
	 * 
	 * @return
	 */
	public static Menu getActorConnectorMenu(ResourcePath resourcePath) {
		return EMFUtil.getConnectorMenuConfig(getActorConnectorMenuPath(resourcePath));
	}

	/**
	 * 获取连接器选择器菜单对象
	 * 
	 * @return
	 */
	public static Menu getFlowConnectorMenu(ResourcePath resourcePath) {
		return EMFUtil.getConnectorMenuConfig(getFlowConnectorMenuPath(resourcePath));
	}

	/**
	 * 获取选择器Menu路径
	 * 
	 * @param resourcePath
	 * @return
	 */
	public static String getActorConnectorMenuPath(ResourcePath resourcePath) {
		IResource resource = ResourcesPlugin.getWorkspace().getRoot().getProject(resourcePath.getProjectName()).findMember(resourcePath.getVirtualPath() + ACTORCONNECTORMENU);
		String xmlFilePath = resource == null ? null : resource.getLocationURI().getPath();
		return xmlFilePath;
	}

	/**
	 * 获取连接器Menu路径
	 * 
	 * @param resourcePath
	 * @return
	 */
	public static String getFlowConnectorMenuPath(ResourcePath resourcePath) {
		IResource resource = ResourcesPlugin.getWorkspace().getRoot().getProject(resourcePath.getProjectName()).findMember(resourcePath.getVirtualPath() + FLOWCONNECTORMENU);
		String xmlFilePath = resource == null ? null : resource.getLocationURI().getPath();
		return xmlFilePath;
	}

	/**
	 * 获取选择器Icon路径
	 * 
	 * @param resourcePath
	 * @return
	 */
	public static String getActorConnectorIconPath(ResourcePath resourcePath) {
		IResource resource = ResourcesPlugin.getWorkspace().getRoot().getProject(resourcePath.getProjectName()).findMember(resourcePath.getVirtualPath() + "ico");
		String xmlFilePath = resource == null ? null : resource.getLocationURI().getPath();
		return xmlFilePath;
	}

	/**
	 * 获取连接器Icon路径
	 * 
	 * @param resourcePath
	 * @return
	 */
	public static String getFlowConnectorIconPath(ResourcePath resourcePath) {
		IResource resource = ResourcesPlugin.getWorkspace().getRoot().getProject(resourcePath.getProjectName()).findMember(resourcePath.getVirtualPath() + "ico");
		String xmlFilePath = resource == null ? null : resource.getLocationURI().getPath();
		return xmlFilePath;
	}

	/**
	 * 根据图标的名称得到处理者选择器图标所存放的路径
	 * 
	 * @param connectorId
	 * @param iconName
	 * @return
	 */
	public static String getActorConnectorIconPathByIconName(String connectorId, String nodeId, String iconName) {
		return getActorConnectorPathById(connectorId, nodeId) + "/" + iconName;
	}

	/**
	 * 根据图标的名称得到连接器图标所存放的路径
	 * 
	 * @param connectorId
	 * @param iconName
	 * @return
	 */
	public static String getFlowConnectorIconPathByIconName(String connectorId, String nodeId, String iconName) {
		return getFlowConnectorPathById(connectorId, nodeId) + "/" + iconName;
	}

	/**
	 * 根据选择器ID得到对应选择器xml文件路径
	 * 
	 * @param connectorId
	 * @return
	 */
	public static String getActorConnectorXmlPath(String connectorId, String nodeId) {
		return getActorConnectorPathById(connectorId, nodeId) + "/" + ACTORCONNECTOR;
	}

	/**
	 * 根据连接器ID得到对应连接器xml文件路径
	 * 
	 * @param connectorId
	 * @return
	 */
	public static String getFlowConnectorXmlPath(String connectorId, String nodeId) {
		return getFlowConnectorPathById(connectorId, nodeId) + "/" + FLOWCONNECTOR;
	}

	/**
	 * 根据连接器ID得到对应连接器xml文件路径
	 * 
	 * @param connectorId
	 * @param resourcePath
	 * @return
	 */
	public static String getFlowConnectorXmlPath(String connectorId, ResourcePath resourcePath) {
		IResource resource = ResourcesPlugin.getWorkspace().getRoot().getProject(resourcePath.getProjectName()).findMember(resourcePath.getVirtualPath());
		String xmlFilePath = resource == null ? null : resource.getLocationURI().getPath() + "/" + connectorId + "/" + FLOWCONNECTOR;
		return xmlFilePath;
	}

	/**
	 * 根据选择器ID得到对应选择器xml文件路径
	 * 
	 * @param connectorId
	 * @param resourcePath
	 * @return
	 */
	public static String getActorConnectorXmlPath(String connectorId, ResourcePath resourcePath) {
		IResource resource = ResourcesPlugin.getWorkspace().getRoot().getProject(resourcePath.getProjectName()).findMember(resourcePath.getVirtualPath());
		String xmlFilePath = resource == null ? null : resource.getLocationURI().getPath() + "/" + connectorId + "/" + ACTORCONNECTOR;
		return xmlFilePath;
	}

	/**
	 * 根据Menu上的连接器ID找到对应的连接器对象
	 * 
	 * @param connectorId
	 * @return
	 */
	public static ConnectorDefinition getFlowConnectorByMenuConnectorId(String connectorId, String nodeId) {
		try {
			ConnectorDefinition connector = EMFUtil.getFlowConnectorConfig(getFlowConnectorXmlPath(connectorId, nodeId));
			if (connector.getId().equals(connectorId)) {
				return connector;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 返回连接器默认图标
	 * 
	 * @param resourcePath
	 * @return
	 */
	public static String getDefaultFlowConnectorIcoPath(ResourcePath resourcePath) {
		return getFlowConnectorIconPath(resourcePath) + "/" + CONNECTORCATEGORYDEFAULTICON;
	}

	/**
	 * 返回选择器默认图标
	 * 
	 * @param resourcePath
	 * @return
	 */
	public static String getDefaultActorConnectorIcoPath(ResourcePath resourcePath) {
		return getFlowConnectorIconPath(resourcePath) + "/" + ACTORCATEGORYDEFAULTICON;
	}

	/**
	 * 根据Menu上的连接器ID找到对应的处理者选择器对象
	 * 
	 * @param connectorId
	 * @return
	 */
	public static ConnectorDefinition getActorConnectorByMenuConnectorId(String connectorId, String nodeId) {
		try {
			ConnectorDefinition connector = EMFUtil.getFlowConnectorConfig(getActorConnectorXmlPath(connectorId, nodeId));
			if (connector.getId().equals(connectorId)) {
				return connector;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 保存处理者选择器菜单
	 * 
	 * @param menu
	 */
	public static void saveActorConnectorMenu(Menu menu, List<String> newcategoryids, ResourcePath resourcePath) {

		// 这个里面需要处理下新增加的分类图标的保存到对应的icon目录下面去
		List<Node> lists = EMFUtil.getAll(menu.eResource(), Node.class);
		if (lists.size() > 0) {
			for (String newcategoryid : newcategoryids) {
				for (Node node : lists) {
					if (node.getId().equals(newcategoryid)) {
						// 先取出这个node对应的Icon信息，再更新成相对路径，最后由下面进行保存之后就是相对路径
						try {
							// 一次读取1024个字节，当byteread为-1时表示文件已经读完
							int byteread = 0;// 读取的位数
							byte[] buffer = new byte[1024];

							if (null != node.getIco()) {
								// 只有node对应的inon不是原有菜单下的就进行拷贝,不然选用的是MenuIcon再重写到MenuIcon的话会成空白的图
								if (!node.getIco().contains(getFlowConnectorIconPath(resourcePath))) {
									// 打开原文件（Menu图标）
									FileInputStream menufis = new FileInputStream(node.getIco());
									// 打开连接到目标文件的输出流
									File menuoutfile = new File(menu.eResource().getURI().devicePath() + FileUtil.getFileName(node.getIco()));
									FileOutputStream menuoutStream = new FileOutputStream(menuoutfile);

									while ((byteread = menufis.read(buffer)) != -1) {
										// 将读取的字节写入输出流
										menuoutStream.write(buffer, 0, byteread);
									}
									menuoutStream.close();
								}
								// 完了拷贝图标之后进行node的icon重设
								node.setIco(FileUtil.getFileName(node.getIco()));
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xml", new XMIResourceFactoryImpl());

		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();

		// Create a resource
		XMIResource resource = (XMIResource) resSet.createResource(URI.createFileURI(getActorConnectorMenuPath(resourcePath)));
		resource.setEncoding("UTF-8");

		resource.getContents().add(menu);

		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 保存流程连接器菜单
	 * 
	 * @param menu
	 */
	public static void saveFlowConnectorMenu(Menu menu, List<String> newcategoryids, ResourcePath resourcePath) {
		// 这个里面需要处理下新增加的分类图标的保存到对应的icon目录下面去
		List<Node> lists = EMFUtil.getAll(menu.eResource(), Node.class);
		if (lists.size() > 0) {
			for (String newcategoryid : newcategoryids) {
				for (Node node : lists) {
					if (node.getId().equals(newcategoryid)) {
						// 先取出这个node对应的Icon信息，再更新成相对路径，最后由下面进行保存之后就是相对路径
						try {
							// 一次读取1024个字节，当byteread为-1时表示文件已经读完
							int byteread = 0;// 读取的位数
							byte[] buffer = new byte[1024];

							if (null != node.getIco()) {
								// 只有node对应的inon不是原有菜单下的就进行拷贝,不然选用的是MenuIcon再重写到MenuIcon的话会成空白的图
								if (!node.getIco().contains(DefinitionConnectorUtil.getFlowConnectorIconPath(resourcePath))) {
									// 打开原文件（Menu图标）
									FileInputStream menufis = new FileInputStream(node.getIco());
									// 打开连接到目标文件的输出流
									File menuoutfile = new File(DefinitionConnectorUtil.getFlowConnectorIconPath(resourcePath) + FileUtil.getFileName(node.getIco()));
									FileOutputStream menuoutStream = new FileOutputStream(menuoutfile);

									while ((byteread = menufis.read(buffer)) != -1) {
										// 将读取的字节写入输出流
										menuoutStream.write(buffer, 0, byteread);
									}
									menuoutStream.close();
								}
								// 完了拷贝图标之后进行node的icon重设
								node.setIco(FileUtil.getFileName(node.getIco()));
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xml", new XMIResourceFactoryImpl());

		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();

		// Create a resource
		XMIResource resource = (XMIResource) resSet.createResource(URI.createFileURI(getFlowConnectorMenuPath(resourcePath)));
		resource.setEncoding("UTF-8");

		resource.getContents().add(menu);

		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据连接器菜单加载分类树
	 * 
	 * @return
	 */
	public static List<ITreeElement> reloadTreeNodes(ResourcePath resourcePath) {
		List<ITreeElement> elements = new ArrayList<ITreeElement>();
		// Menu
		Menu root = getFlowConnectorMenu(resourcePath);
		// 分拆menu成为ITreeElement树
		if (root != null) {
			EList<Node> nodes = root.getNode();
			getTreeElementsNodes(nodes, null, elements);
		}
		return elements;
	}

	/**
	 * 递归查找node节点并且只取所有node
	 * 
	 * @param nodes
	 * @param element
	 * @param elements
	 */
	private static void getTreeElementsNodes(EList<Node> nodes, ITreeElement element, List<ITreeElement> elements) {
		if (nodes != null && nodes.size() > 0) {
			for (Iterator iterator = nodes.iterator(); iterator.hasNext();) {
				Node node = (Node) iterator.next();
				ITreeElement parentElement = new EntityElement(element, node.getId(), node.getName(), node.getName(), node.getIco(), "");
				EList<Node> nodeitems = node.getNode();
				if (nodeitems != null && nodeitems.size() > 0) {
					getTreeElementsNodes(nodeitems, parentElement, elements);
				}

				if (element != null)
					element.addChild(parentElement);
				else
					elements.add(parentElement);
			}
		}
	}

	/**
	 * 根据连接器实例找到对应的resourcesPath
	 * 
	 * @param connector
	 * @return
	 */
	public static ResourcePath getResourcePathByConnectorPackageName(ConnectorDefinition connector) {
		ResourcePath resourcePath = null;
		for (ResourcePath rp : FoxBPMDesignerUtil.getFoxBPMConfig().getResourcePathConfig().getResourcePath()) {
			if (connector.getDefinitionImpl().getPackageName().equals(rp.getSrc().replace("/", ".") + connector.getId())) {
				resourcePath = rp;
				break;
			}
		}
		return resourcePath;
	}

	/**
	 * 根据resourcePath找到对应类型的Menuxml路径
	 * 
	 * @param resourcePath
	 * @param type
	 *            Menu xml类型
	 * @return
	 */
	public static String getProjectConnectorPathByResourcePathAndType(ResourcePath resourcePath, String type) {
		IResource resource = ResourcesPlugin.getWorkspace().getRoot().getProject(resourcePath.getProjectName()).findMember(resourcePath.getVirtualPath() + type);
		String xmlFilePath = resource == null ? null : resource.getLocationURI().getPath();
		return xmlFilePath;
	}

	public static ConnectorDefinition createFlowConnectorDefinition() {
		return ConnectorFactory.eINSTANCE.createConnectorDefinition();
	}

	public static Text createWidgetText() {
		return ConnectorFactory.eINSTANCE.createText();
	}

	public static Password createWidgetPassword() {
		return ConnectorFactory.eINSTANCE.createPassword();
	}

	public static TextArea createWidgetTextArea() {
		return ConnectorFactory.eINSTANCE.createTextArea();
	}

	public static Checkbox createWidgetCheckbox() {
		return ConnectorFactory.eINSTANCE.createCheckbox();
	}

	public static Select createWidgetSelect() {
		return ConnectorFactory.eINSTANCE.createSelect();
	}

	public static RadioGroup createWidgetRadioGroup() {
		return ConnectorFactory.eINSTANCE.createRadioGroup();
	}

	public static Group createWidgetGroup() {
		return ConnectorFactory.eINSTANCE.createGroup();
	}

	public static Table createWidgetTable() {
		return ConnectorFactory.eINSTANCE.createTable();
	}

	public static org.foxbpm.model.config.connector.List createWidgetRadioList() {
		return ConnectorFactory.eINSTANCE.createList();
	}

	public static ScriptEditor createWidgetScriptEditor() {
		return ConnectorFactory.eINSTANCE.createScriptEditor();
	}

	public static Input createInput() {
		return ConnectorFactory.eINSTANCE.createInput();
	}

	public static Output createOutput() {
		return ConnectorFactory.eINSTANCE.createOutput();
	}

	public static Items createItems() {
		return ConnectorFactory.eINSTANCE.createItems();
	}

	public static Choices createChoices() {
		return ConnectorFactory.eINSTANCE.createChoices();
	}

	public static ColsCaption createColsCaption() {
		return ConnectorFactory.eINSTANCE.createColsCaption();
	}

	public static WidgetExpression createWidgetExpression() {
		return ConnectorFactory.eINSTANCE.createWidgetExpression();
	}
}
