package org.foxbpm.bpmn.designer.ui.features.activity.subprocess;

import java.util.List;

import org.eclipse.bpmn2.BaseElement;
import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.CallActivity;
import org.eclipse.bpmn2.CallableElement;
import org.eclipse.bpmn2.Definitions;
import org.eclipse.bpmn2.GlobalBusinessRuleTask;
import org.eclipse.bpmn2.GlobalManualTask;
import org.eclipse.bpmn2.GlobalScriptTask;
import org.eclipse.bpmn2.GlobalTask;
import org.eclipse.bpmn2.GlobalUserTask;
import org.eclipse.bpmn2.Process;
import org.eclipse.bpmn2.di.BPMNDiagram;
import org.eclipse.bpmn2.modeler.core.di.DIUtils;
import org.eclipse.bpmn2.modeler.core.features.ContextConstants;
import org.eclipse.bpmn2.modeler.core.features.DefaultResizeBPMNShapeFeature;
import org.eclipse.bpmn2.modeler.core.features.MultiUpdateFeature;
import org.eclipse.bpmn2.modeler.core.features.activity.AbstractCreateExpandableFlowNodeFeature;
import org.eclipse.bpmn2.modeler.core.features.activity.task.DirectEditTaskFeature;
import org.eclipse.bpmn2.modeler.core.utils.BusinessObjectUtil;
import org.eclipse.bpmn2.modeler.core.utils.GraphicsUtil;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.ui.ImageProvider;
import org.eclipse.bpmn2.modeler.ui.editor.BPMN2Editor;
import org.eclipse.bpmn2.modeler.ui.features.activity.DeleteActivityFeature;
import org.eclipse.bpmn2.modeler.ui.features.activity.subprocess.AddExpandableActivityFeature;
import org.eclipse.bpmn2.modeler.ui.features.activity.subprocess.CallActivityFeatureContainer;
import org.eclipse.bpmn2.modeler.ui.features.activity.subprocess.LayoutExpandableActivityFeature;
import org.eclipse.bpmn2.modeler.ui.features.choreography.ShowDiagramPageFeature;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.AbstractText;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Image;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeService;
import org.foxbpm.bpmn.designer.base.utils.EMFUtil;

public class FoxBPMCallActivityFeatureContainer extends CallActivityFeatureContainer {
	private static final int MARKER_OFFSET = 4;
	private static final String CALL_ACTIVITY_REF_PROPERTY = "call.activity.ref"; //$NON-NLS-1$
	private static final String GLOBAL_TASK_SHAPE_PROPERTY = "global.task.shape"; //$NON-NLS-1$

	@Override
	public ICreateFeature getCreateFeature(IFeatureProvider fp) {
		return new CreateCallActivityFeature(fp);
	}

	@Override
	public IAddFeature getAddFeature(IFeatureProvider fp) {
		return new AddExpandableActivityFeature<CallActivity>(fp) {
			@Override
			protected void decorateShape(IAddContext context, ContainerShape containerShape, CallActivity businessObject) {
				super.decorateShape(context, containerShape, businessObject);
				Graphiti.getPeService().setPropertyValue(containerShape, CALL_ACTIVITY_REF_PROPERTY,
						getCallableElementStringValue(businessObject.getCalledElementRef()));
				RoundedRectangle rect = (RoundedRectangle)getGraphicsAlgorithm(containerShape);
				rect.setLineWidth(4);
			}

			@Override
			protected int getMarkerContainerOffset() {
				return MARKER_OFFSET;
			}

			@Override
			public int getWidth() {
				return GraphicsUtil.getActivitySize(getDiagram()).getWidth();
			}

			@Override
			public int getHeight() {
				return GraphicsUtil.getActivitySize(getDiagram()).getHeight();
			}
		};
	}

	@Override
	public IDeleteFeature getDeleteFeature(IFeatureProvider fp) {
		return new DeleteActivityFeature(fp) {
			@Override
			public void delete(final IDeleteContext context) {
				PictogramElement pe = context.getPictogramElement();
				CallActivity callActivity = BusinessObjectUtil.getFirstElementOfType(pe, CallActivity.class);
				CallableElement calledActivity = callActivity.getCalledElementRef();
				// if there are no other references to this called element, delete it from the model
				boolean canDeleteCalledActivity = (calledActivity!=null);
				if (canDeleteCalledActivity) {
					Definitions definitions = ModelUtil.getDefinitions(callActivity);
					TreeIterator<EObject> iter = definitions.eAllContents();
					while (iter.hasNext() && canDeleteCalledActivity) {
						EObject o = iter.next();
						if (o!=callActivity && o instanceof BaseElement) {
							for (EObject cr : o.eCrossReferences()) {
								if (cr == calledActivity) {
									canDeleteCalledActivity = false;
									break;
								}
							}
						}
					}
				}
				
				super.delete(context);
				
				if (canDeleteCalledActivity) {
					// if the called activity is a Process, it may have its own
					// diagram page which needs to be removed as well.
					BPMNDiagram bpmnDiagram = DIUtils.findBPMNDiagram(calledActivity);
					if (bpmnDiagram != null) {
						DIUtils.deleteDiagram(getDiagramBehavior(), bpmnDiagram);
					}
					EcoreUtil.delete(calledActivity, true);
				}
			}
		};
	}

	@Override
	public ILayoutFeature getLayoutFeature(IFeatureProvider fp) {
		return new LayoutExpandableActivityFeature(fp) {
			protected int getMarkerContainerOffset() {
				return MARKER_OFFSET;
			}
			
			@Override
			protected boolean layoutHook(Shape shape, GraphicsAlgorithm ga, Object bo, int newWidth, int newHeight) {
				if (bo != null && ga instanceof AbstractText) {
					Graphiti.getGaService().setLocationAndSize(ga, 5, 5, newWidth - 10, newHeight);
					return true;
				}
				return false;
			}
			
		};
	}

	@Override
	public IUpdateFeature getUpdateFeature(IFeatureProvider fp) {
		IUpdateFeature updateFeature = super.getUpdateFeature(fp);
		MultiUpdateFeature multiUpdate;
		if (updateFeature instanceof MultiUpdateFeature)
			multiUpdate = (MultiUpdateFeature)updateFeature;
		else
			multiUpdate = new MultiUpdateFeature(fp);
		multiUpdate.addUpdateFeature(new UpdateCallActivityFeature(fp));
		return multiUpdate;
	}
	
	@Override
	public IResizeShapeFeature getResizeFeature(IFeatureProvider fp) {
		return new DefaultResizeBPMNShapeFeature(fp);
	}
	
	@Override
	public ICustomFeature[] getCustomFeatures(IFeatureProvider fp) {
		ICustomFeature[] superFeatures = super.getCustomFeatures(fp);
		ICustomFeature[] thisFeatures = new ICustomFeature[1 + superFeatures.length];
		thisFeatures[0] = new ShowDiagramPageFeature(fp);
		for (int superIndex=0, thisIndex=1; superIndex<superFeatures.length; ++superIndex) {
			thisFeatures[thisIndex++] = superFeatures[superIndex];
		}
		return thisFeatures;
	}

	public static class CreateCallActivityFeature extends AbstractCreateExpandableFlowNodeFeature<CallActivity> {
		protected Resource resource;
		// NOTE: Even though the Call Activity is an expandable figure, the contents for its "innards"
		// are (usually) defined somewhere else, so it doesn't make much sense to be able to expand it in the
		// same sense that a SubProcess would be expanded and rendered. When the "expand" button is clicked
		// we should probably locate the process where this thing is defined (if possible) and open an
		// editor to display its contents.
		
		public CreateCallActivityFeature(IFeatureProvider fp) {
			super(fp, "公有子流程", "创建一个公有子流程");
		}
		
		public CreateCallActivityFeature(IFeatureProvider fp, Resource resource, String name, String desc) {
			super(fp, name, desc);
			this.resource = resource;
		}

		@Override
		public String getStencilImageId() {
			return ImageProvider.IMG_16_CALL_ACTIVITY;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.bpmn2.modeler.core.features.AbstractCreateFlowElementFeature#getFlowElementClass()
		 */
		@Override
		public EClass getBusinessObjectClass() {
			return Bpmn2Package.eINSTANCE.getCallActivity();
		}

		@Override
		public CallActivity getBusinessObject(ICreateContext context) {
			if(resource!=null) {
				List<CallActivity> callActivities = EMFUtil.getAll(resource, CallActivity.class);
				if(callActivities != null && callActivities.size()>0) {
					CallActivity callActivity = EcoreUtil.copy(callActivities.get(0));
					callActivity.setId(null);
					Resource resource = ((BPMN2Editor)getDiagramEditor()).getResource();
					ModelUtil.setID(callActivity, resource);
					return callActivity;
				}
			}
			return super.getBusinessObject(context);
		}
	}

	private class UpdateCallActivityFeature extends AbstractUpdateFeature {

		public UpdateCallActivityFeature(IFeatureProvider fp) {
			super(fp);
		}

		@Override
		public boolean canUpdate(IUpdateContext context) {
			CallActivity callActivity = BusinessObjectUtil.getFirstElementOfType(context.getPictogramElement(),
					CallActivity.class);
			return callActivity != null && context.getPictogramElement() instanceof ContainerShape;
		}

		@Override
		public IReason updateNeeded(IUpdateContext context) {
			if (context.getProperty(ContextConstants.BUSINESS_OBJECT) instanceof EObject) {
				// if the UpdateContext has a "businessObject" property, then this update is needed
				// as part of the the CreateFeature ("businessObject" is only set in the CreateFeature)
				return Reason.createTrueReason("Initial update");
			}
			IPeService peService = Graphiti.getPeService();
			PictogramElement element = context.getPictogramElement();
			String property = peService.getPropertyValue(element, CALL_ACTIVITY_REF_PROPERTY);
			if (property == null) {
				return Reason.createFalseReason();
			}
			CallActivity callActivity = BusinessObjectUtil.getFirstElementOfType(context.getPictogramElement(),
					CallActivity.class);
			String value = getCallableElementStringValue(callActivity.getCalledElementRef());
			boolean changed = !value.equals(property);
			return changed ? Reason.createTrueReason() : Reason.createFalseReason();
		}

		@Override
		public boolean update(IUpdateContext context) {
			IPeService peService = Graphiti.getPeService();
			IGaService gaService = Graphiti.getGaService();

			ContainerShape container = (ContainerShape) context.getPictogramElement();
			CallActivity callActivity = BusinessObjectUtil.getFirstElementOfType(context.getPictogramElement(),
					CallActivity.class);

			Shape globalTaskShape = GraphicsUtil.getContainedShape(container, GLOBAL_TASK_SHAPE_PROPERTY);

			if (callActivity.getCalledElementRef() == null) {
				GraphicsUtil.hideActivityMarker(container, GraphicsUtil.ACTIVITY_MARKER_EXPAND);
				if (globalTaskShape != null) {
					peService.deletePictogramElement(globalTaskShape);
				}
			}

			else if (callActivity.getCalledElementRef() instanceof GlobalTask) {
				GraphicsUtil.hideActivityMarker(container, GraphicsUtil.ACTIVITY_MARKER_EXPAND);
				GlobalTask t = (GlobalTask) callActivity.getCalledElementRef();
				if (globalTaskShape == null) {
					globalTaskShape = peService.createShape(container, false);
					peService.setPropertyValue(globalTaskShape, GLOBAL_TASK_SHAPE_PROPERTY, Boolean.toString(true));
				}
				String imageId = getImageId(t);
				if (imageId != null) {
					Image image = gaService.createImage(globalTaskShape, imageId);
					gaService.setLocationAndSize(image, MARKER_OFFSET + 2, MARKER_OFFSET + 2, 16, 16);
				}
			}

			else if (callActivity.getCalledElementRef() instanceof Process) {
				if (globalTaskShape != null) {
					peService.deletePictogramElement(globalTaskShape);
				}
				GraphicsUtil.showActivityMarker(container, GraphicsUtil.ACTIVITY_MARKER_EXPAND);
			}

			peService.setPropertyValue(container, CALL_ACTIVITY_REF_PROPERTY,
					getCallableElementStringValue(callActivity.getCalledElementRef()));
			return true;
		}
	}

	private String getCallableElementStringValue(CallableElement element) {
		if (element == null) {
			return "null"; //$NON-NLS-1$
		}
		return element.getClass().getSimpleName();
	}

	private String getImageId(GlobalTask task) {
		if (task instanceof GlobalBusinessRuleTask) {
			return ImageProvider.IMG_16_BUSINESS_RULE_TASK;
		} else if (task instanceof GlobalManualTask) {
			return ImageProvider.IMG_16_MANUAL_TASK;
		} else if (task instanceof GlobalScriptTask) {
			return ImageProvider.IMG_16_SCRIPT_TASK;
		} else if (task instanceof GlobalUserTask) {
			return ImageProvider.IMG_16_USER_TASK;
		} else {
			return null;
		}
	}

	@Override
	public IDirectEditingFeature getDirectEditingFeature(IFeatureProvider fp) {
		return new DirectEditTaskFeature(fp);
	}
}
