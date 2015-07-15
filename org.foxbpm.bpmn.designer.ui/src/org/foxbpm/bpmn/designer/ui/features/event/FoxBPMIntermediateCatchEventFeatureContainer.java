package org.foxbpm.bpmn.designer.ui.features.event;

import java.util.List;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.IntermediateCatchEvent;
import org.eclipse.bpmn2.modeler.core.features.MultiUpdateFeature;
import org.eclipse.bpmn2.modeler.core.features.event.AbstractCreateEventFeature;
import org.eclipse.bpmn2.modeler.core.features.event.AbstractUpdateEventFeature;
import org.eclipse.bpmn2.modeler.core.features.event.AddEventFeature;
import org.eclipse.bpmn2.modeler.core.utils.GraphicsUtil;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.core.utils.StyleUtil;
import org.eclipse.bpmn2.modeler.ui.ImageProvider;
import org.eclipse.bpmn2.modeler.ui.editor.BPMN2Editor;
import org.eclipse.bpmn2.modeler.ui.features.event.IntermediateCatchEventFeatureContainer;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IPeService;
import org.foxbpm.bpmn.designer.base.utils.EMFUtil;

public class FoxBPMIntermediateCatchEventFeatureContainer extends IntermediateCatchEventFeatureContainer {
	
	@Override
	public ICreateFeature getCreateFeature(IFeatureProvider fp) {
		return new CreateIntermediateCatchEventFeature(fp);
	}

	@Override
	public IUpdateFeature getUpdateFeature(IFeatureProvider fp) {
		MultiUpdateFeature multiUpdate = new MultiUpdateFeature(fp);
		multiUpdate.addUpdateFeature(super.getUpdateFeature(fp));
		multiUpdate.addUpdateFeature(new UpdateIntermediateCatchEventFeature(fp));
		return multiUpdate;
	}
	
	@Override
	public IAddFeature getAddFeature(IFeatureProvider fp) {
		return new AddIntermediateCatchEventFeature(fp);
	}

	public class AddIntermediateCatchEventFeature extends AddEventFeature<IntermediateCatchEvent> {
		public AddIntermediateCatchEventFeature(IFeatureProvider fp) {
			super(fp);
		}

		@Override
		protected void decorateShape(IAddContext context, ContainerShape containerShape, IntermediateCatchEvent businessObject) {
			Ellipse e = (Ellipse)getGraphicsAlgorithm(containerShape);
			Ellipse circle = GraphicsUtil.createIntermediateEventCircle(e);
			circle.setForeground(manageColor(StyleUtil.CLASS_FOREGROUND));
			IPeService peService = Graphiti.getPeService();
			peService.setPropertyValue(containerShape,
					UpdateIntermediateCatchEventFeature.INTERMEDIATE_CATCH_EVENT_MARKER,
					AbstractUpdateEventFeature.getEventDefinitionsValue((IntermediateCatchEvent)businessObject));
		}
	}

	public static class CreateIntermediateCatchEventFeature extends AbstractCreateEventFeature<IntermediateCatchEvent> {
		protected Resource resource;
		
		public CreateIntermediateCatchEventFeature(IFeatureProvider fp) {
			super(fp, "捕获事件", "创建一个捕获事件");
		}

		public CreateIntermediateCatchEventFeature(IFeatureProvider fp, Resource resource, String name, String desc) {
			super(fp, name, desc);
			this.resource = resource;
		}
		
		@Override
		public String getStencilImageId() {
			return ImageProvider.IMG_16_INTERMEDIATE_CATCH_EVENT;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.bpmn2.modeler.core.features.AbstractCreateFlowElementFeature#getFlowElementClass()
		 */
		@Override
		public EClass getBusinessObjectClass() {
			return Bpmn2Package.eINSTANCE.getIntermediateCatchEvent();
		}

		@Override
		public IntermediateCatchEvent getBusinessObject(ICreateContext context) {
			if(resource != null) {
				List<IntermediateCatchEvent> intermediateCatchEvents = EMFUtil.getAll(resource, IntermediateCatchEvent.class);
				if(intermediateCatchEvents != null && intermediateCatchEvents.size()>0) {
					IntermediateCatchEvent intermediateCatchEvent = EcoreUtil.copy(intermediateCatchEvents.get(0));
					intermediateCatchEvent.setId(null);
					Resource resource = ((BPMN2Editor)getDiagramEditor()).getResource();
					ModelUtil.setID(intermediateCatchEvent, resource);
					return intermediateCatchEvent;
				}
			}
			return super.getBusinessObject(context);
		}
	}
	
	public static class UpdateIntermediateCatchEventFeature extends AbstractUpdateEventFeature {

		public static String INTERMEDIATE_CATCH_EVENT_MARKER = "marker.intermediate.catch.event"; //$NON-NLS-1$

		/**
		 * @param fp
		 */
		public UpdateIntermediateCatchEventFeature(IFeatureProvider fp) {
			super(fp);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.bpmn2.modeler.core.features.activity.AbstractUpdateMarkerFeature#getPropertyKey()
		 */
		@Override
		protected String getPropertyKey() {
			return INTERMEDIATE_CATCH_EVENT_MARKER;
		}
	}
}
