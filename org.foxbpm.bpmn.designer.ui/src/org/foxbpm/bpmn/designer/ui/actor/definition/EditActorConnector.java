package org.foxbpm.bpmn.designer.ui.actor.definition;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.foxbpm.bpmn.designer.ui.connector.runtime.OverrideNewWizard;

public class EditActorConnector implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;
	
	public EditActorConnector() {
		
	}

	@Override
	public void run(IAction action) {
		OverrideNewWizard dialog = new OverrideNewWizard(Display.getDefault().getActiveShell(), 
				new EditActorConnectorWizard());
		dialog.setPageSize(-1, 400); // -1代表宽度自适应, 240为高度
		dialog.open();
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
