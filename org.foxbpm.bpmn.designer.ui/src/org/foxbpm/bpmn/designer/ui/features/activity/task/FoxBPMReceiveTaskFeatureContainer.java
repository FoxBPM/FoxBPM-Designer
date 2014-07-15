package org.foxbpm.bpmn.designer.ui.features.activity.task;

import java.util.List;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.ReceiveTask;
import org.eclipse.bpmn2.modeler.core.features.activity.task.AbstractCreateTaskFeature;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.ui.ImageProvider;
import org.eclipse.bpmn2.modeler.ui.editor.BPMN2Editor;
import org.eclipse.bpmn2.modeler.ui.features.activity.task.AbstractAddDecoratedTaskFeature;
import org.eclipse.bpmn2.modeler.ui.features.activity.task.ReceiveTaskFeatureContainer;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.foxbpm.bpmn.designer.base.utils.EMFUtil;

public class FoxBPMReceiveTaskFeatureContainer extends ReceiveTaskFeatureContainer {
	@Override
	public ICreateFeature getCreateFeature(IFeatureProvider fp) {
		return new CreateReceiveTaskFeature(fp);
	}

	@Override
	public IAddFeature getAddFeature(IFeatureProvider fp) {
		return new AddReceiveTaskFeature(fp);
	}
	
	public static class AddReceiveTaskFeature extends AbstractAddDecoratedTaskFeature<ReceiveTask> {

		public AddReceiveTaskFeature(IFeatureProvider fp) {
			super(fp);
		}

		@Override
		protected String getStencilImageId() {
			return ImageProvider.IMG_16_RECEIVE_TASK;
		}
	}

	public static class CreateReceiveTaskFeature extends AbstractCreateTaskFeature<ReceiveTask> {
		protected Resource resource;
		
		public CreateReceiveTaskFeature(IFeatureProvider fp) {
			super(fp, "接收任务", "创建一个接收任务");
		}
		
		public CreateReceiveTaskFeature(IFeatureProvider fp, Resource resource, String name, String desc) {
			super(fp, name, desc);
			this.resource = resource;
		}

		@Override
		protected String getStencilImageId() {
			return ImageProvider.IMG_16_RECEIVE_TASK;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.bpmn2.modeler.core.features.AbstractCreateFlowElementFeature#getFlowElementClass()
		 */
		@Override
		public EClass getBusinessObjectClass() {
			return Bpmn2Package.eINSTANCE.getReceiveTask();
		}

		@Override
		public ReceiveTask getBusinessObject(ICreateContext context) {
			if(resource!=null) {
				List<ReceiveTask> receiveTasks = EMFUtil.getAll(resource, ReceiveTask.class);
				if(receiveTasks != null && receiveTasks.size()>0) {
					ReceiveTask receiveTask = EcoreUtil.copy(receiveTasks.get(0));
					receiveTask.setId(null);
					Resource resource = ((BPMN2Editor)getDiagramEditor()).getResource();
					ModelUtil.setID(receiveTask, resource);
					return receiveTask;
				}
			}
			return super.getBusinessObject(context);
		}
	}
}
