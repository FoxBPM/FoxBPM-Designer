package org.foxbpm.bpmn.designer.ui.features.activity.task;

import java.util.List;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.UserTask;
import org.eclipse.bpmn2.modeler.core.features.activity.task.AbstractCreateTaskFeature;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.ui.ImageProvider;
import org.eclipse.bpmn2.modeler.ui.editor.BPMN2Editor;
import org.eclipse.bpmn2.modeler.ui.features.activity.task.AbstractAddDecoratedTaskFeature;
import org.eclipse.bpmn2.modeler.ui.features.activity.task.UserTaskFeatureContainer;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.foxbpm.bpmn.designer.base.utils.EMFUtil;

public class FoxBPMUserTaskFeatureContainer extends UserTaskFeatureContainer {
	@Override
	public ICreateFeature getCreateFeature(IFeatureProvider fp) {
		return new CreateUserTaskFeature(fp);
	}

	@Override
	public IAddFeature getAddFeature(IFeatureProvider fp) {
		return new AddUserTaskFeature(fp);
	}
	
	public static class AddUserTaskFeature extends AbstractAddDecoratedTaskFeature<UserTask> {
		
		public AddUserTaskFeature(IFeatureProvider fp) {
			super(fp);
		}

		@Override
		protected String getStencilImageId() {
			return ImageProvider.IMG_16_USER_TASK;
		}
	}

	public static class CreateUserTaskFeature extends AbstractCreateTaskFeature<UserTask> {
		protected Resource resource;
		
		public CreateUserTaskFeature(IFeatureProvider fp) {
			super(fp, "人工任务", "创建一个人工任务");
		}
		
		public CreateUserTaskFeature(IFeatureProvider fp, Resource resource, String name, String desc) {
			super(fp, name, desc);
			this.resource = resource;
		}

		@Override
		protected String getStencilImageId() {
			return ImageProvider.IMG_16_USER_TASK;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.bpmn2.modeler.core.features.AbstractCreateFlowElementFeature#getFlowElementClass()
		 */
		@Override
		public EClass getBusinessObjectClass() {
			return Bpmn2Package.eINSTANCE.getUserTask();
		}

		@Override
		public UserTask createBusinessObject(ICreateContext context) {
			if(resource!=null) {
				List<UserTask> userTasks = EMFUtil.getAll(resource, UserTask.class);
				if(userTasks != null && userTasks.size()>0) {
					UserTask userTask = EcoreUtil.copy(userTasks.get(0));
					userTask.setId(null);
					Resource resource = ((BPMN2Editor)getDiagramEditor()).getResource();
					ModelUtil.setID(userTask, resource);
					return userTask;
				}
			}
			return super.createBusinessObject(context);
		}
	}
}
