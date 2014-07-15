package org.foxbpm.bpmn.designer.ui.features.data;

import java.util.List;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.DataOutput;
import org.eclipse.bpmn2.modeler.core.features.data.AbstractCreateDataInputOutputFeature;
import org.eclipse.bpmn2.modeler.core.features.data.AddDataFeature;
import org.eclipse.bpmn2.modeler.core.utils.GraphicsUtil;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.core.utils.StyleUtil;
import org.eclipse.bpmn2.modeler.ui.ImageProvider;
import org.eclipse.bpmn2.modeler.ui.editor.BPMN2Editor;
import org.eclipse.bpmn2.modeler.ui.features.data.DataOutputFeatureContainer;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.foxbpm.bpmn.designer.base.utils.EMFUtil;

public class FoxBPMDataOutputFeatureContainer extends DataOutputFeatureContainer {
	@Override
	public ICreateFeature getCreateFeature(IFeatureProvider fp) {
		return new CreateDataOutputFeature(fp);
	}

	@Override
	public IAddFeature getAddFeature(IFeatureProvider fp) {
		return new AddDataOutputFeature(fp);
	}

	public class AddDataOutputFeature extends AddDataFeature<DataOutput> {
		public AddDataOutputFeature(IFeatureProvider fp) {
			super(fp);
		}

		@Override
		protected boolean isSupportCollectionMarkers() {
			return false;
		}

		@Override
		protected void decorateShape(IAddContext context, ContainerShape containerShape, DataOutput businessObject) {
			Polygon p = (Polygon)getGraphicsAlgorithm(containerShape);
			Polygon arrow = GraphicsUtil.createDataArrow(p);
			arrow.setFilled(true);
			arrow.setBackground(manageColor(StyleUtil.CLASS_FOREGROUND));
			arrow.setForeground(manageColor(StyleUtil.CLASS_FOREGROUND));
		}

		@Override
		public String getName(DataOutput t) {
			return t.getName();
		}
	}

	public static class CreateDataOutputFeature extends AbstractCreateDataInputOutputFeature<DataOutput> {
		protected Resource resource;
		
		public CreateDataOutputFeature(IFeatureProvider fp) {
			super(fp, "数据输出", "创建一个数据输出");
		}
		
		public CreateDataOutputFeature(IFeatureProvider fp, Resource resource, String name, String desc) {
			super(fp, name, desc);
			this.resource = resource;
		}

		@Override
		public String getStencilImageId() {
			return ImageProvider.IMG_16_DATA_OUTPUT;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.bpmn2.modeler.core.features.AbstractBpmn2CreateFeature#getBusinessObjectClass()
		 */
		@Override
		public EClass getBusinessObjectClass() {
			return Bpmn2Package.eINSTANCE.getDataOutput();
		}

		@Override
		public DataOutput getBusinessObject(ICreateContext context) {
			if(resource!=null) {
				List<DataOutput> dataOutputs = EMFUtil.getAll(resource, DataOutput.class);
				if(dataOutputs != null && dataOutputs.size()>0) {
					DataOutput dataOutput = EcoreUtil.copy(dataOutputs.get(0));
					dataOutput.setId(null);
					Resource resource = ((BPMN2Editor)getDiagramEditor()).getResource();
					ModelUtil.setID(dataOutput, resource);
					return dataOutput;
				}
			}
			return super.getBusinessObject(context);
		}
	}
}
