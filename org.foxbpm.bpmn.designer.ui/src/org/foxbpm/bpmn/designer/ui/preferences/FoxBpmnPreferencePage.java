package org.foxbpm.bpmn.designer.ui.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.foxbpm.bpmn.designer.ui.Activator;

public class FoxBpmnPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public FoxBpmnPreferencePage() {
		super(GRID);
	}

	@Override
	public void init(IWorkbench workbench) {
		//设置首选项保存对象
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("流程设计器配置页");
	}

	@Override
	protected void createFieldEditors() {
		Composite parent=getFieldEditorParent();
		
		StringFieldEditor serverAddressEditor=new StringFieldEditor(FoxBpmnPreferenceConstants.P_SERVER_ADDRESS, "服务器地址:", parent);
		StringFieldEditor portEditor=new StringFieldEditor(FoxBpmnPreferenceConstants.P_PORT, "端口：", parent);
		StringFieldEditor usernameEditor=new StringFieldEditor(FoxBpmnPreferenceConstants.P_USERNAME, "用户名：", parent);
		StringFieldEditor passwordEditor=new StringFieldEditor(FoxBpmnPreferenceConstants.P_PASSWORD, "密码：", parent);
		
		addField(serverAddressEditor);
		addField(portEditor);
		addField(usernameEditor);
		addField(passwordEditor);
	}

}