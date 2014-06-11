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
import org.foxbpm.model.config.connectormenu.Node;

public class DefinitionConnectorUtil {

	public static String DOWNLOADURL = FoxBPMDesignerUtil.getServicePathPath() + "flowconfig";

	public static String FLOWCONNECTORMENU = "FlowConnectorMenu.xml";

	public static String ACTORCONNECTORMENU = "ActorConnectorMenu.xml";
	
	public static String FLOWCONNECTOR = "FlowConnector.xml";

	public static String ACTORCONNECTOR = "ActorConnector.xml";

	public static HashMap<String, Object> hashMap = new HashMap<String, Object>();

	public static String getActorConnectorPath() {
		if (FoxBPMDesignerUtil.getServicePath().equals("path")) {
			MessageDialog.openInformation(null, "提示", "请先在设计器根目录的配置文件(path.properties)中更改服务地址(service)");
			return "";
		}
		return FoxBPMDesignerUtil.getProperties().get("actorConnectorPath").toString() + "/";
	}

	public static String getFlowConnectorPath() {
		if (FoxBPMDesignerUtil.getServicePath().equals("path")) {
			MessageDialog.openInformation(null, "提示", "请先在设计器根目录的配置文件(path.properties)中更改服务地址(service)");
			return "";
		}
		return FoxBPMDesignerUtil.getProperties().get("flowConnectorPath").toString() + "/";
	}

	/**
	 * 得到处理者选择器Menu图标所存放的路径
	 * 
	 * @return
	 */
	public static String getActorConnectorIconPath() {
		return getActorConnectorPath() + "ico/";
	}

	/**
	 * 得到连接器Menu图标所存放的路径
	 * 
	 * @return
	 */
	public static String getFlowConnectorIconPath() {
		return getFlowConnectorPath() + "ico/";
	}

	/**
	 * 得到处理者选择器Menu文件路径
	 * 
	 * @return
	 */
	public static String getActorConnectorMenuPath() {
		return getActorConnectorPath() + ACTORCONNECTORMENU;
	}

	/**
	 * 得到连接器Menu文件路径
	 * 
	 * @return
	 */
	public static String getFlowConnectorMenuPath() {
		return getFlowConnectorPath() + FLOWCONNECTORMENU;
	}

	/**
	 * 根据处理者选择器ID得到对应处理者选择器文件存放路径
	 * 
	 * @param connectorId
	 * @return
	 */
	public static String getActorConnectorPathById(String connectorId) {
		return getActorConnectorPath() + connectorId;
	}

	/**
	 * 根据连接器ID得到对应连接器文件存放路径
	 * 
	 * @param connectorId
	 * @return
	 */
	public static String getFlowConnectorPathById(String connectorId) {
		return getFlowConnectorPath() + connectorId;
	}

	/**
	 * 获取处理者选择器菜单对象
	 * 
	 * @return
	 */
	public static Menu getActorConnectorMenu() {
		return EMFUtil.getConnectorMenuConfig(getActorConnectorMenuPath());
	}

	/**
	 * 获取连接器选择器菜单对象
	 * 
	 * @return
	 */
	public static Menu getFlowConnectorMenu() {
		return EMFUtil.getConnectorMenuConfig(getFlowConnectorMenuPath());
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
	 * 根据选择器ID得到对应选择器xml文件路径
	 * 
	 * @param connectorId
	 * @return
	 */
	public static String getActorConnectorMenuPath(String connectorId) {
		return getActorConnectorPath() + connectorId + "/" + ACTORCONNECTOR;
	}

	/**
	 * 根据连接器ID得到对应连接器xml文件路径
	 * 
	 * @param connectorId
	 * @return
	 */
	public static String getFlowConnectorMenuPath(String connectorId) {
		return getFlowConnectorPath() + connectorId + "/" + FLOWCONNECTOR;
	}
	
	/**
	 * 根据Menu上的连接器ID找到对应的连接器对象
	 * 
	 * @param connectorId
	 * @return
	 */
	public static ConnectorDefinition getFlowConnectorByMenuConnectorId(String connectorId) {
		try {
			ConnectorDefinition connector = EMFUtil.getFlowConnectorConfig(getFlowConnectorMenuPath(connectorId));
			if (connector.getId().equals(connectorId)) {
				return connector;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据Menu上的连接器ID找到对应的处理者选择器对象
	 * 
	 * @param connectorId
	 * @return
	 */
	public static ConnectorDefinition getActorConnectorByMenuConnectorId(String connectorId) {
		try {
			ConnectorDefinition connector = EMFUtil.getFlowConnectorConfig(getActorConnectorMenuPath(connectorId));
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
								if (!node.getIco().contains(DefinitionConnectorUtil.getActorConnectorIconPath())) {
									// 打开原文件（Menu图标）
									FileInputStream menufis = new FileInputStream(node.getIco());
									// 打开连接到目标文件的输出流
									File menuoutfile = new File(DefinitionConnectorUtil.getActorConnectorIconPath() + FileUtil.getFileName(node.getIco()));
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
		XMIResource resource = (XMIResource) resSet.createResource(URI.createFileURI(getActorConnectorPath() + ACTORCONNECTORMENU));
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
								if (!node.getIco().contains(DefinitionConnectorUtil.getFlowConnectorIconPath())) {
									// 打开原文件（Menu图标）
									FileInputStream menufis = new FileInputStream(node.getIco());
									// 打开连接到目标文件的输出流
									File menuoutfile = new File(DefinitionConnectorUtil.getFlowConnectorIconPath() + FileUtil.getFileName(node.getIco()));
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
		XMIResource resource = (XMIResource) resSet.createResource(URI.createFileURI(getFlowConnectorPath() + FLOWCONNECTORMENU));
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
		Menu root = DefinitionConnectorUtil.getFlowConnectorMenu();
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
