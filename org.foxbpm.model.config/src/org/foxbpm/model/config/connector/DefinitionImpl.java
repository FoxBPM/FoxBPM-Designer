/**
 */
package org.foxbpm.model.config.connector;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Definition Impl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.connector.DefinitionImpl#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.DefinitionImpl#getPackageName <em>Package Name</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.DefinitionImpl#getJarDependencies <em>Jar Dependencies</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.config.connector.ConnectorPackage#getDefinitionImpl()
 * @model extendedMetaData="name='definitionImpl'"
 * @generated
 */
public interface DefinitionImpl extends EObject {
	/**
	 * Returns the value of the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Name</em>' attribute.
	 * @see #setClassName(String)
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getDefinitionImpl_ClassName()
	 * @model extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getClassName();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.connector.DefinitionImpl#getClassName <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Name</em>' attribute.
	 * @see #getClassName()
	 * @generated
	 */
	void setClassName(String value);

	/**
	 * Returns the value of the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package Name</em>' attribute.
	 * @see #setPackageName(String)
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getDefinitionImpl_PackageName()
	 * @model extendedMetaData="name='packageName' kind='attribute'"
	 * @generated
	 */
	String getPackageName();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.connector.DefinitionImpl#getPackageName <em>Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package Name</em>' attribute.
	 * @see #getPackageName()
	 * @generated
	 */
	void setPackageName(String value);

	/**
	 * Returns the value of the '<em><b>Jar Dependencies</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jar Dependencies</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jar Dependencies</em>' containment reference.
	 * @see #setJarDependencies(JarDependencies)
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getDefinitionImpl_JarDependencies()
	 * @model containment="true"
	 *        extendedMetaData="name='jarDependencies' kind='element'"
	 * @generated
	 */
	JarDependencies getJarDependencies();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.connector.DefinitionImpl#getJarDependencies <em>Jar Dependencies</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jar Dependencies</em>' containment reference.
	 * @see #getJarDependencies()
	 * @generated
	 */
	void setJarDependencies(JarDependencies value);

} // DefinitionImpl
