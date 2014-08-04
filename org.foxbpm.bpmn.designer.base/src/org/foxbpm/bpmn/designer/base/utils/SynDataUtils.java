/**
 * 
 */
package org.foxbpm.bpmn.designer.base.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.foxbpm.bpmn.designer.base.model.Group;
import org.foxbpm.bpmn.designer.base.model.User;
import org.restlet.data.ChallengeScheme;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

/**
 * 数据同步工具类
 * 
 * @author yangguangftlp
 * @date 2014年7月30日
 */
public class SynDataUtils {

	private static SynDataUtils instance;

	private SynDataUtils() {
	}

	public static SynDataUtils getInstance() {
		if (null == instance) {
			synchronized (SynDataUtils.class) {
				instance = new SynDataUtils();
			}
		}
		return instance;
	}

	@SuppressWarnings({ "unchecked" })
	public void sysData(String servicePath) {
		Connection connection = null;

		try {
			// 组织数据
			ClientResource client = FoxBPMDesignerUtil.getClientByUrl("identity/allGroups");
			client.setChallengeResponse(ChallengeScheme.HTTP_BASIC, "111", "111");
			Representation result = client.get();
			List<Group> groups = (ArrayList<Group>) JsonDataUtil.getInstance().analysisJsonToObj(result.getText(), Group.class);
			// 用户数据
			client = FoxBPMDesignerUtil.getClientByUrl("identity/allUsers");
			client.setChallengeResponse(ChallengeScheme.HTTP_BASIC, "111", "111");
			result = client.get();
			List<User> users = (ArrayList<User>) JsonDataUtil.getInstance().analysisJsonToObj(result.getText(), User.class);

			connection = SQLiteUtil.getInstance().createConnection();
			Statement statement = connection.createStatement();
			StringBuffer sql = new StringBuffer();
			// 清空表数据
			sql.append("DROP TABLE IF EXISTS au_orginfo;\n");
			sql.append("DROP TABLE IF EXISTS au_userinfo;\n");
			statement.executeUpdate(sql.toString());
			sql.delete(0, sql.length());

			// 创建组织表
			sql.append("CREATE TABLE `au_orginfo` (");
			sql.append("`ORGID` varchar(64) NOT NULL,");
			sql.append("`SUPORGID` varchar(512),");
			sql.append("`ORGNAME` varchar(512),");
			sql.append("`GROUPTYPE` varchar(512),");
			sql.append("PRIMARY KEY  (`ORGID`)");
			sql.append(");");

			// 创建用户
			sql.append("CREATE TABLE `au_userinfo` (");
			sql.append("`USERID` varchar(64) NOT NULL ,");
			sql.append("`USERNAME` varchar(512),");
			sql.append("`PASSWORD` varchar(512),");
			sql.append("`EMAIL` varchar(250),");
			sql.append("PRIMARY KEY  (`USERID`)");
			sql.append(");");

			// 批量创建表
			statement.executeUpdate(sql.toString());
			sql.delete(0, sql.length());
			// 插入表数据
			for (Group group : groups) {
				sql.append("insert into au_orginfo values(");
				sql.append("'").append(group.getGroupId()).append("'").append(",");
				sql.append("'").append(group.getGroupName()).append("'").append(",");
				sql.append("'").append(group.getSupGroupId()).append("'").append(",");
				sql.append("'").append(group.getGroupType()).append("'").append(");");
				sql.append("\n");
			}

			for (User user : users) {
				sql.append("insert into au_userinfo values(");
				sql.append("'").append(user.getUserId()).append("'").append(",");
				sql.append("'").append(user.getUserName()).append("'").append(",");
				sql.append("'").append(user.getPassword()).append("'").append(",");
				sql.append("'").append(user.getEmail()).append("'").append(");");
				sql.append("\n");
			}
			System.out.println("synData sql is " + sql.toString());
			// 批量提交sql
			statement.executeUpdate(sql.toString());
			// 提交
			connection.commit();
		} catch (Exception e) {
			MessageDialog.openInformation(null, "提示", "未知错误，错误原因：\n" + e.getMessage());
			try {
				if (null != connection) {
					connection.rollback();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				// 关闭连接
				if (null != connection) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
