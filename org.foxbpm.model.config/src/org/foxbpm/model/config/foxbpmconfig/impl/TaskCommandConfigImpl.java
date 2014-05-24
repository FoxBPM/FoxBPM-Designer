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
import org.foxbpm.model.config.foxbpmconfig.TaskCommandModelDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task Command Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.TaskCommandConfigImpl#getTaskCommandModelDefinitions <em>Task Command Model Definitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskCommandConfigImpl extends BaseConfigImpl implements TaskCommandConfig {
	/**
	 * The cached value of the '{@link #getTaskCommandModelDefinitions() <em>Task Command Model Definitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskCommandModelDefinitions()
	 * @generated
	 * @ordered
	 */
	protected EList<TaskCommandModelDefinition> taskCommandModelDefinitions;
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
	public EList<TaskCommandModelDefinition> getTaskCommandModelDefinitions() {
		if (taskCommandModelDefinitions == null) {
			taskCommandModelDefinitions = new EObjectContainmentEList<TaskCommandModelDefinition>(TaskCommandModelDefinition.class, this, FoxBPMConfigPackage.TASK_COMMAND_CONFIG__TASK_COMMAND_MODEL_DEFINITIONS);
		}
		return taskCommandModelDefinitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FoxBPMConfigPackage.TASK_COMMAND_CONFIG__TASK_COMMAND_MODEL_DEFINITIONS:
				return ((InternalEList<?>)getTaskCommandModelDefinitions()).basicRemove(otherEnd, msgs);
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
			case FoxBPMConfigPackage.TASK_COMMAND_CONFIG__TASK_COMMAND_MODEL_DEFINITIONS:
				return getTaskCommandModelDefinitions();
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
			case FoxBPMConfigPackage.TASK_COMMAND_CONFIG__TASK_COMMAND_MODEL_DEFINITIONS:
				getTaskCommandModelDefinitions().clear();
				getTaskCommandModelDefinitions().addAll((Collection<? extends TaskCommandModelDefinition>)newValue);
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
			case FoxBPMConfigPackage.TASK_COMMAND_CONFIG__TASK_COMMAND_MODEL_DEFINITIONS:
				getTaskCommandModelDefinitions().clear();
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
			case FoxBPMConfigPackage.TASK_COMMAND_CONFIG__TASK_COMMAND_MODEL_DEFINITIONS:
				return taskCommandModelDefinitions != null && !taskCommandModelDefinitions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TaskCommandConfigImpl
