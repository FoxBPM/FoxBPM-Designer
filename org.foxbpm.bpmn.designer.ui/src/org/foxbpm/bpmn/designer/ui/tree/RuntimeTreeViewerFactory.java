package org.foxbpm.bpmn.designer.ui.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.foxbpm.bpmn.designer.ui.utils.ConnectorUtil;
import org.foxbpm.model.config.connector.ConnectorDefinition;
import org.foxbpm.model.config.connectormenu.Menu;
import org.foxbpm.model.config.connectormenu.MenuConnector;
import org.foxbpm.model.config.connectormenu.Node;

public class RuntimeTreeViewerFactory {

	/**
	 * 
	 */
	public RuntimeTreeViewerFactory() {
	}

	/**
	 * 加载树数据
	 * 
	 * @return
	 */
	public static List<ITreeElement> reloadTree() {
		List<ITreeElement> elements = new ArrayList<ITreeElement>();

//		Menu root = ConnectorUtil.getFlowConnectorMenu();

		// 分拆menu成为ITreeElement树
//		if (root != null) {
//			EList<Node> nodes = root.getNode();
//			// 递归查找node节点
//			getTreeElements(nodes, null, elements);
//		}

		List<Node> nodes = ConnectorUtil.getNodesFromConnectorPath(ConnectorUtil.FLOWCONNECTORMENU);
		// 递归查找node节点
		getActorTreeElements(nodes, null, elements);
		
		return elements;
	}
	
	/**
	 * 加载树数据
	 * 
	 * @return
	 */
	public static List<ITreeElement> reloadActorTree() {
		List<ITreeElement> elements = new ArrayList<ITreeElement>();
//		Menu root = ConnectorUtil.getActorConnectorMenu();

		// 分拆menu成为ITreeElement树
//		if (root != null) {
//			EList<Node> nodes = root.getNode();
//			// 递归查找node节点
//			getActorTreeElements(nodes, null, elements);
//		}
		
		List<Node> nodes = ConnectorUtil.getNodesFromConnectorPath(ConnectorUtil.ACTORCONNECTORMENU);
		// 递归查找node节点
		getActorTreeElements(nodes, null, elements);

		return elements;
	}

	/**
	 * 只加载树的根节点数据
	 * 
	 * @return
	 */
	public static List<ITreeElement> reloadTreeNodes() {
		List<ITreeElement> elements = new ArrayList<ITreeElement>();

		// Menu
		// root=EMFUtil.getConnectorMenuConfig(ConnectorUtil.getMenuConnectorPath());
		Menu root = ConnectorUtil.getRuntimeFlowConnectorMenu();
		// 分拆menu成为ITreeElement树
		if (root != null) {
			EList<Node> nodes = root.getNode();
			getTreeElementsNodes(nodes, null, elements);
		}
		// 这个里面加入一个创建...，为了和页面上的一致 //不需要再加创建了，因为已经移植到主界面上去了。
//		ITreeElement parentElementDefault = new EntityElement(null, java.util.UUID.randomUUID().toString(), "创建...", "创建...", "");
		// ConnectorUtil.getMenuConnectorIconPathByIconName(node.getIco()), "");
//		elements.add(parentElementDefault);
		return elements;
	}
	
	/**
	 * 只加载树的根节点数据
	 * 
	 * @return
	 */
	public static List<ITreeElement> reloadActorTreeNodes() {
		List<ITreeElement> elements = new ArrayList<ITreeElement>();

		// Menu
		// root=EMFUtil.getConnectorMenuConfig(ConnectorUtil.getMenuConnectorPath());
		Menu root = ConnectorUtil.getActorConnectorMenu();
		// 分拆menu成为ITreeElement树
		if (root != null) {
			EList<Node> nodes = root.getNode();
			getActorTreeElementsNodes(nodes, null, elements);
		}
		// 这个里面加入一个创建...，为了和页面上的一致 //不需要再加创建了，因为已经移植到主界面上去了。
//		ITreeElement parentElementDefault = new EntityElement(null, java.util.UUID.randomUUID().toString(), "创建...", "创建...", "");
		// ConnectorUtil.getMenuConnectorIconPathByIconName(node.getIco()), "");
//		elements.add(parentElementDefault);
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
	 * 递归查找处理者连接器node节点并且只取所有node
	 * 
	 * @param nodes
	 * @param element
	 * @param elements
	 */
	private static void getActorTreeElementsNodes(EList<Node> nodes, ITreeElement element, List<ITreeElement> elements) {
		if (nodes != null && nodes.size() > 0) {
			for (Iterator iterator = nodes.iterator(); iterator.hasNext();) {
				Node node = (Node) iterator.next();
				ITreeElement parentElement = new EntityElement(element, node.getId(), node.getName(), node.getName(), node.getIco(), "");
				EList<Node> nodeitems = node.getNode();
				if (nodeitems != null && nodeitems.size() > 0) {
					getActorTreeElementsNodes(nodeitems, parentElement, elements);
				}

				if (element != null)
					element.addChild(parentElement);
				else
					elements.add(parentElement);
			}
		}
	}

	/**
	 * 递归查找node节点
	 * 
	 * @param nodes
	 * @param element
	 * @param elements
	 */
	private static void getTreeElements(List<Node> nodes, ITreeElement element, List<ITreeElement> elements) {
		if (nodes != null && nodes.size() > 0) {
			for (Iterator iterator = nodes.iterator(); iterator.hasNext();) {
				Node node = (Node) iterator.next();

				ITreeElement parentElement = new EntityElement(element, node.getId(), node.getName(), node.getName(), node.getIco(), "");

				EList<MenuConnector> connectors = node.getMenuConnector();
				if (connectors != null && connectors.size() > 0) {
					for (Iterator iterator2 = connectors.iterator(); iterator2.hasNext();) {
						MenuConnector menuConnector = (MenuConnector) iterator2.next();
						if(ConnectorUtil.getFlowConnectorByMenuConnectorId(menuConnector.getId()) == null)
							continue;
						ITreeElement childElement = new EntityElement(parentElement, menuConnector.getId(), menuConnector.getName(), menuConnector.getName(),
								ConnectorUtil.getFlowConnectorIconPathByIconName(menuConnector.getId(), ConnectorUtil.getFlowConnectorByMenuConnectorId(menuConnector.getId())
										.getIcon()), ConnectorUtil.getFlowConnectorByMenuConnectorId(menuConnector.getId()).getNote());
						parentElement.addChild(childElement);
					}
				}

				if (element != null)
					element.addChild(parentElement);
				else
					elements.add(parentElement);

				if (node.getNode() != null && node.getNode().size() > 0) {
					getTreeElements(node.getNode(), parentElement, elements);
				}
			}
		}
	}
	
	/**
	 * 递归查找处理者连接器node节点
	 * 
	 * @param nodes
	 * @param element
	 * @param elements
	 */
	private static void getActorTreeElements(List<Node> nodes, ITreeElement element, List<ITreeElement> elements) {
		if (nodes != null && nodes.size() > 0) {
			for (Iterator iterator = nodes.iterator(); iterator.hasNext();) {
				Node node = (Node) iterator.next();

				ITreeElement parentElement = new EntityElement(element, node.getId(), node.getName(), node.getName(), node.getIco(), "");

				EList<MenuConnector> connectors = node.getMenuConnector();
				if (connectors != null && connectors.size() > 0) {
					for (Iterator iterator2 = connectors.iterator(); iterator2.hasNext();) {
						MenuConnector menuConnector = (MenuConnector) iterator2.next();
						if(ConnectorUtil.getActorConnectorByMenuConnectorId(menuConnector.getId()) == null)
							continue;
						ITreeElement childElement = new EntityElement(parentElement, menuConnector.getId(), menuConnector.getName(), menuConnector.getName(),
								ConnectorUtil.getRuntimeActorConnectorIconPathByIconName(menuConnector.getId(), ConnectorUtil.getActorConnectorByMenuConnectorId(menuConnector.getId())
										.getIcon()), ConnectorUtil.getActorConnectorByMenuConnectorId(menuConnector.getId()).getNote());
						parentElement.addChild(childElement);
					}
				}

				if (element != null)
					element.addChild(parentElement);
				else
					elements.add(parentElement);

				if (node.getNode() != null && node.getNode().size() > 0) {
					getActorTreeElements(node.getNode(), parentElement, elements);
				}
			}
		}
	}

	/**
	 * 获取连接器
	 * 
	 * @param url
	 * @return
	 */
	public static ConnectorDefinition getConnector(String connectorId) {
		return ConnectorUtil.getFlowConnectorByMenuConnectorId(connectorId);
	}
	
	/**
	 * 获取连接器
	 * 
	 * @param url
	 * @return
	 */
	public static ConnectorDefinition getActorConnector(String connectorId) {
		return ConnectorUtil.getActorConnectorByMenuConnectorId(connectorId);
	}

}
