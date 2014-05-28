package org.foxbpm.bpmn.designer.ui.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.dialogs.MessageDialog;
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
import org.restlet.data.ChallengeScheme;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class ConnectorUtil {

	public static String DOWNLOADURL = FoxBPMDesignerUtil.getServicePathPath() + "flowconfig";

	public static String FLOWCONNECTORMENU = "FlowConnectorMenu.xml";

	public static String ACTORCONNECTORMENU = "ActorConnectorMenu.xml";
	
	public static HashMap<String, Object> hashMap = new HashMap<String, Object>();

	// ///////////////////////////通用部分////////////////////////////////////

	/**
	 * 得到运行时连接器所存放的路径
	 * 
	 * @return
	 */
	public static String getRuntimeConnectorPath() {
		if (FoxBPMDesignerUtil.getServicePath().equals("path")) {
			MessageDialog.openInformation(null, "提示", "请先在设计器根目录的配置文件(path.properties)中更改服务地址(service)");
			return "";
		}
		return FoxBPMDesignerUtil.getServicePath() + "/connector/";
	}

	public static String getDefinitionConnectorPath() {
		if (FoxBPMDesignerUtil.getServicePath().equals("path")) {
			MessageDialog.openInformation(null, "提示", "请先在设计器根目录的配置文件(path.properties)中更改服务地址(service)");
			return "";
		}
		return FoxBPMDesignerUtil.getProperties().get("connectorDefinitionPath").toString() + "/";
	}

	/**
	 * 根据Menu上的连接器ID找到对应的连接器对象
	 * 
	 * @param connectorId
	 * @return
	 */
	public static ConnectorDefinition getFlowConnectorByMenuConnectorId(String connectorId) {
		try {
			ConnectorDefinition connector = EMFUtil.getFlowConnectorConfig(getConnectorXMLPath(connectorId));
			if (connector.getId().equals(connectorId)) {
				return connector;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据连接器ID得到对应连接器xml文件路径
	 * 
	 * @param connectorId
	 * @return
	 */
	public static String getConnectorXMLPath(String connectorId) {
		return getDefinitionConnectorPath() + connectorId + "/FlowConnector.xml";
	}

	/**
	 * 下载运行时连接器
	 * 
	 * @param type
	 * @return
	 * @throws IOException
	 */
	public static String downLoadConnector(String type) throws Exception {
		String connectorPath = getRuntimeConnectorPath();
//		Authenticator.setDefault(new Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication("111", "111".toCharArray());
//			}
//		});
//		URL url = null;
//		File file = null;
//		// url = new
//		// URL("http://172.16.40.89:8080/foxbpm-webapps-rest/service/connectors");
//		url = new URL(DOWNLOADURL);
//		file = File.createTempFile(System.currentTimeMillis() + "flowres", ".zip");
//		FileUtils.copyURLToFile(url, file);
//
//		String servicePath = FoxBPMDesignerUtil.getServicePath();
//		File serviceDirectory = new File(servicePath);
//
//		if (!type.equals("start") && serviceDirectory.exists()) {
//			// 强制删除服务目录下文件
//			for (File tempFile : serviceDirectory.listFiles()) {
//				FileUtils.forceDelete(tempFile);
//			}
//		}
//
//		ZipUtils.unZip(file.getPath(), servicePath);

		
		//REST方式
		String servicePath = FoxBPMDesignerUtil.getServicePath();
		ClientResource client = new ClientResource(DOWNLOADURL);
		client.setChallengeResponse(ChallengeScheme.HTTP_BASIC,"111", "111");
		Representation result = client.get();
		FileOutputStream fileOutputStream  = null;
		try {
			File file = File.createTempFile(System.currentTimeMillis() + "flowres", ".zip");
			if(file.exists()){
				file.delete();
			}
			fileOutputStream = new FileOutputStream(file);
			result.write(fileOutputStream);
			
			ZipUtils.unZip(file.getPath(), servicePath);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fileOutputStream != null)
				fileOutputStream.close();
		}
		
		return connectorPath;
	}

	/**
	 * 得到连接器图标名称方法(兼容Mac)
	 * 
	 * @param fullpath
	 * @return
	 */
	public static String getConnectorMenuIconName(String fullpath) {
		if(fullpath == null)
			return "";
		File file = new File(fullpath);
		return file.getName();
	}

	
	// //////////////////////////////选择器定义////////////////////////////////////////

	/**
	 * 保存处理者选择器菜单
	 * 
	 * @param menu
	 */
	public static void saveActorConnectorMenu(Menu menu, List<String> newcategoryids) {

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
								if (!node.getIco().contains(ConnectorUtil.getConnectorIconPath())) {
									// 打开原文件（Menu图标）
									FileInputStream menufis = new FileInputStream(node.getIco());
									// 打开连接到目标文件的输出流
									File menuoutfile = new File(ConnectorUtil.getConnectorIconPath() + ConnectorUtil.getConnectorMenuIconName(node.getIco()));
									FileOutputStream menuoutStream = new FileOutputStream(menuoutfile);

									while ((byteread = menufis.read(buffer)) != -1) {
										// 将读取的字节写入输出流
										menuoutStream.write(buffer, 0, byteread);
									}
									menuoutStream.close();
								}
								// 完了拷贝图标之后进行node的icon重设
								node.setIco(ConnectorUtil.getConnectorMenuIconName(node.getIco()));
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
		XMIResource resource = (XMIResource) resSet.createResource(URI.createFileURI(getDefinitionConnectorPath() + ACTORCONNECTORMENU));
		resource.setEncoding("UTF-8");

		resource.getContents().add(menu);

		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据处理者选择器ID得到对应处理者选择器文件存放路径
	 * 
	 * @param connectorId
	 * @return
	 */
	public static String getDefinitionActorConnectorPathById(String connectorId) {
		return getDefinitionConnectorPath() + connectorId;
	}
	
	/**
	 * 根据处理者选择器ID得到对应处理者选择器文件存放路径
	 * 
	 * @param connectorId
	 * @return
	 */
	public static String getRuntimeActorConnectorPathById(String connectorId) {
		return getRuntimeConnectorPath() + connectorId;
	}

	/**
	 * 获取处理者选择器菜单对象
	 * 
	 * @return
	 */
	public static Menu getActorConnectorMenu() {
		return EMFUtil.getConnectorMenuConfig(getDefinitionConnectorPath() + ACTORCONNECTORMENU);
	}

	/**
	 * 根据图标的名称得到处理者选择器图标所存放的路径
	 * 
	 * @param connectorId
	 * @param iconName
	 * @return
	 */
	public static String getDefinitionActorConnectorIconPathByIconName(String connectorId, String iconName) {
		return getDefinitionActorConnectorPathById(connectorId) + "/" + iconName;
	}
	
	/**
	 * 根据图标的名称得到处理者选择器图标所存放的路径
	 * 
	 * @param connectorId
	 * @param iconName
	 * @return
	 */
	public static String getRuntimeActorConnectorIconPathByIconName(String connectorId, String iconName) {
		return getRuntimeActorConnectorPathById(connectorId) + "/" + iconName;
	}

	/**
	 * 得到处理者选择器Menu图标所存放的路径
	 * 
	 * @return
	 */
	public static String getConnectorIconPath() {
		return getDefinitionConnectorPath() + "ico/";
	}

	/**
	 * 得到处理者选择器Menu文件路径
	 * 
	 * @return
	 */
	public static String getActorConnectorMenuPath() {
		return getDefinitionConnectorPath() + ACTORCONNECTORMENU;
	}

	// //////////////////////////////连接器定义///////////////////////////////////////

	/**
	 * 根据连接器ID得到对应连接器文件存放路径
	 * 
	 * @param connectorId
	 * @return
	 */
	public static String getFlowConnectorPathById(String connectorId) {
		return getDefinitionConnectorPath() + connectorId;
	}

	/**
	 * 得到连接器Menu文件路径
	 * 
	 * @return
	 */
	public static String getFlowConnectorMenuPath() {
		return getDefinitionConnectorPath() + FLOWCONNECTORMENU;
	}

	/**
	 * 获取流程连接器菜单对象
	 * 
	 * @return
	 */
	public static Menu getDefinitionFlowConnectorMenu() {
		return EMFUtil.getConnectorMenuConfig(getDefinitionConnectorPath() + FLOWCONNECTORMENU);
	}

	/**
	 * 保存流程连接器菜单
	 * 
	 * @param menu
	 */
	public static void saveFlowConnectorMenu(Menu menu, List<String> newcategoryids) {
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
								if (!node.getIco().contains(ConnectorUtil.getConnectorIconPath())) {
									// 打开原文件（Menu图标）
									FileInputStream menufis = new FileInputStream(node.getIco());
									// 打开连接到目标文件的输出流
									File menuoutfile = new File(ConnectorUtil.getConnectorIconPath() + ConnectorUtil.getConnectorMenuIconName(node.getIco()));
									FileOutputStream menuoutStream = new FileOutputStream(menuoutfile);

									while ((byteread = menufis.read(buffer)) != -1) {
										// 将读取的字节写入输出流
										menuoutStream.write(buffer, 0, byteread);
									}
									menuoutStream.close();
								}
								// 完了拷贝图标之后进行node的icon重设
								node.setIco(ConnectorUtil.getConnectorMenuIconName(node.getIco()));
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
		XMIResource resource = (XMIResource) resSet.createResource(URI.createFileURI(getDefinitionConnectorPath() + FLOWCONNECTORMENU));
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
	public static List<ITreeElement> reloadTreeNodes() {
		List<ITreeElement> elements = new ArrayList<ITreeElement>();
		// Menu
		Menu root = ConnectorUtil.getDefinitionFlowConnectorMenu();
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

	
	
	
	
	//////////////////////////////运行时选择器连接器/////////////////////////////////////
	
	
	/**
	 * 递归找到对应类型的所有menu上的连接器节点
	 * 
	 * @param type
	 *            FLOWCONNECTORMENU或ACTORCONNECTORMENU
	 * @return
	 */
	public static List<Node> getNodesFromConnectorPath(String type) {
		List<Node> nodes = new ArrayList<Node>();
		File connectorPath = new File(getRuntimeConnectorPath());
		getFileChild(connectorPath.getAbsolutePath(), nodes, type);
		return nodes;
	}

	public static void getFileChild(String path, List<Node> nodes, String type) {
		File filePath = new File(path);
		for (File file : filePath.listFiles()) {
			if (file.isDirectory()) {
				// XML文件
				File xmlFile = new File(file.getAbsolutePath() + "/" + type);
				if (xmlFile.exists()) {
					Menu menu = EMFUtil.getConnectorMenuConfig(xmlFile.getAbsolutePath());
					for (Node node : menu.getNode()) {
						node.setIco(file.getAbsolutePath().replace(File.separator, "/") + "/ico/" + node.getIco());
						for (MenuConnector connector : node.getMenuConnector()) {
							connector.setIco(file.getAbsolutePath().replace(File.separator, "/") + "/" +  connector.getId() + "/" + connector.getIco());
						}
						nodes.add(node);
					}
				} else {
					getFileChild(file.getAbsolutePath(), nodes, type);
				}
			} else {
				// XML文件
				File xmlFile = new File(file.getAbsolutePath());
				if (file.getAbsolutePath().indexOf(type)!=-1 && xmlFile.exists()) {
					Menu menu = EMFUtil.getConnectorMenuConfig(xmlFile.getAbsolutePath());
					for (Node node : menu.getNode()) {
						node.setIco(file.getAbsolutePath().replace(File.separator, "/") + "/ico/" + node.getIco());
						for (MenuConnector connector : node.getMenuConnector()) {
							connector.setIco(file.getAbsolutePath().replace(File.separator, "/") + "/" +  connector.getId() + "/" + connector.getIco());
						}
						nodes.add(node);
					}
				} else {
					// do nothing
				}
			}
		}
	}
	
	/**
	 * 获取流程连接器菜单对象
	 * 
	 * @return
	 */
	public static Menu getRuntimeFlowConnectorMenu() {
		return EMFUtil.getConnectorMenuConfig(getDefinitionConnectorPath() + FLOWCONNECTORMENU);
	}
	
	/**
	 * 根据图标的名称得到连接器图标所存放的路径
	 * 
	 * @param connectorId
	 * @param iconName
	 * @return
	 */
	public static String getFlowConnectorIconPathByIconName(String connectorId, String iconName) {
		return getRuntimeFlowConnectorPathById(connectorId) + "/" + iconName;
	}
	
	/**
	 * 根据连接器ID得到对应连接器文件存放路径
	 * 
	 * @param connectorId
	 * @return
	 */
	public static String getRuntimeFlowConnectorPathById(String connectorId) {
		return getRuntimeConnectorPath() + connectorId;
	}
	
	/**
	 * 根据Menu上的连接器ID找到对应的处理者选择器对象
	 * 
	 * @param connectorId
	 * @return
	 */
	public static ConnectorDefinition getActorConnectorByMenuConnectorId(String connectorId) {
		try {
			String xmlPath = getConnectorXMLPathByConnectorId(connectorId, getRuntimeConnectorPath());
			if(xmlPath == null) {
				return null;
			}
			ConnectorDefinition connector = EMFUtil.getFlowConnectorConfig(xmlPath);
			if (connector.getId().equals(connectorId)) {
				return connector;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据Menu上的连接器ID找到对应的处理者选择器对象(定义)
	 * 
	 * @param connectorId
	 * @return
	 */
	public static ConnectorDefinition getDefinitionActorConnectorByMenuConnectorId(String connectorId) {
		try {
			String xmlPath = getConnectorXMLPathByConnectorId(connectorId, getDefinitionConnectorPath());
			if(xmlPath == null) {
				return null;
			}
			ConnectorDefinition connector = EMFUtil.getFlowConnectorConfig(xmlPath);
			if (connector.getId().equals(connectorId)) {
				return connector;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getConnectorXMLPathByConnectorId(String connectorId, String path) {
		getLoop(path);
		return hashMap.get(connectorId).toString();
	}

	private static void getLoop(String path) {
		for (File directory : new File(path).listFiles()) {
			if(directory.isDirectory()) {
				getLoop(directory.getAbsolutePath());
			} else {
				if(directory.getName().indexOf(".xml")!=-1) {
					hashMap.put(directory.getParentFile().getName(), directory.getAbsolutePath());
				}
			}
		}
	}
	
	/**
	 * 根据InputId获取当前连接器的Input对象
	 * 
	 * @param connector
	 * @param inputId
	 * @return
	 */
	public static Input getInputFromId(ConnectorDefinition connector, String inputId) {
		EList<Input> inputs = connector.getInput();
		if (inputs != null && inputs.size() > 0) {
			for (Iterator iterator = inputs.iterator(); iterator.hasNext();) {
				Input input = (Input) iterator.next();
				if (input.getId().equals(inputId))
					return input;
			}
		}
		return null;
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
