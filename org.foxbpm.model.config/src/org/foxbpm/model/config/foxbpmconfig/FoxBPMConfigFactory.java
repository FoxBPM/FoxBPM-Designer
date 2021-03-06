/**
 */
package org.foxbpm.model.config.foxbpmconfig;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage
 * @generated
 */
public interface FoxBPMConfigFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FoxBPMConfigFactory eINSTANCE = org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Fox BPM Config</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fox BPM Config</em>'.
	 * @generated
	 */
	FoxBPMConfig createFoxBPMConfig();

	/**
	 * Returns a new object of class '<em>Sys Mail Config</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sys Mail Config</em>'.
	 * @generated
	 */
	SysMailConfig createSysMailConfig();

	/**
	 * Returns a new object of class '<em>Connection Management Config</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connection Management Config</em>'.
	 * @generated
	 */
	ConnectionManagementConfig createConnectionManagementConfig();

	/**
	 * Returns a new object of class '<em>Connection Management</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connection Management</em>'.
	 * @generated
	 */
	ConnectionManagement createConnectionManagement();

	/**
	 * Returns a new object of class '<em>Resource Path Config</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Path Config</em>'.
	 * @generated
	 */
	ResourcePathConfig createResourcePathConfig();

	/**
	 * Returns a new object of class '<em>Resource Path</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Path</em>'.
	 * @generated
	 */
	ResourcePath createResourcePath();

	/**
	 * Returns a new object of class '<em>Mail Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mail Info</em>'.
	 * @generated
	 */
	MailInfo createMailInfo();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	FoxBPMConfigPackage getFoxBPMConfigPackage();

} //FoxBPMConfigFactory
