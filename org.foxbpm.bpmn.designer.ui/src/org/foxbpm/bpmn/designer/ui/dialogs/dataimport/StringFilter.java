package org.foxbpm.bpmn.designer.ui.dialogs.dataimport;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class StringFilter extends ViewerFilter {
	private String searchString;

	public void setSearchText(String s) {
		// Search must be a substring of the existing value
		this.searchString = s + ".*";
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (searchString == null || searchString.length() == 0) {
			return true;
		}
		String str = element.toString();
		if (str.matches(searchString) || str.matches(searchString.toUpperCase())) {
			return true;
		}
		return false;
	}

}
