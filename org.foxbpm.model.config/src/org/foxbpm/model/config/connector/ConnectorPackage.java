/**
 */
package org.foxbpm.model.config.connector;

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
 * @see org.foxbpm.model.config.connector.ConnectorFactory
 * @model kind="package"
 * @generated
 */
public interface ConnectorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "connector";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.foxbpm.org/connector";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "connector";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConnectorPackage eINSTANCE = org.foxbpm.model.config.connector.impl.ConnectorPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.connector.impl.ConnectorDefinitionImpl <em>Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.connector.impl.ConnectorDefinitionImpl
	 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getConnectorDefinition()
	 * @generated
	 */
	int CONNECTOR_DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_DEFINITION__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_DEFINITION__NAME = 1;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_DEFINITION__NOTE = 2;

	/**
	 * The feature id for the '<em><b>Category Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_DEFINITION__CATEGORY_ID = 3;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_DEFINITION__ICON = 4;

	/**
	 * The feature id for the '<em><b>Input</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_DEFINITION__INPUT = 5;

	/**
	 * The feature id for the '<em><b>Output</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_DEFINITION__OUTPUT = 6;

	/**
	 * The feature id for the '<em><b>Page</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_DEFINITION__PAGE = 7;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_DEFINITION__VERSION = 8;

	/**
	 * The feature id for the '<em><b>Definition Impl</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_DEFINITION__DEFINITION_IMPL = 9;

	/**
	 * The feature id for the '<em><b>Connrctor Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_DEFINITION__CONNRCTOR_TYPE = 10;

	/**
	 * The number of structural features of the '<em>Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_DEFINITION_FEATURE_COUNT = 11;

	/**
	 * The number of operations of the '<em>Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_DEFINITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.connector.impl.InputImpl <em>Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.connector.impl.InputImpl
	 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getInput()
	 * @generated
	 */
	int INPUT = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT__ID = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT__MANDATORY = 2;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT__DEFAULT_VALUE = 3;

	/**
	 * The feature id for the '<em><b>Is Execute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT__IS_EXECUTE = 4;

	/**
	 * The number of structural features of the '<em>Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.connector.impl.OutputImpl <em>Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.connector.impl.OutputImpl
	 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getOutput()
	 * @generated
	 */
	int OUTPUT = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__TYPE = 2;

	/**
	 * The number of structural features of the '<em>Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.connector.impl.PageImpl <em>Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.connector.impl.PageImpl
	 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getPage()
	 * @generated
	 */
	int PAGE = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__NOTE = 2;

	/**
	 * The feature id for the '<em><b>Widget</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__WIDGET = 3;

	/**
	 * The number of structural features of the '<em>Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.connector.impl.WidgetImpl <em>Widget</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.connector.impl.WidgetImpl
	 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getWidget()
	 * @generated
	 */
	int WIDGET = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__NAME = 1;

	/**
	 * The feature id for the '<em><b>Input Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__INPUT_ID = 2;

	/**
	 * The feature id for the '<em><b>Widget Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__WIDGET_EXPRESSION = 3;

	/**
	 * The number of structural features of the '<em>Widget</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Widget</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.connector.impl.TextImpl <em>Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.connector.impl.TextImpl
	 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getText()
	 * @generated
	 */
	int TEXT = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__ID = WIDGET__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__NAME = WIDGET__NAME;

	/**
	 * The feature id for the '<em><b>Input Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__INPUT_ID = WIDGET__INPUT_ID;

	/**
	 * The feature id for the '<em><b>Widget Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__WIDGET_EXPRESSION = WIDGET__WIDGET_EXPRESSION;

	/**
	 * The feature id for the '<em><b>EReference0</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__EREFERENCE0 = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_OPERATION_COUNT = WIDGET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.connector.impl.PasswordImpl <em>Password</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.connector.impl.PasswordImpl
	 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getPassword()
	 * @generated
	 */
	int PASSWORD = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD__ID = WIDGET__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD__NAME = WIDGET__NAME;

	/**
	 * The feature id for the '<em><b>Input Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD__INPUT_ID = WIDGET__INPUT_ID;

	/**
	 * The feature id for the '<em><b>Widget Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD__WIDGET_EXPRESSION = WIDGET__WIDGET_EXPRESSION;

	/**
	 * The number of structural features of the '<em>Password</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Password</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_OPERATION_COUNT = WIDGET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.connector.impl.TextAreaImpl <em>Text Area</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.connector.impl.TextAreaImpl
	 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getTextArea()
	 * @generated
	 */
	int TEXT_AREA = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_AREA__ID = WIDGET__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_AREA__NAME = WIDGET__NAME;

	/**
	 * The feature id for the '<em><b>Input Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_AREA__INPUT_ID = WIDGET__INPUT_ID;

	/**
	 * The feature id for the '<em><b>Widget Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_AREA__WIDGET_EXPRESSION = WIDGET__WIDGET_EXPRESSION;

	/**
	 * The number of structural features of the '<em>Text Area</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_AREA_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Text Area</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_AREA_OPERATION_COUNT = WIDGET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.connector.impl.CheckboxImpl <em>Checkbox</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.connector.impl.CheckboxImpl
	 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getCheckbox()
	 * @generated
	 */
	int CHECKBOX = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX__ID = WIDGET__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX__NAME = WIDGET__NAME;

	/**
	 * The feature id for the '<em><b>Input Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX__INPUT_ID = WIDGET__INPUT_ID;

	/**
	 * The feature id for the '<em><b>Widget Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX__WIDGET_EXPRESSION = WIDGET__WIDGET_EXPRESSION;

	/**
	 * The number of structural features of the '<em>Checkbox</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Checkbox</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX_OPERATION_COUNT = WIDGET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.connector.impl.SelectImpl <em>Select</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.connector.impl.SelectImpl
	 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getSelect()
	 * @generated
	 */
	int SELECT = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT__ID = WIDGET__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT__NAME = WIDGET__NAME;

	/**
	 * The feature id for the '<em><b>Input Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT__INPUT_ID = WIDGET__INPUT_ID;

	/**
	 * The feature id for the '<em><b>Widget Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT__WIDGET_EXPRESSION = WIDGET__WIDGET_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT__ITEMS = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Select</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Select</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_OPERATION_COUNT = WIDGET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.connector.impl.RadioGroupImpl <em>Radio Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.connector.impl.RadioGroupImpl
	 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getRadioGroup()
	 * @generated
	 */
	int RADIO_GROUP = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_GROUP__ID = WIDGET__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_GROUP__NAME = WIDGET__NAME;

	/**
	 * The feature id for the '<em><b>Input Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_GROUP__INPUT_ID = WIDGET__INPUT_ID;

	/**
	 * The feature id for the '<em><b>Widget Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_GROUP__WIDGET_EXPRESSION = WIDGET__WIDGET_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Choices</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_GROUP__CHOICES = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Radio Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_GROUP_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Radio Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_GROUP_OPERATION_COUNT = WIDGET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.connector.impl.GroupImpl <em>Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.connector.impl.GroupImpl
	 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getGroup()
	 * @generated
	 */
	int GROUP = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__ID = WIDGET__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__NAME = WIDGET__NAME;

	/**
	 * The feature id for the '<em><b>Input Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__INPUT_ID = WIDGET__INPUT_ID;

	/**
	 * The feature id for the '<em><b>Widget Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__WIDGET_EXPRESSION = WIDGET__WIDGET_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__OPTIONAL = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Widget</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__WIDGET = WIDGET_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_OPERATION_COUNT = WIDGET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.connector.impl.TableImpl <em>Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.connector.impl.TableImpl
	 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getTable()
	 * @generated
	 */
	int TABLE = 12;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__ID = WIDGET__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__NAME = WIDGET__NAME;

	/**
	 * The feature id for the '<em><b>Input Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__INPUT_ID = WIDGET__INPUT_ID;

	/**
	 * The feature id for the '<em><b>Widget Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__WIDGET_EXPRESSION = WIDGET__WIDGET_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Cols Caption</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__COLS_CAPTION = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cols</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__COLS = WIDGET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fixed Cols</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__FIXED_COLS = WIDGET_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_OPERATION_COUNT = WIDGET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.connector.impl.ListImpl <em>List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.connector.impl.ListImpl
	 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getList()
	 * @generated
	 */
	int LIST = 13;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST__ID = WIDGET__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST__NAME = WIDGET__NAME;

	/**
	 * The feature id for the '<em><b>Input Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST__INPUT_ID = WIDGET__INPUT_ID;

	/**
	 * The feature id for the '<em><b>Widget Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST__WIDGET_EXPRESSION = WIDGET__WIDGET_EXPRESSION;

	/**
	 * The number of structural features of the '<em>List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_OPERATION_COUNT = WIDGET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.connector.impl.ScriptEditorImpl <em>Script Editor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.connector.impl.ScriptEditorImpl
	 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getScriptEditor()
	 * @generated
	 */
	int SCRIPT_EDITOR = 14;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_EDITOR__ID = WIDGET__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_EDITOR__NAME = WIDGET__NAME;

	/**
	 * The feature id for the '<em><b>Input Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_EDITOR__INPUT_ID = WIDGET__INPUT_ID;

	/**
	 * The feature id for the '<em><b>Widget Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_EDITOR__WIDGET_EXPRESSION = WIDGET__WIDGET_EXPRESSION;

	/**
	 * The number of structural features of the '<em>Script Editor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_EDITOR_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Script Editor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_EDITOR_OPERATION_COUNT = WIDGET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.connector.impl.ItemsImpl <em>Items</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.connector.impl.ItemsImpl
	 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getItems()
	 * @generated
	 */
	int ITEMS = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEMS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEMS__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Items</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEMS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Items</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEMS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.connector.impl.ChoicesImpl <em>Choices</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.connector.impl.ChoicesImpl
	 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getChoices()
	 * @generated
	 */
	int CHOICES = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICES__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICES__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Choices</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICES_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Choices</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICES_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.connector.impl.ColsCaptionImpl <em>Cols Caption</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.connector.impl.ColsCaptionImpl
	 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getColsCaption()
	 * @generated
	 */
	int COLS_CAPTION = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLS_CAPTION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLS_CAPTION__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Cols Caption</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLS_CAPTION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Cols Caption</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLS_CAPTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.connector.impl.WidgetExpressionImpl <em>Widget Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.connector.impl.WidgetExpressionImpl
	 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getWidgetExpression()
	 * @generated
	 */
	int WIDGET_EXPRESSION = 18;

	/**
	 * The feature id for the '<em><b>Expression Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_EXPRESSION__EXPRESSION_VALUE = 0;

	/**
	 * The number of structural features of the '<em>Widget Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_EXPRESSION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Widget Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.connector.impl.DefinitionImplImpl <em>Definition Impl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.connector.impl.DefinitionImplImpl
	 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getDefinitionImpl()
	 * @generated
	 */
	int DEFINITION_IMPL = 19;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION_IMPL__CLASS_NAME = 0;

	/**
	 * The feature id for the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION_IMPL__PACKAGE_NAME = 1;

	/**
	 * The feature id for the '<em><b>Jar Dependencies</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION_IMPL__JAR_DEPENDENCIES = 2;

	/**
	 * The number of structural features of the '<em>Definition Impl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION_IMPL_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Definition Impl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION_IMPL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.connector.impl.JarDependenciesImpl <em>Jar Dependencies</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.connector.impl.JarDependenciesImpl
	 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getJarDependencies()
	 * @generated
	 */
	int JAR_DEPENDENCIES = 20;

	/**
	 * The feature id for the '<em><b>Jar Dependency</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_DEPENDENCIES__JAR_DEPENDENCY = 0;

	/**
	 * The number of structural features of the '<em>Jar Dependencies</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_DEPENDENCIES_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Jar Dependencies</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_DEPENDENCIES_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.connector.impl.JarDependencyImpl <em>Jar Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.connector.impl.JarDependencyImpl
	 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getJarDependency()
	 * @generated
	 */
	int JAR_DEPENDENCY = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_DEPENDENCY__NAME = 0;

	/**
	 * The number of structural features of the '<em>Jar Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_DEPENDENCY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Jar Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAR_DEPENDENCY_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.connector.ConnectorDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Definition</em>'.
	 * @see org.foxbpm.model.config.connector.ConnectorDefinition
	 * @generated
	 */
	EClass getConnectorDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.ConnectorDefinition#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.foxbpm.model.config.connector.ConnectorDefinition#getId()
	 * @see #getConnectorDefinition()
	 * @generated
	 */
	EAttribute getConnectorDefinition_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.ConnectorDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.foxbpm.model.config.connector.ConnectorDefinition#getName()
	 * @see #getConnectorDefinition()
	 * @generated
	 */
	EAttribute getConnectorDefinition_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.ConnectorDefinition#getNote <em>Note</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Note</em>'.
	 * @see org.foxbpm.model.config.connector.ConnectorDefinition#getNote()
	 * @see #getConnectorDefinition()
	 * @generated
	 */
	EAttribute getConnectorDefinition_Note();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.ConnectorDefinition#getCategoryId <em>Category Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Category Id</em>'.
	 * @see org.foxbpm.model.config.connector.ConnectorDefinition#getCategoryId()
	 * @see #getConnectorDefinition()
	 * @generated
	 */
	EAttribute getConnectorDefinition_CategoryId();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.ConnectorDefinition#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon</em>'.
	 * @see org.foxbpm.model.config.connector.ConnectorDefinition#getIcon()
	 * @see #getConnectorDefinition()
	 * @generated
	 */
	EAttribute getConnectorDefinition_Icon();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.config.connector.ConnectorDefinition#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input</em>'.
	 * @see org.foxbpm.model.config.connector.ConnectorDefinition#getInput()
	 * @see #getConnectorDefinition()
	 * @generated
	 */
	EReference getConnectorDefinition_Input();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.config.connector.ConnectorDefinition#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output</em>'.
	 * @see org.foxbpm.model.config.connector.ConnectorDefinition#getOutput()
	 * @see #getConnectorDefinition()
	 * @generated
	 */
	EReference getConnectorDefinition_Output();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.config.connector.ConnectorDefinition#getPage <em>Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Page</em>'.
	 * @see org.foxbpm.model.config.connector.ConnectorDefinition#getPage()
	 * @see #getConnectorDefinition()
	 * @generated
	 */
	EReference getConnectorDefinition_Page();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.ConnectorDefinition#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.foxbpm.model.config.connector.ConnectorDefinition#getVersion()
	 * @see #getConnectorDefinition()
	 * @generated
	 */
	EAttribute getConnectorDefinition_Version();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.config.connector.ConnectorDefinition#getDefinitionImpl <em>Definition Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Definition Impl</em>'.
	 * @see org.foxbpm.model.config.connector.ConnectorDefinition#getDefinitionImpl()
	 * @see #getConnectorDefinition()
	 * @generated
	 */
	EReference getConnectorDefinition_DefinitionImpl();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.ConnectorDefinition#getConnrctorType <em>Connrctor Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connrctor Type</em>'.
	 * @see org.foxbpm.model.config.connector.ConnectorDefinition#getConnrctorType()
	 * @see #getConnectorDefinition()
	 * @generated
	 */
	EAttribute getConnectorDefinition_ConnrctorType();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.connector.Input <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input</em>'.
	 * @see org.foxbpm.model.config.connector.Input
	 * @generated
	 */
	EClass getInput();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.Input#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.foxbpm.model.config.connector.Input#getId()
	 * @see #getInput()
	 * @generated
	 */
	EAttribute getInput_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.Input#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.foxbpm.model.config.connector.Input#getType()
	 * @see #getInput()
	 * @generated
	 */
	EAttribute getInput_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.Input#getMandatory <em>Mandatory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mandatory</em>'.
	 * @see org.foxbpm.model.config.connector.Input#getMandatory()
	 * @see #getInput()
	 * @generated
	 */
	EAttribute getInput_Mandatory();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.Input#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value</em>'.
	 * @see org.foxbpm.model.config.connector.Input#getDefaultValue()
	 * @see #getInput()
	 * @generated
	 */
	EAttribute getInput_DefaultValue();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.Input#getIsExecute <em>Is Execute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Execute</em>'.
	 * @see org.foxbpm.model.config.connector.Input#getIsExecute()
	 * @see #getInput()
	 * @generated
	 */
	EAttribute getInput_IsExecute();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.connector.Output <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output</em>'.
	 * @see org.foxbpm.model.config.connector.Output
	 * @generated
	 */
	EClass getOutput();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.Output#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.foxbpm.model.config.connector.Output#getId()
	 * @see #getOutput()
	 * @generated
	 */
	EAttribute getOutput_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.Output#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.foxbpm.model.config.connector.Output#getName()
	 * @see #getOutput()
	 * @generated
	 */
	EAttribute getOutput_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.Output#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.foxbpm.model.config.connector.Output#getType()
	 * @see #getOutput()
	 * @generated
	 */
	EAttribute getOutput_Type();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.connector.Page <em>Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page</em>'.
	 * @see org.foxbpm.model.config.connector.Page
	 * @generated
	 */
	EClass getPage();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.Page#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.foxbpm.model.config.connector.Page#getId()
	 * @see #getPage()
	 * @generated
	 */
	EAttribute getPage_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.Page#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.foxbpm.model.config.connector.Page#getName()
	 * @see #getPage()
	 * @generated
	 */
	EAttribute getPage_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.Page#getNote <em>Note</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Note</em>'.
	 * @see org.foxbpm.model.config.connector.Page#getNote()
	 * @see #getPage()
	 * @generated
	 */
	EAttribute getPage_Note();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.config.connector.Page#getWidget <em>Widget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Widget</em>'.
	 * @see org.foxbpm.model.config.connector.Page#getWidget()
	 * @see #getPage()
	 * @generated
	 */
	EReference getPage_Widget();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.connector.Widget <em>Widget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Widget</em>'.
	 * @see org.foxbpm.model.config.connector.Widget
	 * @generated
	 */
	EClass getWidget();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.Widget#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.foxbpm.model.config.connector.Widget#getId()
	 * @see #getWidget()
	 * @generated
	 */
	EAttribute getWidget_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.Widget#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.foxbpm.model.config.connector.Widget#getName()
	 * @see #getWidget()
	 * @generated
	 */
	EAttribute getWidget_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.Widget#getInputId <em>Input Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input Id</em>'.
	 * @see org.foxbpm.model.config.connector.Widget#getInputId()
	 * @see #getWidget()
	 * @generated
	 */
	EAttribute getWidget_InputId();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.config.connector.Widget#getWidgetExpression <em>Widget Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Widget Expression</em>'.
	 * @see org.foxbpm.model.config.connector.Widget#getWidgetExpression()
	 * @see #getWidget()
	 * @generated
	 */
	EReference getWidget_WidgetExpression();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.connector.Text <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text</em>'.
	 * @see org.foxbpm.model.config.connector.Text
	 * @generated
	 */
	EClass getText();

	/**
	 * Returns the meta object for the reference '{@link org.foxbpm.model.config.connector.Text#getEReference0 <em>EReference0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EReference0</em>'.
	 * @see org.foxbpm.model.config.connector.Text#getEReference0()
	 * @see #getText()
	 * @generated
	 */
	EReference getText_EReference0();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.connector.Password <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Password</em>'.
	 * @see org.foxbpm.model.config.connector.Password
	 * @generated
	 */
	EClass getPassword();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.connector.TextArea <em>Text Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Area</em>'.
	 * @see org.foxbpm.model.config.connector.TextArea
	 * @generated
	 */
	EClass getTextArea();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.connector.Checkbox <em>Checkbox</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Checkbox</em>'.
	 * @see org.foxbpm.model.config.connector.Checkbox
	 * @generated
	 */
	EClass getCheckbox();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.connector.Select <em>Select</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Select</em>'.
	 * @see org.foxbpm.model.config.connector.Select
	 * @generated
	 */
	EClass getSelect();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.config.connector.Select#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see org.foxbpm.model.config.connector.Select#getItems()
	 * @see #getSelect()
	 * @generated
	 */
	EReference getSelect_Items();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.connector.RadioGroup <em>Radio Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Radio Group</em>'.
	 * @see org.foxbpm.model.config.connector.RadioGroup
	 * @generated
	 */
	EClass getRadioGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.config.connector.RadioGroup#getChoices <em>Choices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Choices</em>'.
	 * @see org.foxbpm.model.config.connector.RadioGroup#getChoices()
	 * @see #getRadioGroup()
	 * @generated
	 */
	EReference getRadioGroup_Choices();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.connector.Group <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group</em>'.
	 * @see org.foxbpm.model.config.connector.Group
	 * @generated
	 */
	EClass getGroup();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.Group#getOptional <em>Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Optional</em>'.
	 * @see org.foxbpm.model.config.connector.Group#getOptional()
	 * @see #getGroup()
	 * @generated
	 */
	EAttribute getGroup_Optional();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.config.connector.Group#getWidget <em>Widget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Widget</em>'.
	 * @see org.foxbpm.model.config.connector.Group#getWidget()
	 * @see #getGroup()
	 * @generated
	 */
	EReference getGroup_Widget();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.connector.Table <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table</em>'.
	 * @see org.foxbpm.model.config.connector.Table
	 * @generated
	 */
	EClass getTable();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.config.connector.Table#getColsCaption <em>Cols Caption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cols Caption</em>'.
	 * @see org.foxbpm.model.config.connector.Table#getColsCaption()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_ColsCaption();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.Table#getCols <em>Cols</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cols</em>'.
	 * @see org.foxbpm.model.config.connector.Table#getCols()
	 * @see #getTable()
	 * @generated
	 */
	EAttribute getTable_Cols();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.Table#getFixedCols <em>Fixed Cols</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fixed Cols</em>'.
	 * @see org.foxbpm.model.config.connector.Table#getFixedCols()
	 * @see #getTable()
	 * @generated
	 */
	EAttribute getTable_FixedCols();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.connector.List <em>List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List</em>'.
	 * @see org.foxbpm.model.config.connector.List
	 * @generated
	 */
	EClass getList();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.connector.ScriptEditor <em>Script Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Script Editor</em>'.
	 * @see org.foxbpm.model.config.connector.ScriptEditor
	 * @generated
	 */
	EClass getScriptEditor();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.connector.Items <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Items</em>'.
	 * @see org.foxbpm.model.config.connector.Items
	 * @generated
	 */
	EClass getItems();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.Items#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.foxbpm.model.config.connector.Items#getName()
	 * @see #getItems()
	 * @generated
	 */
	EAttribute getItems_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.Items#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.foxbpm.model.config.connector.Items#getValue()
	 * @see #getItems()
	 * @generated
	 */
	EAttribute getItems_Value();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.connector.Choices <em>Choices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choices</em>'.
	 * @see org.foxbpm.model.config.connector.Choices
	 * @generated
	 */
	EClass getChoices();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.Choices#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.foxbpm.model.config.connector.Choices#getName()
	 * @see #getChoices()
	 * @generated
	 */
	EAttribute getChoices_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.Choices#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.foxbpm.model.config.connector.Choices#getValue()
	 * @see #getChoices()
	 * @generated
	 */
	EAttribute getChoices_Value();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.connector.ColsCaption <em>Cols Caption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cols Caption</em>'.
	 * @see org.foxbpm.model.config.connector.ColsCaption
	 * @generated
	 */
	EClass getColsCaption();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.ColsCaption#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.foxbpm.model.config.connector.ColsCaption#getName()
	 * @see #getColsCaption()
	 * @generated
	 */
	EAttribute getColsCaption_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.ColsCaption#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.foxbpm.model.config.connector.ColsCaption#getValue()
	 * @see #getColsCaption()
	 * @generated
	 */
	EAttribute getColsCaption_Value();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.connector.WidgetExpression <em>Widget Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Widget Expression</em>'.
	 * @see org.foxbpm.model.config.connector.WidgetExpression
	 * @generated
	 */
	EClass getWidgetExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.WidgetExpression#getExpressionValue <em>Expression Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression Value</em>'.
	 * @see org.foxbpm.model.config.connector.WidgetExpression#getExpressionValue()
	 * @see #getWidgetExpression()
	 * @generated
	 */
	EAttribute getWidgetExpression_ExpressionValue();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.connector.DefinitionImpl <em>Definition Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Definition Impl</em>'.
	 * @see org.foxbpm.model.config.connector.DefinitionImpl
	 * @generated
	 */
	EClass getDefinitionImpl();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.DefinitionImpl#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.foxbpm.model.config.connector.DefinitionImpl#getClassName()
	 * @see #getDefinitionImpl()
	 * @generated
	 */
	EAttribute getDefinitionImpl_ClassName();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.DefinitionImpl#getPackageName <em>Package Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package Name</em>'.
	 * @see org.foxbpm.model.config.connector.DefinitionImpl#getPackageName()
	 * @see #getDefinitionImpl()
	 * @generated
	 */
	EAttribute getDefinitionImpl_PackageName();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.config.connector.DefinitionImpl#getJarDependencies <em>Jar Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Jar Dependencies</em>'.
	 * @see org.foxbpm.model.config.connector.DefinitionImpl#getJarDependencies()
	 * @see #getDefinitionImpl()
	 * @generated
	 */
	EReference getDefinitionImpl_JarDependencies();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.connector.JarDependencies <em>Jar Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jar Dependencies</em>'.
	 * @see org.foxbpm.model.config.connector.JarDependencies
	 * @generated
	 */
	EClass getJarDependencies();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.config.connector.JarDependencies#getJarDependency <em>Jar Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Jar Dependency</em>'.
	 * @see org.foxbpm.model.config.connector.JarDependencies#getJarDependency()
	 * @see #getJarDependencies()
	 * @generated
	 */
	EReference getJarDependencies_JarDependency();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.connector.JarDependency <em>Jar Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jar Dependency</em>'.
	 * @see org.foxbpm.model.config.connector.JarDependency
	 * @generated
	 */
	EClass getJarDependency();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connector.JarDependency#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.foxbpm.model.config.connector.JarDependency#getName()
	 * @see #getJarDependency()
	 * @generated
	 */
	EAttribute getJarDependency_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConnectorFactory getConnectorFactory();

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
		 * The meta object literal for the '{@link org.foxbpm.model.config.connector.impl.ConnectorDefinitionImpl <em>Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.connector.impl.ConnectorDefinitionImpl
		 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getConnectorDefinition()
		 * @generated
		 */
		EClass CONNECTOR_DEFINITION = eINSTANCE.getConnectorDefinition();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR_DEFINITION__ID = eINSTANCE.getConnectorDefinition_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR_DEFINITION__NAME = eINSTANCE.getConnectorDefinition_Name();

		/**
		 * The meta object literal for the '<em><b>Note</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR_DEFINITION__NOTE = eINSTANCE.getConnectorDefinition_Note();

		/**
		 * The meta object literal for the '<em><b>Category Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR_DEFINITION__CATEGORY_ID = eINSTANCE.getConnectorDefinition_CategoryId();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR_DEFINITION__ICON = eINSTANCE.getConnectorDefinition_Icon();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR_DEFINITION__INPUT = eINSTANCE.getConnectorDefinition_Input();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR_DEFINITION__OUTPUT = eINSTANCE.getConnectorDefinition_Output();

		/**
		 * The meta object literal for the '<em><b>Page</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR_DEFINITION__PAGE = eINSTANCE.getConnectorDefinition_Page();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR_DEFINITION__VERSION = eINSTANCE.getConnectorDefinition_Version();

		/**
		 * The meta object literal for the '<em><b>Definition Impl</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR_DEFINITION__DEFINITION_IMPL = eINSTANCE.getConnectorDefinition_DefinitionImpl();

		/**
		 * The meta object literal for the '<em><b>Connrctor Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR_DEFINITION__CONNRCTOR_TYPE = eINSTANCE.getConnectorDefinition_ConnrctorType();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.connector.impl.InputImpl <em>Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.connector.impl.InputImpl
		 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getInput()
		 * @generated
		 */
		EClass INPUT = eINSTANCE.getInput();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT__ID = eINSTANCE.getInput_Id();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT__TYPE = eINSTANCE.getInput_Type();

		/**
		 * The meta object literal for the '<em><b>Mandatory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT__MANDATORY = eINSTANCE.getInput_Mandatory();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT__DEFAULT_VALUE = eINSTANCE.getInput_DefaultValue();

		/**
		 * The meta object literal for the '<em><b>Is Execute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT__IS_EXECUTE = eINSTANCE.getInput_IsExecute();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.connector.impl.OutputImpl <em>Output</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.connector.impl.OutputImpl
		 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getOutput()
		 * @generated
		 */
		EClass OUTPUT = eINSTANCE.getOutput();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OUTPUT__ID = eINSTANCE.getOutput_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OUTPUT__NAME = eINSTANCE.getOutput_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OUTPUT__TYPE = eINSTANCE.getOutput_Type();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.connector.impl.PageImpl <em>Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.connector.impl.PageImpl
		 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getPage()
		 * @generated
		 */
		EClass PAGE = eINSTANCE.getPage();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE__ID = eINSTANCE.getPage_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE__NAME = eINSTANCE.getPage_Name();

		/**
		 * The meta object literal for the '<em><b>Note</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE__NOTE = eINSTANCE.getPage_Note();

		/**
		 * The meta object literal for the '<em><b>Widget</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE__WIDGET = eINSTANCE.getPage_Widget();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.connector.impl.WidgetImpl <em>Widget</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.connector.impl.WidgetImpl
		 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getWidget()
		 * @generated
		 */
		EClass WIDGET = eINSTANCE.getWidget();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIDGET__ID = eINSTANCE.getWidget_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIDGET__NAME = eINSTANCE.getWidget_Name();

		/**
		 * The meta object literal for the '<em><b>Input Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIDGET__INPUT_ID = eINSTANCE.getWidget_InputId();

		/**
		 * The meta object literal for the '<em><b>Widget Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIDGET__WIDGET_EXPRESSION = eINSTANCE.getWidget_WidgetExpression();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.connector.impl.TextImpl <em>Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.connector.impl.TextImpl
		 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getText()
		 * @generated
		 */
		EClass TEXT = eINSTANCE.getText();

		/**
		 * The meta object literal for the '<em><b>EReference0</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXT__EREFERENCE0 = eINSTANCE.getText_EReference0();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.connector.impl.PasswordImpl <em>Password</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.connector.impl.PasswordImpl
		 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getPassword()
		 * @generated
		 */
		EClass PASSWORD = eINSTANCE.getPassword();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.connector.impl.TextAreaImpl <em>Text Area</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.connector.impl.TextAreaImpl
		 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getTextArea()
		 * @generated
		 */
		EClass TEXT_AREA = eINSTANCE.getTextArea();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.connector.impl.CheckboxImpl <em>Checkbox</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.connector.impl.CheckboxImpl
		 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getCheckbox()
		 * @generated
		 */
		EClass CHECKBOX = eINSTANCE.getCheckbox();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.connector.impl.SelectImpl <em>Select</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.connector.impl.SelectImpl
		 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getSelect()
		 * @generated
		 */
		EClass SELECT = eINSTANCE.getSelect();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECT__ITEMS = eINSTANCE.getSelect_Items();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.connector.impl.RadioGroupImpl <em>Radio Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.connector.impl.RadioGroupImpl
		 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getRadioGroup()
		 * @generated
		 */
		EClass RADIO_GROUP = eINSTANCE.getRadioGroup();

		/**
		 * The meta object literal for the '<em><b>Choices</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RADIO_GROUP__CHOICES = eINSTANCE.getRadioGroup_Choices();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.connector.impl.GroupImpl <em>Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.connector.impl.GroupImpl
		 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getGroup()
		 * @generated
		 */
		EClass GROUP = eINSTANCE.getGroup();

		/**
		 * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP__OPTIONAL = eINSTANCE.getGroup_Optional();

		/**
		 * The meta object literal for the '<em><b>Widget</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP__WIDGET = eINSTANCE.getGroup_Widget();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.connector.impl.TableImpl <em>Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.connector.impl.TableImpl
		 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getTable()
		 * @generated
		 */
		EClass TABLE = eINSTANCE.getTable();

		/**
		 * The meta object literal for the '<em><b>Cols Caption</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__COLS_CAPTION = eINSTANCE.getTable_ColsCaption();

		/**
		 * The meta object literal for the '<em><b>Cols</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE__COLS = eINSTANCE.getTable_Cols();

		/**
		 * The meta object literal for the '<em><b>Fixed Cols</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE__FIXED_COLS = eINSTANCE.getTable_FixedCols();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.connector.impl.ListImpl <em>List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.connector.impl.ListImpl
		 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getList()
		 * @generated
		 */
		EClass LIST = eINSTANCE.getList();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.connector.impl.ScriptEditorImpl <em>Script Editor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.connector.impl.ScriptEditorImpl
		 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getScriptEditor()
		 * @generated
		 */
		EClass SCRIPT_EDITOR = eINSTANCE.getScriptEditor();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.connector.impl.ItemsImpl <em>Items</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.connector.impl.ItemsImpl
		 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getItems()
		 * @generated
		 */
		EClass ITEMS = eINSTANCE.getItems();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITEMS__NAME = eINSTANCE.getItems_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITEMS__VALUE = eINSTANCE.getItems_Value();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.connector.impl.ChoicesImpl <em>Choices</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.connector.impl.ChoicesImpl
		 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getChoices()
		 * @generated
		 */
		EClass CHOICES = eINSTANCE.getChoices();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHOICES__NAME = eINSTANCE.getChoices_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHOICES__VALUE = eINSTANCE.getChoices_Value();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.connector.impl.ColsCaptionImpl <em>Cols Caption</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.connector.impl.ColsCaptionImpl
		 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getColsCaption()
		 * @generated
		 */
		EClass COLS_CAPTION = eINSTANCE.getColsCaption();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLS_CAPTION__NAME = eINSTANCE.getColsCaption_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLS_CAPTION__VALUE = eINSTANCE.getColsCaption_Value();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.connector.impl.WidgetExpressionImpl <em>Widget Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.connector.impl.WidgetExpressionImpl
		 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getWidgetExpression()
		 * @generated
		 */
		EClass WIDGET_EXPRESSION = eINSTANCE.getWidgetExpression();

		/**
		 * The meta object literal for the '<em><b>Expression Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIDGET_EXPRESSION__EXPRESSION_VALUE = eINSTANCE.getWidgetExpression_ExpressionValue();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.connector.impl.DefinitionImplImpl <em>Definition Impl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.connector.impl.DefinitionImplImpl
		 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getDefinitionImpl()
		 * @generated
		 */
		EClass DEFINITION_IMPL = eINSTANCE.getDefinitionImpl();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFINITION_IMPL__CLASS_NAME = eINSTANCE.getDefinitionImpl_ClassName();

		/**
		 * The meta object literal for the '<em><b>Package Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFINITION_IMPL__PACKAGE_NAME = eINSTANCE.getDefinitionImpl_PackageName();

		/**
		 * The meta object literal for the '<em><b>Jar Dependencies</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFINITION_IMPL__JAR_DEPENDENCIES = eINSTANCE.getDefinitionImpl_JarDependencies();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.connector.impl.JarDependenciesImpl <em>Jar Dependencies</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.connector.impl.JarDependenciesImpl
		 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getJarDependencies()
		 * @generated
		 */
		EClass JAR_DEPENDENCIES = eINSTANCE.getJarDependencies();

		/**
		 * The meta object literal for the '<em><b>Jar Dependency</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAR_DEPENDENCIES__JAR_DEPENDENCY = eINSTANCE.getJarDependencies_JarDependency();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.connector.impl.JarDependencyImpl <em>Jar Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.connector.impl.JarDependencyImpl
		 * @see org.foxbpm.model.config.connector.impl.ConnectorPackageImpl#getJarDependency()
		 * @generated
		 */
		EClass JAR_DEPENDENCY = eINSTANCE.getJarDependency();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAR_DEPENDENCY__NAME = eINSTANCE.getJarDependency_Name();

	}

} //ConnectorPackage
