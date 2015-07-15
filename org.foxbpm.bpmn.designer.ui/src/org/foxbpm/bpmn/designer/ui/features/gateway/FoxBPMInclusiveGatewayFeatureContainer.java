package org.foxbpm.bpmn.designer.ui.features.gateway;

import java.util.List;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.InclusiveGateway;
import org.eclipse.bpmn2.modeler.core.features.gateway.AbstractCreateGatewayFeature;
import org.eclipse.bpmn2.modeler.core.features.gateway.AddGatewayFeature;
import org.eclipse.bpmn2.modeler.core.utils.GraphicsUtil;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.ui.ImageProvider;
import org.eclipse.bpmn2.modeler.ui.editor.BPMN2Editor;
import org.eclipse.bpmn2.modeler.ui.features.gateway.InclusiveGatewayFeatureContainer;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.foxbpm.bpmn.designer.base.utils.EMFUtil;

public class FoxBPMInclusiveGatewayFeatureContainer extends InclusiveGatewayFeatureContainer {
	@Override
	public IAddFeature getAddFeature(IFeatureProvider fp) {
		return new AddInclusiveGatewayFeature(fp);
	}

	@Override
	public ICreateFeature getCreateFeature(IFeatureProvider fp) {
		return new CreateInclusiveGatewayFeature(fp);
	}

	public class AddInclusiveGatewayFeature extends AddGatewayFeature<InclusiveGateway> {
		public AddInclusiveGatewayFeature(IFeatureProvider fp) {
			super(fp);
		}

		@Override
		protected void decorateShape(IAddContext context, ContainerShape containerShape, InclusiveGateway businessObject) {
			Ellipse ellipse = GraphicsUtil.createGatewayOuterCircle(containerShape);
			ellipse.setLineWidth(3);
		}
	}

	public static class CreateInclusiveGatewayFeature extends AbstractCreateGatewayFeature<InclusiveGateway> {
		protected Resource resource;
		
		public CreateInclusiveGatewayFeature(IFeatureProvider fp) {
			super(fp, "包容网关", "创建一个包容网关");
		}
		
		public CreateInclusiveGatewayFeature(IFeatureProvider fp, Resource resource, String name, String desc) {
			super(fp, name, desc);
			this.resource = resource;
		}

		@Override
		protected String getStencilImageId() {
			return ImageProvider.IMG_16_INCLUSIVE_GATEWAY;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.bpmn2.modeler.core.features.AbstractCreateFlowElementFeature#getFlowElementClass()
		 */
		@Override
		public EClass getBusinessObjectClass() {
			return Bpmn2Package.eINSTANCE.getInclusiveGateway();
		}

		@Override
		public InclusiveGateway getBusinessObject(ICreateContext context) {
			if(resource!=null) {
				List<InclusiveGateway> inclusiveGateways = EMFUtil.getAll(resource, InclusiveGateway.class);
				if(inclusiveGateways != null && inclusiveGateways.size()>0) {
					InclusiveGateway inclusiveGateway = EcoreUtil.copy(inclusiveGateways.get(0));
					inclusiveGateway.setId(null);
					Resource resource = ((BPMN2Editor)getDiagramEditor()).getResource();
					ModelUtil.setID(inclusiveGateway, resource);
					return inclusiveGateway;
				}
			}
			return super.createBusinessObject(context);
		}
	}
}
