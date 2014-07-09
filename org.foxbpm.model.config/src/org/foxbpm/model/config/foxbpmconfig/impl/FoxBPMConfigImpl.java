/**
 */
package org.foxbpm.model.config.foxbpmconfig.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.foxbpm.model.config.foxbpmconfig.ConnectionManagementConfig;
import org.foxbpm.model.config.foxbpmconfig.EventListenerConfig;
import org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig;
import org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage;
import org.foxbpm.model.config.foxbpmconfig.ResourcePathConfig;
import org.foxbpm.model.config.foxbpmconfig.ScriptLanguageConfig;
import org.foxbpm.model.config.foxbpmconfig.SysMailConfig;
import org.foxbpm.model.config.foxbpmconfig.TaskCommandConfig;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fox BPM Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigImpl#getResourcePathConfig <em>Resource Path Config</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigImpl#getSysMailConfig <em>Sys Mail Config</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigImpl#getConnectionManagementConfig <em>Connection Management Config</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigImpl#getTaskCommandConfig <em>Task Command Config</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigImpl#getScriptLanguageConfig <em>Script Language Config</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigImpl#getEventListenerConfig <em>Event Listener Config</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FoxBPMConfigImpl extends BaseConfigImpl implements FoxBPMConfig {
	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResourcePathConfig() <em>Resource Path Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourcePathConfig()
	 * @generated
	 * @ordered
	 */
	protected ResourcePathConfig resourcePathConfig;

	/**
	 * The cached value of the '{@link #getSysMailConfig() <em>Sys Mail Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSysMailConfig()
	 * @generated
	 * @ordered
	 */
	protected SysMailConfig sysMailConfig;

	/**
	 * The cached value of the '{@link #getConnectionManagementConfig() <em>Connection Management Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionManagementConfig()
	 * @generated
	 * @ordered
	 */
	protected ConnectionManagementConfig connectionManagementConfig;

	/**
	 * The cached value of the '{@link #getTaskCommandConfig() <em>Task Command Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskCommandConfig()
	 * @generated
	 * @ordered
	 */
	protected TaskCommandConfig taskCommandConfig;

	/**
	 * The cached value of the '{@link #getScriptLanguageConfig() <em>Script Language Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptLanguageConfig()
	 * @generated
	 * @ordered
	 */
	protected ScriptLanguageConfig scriptLanguageConfig;

	/**
	 * The cached value of the '{@link #getEventListenerConfig() <em>Event Listener Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventListenerConfig()
	 * @generated
	 * @ordered
	 */
	protected EventListenerConfig eventListenerConfig;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FoxBPMConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FoxBPMConfigPackage.Literals.FOX_BPM_CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.FOX_BPM_CONFIG__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourcePathConfig getResourcePathConfig() {
		return resourcePathConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourcePathConfig(ResourcePathConfig newResourcePathConfig, NotificationChain msgs) {
		ResourcePathConfig oldResourcePathConfig = resourcePathConfig;
		resourcePathConfig = newResourcePathConfig;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.FOX_BPM_CONFIG__RESOURCE_PATH_CONFIG, oldResourcePathConfig, newResourcePathConfig);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourcePathConfig(ResourcePathConfig newResourcePathConfig) {
		if (newResourcePathConfig != resourcePathConfig) {
			NotificationChain msgs = null;
			if (resourcePathConfig != null)
				msgs = ((InternalEObject)resourcePathConfig).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FoxBPMConfigPackage.FOX_BPM_CONFIG__RESOURCE_PATH_CONFIG, null, msgs);
			if (newResourcePathConfig != null)
				msgs = ((InternalEObject)newResourcePathConfig).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FoxBPMConfigPackage.FOX_BPM_CONFIG__RESOURCE_PATH_CONFIG, null, msgs);
			msgs = basicSetResourcePathConfig(newResourcePathConfig, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.FOX_BPM_CONFIG__RESOURCE_PATH_CONFIG, newResourcePathConfig, newResourcePathConfig));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SysMailConfig getSysMailConfig() {
		return sysMailConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSysMailConfig(SysMailConfig newSysMailConfig, NotificationChain msgs) {
		SysMailConfig oldSysMailConfig = sysMailConfig;
		sysMailConfig = newSysMailConfig;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.FOX_BPM_CONFIG__SYS_MAIL_CONFIG, oldSysMailConfig, newSysMailConfig);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSysMailConfig(SysMailConfig newSysMailConfig) {
		if (newSysMailConfig != sysMailConfig) {
			NotificationChain msgs = null;
			if (sysMailConfig != null)
				msgs = ((InternalEObject)sysMailConfig).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FoxBPMConfigPackage.FOX_BPM_CONFIG__SYS_MAIL_CONFIG, null, msgs);
			if (newSysMailConfig != null)
				msgs = ((InternalEObject)newSysMailConfig).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FoxBPMConfigPackage.FOX_BPM_CONFIG__SYS_MAIL_CONFIG, null, msgs);
			msgs = basicSetSysMailConfig(newSysMailConfig, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.FOX_BPM_CONFIG__SYS_MAIL_CONFIG, newSysMailConfig, newSysMailConfig));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionManagementConfig getConnectionManagementConfig() {
		return connectionManagementConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConnectionManagementConfig(ConnectionManagementConfig newConnectionManagementConfig, NotificationChain msgs) {
		ConnectionManagementConfig oldConnectionManagementConfig = connectionManagementConfig;
		connectionManagementConfig = newConnectionManagementConfig;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.FOX_BPM_CONFIG__CONNECTION_MANAGEMENT_CONFIG, oldConnectionManagementConfig, newConnectionManagementConfig);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionManagementConfig(ConnectionManagementConfig newConnectionManagementConfig) {
		if (newConnectionManagementConfig != connectionManagementConfig) {
			NotificationChain msgs = null;
			if (connectionManagementConfig != null)
				msgs = ((InternalEObject)connectionManagementConfig).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FoxBPMConfigPackage.FOX_BPM_CONFIG__CONNECTION_MANAGEMENT_CONFIG, null, msgs);
			if (newConnectionManagementConfig != null)
				msgs = ((InternalEObject)newConnectionManagementConfig).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FoxBPMConfigPackage.FOX_BPM_CONFIG__CONNECTION_MANAGEMENT_CONFIG, null, msgs);
			msgs = basicSetConnectionManagementConfig(newConnectionManagementConfig, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.FOX_BPM_CONFIG__CONNECTION_MANAGEMENT_CONFIG, newConnectionManagementConfig, newConnectionManagementConfig));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskCommandConfig getTaskCommandConfig() {
		return taskCommandConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTaskCommandConfig(TaskCommandConfig newTaskCommandConfig, NotificationChain msgs) {
		TaskCommandConfig oldTaskCommandConfig = taskCommandConfig;
		taskCommandConfig = newTaskCommandConfig;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.FOX_BPM_CONFIG__TASK_COMMAND_CONFIG, oldTaskCommandConfig, newTaskCommandConfig);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTaskCommandConfig(TaskCommandConfig newTaskCommandConfig) {
		if (newTaskCommandConfig != taskCommandConfig) {
			NotificationChain msgs = null;
			if (taskCommandConfig != null)
				msgs = ((InternalEObject)taskCommandConfig).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FoxBPMConfigPackage.FOX_BPM_CONFIG__TASK_COMMAND_CONFIG, null, msgs);
			if (newTaskCommandConfig != null)
				msgs = ((InternalEObject)newTaskCommandConfig).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FoxBPMConfigPackage.FOX_BPM_CONFIG__TASK_COMMAND_CONFIG, null, msgs);
			msgs = basicSetTaskCommandConfig(newTaskCommandConfig, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.FOX_BPM_CONFIG__TASK_COMMAND_CONFIG, newTaskCommandConfig, newTaskCommandConfig));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptLanguageConfig getScriptLanguageConfig() {
		return scriptLanguageConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScriptLanguageConfig(ScriptLanguageConfig newScriptLanguageConfig, NotificationChain msgs) {
		ScriptLanguageConfig oldScriptLanguageConfig = scriptLanguageConfig;
		scriptLanguageConfig = newScriptLanguageConfig;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.FOX_BPM_CONFIG__SCRIPT_LANGUAGE_CONFIG, oldScriptLanguageConfig, newScriptLanguageConfig);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScriptLanguageConfig(ScriptLanguageConfig newScriptLanguageConfig) {
		if (newScriptLanguageConfig != scriptLanguageConfig) {
			NotificationChain msgs = null;
			if (scriptLanguageConfig != null)
				msgs = ((InternalEObject)scriptLanguageConfig).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FoxBPMConfigPackage.FOX_BPM_CONFIG__SCRIPT_LANGUAGE_CONFIG, null, msgs);
			if (newScriptLanguageConfig != null)
				msgs = ((InternalEObject)newScriptLanguageConfig).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FoxBPMConfigPackage.FOX_BPM_CONFIG__SCRIPT_LANGUAGE_CONFIG, null, msgs);
			msgs = basicSetScriptLanguageConfig(newScriptLanguageConfig, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.FOX_BPM_CONFIG__SCRIPT_LANGUAGE_CONFIG, newScriptLanguageConfig, newScriptLanguageConfig));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventListenerConfig getEventListenerConfig() {
		return eventListenerConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEventListenerConfig(EventListenerConfig newEventListenerConfig, NotificationChain msgs) {
		EventListenerConfig oldEventListenerConfig = eventListenerConfig;
		eventListenerConfig = newEventListenerConfig;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.FOX_BPM_CONFIG__EVENT_LISTENER_CONFIG, oldEventListenerConfig, newEventListenerConfig);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventListenerConfig(EventListenerConfig newEventListenerConfig) {
		if (newEventListenerConfig != eventListenerConfig) {
			NotificationChain msgs = null;
			if (eventListenerConfig != null)
				msgs = ((InternalEObject)eventListenerConfig).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FoxBPMConfigPackage.FOX_BPM_CONFIG__EVENT_LISTENER_CONFIG, null, msgs);
			if (newEventListenerConfig != null)
				msgs = ((InternalEObject)newEventListenerConfig).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FoxBPMConfigPackage.FOX_BPM_CONFIG__EVENT_LISTENER_CONFIG, null, msgs);
			msgs = basicSetEventListenerConfig(newEventListenerConfig, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.FOX_BPM_CONFIG__EVENT_LISTENER_CONFIG, newEventListenerConfig, newEventListenerConfig));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__RESOURCE_PATH_CONFIG:
				return basicSetResourcePathConfig(null, msgs);
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__SYS_MAIL_CONFIG:
				return basicSetSysMailConfig(null, msgs);
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__CONNECTION_MANAGEMENT_CONFIG:
				return basicSetConnectionManagementConfig(null, msgs);
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__TASK_COMMAND_CONFIG:
				return basicSetTaskCommandConfig(null, msgs);
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__SCRIPT_LANGUAGE_CONFIG:
				return basicSetScriptLanguageConfig(null, msgs);
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__EVENT_LISTENER_CONFIG:
				return basicSetEventListenerConfig(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__VERSION:
				return getVersion();
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__RESOURCE_PATH_CONFIG:
				return getResourcePathConfig();
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__SYS_MAIL_CONFIG:
				return getSysMailConfig();
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__CONNECTION_MANAGEMENT_CONFIG:
				return getConnectionManagementConfig();
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__TASK_COMMAND_CONFIG:
				return getTaskCommandConfig();
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__SCRIPT_LANGUAGE_CONFIG:
				return getScriptLanguageConfig();
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__EVENT_LISTENER_CONFIG:
				return getEventListenerConfig();
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
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__VERSION:
				setVersion((String)newValue);
				return;
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__RESOURCE_PATH_CONFIG:
				setResourcePathConfig((ResourcePathConfig)newValue);
				return;
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__SYS_MAIL_CONFIG:
				setSysMailConfig((SysMailConfig)newValue);
				return;
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__CONNECTION_MANAGEMENT_CONFIG:
				setConnectionManagementConfig((ConnectionManagementConfig)newValue);
				return;
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__TASK_COMMAND_CONFIG:
				setTaskCommandConfig((TaskCommandConfig)newValue);
				return;
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__SCRIPT_LANGUAGE_CONFIG:
				setScriptLanguageConfig((ScriptLanguageConfig)newValue);
				return;
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__EVENT_LISTENER_CONFIG:
				setEventListenerConfig((EventListenerConfig)newValue);
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
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__RESOURCE_PATH_CONFIG:
				setResourcePathConfig((ResourcePathConfig)null);
				return;
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__SYS_MAIL_CONFIG:
				setSysMailConfig((SysMailConfig)null);
				return;
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__CONNECTION_MANAGEMENT_CONFIG:
				setConnectionManagementConfig((ConnectionManagementConfig)null);
				return;
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__TASK_COMMAND_CONFIG:
				setTaskCommandConfig((TaskCommandConfig)null);
				return;
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__SCRIPT_LANGUAGE_CONFIG:
				setScriptLanguageConfig((ScriptLanguageConfig)null);
				return;
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__EVENT_LISTENER_CONFIG:
				setEventListenerConfig((EventListenerConfig)null);
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
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__RESOURCE_PATH_CONFIG:
				return resourcePathConfig != null;
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__SYS_MAIL_CONFIG:
				return sysMailConfig != null;
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__CONNECTION_MANAGEMENT_CONFIG:
				return connectionManagementConfig != null;
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__TASK_COMMAND_CONFIG:
				return taskCommandConfig != null;
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__SCRIPT_LANGUAGE_CONFIG:
				return scriptLanguageConfig != null;
			case FoxBPMConfigPackage.FOX_BPM_CONFIG__EVENT_LISTENER_CONFIG:
				return eventListenerConfig != null;
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
		result.append(" (version: ");
		result.append(version);
		result.append(')');
		return result.toString();
	}

} //FoxBPMConfigImpl
