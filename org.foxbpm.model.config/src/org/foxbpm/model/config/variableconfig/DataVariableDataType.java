/**
 */
package org.foxbpm.model.config.variableconfig;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Variable Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.variableconfig.DataVariableDataType#getDataTypeDef <em>Data Type Def</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.config.variableconfig.VariableconfigPackage#getDataVariableDataType()
 * @model extendedMetaData="name='dataVariableDataType'"
 * @generated
 */
public interface DataVariableDataType extends EObject {
	/**
	 * Returns the value of the '<em><b>Data Type Def</b></em>' containment reference list.
	 * The list contents are of type {@link org.foxbpm.model.config.variableconfig.DataTypeDef}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Type Def</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Type Def</em>' containment reference list.
	 * @see org.foxbpm.model.config.variableconfig.VariableconfigPackage#getDataVariableDataType_DataTypeDef()
	 * @model containment="true"
	 *        extendedMetaData="name='dataTypeDef' kind='element'"
	 * @generated
	 */
	EList<DataTypeDef> getDataTypeDef();

} // DataVariableDataType
