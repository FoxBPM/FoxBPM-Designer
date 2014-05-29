package org.foxbpm.bpmn.designer.ui.commands;

import java.io.File;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.foxbpm.bpmn.designer.ui.actor.definition.EditActorConnectorWizard;
import org.foxbpm.bpmn.designer.ui.connector.runtime.OverrideNewWizard;
import org.foxbpm.bpmn.designer.ui.utils.DefinitionConnectorUtil;

public class EditActorHandler implements IHandler {

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {

	}

	@Override
	public void dispose() {

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		String connectPathString = DefinitionConnectorUtil.getActorConnectorPath();
		File file = new File(connectPathString);
		if (!file.exists()) {
			MessageDialog.openWarning(Display.getDefault().getActiveShell(), "提示", "找不到处理者选择器存放路径，请设置");
			return null;
		} else {
			OverrideNewWizard dialog = new OverrideNewWizard(Display.getDefault().getActiveShell(), new EditActorConnectorWizard());
			dialog.setPageSize(-1, 400); // -1代表宽度自适应, 240为高度
			dialog.open();
			return null;
		}
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
