/**
 */
package org.foxbpm.model.config.connector.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.foxbpm.model.config.connector.ConnectorPackage;
import org.foxbpm.model.config.connector.JarDependencies;
import org.foxbpm.model.config.connector.JarDependency;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jar Dependencies</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.connector.impl.JarDependenciesImpl#getJarDependency <em>Jar Dependency</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JarDependenciesImpl extends MinimalEObjectImpl.Container implements JarDependencies {
	/**
	 * The cached value of the '{@link #getJarDependency() <em>Jar Dependency</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJarDependency()
	 * @generated
	 * @ordered
	 */
	protected EList<JarDependency> jarDependency;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JarDependenciesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConnectorPackage.Literals.JAR_DEPENDENCIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JarDependency> getJarDependency() {
		if (jarDependency == null) {
			jarDependency = new EObjectContainmentEList<JarDependency>(JarDependency.class, this, ConnectorPackage.JAR_DEPENDENCIES__JAR_DEPENDENCY);
		}
		return jarDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConnectorPackage.JAR_DEPENDENCIES__JAR_DEPENDENCY:
				return ((InternalEList<?>)getJarDependency()).basicRemove(otherEnd, msgs);
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
			case ConnectorPackage.JAR_DEPENDENCIES__JAR_DEPENDENCY:
				return getJarDependency();
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
			case ConnectorPackage.JAR_DEPENDENCIES__JAR_DEPENDENCY:
				getJarDependency().clear();
				getJarDependency().addAll((Collection<? extends JarDependency>)newValue);
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
			case ConnectorPackage.JAR_DEPENDENCIES__JAR_DEPENDENCY:
				getJarDependency().clear();
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
			case ConnectorPackage.JAR_DEPENDENCIES__JAR_DEPENDENCY:
				return jarDependency != null && !jarDependency.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //JarDependenciesImpl
