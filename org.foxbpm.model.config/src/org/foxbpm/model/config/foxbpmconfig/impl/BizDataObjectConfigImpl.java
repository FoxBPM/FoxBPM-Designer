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

import org.foxbpm.model.config.foxbpmconfig.BizDataObjectConfig;
import org.foxbpm.model.config.foxbpmconfig.DataObjectBehavior;
import org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Biz Data Object Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.BizDataObjectConfigImpl#getDataObjectBehavior <em>Data Object Behavior</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BizDataObjectConfigImpl extends BaseConfigImpl implements BizDataObjectConfig {
	/**
	 * The cached value of the '{@link #getDataObjectBehavior() <em>Data Object Behavior</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataObjectBehavior()
	 * @generated
	 * @ordered
	 */
	protected EList<DataObjectBehavior> dataObjectBehavior;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BizDataObjectConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FoxBPMConfigPackage.Literals.BIZ_DATA_OBJECT_CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataObjectBehavior> getDataObjectBehavior() {
		if (dataObjectBehavior == null) {
			dataObjectBehavior = new EObjectContainmentEList<DataObjectBehavior>(DataObjectBehavior.class, this, FoxBPMConfigPackage.BIZ_DATA_OBJECT_CONFIG__DATA_OBJECT_BEHAVIOR);
		}
		return dataObjectBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FoxBPMConfigPackage.BIZ_DATA_OBJECT_CONFIG__DATA_OBJECT_BEHAVIOR:
				return ((InternalEList<?>)getDataObjectBehavior()).basicRemove(otherEnd, msgs);
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
			case FoxBPMConfigPackage.BIZ_DATA_OBJECT_CONFIG__DATA_OBJECT_BEHAVIOR:
				return getDataObjectBehavior();
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
			case FoxBPMConfigPackage.BIZ_DATA_OBJECT_CONFIG__DATA_OBJECT_BEHAVIOR:
				getDataObjectBehavior().clear();
				getDataObjectBehavior().addAll((Collection<? extends DataObjectBehavior>)newValue);
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
			case FoxBPMConfigPackage.BIZ_DATA_OBJECT_CONFIG__DATA_OBJECT_BEHAVIOR:
				getDataObjectBehavior().clear();
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
			case FoxBPMConfigPackage.BIZ_DATA_OBJECT_CONFIG__DATA_OBJECT_BEHAVIOR:
				return dataObjectBehavior != null && !dataObjectBehavior.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BizDataObjectConfigImpl
