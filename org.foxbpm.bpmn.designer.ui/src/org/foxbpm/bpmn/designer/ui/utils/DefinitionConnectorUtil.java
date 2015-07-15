package org.foxbpm.bpmn.designer.ui.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.foxbpm.bpmn.designer.base.utils.EMFUtil;
import org.foxbpm.bpmn.designer.base.utils.FileUtil;
import org.foxbpm.bpmn.designer.base.utils.FoxBPMDesignerUtil;
import org.foxbpm.bpmn.designer.base.utils.PropertiesUtil;
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
import org.foxbpm.model.config.connectormenu.Connector;
import org.foxbpm.model.config.connectormenu.Menu;
import org.foxbpm.model.config.connectormenu.Node;
import org.foxbpm.model.config.foxbpmconfig.ResourcePath;
import org.osgi.framework.Bundle;

public class DefinitionConnectorUtil {
	public static String CONNECTORMENU = "ConnectorMenu.xml";

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
//	public static List<ResourcePath> getOpenProjectResourcePath() {
//		HashSet<String> hashSet = new HashSet<String>();
//		for (IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
//			if(project.isOpen()) {
//				hashSet.add(project.getName());
//			}
//		}
//		
//		List<ResourcePath> resourcePaths = new ArrayList<ResourcePath>();
//		for (ResourcePath resourcePath : FoxBPMDesignerUtil.getFoxBPMConfig().getResourcePathConfig().getResourcePath()) {
//			if(hashSet.contains(resourcePath.getProjectName())) {
//				resourcePaths.add(resourcePath);
//			}
//		}
//		return resourcePaths;
//	}
	
	/**
	 * 获取所有连接器节点
	 * 
	 * @return
	 */
	public static List<Node> getAllConnectorNodes(String connectorMenuPath) {
		List<Node> nodes = new ArrayList<Node>();
		List<Node> childnodes = new ArrayList<Node>();
		Menu menu = getConnectorMenu(connectorMenuPath);
		for (Node node : menu.getFlowConnector().getNode()) {
			String xmlFilePath = menu.eResource().getURI().devicePath();
			String path = xmlFilePath.substring(0, xmlFilePath.lastIndexOf("/")) + "/ico/";
			for (Connector connector : node.getConnector()) {
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
		
		nodes.removeAll(childnodes);
		return nodes;
	}
	
	/**
	 * 获取所有选择器节点
	 * 
	 * @return
	 */
	public static List<Node> getAllActorConnectorNodes(String connectorMenuPath) {
		List<Node> nodes = new ArrayList<Node>();
		List<Node> childnodes = new ArrayList<Node>();
		Menu menu = getConnectorMenu(connectorMenuPath);
		for (Node node : menu.getActorConnector().getNode()) {
			String xmlFilePath = menu.eResource().getURI().devicePath();
			String path = xmlFilePath.substring(0, xmlFilePath.lastIndexOf("/")) + "/ico/";
			for (Connector connector : node.getConnector()) {
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
		return ((HashMap<String, Object>) allActorConnectors.get(connectorId + nodeId)).get("path").toString();
	}

	/**
	 * 根据连接器ID得到对应连接器文件存放路径
	 * 
	 * @param connectorId
	 * @return
	 */
	public static String getFlowConnectorPathById(String connectorId, String nodeId) {
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
	 * 根据处理者选择器ID得到对应处理者选择器定义实例
	 * 
	 * @param connectorId
	 * @return
	 */
	public static ConnectorDefinition getActorConnectorDefinitionById(String connectorId, String nodeId) {
		return (ConnectorDefinition) ((HashMap<String, Object>) allActorConnectors.get(connectorId + nodeId)).get("object");
	}

	/**
	 * 根据连接器ID得到对应连接器定义实例
	 * 
	 * @param connectorId
	 * @return
	 */
	public static ConnectorDefinition getFlowConnectorDefinitionById(String connectorId, String nodeId) {
		return (ConnectorDefinition) ((HashMap<String, Object>) allFlowConnectors.get(connectorId + nodeId)).get("object");
	}


	/**
	 * 获取连接器选择器菜单对象
	 * 
	 * @return
	 */
	public static Menu getConnectorMenu(String connectorMenuPath) {
		return EMFUtil.getConnectorMenuConfig(connectorMenuPath);
	}

	/**
	 * 获取选择器Icon路径
	 * 
	 * @param resourcePath
	 * @return
	 */
	public static String getConnectorIconPath(String connectorMenuPath) {
		return new File(connectorMenuPath).getParent();
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
	public static String getActorConnectorXmlPath(String packagePath, ConnectorDefinition connectorDefinition) {
		return packagePath + "/" + connectorDefinition.getId() + "/" + ACTORCONNECTOR;
	}

	/**
	 * 根据连接器ID得到对应连接器xml文件路径
	 * 
	 * @param connectorId
	 * @return
	 */
	public static String getFlowConnectorXmlPath(String packagePath, ConnectorDefinition connectorDefinition) {
		return packagePath + "/" + connectorDefinition.getId() + "/" + FLOWCONNECTOR;
	}


	/**
	 * 根据Menu上的连接器ID找到对应的连接器对象
	 * 
	 * @param connectorId
	 * @return
	 */
//	public static ConnectorDefinition getFlowConnectorByMenuConnectorId(String connectorId, String nodeId) {
//		try {
//			ConnectorDefinition connector = EMFUtil.getFlowConnectorConfig(getFlowConnectorXmlPath(connectorId, nodeId));
//			if (connector.getId().equals(connectorId)) {
//				return connector;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

	/**
	 * 返回连接器默认图标
	 * @param connectorMenuPath
	 * @return
	 */
	public static String getDefaultFlowConnectorIcoPath(String connectorMenuPath) {
		String icoPath = new File(connectorMenuPath).getParent() + "/ico/" + CONNECTORCATEGORYDEFAULTICON;
		
		if(!new File(icoPath).exists()) {
			Bundle bundle = Platform.getBundle( "org.foxbpm.bpmn.designer.ui" );
			InputStream stream;
			try {
				int byteread = 0;// 读取的位数
				byte[] buffer = new byte[1024];
				stream = FileLocator.openStream(bundle, Path.fromOSString("icons/connector/category.png"), false);
				File outfile = new File(icoPath);
				outfile.getParentFile().mkdirs();
				FileOutputStream outStream = new FileOutputStream(outfile);

				while ((byteread = stream.read(buffer)) != -1) {
					// 将读取的字节写入输出流
					outStream.write(buffer, 0, byteread);
				}
				stream.close();
				outStream.close();
			} catch (IOException e) {
				MessageDialog.openWarning(null, "提示", "创建图标文件出错，原因是\n" + e.getMessage());
//				e.printStackTrace();
			}
		}
		
		return icoPath;
	}

	/**
	 * 返回选择器默认图标
	 * @param connectorMenuPath
	 * @return
	 */
	public static String getDefaultActorConnectorIcoPath(String connectorMenuPath) {
		String icoPath = new File(connectorMenuPath).getParent() + "/ico/" + ACTORCATEGORYDEFAULTICON;
		
		if(!new File(icoPath).exists()) {
			Bundle bundle = Platform.getBundle( "org.foxbpm.bpmn.designer.ui" );
			InputStream stream;
			try {
				int byteread = 0;// 读取的位数
				byte[] buffer = new byte[1024];
				stream = FileLocator.openStream(bundle, Path.fromOSString("icons/connector/category.png"), false);
				File outfile = new File(icoPath);
				outfile.getParentFile().mkdirs();
				FileOutputStream outStream = new FileOutputStream(outfile);

				while ((byteread = stream.read(buffer)) != -1) {
					// 将读取的字节写入输出流
					outStream.write(buffer, 0, byteread);
				}
				stream.close();
				outStream.close();
			} catch (IOException e) {
				MessageDialog.openWarning(null, "提示", "创建图标文件出错，原因是\n" + e.getMessage());
//				e.printStackTrace();
			}
		}
		
		return icoPath;
	}

	/**
	 * 根据Menu上的连接器ID找到对应的处理者选择器对象
	 * 
	 * @param connectorId
	 * @return
	 */
//	public static ConnectorDefinition getActorConnectorByMenuConnectorId(String connectorId, String nodeId) {
//		try {
//			ConnectorDefinition connector = EMFUtil.getFlowConnectorConfig(getActorConnectorXmlPath(connectorId, nodeId));
//			if (connector.getId().equals(connectorId)) {
//				return connector;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

	/**
	 * 保存处理者选择器菜单
	 * 
	 * @param menu
	 */
	public static void saveActorConnectorMenu(Menu menu, List<String> newcategoryids, String connectorMenuPath) {

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
								if (!node.getIco().contains(DefinitionConnectorUtil.getConnectorIconPath(connectorMenuPath))) {
									// 打开原文件（Menu图标）
									FileInputStream menufis = new FileInputStream(node.getIco());
									// 打开连接到目标文件的输出流
									File menuoutfile = new File(DefinitionConnectorUtil.getConnectorIconPath(connectorMenuPath) + "/" + FileUtil.getFileName(node.getIco()));
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
		XMIResource resource = (XMIResource) resSet.createResource(URI.createFileURI(connectorMenuPath));
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
	public static void saveFlowConnectorMenu(Menu menu, List<String> newcategoryids, String connectorMenuPath) {
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
								if (!node.getIco().contains(DefinitionConnectorUtil.getConnectorIconPath(connectorMenuPath))) {
									// 打开原文件（Menu图标）
									FileInputStream menufis = new FileInputStream(node.getIco());
									// 打开连接到目标文件的输出流
									File menuoutfile = new File(DefinitionConnectorUtil.getConnectorIconPath(connectorMenuPath) + FileUtil.getFileName(node.getIco()));
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
		XMIResource resource = (XMIResource) resSet.createResource(URI.createFileURI(connectorMenuPath));
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
	public static List<ITreeElement> reloadTreeNodes(String connectorMenuPath) {
		List<ITreeElement> elements = new ArrayList<ITreeElement>();
		// Menu
		Menu root = getConnectorMenu(connectorMenuPath);
		// 分拆menu成为ITreeElement树
		if (root != null) {
			EList<Node> nodes = root.getFlowConnector().getNode();
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
	 * 拿到连接器菜单路径
	 * @param isDefault 是否是系统默认
	 * @return
	 */
	public static String getConnectorMenuPath(boolean isDefault) {
		String connectorMenuPath = "";
		if(!isDefault) {
			connectorMenuPath = FoxBPMDesignerUtil.getConnectorMenuPath();
		}else {
			String defaulPath = Platform.getInstallLocation().getURL().getPath() + "connectorPath.properties";
			File file = new File(defaulPath);
			if(file.exists()) {
				try {
					IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("foxbpm-connector");
					IFile ifile = null;
					if(project!=null) {
						ifile = (IFile) project.getFile(Path.fromOSString(new String(PropertiesUtil.readValue(defaulPath, "connectorMenuPath").toString().getBytes("ISO8859-1"), "UTF-8")));
					}
					if(ifile!=null) {
						connectorMenuPath = ifile.getLocation().toFile().getAbsolutePath();
					}else {
						connectorMenuPath = new String(PropertiesUtil.readValue(defaulPath, "connectorMenuPath").toString().getBytes("ISO8859-1"), "UTF-8");
					}
					
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}else{
				try {
					file.createNewFile();
					PropertiesUtil.writeProperties(defaulPath, "connectorMenuPath", "src\\main\\java\\org\\foxbpm\\connector\\ConnectorMenu.xml");
					try {
						IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("foxbpm-connector");
						IFile ifile = null;
						if(project!=null) {
							ifile = (IFile) project.getFile(Path.fromOSString(new String(PropertiesUtil.readValue(defaulPath, "connectorMenuPath").toString().getBytes("ISO8859-1"), "UTF-8")));
						}
						if(ifile!=null) {
							connectorMenuPath = ifile.getLocation().toFile().getAbsolutePath();
						}else {
							connectorMenuPath = new String(PropertiesUtil.readValue(defaulPath, "connectorMenuPath").toString().getBytes("ISO8859-1"), "UTF-8");
						}
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		if(connectorMenuPath.equals("") || !new File(connectorMenuPath).exists()) {
			MessageDialog.openWarning(null, "提示", "连接器Menu文件路径有误，请检查");
		}
		return connectorMenuPath;
	}
	
	/**
	 * 拿到连接器所在路径
	 * @param connectorDefinition
	 * @return
	 */
	public static String getConnectorPath(ConnectorDefinition connectorDefinition) {
		return connectorDefinition.getDefinitionImpl().getPackageName() + "/" + connectorDefinition.getId() + "/";
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
