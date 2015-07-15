package org.foxbpm.bpmn.designer.ui.features.data;

import java.util.List;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.DataInput;
import org.eclipse.bpmn2.modeler.core.features.data.AbstractCreateDataInputOutputFeature;
import org.eclipse.bpmn2.modeler.core.features.data.AddDataFeature;
import org.eclipse.bpmn2.modeler.core.utils.GraphicsUtil;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.core.utils.StyleUtil;
import org.eclipse.bpmn2.modeler.ui.ImageProvider;
import org.eclipse.bpmn2.modeler.ui.editor.BPMN2Editor;
import org.eclipse.bpmn2.modeler.ui.features.data.DataInputFeatureContainer;
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

public class FoxBPMDataInputFeatureContainer extends DataInputFeatureContainer {
	@Override
	public ICreateFeature getCreateFeature(IFeatureProvider fp) {
		return new CreateDataInputFeature(fp);
	}

	@Override
	public IAddFeature getAddFeature(IFeatureProvider fp) {
		return new AddDataInputFeature(fp);
	}

	public class AddDataInputFeature extends AddDataFeature<DataInput> {
		public AddDataInputFeature(IFeatureProvider fp) {
			super(fp);
		}

		@Override
		protected boolean isSupportCollectionMarkers() {
			return false;
		}

		@Override
		protected void decorateShape(IAddContext context, ContainerShape containerShape, DataInput businessObject) {
			Polygon p = (Polygon)getGraphicsAlgorithm(containerShape);
			Polygon arrow = GraphicsUtil.createDataArrow(p);
			arrow.setFilled(false);
			arrow.setForeground(manageColor(StyleUtil.CLASS_FOREGROUND));
		}

		@Override
		public String getName(DataInput t) {
			return t.getName();
		}
	}

	public static class CreateDataInputFeature extends AbstractCreateDataInputOutputFeature<DataInput> {
		protected Resource resource;
		
		public CreateDataInputFeature(IFeatureProvider fp) {
			super(fp, "数据输入", "创建一个数据输入");
		}
		
		public CreateDataInputFeature(IFeatureProvider fp, Resource resource, String name, String desc) {
			super(fp, name, desc);
			this.resource = resource;
		}

		@Override
		public String getStencilImageId() {
			return ImageProvider.IMG_16_DATA_INPUT;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.bpmn2.modeler.core.features.AbstractBpmn2CreateFeature#getBusinessObjectClass()
		 */
		@Override
		public EClass getBusinessObjectClass() {
			return Bpmn2Package.eINSTANCE.getDataInput();
		}

		@Override
		public DataInput getBusinessObject(ICreateContext context) {
			if(resource!=null) {
				List<DataInput> dataInputs = EMFUtil.getAll(resource, DataInput.class);
				if(dataInputs != null && dataInputs.size()>0) {
					DataInput dataInput = EcoreUtil.copy(dataInputs.get(0));
					dataInput.setId(null);
					Resource resource = ((BPMN2Editor)getDiagramEditor()).getResource();
					ModelUtil.setID(dataInput, resource);
					return dataInput;
				}
			}
			return super.getBusinessObject(context);
		}
	}
}
