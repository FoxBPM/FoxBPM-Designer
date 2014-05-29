package org.foxbpm.bpmn.designer.ui.utils;

import java.io.File;

public class FileUtil {
	/**
	 * Java文件操作 获取文件扩展名
	 * 
	 * @param filename
	 * @return
	 */
	public static String getExtensionName(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int dot = filename.lastIndexOf('.');
			if ((dot > -1) && (dot < (filename.length() - 1))) {
				return filename.substring(dot + 1);
			}
		}
		return filename;
	}

	/**
	 * 返回文件名
	 * 
	 * @param path
	 * @return
	 */
	public static String getFileName(String path) {
		if (path == null)
			return "";
		File file = new File(path);
		return file.getName();
	}
}
