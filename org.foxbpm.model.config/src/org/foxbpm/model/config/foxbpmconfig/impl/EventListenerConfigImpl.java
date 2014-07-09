/**
 */
package org.foxbpm.model.config.foxbpmconfig.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.foxbpm.model.config.foxbpmconfig.EventListener;
import org.foxbpm.model.config.foxbpmconfig.EventListenerConfig;
import org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Listener Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.EventListenerConfigImpl#getEventListener <em>Event Listener</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventListenerConfigImpl extends BaseConfigImpl implements EventListenerConfig {
	/**
	 * The cached value of the '{@link #getEventListener() <em>Event Listener</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventListener()
	 * @generated
	 * @ordered
	 */
	protected EList<EventListener> eventListener;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventListenerConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FoxBPMConfigPackage.Literals.EVENT_LISTENER_CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EventListener> getEventListener() {
		if (eventListener == null) {
			eventListener = new EObjectContainmentEList<EventListener>(EventListener.class, this, FoxBPMConfigPackage.EVENT_LISTENER_CONFIG__EVENT_LISTENER);
		}
		return eventListener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FoxBPMConfigPackage.EVENT_LISTENER_CONFIG__EVENT_LISTENER:
				return ((InternalEList<?>)getEventListener()).basicRemove(otherEnd, msgs);
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
			case FoxBPMConfigPackage.EVENT_LISTENER_CONFIG__EVENT_LISTENER:
				return getEventListener();
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
			case FoxBPMConfigPackage.EVENT_LISTENER_CONFIG__EVENT_LISTENER:
				getEventListener().clear();
				getEventListener().addAll((Collection<? extends EventListener>)newValue);
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
			case FoxBPMConfigPackage.EVENT_LISTENER_CONFIG__EVENT_LISTENER:
				getEventListener().clear();
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
			case FoxBPMConfigPackage.EVENT_LISTENER_CONFIG__EVENT_LISTENER:
				return eventListener != null && !eventListener.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EventListenerConfigImpl
