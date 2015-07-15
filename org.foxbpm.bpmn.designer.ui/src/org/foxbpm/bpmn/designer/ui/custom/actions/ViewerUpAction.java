package org.foxbpm.bpmn.designer.ui.custom.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.wb.swt.ResourceManager;

public abstract class ViewerUpAction extends Action {

	public ViewerUpAction() {
		setText("向上");
		setToolTipText("向上");
		setImageDescriptor(ResourceManager.getPluginImageDescriptor("org.eclipse.team.ui", "/icons/full/elcl16/prev_nav.gif"));
	}
	
	@Override
	public abstract void run();

}
