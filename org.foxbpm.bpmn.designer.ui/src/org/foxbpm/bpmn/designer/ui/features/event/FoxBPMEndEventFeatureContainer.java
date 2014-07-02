package org.foxbpm.bpmn.designer.ui.features.event;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.EndEvent;
import org.eclipse.bpmn2.UserTask;
import org.eclipse.bpmn2.modeler.core.features.MultiUpdateFeature;
import org.eclipse.bpmn2.modeler.core.features.event.AbstractCreateEventFeature;
import org.eclipse.bpmn2.modeler.core.features.event.AbstractUpdateEventFeature;
import org.eclipse.bpmn2.modeler.core.features.event.AddEventFeature;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.ui.ImageProvider;
import org.eclipse.bpmn2.modeler.ui.editor.BPMN2Editor;
import org.eclipse.bpmn2.modeler.ui.features.AbstractAppendNodeFeature;
import org.eclipse.bpmn2.modeler.ui.features.event.EndEventFeatureContainer;
import org.eclipse.bpmn2.modeler.ui.features.event.Messages;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IPeService;
import org.foxbpm.bpmn.designer.base.utils.EMFUtil;
import org.foxbpm.bpmn.designer.base.utils.FlowModelUtils;

public class FoxBPMEndEventFeatureContainer extends EndEventFeatureContainer {
	
	@Override
	public ICreateFeature getCreateFeature(IFeatureProvider fp) {
		return new CreateEndEventFeature(fp);
	}

	@Override
	public IAddFeature getAddFeature(IFeatureProvider fp) {
		return new AddEndEventFeature(fp);
	}

	@Override
	public IUpdateFeature getUpdateFeature(IFeatureProvider fp) {
		MultiUpdateFeature updateFeature = new MultiUpdateFeature(fp);
		updateFeature.addUpdateFeature(super.getUpdateFeature(fp));
		updateFeature.addUpdateFeature(new UpdateEndEventFeature(fp));
		return updateFeature;
	}
	
	public class AddEndEventFeature extends AddEventFeature<EndEvent> {
		public AddEndEventFeature(IFeatureProvider fp) {
			super(fp);
		}

		@Override
		protected void decorateShape(IAddContext context, ContainerShape containerShape, EndEvent businessObject) {
			Ellipse e = (Ellipse)getGraphicsAlgorithm(containerShape);
			e.setLineWidth(3);
			IPeService peService = Graphiti.getPeService();
			peService.setPropertyValue(containerShape,
					UpdateEndEventFeature.END_EVENT_MARKER,
					AbstractUpdateEventFeature.getEventDefinitionsValue((EndEvent)businessObject));
		}
	}

	public static class CreateEndEventFeature extends AbstractCreateEventFeature<EndEvent> {

		public CreateEndEventFeature(IFeatureProvider fp) {
			super(fp, "结束事件", "创建一个结束事件");
		}

		@Override
		public String getStencilImageId() {
			return ImageProvider.IMG_16_END_EVENT;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.bpmn2.modeler.core.features.AbstractCreateFlowElementFeature#getFlowElementClass()
		 */
		@Override
		public EClass getBusinessObjectClass() {
			return Bpmn2Package.eINSTANCE.getEndEvent();
		}

		@Override
		public EndEvent createBusinessObject(ICreateContext context) {
			List<EndEvent> endEvents = EMFUtil.getAll(((Resource)FlowModelUtils.MAP.get("end_event")), EndEvent.class);
			if(endEvents != null && endEvents.size()>0) {
				EndEvent endEvent = EcoreUtil.copy(endEvents.get(0));
				endEvent.setId(null);
				Resource resource = ((BPMN2Editor)getDiagramEditor()).getResource();
				ModelUtil.setID(endEvent, resource);
				return endEvent;
			}
			return super.createBusinessObject(context);
		}
	}

	protected static class UpdateEndEventFeature extends AbstractUpdateEventFeature {

		public static String END_EVENT_MARKER = "marker.end.event"; //$NON-NLS-1$

		/**
		 * @param fp
		 */
		public UpdateEndEventFeature(IFeatureProvider fp) {
			super(fp);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.bpmn2.modeler.core.features.activity.AbstractUpdateMarkerFeature#getPropertyKey()
		 */
		@Override
		protected String getPropertyKey() {
			return END_EVENT_MARKER;
		}
	}

	@Override
	public ICustomFeature[] getCustomFeatures(IFeatureProvider fp) {
		ICustomFeature[] superFeatures = super.getCustomFeatures(fp);
		List<ICustomFeature> thisFeatures = new ArrayList<ICustomFeature>();
		int i;
		for (ICustomFeature f : superFeatures) {
			if (!(f instanceof AbstractAppendNodeFeature))
			thisFeatures.add(f);
		}
		return thisFeatures.toArray( new ICustomFeature[thisFeatures.size()] );
	}
}
