/**
 */
package org.foxbpm.model.config.foxbpmconfig.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage;
import org.foxbpm.model.config.foxbpmconfig.ScriptLanguage;
import org.foxbpm.model.config.foxbpmconfig.ScriptLanguageConfig;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Script Language Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.ScriptLanguageConfigImpl#getScriptLanguage <em>Script Language</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScriptLanguageConfigImpl extends MinimalEObjectImpl.Container implements ScriptLanguageConfig {
	/**
	 * The cached value of the '{@link #getScriptLanguage() <em>Script Language</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptLanguage()
	 * @generated
	 * @ordered
	 */
	protected EList<ScriptLanguage> scriptLanguage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScriptLanguageConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FoxBPMConfigPackage.Literals.SCRIPT_LANGUAGE_CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ScriptLanguage> getScriptLanguage() {
		if (scriptLanguage == null) {
			scriptLanguage = new EObjectContainmentEList<ScriptLanguage>(ScriptLanguage.class, this, FoxBPMConfigPackage.SCRIPT_LANGUAGE_CONFIG__SCRIPT_LANGUAGE);
		}
		return scriptLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FoxBPMConfigPackage.SCRIPT_LANGUAGE_CONFIG__SCRIPT_LANGUAGE:
				return ((InternalEList<?>)getScriptLanguage()).basicRemove(otherEnd, msgs);
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
			case FoxBPMConfigPackage.SCRIPT_LANGUAGE_CONFIG__SCRIPT_LANGUAGE:
				return getScriptLanguage();
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
			case FoxBPMConfigPackage.SCRIPT_LANGUAGE_CONFIG__SCRIPT_LANGUAGE:
				getScriptLanguage().clear();
				getScriptLanguage().addAll((Collection<? extends ScriptLanguage>)newValue);
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
			case FoxBPMConfigPackage.SCRIPT_LANGUAGE_CONFIG__SCRIPT_LANGUAGE:
				getScriptLanguage().clear();
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
			case FoxBPMConfigPackage.SCRIPT_LANGUAGE_CONFIG__SCRIPT_LANGUAGE:
				return scriptLanguage != null && !scriptLanguage.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ScriptLanguageConfigImpl
