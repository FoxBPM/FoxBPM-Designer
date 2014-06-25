/**
 */
package org.foxbpm.model.config.foxbpmconfig;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fox BPM Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig#getVersion <em>Version</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig#getResourcePathConfig <em>Resource Path Config</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig#getSysMailConfig <em>Sys Mail Config</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig#getConnectionManagementConfig <em>Connection Management Config</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig#getTaskCommandConfig <em>Task Command Config</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig#getScriptLanguageConfig <em>Script Language Config</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getFoxBPMConfig()
 * @model
 * @generated
 */
public interface FoxBPMConfig extends BaseConfig {
	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 流程引擎的版本号
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getFoxBPMConfig_Version()
	 * @model extendedMetaData="name='version' kind='attribute'"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Resource Path Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 引擎资源配置
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resource Path Config</em>' containment reference.
	 * @see #setResourcePathConfig(ResourcePathConfig)
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getFoxBPMConfig_ResourcePathConfig()
	 * @model containment="true"
	 *        extendedMetaData="name='resourcePathConfig' kind='element'"
	 * @generated
	 */
	ResourcePathConfig getResourcePathConfig();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig#getResourcePathConfig <em>Resource Path Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Path Config</em>' containment reference.
	 * @see #getResourcePathConfig()
	 * @generated
	 */
	void setResourcePathConfig(ResourcePathConfig value);

	/**
	 * Returns the value of the '<em><b>Sys Mail Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sys Mail Config</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sys Mail Config</em>' containment reference.
	 * @see #setSysMailConfig(SysMailConfig)
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getFoxBPMConfig_SysMailConfig()
	 * @model containment="true"
	 *        extendedMetaData="kind='element'"
	 * @generated
	 */
	SysMailConfig getSysMailConfig();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig#getSysMailConfig <em>Sys Mail Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sys Mail Config</em>' containment reference.
	 * @see #getSysMailConfig()
	 * @generated
	 */
	void setSysMailConfig(SysMailConfig value);

	/**
	 * Returns the value of the '<em><b>Connection Management Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Management Config</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Management Config</em>' containment reference.
	 * @see #setConnectionManagementConfig(ConnectionManagementConfig)
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getFoxBPMConfig_ConnectionManagementConfig()
	 * @model containment="true"
	 *        extendedMetaData="kind='element'"
	 * @generated
	 */
	ConnectionManagementConfig getConnectionManagementConfig();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig#getConnectionManagementConfig <em>Connection Management Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Management Config</em>' containment reference.
	 * @see #getConnectionManagementConfig()
	 * @generated
	 */
	void setConnectionManagementConfig(ConnectionManagementConfig value);

	/**
	 * Returns the value of the '<em><b>Task Command Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Command Config</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Command Config</em>' containment reference.
	 * @see #setTaskCommandConfig(TaskCommandConfig)
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getFoxBPMConfig_TaskCommandConfig()
	 * @model containment="true"
	 *        extendedMetaData="kind='element'"
	 * @generated
	 */
	TaskCommandConfig getTaskCommandConfig();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig#getTaskCommandConfig <em>Task Command Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Command Config</em>' containment reference.
	 * @see #getTaskCommandConfig()
	 * @generated
	 */
	void setTaskCommandConfig(TaskCommandConfig value);

	/**
	 * Returns the value of the '<em><b>Script Language Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Script Language Config</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Script Language Config</em>' containment reference.
	 * @see #setScriptLanguageConfig(ScriptLanguageConfig)
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getFoxBPMConfig_ScriptLanguageConfig()
	 * @model containment="true"
	 *        extendedMetaData="name='scriptLanguageConfig' kind='element'"
	 * @generated
	 */
	ScriptLanguageConfig getScriptLanguageConfig();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig#getScriptLanguageConfig <em>Script Language Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Script Language Config</em>' containment reference.
	 * @see #getScriptLanguageConfig()
	 * @generated
	 */
	void setScriptLanguageConfig(ScriptLanguageConfig value);

} // FoxBPMConfig
