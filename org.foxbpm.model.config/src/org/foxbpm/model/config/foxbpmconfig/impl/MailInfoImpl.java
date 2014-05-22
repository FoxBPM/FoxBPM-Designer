/**
 */
package org.foxbpm.model.config.foxbpmconfig.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage;
import org.foxbpm.model.config.foxbpmconfig.MailInfo;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mail Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.MailInfoImpl#getMailAddress <em>Mail Address</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.MailInfoImpl#getMailName <em>Mail Name</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.MailInfoImpl#getSmtpHost <em>Smtp Host</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.MailInfoImpl#getSmtpPort <em>Smtp Port</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.MailInfoImpl#getUserName <em>User Name</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.MailInfoImpl#getPassword <em>Password</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MailInfoImpl extends BaseConfigImpl implements MailInfo {
	/**
	 * The default value of the '{@link #getMailAddress() <em>Mail Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMailAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String MAIL_ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMailAddress() <em>Mail Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMailAddress()
	 * @generated
	 * @ordered
	 */
	protected String mailAddress = MAIL_ADDRESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMailName() <em>Mail Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMailName()
	 * @generated
	 * @ordered
	 */
	protected static final String MAIL_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMailName() <em>Mail Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMailName()
	 * @generated
	 * @ordered
	 */
	protected String mailName = MAIL_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSmtpHost() <em>Smtp Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSmtpHost()
	 * @generated
	 * @ordered
	 */
	protected static final String SMTP_HOST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSmtpHost() <em>Smtp Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSmtpHost()
	 * @generated
	 * @ordered
	 */
	protected String smtpHost = SMTP_HOST_EDEFAULT;

	/**
	 * The default value of the '{@link #getSmtpPort() <em>Smtp Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSmtpPort()
	 * @generated
	 * @ordered
	 */
	protected static final String SMTP_PORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSmtpPort() <em>Smtp Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSmtpPort()
	 * @generated
	 * @ordered
	 */
	protected String smtpPort = SMTP_PORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getUserName() <em>User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserName()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserName() <em>User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserName()
	 * @generated
	 * @ordered
	 */
	protected String userName = USER_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected String password = PASSWORD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MailInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FoxBPMConfigPackage.Literals.MAIL_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMailAddress() {
		return mailAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMailAddress(String newMailAddress) {
		String oldMailAddress = mailAddress;
		mailAddress = newMailAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.MAIL_INFO__MAIL_ADDRESS, oldMailAddress, mailAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMailName() {
		return mailName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMailName(String newMailName) {
		String oldMailName = mailName;
		mailName = newMailName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.MAIL_INFO__MAIL_NAME, oldMailName, mailName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSmtpHost() {
		return smtpHost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSmtpHost(String newSmtpHost) {
		String oldSmtpHost = smtpHost;
		smtpHost = newSmtpHost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.MAIL_INFO__SMTP_HOST, oldSmtpHost, smtpHost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSmtpPort() {
		return smtpPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSmtpPort(String newSmtpPort) {
		String oldSmtpPort = smtpPort;
		smtpPort = newSmtpPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.MAIL_INFO__SMTP_PORT, oldSmtpPort, smtpPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserName(String newUserName) {
		String oldUserName = userName;
		userName = newUserName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.MAIL_INFO__USER_NAME, oldUserName, userName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassword(String newPassword) {
		String oldPassword = password;
		password = newPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.MAIL_INFO__PASSWORD, oldPassword, password));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FoxBPMConfigPackage.MAIL_INFO__MAIL_ADDRESS:
				return getMailAddress();
			case FoxBPMConfigPackage.MAIL_INFO__MAIL_NAME:
				return getMailName();
			case FoxBPMConfigPackage.MAIL_INFO__SMTP_HOST:
				return getSmtpHost();
			case FoxBPMConfigPackage.MAIL_INFO__SMTP_PORT:
				return getSmtpPort();
			case FoxBPMConfigPackage.MAIL_INFO__USER_NAME:
				return getUserName();
			case FoxBPMConfigPackage.MAIL_INFO__PASSWORD:
				return getPassword();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FoxBPMConfigPackage.MAIL_INFO__MAIL_ADDRESS:
				setMailAddress((String)newValue);
				return;
			case FoxBPMConfigPackage.MAIL_INFO__MAIL_NAME:
				setMailName((String)newValue);
				return;
			case FoxBPMConfigPackage.MAIL_INFO__SMTP_HOST:
				setSmtpHost((String)newValue);
				return;
			case FoxBPMConfigPackage.MAIL_INFO__SMTP_PORT:
				setSmtpPort((String)newValue);
				return;
			case FoxBPMConfigPackage.MAIL_INFO__USER_NAME:
				setUserName((String)newValue);
				return;
			case FoxBPMConfigPackage.MAIL_INFO__PASSWORD:
				setPassword((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FoxBPMConfigPackage.MAIL_INFO__MAIL_ADDRESS:
				setMailAddress(MAIL_ADDRESS_EDEFAULT);
				return;
			case FoxBPMConfigPackage.MAIL_INFO__MAIL_NAME:
				setMailName(MAIL_NAME_EDEFAULT);
				return;
			case FoxBPMConfigPackage.MAIL_INFO__SMTP_HOST:
				setSmtpHost(SMTP_HOST_EDEFAULT);
				return;
			case FoxBPMConfigPackage.MAIL_INFO__SMTP_PORT:
				setSmtpPort(SMTP_PORT_EDEFAULT);
				return;
			case FoxBPMConfigPackage.MAIL_INFO__USER_NAME:
				setUserName(USER_NAME_EDEFAULT);
				return;
			case FoxBPMConfigPackage.MAIL_INFO__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FoxBPMConfigPackage.MAIL_INFO__MAIL_ADDRESS:
				return MAIL_ADDRESS_EDEFAULT == null ? mailAddress != null : !MAIL_ADDRESS_EDEFAULT.equals(mailAddress);
			case FoxBPMConfigPackage.MAIL_INFO__MAIL_NAME:
				return MAIL_NAME_EDEFAULT == null ? mailName != null : !MAIL_NAME_EDEFAULT.equals(mailName);
			case FoxBPMConfigPackage.MAIL_INFO__SMTP_HOST:
				return SMTP_HOST_EDEFAULT == null ? smtpHost != null : !SMTP_HOST_EDEFAULT.equals(smtpHost);
			case FoxBPMConfigPackage.MAIL_INFO__SMTP_PORT:
				return SMTP_PORT_EDEFAULT == null ? smtpPort != null : !SMTP_PORT_EDEFAULT.equals(smtpPort);
			case FoxBPMConfigPackage.MAIL_INFO__USER_NAME:
				return USER_NAME_EDEFAULT == null ? userName != null : !USER_NAME_EDEFAULT.equals(userName);
			case FoxBPMConfigPackage.MAIL_INFO__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mailAddress: ");
		result.append(mailAddress);
		result.append(", mailName: ");
		result.append(mailName);
		result.append(", smtpHost: ");
		result.append(smtpHost);
		result.append(", smtpPort: ");
		result.append(smtpPort);
		result.append(", userName: ");
		result.append(userName);
		result.append(", password: ");
		result.append(password);
		result.append(')');
		return result.toString();
	}

} //MailInfoImpl
