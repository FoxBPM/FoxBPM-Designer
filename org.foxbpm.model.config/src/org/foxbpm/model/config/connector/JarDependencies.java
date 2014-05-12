/**
 */
package org.foxbpm.model.config.connector;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jar Dependencies</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.connector.JarDependencies#getJarDependency <em>Jar Dependency</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.config.connector.ConnectorPackage#getJarDependencies()
 * @model extendedMetaData="name='jarDependencies'"
 * @generated
 */
public interface JarDependencies extends EObject {
	/**
	 * Returns the value of the '<em><b>Jar Dependency</b></em>' containment reference list.
	 * The list contents are of type {@link org.foxbpm.model.config.connector.JarDependency}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jar Dependency</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jar Dependency</em>' containment reference list.
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getJarDependencies_JarDependency()
	 * @model containment="true"
	 *        extendedMetaData="name='jarDependency' kind='element'"
	 * @generated
	 */
	EList<JarDependency> getJarDependency();

} // JarDependencies
