package org.foxbpm.bpmn.designer.ui.features.event;

import java.util.List;

import org.eclipse.bpmn2.BaseElement;
import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.CatchEvent;
import org.eclipse.bpmn2.ThrowEvent;
import org.eclipse.bpmn2.TimerEventDefinition;
import org.eclipse.bpmn2.modeler.core.features.event.definitions.AbstractCreateEventDefinitionFeature;
import org.eclipse.bpmn2.modeler.core.features.event.definitions.DecorationAlgorithm;
import org.eclipse.bpmn2.modeler.core.utils.BusinessObjectUtil;
import org.eclipse.bpmn2.modeler.core.utils.GraphicsUtil;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.ui.ImageProvider;
import org.eclipse.bpmn2.modeler.ui.editor.BPMN2Editor;
import org.eclipse.bpmn2.modeler.ui.features.event.definitions.TimerEventDefinitionContainer;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.algorithms.Image;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.foxbpm.bpmn.designer.base.utils.EMFUtil;

public class FoxBPMStartTimerEventFeatureContainer extends TimerEventDefinitionContainer {
	
	@Override
	public ICreateFeature getCreateFeature(IFeatureProvider fp) {
		return new CreateTimerEventDefinition(fp) {
			public boolean canCreate(ICreateContext context) {
				if (super.canCreate(context)) {
					Object bo = getBusinessObjectForPictogramElement(context.getTargetContainer());
					if (bo instanceof ThrowEvent) {
						ThrowEvent te = (ThrowEvent)bo;
						return te.getEventDefinitions().size()==0;
					}
					if (bo instanceof CatchEvent) {
						CatchEvent ce = (CatchEvent)bo;
						return ce.getEventDefinitions().size()==0;
					}
				}
				return false;
			}
		};
	}

	@Override
	protected Shape drawForStart(DecorationAlgorithm algorithm, ContainerShape shape) {
		return draw(shape);
	}

	@Override
	protected Shape drawForEnd(DecorationAlgorithm algorithm, ContainerShape shape) {
		return draw(shape);
	}

	@Override
	protected Shape drawForThrow(DecorationAlgorithm decorationAlgorithm, ContainerShape shape) {
		return null; // NOT ALLOWED ACCORDING TO SPEC
	}

	@Override
	public Shape drawForCatch(DecorationAlgorithm decorationAlgorithm, ContainerShape shape) {
		return draw(shape);
	}

	@Override
	protected Shape drawForBoundary(DecorationAlgorithm algorithm, ContainerShape shape) {
		return draw(shape);
	}

	private Shape draw(ContainerShape shape) {
		BaseElement be = BusinessObjectUtil.getFirstElementOfType(shape, BaseElement.class, true);
		Shape timerShape = Graphiti.getPeService().createShape(shape, false);
		Image image = GraphicsUtil.createEventImage(timerShape, ImageProvider.IMG_20_TIMER);

		// TODO: can't change foreground color of an Image?
//		Diagram diagram = StyleUtil.findDiagram(image);
//		IGaService gaService = Graphiti.getGaService();
//		image.setForeground(gaService.manageColor(diagram, IColorConstant.GREEN));
//		StyleUtil.setFillStyle(image, FillStyle.FILL_STYLE_NONE);
//		StyleUtil.applyStyle(image, be);
		return timerShape;
	}

	public static class CreateTimerEventDefinition extends AbstractCreateEventDefinitionFeature<TimerEventDefinition> {
		protected Resource resource;
		
		public CreateTimerEventDefinition(IFeatureProvider fp) {
			super(fp, "时间定义", "创建一个时间定义");
		}
		
		public CreateTimerEventDefinition(IFeatureProvider fp, Resource resource, String name, String desc) {
			super(fp, name, desc);
			this.resource = resource;
		}
		
		@Override
		protected String getStencilImageId() {
			return ImageProvider.IMG_16_TIMER;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.bpmn2.modeler.core.features.AbstractBpmn2CreateFeature#getBusinessObjectClass()
		 */
		@Override
		public EClass getBusinessObjectClass() {
			return Bpmn2Package.eINSTANCE.getTimerEventDefinition();
		}

		@Override
		public TimerEventDefinition getBusinessObject(ICreateContext context) {
			if(resource!=null) {
				List<TimerEventDefinition> timerEventDefinitions = EMFUtil.getAll(resource, TimerEventDefinition.class);
				if(timerEventDefinitions != null && timerEventDefinitions.size()>0) {
					TimerEventDefinition timerEventDefinition = EcoreUtil.copy(timerEventDefinitions.get(0));
					timerEventDefinition.setId(null);
					Resource resource = ((BPMN2Editor)getDiagramEditor()).getResource();
					ModelUtil.setID(timerEventDefinition, resource);
					return timerEventDefinition;
				}
			}
			return super.getBusinessObject(context);
		}
	}
}
