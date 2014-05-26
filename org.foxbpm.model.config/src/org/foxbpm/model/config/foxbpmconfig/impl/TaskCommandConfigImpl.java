/**
 */
package org.foxbpm.model.config.foxbpmconfig.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
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
		}
		return super.eIsSet(featureID);
	}

} //TaskCommandConfigImpl
