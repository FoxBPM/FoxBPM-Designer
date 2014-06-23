package org.foxbpm.bpmn.designer.ui.tree;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.ui.PlatformUI;
import org.foxbpm.bpmn.designer.ui.utils.DefinitionConnectorUtil;
import org.foxbpm.bpmn.designer.ui.utils.ImageUtil;
import org.foxbpm.model.config.foxbpmconfig.ResourcePath;

public class ActorTreeViewerLabelProvider extends StyledCellLabelProvider implements ILabelProvider {
	private ResourcePath resourcePath;
	/**
	 * 
	 */
	public ActorTreeViewerLabelProvider() {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void addListener(ILabelProviderListener listener) {

	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	public void dispose() {

	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
	 */
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void removeListener(ILabelProviderListener listener) {

	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
	 */
	public Image getImage(Object element) {
		Image image = null;
		ITreeElement tElement = (ITreeElement) element;
		try {
			String imagePath = resourcePath==null?tElement.getIcon():DefinitionConnectorUtil.getActorConnectorIconPath(resourcePath) + "/" + tElement.getIcon(); // 要读取的图片文件的路径
			return new Image(PlatformUI.getWorkbench().getDisplay(),
					new ImageData(imagePath).scaledTo(16, 16));
		} catch (Exception e) {
//			e.printStackTrace();
			image = ImageUtil.getImageFromName("/connector/category.png");
		}
		return image;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
	 */
	public String getText(Object element) {
		ITreeElement tElement = (ITreeElement) element;
		return tElement.getName();
	}

	@Override
	public void update(ViewerCell cell) {
		if (cell.getElement() instanceof EntityElement) {
			EntityElement e = (EntityElement) cell.getElement();
			StyledString styledString = new StyledString();
			String decoration = " -- " + e.getRealPath();
			styledString.append(e.getName());
			if(!(e.getRealPath().equals(""))) {
				styledString.append(decoration, StyledString.DECORATIONS_STYLER);
			}
			cell.setText(styledString.getString());
			cell.setImage(getImage(e)) ;
			cell.setStyleRanges(styledString.getStyleRanges());
		}
	}

	public ResourcePath getResourcePath() {
		return resourcePath;
	}

	public void setResourcePath(ResourcePath resourcePath) {
		this.resourcePath = resourcePath;
	}

}
