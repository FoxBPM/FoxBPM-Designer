package org.foxbpm.bpmn.designer.ui.features.gateway;

import java.util.List;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.ParallelGateway;
import org.eclipse.bpmn2.modeler.core.features.gateway.AbstractCreateGatewayFeature;
import org.eclipse.bpmn2.modeler.core.features.gateway.AddGatewayFeature;
import org.eclipse.bpmn2.modeler.core.utils.GraphicsUtil;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.ui.ImageProvider;
import org.eclipse.bpmn2.modeler.ui.editor.BPMN2Editor;
import org.eclipse.bpmn2.modeler.ui.features.gateway.ParallelGatewayFeatureContainer;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.foxbpm.bpmn.designer.base.utils.EMFUtil;

public class FoxBPMParallelGatewayFeatureContainer extends ParallelGatewayFeatureContainer {
	@Override
	public ICreateFeature getCreateFeature(IFeatureProvider fp) {
		return new CreateParallelGatewayFeature(fp);
	}

	@Override
	public IAddFeature getAddFeature(IFeatureProvider fp) {
		return new AddParallelGatewayFeature(fp);
	}

	public class AddParallelGatewayFeature extends AddGatewayFeature<ParallelGateway> {
		public AddParallelGatewayFeature(IFeatureProvider fp) {
			super(fp);
		}

		@Override
		protected void decorateShape(IAddContext context, ContainerShape containerShape, ParallelGateway businessObject) {
			GraphicsUtil.createGatewayCross(containerShape);
		}
	}

	public static class CreateParallelGatewayFeature extends AbstractCreateGatewayFeature<ParallelGateway> {
		protected Resource resource;
		
		public CreateParallelGatewayFeature(IFeatureProvider fp) {
			super(fp, "并行网关", "创建一个并行网关");
		}
		
		public CreateParallelGatewayFeature(IFeatureProvider fp, Resource resource, String name, String desc) {
			super(fp, name, desc);
			this.resource = resource;
		}

		@Override
		protected String getStencilImageId() {
			return ImageProvider.IMG_16_PARALLEL_GATEWAY;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.bpmn2.modeler.core.features.AbstractCreateFlowElementFeature#getFlowElementClass()
		 */
		@Override
		public EClass getBusinessObjectClass() {
			return Bpmn2Package.eINSTANCE.getParallelGateway();
		}

		@Override
		public ParallelGateway getBusinessObject(ICreateContext context) {
			if(resource!=null) {
				List<ParallelGateway> parallelGateways = EMFUtil.getAll(resource, ParallelGateway.class);
				if(parallelGateways != null && parallelGateways.size()>0) {
					ParallelGateway parallelGateway = EcoreUtil.copy(parallelGateways.get(0));
					parallelGateway.setId(null);
					Resource resource = ((BPMN2Editor)getDiagramEditor()).getResource();
					ModelUtil.setID(parallelGateway, resource);
					return parallelGateway;
				}
			}
			return super.createBusinessObject(context);
		}
	}
}
