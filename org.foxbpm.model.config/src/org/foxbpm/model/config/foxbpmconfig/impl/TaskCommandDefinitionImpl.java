/**
 */
package org.foxbpm.model.config.foxbpmconfig.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage;
import org.foxbpm.model.config.foxbpmconfig.TaskCommandDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task Command Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.TaskCommandDefinitionImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.TaskCommandDefinitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.TaskCommandDefinitionImpl#getCommand <em>Command</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.TaskCommandDefinitionImpl#getCmd <em>Cmd</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.TaskCommandDefinitionImpl#getFilter <em>Filter</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.TaskCommandDefinitionImpl#getIsEnabled <em>Is Enabled</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.TaskCommandDefinitionImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.TaskCommandDefinitionImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskCommandDefinitionImpl extends BaseConfigImpl implements TaskCommandDefinition {
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
	 * The default value of the '{@link #getCommand() <em>Command</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommand()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMAND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCommand() <em>Command</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommand()
	 * @generated
	 * @ordered
	 */
	protected String command = COMMAND_EDEFAULT;

	/**
	 * The default value of the '{@link #getCmd() <em>Cmd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCmd()
	 * @generated
	 * @ordered
	 */
	protected static final String CMD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCmd() <em>Cmd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCmd()
	 * @generated
	 * @ordered
	 */
	protected String cmd = CMD_EDEFAULT;

	/**
	 * The default value of the '{@link #getFilter() <em>Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilter()
	 * @generated
	 * @ordered
	 */
	protected static final String FILTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFilter() <em>Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilter()
	 * @generated
	 * @ordered
	 */
	protected String filter = FILTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getIsEnabled() <em>Is Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final String IS_ENABLED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsEnabled() <em>Is Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsEnabled()
	 * @generated
	 * @ordered
	 */
	protected String isEnabled = IS_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaskCommandDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FoxBPMConfigPackage.Literals.TASK_COMMAND_DEFINITION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCommand() {
		return command;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommand(String newCommand) {
		String oldCommand = command;
		command = newCommand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__COMMAND, oldCommand, command));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCmd() {
		return cmd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCmd(String newCmd) {
		String oldCmd = cmd;
		cmd = newCmd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__CMD, oldCmd, cmd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFilter() {
		return filter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilter(String newFilter) {
		String oldFilter = filter;
		filter = newFilter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__FILTER, oldFilter, filter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIsEnabled() {
		return isEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsEnabled(String newIsEnabled) {
		String oldIsEnabled = isEnabled;
		isEnabled = newIsEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__IS_ENABLED, oldIsEnabled, isEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__ID:
				return getId();
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__NAME:
				return getName();
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__COMMAND:
				return getCommand();
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__CMD:
				return getCmd();
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__FILTER:
				return getFilter();
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__IS_ENABLED:
				return getIsEnabled();
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__TYPE:
				return getType();
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__DESCRIPTION:
				return getDescription();
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
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__ID:
				setId((String)newValue);
				return;
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__NAME:
				setName((String)newValue);
				return;
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__COMMAND:
				setCommand((String)newValue);
				return;
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__CMD:
				setCmd((String)newValue);
				return;
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__FILTER:
				setFilter((String)newValue);
				return;
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__IS_ENABLED:
				setIsEnabled((String)newValue);
				return;
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__TYPE:
				setType((String)newValue);
				return;
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__DESCRIPTION:
				setDescription((String)newValue);
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
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__ID:
				setId(ID_EDEFAULT);
				return;
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__COMMAND:
				setCommand(COMMAND_EDEFAULT);
				return;
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__CMD:
				setCmd(CMD_EDEFAULT);
				return;
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__FILTER:
				setFilter(FILTER_EDEFAULT);
				return;
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__IS_ENABLED:
				setIsEnabled(IS_ENABLED_EDEFAULT);
				return;
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
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
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__COMMAND:
				return COMMAND_EDEFAULT == null ? command != null : !COMMAND_EDEFAULT.equals(command);
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__CMD:
				return CMD_EDEFAULT == null ? cmd != null : !CMD_EDEFAULT.equals(cmd);
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__FILTER:
				return FILTER_EDEFAULT == null ? filter != null : !FILTER_EDEFAULT.equals(filter);
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__IS_ENABLED:
				return IS_ENABLED_EDEFAULT == null ? isEnabled != null : !IS_ENABLED_EDEFAULT.equals(isEnabled);
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
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
		result.append(", command: ");
		result.append(command);
		result.append(", cmd: ");
		result.append(cmd);
		result.append(", filter: ");
		result.append(filter);
		result.append(", isEnabled: ");
		result.append(isEnabled);
		result.append(", type: ");
		result.append(type);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //TaskCommandDefinitionImpl
