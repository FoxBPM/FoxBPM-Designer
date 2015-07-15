package org.foxbpm.bpmn.designer.ui.to;

import java.util.ArrayList;
import java.util.List;

import org.foxbpm.bpmn.designer.ui.custom.CommandParamTo;
import org.foxbpm.model.config.foxbpmconfig.impl.TaskCommandDefinitionImpl;

public class TaskCommandDefinitonTo extends TaskCommandDefinitionImpl{
	private List<CommandParamTo> commandParamTos = new ArrayList<CommandParamTo>();

	public List<CommandParamTo> getCommandParamTos() {
		return commandParamTos;
	}

	public void setCommandParamTos(List<CommandParamTo> commandParamTos) {
		this.commandParamTos = commandParamTos;
	}
}
