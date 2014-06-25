package org.foxbpm.bpmn.designer.ui.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.swt.widgets.Display;
import org.foxbpm.bpmn.designer.ui.actor.definition.EditActorConnectorWizard;
import org.foxbpm.bpmn.designer.ui.connector.runtime.OverrideNewWizard;

public class EditActorHandler implements IHandler {

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {

	}

	@Override
	public void dispose() {

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		OverrideNewWizard dialog = new OverrideNewWizard(Display.getDefault().getActiveShell(), new EditActorConnectorWizard());
		dialog.setPageSize(-1, 400); // -1代表宽度自适应, 240为高度
		dialog.open();
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
