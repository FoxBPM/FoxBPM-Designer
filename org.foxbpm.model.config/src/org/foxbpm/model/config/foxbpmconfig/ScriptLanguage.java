/**
 */
package org.foxbpm.model.config.foxbpmconfig;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Script Language</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.ScriptLanguage#getName <em>Name</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.ScriptLanguage#getId <em>Id</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.ScriptLanguage#getClassImpl <em>Class Impl</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getScriptLanguage()
 * @model extendedMetaData="name='scriptLanguage'"
 * @generated
 */
public interface ScriptLanguage extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getScriptLanguage_Name()
	 * @model extendedMetaData="name='name' kind='attribute'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.foxbpmconfig.ScriptLanguage#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getScriptLanguage_Id()
	 * @model required="true"
	 *        extendedMetaData="name='id' kind='attribute'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.foxbpmconfig.ScriptLanguage#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Class Impl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Impl</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Impl</em>' attribute.
	 * @see #setClassImpl(String)
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getScriptLanguage_ClassImpl()
	 * @model extendedMetaData="name='classImpl' kind='attribute'"
	 * @generated
	 */
	String getClassImpl();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.foxbpmconfig.ScriptLanguage#getClassImpl <em>Class Impl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Impl</em>' attribute.
	 * @see #getClassImpl()
	 * @generated
	 */
	void setClassImpl(String value);

} // ScriptLanguage
