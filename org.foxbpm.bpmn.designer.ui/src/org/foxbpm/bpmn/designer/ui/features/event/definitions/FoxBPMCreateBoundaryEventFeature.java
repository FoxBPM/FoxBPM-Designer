/******************************************************************************* 
 * Copyright (c) 2011, 2012 Red Hat, Inc. 
 *  All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation 
 *
 * @author Innar Made
 ******************************************************************************/
package org.foxbpm.bpmn.designer.ui.features.event.definitions;

import java.io.IOException;
import java.util.List;

import org.eclipse.bpmn2.Activity;
import org.eclipse.bpmn2.BoundaryEvent;
import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.FlowNode;
import org.eclipse.bpmn2.SubProcess;
import org.eclipse.bpmn2.modeler.core.Activator;
import org.eclipse.bpmn2.modeler.core.ModelHandler;
import org.eclipse.bpmn2.modeler.core.features.AbstractBpmn2CreateFeature;
import org.eclipse.bpmn2.modeler.core.utils.BoundaryEventPositionHelper;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.ui.ImageProvider;
import org.eclipse.bpmn2.modeler.ui.editor.BPMN2Editor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.foxbpm.bpmn.designer.base.utils.EMFUtil;

public class FoxBPMCreateBoundaryEventFeature extends AbstractBpmn2CreateFeature<BoundaryEvent> {
	protected Resource resource;
	
	public FoxBPMCreateBoundaryEventFeature(IFeatureProvider fp) {
		super(fp, "边界事件", "创建一个边界事件");
	}

	public FoxBPMCreateBoundaryEventFeature(IFeatureProvider fp, Resource resource, String name, String desc) {
		super(fp, name, desc);
		this.resource = resource;
	}
	
	@Override
	public boolean canCreate(ICreateContext context) {
		Object o = getBusinessObjectForPictogramElement(context.getTargetContainer());
		if (o == null || !(o instanceof Activity)) {
			return false;
		}

		GraphicsAlgorithm ga = context.getTargetContainer().getGraphicsAlgorithm();
		return BoundaryEventPositionHelper.canCreateEventAt(context, ga, 10);
	}

	@Override
	public Object[] create(ICreateContext context) {
		BoundaryEvent event = createBusinessObject(context);
		PictogramElement pe = addGraphicalRepresentation(context, event);
		return new Object[] { event, pe };
	}
	
	@Override
	public BoundaryEvent createBusinessObject(ICreateContext context) {
		BoundaryEvent event = null;
		try {
			Activity activity = (Activity) getBusinessObjectForPictogramElement(context.getTargetContainer());
			ModelHandler handler = ModelHandler.getInstance(getDiagram());
			event = super.createBusinessObject(context);
			event.setAttachedToRef(activity);
			event.setName(""); //$NON-NLS-1$
			event.setCancelActivity(true); // by default is interrupting
			Object bo = getBusinessObjectForPictogramElement(context.getTargetContainer());
			
			if (bo instanceof FlowNode &&  !((FlowNode)bo).getLanes().isEmpty()) {
				((FlowNode)bo).getLanes().get(0).getFlowNodeRefs().add(event);
			}
			
			if (bo instanceof SubProcess) {
				bo = getBusinessObjectForPictogramElement((PictogramElement) context.getTargetContainer().eContainer());
			}
			
			handler.addFlowElement(bo, event);
			ModelUtil.setID(event);
		
		} catch (IOException e) {
			Activator.logError(e);
		}
		return event;
	}

	@Override
	public String getCreateImageId() {
		return ImageProvider.IMG_16_BOUNDARY_EVENT;
	}

	@Override
	public String getCreateLargeImageId() {
		return getCreateImageId();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpmn2.modeler.core.features.AbstractBpmn2CreateFeature#getBusinessObjectClass()
	 */
	@Override
	public EClass getBusinessObjectClass() {
		return Bpmn2Package.eINSTANCE.getBoundaryEvent();
	}

	@Override
	public BoundaryEvent getBusinessObject(ICreateContext context) {
		if(resource != null) {
			List<BoundaryEvent> boundaryEvents = EMFUtil.getAll(resource, BoundaryEvent.class);
			if(boundaryEvents != null && boundaryEvents.size()>0) {
				BoundaryEvent boundaryEvent = EcoreUtil.copy(boundaryEvents.get(0));
				boundaryEvent.setId(null);
				Resource resource = ((BPMN2Editor)getDiagramEditor()).getResource();
				ModelUtil.setID(boundaryEvent, resource);
				return boundaryEvent;
			}
		}
		return super.getBusinessObject(context);
	}
}