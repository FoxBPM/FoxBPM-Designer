package org.foxbpm.bpmn.designer.ui.connector.definition;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.foxbpm.bpmn.designer.base.utils.CreateJavaClassUtil;
import org.foxbpm.model.config.connector.ConnectorDefinition;
import org.foxbpm.model.config.connector.Input;
import org.foxbpm.model.config.connector.Output;


public class CreateFlowConnectorJava {
	public static InputStream CreateConnectorJavaClassReturnInputStream(
			ConnectorDefinition connector) {
		InputStream inputStream = (InputStream) (new ByteArrayInputStream(
				CreateConnectorJavaClassReturnString(connector).getBytes()));
		return inputStream;
	}

	public static InputStream CreateActorConnectorJavaClassReturnInputStream(
			ConnectorDefinition connector) {
		InputStream inputStream = (InputStream) (new ByteArrayInputStream(
				CreateActorConnectorJavaClassReturnString(connector).getBytes()));
		return inputStream;
	}

	public static String CreateConnectorJavaClassReturnString(
			ConnectorDefinition connector) {
		CreateJavaClassUtil createJavaClassUtil = new CreateJavaClassUtil();

		for (Input input : connector.getInput()) {
			createJavaClassUtil.createInputCode(input.getType(), input.getId());
		}

		for (Output output : connector.getOutput()) {
			createJavaClassUtil.createOutputCode(output.getType(),
					output.getId());
		}

		createJavaClassUtil.setClassName(connector.getDefinitionImpl()
				.getClassName());
		createJavaClassUtil.createExecuteConnector();
		createJavaClassUtil.setPackageName(connector.getDefinitionImpl()
				.getPackageName());
		createJavaClassUtil
				.createImport("org.foxbpm.engine.execution.ConnectorExecutionContext;");
		createJavaClassUtil
				.createImport("org.foxbpm.engine.impl.connector.FlowConnectorHandler;");

		String javaCodeString = createJavaClassUtil.generateJavaCode();
		return javaCodeString;
	}

	public static String CreateActorConnectorJavaClassReturnString(
			ConnectorDefinition connector) {
		CreateJavaClassUtil createJavaClassUtil = new CreateJavaClassUtil();

		for (Input input : connector.getInput()) {
			createJavaClassUtil.createInputCode(input.getType(), input.getId());
		}

		for (Output output : connector.getOutput()) {
			createJavaClassUtil.createOutputCode(output.getType(),
					output.getId());
		}

		createJavaClassUtil.setClassName(connector.getDefinitionImpl()
				.getClassName());
		createJavaClassUtil.createExecuteActorConnector();
		createJavaClassUtil.setPackageName(connector.getDefinitionImpl()
				.getPackageName());
		createJavaClassUtil
				.createImport("org.foxbpm.engine.impl.connector.ActorConnectorHandler;");
		createJavaClassUtil
				.createImport("org.foxbpm.engine.task.DelegateTask;");

		String javaCodeString = createJavaClassUtil.generateActorJavaCode();
		return javaCodeString;
	}

	public static byte[] CreateConnectorJavaClassReturnBytes(
			ConnectorDefinition connector) {
		return CreateConnectorJavaClassReturnString(connector).getBytes();
	}
}
