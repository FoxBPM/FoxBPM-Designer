package org.foxbpm.bpmn.designer.ui.wizard;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

public class FoxFlowNewWizard extends Wizard implements INewWizard {
	private ISelection selection;
	
	public FoxFlowNewWizard() {
		setNeedsProgressMonitor(true);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}

	@Override
	public boolean performFinish() {
		return false;
	}

}
