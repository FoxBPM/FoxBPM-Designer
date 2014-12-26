package org.foxbpm.bpmn.designer.ui.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.foxbpm.bpmn.designer.ui.Activator;

import com.wisedu.emap.studio.common.util.FixUtil;

public class FoxBpmnPreferenceInitializer extends AbstractPreferenceInitializer {
	//默认解压路径
	private static final String UNZIP_PATH = FixUtil.getEclipseRealRootPath() + "bpmn";

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		// 设置默认的首选项值
		store.setDefault(FoxBpmnPreferenceConstants.P_SERVER_ADDRESS,
				"http://127.0.0.1:8080/foxbpm-webapps-rest/service/");
		store.setDefault(FoxBpmnPreferenceConstants.P_USERNAME, "user");
		store.setDefault(FoxBpmnPreferenceConstants.P_PASSWORD, "password");
		store.setDefault(FoxBpmnPreferenceConstants.P_ZIP_PATH, UNZIP_PATH);
		store.setDefault(FoxBpmnPreferenceConstants.P_CONNECTOR_PATH, "");
	}
	
}
