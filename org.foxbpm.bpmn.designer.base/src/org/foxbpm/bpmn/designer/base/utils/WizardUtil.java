/**
 * Copyright 1996-2014 FoxBPM ORG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * @author MAENLIANG
 */
package org.foxbpm.bpmn.designer.base.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.widgets.Combo;

/**
 * 
 * @author MAENLIANG
 * 
 */
public class WizardUtil {
	/**
	 * 给combo设置键值并返回模板信息的map
	 * 
	 * @param combo
	 * @return
	 */
	public static Map<String, Object> getModelInfoForWizard(Combo combo) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] str = new String[]{};
		List<String> strs = new ArrayList<String>();
		String root = FoxBPMDesignerUtil.getFlowTempletePath();
		File file = new File(root);
		if (file.exists()) {
			fileList(file, strs, root, map, combo);
			str = (String[]) strs.toArray(new String[strs.size()]);
			map.put("comboStrs", str);
		}
		
		return map;
	}
	
	/**
	 * 递归查模板
	 * 
	 * @param file
	 * @param strs
	 * @param root
	 * @param map
	 * @param combo
	 */
	public static void fileList(File file, List<String> strs, String root, Map<String, Object> map,
	    Combo combo) {
		if (file == null || !file.exists()) {
			return;
		}
		for (File files : file.listFiles()) {
			if (files.isDirectory()) {
				fileList(files, strs, root, map, combo);
			} else if (files.isFile() && files.getName().endsWith(".properties")) {
				Map<String, Object> hashmap = PropertiesUtil.readProperties(files.getAbsolutePath());
				String modelname = new String(StringUtil.getString(hashmap.get("model_name").toString()));
				String modelid = new String(StringUtil.getString(hashmap.get("model_id").toString()));
				strs.add(modelname);
				combo.setData(modelname, modelid);
				map.put(modelid, hashmap);
			}
		}
	}
	
	/**
	 * 拿到模板的根路径
	 * 
	 * @return
	 */
	public static String getModelPath() {
		String root = FoxBPMDesignerUtil.getFlowTempletePath();
		return root;
	}
}
