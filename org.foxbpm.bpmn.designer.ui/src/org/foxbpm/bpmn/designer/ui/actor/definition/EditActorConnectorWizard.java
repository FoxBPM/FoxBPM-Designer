package org.foxbpm.bpmn.designer.ui.actor.definition;

import java.io.File;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.foxbpm.bpmn.designer.ui.connector.runtime.DynamicPageWizard;
import org.foxbpm.bpmn.designer.ui.utils.ConnectorUtil;
import org.foxbpm.bpmn.designer.ui.utils.ProjectUtil;

public class EditActorConnectorWizard extends DynamicPageWizard {
	private SelectActorConnectorWizardPage selectNewConnectorWizardPage;
//	private ChooseConnectorFileToEditWizardPage chooseConnectorFileToEditWizardPage;
	private ChooseActorConnectorFileToEditWizardPage chooseFlowConnectorFileToEditWizardPage;
	
	public EditActorConnectorWizard() {
	}
	
	@Override
	public boolean performFinish() {
			if (chooseFlowConnectorFileToEditWizardPage.getWizardRadioButton().getSelection()) {
				ActorConnectorWizardCreationWizard cwcp = new ActorConnectorWizardCreationWizard(selectNewConnectorWizardPage.getConnector());
				CreateActorConnectorWizardDialog cfwd = new CreateActorConnectorWizardDialog(new Shell(SWT.PRIMARY_MODAL), cwcp);
				cfwd.open();
				return true;
			}
			if (chooseFlowConnectorFileToEditWizardPage.getFileRadioButton().getSelection()) {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				Object[] files = chooseFlowConnectorFileToEditWizardPage.getCheckboxTreeViewer().getCheckedElements();

				for (Object object : files) {
					try {
						IFileStore fileStore = EFS.getLocalFileSystem().getStore(new Path(ConnectorUtil.getFlowConnectorPathById(selectNewConnectorWizardPage.getConnector().getId()) + "/" + object.toString()));
						IDE.openEditorOnFileStore(page, fileStore);
					} catch (PartInitException e) {
					}
				}

				return true;
			}
		return false;
	}

	@Override
	public void addPages() {
		//根据新旧连接器加载不同页面
			selectNewConnectorWizardPage = new SelectActorConnectorWizardPage(this);
			addPage(selectNewConnectorWizardPage);
			chooseFlowConnectorFileToEditWizardPage = new ChooseActorConnectorFileToEditWizardPage(null);
			addPage(chooseFlowConnectorFileToEditWizardPage);
		super.addPages();
	}

//	public ChooseConnectorFileToEditWizardPage getChooseConnectorFileToEditWizardPage() {
//		return chooseConnectorFileToEditWizardPage;
//	}
//
//	public void setChooseConnectorFileToEditWizardPage(ChooseConnectorFileToEditWizardPage chooseConnectorFileToEditWizardPage) {
//		this.chooseConnectorFileToEditWizardPage = chooseConnectorFileToEditWizardPage;
//	}
	
	//下面新加是为了适应新连接器
	public ChooseActorConnectorFileToEditWizardPage getchChooseFlowConnectorFileToEditWizardPage() {
		return chooseFlowConnectorFileToEditWizardPage;
	}
	
	public void setChooseFlowConnectorFileToEditWizardPage(ChooseActorConnectorFileToEditWizardPage chooseFlowConnectorFileToEditWizardPage) {
		this.chooseFlowConnectorFileToEditWizardPage = chooseFlowConnectorFileToEditWizardPage;
	}
}
