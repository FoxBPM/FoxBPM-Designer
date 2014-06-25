package org.foxbpm.bpmn.designer.ui.actor.definition;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;


public class CreateActorConnector implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;

	public CreateActorConnector() {
	}
	
	@Override
	public void run(IAction action) {
		ActorConnectorWizardCreationWizard cwcp = new ActorConnectorWizardCreationWizard();
		CreateActorConnectorWizardDialog cfwd = new CreateActorConnectorWizardDialog(window == null ? null : 
			window.getShell(), cwcp);
		cfwd.open();
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
