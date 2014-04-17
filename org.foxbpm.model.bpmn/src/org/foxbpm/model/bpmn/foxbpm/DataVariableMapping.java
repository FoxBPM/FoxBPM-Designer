/**
 */
package org.foxbpm.model.bpmn.foxbpm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Variable Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.DataVariableMapping#getDataSourceId <em>Data Source Id</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.DataVariableMapping#getSubProcesId <em>Sub Proces Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getDataVariableMapping()
 * @model
 * @generated
 */
public interface DataVariableMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Data Source Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Source Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Source Id</em>' attribute.
	 * @see #setDataSourceId(String)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getDataVariableMapping_DataSourceId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getDataSourceId();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.DataVariableMapping#getDataSourceId <em>Data Source Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Source Id</em>' attribute.
	 * @see #getDataSourceId()
	 * @generated
	 */
	void setDataSourceId(String value);

	/**
	 * Returns the value of the '<em><b>Sub Proces Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Proces Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Proces Id</em>' attribute.
	 * @see #setSubProcesId(String)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getDataVariableMapping_SubProcesId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getSubProcesId();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.DataVariableMapping#getSubProcesId <em>Sub Proces Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Proces Id</em>' attribute.
	 * @see #getSubProcesId()
	 * @generated
	 */
	void setSubProcesId(String value);

} // DataVariableMapping
