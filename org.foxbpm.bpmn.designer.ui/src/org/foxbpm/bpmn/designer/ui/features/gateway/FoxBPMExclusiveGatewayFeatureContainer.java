package org.foxbpm.bpmn.designer.ui.features.gateway;

import java.util.List;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.ExclusiveGateway;
import org.eclipse.bpmn2.di.BPMNShape;
import org.eclipse.bpmn2.modeler.core.features.gateway.AbstractCreateGatewayFeature;
import org.eclipse.bpmn2.modeler.core.features.gateway.AddGatewayFeature;
import org.eclipse.bpmn2.modeler.core.utils.BusinessObjectUtil;
import org.eclipse.bpmn2.modeler.core.utils.GraphicsUtil;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.ui.ImageProvider;
import org.eclipse.bpmn2.modeler.ui.editor.BPMN2Editor;
import org.eclipse.bpmn2.modeler.ui.features.gateway.ExclusiveGatewayFeatureContainer;
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

public class FoxBPMExclusiveGatewayFeatureContainer extends ExclusiveGatewayFeatureContainer {
	@Override
	public IAddFeature getAddFeature(IFeatureProvider fp) {
		return new AddExclusiveGatewayFeature(fp);
	}

	@Override
	public ICreateFeature getCreateFeature(IFeatureProvider fp) {
		return new CreateExclusiveGatewayFeature(fp);
	}

	public class AddExclusiveGatewayFeature extends AddGatewayFeature<ExclusiveGateway> {
		public AddExclusiveGatewayFeature(IFeatureProvider fp) {
			super(fp);
		}

		@Override
		protected void decorateShape(IAddContext context, ContainerShape containerShape, ExclusiveGateway businessObject) {
			// TODO: handle showExclusiveGatewayMarker property change event in BPMN2Editor
			// and override the default gateway UpdateFeature to show/hide the "X" marker.
			BPMNShape bpmnShape = BusinessObjectUtil.getFirstElementOfType(containerShape, BPMNShape.class);
			if (bpmnShape.isIsMarkerVisible()) {
				GraphicsUtil.createGatewayDiagonalCross(containerShape);
			}
		}
	}

	public static class CreateExclusiveGatewayFeature extends AbstractCreateGatewayFeature<ExclusiveGateway> {
		protected Resource resource;
		
		public CreateExclusiveGatewayFeature(IFeatureProvider fp) {
			super(fp, "排他网关", "创建一个排他网关");
		}
		
		public CreateExclusiveGatewayFeature(IFeatureProvider fp, Resource resource, String name, String desc) {
			super(fp, name, desc);
			this.resource = resource;
		}

		@Override
		protected String getStencilImageId() {
			return ImageProvider.IMG_16_EXCLUSIVE_GATEWAY;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.bpmn2.modeler.core.features.AbstractCreateFlowElementFeature#getFlowElementClass()
		 */
		@Override
		public EClass getBusinessObjectClass() {
			return Bpmn2Package.eINSTANCE.getExclusiveGateway();
		}

		@Override
		public ExclusiveGateway createBusinessObject(ICreateContext context) {
			List<ExclusiveGateway> exclusiveGateways = EMFUtil.getAll(resource, ExclusiveGateway.class);
			if(exclusiveGateways != null && exclusiveGateways.size()>0) {
				ExclusiveGateway exclusiveGateway = EcoreUtil.copy(exclusiveGateways.get(0));
				exclusiveGateway.setId(null);
				Resource resource = ((BPMN2Editor)getDiagramEditor()).getResource();
				ModelUtil.setID(exclusiveGateway, resource);
				return exclusiveGateway;
			}
			return super.createBusinessObject(context);
		}
	}
}
