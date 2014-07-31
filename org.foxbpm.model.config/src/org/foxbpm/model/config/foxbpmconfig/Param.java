/**
 */
package org.foxbpm.model.config.foxbpmconfig;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Param</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.Param#getKey <em>Key</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.Param#getValue <em>Value</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.Param#getParams <em>Params</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.Param#getName <em>Name</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.Param#getMixed <em>Mixed</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getParam()
 * @model extendedMetaData="name='Param' kind='mixed'"
 * @generated
 */
public interface Param extends EObject {
	/**
	 * Returns the value of the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' attribute.
	 * @see #setKey(String)
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getParam_Key()
	 * @model extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getKey();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.foxbpmconfig.Param#getKey <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' attribute.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getParam_Value()
	 * @model extendedMetaData="kind='element'"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.foxbpmconfig.Param#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Params</b></em>' containment reference list.
	 * The list contents are of type {@link org.foxbpm.model.config.foxbpmconfig.Param}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Params</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Params</em>' containment reference list.
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getParam_Params()
	 * @model containment="true"
	 *        extendedMetaData="kind='mixed'"
	 * @generated
	 */
	EList<Param> getParams();

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
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getParam_Name()
	 * @model extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.foxbpmconfig.Param#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getParam_Mixed()
	 * @model dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="name=':mixed' kind='elementWildcard'"
	 * @generated
	 */
	FeatureMap getMixed();

} // Param
