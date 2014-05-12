/**
 */
package org.foxbpm.model.config.connector;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.connector.Input#getId <em>Id</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.Input#getType <em>Type</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.Input#getMandatory <em>Mandatory</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.Input#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.Input#getIsExecute <em>Is Execute</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.config.connector.ConnectorPackage#getInput()
 * @model extendedMetaData="name='input'"
 * @generated
 */
public interface Input extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 输入变量的编号
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getInput_Id()
	 * @model required="true"
	 *        extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.connector.Input#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 变量的入参类型
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getInput_Type()
	 * @model extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.connector.Input#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 是否必填
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mandatory</em>' attribute.
	 * @see #setMandatory(String)
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getInput_Mandatory()
	 * @model extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getMandatory();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.connector.Input#getMandatory <em>Mandatory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mandatory</em>' attribute.
	 * @see #getMandatory()
	 * @generated
	 */
	void setMandatory(String value);

	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 默认值
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default Value</em>' attribute.
	 * @see #setDefaultValue(String)
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getInput_DefaultValue()
	 * @model extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getDefaultValue();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.connector.Input#getDefaultValue <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' attribute.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(String value);

	/**
	 * Returns the value of the '<em><b>Is Execute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Execute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Execute</em>' attribute.
	 * @see #setIsExecute(String)
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getInput_IsExecute()
	 * @model extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getIsExecute();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.connector.Input#getIsExecute <em>Is Execute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Execute</em>' attribute.
	 * @see #getIsExecute()
	 * @generated
	 */
	void setIsExecute(String value);

} // Input
