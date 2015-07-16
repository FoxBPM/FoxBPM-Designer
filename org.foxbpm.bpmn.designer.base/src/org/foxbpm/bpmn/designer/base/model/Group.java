/**
 * 
 */
package org.foxbpm.bpmn.designer.base.model;

/**
 * @author Administrator
 * 
 */
public class Group {
	/** 组Id */
	private String groupId;
	/** 组名称 */
	private String groupName;
	/** 父组Id */
	private String supGroupId;
	/** 组类型 */
	private String groupType;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getSupGroupId() {
		return supGroupId;
	}

	public void setSupGroupId(String supGroupId) {
		this.supGroupId = supGroupId;
	}

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

}
