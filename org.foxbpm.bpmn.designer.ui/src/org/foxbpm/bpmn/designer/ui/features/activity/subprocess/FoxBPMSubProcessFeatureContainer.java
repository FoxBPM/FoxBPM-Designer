package org.foxbpm.bpmn.designer.ui.features.activity.subprocess;

import java.util.List;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.SubProcess;
import org.eclipse.bpmn2.modeler.core.features.MultiUpdateFeature;
import org.eclipse.bpmn2.modeler.core.features.activity.AbstractCreateExpandableFlowNodeFeature;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.ui.ImageProvider;
import org.eclipse.bpmn2.modeler.ui.editor.BPMN2Editor;
import org.eclipse.bpmn2.modeler.ui.features.activity.subprocess.AddExpandableActivityFeature;
import org.eclipse.bpmn2.modeler.ui.features.activity.subprocess.SubProcessFeatureContainer;
import org.eclipse.bpmn2.modeler.ui.features.activity.subprocess.UpdateExpandableActivityFeature;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.foxbpm.bpmn.designer.base.utils.EMFUtil;

public class FoxBPMSubProcessFeatureContainer extends SubProcessFeatureContainer {
	public static final String TRIGGERED_BY_EVENT = "triggered-by-event-key"; //$NON-NLS-1$
	public static final String IS_EXPANDED = "is-expanded-key"; //$NON-NLS-1$
	
	@Override
	public ICreateFeature getCreateFeature(IFeatureProvider fp) {
		return new CreateSubProcessFeature(fp);
	}

	@Override
	public IAddFeature getAddFeature(IFeatureProvider fp) {
		return new AddExpandableActivityFeature<SubProcess>(fp);
	}

	@Override
	public IUpdateFeature getUpdateFeature(IFeatureProvider fp) {
		IUpdateFeature updateFeature = super.getUpdateFeature(fp);
		MultiUpdateFeature multiUpdate;
		if (updateFeature instanceof MultiUpdateFeature)
			multiUpdate = (MultiUpdateFeature)updateFeature;
		else
			multiUpdate = new MultiUpdateFeature(fp);
		UpdateExpandableActivityFeature ueaf = new UpdateExpandableActivityFeature(fp);
		multiUpdate.addUpdateFeature(ueaf);
		return multiUpdate;
	}

	public static class CreateSubProcessFeature extends AbstractCreateExpandableFlowNodeFeature<SubProcess> {
		protected Resource resource;
		         
		public CreateSubProcessFeature(IFeatureProvider fp) {
			super(fp, "私有子流程", "创建一个私有子流程");
		}
		
		public CreateSubProcessFeature(IFeatureProvider fp, Resource resource, String name, String desc) {
			super(fp, name, desc);
			this.resource = resource;
		}

		@Override
		protected String getStencilImageId() {
			return ImageProvider.IMG_16_SUB_PROCESS;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.bpmn2.modeler.core.features.AbstractCreateFlowElementFeature#getFlowElementClass()
		 */
		@Override
		public EClass getBusinessObjectClass() {
			return Bpmn2Package.eINSTANCE.getSubProcess();
		}

		@Override
		public SubProcess getBusinessObject(ICreateContext context) {
			if(resource!=null) {
				List<SubProcess> subProcesses = EMFUtil.getAll(resource, SubProcess.class);
				if(subProcesses != null && subProcesses.size()>0) {
					SubProcess subProcess = EcoreUtil.copy(subProcesses.get(0));
					subProcess.setId(null);
					Resource resource = ((BPMN2Editor)getDiagramEditor()).getResource();
					ModelUtil.setID(subProcess, resource);
					return subProcess;
				}
			}
			return super.getBusinessObject(context);
		}
	}
}
