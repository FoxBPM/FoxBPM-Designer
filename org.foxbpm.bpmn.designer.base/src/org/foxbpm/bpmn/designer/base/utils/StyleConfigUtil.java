package org.foxbpm.bpmn.designer.base.utils;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.foxbpm.model.config.style.ElementStyle;
import org.foxbpm.model.config.style.FoxBPMStyleConfig;

public class StyleConfigUtil {
	
	
	
	
	/**
	 * 得到style设计器主题配置文件所存放的路径
	 * 
	 * @return
	 */
	public static String getStyleConfigFilePath() {
		return FoxBPMDesignerUtil.getServicePath() + "coreconfig/style.xml" ;
	}
	
	/**
	 * 加载所有的FixFlowStyleConfig配置信息
	 * 
	 * @return
	 */
	public static FoxBPMStyleConfig getStyleConfig() {

		FoxBPMStyleConfig fixFlowStyleConfig = EMFUtil.getStyleConfig(getStyleConfigFilePath());
		
		return fixFlowStyleConfig;
		
	}
	
	/**
	 * 保存EMF模型
	 * @param fixFlowStyleConfig
	 */
	public static void saveStyleConfig(FoxBPMStyleConfig fixFlowStyleConfig){
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xml", new XMIResourceFactoryImpl());

		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();

		// Create a resource
		XMIResource resource = (XMIResource) resSet.createResource(URI.createFileURI(getStyleConfigFilePath()));
		resource.setEncoding("UTF-8");

		resource.getContents().add(fixFlowStyleConfig);

		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	
	/**
	 * 拿到对应当前选中主题的elementStyle
	 * 
	 * @return
	 */
	public static ElementStyle getCurrentStyle() {
		for (ElementStyle elementStyle : getStyleConfig().getElementStyleConfig().getElementStyle()) {
			if (elementStyle.getStyleId().equals(getStyleConfig().getElementStyleConfig().getCurrentStyle())) {
				return elementStyle;
			}
		}
		return null;
	}
}
