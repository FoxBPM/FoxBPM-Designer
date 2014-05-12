/**
 */
package org.foxbpm.model.config.connector.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.foxbpm.model.config.connector.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConnectorFactoryImpl extends EFactoryImpl implements ConnectorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConnectorFactory init() {
		try {
			ConnectorFactory theConnectorFactory = (ConnectorFactory)EPackage.Registry.INSTANCE.getEFactory(ConnectorPackage.eNS_URI);
			if (theConnectorFactory != null) {
				return theConnectorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ConnectorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectorFactoryImpl() {
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
			case ConnectorPackage.CONNECTOR_DEFINITION: return createConnectorDefinition();
			case ConnectorPackage.INPUT: return createInput();
			case ConnectorPackage.OUTPUT: return createOutput();
			case ConnectorPackage.PAGE: return createPage();
			case ConnectorPackage.TEXT: return createText();
			case ConnectorPackage.PASSWORD: return createPassword();
			case ConnectorPackage.TEXT_AREA: return createTextArea();
			case ConnectorPackage.CHECKBOX: return createCheckbox();
			case ConnectorPackage.SELECT: return createSelect();
			case ConnectorPackage.RADIO_GROUP: return createRadioGroup();
			case ConnectorPackage.GROUP: return createGroup();
			case ConnectorPackage.TABLE: return createTable();
			case ConnectorPackage.LIST: return createList();
			case ConnectorPackage.SCRIPT_EDITOR: return createScriptEditor();
			case ConnectorPackage.ITEMS: return createItems();
			case ConnectorPackage.CHOICES: return createChoices();
			case ConnectorPackage.COLS_CAPTION: return createColsCaption();
			case ConnectorPackage.WIDGET_EXPRESSION: return createWidgetExpression();
			case ConnectorPackage.DEFINITION_IMPL: return createDefinitionImpl();
			case ConnectorPackage.JAR_DEPENDENCIES: return createJarDependencies();
			case ConnectorPackage.JAR_DEPENDENCY: return createJarDependency();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectorDefinition createConnectorDefinition() {
		ConnectorDefinitionImpl connectorDefinition = new ConnectorDefinitionImpl();
		return connectorDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Input createInput() {
		InputImpl input = new InputImpl();
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Output createOutput() {
		OutputImpl output = new OutputImpl();
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Page createPage() {
		PageImpl page = new PageImpl();
		return page;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Text createText() {
		TextImpl text = new TextImpl();
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Password createPassword() {
		PasswordImpl password = new PasswordImpl();
		return password;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextArea createTextArea() {
		TextAreaImpl textArea = new TextAreaImpl();
		return textArea;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Checkbox createCheckbox() {
		CheckboxImpl checkbox = new CheckboxImpl();
		return checkbox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Select createSelect() {
		SelectImpl select = new SelectImpl();
		return select;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RadioGroup createRadioGroup() {
		RadioGroupImpl radioGroup = new RadioGroupImpl();
		return radioGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Group createGroup() {
		GroupImpl group = new GroupImpl();
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table createTable() {
		TableImpl table = new TableImpl();
		return table;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List createList() {
		ListImpl list = new ListImpl();
		return list;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptEditor createScriptEditor() {
		ScriptEditorImpl scriptEditor = new ScriptEditorImpl();
		return scriptEditor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Items createItems() {
		ItemsImpl items = new ItemsImpl();
		return items;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Choices createChoices() {
		ChoicesImpl choices = new ChoicesImpl();
		return choices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColsCaption createColsCaption() {
		ColsCaptionImpl colsCaption = new ColsCaptionImpl();
		return colsCaption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WidgetExpression createWidgetExpression() {
		WidgetExpressionImpl widgetExpression = new WidgetExpressionImpl();
		return widgetExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefinitionImpl createDefinitionImpl() {
		DefinitionImplImpl definitionImpl = new DefinitionImplImpl();
		return definitionImpl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JarDependencies createJarDependencies() {
		JarDependenciesImpl jarDependencies = new JarDependenciesImpl();
		return jarDependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JarDependency createJarDependency() {
		JarDependencyImpl jarDependency = new JarDependencyImpl();
		return jarDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectorPackage getConnectorPackage() {
		return (ConnectorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ConnectorPackage getPackage() {
		return ConnectorPackage.eINSTANCE;
	}

} //ConnectorFactoryImpl
