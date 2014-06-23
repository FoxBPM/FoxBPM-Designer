package org.foxbpm.bpmn.designer.ui.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.foxbpm.bpmn.designer.base.utils.EMFUtil;
import org.foxbpm.bpmn.designer.ui.utils.DefinitionConnectorUtil;
import org.foxbpm.model.config.connector.ConnectorDefinition;
import org.foxbpm.model.config.connectormenu.Menu;
import org.foxbpm.model.config.connectormenu.MenuConnector;
import org.foxbpm.model.config.connectormenu.Node;
import org.foxbpm.model.config.foxbpmconfig.ResourcePath;

public class DefinitionTreeViewerFactory {

	/**
	 * 
	 */
	public DefinitionTreeViewerFactory() {
	}

	/**
	 * 加载树数据
	 * 
	 * @return
	 */
	public static List<ITreeElement> reloadTree() {
		List<ITreeElement> elements = new ArrayList<ITreeElement>();

		List<Node> nodes = DefinitionConnectorUtil.getAllFlowConnectorNodes();

		getTreeElements(nodes, null, elements);
		
		return elements;
	}
	
	/**
	 * 加载树数据
	 * 
	 * @return
	 */
	public static List<ITreeElement> reloadActorTree() {
		List<ITreeElement> elements = new ArrayList<ITreeElement>();

		List<Node> nodes = DefinitionConnectorUtil.getAllActorConnectorNodes();
		
		getActorTreeElements(nodes, null, elements);

		return elements;
	}

	/**
	 * 根据连接器菜单加载分类树
	 * 
	 * @return
	 */
	public static List<ITreeElement> reloadTreeNodes(ResourcePath resourcePath) {
		List<ITreeElement> elements = new ArrayList<ITreeElement>();
		// Menu
		Menu root = DefinitionConnectorUtil.getFlowConnectorMenu(resourcePath);
		// 分拆menu成为ITreeElement树
		if (root != null) {
			EList<Node> nodes = root.getNode();
			getTreeElementsNodes(nodes, null, elements);
		}
		return elements;
	}
	
	/**
	 * 只加载树的根节点数据
	 * 
	 * @return
	 */
	public static List<ITreeElement> reloadActorTreeNodes(ResourcePath resourcePath) {
		List<ITreeElement> elements = new ArrayList<ITreeElement>();
		// Menu
		Menu root = DefinitionConnectorUtil.getActorConnectorMenu(resourcePath);
		// 分拆menu成为ITreeElement树
		if (root != null) {
			EList<Node> nodes = root.getNode();
			getActorTreeElementsNodes(nodes, null, elements);
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
	 * 递归查找处理者连接器node节点并且只取所有node
	 * 
	 * @param nodes
	 * @param element
	 * @param elements
	 */
	private static void getActorTreeElementsNodes(List<Node> nodes, ITreeElement element, List<ITreeElement> elements) {
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
						if(DefinitionConnectorUtil.getFlowConnectorByMenuConnectorId(menuConnector.getId(), node.getId()) == null)
							continue;
						String icon = DefinitionConnectorUtil.getFlowConnectorIconPathByIconName(menuConnector.getId(), node.getId(), DefinitionConnectorUtil.getFlowConnectorByMenuConnectorId(menuConnector.getId(), node.getId()).getIcon());
						String note = DefinitionConnectorUtil.getFlowConnectorByMenuConnectorId(menuConnector.getId(), node.getId()).getNote();
						ITreeElement childElement = new EntityElement(parentElement, menuConnector.getId(), menuConnector.getName(), node.getId(),//放入nodeId
								icon, note);
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
						if(DefinitionConnectorUtil.getActorConnectorByMenuConnectorId(menuConnector.getId(), node.getId()) == null)
							continue;
						
						String icon = DefinitionConnectorUtil.getActorConnectorIconPathByIconName(menuConnector.getId(), node.getId(), DefinitionConnectorUtil.getActorConnectorByMenuConnectorId(menuConnector.getId(), node.getId()).getIcon());
						String note = DefinitionConnectorUtil.getActorConnectorByMenuConnectorId(menuConnector.getId(), node.getId()).getNote();
						ITreeElement childElement = new EntityElement(parentElement, menuConnector.getId(), menuConnector.getName(), node.getId(),//放入nodeId
								icon, note);
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
	public static ConnectorDefinition getConnector(String connectorId, String nodeId) {
		return DefinitionConnectorUtil.getFlowConnectorDefinitionById(connectorId, nodeId);
	}
	
	/**
	 * 获取连接器
	 * 
	 * @param url
	 * @return
	 */
	public static ConnectorDefinition getActorConnector(String connectorId, String nodeId) {
		return DefinitionConnectorUtil.getActorConnectorDefinitionById(connectorId, nodeId);
	}
}
