/**
 */
package org.foxbpm.model.config.foxbpmconfig.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage;
import org.foxbpm.model.config.foxbpmconfig.TaskCommandConfig;
import org.foxbpm.model.config.foxbpmconfig.TaskCommandDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task Command Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.TaskCommandConfigImpl#getTaskCommandDefinition <em>Task Command Definition</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.TaskCommandConfigImpl#getIsAutoClaim <em>Is Auto Claim</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskCommandConfigImpl extends BaseConfigImpl implements TaskCommandConfig {
	/**
	 * The cached value of the '{@link #getTaskCommandDefinition() <em>Task Command Definition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskCommandDefinition()
	 * @generated
	 * @ordered
	 */
	protected EList<TaskCommandDefinition> taskCommandDefinition;
	/**
	 * The default value of the '{@link #getIsAutoClaim() <em>Is Auto Claim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsAutoClaim()
	 * @generated
	 * @ordered
	 */
	protected static final String IS_AUTO_CLAIM_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getIsAutoClaim() <em>Is Auto Claim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsAutoClaim()
	 * @generated
	 * @ordered
	 */
	protected String isAutoClaim = IS_AUTO_CLAIM_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaskCommandConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FoxBPMConfigPackage.Literals.TASK_COMMAND_CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TaskCommandDefinition> getTaskCommandDefinition() {
		if (taskCommandDefinition == null) {
			taskCommandDefinition = new EObjectContainmentEList<TaskCommandDefinition>(TaskCommandDefinition.class, this, FoxBPMConfigPackage.TASK_COMMAND_CONFIG__TASK_COMMAND_DEFINITION);
		}
		return taskCommandDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIsAutoClaim() {
		return isAutoClaim;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAutoClaim(String newIsAutoClaim) {
		String oldIsAutoClaim = isAutoClaim;
		isAutoClaim = newIsAutoClaim;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.TASK_COMMAND_CONFIG__IS_AUTO_CLAIM, oldIsAutoClaim, isAutoClaim));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FoxBPMConfigPackage.TASK_COMMAND_CONFIG__TASK_COMMAND_DEFINITION:
				return ((InternalEList<?>)getTaskCommandDefinition()).basicRemove(otherEnd, msgs);
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
			case FoxBPMConfigPackage.TASK_COMMAND_CONFIG__TASK_COMMAND_DEFINITION:
				return getTaskCommandDefinition();
			case FoxBPMConfigPackage.TASK_COMMAND_CONFIG__IS_AUTO_CLAIM:
				return getIsAutoClaim();
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
			case FoxBPMConfigPackage.TASK_COMMAND_CONFIG__TASK_COMMAND_DEFINITION:
				getTaskCommandDefinition().clear();
				getTaskCommandDefinition().addAll((Collection<? extends TaskCommandDefinition>)newValue);
				return;
			case FoxBPMConfigPackage.TASK_COMMAND_CONFIG__IS_AUTO_CLAIM:
				setIsAutoClaim((String)newValue);
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
			case FoxBPMConfigPackage.TASK_COMMAND_CONFIG__TASK_COMMAND_DEFINITION:
				getTaskCommandDefinition().clear();
				return;
			case FoxBPMConfigPackage.TASK_COMMAND_CONFIG__IS_AUTO_CLAIM:
				setIsAutoClaim(IS_AUTO_CLAIM_EDEFAULT);
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
			case FoxBPMConfigPackage.TASK_COMMAND_CONFIG__TASK_COMMAND_DEFINITION:
				return taskCommandDefinition != null && !taskCommandDefinition.isEmpty();
			case FoxBPMConfigPackage.TASK_COMMAND_CONFIG__IS_AUTO_CLAIM:
				return IS_AUTO_CLAIM_EDEFAULT == null ? isAutoClaim != null : !IS_AUTO_CLAIM_EDEFAULT.equals(isAutoClaim);
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
		result.append(" (isAutoClaim: ");
		result.append(isAutoClaim);
		result.append(')');
		return result.toString();
	}

} //TaskCommandConfigImpl
