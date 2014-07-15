package org.foxbpm.bpmn.designer.ui.features.activity.task;

import java.util.List;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.SendTask;
import org.eclipse.bpmn2.ServiceTask;
import org.eclipse.bpmn2.modeler.core.features.activity.task.AbstractCreateTaskFeature;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.ui.ImageProvider;
import org.eclipse.bpmn2.modeler.ui.editor.BPMN2Editor;
import org.eclipse.bpmn2.modeler.ui.features.activity.task.AbstractAddDecoratedTaskFeature;
import org.eclipse.bpmn2.modeler.ui.features.activity.task.ServiceTaskFeatureContainer;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.foxbpm.bpmn.designer.base.utils.EMFUtil;

public class FoxBPMServiceTaskFeatureContainer extends ServiceTaskFeatureContainer {
	@Override
	public ICreateFeature getCreateFeature(IFeatureProvider fp) {
		return new CreateServiceTaskFeature(fp);
	}

	@Override
	public IAddFeature getAddFeature(IFeatureProvider fp) {
		return new AddServiceTaskFeature(fp);
	}

	public static class AddServiceTaskFeature extends AbstractAddDecoratedTaskFeature<SendTask> {

		public AddServiceTaskFeature(IFeatureProvider fp) {
			super(fp);
		}

		@Override
		protected String getStencilImageId() {
			return ImageProvider.IMG_16_SERVICE_TASK;
		}
	}

	public static class CreateServiceTaskFeature extends AbstractCreateTaskFeature<ServiceTask> {
		protected Resource resource;
		
		public CreateServiceTaskFeature(IFeatureProvider fp) {
			super(fp, "服务任务", "创建一个服务任务");
		}

		public CreateServiceTaskFeature(IFeatureProvider fp, Resource resource, String name, String desc) {
			super(fp, name, desc);
			this.resource = resource;
		}
		
		@Override
		protected String getStencilImageId() {
			return ImageProvider.IMG_16_SERVICE_TASK;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.bpmn2.modeler.core.features.AbstractCreateFlowElementFeature#getFlowElementClass()
		 */
		@Override
		public EClass getBusinessObjectClass() {
			return Bpmn2Package.eINSTANCE.getServiceTask();
		}

		@Override
		public ServiceTask getBusinessObject(ICreateContext context) {
			if(resource!=null) {
				List<ServiceTask> serviceTasks = EMFUtil.getAll(resource, ServiceTask.class);
				if(serviceTasks != null && serviceTasks.size()>0) {
					ServiceTask serviceTask = EcoreUtil.copy(serviceTasks.get(0));
					serviceTask.setId(null);
					Resource resource = ((BPMN2Editor)getDiagramEditor()).getResource();
					ModelUtil.setID(serviceTask, resource);
					return serviceTask;
				}
			}
			return super.getBusinessObject(context);
		}
	}
}
