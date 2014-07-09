package org.foxbpm.bpmn.designer.ui.dialogs;

import org.foxbpm.bpmn.designer.ui.tree.EntityElement;
import org.foxbpm.bpmn.designer.ui.tree.ITreeElement;

public class DataVarTo extends EntityElement{
	private String id;
	private String icon;
	private String type;
	private String doc;
	private String value;
	private String cantbechoose;
	private String bizType;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDoc() {
		return doc;
	}
	public void setDoc(String doc) {
		this.doc = doc;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public void addChild(ITreeElement treeElement) {
		super.addChild(treeElement);
	}
	public String getCantbechoose() {
		return cantbechoose;
	}
	public void setCantbechoose(String cantbechoose) {
		this.cantbechoose = cantbechoose;
	}
	public String getBizType() {
		return bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
}
