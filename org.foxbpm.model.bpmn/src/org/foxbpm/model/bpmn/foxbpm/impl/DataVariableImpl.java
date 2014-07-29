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

import org.foxbpm.model.bpmn.foxbpm.DataVariable;
import org.foxbpm.model.bpmn.foxbpm.Documentation;
import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.DataVariableImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.DataVariableImpl#getDataType <em>Data Type</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.DataVariableImpl#isIsList <em>Is List</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.DataVariableImpl#isIsPersistence <em>Is Persistence</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.DataVariableImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.DataVariableImpl#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.DataVariableImpl#getBizType <em>Biz Type</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.DataVariableImpl#getFieldName <em>Field Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataVariableImpl extends MinimalEObjectImpl.Container implements DataVariable {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getDataType() <em>Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataType()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataType() <em>Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataType()
	 * @generated
	 * @ordered
	 */
	protected String dataType = DATA_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsList() <em>Is List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsList()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_LIST_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsList() <em>Is List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsList()
	 * @generated
	 * @ordered
	 */
	protected boolean isList = IS_LIST_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsPersistence() <em>Is Persistence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPersistence()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_PERSISTENCE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsPersistence() <em>Is Persistence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPersistence()
	 * @generated
	 * @ordered
	 */
	protected boolean isPersistence = IS_PERSISTENCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression expression;

	/**
	 * The cached value of the '{@link #getDocumentation() <em>Documentation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentation()
	 * @generated
	 * @ordered
	 */
	protected EList<Documentation> documentation;

	/**
	 * The default value of the '{@link #getBizType() <em>Biz Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBizType()
	 * @generated
	 * @ordered
	 */
	protected static final String BIZ_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBizType() <em>Biz Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBizType()
	 * @generated
	 * @ordered
	 */
	protected String bizType = BIZ_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFieldName() <em>Field Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldName()
	 * @generated
	 * @ordered
	 */
	protected static final String FIELD_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFieldName() <em>Field Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldName()
	 * @generated
	 * @ordered
	 */
	protected String fieldName = FIELD_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FoxBPMPackage.Literals.DATA_VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.DATA_VARIABLE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDataType() {
		return dataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataType(String newDataType) {
		String oldDataType = dataType;
		dataType = newDataType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.DATA_VARIABLE__DATA_TYPE, oldDataType, dataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsList() {
		return isList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsList(boolean newIsList) {
		boolean oldIsList = isList;
		isList = newIsList;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.DATA_VARIABLE__IS_LIST, oldIsList, isList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsPersistence() {
		return isPersistence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsPersistence(boolean newIsPersistence) {
		boolean oldIsPersistence = isPersistence;
		isPersistence = newIsPersistence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.DATA_VARIABLE__IS_PERSISTENCE, oldIsPersistence, isPersistence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs) {
		Expression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FoxBPMPackage.DATA_VARIABLE__EXPRESSION, oldExpression, newExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(Expression newExpression) {
		if (newExpression != expression) {
			NotificationChain msgs = null;
			if (expression != null)
				msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FoxBPMPackage.DATA_VARIABLE__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FoxBPMPackage.DATA_VARIABLE__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.DATA_VARIABLE__EXPRESSION, newExpression, newExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Documentation> getDocumentation() {
		if (documentation == null) {
			documentation = new EObjectContainmentEList<Documentation>(Documentation.class, this, FoxBPMPackage.DATA_VARIABLE__DOCUMENTATION);
		}
		return documentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBizType() {
		return bizType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBizType(String newBizType) {
		String oldBizType = bizType;
		bizType = newBizType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.DATA_VARIABLE__BIZ_TYPE, oldBizType, bizType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFieldName(String newFieldName) {
		String oldFieldName = fieldName;
		fieldName = newFieldName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.DATA_VARIABLE__FIELD_NAME, oldFieldName, fieldName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FoxBPMPackage.DATA_VARIABLE__EXPRESSION:
				return basicSetExpression(null, msgs);
			case FoxBPMPackage.DATA_VARIABLE__DOCUMENTATION:
				return ((InternalEList<?>)getDocumentation()).basicRemove(otherEnd, msgs);
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
			case FoxBPMPackage.DATA_VARIABLE__ID:
				return getId();
			case FoxBPMPackage.DATA_VARIABLE__DATA_TYPE:
				return getDataType();
			case FoxBPMPackage.DATA_VARIABLE__IS_LIST:
				return isIsList();
			case FoxBPMPackage.DATA_VARIABLE__IS_PERSISTENCE:
				return isIsPersistence();
			case FoxBPMPackage.DATA_VARIABLE__EXPRESSION:
				return getExpression();
			case FoxBPMPackage.DATA_VARIABLE__DOCUMENTATION:
				return getDocumentation();
			case FoxBPMPackage.DATA_VARIABLE__BIZ_TYPE:
				return getBizType();
			case FoxBPMPackage.DATA_VARIABLE__FIELD_NAME:
				return getFieldName();
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
			case FoxBPMPackage.DATA_VARIABLE__ID:
				setId((String)newValue);
				return;
			case FoxBPMPackage.DATA_VARIABLE__DATA_TYPE:
				setDataType((String)newValue);
				return;
			case FoxBPMPackage.DATA_VARIABLE__IS_LIST:
				setIsList((Boolean)newValue);
				return;
			case FoxBPMPackage.DATA_VARIABLE__IS_PERSISTENCE:
				setIsPersistence((Boolean)newValue);
				return;
			case FoxBPMPackage.DATA_VARIABLE__EXPRESSION:
				setExpression((Expression)newValue);
				return;
			case FoxBPMPackage.DATA_VARIABLE__DOCUMENTATION:
				getDocumentation().clear();
				getDocumentation().addAll((Collection<? extends Documentation>)newValue);
				return;
			case FoxBPMPackage.DATA_VARIABLE__BIZ_TYPE:
				setBizType((String)newValue);
				return;
			case FoxBPMPackage.DATA_VARIABLE__FIELD_NAME:
				setFieldName((String)newValue);
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
			case FoxBPMPackage.DATA_VARIABLE__ID:
				setId(ID_EDEFAULT);
				return;
			case FoxBPMPackage.DATA_VARIABLE__DATA_TYPE:
				setDataType(DATA_TYPE_EDEFAULT);
				return;
			case FoxBPMPackage.DATA_VARIABLE__IS_LIST:
				setIsList(IS_LIST_EDEFAULT);
				return;
			case FoxBPMPackage.DATA_VARIABLE__IS_PERSISTENCE:
				setIsPersistence(IS_PERSISTENCE_EDEFAULT);
				return;
			case FoxBPMPackage.DATA_VARIABLE__EXPRESSION:
				setExpression((Expression)null);
				return;
			case FoxBPMPackage.DATA_VARIABLE__DOCUMENTATION:
				getDocumentation().clear();
				return;
			case FoxBPMPackage.DATA_VARIABLE__BIZ_TYPE:
				setBizType(BIZ_TYPE_EDEFAULT);
				return;
			case FoxBPMPackage.DATA_VARIABLE__FIELD_NAME:
				setFieldName(FIELD_NAME_EDEFAULT);
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
			case FoxBPMPackage.DATA_VARIABLE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case FoxBPMPackage.DATA_VARIABLE__DATA_TYPE:
				return DATA_TYPE_EDEFAULT == null ? dataType != null : !DATA_TYPE_EDEFAULT.equals(dataType);
			case FoxBPMPackage.DATA_VARIABLE__IS_LIST:
				return isList != IS_LIST_EDEFAULT;
			case FoxBPMPackage.DATA_VARIABLE__IS_PERSISTENCE:
				return isPersistence != IS_PERSISTENCE_EDEFAULT;
			case FoxBPMPackage.DATA_VARIABLE__EXPRESSION:
				return expression != null;
			case FoxBPMPackage.DATA_VARIABLE__DOCUMENTATION:
				return documentation != null && !documentation.isEmpty();
			case FoxBPMPackage.DATA_VARIABLE__BIZ_TYPE:
				return BIZ_TYPE_EDEFAULT == null ? bizType != null : !BIZ_TYPE_EDEFAULT.equals(bizType);
			case FoxBPMPackage.DATA_VARIABLE__FIELD_NAME:
				return FIELD_NAME_EDEFAULT == null ? fieldName != null : !FIELD_NAME_EDEFAULT.equals(fieldName);
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
		result.append(" (id: ");
		result.append(id);
		result.append(", dataType: ");
		result.append(dataType);
		result.append(", isList: ");
		result.append(isList);
		result.append(", isPersistence: ");
		result.append(isPersistence);
		result.append(", bizType: ");
		result.append(bizType);
		result.append(", fieldName: ");
		result.append(fieldName);
		result.append(')');
		return result.toString();
	}

} //DataVariableImpl
