package org.foxbpm.bpmn.designer.ui.views;

import java.io.File;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.navigator.IDescriptionProvider;
import org.foxbpm.bpmn.designer.ui.utils.ImageUtil;

public class FoxBPMNaviViewLabelProvider implements ILabelProvider, IDescriptionProvider {

	@Override
	public void addListener(ILabelProviderListener listener) {

	}

	@Override
	public void dispose() {

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {

	}

	@Override
	public String getDescription(Object anElement) {
		if(anElement instanceof File) {
			File file = (File) anElement;
			return file.getAbsolutePath();
		}
		return null;
	}

	@Override
	public Image getImage(Object element) {
		return ImageUtil.getImageFromName("/fox_16.ico");
	}

	@Override
	public String getText(Object element) {
		if(element instanceof File) {
			File file = (File) element;
			return file.getName();
		}
		return null;
	}

}
