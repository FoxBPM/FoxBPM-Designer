/**
 */
package org.foxbpm.model.config.connector.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.foxbpm.model.config.connector.ConnectorPackage;
import org.foxbpm.model.config.connector.Widget;
import org.foxbpm.model.config.connector.WidgetExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Widget</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.connector.impl.WidgetImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.impl.WidgetImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.impl.WidgetImpl#getInputId <em>Input Id</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.impl.WidgetImpl#getWidgetExpression <em>Widget Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class WidgetImpl extends MinimalEObjectImpl.Container implements Widget {
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
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getInputId() <em>Input Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputId()
	 * @generated
	 * @ordered
	 */
	protected static final String INPUT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInputId() <em>Input Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputId()
	 * @generated
	 * @ordered
	 */
	protected String inputId = INPUT_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getWidgetExpression() <em>Widget Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidgetExpression()
	 * @generated
	 * @ordered
	 */
	protected WidgetExpression widgetExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WidgetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConnectorPackage.Literals.WIDGET;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConnectorPackage.WIDGET__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConnectorPackage.WIDGET__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInputId() {
		return inputId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputId(String newInputId) {
		String oldInputId = inputId;
		inputId = newInputId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConnectorPackage.WIDGET__INPUT_ID, oldInputId, inputId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WidgetExpression getWidgetExpression() {
		return widgetExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWidgetExpression(WidgetExpression newWidgetExpression, NotificationChain msgs) {
		WidgetExpression oldWidgetExpression = widgetExpression;
		widgetExpression = newWidgetExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConnectorPackage.WIDGET__WIDGET_EXPRESSION, oldWidgetExpression, newWidgetExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidgetExpression(WidgetExpression newWidgetExpression) {
		if (newWidgetExpression != widgetExpression) {
			NotificationChain msgs = null;
			if (widgetExpression != null)
				msgs = ((InternalEObject)widgetExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConnectorPackage.WIDGET__WIDGET_EXPRESSION, null, msgs);
			if (newWidgetExpression != null)
				msgs = ((InternalEObject)newWidgetExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConnectorPackage.WIDGET__WIDGET_EXPRESSION, null, msgs);
			msgs = basicSetWidgetExpression(newWidgetExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConnectorPackage.WIDGET__WIDGET_EXPRESSION, newWidgetExpression, newWidgetExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConnectorPackage.WIDGET__WIDGET_EXPRESSION:
				return basicSetWidgetExpression(null, msgs);
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
			case ConnectorPackage.WIDGET__ID:
				return getId();
			case ConnectorPackage.WIDGET__NAME:
				return getName();
			case ConnectorPackage.WIDGET__INPUT_ID:
				return getInputId();
			case ConnectorPackage.WIDGET__WIDGET_EXPRESSION:
				return getWidgetExpression();
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
			case ConnectorPackage.WIDGET__ID:
				setId((String)newValue);
				return;
			case ConnectorPackage.WIDGET__NAME:
				setName((String)newValue);
				return;
			case ConnectorPackage.WIDGET__INPUT_ID:
				setInputId((String)newValue);
				return;
			case ConnectorPackage.WIDGET__WIDGET_EXPRESSION:
				setWidgetExpression((WidgetExpression)newValue);
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
			case ConnectorPackage.WIDGET__ID:
				setId(ID_EDEFAULT);
				return;
			case ConnectorPackage.WIDGET__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConnectorPackage.WIDGET__INPUT_ID:
				setInputId(INPUT_ID_EDEFAULT);
				return;
			case ConnectorPackage.WIDGET__WIDGET_EXPRESSION:
				setWidgetExpression((WidgetExpression)null);
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
			case ConnectorPackage.WIDGET__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ConnectorPackage.WIDGET__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConnectorPackage.WIDGET__INPUT_ID:
				return INPUT_ID_EDEFAULT == null ? inputId != null : !INPUT_ID_EDEFAULT.equals(inputId);
			case ConnectorPackage.WIDGET__WIDGET_EXPRESSION:
				return widgetExpression != null;
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
		result.append(", name: ");
		result.append(name);
		result.append(", inputId: ");
		result.append(inputId);
		result.append(')');
		return result.toString();
	}

} //WidgetImpl
