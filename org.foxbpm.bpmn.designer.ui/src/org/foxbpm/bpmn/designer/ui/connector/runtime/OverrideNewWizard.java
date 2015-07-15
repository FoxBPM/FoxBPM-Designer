package org.foxbpm.bpmn.designer.ui.connector.runtime;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.foxbpm.bpmn.designer.ui.actor.runtime.create.AddNewActorConnectorWizard;
import org.foxbpm.bpmn.designer.ui.connector.runtime.create.AddNewConnectorWizard;
import org.foxbpm.model.bpmn.foxbpm.ConnectorInstance;

public class OverrideNewWizard extends WizardDialog {

	private Wizard wizard;
	private Button buttonSave;
	private Button buttonLoad;

	/**
	 * 构造器
	 */
	public OverrideNewWizard(Shell parentShell, IWizard newWizard) {
		super(parentShell, newWizard);
		setHelpAvailable(false);
		this.wizard = (Wizard) newWizard;
	}

	/**
	 * 重写createContents用以改变按钮文字为中文
	 */
	@Override
	protected Control createContents(Composite parent) {
		Control c = super.createContents(parent);
		getButton(IDialogConstants.FINISH_ID).setText("完成"); // 完成按钮
		getButton(IDialogConstants.CANCEL_ID).setText("取消"); // 取消按钮
		try {
			getButton(IDialogConstants.BACK_ID).setText("上一步"); // 上一步
			getButton(IDialogConstants.BACK_ID).setEnabled(false);
			getButton(IDialogConstants.NEXT_ID).setText("下一步"); // 下一步
		} catch (Exception e) {
		}
		return c;
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		buttonLoad = createButton(parent, 1, "加载模板", false);
		buttonSave = createButton(parent, 2, "保存模板", false);
		buttonLoad.setEnabled(false);
		buttonSave.setEnabled(false);

		buttonSave.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ConfigurationDialog dialog = new ConfigurationDialog(getShell(), "保存连接器配置", "可以将连接器配置保存起来以便多处调用");
				if (dialog.open() == Dialog.OK) {

				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		buttonLoad.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ConfigurationDialog dialog = new ConfigurationDialog(getShell(), "加载连接器配置", "可以选择一个连接器配置");
				if (dialog.open() == Dialog.OK) {

				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		super.createButtonsForButtonBar(parent);
	}

	@Override
	public void updateButtons() {
		// 只有在编辑连接器内容的时候才会显示保存和加载按钮
		if (getCurrentPage() == wizard.getPage("commonConnectotWizardPage") || getCurrentPage() == wizard.getPage("modifyCommonConnectotWizardPage")) {
			buttonSave.setVisible(true);
			buttonLoad.setVisible(true);
		} else {
			buttonSave.setVisible(false);
			buttonLoad.setVisible(false);
		}
		super.updateButtons();
	}

	/**
	 * 返回创建的连接器实例
	 * 
	 * @return
	 */
	public ConnectorInstance getAddedValue() {
		ConnectorInstance connectorInstance = ((AddNewConnectorWizard) wizard).getConnectorInstance();
		return connectorInstance;
	}

	/**
	 * 返回创建的连接器实例
	 * 
	 * @return
	 */
	public ConnectorInstance getActorAddedValue() {
		ConnectorInstance connectorInstance = ((AddNewActorConnectorWizard) wizard).getConnectorInstance();
		return connectorInstance;
	}

	/**
	 * 返回创建的连接器实例
	 * 
	 * @return
	 */
//	public ConnectorInstance getModifyedValue() {
//		ConnectorInstance connectorInstance = ((ModifyConnectorWizard) wizard).getConnectorInstance();
//		return connectorInstance;
//	}

}
