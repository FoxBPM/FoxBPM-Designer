/**
 */
package org.foxbpm.model.config.variableconfig;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Variable Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.variableconfig.DataVariableConfig#getDataVariableType <em>Data Variable Type</em>}</li>
 *   <li>{@link org.foxbpm.model.config.variableconfig.DataVariableConfig#getFoxBPMDataVariable <em>Fox BPM Data Variable</em>}</li>
 *   <li>{@link org.foxbpm.model.config.variableconfig.DataVariableConfig#getDataVariableDataType <em>Data Variable Data Type</em>}</li>
 *   <li>{@link org.foxbpm.model.config.variableconfig.DataVariableConfig#getDataVariableBizTypeConfig <em>Data Variable Biz Type Config</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.config.variableconfig.VariableconfigPackage#getDataVariableConfig()
 * @model extendedMetaData="name='dataVariableConfig'"
 * @generated
 */
public interface DataVariableConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Data Variable Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Variable Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Variable Type</em>' containment reference.
	 * @see #setDataVariableType(DataVariableType)
	 * @see org.foxbpm.model.config.variableconfig.VariableconfigPackage#getDataVariableConfig_DataVariableType()
	 * @model containment="true" required="true"
	 *        extendedMetaData="name='dataVariableType' kind='element'"
	 * @generated
	 */
	DataVariableType getDataVariableType();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.variableconfig.DataVariableConfig#getDataVariableType <em>Data Variable Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Variable Type</em>' containment reference.
	 * @see #getDataVariableType()
	 * @generated
	 */
	void setDataVariableType(DataVariableType value);

	/**
	 * Returns the value of the '<em><b>Fox BPM Data Variable</b></em>' containment reference list.
	 * The list contents are of type {@link org.foxbpm.model.config.variableconfig.FoxBPMDataVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fox BPM Data Variable</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fox BPM Data Variable</em>' containment reference list.
	 * @see org.foxbpm.model.config.variableconfig.VariableconfigPackage#getDataVariableConfig_FoxBPMDataVariable()
	 * @model containment="true"
	 *        extendedMetaData="name='foxBPMDataVariable' kind='element'"
	 * @generated
	 */
	EList<FoxBPMDataVariable> getFoxBPMDataVariable();

	/**
	 * Returns the value of the '<em><b>Data Variable Data Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Variable Data Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Variable Data Type</em>' containment reference.
	 * @see #setDataVariableDataType(DataVariableDataType)
	 * @see org.foxbpm.model.config.variableconfig.VariableconfigPackage#getDataVariableConfig_DataVariableDataType()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='dataVariableDataType'"
	 * @generated
	 */
	DataVariableDataType getDataVariableDataType();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.variableconfig.DataVariableConfig#getDataVariableDataType <em>Data Variable Data Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Variable Data Type</em>' containment reference.
	 * @see #getDataVariableDataType()
	 * @generated
	 */
	void setDataVariableDataType(DataVariableDataType value);

	/**
	 * Returns the value of the '<em><b>Data Variable Biz Type Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Variable Biz Type Config</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Variable Biz Type Config</em>' containment reference.
	 * @see #setDataVariableBizTypeConfig(DataVariableBizTypeConfig)
	 * @see org.foxbpm.model.config.variableconfig.VariableconfigPackage#getDataVariableConfig_DataVariableBizTypeConfig()
	 * @model containment="true"
	 *        extendedMetaData="name='dataVariableBizTypeConfig' kind='element'"
	 * @generated
	 */
	DataVariableBizTypeConfig getDataVariableBizTypeConfig();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.variableconfig.DataVariableConfig#getDataVariableBizTypeConfig <em>Data Variable Biz Type Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Variable Biz Type Config</em>' containment reference.
	 * @see #getDataVariableBizTypeConfig()
	 * @generated
	 */
	void setDataVariableBizTypeConfig(DataVariableBizTypeConfig value);

} // DataVariableConfig
