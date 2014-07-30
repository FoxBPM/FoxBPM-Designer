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

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig;
import org.foxbpm.model.config.foxbpmconfig.ResourcePath;
import org.foxbpm.model.config.foxbpmconfig.ResourcePathConfig;

/**
 * 系统配置文件工具类
 * 
 * @author MAENLIANG
 * 
 */
public class FoxBPMConfigUtil {
	
	public static String FIXFLOW_REPOSITORY_FLOW_TEMPLATE = "foxbpmflow-template";
	public static String SYSTEM_TEMPLATE = "system-template";
	public static String CONNECTOR_PATH = "connector-path";
	
	public static String FLOWCONFIGPROJECT = getPathFromConfFile("projectName");
	
	public static FoxBPMConfig foxBPMConfig;
	
	private final static String FOXBPM_CONFIG_FILE = "/foxbpm.cfg.xml";
	
	/**
	 * 得到FixFlowXML所存放的路径
	 * 
	 * @return
	 */
	public static String getFoxBPMConfigXMLPath() {
		return "C:/Users/hp-/git/FoxBPM/modules/foxbpm-engine/" + getPathFromConfFile("configPath")
		        + FOXBPM_CONFIG_FILE;
	}
	
	/**
	 * 加载所有的FoxBPMConfig配置信息
	 * 
	 * @return
	 */
	public static FoxBPMConfig getFoxBPMConfig() {
		if (foxBPMConfig == null) {
			foxBPMConfig = EMFUtil.getFoxBPMConfig(getFoxBPMConfigXMLPath());
		}
		return foxBPMConfig;
	}
	
	/**
	 * 获取资源路径配置对象
	 * 
	 * @return
	 */
	public static ResourcePathConfig getResourcePathConfig() {
		return getFoxBPMConfig().getResourcePathConfig();
	}
	
	/**
	 * 获取资源路径列表
	 * 
	 * @return
	 */
	public static List<ResourcePath> getResourcePathList() {
		return getFoxBPMConfig().getResourcePathConfig().getResourcePath();
	}
	
	/**
	 * 获取对应resourceId的路径
	 * 
	 * @param resourceId
	 * @return
	 */
	public static String getResourcePath(String resourceId) {
		String path = "";
		for (ResourcePath resourcePath : getResourcePathConfig().getResourcePath()) {
			if (resourcePath.getId().equals(resourceId)) {
				path = "C:/Users/hp-/git/FoxBPM/modules/foxbpm-engine/"
				        + (resourcePath.getVirtualPath());
				break;
			}
		}
		return path;
	}
	
	public static ResourcePath getResourcePathObj(String resourceId) {
		for (ResourcePath resourcePath : getResourcePathConfig().getResourcePath()) {
			if (resourcePath.getId().equals(resourceId)) {
				return resourcePath;
			}
		}
		return null;
	}
	
	public static String getSystemTemplate() {
		
		ResourcePath resourcePath = getResourcePathObj(SYSTEM_TEMPLATE);
		
		String path = ProjectUtil.getProjectPath(resourcePath.getProjectName()) + "/"
		        + resourcePath.getVirtualPath();
		
		return path;
	}
	
	public static String getFlowTemplate() {
		
		ResourcePath resourcePath = getResourcePathObj(FIXFLOW_REPOSITORY_FLOW_TEMPLATE);
		
		String path = "C:/Users/hp-/git/FoxBPM/modules/foxbpm-engine/"
		        + resourcePath.getVirtualPath();
		
		return path;
	}
	
	public static String getDataVariableConfigFilePath() {
		
		ResourcePath resourcePath = getResourcePathObj("dataVariableConfig");
		
		String path = ProjectUtil.getProjectPath(resourcePath.getProjectName()) + "/"
		        + resourcePath.getVirtualPath();
		
		return path;
	}
	
	public static String getDataVariableConfigFileProjectName() {
		
		ResourcePath resourcePath = getResourcePathObj("dataVariableConfig");
		
		return resourcePath.getProjectName();
	}
	
	public static String getFixflowNoneFilePath() {
		
		ResourcePath resourcePath = getResourcePathObj("fixflowfile");
		
		String path = ProjectUtil.getProjectPath(resourcePath.getProjectName()) + "/"
		        + resourcePath.getVirtualPath();
		
		return path;
	}
	
	public static String getGroovyFilePath() {
		
		ResourcePath resourcePath = getResourcePathObj("groovyFile");
		
		String path = ProjectUtil.getProjectPath(resourcePath.getProjectName()) + "/"
		        + resourcePath.getVirtualPath();
		
		return path;
	}
	
	public static String getGroovyVirtualPath() {
		
		ResourcePath resourcePath = getResourcePathObj("groovyFile");
		
		return resourcePath.getVirtualPath();
		
	}
	
	public static String getGroovyFileProjectName() {
		
		ResourcePath resourcePath = getResourcePathObj("groovyFile");
		
		return resourcePath.getProjectName();
	}
	
	public static String getQuartzFilePath() {
		
		ResourcePath resourcePath = getResourcePathObj("quartz");
		
		String path = ProjectUtil.getProjectPath(resourcePath.getProjectName()) + "/"
		        + resourcePath.getVirtualPath();
		
		return path;
	}
	
	public static String getStyleFilePath() {
		
		ResourcePath resourcePath = getResourcePathObj("style");
		
		String path = ProjectUtil.getProjectPath(resourcePath.getProjectName()) + "/"
		        + resourcePath.getVirtualPath();
		
		return path;
	}
	
	public static String getStyleFileProjectName() {
		
		ResourcePath resourcePath = getResourcePathObj("style");
		
		return resourcePath.getProjectName();
	}
	
	public static String getInternationalizationPath() {
		
		ResourcePath resourcePath = getResourcePathObj("internationalization");
		
		String path = ProjectUtil.getProjectPath(resourcePath.getProjectName()) + "/"
		        + resourcePath.getVirtualPath();
		
		return path;
	}
	
	public static String getInternationalizationProjectName() {
		
		ResourcePath resourcePath = getResourcePathObj("internationalization");
		
		return resourcePath.getProjectName();
	}
	
	public static String getFixflowDiagramPath() {
		
		ResourcePath resourcePath = getResourcePathObj("fixflowdiagram");
		
		String path = ProjectUtil.getProjectPath(resourcePath.getProjectName()) + "/"
		        + resourcePath.getVirtualPath();
		
		return path;
	}
	
	public static String getFixflowDiagramProjectName() {
		
		ResourcePath resourcePath = getResourcePathObj("fixflowdiagram");
		
		return resourcePath.getProjectName();
	}
	
	/**
	 * 从设计器根目录配置文件中读取对应的属性
	 * 
	 * @return
	 */
	public static String getPathFromConfFile(String key) {
		String proFilePath = Platform.getInstallLocation().getURL().getPath().toString()
		        + "conf.properties";
		File file = new File(proFilePath);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			PropertiesUtil.writeProperties(file.getAbsolutePath(), "projectName", "foxbpm-engine");
			PropertiesUtil.writeProperties(file.getAbsolutePath(), "configPath", "/src/main/resources/config");
		}
		return PropertiesUtil.readValue(proFilePath, key);
	}
	
}
