/**
 */
package org.foxbpm.model.config.foxbpmconfig.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.foxbpm.model.config.foxbpmconfig.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FoxBPMConfigFactoryImpl extends EFactoryImpl implements FoxBPMConfigFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FoxBPMConfigFactory init() {
		try {
			FoxBPMConfigFactory theFoxBPMConfigFactory = (FoxBPMConfigFactory)EPackage.Registry.INSTANCE.getEFactory(FoxBPMConfigPackage.eNS_URI);
			if (theFoxBPMConfigFactory != null) {
				return theFoxBPMConfigFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FoxBPMConfigFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FoxBPMConfigFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case FoxBPMConfigPackage.FOX_BPM_CONFIG: return createFoxBPMConfig();
			case FoxBPMConfigPackage.SYS_MAIL_CONFIG: return createSysMailConfig();
			case FoxBPMConfigPackage.CONNECTION_MANAGEMENT_CONFIG: return createConnectionManagementConfig();
			case FoxBPMConfigPackage.CONNECTION_MANAGEMENT: return createConnectionManagement();
			case FoxBPMConfigPackage.RESOURCE_PATH_CONFIG: return createResourcePathConfig();
			case FoxBPMConfigPackage.RESOURCE_PATH: return createResourcePath();
			case FoxBPMConfigPackage.MAIL_INFO: return createMailInfo();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FoxBPMConfig createFoxBPMConfig() {
		FoxBPMConfigImpl foxBPMConfig = new FoxBPMConfigImpl();
		return foxBPMConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SysMailConfig createSysMailConfig() {
		SysMailConfigImpl sysMailConfig = new SysMailConfigImpl();
		return sysMailConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionManagementConfig createConnectionManagementConfig() {
		ConnectionManagementConfigImpl connectionManagementConfig = new ConnectionManagementConfigImpl();
		return connectionManagementConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionManagement createConnectionManagement() {
		ConnectionManagementImpl connectionManagement = new ConnectionManagementImpl();
		return connectionManagement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourcePathConfig createResourcePathConfig() {
		ResourcePathConfigImpl resourcePathConfig = new ResourcePathConfigImpl();
		return resourcePathConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourcePath createResourcePath() {
		ResourcePathImpl resourcePath = new ResourcePathImpl();
		return resourcePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MailInfo createMailInfo() {
		MailInfoImpl mailInfo = new MailInfoImpl();
		return mailInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FoxBPMConfigPackage getFoxBPMConfigPackage() {
		return (FoxBPMConfigPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FoxBPMConfigPackage getPackage() {
		return FoxBPMConfigPackage.eINSTANCE;
	}

} //FoxBPMConfigFactoryImpl
