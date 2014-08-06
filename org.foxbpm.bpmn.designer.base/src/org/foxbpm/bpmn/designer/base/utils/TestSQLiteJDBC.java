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
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * @author yangguangftlp
 @date 2014年7月30日
 */
public class TestSQLiteJDBC {
	boolean isOk;
	static {
		System.out.println(System.getProperty("java.io.tmpdir"));
		System.out.println(System.getProperty("java.library.path"));
		//System.loadLibrary("sqlite_jni");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// 连接SQLite的JDBC
			//Class.forName("SQLite.JDBCDriver");
			Class.forName("org.sqlite.JDBC");

			// 建立一个数据库名zieckey.db的连接，如果不存在就在当前目录下创建之

			Connection conn = DriverManager
					.getConnection("jdbc:sqlite:/Users/kenshin/GIT/FoxBPM-Designer/org.foxbpm.bpmn.designer.base/src/org/foxbpm/bpmn/designer/base/utils/database.db");
			Statement stat = conn.createStatement();
			
			stat.executeUpdate("create table tbl1(name varchar(20), salary int);");// 创建一个表，两列
			stat.executeUpdate("insert into tbl1 values('ZhangSan',8000);insert into tbl1 values('aa',1200);"); // 插入数据
			stat.executeUpdate("insert into tbl1 values('LiSi',7800);");
			stat.executeUpdate("insert into tbl1 values('WangWu',5800);");
			stat.executeUpdate("insert into tbl1 values('ZhaoLiu',9100);");
			ResultSet rs = stat.executeQuery("select * from tbl1;"); // 查询数据
			while (rs.next()) { // 将查询到的数据打印出来
				System.out.print("name = " + rs.getString("name") + " "); // 列属性一
				System.out.println("salary = " + rs.getString("salary")); // 列属性二
			}
			rs.close();
			conn.close(); // 结束数据库的连接

		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
