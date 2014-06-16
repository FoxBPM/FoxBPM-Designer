package org.foxbpm.bpmn.designer.ui.commands;

import java.io.File;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.foxbpm.bpmn.designer.ui.connector.definition.ConnectorWizardCreationWizard;
import org.foxbpm.bpmn.designer.ui.connector.definition.CreateConnectorWizardDialog;
import org.foxbpm.bpmn.designer.ui.utils.DefinitionConnectorUtil;

public class CreateConnectorHandler implements IHandler {

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {

	}

	@Override
	public void dispose() {

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		String connectPathString = DefinitionConnectorUtil.getFlowConnectorPath();
		File file = new File(connectPathString);
		if(!file.exists()){
			MessageDialog.openWarning(Display.getDefault().getActiveShell(), "提示", "找不到连接器存放路径，请设置");
			return null;
		}else{
			ConnectorWizardCreationWizard cwcp = new ConnectorWizardCreationWizard();
			CreateConnectorWizardDialog cfwd = new CreateConnectorWizardDialog(Display.getDefault().getActiveShell(), cwcp);
			cfwd.open();
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
