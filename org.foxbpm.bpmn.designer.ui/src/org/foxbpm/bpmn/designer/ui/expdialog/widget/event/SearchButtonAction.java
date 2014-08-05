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
package org.foxbpm.bpmn.designer.ui.expdialog.widget.event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.foxbpm.bpmn.designer.base.utils.SQLiteUtil;
import org.foxbpm.bpmn.designer.base.utils.StringUtil;

/**
 * 组织结构搜索按钮事件处理
 * 
 * @author yangguangftlp
 * @date 2014年7月31日
 */
public class SearchButtonAction extends SelectionAdapter {

	private Text text;
	private Group orgGroup;
	private TableViewer tableViewer;

	public SearchButtonAction(Text text, Group orgGroup, TableViewer tableViewer) {
		this.text = text;
		this.orgGroup = orgGroup;
		this.tableViewer = tableViewer;
	}

	public void widgetSelected(SelectionEvent event) {
		Control[] controls = orgGroup.getChildren();
		String type = null;
		Button button = null;
		for (Control control : controls) {
			button = (Button) control;
			if (button.getSelection()) {
				type = StringUtil.getString(button.getData("type"));
				break;
			}
		}
		if (!StringUtil.isEmpty(type) && !StringUtil.isEmpty(text.getText())) {
			Connection connection = null;
			try {
				StringBuffer sql = new StringBuffer("select * from ");

				if ("user".equals(type)) {
					sql.append("au_userinfo ");
					sql.append("where USERID like ? or USERNAME like ?");
				} else {
					sql.append("au_orginfo where GROUPType='" + type + "' ");
					sql.append(" and (ORGID like ? or ORGNAME like ?)");
				}
				connection = SQLiteUtil.getInstance().createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
				preparedStatement.setString(1, '%' + text.getText() + '%');
				preparedStatement.setString(2, '%' + text.getText() + '%');
				ResultSet resultSet = preparedStatement.executeQuery();

				ArrayList<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
				Map<String, String> dataMap = new HashMap<String, String>();
				while (resultSet.next()) {
					dataMap = new HashMap<String, String>();
					dataMap.put("1", resultSet.getString(1));
					dataMap.put("2", resultSet.getString(2));
					dataList.add(dataMap);
				}
				tableViewer.setInput(dataList);
				tableViewer.refresh();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (null != connection) {
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
