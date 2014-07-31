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
 * @author yangguangftlp
 */
package org.foxbpm.bpmn.designer.base.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * sqlite数据库操作工具类
 * 
 * @author yangguangftlp
 * @date 2014年7月30日
 */
public class SQLiteUtil {

	private static SQLiteUtil instance;

	private SQLiteUtil() {
		init();
	}

	private void init() {
		try {
			// 自动在java.library.path下加载sqlite_jni.dll
			System.loadLibrary("sqlite_jni");
			// 连接SQLite的JDBC
			Class.forName("SQLite.JDBCDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SQLiteUtil getInstance() {
		if (null == instance) {
			synchronized (SQLiteUtil.class) {
				instance = new SQLiteUtil();
			}
		}
		return instance;
	}

	/**
	 * 创建新连接 注意:该链接需要手动关闭
	 * 
	 * @return 返回新连接
	 * @throws SQLException
	 */
	public Connection createConnection() throws SQLException {
		StringBuffer url = new StringBuffer("jdbc:sqlite:/");
		url.append(FoxBPMDesignerUtil.getServicePath());
		url.append("databasea.db");
		return DriverManager.getConnection(url.toString());
	}
}
