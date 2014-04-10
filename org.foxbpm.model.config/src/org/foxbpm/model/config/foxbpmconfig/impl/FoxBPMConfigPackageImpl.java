/**
 */
package org.foxbpm.model.config.foxbpmconfig.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.foxbpm.model.config.foxbpmconfig.ConnectionManagement;
import org.foxbpm.model.config.foxbpmconfig.ConnectionManagementConfig;
import org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig;
import org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigFactory;
import org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage;
import org.foxbpm.model.config.foxbpmconfig.MailInfo;
import org.foxbpm.model.config.foxbpmconfig.ResourcePath;
import org.foxbpm.model.config.foxbpmconfig.ResourcePathConfig;
import org.foxbpm.model.config.foxbpmconfig.SysMailConfig;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FoxBPMConfigPackageImpl extends EPackageImpl implements FoxBPMConfigPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass foxBPMConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sysMailConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionManagementConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionManagementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourcePathConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourcePathEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mailInfoEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FoxBPMConfigPackageImpl() {
		super(eNS_URI, FoxBPMConfigFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link FoxBPMConfigPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FoxBPMConfigPackage init() {
		if (isInited) return (FoxBPMConfigPackage)EPackage.Registry.INSTANCE.getEPackage(FoxBPMConfigPackage.eNS_URI);

		// Obtain or create and register package
		FoxBPMConfigPackageImpl theFoxBPMConfigPackage = (FoxBPMConfigPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FoxBPMConfigPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FoxBPMConfigPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theFoxBPMConfigPackage.createPackageContents();

		// Initialize created meta-data
		theFoxBPMConfigPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFoxBPMConfigPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FoxBPMConfigPackage.eNS_URI, theFoxBPMConfigPackage);
		return theFoxBPMConfigPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFoxBPMConfig() {
		return foxBPMConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFoxBPMConfig_Version() {
		return (EAttribute)foxBPMConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFoxBPMConfig_ResourcePathConfig() {
		return (EReference)foxBPMConfigEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFoxBPMConfig_SysMailConfig() {
		return (EReference)foxBPMConfigEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFoxBPMConfig_ConnectionManagementConfig() {
		return (EReference)foxBPMConfigEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSysMailConfig() {
		return sysMailConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSysMailConfig_MailInfo() {
		return (EReference)sysMailConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSysMailConfig_Selected() {
		return (EAttribute)sysMailConfigEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectionManagementConfig() {
		return connectionManagementConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionManagementConfig_Selected() {
		return (EAttribute)connectionManagementConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionManagementConfig_ConnectionManagement() {
		return (EReference)connectionManagementConfigEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectionManagement() {
		return connectionManagementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionManagement_Id() {
		return (EAttribute)connectionManagementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionManagement_Name() {
		return (EAttribute)connectionManagementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionManagement_ClassImpl() {
		return (EAttribute)connectionManagementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourcePathConfig() {
		return resourcePathConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourcePathConfig_ResourcePath() {
		return (EReference)resourcePathConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourcePath() {
		return resourcePathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourcePath_Id() {
		return (EAttribute)resourcePathEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourcePath_Name() {
		return (EAttribute)resourcePathEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourcePath_Src() {
		return (EAttribute)resourcePathEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourcePath_PhysicalPath() {
		return (EAttribute)resourcePathEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourcePath_VirtualPath() {
		return (EAttribute)resourcePathEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourcePath_ProjectName() {
		return (EAttribute)resourcePathEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMailInfo() {
		return mailInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailInfo_MailAddress() {
		return (EAttribute)mailInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailInfo_MailName() {
		return (EAttribute)mailInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailInfo_SmtpHost() {
		return (EAttribute)mailInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailInfo_SmtpPort() {
		return (EAttribute)mailInfoEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailInfo_UserName() {
		return (EAttribute)mailInfoEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailInfo_Password() {
		return (EAttribute)mailInfoEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FoxBPMConfigFactory getFoxBPMConfigFactory() {
		return (FoxBPMConfigFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		foxBPMConfigEClass = createEClass(FOX_BPM_CONFIG);
		createEAttribute(foxBPMConfigEClass, FOX_BPM_CONFIG__VERSION);
		createEReference(foxBPMConfigEClass, FOX_BPM_CONFIG__RESOURCE_PATH_CONFIG);
		createEReference(foxBPMConfigEClass, FOX_BPM_CONFIG__SYS_MAIL_CONFIG);
		createEReference(foxBPMConfigEClass, FOX_BPM_CONFIG__CONNECTION_MANAGEMENT_CONFIG);

		sysMailConfigEClass = createEClass(SYS_MAIL_CONFIG);
		createEReference(sysMailConfigEClass, SYS_MAIL_CONFIG__MAIL_INFO);
		createEAttribute(sysMailConfigEClass, SYS_MAIL_CONFIG__SELECTED);

		connectionManagementConfigEClass = createEClass(CONNECTION_MANAGEMENT_CONFIG);
		createEAttribute(connectionManagementConfigEClass, CONNECTION_MANAGEMENT_CONFIG__SELECTED);
		createEReference(connectionManagementConfigEClass, CONNECTION_MANAGEMENT_CONFIG__CONNECTION_MANAGEMENT);

		connectionManagementEClass = createEClass(CONNECTION_MANAGEMENT);
		createEAttribute(connectionManagementEClass, CONNECTION_MANAGEMENT__ID);
		createEAttribute(connectionManagementEClass, CONNECTION_MANAGEMENT__NAME);
		createEAttribute(connectionManagementEClass, CONNECTION_MANAGEMENT__CLASS_IMPL);

		resourcePathConfigEClass = createEClass(RESOURCE_PATH_CONFIG);
		createEReference(resourcePathConfigEClass, RESOURCE_PATH_CONFIG__RESOURCE_PATH);

		resourcePathEClass = createEClass(RESOURCE_PATH);
		createEAttribute(resourcePathEClass, RESOURCE_PATH__ID);
		createEAttribute(resourcePathEClass, RESOURCE_PATH__NAME);
		createEAttribute(resourcePathEClass, RESOURCE_PATH__SRC);
		createEAttribute(resourcePathEClass, RESOURCE_PATH__PHYSICAL_PATH);
		createEAttribute(resourcePathEClass, RESOURCE_PATH__VIRTUAL_PATH);
		createEAttribute(resourcePathEClass, RESOURCE_PATH__PROJECT_NAME);

		mailInfoEClass = createEClass(MAIL_INFO);
		createEAttribute(mailInfoEClass, MAIL_INFO__MAIL_ADDRESS);
		createEAttribute(mailInfoEClass, MAIL_INFO__MAIL_NAME);
		createEAttribute(mailInfoEClass, MAIL_INFO__SMTP_HOST);
		createEAttribute(mailInfoEClass, MAIL_INFO__SMTP_PORT);
		createEAttribute(mailInfoEClass, MAIL_INFO__USER_NAME);
		createEAttribute(mailInfoEClass, MAIL_INFO__PASSWORD);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(foxBPMConfigEClass, FoxBPMConfig.class, "FoxBPMConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFoxBPMConfig_Version(), ecorePackage.getEString(), "version", null, 0, 1, FoxBPMConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFoxBPMConfig_ResourcePathConfig(), this.getResourcePathConfig(), null, "resourcePathConfig", null, 0, 1, FoxBPMConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFoxBPMConfig_SysMailConfig(), this.getSysMailConfig(), null, "sysMailConfig", null, 0, 1, FoxBPMConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFoxBPMConfig_ConnectionManagementConfig(), this.getConnectionManagementConfig(), null, "connectionManagementConfig", null, 0, 1, FoxBPMConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sysMailConfigEClass, SysMailConfig.class, "SysMailConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSysMailConfig_MailInfo(), this.getMailInfo(), null, "mailInfo", null, 0, -1, SysMailConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSysMailConfig_Selected(), ecorePackage.getEString(), "selected", null, 1, 1, SysMailConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectionManagementConfigEClass, ConnectionManagementConfig.class, "ConnectionManagementConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConnectionManagementConfig_Selected(), ecorePackage.getEString(), "selected", null, 1, 1, ConnectionManagementConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectionManagementConfig_ConnectionManagement(), this.getConnectionManagement(), null, "connectionManagement", null, 0, -1, ConnectionManagementConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectionManagementEClass, ConnectionManagement.class, "ConnectionManagement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConnectionManagement_Id(), ecorePackage.getEString(), "id", null, 1, 1, ConnectionManagement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionManagement_Name(), ecorePackage.getEString(), "name", null, 0, 1, ConnectionManagement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionManagement_ClassImpl(), ecorePackage.getEString(), "classImpl", null, 1, 1, ConnectionManagement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourcePathConfigEClass, ResourcePathConfig.class, "ResourcePathConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourcePathConfig_ResourcePath(), this.getResourcePath(), null, "resourcePath", null, 0, -1, ResourcePathConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourcePathEClass, ResourcePath.class, "ResourcePath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResourcePath_Id(), ecorePackage.getEString(), "id", null, 1, 1, ResourcePath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourcePath_Name(), ecorePackage.getEString(), "name", null, 0, 1, ResourcePath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourcePath_Src(), ecorePackage.getEString(), "src", null, 0, 1, ResourcePath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourcePath_PhysicalPath(), ecorePackage.getEString(), "physicalPath", null, 0, 1, ResourcePath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourcePath_VirtualPath(), ecorePackage.getEString(), "virtualPath", null, 0, 1, ResourcePath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourcePath_ProjectName(), ecorePackage.getEString(), "projectName", null, 0, 1, ResourcePath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mailInfoEClass, MailInfo.class, "MailInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMailInfo_MailAddress(), ecorePackage.getEString(), "mailAddress", null, 1, 1, MailInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMailInfo_MailName(), ecorePackage.getEString(), "mailName", null, 1, 1, MailInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMailInfo_SmtpHost(), ecorePackage.getEString(), "smtpHost", null, 1, 1, MailInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMailInfo_SmtpPort(), ecorePackage.getEString(), "smtpPort", null, 1, 1, MailInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMailInfo_UserName(), ecorePackage.getEString(), "userName", null, 1, 1, MailInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMailInfo_Password(), ecorePackage.getEString(), "password", null, 1, 1, MailInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";			
		addAnnotation
		  (getFoxBPMConfig_Version(), 
		   source, 
		   new String[] {
			 "name", "version",
			 "kind", "attribute"
		   });			
		addAnnotation
		  (getFoxBPMConfig_ResourcePathConfig(), 
		   source, 
		   new String[] {
			 "name", "resourcePathConfig",
			 "kind", "element"
		   });			
		addAnnotation
		  (getFoxBPMConfig_SysMailConfig(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getFoxBPMConfig_ConnectionManagementConfig(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (sysMailConfigEClass, 
		   source, 
		   new String[] {
			 "name", "SysMailConfig"
		   });			
		addAnnotation
		  (getSysMailConfig_MailInfo(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });			
		addAnnotation
		  (getSysMailConfig_Selected(), 
		   source, 
		   new String[] {
			 "name", "selected",
			 "kind", "attribute"
		   });					
		addAnnotation
		  (getConnectionManagementConfig_ConnectionManagement(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });				
		addAnnotation
		  (getConnectionManagement_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });			
		addAnnotation
		  (getConnectionManagement_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });			
		addAnnotation
		  (getConnectionManagement_ClassImpl(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });				
		addAnnotation
		  (getResourcePathConfig_ResourcePath(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });				
		addAnnotation
		  (getResourcePath_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });			
		addAnnotation
		  (getResourcePath_Src(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });			
		addAnnotation
		  (getResourcePath_PhysicalPath(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });			
		addAnnotation
		  (getResourcePath_VirtualPath(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });			
		addAnnotation
		  (getResourcePath_ProjectName(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });			
		addAnnotation
		  (mailInfoEClass, 
		   source, 
		   new String[] {
			 "name", "MailInfo"
		   });			
		addAnnotation
		  (getMailInfo_MailAddress(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });			
		addAnnotation
		  (getMailInfo_MailName(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });			
		addAnnotation
		  (getMailInfo_SmtpHost(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });			
		addAnnotation
		  (getMailInfo_SmtpPort(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });			
		addAnnotation
		  (getMailInfo_UserName(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });			
		addAnnotation
		  (getMailInfo_Password(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });	
	}

} //FoxBPMConfigPackageImpl
