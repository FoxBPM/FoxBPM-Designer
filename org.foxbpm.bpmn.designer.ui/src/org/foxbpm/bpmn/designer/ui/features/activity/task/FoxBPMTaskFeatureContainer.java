package org.foxbpm.bpmn.designer.ui.features.activity.task;

import java.util.List;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.Task;
import org.eclipse.bpmn2.modeler.core.features.activity.task.AbstractCreateTaskFeature;
import org.eclipse.bpmn2.modeler.core.features.activity.task.AddTaskFeature;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.ui.ImageProvider;
import org.eclipse.bpmn2.modeler.ui.editor.BPMN2Editor;
import org.eclipse.bpmn2.modeler.ui.features.activity.task.TaskFeatureContainer;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.foxbpm.bpmn.designer.base.utils.EMFUtil;

public class FoxBPMTaskFeatureContainer extends TaskFeatureContainer {
	@Override
	public ICreateFeature getCreateFeature(IFeatureProvider fp) {
		return new CreateTaskFeature(fp);
	}

	@Override
	public IAddFeature getAddFeature(IFeatureProvider fp) {
		return new AddTaskFeature<Task>(fp);
	}

	public static class CreateTaskFeature extends AbstractCreateTaskFeature<Task> {
		protected Resource resource;
		
		public CreateTaskFeature(IFeatureProvider fp) {
			super(fp, "通用任务", "创建一个通用任务");
		}

		public CreateTaskFeature(IFeatureProvider fp, Resource resource, String name, String desc) {
			super(fp, name, desc);
			this.resource = resource;
		}
		
		@Override
		protected String getStencilImageId() {
			return ImageProvider.IMG_16_TASK;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.bpmn2.modeler.core.features.AbstractCreateFlowElementFeature#getFlowElementClass()
		 */
		@Override
		public EClass getBusinessObjectClass() {
			return Bpmn2Package.eINSTANCE.getTask();
		}

		@Override
		public Task getBusinessObject(ICreateContext context) {
			if(resource!=null) {
				List<Task> tasks = EMFUtil.getAll(resource, Task.class);
				if(tasks != null && tasks.size()>0) {
					Task task = EcoreUtil.copy(tasks.get(0));
					task.setId(null);
					Resource resource = ((BPMN2Editor)getDiagramEditor()).getResource();
					ModelUtil.setID(task, resource);
					return task;
				}
			}
			return super.getBusinessObject(context);
		}
	}
}
