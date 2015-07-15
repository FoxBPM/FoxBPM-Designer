package org.foxbpm.bpmn.designer.ui.custom.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.wb.swt.ResourceManager;

public abstract class ViewerAddAction extends Action {

	public ViewerAddAction() {
		setToolTipText("添加...");
		setImageDescriptor(ResourceManager.getPluginImageDescriptor("org.eclipse.ui", "/icons/full/obj16/add_obj.gif"));
	}
	
	@Override
	public abstract void run();

}
