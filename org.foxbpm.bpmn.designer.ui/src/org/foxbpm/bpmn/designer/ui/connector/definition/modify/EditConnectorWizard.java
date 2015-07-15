package org.foxbpm.bpmn.designer.ui.connector.definition.modify;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.internal.core.PackageFragment;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.foxbpm.bpmn.designer.base.utils.EMFUtil;
import org.foxbpm.bpmn.designer.ui.connector.definition.ConnectorWizardCreationWizard;
import org.foxbpm.bpmn.designer.ui.connector.runtime.DynamicPageWizard;
import org.foxbpm.bpmn.designer.ui.utils.DefinitionConnectorUtil;
import org.foxbpm.model.config.connector.ConnectorDefinition;

public class EditConnectorWizard extends DynamicPageWizard {
//	private SelectNewConnectorWizardPage selectNewConnectorWizardPage;
	private ChooseConnectorFileToEditWizardPage chooseConnectorFileToEditWizardPage;
	private ChooseFlowConnectorFileToEditWizardPage chooseFlowConnectorFileToEditWizardPage;
	private String connectorPath;
	private String connectorMenuPath;
	private ConnectorDefinition connectorDefinition;
	private PackageFragment packageFragment;
	
	public EditConnectorWizard() {
	}

	public EditConnectorWizard(PackageFragment packageFragment) {
		this.packageFragment = packageFragment;
		this.connectorPath = packageFragment.getResource().getLocation().toFile().getAbsolutePath();
		this.connectorMenuPath = DefinitionConnectorUtil.getConnectorMenuPath(packageFragment.getResource().getProject().getName().equals("foxbpm-connector"));
		//加载目录下的连接器xml文件
		Resource resource = EMFUtil.readEMFFile(connectorPath + "/FlowConnector.xml");
		this.connectorDefinition = (ConnectorDefinition) resource.getContents().get(0);
	}
	
	@Override
	public boolean performFinish() {
		if (chooseFlowConnectorFileToEditWizardPage.getWizardRadioButton().getSelection()) {
			ConnectorWizardCreationWizard cwcp = new ConnectorWizardCreationWizard(connectorDefinition, packageFragment);
			CreateFixConnectorWizardDialog cfwd = new CreateFixConnectorWizardDialog(new Shell(SWT.PRIMARY_MODAL), cwcp);
			cfwd.open();
			return true;
		}
		if (chooseFlowConnectorFileToEditWizardPage.getFileRadioButton().getSelection()) {
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();


			Object[] files = chooseFlowConnectorFileToEditWizardPage.getCheckboxTreeViewer().getCheckedElements();

			for (Object object : files) {
				try {
//					File file = new File(ConnectorUtil.getFlowConnectorPathById(selectNewConnectorWizardPage.getConnector().getId()) + "/" + object.toString());
//					String relativePath = file.toString().substring(project.getLocation().toString().length() + 1);
//					IFile ifile = project.getFile(relativePath);
//					// 打开编辑器
//					ProjectUtil.refreshProject(ConnectorUtil.getOldConnectorProjectName());
					
					IFileStore fileStore = EFS.getLocalFileSystem().getStore(new Path(connectorPath + "/" + object.toString()));
//					IEditorInput input = null;
//					if (!fileStore.fetchInfo().isDirectory() && fileStore.fetchInfo().exists()) {
//						input = new FileStoreEditorInput(fileStore);
//					}
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
		// 根据新旧连接器加载不同页面
//		selectNewConnectorWizardPage = new SelectNewConnectorWizardPage(this);
//		addPage(selectNewConnectorWizardPage);
		chooseFlowConnectorFileToEditWizardPage = new ChooseFlowConnectorFileToEditWizardPage(connectorPath);
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
