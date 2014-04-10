/**
 */
package org.foxbpm.model.config.foxbpmconfig;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mail Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 邮件信息
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.MailInfo#getMailAddress <em>Mail Address</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.MailInfo#getMailName <em>Mail Name</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.MailInfo#getSmtpHost <em>Smtp Host</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.MailInfo#getSmtpPort <em>Smtp Port</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.MailInfo#getUserName <em>User Name</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.MailInfo#getPassword <em>Password</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getMailInfo()
 * @model extendedMetaData="name='MailInfo'"
 * @generated
 */
public interface MailInfo extends EObject {
	/**
	 * Returns the value of the '<em><b>Mail Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 邮件地址
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mail Address</em>' attribute.
	 * @see #setMailAddress(String)
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getMailInfo_MailAddress()
	 * @model required="true"
	 *        extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getMailAddress();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.foxbpmconfig.MailInfo#getMailAddress <em>Mail Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mail Address</em>' attribute.
	 * @see #getMailAddress()
	 * @generated
	 */
	void setMailAddress(String value);

	/**
	 * Returns the value of the '<em><b>Mail Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 邮箱名称
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mail Name</em>' attribute.
	 * @see #setMailName(String)
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getMailInfo_MailName()
	 * @model required="true"
	 *        extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getMailName();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.foxbpmconfig.MailInfo#getMailName <em>Mail Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mail Name</em>' attribute.
	 * @see #getMailName()
	 * @generated
	 */
	void setMailName(String value);

	/**
	 * Returns the value of the '<em><b>Smtp Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * smtp主机地址
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Smtp Host</em>' attribute.
	 * @see #setSmtpHost(String)
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getMailInfo_SmtpHost()
	 * @model required="true"
	 *        extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getSmtpHost();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.foxbpmconfig.MailInfo#getSmtpHost <em>Smtp Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Smtp Host</em>' attribute.
	 * @see #getSmtpHost()
	 * @generated
	 */
	void setSmtpHost(String value);

	/**
	 * Returns the value of the '<em><b>Smtp Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * smtp端口号
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Smtp Port</em>' attribute.
	 * @see #setSmtpPort(String)
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getMailInfo_SmtpPort()
	 * @model required="true"
	 *        extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getSmtpPort();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.foxbpmconfig.MailInfo#getSmtpPort <em>Smtp Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Smtp Port</em>' attribute.
	 * @see #getSmtpPort()
	 * @generated
	 */
	void setSmtpPort(String value);

	/**
	 * Returns the value of the '<em><b>User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 用户名
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>User Name</em>' attribute.
	 * @see #setUserName(String)
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getMailInfo_UserName()
	 * @model required="true"
	 *        extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getUserName();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.foxbpmconfig.MailInfo#getUserName <em>User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Name</em>' attribute.
	 * @see #getUserName()
	 * @generated
	 */
	void setUserName(String value);

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 密码
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getMailInfo_Password()
	 * @model required="true"
	 *        extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.foxbpmconfig.MailInfo#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

} // MailInfo
