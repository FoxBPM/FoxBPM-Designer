package org.foxbpm.model.config;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig;
import org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigFactory;
import org.foxbpm.model.config.foxbpmconfig.Param;
import org.foxbpm.model.config.foxbpmconfig.TaskCommandConfig;
import org.foxbpm.model.config.foxbpmconfig.TaskCommandDefinition;
import org.foxbpm.model.config.foxbpmconfig.util.FoxBPMConfigResourceFactoryImpl;
import org.foxbpm.model.config.foxbpmconfig.util.FoxBPMConfigResourceImpl;

public class Test {

	public static void main(String[] args) {
//		ResourceSet resourceSet = new ResourceSetImpl();
//		
//		XMIResource resource = (XMIResource) resourceSet.createResource(URI.createFileURI("D:/sss.xml"));
//		resource.setEncoding("UTF-8");
		
		
		FoxBPMConfigResourceFactoryImpl factoryImpl = new FoxBPMConfigResourceFactoryImpl();
		FoxBPMConfigResourceImpl foxBPMConfigResourceImpl = (FoxBPMConfigResourceImpl) factoryImpl.createResource(URI.createFileURI("D:/tttt.xml"));
		foxBPMConfigResourceImpl.setEncoding("UTF-8");
		
		FoxBPMConfig foxBPMConfig = FoxBPMConfigFactory.eINSTANCE.createFoxBPMConfig();
		
		TaskCommandConfig taskCommandConfig = FoxBPMConfigFactory.eINSTANCE.createTaskCommandConfig();
		
		TaskCommandDefinition taskCommandDefinition = FoxBPMConfigFactory.eINSTANCE.createTaskCommandDefinition();
		taskCommandDefinition.setId("111");
		
		Param param = FoxBPMConfigFactory.eINSTANCE.createParam();
		param.setKey("isSave");
		param.setName("是否保存");
		param.setValue("true");
		
		Param param1 = FoxBPMConfigFactory.eINSTANCE.createParam();
		param1.setKey("isVerify");
		param1.setName("是否验证");
		param1.setValue("false");
		
//		taskCommandDefinition.getParams().add(param);
//		taskCommandDefinition.getParams().add(param1);
//				
		taskCommandConfig.getTaskCommandDefinition().add(taskCommandDefinition);
				
		foxBPMConfig.setTaskCommandConfig(taskCommandConfig);
		
		foxBPMConfigResourceImpl.getContents().add(foxBPMConfig);
//		resource.getContents().add(foxBPMConfig);
		
		try {
			foxBPMConfigResourceImpl.save(null);
//			resource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
