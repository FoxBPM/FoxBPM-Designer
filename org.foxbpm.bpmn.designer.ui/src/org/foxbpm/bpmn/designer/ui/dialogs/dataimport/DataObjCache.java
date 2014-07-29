package org.foxbpm.bpmn.designer.ui.dialogs.dataimport;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.node.TextNode;
import org.foxbpm.bpmn.designer.base.utils.FileUtil;
import org.foxbpm.bpmn.designer.base.utils.FoxBPMDesignerUtil;
import org.foxbpm.model.bpmn.foxbpm.DataVariable;
import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;
import org.restlet.data.ChallengeScheme;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class DataObjCache {
	
	private static List<DataObjImport> dataObjImports=new ArrayList<DataObjImport>();

	public static List<DataObjImport> getDataObjImports() {
		List<DataObjImport> cacheDataObjImports = new ArrayList<DataObjImport>();
		dataObjImports.clear();
		
		String path = FoxBPMDesignerUtil.getCachePath();
		File cacheFile = new File(path);
		if(cacheFile.exists()) {
			try {
				String resultString = FileUtil.readObject(cacheFile).toString();
				analysisJson(resultString, cacheDataObjImports);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			try {
				ClientResource client = null;
				client = new ClientResource(FoxBPMDesignerUtil.getServicePathPath() + "bizDataObjects/dataBaseMode/foxbpmDataSource");
				client.setChallengeResponse(ChallengeScheme.HTTP_BASIC,"111", "111");
				Representation result = client.get();
				
				String resultString = result.getText();
				analysisJson(resultString, cacheDataObjImports);
				
				try {
					cacheFile.mkdirs();
					cacheFile.createNewFile();
					FileUtil.writeObject(resultString, path);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
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
	private static void analysisJson(String result, List<DataObjImport> cacheDataObjImports) throws JsonProcessingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		String resultString = result;
		JsonNode object= objectMapper.readTree(resultString);
		System.out.println(resultString);
		ArrayNode dataArray = (ArrayNode)object.get("data");
		DataObjImportImpl dataObjImport = new DataObjImportImpl();
		
		for(JsonNode json :dataArray){
			dataObjImport = new DataObjImportImpl();
			dataObjImport.setId(json.get("id")==null?"":json.get("id").asText());
			dataObjImport.setName(json.get("documentation")==null?"":json.get("documentation").asText());
			DataVariable dataVariable = FoxBPMFactory.eINSTANCE.createDataVariable();
			ArrayNode columnArray = (ArrayNode)json.get("dataVariableDefinitions");
			if(columnArray!=null) {
				for(JsonNode columnJson :columnArray){
					dataVariable = FoxBPMFactory.eINSTANCE.createDataVariable();
					dataVariable.setId(columnJson.get("id")==null?"":columnJson.get("id").asText());
					dataVariable.setBizType(columnJson.get("biztype")==null?"":columnJson.get("biztype").asText());
					dataVariable.setIsList(columnJson.get("list")==null?false:columnJson.get("list").asBoolean());
					dataVariable.setIsPersistence(columnJson.get("persistence")==null?false:columnJson.get("persistence").asBoolean());
					
					Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
					expression.setName(columnJson.get("expressionText").asText());
					expression.setValue(columnJson.get("expressionText").asText());
//					System.out.println(expression.getName());
					dataVariable.setExpression(expression);
				}
			}
			dataObjImport.getDataVariables().add(dataVariable);
			dataObjImports.add(dataObjImport);
			cacheDataObjImports.add(dataObjImport);
		}
	}
	

}
