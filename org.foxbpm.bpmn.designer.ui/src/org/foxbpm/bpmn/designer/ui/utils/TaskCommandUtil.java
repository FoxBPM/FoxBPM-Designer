package org.foxbpm.bpmn.designer.ui.utils;

import java.util.ArrayList;
import java.util.List;

import org.foxbpm.bpmn.designer.ui.custom.CommandParamTo;
import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;
import org.foxbpm.model.config.foxbpmconfig.CommandParam;
import org.foxbpm.model.config.foxbpmconfig.TaskCommandDefinition;

public class TaskCommandUtil {
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
}
