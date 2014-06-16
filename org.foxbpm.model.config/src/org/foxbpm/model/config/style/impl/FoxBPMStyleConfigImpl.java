/**
 */
package org.foxbpm.model.config.style.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.foxbpm.model.config.style.ElementStyleConfig;
import org.foxbpm.model.config.style.FoxBPMStyleConfig;
import org.foxbpm.model.config.style.StylePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fox BPM Style Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.style.impl.FoxBPMStyleConfigImpl#getElementStyleConfig <em>Element Style Config</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FoxBPMStyleConfigImpl extends MinimalEObjectImpl.Container implements FoxBPMStyleConfig {
	/**
	 * The cached value of the '{@link #getElementStyleConfig() <em>Element Style Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementStyleConfig()
	 * @generated
	 * @ordered
	 */
	protected ElementStyleConfig elementStyleConfig;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FoxBPMStyleConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StylePackage.Literals.FOX_BPM_STYLE_CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementStyleConfig getElementStyleConfig() {
		return elementStyleConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElementStyleConfig(ElementStyleConfig newElementStyleConfig, NotificationChain msgs) {
		ElementStyleConfig oldElementStyleConfig = elementStyleConfig;
		elementStyleConfig = newElementStyleConfig;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StylePackage.FOX_BPM_STYLE_CONFIG__ELEMENT_STYLE_CONFIG, oldElementStyleConfig, newElementStyleConfig);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementStyleConfig(ElementStyleConfig newElementStyleConfig) {
		if (newElementStyleConfig != elementStyleConfig) {
			NotificationChain msgs = null;
			if (elementStyleConfig != null)
				msgs = ((InternalEObject)elementStyleConfig).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StylePackage.FOX_BPM_STYLE_CONFIG__ELEMENT_STYLE_CONFIG, null, msgs);
			if (newElementStyleConfig != null)
				msgs = ((InternalEObject)newElementStyleConfig).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StylePackage.FOX_BPM_STYLE_CONFIG__ELEMENT_STYLE_CONFIG, null, msgs);
			msgs = basicSetElementStyleConfig(newElementStyleConfig, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StylePackage.FOX_BPM_STYLE_CONFIG__ELEMENT_STYLE_CONFIG, newElementStyleConfig, newElementStyleConfig));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StylePackage.FOX_BPM_STYLE_CONFIG__ELEMENT_STYLE_CONFIG:
				return basicSetElementStyleConfig(null, msgs);
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
			case StylePackage.FOX_BPM_STYLE_CONFIG__ELEMENT_STYLE_CONFIG:
				return getElementStyleConfig();
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
			case StylePackage.FOX_BPM_STYLE_CONFIG__ELEMENT_STYLE_CONFIG:
				setElementStyleConfig((ElementStyleConfig)newValue);
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
			case StylePackage.FOX_BPM_STYLE_CONFIG__ELEMENT_STYLE_CONFIG:
				setElementStyleConfig((ElementStyleConfig)null);
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
			case StylePackage.FOX_BPM_STYLE_CONFIG__ELEMENT_STYLE_CONFIG:
				return elementStyleConfig != null;
		}
		return super.eIsSet(featureID);
	}

} //FoxBPMStyleConfigImpl
