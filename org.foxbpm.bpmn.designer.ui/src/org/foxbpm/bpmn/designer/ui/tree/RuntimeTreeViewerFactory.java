package org.foxbpm.bpmn.designer.ui.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.foxbpm.bpmn.designer.base.utils.RuntimeConnectorUtil;
import org.foxbpm.model.config.connector.ConnectorDefinition;
import org.foxbpm.model.config.connectormenu.Connector;
import org.foxbpm.model.config.connectormenu.Connector;
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

		List<Node> nodes = RuntimeConnectorUtil.getNodesFromConnectorPath("flowconnector");
		// 递归查找node节点
		getConnectorTreeElements(nodes, null, elements);
		
		return elements;
	}
	
	/**
	 * 加载树数据
	 * 
	 * @return
	 */
	public static List<ITreeElement> reloadActorTree() {
		List<ITreeElement> elements = new ArrayList<ITreeElement>();
		
		List<Node> nodes = RuntimeConnectorUtil.getNodesFromConnectorPath("actorconnector");
		// 递归查找node节点
		getActorTreeElements(nodes, null, elements);

		return elements;
	}

	/**
	 * 递归查找连接器node节点
	 * @param nodes
	 * @param element
	 * @param elements
	 */
	private static void getConnectorTreeElements(List<Node> nodes, ITreeElement element, List<ITreeElement> elements) {
		if (nodes != null && nodes.size() > 0) {
			for (Iterator iterator = nodes.iterator(); iterator.hasNext();) {
				Node node = (Node) iterator.next();

				ITreeElement parentElement = new EntityElement(element, node.getId(), node.getName(), node.getName(), node.getIco(), "");

				EList<Connector> connectors = node.getConnector();
				if (connectors != null && connectors.size() > 0) {
					for (Iterator iterator2 = connectors.iterator(); iterator2.hasNext();) {
						Connector menuConnector = (Connector) iterator2.next();
						if(RuntimeConnectorUtil.getFlowConnectorByMenuConnectorId(menuConnector.getId()) == null)
							continue;
						ITreeElement childElement = new EntityElement(parentElement, menuConnector.getId(), menuConnector.getName(), menuConnector.getName(),
								menuConnector.getIco(), RuntimeConnectorUtil.getFlowConnectorByMenuConnectorId(menuConnector.getId()).getNote());
						parentElement.addChild(childElement);
					}
				}

				if (element != null)
					element.addChild(parentElement);
				else
					elements.add(parentElement);

				if (node.getNode() != null && node.getNode().size() > 0) {
					getConnectorTreeElements(node.getNode(), parentElement, elements);
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

				EList<Connector> connectors = node.getConnector();
				if (connectors != null && connectors.size() > 0) {
					for (Iterator iterator2 = connectors.iterator(); iterator2.hasNext();) {
						Connector menuConnector = (Connector) iterator2.next();
						if(RuntimeConnectorUtil.getActorConnectorByMenuConnectorId(menuConnector.getId()) == null)
							continue;
						ITreeElement childElement = new EntityElement(parentElement, menuConnector.getId(), menuConnector.getName(), menuConnector.getName(),
								menuConnector.getIco(), RuntimeConnectorUtil.getActorConnectorByMenuConnectorId(menuConnector.getId()).getNote());
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
		return RuntimeConnectorUtil.getFlowConnectorByMenuConnectorId(connectorId);
	}
	
	/**
	 * 获取连接器
	 * 
	 * @param url
	 * @return
	 */
	public static ConnectorDefinition getActorConnector(String connectorId) {
		return RuntimeConnectorUtil.getActorConnectorByMenuConnectorId(connectorId);
	}

}
