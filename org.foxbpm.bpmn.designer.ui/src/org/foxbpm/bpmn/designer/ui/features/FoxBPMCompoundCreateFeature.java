package org.foxbpm.bpmn.designer.ui.features;

import org.eclipse.bpmn2.modeler.core.features.CompoundCreateFeature;
import org.eclipse.bpmn2.modeler.core.runtime.CustomTaskImageProvider;
import org.eclipse.bpmn2.modeler.core.runtime.CustomTaskImageProvider.IconSize;
import org.eclipse.bpmn2.modeler.core.runtime.TargetRuntime;
import org.eclipse.bpmn2.modeler.core.runtime.ToolPaletteDescriptor.ToolDescriptor;
import org.eclipse.graphiti.features.IFeatureProvider;

public class FoxBPMCompoundCreateFeature extends CompoundCreateFeature {

	public FoxBPMCompoundCreateFeature(IFeatureProvider fp, ToolDescriptor tool) {
		super(fp, tool);
	}

	public FoxBPMCompoundCreateFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public String getCreateImageId() {
		if(tool == null) {
			return null;
		}
		return tool.getIcon();
	}

	@Override
	public String getCreateLargeImageId() {
		if(tool == null) {
			return null;
		}
		return tool.getIcon();
	}
}
