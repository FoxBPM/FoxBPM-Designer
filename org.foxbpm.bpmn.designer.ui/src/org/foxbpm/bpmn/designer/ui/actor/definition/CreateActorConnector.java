package org.foxbpm.bpmn.designer.ui.actor.definition;

import java.io.File;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.foxbpm.bpmn.designer.ui.utils.ConnectorUtil;


public class CreateActorConnector implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;

	public CreateActorConnector() {
	}
	
	@Override
	public void run(IAction action) {
		String connectPathString = ConnectorUtil.getConnectorPath();
		File file = new File(connectPathString);
		if(!file.exists()){
			MessageDialog.openWarning(window.getShell(), "提示", "找不到选择器存放路径，请设置");
			return;
		}else{
			ActorConnectorWizardCreationWizard cwcp = new ActorConnectorWizardCreationWizard();
			CreateActorConnectorWizardDialog cfwd = new CreateActorConnectorWizardDialog(window == null ? null : 
				window.getShell(), cwcp);
			cfwd.open();
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {

	}

	@Override
	public void dispose() {

	}

	@Override
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}

}
