/**
 */
package org.foxbpm.model.config.foxbpmconfig;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sys Mail Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 系统邮件配置
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.SysMailConfig#getMailInfo <em>Mail Info</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.SysMailConfig#getSelected <em>Selected</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getSysMailConfig()
 * @model extendedMetaData="name='SysMailConfig'"
 * @generated
 */
public interface SysMailConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Mail Info</b></em>' containment reference list.
	 * The list contents are of type {@link org.foxbpm.model.config.foxbpmconfig.MailInfo}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 邮件信息集合
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mail Info</em>' containment reference list.
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getSysMailConfig_MailInfo()
	 * @model containment="true"
	 *        extendedMetaData="kind='element'"
	 * @generated
	 */
	EList<MailInfo> getMailInfo();

	/**
	 * Returns the value of the '<em><b>Selected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 选中正在使用的发送邮箱
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Selected</em>' attribute.
	 * @see #setSelected(String)
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getSysMailConfig_Selected()
	 * @model required="true"
	 *        extendedMetaData="name='selected' kind='attribute'"
	 * @generated
	 */
	String getSelected();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.foxbpmconfig.SysMailConfig#getSelected <em>Selected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selected</em>' attribute.
	 * @see #getSelected()
	 * @generated
	 */
	void setSelected(String value);

} // SysMailConfig
