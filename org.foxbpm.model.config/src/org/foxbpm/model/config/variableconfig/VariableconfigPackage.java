/**
 */
package org.foxbpm.model.config.variableconfig;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * 此XML Schema定义的BPMN 2.0的扩展元素是Founder公司拓展的属性。
 * 		
 * <!-- end-model-doc -->
 * @see org.foxbpm.model.config.variableconfig.VariableconfigFactory
 * @model kind="package"
 * @generated
 */
public interface VariableconfigPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "variableconfig";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.foxbpm.org/variableconfig";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "variableconfig";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VariableconfigPackage eINSTANCE = org.foxbpm.model.config.variableconfig.impl.VariableconfigPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.variableconfig.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.variableconfig.impl.DocumentRootImpl
	 * @see org.foxbpm.model.config.variableconfig.impl.VariableconfigPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 0;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Data Variable Config</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__DATA_VARIABLE_CONFIG = 3;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.variableconfig.impl.DataVariableConfigImpl <em>Data Variable Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.variableconfig.impl.DataVariableConfigImpl
	 * @see org.foxbpm.model.config.variableconfig.impl.VariableconfigPackageImpl#getDataVariableConfig()
	 * @generated
	 */
	int DATA_VARIABLE_CONFIG = 1;

	/**
	 * The feature id for the '<em><b>Data Variable Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_CONFIG__DATA_VARIABLE_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Fox BPM Data Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_CONFIG__FOX_BPM_DATA_VARIABLE = 1;

	/**
	 * The feature id for the '<em><b>Data Variable Data Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_CONFIG__DATA_VARIABLE_DATA_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Data Variable Biz Type Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_CONFIG__DATA_VARIABLE_BIZ_TYPE_CONFIG = 3;

	/**
	 * The number of structural features of the '<em>Data Variable Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_CONFIG_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Data Variable Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_CONFIG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.variableconfig.impl.DataVariableTypeImpl <em>Data Variable Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.variableconfig.impl.DataVariableTypeImpl
	 * @see org.foxbpm.model.config.variableconfig.impl.VariableconfigPackageImpl#getDataVariableType()
	 * @generated
	 */
	int DATA_VARIABLE_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_TYPE__TYPE = 0;

	/**
	 * The number of structural features of the '<em>Data Variable Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Data Variable Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.variableconfig.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.variableconfig.impl.TypeImpl
	 * @see org.foxbpm.model.config.variableconfig.impl.VariableconfigPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__ID = 1;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.variableconfig.impl.DataVariableDataTypeImpl <em>Data Variable Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.variableconfig.impl.DataVariableDataTypeImpl
	 * @see org.foxbpm.model.config.variableconfig.impl.VariableconfigPackageImpl#getDataVariableDataType()
	 * @generated
	 */
	int DATA_VARIABLE_DATA_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Data Type Def</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_DATA_TYPE__DATA_TYPE_DEF = 0;

	/**
	 * The number of structural features of the '<em>Data Variable Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_DATA_TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Data Variable Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_DATA_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.variableconfig.impl.DataTypeDefImpl <em>Data Type Def</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.variableconfig.impl.DataTypeDefImpl
	 * @see org.foxbpm.model.config.variableconfig.impl.VariableconfigPackageImpl#getDataTypeDef()
	 * @generated
	 */
	int DATA_TYPE_DEF = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEF__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEF__TYPE_VALUE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEF__ID = 2;

	/**
	 * The number of structural features of the '<em>Data Type Def</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEF_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Data Type Def</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEF_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.variableconfig.impl.FoxBPMDataVariableImpl <em>Fox BPM Data Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.variableconfig.impl.FoxBPMDataVariableImpl
	 * @see org.foxbpm.model.config.variableconfig.impl.VariableconfigPackageImpl#getFoxBPMDataVariable()
	 * @generated
	 */
	int FOX_BPM_DATA_VARIABLE = 6;

	/**
	 * The feature id for the '<em><b>Data Variable Def</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOX_BPM_DATA_VARIABLE__DATA_VARIABLE_DEF = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOX_BPM_DATA_VARIABLE__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Fox BPM Data Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOX_BPM_DATA_VARIABLE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Fox BPM Data Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOX_BPM_DATA_VARIABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.variableconfig.impl.DataVariableDefImpl <em>Data Variable Def</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.variableconfig.impl.DataVariableDefImpl
	 * @see org.foxbpm.model.config.variableconfig.impl.VariableconfigPackageImpl#getDataVariableDef()
	 * @generated
	 */
	int DATA_VARIABLE_DEF = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_DEF__NAME = 0;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_DEF__DATA_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_DEF__VALUE = 2;

	/**
	 * The feature id for the '<em><b>Doc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_DEF__DOC = 3;

	/**
	 * The number of structural features of the '<em>Data Variable Def</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_DEF_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Data Variable Def</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_DEF_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.variableconfig.impl.DataVariableBizTypeConfigImpl <em>Data Variable Biz Type Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.variableconfig.impl.DataVariableBizTypeConfigImpl
	 * @see org.foxbpm.model.config.variableconfig.impl.VariableconfigPackageImpl#getDataVariableBizTypeConfig()
	 * @generated
	 */
	int DATA_VARIABLE_BIZ_TYPE_CONFIG = 8;

	/**
	 * The feature id for the '<em><b>Data Variable Biz Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_BIZ_TYPE_CONFIG__DATA_VARIABLE_BIZ_TYPE = 0;

	/**
	 * The number of structural features of the '<em>Data Variable Biz Type Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_BIZ_TYPE_CONFIG_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Data Variable Biz Type Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_BIZ_TYPE_CONFIG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.variableconfig.impl.DataVariableBizTypeImpl <em>Data Variable Biz Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.variableconfig.impl.DataVariableBizTypeImpl
	 * @see org.foxbpm.model.config.variableconfig.impl.VariableconfigPackageImpl#getDataVariableBizType()
	 * @generated
	 */
	int DATA_VARIABLE_BIZ_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_BIZ_TYPE__TYPE_ID = 0;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_BIZ_TYPE__TYPE_NAME = 1;

	/**
	 * The feature id for the '<em><b>Img</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_BIZ_TYPE__IMG = 2;

	/**
	 * The number of structural features of the '<em>Data Variable Biz Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_BIZ_TYPE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Data Variable Biz Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_BIZ_TYPE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.variableconfig.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.foxbpm.model.config.variableconfig.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link org.foxbpm.model.config.variableconfig.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.foxbpm.model.config.variableconfig.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.foxbpm.model.config.variableconfig.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.foxbpm.model.config.variableconfig.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.foxbpm.model.config.variableconfig.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.foxbpm.model.config.variableconfig.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.config.variableconfig.DocumentRoot#getDataVariableConfig <em>Data Variable Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Variable Config</em>'.
	 * @see org.foxbpm.model.config.variableconfig.DocumentRoot#getDataVariableConfig()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_DataVariableConfig();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.variableconfig.DataVariableConfig <em>Data Variable Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Variable Config</em>'.
	 * @see org.foxbpm.model.config.variableconfig.DataVariableConfig
	 * @generated
	 */
	EClass getDataVariableConfig();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.config.variableconfig.DataVariableConfig#getDataVariableType <em>Data Variable Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Variable Type</em>'.
	 * @see org.foxbpm.model.config.variableconfig.DataVariableConfig#getDataVariableType()
	 * @see #getDataVariableConfig()
	 * @generated
	 */
	EReference getDataVariableConfig_DataVariableType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.config.variableconfig.DataVariableConfig#getFoxBPMDataVariable <em>Fox BPM Data Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fox BPM Data Variable</em>'.
	 * @see org.foxbpm.model.config.variableconfig.DataVariableConfig#getFoxBPMDataVariable()
	 * @see #getDataVariableConfig()
	 * @generated
	 */
	EReference getDataVariableConfig_FoxBPMDataVariable();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.config.variableconfig.DataVariableConfig#getDataVariableDataType <em>Data Variable Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Variable Data Type</em>'.
	 * @see org.foxbpm.model.config.variableconfig.DataVariableConfig#getDataVariableDataType()
	 * @see #getDataVariableConfig()
	 * @generated
	 */
	EReference getDataVariableConfig_DataVariableDataType();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.config.variableconfig.DataVariableConfig#getDataVariableBizTypeConfig <em>Data Variable Biz Type Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Variable Biz Type Config</em>'.
	 * @see org.foxbpm.model.config.variableconfig.DataVariableConfig#getDataVariableBizTypeConfig()
	 * @see #getDataVariableConfig()
	 * @generated
	 */
	EReference getDataVariableConfig_DataVariableBizTypeConfig();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.variableconfig.DataVariableType <em>Data Variable Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Variable Type</em>'.
	 * @see org.foxbpm.model.config.variableconfig.DataVariableType
	 * @generated
	 */
	EClass getDataVariableType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.config.variableconfig.DataVariableType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type</em>'.
	 * @see org.foxbpm.model.config.variableconfig.DataVariableType#getType()
	 * @see #getDataVariableType()
	 * @generated
	 */
	EReference getDataVariableType_Type();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.variableconfig.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see org.foxbpm.model.config.variableconfig.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.variableconfig.Type#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.foxbpm.model.config.variableconfig.Type#getName()
	 * @see #getType()
	 * @generated
	 */
	EAttribute getType_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.variableconfig.Type#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.foxbpm.model.config.variableconfig.Type#getId()
	 * @see #getType()
	 * @generated
	 */
	EAttribute getType_Id();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.variableconfig.DataVariableDataType <em>Data Variable Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Variable Data Type</em>'.
	 * @see org.foxbpm.model.config.variableconfig.DataVariableDataType
	 * @generated
	 */
	EClass getDataVariableDataType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.config.variableconfig.DataVariableDataType#getDataTypeDef <em>Data Type Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Type Def</em>'.
	 * @see org.foxbpm.model.config.variableconfig.DataVariableDataType#getDataTypeDef()
	 * @see #getDataVariableDataType()
	 * @generated
	 */
	EReference getDataVariableDataType_DataTypeDef();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.variableconfig.DataTypeDef <em>Data Type Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type Def</em>'.
	 * @see org.foxbpm.model.config.variableconfig.DataTypeDef
	 * @generated
	 */
	EClass getDataTypeDef();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.variableconfig.DataTypeDef#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.foxbpm.model.config.variableconfig.DataTypeDef#getName()
	 * @see #getDataTypeDef()
	 * @generated
	 */
	EAttribute getDataTypeDef_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.variableconfig.DataTypeDef#getTypeValue <em>Type Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Value</em>'.
	 * @see org.foxbpm.model.config.variableconfig.DataTypeDef#getTypeValue()
	 * @see #getDataTypeDef()
	 * @generated
	 */
	EAttribute getDataTypeDef_TypeValue();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.variableconfig.DataTypeDef#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.foxbpm.model.config.variableconfig.DataTypeDef#getId()
	 * @see #getDataTypeDef()
	 * @generated
	 */
	EAttribute getDataTypeDef_Id();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.variableconfig.FoxBPMDataVariable <em>Fox BPM Data Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fox BPM Data Variable</em>'.
	 * @see org.foxbpm.model.config.variableconfig.FoxBPMDataVariable
	 * @generated
	 */
	EClass getFoxBPMDataVariable();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.config.variableconfig.FoxBPMDataVariable#getDataVariableDef <em>Data Variable Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Variable Def</em>'.
	 * @see org.foxbpm.model.config.variableconfig.FoxBPMDataVariable#getDataVariableDef()
	 * @see #getFoxBPMDataVariable()
	 * @generated
	 */
	EReference getFoxBPMDataVariable_DataVariableDef();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.variableconfig.FoxBPMDataVariable#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.foxbpm.model.config.variableconfig.FoxBPMDataVariable#getType()
	 * @see #getFoxBPMDataVariable()
	 * @generated
	 */
	EAttribute getFoxBPMDataVariable_Type();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.variableconfig.DataVariableDef <em>Data Variable Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Variable Def</em>'.
	 * @see org.foxbpm.model.config.variableconfig.DataVariableDef
	 * @generated
	 */
	EClass getDataVariableDef();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.variableconfig.DataVariableDef#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.foxbpm.model.config.variableconfig.DataVariableDef#getName()
	 * @see #getDataVariableDef()
	 * @generated
	 */
	EAttribute getDataVariableDef_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.variableconfig.DataVariableDef#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Type</em>'.
	 * @see org.foxbpm.model.config.variableconfig.DataVariableDef#getDataType()
	 * @see #getDataVariableDef()
	 * @generated
	 */
	EAttribute getDataVariableDef_DataType();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.variableconfig.DataVariableDef#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.foxbpm.model.config.variableconfig.DataVariableDef#getValue()
	 * @see #getDataVariableDef()
	 * @generated
	 */
	EAttribute getDataVariableDef_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.variableconfig.DataVariableDef#getDoc <em>Doc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Doc</em>'.
	 * @see org.foxbpm.model.config.variableconfig.DataVariableDef#getDoc()
	 * @see #getDataVariableDef()
	 * @generated
	 */
	EAttribute getDataVariableDef_Doc();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.variableconfig.DataVariableBizTypeConfig <em>Data Variable Biz Type Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Variable Biz Type Config</em>'.
	 * @see org.foxbpm.model.config.variableconfig.DataVariableBizTypeConfig
	 * @generated
	 */
	EClass getDataVariableBizTypeConfig();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.config.variableconfig.DataVariableBizTypeConfig#getDataVariableBizType <em>Data Variable Biz Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Variable Biz Type</em>'.
	 * @see org.foxbpm.model.config.variableconfig.DataVariableBizTypeConfig#getDataVariableBizType()
	 * @see #getDataVariableBizTypeConfig()
	 * @generated
	 */
	EReference getDataVariableBizTypeConfig_DataVariableBizType();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.variableconfig.DataVariableBizType <em>Data Variable Biz Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Variable Biz Type</em>'.
	 * @see org.foxbpm.model.config.variableconfig.DataVariableBizType
	 * @generated
	 */
	EClass getDataVariableBizType();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.variableconfig.DataVariableBizType#getTypeId <em>Type Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Id</em>'.
	 * @see org.foxbpm.model.config.variableconfig.DataVariableBizType#getTypeId()
	 * @see #getDataVariableBizType()
	 * @generated
	 */
	EAttribute getDataVariableBizType_TypeId();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.variableconfig.DataVariableBizType#getTypeName <em>Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Name</em>'.
	 * @see org.foxbpm.model.config.variableconfig.DataVariableBizType#getTypeName()
	 * @see #getDataVariableBizType()
	 * @generated
	 */
	EAttribute getDataVariableBizType_TypeName();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.variableconfig.DataVariableBizType#getImg <em>Img</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Img</em>'.
	 * @see org.foxbpm.model.config.variableconfig.DataVariableBizType#getImg()
	 * @see #getDataVariableBizType()
	 * @generated
	 */
	EAttribute getDataVariableBizType_Img();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	VariableconfigFactory getVariableconfigFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.variableconfig.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.variableconfig.impl.DocumentRootImpl
		 * @see org.foxbpm.model.config.variableconfig.impl.VariableconfigPackageImpl#getDocumentRoot()
		 * @generated
		 */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Data Variable Config</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__DATA_VARIABLE_CONFIG = eINSTANCE.getDocumentRoot_DataVariableConfig();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.variableconfig.impl.DataVariableConfigImpl <em>Data Variable Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.variableconfig.impl.DataVariableConfigImpl
		 * @see org.foxbpm.model.config.variableconfig.impl.VariableconfigPackageImpl#getDataVariableConfig()
		 * @generated
		 */
		EClass DATA_VARIABLE_CONFIG = eINSTANCE.getDataVariableConfig();

		/**
		 * The meta object literal for the '<em><b>Data Variable Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_VARIABLE_CONFIG__DATA_VARIABLE_TYPE = eINSTANCE.getDataVariableConfig_DataVariableType();

		/**
		 * The meta object literal for the '<em><b>Fox BPM Data Variable</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_VARIABLE_CONFIG__FOX_BPM_DATA_VARIABLE = eINSTANCE.getDataVariableConfig_FoxBPMDataVariable();

		/**
		 * The meta object literal for the '<em><b>Data Variable Data Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_VARIABLE_CONFIG__DATA_VARIABLE_DATA_TYPE = eINSTANCE.getDataVariableConfig_DataVariableDataType();

		/**
		 * The meta object literal for the '<em><b>Data Variable Biz Type Config</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_VARIABLE_CONFIG__DATA_VARIABLE_BIZ_TYPE_CONFIG = eINSTANCE.getDataVariableConfig_DataVariableBizTypeConfig();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.variableconfig.impl.DataVariableTypeImpl <em>Data Variable Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.variableconfig.impl.DataVariableTypeImpl
		 * @see org.foxbpm.model.config.variableconfig.impl.VariableconfigPackageImpl#getDataVariableType()
		 * @generated
		 */
		EClass DATA_VARIABLE_TYPE = eINSTANCE.getDataVariableType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_VARIABLE_TYPE__TYPE = eINSTANCE.getDataVariableType_Type();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.variableconfig.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.variableconfig.impl.TypeImpl
		 * @see org.foxbpm.model.config.variableconfig.impl.VariableconfigPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE__NAME = eINSTANCE.getType_Name();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE__ID = eINSTANCE.getType_Id();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.variableconfig.impl.DataVariableDataTypeImpl <em>Data Variable Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.variableconfig.impl.DataVariableDataTypeImpl
		 * @see org.foxbpm.model.config.variableconfig.impl.VariableconfigPackageImpl#getDataVariableDataType()
		 * @generated
		 */
		EClass DATA_VARIABLE_DATA_TYPE = eINSTANCE.getDataVariableDataType();

		/**
		 * The meta object literal for the '<em><b>Data Type Def</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_VARIABLE_DATA_TYPE__DATA_TYPE_DEF = eINSTANCE.getDataVariableDataType_DataTypeDef();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.variableconfig.impl.DataTypeDefImpl <em>Data Type Def</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.variableconfig.impl.DataTypeDefImpl
		 * @see org.foxbpm.model.config.variableconfig.impl.VariableconfigPackageImpl#getDataTypeDef()
		 * @generated
		 */
		EClass DATA_TYPE_DEF = eINSTANCE.getDataTypeDef();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE_DEF__NAME = eINSTANCE.getDataTypeDef_Name();

		/**
		 * The meta object literal for the '<em><b>Type Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE_DEF__TYPE_VALUE = eINSTANCE.getDataTypeDef_TypeValue();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE_DEF__ID = eINSTANCE.getDataTypeDef_Id();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.variableconfig.impl.FoxBPMDataVariableImpl <em>Fox BPM Data Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.variableconfig.impl.FoxBPMDataVariableImpl
		 * @see org.foxbpm.model.config.variableconfig.impl.VariableconfigPackageImpl#getFoxBPMDataVariable()
		 * @generated
		 */
		EClass FOX_BPM_DATA_VARIABLE = eINSTANCE.getFoxBPMDataVariable();

		/**
		 * The meta object literal for the '<em><b>Data Variable Def</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOX_BPM_DATA_VARIABLE__DATA_VARIABLE_DEF = eINSTANCE.getFoxBPMDataVariable_DataVariableDef();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOX_BPM_DATA_VARIABLE__TYPE = eINSTANCE.getFoxBPMDataVariable_Type();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.variableconfig.impl.DataVariableDefImpl <em>Data Variable Def</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.variableconfig.impl.DataVariableDefImpl
		 * @see org.foxbpm.model.config.variableconfig.impl.VariableconfigPackageImpl#getDataVariableDef()
		 * @generated
		 */
		EClass DATA_VARIABLE_DEF = eINSTANCE.getDataVariableDef();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_VARIABLE_DEF__NAME = eINSTANCE.getDataVariableDef_Name();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_VARIABLE_DEF__DATA_TYPE = eINSTANCE.getDataVariableDef_DataType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_VARIABLE_DEF__VALUE = eINSTANCE.getDataVariableDef_Value();

		/**
		 * The meta object literal for the '<em><b>Doc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_VARIABLE_DEF__DOC = eINSTANCE.getDataVariableDef_Doc();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.variableconfig.impl.DataVariableBizTypeConfigImpl <em>Data Variable Biz Type Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.variableconfig.impl.DataVariableBizTypeConfigImpl
		 * @see org.foxbpm.model.config.variableconfig.impl.VariableconfigPackageImpl#getDataVariableBizTypeConfig()
		 * @generated
		 */
		EClass DATA_VARIABLE_BIZ_TYPE_CONFIG = eINSTANCE.getDataVariableBizTypeConfig();

		/**
		 * The meta object literal for the '<em><b>Data Variable Biz Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_VARIABLE_BIZ_TYPE_CONFIG__DATA_VARIABLE_BIZ_TYPE = eINSTANCE.getDataVariableBizTypeConfig_DataVariableBizType();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.variableconfig.impl.DataVariableBizTypeImpl <em>Data Variable Biz Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.variableconfig.impl.DataVariableBizTypeImpl
		 * @see org.foxbpm.model.config.variableconfig.impl.VariableconfigPackageImpl#getDataVariableBizType()
		 * @generated
		 */
		EClass DATA_VARIABLE_BIZ_TYPE = eINSTANCE.getDataVariableBizType();

		/**
		 * The meta object literal for the '<em><b>Type Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_VARIABLE_BIZ_TYPE__TYPE_ID = eINSTANCE.getDataVariableBizType_TypeId();

		/**
		 * The meta object literal for the '<em><b>Type Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_VARIABLE_BIZ_TYPE__TYPE_NAME = eINSTANCE.getDataVariableBizType_TypeName();

		/**
		 * The meta object literal for the '<em><b>Img</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_VARIABLE_BIZ_TYPE__IMG = eINSTANCE.getDataVariableBizType_Img();

	}

} //VariableconfigPackage
