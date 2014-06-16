package org.foxbpm.bpmn.designer.ui.propertytab.connector;

import org.eclipse.bpmn2.CallActivity;
import org.eclipse.bpmn2.ManualTask;
import org.eclipse.bpmn2.Participant;
import org.eclipse.bpmn2.SubProcess;
import org.eclipse.bpmn2.Task;
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

public class ConnectorPropertySection extends AbstractFoxBPMPropertySection {

	public ConnectorPropertySection() {
		
	}

	@Override
	protected AbstractFoxBPMComposite createSectionRoot() {
		return new ConnectorPropertyComposite(parent, SWT.NONE);
	}

	@Override
	protected EObject getBusinessObjectForSelection(ISelection selection) {
		EObject be = BusinessObjectUtil.getBusinessObjectForSelection(selection);
		if (be instanceof BPMNDiagram) {
			return BpmnModelUtil.getProcessByEobj(be);
		} else {
			return be;
		}
	}

	@Override
	public boolean appliesTo(IWorkbenchPart part, ISelection selection) {
		EObject eObject = BusinessObjectUtil.getBusinessObjectForSelection(selection);

		Bpmn2DiagramType bpmn2DiagramType = BpmnModelUtil.getDiagramType(eObject);
		if (bpmn2DiagramType == Bpmn2DiagramType.COLLABORATION) {
			boolean enabled = ((eObject instanceof Participant || eObject instanceof Task || eObject instanceof SubProcess || eObject instanceof CallActivity) && (!(eObject instanceof ManualTask)));
			return enabled;
		} else {
			boolean enabled = ((eObject instanceof BPMNDiagram || eObject instanceof Task || eObject instanceof SubProcess || eObject instanceof CallActivity) && (!(eObject instanceof ManualTask)));
			return enabled;
		}
	}

}
