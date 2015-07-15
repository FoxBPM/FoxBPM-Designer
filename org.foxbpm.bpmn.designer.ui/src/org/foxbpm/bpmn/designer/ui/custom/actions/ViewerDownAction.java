package org.foxbpm.bpmn.designer.ui.custom.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.wb.swt.ResourceManager;

public abstract class ViewerDownAction extends Action {

	public ViewerDownAction() {
		setText("向下");
		setToolTipText("向下");
		setImageDescriptor(ResourceManager.getPluginImageDescriptor("org.eclipse.team.ui", "/icons/full/elcl16/next_nav.gif"));
	}
	
	@Override
	public abstract void run();

}
