/**
 */
package org.foxbpm.model.bpmn.foxbpm.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.foxbpm.model.bpmn.foxbpm.DataVariableMapping;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Variable Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.DataVariableMappingImpl#getDataSourceId <em>Data Source Id</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.DataVariableMappingImpl#getSubProcesId <em>Sub Proces Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataVariableMappingImpl extends MinimalEObjectImpl.Container implements DataVariableMapping {
	/**
	 * The default value of the '{@link #getDataSourceId() <em>Data Source Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataSourceId()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_SOURCE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataSourceId() <em>Data Source Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataSourceId()
	 * @generated
	 * @ordered
	 */
	protected String dataSourceId = DATA_SOURCE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getSubProcesId() <em>Sub Proces Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubProcesId()
	 * @generated
	 * @ordered
	 */
	protected static final String SUB_PROCES_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSubProcesId() <em>Sub Proces Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubProcesId()
	 * @generated
	 * @ordered
	 */
	protected String subProcesId = SUB_PROCES_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataVariableMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FoxBPMPackage.Literals.DATA_VARIABLE_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDataSourceId() {
		return dataSourceId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataSourceId(String newDataSourceId) {
		String oldDataSourceId = dataSourceId;
		dataSourceId = newDataSourceId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.DATA_VARIABLE_MAPPING__DATA_SOURCE_ID, oldDataSourceId, dataSourceId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSubProcesId() {
		return subProcesId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubProcesId(String newSubProcesId) {
		String oldSubProcesId = subProcesId;
		subProcesId = newSubProcesId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.DATA_VARIABLE_MAPPING__SUB_PROCES_ID, oldSubProcesId, subProcesId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FoxBPMPackage.DATA_VARIABLE_MAPPING__DATA_SOURCE_ID:
				return getDataSourceId();
			case FoxBPMPackage.DATA_VARIABLE_MAPPING__SUB_PROCES_ID:
				return getSubProcesId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FoxBPMPackage.DATA_VARIABLE_MAPPING__DATA_SOURCE_ID:
				setDataSourceId((String)newValue);
				return;
			case FoxBPMPackage.DATA_VARIABLE_MAPPING__SUB_PROCES_ID:
				setSubProcesId((String)newValue);
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
			case FoxBPMPackage.DATA_VARIABLE_MAPPING__DATA_SOURCE_ID:
				setDataSourceId(DATA_SOURCE_ID_EDEFAULT);
				return;
			case FoxBPMPackage.DATA_VARIABLE_MAPPING__SUB_PROCES_ID:
				setSubProcesId(SUB_PROCES_ID_EDEFAULT);
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
			case FoxBPMPackage.DATA_VARIABLE_MAPPING__DATA_SOURCE_ID:
				return DATA_SOURCE_ID_EDEFAULT == null ? dataSourceId != null : !DATA_SOURCE_ID_EDEFAULT.equals(dataSourceId);
			case FoxBPMPackage.DATA_VARIABLE_MAPPING__SUB_PROCES_ID:
				return SUB_PROCES_ID_EDEFAULT == null ? subProcesId != null : !SUB_PROCES_ID_EDEFAULT.equals(subProcesId);
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
		result.append(" (dataSourceId: ");
		result.append(dataSourceId);
		result.append(", subProcesId: ");
		result.append(subProcesId);
		result.append(')');
		return result.toString();
	}

} //DataVariableMappingImpl
