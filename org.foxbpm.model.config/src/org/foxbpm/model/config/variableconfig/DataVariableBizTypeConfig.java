/**
 */
package org.foxbpm.model.config.variableconfig;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Variable Biz Type Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.variableconfig.DataVariableBizTypeConfig#getDataVariableBizType <em>Data Variable Biz Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.config.variableconfig.VariableconfigPackage#getDataVariableBizTypeConfig()
 * @model extendedMetaData="name='dataVariableBizTypeConfig'"
 * @generated
 */
public interface DataVariableBizTypeConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Data Variable Biz Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.foxbpm.model.config.variableconfig.DataVariableBizType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Variable Biz Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Variable Biz Type</em>' containment reference list.
	 * @see org.foxbpm.model.config.variableconfig.VariableconfigPackage#getDataVariableBizTypeConfig_DataVariableBizType()
	 * @model containment="true"
	 *        extendedMetaData="name='dataVariableBizType' kind='element'"
	 * @generated
	 */
	EList<DataVariableBizType> getDataVariableBizType();

} // DataVariableBizTypeConfig
