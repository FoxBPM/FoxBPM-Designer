/**
 */
package org.foxbpm.model.config.variableconfig.impl;

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

import org.foxbpm.model.config.variableconfig.DataVariableBizTypeConfig;
import org.foxbpm.model.config.variableconfig.DataVariableConfig;
import org.foxbpm.model.config.variableconfig.DataVariableDataType;
import org.foxbpm.model.config.variableconfig.DataVariableType;
import org.foxbpm.model.config.variableconfig.FixFlowDataVariable;
import org.foxbpm.model.config.variableconfig.VariableconfigPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Variable Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.variableconfig.impl.DataVariableConfigImpl#getDataVariableType <em>Data Variable Type</em>}</li>
 *   <li>{@link org.foxbpm.model.config.variableconfig.impl.DataVariableConfigImpl#getFixFlowDataVariable <em>Fix Flow Data Variable</em>}</li>
 *   <li>{@link org.foxbpm.model.config.variableconfig.impl.DataVariableConfigImpl#getDataVariableDataType <em>Data Variable Data Type</em>}</li>
 *   <li>{@link org.foxbpm.model.config.variableconfig.impl.DataVariableConfigImpl#getDataVariableBizTypeConfig <em>Data Variable Biz Type Config</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataVariableConfigImpl extends MinimalEObjectImpl.Container implements DataVariableConfig {
	/**
	 * The cached value of the '{@link #getDataVariableType() <em>Data Variable Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataVariableType()
	 * @generated
	 * @ordered
	 */
	protected DataVariableType dataVariableType;

	/**
	 * The cached value of the '{@link #getFixFlowDataVariable() <em>Fix Flow Data Variable</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixFlowDataVariable()
	 * @generated
	 * @ordered
	 */
	protected EList<FixFlowDataVariable> fixFlowDataVariable;

	/**
	 * The cached value of the '{@link #getDataVariableDataType() <em>Data Variable Data Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataVariableDataType()
	 * @generated
	 * @ordered
	 */
	protected DataVariableDataType dataVariableDataType;

	/**
	 * The cached value of the '{@link #getDataVariableBizTypeConfig() <em>Data Variable Biz Type Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataVariableBizTypeConfig()
	 * @generated
	 * @ordered
	 */
	protected DataVariableBizTypeConfig dataVariableBizTypeConfig;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataVariableConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VariableconfigPackage.Literals.DATA_VARIABLE_CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataVariableType getDataVariableType() {
		return dataVariableType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataVariableType(DataVariableType newDataVariableType, NotificationChain msgs) {
		DataVariableType oldDataVariableType = dataVariableType;
		dataVariableType = newDataVariableType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VariableconfigPackage.DATA_VARIABLE_CONFIG__DATA_VARIABLE_TYPE, oldDataVariableType, newDataVariableType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataVariableType(DataVariableType newDataVariableType) {
		if (newDataVariableType != dataVariableType) {
			NotificationChain msgs = null;
			if (dataVariableType != null)
				msgs = ((InternalEObject)dataVariableType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VariableconfigPackage.DATA_VARIABLE_CONFIG__DATA_VARIABLE_TYPE, null, msgs);
			if (newDataVariableType != null)
				msgs = ((InternalEObject)newDataVariableType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VariableconfigPackage.DATA_VARIABLE_CONFIG__DATA_VARIABLE_TYPE, null, msgs);
			msgs = basicSetDataVariableType(newDataVariableType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariableconfigPackage.DATA_VARIABLE_CONFIG__DATA_VARIABLE_TYPE, newDataVariableType, newDataVariableType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FixFlowDataVariable> getFixFlowDataVariable() {
		if (fixFlowDataVariable == null) {
			fixFlowDataVariable = new EObjectContainmentEList<FixFlowDataVariable>(FixFlowDataVariable.class, this, VariableconfigPackage.DATA_VARIABLE_CONFIG__FIX_FLOW_DATA_VARIABLE);
		}
		return fixFlowDataVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataVariableDataType getDataVariableDataType() {
		return dataVariableDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataVariableDataType(DataVariableDataType newDataVariableDataType, NotificationChain msgs) {
		DataVariableDataType oldDataVariableDataType = dataVariableDataType;
		dataVariableDataType = newDataVariableDataType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VariableconfigPackage.DATA_VARIABLE_CONFIG__DATA_VARIABLE_DATA_TYPE, oldDataVariableDataType, newDataVariableDataType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataVariableDataType(DataVariableDataType newDataVariableDataType) {
		if (newDataVariableDataType != dataVariableDataType) {
			NotificationChain msgs = null;
			if (dataVariableDataType != null)
				msgs = ((InternalEObject)dataVariableDataType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VariableconfigPackage.DATA_VARIABLE_CONFIG__DATA_VARIABLE_DATA_TYPE, null, msgs);
			if (newDataVariableDataType != null)
				msgs = ((InternalEObject)newDataVariableDataType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VariableconfigPackage.DATA_VARIABLE_CONFIG__DATA_VARIABLE_DATA_TYPE, null, msgs);
			msgs = basicSetDataVariableDataType(newDataVariableDataType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariableconfigPackage.DATA_VARIABLE_CONFIG__DATA_VARIABLE_DATA_TYPE, newDataVariableDataType, newDataVariableDataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataVariableBizTypeConfig getDataVariableBizTypeConfig() {
		return dataVariableBizTypeConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataVariableBizTypeConfig(DataVariableBizTypeConfig newDataVariableBizTypeConfig, NotificationChain msgs) {
		DataVariableBizTypeConfig oldDataVariableBizTypeConfig = dataVariableBizTypeConfig;
		dataVariableBizTypeConfig = newDataVariableBizTypeConfig;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VariableconfigPackage.DATA_VARIABLE_CONFIG__DATA_VARIABLE_BIZ_TYPE_CONFIG, oldDataVariableBizTypeConfig, newDataVariableBizTypeConfig);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataVariableBizTypeConfig(DataVariableBizTypeConfig newDataVariableBizTypeConfig) {
		if (newDataVariableBizTypeConfig != dataVariableBizTypeConfig) {
			NotificationChain msgs = null;
			if (dataVariableBizTypeConfig != null)
				msgs = ((InternalEObject)dataVariableBizTypeConfig).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VariableconfigPackage.DATA_VARIABLE_CONFIG__DATA_VARIABLE_BIZ_TYPE_CONFIG, null, msgs);
			if (newDataVariableBizTypeConfig != null)
				msgs = ((InternalEObject)newDataVariableBizTypeConfig).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VariableconfigPackage.DATA_VARIABLE_CONFIG__DATA_VARIABLE_BIZ_TYPE_CONFIG, null, msgs);
			msgs = basicSetDataVariableBizTypeConfig(newDataVariableBizTypeConfig, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariableconfigPackage.DATA_VARIABLE_CONFIG__DATA_VARIABLE_BIZ_TYPE_CONFIG, newDataVariableBizTypeConfig, newDataVariableBizTypeConfig));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VariableconfigPackage.DATA_VARIABLE_CONFIG__DATA_VARIABLE_TYPE:
				return basicSetDataVariableType(null, msgs);
			case VariableconfigPackage.DATA_VARIABLE_CONFIG__FIX_FLOW_DATA_VARIABLE:
				return ((InternalEList<?>)getFixFlowDataVariable()).basicRemove(otherEnd, msgs);
			case VariableconfigPackage.DATA_VARIABLE_CONFIG__DATA_VARIABLE_DATA_TYPE:
				return basicSetDataVariableDataType(null, msgs);
			case VariableconfigPackage.DATA_VARIABLE_CONFIG__DATA_VARIABLE_BIZ_TYPE_CONFIG:
				return basicSetDataVariableBizTypeConfig(null, msgs);
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
			case VariableconfigPackage.DATA_VARIABLE_CONFIG__DATA_VARIABLE_TYPE:
				return getDataVariableType();
			case VariableconfigPackage.DATA_VARIABLE_CONFIG__FIX_FLOW_DATA_VARIABLE:
				return getFixFlowDataVariable();
			case VariableconfigPackage.DATA_VARIABLE_CONFIG__DATA_VARIABLE_DATA_TYPE:
				return getDataVariableDataType();
			case VariableconfigPackage.DATA_VARIABLE_CONFIG__DATA_VARIABLE_BIZ_TYPE_CONFIG:
				return getDataVariableBizTypeConfig();
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
			case VariableconfigPackage.DATA_VARIABLE_CONFIG__DATA_VARIABLE_TYPE:
				setDataVariableType((DataVariableType)newValue);
				return;
			case VariableconfigPackage.DATA_VARIABLE_CONFIG__FIX_FLOW_DATA_VARIABLE:
				getFixFlowDataVariable().clear();
				getFixFlowDataVariable().addAll((Collection<? extends FixFlowDataVariable>)newValue);
				return;
			case VariableconfigPackage.DATA_VARIABLE_CONFIG__DATA_VARIABLE_DATA_TYPE:
				setDataVariableDataType((DataVariableDataType)newValue);
				return;
			case VariableconfigPackage.DATA_VARIABLE_CONFIG__DATA_VARIABLE_BIZ_TYPE_CONFIG:
				setDataVariableBizTypeConfig((DataVariableBizTypeConfig)newValue);
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
			case VariableconfigPackage.DATA_VARIABLE_CONFIG__DATA_VARIABLE_TYPE:
				setDataVariableType((DataVariableType)null);
				return;
			case VariableconfigPackage.DATA_VARIABLE_CONFIG__FIX_FLOW_DATA_VARIABLE:
				getFixFlowDataVariable().clear();
				return;
			case VariableconfigPackage.DATA_VARIABLE_CONFIG__DATA_VARIABLE_DATA_TYPE:
				setDataVariableDataType((DataVariableDataType)null);
				return;
			case VariableconfigPackage.DATA_VARIABLE_CONFIG__DATA_VARIABLE_BIZ_TYPE_CONFIG:
				setDataVariableBizTypeConfig((DataVariableBizTypeConfig)null);
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
			case VariableconfigPackage.DATA_VARIABLE_CONFIG__DATA_VARIABLE_TYPE:
				return dataVariableType != null;
			case VariableconfigPackage.DATA_VARIABLE_CONFIG__FIX_FLOW_DATA_VARIABLE:
				return fixFlowDataVariable != null && !fixFlowDataVariable.isEmpty();
			case VariableconfigPackage.DATA_VARIABLE_CONFIG__DATA_VARIABLE_DATA_TYPE:
				return dataVariableDataType != null;
			case VariableconfigPackage.DATA_VARIABLE_CONFIG__DATA_VARIABLE_BIZ_TYPE_CONFIG:
				return dataVariableBizTypeConfig != null;
		}
		return super.eIsSet(featureID);
	}

} //DataVariableConfigImpl
