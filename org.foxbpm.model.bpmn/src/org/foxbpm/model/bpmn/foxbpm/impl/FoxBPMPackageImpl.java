/**
 */
package org.foxbpm.model.bpmn.foxbpm.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.foxbpm.model.bpmn.foxbpm.AssignPolicyType;
import org.foxbpm.model.bpmn.foxbpm.CompleteTaskDescription;
import org.foxbpm.model.bpmn.foxbpm.ConnectorInstance;
import org.foxbpm.model.bpmn.foxbpm.ConnectorInstanceElements;
import org.foxbpm.model.bpmn.foxbpm.ConnectorParameterInput;
import org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutput;
import org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutputDef;
import org.foxbpm.model.bpmn.foxbpm.DataSourceToSubProcessMapping;
import org.foxbpm.model.bpmn.foxbpm.DataVariable;
import org.foxbpm.model.bpmn.foxbpm.DataVariableMapping;
import org.foxbpm.model.bpmn.foxbpm.DocumentRoot;
import org.foxbpm.model.bpmn.foxbpm.Documentation;
import org.foxbpm.model.bpmn.foxbpm.ExpectedExecutionTime;
import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FilterConditions;
import org.foxbpm.model.bpmn.foxbpm.FormParam;
import org.foxbpm.model.bpmn.foxbpm.FormParamContainer;
import org.foxbpm.model.bpmn.foxbpm.FormUri;
import org.foxbpm.model.bpmn.foxbpm.FormUriView;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;
import org.foxbpm.model.bpmn.foxbpm.ListExpression;
import org.foxbpm.model.bpmn.foxbpm.LoopDataInputCollection;
import org.foxbpm.model.bpmn.foxbpm.LoopDataOutputCollection;
import org.foxbpm.model.bpmn.foxbpm.LoopMaximum;
import org.foxbpm.model.bpmn.foxbpm.MessageObj;
import org.foxbpm.model.bpmn.foxbpm.ProcessInstanceVariable;
import org.foxbpm.model.bpmn.foxbpm.ProcessValidationLevel;
import org.foxbpm.model.bpmn.foxbpm.ReceiveMessage;
import org.foxbpm.model.bpmn.foxbpm.ResourceFilter;
import org.foxbpm.model.bpmn.foxbpm.SkipAssignee;
import org.foxbpm.model.bpmn.foxbpm.SkipComment;
import org.foxbpm.model.bpmn.foxbpm.SkipStrategy;
import org.foxbpm.model.bpmn.foxbpm.SubProcessToDataSourceMapping;
import org.foxbpm.model.bpmn.foxbpm.TableExpression;
import org.foxbpm.model.bpmn.foxbpm.TaskCommand;
import org.foxbpm.model.bpmn.foxbpm.TaskDescription;
import org.foxbpm.model.bpmn.foxbpm.TaskPriority;
import org.foxbpm.model.bpmn.foxbpm.TaskSubject;
import org.foxbpm.model.bpmn.foxbpm.TimeExpression;
import org.foxbpm.model.bpmn.foxbpm.TimeSkipExpression;
import org.foxbpm.model.bpmn.foxbpm.TokenVariable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FoxBPMPackageImpl extends EPackageImpl implements FoxBPMPackage {
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
	private EClass expressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskSubjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskCommandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceFilterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectorInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectorParameterInputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectorParameterOutputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopDataInputCollectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopDataOutputCollectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectorParameterOutputDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass formUriEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopMaximumEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass skipStrategyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageObjEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass filterConditionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass receiveMessageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tokenVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processInstanceVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expectedExecutionTimeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataSourceToSubProcessMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subProcessToDataSourceMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataVariableMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass formUriViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskPriorityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignPolicyTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass skipAssigneeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass skipCommentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectorInstanceElementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timeExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timeSkipExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tableExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass completeTaskDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass formParamContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass formParamEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum processValidationLevelEEnum = null;

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
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FoxBPMPackageImpl() {
		super(eNS_URI, FoxBPMFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link FoxBPMPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FoxBPMPackage init() {
		if (isInited) return (FoxBPMPackage)EPackage.Registry.INSTANCE.getEPackage(FoxBPMPackage.eNS_URI);

		// Obtain or create and register package
		FoxBPMPackageImpl theFoxBPMPackage = (FoxBPMPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FoxBPMPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FoxBPMPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theFoxBPMPackage.createPackageContents();

		// Initialize created meta-data
		theFoxBPMPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFoxBPMPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FoxBPMPackage.eNS_URI, theFoxBPMPackage);
		return theFoxBPMPackage;
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
	public EReference getDocumentRoot_TaskSubject() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_TaskCommand() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_ResourceType() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ResourceFilter() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_DataVariable() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Version() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Dbid() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Category() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ConnectorInstance() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_LoopDataInputCollection() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_LoopDataOutputCollection() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_FormUri() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_LoopMaximum() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_SubTask() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_ScriptName() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_ResultVariable() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_CallableElementId() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_CallableElementName() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_CallableElementVersion() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_CallableElementVersionName() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_IncludeExclusion() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_ResourceRange() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_AssignAction() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_ErrorCode() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_SkipStrategy() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_IsContainsSub() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Verification() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_MessageObj() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ReceiveMessage() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ExpectedExecutionTime() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_DataSourceToSubProcessMapping() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_SubProcessToDataSourceMapping() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_CallableElementBizKey() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_CallableElementBizKeyName() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_IsAsync() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_FormUriView() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_OrderId() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_TaskPriority() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_AssignPolicyType() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_IsPersistence() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_TaskType() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_ValidationLevel() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_LanguageType() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ConnectorInstanceElements() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Name() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(47);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_IsCreateRecord() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(48);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_IsAutoClaim() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(49);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_TaskDescription() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(50);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_CompleteTaskDescription() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(51);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_FormParamContainer() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(52);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpression() {
		return expressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpression_Value() {
		return (EAttribute)expressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpression_Id() {
		return (EAttribute)expressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpression_Name() {
		return (EAttribute)expressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTaskSubject() {
		return taskSubjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTaskSubject_Expression() {
		return (EReference)taskSubjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskSubject_Id() {
		return (EAttribute)taskSubjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskSubject_Name() {
		return (EAttribute)taskSubjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTaskCommand() {
		return taskCommandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskCommand_Id() {
		return (EAttribute)taskCommandEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskCommand_Name() {
		return (EAttribute)taskCommandEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskCommand_CommandType() {
		return (EAttribute)taskCommandEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTaskCommand_Expression() {
		return (EReference)taskCommandEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskCommand_OrderId() {
		return (EAttribute)taskCommandEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskCommand_IsVerification() {
		return (EAttribute)taskCommandEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskCommand_IsSaveData() {
		return (EAttribute)taskCommandEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskCommand_IsSimulationRun() {
		return (EAttribute)taskCommandEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTaskCommand_ParameterExpression() {
		return (EReference)taskCommandEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceFilter() {
		return resourceFilterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceFilter_Id() {
		return (EAttribute)resourceFilterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceFilter_Name() {
		return (EAttribute)resourceFilterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceFilter_Expression() {
		return (EReference)resourceFilterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceFilter_Documentation() {
		return (EReference)resourceFilterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataVariable() {
		return dataVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataVariable_Id() {
		return (EAttribute)dataVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataVariable_DataType() {
		return (EAttribute)dataVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataVariable_IsList() {
		return (EAttribute)dataVariableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataVariable_IsPersistence() {
		return (EAttribute)dataVariableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataVariable_Expression() {
		return (EReference)dataVariableEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataVariable_Documentation() {
		return (EReference)dataVariableEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataVariable_BizType() {
		return (EAttribute)dataVariableEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataVariable_FileName() {
		return (EAttribute)dataVariableEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentation() {
		return documentationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentation_Value() {
		return (EAttribute)documentationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentation_Id() {
		return (EAttribute)documentationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentation_Name() {
		return (EAttribute)documentationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectorInstance() {
		return connectorInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectorInstance_ConnectorId() {
		return (EAttribute)connectorInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectorInstance_PackageName() {
		return (EAttribute)connectorInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectorInstance_ClassName() {
		return (EAttribute)connectorInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectorInstance_ConnectorInstanceId() {
		return (EAttribute)connectorInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectorInstance_ConnectorInstanceName() {
		return (EAttribute)connectorInstanceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectorInstance_EventType() {
		return (EAttribute)connectorInstanceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectorInstance_Documentation() {
		return (EReference)connectorInstanceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectorInstance_ErrorHandling() {
		return (EAttribute)connectorInstanceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectorInstance_ErrorCode() {
		return (EAttribute)connectorInstanceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectorInstance_ConnectorParameterInputs() {
		return (EReference)connectorInstanceEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectorInstance_ConnectorParameterOutputs() {
		return (EReference)connectorInstanceEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectorInstance_ConnectorParameterOutputsDef() {
		return (EReference)connectorInstanceEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectorInstance_SkipComment() {
		return (EReference)connectorInstanceEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectorInstance_TimeExpression() {
		return (EReference)connectorInstanceEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectorInstance_IsTimeExecute() {
		return (EAttribute)connectorInstanceEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectorInstance_TimeSkipExpression() {
		return (EReference)connectorInstanceEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectorInstance_Version() {
		return (EAttribute)connectorInstanceEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectorInstance_Type() {
		return (EAttribute)connectorInstanceEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectorParameterInput() {
		return connectorParameterInputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectorParameterInput_Id() {
		return (EAttribute)connectorParameterInputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectorParameterInput_Name() {
		return (EAttribute)connectorParameterInputEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectorParameterInput_DataType() {
		return (EAttribute)connectorParameterInputEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectorParameterInput_Expression() {
		return (EReference)connectorParameterInputEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectorParameterInput_IsExecute() {
		return (EAttribute)connectorParameterInputEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectorParameterOutput() {
		return connectorParameterOutputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectorParameterOutput_VariableTarget() {
		return (EAttribute)connectorParameterOutputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectorParameterOutput_Expression() {
		return (EReference)connectorParameterOutputEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectorParameterOutput_OutputId() {
		return (EAttribute)connectorParameterOutputEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoopDataInputCollection() {
		return loopDataInputCollectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopDataInputCollection_Expression() {
		return (EReference)loopDataInputCollectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoopDataOutputCollection() {
		return loopDataOutputCollectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopDataOutputCollection_Expression() {
		return (EReference)loopDataOutputCollectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectorParameterOutputDef() {
		return connectorParameterOutputDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectorParameterOutputDef_Id() {
		return (EAttribute)connectorParameterOutputDefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectorParameterOutputDef_Name() {
		return (EAttribute)connectorParameterOutputDefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectorParameterOutputDef_DataType() {
		return (EAttribute)connectorParameterOutputDefEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFormUri() {
		return formUriEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFormUri_Expression() {
		return (EReference)formUriEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoopMaximum() {
		return loopMaximumEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopMaximum_Expression() {
		return (EReference)loopMaximumEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSkipStrategy() {
		return skipStrategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSkipStrategy_Expression() {
		return (EReference)skipStrategyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSkipStrategy_IsCreateSkipProcess() {
		return (EAttribute)skipStrategyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSkipStrategy_SkipAssignee() {
		return (EReference)skipStrategyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSkipStrategy_SkipComment() {
		return (EReference)skipStrategyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSkipStrategy_IsEnable() {
		return (EAttribute)skipStrategyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessageObj() {
		return messageObjEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageObj_Id() {
		return (EAttribute)messageObjEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageObj_Name() {
		return (EAttribute)messageObjEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageObj_Documentation() {
		return (EReference)messageObjEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageObj_DataVariable() {
		return (EReference)messageObjEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageObj_TargetProcess() {
		return (EAttribute)messageObjEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageObj_TargetNode() {
		return (EAttribute)messageObjEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageObj_ProcessInstanceVariable() {
		return (EReference)messageObjEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageObj_TokenVariable() {
		return (EReference)messageObjEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageObj_MessageType() {
		return (EAttribute)messageObjEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFilterConditions() {
		return filterConditionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFilterConditions_Expression() {
		return (EReference)filterConditionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReceiveMessage() {
		return receiveMessageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReceiveMessage_MessageId() {
		return (EAttribute)receiveMessageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReceiveMessage_FilterConditions() {
		return (EReference)receiveMessageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReceiveMessage_ProcessInstanceVariable() {
		return (EReference)receiveMessageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReceiveMessage_TokenVariable() {
		return (EReference)receiveMessageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTokenVariable() {
		return tokenVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTokenVariable_Expression() {
		return (EReference)tokenVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessInstanceVariable() {
		return processInstanceVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessInstanceVariable_Expression() {
		return (EReference)processInstanceVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpectedExecutionTime() {
		return expectedExecutionTimeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpectedExecutionTime_Day() {
		return (EAttribute)expectedExecutionTimeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpectedExecutionTime_Hour() {
		return (EAttribute)expectedExecutionTimeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpectedExecutionTime_Minute() {
		return (EAttribute)expectedExecutionTimeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpectedExecutionTime_Second() {
		return (EAttribute)expectedExecutionTimeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataSourceToSubProcessMapping() {
		return dataSourceToSubProcessMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataSourceToSubProcessMapping_DataVariableMapping() {
		return (EReference)dataSourceToSubProcessMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubProcessToDataSourceMapping() {
		return subProcessToDataSourceMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubProcessToDataSourceMapping_DataVariableMapping() {
		return (EReference)subProcessToDataSourceMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataVariableMapping() {
		return dataVariableMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataVariableMapping_DataSourceId() {
		return (EAttribute)dataVariableMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataVariableMapping_SubProcesId() {
		return (EAttribute)dataVariableMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFormUriView() {
		return formUriViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFormUriView_Expression() {
		return (EReference)formUriViewEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTaskPriority() {
		return taskPriorityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTaskPriority_Expression() {
		return (EReference)taskPriorityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssignPolicyType() {
		return assignPolicyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignPolicyType_Id() {
		return (EAttribute)assignPolicyTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignPolicyType_Expression() {
		return (EReference)assignPolicyTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSkipAssignee() {
		return skipAssigneeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSkipAssignee_Expression() {
		return (EReference)skipAssigneeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSkipComment() {
		return skipCommentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSkipComment_Expression() {
		return (EReference)skipCommentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectorInstanceElements() {
		return connectorInstanceElementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectorInstanceElements_ConnrctorType() {
		return (EAttribute)connectorInstanceElementsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectorInstanceElements_ConnectorInstance() {
		return (EReference)connectorInstanceElementsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimeExpression() {
		return timeExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimeExpression_Expression() {
		return (EReference)timeExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimeSkipExpression() {
		return timeSkipExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimeSkipExpression_Expression() {
		return (EReference)timeSkipExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTableExpression() {
		return tableExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTableExpression_Expressions() {
		return (EReference)tableExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListExpression() {
		return listExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getListExpression_Expressions() {
		return (EReference)listExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTaskDescription() {
		return taskDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTaskDescription_Expression() {
		return (EReference)taskDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompleteTaskDescription() {
		return completeTaskDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompleteTaskDescription_Expression() {
		return (EReference)completeTaskDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFormParamContainer() {
		return formParamContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFormParamContainer_FormParam() {
		return (EReference)formParamContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFormParam() {
		return formParamEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormParam_ParamKey() {
		return (EAttribute)formParamEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormParam_ParamType() {
		return (EAttribute)formParamEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFormParam_Expression() {
		return (EReference)formParamEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getProcessValidationLevel() {
		return processValidationLevelEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FoxBPMFactory getFoxBPMFactory() {
		return (FoxBPMFactory)getEFactoryInstance();
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
		createEReference(documentRootEClass, DOCUMENT_ROOT__TASK_SUBJECT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__TASK_COMMAND);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__RESOURCE_TYPE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__RESOURCE_FILTER);
		createEReference(documentRootEClass, DOCUMENT_ROOT__DATA_VARIABLE);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__VERSION);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__DBID);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__CATEGORY);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CONNECTOR_INSTANCE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__LOOP_DATA_INPUT_COLLECTION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__LOOP_DATA_OUTPUT_COLLECTION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__FORM_URI);
		createEReference(documentRootEClass, DOCUMENT_ROOT__LOOP_MAXIMUM);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__SUB_TASK);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__SCRIPT_NAME);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__RESULT_VARIABLE);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__CALLABLE_ELEMENT_ID);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__CALLABLE_ELEMENT_NAME);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__CALLABLE_ELEMENT_VERSION);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__CALLABLE_ELEMENT_VERSION_NAME);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__INCLUDE_EXCLUSION);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__RESOURCE_RANGE);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__ASSIGN_ACTION);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__ERROR_CODE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SKIP_STRATEGY);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__IS_CONTAINS_SUB);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__VERIFICATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__MESSAGE_OBJ);
		createEReference(documentRootEClass, DOCUMENT_ROOT__RECEIVE_MESSAGE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__EXPECTED_EXECUTION_TIME);
		createEReference(documentRootEClass, DOCUMENT_ROOT__DATA_SOURCE_TO_SUB_PROCESS_MAPPING);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SUB_PROCESS_TO_DATA_SOURCE_MAPPING);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__CALLABLE_ELEMENT_BIZ_KEY);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__CALLABLE_ELEMENT_BIZ_KEY_NAME);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__IS_ASYNC);
		createEReference(documentRootEClass, DOCUMENT_ROOT__FORM_URI_VIEW);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__ORDER_ID);
		createEReference(documentRootEClass, DOCUMENT_ROOT__TASK_PRIORITY);
		createEReference(documentRootEClass, DOCUMENT_ROOT__ASSIGN_POLICY_TYPE);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__IS_PERSISTENCE);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__TASK_TYPE);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__VALIDATION_LEVEL);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__LANGUAGE_TYPE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CONNECTOR_INSTANCE_ELEMENTS);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__NAME);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__IS_CREATE_RECORD);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__IS_AUTO_CLAIM);
		createEReference(documentRootEClass, DOCUMENT_ROOT__TASK_DESCRIPTION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__COMPLETE_TASK_DESCRIPTION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__FORM_PARAM_CONTAINER);

		expressionEClass = createEClass(EXPRESSION);
		createEAttribute(expressionEClass, EXPRESSION__VALUE);
		createEAttribute(expressionEClass, EXPRESSION__ID);
		createEAttribute(expressionEClass, EXPRESSION__NAME);

		taskSubjectEClass = createEClass(TASK_SUBJECT);
		createEReference(taskSubjectEClass, TASK_SUBJECT__EXPRESSION);
		createEAttribute(taskSubjectEClass, TASK_SUBJECT__ID);
		createEAttribute(taskSubjectEClass, TASK_SUBJECT__NAME);

		taskCommandEClass = createEClass(TASK_COMMAND);
		createEAttribute(taskCommandEClass, TASK_COMMAND__ID);
		createEAttribute(taskCommandEClass, TASK_COMMAND__NAME);
		createEAttribute(taskCommandEClass, TASK_COMMAND__COMMAND_TYPE);
		createEReference(taskCommandEClass, TASK_COMMAND__EXPRESSION);
		createEAttribute(taskCommandEClass, TASK_COMMAND__ORDER_ID);
		createEAttribute(taskCommandEClass, TASK_COMMAND__IS_VERIFICATION);
		createEAttribute(taskCommandEClass, TASK_COMMAND__IS_SAVE_DATA);
		createEAttribute(taskCommandEClass, TASK_COMMAND__IS_SIMULATION_RUN);
		createEReference(taskCommandEClass, TASK_COMMAND__PARAMETER_EXPRESSION);

		resourceFilterEClass = createEClass(RESOURCE_FILTER);
		createEAttribute(resourceFilterEClass, RESOURCE_FILTER__ID);
		createEAttribute(resourceFilterEClass, RESOURCE_FILTER__NAME);
		createEReference(resourceFilterEClass, RESOURCE_FILTER__EXPRESSION);
		createEReference(resourceFilterEClass, RESOURCE_FILTER__DOCUMENTATION);

		dataVariableEClass = createEClass(DATA_VARIABLE);
		createEAttribute(dataVariableEClass, DATA_VARIABLE__ID);
		createEAttribute(dataVariableEClass, DATA_VARIABLE__DATA_TYPE);
		createEAttribute(dataVariableEClass, DATA_VARIABLE__IS_LIST);
		createEAttribute(dataVariableEClass, DATA_VARIABLE__IS_PERSISTENCE);
		createEReference(dataVariableEClass, DATA_VARIABLE__EXPRESSION);
		createEReference(dataVariableEClass, DATA_VARIABLE__DOCUMENTATION);
		createEAttribute(dataVariableEClass, DATA_VARIABLE__BIZ_TYPE);
		createEAttribute(dataVariableEClass, DATA_VARIABLE__FILE_NAME);

		documentationEClass = createEClass(DOCUMENTATION);
		createEAttribute(documentationEClass, DOCUMENTATION__VALUE);
		createEAttribute(documentationEClass, DOCUMENTATION__ID);
		createEAttribute(documentationEClass, DOCUMENTATION__NAME);

		connectorInstanceEClass = createEClass(CONNECTOR_INSTANCE);
		createEAttribute(connectorInstanceEClass, CONNECTOR_INSTANCE__CONNECTOR_ID);
		createEAttribute(connectorInstanceEClass, CONNECTOR_INSTANCE__PACKAGE_NAME);
		createEAttribute(connectorInstanceEClass, CONNECTOR_INSTANCE__CLASS_NAME);
		createEAttribute(connectorInstanceEClass, CONNECTOR_INSTANCE__CONNECTOR_INSTANCE_ID);
		createEAttribute(connectorInstanceEClass, CONNECTOR_INSTANCE__CONNECTOR_INSTANCE_NAME);
		createEAttribute(connectorInstanceEClass, CONNECTOR_INSTANCE__EVENT_TYPE);
		createEReference(connectorInstanceEClass, CONNECTOR_INSTANCE__DOCUMENTATION);
		createEAttribute(connectorInstanceEClass, CONNECTOR_INSTANCE__ERROR_HANDLING);
		createEAttribute(connectorInstanceEClass, CONNECTOR_INSTANCE__ERROR_CODE);
		createEReference(connectorInstanceEClass, CONNECTOR_INSTANCE__CONNECTOR_PARAMETER_INPUTS);
		createEReference(connectorInstanceEClass, CONNECTOR_INSTANCE__CONNECTOR_PARAMETER_OUTPUTS);
		createEReference(connectorInstanceEClass, CONNECTOR_INSTANCE__CONNECTOR_PARAMETER_OUTPUTS_DEF);
		createEReference(connectorInstanceEClass, CONNECTOR_INSTANCE__SKIP_COMMENT);
		createEReference(connectorInstanceEClass, CONNECTOR_INSTANCE__TIME_EXPRESSION);
		createEAttribute(connectorInstanceEClass, CONNECTOR_INSTANCE__IS_TIME_EXECUTE);
		createEReference(connectorInstanceEClass, CONNECTOR_INSTANCE__TIME_SKIP_EXPRESSION);
		createEAttribute(connectorInstanceEClass, CONNECTOR_INSTANCE__VERSION);
		createEAttribute(connectorInstanceEClass, CONNECTOR_INSTANCE__TYPE);

		connectorParameterInputEClass = createEClass(CONNECTOR_PARAMETER_INPUT);
		createEAttribute(connectorParameterInputEClass, CONNECTOR_PARAMETER_INPUT__ID);
		createEAttribute(connectorParameterInputEClass, CONNECTOR_PARAMETER_INPUT__NAME);
		createEAttribute(connectorParameterInputEClass, CONNECTOR_PARAMETER_INPUT__DATA_TYPE);
		createEReference(connectorParameterInputEClass, CONNECTOR_PARAMETER_INPUT__EXPRESSION);
		createEAttribute(connectorParameterInputEClass, CONNECTOR_PARAMETER_INPUT__IS_EXECUTE);

		connectorParameterOutputEClass = createEClass(CONNECTOR_PARAMETER_OUTPUT);
		createEAttribute(connectorParameterOutputEClass, CONNECTOR_PARAMETER_OUTPUT__VARIABLE_TARGET);
		createEReference(connectorParameterOutputEClass, CONNECTOR_PARAMETER_OUTPUT__EXPRESSION);
		createEAttribute(connectorParameterOutputEClass, CONNECTOR_PARAMETER_OUTPUT__OUTPUT_ID);

		loopDataInputCollectionEClass = createEClass(LOOP_DATA_INPUT_COLLECTION);
		createEReference(loopDataInputCollectionEClass, LOOP_DATA_INPUT_COLLECTION__EXPRESSION);

		loopDataOutputCollectionEClass = createEClass(LOOP_DATA_OUTPUT_COLLECTION);
		createEReference(loopDataOutputCollectionEClass, LOOP_DATA_OUTPUT_COLLECTION__EXPRESSION);

		connectorParameterOutputDefEClass = createEClass(CONNECTOR_PARAMETER_OUTPUT_DEF);
		createEAttribute(connectorParameterOutputDefEClass, CONNECTOR_PARAMETER_OUTPUT_DEF__ID);
		createEAttribute(connectorParameterOutputDefEClass, CONNECTOR_PARAMETER_OUTPUT_DEF__NAME);
		createEAttribute(connectorParameterOutputDefEClass, CONNECTOR_PARAMETER_OUTPUT_DEF__DATA_TYPE);

		formUriEClass = createEClass(FORM_URI);
		createEReference(formUriEClass, FORM_URI__EXPRESSION);

		loopMaximumEClass = createEClass(LOOP_MAXIMUM);
		createEReference(loopMaximumEClass, LOOP_MAXIMUM__EXPRESSION);

		skipStrategyEClass = createEClass(SKIP_STRATEGY);
		createEReference(skipStrategyEClass, SKIP_STRATEGY__EXPRESSION);
		createEAttribute(skipStrategyEClass, SKIP_STRATEGY__IS_CREATE_SKIP_PROCESS);
		createEReference(skipStrategyEClass, SKIP_STRATEGY__SKIP_ASSIGNEE);
		createEReference(skipStrategyEClass, SKIP_STRATEGY__SKIP_COMMENT);
		createEAttribute(skipStrategyEClass, SKIP_STRATEGY__IS_ENABLE);

		messageObjEClass = createEClass(MESSAGE_OBJ);
		createEAttribute(messageObjEClass, MESSAGE_OBJ__ID);
		createEAttribute(messageObjEClass, MESSAGE_OBJ__NAME);
		createEReference(messageObjEClass, MESSAGE_OBJ__DOCUMENTATION);
		createEReference(messageObjEClass, MESSAGE_OBJ__DATA_VARIABLE);
		createEAttribute(messageObjEClass, MESSAGE_OBJ__TARGET_PROCESS);
		createEAttribute(messageObjEClass, MESSAGE_OBJ__TARGET_NODE);
		createEReference(messageObjEClass, MESSAGE_OBJ__PROCESS_INSTANCE_VARIABLE);
		createEReference(messageObjEClass, MESSAGE_OBJ__TOKEN_VARIABLE);
		createEAttribute(messageObjEClass, MESSAGE_OBJ__MESSAGE_TYPE);

		filterConditionsEClass = createEClass(FILTER_CONDITIONS);
		createEReference(filterConditionsEClass, FILTER_CONDITIONS__EXPRESSION);

		receiveMessageEClass = createEClass(RECEIVE_MESSAGE);
		createEAttribute(receiveMessageEClass, RECEIVE_MESSAGE__MESSAGE_ID);
		createEReference(receiveMessageEClass, RECEIVE_MESSAGE__FILTER_CONDITIONS);
		createEReference(receiveMessageEClass, RECEIVE_MESSAGE__PROCESS_INSTANCE_VARIABLE);
		createEReference(receiveMessageEClass, RECEIVE_MESSAGE__TOKEN_VARIABLE);

		tokenVariableEClass = createEClass(TOKEN_VARIABLE);
		createEReference(tokenVariableEClass, TOKEN_VARIABLE__EXPRESSION);

		processInstanceVariableEClass = createEClass(PROCESS_INSTANCE_VARIABLE);
		createEReference(processInstanceVariableEClass, PROCESS_INSTANCE_VARIABLE__EXPRESSION);

		expectedExecutionTimeEClass = createEClass(EXPECTED_EXECUTION_TIME);
		createEAttribute(expectedExecutionTimeEClass, EXPECTED_EXECUTION_TIME__DAY);
		createEAttribute(expectedExecutionTimeEClass, EXPECTED_EXECUTION_TIME__HOUR);
		createEAttribute(expectedExecutionTimeEClass, EXPECTED_EXECUTION_TIME__MINUTE);
		createEAttribute(expectedExecutionTimeEClass, EXPECTED_EXECUTION_TIME__SECOND);

		dataSourceToSubProcessMappingEClass = createEClass(DATA_SOURCE_TO_SUB_PROCESS_MAPPING);
		createEReference(dataSourceToSubProcessMappingEClass, DATA_SOURCE_TO_SUB_PROCESS_MAPPING__DATA_VARIABLE_MAPPING);

		subProcessToDataSourceMappingEClass = createEClass(SUB_PROCESS_TO_DATA_SOURCE_MAPPING);
		createEReference(subProcessToDataSourceMappingEClass, SUB_PROCESS_TO_DATA_SOURCE_MAPPING__DATA_VARIABLE_MAPPING);

		dataVariableMappingEClass = createEClass(DATA_VARIABLE_MAPPING);
		createEAttribute(dataVariableMappingEClass, DATA_VARIABLE_MAPPING__DATA_SOURCE_ID);
		createEAttribute(dataVariableMappingEClass, DATA_VARIABLE_MAPPING__SUB_PROCES_ID);

		formUriViewEClass = createEClass(FORM_URI_VIEW);
		createEReference(formUriViewEClass, FORM_URI_VIEW__EXPRESSION);

		taskPriorityEClass = createEClass(TASK_PRIORITY);
		createEReference(taskPriorityEClass, TASK_PRIORITY__EXPRESSION);

		assignPolicyTypeEClass = createEClass(ASSIGN_POLICY_TYPE);
		createEAttribute(assignPolicyTypeEClass, ASSIGN_POLICY_TYPE__ID);
		createEReference(assignPolicyTypeEClass, ASSIGN_POLICY_TYPE__EXPRESSION);

		skipAssigneeEClass = createEClass(SKIP_ASSIGNEE);
		createEReference(skipAssigneeEClass, SKIP_ASSIGNEE__EXPRESSION);

		skipCommentEClass = createEClass(SKIP_COMMENT);
		createEReference(skipCommentEClass, SKIP_COMMENT__EXPRESSION);

		connectorInstanceElementsEClass = createEClass(CONNECTOR_INSTANCE_ELEMENTS);
		createEAttribute(connectorInstanceElementsEClass, CONNECTOR_INSTANCE_ELEMENTS__CONNRCTOR_TYPE);
		createEReference(connectorInstanceElementsEClass, CONNECTOR_INSTANCE_ELEMENTS__CONNECTOR_INSTANCE);

		timeExpressionEClass = createEClass(TIME_EXPRESSION);
		createEReference(timeExpressionEClass, TIME_EXPRESSION__EXPRESSION);

		timeSkipExpressionEClass = createEClass(TIME_SKIP_EXPRESSION);
		createEReference(timeSkipExpressionEClass, TIME_SKIP_EXPRESSION__EXPRESSION);

		tableExpressionEClass = createEClass(TABLE_EXPRESSION);
		createEReference(tableExpressionEClass, TABLE_EXPRESSION__EXPRESSIONS);

		listExpressionEClass = createEClass(LIST_EXPRESSION);
		createEReference(listExpressionEClass, LIST_EXPRESSION__EXPRESSIONS);

		taskDescriptionEClass = createEClass(TASK_DESCRIPTION);
		createEReference(taskDescriptionEClass, TASK_DESCRIPTION__EXPRESSION);

		completeTaskDescriptionEClass = createEClass(COMPLETE_TASK_DESCRIPTION);
		createEReference(completeTaskDescriptionEClass, COMPLETE_TASK_DESCRIPTION__EXPRESSION);

		formParamContainerEClass = createEClass(FORM_PARAM_CONTAINER);
		createEReference(formParamContainerEClass, FORM_PARAM_CONTAINER__FORM_PARAM);

		formParamEClass = createEClass(FORM_PARAM);
		createEAttribute(formParamEClass, FORM_PARAM__PARAM_KEY);
		createEAttribute(formParamEClass, FORM_PARAM__PARAM_TYPE);
		createEReference(formParamEClass, FORM_PARAM__EXPRESSION);

		// Create enums
		processValidationLevelEEnum = createEEnum(PROCESS_VALIDATION_LEVEL);
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
		tableExpressionEClass.getESuperTypes().add(this.getExpression());
		listExpressionEClass.getESuperTypes().add(this.getExpression());

		// Initialize classes, features, and operations; add parameters
		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_TaskSubject(), this.getTaskSubject(), null, "taskSubject", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_TaskCommand(), this.getTaskCommand(), null, "taskCommand", null, 0, -1, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_ResourceType(), theXMLTypePackage.getString(), "resourceType", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ResourceFilter(), this.getResourceFilter(), null, "resourceFilter", null, 0, -1, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_DataVariable(), this.getDataVariable(), null, "dataVariable", null, 0, -1, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_Version(), theXMLTypePackage.getInt(), "version", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_Dbid(), theXMLTypePackage.getString(), "dbid", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_Category(), theXMLTypePackage.getString(), "category", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ConnectorInstance(), this.getConnectorInstance(), null, "connectorInstance", null, 0, -1, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_LoopDataInputCollection(), this.getLoopDataInputCollection(), null, "loopDataInputCollection", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_LoopDataOutputCollection(), this.getLoopDataOutputCollection(), null, "loopDataOutputCollection", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_FormUri(), this.getFormUri(), null, "FormUri", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_LoopMaximum(), this.getLoopMaximum(), null, "loopMaximum", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_SubTask(), theXMLTypePackage.getString(), "subTask", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_ScriptName(), theXMLTypePackage.getString(), "scriptName", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_ResultVariable(), theXMLTypePackage.getString(), "resultVariable", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_CallableElementId(), theXMLTypePackage.getString(), "callableElementId", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_CallableElementName(), theXMLTypePackage.getString(), "callableElementName", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_CallableElementVersion(), theXMLTypePackage.getString(), "callableElementVersion", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_CallableElementVersionName(), theXMLTypePackage.getString(), "callableElementVersionName", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_IncludeExclusion(), theXMLTypePackage.getString(), "includeExclusion", null, 1, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_ResourceRange(), theXMLTypePackage.getString(), "resourceRange", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_AssignAction(), theXMLTypePackage.getString(), "assignAction", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_ErrorCode(), theXMLTypePackage.getString(), "errorCode", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_SkipStrategy(), this.getSkipStrategy(), null, "skipStrategy", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_IsContainsSub(), theXMLTypePackage.getBoolean(), "isContainsSub", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_Verification(), theXMLTypePackage.getString(), "verification", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_MessageObj(), this.getMessageObj(), null, "messageObj", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ReceiveMessage(), this.getReceiveMessage(), null, "receiveMessage", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ExpectedExecutionTime(), this.getExpectedExecutionTime(), null, "expectedExecutionTime", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_DataSourceToSubProcessMapping(), this.getDataSourceToSubProcessMapping(), null, "dataSourceToSubProcessMapping", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_SubProcessToDataSourceMapping(), this.getSubProcessToDataSourceMapping(), null, "subProcessToDataSourceMapping", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_CallableElementBizKey(), theXMLTypePackage.getString(), "callableElementBizKey", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_CallableElementBizKeyName(), theXMLTypePackage.getString(), "callableElementBizKeyName", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_IsAsync(), theXMLTypePackage.getString(), "isAsync", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_FormUriView(), this.getFormUriView(), null, "formUriView", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_OrderId(), theXMLTypePackage.getInt(), "orderId", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_TaskPriority(), this.getTaskPriority(), null, "taskPriority", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_AssignPolicyType(), this.getAssignPolicyType(), null, "assignPolicyType", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_IsPersistence(), theXMLTypePackage.getBoolean(), "isPersistence", "true", 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_TaskType(), theXMLTypePackage.getString(), "taskType", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_ValidationLevel(), this.getProcessValidationLevel(), "validationLevel", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_LanguageType(), theXMLTypePackage.getString(), "languageType", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ConnectorInstanceElements(), this.getConnectorInstanceElements(), null, "connectorInstanceElements", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_IsCreateRecord(), theXMLTypePackage.getString(), "isCreateRecord", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_IsAutoClaim(), theXMLTypePackage.getString(), "isAutoClaim", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_TaskDescription(), this.getTaskDescription(), null, "taskDescription", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_CompleteTaskDescription(), this.getCompleteTaskDescription(), null, "completeTaskDescription", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_FormParamContainer(), this.getFormParamContainer(), null, "formParamContainer", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExpression_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExpression_Id(), theXMLTypePackage.getString(), "id", null, 1, 1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExpression_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskSubjectEClass, TaskSubject.class, "TaskSubject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTaskSubject_Expression(), this.getExpression(), null, "expression", null, 0, 1, TaskSubject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTaskSubject_Id(), theXMLTypePackage.getString(), "id", null, 1, 1, TaskSubject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTaskSubject_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TaskSubject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskCommandEClass, TaskCommand.class, "TaskCommand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTaskCommand_Id(), theXMLTypePackage.getString(), "id", null, 0, 1, TaskCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTaskCommand_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TaskCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTaskCommand_CommandType(), theXMLTypePackage.getString(), "commandType", null, 0, 1, TaskCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTaskCommand_Expression(), this.getExpression(), null, "expression", null, 0, 1, TaskCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTaskCommand_OrderId(), theXMLTypePackage.getInt(), "orderId", null, 0, 1, TaskCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTaskCommand_IsVerification(), theXMLTypePackage.getString(), "isVerification", null, 0, 1, TaskCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTaskCommand_IsSaveData(), theXMLTypePackage.getString(), "isSaveData", null, 0, 1, TaskCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTaskCommand_IsSimulationRun(), theXMLTypePackage.getString(), "isSimulationRun", null, 0, 1, TaskCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTaskCommand_ParameterExpression(), this.getExpression(), null, "parameterExpression", null, 0, 1, TaskCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceFilterEClass, ResourceFilter.class, "ResourceFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResourceFilter_Id(), theXMLTypePackage.getString(), "id", null, 0, 1, ResourceFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceFilter_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, ResourceFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceFilter_Expression(), this.getExpression(), null, "expression", null, 0, 1, ResourceFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceFilter_Documentation(), this.getDocumentation(), null, "documentation", null, 0, -1, ResourceFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataVariableEClass, DataVariable.class, "DataVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataVariable_Id(), theXMLTypePackage.getString(), "id", null, 0, 1, DataVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataVariable_DataType(), theXMLTypePackage.getString(), "dataType", null, 0, 1, DataVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataVariable_IsList(), theXMLTypePackage.getBoolean(), "isList", null, 0, 1, DataVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataVariable_IsPersistence(), theXMLTypePackage.getBoolean(), "isPersistence", null, 0, 1, DataVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataVariable_Expression(), this.getExpression(), null, "expression", null, 0, 1, DataVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataVariable_Documentation(), this.getDocumentation(), null, "documentation", null, 0, -1, DataVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataVariable_BizType(), theXMLTypePackage.getString(), "bizType", null, 0, 1, DataVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataVariable_FileName(), theXMLTypePackage.getString(), "fileName", null, 0, 1, DataVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentationEClass, Documentation.class, "Documentation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentation_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, Documentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentation_Id(), theXMLTypePackage.getString(), "id", null, 1, 1, Documentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentation_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, Documentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectorInstanceEClass, ConnectorInstance.class, "ConnectorInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConnectorInstance_ConnectorId(), theXMLTypePackage.getString(), "connectorId", null, 1, 1, ConnectorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectorInstance_PackageName(), theXMLTypePackage.getString(), "packageName", null, 0, 1, ConnectorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectorInstance_ClassName(), theXMLTypePackage.getString(), "className", null, 0, 1, ConnectorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectorInstance_ConnectorInstanceId(), theXMLTypePackage.getString(), "connectorInstanceId", null, 0, 1, ConnectorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectorInstance_ConnectorInstanceName(), theXMLTypePackage.getString(), "connectorInstanceName", null, 0, 1, ConnectorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectorInstance_EventType(), theXMLTypePackage.getString(), "eventType", null, 0, 1, ConnectorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectorInstance_Documentation(), this.getDocumentation(), null, "documentation", null, 0, 1, ConnectorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectorInstance_ErrorHandling(), theXMLTypePackage.getString(), "errorHandling", null, 0, 1, ConnectorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectorInstance_ErrorCode(), theXMLTypePackage.getString(), "errorCode", null, 0, 1, ConnectorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectorInstance_ConnectorParameterInputs(), this.getConnectorParameterInput(), null, "connectorParameterInputs", null, 0, -1, ConnectorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectorInstance_ConnectorParameterOutputs(), this.getConnectorParameterOutput(), null, "connectorParameterOutputs", null, 0, -1, ConnectorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectorInstance_ConnectorParameterOutputsDef(), this.getConnectorParameterOutputDef(), null, "connectorParameterOutputsDef", null, 0, -1, ConnectorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectorInstance_SkipComment(), this.getSkipComment(), null, "skipComment", null, 0, 1, ConnectorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectorInstance_TimeExpression(), this.getTimeExpression(), null, "timeExpression", null, 0, 1, ConnectorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectorInstance_IsTimeExecute(), theXMLTypePackage.getBoolean(), "isTimeExecute", "false", 0, 1, ConnectorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectorInstance_TimeSkipExpression(), this.getTimeSkipExpression(), null, "TimeSkipExpression", null, 0, 1, ConnectorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectorInstance_Version(), theXMLTypePackage.getString(), "version", null, 0, 1, ConnectorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectorInstance_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, ConnectorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectorParameterInputEClass, ConnectorParameterInput.class, "ConnectorParameterInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConnectorParameterInput_Id(), theXMLTypePackage.getString(), "id", null, 1, 1, ConnectorParameterInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectorParameterInput_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, ConnectorParameterInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectorParameterInput_DataType(), theXMLTypePackage.getString(), "dataType", null, 0, 1, ConnectorParameterInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectorParameterInput_Expression(), this.getExpression(), null, "expression", null, 0, 1, ConnectorParameterInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectorParameterInput_IsExecute(), theXMLTypePackage.getString(), "isExecute", null, 0, 1, ConnectorParameterInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectorParameterOutputEClass, ConnectorParameterOutput.class, "ConnectorParameterOutput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConnectorParameterOutput_VariableTarget(), theXMLTypePackage.getString(), "variableTarget", null, 0, 1, ConnectorParameterOutput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectorParameterOutput_Expression(), this.getExpression(), null, "expression", null, 0, 1, ConnectorParameterOutput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectorParameterOutput_OutputId(), theXMLTypePackage.getString(), "outputId", null, 0, 1, ConnectorParameterOutput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loopDataInputCollectionEClass, LoopDataInputCollection.class, "LoopDataInputCollection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLoopDataInputCollection_Expression(), this.getExpression(), null, "expression", null, 0, 1, LoopDataInputCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loopDataOutputCollectionEClass, LoopDataOutputCollection.class, "LoopDataOutputCollection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLoopDataOutputCollection_Expression(), this.getExpression(), null, "expression", null, 0, 1, LoopDataOutputCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectorParameterOutputDefEClass, ConnectorParameterOutputDef.class, "ConnectorParameterOutputDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConnectorParameterOutputDef_Id(), theXMLTypePackage.getString(), "id", null, 1, 1, ConnectorParameterOutputDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectorParameterOutputDef_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, ConnectorParameterOutputDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectorParameterOutputDef_DataType(), theXMLTypePackage.getString(), "dataType", null, 0, 1, ConnectorParameterOutputDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(formUriEClass, FormUri.class, "FormUri", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFormUri_Expression(), this.getExpression(), null, "expression", null, 0, 1, FormUri.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loopMaximumEClass, LoopMaximum.class, "LoopMaximum", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLoopMaximum_Expression(), this.getExpression(), null, "expression", null, 0, 1, LoopMaximum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(skipStrategyEClass, SkipStrategy.class, "SkipStrategy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSkipStrategy_Expression(), this.getExpression(), null, "expression", null, 0, 1, SkipStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSkipStrategy_IsCreateSkipProcess(), theXMLTypePackage.getBoolean(), "isCreateSkipProcess", "true", 0, 1, SkipStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSkipStrategy_SkipAssignee(), this.getSkipAssignee(), null, "skipAssignee", null, 0, 1, SkipStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSkipStrategy_SkipComment(), this.getSkipComment(), null, "skipComment", null, 0, 1, SkipStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSkipStrategy_IsEnable(), theXMLTypePackage.getBoolean(), "isEnable", "false", 0, 1, SkipStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(messageObjEClass, MessageObj.class, "MessageObj", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMessageObj_Id(), theXMLTypePackage.getString(), "id", null, 1, 1, MessageObj.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageObj_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, MessageObj.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMessageObj_Documentation(), this.getDocumentation(), null, "documentation", null, 0, 1, MessageObj.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMessageObj_DataVariable(), this.getDataVariable(), null, "dataVariable", null, 0, -1, MessageObj.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageObj_TargetProcess(), theXMLTypePackage.getString(), "targetProcess", null, 1, 1, MessageObj.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageObj_TargetNode(), theXMLTypePackage.getString(), "targetNode", null, 1, 1, MessageObj.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMessageObj_ProcessInstanceVariable(), this.getProcessInstanceVariable(), null, "processInstanceVariable", null, 0, 1, MessageObj.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMessageObj_TokenVariable(), this.getTokenVariable(), null, "tokenVariable", null, 0, 1, MessageObj.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageObj_MessageType(), theXMLTypePackage.getString(), "messageType", null, 1, 1, MessageObj.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(filterConditionsEClass, FilterConditions.class, "FilterConditions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFilterConditions_Expression(), this.getExpression(), null, "expression", null, 0, 1, FilterConditions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(receiveMessageEClass, ReceiveMessage.class, "ReceiveMessage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReceiveMessage_MessageId(), theXMLTypePackage.getString(), "messageId", null, 0, 1, ReceiveMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReceiveMessage_FilterConditions(), this.getFilterConditions(), null, "filterConditions", null, 0, 1, ReceiveMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReceiveMessage_ProcessInstanceVariable(), this.getProcessInstanceVariable(), null, "processInstanceVariable", null, 0, 1, ReceiveMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReceiveMessage_TokenVariable(), this.getTokenVariable(), null, "tokenVariable", null, 0, 1, ReceiveMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tokenVariableEClass, TokenVariable.class, "TokenVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTokenVariable_Expression(), this.getExpression(), null, "expression", null, 0, 1, TokenVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(processInstanceVariableEClass, ProcessInstanceVariable.class, "ProcessInstanceVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcessInstanceVariable_Expression(), this.getExpression(), null, "expression", null, 0, 1, ProcessInstanceVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expectedExecutionTimeEClass, ExpectedExecutionTime.class, "ExpectedExecutionTime", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExpectedExecutionTime_Day(), theXMLTypePackage.getInt(), "day", null, 1, 1, ExpectedExecutionTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExpectedExecutionTime_Hour(), theXMLTypePackage.getInt(), "hour", null, 1, 1, ExpectedExecutionTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExpectedExecutionTime_Minute(), theXMLTypePackage.getInt(), "minute", null, 1, 1, ExpectedExecutionTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExpectedExecutionTime_Second(), theXMLTypePackage.getInt(), "second", null, 1, 1, ExpectedExecutionTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataSourceToSubProcessMappingEClass, DataSourceToSubProcessMapping.class, "DataSourceToSubProcessMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataSourceToSubProcessMapping_DataVariableMapping(), this.getDataVariableMapping(), null, "dataVariableMapping", null, 0, -1, DataSourceToSubProcessMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subProcessToDataSourceMappingEClass, SubProcessToDataSourceMapping.class, "SubProcessToDataSourceMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubProcessToDataSourceMapping_DataVariableMapping(), this.getDataVariableMapping(), null, "dataVariableMapping", null, 0, -1, SubProcessToDataSourceMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataVariableMappingEClass, DataVariableMapping.class, "DataVariableMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataVariableMapping_DataSourceId(), theXMLTypePackage.getString(), "dataSourceId", null, 1, 1, DataVariableMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataVariableMapping_SubProcesId(), theXMLTypePackage.getString(), "subProcesId", null, 1, 1, DataVariableMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(formUriViewEClass, FormUriView.class, "FormUriView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFormUriView_Expression(), this.getExpression(), null, "expression", null, 0, 1, FormUriView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskPriorityEClass, TaskPriority.class, "TaskPriority", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTaskPriority_Expression(), this.getExpression(), null, "expression", null, 0, 1, TaskPriority.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assignPolicyTypeEClass, AssignPolicyType.class, "AssignPolicyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAssignPolicyType_Id(), theXMLTypePackage.getString(), "id", null, 1, 1, AssignPolicyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssignPolicyType_Expression(), this.getExpression(), null, "expression", null, 0, 1, AssignPolicyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(skipAssigneeEClass, SkipAssignee.class, "SkipAssignee", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSkipAssignee_Expression(), this.getExpression(), null, "expression", null, 0, 1, SkipAssignee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(skipCommentEClass, SkipComment.class, "SkipComment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSkipComment_Expression(), this.getExpression(), null, "expression", null, 0, 1, SkipComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectorInstanceElementsEClass, ConnectorInstanceElements.class, "ConnectorInstanceElements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConnectorInstanceElements_ConnrctorType(), theXMLTypePackage.getString(), "connrctorType", null, 1, 1, ConnectorInstanceElements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectorInstanceElements_ConnectorInstance(), this.getConnectorInstance(), null, "connectorInstance", null, 0, -1, ConnectorInstanceElements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(timeExpressionEClass, TimeExpression.class, "TimeExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTimeExpression_Expression(), this.getExpression(), null, "expression", null, 0, 1, TimeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(timeSkipExpressionEClass, TimeSkipExpression.class, "TimeSkipExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTimeSkipExpression_Expression(), this.getExpression(), null, "expression", null, 0, 1, TimeSkipExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tableExpressionEClass, TableExpression.class, "TableExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTableExpression_Expressions(), this.getListExpression(), null, "expressions", null, 0, -1, TableExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(listExpressionEClass, ListExpression.class, "ListExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getListExpression_Expressions(), this.getExpression(), null, "expressions", null, 0, -1, ListExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskDescriptionEClass, TaskDescription.class, "TaskDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTaskDescription_Expression(), this.getExpression(), null, "expression", null, 0, 1, TaskDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(completeTaskDescriptionEClass, CompleteTaskDescription.class, "CompleteTaskDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompleteTaskDescription_Expression(), this.getExpression(), null, "expression", null, 0, 1, CompleteTaskDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(formParamContainerEClass, FormParamContainer.class, "FormParamContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFormParamContainer_FormParam(), this.getFormParam(), null, "formParam", null, 0, -1, FormParamContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(formParamEClass, FormParam.class, "FormParam", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFormParam_ParamKey(), theXMLTypePackage.getString(), "paramKey", null, 0, 1, FormParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFormParam_ParamType(), theXMLTypePackage.getString(), "paramType", null, 0, 1, FormParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFormParam_Expression(), this.getExpression(), null, "expression", null, 0, 1, FormParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(processValidationLevelEEnum, ProcessValidationLevel.class, "ProcessValidationLevel");
		addEEnumLiteral(processValidationLevelEEnum, ProcessValidationLevel.HIGH);
		addEEnumLiteral(processValidationLevelEEnum, ProcessValidationLevel.MEDIUM);
		addEEnumLiteral(processValidationLevelEEnum, ProcessValidationLevel.LOW);
		addEEnumLiteral(processValidationLevelEEnum, ProcessValidationLevel.NONE);

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
		  (getDocumentRoot_TaskSubject(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "taskSubject",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_TaskCommand(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "element",
			 "name", "taskCommand"
		   });		
		addAnnotation
		  (getDocumentRoot_ResourceType(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDocumentRoot_ResourceFilter(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (getDocumentRoot_DataVariable(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "element",
			 "name", "DataVariable"
		   });		
		addAnnotation
		  (getDocumentRoot_Version(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDocumentRoot_Dbid(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDocumentRoot_Category(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDocumentRoot_ConnectorInstance(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (getDocumentRoot_LoopDataInputCollection(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (getDocumentRoot_LoopDataOutputCollection(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (getDocumentRoot_FormUri(), 
		   source, 
		   new String[] {
			 "name", "formUri",
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (getDocumentRoot_LoopMaximum(), 
		   source, 
		   new String[] {
			 "name", "loopMaximum",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_SubTask(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDocumentRoot_ScriptName(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDocumentRoot_ResultVariable(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "name", "resultVariable",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDocumentRoot_CallableElementId(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDocumentRoot_CallableElementName(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDocumentRoot_CallableElementVersion(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDocumentRoot_CallableElementVersionName(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDocumentRoot_IncludeExclusion(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "attribute",
			 "name", "includeExclusion"
		   });		
		addAnnotation
		  (getDocumentRoot_ResourceRange(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDocumentRoot_AssignAction(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDocumentRoot_ErrorCode(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "name", "errorCode",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDocumentRoot_SkipStrategy(), 
		   source, 
		   new String[] {
			 "name", "skipStrategy",
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (getDocumentRoot_IsContainsSub(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "attribute"
		   });			
		addAnnotation
		  (getDocumentRoot_Verification(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDocumentRoot_MessageObj(), 
		   source, 
		   new String[] {
			 "name", "messageObj",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_ReceiveMessage(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_ExpectedExecutionTime(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "element",
			 "name", "expectedExecutionTime"
		   });		
		addAnnotation
		  (getDocumentRoot_DataSourceToSubProcessMapping(), 
		   source, 
		   new String[] {
			 "name", "dataSourceToSubProcessMapping",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_SubProcessToDataSourceMapping(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "name", "subProcessToDataSourceMapping",
			 "kind", "element"
		   });		
		addAnnotation
		  (getDocumentRoot_CallableElementBizKey(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDocumentRoot_CallableElementBizKeyName(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDocumentRoot_IsAsync(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_FormUriView(), 
		   source, 
		   new String[] {
			 "name", "formUriView",
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (getDocumentRoot_OrderId(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDocumentRoot_TaskPriority(), 
		   source, 
		   new String[] {
			 "name", "taskPriority",
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (getDocumentRoot_AssignPolicyType(), 
		   source, 
		   new String[] {
			 "name", "",
			 "namespace", "##targetNamespace",
			 "kind", "element",
			 "wildcards", ""
		   });		
		addAnnotation
		  (getDocumentRoot_IsPersistence(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "attribute"
		   });			
		addAnnotation
		  (getDocumentRoot_TaskType(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "attribute"
		   });			
		addAnnotation
		  (getDocumentRoot_ValidationLevel(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_LanguageType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_ConnectorInstanceElements(), 
		   source, 
		   new String[] {
			 "name", "connectorInstanceElements",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Name(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDocumentRoot_IsCreateRecord(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_IsAutoClaim(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDocumentRoot_TaskDescription(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_CompleteTaskDescription(), 
		   source, 
		   new String[] {
			 "name", "completeTaskDescription",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_FormParamContainer(), 
		   source, 
		   new String[] {
			 "name", "formParamContainer",
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (expressionEClass, 
		   source, 
		   new String[] {
			 "name", "Expression",
			 "kind", "simple"
		   });			
		addAnnotation
		  (getExpression_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getExpression_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });		
		addAnnotation
		  (getExpression_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (taskSubjectEClass, 
		   source, 
		   new String[] {
			 "name", "TaskSubject"
		   });			
		addAnnotation
		  (getTaskSubject_Expression(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "expression",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getTaskSubject_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });			
		addAnnotation
		  (getTaskSubject_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });			
		addAnnotation
		  (taskCommandEClass, 
		   source, 
		   new String[] {
			 "name", "TaskCommand"
		   });		
		addAnnotation
		  (getTaskCommand_Expression(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (getTaskCommand_OrderId(), 
		   source, 
		   new String[] {
			 "namespace", "",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getTaskCommand_IsVerification(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });			
		addAnnotation
		  (getTaskCommand_IsSaveData(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });			
		addAnnotation
		  (getTaskCommand_IsSimulationRun(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });			
		addAnnotation
		  (getTaskCommand_ParameterExpression(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (getResourceFilter_Expression(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (getResourceFilter_Documentation(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });			
		addAnnotation
		  (getDataVariable_IsPersistence(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDataVariable_Expression(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (getDataVariable_Documentation(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (getDataVariable_BizType(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDataVariable_FileName(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (documentationEClass, 
		   source, 
		   new String[] {
			 "kind", "simple"
		   });		
		addAnnotation
		  (getDocumentation_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getDocumentation_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDocumentation_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getConnectorInstance_ConnectorId(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getConnectorInstance_PackageName(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getConnectorInstance_ClassName(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getConnectorInstance_ConnectorInstanceId(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getConnectorInstance_ConnectorInstanceName(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getConnectorInstance_EventType(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getConnectorInstance_ErrorHandling(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getConnectorInstance_ErrorCode(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getConnectorInstance_ConnectorParameterInputs(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (getConnectorInstance_ConnectorParameterOutputs(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "name", "connectorParameterOutputs",
			 "kind", "element"
		   });		
		addAnnotation
		  (getConnectorInstance_ConnectorParameterOutputsDef(), 
		   source, 
		   new String[] {
			 "name", "connectorParameterOutputsDef",
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (getConnectorInstance_SkipComment(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "name", "skipComment",
			 "kind", "element"
		   });		
		addAnnotation
		  (getConnectorInstance_TimeExpression(), 
		   source, 
		   new String[] {
			 "name", "timeExpression",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getConnectorInstance_IsTimeExecute(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getConnectorInstance_TimeSkipExpression(), 
		   source, 
		   new String[] {
			 "name", "timeSkipExpression",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getConnectorInstance_Version(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getConnectorInstance_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });			
		addAnnotation
		  (connectorParameterInputEClass, 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (getConnectorParameterInput_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getConnectorParameterInput_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getConnectorParameterInput_DataType(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getConnectorParameterInput_Expression(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (getConnectorParameterInput_IsExecute(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (connectorParameterOutputEClass, 
		   source, 
		   new String[] {
			 "name", "ConnectorParameterOutput"
		   });		
		addAnnotation
		  (getConnectorParameterOutput_VariableTarget(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getConnectorParameterOutput_Expression(), 
		   source, 
		   new String[] {
			 "name", "expression",
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (getConnectorParameterOutput_OutputId(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "output"
		   });		
		addAnnotation
		  (getLoopDataInputCollection_Expression(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (getLoopDataOutputCollection_Expression(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (getConnectorParameterOutputDef_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getConnectorParameterOutputDef_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getConnectorParameterOutputDef_DataType(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (formUriEClass, 
		   source, 
		   new String[] {
			 "name", "formUri"
		   });		
		addAnnotation
		  (getFormUri_Expression(), 
		   source, 
		   new String[] {
			 "name", "expression",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (loopMaximumEClass, 
		   source, 
		   new String[] {
			 "name", "loopMaximum"
		   });		
		addAnnotation
		  (getLoopMaximum_Expression(), 
		   source, 
		   new String[] {
			 "name", "expression",
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (getSkipStrategy_Expression(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (getSkipStrategy_IsCreateSkipProcess(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "attribute"
		   });			
		addAnnotation
		  (getSkipStrategy_SkipAssignee(), 
		   source, 
		   new String[] {
			 "name", "skipAssignee",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getSkipStrategy_SkipComment(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getSkipStrategy_IsEnable(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (messageObjEClass, 
		   source, 
		   new String[] {
			 "name", "messageObj"
		   });		
		addAnnotation
		  (getMessageObj_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getMessageObj_Name(), 
		   source, 
		   new String[] {
			 "name", "name",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getMessageObj_Documentation(), 
		   source, 
		   new String[] {
			 "name", "documentation",
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (getMessageObj_DataVariable(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getMessageObj_TargetProcess(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getMessageObj_TargetNode(), 
		   source, 
		   new String[] {
			 "name", "targetNode",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getMessageObj_ProcessInstanceVariable(), 
		   source, 
		   new String[] {
			 "name", "processInstanceVariable",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getMessageObj_TokenVariable(), 
		   source, 
		   new String[] {
			 "name", "tokenVariable",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getMessageObj_MessageType(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (filterConditionsEClass, 
		   source, 
		   new String[] {
			 "name", "filterConditions"
		   });		
		addAnnotation
		  (getFilterConditions_Expression(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "element",
			 "wildcards", "",
			 "name", "expression"
		   });		
		addAnnotation
		  (receiveMessageEClass, 
		   source, 
		   new String[] {
			 "name", "receiveMessage"
		   });		
		addAnnotation
		  (getReceiveMessage_MessageId(), 
		   source, 
		   new String[] {
			 "name", "messageId",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getReceiveMessage_FilterConditions(), 
		   source, 
		   new String[] {
			 "name", "filterConditions",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getReceiveMessage_ProcessInstanceVariable(), 
		   source, 
		   new String[] {
			 "name", "processInstanceVariable",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getReceiveMessage_TokenVariable(), 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "element",
			 "namespace", "##targetNamespace",
			 "wildcards", ""
		   });		
		addAnnotation
		  (tokenVariableEClass, 
		   source, 
		   new String[] {
			 "name", "tokenVariable"
		   });		
		addAnnotation
		  (getTokenVariable_Expression(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "name", "expression",
			 "kind", "element"
		   });		
		addAnnotation
		  (processInstanceVariableEClass, 
		   source, 
		   new String[] {
			 "name", "processInstanceVariable"
		   });		
		addAnnotation
		  (getProcessInstanceVariable_Expression(), 
		   source, 
		   new String[] {
			 "name", "expression",
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (getExpectedExecutionTime_Day(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getExpectedExecutionTime_Hour(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getExpectedExecutionTime_Minute(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getExpectedExecutionTime_Second(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDataSourceToSubProcessMapping_DataVariableMapping(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (getSubProcessToDataSourceMapping_DataVariableMapping(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (getDataVariableMapping_DataSourceId(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDataVariableMapping_SubProcesId(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (formUriViewEClass, 
		   source, 
		   new String[] {
			 "name", "formUriView"
		   });		
		addAnnotation
		  (getFormUriView_Expression(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (taskPriorityEClass, 
		   source, 
		   new String[] {
			 "name", "taskPriority"
		   });		
		addAnnotation
		  (getTaskPriority_Expression(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "name", "expression",
			 "kind", "element"
		   });		
		addAnnotation
		  (assignPolicyTypeEClass, 
		   source, 
		   new String[] {
			 "name", "assignPolicyType"
		   });		
		addAnnotation
		  (getAssignPolicyType_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getAssignPolicyType_Expression(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "name", "expression",
			 "kind", "element"
		   });		
		addAnnotation
		  (getSkipAssignee_Expression(), 
		   source, 
		   new String[] {
			 "name", "expression",
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (skipCommentEClass, 
		   source, 
		   new String[] {
			 "name", "SkipComment"
		   });		
		addAnnotation
		  (getSkipComment_Expression(), 
		   source, 
		   new String[] {
			 "name", "expression",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });							
		addAnnotation
		  (connectorInstanceElementsEClass, 
		   source, 
		   new String[] {
			 "name", "connectorInstanceElements"
		   });		
		addAnnotation
		  (getConnectorInstanceElements_ConnrctorType(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getConnectorInstanceElements_ConnectorInstance(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "wildcards", "",
			 "name", "connectorInstance",
			 "kind", "element"
		   });		
		addAnnotation
		  (timeExpressionEClass, 
		   source, 
		   new String[] {
			 "name", "timeExpression"
		   });		
		addAnnotation
		  (getTimeExpression_Expression(), 
		   source, 
		   new String[] {
			 "name", "expression",
			 "kind", "element",
			 "namespace", "##targetNamespace",
			 "wildcards", ""
		   });		
		addAnnotation
		  (timeSkipExpressionEClass, 
		   source, 
		   new String[] {
			 "name", "timeSkipExpression"
		   });		
		addAnnotation
		  (getTimeSkipExpression_Expression(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "name", "expression",
			 "kind", "element"
		   });		
		addAnnotation
		  (tableExpressionEClass, 
		   source, 
		   new String[] {
			 "name", "tableExpression"
		   });		
		addAnnotation
		  (getTableExpression_Expressions(), 
		   source, 
		   new String[] {
			 "name", "expressions",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (listExpressionEClass, 
		   source, 
		   new String[] {
			 "name", "listExpression"
		   });		
		addAnnotation
		  (getListExpression_Expressions(), 
		   source, 
		   new String[] {
			 "name", "expressions",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTaskDescription_Expression(), 
		   source, 
		   new String[] {
			 "name", "expression",
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (completeTaskDescriptionEClass, 
		   source, 
		   new String[] {
			 "name", "CompleteTaskDescription"
		   });		
		addAnnotation
		  (getCompleteTaskDescription_Expression(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "namespace", "##targetNamespace",
			 "wildcards", "",
			 "name", ""
		   });		
		addAnnotation
		  (formParamContainerEClass, 
		   source, 
		   new String[] {
			 "name", "FormParamContainer"
		   });		
		addAnnotation
		  (getFormParamContainer_FormParam(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });		
		addAnnotation
		  (getFormParam_ParamKey(), 
		   source, 
		   new String[] {
			 "namespace", "",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getFormParam_ParamType(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getFormParam_Expression(), 
		   source, 
		   new String[] {
			 "namespace", "##targetNamespace",
			 "kind", "element"
		   });
	}

} //FoxBPMPackageImpl
