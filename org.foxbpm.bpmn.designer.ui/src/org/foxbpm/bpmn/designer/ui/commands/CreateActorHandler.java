package org.foxbpm.bpmn.designer.ui.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.swt.widgets.Display;
import org.foxbpm.bpmn.designer.ui.actor.definition.ActorConnectorWizardCreationWizard;
import org.foxbpm.bpmn.designer.ui.actor.definition.CreateActorConnectorWizardDialog;

public class CreateActorHandler implements IHandler {

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {

	}

	@Override
	public void dispose() {

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ActorConnectorWizardCreationWizard cwcp = new ActorConnectorWizardCreationWizard();
		CreateActorConnectorWizardDialog cfwd = new CreateActorConnectorWizardDialog(Display.getDefault().getActiveShell(), cwcp);
		cfwd.open();
		return null;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isHandled() {
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {

	}

}
