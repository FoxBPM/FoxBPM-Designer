package org.foxbpm.bpmn.designer.ui.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.eclipse.core.internal.resources.Project;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.IWorkbenchAdapter;
import org.foxbpm.bpmn.designer.base.utils.FoxBPMDesignerUtil;
import org.foxbpm.model.config.foxbpmconfig.ResourcePath;

public class ProjectContentProvider extends BaseWorkbenchContentProvider {

	@Override
	public boolean hasChildren(Object element) {
		return false;
	}

	@Override
	public Object[] getElements(Object element) {
		HashSet<String> hashSet = new HashSet<String>();
		for (ResourcePath resourcePath : FoxBPMDesignerUtil.getFoxBPMConfig().getResourcePathConfig().getResourcePath()) {
			hashSet.add(resourcePath.getProjectName());
		}
		  IWorkbenchAdapter adapter = getAdapter(element);
	        if (adapter != null) {
	        	List<Object> projects = Arrays.asList(adapter.getChildren(element));
	        	List<Object> operlist = new ArrayList<Object>();
	        	for (Object object : projects) {
					if(((Project)object).isOpen() && hashSet.contains(((Project)object).getName())) {
						operlist.add(object);
					}
				}
	            return operlist.toArray();
	        }
	        return new Object[0];
	}

}
