package org.foxbpm.bpmn.designer.base.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.foxbpm.model.config.connector.ConnectorDefinition;
import org.foxbpm.model.config.connector.Input;
import org.foxbpm.model.config.connectormenu.Menu;
import org.foxbpm.model.config.connectormenu.MenuConnector;
import org.foxbpm.model.config.connectormenu.Node;
import org.restlet.data.ChallengeScheme;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class RuntimeConnectorUtil {
	public static String FLOWCONNECTORMENU = "FlowConnectorMenu.xml";

	public static String ACTORCONNECTORMENU = "ActorConnectorMenu.xml";

	public static String FLOWCONNECTOR = "FlowConnector.xml";

	public static String ACTORCONNECTOR = "ActorConnector.xml";
	
	public static HashMap<String, Object> allFlowConnectors = null;

	/**
	 * 得到运行时连接器所存放的路径
	 * 
	 * @return
	 */
	public static String getAllConnectorPath() {
		if (FoxBPMDesignerUtil.getServicePath().equals("path")) {
			MessageDialog.openInformation(null, "提示", "请先在设计器根目录的配置文件(path.properties)中更改服务地址(service)");
			return "";
		}
		return FoxBPMDesignerUtil.getServicePath() + "/connector/";
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

	/**
	 * 加载所有目录下的连接器
	 * @return 
	 */
	public static HashMap<String, Object> getAllConnectors() {
			allFlowConnectors = new HashMap<String, Object>();
			File connectorPath = new File(getAllConnectorPath());
			reloadAllConnectors(connectorPath.getAbsolutePath());
		return allFlowConnectors;
	}

	private static void reloadAllConnectors(String path) {
		File filePath = new File(path);
		for (File file : filePath.listFiles()) {
			if (file.isDirectory()) {
				// FlowMenuXML文件
				File xmlFile = new File(file.getAbsolutePath() + "/" + FLOWCONNECTORMENU);
				File actorXmlFile = new File(file.getAbsolutePath() + "/" + ACTORCONNECTORMENU);
				if (xmlFile.exists()) {
					reload(file, xmlFile);
				} else if (actorXmlFile.exists()) {
					reload(file, actorXmlFile);
				} else {
					reloadAllConnectors(file.getAbsolutePath());
				}
			} else {
				// FlowMenuXML文件
				File xmlFile = new File(file.getAbsolutePath());
				File actorXmlFile = new File(file.getAbsolutePath() + "/" + ACTORCONNECTORMENU);
				if (file.getAbsolutePath().indexOf(FLOWCONNECTORMENU) != -1 && xmlFile.exists()) {
					reload(file, xmlFile);
				} else if (file.getAbsolutePath().indexOf(FLOWCONNECTORMENU) != -1 && actorXmlFile.exists()) {
					reload(file, actorXmlFile);
				} else {
					// do nothing
				}
			}
		}
	}

	private static void reload(File file, File xmlFile) {
		Menu menu = EMFUtil.getConnectorMenuConfig(xmlFile.getAbsolutePath());
		for (Node node : EMFUtil.getAll(menu.eResource(), Node.class)) {
			node.setIco(file.getAbsolutePath().replace(File.separator, "/") + "/ico/" + node.getIco());
			for (MenuConnector connector : node.getMenuConnector()) {
				connector.setIco(file.getAbsolutePath().replace(File.separator, "/") + "/" +  connector.getId() + "/" + connector.getIco());
				//connector的具体路径
				String connectorPath = xmlFile.getAbsolutePath().substring(0, xmlFile.getAbsolutePath().lastIndexOf(File.separator)) + File.separator + connector.getId() + File.separator;
				HashMap<String, Object> map = new HashMap<String, Object>();
				//对象
				map.put("object", connector);
				//所在节点
				map.put("node", node);
				//目录
				map.put("path", connectorPath);
				//放到map里
				allFlowConnectors.put(connector.getId(), map);
			}
		}
	}

	/**
	 * 根据Menu上的连接器ID找到对应的连接器对象
	 * 
	 * @param connectorId
	 * @return
	 */
	public static ConnectorDefinition getFlowConnectorByMenuConnectorId(String connectorId) {
		try {
			ConnectorDefinition connector = EMFUtil.getFlowConnectorConfig(((HashMap<String, Object>)getAllConnectors().get(connectorId)).get("path") + FLOWCONNECTOR);
			if (connector.getId().equals(connectorId)) {
				return connector;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据Menu上的连接器ID找到对应的连接器对象
	 * 
	 * @param connectorId
	 * @return
	 */
	public static ConnectorDefinition getActorConnectorByMenuConnectorId(String connectorId) {
		try {
			ConnectorDefinition connector = EMFUtil.getFlowConnectorConfig(((HashMap<String, Object>)getAllConnectors().get(connectorId)).get("path") + ACTORCONNECTOR);
			if (connector.getId().equals(connectorId)) {
				return connector;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 递归找到对应类型的所有menu上的连接器节点
	 * 
	 * @param type
	 *            FLOWCONNECTORMENU或ACTORCONNECTORMENU
	 * @return
	 */
	public static List<Node> getNodesFromConnectorPath(String type) {
		List<Node> nodes = new ArrayList<Node>();
		File connectorPath = new File(getAllConnectorPath());
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
							connector.setIco(file.getAbsolutePath().replace(File.separator, "/") + "/" + connector.getId() + "/" + connector.getIco());
						}
						nodes.add(node);
					}
				} else {
					getFileChild(file.getAbsolutePath(), nodes, type);
				}
			} else {
				// XML文件
				File xmlFile = new File(file.getAbsolutePath());
				if (file.getAbsolutePath().indexOf(type) != -1 && xmlFile.exists()) {
					Menu menu = EMFUtil.getConnectorMenuConfig(xmlFile.getAbsolutePath());
					for (Node node : menu.getNode()) {
						node.setIco(file.getAbsolutePath().replace(File.separator, "/") + "/ico/" + node.getIco());
						for (MenuConnector connector : node.getMenuConnector()) {
							connector.setIco(file.getAbsolutePath().replace(File.separator, "/") + "/" + connector.getId() + "/" + connector.getIco());
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
	 * 下载运行时连接器
	 * 
	 * @param type
	 * @return
	 * @throws IOException
	 */
	public static String downLoadConnector(String type) throws Exception {
		String connectorPath = getAllConnectorPath();
		// Authenticator.setDefault(new Authenticator() {
		// protected PasswordAuthentication getPasswordAuthentication() {
		// return new PasswordAuthentication("111", "111".toCharArray());
		// }
		// });
		// URL url = null;
		// File file = null;
		// // url = new
		// //
		// URL("http://172.16.40.89:8080/foxbpm-webapps-rest/service/connectors");
		// url = new URL(DOWNLOADURL);
		// file = File.createTempFile(System.currentTimeMillis() + "flowres",
		// ".zip");
		// FileUtils.copyURLToFile(url, file);
		//
		// String servicePath = FoxBPMDesignerUtil.getServicePath();
		// File serviceDirectory = new File(servicePath);
		//
		// if (!type.equals("start") && serviceDirectory.exists()) {
		// // 强制删除服务目录下文件
		// for (File tempFile : serviceDirectory.listFiles()) {
		// FileUtils.forceDelete(tempFile);
		// }
		// }
		//
		// ZipUtils.unZip(file.getPath(), servicePath);

		// REST方式
		String servicePath = FoxBPMDesignerUtil.getServicePath();
		ClientResource client = new ClientResource(FoxBPMDesignerUtil.getServicePathPath() + "flowconfig");
		client.setChallengeResponse(ChallengeScheme.HTTP_BASIC, "111", "111");
		Representation result = client.get();
		FileOutputStream fileOutputStream = null;
		try {
			File file = File.createTempFile(System.currentTimeMillis() + "flowres", ".zip");
			if (file.exists()) {
				file.delete();
			}
			fileOutputStream = new FileOutputStream(file);
			result.write(fileOutputStream);

		if(!new File(servicePath).exists()) {
			new File(servicePath).mkdir();
		}
			
			 if (new File(servicePath).exists()) {
				 // 强制删除服务目录下文件
				for (File tempFile : new File(servicePath).listFiles()) {
					 FileUtils.forceDelete(tempFile);
			 	}
			 }
			
			ZipUtils.unZip(file.getPath(), servicePath);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileOutputStream != null)
				fileOutputStream.close();
		}

		return connectorPath;
	}
}
