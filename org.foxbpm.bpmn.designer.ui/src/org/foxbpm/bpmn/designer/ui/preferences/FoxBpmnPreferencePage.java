package org.foxbpm.bpmn.designer.ui.preferences;

import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
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
		DirectoryFieldEditor zipPathEditor=new DirectoryFieldEditor(FoxBpmnPreferenceConstants.P_ZIP_PATH, "本地工作空间：", parent);
//		FileFieldEditor connectorPathEditor=new FileFieldEditor(FoxBpmnPreferenceConstants.P_CONNECTOR_PATH, "连接器Menu路径：", parent);
		
		StringFieldEditor usernameEditor=new StringFieldEditor(FoxBpmnPreferenceConstants.P_USERNAME, "用户名：", parent);
		StringFieldEditor passwordEditor=new StringFieldEditor(FoxBpmnPreferenceConstants.P_PASSWORD, "密码：", parent);
		
		//屏蔽用户名和密码
		usernameEditor.getLabelControl(parent).setVisible(false);
		usernameEditor.getTextControl(parent).setVisible(false);
		passwordEditor.getLabelControl(parent).setVisible(false);
		passwordEditor.getTextControl(parent).setVisible(false);
		
		addField(serverAddressEditor);
		addField(usernameEditor);
		addField(passwordEditor);
		addField(zipPathEditor);
//		addField(connectorPathEditor);
	}

	@Override
	protected IPreferenceStore doGetPreferenceStore() {
		return super.doGetPreferenceStore();
	}

	@Override
	public boolean performOk() {
		super.performOk();
		return true;
	}

}
