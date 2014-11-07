package org.foxbpm.bpmn.designer.ui.commands;

import java.io.File;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.jdt.internal.core.PackageFragment;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;
import org.foxbpm.bpmn.designer.ui.actor.definition.EditActorConnectorWizard;
import org.foxbpm.bpmn.designer.ui.connector.definition.modify.EditConnectorWizard;
import org.foxbpm.bpmn.designer.ui.connector.runtime.OverrideNewWizard;

public class EditConnectorHandler implements IHandler {

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {

	}

	@Override
	public void dispose() {

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection iSelection = (IStructuredSelection) HandlerUtil.getCurrentSelection(event);
		if(iSelection.getFirstElement() instanceof PackageFragment) {
			boolean isConnector = false;
			boolean isActorConnector = false;
			PackageFragment packageFragment = (PackageFragment) iSelection.getFirstElement();
			for (File file : packageFragment.getResource().getLocation().toFile().listFiles()) {
				if(file.getName().equals("FlowConnector.xml")) {
					isConnector = true; 
				}
				if(file.getName().equals("ActorConnector.xml")) {
					isActorConnector = true; 
				}
			}
			if(isConnector) {
				OverrideNewWizard dialog = new OverrideNewWizard(Display.getDefault().getActiveShell(), new EditConnectorWizard(packageFragment));
				dialog.setPageSize(-1, 400); // -1代表宽度自适应, 240为高度
				dialog.open();
			}
			else if(isActorConnector) {
				OverrideNewWizard dialog = new OverrideNewWizard(Display.getDefault().getActiveShell(), new EditActorConnectorWizard(packageFragment));
				dialog.setPageSize(-1, 400); // -1代表宽度自适应, 240为高度
				dialog.open();
			} else {
				MessageDialog.openInformation(null, "提示", "该目录不符合连接器或选择器结构");
			}
			
		}else {
			MessageDialog.openInformation(null, "提示", "该目录下没有连接器或选择器");
		}
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
