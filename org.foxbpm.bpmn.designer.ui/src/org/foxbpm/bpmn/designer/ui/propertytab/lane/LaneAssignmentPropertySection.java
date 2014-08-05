package org.foxbpm.bpmn.designer.ui.propertytab.lane;

import org.eclipse.bpmn2.Lane;
import org.eclipse.bpmn2.modeler.core.utils.BusinessObjectUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchPart;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMComposite;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMPropertySection;

public class LaneAssignmentPropertySection extends AbstractFoxBPMPropertySection {

	public LaneAssignmentPropertySection() {
	}

	@Override
	protected AbstractFoxBPMComposite createSectionRoot() {
		return new LaneAssignmentPropertyComposite(parent, SWT.NONE);
	}

	@Override
	protected EObject getBusinessObjectForSelection(ISelection selection) {
		EObject be = BusinessObjectUtil.getBusinessObjectForSelection(selection);
		return be;
	}

	@Override
	public boolean appliesTo(IWorkbenchPart part, ISelection selection) {
		EObject be = BusinessObjectUtil.getBusinessObjectForSelection(selection);
		boolean enable = be instanceof Lane;
		return enable;
	}

}