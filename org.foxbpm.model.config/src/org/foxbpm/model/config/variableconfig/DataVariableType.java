/**
 */
package org.foxbpm.model.config.variableconfig;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Variable Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.variableconfig.DataVariableType#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.config.variableconfig.VariableconfigPackage#getDataVariableType()
 * @model extendedMetaData="name='dataVariableType'"
 * @generated
 */
public interface DataVariableType extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.foxbpm.model.config.variableconfig.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference list.
	 * @see org.foxbpm.model.config.variableconfig.VariableconfigPackage#getDataVariableType_Type()
	 * @model containment="true"
	 *        extendedMetaData="name='type' kind='element'"
	 * @generated
	 */
	EList<Type> getType();

} // DataVariableType
