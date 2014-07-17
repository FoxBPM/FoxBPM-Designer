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
package org.foxbpm.bpmn.designer.ui.features.artifact;

import java.util.List;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.TextAnnotation;
import org.eclipse.bpmn2.modeler.core.features.artifact.AbstractCreateArtifactFeature;
import org.eclipse.bpmn2.modeler.core.utils.FeatureSupport;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.ui.ImageProvider;
import org.eclipse.bpmn2.modeler.ui.editor.BPMN2Editor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.foxbpm.bpmn.designer.base.utils.EMFUtil;

public class FoxBPMCreateTextAnnotationFeature extends AbstractCreateArtifactFeature<TextAnnotation> {
	protected Resource resource;
	
	public FoxBPMCreateTextAnnotationFeature(IFeatureProvider fp) {
		super(fp, "备注", "创建一个备注");
	}
	
	public FoxBPMCreateTextAnnotationFeature(IFeatureProvider fp, Resource resource, String name, String desc) {
		super(fp, name, desc);
		this.resource = resource;
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		return FeatureSupport.isValidArtifactTarget(context);
	}

	@Override
	public Object[] create(ICreateContext context) {

		TextAnnotation ta = createBusinessObject(context);
		addGraphicalRepresentation(context, ta);

		return new Object[] { ta };
	}

	@Override
	protected String getStencilImageId() {
		return ImageProvider.IMG_16_TEXT_ANNOTATION;
	}

	@Override
	public String getCreateImageId() {
		return ImageProvider.IMG_16_TEXT_ANNOTATION;
	}

	@Override
	public String getCreateLargeImageId() {
		return getCreateImageId(); // FIXME
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpmn2.modeler.core.features.AbstractBpmn2CreateFeature#getBusinessObjectClass()
	 */
	@Override
	public EClass getBusinessObjectClass() {
		return Bpmn2Package.eINSTANCE.getTextAnnotation();
	}

	@Override
	public TextAnnotation getBusinessObject(ICreateContext context) {
		if(resource!=null) {
			List<TextAnnotation> textAnnotations = EMFUtil.getAll(resource, TextAnnotation.class);
			if(textAnnotations != null && textAnnotations.size()>0) {
				TextAnnotation textAnnotation = EcoreUtil.copy(textAnnotations.get(0));
				textAnnotation.setId(null);
				Resource resource = ((BPMN2Editor)getDiagramEditor()).getResource();
				ModelUtil.setID(textAnnotation, resource);
				return textAnnotation;
			}
		}
		return super.getBusinessObject(context);
	}
}
