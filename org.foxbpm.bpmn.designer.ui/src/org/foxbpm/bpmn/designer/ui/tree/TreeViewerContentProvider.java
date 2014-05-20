package org.foxbpm.bpmn.designer.ui.tree;

import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class TreeViewerContentProvider implements ITreeContentProvider {

	/**
	 * 
	 */
	public TreeViewerContentProvider() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface
	 * .viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.
	 * Object)
	 */
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof List) {
			List<ITreeElement> list = (List<ITreeElement>) inputElement;
			if (list != null && list.size() > 0) {
				return list.toArray();
			}
		} else {
			return new Object[0];
		}
		return new Object[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.
	 * Object)
	 */
	public Object[] getChildren(Object parentElement) {
		ITreeElement tElement = (ITreeElement) parentElement;
		List<ITreeElement> list = tElement.getChildren();
		if (list != null && list.size() > 0) {
			return list.toArray();
		}
		return new Object[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object
	 * )
	 */
	public Object getParent(Object element) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.
	 * Object)
	 */
	public boolean hasChildren(Object element) {
		ITreeElement tElement = (ITreeElement) element;
		List<ITreeElement> list = tElement.getChildren();
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

}
