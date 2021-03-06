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

import org.foxbpm.model.bpmn.foxbpm.DataSourceToSubProcessMapping;
import org.foxbpm.model.bpmn.foxbpm.DataVariableMapping;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Source To Sub Process Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.DataSourceToSubProcessMappingImpl#getDataVariableMapping <em>Data Variable Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataSourceToSubProcessMappingImpl extends MinimalEObjectImpl.Container implements DataSourceToSubProcessMapping {
	/**
	 * The cached value of the '{@link #getDataVariableMapping() <em>Data Variable Mapping</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataVariableMapping()
	 * @generated
	 * @ordered
	 */
	protected EList<DataVariableMapping> dataVariableMapping;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataSourceToSubProcessMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FoxBPMPackage.Literals.DATA_SOURCE_TO_SUB_PROCESS_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataVariableMapping> getDataVariableMapping() {
		if (dataVariableMapping == null) {
			dataVariableMapping = new EObjectContainmentEList<DataVariableMapping>(DataVariableMapping.class, this, FoxBPMPackage.DATA_SOURCE_TO_SUB_PROCESS_MAPPING__DATA_VARIABLE_MAPPING);
		}
		return dataVariableMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FoxBPMPackage.DATA_SOURCE_TO_SUB_PROCESS_MAPPING__DATA_VARIABLE_MAPPING:
				return ((InternalEList<?>)getDataVariableMapping()).basicRemove(otherEnd, msgs);
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
			case FoxBPMPackage.DATA_SOURCE_TO_SUB_PROCESS_MAPPING__DATA_VARIABLE_MAPPING:
				return getDataVariableMapping();
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
			case FoxBPMPackage.DATA_SOURCE_TO_SUB_PROCESS_MAPPING__DATA_VARIABLE_MAPPING:
				getDataVariableMapping().clear();
				getDataVariableMapping().addAll((Collection<? extends DataVariableMapping>)newValue);
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
			case FoxBPMPackage.DATA_SOURCE_TO_SUB_PROCESS_MAPPING__DATA_VARIABLE_MAPPING:
				getDataVariableMapping().clear();
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
			case FoxBPMPackage.DATA_SOURCE_TO_SUB_PROCESS_MAPPING__DATA_VARIABLE_MAPPING:
				return dataVariableMapping != null && !dataVariableMapping.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DataSourceToSubProcessMappingImpl
