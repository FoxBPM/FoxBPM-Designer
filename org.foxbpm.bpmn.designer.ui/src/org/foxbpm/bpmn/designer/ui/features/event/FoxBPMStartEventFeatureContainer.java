package org.foxbpm.bpmn.designer.ui.features.event;

import java.util.List;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.StartEvent;
import org.eclipse.bpmn2.modeler.core.features.MultiUpdateFeature;
import org.eclipse.bpmn2.modeler.core.features.event.AbstractCreateEventFeature;
import org.eclipse.bpmn2.modeler.core.features.event.AbstractUpdateEventFeature;
import org.eclipse.bpmn2.modeler.core.features.event.AddEventFeature;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.ui.ImageProvider;
import org.eclipse.bpmn2.modeler.ui.editor.BPMN2Editor;
import org.eclipse.bpmn2.modeler.ui.features.event.StartEventFeatureContainer;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.styles.LineStyle;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IPeService;
import org.foxbpm.bpmn.designer.base.utils.EMFUtil;

public class FoxBPMStartEventFeatureContainer extends StartEventFeatureContainer {
	static final String INTERRUPTING = "interrupting"; //$NON-NLS-1$
	
	@Override
	public ICreateFeature getCreateFeature(IFeatureProvider fp) {
		return new CreateStartEventFeature(fp);
	}

	@Override
	public IAddFeature getAddFeature(IFeatureProvider fp) {
		return new AddStartEventFeature(fp);
	}

	@Override
	public IUpdateFeature getUpdateFeature(IFeatureProvider fp) {
		MultiUpdateFeature updateFeature = new MultiUpdateFeature(fp);
		updateFeature.addUpdateFeature(super.getUpdateFeature(fp));
		updateFeature.addUpdateFeature(new UpdateSubProcessEventFeature(fp));
		updateFeature.addUpdateFeature(new UpdateStartEventFeature(fp));
		return updateFeature;
	}

	public class AddStartEventFeature extends AddEventFeature<StartEvent> {
		public AddStartEventFeature(IFeatureProvider fp) {
			super(fp);
		}

		@Override
		protected void decorateShape(IAddContext context, ContainerShape containerShape, StartEvent businessObject) {
			Ellipse e = (Ellipse)getGraphicsAlgorithm(containerShape);
			Graphiti.getPeService().setPropertyValue(containerShape, INTERRUPTING, Boolean.toString(true));
			IPeService peService = Graphiti.getPeService();
			peService.setPropertyValue(containerShape,
					UpdateStartEventFeature.START_EVENT_MARKER,
					AbstractUpdateEventFeature.getEventDefinitionsValue((StartEvent)businessObject));
		}
	}

	public static class CreateStartEventFeature extends AbstractCreateEventFeature<StartEvent> {
		protected Resource resource;
		
		public CreateStartEventFeature(IFeatureProvider fp) {
			super(fp, "开始节点", "创建一个开始节点");
		}
		
		public CreateStartEventFeature(IFeatureProvider fp, Resource resource, String name, String desc) {
			super(fp, name, desc);
			this.resource = resource;
		}

		@Override
		public String getStencilImageId() {
			return ImageProvider.IMG_16_START_EVENT;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.bpmn2.modeler.core.features.AbstractCreateFlowElementFeature#getFlowElementClass()
		 */
		@Override
		public EClass getBusinessObjectClass() {
			return Bpmn2Package.eINSTANCE.getStartEvent();
		}

		@Override
		public StartEvent getBusinessObject(ICreateContext context) {
			if(resource!=null) {
				List<StartEvent> startEvents = EMFUtil.getAll(resource, StartEvent.class);
				if(startEvents != null && startEvents.size()>0) {
					StartEvent startEvent = EcoreUtil.copy(startEvents.get(0));
					startEvent.setId(null);
					Resource resource = ((BPMN2Editor)getDiagramEditor()).getResource();
					ModelUtil.setID(startEvent, resource);
					return startEvent;
				}
			}
			return super.createBusinessObject(context);
		}
	}

	protected static class UpdateStartEventFeature extends AbstractUpdateEventFeature {

		public static String START_EVENT_MARKER = "marker.start.event"; //$NON-NLS-1$

		/**
		 * @param fp
		 */
		public UpdateStartEventFeature(IFeatureProvider fp) {
			super(fp);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.bpmn2.modeler.core.features.activity.AbstractUpdateMarkerFeature#getPropertyKey()
		 */
		@Override
		protected String getPropertyKey() {
			return START_EVENT_MARKER;
		}
	}

	private class UpdateSubProcessEventFeature extends AbstractUpdateFeature {

		public UpdateSubProcessEventFeature(IFeatureProvider fp) {
			super(fp);
		}

		@Override
		public boolean canUpdate(IUpdateContext context) {
			Object o = getBusinessObjectForPictogramElement(context.getPictogramElement());
			return o != null && o instanceof StartEvent;
		}

		@Override
		public IReason updateNeeded(IUpdateContext context) {
			IPeService peService = Graphiti.getPeService();
			PictogramElement element = context.getPictogramElement();

			String prop = peService.getPropertyValue(element, INTERRUPTING);
			if (prop == null) {
				return Reason.createFalseReason();
			}

			StartEvent event = (StartEvent) getBusinessObjectForPictogramElement(element);
			boolean interrupting = Boolean.parseBoolean(prop);
			IReason reason = event.isIsInterrupting() == interrupting ? Reason.createFalseReason() : Reason
					.createTrueReason();
			return reason;
		}

		@Override
		public boolean update(IUpdateContext context) {
			IPeService peService = Graphiti.getPeService();
			ContainerShape container = (ContainerShape) context.getPictogramElement();
			StartEvent event = (StartEvent) getBusinessObjectForPictogramElement(container);

			GraphicsAlgorithm ga = peService.getAllContainedShapes(container).iterator().next().getGraphicsAlgorithm();
			if (ga instanceof Ellipse) {
			Ellipse ellipse = (Ellipse) ga;
				LineStyle style = event.isIsInterrupting() ? LineStyle.SOLID : LineStyle.DASH;
				ellipse.setLineStyle(style);
			}
			
			peService.setPropertyValue(container, INTERRUPTING, Boolean.toString(event.isIsInterrupting()));
			return true;
		}
	}
}
