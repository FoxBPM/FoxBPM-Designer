/**
 */
package org.foxbpm.model.bpmn.foxbpm.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutput;
import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connector Parameter Output</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorParameterOutputImpl#getVariableTarget <em>Variable Target</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorParameterOutputImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.ConnectorParameterOutputImpl#getOutputId <em>Output Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectorParameterOutputImpl extends MinimalEObjectImpl.Container implements ConnectorParameterOutput {
	/**
	 * The default value of the '{@link #getVariableTarget() <em>Variable Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableTarget()
	 * @generated
	 * @ordered
	 */
	protected static final String VARIABLE_TARGET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVariableTarget() <em>Variable Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableTarget()
	 * @generated
	 * @ordered
	 */
	protected String variableTarget = VARIABLE_TARGET_EDEFAULT;

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
	 * The default value of the '{@link #getOutputId() <em>Output Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputId()
	 * @generated
	 * @ordered
	 */
	protected static final String OUTPUT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutputId() <em>Output Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputId()
	 * @generated
	 * @ordered
	 */
	protected String outputId = OUTPUT_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectorParameterOutputImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FoxBPMPackage.Literals.CONNECTOR_PARAMETER_OUTPUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVariableTarget() {
		return variableTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariableTarget(String newVariableTarget) {
		String oldVariableTarget = variableTarget;
		variableTarget = newVariableTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.CONNECTOR_PARAMETER_OUTPUT__VARIABLE_TARGET, oldVariableTarget, variableTarget));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FoxBPMPackage.CONNECTOR_PARAMETER_OUTPUT__EXPRESSION, oldExpression, newExpression);
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
				msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FoxBPMPackage.CONNECTOR_PARAMETER_OUTPUT__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FoxBPMPackage.CONNECTOR_PARAMETER_OUTPUT__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.CONNECTOR_PARAMETER_OUTPUT__EXPRESSION, newExpression, newExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutputId() {
		return outputId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputId(String newOutputId) {
		String oldOutputId = outputId;
		outputId = newOutputId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMPackage.CONNECTOR_PARAMETER_OUTPUT__OUTPUT_ID, oldOutputId, outputId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FoxBPMPackage.CONNECTOR_PARAMETER_OUTPUT__EXPRESSION:
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
			case FoxBPMPackage.CONNECTOR_PARAMETER_OUTPUT__VARIABLE_TARGET:
				return getVariableTarget();
			case FoxBPMPackage.CONNECTOR_PARAMETER_OUTPUT__EXPRESSION:
				return getExpression();
			case FoxBPMPackage.CONNECTOR_PARAMETER_OUTPUT__OUTPUT_ID:
				return getOutputId();
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
			case FoxBPMPackage.CONNECTOR_PARAMETER_OUTPUT__VARIABLE_TARGET:
				setVariableTarget((String)newValue);
				return;
			case FoxBPMPackage.CONNECTOR_PARAMETER_OUTPUT__EXPRESSION:
				setExpression((Expression)newValue);
				return;
			case FoxBPMPackage.CONNECTOR_PARAMETER_OUTPUT__OUTPUT_ID:
				setOutputId((String)newValue);
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
			case FoxBPMPackage.CONNECTOR_PARAMETER_OUTPUT__VARIABLE_TARGET:
				setVariableTarget(VARIABLE_TARGET_EDEFAULT);
				return;
			case FoxBPMPackage.CONNECTOR_PARAMETER_OUTPUT__EXPRESSION:
				setExpression((Expression)null);
				return;
			case FoxBPMPackage.CONNECTOR_PARAMETER_OUTPUT__OUTPUT_ID:
				setOutputId(OUTPUT_ID_EDEFAULT);
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
			case FoxBPMPackage.CONNECTOR_PARAMETER_OUTPUT__VARIABLE_TARGET:
				return VARIABLE_TARGET_EDEFAULT == null ? variableTarget != null : !VARIABLE_TARGET_EDEFAULT.equals(variableTarget);
			case FoxBPMPackage.CONNECTOR_PARAMETER_OUTPUT__EXPRESSION:
				return expression != null;
			case FoxBPMPackage.CONNECTOR_PARAMETER_OUTPUT__OUTPUT_ID:
				return OUTPUT_ID_EDEFAULT == null ? outputId != null : !OUTPUT_ID_EDEFAULT.equals(outputId);
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
		result.append(" (variableTarget: ");
		result.append(variableTarget);
		result.append(", outputId: ");
		result.append(outputId);
		result.append(')');
		return result.toString();
	}

} //ConnectorParameterOutputImpl
