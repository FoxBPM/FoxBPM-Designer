package org.foxbpm.bpmn.designer.ui.propertytab.task;

import org.eclipse.bpmn2.BusinessRuleTask;
import org.eclipse.bpmn2.ChoreographyTask;
import org.eclipse.bpmn2.ManualTask;
import org.eclipse.bpmn2.ReceiveTask;
import org.eclipse.bpmn2.ScriptTask;
import org.eclipse.bpmn2.SendTask;
import org.eclipse.bpmn2.ServiceTask;
import org.eclipse.bpmn2.Task;
import org.eclipse.bpmn2.UserTask;
import org.eclipse.bpmn2.modeler.core.utils.BusinessObjectUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchPart;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMComposite;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMPropertySection;

public class TaskCommonPropertySection extends AbstractFoxBPMPropertySection {

	public TaskCommonPropertySection() {
	}

	@Override
	protected AbstractFoxBPMComposite createSectionRoot() {
		return new TaskCommonPropertyComposite(parent, SWT.NONE);
	}

	@Override
	protected EObject getBusinessObjectForSelection(ISelection selection) {
		EObject be = BusinessObjectUtil.getBusinessObjectForSelection(selection);
		return be;
	}

	@Override
	public boolean appliesTo(IWorkbenchPart part, ISelection selection) {
		EObject eObject = BusinessObjectUtil.getBusinessObjectForSelection(selection);
		boolean enabled = ((eObject instanceof Task) && !(eObject instanceof UserTask) && !(eObject instanceof ScriptTask) && !(eObject instanceof ServiceTask) && !(eObject instanceof SendTask)
				&& !(eObject instanceof ReceiveTask) && !(eObject instanceof ManualTask) && !(eObject instanceof BusinessRuleTask) && !(eObject instanceof ChoreographyTask));
		return enabled;
	}

}
