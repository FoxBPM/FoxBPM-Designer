/**
 */
package org.foxbpm.model.config.connectormenu;

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
 * @see org.foxbpm.model.config.connectormenu.ConnectormenuFactory
 * @model kind="package"
 * @generated
 */
public interface ConnectormenuPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "connectormenu";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.foxbpm.org/connectormenu";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "connectormenu";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConnectormenuPackage eINSTANCE = org.foxbpm.model.config.connectormenu.impl.ConnectormenuPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.connectormenu.impl.MenuImpl <em>Menu</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.connectormenu.impl.MenuImpl
	 * @see org.foxbpm.model.config.connectormenu.impl.ConnectormenuPackageImpl#getMenu()
	 * @generated
	 */
	int MENU = 0;

	/**
	 * The feature id for the '<em><b>Flow Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU__FLOW_CONNECTOR = 0;

	/**
	 * The feature id for the '<em><b>Actor Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU__ACTOR_CONNECTOR = 1;

	/**
	 * The number of structural features of the '<em>Menu</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Menu</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.connectormenu.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.connectormenu.impl.NodeImpl
	 * @see org.foxbpm.model.config.connectormenu.impl.ConnectormenuPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Ico</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ICO = 2;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__CONNECTOR = 3;

	/**
	 * The feature id for the '<em><b>Node</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NODE = 4;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.connectormenu.impl.ConnectorImpl <em>Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.connectormenu.impl.ConnectorImpl
	 * @see org.foxbpm.model.config.connectormenu.impl.ConnectormenuPackageImpl#getConnector()
	 * @generated
	 */
	int CONNECTOR = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__NAME = 1;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__NOTE = 2;

	/**
	 * The feature id for the '<em><b>Ico</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__ICO = 3;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__VERSION = 4;

	/**
	 * The feature id for the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__PACKAGE = 5;

	/**
	 * The number of structural features of the '<em>Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.connectormenu.impl.FlowConnectorImpl <em>Flow Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.connectormenu.impl.FlowConnectorImpl
	 * @see org.foxbpm.model.config.connectormenu.impl.ConnectormenuPackageImpl#getFlowConnector()
	 * @generated
	 */
	int FLOW_CONNECTOR = 3;

	/**
	 * The feature id for the '<em><b>Node</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_CONNECTOR__NODE = 0;

	/**
	 * The number of structural features of the '<em>Flow Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_CONNECTOR_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Flow Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_CONNECTOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.connectormenu.impl.ActorConnectorImpl <em>Actor Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.connectormenu.impl.ActorConnectorImpl
	 * @see org.foxbpm.model.config.connectormenu.impl.ConnectormenuPackageImpl#getActorConnector()
	 * @generated
	 */
	int ACTOR_CONNECTOR = 4;

	/**
	 * The feature id for the '<em><b>Node</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_CONNECTOR__NODE = 0;

	/**
	 * The number of structural features of the '<em>Actor Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_CONNECTOR_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Actor Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_CONNECTOR_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.connectormenu.Menu <em>Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Menu</em>'.
	 * @see org.foxbpm.model.config.connectormenu.Menu
	 * @generated
	 */
	EClass getMenu();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.config.connectormenu.Menu#getFlowConnector <em>Flow Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Flow Connector</em>'.
	 * @see org.foxbpm.model.config.connectormenu.Menu#getFlowConnector()
	 * @see #getMenu()
	 * @generated
	 */
	EReference getMenu_FlowConnector();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.config.connectormenu.Menu#getActorConnector <em>Actor Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Actor Connector</em>'.
	 * @see org.foxbpm.model.config.connectormenu.Menu#getActorConnector()
	 * @see #getMenu()
	 * @generated
	 */
	EReference getMenu_ActorConnector();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.connectormenu.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.foxbpm.model.config.connectormenu.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connectormenu.Node#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.foxbpm.model.config.connectormenu.Node#getId()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connectormenu.Node#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.foxbpm.model.config.connectormenu.Node#getName()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connectormenu.Node#getIco <em>Ico</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ico</em>'.
	 * @see org.foxbpm.model.config.connectormenu.Node#getIco()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Ico();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.config.connectormenu.Node#getConnector <em>Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connector</em>'.
	 * @see org.foxbpm.model.config.connectormenu.Node#getConnector()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Connector();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.config.connectormenu.Node#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Node</em>'.
	 * @see org.foxbpm.model.config.connectormenu.Node#getNode()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Node();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.connectormenu.Connector <em>Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector</em>'.
	 * @see org.foxbpm.model.config.connectormenu.Connector
	 * @generated
	 */
	EClass getConnector();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connectormenu.Connector#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.foxbpm.model.config.connectormenu.Connector#getId()
	 * @see #getConnector()
	 * @generated
	 */
	EAttribute getConnector_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connectormenu.Connector#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.foxbpm.model.config.connectormenu.Connector#getName()
	 * @see #getConnector()
	 * @generated
	 */
	EAttribute getConnector_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connectormenu.Connector#getNote <em>Note</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Note</em>'.
	 * @see org.foxbpm.model.config.connectormenu.Connector#getNote()
	 * @see #getConnector()
	 * @generated
	 */
	EAttribute getConnector_Note();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connectormenu.Connector#getIco <em>Ico</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ico</em>'.
	 * @see org.foxbpm.model.config.connectormenu.Connector#getIco()
	 * @see #getConnector()
	 * @generated
	 */
	EAttribute getConnector_Ico();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connectormenu.Connector#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.foxbpm.model.config.connectormenu.Connector#getVersion()
	 * @see #getConnector()
	 * @generated
	 */
	EAttribute getConnector_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.connectormenu.Connector#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package</em>'.
	 * @see org.foxbpm.model.config.connectormenu.Connector#getPackage()
	 * @see #getConnector()
	 * @generated
	 */
	EAttribute getConnector_Package();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.connectormenu.FlowConnector <em>Flow Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flow Connector</em>'.
	 * @see org.foxbpm.model.config.connectormenu.FlowConnector
	 * @generated
	 */
	EClass getFlowConnector();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.config.connectormenu.FlowConnector#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Node</em>'.
	 * @see org.foxbpm.model.config.connectormenu.FlowConnector#getNode()
	 * @see #getFlowConnector()
	 * @generated
	 */
	EReference getFlowConnector_Node();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.connectormenu.ActorConnector <em>Actor Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor Connector</em>'.
	 * @see org.foxbpm.model.config.connectormenu.ActorConnector
	 * @generated
	 */
	EClass getActorConnector();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.config.connectormenu.ActorConnector#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Node</em>'.
	 * @see org.foxbpm.model.config.connectormenu.ActorConnector#getNode()
	 * @see #getActorConnector()
	 * @generated
	 */
	EReference getActorConnector_Node();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConnectormenuFactory getConnectormenuFactory();

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
		 * The meta object literal for the '{@link org.foxbpm.model.config.connectormenu.impl.MenuImpl <em>Menu</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.connectormenu.impl.MenuImpl
		 * @see org.foxbpm.model.config.connectormenu.impl.ConnectormenuPackageImpl#getMenu()
		 * @generated
		 */
		EClass MENU = eINSTANCE.getMenu();

		/**
		 * The meta object literal for the '<em><b>Flow Connector</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MENU__FLOW_CONNECTOR = eINSTANCE.getMenu_FlowConnector();

		/**
		 * The meta object literal for the '<em><b>Actor Connector</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MENU__ACTOR_CONNECTOR = eINSTANCE.getMenu_ActorConnector();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.connectormenu.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.connectormenu.impl.NodeImpl
		 * @see org.foxbpm.model.config.connectormenu.impl.ConnectormenuPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__ID = eINSTANCE.getNode_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__NAME = eINSTANCE.getNode_Name();

		/**
		 * The meta object literal for the '<em><b>Ico</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__ICO = eINSTANCE.getNode_Ico();

		/**
		 * The meta object literal for the '<em><b>Connector</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__CONNECTOR = eINSTANCE.getNode_Connector();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__NODE = eINSTANCE.getNode_Node();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.connectormenu.impl.ConnectorImpl <em>Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.connectormenu.impl.ConnectorImpl
		 * @see org.foxbpm.model.config.connectormenu.impl.ConnectormenuPackageImpl#getConnector()
		 * @generated
		 */
		EClass CONNECTOR = eINSTANCE.getConnector();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR__ID = eINSTANCE.getConnector_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR__NAME = eINSTANCE.getConnector_Name();

		/**
		 * The meta object literal for the '<em><b>Note</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR__NOTE = eINSTANCE.getConnector_Note();

		/**
		 * The meta object literal for the '<em><b>Ico</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR__ICO = eINSTANCE.getConnector_Ico();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR__VERSION = eINSTANCE.getConnector_Version();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTOR__PACKAGE = eINSTANCE.getConnector_Package();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.connectormenu.impl.FlowConnectorImpl <em>Flow Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.connectormenu.impl.FlowConnectorImpl
		 * @see org.foxbpm.model.config.connectormenu.impl.ConnectormenuPackageImpl#getFlowConnector()
		 * @generated
		 */
		EClass FLOW_CONNECTOR = eINSTANCE.getFlowConnector();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW_CONNECTOR__NODE = eINSTANCE.getFlowConnector_Node();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.connectormenu.impl.ActorConnectorImpl <em>Actor Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.connectormenu.impl.ActorConnectorImpl
		 * @see org.foxbpm.model.config.connectormenu.impl.ConnectormenuPackageImpl#getActorConnector()
		 * @generated
		 */
		EClass ACTOR_CONNECTOR = eINSTANCE.getActorConnector();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_CONNECTOR__NODE = eINSTANCE.getActorConnector_Node();

	}

} //ConnectormenuPackage
