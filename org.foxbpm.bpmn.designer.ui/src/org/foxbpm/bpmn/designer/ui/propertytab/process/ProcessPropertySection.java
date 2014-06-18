package org.foxbpm.bpmn.designer.ui.propertytab.process;

import org.eclipse.bpmn2.Participant;
import org.eclipse.bpmn2.di.BPMNDiagram;
import org.eclipse.bpmn2.modeler.core.utils.BusinessObjectUtil;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil.Bpmn2DiagramType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchPart;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMComposite;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMPropertySection;
import org.foxbpm.bpmn.designer.ui.utils.BpmnModelUtil;

public class ProcessPropertySection extends AbstractFoxBPMPropertySection {

	public ProcessPropertySection() {
	}

	@Override
	protected AbstractFoxBPMComposite createSectionRoot() {
		return new ProcessPropertyComposite(parent, SWT.NONE);
	}

	@Override
	protected EObject getBusinessObjectForSelection(ISelection selection) {
		EObject be = BusinessObjectUtil.getBusinessObjectForSelection(selection);
		return be;
	}

	@Override
	public boolean appliesTo(IWorkbenchPart part, ISelection selection) {
		EObject object = BusinessObjectUtil.getBusinessObjectForSelection(selection);
		Bpmn2DiagramType bpmn2DiagramType = BpmnModelUtil.getDiagramType(object);
		if (bpmn2DiagramType == Bpmn2DiagramType.COLLABORATION) {
			boolean enabled = object instanceof Participant;
			return enabled;
		} else {
			boolean enabled = object instanceof BPMNDiagram;
			return enabled;
		}
	}

}