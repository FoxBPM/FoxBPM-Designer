/**
 */
package org.foxbpm.model.bpmn.foxbpm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Command Param</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.CommandParam#getBizType <em>Biz Type</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.CommandParam#getDataType <em>Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getCommandParam()
 * @model extendedMetaData="name='CommandParam'"
 * @generated
 */
public interface CommandParam extends Param {
	/**
	 * Returns the value of the '<em><b>Biz Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Biz Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Biz Type</em>' attribute.
	 * @see #setBizType(String)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getCommandParam_BizType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="name='bizType' kind='attribute'"
	 * @generated
	 */
	String getBizType();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.CommandParam#getBizType <em>Biz Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Biz Type</em>' attribute.
	 * @see #getBizType()
	 * @generated
	 */
	void setBizType(String value);

	/**
	 * Returns the value of the '<em><b>Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Type</em>' attribute.
	 * @see #setDataType(String)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getCommandParam_DataType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getDataType();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.CommandParam#getDataType <em>Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Type</em>' attribute.
	 * @see #getDataType()
	 * @generated
	 */
	void setDataType(String value);

} // CommandParam
