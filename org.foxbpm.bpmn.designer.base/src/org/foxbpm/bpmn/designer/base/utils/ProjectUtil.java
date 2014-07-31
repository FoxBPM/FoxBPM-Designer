/**
 * Copyright 1996-2014 FoxBPM ORG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * @author MAENLIANG
 */
package org.foxbpm.bpmn.designer.base.utils;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

/**
 * 插件项目工具类
 * 
 * @author MAENLIANG
 * 
 */
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
