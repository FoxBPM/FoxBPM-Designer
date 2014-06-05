/**
 */
package org.foxbpm.model.bpmn.foxbpm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Form Param Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.FormParamContainer#getFormParam <em>Form Param</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getFormParamContainer()
 * @model extendedMetaData="name='FormParamContainer'"
 * @generated
 */
public interface FormParamContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Form Param</b></em>' containment reference list.
	 * The list contents are of type {@link org.foxbpm.model.bpmn.foxbpm.FormParam}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Form Param</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Form Param</em>' containment reference list.
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getFormParamContainer_FormParam()
	 * @model containment="true"
	 *        extendedMetaData="namespace='##targetNamespace' kind='element'"
	 * @generated
	 */
	EList<FormParam> getFormParam();

} // FormParamContainer
