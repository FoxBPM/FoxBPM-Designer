package org.foxbpm.bpmn.designer.ui.utils;

import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.foxbpm.bpmn.designer.base.utils.PropertiesUtil;

public class FoxBPMDesignerUtil {
	public static String getPropertiesPath() {
		return Platform.getInstallLocation().getURL().getPath() + "path.properties";
	}
	
	public static Map<String, Object> getProperties() {
		return PropertiesUtil.readProperties(getPropertiesPath());
	}
	
	public static String getServicePath() {
		return PropertiesUtil.readProperties(getPropertiesPath()).get("service").toString() + "/";
	}
	
	public static String getTempleteFilePath() {
		return getServicePath() + "template/flow-template/default_process/default_process.bpmn";
	}
}
