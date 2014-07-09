package org.foxbpm.bpmn.designer.ui.propertytab.variable;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.foxbpm.model.bpmn.foxbpm.DataVariable;

public class DataVariableTreeViewerFilter extends ViewerFilter {
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
		
		DataVariable dataVariable = (DataVariable) element;
		String str = dataVariable.getId();
		if (str.matches(searchString) || str.matches(searchString.toUpperCase())) {
			return true;
		}
		return false;
	}
}
