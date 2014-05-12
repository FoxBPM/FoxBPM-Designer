package org.foxbpm.bpmn.designer.ui.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpmn2.Bpmn2Factory;
import org.eclipse.bpmn2.Definitions;
import org.eclipse.bpmn2.DocumentRoot;
import org.eclipse.bpmn2.ExtensionAttributeValue;
import org.eclipse.bpmn2.FormalExpression;
import org.eclipse.bpmn2.PotentialOwner;
import org.eclipse.bpmn2.Process;
import org.eclipse.bpmn2.ResourceAssignmentExpression;
import org.eclipse.bpmn2.UserTask;
import org.eclipse.bpmn2.modeler.core.ModelHandler;
import org.eclipse.bpmn2.modeler.core.ModelHandlerLocator;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil.Bpmn2DiagramType;
import org.eclipse.bpmn2.modeler.ui.editor.BPMN2Editor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Internal;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl.SimpleFeatureMapEntry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.foxbpm.model.bpmn.foxbpm.AssignPolicyType;
import org.foxbpm.model.bpmn.foxbpm.DataVariable;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;
import org.foxbpm.model.bpmn.foxbpm.ProcessValidationLevel;
import org.foxbpm.model.bpmn.foxbpm.SkipStrategy;
import org.foxbpm.model.bpmn.foxbpm.TaskCommand;



public class BpmnModelUtil {

	public static Process getProcess(Resource eResource) {

		try {
			ModelHandler modelHandler = ModelHandlerLocator.getModelHandler(eResource);
			

			List<Process> processes = modelHandler.getAll(Process.class);
			// not a collaboration, and only one process -> append it there
			Process process = processes.size() == 1 ? processes.get(0) : null;

			return process;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Process getProcessByEobj(EObject eObject) {

		try {
			ModelHandler modelHandler = ModelHandlerLocator.getModelHandler(eObject.eResource());
			
			if(modelHandler ==null) {
				Process process = (Process) ((DocumentRoot)eObject.eResource().getContents().get(0)).getDefinitions().getRootElements().get(0);
				return process;
			}
			
			List<Process> processes = modelHandler.getAll(Process.class);
			// not a collaboration, and only one process -> append it there
			Process process = processes.size() == 1 ? processes.get(0) : null;

			return process;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static ModelHandler getModelHandler(EObject eObject) {

		try {
			ModelHandler modelHandler = ModelHandlerLocator.getModelHandler(eObject.eResource());

			return modelHandler;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Definitions getDefinitions(Resource eResource) {

		try {
			ModelHandler modelHandler = ModelHandlerLocator.getModelHandler(eResource);

			Definitions definitions = modelHandler.getDefinitions();

			return definitions;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}

	public static Definitions getDefinitionsByEobj(EObject eObject) {

		try {
			ModelHandler modelHandler = ModelHandlerLocator.getModelHandler(eObject.eResource());

			Definitions definitions = modelHandler.getDefinitions();

			return definitions;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}

	public static Bpmn2DiagramType getDiagramType(EObject object) {
		return ModelUtil.getDiagramType(object);
	}

	public static TaskCommand createTaskCommand() {

		TaskCommand taskCommand = FoxBPMFactory.eINSTANCE.createTaskCommand();
		taskCommand.setId("Advance_1");
		taskCommand.setName("启动提交");
		taskCommand.setCommandType("startandsubmit");
		/*
		 * Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
		 * expression
		 * .setValue((DataVarTo)comboViewer.getElementAt(comboViewer.getCombo
		 * ().getSelectionIndex()) == null ? "" :
		 * ((DataVarTo)comboViewer.getElementAt
		 * (comboViewer.getCombo().getSelectionIndex())).getValue());
		 * taskCommand.setExpression(expression);
		 */
		return taskCommand;

	}

	public static TaskCommand createTaskViewCommand() {

		TaskCommand taskCommand = FoxBPMFactory.eINSTANCE.createTaskCommand();
		taskCommand.setId("Advance_ProcessStatus");
		taskCommand.setName("流程状态");
		taskCommand.setCommandType("processStatus");
		/*
		 * Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
		 * expression
		 * .setValue((DataVarTo)comboViewer.getElementAt(comboViewer.getCombo
		 * ().getSelectionIndex()) == null ? "" :
		 * ((DataVarTo)comboViewer.getElementAt
		 * (comboViewer.getCombo().getSelectionIndex())).getValue());
		 * taskCommand.setExpression(expression);
		 */
		return taskCommand;

	}

	public static AssignPolicyType createAssignPolicyType() {

		AssignPolicyType assignPolicyType = FoxBPMFactory.eINSTANCE.createAssignPolicyType();
		assignPolicyType.setId("potentialOwner");

		return assignPolicyType;

	}

	public static SkipStrategy createSkipStrategy() {
		SkipStrategy SkipStrategy = FoxBPMFactory.eINSTANCE.createSkipStrategy();

		return SkipStrategy;
	}
	
	
	public static UserTask initUserTask(UserTask userTask){
		userTask.getResources().add(BpmnModelUtil.createPotentialOwner());

		ExtensionAttributeValue extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
		userTask.getExtensionValues().add(extensionElement);
		FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry(
				(org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__TASK_COMMAND,
				createTaskViewCommand());
		extensionElement.getValue().add(extensionElementEntry);

		FeatureMap.Entry extensionElementEntry2 = new SimpleFeatureMapEntry(
				(org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__ASSIGN_POLICY_TYPE,
				createAssignPolicyType());
		extensionElement.getValue().add(extensionElementEntry2);

		FeatureMap.Entry extensionElementEntry3 = new SimpleFeatureMapEntry(
				(org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__SKIP_STRATEGY,
				createSkipStrategy());
		extensionElement.getValue().add(extensionElementEntry3);

		return userTask;
	}
	
	

	
	

	public static PotentialOwner createPotentialOwner() {

		PotentialOwner potentialOwner = Bpmn2Factory.eINSTANCE.createPotentialOwner();
		ModelUtil.setID(potentialOwner);
		FeatureMap.Entry extensionAttributeEntry = new SimpleFeatureMapEntry(
				(Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__RESOURCE_TYPE, "user");
		potentialOwner.getAnyAttribute().add(extensionAttributeEntry);
		FeatureMap.Entry extensionAttributeEntry1 = new SimpleFeatureMapEntry(
				(Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__INCLUDE_EXCLUSION, "INCLUDE");
		potentialOwner.getAnyAttribute().add(extensionAttributeEntry1);
		FeatureMap.Entry extensionAttributeEntry2 = new SimpleFeatureMapEntry(
				(Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__IS_CONTAINS_SUB, "false");
		potentialOwner.getAnyAttribute().add(extensionAttributeEntry2);

		ResourceAssignmentExpression resourceAssignmentExpression = Bpmn2Factory.eINSTANCE.createResourceAssignmentExpression();
		ModelUtil.setID(resourceAssignmentExpression);
		
		ModelUtil.setID(potentialOwner);
		FormalExpression formalExpression = Bpmn2Factory.eINSTANCE.createFormalExpression();
		ModelUtil.setID(formalExpression);
		formalExpression.eSet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME, "所有人");
		//formalExpression.setId("所有人");
		formalExpression.setBody("\"fixflow_allusers\"");
		resourceAssignmentExpression.setExpression(formalExpression);

		potentialOwner.setName("所有人");
		potentialOwner.setResourceAssignmentExpression(resourceAssignmentExpression);

		return potentialOwner;
	}
	
	
	
	public static void updateBpmnModelFile(BPMN2Editor bpmn2Editor,final String processId,final String processName,final ProcessValidationLevel processValidationLevel) {
		final ModelHandler modelHandler=bpmn2Editor.getModelHandler();
		final Resource resource=modelHandler.getResource();
		
		TransactionalEditingDomain editingDomain = bpmn2Editor.getEditingDomain();
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				Process process=getProcess(resource);
				process.setId(processId);
				process.setName(processName);
				process.eSet(FoxBPMPackage.Literals.DOCUMENT_ROOT__VALIDATION_LEVEL, processValidationLevel);
			}
		});
	}
	
	/**
	 * 获取流程的数据变量
	 * @param process 流程对象
	 * @return
	 */
	public static List<DataVariable> getDataVariable(Process process){
		
		
		
		List<DataVariable> dataVariables = new ArrayList<DataVariable>();

		if (process.getExtensionValues().size() > 0) {
			for (ExtensionAttributeValue extensionAttributeValue : process.getExtensionValues()) {
				FeatureMap extensionElements = extensionAttributeValue.getValue();
				Object objectElement = extensionElements.get(FoxBPMPackage.Literals.DOCUMENT_ROOT__DATA_VARIABLE, true);
				if (objectElement != null) {
					@SuppressWarnings("unchecked")
					List<DataVariable> dataVariableList = (List<DataVariable>) objectElement;
					for (DataVariable dataVariable : dataVariableList) {
						dataVariables.add(dataVariable);
					}
				}
			}
		}

		return dataVariables;
		
		
	}
	
	
	/**
	 * 获取流程的数据变量
	 * @param process 流程对象
	 * @param bizType 业务类型
	 * @return
	 */
	public static List<DataVariable> getDataVariable(Process process,String bizType){
		
		
		
		List<DataVariable> dataVariables = new ArrayList<DataVariable>();

		if (process.getExtensionValues().size() > 0) {
			for (ExtensionAttributeValue extensionAttributeValue : process.getExtensionValues()) {
				FeatureMap extensionElements = extensionAttributeValue.getValue();
				Object objectElement = extensionElements.get(FoxBPMPackage.Literals.DOCUMENT_ROOT__DATA_VARIABLE, true);
				if (objectElement != null) {
					@SuppressWarnings("unchecked")
					List<DataVariable> dataVariableList = (List<DataVariable>) objectElement;
					for (DataVariable dataVariable : dataVariableList) {
						if(dataVariable.getBizType()!=null && dataVariable.getBizType().equals(bizType)){
							dataVariables.add(dataVariable);
						}
						
					}
				}
			}
		}

		return dataVariables;
		
		
	}
	
//	public static List<ExpressionTo> getDataVariableExpression(String bizType,EObject eObject){
//		
//		List<DataVariable> dataVariables=getDataVariable(BpmnModelUtil.getProcessByEobj(eObject),bizType);
//		List<ExpressionTo> expressions=new ArrayList<ExpressionTo>();
//		
//		for (DataVariable dataVariable : dataVariables) {
//			ExpressionTo expression=new ExpressionTo();
//			expression.setName(dataVariable.getId());
//			expression.setExpressionText("${"+dataVariable.getId()+"}");
//			expressions.add(expression);
//		}
//		return expressions;
//		
//	}
	
	public static List<DataVariable> getDataVariablesByBizType(Process process, String BizType) {
		List<DataVariable> dataVariables = new ArrayList<DataVariable>();

		for (ExtensionAttributeValue eav : BpmnModelUtil.getProcessByEobj(process).getExtensionValues()) {
			FeatureMap extensionElements = eav.getValue();
			Object objectElement = extensionElements.get(FoxBPMPackage.Literals.DOCUMENT_ROOT__DATA_VARIABLE, true);
			if (objectElement != null) {

				@SuppressWarnings("unchecked")
				List<DataVariable> dataVariableList = (List<DataVariable>) objectElement;
				for (DataVariable dataVariable : dataVariableList) {
					if(dataVariable.getBizType()==null && BizType.equals("customVariable")) {
						dataVariables.add(dataVariable);
					}
					else if (dataVariable.getBizType()!=null && dataVariable.getBizType().equals(BizType)) {
						dataVariables.add(dataVariable);
					}
				}

			}
		}

		return dataVariables;
	}

}
