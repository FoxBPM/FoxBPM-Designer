package org.foxbpm.bpmn.designer.ui.utils;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.preference.IPreferenceStore;
import org.foxbpm.bpmn.designer.ui.Activator;
import org.foxbpm.bpmn.designer.ui.preferences.FoxBpmnPreferenceConstants;

import com.wisedu.emap.studio.common.util.StudioUtil;

/**
 * 首选项工具类
 * 
 * @author zengxianping
 * 
 */
public class PreferenceUtil {
	/**
	 * 设置服务器地址
	 * 
	 * @param projectName
	 */
	private static void setServerAddress(IProject project) {
		String serverAddress = "http://127.0.0.1:8080/" + project.getName()
				+ "/service";

		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.setValue(FoxBpmnPreferenceConstants.P_SERVER_ADDRESS,
				serverAddress);
	}

	/**
	 * 设置连接器menu路径
	 * 
	 * @param projectName
	 */
	private static void setConnectorMenuPath(IProject project) {
		String studioPath = StudioUtil.getStudioPath(project.getName());
		String connectorMenuPath = project.getLocation().toOSString() + "/"
				+ studioPath + "flow/CustomConnectorMenu.xml";
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.setValue(FoxBpmnPreferenceConstants.P_CONNECTOR_PATH,
				connectorMenuPath);
	}
	
	
	/**
	 * 设置流程首选项
	 * @param project
	 */
	public static void setFlowPreference(IProject project){
		setServerAddress(project);
		setConnectorMenuPath(project);
	}
}
