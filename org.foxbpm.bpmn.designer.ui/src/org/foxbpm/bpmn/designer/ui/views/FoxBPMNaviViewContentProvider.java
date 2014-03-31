package org.foxbpm.bpmn.designer.ui.views;

import java.io.File;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;

public class FoxBPMNaviViewContentProvider implements ICommonContentProvider {

	@Override
	public Object[] getElements(Object inputElement) {
		IWorkspaceRoot iWorkspaceRoot = (IWorkspaceRoot) inputElement;
		return new File(iWorkspaceRoot.getLocation().toOSString()).listFiles();
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		File file = (File) parentElement;
		return file.listFiles();
	}

	@Override
	public Object getParent(Object element) {
		if(element instanceof IWorkspaceRoot) {
			return element;
		}
		File file = (File) element;
		return file.getParentFile();
	}

	@Override
	public boolean hasChildren(Object element) {
		File file = (File) element;
		return file.isDirectory()?true:false;
	}

	@Override
	public void dispose() {

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

	@Override
	public void restoreState(IMemento aMemento) {

	}

	@Override
	public void saveState(IMemento aMemento) {

	}

	@Override
	public void init(ICommonContentExtensionSite aConfig) {

	}

}
