package org.foxbpm.bpmn.designer.ui.connector.definition.modify;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.foxbpm.bpmn.designer.ui.connector.definition.ConnectorWizardCreationWizard;
import org.foxbpm.bpmn.designer.ui.connector.runtime.DynamicPageWizard;
import org.foxbpm.bpmn.designer.ui.utils.ConnectorUtil;
import org.foxbpm.bpmn.designer.ui.utils.ProjectUtil;

public class EditConnectorWizard extends DynamicPageWizard {
	private SelectNewConnectorWizardPage selectNewConnectorWizardPage;
	private ChooseConnectorFileToEditWizardPage chooseConnectorFileToEditWizardPage;
	private ChooseFlowConnectorFileToEditWizardPage chooseFlowConnectorFileToEditWizardPage;

	public EditConnectorWizard() {
	}

	@Override
	public boolean performFinish() {
		if (chooseFlowConnectorFileToEditWizardPage.getWizardRadioButton().getSelection()) {
			ConnectorWizardCreationWizard cwcp = new ConnectorWizardCreationWizard(selectNewConnectorWizardPage.getConnector());
			CreateFixConnectorWizardDialog cfwd = new CreateFixConnectorWizardDialog(new Shell(SWT.PRIMARY_MODAL), cwcp);
			cfwd.open();
			return true;
		}
		if (chooseFlowConnectorFileToEditWizardPage.getFileRadioButton().getSelection()) {
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(ConnectorUtil.getOldConnectorProjectName());

			Object[] files = chooseFlowConnectorFileToEditWizardPage.getCheckboxTreeViewer().getCheckedElements();

			for (Object object : files) {
				try {
					File file = new File(ConnectorUtil.getFlowConnectorPathById(selectNewConnectorWizardPage.getConnector().getId()) + "/" + object.toString());
					String relativePath = file.toString().substring(project.getLocation().toString().length() + 1);
					IFile ifile = project.getFile(relativePath);
					// 打开编辑器
					ProjectUtil.refreshProject(ConnectorUtil.getOldConnectorProjectName());
					IDE.openEditor(page, ifile);
				} catch (PartInitException e) {
				}
			}

			return true;
		}
		return false;
	}

	@Override
	public void addPages() {
		// 根据新旧连接器加载不同页面
		selectNewConnectorWizardPage = new SelectNewConnectorWizardPage(this);
		addPage(selectNewConnectorWizardPage);
		chooseFlowConnectorFileToEditWizardPage = new ChooseFlowConnectorFileToEditWizardPage(null);
		addPage(chooseFlowConnectorFileToEditWizardPage);
		super.addPages();
	}

	public ChooseConnectorFileToEditWizardPage getChooseConnectorFileToEditWizardPage() {
		return chooseConnectorFileToEditWizardPage;
	}

	public void setChooseConnectorFileToEditWizardPage(ChooseConnectorFileToEditWizardPage chooseConnectorFileToEditWizardPage) {
		this.chooseConnectorFileToEditWizardPage = chooseConnectorFileToEditWizardPage;
	}

	// 下面新加是为了适应新连接器
	public ChooseFlowConnectorFileToEditWizardPage getchChooseFlowConnectorFileToEditWizardPage() {
		return chooseFlowConnectorFileToEditWizardPage;
	}

	public void setChooseFlowConnectorFileToEditWizardPage(ChooseFlowConnectorFileToEditWizardPage chooseFlowConnectorFileToEditWizardPage) {
		this.chooseFlowConnectorFileToEditWizardPage = chooseFlowConnectorFileToEditWizardPage;
	}
}
