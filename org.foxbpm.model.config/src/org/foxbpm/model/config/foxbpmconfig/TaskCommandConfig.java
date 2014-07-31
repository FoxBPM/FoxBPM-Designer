/**
 */
package org.foxbpm.model.config.foxbpmconfig;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task Command Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 任务命令配置
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.TaskCommandConfig#getTaskCommandDefinition <em>Task Command Definition</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.TaskCommandConfig#getIsAutoClaim <em>Is Auto Claim</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getTaskCommandConfig()
 * @model
 * @generated
 */
public interface TaskCommandConfig extends BaseConfig {

	/**
	 * Returns the value of the '<em><b>Task Command Definition</b></em>' containment reference list.
	 * The list contents are of type {@link org.foxbpm.model.config.foxbpmconfig.TaskCommandDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Command Definition</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Command Definition</em>' containment reference list.
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getTaskCommandConfig_TaskCommandDefinition()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='taskCommandDefinition'"
	 * @generated
	 */
	EList<TaskCommandDefinition> getTaskCommandDefinition();

	/**
	 * Returns the value of the '<em><b>Is Auto Claim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Auto Claim</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Auto Claim</em>' attribute.
	 * @see #setIsAutoClaim(String)
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getTaskCommandConfig_IsAutoClaim()
	 * @model extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getIsAutoClaim();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.foxbpmconfig.TaskCommandConfig#getIsAutoClaim <em>Is Auto Claim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Auto Claim</em>' attribute.
	 * @see #getIsAutoClaim()
	 * @generated
	 */
	void setIsAutoClaim(String value);
} // TaskCommandConfig
