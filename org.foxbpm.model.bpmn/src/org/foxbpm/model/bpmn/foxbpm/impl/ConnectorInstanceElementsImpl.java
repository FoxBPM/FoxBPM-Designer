/**
 */
package org.foxbpm.model.bpmn.foxbpm.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.foxbpm.model.bpmn.foxbpm.ConnectorInstance;
import org.foxbpm.model.bpmn.foxbpm.ConnectorInstanceElements;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connector Instance Elements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorInstanceElementsImpl#getConnrctorType <em>Connrctor Type</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorInstanceElementsImpl#getConnectorInstance <em>Connector Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectorInstanceElementsImpl extends MinimalEObjectImpl.Container implements ConnectorInstanceElements {
	/**
	 * The default value of the '{@link #getConnrctorType() <em>Connrctor Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnrctorType()
	 * @generated
	 * @ordered
	 */
	protected static final String CONNRCTOR_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConnrctorType() <em>Connrctor Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnrctorType()
	 * @generated
	 * @ordered
	 */
	protected String connrctorType = CONNRCTOR_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConnectorInstance() <em>Connector Instance</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectorInstance()
	 * @generated
	 * @ordered
	 */
	protected EList<ConnectorInstance> connectorInstance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectorInstanceElementsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FoxBPMPackage.Literals.CONNECTOR_INSTANCE_ELEMENTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConnrctorType() {
		return connrctorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnrctorType(String newConnrctorType) {
		String oldConnrctorType = connrctorType;
		connrctorType = newConnrctorType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.CONNECTOR_INSTANCE_ELEMENTS__CONNRCTOR_TYPE, oldConnrctorType, connrctorType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConnectorInstance> getConnectorInstance() {
		if (connectorInstance == null) {
			connectorInstance = new EObjectContainmentEList<ConnectorInstance>(ConnectorInstance.class, this, FoxBPMPackage.CONNECTOR_INSTANCE_ELEMENTS__CONNECTOR_INSTANCE);
		}
		return connectorInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FoxBPMPackage.CONNECTOR_INSTANCE_ELEMENTS__CONNECTOR_INSTANCE:
				return ((InternalEList<?>)getConnectorInstance()).basicRemove(otherEnd, msgs);
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
			case FoxBPMPackage.CONNECTOR_INSTANCE_ELEMENTS__CONNRCTOR_TYPE:
				return getConnrctorType();
			case FoxBPMPackage.CONNECTOR_INSTANCE_ELEMENTS__CONNECTOR_INSTANCE:
				return getConnectorInstance();
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
			case FoxBPMPackage.CONNECTOR_INSTANCE_ELEMENTS__CONNRCTOR_TYPE:
				setConnrctorType((String)newValue);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE_ELEMENTS__CONNECTOR_INSTANCE:
				getConnectorInstance().clear();
				getConnectorInstance().addAll((Collection<? extends ConnectorInstance>)newValue);
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
			case FoxBPMPackage.CONNECTOR_INSTANCE_ELEMENTS__CONNRCTOR_TYPE:
				setConnrctorType(CONNRCTOR_TYPE_EDEFAULT);
				return;
			case FoxBPMPackage.CONNECTOR_INSTANCE_ELEMENTS__CONNECTOR_INSTANCE:
				getConnectorInstance().clear();
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
			case FoxBPMPackage.CONNECTOR_INSTANCE_ELEMENTS__CONNRCTOR_TYPE:
				return CONNRCTOR_TYPE_EDEFAULT == null ? connrctorType != null : !CONNRCTOR_TYPE_EDEFAULT.equals(connrctorType);
			case FoxBPMPackage.CONNECTOR_INSTANCE_ELEMENTS__CONNECTOR_INSTANCE:
				return connectorInstance != null && !connectorInstance.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (connrctorType: ");
		result.append(connrctorType);
		result.append(')');
		return result.toString();
	}

} //ConnectorInstanceElementsImpl
