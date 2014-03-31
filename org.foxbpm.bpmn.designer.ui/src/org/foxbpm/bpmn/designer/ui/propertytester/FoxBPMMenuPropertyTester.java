package org.foxbpm.bpmn.designer.ui.propertytester;

import org.eclipse.bpmn2.modeler.core.runtime.TargetRuntime;
import org.eclipse.core.expressions.PropertyTester;

public class FoxBPMMenuPropertyTester extends PropertyTester {
	private static final String TARGET_RUNTIME_ID = "org.eclipse.bpmn2.modeler.runtime.none";
	
	public FoxBPMMenuPropertyTester() {
		
	}

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		TargetRuntime.getAllRuntimes();
		if (TARGET_RUNTIME_ID.equals(TargetRuntime.getCurrentRuntime().getId()))
			return true;
		return false;
	}

}
