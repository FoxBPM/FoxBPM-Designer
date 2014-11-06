package org.foxbpm.bpmn.designer.base.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig;
import org.foxbpm.model.config.variableconfig.DataVariableConfig;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;

public class FoxBPMDesignerUtil {
	public static final String PLUGIN_ID = "org.foxbpm.bpmn.designer.ui";
	public static String FOXBPM_REPOSITORY_FLOW_TEMPLATE = "template/flowtemplate/";

	/**
	 * 取临时读取的properties文件路径
	 * 
	 * @return
	 */
	public static String getPropertiesPath() {
		return Platform.getInstallLocation().getURL().getPath() + "path.properties";
	}

	/**
	 * 取flowresource文件夹路径
	 * 
	 * @return
	 */
	public static String getFlowResourcePath() {
		return Platform.getInstallLocation().getURL().getPath() + "flowresource";
	}

	/**
	 * 读取properties文件返回map
	 * 
	 * @return
	 */
	public static Map<String, Object> getProperties() {
		return PropertiesUtil.readProperties(getPropertiesPath());
	}

	/**
	 * 返回临时的服务文件夹目录路径
	 * 
	 * @return
	 */
	public static String getServicePath() {
		String defaultPath = Platform.getInstallLocation().getURL().getPath() + "flowresource";
		return Platform.getPreferencesService().getString(PLUGIN_ID, "zipPath", defaultPath, null) + "/serviceFiles/";
	}
	
	/**
	 * 返回连接器菜单路径
	 * 
	 * @return
	 */
	public static String getConnectorMenuPath() {
		return Platform.getPreferencesService().getString(PLUGIN_ID, "connectorPath", null, null);
	}

	public static String getServicePathPath() {
		String servicePath = Platform.getPreferencesService().getString(PLUGIN_ID, "serverAddress", "http://127.0.0.1:8080/foxbpm-webapps-rest/service/", null);
		if (servicePath.lastIndexOf("/") == servicePath.length() - 1) {
			return servicePath;
		} else {
			return servicePath + "/";
		}
	}

	/**
	 * 返回临时目录中的流程模板文件路径
	 * 
	 * @return
	 */
	public static String getTempleteFilePath() {
		return getServicePath() + "template/flowtemplate/default_process/default_process.bpmn";
	}

	/**
	 * 返回临时目录中的流程模板路径
	 * 
	 * @return
	 */
	public static String getTempletePath() {
		return getServicePath() + "template/";
	}

	/**
	 * 返回临时目录中的缓存文件路径
	 * 
	 * @return
	 */
	public static String getCachePath() {
		return getServicePath() + "cache/";
	}

	/**
	 * 返回临时目录中的流程节点模板路径
	 * 
	 * @return
	 */
	public static String getNodeTempletePath() {
		return getServicePath() + "template/nodetemplate/";
	}

	/**
	 * 返回临时目录中的流程节点模板路径
	 * 
	 * @return
	 */
	public static String getFlowTempletePath() {
		return getServicePath() + FOXBPM_REPOSITORY_FLOW_TEMPLATE;
	}

	/**
	 * 取foxbpm.cfg.xml路径
	 * 
	 * @return
	 */
	public static String getTempleteConfigFilePath() {
		return getServicePath() + "coreconfig/connector.xml";
	}

	/**
	 * @return datavariableconfig.xml路径
	 */
	public static String getDataVariableConfigPath() {
		return getServicePath() + "coreconfig/datavariableconfig.xml";
	}

	/**
	 * 返回数据变量配置对象
	 * 
	 * @return
	 */
	public static DataVariableConfig getDataVariableConfig() {
		DataVariableConfig dataVariableConfig = (DataVariableConfig) EMFUtil.readEMFFile(FoxBPMDesignerUtil.getDataVariableConfigPath()).getContents().get(0);
		return dataVariableConfig;
	}

	/**
	 * 拿到所有启用为true的TaskCommand对象
	 * 
	 * @return
	 */
//	public static List<TaskCommandDefinition> getTaskCommandNames(FoxBPMConfig foxBPMConfig) {
//		List<TaskCommandDefinition> taskCommandNames = new ArrayList<TaskCommandDefinition>();
//		for (TaskCommandDefinition taskCommand : foxBPMConfig.getTaskCommandConfig().getTaskCommandDefinition()) {
//			if (taskCommand.getIsEnabled().equals("true") && !taskCommand.getType().equals("system")) {
//				taskCommandNames.add(taskCommand);
//			}
//		}
//		return taskCommandNames;
//	}
	
	/**
	 * 返回foxBPMConfig对象
	 * 
	 * @return
	 */
	public static FoxBPMConfig getFoxBPMConfig() {
		FoxBPMConfig foxBPMConfig = (FoxBPMConfig) EMFUtil.readEMFFile(getTempleteConfigFilePath()).getContents().get(0);
		return foxBPMConfig;
	}

	/**
	 * 拿假的groovy文件
	 * 
	 * @return
	 */
	public static String getFakeGroovyFilePath() {
		File file = new File(Platform.getInstallLocation().getURL().getPath() + "fake.groovy");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file.getAbsolutePath();
	}

	/**
	 * 刷新项目
	 * 
	 * @param projectName
	 *            项目名称
	 * @param type
	 *            类型 IResource.FOLDER,IResource.FILE
	 */
	public static void refresh(String projectName, String folder, int type) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IProject project = workspace.getRoot().getProject(projectName);
		IPath location = Path.fromOSString(folder);

		if (type == IResource.FILE) {
			IFile file = (IFile) project.findMember(location);
			try {
				file.refreshLocal(IResource.DEPTH_INFINITE, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		} else if (type == IResource.FOLDER) {
			IFolder iFolder = (IFolder) project.findMember(location);
			try {
				iFolder.refreshLocal(IResource.DEPTH_INFINITE, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 刷新文件
	 * 
	 * @param file
	 */
	public static void refresh(String file) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IPath location = Path.fromOSString(file);

		IFile iFile = workspace.getRoot().getFileForLocation(location);
		try {
			iFile.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据传入的url返回对应的clientresource对象
	 * 
	 * @param url
	 * @return
	 */
	public static ClientResource getClientByUrl(String url) {
		ClientResource client = new ClientResource(FoxBPMDesignerUtil.getServicePathPath() + url);
		client.setChallengeResponse(ChallengeScheme.HTTP_BASIC, "111", "111");
		client.setRetryAttempts(0);
		try {
			ClientResource testclient = new ClientResource(FoxBPMDesignerUtil.getServicePathPath() + "testConnection");
			testclient.setChallengeResponse(ChallengeScheme.HTTP_BASIC, "111", "111");
			testclient.setRetryAttempts(0);
			testclient.get();
		} catch (Exception e) {
			MessageDialog.openInformation(null, "提示", "暂时无法连接流程服务，请检查网络或服务配置并稍后重试，导致此错误的原因是：\n" + e.getMessage());
			return null;
		}
		return client;
	}
}
