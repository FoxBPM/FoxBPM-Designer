/**
 * 
 */
package org.foxbpm.bpmn.designer.base.utils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.foxbpm.bpmn.designer.base.utils.FoxBPMDesignerUtil;
import org.foxbpm.bpmn.designer.base.model.*;
import org.foxbpm.bpmn.designer.base.utils.SQLiteUtil;
import org.restlet.resource.ClientResource;

/**
 * @author Administrator
 * 
 */
public class JsonDataUtil {
	private static JsonDataUtil instance;

	private JsonDataUtil() {
	}

	public static JsonDataUtil getInstance() {
		if (null == instance) {
			synchronized (SQLiteUtil.class) {
				instance = new JsonDataUtil();
			}
		}
		return instance;
	}

	/**
	 * 解析json 数据中data部分
	 * 
	 * @param jsonString
	 *            jsong 数据
	 * @param cls
	 *            Class
	 * @return 返回转换后的实体
	 * @throws JsonProcessingException
	 * @throws IOException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList analysisJsonToObj(String jsonString, Class cls) throws JsonProcessingException, IOException, InstantiationException,
			IllegalAccessException {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode object = objectMapper.readTree(jsonString);
		ArrayNode dataArray = (ArrayNode) object.get("data");
		ArrayList datas = new ArrayList();
		if (null != dataArray && null != cls) {
			Object obj = null;
			Field[] fields = null;
			for (JsonNode json : dataArray) {
				fields = cls.getDeclaredFields();
				if (null == fields) {
					continue;
				}
				for (Field field : fields) {
					if (null != json.get(field.getName())) {
						field.setAccessible(true);
						if (null == obj) {
							obj = cls.newInstance();
						}
						field.set(obj, json.get(field.getName()).asText());
					}
				}
				if (null != obj) {
					datas.add(obj);
					obj = null;
				}
			}
		}
		return datas;
	}

	public List<GroupDefine> getGroupDefine() {
		List<GroupDefine> groupDefine = new ArrayList<GroupDefine>();
		FoxBPMDesignerUtil.getClientByUrl("");
		return null;
	}
}
