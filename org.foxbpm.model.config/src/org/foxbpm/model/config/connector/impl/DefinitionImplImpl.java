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
import org.foxbpm.model.config.connector.DefinitionImpl;
import org.foxbpm.model.config.connector.JarDependencies;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Definition Impl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.connector.impl.DefinitionImplImpl#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.impl.DefinitionImplImpl#getPackageName <em>Package Name</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.impl.DefinitionImplImpl#getJarDependencies <em>Jar Dependencies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DefinitionImplImpl extends MinimalEObjectImpl.Container implements DefinitionImpl {
	/**
	 * The default value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected String className = CLASS_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPackageName() <em>Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageName()
	 * @generated
	 * @ordered
	 */
	protected static final String PACKAGE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPackageName() <em>Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageName()
	 * @generated
	 * @ordered
	 */
	protected String packageName = PACKAGE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getJarDependencies() <em>Jar Dependencies</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJarDependencies()
	 * @generated
	 * @ordered
	 */
	protected JarDependencies jarDependencies;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefinitionImplImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConnectorPackage.Literals.DEFINITION_IMPL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassName(String newClassName) {
		String oldClassName = className;
		className = newClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConnectorPackage.DEFINITION_IMPL__CLASS_NAME, oldClassName, className));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPackageName() {
		return packageName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackageName(String newPackageName) {
		String oldPackageName = packageName;
		packageName = newPackageName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConnectorPackage.DEFINITION_IMPL__PACKAGE_NAME, oldPackageName, packageName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JarDependencies getJarDependencies() {
		return jarDependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetJarDependencies(JarDependencies newJarDependencies, NotificationChain msgs) {
		JarDependencies oldJarDependencies = jarDependencies;
		jarDependencies = newJarDependencies;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConnectorPackage.DEFINITION_IMPL__JAR_DEPENDENCIES, oldJarDependencies, newJarDependencies);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJarDependencies(JarDependencies newJarDependencies) {
		if (newJarDependencies != jarDependencies) {
			NotificationChain msgs = null;
			if (jarDependencies != null)
				msgs = ((InternalEObject)jarDependencies).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConnectorPackage.DEFINITION_IMPL__JAR_DEPENDENCIES, null, msgs);
			if (newJarDependencies != null)
				msgs = ((InternalEObject)newJarDependencies).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConnectorPackage.DEFINITION_IMPL__JAR_DEPENDENCIES, null, msgs);
			msgs = basicSetJarDependencies(newJarDependencies, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConnectorPackage.DEFINITION_IMPL__JAR_DEPENDENCIES, newJarDependencies, newJarDependencies));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConnectorPackage.DEFINITION_IMPL__JAR_DEPENDENCIES:
				return basicSetJarDependencies(null, msgs);
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
			case ConnectorPackage.DEFINITION_IMPL__CLASS_NAME:
				return getClassName();
			case ConnectorPackage.DEFINITION_IMPL__PACKAGE_NAME:
				return getPackageName();
			case ConnectorPackage.DEFINITION_IMPL__JAR_DEPENDENCIES:
				return getJarDependencies();
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
			case ConnectorPackage.DEFINITION_IMPL__CLASS_NAME:
				setClassName((String)newValue);
				return;
			case ConnectorPackage.DEFINITION_IMPL__PACKAGE_NAME:
				setPackageName((String)newValue);
				return;
			case ConnectorPackage.DEFINITION_IMPL__JAR_DEPENDENCIES:
				setJarDependencies((JarDependencies)newValue);
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
			case ConnectorPackage.DEFINITION_IMPL__CLASS_NAME:
				setClassName(CLASS_NAME_EDEFAULT);
				return;
			case ConnectorPackage.DEFINITION_IMPL__PACKAGE_NAME:
				setPackageName(PACKAGE_NAME_EDEFAULT);
				return;
			case ConnectorPackage.DEFINITION_IMPL__JAR_DEPENDENCIES:
				setJarDependencies((JarDependencies)null);
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
			case ConnectorPackage.DEFINITION_IMPL__CLASS_NAME:
				return CLASS_NAME_EDEFAULT == null ? className != null : !CLASS_NAME_EDEFAULT.equals(className);
			case ConnectorPackage.DEFINITION_IMPL__PACKAGE_NAME:
				return PACKAGE_NAME_EDEFAULT == null ? packageName != null : !PACKAGE_NAME_EDEFAULT.equals(packageName);
			case ConnectorPackage.DEFINITION_IMPL__JAR_DEPENDENCIES:
				return jarDependencies != null;
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
		result.append(" (className: ");
		result.append(className);
		result.append(", packageName: ");
		result.append(packageName);
		result.append(')');
		return result.toString();
	}

} //DefinitionImplImpl
