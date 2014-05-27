package org.foxbpm.bpmn.designer.ui.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.foxbpm.bpmn.designer.base.utils.PropertiesUtil;
import org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig;
import org.foxbpm.model.config.foxbpmconfig.TaskCommandDefinition;

public class FoxBPMDesignerUtil {
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
		return PropertiesUtil.readProperties(getPropertiesPath()).get("service").toString() + "/";
	}
	
	public static String getServicePathPath() {
		if(getProperties().get("servicePath").toString().lastIndexOf("/") == getProperties().get("servicePath").toString().length()-1) {
			return getProperties().get("servicePath").toString();
		} else {
			return getProperties().get("servicePath").toString() + "/";
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
}
