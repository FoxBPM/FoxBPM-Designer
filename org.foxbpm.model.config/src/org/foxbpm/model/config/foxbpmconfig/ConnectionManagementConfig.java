/**
 */
package org.foxbpm.model.config.foxbpmconfig;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection Management Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 流程链接管理器配置
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.ConnectionManagementConfig#getConnectionManagement <em>Connection Management</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.ConnectionManagementConfig#getSelected <em>Selected</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getConnectionManagementConfig()
 * @model
 * @generated
 */
public interface ConnectionManagementConfig extends BaseConfig {
	/**
	 * Returns the value of the '<em><b>Selected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 当前选中的连接管理器
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Selected</em>' attribute.
	 * @see #setSelected(String)
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getConnectionManagementConfig_Selected()
	 * @model required="true"
	 * @generated
	 */
	String getSelected();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.foxbpmconfig.ConnectionManagementConfig#getSelected <em>Selected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selected</em>' attribute.
	 * @see #getSelected()
	 * @generated
	 */
	void setSelected(String value);

	/**
	 * Returns the value of the '<em><b>Connection Management</b></em>' containment reference list.
	 * The list contents are of type {@link org.foxbpm.model.config.foxbpmconfig.ConnectionManagement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 链接管理器集合
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Connection Management</em>' containment reference list.
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getConnectionManagementConfig_ConnectionManagement()
	 * @model containment="true"
	 *        extendedMetaData="kind='element'"
	 * @generated
	 */
	EList<ConnectionManagement> getConnectionManagement();

} // ConnectionManagementConfig
