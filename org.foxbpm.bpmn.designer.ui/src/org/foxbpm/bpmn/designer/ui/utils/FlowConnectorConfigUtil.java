package org.foxbpm.bpmn.designer.ui.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
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
import org.foxbpm.model.config.connectormenu.Node;
import org.foxbpm.model.config.foxbpmconfig.ResourcePath;
import org.foxbpm.model.config.foxbpmconfig.ResourcePathConfig;

public class FlowConnectorConfigUtil {

	public static String FLOWCONNECTORPATH = "flowConnector-path";

	public static String ACTORCONNECTORPATH = "actorConnector-path";

	public static String FLOWCONNECTORMENU = "FlowConnectorMenu.xml";

	public static String ACTORCONNECTORMENU = "ActorConnectorMenu.xml";

	public static String OLDCONNECTORMENU = "FlowConnectorMenu.xml";

	public static String OLDCONNECTORPATH = "connector-path";

	public static ResourcePath getFlowConnectorPath() {
		ResourcePathConfig resourcePathConfig = FoxBPMConfigUtil.getFoxBPMConfig().getResourcePathConfig();
		List<ResourcePath> resourcePaths = resourcePathConfig.getResourcePath();
		for (ResourcePath resourcePath : resourcePaths) {
			if (resourcePath.getId().equals(FLOWCONNECTORPATH)) {
				return resourcePath;
			}
		}
		return null;
	}

	public static ResourcePath getOldConnectorPath() {
		ResourcePathConfig resourcePathConfig = FoxBPMConfigUtil.getFoxBPMConfig().getResourcePathConfig();
		List<ResourcePath> resourcePaths = resourcePathConfig.getResourcePath();
		for (ResourcePath resourcePath : resourcePaths) {
			if (resourcePath.getId().equals(OLDCONNECTORPATH)) {
				return resourcePath;
			}
		}
		return null;
	}

	public static ResourcePath getActorConnectorPath() {
		ResourcePathConfig resourcePathConfig = FoxBPMConfigUtil.getFoxBPMConfig().getResourcePathConfig();
		List<ResourcePath> resourcePaths = resourcePathConfig.getResourcePath();
		for (ResourcePath resourcePath : resourcePaths) {
			if (resourcePath.getId().equals(ACTORCONNECTORPATH)) {
				return resourcePath;
			}
		}
		return null;
	}

	public static String getFlowConnectorProjectName() {
		return getFlowConnectorPath().getProjectName();
	}

	public static String getActorConnectorProjectName() {
		return getActorConnectorPath().getProjectName();
	}

	public static String getOldConnectorProjectName() {
		return getOldConnectorPath().getProjectName();
	}

	/**
	 * 获取流程连接器文件夹路径
	 * 
	 * @return
	 */
	public static String getFlowConnectorAllPath() {

		return ProjectUtil.getProjectPath(getFlowConnectorProjectName()) + "/" + getFlowConnectorPath().getVirtualPath();

	}

	/**
	 * 获取处理者选择器文件夹路径
	 * 
	 * @return
	 */
	public static String getActorConnectorAllPath() {

		return ProjectUtil.getProjectPath(getActorConnectorProjectName()) + "/" + getActorConnectorPath().getVirtualPath();

	}

	/**
	 * 获取老选择器文件夹路径
	 * 
	 * @return
	 */
	public static String getOldConnectorAllPath() {

		return ProjectUtil.getProjectPath(getOldConnectorProjectName()) + "/" + getOldConnectorPath().getVirtualPath();

	}

	/**
	 * 根据连接器ID得到对应连接器文件存放路径
	 * 
	 * @param connectorId
	 * @return
	 */
	public static String getFlowConnectorPathById(String connectorId) {
		return getFlowConnectorAllPath() + connectorId;
	}

	/**
	 * 根据处理者选择器ID得到对应处理者选择器文件存放路径
	 * 
	 * @param connectorId
	 * @return
	 */
	public static String getActorConnectorPathById(String connectorId) {
		return getActorConnectorAllPath() + connectorId;
	}

	/**
	 * 根据连接器ID得到对应连接器xml文件路径
	 * 
	 * @param connectorId
	 * @return
	 */
	public static String getConnectorXMLPath(String connectorId) {
		return getFlowConnectorAllPath() + connectorId + "/FixConnector.xml";
	}

	/**
	 * 根据处理者选择器ID得到对应处理者选择器xml文件路径
	 * 
	 * @param connectorId
	 * @return
	 */
	public static String getActorConnectorXMLPath(String connectorId) {
		return getActorConnectorAllPath() + connectorId + "/FixConnector.xml";
	}

	/**
	 * 根据Menu上的连接器ID找到对应的连接器对象
	 * 
	 * @param connectorId
	 * @return
	 */
//	public static FlowConnectorDefinition getFlowConnectorByMenuConnectorId(String connectorId) {
//		try {
//			FlowConnectorDefinition connector = EMFUtil.getFlowConnectorConfig(getConnectorXMLPath(connectorId));
//			if (connector.getId().equals(connectorId)) {
//				return connector;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

	/**
	 * 根据Menu上的连接器ID找到对应的处理者选择器对象
	 * 
	 * @param connectorId
	 * @return
	 */
//	public static FlowConnectorDefinition getActorConnectorByMenuConnectorId(String connectorId) {
//		try {
//			FlowConnectorDefinition connector = EMFUtil.getFlowConnectorConfig(getActorConnectorXMLPath(connectorId));
//			if (connector.getId().equals(connectorId)) {
//				return connector;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

	/**
	 * 得到连接器Menu文件路径
	 * 
	 * @return
	 */
	public static String getFlowConnectorMenuPath() {
		return getFlowConnectorAllPath() + FLOWCONNECTORMENU;
	}

	/**
	 * 得到处理者选择器Menu文件路径
	 * 
	 * @return
	 */
	public static String getActorConnectorMenuPath() {
		return getActorConnectorAllPath() + ACTORCONNECTORMENU;
	}

	/**
	 * 得到连接器Menu图标所存放的路径
	 * 
	 * @return
	 */
	public static String getMenuFlowConnectorIconPath() {
		return getFlowConnectorAllPath() + "ico/";
	}

	/**
	 * 得到处理者选择器Menu图标所存放的路径
	 * 
	 * @return
	 */
	public static String getMenuActorConnectorIconPath() {
		return getActorConnectorAllPath() + "ico/";
	}

	/**
	 * 根据图标的名称得到连接器Menu图标所存放的路径
	 * 
	 * @param iconName
	 * @return
	 */
	public static String getMenuFlowConnectorIconPathByIconName(String iconName) {
		return getMenuFlowConnectorIconPath() + iconName;
	}

	/**
	 * 根据图标的名称得到处理者选择器Menu图标所存放的路径
	 * 
	 * @param iconName
	 * @return
	 */
	public static String getMenuActorConnectorIconPathByIconName(String iconName) {
		return getMenuActorConnectorIconPath() + iconName;
	}

	/**
	 * 根据图标的名称得到连接器图标所存放的路径
	 * 
	 * @param connectorId
	 * @param iconName
	 * @return
	 */
	public static String getFlowConnectorIconPathByIconName(String connectorId, String iconName) {
		return getFlowConnectorPathById(connectorId) + "/" + iconName;
	}

	/**
	 * 根据图标的名称得到处理者选择器图标所存放的路径
	 * 
	 * @param connectorId
	 * @param iconName
	 * @return
	 */
	public static String getActorConnectorIconPathByIconName(String connectorId, String iconName) {
		return getActorConnectorPathById(connectorId) + "/" + iconName;
	}

	/**
	 * 获取流程连接器菜单对象
	 * 
	 * @return
	 */
	public static Menu getFlowConnectorMenu() {

		return EMFUtil.getConnectorMenuConfig(getFlowConnectorAllPath() + FLOWCONNECTORMENU);
	}

	/**
	 * 获取处理者选择器菜单对象
	 * 
	 * @return
	 */
	public static Menu getActorConnectorMenu() {

		return EMFUtil.getConnectorMenuConfig(getActorConnectorAllPath() + ACTORCONNECTORMENU);
	}

	/**
	 * 得到连接器图标名称方法(兼容Mac)
	 * 
	 * @param fullpath
	 * @return
	 */
	public static String getFlowConnectorMenuIconName(String fullpath) {
		File file = new File(fullpath);
		return file.getName();
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
								if (!node.getIco().contains(FlowConnectorConfigUtil.getMenuFlowConnectorIconPath())) {
									// 打开原文件（Menu图标）
									FileInputStream menufis = new FileInputStream(node.getIco());
									// 打开连接到目标文件的输出流
									File menuoutfile = new File(FlowConnectorConfigUtil.getMenuFlowConnectorIconPath() + FlowConnectorConfigUtil.getFlowConnectorMenuIconName(node.getIco()));
									FileOutputStream menuoutStream = new FileOutputStream(menuoutfile);

									while ((byteread = menufis.read(buffer)) != -1) {
										// 将读取的字节写入输出流
										menuoutStream.write(buffer, 0, byteread);
									}
									menuoutStream.close();
								}
								// 完了拷贝图标之后进行node的icon重设
								node.setIco(FlowConnectorConfigUtil.getFlowConnectorMenuIconName(node.getIco()));
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
		XMIResource resource = (XMIResource) resSet.createResource(URI.createFileURI(getFlowConnectorAllPath() + FLOWCONNECTORMENU));
		resource.setEncoding("UTF-8");

		resource.getContents().add(menu);

		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 刷新工程
		ProjectUtil.refreshProject(getFlowConnectorProjectName());
	}

	/**
	 * 保存处理者选择器菜单
	 * 
	 * @param menu
	 */
	public static void saveActorConnectorMenu(Menu menu) {

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xml", new XMIResourceFactoryImpl());

		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();

		// Create a resource
		XMIResource resource = (XMIResource) resSet.createResource(URI.createFileURI(getActorConnectorAllPath() + ACTORCONNECTORMENU));
		resource.setEncoding("UTF-8");

		resource.getContents().add(menu);

		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 刷新工程
		ProjectUtil.refreshProject(getActorConnectorProjectName());

	}

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
								if (!node.getIco().contains(FlowConnectorConfigUtil.getMenuActorConnectorIconPath())) {
									// 打开原文件（Menu图标）
									FileInputStream menufis = new FileInputStream(node.getIco());
									// 打开连接到目标文件的输出流
									File menuoutfile = new File(FlowConnectorConfigUtil.getMenuActorConnectorIconPath() + FlowConnectorConfigUtil.getFlowConnectorMenuIconName(node.getIco()));
									FileOutputStream menuoutStream = new FileOutputStream(menuoutfile);

									while ((byteread = menufis.read(buffer)) != -1) {
										// 将读取的字节写入输出流
										menuoutStream.write(buffer, 0, byteread);
									}
									menuoutStream.close();
								}
								// 完了拷贝图标之后进行node的icon重设
								node.setIco(FlowConnectorConfigUtil.getFlowConnectorMenuIconName(node.getIco()));
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
		XMIResource resource = (XMIResource) resSet.createResource(URI.createFileURI(getActorConnectorAllPath() + ACTORCONNECTORMENU));
		resource.setEncoding("UTF-8");

		resource.getContents().add(menu);

		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 刷新工程
		ProjectUtil.refreshProject(getActorConnectorProjectName());

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