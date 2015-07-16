package org.foxbpm.bpmn.designer.base.utils;

public class CreateJavaClassUtil {

	protected String attribute = "";
	protected String setter = "";
	protected String getter = "";
	protected String className = "";
	protected String executeConnector = "";
	protected String packageName = "";
	protected String importValue = "";
	protected String implement = "";
	protected String extend = "";

	public CreateJavaClassUtil() {
		implement = "FlowConnectorHandler";
		extend = "ActorConnectorHandler";
	}
	
	public void createAttribute(String type, String name) {
		attribute = attribute + "\tprivate " + type + " " + name + ";\n\n";
	}

	public void createSetter(String type, String name) {
		setter = setter + "\tpublic void  set"
				+ name.substring(0, 1).toUpperCase()
				+ name.substring(1, name.length()) + "(" + type + " " + name
				+ "){\n\t\tthis." + name + " = " + name + ";\n\t}\n\n";
	}

	public void createGetter(String type, String name) {
		getter = getter + "\tpublic " + type + "  get"
				+ name.substring(0, 1).toUpperCase()
				+ name.substring(1, name.length())
				+ "(){\n\t\treturn null ;\n\t}\n\n";
	}

	public void createInputCode(String type, String name) {
		createAttribute(type, name);
		createSetter(type, name);
		// + createGetter(type, name);
	}

	public void createOutputCode(String type, String name) {
		createGetter(type, name);
		// + createGetter(type, name);
	}

	public void createExecuteConnector() {
		this.executeConnector = "\tpublic void execute(ConnectorExecutionContext executionContext) throws Exception {\n\n\t}\n\n";
	}
	
	public void createExecuteActorConnector() {
		this.executeConnector = "\tpublic void assign(DelegateTask task) throws Exception {\n\n\t}\n\n";
//		this.executeConnector = "\t/**\r\n" +
//								 "\t* 获取用户类型处理者\r\n" +
//								 "\t* @param executionContext 流程上下文\r\n" +
//								 "\t* @return\r\n" +
//								 "\t*/\r\n";
//		this.executeConnector += "\tpublic List<UserTo> UserExecute(ExecutionContext executionContext) {\n\t\tList<UserTo> userTos = new ArrayList<UserTo>();\r\n" +
//								 "\t\t//加入UserTo UserTo userTo = new UserTo(\"用户编号\");\r\n\t\treturn userTos;\n\t}\n\n";
//		this.executeConnector += "\t/**\r\n" +
//								 "\t* 获取组类型处理者\r\n" +
//								 "\t* @param executionContext 流程上下文\r\n" +
//								 "\t* @return\r\n" +
//								 "\t*/\r\n";
//		this.executeConnector += "\tpublic List<GroupTo> GroupExecute(ExecutionContext executionContext) {\n"
//				+ "\t\tList<GroupTo> groupTos = new ArrayList<GroupTo>();\r\n"
//				+ "\t\t//加入Group 	GroupTo groupTo = new GroupTo(\"组编号\", \"组类型\");\r\n\t\treturn groupTos;\n\t}\n\n";
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String generateJavaCode() {
		String codeString = packageName + "\n\n" + this.importValue
				+ "\n\npublic class " + this.className
				+ " implements " + implement + " {\n\n" + attribute
				+ executeConnector + setter + getter + "}";
		return codeString;
	}
	
	public String generateActorJavaCode() {
		String codeString = packageName + "\n\n" + this.importValue
				+ "\n\npublic class " + this.className
				+ " extends " + extend + " {\n\n" + attribute
				+ executeConnector + setter + getter + "}";
		return codeString;
	}

	public void setPackageName(String packageName) {
		this.packageName = "package " + packageName + ";";
	}

	public void createImport(String importValue) {
		this.importValue = this.importValue + "\nimport " + importValue;
	}

	public String getImplement() {
		return implement;
	}

	public void setImplement(String implement) {
		this.implement = implement;
	}

	public static void main(String[] args) {
		CreateJavaClassUtil createJavaClassUtil = new CreateJavaClassUtil();
		createJavaClassUtil.createInputCode("int", "字段1");
		createJavaClassUtil.createInputCode("String", "字段2");
		createJavaClassUtil.createOutputCode("int", "输出字段");
		createJavaClassUtil.setClassName("HelloKenshin");
		createJavaClassUtil.setImplement("ActorConnectorHandler");
		createJavaClassUtil.createExecuteActorConnector();
		createJavaClassUtil
				.setPackageName("org.foxbpm.core.connector");
		createJavaClassUtil.createImport("java.util.*");
		createJavaClassUtil
				.createImport("org.foxbpm.core.connector.ActorConnectorHandler;");
		createJavaClassUtil
				.createImport("org.foxbpm.core.impl.identity.GroupTo;");
		createJavaClassUtil
				.createImport("org.foxbpm.core.impl.identity.UserTo;");
		createJavaClassUtil
				.createImport("org.foxbpm.core.runtime.ExecutionContext;");
		System.out.print(createJavaClassUtil.generateJavaCode());
	}

}
