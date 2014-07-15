package org.foxbpm.bpmn.designer.ui.features.event;

import java.util.List;

import org.eclipse.bpmn2.BaseElement;
import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.CatchEvent;
import org.eclipse.bpmn2.TerminateEventDefinition;
import org.eclipse.bpmn2.ThrowEvent;
import org.eclipse.bpmn2.modeler.core.features.event.definitions.AbstractCreateEventDefinitionFeature;
import org.eclipse.bpmn2.modeler.core.features.event.definitions.DecorationAlgorithm;
import org.eclipse.bpmn2.modeler.core.utils.BusinessObjectUtil;
import org.eclipse.bpmn2.modeler.core.utils.GraphicsUtil;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.core.utils.StyleUtil;
import org.eclipse.bpmn2.modeler.core.utils.StyleUtil.FillStyle;
import org.eclipse.bpmn2.modeler.ui.ImageProvider;
import org.eclipse.bpmn2.modeler.ui.editor.BPMN2Editor;
import org.eclipse.bpmn2.modeler.ui.features.event.definitions.TerminateEventDefinitionFeatureContainer;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.foxbpm.bpmn.designer.base.utils.EMFUtil;

public class FoxBPMTerminateEventDefinitionFeatureContainer extends TerminateEventDefinitionFeatureContainer {
	@Override
	public ICreateFeature getCreateFeature(IFeatureProvider fp) {
		return new CreateTerminateEventDefinition(fp) {
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
		return null; // NOT ALLOWED ACCORDING TO SPEC
	}

	@Override
	protected Shape drawForEnd(DecorationAlgorithm algorithm, ContainerShape shape) {
		BaseElement be = BusinessObjectUtil.getFirstElementOfType(shape, BaseElement.class, true);
		Shape terminateShape = Graphiti.getPeService().createShape(shape, false);
		Ellipse ellispe = GraphicsUtil.createEventTerminate(terminateShape);
		StyleUtil.setFillStyle(ellispe, FillStyle.FILL_STYLE_FOREGROUND);
		StyleUtil.applyStyle(ellispe, be);
		return terminateShape;
	}

	@Override
	protected Shape drawForThrow(DecorationAlgorithm algorithm, ContainerShape shape) {
		return null; // NOT ALLOWED ACCORDING TO SPEC
	}

	@Override
	protected Shape drawForCatch(DecorationAlgorithm algorithm, ContainerShape shape) {
		return null; // NOT ALLOWED ACCORDING TO SPEC
	}

	@Override
	protected Shape drawForBoundary(DecorationAlgorithm algorithm, ContainerShape shape) {
		return null; // NOT ALLOWED ACCORDING TO SPEC
	}

	public static class CreateTerminateEventDefinition extends AbstractCreateEventDefinitionFeature<TerminateEventDefinition> {
		protected Resource resource;
		
		public CreateTerminateEventDefinition(IFeatureProvider fp) {
			super(fp, "终止事件定义", "创建一个终止事件定义");
		}
		
		public CreateTerminateEventDefinition(IFeatureProvider fp, Resource resource, String name, String desc) {
			super(fp, name, desc);
			this.resource = resource;
		}

		@Override
		protected String getStencilImageId() {
			return ImageProvider.IMG_16_TERMINATE;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.bpmn2.modeler.core.features.AbstractBpmn2CreateFeature#getBusinessObjectClass()
		 */
		@Override
		public EClass getBusinessObjectClass() {
			return Bpmn2Package.eINSTANCE.getTerminateEventDefinition();
		}

		@Override
		public TerminateEventDefinition getBusinessObject(ICreateContext context) {
			if(resource!=null) {
				List<TerminateEventDefinition> terminateEventDefinitions = EMFUtil.getAll(resource, TerminateEventDefinition.class);
				if(terminateEventDefinitions != null && terminateEventDefinitions.size()>0) {
					TerminateEventDefinition terminateEventDefinition = EcoreUtil.copy(terminateEventDefinitions.get(0));
					terminateEventDefinition.setId(null);
					Resource resource = ((BPMN2Editor)getDiagramEditor()).getResource();
					ModelUtil.setID(terminateEventDefinition, resource);
					return terminateEventDefinition;
				}
			}
			return super.getBusinessObject(context);
		}
	}
}
