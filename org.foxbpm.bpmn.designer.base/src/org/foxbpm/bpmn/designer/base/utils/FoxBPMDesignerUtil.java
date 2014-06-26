package org.foxbpm.bpmn.designer.base.utils;

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
import org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig;
import org.foxbpm.model.config.foxbpmconfig.TaskCommandDefinition;

public class FoxBPMDesignerUtil {
	public static final String PLUGIN_ID = "org.foxbpm.bpmn.designer.ui";
	/**
	 * 取临时读取的properties文件路径
	 * @return
	 */
	public static String getPropertiesPath() {
		return Platform.getInstallLocation().getURL().getPath() + "path.properties";
	}
	
	/**
	 * 取flowresource文件夹路径
	 * @return
	 */
	public static String getFlowResourcePath() {
		return Platform.getInstallLocation().getURL().getPath() + "flowresource";
	}

	/**
	 * 读取properties文件返回map
	 * @return
	 */
	public static Map<String, Object> getProperties() {
		return PropertiesUtil.readProperties(getPropertiesPath());
	}

	/**
	 * 返回临时的服务文件夹目录路径
	 * @return
	 */
	public static String getServicePath() {
		String defaultPath = Platform.getInstallLocation().getURL().getPath() + "flowresource";
		return Platform.getPreferencesService().
				  getString(PLUGIN_ID, "zipPath", defaultPath, null) + "/serviceFiles/"; 
	}
	
	public static String getServicePathPath() {
		String servicePath = Platform.getPreferencesService().
				  getString(PLUGIN_ID, "serverAddress", "http://127.0.0.1:8080/foxbpm-webapps-rest/service/", null);
		if(servicePath.lastIndexOf("/") == servicePath.length()-1) {
			return servicePath;
		} else {
			return servicePath + "/";
		}
	}

	/**
	 * 返回临时目录中的流程模板文件路径
	 * @return
	 */
	public static String getTempleteFilePath() {
		return getServicePath() + "template/flow-template/default_process/default_process.bpmn";
	}

	/**
	 * 取foxbpm.cfg.xml路径
	 * @return
	 */
	public static String getTempleteConfigFilePath() {
		return getServicePath() + "coreconfig/foxbpm.cfg.xml";
	}
	
	/**
	 * 拿到所有启用为true的TaskCommand对象
	 * 
	 * @return
	 */
	public static List<TaskCommandDefinition> getTaskCommandNames(FoxBPMConfig foxBPMConfig) {
		List<TaskCommandDefinition> taskCommandNames = new ArrayList<TaskCommandDefinition>();
		for (TaskCommandDefinition taskCommand : foxBPMConfig.getTaskCommandConfig().getTaskCommandDefinition()) {
			if (taskCommand.getIsEnabled().equals("true") && !taskCommand.getType().equals("system")) {
				taskCommandNames.add(taskCommand);
			}
		}
		return taskCommandNames;
	}

	/**
	 * 返回foxBPMConfig对象
	 * @return
	 */
	public static FoxBPMConfig getFoxBPMConfig() {
		FoxBPMConfig foxBPMConfig = (FoxBPMConfig) EMFUtil.readEMFFile(getTempleteConfigFilePath()).getContents().get(0);
		return foxBPMConfig;
	}
	
	/**
	 * 拿假的groovy文件
	 * @return
	 */
	public static String getFakeGroovyFilePath() {
		return Platform.getInstallLocation().getURL().getPath() + "fake.groovy";
	}
	
	/**
	 * 刷新项目
	 * @param projectName 项目名称
	 * @param type 类型 IResource.FOLDER,IResource.FILE
	 */
	public static void refresh(String projectName, String folder, int type) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IProject project = workspace.getRoot().getProject(projectName);
		IPath location = Path.fromOSString(folder);
		
		if(type==IResource.FILE) {
			IFile file = (IFile) project.findMember(location);
			try {
				file.refreshLocal(IResource.DEPTH_INFINITE, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}else if(type==IResource.FOLDER) {
			IFolder iFolder = (IFolder) project.findMember(location);
			try {
				iFolder.refreshLocal(IResource.DEPTH_INFINITE, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 刷新项目
	 * @param folder
	 * @param type 类型 IResource.FOLDER,IResource.FILE
	 */
	public static void refresh(String folder) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IPath location = Path.fromOSString(folder);
		
		IFile file = workspace.getRoot().getFileForLocation(location);
		try {
			file.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
}
