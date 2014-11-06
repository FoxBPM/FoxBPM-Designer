/**
 */
package org.foxbpm.model.config.connectormenu.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.foxbpm.model.config.connectormenu.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConnectormenuFactoryImpl extends EFactoryImpl implements ConnectormenuFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConnectormenuFactory init() {
		try {
			ConnectormenuFactory theConnectormenuFactory = (ConnectormenuFactory)EPackage.Registry.INSTANCE.getEFactory(ConnectormenuPackage.eNS_URI);
			if (theConnectormenuFactory != null) {
				return theConnectormenuFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ConnectormenuFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectormenuFactoryImpl() {
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
			case ConnectormenuPackage.MENU: return createMenu();
			case ConnectormenuPackage.NODE: return createNode();
			case ConnectormenuPackage.CONNECTOR: return createConnector();
			case ConnectormenuPackage.FLOW_CONNECTOR: return createFlowConnector();
			case ConnectormenuPackage.ACTOR_CONNECTOR: return createActorConnector();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Menu createMenu() {
		MenuImpl menu = new MenuImpl();
		return menu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node createNode() {
		NodeImpl node = new NodeImpl();
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connector createConnector() {
		ConnectorImpl connector = new ConnectorImpl();
		return connector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowConnector createFlowConnector() {
		FlowConnectorImpl flowConnector = new FlowConnectorImpl();
		return flowConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorConnector createActorConnector() {
		ActorConnectorImpl actorConnector = new ActorConnectorImpl();
		return actorConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectormenuPackage getConnectormenuPackage() {
		return (ConnectormenuPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ConnectormenuPackage getPackage() {
		return ConnectormenuPackage.eINSTANCE;
	}

} //ConnectormenuFactoryImpl
