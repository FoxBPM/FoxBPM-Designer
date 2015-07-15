package org.foxbpm.bpmn.designer.ui.custom.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.wb.swt.ResourceManager;

public abstract class ViewerDeleteAction extends Action {

	public ViewerDeleteAction() {
		setToolTipText("删除");
		setImageDescriptor(ResourceManager.getPluginImageDescriptor("org.eclipse.ui", "/icons/full/obj16/delete_obj.gif"));
	}
	
	@Override
	public abstract void run();

}
