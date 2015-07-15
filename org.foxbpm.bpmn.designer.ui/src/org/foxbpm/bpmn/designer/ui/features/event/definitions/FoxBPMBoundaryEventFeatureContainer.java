package org.foxbpm.bpmn.designer.ui.features.event.definitions;

import org.eclipse.bpmn2.modeler.ui.features.AbstractDefaultDeleteFeature;
import org.eclipse.bpmn2.modeler.ui.features.event.AddBoundaryEventFeature;
import org.eclipse.bpmn2.modeler.ui.features.event.BoundaryEventFeatureContainer;
import org.eclipse.bpmn2.modeler.ui.features.event.LayoutBoundaryEventFeature;
import org.eclipse.bpmn2.modeler.ui.features.event.MoveBoundaryEventFeature;
import org.eclipse.bpmn2.modeler.ui.features.event.UpdateBoundaryEventFeature;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature;

public class FoxBPMBoundaryEventFeatureContainer extends BoundaryEventFeatureContainer {
	public static String BOUNDARY_EVENT_CANCEL = "cancel.activity"; //$NON-NLS-1$
	public static String BOUNDARY_EVENT_DISTANCE = "boundary.distance"; //$NON-NLS-1$
	
	@Override
	public ICreateFeature getCreateFeature(IFeatureProvider fp) {
		return new FoxBPMCreateBoundaryEventFeature(fp);
	}

	@Override
	public IAddFeature getAddFeature(IFeatureProvider fp) {
		return new AddBoundaryEventFeature(fp);
	}

	@Override
	public IUpdateFeature getUpdateFeature(IFeatureProvider fp) {
		return new UpdateBoundaryEventFeature(fp);
	}

	@Override
	public ILayoutFeature getLayoutFeature(IFeatureProvider fp) {
		return new LayoutBoundaryEventFeature(fp);
	}

	@Override
	public IMoveShapeFeature getMoveFeature(IFeatureProvider fp) {
		return new MoveBoundaryEventFeature(fp);
	}

	@Override
	public IResizeShapeFeature getResizeFeature(IFeatureProvider fp) {
		return new DefaultResizeShapeFeature(fp) {
			@Override
			public boolean canResizeShape(IResizeShapeContext context) {
				return false;
			}
		};
	}

	@Override
	public IDeleteFeature getDeleteFeature(IFeatureProvider fp) {
		return new AbstractDefaultDeleteFeature(fp);
	}
}
