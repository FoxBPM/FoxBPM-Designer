package org.foxbpm.bpmn.designer.ui.connector.runtime;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.foxbpm.bpmn.designer.ui.tree.ITreeElement;


public class ConnectorFilter extends ViewerFilter {
	
	private String searchString;

	/**
	 * 
	 */
	public ConnectorFilter() {
	}
	
	public void setSearchText(String s) {
		// Search must be a substring of the existing value
		this.searchString = ".*" + s + ".*";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (searchString == null || searchString.length() == 0) {
			return true;
		}
		
		ITreeElement parent = (ITreeElement) element;
		List<ITreeElement> children = parent.getChildren();
		
		if(children != null && children.size() > 0) {
			for (Iterator iterator = children.iterator(); iterator.hasNext();) {
				ITreeElement iTreeElement = (ITreeElement) iterator.next();
				//递归去找子节点
				if(select(viewer, parent, iTreeElement)) {
					return true;
				}
			}
		} else {
			if (parent.getId().matches(searchString)
					|| parent.getId().matches(searchString.toUpperCase())) {
				return true;
			}
			if (parent.getName().matches(searchString)
					|| parent.getName().matches(searchString.toUpperCase())) {
				return true;
			}
		}
		
		return false;
	}

}
