package org.foxbpm.bpmn.designer.ui.utils;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

public class ProjectUtil {


	

	/**
	 * 获取指定项目路径
	 * 
	 * @return 项目所在路径(不包括最后的/)
	 */
	public static String getProjectPath(String projectName) {
		return ResourcesPlugin.getWorkspace().getRoot().getProject(projectName).getLocation().toString();
	}

	

	/**
	 * 刷新工程
	 * 
	 * @param projectName
	 */
	public static void refreshProject(String projectName) {
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IProject myProject = workspaceRoot.getProject(projectName);

		try {
			myProject.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

}
