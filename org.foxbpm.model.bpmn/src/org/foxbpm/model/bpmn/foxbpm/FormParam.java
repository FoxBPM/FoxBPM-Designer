/**
 */
package org.foxbpm.model.bpmn.foxbpm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Form Param</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.FormParam#getParamKey <em>Param Key</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.FormParam#getParamType <em>Param Type</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.FormParam#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getFormParam()
 * @model
 * @generated
 */
public interface FormParam extends EObject {
	/**
	 * Returns the value of the '<em><b>Param Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Param Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Param Key</em>' attribute.
	 * @see #setParamKey(String)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getFormParam_ParamKey()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="namespace='' kind='attribute'"
	 * @generated
	 */
	String getParamKey();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.FormParam#getParamKey <em>Param Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Param Key</em>' attribute.
	 * @see #getParamKey()
	 * @generated
	 */
	void setParamKey(String value);

	/**
	 * Returns the value of the '<em><b>Param Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Param Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Param Type</em>' attribute.
	 * @see #setParamType(String)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getFormParam_ParamType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getParamType();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.FormParam#getParamType <em>Param Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Param Type</em>' attribute.
	 * @see #getParamType()
	 * @generated
	 */
	void setParamType(String value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(Expression)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getFormParam_Expression()
	 * @model containment="true"
	 *        extendedMetaData="namespace='##targetNamespace' kind='element'"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.FormParam#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

} // FormParam
