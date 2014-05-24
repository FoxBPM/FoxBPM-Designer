/**
 */
package org.foxbpm.model.config.foxbpmconfig;

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
 * FoxBPM引擎配置文件模型
 * <!-- end-model-doc -->
 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigFactory
 * @model kind="package"
 * @generated
 */
public interface FoxBPMConfigPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "foxbpmconfig";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.foxbpm.org/foxbpmconfig";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "foxbpmconfig";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FoxBPMConfigPackage eINSTANCE = org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.foxbpmconfig.impl.BaseConfigImpl <em>Base Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.foxbpmconfig.impl.BaseConfigImpl
	 * @see org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigPackageImpl#getBaseConfig()
	 * @generated
	 */
	int BASE_CONFIG = 9;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_CONFIG__PARAMS = 0;

	/**
	 * The number of structural features of the '<em>Base Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_CONFIG_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Base Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_CONFIG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigImpl <em>Fox BPM Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigImpl
	 * @see org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigPackageImpl#getFoxBPMConfig()
	 * @generated
	 */
	int FOX_BPM_CONFIG = 0;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOX_BPM_CONFIG__PARAMS = BASE_CONFIG__PARAMS;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOX_BPM_CONFIG__VERSION = BASE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource Path Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOX_BPM_CONFIG__RESOURCE_PATH_CONFIG = BASE_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sys Mail Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOX_BPM_CONFIG__SYS_MAIL_CONFIG = BASE_CONFIG_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Connection Management Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOX_BPM_CONFIG__CONNECTION_MANAGEMENT_CONFIG = BASE_CONFIG_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Task Command Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOX_BPM_CONFIG__TASK_COMMAND_CONFIG = BASE_CONFIG_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Fox BPM Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOX_BPM_CONFIG_FEATURE_COUNT = BASE_CONFIG_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Fox BPM Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOX_BPM_CONFIG_OPERATION_COUNT = BASE_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.foxbpmconfig.impl.SysMailConfigImpl <em>Sys Mail Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.foxbpmconfig.impl.SysMailConfigImpl
	 * @see org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigPackageImpl#getSysMailConfig()
	 * @generated
	 */
	int SYS_MAIL_CONFIG = 1;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYS_MAIL_CONFIG__PARAMS = BASE_CONFIG__PARAMS;

	/**
	 * The feature id for the '<em><b>Mail Info</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYS_MAIL_CONFIG__MAIL_INFO = BASE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Selected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYS_MAIL_CONFIG__SELECTED = BASE_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sys Mail Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYS_MAIL_CONFIG_FEATURE_COUNT = BASE_CONFIG_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Sys Mail Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYS_MAIL_CONFIG_OPERATION_COUNT = BASE_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.foxbpmconfig.impl.ConnectionManagementConfigImpl <em>Connection Management Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.foxbpmconfig.impl.ConnectionManagementConfigImpl
	 * @see org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigPackageImpl#getConnectionManagementConfig()
	 * @generated
	 */
	int CONNECTION_MANAGEMENT_CONFIG = 2;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_MANAGEMENT_CONFIG__PARAMS = BASE_CONFIG__PARAMS;

	/**
	 * The feature id for the '<em><b>Connection Management</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_MANAGEMENT_CONFIG__CONNECTION_MANAGEMENT = BASE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Selected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_MANAGEMENT_CONFIG__SELECTED = BASE_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Connection Management Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_MANAGEMENT_CONFIG_FEATURE_COUNT = BASE_CONFIG_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Connection Management Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_MANAGEMENT_CONFIG_OPERATION_COUNT = BASE_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.foxbpmconfig.impl.ConnectionManagementImpl <em>Connection Management</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.foxbpmconfig.impl.ConnectionManagementImpl
	 * @see org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigPackageImpl#getConnectionManagement()
	 * @generated
	 */
	int CONNECTION_MANAGEMENT = 3;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_MANAGEMENT__PARAMS = BASE_CONFIG__PARAMS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_MANAGEMENT__ID = BASE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_MANAGEMENT__NAME = BASE_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Class Impl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_MANAGEMENT__CLASS_IMPL = BASE_CONFIG_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Connection Management</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_MANAGEMENT_FEATURE_COUNT = BASE_CONFIG_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Connection Management</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_MANAGEMENT_OPERATION_COUNT = BASE_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.foxbpmconfig.impl.ResourcePathConfigImpl <em>Resource Path Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.foxbpmconfig.impl.ResourcePathConfigImpl
	 * @see org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigPackageImpl#getResourcePathConfig()
	 * @generated
	 */
	int RESOURCE_PATH_CONFIG = 4;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PATH_CONFIG__PARAMS = BASE_CONFIG__PARAMS;

	/**
	 * The feature id for the '<em><b>Resource Path</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PATH_CONFIG__RESOURCE_PATH = BASE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resource Path Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PATH_CONFIG_FEATURE_COUNT = BASE_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Resource Path Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PATH_CONFIG_OPERATION_COUNT = BASE_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.foxbpmconfig.impl.ResourcePathImpl <em>Resource Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.foxbpmconfig.impl.ResourcePathImpl
	 * @see org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigPackageImpl#getResourcePath()
	 * @generated
	 */
	int RESOURCE_PATH = 5;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PATH__PARAMS = BASE_CONFIG__PARAMS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PATH__ID = BASE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PATH__NAME = BASE_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Src</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PATH__SRC = BASE_CONFIG_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Physical Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PATH__PHYSICAL_PATH = BASE_CONFIG_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Virtual Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PATH__VIRTUAL_PATH = BASE_CONFIG_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PATH__PROJECT_NAME = BASE_CONFIG_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PATH__TYPE = BASE_CONFIG_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Resource Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PATH_FEATURE_COUNT = BASE_CONFIG_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Resource Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PATH_OPERATION_COUNT = BASE_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.foxbpmconfig.impl.MailInfoImpl <em>Mail Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.foxbpmconfig.impl.MailInfoImpl
	 * @see org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigPackageImpl#getMailInfo()
	 * @generated
	 */
	int MAIL_INFO = 6;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIL_INFO__PARAMS = BASE_CONFIG__PARAMS;

	/**
	 * The feature id for the '<em><b>Mail Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIL_INFO__MAIL_ADDRESS = BASE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mail Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIL_INFO__MAIL_NAME = BASE_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Smtp Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIL_INFO__SMTP_HOST = BASE_CONFIG_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Smtp Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIL_INFO__SMTP_PORT = BASE_CONFIG_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIL_INFO__USER_NAME = BASE_CONFIG_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIL_INFO__PASSWORD = BASE_CONFIG_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Mail Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIL_INFO_FEATURE_COUNT = BASE_CONFIG_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Mail Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIL_INFO_OPERATION_COUNT = BASE_CONFIG_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.foxbpmconfig.impl.TaskCommandConfigImpl <em>Task Command Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.foxbpmconfig.impl.TaskCommandConfigImpl
	 * @see org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigPackageImpl#getTaskCommandConfig()
	 * @generated
	 */
	int TASK_COMMAND_CONFIG = 7;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_COMMAND_CONFIG__PARAMS = BASE_CONFIG__PARAMS;

	/**
	 * The feature id for the '<em><b>Task Command Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_COMMAND_CONFIG__TASK_COMMAND_DEFINITIONS = BASE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Task Command Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_COMMAND_CONFIG_FEATURE_COUNT = BASE_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Task Command Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_COMMAND_CONFIG_OPERATION_COUNT = BASE_CONFIG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.foxbpmconfig.impl.ParamImpl <em>Param</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.foxbpmconfig.impl.ParamImpl
	 * @see org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigPackageImpl#getParam()
	 * @generated
	 */
	int PARAM = 8;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.foxbpmconfig.impl.TaskCommandDefinitionImpl <em>Task Command Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.foxbpmconfig.impl.TaskCommandDefinitionImpl
	 * @see org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigPackageImpl#getTaskCommandDefinition()
	 * @generated
	 */
	int TASK_COMMAND_DEFINITION = 10;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_COMMAND_DEFINITION__PARAMS = BASE_CONFIG__PARAMS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_COMMAND_DEFINITION__ID = BASE_CONFIG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_COMMAND_DEFINITION__NAME = BASE_CONFIG_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Command</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_COMMAND_DEFINITION__COMMAND = BASE_CONFIG_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Cmd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_COMMAND_DEFINITION__CMD = BASE_CONFIG_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_COMMAND_DEFINITION__FILTER = BASE_CONFIG_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_COMMAND_DEFINITION__IS_ENABLED = BASE_CONFIG_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_COMMAND_DEFINITION__TYPE = BASE_CONFIG_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Task Command Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_COMMAND_DEFINITION_FEATURE_COUNT = BASE_CONFIG_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Task Command Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_COMMAND_DEFINITION_OPERATION_COUNT = BASE_CONFIG_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig <em>Fox BPM Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fox BPM Config</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig
	 * @generated
	 */
	EClass getFoxBPMConfig();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig#getVersion()
	 * @see #getFoxBPMConfig()
	 * @generated
	 */
	EAttribute getFoxBPMConfig_Version();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig#getResourcePathConfig <em>Resource Path Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Resource Path Config</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig#getResourcePathConfig()
	 * @see #getFoxBPMConfig()
	 * @generated
	 */
	EReference getFoxBPMConfig_ResourcePathConfig();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig#getSysMailConfig <em>Sys Mail Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sys Mail Config</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig#getSysMailConfig()
	 * @see #getFoxBPMConfig()
	 * @generated
	 */
	EReference getFoxBPMConfig_SysMailConfig();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig#getConnectionManagementConfig <em>Connection Management Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Connection Management Config</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig#getConnectionManagementConfig()
	 * @see #getFoxBPMConfig()
	 * @generated
	 */
	EReference getFoxBPMConfig_ConnectionManagementConfig();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig#getTaskCommandConfig <em>Task Command Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Task Command Config</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig#getTaskCommandConfig()
	 * @see #getFoxBPMConfig()
	 * @generated
	 */
	EReference getFoxBPMConfig_TaskCommandConfig();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.foxbpmconfig.SysMailConfig <em>Sys Mail Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sys Mail Config</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.SysMailConfig
	 * @generated
	 */
	EClass getSysMailConfig();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.config.foxbpmconfig.SysMailConfig#getMailInfo <em>Mail Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mail Info</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.SysMailConfig#getMailInfo()
	 * @see #getSysMailConfig()
	 * @generated
	 */
	EReference getSysMailConfig_MailInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.foxbpmconfig.SysMailConfig#getSelected <em>Selected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selected</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.SysMailConfig#getSelected()
	 * @see #getSysMailConfig()
	 * @generated
	 */
	EAttribute getSysMailConfig_Selected();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.foxbpmconfig.ConnectionManagementConfig <em>Connection Management Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Management Config</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.ConnectionManagementConfig
	 * @generated
	 */
	EClass getConnectionManagementConfig();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.foxbpmconfig.ConnectionManagementConfig#getSelected <em>Selected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selected</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.ConnectionManagementConfig#getSelected()
	 * @see #getConnectionManagementConfig()
	 * @generated
	 */
	EAttribute getConnectionManagementConfig_Selected();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.config.foxbpmconfig.ConnectionManagementConfig#getConnectionManagement <em>Connection Management</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connection Management</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.ConnectionManagementConfig#getConnectionManagement()
	 * @see #getConnectionManagementConfig()
	 * @generated
	 */
	EReference getConnectionManagementConfig_ConnectionManagement();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.foxbpmconfig.ConnectionManagement <em>Connection Management</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Management</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.ConnectionManagement
	 * @generated
	 */
	EClass getConnectionManagement();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.foxbpmconfig.ConnectionManagement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.ConnectionManagement#getId()
	 * @see #getConnectionManagement()
	 * @generated
	 */
	EAttribute getConnectionManagement_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.foxbpmconfig.ConnectionManagement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.ConnectionManagement#getName()
	 * @see #getConnectionManagement()
	 * @generated
	 */
	EAttribute getConnectionManagement_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.foxbpmconfig.ConnectionManagement#getClassImpl <em>Class Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Impl</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.ConnectionManagement#getClassImpl()
	 * @see #getConnectionManagement()
	 * @generated
	 */
	EAttribute getConnectionManagement_ClassImpl();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.foxbpmconfig.ResourcePathConfig <em>Resource Path Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Path Config</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.ResourcePathConfig
	 * @generated
	 */
	EClass getResourcePathConfig();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.config.foxbpmconfig.ResourcePathConfig#getResourcePath <em>Resource Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Path</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.ResourcePathConfig#getResourcePath()
	 * @see #getResourcePathConfig()
	 * @generated
	 */
	EReference getResourcePathConfig_ResourcePath();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.foxbpmconfig.ResourcePath <em>Resource Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Path</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.ResourcePath
	 * @generated
	 */
	EClass getResourcePath();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.foxbpmconfig.ResourcePath#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.ResourcePath#getId()
	 * @see #getResourcePath()
	 * @generated
	 */
	EAttribute getResourcePath_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.foxbpmconfig.ResourcePath#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.ResourcePath#getName()
	 * @see #getResourcePath()
	 * @generated
	 */
	EAttribute getResourcePath_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.foxbpmconfig.ResourcePath#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.ResourcePath#getSrc()
	 * @see #getResourcePath()
	 * @generated
	 */
	EAttribute getResourcePath_Src();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.foxbpmconfig.ResourcePath#getPhysicalPath <em>Physical Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Physical Path</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.ResourcePath#getPhysicalPath()
	 * @see #getResourcePath()
	 * @generated
	 */
	EAttribute getResourcePath_PhysicalPath();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.foxbpmconfig.ResourcePath#getVirtualPath <em>Virtual Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Virtual Path</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.ResourcePath#getVirtualPath()
	 * @see #getResourcePath()
	 * @generated
	 */
	EAttribute getResourcePath_VirtualPath();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.foxbpmconfig.ResourcePath#getProjectName <em>Project Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Name</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.ResourcePath#getProjectName()
	 * @see #getResourcePath()
	 * @generated
	 */
	EAttribute getResourcePath_ProjectName();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.foxbpmconfig.ResourcePath#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.ResourcePath#getType()
	 * @see #getResourcePath()
	 * @generated
	 */
	EAttribute getResourcePath_Type();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.foxbpmconfig.MailInfo <em>Mail Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mail Info</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.MailInfo
	 * @generated
	 */
	EClass getMailInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.foxbpmconfig.MailInfo#getMailAddress <em>Mail Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mail Address</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.MailInfo#getMailAddress()
	 * @see #getMailInfo()
	 * @generated
	 */
	EAttribute getMailInfo_MailAddress();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.foxbpmconfig.MailInfo#getMailName <em>Mail Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mail Name</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.MailInfo#getMailName()
	 * @see #getMailInfo()
	 * @generated
	 */
	EAttribute getMailInfo_MailName();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.foxbpmconfig.MailInfo#getSmtpHost <em>Smtp Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Smtp Host</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.MailInfo#getSmtpHost()
	 * @see #getMailInfo()
	 * @generated
	 */
	EAttribute getMailInfo_SmtpHost();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.foxbpmconfig.MailInfo#getSmtpPort <em>Smtp Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Smtp Port</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.MailInfo#getSmtpPort()
	 * @see #getMailInfo()
	 * @generated
	 */
	EAttribute getMailInfo_SmtpPort();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.foxbpmconfig.MailInfo#getUserName <em>User Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Name</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.MailInfo#getUserName()
	 * @see #getMailInfo()
	 * @generated
	 */
	EAttribute getMailInfo_UserName();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.foxbpmconfig.MailInfo#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.MailInfo#getPassword()
	 * @see #getMailInfo()
	 * @generated
	 */
	EAttribute getMailInfo_Password();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.foxbpmconfig.TaskCommandConfig <em>Task Command Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task Command Config</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.TaskCommandConfig
	 * @generated
	 */
	EClass getTaskCommandConfig();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.config.foxbpmconfig.TaskCommandConfig#getTaskCommandDefinitions <em>Task Command Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Task Command Definitions</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.TaskCommandConfig#getTaskCommandDefinitions()
	 * @see #getTaskCommandConfig()
	 * @generated
	 */
	EReference getTaskCommandConfig_TaskCommandDefinitions();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.foxbpmconfig.Param <em>Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Param</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.Param
	 * @generated
	 */
	EClass getParam();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.foxbpmconfig.Param#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.Param#getKey()
	 * @see #getParam()
	 * @generated
	 */
	EAttribute getParam_Key();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.foxbpmconfig.Param#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.Param#getValue()
	 * @see #getParam()
	 * @generated
	 */
	EAttribute getParam_Value();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.foxbpmconfig.BaseConfig <em>Base Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Config</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.BaseConfig
	 * @generated
	 */
	EClass getBaseConfig();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.config.foxbpmconfig.BaseConfig#getParams <em>Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Params</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.BaseConfig#getParams()
	 * @see #getBaseConfig()
	 * @generated
	 */
	EReference getBaseConfig_Params();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.foxbpmconfig.TaskCommandDefinition <em>Task Command Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task Command Definition</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.TaskCommandDefinition
	 * @generated
	 */
	EClass getTaskCommandDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.foxbpmconfig.TaskCommandDefinition#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.TaskCommandDefinition#getId()
	 * @see #getTaskCommandDefinition()
	 * @generated
	 */
	EAttribute getTaskCommandDefinition_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.foxbpmconfig.TaskCommandDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.TaskCommandDefinition#getName()
	 * @see #getTaskCommandDefinition()
	 * @generated
	 */
	EAttribute getTaskCommandDefinition_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.foxbpmconfig.TaskCommandDefinition#getCommand <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Command</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.TaskCommandDefinition#getCommand()
	 * @see #getTaskCommandDefinition()
	 * @generated
	 */
	EAttribute getTaskCommandDefinition_Command();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.foxbpmconfig.TaskCommandDefinition#getCmd <em>Cmd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cmd</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.TaskCommandDefinition#getCmd()
	 * @see #getTaskCommandDefinition()
	 * @generated
	 */
	EAttribute getTaskCommandDefinition_Cmd();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.foxbpmconfig.TaskCommandDefinition#getFilter <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filter</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.TaskCommandDefinition#getFilter()
	 * @see #getTaskCommandDefinition()
	 * @generated
	 */
	EAttribute getTaskCommandDefinition_Filter();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.foxbpmconfig.TaskCommandDefinition#getIsEnabled <em>Is Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Enabled</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.TaskCommandDefinition#getIsEnabled()
	 * @see #getTaskCommandDefinition()
	 * @generated
	 */
	EAttribute getTaskCommandDefinition_IsEnabled();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.foxbpmconfig.TaskCommandDefinition#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.foxbpm.model.config.foxbpmconfig.TaskCommandDefinition#getType()
	 * @see #getTaskCommandDefinition()
	 * @generated
	 */
	EAttribute getTaskCommandDefinition_Type();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FoxBPMConfigFactory getFoxBPMConfigFactory();

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
		 * The meta object literal for the '{@link org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigImpl <em>Fox BPM Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigImpl
		 * @see org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigPackageImpl#getFoxBPMConfig()
		 * @generated
		 */
		EClass FOX_BPM_CONFIG = eINSTANCE.getFoxBPMConfig();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOX_BPM_CONFIG__VERSION = eINSTANCE.getFoxBPMConfig_Version();

		/**
		 * The meta object literal for the '<em><b>Resource Path Config</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOX_BPM_CONFIG__RESOURCE_PATH_CONFIG = eINSTANCE.getFoxBPMConfig_ResourcePathConfig();

		/**
		 * The meta object literal for the '<em><b>Sys Mail Config</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOX_BPM_CONFIG__SYS_MAIL_CONFIG = eINSTANCE.getFoxBPMConfig_SysMailConfig();

		/**
		 * The meta object literal for the '<em><b>Connection Management Config</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOX_BPM_CONFIG__CONNECTION_MANAGEMENT_CONFIG = eINSTANCE.getFoxBPMConfig_ConnectionManagementConfig();

		/**
		 * The meta object literal for the '<em><b>Task Command Config</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOX_BPM_CONFIG__TASK_COMMAND_CONFIG = eINSTANCE.getFoxBPMConfig_TaskCommandConfig();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.foxbpmconfig.impl.SysMailConfigImpl <em>Sys Mail Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.foxbpmconfig.impl.SysMailConfigImpl
		 * @see org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigPackageImpl#getSysMailConfig()
		 * @generated
		 */
		EClass SYS_MAIL_CONFIG = eINSTANCE.getSysMailConfig();

		/**
		 * The meta object literal for the '<em><b>Mail Info</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYS_MAIL_CONFIG__MAIL_INFO = eINSTANCE.getSysMailConfig_MailInfo();

		/**
		 * The meta object literal for the '<em><b>Selected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYS_MAIL_CONFIG__SELECTED = eINSTANCE.getSysMailConfig_Selected();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.foxbpmconfig.impl.ConnectionManagementConfigImpl <em>Connection Management Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.foxbpmconfig.impl.ConnectionManagementConfigImpl
		 * @see org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigPackageImpl#getConnectionManagementConfig()
		 * @generated
		 */
		EClass CONNECTION_MANAGEMENT_CONFIG = eINSTANCE.getConnectionManagementConfig();

		/**
		 * The meta object literal for the '<em><b>Selected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_MANAGEMENT_CONFIG__SELECTED = eINSTANCE.getConnectionManagementConfig_Selected();

		/**
		 * The meta object literal for the '<em><b>Connection Management</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_MANAGEMENT_CONFIG__CONNECTION_MANAGEMENT = eINSTANCE.getConnectionManagementConfig_ConnectionManagement();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.foxbpmconfig.impl.ConnectionManagementImpl <em>Connection Management</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.foxbpmconfig.impl.ConnectionManagementImpl
		 * @see org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigPackageImpl#getConnectionManagement()
		 * @generated
		 */
		EClass CONNECTION_MANAGEMENT = eINSTANCE.getConnectionManagement();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_MANAGEMENT__ID = eINSTANCE.getConnectionManagement_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_MANAGEMENT__NAME = eINSTANCE.getConnectionManagement_Name();

		/**
		 * The meta object literal for the '<em><b>Class Impl</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_MANAGEMENT__CLASS_IMPL = eINSTANCE.getConnectionManagement_ClassImpl();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.foxbpmconfig.impl.ResourcePathConfigImpl <em>Resource Path Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.foxbpmconfig.impl.ResourcePathConfigImpl
		 * @see org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigPackageImpl#getResourcePathConfig()
		 * @generated
		 */
		EClass RESOURCE_PATH_CONFIG = eINSTANCE.getResourcePathConfig();

		/**
		 * The meta object literal for the '<em><b>Resource Path</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_PATH_CONFIG__RESOURCE_PATH = eINSTANCE.getResourcePathConfig_ResourcePath();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.foxbpmconfig.impl.ResourcePathImpl <em>Resource Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.foxbpmconfig.impl.ResourcePathImpl
		 * @see org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigPackageImpl#getResourcePath()
		 * @generated
		 */
		EClass RESOURCE_PATH = eINSTANCE.getResourcePath();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_PATH__ID = eINSTANCE.getResourcePath_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_PATH__NAME = eINSTANCE.getResourcePath_Name();

		/**
		 * The meta object literal for the '<em><b>Src</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_PATH__SRC = eINSTANCE.getResourcePath_Src();

		/**
		 * The meta object literal for the '<em><b>Physical Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_PATH__PHYSICAL_PATH = eINSTANCE.getResourcePath_PhysicalPath();

		/**
		 * The meta object literal for the '<em><b>Virtual Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_PATH__VIRTUAL_PATH = eINSTANCE.getResourcePath_VirtualPath();

		/**
		 * The meta object literal for the '<em><b>Project Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_PATH__PROJECT_NAME = eINSTANCE.getResourcePath_ProjectName();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_PATH__TYPE = eINSTANCE.getResourcePath_Type();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.foxbpmconfig.impl.MailInfoImpl <em>Mail Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.foxbpmconfig.impl.MailInfoImpl
		 * @see org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigPackageImpl#getMailInfo()
		 * @generated
		 */
		EClass MAIL_INFO = eINSTANCE.getMailInfo();

		/**
		 * The meta object literal for the '<em><b>Mail Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAIL_INFO__MAIL_ADDRESS = eINSTANCE.getMailInfo_MailAddress();

		/**
		 * The meta object literal for the '<em><b>Mail Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAIL_INFO__MAIL_NAME = eINSTANCE.getMailInfo_MailName();

		/**
		 * The meta object literal for the '<em><b>Smtp Host</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAIL_INFO__SMTP_HOST = eINSTANCE.getMailInfo_SmtpHost();

		/**
		 * The meta object literal for the '<em><b>Smtp Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAIL_INFO__SMTP_PORT = eINSTANCE.getMailInfo_SmtpPort();

		/**
		 * The meta object literal for the '<em><b>User Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAIL_INFO__USER_NAME = eINSTANCE.getMailInfo_UserName();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAIL_INFO__PASSWORD = eINSTANCE.getMailInfo_Password();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.foxbpmconfig.impl.TaskCommandConfigImpl <em>Task Command Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.foxbpmconfig.impl.TaskCommandConfigImpl
		 * @see org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigPackageImpl#getTaskCommandConfig()
		 * @generated
		 */
		EClass TASK_COMMAND_CONFIG = eINSTANCE.getTaskCommandConfig();

		/**
		 * The meta object literal for the '<em><b>Task Command Definitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_COMMAND_CONFIG__TASK_COMMAND_DEFINITIONS = eINSTANCE.getTaskCommandConfig_TaskCommandDefinitions();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.foxbpmconfig.impl.ParamImpl <em>Param</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.foxbpmconfig.impl.ParamImpl
		 * @see org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigPackageImpl#getParam()
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
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAM__VALUE = eINSTANCE.getParam_Value();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.foxbpmconfig.impl.BaseConfigImpl <em>Base Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.foxbpmconfig.impl.BaseConfigImpl
		 * @see org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigPackageImpl#getBaseConfig()
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
		 * The meta object literal for the '{@link org.foxbpm.model.config.foxbpmconfig.impl.TaskCommandDefinitionImpl <em>Task Command Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.foxbpmconfig.impl.TaskCommandDefinitionImpl
		 * @see org.foxbpm.model.config.foxbpmconfig.impl.FoxBPMConfigPackageImpl#getTaskCommandDefinition()
		 * @generated
		 */
		EClass TASK_COMMAND_DEFINITION = eINSTANCE.getTaskCommandDefinition();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_COMMAND_DEFINITION__ID = eINSTANCE.getTaskCommandDefinition_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_COMMAND_DEFINITION__NAME = eINSTANCE.getTaskCommandDefinition_Name();

		/**
		 * The meta object literal for the '<em><b>Command</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_COMMAND_DEFINITION__COMMAND = eINSTANCE.getTaskCommandDefinition_Command();

		/**
		 * The meta object literal for the '<em><b>Cmd</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_COMMAND_DEFINITION__CMD = eINSTANCE.getTaskCommandDefinition_Cmd();

		/**
		 * The meta object literal for the '<em><b>Filter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_COMMAND_DEFINITION__FILTER = eINSTANCE.getTaskCommandDefinition_Filter();

		/**
		 * The meta object literal for the '<em><b>Is Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_COMMAND_DEFINITION__IS_ENABLED = eINSTANCE.getTaskCommandDefinition_IsEnabled();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_COMMAND_DEFINITION__TYPE = eINSTANCE.getTaskCommandDefinition_Type();

	}

} //FoxBPMConfigPackage
