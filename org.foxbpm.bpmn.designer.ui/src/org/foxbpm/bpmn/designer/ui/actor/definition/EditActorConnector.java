package org.foxbpm.bpmn.designer.ui.actor.definition;

import java.io.File;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.foxbpm.bpmn.designer.ui.connector.runtime.OverrideNewWizard;
import org.foxbpm.bpmn.designer.ui.utils.ConnectorUtil;

public class EditActorConnector implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;
	
	public EditActorConnector() {
		
	}

	@Override
	public void run(IAction action) {
		String connectPathString = ConnectorUtil.getDefinitionConnectorPath();
		File file = new File(connectPathString);
		if(!file.exists()){
			MessageDialog.openWarning(window.getShell(), "提示", "找不到处理者选择器存放路径，请设置");
			return;
		}else{
			OverrideNewWizard dialog = new OverrideNewWizard(Display.getDefault().getActiveShell(), 
					new EditActorConnectorWizard());
			dialog.setPageSize(-1, 400); // -1代表宽度自适应, 240为高度
			dialog.open();
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
