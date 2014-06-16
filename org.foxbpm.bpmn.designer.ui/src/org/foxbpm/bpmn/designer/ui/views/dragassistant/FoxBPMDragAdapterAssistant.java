package org.foxbpm.bpmn.designer.ui.views.dragassistant;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.ui.navigator.CommonDragAdapterAssistant;

public class FoxBPMDragAdapterAssistant extends CommonDragAdapterAssistant {

	public FoxBPMDragAdapterAssistant() {
	}

	@Override
	public Transfer[] getSupportedTransferTypes() {
		return null;
	}

	@Override
	public boolean setDragData(DragSourceEvent anEvent, IStructuredSelection aSelection) {
		return false;
	}

}
