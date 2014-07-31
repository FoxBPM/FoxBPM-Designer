/**
 */
package org.foxbpm.model.bpmn.foxbpm;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * 此XML Schema定义的BPMN 2.0的扩展元素是FXOBPM拓展的属性。
 * 		
 * <!-- end-model-doc -->
 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory
 * @model kind="package"
 * @generated
 */
public interface FoxBPMPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "foxbpm";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.foxbpm.org/foxbpm";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "foxbpm";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FoxBPMPackage eINSTANCE = org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.DocumentRootImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getDocumentRoot()
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
	 * The feature id for the '<em><b>Task Subject</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__TASK_SUBJECT = 3;

	/**
	 * The feature id for the '<em><b>Task Command</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__TASK_COMMAND = 4;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__RESOURCE_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Resource Filter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__RESOURCE_FILTER = 6;

	/**
	 * The feature id for the '<em><b>Data Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__DATA_VARIABLE = 7;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__VERSION = 8;

	/**
	 * The feature id for the '<em><b>Dbid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__DBID = 9;

	/**
	 * The feature id for the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__CATEGORY = 10;

	/**
	 * The feature id for the '<em><b>Connector Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__CONNECTOR_INSTANCE = 11;

	/**
	 * The feature id for the '<em><b>Loop Data Input Collection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__LOOP_DATA_INPUT_COLLECTION = 12;

	/**
	 * The feature id for the '<em><b>Loop Data Output Collection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__LOOP_DATA_OUTPUT_COLLECTION = 13;

	/**
	 * The feature id for the '<em><b>Form Uri</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__FORM_URI = 14;

	/**
	 * The feature id for the '<em><b>Loop Maximum</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__LOOP_MAXIMUM = 15;

	/**
	 * The feature id for the '<em><b>Sub Task</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SUB_TASK = 16;

	/**
	 * The feature id for the '<em><b>Script Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SCRIPT_NAME = 17;

	/**
	 * The feature id for the '<em><b>Result Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__RESULT_VARIABLE = 18;

	/**
	 * The feature id for the '<em><b>Callable Element Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__CALLABLE_ELEMENT_ID = 19;

	/**
	 * The feature id for the '<em><b>Callable Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__CALLABLE_ELEMENT_NAME = 20;

	/**
	 * The feature id for the '<em><b>Callable Element Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__CALLABLE_ELEMENT_VERSION = 21;

	/**
	 * The feature id for the '<em><b>Callable Element Version Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__CALLABLE_ELEMENT_VERSION_NAME = 22;

	/**
	 * The feature id for the '<em><b>Include Exclusion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__INCLUDE_EXCLUSION = 23;

	/**
	 * The feature id for the '<em><b>Resource Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__RESOURCE_RANGE = 24;

	/**
	 * The feature id for the '<em><b>Assign Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ASSIGN_ACTION = 25;

	/**
	 * The feature id for the '<em><b>Error Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ERROR_CODE = 26;

	/**
	 * The feature id for the '<em><b>Skip Strategy</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SKIP_STRATEGY = 27;

	/**
	 * The feature id for the '<em><b>Is Contains Sub</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__IS_CONTAINS_SUB = 28;

	/**
	 * The feature id for the '<em><b>Verification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__VERIFICATION = 29;

	/**
	 * The feature id for the '<em><b>Message Obj</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MESSAGE_OBJ = 30;

	/**
	 * The feature id for the '<em><b>Receive Message</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__RECEIVE_MESSAGE = 31;

	/**
	 * The feature id for the '<em><b>Expected Execution Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__EXPECTED_EXECUTION_TIME = 32;

	/**
	 * The feature id for the '<em><b>Data Source To Sub Process Mapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__DATA_SOURCE_TO_SUB_PROCESS_MAPPING = 33;

	/**
	 * The feature id for the '<em><b>Sub Process To Data Source Mapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SUB_PROCESS_TO_DATA_SOURCE_MAPPING = 34;

	/**
	 * The feature id for the '<em><b>Callable Element Biz Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__CALLABLE_ELEMENT_BIZ_KEY = 35;

	/**
	 * The feature id for the '<em><b>Callable Element Biz Key Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__CALLABLE_ELEMENT_BIZ_KEY_NAME = 36;

	/**
	 * The feature id for the '<em><b>Is Async</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__IS_ASYNC = 37;

	/**
	 * The feature id for the '<em><b>Form Uri View</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__FORM_URI_VIEW = 38;

	/**
	 * The feature id for the '<em><b>Order Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ORDER_ID = 39;

	/**
	 * The feature id for the '<em><b>Task Priority</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__TASK_PRIORITY = 40;

	/**
	 * The feature id for the '<em><b>Assign Policy Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ASSIGN_POLICY_TYPE = 41;

	/**
	 * The feature id for the '<em><b>Is Persistence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__IS_PERSISTENCE = 42;

	/**
	 * The feature id for the '<em><b>Task Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__TASK_TYPE = 43;

	/**
	 * The feature id for the '<em><b>Validation Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__VALIDATION_LEVEL = 44;

	/**
	 * The feature id for the '<em><b>Language Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__LANGUAGE_TYPE = 45;

	/**
	 * The feature id for the '<em><b>Connector Instance Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__CONNECTOR_INSTANCE_ELEMENTS = 46;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__NAME = 47;

	/**
	 * The feature id for the '<em><b>Is Create Record</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__IS_CREATE_RECORD = 48;

	/**
	 * The feature id for the '<em><b>Claim Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__CLAIM_TYPE = 49;

	/**
	 * The feature id for the '<em><b>Task Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__TASK_DESCRIPTION = 50;

	/**
	 * The feature id for the '<em><b>Complete Task Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__COMPLETE_TASK_DESCRIPTION = 51;

	/**
	 * The feature id for the '<em><b>Form Param Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__FORM_PARAM_CONTAINER = 52;

	/**
	 * The feature id for the '<em><b>Converg Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__CONVERG_TYPE = 53;

	/**
	 * The feature id for the '<em><b>Potential Starter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__POTENTIAL_STARTER = 54;

	/**
	 * The feature id for the '<em><b>Potential Owner</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__POTENTIAL_OWNER = 55;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 56;

	/**
	 * The number of operations of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.ExpressionImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__ID = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__NAME = 2;

	/**
	 * The feature id for the '<em><b>Is Run</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__IS_RUN = 3;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__MIXED = 4;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.TaskSubjectImpl <em>Task Subject</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.TaskSubjectImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getTaskSubject()
	 * @generated
	 */
	int TASK_SUBJECT = 2;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_SUBJECT__EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_SUBJECT__ID = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_SUBJECT__NAME = 2;

	/**
	 * The number of structural features of the '<em>Task Subject</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_SUBJECT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Task Subject</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_SUBJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.BaseConfigImpl <em>Base Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.BaseConfigImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getBaseConfig()
	 * @generated
	 */
	int BASE_CONFIG = 39;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_CONFIG__PARAMS = 0;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_CONFIG__DOCUMENTATION = 1;

	/**
	 * The number of structural features of the '<em>Base Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_CONFIG_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Base Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_CONFIG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.TaskCommandImpl <em>Task Command</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.TaskCommandImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getTaskCommand()
	 * @generated
	 */
	int TASK_COMMAND = 3;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_COMMAND__PARAMS = BASE_CONFIG__PARAMS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_COMMAND__DOCUMENTATION = BASE_CONFIG__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_COMMAND__ID = BASE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_COMMAND__NAME = BASE_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Command Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_COMMAND__COMMAND_TYPE = BASE_CONFIG_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_COMMAND__EXPRESSION = BASE_CONFIG_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Order Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_COMMAND__ORDER_ID = BASE_CONFIG_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Parameter Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_COMMAND__PARAMETER_EXPRESSION = BASE_CONFIG_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Task Command</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_COMMAND_FEATURE_COUNT = BASE_CONFIG_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Task Command</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_COMMAND_OPERATION_COUNT = BASE_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.ResourceFilterImpl <em>Resource Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.ResourceFilterImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getResourceFilter()
	 * @generated
	 */
	int RESOURCE_FILTER = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FILTER__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FILTER__NAME = 1;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FILTER__EXPRESSION = 2;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FILTER__DOCUMENTATION = 3;

	/**
	 * The number of structural features of the '<em>Resource Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FILTER_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Resource Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FILTER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.DataVariableImpl <em>Data Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.DataVariableImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getDataVariable()
	 * @generated
	 */
	int DATA_VARIABLE = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE__ID = 0;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE__DATA_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Is List</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE__IS_LIST = 2;

	/**
	 * The feature id for the '<em><b>Is Persistence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE__IS_PERSISTENCE = 3;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE__EXPRESSION = 4;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE__DOCUMENTATION = 5;

	/**
	 * The feature id for the '<em><b>Biz Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE__BIZ_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Field Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE__FIELD_NAME = 7;

	/**
	 * The number of structural features of the '<em>Data Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Data Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.DocumentationImpl <em>Documentation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.DocumentationImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getDocumentation()
	 * @generated
	 */
	int DOCUMENTATION = 6;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__ID = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__NAME = 2;

	/**
	 * The number of structural features of the '<em>Documentation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Documentation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorInstanceImpl <em>Connector Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.ConnectorInstanceImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getConnectorInstance()
	 * @generated
	 */
	int CONNECTOR_INSTANCE = 7;

	/**
	 * The feature id for the '<em><b>Connector Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_INSTANCE__CONNECTOR_ID = 0;

	/**
	 * The feature id for the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_INSTANCE__PACKAGE_NAME = 1;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_INSTANCE__CLASS_NAME = 2;

	/**
	 * The feature id for the '<em><b>Connector Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_INSTANCE__CONNECTOR_INSTANCE_ID = 3;

	/**
	 * The feature id for the '<em><b>Connector Instance Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_INSTANCE__CONNECTOR_INSTANCE_NAME = 4;

	/**
	 * The feature id for the '<em><b>Event Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_INSTANCE__EVENT_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_INSTANCE__DOCUMENTATION = 6;

	/**
	 * The feature id for the '<em><b>Error Handling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_INSTANCE__ERROR_HANDLING = 7;

	/**
	 * The feature id for the '<em><b>Error Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_INSTANCE__ERROR_CODE = 8;

	/**
	 * The feature id for the '<em><b>Connector Parameter Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_INSTANCE__CONNECTOR_PARAMETER_INPUTS = 9;

	/**
	 * The feature id for the '<em><b>Connector Parameter Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_INSTANCE__CONNECTOR_PARAMETER_OUTPUTS = 10;

	/**
	 * The feature id for the '<em><b>Connector Parameter Outputs Def</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_INSTANCE__CONNECTOR_PARAMETER_OUTPUTS_DEF = 11;

	/**
	 * The feature id for the '<em><b>Skip Comment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_INSTANCE__SKIP_COMMENT = 12;

	/**
	 * The feature id for the '<em><b>Time Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_INSTANCE__TIME_EXPRESSION = 13;

	/**
	 * The feature id for the '<em><b>Is Time Execute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_INSTANCE__IS_TIME_EXECUTE = 14;

	/**
	 * The feature id for the '<em><b>Time Skip Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_INSTANCE__TIME_SKIP_EXPRESSION = 15;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_INSTANCE__VERSION = 16;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_INSTANCE__TYPE = 17;

	/**
	 * The number of structural features of the '<em>Connector Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_INSTANCE_FEATURE_COUNT = 18;

	/**
	 * The number of operations of the '<em>Connector Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_INSTANCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorParameterInputImpl <em>Connector Parameter Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.ConnectorParameterInputImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getConnectorParameterInput()
	 * @generated
	 */
	int CONNECTOR_PARAMETER_INPUT = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_PARAMETER_INPUT__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_PARAMETER_INPUT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_PARAMETER_INPUT__DATA_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_PARAMETER_INPUT__EXPRESSION = 3;

	/**
	 * The feature id for the '<em><b>Is Execute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_PARAMETER_INPUT__IS_EXECUTE = 4;

	/**
	 * The number of structural features of the '<em>Connector Parameter Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_PARAMETER_INPUT_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Connector Parameter Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_PARAMETER_INPUT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorParameterOutputImpl <em>Connector Parameter Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.ConnectorParameterOutputImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getConnectorParameterOutput()
	 * @generated
	 */
	int CONNECTOR_PARAMETER_OUTPUT = 9;

	/**
	 * The feature id for the '<em><b>Variable Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_PARAMETER_OUTPUT__VARIABLE_TARGET = 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_PARAMETER_OUTPUT__EXPRESSION = 1;

	/**
	 * The feature id for the '<em><b>Output Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_PARAMETER_OUTPUT__OUTPUT_ID = 2;

	/**
	 * The number of structural features of the '<em>Connector Parameter Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_PARAMETER_OUTPUT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Connector Parameter Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_PARAMETER_OUTPUT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.LoopDataInputCollectionImpl <em>Loop Data Input Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.LoopDataInputCollectionImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getLoopDataInputCollection()
	 * @generated
	 */
	int LOOP_DATA_INPUT_COLLECTION = 10;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_DATA_INPUT_COLLECTION__EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Loop Data Input Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_DATA_INPUT_COLLECTION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Loop Data Input Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_DATA_INPUT_COLLECTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.LoopDataOutputCollectionImpl <em>Loop Data Output Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.LoopDataOutputCollectionImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getLoopDataOutputCollection()
	 * @generated
	 */
	int LOOP_DATA_OUTPUT_COLLECTION = 11;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_DATA_OUTPUT_COLLECTION__EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Loop Data Output Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_DATA_OUTPUT_COLLECTION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Loop Data Output Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_DATA_OUTPUT_COLLECTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorParameterOutputDefImpl <em>Connector Parameter Output Def</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.ConnectorParameterOutputDefImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getConnectorParameterOutputDef()
	 * @generated
	 */
	int CONNECTOR_PARAMETER_OUTPUT_DEF = 12;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_PARAMETER_OUTPUT_DEF__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_PARAMETER_OUTPUT_DEF__NAME = 1;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_PARAMETER_OUTPUT_DEF__DATA_TYPE = 2;

	/**
	 * The number of structural features of the '<em>Connector Parameter Output Def</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_PARAMETER_OUTPUT_DEF_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Connector Parameter Output Def</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_PARAMETER_OUTPUT_DEF_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.FormUriImpl <em>Form Uri</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FormUriImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getFormUri()
	 * @generated
	 */
	int FORM_URI = 13;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_URI__EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Form Uri</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_URI_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Form Uri</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_URI_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.LoopMaximumImpl <em>Loop Maximum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.LoopMaximumImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getLoopMaximum()
	 * @generated
	 */
	int LOOP_MAXIMUM = 14;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_MAXIMUM__EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Loop Maximum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_MAXIMUM_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Loop Maximum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_MAXIMUM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.SkipStrategyImpl <em>Skip Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.SkipStrategyImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getSkipStrategy()
	 * @generated
	 */
	int SKIP_STRATEGY = 15;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIP_STRATEGY__EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Is Create Skip Process</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIP_STRATEGY__IS_CREATE_SKIP_PROCESS = 1;

	/**
	 * The feature id for the '<em><b>Skip Assignee</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIP_STRATEGY__SKIP_ASSIGNEE = 2;

	/**
	 * The feature id for the '<em><b>Skip Comment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIP_STRATEGY__SKIP_COMMENT = 3;

	/**
	 * The feature id for the '<em><b>Is Enable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIP_STRATEGY__IS_ENABLE = 4;

	/**
	 * The number of structural features of the '<em>Skip Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIP_STRATEGY_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Skip Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIP_STRATEGY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.MessageObjImpl <em>Message Obj</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.MessageObjImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getMessageObj()
	 * @generated
	 */
	int MESSAGE_OBJ = 16;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_OBJ__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_OBJ__NAME = 1;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_OBJ__DOCUMENTATION = 2;

	/**
	 * The feature id for the '<em><b>Data Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_OBJ__DATA_VARIABLE = 3;

	/**
	 * The feature id for the '<em><b>Target Process</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_OBJ__TARGET_PROCESS = 4;

	/**
	 * The feature id for the '<em><b>Target Node</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_OBJ__TARGET_NODE = 5;

	/**
	 * The feature id for the '<em><b>Process Instance Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_OBJ__PROCESS_INSTANCE_VARIABLE = 6;

	/**
	 * The feature id for the '<em><b>Token Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_OBJ__TOKEN_VARIABLE = 7;

	/**
	 * The feature id for the '<em><b>Message Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_OBJ__MESSAGE_TYPE = 8;

	/**
	 * The number of structural features of the '<em>Message Obj</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_OBJ_FEATURE_COUNT = 9;

	/**
	 * The number of operations of the '<em>Message Obj</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_OBJ_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.FilterConditionsImpl <em>Filter Conditions</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FilterConditionsImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getFilterConditions()
	 * @generated
	 */
	int FILTER_CONDITIONS = 17;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_CONDITIONS__EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Filter Conditions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_CONDITIONS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Filter Conditions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_CONDITIONS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.ReceiveMessageImpl <em>Receive Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.ReceiveMessageImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getReceiveMessage()
	 * @generated
	 */
	int RECEIVE_MESSAGE = 18;

	/**
	 * The feature id for the '<em><b>Message Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_MESSAGE__MESSAGE_ID = 0;

	/**
	 * The feature id for the '<em><b>Filter Conditions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_MESSAGE__FILTER_CONDITIONS = 1;

	/**
	 * The feature id for the '<em><b>Process Instance Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_MESSAGE__PROCESS_INSTANCE_VARIABLE = 2;

	/**
	 * The feature id for the '<em><b>Token Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_MESSAGE__TOKEN_VARIABLE = 3;

	/**
	 * The number of structural features of the '<em>Receive Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_MESSAGE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Receive Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_MESSAGE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.TokenVariableImpl <em>Token Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.TokenVariableImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getTokenVariable()
	 * @generated
	 */
	int TOKEN_VARIABLE = 19;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_VARIABLE__EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Token Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_VARIABLE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Token Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_VARIABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.ProcessInstanceVariableImpl <em>Process Instance Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.ProcessInstanceVariableImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getProcessInstanceVariable()
	 * @generated
	 */
	int PROCESS_INSTANCE_VARIABLE = 20;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_INSTANCE_VARIABLE__EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Process Instance Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_INSTANCE_VARIABLE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Process Instance Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_INSTANCE_VARIABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.ExpectedExecutionTimeImpl <em>Expected Execution Time</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.ExpectedExecutionTimeImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getExpectedExecutionTime()
	 * @generated
	 */
	int EXPECTED_EXECUTION_TIME = 21;

	/**
	 * The feature id for the '<em><b>Day</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_EXECUTION_TIME__DAY = 0;

	/**
	 * The feature id for the '<em><b>Hour</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_EXECUTION_TIME__HOUR = 1;

	/**
	 * The feature id for the '<em><b>Minute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_EXECUTION_TIME__MINUTE = 2;

	/**
	 * The feature id for the '<em><b>Second</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_EXECUTION_TIME__SECOND = 3;

	/**
	 * The number of structural features of the '<em>Expected Execution Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_EXECUTION_TIME_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Expected Execution Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPECTED_EXECUTION_TIME_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.DataSourceToSubProcessMappingImpl <em>Data Source To Sub Process Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.DataSourceToSubProcessMappingImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getDataSourceToSubProcessMapping()
	 * @generated
	 */
	int DATA_SOURCE_TO_SUB_PROCESS_MAPPING = 22;

	/**
	 * The feature id for the '<em><b>Data Variable Mapping</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE_TO_SUB_PROCESS_MAPPING__DATA_VARIABLE_MAPPING = 0;

	/**
	 * The number of structural features of the '<em>Data Source To Sub Process Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE_TO_SUB_PROCESS_MAPPING_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Data Source To Sub Process Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE_TO_SUB_PROCESS_MAPPING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.SubProcessToDataSourceMappingImpl <em>Sub Process To Data Source Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.SubProcessToDataSourceMappingImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getSubProcessToDataSourceMapping()
	 * @generated
	 */
	int SUB_PROCESS_TO_DATA_SOURCE_MAPPING = 23;

	/**
	 * The feature id for the '<em><b>Data Variable Mapping</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS_TO_DATA_SOURCE_MAPPING__DATA_VARIABLE_MAPPING = 0;

	/**
	 * The number of structural features of the '<em>Sub Process To Data Source Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS_TO_DATA_SOURCE_MAPPING_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Sub Process To Data Source Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS_TO_DATA_SOURCE_MAPPING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.DataVariableMappingImpl <em>Data Variable Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.DataVariableMappingImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getDataVariableMapping()
	 * @generated
	 */
	int DATA_VARIABLE_MAPPING = 24;

	/**
	 * The feature id for the '<em><b>Data Source Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_MAPPING__DATA_SOURCE_ID = 0;

	/**
	 * The feature id for the '<em><b>Sub Proces Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_MAPPING__SUB_PROCES_ID = 1;

	/**
	 * The number of structural features of the '<em>Data Variable Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_MAPPING_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Data Variable Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VARIABLE_MAPPING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.FormUriViewImpl <em>Form Uri View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FormUriViewImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getFormUriView()
	 * @generated
	 */
	int FORM_URI_VIEW = 25;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_URI_VIEW__EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Form Uri View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_URI_VIEW_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Form Uri View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_URI_VIEW_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.TaskPriorityImpl <em>Task Priority</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.TaskPriorityImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getTaskPriority()
	 * @generated
	 */
	int TASK_PRIORITY = 26;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_PRIORITY__EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Task Priority</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_PRIORITY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Task Priority</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_PRIORITY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.AssignPolicyTypeImpl <em>Assign Policy Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.AssignPolicyTypeImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getAssignPolicyType()
	 * @generated
	 */
	int ASSIGN_POLICY_TYPE = 27;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_POLICY_TYPE__ID = 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_POLICY_TYPE__EXPRESSION = 1;

	/**
	 * The number of structural features of the '<em>Assign Policy Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_POLICY_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Assign Policy Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_POLICY_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.SkipAssigneeImpl <em>Skip Assignee</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.SkipAssigneeImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getSkipAssignee()
	 * @generated
	 */
	int SKIP_ASSIGNEE = 28;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIP_ASSIGNEE__EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Skip Assignee</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIP_ASSIGNEE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Skip Assignee</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIP_ASSIGNEE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.SkipCommentImpl <em>Skip Comment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.SkipCommentImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getSkipComment()
	 * @generated
	 */
	int SKIP_COMMENT = 29;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIP_COMMENT__EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Skip Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIP_COMMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Skip Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIP_COMMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorInstanceElementsImpl <em>Connector Instance Elements</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.ConnectorInstanceElementsImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getConnectorInstanceElements()
	 * @generated
	 */
	int CONNECTOR_INSTANCE_ELEMENTS = 30;

	/**
	 * The feature id for the '<em><b>Connrctor Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_INSTANCE_ELEMENTS__CONNRCTOR_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Connector Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_INSTANCE_ELEMENTS__CONNECTOR_INSTANCE = 1;

	/**
	 * The number of structural features of the '<em>Connector Instance Elements</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_INSTANCE_ELEMENTS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Connector Instance Elements</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_INSTANCE_ELEMENTS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.TimeExpressionImpl <em>Time Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.TimeExpressionImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getTimeExpression()
	 * @generated
	 */
	int TIME_EXPRESSION = 31;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_EXPRESSION__EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Time Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_EXPRESSION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Time Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.TimeSkipExpressionImpl <em>Time Skip Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.TimeSkipExpressionImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getTimeSkipExpression()
	 * @generated
	 */
	int TIME_SKIP_EXPRESSION = 32;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SKIP_EXPRESSION__EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Time Skip Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SKIP_EXPRESSION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Time Skip Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_SKIP_EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.TableExpressionImpl <em>Table Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.TableExpressionImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getTableExpression()
	 * @generated
	 */
	int TABLE_EXPRESSION = 33;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_EXPRESSION__VALUE = EXPRESSION__VALUE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_EXPRESSION__ID = EXPRESSION__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_EXPRESSION__NAME = EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Is Run</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_EXPRESSION__IS_RUN = EXPRESSION__IS_RUN;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_EXPRESSION__MIXED = EXPRESSION__MIXED;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_EXPRESSION__EXPRESSIONS = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Table Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Table Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.ListExpressionImpl <em>List Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.ListExpressionImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getListExpression()
	 * @generated
	 */
	int LIST_EXPRESSION = 34;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_EXPRESSION__VALUE = EXPRESSION__VALUE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_EXPRESSION__ID = EXPRESSION__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_EXPRESSION__NAME = EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Is Run</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_EXPRESSION__IS_RUN = EXPRESSION__IS_RUN;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_EXPRESSION__MIXED = EXPRESSION__MIXED;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_EXPRESSION__EXPRESSIONS = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>List Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>List Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.TaskDescriptionImpl <em>Task Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.TaskDescriptionImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getTaskDescription()
	 * @generated
	 */
	int TASK_DESCRIPTION = 35;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_DESCRIPTION__EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Task Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_DESCRIPTION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Task Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_DESCRIPTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.CompleteTaskDescriptionImpl <em>Complete Task Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.CompleteTaskDescriptionImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getCompleteTaskDescription()
	 * @generated
	 */
	int COMPLETE_TASK_DESCRIPTION = 36;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TASK_DESCRIPTION__EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Complete Task Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TASK_DESCRIPTION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Complete Task Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TASK_DESCRIPTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.FormParamContainerImpl <em>Form Param Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FormParamContainerImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getFormParamContainer()
	 * @generated
	 */
	int FORM_PARAM_CONTAINER = 37;

	/**
	 * The feature id for the '<em><b>Form Param</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_PARAM_CONTAINER__FORM_PARAM = 0;

	/**
	 * The number of structural features of the '<em>Form Param Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_PARAM_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Form Param Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_PARAM_CONTAINER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.FormParamImpl <em>Form Param</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FormParamImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getFormParam()
	 * @generated
	 */
	int FORM_PARAM = 38;

	/**
	 * The feature id for the '<em><b>Param Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_PARAM__PARAM_KEY = 0;

	/**
	 * The feature id for the '<em><b>Param Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_PARAM__PARAM_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_PARAM__EXPRESSION = 2;

	/**
	 * The number of structural features of the '<em>Form Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_PARAM_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Form Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_PARAM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.ParamImpl <em>Param</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.ParamImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getParam()
	 * @generated
	 */
	int PARAM = 40;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM__KEY = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM__NAME = 1;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM__EXPRESSION = 2;

	/**
	 * The number of structural features of the '<em>Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.PotentialStarterImpl <em>Potential Starter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.PotentialStarterImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getPotentialStarter()
	 * @generated
	 */
	int POTENTIAL_STARTER = 41;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_STARTER__PARAMS = BASE_CONFIG__PARAMS;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_STARTER__DOCUMENTATION = BASE_CONFIG__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_STARTER__EXPRESSION = BASE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_STARTER__RESOURCE_TYPE = BASE_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>EReference0</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_STARTER__EREFERENCE0 = BASE_CONFIG_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_STARTER__DESCRIPTION = BASE_CONFIG_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Potential Starter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_STARTER_FEATURE_COUNT = BASE_CONFIG_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Potential Starter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_STARTER_OPERATION_COUNT = BASE_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.PotentialOwnerImpl <em>Potential Owner</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.PotentialOwnerImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getPotentialOwner()
	 * @generated
	 */
	int POTENTIAL_OWNER = 42;

	/**
	 * The feature id for the '<em><b>Connector Instance Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_OWNER__CONNECTOR_INSTANCE_ELEMENTS = 0;

	/**
	 * The number of structural features of the '<em>Potential Owner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_OWNER_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Potential Owner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_OWNER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.CommandParamImpl <em>Command Param</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.CommandParamImpl
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getCommandParam()
	 * @generated
	 */
	int COMMAND_PARAM = 43;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_PARAM__KEY = PARAM__KEY;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_PARAM__NAME = PARAM__NAME;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_PARAM__EXPRESSION = PARAM__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Biz Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_PARAM__BIZ_TYPE = PARAM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_PARAM__DATA_TYPE = PARAM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Command Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_PARAM_FEATURE_COUNT = PARAM_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Command Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_PARAM_OPERATION_COUNT = PARAM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.bpmn.foxbpm.ProcessValidationLevel <em>Process Validation Level</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.bpmn.foxbpm.ProcessValidationLevel
	 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getProcessValidationLevel()
	 * @generated
	 */
	int PROCESS_VALIDATION_LEVEL = 44;


	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getTaskSubject <em>Task Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Task Subject</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getTaskSubject()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_TaskSubject();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getTaskCommand <em>Task Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Task Command</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getTaskCommand()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_TaskCommand();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getResourceType <em>Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource Type</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getResourceType()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_ResourceType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getResourceFilter <em>Resource Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Filter</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getResourceFilter()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_ResourceFilter();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getDataVariable <em>Data Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Variable</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getDataVariable()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_DataVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getVersion()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getDbid <em>Dbid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dbid</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getDbid()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Dbid();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Category</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getCategory()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Category();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getConnectorInstance <em>Connector Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connector Instance</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getConnectorInstance()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_ConnectorInstance();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getLoopDataInputCollection <em>Loop Data Input Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Loop Data Input Collection</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getLoopDataInputCollection()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_LoopDataInputCollection();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getLoopDataOutputCollection <em>Loop Data Output Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Loop Data Output Collection</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getLoopDataOutputCollection()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_LoopDataOutputCollection();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getFormUri <em>Form Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Form Uri</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getFormUri()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_FormUri();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getLoopMaximum <em>Loop Maximum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Loop Maximum</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getLoopMaximum()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_LoopMaximum();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getSubTask <em>Sub Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sub Task</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getSubTask()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_SubTask();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getScriptName <em>Script Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Script Name</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getScriptName()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_ScriptName();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getResultVariable <em>Result Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result Variable</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getResultVariable()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_ResultVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getCallableElementId <em>Callable Element Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Callable Element Id</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getCallableElementId()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_CallableElementId();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getCallableElementName <em>Callable Element Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Callable Element Name</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getCallableElementName()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_CallableElementName();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getCallableElementVersion <em>Callable Element Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Callable Element Version</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getCallableElementVersion()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_CallableElementVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getCallableElementVersionName <em>Callable Element Version Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Callable Element Version Name</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getCallableElementVersionName()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_CallableElementVersionName();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getIncludeExclusion <em>Include Exclusion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Include Exclusion</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getIncludeExclusion()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_IncludeExclusion();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getResourceRange <em>Resource Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource Range</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getResourceRange()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_ResourceRange();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getAssignAction <em>Assign Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Assign Action</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getAssignAction()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_AssignAction();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getErrorCode <em>Error Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Error Code</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getErrorCode()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_ErrorCode();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getSkipStrategy <em>Skip Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Skip Strategy</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getSkipStrategy()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_SkipStrategy();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#isIsContainsSub <em>Is Contains Sub</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Contains Sub</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#isIsContainsSub()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_IsContainsSub();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getVerification <em>Verification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Verification</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getVerification()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Verification();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getMessageObj <em>Message Obj</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Message Obj</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getMessageObj()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_MessageObj();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getReceiveMessage <em>Receive Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Receive Message</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getReceiveMessage()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_ReceiveMessage();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getExpectedExecutionTime <em>Expected Execution Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expected Execution Time</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getExpectedExecutionTime()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_ExpectedExecutionTime();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getDataSourceToSubProcessMapping <em>Data Source To Sub Process Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Source To Sub Process Mapping</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getDataSourceToSubProcessMapping()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_DataSourceToSubProcessMapping();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getSubProcessToDataSourceMapping <em>Sub Process To Data Source Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub Process To Data Source Mapping</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getSubProcessToDataSourceMapping()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_SubProcessToDataSourceMapping();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getCallableElementBizKey <em>Callable Element Biz Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Callable Element Biz Key</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getCallableElementBizKey()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_CallableElementBizKey();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getCallableElementBizKeyName <em>Callable Element Biz Key Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Callable Element Biz Key Name</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getCallableElementBizKeyName()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_CallableElementBizKeyName();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getIsAsync <em>Is Async</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Async</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getIsAsync()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_IsAsync();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getFormUriView <em>Form Uri View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Form Uri View</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getFormUriView()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_FormUriView();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getOrderId <em>Order Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Order Id</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getOrderId()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_OrderId();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getTaskPriority <em>Task Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Task Priority</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getTaskPriority()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_TaskPriority();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getAssignPolicyType <em>Assign Policy Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Assign Policy Type</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getAssignPolicyType()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_AssignPolicyType();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#isIsPersistence <em>Is Persistence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Persistence</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#isIsPersistence()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_IsPersistence();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getTaskType <em>Task Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Task Type</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getTaskType()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_TaskType();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getValidationLevel <em>Validation Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Validation Level</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getValidationLevel()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_ValidationLevel();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getLanguageType <em>Language Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language Type</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getLanguageType()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_LanguageType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getConnectorInstanceElements <em>Connector Instance Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connector Instance Elements</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getConnectorInstanceElements()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_ConnectorInstanceElements();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getName()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getIsCreateRecord <em>Is Create Record</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Create Record</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getIsCreateRecord()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_IsCreateRecord();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getClaimType <em>Claim Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Claim Type</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getClaimType()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_ClaimType();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getTaskDescription <em>Task Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Task Description</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getTaskDescription()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_TaskDescription();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getCompleteTaskDescription <em>Complete Task Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Complete Task Description</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getCompleteTaskDescription()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_CompleteTaskDescription();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getFormParamContainer <em>Form Param Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Form Param Container</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getFormParamContainer()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_FormParamContainer();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getConvergType <em>Converg Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Converg Type</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getConvergType()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_ConvergType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getPotentialStarter <em>Potential Starter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Potential Starter</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getPotentialStarter()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_PotentialStarter();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getPotentialOwner <em>Potential Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Potential Owner</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DocumentRoot#getPotentialOwner()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_PotentialOwner();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.Expression#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.Expression#getValue()
	 * @see #getExpression()
	 * @generated
	 */
	EAttribute getExpression_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.Expression#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.Expression#getId()
	 * @see #getExpression()
	 * @generated
	 */
	EAttribute getExpression_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.Expression#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.Expression#getName()
	 * @see #getExpression()
	 * @generated
	 */
	EAttribute getExpression_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.Expression#isIsRun <em>Is Run</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Run</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.Expression#isIsRun()
	 * @see #getExpression()
	 * @generated
	 */
	EAttribute getExpression_IsRun();

	/**
	 * Returns the meta object for the attribute list '{@link org.foxbpm.model.bpmn.foxbpm.Expression#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.Expression#getMixed()
	 * @see #getExpression()
	 * @generated
	 */
	EAttribute getExpression_Mixed();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.TaskSubject <em>Task Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task Subject</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.TaskSubject
	 * @generated
	 */
	EClass getTaskSubject();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.TaskSubject#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.TaskSubject#getExpression()
	 * @see #getTaskSubject()
	 * @generated
	 */
	EReference getTaskSubject_Expression();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.TaskSubject#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.TaskSubject#getId()
	 * @see #getTaskSubject()
	 * @generated
	 */
	EAttribute getTaskSubject_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.TaskSubject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.TaskSubject#getName()
	 * @see #getTaskSubject()
	 * @generated
	 */
	EAttribute getTaskSubject_Name();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.TaskCommand <em>Task Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task Command</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.TaskCommand
	 * @generated
	 */
	EClass getTaskCommand();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.TaskCommand#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.TaskCommand#getId()
	 * @see #getTaskCommand()
	 * @generated
	 */
	EAttribute getTaskCommand_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.TaskCommand#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.TaskCommand#getName()
	 * @see #getTaskCommand()
	 * @generated
	 */
	EAttribute getTaskCommand_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.TaskCommand#getCommandType <em>Command Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Command Type</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.TaskCommand#getCommandType()
	 * @see #getTaskCommand()
	 * @generated
	 */
	EAttribute getTaskCommand_CommandType();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.TaskCommand#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.TaskCommand#getExpression()
	 * @see #getTaskCommand()
	 * @generated
	 */
	EReference getTaskCommand_Expression();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.TaskCommand#getOrderId <em>Order Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Order Id</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.TaskCommand#getOrderId()
	 * @see #getTaskCommand()
	 * @generated
	 */
	EAttribute getTaskCommand_OrderId();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.TaskCommand#getParameterExpression <em>Parameter Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Parameter Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.TaskCommand#getParameterExpression()
	 * @see #getTaskCommand()
	 * @generated
	 */
	EReference getTaskCommand_ParameterExpression();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.ResourceFilter <em>Resource Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Filter</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ResourceFilter
	 * @generated
	 */
	EClass getResourceFilter();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.ResourceFilter#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ResourceFilter#getId()
	 * @see #getResourceFilter()
	 * @generated
	 */
	EAttribute getResourceFilter_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.ResourceFilter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ResourceFilter#getName()
	 * @see #getResourceFilter()
	 * @generated
	 */
	EAttribute getResourceFilter_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.ResourceFilter#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ResourceFilter#getExpression()
	 * @see #getResourceFilter()
	 * @generated
	 */
	EReference getResourceFilter_Expression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.bpmn.foxbpm.ResourceFilter#getDocumentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Documentation</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ResourceFilter#getDocumentation()
	 * @see #getResourceFilter()
	 * @generated
	 */
	EReference getResourceFilter_Documentation();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.DataVariable <em>Data Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Variable</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DataVariable
	 * @generated
	 */
	EClass getDataVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DataVariable#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DataVariable#getId()
	 * @see #getDataVariable()
	 * @generated
	 */
	EAttribute getDataVariable_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DataVariable#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Type</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DataVariable#getDataType()
	 * @see #getDataVariable()
	 * @generated
	 */
	EAttribute getDataVariable_DataType();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DataVariable#isIsList <em>Is List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is List</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DataVariable#isIsList()
	 * @see #getDataVariable()
	 * @generated
	 */
	EAttribute getDataVariable_IsList();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DataVariable#isIsPersistence <em>Is Persistence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Persistence</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DataVariable#isIsPersistence()
	 * @see #getDataVariable()
	 * @generated
	 */
	EAttribute getDataVariable_IsPersistence();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.DataVariable#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DataVariable#getExpression()
	 * @see #getDataVariable()
	 * @generated
	 */
	EReference getDataVariable_Expression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.bpmn.foxbpm.DataVariable#getDocumentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Documentation</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DataVariable#getDocumentation()
	 * @see #getDataVariable()
	 * @generated
	 */
	EReference getDataVariable_Documentation();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DataVariable#getBizType <em>Biz Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Biz Type</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DataVariable#getBizType()
	 * @see #getDataVariable()
	 * @generated
	 */
	EAttribute getDataVariable_BizType();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DataVariable#getFieldName <em>Field Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field Name</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DataVariable#getFieldName()
	 * @see #getDataVariable()
	 * @generated
	 */
	EAttribute getDataVariable_FieldName();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.Documentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Documentation</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.Documentation
	 * @generated
	 */
	EClass getDocumentation();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.Documentation#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.Documentation#getValue()
	 * @see #getDocumentation()
	 * @generated
	 */
	EAttribute getDocumentation_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.Documentation#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.Documentation#getId()
	 * @see #getDocumentation()
	 * @generated
	 */
	EAttribute getDocumentation_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.Documentation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.Documentation#getName()
	 * @see #getDocumentation()
	 * @generated
	 */
	EAttribute getDocumentation_Name();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance <em>Connector Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector Instance</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorInstance
	 * @generated
	 */
	EClass getConnectorInstance();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getConnectorId <em>Connector Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connector Id</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getConnectorId()
	 * @see #getConnectorInstance()
	 * @generated
	 */
	EAttribute getConnectorInstance_ConnectorId();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getPackageName <em>Package Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package Name</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getPackageName()
	 * @see #getConnectorInstance()
	 * @generated
	 */
	EAttribute getConnectorInstance_PackageName();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getClassName()
	 * @see #getConnectorInstance()
	 * @generated
	 */
	EAttribute getConnectorInstance_ClassName();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getConnectorInstanceId <em>Connector Instance Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connector Instance Id</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getConnectorInstanceId()
	 * @see #getConnectorInstance()
	 * @generated
	 */
	EAttribute getConnectorInstance_ConnectorInstanceId();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getConnectorInstanceName <em>Connector Instance Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connector Instance Name</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getConnectorInstanceName()
	 * @see #getConnectorInstance()
	 * @generated
	 */
	EAttribute getConnectorInstance_ConnectorInstanceName();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getEventType <em>Event Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event Type</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getEventType()
	 * @see #getConnectorInstance()
	 * @generated
	 */
	EAttribute getConnectorInstance_EventType();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getDocumentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Documentation</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getDocumentation()
	 * @see #getConnectorInstance()
	 * @generated
	 */
	EReference getConnectorInstance_Documentation();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getErrorHandling <em>Error Handling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Error Handling</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getErrorHandling()
	 * @see #getConnectorInstance()
	 * @generated
	 */
	EAttribute getConnectorInstance_ErrorHandling();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getErrorCode <em>Error Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Error Code</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getErrorCode()
	 * @see #getConnectorInstance()
	 * @generated
	 */
	EAttribute getConnectorInstance_ErrorCode();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getConnectorParameterInputs <em>Connector Parameter Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connector Parameter Inputs</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getConnectorParameterInputs()
	 * @see #getConnectorInstance()
	 * @generated
	 */
	EReference getConnectorInstance_ConnectorParameterInputs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getConnectorParameterOutputs <em>Connector Parameter Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connector Parameter Outputs</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getConnectorParameterOutputs()
	 * @see #getConnectorInstance()
	 * @generated
	 */
	EReference getConnectorInstance_ConnectorParameterOutputs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getConnectorParameterOutputsDef <em>Connector Parameter Outputs Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connector Parameter Outputs Def</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getConnectorParameterOutputsDef()
	 * @see #getConnectorInstance()
	 * @generated
	 */
	EReference getConnectorInstance_ConnectorParameterOutputsDef();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getSkipComment <em>Skip Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Skip Comment</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getSkipComment()
	 * @see #getConnectorInstance()
	 * @generated
	 */
	EReference getConnectorInstance_SkipComment();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getTimeExpression <em>Time Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Time Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getTimeExpression()
	 * @see #getConnectorInstance()
	 * @generated
	 */
	EReference getConnectorInstance_TimeExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#isIsTimeExecute <em>Is Time Execute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Time Execute</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#isIsTimeExecute()
	 * @see #getConnectorInstance()
	 * @generated
	 */
	EAttribute getConnectorInstance_IsTimeExecute();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getTimeSkipExpression <em>Time Skip Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Time Skip Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getTimeSkipExpression()
	 * @see #getConnectorInstance()
	 * @generated
	 */
	EReference getConnectorInstance_TimeSkipExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getVersion()
	 * @see #getConnectorInstance()
	 * @generated
	 */
	EAttribute getConnectorInstance_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorInstance#getType()
	 * @see #getConnectorInstance()
	 * @generated
	 */
	EAttribute getConnectorInstance_Type();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorParameterInput <em>Connector Parameter Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector Parameter Input</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorParameterInput
	 * @generated
	 */
	EClass getConnectorParameterInput();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorParameterInput#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorParameterInput#getId()
	 * @see #getConnectorParameterInput()
	 * @generated
	 */
	EAttribute getConnectorParameterInput_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorParameterInput#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorParameterInput#getName()
	 * @see #getConnectorParameterInput()
	 * @generated
	 */
	EAttribute getConnectorParameterInput_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorParameterInput#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Type</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorParameterInput#getDataType()
	 * @see #getConnectorParameterInput()
	 * @generated
	 */
	EAttribute getConnectorParameterInput_DataType();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorParameterInput#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorParameterInput#getExpression()
	 * @see #getConnectorParameterInput()
	 * @generated
	 */
	EReference getConnectorParameterInput_Expression();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorParameterInput#getIsExecute <em>Is Execute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Execute</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorParameterInput#getIsExecute()
	 * @see #getConnectorParameterInput()
	 * @generated
	 */
	EAttribute getConnectorParameterInput_IsExecute();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutput <em>Connector Parameter Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector Parameter Output</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutput
	 * @generated
	 */
	EClass getConnectorParameterOutput();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutput#getVariableTarget <em>Variable Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable Target</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutput#getVariableTarget()
	 * @see #getConnectorParameterOutput()
	 * @generated
	 */
	EAttribute getConnectorParameterOutput_VariableTarget();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutput#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutput#getExpression()
	 * @see #getConnectorParameterOutput()
	 * @generated
	 */
	EReference getConnectorParameterOutput_Expression();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutput#getOutputId <em>Output Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output Id</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutput#getOutputId()
	 * @see #getConnectorParameterOutput()
	 * @generated
	 */
	EAttribute getConnectorParameterOutput_OutputId();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.LoopDataInputCollection <em>Loop Data Input Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Data Input Collection</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.LoopDataInputCollection
	 * @generated
	 */
	EClass getLoopDataInputCollection();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.LoopDataInputCollection#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.LoopDataInputCollection#getExpression()
	 * @see #getLoopDataInputCollection()
	 * @generated
	 */
	EReference getLoopDataInputCollection_Expression();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.LoopDataOutputCollection <em>Loop Data Output Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Data Output Collection</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.LoopDataOutputCollection
	 * @generated
	 */
	EClass getLoopDataOutputCollection();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.LoopDataOutputCollection#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.LoopDataOutputCollection#getExpression()
	 * @see #getLoopDataOutputCollection()
	 * @generated
	 */
	EReference getLoopDataOutputCollection_Expression();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutputDef <em>Connector Parameter Output Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector Parameter Output Def</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutputDef
	 * @generated
	 */
	EClass getConnectorParameterOutputDef();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutputDef#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutputDef#getId()
	 * @see #getConnectorParameterOutputDef()
	 * @generated
	 */
	EAttribute getConnectorParameterOutputDef_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutputDef#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutputDef#getName()
	 * @see #getConnectorParameterOutputDef()
	 * @generated
	 */
	EAttribute getConnectorParameterOutputDef_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutputDef#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Type</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutputDef#getDataType()
	 * @see #getConnectorParameterOutputDef()
	 * @generated
	 */
	EAttribute getConnectorParameterOutputDef_DataType();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.FormUri <em>Form Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Form Uri</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.FormUri
	 * @generated
	 */
	EClass getFormUri();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.FormUri#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.FormUri#getExpression()
	 * @see #getFormUri()
	 * @generated
	 */
	EReference getFormUri_Expression();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.LoopMaximum <em>Loop Maximum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Maximum</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.LoopMaximum
	 * @generated
	 */
	EClass getLoopMaximum();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.LoopMaximum#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.LoopMaximum#getExpression()
	 * @see #getLoopMaximum()
	 * @generated
	 */
	EReference getLoopMaximum_Expression();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.SkipStrategy <em>Skip Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Skip Strategy</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.SkipStrategy
	 * @generated
	 */
	EClass getSkipStrategy();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.SkipStrategy#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.SkipStrategy#getExpression()
	 * @see #getSkipStrategy()
	 * @generated
	 */
	EReference getSkipStrategy_Expression();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.SkipStrategy#isIsCreateSkipProcess <em>Is Create Skip Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Create Skip Process</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.SkipStrategy#isIsCreateSkipProcess()
	 * @see #getSkipStrategy()
	 * @generated
	 */
	EAttribute getSkipStrategy_IsCreateSkipProcess();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.SkipStrategy#getSkipAssignee <em>Skip Assignee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Skip Assignee</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.SkipStrategy#getSkipAssignee()
	 * @see #getSkipStrategy()
	 * @generated
	 */
	EReference getSkipStrategy_SkipAssignee();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.SkipStrategy#getSkipComment <em>Skip Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Skip Comment</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.SkipStrategy#getSkipComment()
	 * @see #getSkipStrategy()
	 * @generated
	 */
	EReference getSkipStrategy_SkipComment();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.SkipStrategy#isIsEnable <em>Is Enable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Enable</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.SkipStrategy#isIsEnable()
	 * @see #getSkipStrategy()
	 * @generated
	 */
	EAttribute getSkipStrategy_IsEnable();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.MessageObj <em>Message Obj</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message Obj</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.MessageObj
	 * @generated
	 */
	EClass getMessageObj();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.MessageObj#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.MessageObj#getId()
	 * @see #getMessageObj()
	 * @generated
	 */
	EAttribute getMessageObj_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.MessageObj#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.MessageObj#getName()
	 * @see #getMessageObj()
	 * @generated
	 */
	EAttribute getMessageObj_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.MessageObj#getDocumentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Documentation</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.MessageObj#getDocumentation()
	 * @see #getMessageObj()
	 * @generated
	 */
	EReference getMessageObj_Documentation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.bpmn.foxbpm.MessageObj#getDataVariable <em>Data Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Variable</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.MessageObj#getDataVariable()
	 * @see #getMessageObj()
	 * @generated
	 */
	EReference getMessageObj_DataVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.MessageObj#getTargetProcess <em>Target Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Process</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.MessageObj#getTargetProcess()
	 * @see #getMessageObj()
	 * @generated
	 */
	EAttribute getMessageObj_TargetProcess();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.MessageObj#getTargetNode <em>Target Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Node</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.MessageObj#getTargetNode()
	 * @see #getMessageObj()
	 * @generated
	 */
	EAttribute getMessageObj_TargetNode();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.MessageObj#getProcessInstanceVariable <em>Process Instance Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Process Instance Variable</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.MessageObj#getProcessInstanceVariable()
	 * @see #getMessageObj()
	 * @generated
	 */
	EReference getMessageObj_ProcessInstanceVariable();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.MessageObj#getTokenVariable <em>Token Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Token Variable</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.MessageObj#getTokenVariable()
	 * @see #getMessageObj()
	 * @generated
	 */
	EReference getMessageObj_TokenVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.MessageObj#getMessageType <em>Message Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message Type</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.MessageObj#getMessageType()
	 * @see #getMessageObj()
	 * @generated
	 */
	EAttribute getMessageObj_MessageType();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.FilterConditions <em>Filter Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Filter Conditions</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.FilterConditions
	 * @generated
	 */
	EClass getFilterConditions();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.FilterConditions#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.FilterConditions#getExpression()
	 * @see #getFilterConditions()
	 * @generated
	 */
	EReference getFilterConditions_Expression();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.ReceiveMessage <em>Receive Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Receive Message</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ReceiveMessage
	 * @generated
	 */
	EClass getReceiveMessage();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.ReceiveMessage#getMessageId <em>Message Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message Id</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ReceiveMessage#getMessageId()
	 * @see #getReceiveMessage()
	 * @generated
	 */
	EAttribute getReceiveMessage_MessageId();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.ReceiveMessage#getFilterConditions <em>Filter Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Filter Conditions</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ReceiveMessage#getFilterConditions()
	 * @see #getReceiveMessage()
	 * @generated
	 */
	EReference getReceiveMessage_FilterConditions();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.ReceiveMessage#getProcessInstanceVariable <em>Process Instance Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Process Instance Variable</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ReceiveMessage#getProcessInstanceVariable()
	 * @see #getReceiveMessage()
	 * @generated
	 */
	EReference getReceiveMessage_ProcessInstanceVariable();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.ReceiveMessage#getTokenVariable <em>Token Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Token Variable</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ReceiveMessage#getTokenVariable()
	 * @see #getReceiveMessage()
	 * @generated
	 */
	EReference getReceiveMessage_TokenVariable();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.TokenVariable <em>Token Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Token Variable</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.TokenVariable
	 * @generated
	 */
	EClass getTokenVariable();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.TokenVariable#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.TokenVariable#getExpression()
	 * @see #getTokenVariable()
	 * @generated
	 */
	EReference getTokenVariable_Expression();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.ProcessInstanceVariable <em>Process Instance Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process Instance Variable</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ProcessInstanceVariable
	 * @generated
	 */
	EClass getProcessInstanceVariable();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.ProcessInstanceVariable#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ProcessInstanceVariable#getExpression()
	 * @see #getProcessInstanceVariable()
	 * @generated
	 */
	EReference getProcessInstanceVariable_Expression();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.ExpectedExecutionTime <em>Expected Execution Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expected Execution Time</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ExpectedExecutionTime
	 * @generated
	 */
	EClass getExpectedExecutionTime();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.ExpectedExecutionTime#getDay <em>Day</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Day</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ExpectedExecutionTime#getDay()
	 * @see #getExpectedExecutionTime()
	 * @generated
	 */
	EAttribute getExpectedExecutionTime_Day();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.ExpectedExecutionTime#getHour <em>Hour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hour</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ExpectedExecutionTime#getHour()
	 * @see #getExpectedExecutionTime()
	 * @generated
	 */
	EAttribute getExpectedExecutionTime_Hour();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.ExpectedExecutionTime#getMinute <em>Minute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minute</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ExpectedExecutionTime#getMinute()
	 * @see #getExpectedExecutionTime()
	 * @generated
	 */
	EAttribute getExpectedExecutionTime_Minute();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.ExpectedExecutionTime#getSecond <em>Second</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Second</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ExpectedExecutionTime#getSecond()
	 * @see #getExpectedExecutionTime()
	 * @generated
	 */
	EAttribute getExpectedExecutionTime_Second();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.DataSourceToSubProcessMapping <em>Data Source To Sub Process Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Source To Sub Process Mapping</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DataSourceToSubProcessMapping
	 * @generated
	 */
	EClass getDataSourceToSubProcessMapping();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.bpmn.foxbpm.DataSourceToSubProcessMapping#getDataVariableMapping <em>Data Variable Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Variable Mapping</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DataSourceToSubProcessMapping#getDataVariableMapping()
	 * @see #getDataSourceToSubProcessMapping()
	 * @generated
	 */
	EReference getDataSourceToSubProcessMapping_DataVariableMapping();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.SubProcessToDataSourceMapping <em>Sub Process To Data Source Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Process To Data Source Mapping</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.SubProcessToDataSourceMapping
	 * @generated
	 */
	EClass getSubProcessToDataSourceMapping();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.bpmn.foxbpm.SubProcessToDataSourceMapping#getDataVariableMapping <em>Data Variable Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Variable Mapping</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.SubProcessToDataSourceMapping#getDataVariableMapping()
	 * @see #getSubProcessToDataSourceMapping()
	 * @generated
	 */
	EReference getSubProcessToDataSourceMapping_DataVariableMapping();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.DataVariableMapping <em>Data Variable Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Variable Mapping</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DataVariableMapping
	 * @generated
	 */
	EClass getDataVariableMapping();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DataVariableMapping#getDataSourceId <em>Data Source Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Source Id</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DataVariableMapping#getDataSourceId()
	 * @see #getDataVariableMapping()
	 * @generated
	 */
	EAttribute getDataVariableMapping_DataSourceId();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.DataVariableMapping#getSubProcesId <em>Sub Proces Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sub Proces Id</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.DataVariableMapping#getSubProcesId()
	 * @see #getDataVariableMapping()
	 * @generated
	 */
	EAttribute getDataVariableMapping_SubProcesId();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.FormUriView <em>Form Uri View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Form Uri View</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.FormUriView
	 * @generated
	 */
	EClass getFormUriView();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.FormUriView#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.FormUriView#getExpression()
	 * @see #getFormUriView()
	 * @generated
	 */
	EReference getFormUriView_Expression();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.TaskPriority <em>Task Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task Priority</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.TaskPriority
	 * @generated
	 */
	EClass getTaskPriority();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.TaskPriority#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.TaskPriority#getExpression()
	 * @see #getTaskPriority()
	 * @generated
	 */
	EReference getTaskPriority_Expression();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.AssignPolicyType <em>Assign Policy Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assign Policy Type</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.AssignPolicyType
	 * @generated
	 */
	EClass getAssignPolicyType();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.AssignPolicyType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.AssignPolicyType#getId()
	 * @see #getAssignPolicyType()
	 * @generated
	 */
	EAttribute getAssignPolicyType_Id();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.AssignPolicyType#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.AssignPolicyType#getExpression()
	 * @see #getAssignPolicyType()
	 * @generated
	 */
	EReference getAssignPolicyType_Expression();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.SkipAssignee <em>Skip Assignee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Skip Assignee</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.SkipAssignee
	 * @generated
	 */
	EClass getSkipAssignee();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.SkipAssignee#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.SkipAssignee#getExpression()
	 * @see #getSkipAssignee()
	 * @generated
	 */
	EReference getSkipAssignee_Expression();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.SkipComment <em>Skip Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Skip Comment</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.SkipComment
	 * @generated
	 */
	EClass getSkipComment();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.SkipComment#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.SkipComment#getExpression()
	 * @see #getSkipComment()
	 * @generated
	 */
	EReference getSkipComment_Expression();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstanceElements <em>Connector Instance Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector Instance Elements</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorInstanceElements
	 * @generated
	 */
	EClass getConnectorInstanceElements();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstanceElements#getConnrctorType <em>Connrctor Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connrctor Type</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorInstanceElements#getConnrctorType()
	 * @see #getConnectorInstanceElements()
	 * @generated
	 */
	EAttribute getConnectorInstanceElements_ConnrctorType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorInstanceElements#getConnectorInstance <em>Connector Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connector Instance</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ConnectorInstanceElements#getConnectorInstance()
	 * @see #getConnectorInstanceElements()
	 * @generated
	 */
	EReference getConnectorInstanceElements_ConnectorInstance();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.TimeExpression <em>Time Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.TimeExpression
	 * @generated
	 */
	EClass getTimeExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.TimeExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.TimeExpression#getExpression()
	 * @see #getTimeExpression()
	 * @generated
	 */
	EReference getTimeExpression_Expression();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.TimeSkipExpression <em>Time Skip Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Skip Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.TimeSkipExpression
	 * @generated
	 */
	EClass getTimeSkipExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.TimeSkipExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.TimeSkipExpression#getExpression()
	 * @see #getTimeSkipExpression()
	 * @generated
	 */
	EReference getTimeSkipExpression_Expression();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.TableExpression <em>Table Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.TableExpression
	 * @generated
	 */
	EClass getTableExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.bpmn.foxbpm.TableExpression#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expressions</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.TableExpression#getExpressions()
	 * @see #getTableExpression()
	 * @generated
	 */
	EReference getTableExpression_Expressions();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.ListExpression <em>List Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ListExpression
	 * @generated
	 */
	EClass getListExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.bpmn.foxbpm.ListExpression#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expressions</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ListExpression#getExpressions()
	 * @see #getListExpression()
	 * @generated
	 */
	EReference getListExpression_Expressions();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.TaskDescription <em>Task Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task Description</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.TaskDescription
	 * @generated
	 */
	EClass getTaskDescription();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.TaskDescription#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.TaskDescription#getExpression()
	 * @see #getTaskDescription()
	 * @generated
	 */
	EReference getTaskDescription_Expression();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.CompleteTaskDescription <em>Complete Task Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complete Task Description</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.CompleteTaskDescription
	 * @generated
	 */
	EClass getCompleteTaskDescription();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.CompleteTaskDescription#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.CompleteTaskDescription#getExpression()
	 * @see #getCompleteTaskDescription()
	 * @generated
	 */
	EReference getCompleteTaskDescription_Expression();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.FormParamContainer <em>Form Param Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Form Param Container</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.FormParamContainer
	 * @generated
	 */
	EClass getFormParamContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.bpmn.foxbpm.FormParamContainer#getFormParam <em>Form Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Form Param</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.FormParamContainer#getFormParam()
	 * @see #getFormParamContainer()
	 * @generated
	 */
	EReference getFormParamContainer_FormParam();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.FormParam <em>Form Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Form Param</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.FormParam
	 * @generated
	 */
	EClass getFormParam();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.FormParam#getParamKey <em>Param Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Param Key</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.FormParam#getParamKey()
	 * @see #getFormParam()
	 * @generated
	 */
	EAttribute getFormParam_ParamKey();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.FormParam#getParamType <em>Param Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Param Type</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.FormParam#getParamType()
	 * @see #getFormParam()
	 * @generated
	 */
	EAttribute getFormParam_ParamType();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.FormParam#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.FormParam#getExpression()
	 * @see #getFormParam()
	 * @generated
	 */
	EReference getFormParam_Expression();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.BaseConfig <em>Base Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Config</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.BaseConfig
	 * @generated
	 */
	EClass getBaseConfig();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.bpmn.foxbpm.BaseConfig#getParams <em>Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Params</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.BaseConfig#getParams()
	 * @see #getBaseConfig()
	 * @generated
	 */
	EReference getBaseConfig_Params();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.BaseConfig#getDocumentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Documentation</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.BaseConfig#getDocumentation()
	 * @see #getBaseConfig()
	 * @generated
	 */
	EReference getBaseConfig_Documentation();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.Param <em>Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Param</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.Param
	 * @generated
	 */
	EClass getParam();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.Param#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.Param#getKey()
	 * @see #getParam()
	 * @generated
	 */
	EAttribute getParam_Key();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.Param#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.Param#getName()
	 * @see #getParam()
	 * @generated
	 */
	EAttribute getParam_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.Param#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.Param#getExpression()
	 * @see #getParam()
	 * @generated
	 */
	EReference getParam_Expression();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.PotentialStarter <em>Potential Starter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Potential Starter</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.PotentialStarter
	 * @generated
	 */
	EClass getPotentialStarter();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.bpmn.foxbpm.PotentialStarter#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.PotentialStarter#getExpression()
	 * @see #getPotentialStarter()
	 * @generated
	 */
	EReference getPotentialStarter_Expression();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.PotentialStarter#getResourceType <em>Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource Type</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.PotentialStarter#getResourceType()
	 * @see #getPotentialStarter()
	 * @generated
	 */
	EAttribute getPotentialStarter_ResourceType();

	/**
	 * Returns the meta object for the reference '{@link org.foxbpm.model.bpmn.foxbpm.PotentialStarter#getEReference0 <em>EReference0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EReference0</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.PotentialStarter#getEReference0()
	 * @see #getPotentialStarter()
	 * @generated
	 */
	EReference getPotentialStarter_EReference0();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.PotentialStarter#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.PotentialStarter#getDescription()
	 * @see #getPotentialStarter()
	 * @generated
	 */
	EAttribute getPotentialStarter_Description();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.PotentialOwner <em>Potential Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Potential Owner</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.PotentialOwner
	 * @generated
	 */
	EClass getPotentialOwner();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.bpmn.foxbpm.PotentialOwner#getConnectorInstanceElements <em>Connector Instance Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connector Instance Elements</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.PotentialOwner#getConnectorInstanceElements()
	 * @see #getPotentialOwner()
	 * @generated
	 */
	EReference getPotentialOwner_ConnectorInstanceElements();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.bpmn.foxbpm.CommandParam <em>Command Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Command Param</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.CommandParam
	 * @generated
	 */
	EClass getCommandParam();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.CommandParam#getBizType <em>Biz Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Biz Type</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.CommandParam#getBizType()
	 * @see #getCommandParam()
	 * @generated
	 */
	EAttribute getCommandParam_BizType();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.bpmn.foxbpm.CommandParam#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Type</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.CommandParam#getDataType()
	 * @see #getCommandParam()
	 * @generated
	 */
	EAttribute getCommandParam_DataType();

	/**
	 * Returns the meta object for enum '{@link org.foxbpm.model.bpmn.foxbpm.ProcessValidationLevel <em>Process Validation Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Process Validation Level</em>'.
	 * @see org.foxbpm.model.bpmn.foxbpm.ProcessValidationLevel
	 * @generated
	 */
	EEnum getProcessValidationLevel();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FoxBPMFactory getFoxBPMFactory();

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
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.DocumentRootImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getDocumentRoot()
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
		 * The meta object literal for the '<em><b>Task Subject</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__TASK_SUBJECT = eINSTANCE.getDocumentRoot_TaskSubject();

		/**
		 * The meta object literal for the '<em><b>Task Command</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__TASK_COMMAND = eINSTANCE.getDocumentRoot_TaskCommand();

		/**
		 * The meta object literal for the '<em><b>Resource Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__RESOURCE_TYPE = eINSTANCE.getDocumentRoot_ResourceType();

		/**
		 * The meta object literal for the '<em><b>Resource Filter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__RESOURCE_FILTER = eINSTANCE.getDocumentRoot_ResourceFilter();

		/**
		 * The meta object literal for the '<em><b>Data Variable</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__DATA_VARIABLE = eINSTANCE.getDocumentRoot_DataVariable();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__VERSION = eINSTANCE.getDocumentRoot_Version();

		/**
		 * The meta object literal for the '<em><b>Dbid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__DBID = eINSTANCE.getDocumentRoot_Dbid();

		/**
		 * The meta object literal for the '<em><b>Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__CATEGORY = eINSTANCE.getDocumentRoot_Category();

		/**
		 * The meta object literal for the '<em><b>Connector Instance</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__CONNECTOR_INSTANCE = eINSTANCE.getDocumentRoot_ConnectorInstance();

		/**
		 * The meta object literal for the '<em><b>Loop Data Input Collection</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__LOOP_DATA_INPUT_COLLECTION = eINSTANCE.getDocumentRoot_LoopDataInputCollection();

		/**
		 * The meta object literal for the '<em><b>Loop Data Output Collection</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__LOOP_DATA_OUTPUT_COLLECTION = eINSTANCE.getDocumentRoot_LoopDataOutputCollection();

		/**
		 * The meta object literal for the '<em><b>Form Uri</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__FORM_URI = eINSTANCE.getDocumentRoot_FormUri();

		/**
		 * The meta object literal for the '<em><b>Loop Maximum</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__LOOP_MAXIMUM = eINSTANCE.getDocumentRoot_LoopMaximum();

		/**
		 * The meta object literal for the '<em><b>Sub Task</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__SUB_TASK = eINSTANCE.getDocumentRoot_SubTask();

		/**
		 * The meta object literal for the '<em><b>Script Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__SCRIPT_NAME = eINSTANCE.getDocumentRoot_ScriptName();

		/**
		 * The meta object literal for the '<em><b>Result Variable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__RESULT_VARIABLE = eINSTANCE.getDocumentRoot_ResultVariable();

		/**
		 * The meta object literal for the '<em><b>Callable Element Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__CALLABLE_ELEMENT_ID = eINSTANCE.getDocumentRoot_CallableElementId();

		/**
		 * The meta object literal for the '<em><b>Callable Element Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__CALLABLE_ELEMENT_NAME = eINSTANCE.getDocumentRoot_CallableElementName();

		/**
		 * The meta object literal for the '<em><b>Callable Element Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__CALLABLE_ELEMENT_VERSION = eINSTANCE.getDocumentRoot_CallableElementVersion();

		/**
		 * The meta object literal for the '<em><b>Callable Element Version Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__CALLABLE_ELEMENT_VERSION_NAME = eINSTANCE.getDocumentRoot_CallableElementVersionName();

		/**
		 * The meta object literal for the '<em><b>Include Exclusion</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__INCLUDE_EXCLUSION = eINSTANCE.getDocumentRoot_IncludeExclusion();

		/**
		 * The meta object literal for the '<em><b>Resource Range</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__RESOURCE_RANGE = eINSTANCE.getDocumentRoot_ResourceRange();

		/**
		 * The meta object literal for the '<em><b>Assign Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__ASSIGN_ACTION = eINSTANCE.getDocumentRoot_AssignAction();

		/**
		 * The meta object literal for the '<em><b>Error Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__ERROR_CODE = eINSTANCE.getDocumentRoot_ErrorCode();

		/**
		 * The meta object literal for the '<em><b>Skip Strategy</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SKIP_STRATEGY = eINSTANCE.getDocumentRoot_SkipStrategy();

		/**
		 * The meta object literal for the '<em><b>Is Contains Sub</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__IS_CONTAINS_SUB = eINSTANCE.getDocumentRoot_IsContainsSub();

		/**
		 * The meta object literal for the '<em><b>Verification</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__VERIFICATION = eINSTANCE.getDocumentRoot_Verification();

		/**
		 * The meta object literal for the '<em><b>Message Obj</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__MESSAGE_OBJ = eINSTANCE.getDocumentRoot_MessageObj();

		/**
		 * The meta object literal for the '<em><b>Receive Message</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__RECEIVE_MESSAGE = eINSTANCE.getDocumentRoot_ReceiveMessage();

		/**
		 * The meta object literal for the '<em><b>Expected Execution Time</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__EXPECTED_EXECUTION_TIME = eINSTANCE.getDocumentRoot_ExpectedExecutionTime();

		/**
		 * The meta object literal for the '<em><b>Data Source To Sub Process Mapping</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__DATA_SOURCE_TO_SUB_PROCESS_MAPPING = eINSTANCE.getDocumentRoot_DataSourceToSubProcessMapping();

		/**
		 * The meta object literal for the '<em><b>Sub Process To Data Source Mapping</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SUB_PROCESS_TO_DATA_SOURCE_MAPPING = eINSTANCE.getDocumentRoot_SubProcessToDataSourceMapping();

		/**
		 * The meta object literal for the '<em><b>Callable Element Biz Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__CALLABLE_ELEMENT_BIZ_KEY = eINSTANCE.getDocumentRoot_CallableElementBizKey();

		/**
		 * The meta object literal for the '<em><b>Callable Element Biz Key Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__CALLABLE_ELEMENT_BIZ_KEY_NAME = eINSTANCE.getDocumentRoot_CallableElementBizKeyName();

		/**
		 * The meta object literal for the '<em><b>Is Async</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__IS_ASYNC = eINSTANCE.getDocumentRoot_IsAsync();

		/**
		 * The meta object literal for the '<em><b>Form Uri View</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__FORM_URI_VIEW = eINSTANCE.getDocumentRoot_FormUriView();

		/**
		 * The meta object literal for the '<em><b>Order Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__ORDER_ID = eINSTANCE.getDocumentRoot_OrderId();

		/**
		 * The meta object literal for the '<em><b>Task Priority</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__TASK_PRIORITY = eINSTANCE.getDocumentRoot_TaskPriority();

		/**
		 * The meta object literal for the '<em><b>Assign Policy Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__ASSIGN_POLICY_TYPE = eINSTANCE.getDocumentRoot_AssignPolicyType();

		/**
		 * The meta object literal for the '<em><b>Is Persistence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__IS_PERSISTENCE = eINSTANCE.getDocumentRoot_IsPersistence();

		/**
		 * The meta object literal for the '<em><b>Task Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__TASK_TYPE = eINSTANCE.getDocumentRoot_TaskType();

		/**
		 * The meta object literal for the '<em><b>Validation Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__VALIDATION_LEVEL = eINSTANCE.getDocumentRoot_ValidationLevel();

		/**
		 * The meta object literal for the '<em><b>Language Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__LANGUAGE_TYPE = eINSTANCE.getDocumentRoot_LanguageType();

		/**
		 * The meta object literal for the '<em><b>Connector Instance Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__CONNECTOR_INSTANCE_ELEMENTS = eINSTANCE.getDocumentRoot_ConnectorInstanceElements();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__NAME = eINSTANCE.getDocumentRoot_Name();

		/**
		 * The meta object literal for the '<em><b>Is Create Record</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__IS_CREATE_RECORD = eINSTANCE.getDocumentRoot_IsCreateRecord();

		/**
		 * The meta object literal for the '<em><b>Claim Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__CLAIM_TYPE = eINSTANCE.getDocumentRoot_ClaimType();

		/**
		 * The meta object literal for the '<em><b>Task Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__TASK_DESCRIPTION = eINSTANCE.getDocumentRoot_TaskDescription();

		/**
		 * The meta object literal for the '<em><b>Complete Task Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__COMPLETE_TASK_DESCRIPTION = eINSTANCE.getDocumentRoot_CompleteTaskDescription();

		/**
		 * The meta object literal for the '<em><b>Form Param Container</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__FORM_PARAM_CONTAINER = eINSTANCE.getDocumentRoot_FormParamContainer();

		/**
		 * The meta object literal for the '<em><b>Converg Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__CONVERG_TYPE = eINSTANCE.getDocumentRoot_ConvergType();

		/**
		 * The meta object literal for the '<em><b>Potential Starter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__POTENTIAL_STARTER = eINSTANCE.getDocumentRoot_PotentialStarter();

		/**
		 * The meta object literal for the '<em><b>Potential Owner</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__POTENTIAL_OWNER = eINSTANCE.getDocumentRoot_PotentialOwner();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.ExpressionImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION__VALUE = eINSTANCE.getExpression_Value();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION__ID = eINSTANCE.getExpression_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION__NAME = eINSTANCE.getExpression_Name();

		/**
		 * The meta object literal for the '<em><b>Is Run</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION__IS_RUN = eINSTANCE.getExpression_IsRun();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION__MIXED = eINSTANCE.getExpression_Mixed();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.TaskSubjectImpl <em>Task Subject</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.TaskSubjectImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getTaskSubject()
		 * @generated
		 */
		EClass TASK_SUBJECT = eINSTANCE.getTaskSubject();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_SUBJECT__EXPRESSION = eINSTANCE.getTaskSubject_Expression();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_SUBJECT__ID = eINSTANCE.getTaskSubject_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_SUBJECT__NAME = eINSTANCE.getTaskSubject_Name();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.TaskCommandImpl <em>Task Command</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.TaskCommandImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getTaskCommand()
		 * @generated
		 */
		EClass TASK_COMMAND = eINSTANCE.getTaskCommand();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_COMMAND__ID = eINSTANCE.getTaskCommand_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_COMMAND__NAME = eINSTANCE.getTaskCommand_Name();

		/**
		 * The meta object literal for the '<em><b>Command Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_COMMAND__COMMAND_TYPE = eINSTANCE.getTaskCommand_CommandType();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_COMMAND__EXPRESSION = eINSTANCE.getTaskCommand_Expression();

		/**
		 * The meta object literal for the '<em><b>Order Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_COMMAND__ORDER_ID = eINSTANCE.getTaskCommand_OrderId();

		/**
		 * The meta object literal for the '<em><b>Parameter Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_COMMAND__PARAMETER_EXPRESSION = eINSTANCE.getTaskCommand_ParameterExpression();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.ResourceFilterImpl <em>Resource Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.ResourceFilterImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getResourceFilter()
		 * @generated
		 */
		EClass RESOURCE_FILTER = eINSTANCE.getResourceFilter();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_FILTER__ID = eINSTANCE.getResourceFilter_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_FILTER__NAME = eINSTANCE.getResourceFilter_Name();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_FILTER__EXPRESSION = eINSTANCE.getResourceFilter_Expression();

		/**
		 * The meta object literal for the '<em><b>Documentation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_FILTER__DOCUMENTATION = eINSTANCE.getResourceFilter_Documentation();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.DataVariableImpl <em>Data Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.DataVariableImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getDataVariable()
		 * @generated
		 */
		EClass DATA_VARIABLE = eINSTANCE.getDataVariable();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_VARIABLE__ID = eINSTANCE.getDataVariable_Id();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_VARIABLE__DATA_TYPE = eINSTANCE.getDataVariable_DataType();

		/**
		 * The meta object literal for the '<em><b>Is List</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_VARIABLE__IS_LIST = eINSTANCE.getDataVariable_IsList();

		/**
		 * The meta object literal for the '<em><b>Is Persistence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_VARIABLE__IS_PERSISTENCE = eINSTANCE.getDataVariable_IsPersistence();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_VARIABLE__EXPRESSION = eINSTANCE.getDataVariable_Expression();

		/**
		 * The meta object literal for the '<em><b>Documentation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_VARIABLE__DOCUMENTATION = eINSTANCE.getDataVariable_Documentation();

		/**
		 * The meta object literal for the '<em><b>Biz Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_VARIABLE__BIZ_TYPE = eINSTANCE.getDataVariable_BizType();

		/**
		 * The meta object literal for the '<em><b>Field Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_VARIABLE__FIELD_NAME = eINSTANCE.getDataVariable_FieldName();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.DocumentationImpl <em>Documentation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.DocumentationImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getDocumentation()
		 * @generated
		 */
		EClass DOCUMENTATION = eINSTANCE.getDocumentation();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENTATION__VALUE = eINSTANCE.getDocumentation_Value();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENTATION__ID = eINSTANCE.getDocumentation_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENTATION__NAME = eINSTANCE.getDocumentation_Name();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorInstanceImpl <em>Connector Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.ConnectorInstanceImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getConnectorInstance()
		 * @generated
		 */
		EClass CONNECTOR_INSTANCE = eINSTANCE.getConnectorInstance();

		/**
		 * The meta object literal for the '<em><b>Connector Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR_INSTANCE__CONNECTOR_ID = eINSTANCE.getConnectorInstance_ConnectorId();

		/**
		 * The meta object literal for the '<em><b>Package Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR_INSTANCE__PACKAGE_NAME = eINSTANCE.getConnectorInstance_PackageName();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR_INSTANCE__CLASS_NAME = eINSTANCE.getConnectorInstance_ClassName();

		/**
		 * The meta object literal for the '<em><b>Connector Instance Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR_INSTANCE__CONNECTOR_INSTANCE_ID = eINSTANCE.getConnectorInstance_ConnectorInstanceId();

		/**
		 * The meta object literal for the '<em><b>Connector Instance Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR_INSTANCE__CONNECTOR_INSTANCE_NAME = eINSTANCE.getConnectorInstance_ConnectorInstanceName();

		/**
		 * The meta object literal for the '<em><b>Event Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR_INSTANCE__EVENT_TYPE = eINSTANCE.getConnectorInstance_EventType();

		/**
		 * The meta object literal for the '<em><b>Documentation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR_INSTANCE__DOCUMENTATION = eINSTANCE.getConnectorInstance_Documentation();

		/**
		 * The meta object literal for the '<em><b>Error Handling</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR_INSTANCE__ERROR_HANDLING = eINSTANCE.getConnectorInstance_ErrorHandling();

		/**
		 * The meta object literal for the '<em><b>Error Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR_INSTANCE__ERROR_CODE = eINSTANCE.getConnectorInstance_ErrorCode();

		/**
		 * The meta object literal for the '<em><b>Connector Parameter Inputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR_INSTANCE__CONNECTOR_PARAMETER_INPUTS = eINSTANCE.getConnectorInstance_ConnectorParameterInputs();

		/**
		 * The meta object literal for the '<em><b>Connector Parameter Outputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR_INSTANCE__CONNECTOR_PARAMETER_OUTPUTS = eINSTANCE.getConnectorInstance_ConnectorParameterOutputs();

		/**
		 * The meta object literal for the '<em><b>Connector Parameter Outputs Def</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR_INSTANCE__CONNECTOR_PARAMETER_OUTPUTS_DEF = eINSTANCE.getConnectorInstance_ConnectorParameterOutputsDef();

		/**
		 * The meta object literal for the '<em><b>Skip Comment</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR_INSTANCE__SKIP_COMMENT = eINSTANCE.getConnectorInstance_SkipComment();

		/**
		 * The meta object literal for the '<em><b>Time Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR_INSTANCE__TIME_EXPRESSION = eINSTANCE.getConnectorInstance_TimeExpression();

		/**
		 * The meta object literal for the '<em><b>Is Time Execute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR_INSTANCE__IS_TIME_EXECUTE = eINSTANCE.getConnectorInstance_IsTimeExecute();

		/**
		 * The meta object literal for the '<em><b>Time Skip Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR_INSTANCE__TIME_SKIP_EXPRESSION = eINSTANCE.getConnectorInstance_TimeSkipExpression();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR_INSTANCE__VERSION = eINSTANCE.getConnectorInstance_Version();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR_INSTANCE__TYPE = eINSTANCE.getConnectorInstance_Type();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorParameterInputImpl <em>Connector Parameter Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.ConnectorParameterInputImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getConnectorParameterInput()
		 * @generated
		 */
		EClass CONNECTOR_PARAMETER_INPUT = eINSTANCE.getConnectorParameterInput();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR_PARAMETER_INPUT__ID = eINSTANCE.getConnectorParameterInput_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR_PARAMETER_INPUT__NAME = eINSTANCE.getConnectorParameterInput_Name();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR_PARAMETER_INPUT__DATA_TYPE = eINSTANCE.getConnectorParameterInput_DataType();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR_PARAMETER_INPUT__EXPRESSION = eINSTANCE.getConnectorParameterInput_Expression();

		/**
		 * The meta object literal for the '<em><b>Is Execute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR_PARAMETER_INPUT__IS_EXECUTE = eINSTANCE.getConnectorParameterInput_IsExecute();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorParameterOutputImpl <em>Connector Parameter Output</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.ConnectorParameterOutputImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getConnectorParameterOutput()
		 * @generated
		 */
		EClass CONNECTOR_PARAMETER_OUTPUT = eINSTANCE.getConnectorParameterOutput();

		/**
		 * The meta object literal for the '<em><b>Variable Target</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR_PARAMETER_OUTPUT__VARIABLE_TARGET = eINSTANCE.getConnectorParameterOutput_VariableTarget();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR_PARAMETER_OUTPUT__EXPRESSION = eINSTANCE.getConnectorParameterOutput_Expression();

		/**
		 * The meta object literal for the '<em><b>Output Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR_PARAMETER_OUTPUT__OUTPUT_ID = eINSTANCE.getConnectorParameterOutput_OutputId();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.LoopDataInputCollectionImpl <em>Loop Data Input Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.LoopDataInputCollectionImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getLoopDataInputCollection()
		 * @generated
		 */
		EClass LOOP_DATA_INPUT_COLLECTION = eINSTANCE.getLoopDataInputCollection();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_DATA_INPUT_COLLECTION__EXPRESSION = eINSTANCE.getLoopDataInputCollection_Expression();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.LoopDataOutputCollectionImpl <em>Loop Data Output Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.LoopDataOutputCollectionImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getLoopDataOutputCollection()
		 * @generated
		 */
		EClass LOOP_DATA_OUTPUT_COLLECTION = eINSTANCE.getLoopDataOutputCollection();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_DATA_OUTPUT_COLLECTION__EXPRESSION = eINSTANCE.getLoopDataOutputCollection_Expression();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorParameterOutputDefImpl <em>Connector Parameter Output Def</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.ConnectorParameterOutputDefImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getConnectorParameterOutputDef()
		 * @generated
		 */
		EClass CONNECTOR_PARAMETER_OUTPUT_DEF = eINSTANCE.getConnectorParameterOutputDef();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR_PARAMETER_OUTPUT_DEF__ID = eINSTANCE.getConnectorParameterOutputDef_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR_PARAMETER_OUTPUT_DEF__NAME = eINSTANCE.getConnectorParameterOutputDef_Name();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR_PARAMETER_OUTPUT_DEF__DATA_TYPE = eINSTANCE.getConnectorParameterOutputDef_DataType();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.FormUriImpl <em>Form Uri</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FormUriImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getFormUri()
		 * @generated
		 */
		EClass FORM_URI = eINSTANCE.getFormUri();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORM_URI__EXPRESSION = eINSTANCE.getFormUri_Expression();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.LoopMaximumImpl <em>Loop Maximum</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.LoopMaximumImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getLoopMaximum()
		 * @generated
		 */
		EClass LOOP_MAXIMUM = eINSTANCE.getLoopMaximum();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_MAXIMUM__EXPRESSION = eINSTANCE.getLoopMaximum_Expression();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.SkipStrategyImpl <em>Skip Strategy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.SkipStrategyImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getSkipStrategy()
		 * @generated
		 */
		EClass SKIP_STRATEGY = eINSTANCE.getSkipStrategy();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SKIP_STRATEGY__EXPRESSION = eINSTANCE.getSkipStrategy_Expression();

		/**
		 * The meta object literal for the '<em><b>Is Create Skip Process</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SKIP_STRATEGY__IS_CREATE_SKIP_PROCESS = eINSTANCE.getSkipStrategy_IsCreateSkipProcess();

		/**
		 * The meta object literal for the '<em><b>Skip Assignee</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SKIP_STRATEGY__SKIP_ASSIGNEE = eINSTANCE.getSkipStrategy_SkipAssignee();

		/**
		 * The meta object literal for the '<em><b>Skip Comment</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SKIP_STRATEGY__SKIP_COMMENT = eINSTANCE.getSkipStrategy_SkipComment();

		/**
		 * The meta object literal for the '<em><b>Is Enable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SKIP_STRATEGY__IS_ENABLE = eINSTANCE.getSkipStrategy_IsEnable();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.MessageObjImpl <em>Message Obj</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.MessageObjImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getMessageObj()
		 * @generated
		 */
		EClass MESSAGE_OBJ = eINSTANCE.getMessageObj();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_OBJ__ID = eINSTANCE.getMessageObj_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_OBJ__NAME = eINSTANCE.getMessageObj_Name();

		/**
		 * The meta object literal for the '<em><b>Documentation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_OBJ__DOCUMENTATION = eINSTANCE.getMessageObj_Documentation();

		/**
		 * The meta object literal for the '<em><b>Data Variable</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_OBJ__DATA_VARIABLE = eINSTANCE.getMessageObj_DataVariable();

		/**
		 * The meta object literal for the '<em><b>Target Process</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_OBJ__TARGET_PROCESS = eINSTANCE.getMessageObj_TargetProcess();

		/**
		 * The meta object literal for the '<em><b>Target Node</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_OBJ__TARGET_NODE = eINSTANCE.getMessageObj_TargetNode();

		/**
		 * The meta object literal for the '<em><b>Process Instance Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_OBJ__PROCESS_INSTANCE_VARIABLE = eINSTANCE.getMessageObj_ProcessInstanceVariable();

		/**
		 * The meta object literal for the '<em><b>Token Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_OBJ__TOKEN_VARIABLE = eINSTANCE.getMessageObj_TokenVariable();

		/**
		 * The meta object literal for the '<em><b>Message Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_OBJ__MESSAGE_TYPE = eINSTANCE.getMessageObj_MessageType();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.FilterConditionsImpl <em>Filter Conditions</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FilterConditionsImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getFilterConditions()
		 * @generated
		 */
		EClass FILTER_CONDITIONS = eINSTANCE.getFilterConditions();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILTER_CONDITIONS__EXPRESSION = eINSTANCE.getFilterConditions_Expression();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.ReceiveMessageImpl <em>Receive Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.ReceiveMessageImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getReceiveMessage()
		 * @generated
		 */
		EClass RECEIVE_MESSAGE = eINSTANCE.getReceiveMessage();

		/**
		 * The meta object literal for the '<em><b>Message Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECEIVE_MESSAGE__MESSAGE_ID = eINSTANCE.getReceiveMessage_MessageId();

		/**
		 * The meta object literal for the '<em><b>Filter Conditions</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECEIVE_MESSAGE__FILTER_CONDITIONS = eINSTANCE.getReceiveMessage_FilterConditions();

		/**
		 * The meta object literal for the '<em><b>Process Instance Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECEIVE_MESSAGE__PROCESS_INSTANCE_VARIABLE = eINSTANCE.getReceiveMessage_ProcessInstanceVariable();

		/**
		 * The meta object literal for the '<em><b>Token Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECEIVE_MESSAGE__TOKEN_VARIABLE = eINSTANCE.getReceiveMessage_TokenVariable();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.TokenVariableImpl <em>Token Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.TokenVariableImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getTokenVariable()
		 * @generated
		 */
		EClass TOKEN_VARIABLE = eINSTANCE.getTokenVariable();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOKEN_VARIABLE__EXPRESSION = eINSTANCE.getTokenVariable_Expression();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.ProcessInstanceVariableImpl <em>Process Instance Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.ProcessInstanceVariableImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getProcessInstanceVariable()
		 * @generated
		 */
		EClass PROCESS_INSTANCE_VARIABLE = eINSTANCE.getProcessInstanceVariable();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_INSTANCE_VARIABLE__EXPRESSION = eINSTANCE.getProcessInstanceVariable_Expression();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.ExpectedExecutionTimeImpl <em>Expected Execution Time</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.ExpectedExecutionTimeImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getExpectedExecutionTime()
		 * @generated
		 */
		EClass EXPECTED_EXECUTION_TIME = eINSTANCE.getExpectedExecutionTime();

		/**
		 * The meta object literal for the '<em><b>Day</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPECTED_EXECUTION_TIME__DAY = eINSTANCE.getExpectedExecutionTime_Day();

		/**
		 * The meta object literal for the '<em><b>Hour</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPECTED_EXECUTION_TIME__HOUR = eINSTANCE.getExpectedExecutionTime_Hour();

		/**
		 * The meta object literal for the '<em><b>Minute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPECTED_EXECUTION_TIME__MINUTE = eINSTANCE.getExpectedExecutionTime_Minute();

		/**
		 * The meta object literal for the '<em><b>Second</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPECTED_EXECUTION_TIME__SECOND = eINSTANCE.getExpectedExecutionTime_Second();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.DataSourceToSubProcessMappingImpl <em>Data Source To Sub Process Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.DataSourceToSubProcessMappingImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getDataSourceToSubProcessMapping()
		 * @generated
		 */
		EClass DATA_SOURCE_TO_SUB_PROCESS_MAPPING = eINSTANCE.getDataSourceToSubProcessMapping();

		/**
		 * The meta object literal for the '<em><b>Data Variable Mapping</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_SOURCE_TO_SUB_PROCESS_MAPPING__DATA_VARIABLE_MAPPING = eINSTANCE.getDataSourceToSubProcessMapping_DataVariableMapping();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.SubProcessToDataSourceMappingImpl <em>Sub Process To Data Source Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.SubProcessToDataSourceMappingImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getSubProcessToDataSourceMapping()
		 * @generated
		 */
		EClass SUB_PROCESS_TO_DATA_SOURCE_MAPPING = eINSTANCE.getSubProcessToDataSourceMapping();

		/**
		 * The meta object literal for the '<em><b>Data Variable Mapping</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_PROCESS_TO_DATA_SOURCE_MAPPING__DATA_VARIABLE_MAPPING = eINSTANCE.getSubProcessToDataSourceMapping_DataVariableMapping();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.DataVariableMappingImpl <em>Data Variable Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.DataVariableMappingImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getDataVariableMapping()
		 * @generated
		 */
		EClass DATA_VARIABLE_MAPPING = eINSTANCE.getDataVariableMapping();

		/**
		 * The meta object literal for the '<em><b>Data Source Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_VARIABLE_MAPPING__DATA_SOURCE_ID = eINSTANCE.getDataVariableMapping_DataSourceId();

		/**
		 * The meta object literal for the '<em><b>Sub Proces Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_VARIABLE_MAPPING__SUB_PROCES_ID = eINSTANCE.getDataVariableMapping_SubProcesId();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.FormUriViewImpl <em>Form Uri View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FormUriViewImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getFormUriView()
		 * @generated
		 */
		EClass FORM_URI_VIEW = eINSTANCE.getFormUriView();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORM_URI_VIEW__EXPRESSION = eINSTANCE.getFormUriView_Expression();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.TaskPriorityImpl <em>Task Priority</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.TaskPriorityImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getTaskPriority()
		 * @generated
		 */
		EClass TASK_PRIORITY = eINSTANCE.getTaskPriority();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_PRIORITY__EXPRESSION = eINSTANCE.getTaskPriority_Expression();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.AssignPolicyTypeImpl <em>Assign Policy Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.AssignPolicyTypeImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getAssignPolicyType()
		 * @generated
		 */
		EClass ASSIGN_POLICY_TYPE = eINSTANCE.getAssignPolicyType();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSIGN_POLICY_TYPE__ID = eINSTANCE.getAssignPolicyType_Id();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGN_POLICY_TYPE__EXPRESSION = eINSTANCE.getAssignPolicyType_Expression();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.SkipAssigneeImpl <em>Skip Assignee</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.SkipAssigneeImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getSkipAssignee()
		 * @generated
		 */
		EClass SKIP_ASSIGNEE = eINSTANCE.getSkipAssignee();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SKIP_ASSIGNEE__EXPRESSION = eINSTANCE.getSkipAssignee_Expression();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.SkipCommentImpl <em>Skip Comment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.SkipCommentImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getSkipComment()
		 * @generated
		 */
		EClass SKIP_COMMENT = eINSTANCE.getSkipComment();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SKIP_COMMENT__EXPRESSION = eINSTANCE.getSkipComment_Expression();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorInstanceElementsImpl <em>Connector Instance Elements</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.ConnectorInstanceElementsImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getConnectorInstanceElements()
		 * @generated
		 */
		EClass CONNECTOR_INSTANCE_ELEMENTS = eINSTANCE.getConnectorInstanceElements();

		/**
		 * The meta object literal for the '<em><b>Connrctor Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR_INSTANCE_ELEMENTS__CONNRCTOR_TYPE = eINSTANCE.getConnectorInstanceElements_ConnrctorType();

		/**
		 * The meta object literal for the '<em><b>Connector Instance</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR_INSTANCE_ELEMENTS__CONNECTOR_INSTANCE = eINSTANCE.getConnectorInstanceElements_ConnectorInstance();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.TimeExpressionImpl <em>Time Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.TimeExpressionImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getTimeExpression()
		 * @generated
		 */
		EClass TIME_EXPRESSION = eINSTANCE.getTimeExpression();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIME_EXPRESSION__EXPRESSION = eINSTANCE.getTimeExpression_Expression();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.TimeSkipExpressionImpl <em>Time Skip Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.TimeSkipExpressionImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getTimeSkipExpression()
		 * @generated
		 */
		EClass TIME_SKIP_EXPRESSION = eINSTANCE.getTimeSkipExpression();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIME_SKIP_EXPRESSION__EXPRESSION = eINSTANCE.getTimeSkipExpression_Expression();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.TableExpressionImpl <em>Table Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.TableExpressionImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getTableExpression()
		 * @generated
		 */
		EClass TABLE_EXPRESSION = eINSTANCE.getTableExpression();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_EXPRESSION__EXPRESSIONS = eINSTANCE.getTableExpression_Expressions();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.ListExpressionImpl <em>List Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.ListExpressionImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getListExpression()
		 * @generated
		 */
		EClass LIST_EXPRESSION = eINSTANCE.getListExpression();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIST_EXPRESSION__EXPRESSIONS = eINSTANCE.getListExpression_Expressions();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.TaskDescriptionImpl <em>Task Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.TaskDescriptionImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getTaskDescription()
		 * @generated
		 */
		EClass TASK_DESCRIPTION = eINSTANCE.getTaskDescription();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_DESCRIPTION__EXPRESSION = eINSTANCE.getTaskDescription_Expression();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.CompleteTaskDescriptionImpl <em>Complete Task Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.CompleteTaskDescriptionImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getCompleteTaskDescription()
		 * @generated
		 */
		EClass COMPLETE_TASK_DESCRIPTION = eINSTANCE.getCompleteTaskDescription();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_TASK_DESCRIPTION__EXPRESSION = eINSTANCE.getCompleteTaskDescription_Expression();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.FormParamContainerImpl <em>Form Param Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FormParamContainerImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getFormParamContainer()
		 * @generated
		 */
		EClass FORM_PARAM_CONTAINER = eINSTANCE.getFormParamContainer();

		/**
		 * The meta object literal for the '<em><b>Form Param</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORM_PARAM_CONTAINER__FORM_PARAM = eINSTANCE.getFormParamContainer_FormParam();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.FormParamImpl <em>Form Param</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FormParamImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getFormParam()
		 * @generated
		 */
		EClass FORM_PARAM = eINSTANCE.getFormParam();

		/**
		 * The meta object literal for the '<em><b>Param Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORM_PARAM__PARAM_KEY = eINSTANCE.getFormParam_ParamKey();

		/**
		 * The meta object literal for the '<em><b>Param Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORM_PARAM__PARAM_TYPE = eINSTANCE.getFormParam_ParamType();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORM_PARAM__EXPRESSION = eINSTANCE.getFormParam_Expression();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.BaseConfigImpl <em>Base Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.BaseConfigImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getBaseConfig()
		 * @generated
		 */
		EClass BASE_CONFIG = eINSTANCE.getBaseConfig();

		/**
		 * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASE_CONFIG__PARAMS = eINSTANCE.getBaseConfig_Params();

		/**
		 * The meta object literal for the '<em><b>Documentation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASE_CONFIG__DOCUMENTATION = eINSTANCE.getBaseConfig_Documentation();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.ParamImpl <em>Param</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.ParamImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getParam()
		 * @generated
		 */
		EClass PARAM = eINSTANCE.getParam();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAM__KEY = eINSTANCE.getParam_Key();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAM__NAME = eINSTANCE.getParam_Name();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAM__EXPRESSION = eINSTANCE.getParam_Expression();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.PotentialStarterImpl <em>Potential Starter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.PotentialStarterImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getPotentialStarter()
		 * @generated
		 */
		EClass POTENTIAL_STARTER = eINSTANCE.getPotentialStarter();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POTENTIAL_STARTER__EXPRESSION = eINSTANCE.getPotentialStarter_Expression();

		/**
		 * The meta object literal for the '<em><b>Resource Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POTENTIAL_STARTER__RESOURCE_TYPE = eINSTANCE.getPotentialStarter_ResourceType();

		/**
		 * The meta object literal for the '<em><b>EReference0</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POTENTIAL_STARTER__EREFERENCE0 = eINSTANCE.getPotentialStarter_EReference0();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POTENTIAL_STARTER__DESCRIPTION = eINSTANCE.getPotentialStarter_Description();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.PotentialOwnerImpl <em>Potential Owner</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.PotentialOwnerImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getPotentialOwner()
		 * @generated
		 */
		EClass POTENTIAL_OWNER = eINSTANCE.getPotentialOwner();

		/**
		 * The meta object literal for the '<em><b>Connector Instance Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POTENTIAL_OWNER__CONNECTOR_INSTANCE_ELEMENTS = eINSTANCE.getPotentialOwner_ConnectorInstanceElements();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.impl.CommandParamImpl <em>Command Param</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.CommandParamImpl
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getCommandParam()
		 * @generated
		 */
		EClass COMMAND_PARAM = eINSTANCE.getCommandParam();

		/**
		 * The meta object literal for the '<em><b>Biz Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND_PARAM__BIZ_TYPE = eINSTANCE.getCommandParam_BizType();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND_PARAM__DATA_TYPE = eINSTANCE.getCommandParam_DataType();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.bpmn.foxbpm.ProcessValidationLevel <em>Process Validation Level</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.bpmn.foxbpm.ProcessValidationLevel
		 * @see org.foxbpm.model.bpmn.foxbpm.impl.FoxBPMPackageImpl#getProcessValidationLevel()
		 * @generated
		 */
		EEnum PROCESS_VALIDATION_LEVEL = eINSTANCE.getProcessValidationLevel();

	}

} //FoxBPMPackage
