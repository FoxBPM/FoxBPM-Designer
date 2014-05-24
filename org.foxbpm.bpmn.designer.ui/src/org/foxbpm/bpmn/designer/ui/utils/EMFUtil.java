package org.foxbpm.bpmn.designer.ui.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.foxbpm.model.config.connector.ConnectorDefinition;
import org.foxbpm.model.config.connectormenu.Menu;
import org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage;

public class EMFUtil {

	/**
	 * 根据需要加载出所有的对象
	 * 
	 * @param resource
	 *            ，可以传入 menu.eResource(),
	 * @param class1
	 *            ， 可以设定成 Node.class
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> getAll(Resource resource, final Class<T> class1) {
		ArrayList<T> l = new ArrayList<T>();
		TreeIterator<EObject> contents = resource.getAllContents();
		for (; contents.hasNext();) {
			Object t = contents.next();
			if (class1.isInstance(t)) {
				l.add((T) t);
			}
		}
		return l;
	}
	
	/**
	 * 读EMF文件
	 * 
	 * @param path
	 * @return
	 */
	public static Resource readEMFFile(String path) {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xml", new XMIResourceFactoryImpl());

		Resource resource = resourceSet.getResource(URI.createFileURI(path), true);
		try {
			resource.load(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resource;
	}

	/**
	 * 加载所有的数据变量
	 * 
	 * @return
	 */
	// public static DataVariableConfig getFixFlowDataVariableConfig(String
	// filePath) {
	//
	// DataVariableConfig dataVariableConfig = null;
	//
	// ResourceSet resourceSet = new ResourceSetImpl();
	//
	// resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
	// .put("xml", new XMIResourceFactoryImpl());
	//
	// Resource resource = resourceSet.getResource(
	// URI.createFileURI(filePath), true);
	//
	// // register package in local resource registry
	// resourceSet.getPackageRegistry().put(
	// CoreconfigPackage.eINSTANCE.getNsURI(),
	// CoreconfigPackage.eINSTANCE);
	// // load resource
	// try {
	// resource.load(null);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	//
	// dataVariableConfig = (DataVariableConfig) resource.getContents().get(0);
	//
	// // XMIResource resource = (XMIResource) new
	// //
	// ResourceSetImpl().getResource(URI.createFileURI(getDataVariableXMLPath()),
	// // true);
	// // dataVariableConfig = (DataVariableConfig)
	// // resource.getContents().get(0);
	//
	// return dataVariableConfig;
	// }

	/**
	 * 加载所有的fixflowconfig配置信息
	 * 
	 * @return
	 */
	// public static FixFlowConfig getFixFlowConfig(String filePath) {
	//
	// FixFlowConfig fixFlowConfig=null;
	//
	// ResourceSet resourceSet = new ResourceSetImpl();
	//
	// resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
	// .put("xml", new XMIResourceFactoryImpl());
	//
	//
	//
	// Resource resource = resourceSet.getResource(URI.createFileURI(filePath),
	// true);
	//
	// // register package in local resource registry
	// resourceSet.getPackageRegistry().put(
	// CoreconfigPackage.eINSTANCE.getNsURI(),
	// CoreconfigPackage.eINSTANCE);
	// // load resource
	// try {
	// resource.load(null);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	//
	// fixFlowConfig = (FixFlowConfig) resource.getContents().get(0);
	//
	// return fixFlowConfig;
	//
	// }

	/**
	 * 加载所有的FixFlowStyleConfig配置信息
	 * 
	 * @return
	 */
	// public static FixFlowStyleConfig getStyleConfig(String filePath) {
	//
	// FixFlowStyleConfig fixFlowStyleConfig=null;
	//
	// ResourceSet resourceSet = new ResourceSetImpl();
	//
	// resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
	// .put("xml", new XMIResourceFactoryImpl());
	//
	//
	//
	// Resource resource = resourceSet.getResource(URI.createFileURI(filePath),
	// true);
	//
	// // register package in local resource registry
	// resourceSet.getPackageRegistry().put(
	// CoreconfigPackage.eINSTANCE.getNsURI(),
	// CoreconfigPackage.eINSTANCE);
	// // load resource
	// try {
	// resource.load(null);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	//
	// fixFlowStyleConfig = (FixFlowStyleConfig) resource.getContents().get(0);
	//
	// return fixFlowStyleConfig;
	//
	// }

	// public static ScriptLanguage getScriptLanguage() {
	// ScriptLanguageConfig
	// scriptLanguageConfig=FixFlowConfigUtil.getFixFlowConfig().getScriptLanguageConfig();
	//
	//
	// for (ScriptLanguage scriptLanguage :
	// scriptLanguageConfig.getScriptLanguage()) {
	// if(scriptLanguage.getId().equals(scriptLanguageConfig.getSelected())){
	// return scriptLanguage;
	// }
	// }
	// return null;
	//
	// }

	/**
	 * 加载所有的fixflowconfig配置信息
	 * 
	 * @return
	 */
	public static Menu getConnectorMenuConfig(String filePath) {

		Menu root = null;

		ResourceSet resourceSet = new ResourceSetImpl();

		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xml", new XMIResourceFactoryImpl());

		Resource resource = resourceSet.getResource(URI.createFileURI(filePath), true);

		// register package in local resource registry
		resourceSet.getPackageRegistry().put(FoxBPMConfigPackage.eINSTANCE.getNsURI(), FoxBPMConfigPackage.eINSTANCE);
		// load resource
		try {
			resource.load(null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		root = (Menu) resource.getContents().get(0);
		return root;

	}

	/**
	 * 加载所有的fixflowconfig配置信息
	 * 
	 * @return
	 */
	// public static Connector getConnectorConfig(String filePath) {
	//
	//
	// Connector connector=null;
	//
	// ResourceSet resourceSet = new ResourceSetImpl();
	//
	// resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
	// .put("xml", new XMIResourceFactoryImpl());
	//
	// Resource resource = resourceSet.getResource(
	// URI.createFileURI(filePath), true);
	//
	// // register package in local resource registry
	// resourceSet.getPackageRegistry().put(
	// CoreconfigPackage.eINSTANCE.getNsURI(),
	// CoreconfigPackage.eINSTANCE);
	// // load resource
	// try {
	// resource.load(null);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	//
	// connector = (Connector) resource.getContents()
	// .get(0);
	// return connector;
	//
	// }

	/**
	 * 加载所有的FlowConnector信息
	 * 
	 * @return
	 */
	public static ConnectorDefinition getFlowConnectorConfig(String filePath) {

		ConnectorDefinition connector = null;

		ResourceSet resourceSet = new ResourceSetImpl();

		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xml", new XMIResourceFactoryImpl());

		Resource resource = resourceSet.getResource(URI.createFileURI(filePath), true);

		// register package in local resource registry
		resourceSet.getPackageRegistry().put(FoxBPMConfigPackage.eINSTANCE.getNsURI(), FoxBPMConfigPackage.eINSTANCE);
		// load resource
		try {
			resource.load(null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		connector = (ConnectorDefinition) resource.getContents().get(0);
		return connector;

	}

//	public static SqlMappingConfig getSqlMappingConfig(String sqlMappingConfigXMLPath) {
//
//		SqlMappingConfig sqlMappingConfig = null;
//
//		ResourceSet resourceSet = new ResourceSetImpl();
//
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xml", new XMIResourceFactoryImpl());
//
//		Resource resource = resourceSet.getResource(URI.createFileURI(sqlMappingConfigXMLPath), true);
//
//		// register package in local resource registry
//		resourceSet.getPackageRegistry().put(CoreconfigPackage.eINSTANCE.getNsURI(), CoreconfigPackage.eINSTANCE);
//		// load resource
//		try {
//			resource.load(null);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		sqlMappingConfig = (SqlMappingConfig) resource.getContents().get(0);
//
//		return sqlMappingConfig;
//
//	}

}
