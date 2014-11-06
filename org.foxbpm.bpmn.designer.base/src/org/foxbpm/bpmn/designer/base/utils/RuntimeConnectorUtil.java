package org.foxbpm.bpmn.designer.base.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.foxbpm.model.config.connector.ConnectorDefinition;
import org.foxbpm.model.config.connector.Input;
import org.foxbpm.model.config.connectormenu.Connector;
import org.foxbpm.model.config.connectormenu.Menu;
import org.foxbpm.model.config.connectormenu.Node;
import org.restlet.data.ChallengeScheme;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class RuntimeConnectorUtil {
	public static String CONNECTORMENU = "ConnectorMenu.xml";

	public static String FLOWCONNECTOR = "FlowConnector.xml";

	public static String ACTORCONNECTOR = "ActorConnector.xml";

	public static HashMap<String, Object> allFlowConnectors = null;
	
	private static boolean isOk = false;

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
			for (Iterator<Input> iterator = inputs.iterator(); iterator.hasNext();) {
				Input input = iterator.next();
				if (input.getId().equals(inputId))
					return input;
			}
		}
		return null;
	}

	/**
	 * 加载所有目录下的连接器
	 * 
	 * @return
	 */
	public static Map<String, Object> getAllConnectors() {
//		if(allFlowConnectors != null){
//			return allFlowConnectors;
//		}
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
				File xmlFile = new File(file.getAbsolutePath() + "/" + CONNECTORMENU);
				if (xmlFile.exists()) {
					reload(file, xmlFile);
				}else {
					reloadAllConnectors(file.getAbsolutePath());
				}
			} else {
				// FlowMenuXML文件
				File xmlFile = new File(file.getAbsolutePath());
				if (file.getAbsolutePath().indexOf(CONNECTORMENU) != -1 && xmlFile.exists()) {
					reload(file, xmlFile);
				}else {
					// do nothing
				}
			}
		}
	}

	private static void reload(File file, File xmlFile) {
		Menu menu = EMFUtil.getConnectorMenuConfig(xmlFile.getAbsolutePath());
		for (Node node : menu.getFlowConnector().getNode()) {
			readNode(node,xmlFile.getAbsolutePath(),"flowConnector");
		}
		
		for (Node node : menu.getActorConnector().getNode()) {
			readNode(node,xmlFile.getAbsolutePath(),"actorConnector");
		}
	}
	
	
	private static void readNode(Node node,String absolutePath,String type){
		node.setIco(absolutePath.replace(File.separator, "/") + "/ico/" + node.getIco());
		
		for(Node tmpNode : node.getNode()){
			readNode(tmpNode,absolutePath,type);
		}
		for (Connector connector : node.getConnector()) {
			connector.setIco(absolutePath.replace(File.separator, "/") + "/" + connector.getId() + "/" + connector.getIco());
			// connector的具体路径
			String connectorPath = absolutePath.substring(0, absolutePath.lastIndexOf(File.separator))
					+ File.separator  + type +File.separator+ connector.getId() + File.separator;
			HashMap<String, Object> map = new HashMap<String, Object>();
			// 对象
			map.put("object", connector);
			// 所在节点
			map.put("node", node);
			// 目录
			map.put("path", connectorPath);
			//图标
			map.put("ico", node.getIco());
			// 放到map里
			allFlowConnectors.put(connector.getId(), map);
		}
	}

	/**
	 * 根据Menu上的连接器ID找到对应的连接器对象
	 * 
	 * @param connectorId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static ConnectorDefinition getFlowConnectorByMenuConnectorId(String connectorId) {
		try {
			Map<String,Object> connectorMap = (Map<String, Object>) getAllConnectors().get(connectorId);
			if(connectorMap == null){
				return null;
			}
			ConnectorDefinition connector = EMFUtil.getFlowConnectorConfig(connectorMap.get("path") + FLOWCONNECTOR);
			if (connector.getId().equals(connectorId)) {
				return connector;
			}
		} catch (Exception e) {
			System.out.println("连接器"+connectorId+"加载失败！");
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
	@SuppressWarnings("unchecked")
	public static ConnectorDefinition getActorConnectorByMenuConnectorId(String connectorId) {
		try {
			
			Map<String,Object> connectorMap = (Map<String, Object>) getAllConnectors().get(connectorId);
			if(connectorMap == null){
				return null;
			}
			ConnectorDefinition connector = EMFUtil.getFlowConnectorConfig(connectorMap.get("path") + ACTORCONNECTOR);
			if (connector.getId().equals(connectorId)) {
				return connector;
			}
		} catch (Exception e) {
			System.out.println("连接器"+connectorId+"加载失败！");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 递归找到对应类型的所有menu上的连接器节点
	 * 
	 * @param type
	 *            flowconnector或actorconnector
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
				File xmlFile = new File(file.getAbsolutePath() + "/" + CONNECTORMENU);
				if (xmlFile.exists()) {
					Menu menu = EMFUtil.getConnectorMenuConfig(xmlFile.getAbsolutePath());
					reloadNodes(menu, null, xmlFile, nodes, type);
				} else {
					getFileChild(file.getAbsolutePath(), nodes, CONNECTORMENU);
				}
			} else {
				// XML文件
				File xmlFile = new File(file.getAbsolutePath());
				if (file.getAbsolutePath().indexOf(CONNECTORMENU) != -1 && xmlFile.exists()) {
					Menu menu = EMFUtil.getConnectorMenuConfig(xmlFile.getAbsolutePath());
					if(type.equals("flowconnector")) {
						for (Node node : menu.getFlowConnector().getNode()) {
							node.setIco(file.getAbsolutePath().replace(File.separator, "/") + "/ico/" + node.getIco());
							for (Connector connector : node.getConnector()) {
								connector.setIco(file.getAbsolutePath().replace(File.separator, "/") + "/" + connector.getId() + "/"
										+ connector.getIco());
							}
							nodes.add(node);
						}
					}else if(type.equals("actorconnector")) {
						for (Node node : menu.getActorConnector().getNode()) {
							node.setIco(file.getAbsolutePath().replace(File.separator, "/") + "/ico/" + node.getIco());
							for (Connector connector : node.getConnector()) {
								connector.setIco(file.getAbsolutePath().replace(File.separator, "/") + "/" + connector.getId() + "/"
										+ connector.getIco());
							}
							nodes.add(node);
						}
					}
				
				} else {
					// do nothing
				}
			}
		}
	}

	/**
	 * 目录节点下还可能有目录节点
	 * @param menu
	 * @param file
	 * @param nodes
	 */
	private static void reloadNodes(Menu menu, Node rootNode, File file, List<Node> nodes, String type) {
		if(rootNode == null) {
			if(type.equals("flowconnector")) {
				for (Node node : menu.getFlowConnector().getNode()) {
					String nodeico = file.getAbsolutePath().replace(File.separator, "/").substring(0, file.getAbsolutePath().replace(File.separator, "/").lastIndexOf("/")) + "/ico/" + node.getIco();
					node.setIco(nodeico);
					for (Connector connector : node.getConnector()) {
						String ico = file.getAbsolutePath().replace(File.separator, "/").substring(0, file.getAbsolutePath().replace(File.separator, "/").lastIndexOf("/")) + "/" + connector.getId() + "/"
								+ connector.getIco();
						connector.setIco(ico);
					}
					nodes.add(node);
					if(node.getNode().size()>0) {
						reloadNodes(null, node, file, nodes, type);
					}
				}
			}else if(type.equals("actorconnector")) {
				for (Node node : menu.getActorConnector().getNode()) {
					String nodeico = file.getAbsolutePath().replace(File.separator, "/").substring(0, file.getAbsolutePath().replace(File.separator, "/").lastIndexOf("/")) + "/ico/" + node.getIco();
					node.setIco(nodeico);
					for (Connector connector : node.getConnector()) {
						String ico = file.getAbsolutePath().replace(File.separator, "/").substring(0, file.getAbsolutePath().replace(File.separator, "/").lastIndexOf("/")) + "/" + connector.getId() + "/"
								+ connector.getIco();
						connector.setIco(ico);
					}
					nodes.add(node);
					if(node.getNode().size()>0) {
						reloadNodes(null, node, file, nodes, type);
					}
				}
			}
			
		}else {
			for (Node node : rootNode.getNode()) {
				String nodeico = file.getAbsolutePath().replace(File.separator, "/").substring(0, file.getAbsolutePath().replace(File.separator, "/").lastIndexOf("/")) + "/ico/" + node.getIco();
				node.setIco(nodeico);
				for (Connector connector : node.getConnector()) {
					String ico = file.getAbsolutePath().replace(File.separator, "/").substring(0, file.getAbsolutePath().replace(File.separator, "/").lastIndexOf("/")) + "/" + connector.getId() + "/"
							+ connector.getIco();
					connector.setIco(ico);
				}
				rootNode.getNode().add(node);
				if(node.getNode().size()>0) {
					reloadNodes(null, node, file, nodes, type);
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
	public static boolean downLoadConnector(String type) throws Exception {
//		String connectorPath = getAllConnectorPath();
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
		final String servicePath = FoxBPMDesignerUtil.getServicePath();
		if (servicePath.equals("/")) {
			throw new Exception("请先在首选项中配置解压路径");
		}
		ClientResource client = new ClientResource(FoxBPMDesignerUtil.getServicePathPath() + "designer/flowconfig");
		client.setChallengeResponse(ChallengeScheme.HTTP_BASIC, "111", "111");
		Representation result = client.get();
		FileOutputStream fileOutputStream = null;

		isOk = false;

		try {
			final File file = File.createTempFile(System.currentTimeMillis() + "flowres", ".zip");
			if (file.exists()) {
				file.delete();
			}
			fileOutputStream = new FileOutputStream(file);
			result.write(fileOutputStream);

			if (!new File(servicePath).exists()) {
				Display.getDefault().syncExec(new Runnable() {

					@Override
					public void run() {
						boolean b = MessageDialog.openConfirm(null, "提示", FoxBPMDesignerUtil.getServicePath() + "\n目录不存在，是否创建该目录？");
						if (b) {
							new File(servicePath).mkdirs();
						} else {
							return;
						}
					}
				});
			}

			if (new File(servicePath).exists()) {
				Display.getDefault().syncExec(new Runnable() {

					@Override
					public void run() {
						boolean b = MessageDialog.openConfirm(null, "提示", "即将清空\n" + FoxBPMDesignerUtil.getServicePath()
								+ "\n目录下的所有文件，是否确定该操作？");
						if (b) {
							// 强制删除服务目录下文件
							for (File tempFile : new File(FoxBPMDesignerUtil.getServicePath()).listFiles()) {
								try {
									FileUtils.forceDelete(tempFile);
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							ZipUtils.unZip(file.getPath(), servicePath);
							isOk = true;
						} else {
							return;
						}
					}
				});
				// 同步数据
				Display.getDefault().syncExec(new Runnable() {
					@Override
					public void run() {
						try {
							// 组织数据
							SynDataUtils.getInstance().sysData(FoxBPMDesignerUtil.getServicePathPath());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileOutputStream != null)
				fileOutputStream.close();
		}

		return isOk;
	}
}
