/**
 */
package org.foxbpm.model.config.foxbpmconfig;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Script Language Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.ScriptLanguageConfig#getScriptLanguage <em>Script Language</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getScriptLanguageConfig()
 * @model extendedMetaData="name='scriptLanguageConfig'"
 * @generated
 */
public interface ScriptLanguageConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Script Language</b></em>' containment reference list.
	 * The list contents are of type {@link org.foxbpm.model.config.foxbpmconfig.ScriptLanguage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Script Language</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Script Language</em>' containment reference list.
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getScriptLanguageConfig_ScriptLanguage()
	 * @model containment="true"
	 *        extendedMetaData="name='scriptLanguage' kind='element'"
	 * @generated
	 */
	EList<ScriptLanguage> getScriptLanguage();

} // ScriptLanguageConfig
