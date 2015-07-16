/**
 */
package org.foxbpm.model.bpmn.foxbpm.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.foxbpm.model.bpmn.foxbpm.ConnectorInstanceElements;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;
import org.foxbpm.model.bpmn.foxbpm.PotentialOwner;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Potential Owner</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.PotentialOwnerImpl#getConnectorInstanceElements <em>Connector Instance Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PotentialOwnerImpl extends MinimalEObjectImpl.Container implements PotentialOwner {
	/**
	 * The cached value of the '{@link #getConnectorInstanceElements() <em>Connector Instance Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectorInstanceElements()
	 * @generated
	 * @ordered
	 */
	protected EList<ConnectorInstanceElements> connectorInstanceElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PotentialOwnerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FoxBPMPackage.Literals.POTENTIAL_OWNER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConnectorInstanceElements> getConnectorInstanceElements() {
		if (connectorInstanceElements == null) {
			connectorInstanceElements = new EObjectContainmentEList<ConnectorInstanceElements>(ConnectorInstanceElements.class, this, FoxBPMPackage.POTENTIAL_OWNER__CONNECTOR_INSTANCE_ELEMENTS);
		}
		return connectorInstanceElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FoxBPMPackage.POTENTIAL_OWNER__CONNECTOR_INSTANCE_ELEMENTS:
				return ((InternalEList<?>)getConnectorInstanceElements()).basicRemove(otherEnd, msgs);
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
			case FoxBPMPackage.POTENTIAL_OWNER__CONNECTOR_INSTANCE_ELEMENTS:
				return getConnectorInstanceElements();
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
			case FoxBPMPackage.POTENTIAL_OWNER__CONNECTOR_INSTANCE_ELEMENTS:
				getConnectorInstanceElements().clear();
				getConnectorInstanceElements().addAll((Collection<? extends ConnectorInstanceElements>)newValue);
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
			case FoxBPMPackage.POTENTIAL_OWNER__CONNECTOR_INSTANCE_ELEMENTS:
				getConnectorInstanceElements().clear();
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
			case FoxBPMPackage.POTENTIAL_OWNER__CONNECTOR_INSTANCE_ELEMENTS:
				return connectorInstanceElements != null && !connectorInstanceElements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PotentialOwnerImpl
