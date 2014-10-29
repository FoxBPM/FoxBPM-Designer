package org.foxbpm.bpmn.designer.ui.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.eclipse.jface.dialogs.MessageDialog;
import org.foxbpm.bpmn.designer.base.utils.FileUtil;
import org.foxbpm.bpmn.designer.base.utils.FoxBPMDesignerUtil;
import org.foxbpm.bpmn.designer.ui.custom.CommandParamTo;
import org.foxbpm.bpmn.designer.ui.to.TaskCommandDefinitonTo;
import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;
import org.foxbpm.model.config.foxbpmconfig.CommandParam;
import org.foxbpm.model.config.foxbpmconfig.TaskCommandDefinition;

public class TaskCommandUtil {
	public static List<TaskCommandDefinition> taskCommandDefinitions = new ArrayList<TaskCommandDefinition>();
	
	/**
	 * 根据类型返回不同的任务命令参数
	 * 
	 * @return
	 */
	public static List<CommandParamTo> getTaskCommandParamByType(TaskCommandDefinition taskCommandDefinition, String type) {
		List<CommandParamTo> commandParams = new ArrayList<CommandParamTo>();
		for (CommandParam commandParam : taskCommandDefinition.getCommandParam()) {
			if (commandParam.getBizType().equals(type)) {
				CommandParamTo commandParamTo = new CommandParamTo();
				commandParamTo.setBizType(commandParam.getBizType());
				commandParamTo.setDataType(commandParam.getDataType());
				commandParamTo.setDescription(commandParam.getDescription());
				commandParamTo.setType("config");
				
				if(commandParam.getValue()!=null) {
					Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
					expression.setName(commandParam.getValue());
					expression.setValue(commandParam.getValue());
					commandParamTo.setExpression(expression);
				}
				
				commandParamTo.setName(commandParam.getName());
				commandParamTo.setKey(commandParam.getKey());
				
				commandParams.add(commandParamTo);
			}
		}
		return commandParams;
	}
	
	public static List<TaskCommandDefinition> getTaskCommandNames() {
		taskCommandDefinitions.clear();
		String path = FoxBPMDesignerUtil.getCachePath() + "taskCommandDefinition.data";
		File cacheFile = new File(path);
		if(cacheFile.exists()) {
			try {
				String resultString = FileUtil.readFile2StringUTF8(cacheFile.getAbsolutePath());
				analysisJson(resultString);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			MessageDialog.openInformation(null, "提示", "未找到缓存的数据变量文件，请同步流程设计器资源");
		}
		return taskCommandDefinitions;
	}
	
	private static void analysisJson(String result) throws JsonProcessingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		String resultString = result;
		JsonNode object= objectMapper.readTree(resultString);
//		System.out.println(resultString);
		
		for(JsonNode js :object){
			TaskCommandDefinitonTo taskCommandDefinitonTo = new TaskCommandDefinitonTo();
			String id = js.get("id")==null?"":js.get("id").asText();
			String name = js.get("name")==null?"":js.get("name").asText();
			String commandClass = js.get("commandClass")==null?"":js.get("commandClass").asText();
			String cmdClass = js.get("filterClass")==null?"":js.get("filterClass").asText();
			String filterClass = js.get("filterClass")==null?"":js.get("filterClass").asText();
			String description = js.get("description")==null?"":js.get("description").asText();
			String type = js.get("type")==null?"":js.get("type").asText();

			taskCommandDefinitonTo.setId(id);
			taskCommandDefinitonTo.setName(name);
			taskCommandDefinitonTo.setCommand(commandClass);
			taskCommandDefinitonTo.setCmd(cmdClass);
			taskCommandDefinitonTo.setFilter(filterClass);
			taskCommandDefinitonTo.setDescription(description);
			taskCommandDefinitonTo.setType(type);
			
			if(!js.get("commandParam").isNull()) {
				ArrayNode dataArray = (ArrayNode)js.get("commandParam");
				
				for(JsonNode json :dataArray){
					//循环添加变量
					CommandParamTo commandParamTo = new CommandParamTo();
					
					String key = json.get("id")==null?"":json.get("id").asText();
					String paramName = json.get("name")==null?"":json.get("name").asText();
					String paramDescription = json.get("description")==null?"":json.get("description").asText();
					String bizType = json.get("bizType")==null?"":json.get("bizType").asText();
					String dataType = json.get("dataType")==null?"":json.get("dataType").asText();
					String expressionId = json.get("expression")==null?"":json.get("expression").asText();
					String expressionText = json.get("expression")==null?"":json.get("expression").asText();
					
					commandParamTo.setKey(key);
					commandParamTo.setName(paramName);
					commandParamTo.setDescription(paramDescription);
					commandParamTo.setBizType(bizType);
					commandParamTo.setDataType(dataType);
					Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
					expression.setId(expressionId);
					expression.setValue(expressionText);
					commandParamTo.setExpression(expression);
					
					taskCommandDefinitonTo.getCommandParamTos().add(commandParamTo);
				}
			}

			taskCommandDefinitions.add(taskCommandDefinitonTo);
		}
	}
}
