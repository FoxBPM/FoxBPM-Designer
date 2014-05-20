package org.foxbpm.bpmn.designer.ui.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.foxbpm.bpmn.designer.ui.Activator;

public class FoxBpmnPreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		// 设置默认的首选项值
		store.setDefault(FoxBpmnPreferenceConstants.P_SERVER_ADDRESS, "http://127.0.0.1");
		store.setDefault(FoxBpmnPreferenceConstants.P_PORT, "8080");
		store.setDefault(FoxBpmnPreferenceConstants.P_USERNAME, "xpzeng");
		store.setDefault(FoxBpmnPreferenceConstants.P_PASSWORD, "123456");
	}

}
