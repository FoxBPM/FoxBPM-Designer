/**
 */
package org.foxbpm.model.config.connectormenu.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.foxbpm.model.config.connectormenu.ActorConnector;
import org.foxbpm.model.config.connectormenu.ConnectormenuPackage;
import org.foxbpm.model.config.connectormenu.FlowConnector;
import org.foxbpm.model.config.connectormenu.Menu;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Menu</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.connectormenu.impl.MenuImpl#getFlowConnector <em>Flow Connector</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connectormenu.impl.MenuImpl#getActorConnector <em>Actor Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MenuImpl extends MinimalEObjectImpl.Container implements Menu {
	/**
	 * The cached value of the '{@link #getFlowConnector() <em>Flow Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlowConnector()
	 * @generated
	 * @ordered
	 */
	protected FlowConnector flowConnector;
	/**
	 * The cached value of the '{@link #getActorConnector() <em>Actor Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActorConnector()
	 * @generated
	 * @ordered
	 */
	protected ActorConnector actorConnector;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MenuImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConnectormenuPackage.Literals.MENU;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowConnector getFlowConnector() {
		return flowConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFlowConnector(FlowConnector newFlowConnector, NotificationChain msgs) {
		FlowConnector oldFlowConnector = flowConnector;
		flowConnector = newFlowConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConnectormenuPackage.MENU__FLOW_CONNECTOR, oldFlowConnector, newFlowConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlowConnector(FlowConnector newFlowConnector) {
		if (newFlowConnector != flowConnector) {
			NotificationChain msgs = null;
			if (flowConnector != null)
				msgs = ((InternalEObject)flowConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConnectormenuPackage.MENU__FLOW_CONNECTOR, null, msgs);
			if (newFlowConnector != null)
				msgs = ((InternalEObject)newFlowConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConnectormenuPackage.MENU__FLOW_CONNECTOR, null, msgs);
			msgs = basicSetFlowConnector(newFlowConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConnectormenuPackage.MENU__FLOW_CONNECTOR, newFlowConnector, newFlowConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorConnector getActorConnector() {
		return actorConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetActorConnector(ActorConnector newActorConnector, NotificationChain msgs) {
		ActorConnector oldActorConnector = actorConnector;
		actorConnector = newActorConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConnectormenuPackage.MENU__ACTOR_CONNECTOR, oldActorConnector, newActorConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActorConnector(ActorConnector newActorConnector) {
		if (newActorConnector != actorConnector) {
			NotificationChain msgs = null;
			if (actorConnector != null)
				msgs = ((InternalEObject)actorConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConnectormenuPackage.MENU__ACTOR_CONNECTOR, null, msgs);
			if (newActorConnector != null)
				msgs = ((InternalEObject)newActorConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConnectormenuPackage.MENU__ACTOR_CONNECTOR, null, msgs);
			msgs = basicSetActorConnector(newActorConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConnectormenuPackage.MENU__ACTOR_CONNECTOR, newActorConnector, newActorConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConnectormenuPackage.MENU__FLOW_CONNECTOR:
				return basicSetFlowConnector(null, msgs);
			case ConnectormenuPackage.MENU__ACTOR_CONNECTOR:
				return basicSetActorConnector(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConnectormenuPackage.MENU__FLOW_CONNECTOR:
				return getFlowConnector();
			case ConnectormenuPackage.MENU__ACTOR_CONNECTOR:
				return getActorConnector();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConnectormenuPackage.MENU__FLOW_CONNECTOR:
				setFlowConnector((FlowConnector)newValue);
				return;
			case ConnectormenuPackage.MENU__ACTOR_CONNECTOR:
				setActorConnector((ActorConnector)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ConnectormenuPackage.MENU__FLOW_CONNECTOR:
				setFlowConnector((FlowConnector)null);
				return;
			case ConnectormenuPackage.MENU__ACTOR_CONNECTOR:
				setActorConnector((ActorConnector)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConnectormenuPackage.MENU__FLOW_CONNECTOR:
				return flowConnector != null;
			case ConnectormenuPackage.MENU__ACTOR_CONNECTOR:
				return actorConnector != null;
		}
		return super.eIsSet(featureID);
	}

} //MenuImpl
