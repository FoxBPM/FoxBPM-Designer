/**
 */
package org.foxbpm.model.config.variableconfig.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.foxbpm.model.config.variableconfig.DataTypeDef;
import org.foxbpm.model.config.variableconfig.DataVariableBizType;
import org.foxbpm.model.config.variableconfig.DataVariableBizTypeConfig;
import org.foxbpm.model.config.variableconfig.DataVariableConfig;
import org.foxbpm.model.config.variableconfig.DataVariableDataType;
import org.foxbpm.model.config.variableconfig.DataVariableDef;
import org.foxbpm.model.config.variableconfig.DataVariableType;
import org.foxbpm.model.config.variableconfig.DocumentRoot;
import org.foxbpm.model.config.variableconfig.FoxBPMDataVariable;
import org.foxbpm.model.config.variableconfig.Type;
import org.foxbpm.model.config.variableconfig.VariableconfigFactory;
import org.foxbpm.model.config.variableconfig.VariableconfigPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VariableconfigPackageImpl extends EPackageImpl implements VariableconfigPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataVariableConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataVariableTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataVariableDataTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass foxBPMDataVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataVariableDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataVariableBizTypeConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataVariableBizTypeEClass = null;

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
	 * @see org.foxbpm.model.config.variableconfig.VariableconfigPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private VariableconfigPackageImpl() {
		super(eNS_URI, VariableconfigFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link VariableconfigPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static VariableconfigPackage init() {
		if (isInited) return (VariableconfigPackage)EPackage.Registry.INSTANCE.getEPackage(VariableconfigPackage.eNS_URI);

		// Obtain or create and register package
		VariableconfigPackageImpl theVariableconfigPackage = (VariableconfigPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof VariableconfigPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new VariableconfigPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theVariableconfigPackage.createPackageContents();

		// Initialize created meta-data
		theVariableconfigPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theVariableconfigPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(VariableconfigPackage.eNS_URI, theVariableconfigPackage);
		return theVariableconfigPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentRoot() {
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Mixed() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XMLNSPrefixMap() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XSISchemaLocation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_DataVariableConfig() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataVariableConfig() {
		return dataVariableConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataVariableConfig_DataVariableType() {
		return (EReference)dataVariableConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataVariableConfig_FoxBPMDataVariable() {
		return (EReference)dataVariableConfigEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataVariableConfig_DataVariableDataType() {
		return (EReference)dataVariableConfigEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataVariableConfig_DataVariableBizTypeConfig() {
		return (EReference)dataVariableConfigEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataVariableType() {
		return dataVariableTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataVariableType_Type() {
		return (EReference)dataVariableTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getType() {
		return typeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getType_Name() {
		return (EAttribute)typeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getType_Id() {
		return (EAttribute)typeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataVariableDataType() {
		return dataVariableDataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataVariableDataType_DataTypeDef() {
		return (EReference)dataVariableDataTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataTypeDef() {
		return dataTypeDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataTypeDef_Name() {
		return (EAttribute)dataTypeDefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataTypeDef_TypeValue() {
		return (EAttribute)dataTypeDefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataTypeDef_Id() {
		return (EAttribute)dataTypeDefEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFoxBPMDataVariable() {
		return foxBPMDataVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFoxBPMDataVariable_DataVariableDef() {
		return (EReference)foxBPMDataVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFoxBPMDataVariable_Type() {
		return (EAttribute)foxBPMDataVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataVariableDef() {
		return dataVariableDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataVariableDef_Name() {
		return (EAttribute)dataVariableDefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataVariableDef_DataType() {
		return (EAttribute)dataVariableDefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataVariableDef_Value() {
		return (EAttribute)dataVariableDefEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataVariableDef_Doc() {
		return (EAttribute)dataVariableDefEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataVariableBizTypeConfig() {
		return dataVariableBizTypeConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataVariableBizTypeConfig_DataVariableBizType() {
		return (EReference)dataVariableBizTypeConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataVariableBizType() {
		return dataVariableBizTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataVariableBizType_TypeId() {
		return (EAttribute)dataVariableBizTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataVariableBizType_TypeName() {
		return (EAttribute)dataVariableBizTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataVariableBizType_Img() {
		return (EAttribute)dataVariableBizTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableconfigFactory getVariableconfigFactory() {
		return (VariableconfigFactory)getEFactoryInstance();
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
		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__DATA_VARIABLE_CONFIG);

		dataVariableConfigEClass = createEClass(DATA_VARIABLE_CONFIG);
		createEReference(dataVariableConfigEClass, DATA_VARIABLE_CONFIG__DATA_VARIABLE_TYPE);
		createEReference(dataVariableConfigEClass, DATA_VARIABLE_CONFIG__FOX_BPM_DATA_VARIABLE);
		createEReference(dataVariableConfigEClass, DATA_VARIABLE_CONFIG__DATA_VARIABLE_DATA_TYPE);
		createEReference(dataVariableConfigEClass, DATA_VARIABLE_CONFIG__DATA_VARIABLE_BIZ_TYPE_CONFIG);

		dataVariableTypeEClass = createEClass(DATA_VARIABLE_TYPE);
		createEReference(dataVariableTypeEClass, DATA_VARIABLE_TYPE__TYPE);

		typeEClass = createEClass(TYPE);
		createEAttribute(typeEClass, TYPE__NAME);
		createEAttribute(typeEClass, TYPE__ID);

		dataVariableDataTypeEClass = createEClass(DATA_VARIABLE_DATA_TYPE);
		createEReference(dataVariableDataTypeEClass, DATA_VARIABLE_DATA_TYPE__DATA_TYPE_DEF);

		dataTypeDefEClass = createEClass(DATA_TYPE_DEF);
		createEAttribute(dataTypeDefEClass, DATA_TYPE_DEF__NAME);
		createEAttribute(dataTypeDefEClass, DATA_TYPE_DEF__TYPE_VALUE);
		createEAttribute(dataTypeDefEClass, DATA_TYPE_DEF__ID);

		foxBPMDataVariableEClass = createEClass(FOX_BPM_DATA_VARIABLE);
		createEReference(foxBPMDataVariableEClass, FOX_BPM_DATA_VARIABLE__DATA_VARIABLE_DEF);
		createEAttribute(foxBPMDataVariableEClass, FOX_BPM_DATA_VARIABLE__TYPE);

		dataVariableDefEClass = createEClass(DATA_VARIABLE_DEF);
		createEAttribute(dataVariableDefEClass, DATA_VARIABLE_DEF__NAME);
		createEAttribute(dataVariableDefEClass, DATA_VARIABLE_DEF__DATA_TYPE);
		createEAttribute(dataVariableDefEClass, DATA_VARIABLE_DEF__VALUE);
		createEAttribute(dataVariableDefEClass, DATA_VARIABLE_DEF__DOC);

		dataVariableBizTypeConfigEClass = createEClass(DATA_VARIABLE_BIZ_TYPE_CONFIG);
		createEReference(dataVariableBizTypeConfigEClass, DATA_VARIABLE_BIZ_TYPE_CONFIG__DATA_VARIABLE_BIZ_TYPE);

		dataVariableBizTypeEClass = createEClass(DATA_VARIABLE_BIZ_TYPE);
		createEAttribute(dataVariableBizTypeEClass, DATA_VARIABLE_BIZ_TYPE__TYPE_ID);
		createEAttribute(dataVariableBizTypeEClass, DATA_VARIABLE_BIZ_TYPE__TYPE_NAME);
		createEAttribute(dataVariableBizTypeEClass, DATA_VARIABLE_BIZ_TYPE__IMG);
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

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_DataVariableConfig(), this.getDataVariableConfig(), null, "dataVariableConfig", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataVariableConfigEClass, DataVariableConfig.class, "DataVariableConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataVariableConfig_DataVariableType(), this.getDataVariableType(), null, "dataVariableType", null, 1, 1, DataVariableConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataVariableConfig_FoxBPMDataVariable(), this.getFoxBPMDataVariable(), null, "foxBPMDataVariable", null, 0, -1, DataVariableConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataVariableConfig_DataVariableDataType(), this.getDataVariableDataType(), null, "dataVariableDataType", null, 1, 1, DataVariableConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataVariableConfig_DataVariableBizTypeConfig(), this.getDataVariableBizTypeConfig(), null, "dataVariableBizTypeConfig", null, 0, 1, DataVariableConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataVariableTypeEClass, DataVariableType.class, "DataVariableType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataVariableType_Type(), this.getType(), null, "type", null, 0, -1, DataVariableType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeEClass, Type.class, "Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getType_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getType_Id(), theXMLTypePackage.getString(), "id", null, 1, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataVariableDataTypeEClass, DataVariableDataType.class, "DataVariableDataType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataVariableDataType_DataTypeDef(), this.getDataTypeDef(), null, "dataTypeDef", null, 0, -1, DataVariableDataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataTypeDefEClass, DataTypeDef.class, "DataTypeDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataTypeDef_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, DataTypeDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataTypeDef_TypeValue(), theXMLTypePackage.getString(), "typeValue", null, 1, 1, DataTypeDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataTypeDef_Id(), theXMLTypePackage.getString(), "id", null, 1, 1, DataTypeDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(foxBPMDataVariableEClass, FoxBPMDataVariable.class, "FoxBPMDataVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFoxBPMDataVariable_DataVariableDef(), this.getDataVariableDef(), null, "dataVariableDef", null, 0, -1, FoxBPMDataVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFoxBPMDataVariable_Type(), theXMLTypePackage.getString(), "type", null, 1, 1, FoxBPMDataVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataVariableDefEClass, DataVariableDef.class, "DataVariableDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataVariableDef_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, DataVariableDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataVariableDef_DataType(), theXMLTypePackage.getString(), "dataType", null, 0, 1, DataVariableDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataVariableDef_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, DataVariableDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataVariableDef_Doc(), theXMLTypePackage.getString(), "doc", null, 0, 1, DataVariableDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataVariableBizTypeConfigEClass, DataVariableBizTypeConfig.class, "DataVariableBizTypeConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataVariableBizTypeConfig_DataVariableBizType(), this.getDataVariableBizType(), null, "dataVariableBizType", null, 0, -1, DataVariableBizTypeConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataVariableBizTypeEClass, DataVariableBizType.class, "DataVariableBizType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataVariableBizType_TypeId(), theXMLTypePackage.getString(), "typeId", null, 0, 1, DataVariableBizType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataVariableBizType_TypeName(), theXMLTypePackage.getString(), "typeName", null, 0, 1, DataVariableBizType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataVariableBizType_Img(), theXMLTypePackage.getString(), "img", null, 0, 1, DataVariableBizType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		  (documentRootEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns:prefix"
		   });		
		addAnnotation
		  (getDocumentRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xsi:schemaLocation"
		   });		
		addAnnotation
		  (getDocumentRoot_DataVariableConfig(), 
		   source, 
		   new String[] {
			 "name", "dataVariableConfig",
			 "kind", "element"
		   });		
		addAnnotation
		  (dataVariableConfigEClass, 
		   source, 
		   new String[] {
			 "name", "dataVariableConfig"
		   });		
		addAnnotation
		  (getDataVariableConfig_DataVariableType(), 
		   source, 
		   new String[] {
			 "name", "dataVariableType",
			 "kind", "element"
		   });		
		addAnnotation
		  (getDataVariableConfig_FoxBPMDataVariable(), 
		   source, 
		   new String[] {
			 "name", "foxBPMDataVariable",
			 "kind", "element"
		   });		
		addAnnotation
		  (getDataVariableConfig_DataVariableDataType(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dataVariableDataType"
		   });		
		addAnnotation
		  (getDataVariableConfig_DataVariableBizTypeConfig(), 
		   source, 
		   new String[] {
			 "name", "dataVariableBizTypeConfig",
			 "kind", "element"
		   });		
		addAnnotation
		  (dataVariableTypeEClass, 
		   source, 
		   new String[] {
			 "name", "dataVariableType"
		   });		
		addAnnotation
		  (getDataVariableType_Type(), 
		   source, 
		   new String[] {
			 "name", "type",
			 "kind", "element"
		   });		
		addAnnotation
		  (typeEClass, 
		   source, 
		   new String[] {
			 "name", "type"
		   });		
		addAnnotation
		  (getType_Name(), 
		   source, 
		   new String[] {
			 "name", "name",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getType_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (dataVariableDataTypeEClass, 
		   source, 
		   new String[] {
			 "name", "dataVariableDataType"
		   });		
		addAnnotation
		  (getDataVariableDataType_DataTypeDef(), 
		   source, 
		   new String[] {
			 "name", "dataTypeDef",
			 "kind", "element"
		   });		
		addAnnotation
		  (dataTypeDefEClass, 
		   source, 
		   new String[] {
			 "name", "dataTypeDef"
		   });		
		addAnnotation
		  (getDataTypeDef_Name(), 
		   source, 
		   new String[] {
			 "name", "name",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDataTypeDef_TypeValue(), 
		   source, 
		   new String[] {
			 "name", "typeValue",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDataTypeDef_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (foxBPMDataVariableEClass, 
		   source, 
		   new String[] {
			 "name", "foxBPMDataVariable"
		   });		
		addAnnotation
		  (getFoxBPMDataVariable_DataVariableDef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dataVariableDef"
		   });		
		addAnnotation
		  (getFoxBPMDataVariable_Type(), 
		   source, 
		   new String[] {
			 "name", "type",
			 "namespace", "",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (dataVariableDefEClass, 
		   source, 
		   new String[] {
			 "name", "dataVariableDef"
		   });		
		addAnnotation
		  (getDataVariableDef_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getDataVariableDef_DataType(), 
		   source, 
		   new String[] {
			 "name", "dataType",
			 "namespace", "",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDataVariableDef_Value(), 
		   source, 
		   new String[] {
			 "kind", "simple"
		   });		
		addAnnotation
		  (getDataVariableDef_Doc(), 
		   source, 
		   new String[] {
			 "kind", "simple"
		   });		
		addAnnotation
		  (dataVariableBizTypeConfigEClass, 
		   source, 
		   new String[] {
			 "name", "dataVariableBizTypeConfig"
		   });		
		addAnnotation
		  (getDataVariableBizTypeConfig_DataVariableBizType(), 
		   source, 
		   new String[] {
			 "name", "dataVariableBizType",
			 "kind", "element"
		   });		
		addAnnotation
		  (dataVariableBizTypeEClass, 
		   source, 
		   new String[] {
			 "name", "dataVariableBizType"
		   });		
		addAnnotation
		  (getDataVariableBizType_TypeId(), 
		   source, 
		   new String[] {
			 "name", "typeId",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDataVariableBizType_TypeName(), 
		   source, 
		   new String[] {
			 "name", "typeName",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDataVariableBizType_Img(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });
	}

} //VariableconfigPackageImpl
