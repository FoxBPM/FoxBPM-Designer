package org.foxbpm.bpmn.designer.ui.propertytab.timerdefinition;

import org.eclipse.bpmn2.BoundaryEvent;
import org.eclipse.bpmn2.EventDefinition;
import org.eclipse.bpmn2.IntermediateCatchEvent;
import org.eclipse.bpmn2.StartEvent;
import org.eclipse.bpmn2.TimerEventDefinition;
import org.eclipse.bpmn2.modeler.core.utils.BusinessObjectUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchPart;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMComposite;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMPropertySection;

public class TimerEventDefinitionPropertySection extends AbstractFoxBPMPropertySection {

	public TimerEventDefinitionPropertySection() {
	}

	@Override
	protected AbstractFoxBPMComposite createSectionRoot() {
		return new TimerEventDefinitionPropertyComposite(parent, SWT.NONE);
	}

	@Override
	protected EObject getBusinessObjectForSelection(ISelection selection) {
		EObject be = BusinessObjectUtil.getBusinessObjectForSelection(selection);
		return be;
	}

	@Override
	public boolean appliesTo(IWorkbenchPart part, ISelection selection) {
		EObject eObject = BusinessObjectUtil.getBusinessObjectForSelection(selection);

		if (eObject instanceof StartEvent) {
			StartEvent startEvent = (StartEvent) eObject;
			if (startEvent.getEventDefinitions().size() > 0) {

				for (EventDefinition eventDefinition : startEvent.getEventDefinitions()) {
					if (eventDefinition instanceof TimerEventDefinition) {
						return true;
					}
				}

			}
		}
		
		if (eObject instanceof BoundaryEvent) {
			BoundaryEvent boundaryEvent = (BoundaryEvent) eObject;
			if (boundaryEvent.getEventDefinitions().size() > 0) {

				for (EventDefinition eventDefinition : boundaryEvent.getEventDefinitions()) {
					if (eventDefinition instanceof TimerEventDefinition) {
						return true;
					}
				}

			}
		}
		
		if (eObject instanceof IntermediateCatchEvent) {
			IntermediateCatchEvent intermediateCatchEvent = (IntermediateCatchEvent) eObject;
			if (intermediateCatchEvent.getEventDefinitions().size() > 0) {

				for (EventDefinition eventDefinition : intermediateCatchEvent.getEventDefinitions()) {
					if (eventDefinition instanceof TimerEventDefinition) {
						return true;
					}
				}

			}
		}

		return false;
	}

}
