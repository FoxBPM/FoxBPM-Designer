/**
 */
package org.foxbpm.model.config.connector.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.foxbpm.model.config.connector.ConnectorPackage;
import org.foxbpm.model.config.connector.WidgetExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Widget Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.connector.impl.WidgetExpressionImpl#getExpressionValue <em>Expression Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WidgetExpressionImpl extends MinimalEObjectImpl.Container implements WidgetExpression {
	/**
	 * The default value of the '{@link #getExpressionValue() <em>Expression Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionValue()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPRESSION_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExpressionValue() <em>Expression Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionValue()
	 * @generated
	 * @ordered
	 */
	protected String expressionValue = EXPRESSION_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WidgetExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConnectorPackage.Literals.WIDGET_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpressionValue() {
		return expressionValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpressionValue(String newExpressionValue) {
		String oldExpressionValue = expressionValue;
		expressionValue = newExpressionValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConnectorPackage.WIDGET_EXPRESSION__EXPRESSION_VALUE, oldExpressionValue, expressionValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConnectorPackage.WIDGET_EXPRESSION__EXPRESSION_VALUE:
				return getExpressionValue();
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
			case ConnectorPackage.WIDGET_EXPRESSION__EXPRESSION_VALUE:
				setExpressionValue((String)newValue);
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
			case ConnectorPackage.WIDGET_EXPRESSION__EXPRESSION_VALUE:
				setExpressionValue(EXPRESSION_VALUE_EDEFAULT);
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
			case ConnectorPackage.WIDGET_EXPRESSION__EXPRESSION_VALUE:
				return EXPRESSION_VALUE_EDEFAULT == null ? expressionValue != null : !EXPRESSION_VALUE_EDEFAULT.equals(expressionValue);
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
		result.append(" (expressionValue: ");
		result.append(expressionValue);
		result.append(')');
		return result.toString();
	}

} //WidgetExpressionImpl
