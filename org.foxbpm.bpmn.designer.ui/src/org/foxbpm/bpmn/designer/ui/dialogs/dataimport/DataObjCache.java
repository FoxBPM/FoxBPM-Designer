package org.foxbpm.bpmn.designer.ui.dialogs.dataimport;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.eclipse.jface.dialogs.MessageDialog;
import org.foxbpm.bpmn.designer.base.utils.FileUtil;
import org.foxbpm.bpmn.designer.base.utils.FoxBPMDesignerUtil;
import org.foxbpm.model.bpmn.foxbpm.DataVariable;
import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;

public class DataObjCache {
	
	public static List<DataObjImport> dataObjImports=new ArrayList<DataObjImport>();
	public static List<String> dataVarTypes = new ArrayList<String>();
	public static Map<String, Object> cachemap = new HashMap<String, Object>();
	
	public static List<DataObjImport> getDataObjImports() {
		dataObjImports.clear();
		cachemap.clear();
		dataVarTypes.clear();
		
		String path = FoxBPMDesignerUtil.getCachePath() + "bizData.data";
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
//			try {
//				ClientResource client = FoxBPMDesignerUtil.getClientByUrl("bizDataObjects/dataBaseMode/foxbpmDataSource");
//				if(client==null) {
//					return dataObjImports;
//				}
//				Representation result = client.get();
//				
//				String resultString = result.getText();
//				analysisJson(resultString);
//				
//				try {
//					cacheFile.mkdirs();
//					cacheFile.createNewFile();
//					FileUtil.writeObject(resultString, path);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		}
		
		return dataObjImports;
	}
	
	public static void deleteDataObj (String olderId){

		for (int i = 0; i < dataObjImports.size(); i++) {
			if (dataObjImports.get(i).getId().equals(olderId)) {
				dataObjImports.remove(i);
				break;
			}
		}

	}

	/**
	 * 解析json串转化为业务对象
	 * @param result
	 * @param cacheDataObjImports
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	private static void analysisJson(String result) throws JsonProcessingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		String resultString = result;
		JsonNode object= objectMapper.readTree(resultString);
		System.out.println(resultString);
		
		for(JsonNode js :object){
			String id = js.get("id")==null?"":js.get("id").asText();
			String name = js.get("name")==null?"":js.get("name").asText();
			
			List<DataObjImport> cacheDataObjImports =  new ArrayList<DataObjImport>();
			
			ArrayNode dataArray = (ArrayNode)js.get("data");
			
			for(JsonNode json :dataArray){
				DataObjImportImpl dataObjImport = new DataObjImportImpl();
				dataObjImport.setId(json.get("id")==null?"":json.get("id").asText());
				dataObjImport.setName(json.get("name")==null?"":json.get("name").asText());
				DataVariable dataVariable = FoxBPMFactory.eINSTANCE.createDataVariable();
				ArrayNode columnArray = (ArrayNode)json.get("dataVariableDefinitions");
				if(columnArray!=null) {
					for(JsonNode columnJson :columnArray){
						dataVariable = FoxBPMFactory.eINSTANCE.createDataVariable();
						dataVariable.setId(columnJson.get("id")==null?"":columnJson.get("id").asText());
						dataVariable.setBizType(columnJson.get("bizType")==null?"":columnJson.get("bizType").asText());
						dataVariable.setIsList(columnJson.get("list")==null?false:columnJson.get("list").asBoolean());
						dataVariable.setIsPersistence(columnJson.get("persistence")==null?false:columnJson.get("persistence").asBoolean());
						dataVariable.setDataType(columnJson.get("dataType")==null?"":columnJson.get("dataType").asText());
						
						Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
						expression.setName(columnJson.get("id")==null?"":columnJson.get("id").asText());
						expression.setValue(columnJson.get("expressionText")==null?"":columnJson.get("expressionText").asText());
//						System.out.println(expression.getName());
						dataVariable.setExpression(expression);
						dataObjImport.getDataVariables().add(dataVariable);
					}
				}
				dataObjImports.add(dataObjImport);
				cacheDataObjImports.add(dataObjImport);
			}
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("name", name);
			map.put("dataobjs", cacheDataObjImports);
			cachemap.put(id, map);
			dataVarTypes.add(id);
		}
	}
}
