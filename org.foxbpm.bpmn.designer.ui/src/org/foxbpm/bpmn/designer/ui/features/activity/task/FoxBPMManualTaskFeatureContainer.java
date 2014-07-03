package org.foxbpm.bpmn.designer.ui.features.activity.task;

import java.util.List;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.ManualTask;
import org.eclipse.bpmn2.modeler.core.features.activity.task.AbstractCreateTaskFeature;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.ui.ImageProvider;
import org.eclipse.bpmn2.modeler.ui.editor.BPMN2Editor;
import org.eclipse.bpmn2.modeler.ui.features.activity.task.AbstractAddDecoratedTaskFeature;
import org.eclipse.bpmn2.modeler.ui.features.activity.task.ManualTaskFeatureContainer;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.foxbpm.bpmn.designer.base.utils.EMFUtil;

public class FoxBPMManualTaskFeatureContainer extends ManualTaskFeatureContainer {
	@Override
	public ICreateFeature getCreateFeature(IFeatureProvider fp) {
		return new CreateManualTaskFeature(fp);
	}

	@Override
	public IAddFeature getAddFeature(IFeatureProvider fp) {
		return new AddManualTaskFeature(fp);
	}
	
	public static class AddManualTaskFeature extends AbstractAddDecoratedTaskFeature<ManualTask> {
		
		public AddManualTaskFeature(IFeatureProvider fp) {
			super(fp);
		}

		@Override
		protected String getStencilImageId() {
			return ImageProvider.IMG_16_MANUAL_TASK;
		}
	}

	public static class CreateManualTaskFeature extends AbstractCreateTaskFeature<ManualTask> {
		protected Resource resource;
		
		public CreateManualTaskFeature(IFeatureProvider fp) {
			super(fp, "手工任务", "创建一个手工任务");
		}
		
		public CreateManualTaskFeature(IFeatureProvider fp, Resource resource, String name, String desc) {
			super(fp, "手工任务", "创建一个手工任务");
			this.resource = resource;
		}

		@Override
		protected String getStencilImageId() {
			return ImageProvider.IMG_16_MANUAL_TASK;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.bpmn2.modeler.core.features.AbstractCreateFlowElementFeature#getFlowElementClass()
		 */
		@Override
		public EClass getBusinessObjectClass() {
			return Bpmn2Package.eINSTANCE.getManualTask();
		}

		@Override
		public ManualTask getBusinessObject(ICreateContext context) {
			List<ManualTask> manualTasks = EMFUtil.getAll(resource, ManualTask.class);
			if(manualTasks != null && manualTasks.size()>0) {
				ManualTask manualTask = EcoreUtil.copy(manualTasks.get(0));
				manualTask.setId(null);
				Resource resource = ((BPMN2Editor)getDiagramEditor()).getResource();
				ModelUtil.setID(manualTask, resource);
				return manualTask;
			}
			return super.getBusinessObject(context);
		}
	}
}
