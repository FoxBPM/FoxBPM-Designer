package org.foxbpm.bpmn.designer.base.utils;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.foxbpm.bpmn.designer.base.utils.PropertiesUtil;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;
import org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig;
import org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigFactory;
import org.foxbpm.model.config.foxbpmconfig.ResourcePath;
import org.foxbpm.model.config.foxbpmconfig.ResourcePathConfig;

public class FoxBPMConfigUtil {
	
	
	
	public static String FIXFLOW_REPOSITORY_ROOT="fixflow-repository-root";
	public static String FIXFLOW_REPOSITORY_FLOW_TEMPLATE="fixflow-repository-flow-template";
	public static String FIXFLOW_REPOSITORY_NODE_TEMPLATE="fixflow-repository-node-template";
	public static String SYSTEM_TEMPLATE="system-template";
	public static String CONNECTOR_PATH="connector-path";
	public static String FIXFLOW_EDITOR_PUBLIC_REPOSITORY="fixflow-editor-public-repository";
	public static String FIXFLOW_EDITOR_PRIVATE_REPOSITORY="fixflow-editor-private-repository";
	
//	public static String FLOWCONFIGPROJECT=getPathFromConfFile("projectName");
	
	
//	public static FixFlowConfig fixFlowConfig;


	/**
	 * 加载所有的fixflowconfig配置信息
	 * 
	 * @return
	 */
	public static FoxBPMConfig getFoxBPMConfig() {
		FoxBPMConfig foxBPMConfig = FoxBPMConfigFactory.eINSTANCE.createFoxBPMConfig();
		
		ResourcePathConfig resourcePathConfig = FoxBPMConfigFactory.eINSTANCE.createResourcePathConfig();
		
		ResourcePath resourcePath = FoxBPMConfigFactory.eINSTANCE.createResourcePath();
		resourcePath.setId("");
		resourcePath.setName("");
		resourcePath.setPhysicalPath("");
		resourcePath.setVirtualPath("");
		resourcePath.setProjectName("");
		resourcePath.setVirtualPath("");
		
		resourcePathConfig.getResourcePath().add(resourcePath);
		foxBPMConfig.setResourcePathConfig(resourcePathConfig);
		return foxBPMConfig;
		/*
		 * 
		 * // 读取Menu的xml if (fixFlowConfig == null) { XMIResource resource =
		 * (XMIResource) new
		 * ResourceSetImpl().getResource(URI.createFileURI(getFixFlowConfigXMLPath
		 * ()), true); fixFlowConfig = (FixFlowConfig)
		 * resource.getContents().get(0); } return fixFlowConfig;
		 */
	}

//	/**
//	 * 得到FixFlowXML所存放的路径
//	 * 
//	 * @return
//	 */
//	public static String getFixFlowConfigXMLPath() {
//		return ProjectUtil.getProjectPath(FLOWCONFIGPROJECT) + getPathFromConfFile("configPath") + "/fixflowconfig.xml";
//	}
//
//	/**
//	 * 加载所有的fixflowconfig配置信息
//	 * 
//	 * @return
//	 */
//	public static FixFlowConfig getFixFlowConfig() {
//		if (fixFlowConfig == null) {
//			
//
//			fixFlowConfig = EMFUtil.getFixFlowConfig(getFixFlowConfigXMLPath());
//		}
//		return fixFlowConfig;
//		/*
//		 * 
//		 * // 读取Menu的xml if (fixFlowConfig == null) { XMIResource resource =
//		 * (XMIResource) new
//		 * ResourceSetImpl().getResource(URI.createFileURI(getFixFlowConfigXMLPath
//		 * ()), true); fixFlowConfig = (FixFlowConfig)
//		 * resource.getContents().get(0); } return fixFlowConfig;
//		 */
//	}
//
//	/**
//	 * 设置流程引擎所使用的数据库
//	 * 
//	 * @param id
//	 *            编号("FixBPMCS")
//	 * @param name
//	 *            名称
//	 * @param driverClassName
//	 *            驱动名称
//	 * @param url
//	 *            地址
//	 * @param userName
//	 *            用户名
//	 * @param passWord
//	 *            密码
//	 * @param maxActive
//	 *            最大活动连接数
//	 * @param maxIdle
//	 *            最大闲置连接数
//	 * @param maxWait
//	 *            最大等待时间
//	 * @param dbType
//	 *            数据库类型(oracle、sqlserver、mysql、db2)
//	 */
//	public static void modifyFixFlowDataBaseConfig(String id, String name,
//			String driverClassName, String url, String userName,
//			String passWord, String maxActive, String maxIdle, String maxWait,
//			String dbType) {
//
//		FixFlowConfig fixFlowConfig = getFixFlowConfig();
//		fixFlowConfig.getDataBaseConfig().getDataBase();
//		for (DataBase dataBase : fixFlowConfig.getDataBaseConfig()
//				.getDataBase()) {
//			if (dataBase.getId().trim().equals(name)) {
//
//				// dataBase.setId(dataBase.getId().trim());
//				dataBase.setName(name);
//				dataBase.setDriverClassName(driverClassName);
//				dataBase.setUrl(url);
//				dataBase.setUsername(userName);
//				dataBase.setPassword(passWord);
//				dataBase.setMaxActive(maxActive);
//				dataBase.setMaxIdle(maxIdle);
//				dataBase.setMaxWait(maxWait);
//				dataBase.setDbtype(DBType.getByName(dbType));
//				if (dbType.trim().equals("oracle")) {
//					dataBase.setPaginationImpl("com.founder.fix.fixflow.expand.database.pagination.OraclePaginationImpl");
//				} 
//				if (dbType.trim().equals("sqlserver")) {
//					dataBase.setPaginationImpl("com.founder.fix.fixflow.expand.database.pagination.SqlServerPaginationImpl");
//				} 
//				if (dbType.trim().equals("mysql")) {
//					dataBase.setPaginationImpl("com.founder.fix.fixflow.expand.database.pagination.MySqlPaginationImpl");
//				} 
//				if (dbType.trim().equals("db2")) {
//					dataBase.setPaginationImpl("com.founder.fix.fixflow.expand.database.pagination.DB2PaginationImpl");
//				} 
//				
//				fixFlowConfig.getDataBaseConfig().setSelected(dataBase.getId());
//
//				Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
//				Map<String, Object> m = reg.getExtensionToFactoryMap();
//				m.put("xml", new XMIResourceFactoryImpl());
//
//				// Obtain a new resource set
//				ResourceSet resSet = new ResourceSetImpl();
//
//				// Create a resource
//				XMIResource resource = (XMIResource) resSet.createResource(URI
//						.createFileURI(FixFlowConfigUtil
//								.getFixFlowConfigXMLPath()));
//				resource.setEncoding("UTF-8");
//
//				resource.getContents().add(fixFlowConfig);
//
//				try {
//					resource.save(Collections.EMPTY_MAP);
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//
//				// 刷新工程
//				ProjectUtil.refreshProject(FLOWCONFIGPROJECT);
//
//				// 清空缓存
//				FixFlowConfigUtil.fixFlowConfig = null;
//
//				return;
//			}
//		}
//
//		DataBase dataBase = CoreconfigFactory.eINSTANCE.createDataBase();
//		dataBase.setId(name);
//		dataBase.setName(name);
//		dataBase.setDriverClassName(driverClassName);
//		dataBase.setUrl(url);
//		dataBase.setUsername(userName);
//		dataBase.setPassword(passWord);
//		dataBase.setMaxActive(maxActive);
//		dataBase.setMaxIdle(maxIdle);
//		dataBase.setMaxWait(maxWait);
//		dataBase.setDbtype(DBType.getByName(dbType));
//		if (dbType.trim().equals("oracle")) {
//			dataBase.setPaginationImpl("com.founder.fix.fixflow.expand.database.pagination.OraclePaginationImpl");
//		} else {
//			dataBase.setPaginationImpl("com.founder.fix.fixflow.expand.database.pagination.SqlServerPaginationImpl");
//		}
//		fixFlowConfig.getDataBaseConfig().getDataBase().add(dataBase);
//		fixFlowConfig.getDataBaseConfig().setSelected(name);
//
//		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
//		Map<String, Object> m = reg.getExtensionToFactoryMap();
//		m.put("xml", new XMIResourceFactoryImpl());
//
//		// Obtain a new resource set
//		ResourceSet resSet = new ResourceSetImpl();
//
//		// Create a resource
//		XMIResource resource = (XMIResource) resSet.createResource(URI
//				.createFileURI(FixFlowConfigUtil.getFixFlowConfigXMLPath()));
//		resource.setEncoding("UTF-8");
//
//		resource.getContents().add(fixFlowConfig);
//
//		try {
//			resource.save(Collections.EMPTY_MAP);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		// 刷新工程
//		ProjectUtil.refreshProject(FLOWCONFIGPROJECT);
//
//		// 清空缓存
//		FixFlowConfigUtil.fixFlowConfig = null;
//
//	}
//
//	/**
//	 * 拿到所有启用为true的TaskCommand对象
//	 * 
//	 * @return
//	 */
//	public static List<TaskCommandDef> getTaskCommandNames(
//			FixFlowConfig fixFlowConfig) {
//		List<TaskCommandDef> taskCommandNames = new ArrayList<TaskCommandDef>();
//		for (TaskCommandDef taskCommand : fixFlowConfig.getTaskCommandConfig()
//				.getTaskCommandDef()) {
//			if (taskCommand.getIsEnabled().equals("true")&&!taskCommand.getType().equals("system")) {
//				taskCommandNames.add(taskCommand);
//			}
//		}
//		return taskCommandNames;
//	}
//	
//	public static ImportDataVariableConfig getImportDataVariableConfig(){
//		return getFixFlowConfig().getImportDataVariableConfig();
//	}
//	
//	public static ImportDataVariable getImportDataVariable(String dataVariableConfigId){
//		
//		ImportDataVariableConfig importDataVariableConfig=getImportDataVariableConfig();
//		
//		for (ImportDataVariable importDataVariable : importDataVariableConfig.getImportDataVariable()) {
//			if(importDataVariable.getId().equals(dataVariableConfigId)){
//				return importDataVariable;
//			}
//		}
//		return null;
//		
//	}
//
//	/**
//	 * 拿到配置里选中的数据库
//	 * 
//	 * @return
//	 */
//	public static DataBase getSelectedDataBase() {
//		DataBaseConfig dataBaseConfig = FixFlowConfigUtil.getFixFlowConfig()
//				.getDataBaseConfig();
//		List<DataBase> dataBases = dataBaseConfig.getDataBase();
//
//		DataBase dataBase = null;
//
//		for (DataBase db : dataBases) {
//			if (db.getId().equals(dataBaseConfig.getSelected())) {
//				dataBase = db;
//			}
//		}
//		return dataBase;
//	}
//	
//	/**
//	 * 拿到指定的数据库连接
//	 * 
//	 * @return
//	 */
//	public static DataBase getSelectedDataBase(String dataBaseId) {
//		DataBaseConfig dataBaseConfig = FixFlowConfigUtil.getFixFlowConfig()
//				.getDataBaseConfig();
//		List<DataBase> dataBases = dataBaseConfig.getDataBase();
//
//		DataBase dataBase = null;
//
//		for (DataBase db : dataBases) {
//			if (db.getId().equals(dataBaseId)) {
//				dataBase = db;
//			}
//		}
//		return dataBase;
//	}
//
//	/**
//	 * 创建数据库连接(不起事务)
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	public static Connection createConnection() {
//		Connection connection = null;
//
//		DataBase dataBase = getSelectedDataBase();
//
//		String driver = dataBase.getDriverClassName();
//		String url = dataBase.getUrl();
//		String user = dataBase.getUsername();
//		String password = dataBase.getPassword();
//
//		/*
//		 * Class.forName("oracle.jdbc.driver.OracleDriver"); String url =
//		 * "jdbc:oracle:thin:@172.29.128.91:1521:orcl"; String user = "idbase";
//		 * String password = "idbase"; connection =
//		 * DriverManager.getConnection(url, user, password);
//		 */
//
//		try {
//			Class.forName(driver);
//		} catch (Exception e) {
//			//MessageDialog.openInformation(null, "错误",
//					//"数据库连接创建失败,原因是 " + e.toString());
//		}// com.mysql.jdbc.Driver
//
//		try {
//			connection = DriverManager.getConnection(url, user, password);
//		} catch (Exception e) {
//			
//			MessageDialog.openInformation(null, "错误",
//					"数据库连接创建失败,原因是 " + e.toString());
//		}
//
//		return connection;
//	}
//	
//	/**
//	 * 创建数据库连接(起事务)
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	public static Connection createConnectionWithCommit() {
//		Connection connection = null;
//
//		DataBase dataBase = getSelectedDataBase();
//
//		String driver = dataBase.getDriverClassName();
//		String url = dataBase.getUrl();
//		String user = dataBase.getUsername();
//		String password = dataBase.getPassword();
//
//		/*
//		 * Class.forName("oracle.jdbc.driver.OracleDriver"); String url =
//		 * "jdbc:oracle:thin:@172.29.128.91:1521:orcl"; String user = "idbase";
//		 * String password = "idbase"; connection =
//		 * DriverManager.getConnection(url, user, password);
//		 */
//
//		try {
//			Class.forName(driver);
//		} catch (Exception e) {
//			//MessageDialog.openInformation(null, "错误",
//					//"数据库连接创建失败,原因是 " + e.toString());
//		}// com.mysql.jdbc.Driver
//
//		try {
//			connection = DriverManager.getConnection(url, user, password);
//			connection.setAutoCommit(false);
//		} catch (Exception e) {
//			
//			MessageDialog.openInformation(null, "错误",
//					"数据库连接创建失败,原因是 " + e.toString());
//		}
//
//		return connection;
//	}
//	
//	
//	/**
//	 * 获取资源路径配置对象
//	 * @return
//	 */
//	public static ResourcePathConfig getResourcePathConfig() {
//		return getFixFlowConfig().getResourcePathConfig();
//	}
//	
//	/**
//	 * 获取资源路径列表
//	 * @return
//	 */
//	public static List<ResourcePath> getResourcePathList() {
//		return getFixFlowConfig().getResourcePathConfig().getResourcePath();
//	}
//	
//	/**
//	 * 获取对应resourceId的路径
//	 * @param resourceId
//	 * @return
//	 */
//	public static String getResourcePath(String resourceId) {
//		String path = "";
//		for (ResourcePath resourcePath : FixFlowConfigUtil.getResourcePathConfig().getResourcePath()) {
//			if(resourcePath.getId().equals(resourceId)) {
//				path = ProjectUtil.getProjectPath(resourcePath.getProjectName())
//						+ "/" + (resourcePath.getVirtualPath());
//				break;
//			}
//		}
//		return path;
//	}
//	
//	public static ResourcePath getResourcePathObj(String resourceId){
//		for (ResourcePath resourcePath : FixFlowConfigUtil.getResourcePathConfig().getResourcePath()) {
//			if(resourcePath.getId().equals(resourceId)) {
//				return resourcePath;
//			}
//		}
//		return null;
//	}
//	
//	public static String getNodeTemplate(){
//		
//		
//		ResourcePath resourcePath=getResourcePathObj(FIXFLOW_REPOSITORY_NODE_TEMPLATE);
//		
//		String path=ProjectUtil.getProjectPath(resourcePath.getProjectName()) + "/" + resourcePath.getVirtualPath();
//		
//		return path;
//	}
//	
//	public static String getNodeTemplateProjectName(){
//		
//		
//		ResourcePath resourcePath=getResourcePathObj(FIXFLOW_REPOSITORY_NODE_TEMPLATE);
//		
//		return resourcePath.getProjectName();
//	}
//	
//	public static String getSystemTemplate(){
//		
//		
//		ResourcePath resourcePath=getResourcePathObj(SYSTEM_TEMPLATE);
//		
//		String path=ProjectUtil.getProjectPath(resourcePath.getProjectName())+ "/" + resourcePath.getVirtualPath();
//		
//		return path;
//	}
//	
//	
//	public static String getFlowTemplate(){
//		
//		
//		ResourcePath resourcePath=getResourcePathObj(FIXFLOW_REPOSITORY_FLOW_TEMPLATE);
//		
//		String path=ProjectUtil.getProjectPath(resourcePath.getProjectName()) + "/" + resourcePath.getVirtualPath();
//		
//		return path;
//	}
//	
//	public static String getDataVariableConfigFilePath(){
//		
//		
//		ResourcePath resourcePath=getResourcePathObj("dataVariableConfig");
//	
//		String path=ProjectUtil.getProjectPath(resourcePath.getProjectName())+ "/" + resourcePath.getVirtualPath();
//		
//		return path;
//	}
//	
//	public static String getDataVariableConfigFileProjectName(){
//		
//		
//		ResourcePath resourcePath=getResourcePathObj("dataVariableConfig");
//	
//		return resourcePath.getProjectName();
//	}
//	
//	public static String getFixflowNoneFilePath(){
//		
//		
//		ResourcePath resourcePath=getResourcePathObj("fixflowfile");
//	
//		String path=ProjectUtil.getProjectPath(resourcePath.getProjectName())+ "/" + resourcePath.getVirtualPath();
//		
//		return path;
//	}
//	
//	public static String getGroovyFilePath(){
//		
//		
//		ResourcePath resourcePath=getResourcePathObj("groovyFile");
//	
//		String path=ProjectUtil.getProjectPath(resourcePath.getProjectName())+ "/" + resourcePath.getVirtualPath();
//		
//		return path;
//	}
//	
//	public static String getGroovyVirtualPath(){
//		
//		
//		ResourcePath resourcePath=getResourcePathObj("groovyFile");
//	
//		return resourcePath.getVirtualPath();
//
//	}
//	
//	public static String getGroovyFileProjectName(){
//		
//		
//		ResourcePath resourcePath=getResourcePathObj("groovyFile");
//	
//		
//		return resourcePath.getProjectName();
//	}
//	
//	
//	
//	public static String getQuartzFilePath(){
//		
//		
//		ResourcePath resourcePath=getResourcePathObj("quartz");
//	
//		String path=ProjectUtil.getProjectPath(resourcePath.getProjectName())+ "/" + resourcePath.getVirtualPath();
//		
//		return path;
//	}
//	
//	public static String getStyleFilePath(){
//		
//		
//		ResourcePath resourcePath=getResourcePathObj("style");
//	
//		String path=ProjectUtil.getProjectPath(resourcePath.getProjectName())+ "/" + resourcePath.getVirtualPath();
//		
//		return path;
//	}
//	
//	public static String getStyleFileProjectName(){
//		
//		
//		ResourcePath resourcePath=getResourcePathObj("style");
//	
//		
//		
//		return resourcePath.getProjectName();
//	}
//	
//	
//	public static String getInternationalizationPath(){
//		
//		
//		ResourcePath resourcePath=getResourcePathObj("internationalization");
//	
//		String path=ProjectUtil.getProjectPath(resourcePath.getProjectName())+ "/" + resourcePath.getVirtualPath();
//		
//		return path;
//	}
//	
//	public static String getInternationalizationProjectName(){
//		
//		
//		ResourcePath resourcePath=getResourcePathObj("internationalization");
//	
//		
//		return resourcePath.getProjectName();
//	}
//	
//	public static String getFixflowDiagramPath(){
//		
//		
//		ResourcePath resourcePath=getResourcePathObj("fixflowdiagram");
//	
//		String path=ProjectUtil.getProjectPath(resourcePath.getProjectName())+ "/" + resourcePath.getVirtualPath();
//		
//		return path;
//	}
//	
//	public static String getFixflowDiagramProjectName(){
//		
//		
//		ResourcePath resourcePath=getResourcePathObj("fixflowdiagram");
//	
//		
//		return resourcePath.getProjectName();
//	}
//	
//
//	/**
//	 * 从设计器根目录配置文件中读取对应的属性
//	 * @return
//	 */
//	public static String getPathFromConfFile(String key) {
//		String proFilePath = Platform.getInstallLocation().getURL().getPath().toString() + "conf.properties";
//		File file = new File(proFilePath);
//		if(!file.exists()) {
//			try {
//				file.createNewFile();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			PropertiesUtil.writeProperties(file.getAbsolutePath(), "projectName", "fixflow-expand");
//			PropertiesUtil.writeProperties(file.getAbsolutePath(), "configPath", "/src/main/resources/config");
//		}
//		return PropertiesUtil.readValue(proFilePath, key);
//	}
//	
}
