/**
 */
package org.foxbpm.model.config.connector.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.foxbpm.model.config.connector.Checkbox;
import org.foxbpm.model.config.connector.Choices;
import org.foxbpm.model.config.connector.ColsCaption;
import org.foxbpm.model.config.connector.ConnectorDefinition;
import org.foxbpm.model.config.connector.ConnectorFactory;
import org.foxbpm.model.config.connector.ConnectorPackage;
import org.foxbpm.model.config.connector.DefinitionImpl;
import org.foxbpm.model.config.connector.Group;
import org.foxbpm.model.config.connector.Input;
import org.foxbpm.model.config.connector.Items;
import org.foxbpm.model.config.connector.JarDependencies;
import org.foxbpm.model.config.connector.JarDependency;
import org.foxbpm.model.config.connector.List;
import org.foxbpm.model.config.connector.Output;
import org.foxbpm.model.config.connector.Page;
import org.foxbpm.model.config.connector.Password;
import org.foxbpm.model.config.connector.RadioGroup;
import org.foxbpm.model.config.connector.ScriptEditor;
import org.foxbpm.model.config.connector.Select;
import org.foxbpm.model.config.connector.Table;
import org.foxbpm.model.config.connector.Text;
import org.foxbpm.model.config.connector.TextArea;
import org.foxbpm.model.config.connector.Widget;
import org.foxbpm.model.config.connector.WidgetExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConnectorPackageImpl extends EPackageImpl implements ConnectorPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectorDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass widgetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass passwordEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textAreaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass checkboxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass radioGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass groupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scriptEditorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass itemsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass choicesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass colsCaptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass widgetExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass definitionImplEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jarDependenciesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jarDependencyEClass = null;

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
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ConnectorPackageImpl() {
		super(eNS_URI, ConnectorFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ConnectorPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ConnectorPackage init() {
		if (isInited) return (ConnectorPackage)EPackage.Registry.INSTANCE.getEPackage(ConnectorPackage.eNS_URI);

		// Obtain or create and register package
		ConnectorPackageImpl theConnectorPackage = (ConnectorPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ConnectorPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ConnectorPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theConnectorPackage.createPackageContents();

		// Initialize created meta-data
		theConnectorPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theConnectorPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ConnectorPackage.eNS_URI, theConnectorPackage);
		return theConnectorPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectorDefinition() {
		return connectorDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectorDefinition_Id() {
		return (EAttribute)connectorDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectorDefinition_Name() {
		return (EAttribute)connectorDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectorDefinition_Note() {
		return (EAttribute)connectorDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectorDefinition_CategoryId() {
		return (EAttribute)connectorDefinitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectorDefinition_Icon() {
		return (EAttribute)connectorDefinitionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectorDefinition_Input() {
		return (EReference)connectorDefinitionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectorDefinition_Output() {
		return (EReference)connectorDefinitionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectorDefinition_Page() {
		return (EReference)connectorDefinitionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectorDefinition_Version() {
		return (EAttribute)connectorDefinitionEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectorDefinition_DefinitionImpl() {
		return (EReference)connectorDefinitionEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectorDefinition_ConnrctorType() {
		return (EAttribute)connectorDefinitionEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInput() {
		return inputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInput_Id() {
		return (EAttribute)inputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInput_Type() {
		return (EAttribute)inputEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInput_Mandatory() {
		return (EAttribute)inputEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInput_DefaultValue() {
		return (EAttribute)inputEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInput_IsExecute() {
		return (EAttribute)inputEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutput() {
		return outputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOutput_Id() {
		return (EAttribute)outputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOutput_Name() {
		return (EAttribute)outputEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOutput_Type() {
		return (EAttribute)outputEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPage() {
		return pageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPage_Id() {
		return (EAttribute)pageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPage_Name() {
		return (EAttribute)pageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPage_Note() {
		return (EAttribute)pageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPage_Widget() {
		return (EReference)pageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWidget() {
		return widgetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWidget_Id() {
		return (EAttribute)widgetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWidget_Name() {
		return (EAttribute)widgetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWidget_InputId() {
		return (EAttribute)widgetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWidget_WidgetExpression() {
		return (EReference)widgetEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getText() {
		return textEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getText_EReference0() {
		return (EReference)textEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPassword() {
		return passwordEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTextArea() {
		return textAreaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCheckbox() {
		return checkboxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSelect() {
		return selectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelect_Items() {
		return (EReference)selectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRadioGroup() {
		return radioGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRadioGroup_Choices() {
		return (EReference)radioGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGroup() {
		return groupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGroup_Optional() {
		return (EAttribute)groupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGroup_Widget() {
		return (EReference)groupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTable() {
		return tableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTable_ColsCaption() {
		return (EReference)tableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTable_Cols() {
		return (EAttribute)tableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTable_FixedCols() {
		return (EAttribute)tableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getList() {
		return listEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScriptEditor() {
		return scriptEditorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getItems() {
		return itemsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getItems_Name() {
		return (EAttribute)itemsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getItems_Value() {
		return (EAttribute)itemsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChoices() {
		return choicesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChoices_Name() {
		return (EAttribute)choicesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChoices_Value() {
		return (EAttribute)choicesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getColsCaption() {
		return colsCaptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColsCaption_Name() {
		return (EAttribute)colsCaptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColsCaption_Value() {
		return (EAttribute)colsCaptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWidgetExpression() {
		return widgetExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWidgetExpression_ExpressionValue() {
		return (EAttribute)widgetExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefinitionImpl() {
		return definitionImplEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefinitionImpl_ClassName() {
		return (EAttribute)definitionImplEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefinitionImpl_PackageName() {
		return (EAttribute)definitionImplEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefinitionImpl_JarDependencies() {
		return (EReference)definitionImplEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJarDependencies() {
		return jarDependenciesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJarDependencies_JarDependency() {
		return (EReference)jarDependenciesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJarDependency() {
		return jarDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJarDependency_Name() {
		return (EAttribute)jarDependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectorFactory getConnectorFactory() {
		return (ConnectorFactory)getEFactoryInstance();
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
		connectorDefinitionEClass = createEClass(CONNECTOR_DEFINITION);
		createEAttribute(connectorDefinitionEClass, CONNECTOR_DEFINITION__ID);
		createEAttribute(connectorDefinitionEClass, CONNECTOR_DEFINITION__NAME);
		createEAttribute(connectorDefinitionEClass, CONNECTOR_DEFINITION__NOTE);
		createEAttribute(connectorDefinitionEClass, CONNECTOR_DEFINITION__CATEGORY_ID);
		createEAttribute(connectorDefinitionEClass, CONNECTOR_DEFINITION__ICON);
		createEReference(connectorDefinitionEClass, CONNECTOR_DEFINITION__INPUT);
		createEReference(connectorDefinitionEClass, CONNECTOR_DEFINITION__OUTPUT);
		createEReference(connectorDefinitionEClass, CONNECTOR_DEFINITION__PAGE);
		createEAttribute(connectorDefinitionEClass, CONNECTOR_DEFINITION__VERSION);
		createEReference(connectorDefinitionEClass, CONNECTOR_DEFINITION__DEFINITION_IMPL);
		createEAttribute(connectorDefinitionEClass, CONNECTOR_DEFINITION__CONNRCTOR_TYPE);

		inputEClass = createEClass(INPUT);
		createEAttribute(inputEClass, INPUT__ID);
		createEAttribute(inputEClass, INPUT__TYPE);
		createEAttribute(inputEClass, INPUT__MANDATORY);
		createEAttribute(inputEClass, INPUT__DEFAULT_VALUE);
		createEAttribute(inputEClass, INPUT__IS_EXECUTE);

		outputEClass = createEClass(OUTPUT);
		createEAttribute(outputEClass, OUTPUT__ID);
		createEAttribute(outputEClass, OUTPUT__NAME);
		createEAttribute(outputEClass, OUTPUT__TYPE);

		pageEClass = createEClass(PAGE);
		createEAttribute(pageEClass, PAGE__ID);
		createEAttribute(pageEClass, PAGE__NAME);
		createEAttribute(pageEClass, PAGE__NOTE);
		createEReference(pageEClass, PAGE__WIDGET);

		widgetEClass = createEClass(WIDGET);
		createEAttribute(widgetEClass, WIDGET__ID);
		createEAttribute(widgetEClass, WIDGET__NAME);
		createEAttribute(widgetEClass, WIDGET__INPUT_ID);
		createEReference(widgetEClass, WIDGET__WIDGET_EXPRESSION);

		textEClass = createEClass(TEXT);
		createEReference(textEClass, TEXT__EREFERENCE0);

		passwordEClass = createEClass(PASSWORD);

		textAreaEClass = createEClass(TEXT_AREA);

		checkboxEClass = createEClass(CHECKBOX);

		selectEClass = createEClass(SELECT);
		createEReference(selectEClass, SELECT__ITEMS);

		radioGroupEClass = createEClass(RADIO_GROUP);
		createEReference(radioGroupEClass, RADIO_GROUP__CHOICES);

		groupEClass = createEClass(GROUP);
		createEAttribute(groupEClass, GROUP__OPTIONAL);
		createEReference(groupEClass, GROUP__WIDGET);

		tableEClass = createEClass(TABLE);
		createEReference(tableEClass, TABLE__COLS_CAPTION);
		createEAttribute(tableEClass, TABLE__COLS);
		createEAttribute(tableEClass, TABLE__FIXED_COLS);

		listEClass = createEClass(LIST);

		scriptEditorEClass = createEClass(SCRIPT_EDITOR);

		itemsEClass = createEClass(ITEMS);
		createEAttribute(itemsEClass, ITEMS__NAME);
		createEAttribute(itemsEClass, ITEMS__VALUE);

		choicesEClass = createEClass(CHOICES);
		createEAttribute(choicesEClass, CHOICES__NAME);
		createEAttribute(choicesEClass, CHOICES__VALUE);

		colsCaptionEClass = createEClass(COLS_CAPTION);
		createEAttribute(colsCaptionEClass, COLS_CAPTION__NAME);
		createEAttribute(colsCaptionEClass, COLS_CAPTION__VALUE);

		widgetExpressionEClass = createEClass(WIDGET_EXPRESSION);
		createEAttribute(widgetExpressionEClass, WIDGET_EXPRESSION__EXPRESSION_VALUE);

		definitionImplEClass = createEClass(DEFINITION_IMPL);
		createEAttribute(definitionImplEClass, DEFINITION_IMPL__CLASS_NAME);
		createEAttribute(definitionImplEClass, DEFINITION_IMPL__PACKAGE_NAME);
		createEReference(definitionImplEClass, DEFINITION_IMPL__JAR_DEPENDENCIES);

		jarDependenciesEClass = createEClass(JAR_DEPENDENCIES);
		createEReference(jarDependenciesEClass, JAR_DEPENDENCIES__JAR_DEPENDENCY);

		jarDependencyEClass = createEClass(JAR_DEPENDENCY);
		createEAttribute(jarDependencyEClass, JAR_DEPENDENCY__NAME);
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
		textEClass.getESuperTypes().add(this.getWidget());
		passwordEClass.getESuperTypes().add(this.getWidget());
		textAreaEClass.getESuperTypes().add(this.getWidget());
		checkboxEClass.getESuperTypes().add(this.getWidget());
		selectEClass.getESuperTypes().add(this.getWidget());
		radioGroupEClass.getESuperTypes().add(this.getWidget());
		groupEClass.getESuperTypes().add(this.getWidget());
		tableEClass.getESuperTypes().add(this.getWidget());
		listEClass.getESuperTypes().add(this.getWidget());
		scriptEditorEClass.getESuperTypes().add(this.getWidget());

		// Initialize classes, features, and operations; add parameters
		initEClass(connectorDefinitionEClass, ConnectorDefinition.class, "ConnectorDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConnectorDefinition_Id(), ecorePackage.getEString(), "id", null, 1, 1, ConnectorDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectorDefinition_Name(), ecorePackage.getEString(), "name", null, 0, 1, ConnectorDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectorDefinition_Note(), ecorePackage.getEString(), "note", null, 0, 1, ConnectorDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectorDefinition_CategoryId(), ecorePackage.getEString(), "categoryId", null, 0, 1, ConnectorDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectorDefinition_Icon(), ecorePackage.getEString(), "icon", null, 0, 1, ConnectorDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectorDefinition_Input(), this.getInput(), null, "input", null, 0, -1, ConnectorDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectorDefinition_Output(), this.getOutput(), null, "output", null, 0, -1, ConnectorDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectorDefinition_Page(), this.getPage(), null, "page", null, 0, -1, ConnectorDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectorDefinition_Version(), ecorePackage.getEString(), "version", null, 0, 1, ConnectorDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectorDefinition_DefinitionImpl(), this.getDefinitionImpl(), null, "definitionImpl", null, 0, 1, ConnectorDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectorDefinition_ConnrctorType(), ecorePackage.getEString(), "connrctorType", null, 0, 1, ConnectorDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputEClass, Input.class, "Input", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInput_Id(), ecorePackage.getEString(), "id", null, 1, 1, Input.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInput_Type(), ecorePackage.getEString(), "type", null, 0, 1, Input.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInput_Mandatory(), ecorePackage.getEString(), "mandatory", null, 0, 1, Input.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInput_DefaultValue(), ecorePackage.getEString(), "defaultValue", null, 0, 1, Input.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInput_IsExecute(), ecorePackage.getEString(), "isExecute", null, 0, 1, Input.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outputEClass, Output.class, "Output", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOutput_Id(), ecorePackage.getEString(), "id", null, 1, 1, Output.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOutput_Name(), ecorePackage.getEString(), "name", null, 0, 1, Output.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOutput_Type(), ecorePackage.getEString(), "type", null, 0, 1, Output.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pageEClass, Page.class, "Page", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPage_Id(), ecorePackage.getEString(), "id", null, 0, 1, Page.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPage_Name(), ecorePackage.getEString(), "name", null, 0, 1, Page.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPage_Note(), ecorePackage.getEString(), "note", null, 0, 1, Page.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPage_Widget(), this.getWidget(), null, "widget", null, 0, -1, Page.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(widgetEClass, Widget.class, "Widget", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWidget_Id(), ecorePackage.getEString(), "id", null, 0, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWidget_Name(), ecorePackage.getEString(), "name", null, 0, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWidget_InputId(), ecorePackage.getEString(), "inputId", null, 0, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWidget_WidgetExpression(), this.getWidgetExpression(), null, "widgetExpression", null, 0, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(textEClass, Text.class, "Text", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getText_EReference0(), this.getWidget(), null, "EReference0", null, 0, 1, Text.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(passwordEClass, Password.class, "Password", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(textAreaEClass, TextArea.class, "TextArea", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(checkboxEClass, Checkbox.class, "Checkbox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(selectEClass, Select.class, "Select", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSelect_Items(), this.getItems(), null, "items", null, 0, -1, Select.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(radioGroupEClass, RadioGroup.class, "RadioGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRadioGroup_Choices(), this.getChoices(), null, "choices", null, 0, -1, RadioGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(groupEClass, Group.class, "Group", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGroup_Optional(), ecorePackage.getEString(), "optional", null, 0, 1, Group.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGroup_Widget(), this.getWidget(), null, "widget", null, 0, -1, Group.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tableEClass, Table.class, "Table", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTable_ColsCaption(), this.getColsCaption(), null, "colsCaption", null, 0, -1, Table.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTable_Cols(), ecorePackage.getEInt(), "cols", null, 0, 1, Table.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTable_FixedCols(), ecorePackage.getEString(), "fixedCols", null, 0, 1, Table.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(listEClass, List.class, "List", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(scriptEditorEClass, ScriptEditor.class, "ScriptEditor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(itemsEClass, Items.class, "Items", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getItems_Name(), ecorePackage.getEString(), "name", null, 0, 1, Items.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getItems_Value(), ecorePackage.getEString(), "value", null, 0, 1, Items.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(choicesEClass, Choices.class, "Choices", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getChoices_Name(), ecorePackage.getEString(), "name", null, 0, 1, Choices.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getChoices_Value(), ecorePackage.getEString(), "value", null, 0, 1, Choices.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(colsCaptionEClass, ColsCaption.class, "ColsCaption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getColsCaption_Name(), ecorePackage.getEString(), "name", null, 0, 1, ColsCaption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColsCaption_Value(), ecorePackage.getEString(), "value", null, 0, 1, ColsCaption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(widgetExpressionEClass, WidgetExpression.class, "WidgetExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWidgetExpression_ExpressionValue(), ecorePackage.getEString(), "expressionValue", null, 0, 1, WidgetExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(definitionImplEClass, DefinitionImpl.class, "DefinitionImpl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDefinitionImpl_ClassName(), ecorePackage.getEString(), "className", null, 0, 1, DefinitionImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefinitionImpl_PackageName(), ecorePackage.getEString(), "packageName", null, 0, 1, DefinitionImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDefinitionImpl_JarDependencies(), this.getJarDependencies(), null, "jarDependencies", null, 0, 1, DefinitionImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jarDependenciesEClass, JarDependencies.class, "JarDependencies", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJarDependencies_JarDependency(), this.getJarDependency(), null, "jarDependency", null, 0, -1, JarDependencies.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jarDependencyEClass, JarDependency.class, "JarDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJarDependency_Name(), ecorePackage.getEString(), "name", null, 0, 1, JarDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		  (getConnectorDefinition_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });		
		addAnnotation
		  (getConnectorDefinition_Name(), 
		   source, 
		   new String[] {
			 "name", "name",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getConnectorDefinition_Note(), 
		   source, 
		   new String[] {
			 "name", "note",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getConnectorDefinition_CategoryId(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getConnectorDefinition_Icon(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getConnectorDefinition_Input(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getConnectorDefinition_Output(), 
		   source, 
		   new String[] {
			 "name", "output",
			 "kind", "element"
		   });		
		addAnnotation
		  (getConnectorDefinition_Page(), 
		   source, 
		   new String[] {
			 "name", "page",
			 "kind", "element"
		   });		
		addAnnotation
		  (getConnectorDefinition_Version(), 
		   source, 
		   new String[] {
			 "name", "version",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getConnectorDefinition_DefinitionImpl(), 
		   source, 
		   new String[] {
			 "name", "definitionImpl",
			 "kind", "element"
		   });		
		addAnnotation
		  (getConnectorDefinition_ConnrctorType(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (inputEClass, 
		   source, 
		   new String[] {
			 "name", "input"
		   });		
		addAnnotation
		  (getInput_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });			
		addAnnotation
		  (getInput_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });			
		addAnnotation
		  (getInput_Mandatory(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });			
		addAnnotation
		  (getInput_DefaultValue(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });			
		addAnnotation
		  (getInput_IsExecute(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (outputEClass, 
		   source, 
		   new String[] {
			 "name", "output"
		   });		
		addAnnotation
		  (getOutput_Id(), 
		   source, 
		   new String[] {
			 "name", "id",
			 "kind", "attribute"
		   });			
		addAnnotation
		  (getOutput_Name(), 
		   source, 
		   new String[] {
			 "name", "name",
			 "kind", "attribute"
		   });			
		addAnnotation
		  (getOutput_Type(), 
		   source, 
		   new String[] {
			 "name", "type",
			 "kind", "attribute"
		   });			
		addAnnotation
		  (pageEClass, 
		   source, 
		   new String[] {
			 "name", "page"
		   });		
		addAnnotation
		  (getPage_Id(), 
		   source, 
		   new String[] {
			 "name", "id",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getPage_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getPage_Note(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getPage_Widget(), 
		   source, 
		   new String[] {
			 "name", "widget",
			 "kind", "element"
		   });		
		addAnnotation
		  (widgetEClass, 
		   source, 
		   new String[] {
			 "name", "widget"
		   });		
		addAnnotation
		  (getWidget_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getWidget_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getWidget_InputId(), 
		   source, 
		   new String[] {
			 "name", "inputId",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getWidget_WidgetExpression(), 
		   source, 
		   new String[] {
			 "name", "widgetExpression",
			 "kind", "element"
		   });		
		addAnnotation
		  (textEClass, 
		   source, 
		   new String[] {
			 "name", "text"
		   });		
		addAnnotation
		  (passwordEClass, 
		   source, 
		   new String[] {
			 "name", "password"
		   });		
		addAnnotation
		  (textAreaEClass, 
		   source, 
		   new String[] {
			 "name", "textArea"
		   });		
		addAnnotation
		  (checkboxEClass, 
		   source, 
		   new String[] {
			 "name", "checkbox"
		   });		
		addAnnotation
		  (selectEClass, 
		   source, 
		   new String[] {
			 "name", "select"
		   });		
		addAnnotation
		  (getSelect_Items(), 
		   source, 
		   new String[] {
			 "name", "items",
			 "kind", "element"
		   });		
		addAnnotation
		  (radioGroupEClass, 
		   source, 
		   new String[] {
			 "name", "radioGroup"
		   });		
		addAnnotation
		  (getRadioGroup_Choices(), 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "element",
			 "wildcards", ""
		   });		
		addAnnotation
		  (groupEClass, 
		   source, 
		   new String[] {
			 "name", "group"
		   });		
		addAnnotation
		  (getGroup_Optional(), 
		   source, 
		   new String[] {
			 "name", "optional",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getGroup_Widget(), 
		   source, 
		   new String[] {
			 "name", "widget",
			 "kind", "element"
		   });		
		addAnnotation
		  (tableEClass, 
		   source, 
		   new String[] {
			 "name", "table"
		   });		
		addAnnotation
		  (getTable_ColsCaption(), 
		   source, 
		   new String[] {
			 "name", "colsCaption",
			 "kind", "element"
		   });		
		addAnnotation
		  (getTable_Cols(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getTable_FixedCols(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (listEClass, 
		   source, 
		   new String[] {
			 "name", "list"
		   });		
		addAnnotation
		  (scriptEditorEClass, 
		   source, 
		   new String[] {
			 "name", "scriptEditor"
		   });		
		addAnnotation
		  (itemsEClass, 
		   source, 
		   new String[] {
			 "name", "items"
		   });		
		addAnnotation
		  (getItems_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getItems_Value(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (choicesEClass, 
		   source, 
		   new String[] {
			 "name", "choices"
		   });		
		addAnnotation
		  (getChoices_Name(), 
		   source, 
		   new String[] {
			 "name", "name",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getChoices_Value(), 
		   source, 
		   new String[] {
			 "name", "value",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (colsCaptionEClass, 
		   source, 
		   new String[] {
			 "name", "colsCaption"
		   });		
		addAnnotation
		  (getColsCaption_Name(), 
		   source, 
		   new String[] {
			 "name", "name",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getColsCaption_Value(), 
		   source, 
		   new String[] {
			 "name", "value",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (widgetExpressionEClass, 
		   source, 
		   new String[] {
			 "name", "widgetExpression"
		   });		
		addAnnotation
		  (getWidgetExpression_ExpressionValue(), 
		   source, 
		   new String[] {
			 "name", "expressionValue",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (definitionImplEClass, 
		   source, 
		   new String[] {
			 "name", "definitionImpl"
		   });		
		addAnnotation
		  (getDefinitionImpl_ClassName(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDefinitionImpl_PackageName(), 
		   source, 
		   new String[] {
			 "name", "packageName",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDefinitionImpl_JarDependencies(), 
		   source, 
		   new String[] {
			 "name", "jarDependencies",
			 "kind", "element"
		   });		
		addAnnotation
		  (jarDependenciesEClass, 
		   source, 
		   new String[] {
			 "name", "jarDependencies"
		   });		
		addAnnotation
		  (getJarDependencies_JarDependency(), 
		   source, 
		   new String[] {
			 "name", "jarDependency",
			 "kind", "element"
		   });		
		addAnnotation
		  (jarDependencyEClass, 
		   source, 
		   new String[] {
			 "name", "jarDependency"
		   });		
		addAnnotation
		  (getJarDependency_Name(), 
		   source, 
		   new String[] {
			 "name", "name",
			 "kind", "attribute"
		   });
	}

} //ConnectorPackageImpl
