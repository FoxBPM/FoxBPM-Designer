package org.foxbpm.bpmn.designer.ui.features.activity.task;

import java.util.List;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.BusinessRuleTask;
import org.eclipse.bpmn2.modeler.core.features.activity.task.AbstractCreateTaskFeature;
import org.eclipse.bpmn2.modeler.core.utils.GraphicsUtil;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.ui.ImageProvider;
import org.eclipse.bpmn2.modeler.ui.editor.BPMN2Editor;
import org.eclipse.bpmn2.modeler.ui.features.activity.task.AbstractAddDecoratedTaskFeature;
import org.eclipse.bpmn2.modeler.ui.features.activity.task.BusinessRuleTaskFeatureContainer;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.foxbpm.bpmn.designer.base.utils.EMFUtil;

public class FoxBPMBusinessRuleTaskFeatureContainer extends BusinessRuleTaskFeatureContainer {
	@Override
	public ICreateFeature getCreateFeature(IFeatureProvider fp) {
		return new CreateBusinessRuleTaskFeature(fp);
	}

	@Override
	public IAddFeature getAddFeature(IFeatureProvider fp) {
		return new AddBusinessRuleTask(fp);
	}

	public static class AddBusinessRuleTask extends AbstractAddDecoratedTaskFeature<BusinessRuleTask> {

		public AddBusinessRuleTask(IFeatureProvider fp) {
			super(fp);
		}

		@Override
		public int getWidth() {
			return GraphicsUtil.getActivitySize(getDiagram()).getWidth();
//			return GraphicsUtil.TASK_DEFAULT_WIDTH + 50;
		}

		@Override
		protected String getStencilImageId() {
			return ImageProvider.IMG_16_BUSINESS_RULE_TASK;
		}
	}

	public static class CreateBusinessRuleTaskFeature extends AbstractCreateTaskFeature<BusinessRuleTask> {
		protected Resource resource;
		
		public CreateBusinessRuleTaskFeature(IFeatureProvider fp) {
			super(fp, "业务规则任务", "创建一个业务规则任务");
		}

		public CreateBusinessRuleTaskFeature(IFeatureProvider fp, Resource resource, String name, String desc) {
			super(fp, name, desc);
			this.resource = resource;
		}
		
		@Override
		protected String getStencilImageId() {
			return ImageProvider.IMG_16_BUSINESS_RULE_TASK;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.bpmn2.modeler.core.features.AbstractCreateFlowElementFeature#getFlowElementClass()
		 */
		@Override
		public EClass getBusinessObjectClass() {
			return Bpmn2Package.eINSTANCE.getBusinessRuleTask();
		}

		@Override
		public BusinessRuleTask getBusinessObject(ICreateContext context) {
			if(resource!=null) {
				List<BusinessRuleTask> businessRuleTasks = EMFUtil.getAll(resource, BusinessRuleTask.class);
				if(businessRuleTasks != null && businessRuleTasks.size()>0) {
					BusinessRuleTask businessRuleTask = EcoreUtil.copy(businessRuleTasks.get(0));
					businessRuleTask.setId(null);
					Resource resource = ((BPMN2Editor)getDiagramEditor()).getResource();
					ModelUtil.setID(businessRuleTask, resource);
					return businessRuleTask;
				}
			}
			return super.getBusinessObject(context);
		}
	}
}
