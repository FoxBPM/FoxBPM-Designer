/**
 * 
 */
package org.foxbpm.bpmn.designer.base.model;

/**
 * 
 * @author yangguangftlp
 * @date 2014年7月30日
 */
public class User {
	/** 用户Id */
	private String userId;
	/** 用户名 */
	private String userName;
	/** 用户密码 */
	private String password;
	/** 用户邮件 */
	private String email;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
