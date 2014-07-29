package org.foxbpm.bpmn.designer.ui.dialogs.dataimport;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.foxbpm.model.bpmn.foxbpm.DataVariable;

public class DataObjImportImpl implements DataObjImport,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2477400626645302950L;



	protected String id;
	
	

	protected String name;
	
	protected String type;
	
	protected String filePath;
	
	protected List<DataVariable> dataVariables = new ArrayList<DataVariable>();
	
	

	protected List<DataVariableImport> dataVariableImports;
	

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getType() {
		return this.type;
	}

	@Override
	public List<DataVariableImport> getDataVariableList(EObject be, String type) {

			
			
			this.dataVariableImports=new ArrayList<DataVariableImport>();
					
			getDataVariables(be, type);


		
			return this.dataVariableImports;
	}
	
	
	private void getDataVariables(EObject be, String type)
	{
//		
//		FileInputStream fis=null;
//		try {
//			fis = new FileInputStream(filePath);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		Document document=null;
//		try {
//			document = XmlUtil.read(fis, "UTF-8");
//		} catch (DocumentException e) {
//			e.printStackTrace();
//		}
//		
//		// 一配置文件代表一个数据对象。
//		Element dataObj = document.getRootElement();
//		
//		
//
//		// 获取列信息
//		@SuppressWarnings("unchecked")
//		List<Element> properties = dataObj.elements("property");
//		
//		List<Element> propertiesFlow = dataObj.elements("relfixflow");
//		String processIdString=BpmnModelUtil.getProcessByEobj(be).getId();
//		String bizId=XmlUtil.getAttributeValue(dataObj.attribute("id"));
//		//String bizName=XmlUtil.getAttributeValue(dataObj.attribute("name"));
//		DataVariableImportImpl column1 = new DataVariableImportImpl();
//		column1.setId("Fix_BizName");
//		column1.setName("Fix_BizName");
//		column1.setDataType("String");
//		column1.setVariableValue("\""+bizId+"\"");
//		column1.setBizType("bizObjVariable");
//		
//		this.dataVariableImports.add(column1);
//		
//		
//		
//		DataVariableImportImpl column2 = new DataVariableImportImpl();
//		column2.setId("Fix_BizKeyFile");
//		column2.setName("Fix_BizKeyFile");
//		column2.setDataType("String");
//		column2.setVariableValue("");
//		column2.setBizType("relatedFieldVariable");
//		this.dataVariableImports.add(column2);
//		
//		/*
//		for (Element element : propertiesFlow) {
//			
//			if(XmlUtil.getAttributeValue(element.attribute("processDefinitionKey")).equals(processIdString)){
//				column2.setVariableValue("\""+XmlUtil.getAttributeValue(element.attribute("processBusinessField"))+"\"");
//
//			}
//			
//		}*/
//		
//		//
//		
//		if (properties != null) {
//			for (Element tmp : properties) {
//				DataVariableImportImpl column = new DataVariableImportImpl();
//				Attribute pid = tmp.attribute("id");
//				column.setId(XmlUtil.getAttributeValue(pid));
//				Attribute pname = tmp.attribute("name");
//				column.setName(XmlUtil.getAttributeValue(pname));
//				
//				Attribute datatype = tmp.attribute("dataType");
//				column.setDataType(XmlUtil.getAttributeValue(datatype));
//				if(type.equals("db")){
//					column.setBizType("dataBaseVariable");
//					
//					//FixCSForm
//					String expressionString=FixFlowConfigUtil.getImportDataVariable("FixCSDB").getExpression();
//					//expressionString=expressionString.replaceAll("#{DataBaseId}", dataBaseId);
//					//expressionString=expressionString.replaceAll("#{BizObjName}", tableName);
//					expressionString=expressionString.replace("#{FieldName}", XmlUtil.getAttributeValue(pid));
//					
//					
//					column.setVariableValue(expressionString);
//				}
//				else{
//					column.setBizType("formVariable");
//					String expressionString=FixFlowConfigUtil.getImportDataVariable("FixCSForm").getExpression();
//					//expressionString=expressionString.replaceAll("#{DataBaseId}", dataBaseId);
//					//expressionString=expressionString.replaceAll("#{BizObjName}", tableName);
//					expressionString=expressionString.replace("#{FieldName}", XmlUtil.getAttributeValue(pid));
//					column.setVariableValue(expressionString);
//				}
//				
//				
//				
//				this.dataVariableImports.add(column);
//			}
//		}
//		
//		//Object bizData.getMasterValue("defkey","bizkey","字段名称");
//		//<relfixflow processDefinitionKey="mydemo" processBusinessField="ID" name="Default Process" enable="1"/>
//		//(processInfo.getProcessDefinitionKey(),processInfo.getBizKey(),)
//		
		
	}

	@Override
	public String getFilePath() {
		return this.filePath;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<DataVariable> getDataVariables() {
		return dataVariables;
	}

	public void setDataVariables(List<DataVariable> dataVariables) {
		this.dataVariables = dataVariables;
	}

}
