package org.foxbpm.bpmn.designer.ui.propertytab.usertask;

import org.eclipse.bpmn2.UserTask;
import org.eclipse.bpmn2.modeler.core.utils.BusinessObjectUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchPart;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMComposite;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMPropertySection;

public class UserTaskTaskCommandPropertySection extends AbstractFoxBPMPropertySection {

	public UserTaskTaskCommandPropertySection() {
	}

	@Override
	protected AbstractFoxBPMComposite createSectionRoot() {
		return new UserTaskTaskCommandComposite(parent, SWT.NONE);
	}

	@Override
	protected EObject getBusinessObjectForSelection(ISelection selection) {
		return BusinessObjectUtil.getBusinessObjectForSelection(selection);
	}

	/* (non-Javadoc)
	 * @see org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMPropertySection#appliesTo(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public boolean appliesTo(IWorkbenchPart part, ISelection selection) {
		EObject be=BusinessObjectUtil.getBusinessObjectForSelection(selection);
		return be instanceof UserTask;
	}
}
