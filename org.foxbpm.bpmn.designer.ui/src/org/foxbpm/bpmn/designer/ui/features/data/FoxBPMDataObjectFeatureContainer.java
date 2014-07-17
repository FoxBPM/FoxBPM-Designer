package org.foxbpm.bpmn.designer.ui.features.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.DataObject;
import org.eclipse.bpmn2.DataObjectReference;
import org.eclipse.bpmn2.FlowElement;
import org.eclipse.bpmn2.modeler.core.ModelHandler;
import org.eclipse.bpmn2.modeler.core.features.AbstractCreateFlowElementFeature;
import org.eclipse.bpmn2.modeler.core.features.MultiUpdateFeature;
import org.eclipse.bpmn2.modeler.core.features.data.AddDataFeature;
import org.eclipse.bpmn2.modeler.core.features.label.UpdateLabelFeature;
import org.eclipse.bpmn2.modeler.core.model.Bpmn2ModelerFactory;
import org.eclipse.bpmn2.modeler.core.utils.FeatureSupport;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.ui.Activator;
import org.eclipse.bpmn2.modeler.ui.ImageProvider;
import org.eclipse.bpmn2.modeler.ui.features.data.DataObjectFeatureContainer;
import org.eclipse.bpmn2.modeler.ui.features.data.Messages;
import org.eclipse.bpmn2.modeler.ui.features.data.UpdateDataObjectFeature;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.ui.internal.util.ui.PopupMenu;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class FoxBPMDataObjectFeatureContainer extends DataObjectFeatureContainer {
	@Override
	public ICreateFeature getCreateFeature(IFeatureProvider fp) {
		return new CreateDataObjectFeature(fp);
	}

	@Override
	public IAddFeature getAddFeature(IFeatureProvider fp) {
		return new AddDataObjectFeature(fp);
	}

	@Override
	public IUpdateFeature getUpdateFeature(IFeatureProvider fp) {
		MultiUpdateFeature multiUpdate = new MultiUpdateFeature(fp);
		multiUpdate.addUpdateFeature(new UpdateDataObjectFeature(fp));
		multiUpdate.addUpdateFeature(new UpdateLabelFeature(fp));
		return multiUpdate;
	}

	public class AddDataObjectFeature extends AddDataFeature<DataObject> {
		public AddDataObjectFeature(IFeatureProvider fp) {
			super(fp);
		}

		@Override
		public String getName(DataObject t) {
			return t.getName();
		}
	}

	public static class CreateDataObjectFeature extends AbstractCreateFlowElementFeature<FlowElement> {
		protected Resource resource;
		
		private static ILabelProvider labelProvider = new ILabelProvider() {

			public void removeListener(ILabelProviderListener listener) {
			}

			public boolean isLabelProperty(Object element, String property) {
				return false;
			}

			public void dispose() {

			}

			public void addListener(ILabelProviderListener listener) {

			}

			public String getText(Object element) {
				if (((DataObject) element).getId() == null)
					return ((DataObject) element).getName();
				return NLS.bind(Messages.DataObjectFeatureContainer_Ref, ((DataObject) element).getName());
			}

			public Image getImage(Object element) {
				return null;
			}

		};

		public CreateDataObjectFeature(IFeatureProvider fp) {
			super(fp, "数据对象", "创建一个数据对象");
		}
		
		public CreateDataObjectFeature(IFeatureProvider fp, Resource resource, String name, String desc) {
			super(fp, name, desc);
			this.resource = resource;
		}

		@Override
		public boolean canCreate(ICreateContext context) {
			return FeatureSupport.isValidDataTarget(context);
		}

		@Override
		public String getStencilImageId() {
			return ImageProvider.IMG_16_DATA_OBJECT;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.bpmn2.modeler.core.features.AbstractCreateFlowElementFeature#getFlowElementClass()
		 */
		@Override
		public EClass getBusinessObjectClass() {
			return Bpmn2Package.eINSTANCE.getDataObject();
		}

		@Override
		public FlowElement createBusinessObject(ICreateContext context) {
			changesDone = true;
			FlowElement bo = null;
			try {
				DataObjectReference dataObjectReference = null;
				DataObject dataObject = null;
				ModelHandler mh = ModelHandler.getInstance(getDiagram());
				dataObjectReference = Bpmn2ModelerFactory.create(DataObjectReference.class);
				dataObject = Bpmn2ModelerFactory.create(DataObject.class);
				String oldName = dataObject.getName();
				dataObject.setName(Messages.DataObjectFeatureContainer_New);
				dataObject.setId(null);
				EObject targetBusinessObject = (EObject)getBusinessObjectForPictogramElement(context.getTargetContainer());
				
				// NOTE: this code removed. A DataObjectReference may reference DataObjects
				// from any other container (Process) in the BPMN file, not just those defined
				// within the same container as the target (context.getTargetContainer())
//				Object containerBO = container;
//				if (container instanceof BPMNDiagram) {
//					containerBO = ((BPMNDiagram)container).getPlane().getBpmnElement();
//				}
//				if (container instanceof Lane) {
//					EObject laneSet = ((Lane)container).eContainer();
//					if (laneSet instanceof LaneSet)
//						containerBO = laneSet.eContainer();
//				}

				List<DataObject> dataObjectList = new ArrayList<DataObject>();
				dataObjectList.add(dataObject);
				TreeIterator<EObject> iter = ModelUtil.getDefinitions(targetBusinessObject).eAllContents();
				while (iter.hasNext()) {
					EObject obj = iter.next();
					if (obj instanceof DataObject) // removed, see above: && obj.eContainer() == containerBO)
						dataObjectList.add((DataObject) obj);
				}

				DataObject result = dataObject;
				if (dataObjectList.size() > 1) {
					PopupMenu popupMenu = new PopupMenu(dataObjectList, labelProvider);
					changesDone = popupMenu.show(Display.getCurrent().getActiveShell());
					if (changesDone) {
						result = (DataObject) popupMenu.getResult();
					}
					else {
						EcoreUtil.delete(dataObject);
						EcoreUtil.delete(dataObjectReference);
					}
				}
				if (changesDone) {
					if (result == dataObject) { // the new one
						mh.addFlowElement(targetBusinessObject,dataObject);
						ModelUtil.setID(dataObject);
						dataObject.setIsCollection(false);
						dataObject.setName(oldName);
						bo = dataObject;
					} else {
						mh.addFlowElement(targetBusinessObject,dataObjectReference);
						ModelUtil.setID(dataObjectReference);
						dataObjectReference.setName(
							NLS.bind(
								Messages.DataObjectFeatureContainer_Default_Name,
								result.getName()
							)
						);
						dataObjectReference.setDataObjectRef(result);
						dataObject = result;
						bo = dataObjectReference;
					}
					putBusinessObject(context, bo);
				}

			} catch (IOException e) {
				Activator.showErrorWithLogging(e);
			}
			return bo;
		}
	}
}
