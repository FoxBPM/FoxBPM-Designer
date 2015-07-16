/**
 */
package org.foxbpm.model.bpmn.foxbpm.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FormParam;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Form Param</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.FormParamImpl#getParamKey <em>Param Key</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.FormParamImpl#getParamType <em>Param Type</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.FormParamImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FormParamImpl extends MinimalEObjectImpl.Container implements FormParam {
	/**
	 * The default value of the '{@link #getParamKey() <em>Param Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParamKey()
	 * @generated
	 * @ordered
	 */
	protected static final String PARAM_KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParamKey() <em>Param Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParamKey()
	 * @generated
	 * @ordered
	 */
	protected String paramKey = PARAM_KEY_EDEFAULT;

	/**
	 * The default value of the '{@link #getParamType() <em>Param Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParamType()
	 * @generated
	 * @ordered
	 */
	protected static final String PARAM_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParamType() <em>Param Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParamType()
	 * @generated
	 * @ordered
	 */
	protected String paramType = PARAM_TYPE_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FormParamImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FoxBPMPackage.Literals.FORM_PARAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParamKey() {
		return paramKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParamKey(String newParamKey) {
		String oldParamKey = paramKey;
		paramKey = newParamKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.FORM_PARAM__PARAM_KEY, oldParamKey, paramKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParamType() {
		return paramType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParamType(String newParamType) {
		String oldParamType = paramType;
		paramType = newParamType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.FORM_PARAM__PARAM_TYPE, oldParamType, paramType));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FoxBPMPackage.FORM_PARAM__EXPRESSION, oldExpression, newExpression);
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
				msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FoxBPMPackage.FORM_PARAM__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FoxBPMPackage.FORM_PARAM__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.FORM_PARAM__EXPRESSION, newExpression, newExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FoxBPMPackage.FORM_PARAM__EXPRESSION:
				return basicSetExpression(null, msgs);
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
			case FoxBPMPackage.FORM_PARAM__PARAM_KEY:
				return getParamKey();
			case FoxBPMPackage.FORM_PARAM__PARAM_TYPE:
				return getParamType();
			case FoxBPMPackage.FORM_PARAM__EXPRESSION:
				return getExpression();
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
			case FoxBPMPackage.FORM_PARAM__PARAM_KEY:
				setParamKey((String)newValue);
				return;
			case FoxBPMPackage.FORM_PARAM__PARAM_TYPE:
				setParamType((String)newValue);
				return;
			case FoxBPMPackage.FORM_PARAM__EXPRESSION:
				setExpression((Expression)newValue);
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
			case FoxBPMPackage.FORM_PARAM__PARAM_KEY:
				setParamKey(PARAM_KEY_EDEFAULT);
				return;
			case FoxBPMPackage.FORM_PARAM__PARAM_TYPE:
				setParamType(PARAM_TYPE_EDEFAULT);
				return;
			case FoxBPMPackage.FORM_PARAM__EXPRESSION:
				setExpression((Expression)null);
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
			case FoxBPMPackage.FORM_PARAM__PARAM_KEY:
				return PARAM_KEY_EDEFAULT == null ? paramKey != null : !PARAM_KEY_EDEFAULT.equals(paramKey);
			case FoxBPMPackage.FORM_PARAM__PARAM_TYPE:
				return PARAM_TYPE_EDEFAULT == null ? paramType != null : !PARAM_TYPE_EDEFAULT.equals(paramType);
			case FoxBPMPackage.FORM_PARAM__EXPRESSION:
				return expression != null;
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
		result.append(" (paramKey: ");
		result.append(paramKey);
		result.append(", paramType: ");
		result.append(paramType);
		result.append(')');
		return result.toString();
	}

} //FormParamImpl
