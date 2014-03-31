package org.foxbpm.bpmn.designer.ui.propertytab;

import org.eclipse.bpmn2.StartEvent;
import org.eclipse.bpmn2.modeler.core.utils.BusinessObjectUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchPart;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFixFlowComposite;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFixFlowPropertySection;

public class TestFixFlowPropertySection extends AbstractFixFlowPropertySection {

	@Override
	public boolean appliesTo(IWorkbenchPart part, ISelection selection) {
		EObject eObject = BusinessObjectUtil.getBusinessObjectForSelection(selection);
		boolean enabled = eObject instanceof StartEvent;
		return enabled;
	}

	public TestFixFlowPropertySection() {
		
	}

	@Override
	protected AbstractFixFlowComposite createSectionRoot() {
		return new TestComposite(parent, SWT.NONE);
	}

	@Override
	protected EObject getBusinessObjectForSelection(ISelection selection) {
		EObject be = BusinessObjectUtil.getBusinessObjectForSelection(selection);
		return be;
	}

}
