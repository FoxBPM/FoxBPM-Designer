/**
 */
package org.foxbpm.model.config.foxbpmconfig.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.foxbpm.model.config.foxbpmconfig.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage
 * @generated
 */
public class FoxBPMConfigSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static FoxBPMConfigPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FoxBPMConfigSwitch() {
		if (modelPackage == null) {
			modelPackage = FoxBPMConfigPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case FoxBPMConfigPackage.FOX_BPM_CONFIG: {
				FoxBPMConfig foxBPMConfig = (FoxBPMConfig)theEObject;
				T result = caseFoxBPMConfig(foxBPMConfig);
				if (result == null) result = caseBaseConfig(foxBPMConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMConfigPackage.SYS_MAIL_CONFIG: {
				SysMailConfig sysMailConfig = (SysMailConfig)theEObject;
				T result = caseSysMailConfig(sysMailConfig);
				if (result == null) result = caseBaseConfig(sysMailConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMConfigPackage.CONNECTION_MANAGEMENT_CONFIG: {
				ConnectionManagementConfig connectionManagementConfig = (ConnectionManagementConfig)theEObject;
				T result = caseConnectionManagementConfig(connectionManagementConfig);
				if (result == null) result = caseBaseConfig(connectionManagementConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMConfigPackage.CONNECTION_MANAGEMENT: {
				ConnectionManagement connectionManagement = (ConnectionManagement)theEObject;
				T result = caseConnectionManagement(connectionManagement);
				if (result == null) result = caseBaseConfig(connectionManagement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMConfigPackage.RESOURCE_PATH_CONFIG: {
				ResourcePathConfig resourcePathConfig = (ResourcePathConfig)theEObject;
				T result = caseResourcePathConfig(resourcePathConfig);
				if (result == null) result = caseBaseConfig(resourcePathConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMConfigPackage.RESOURCE_PATH: {
				ResourcePath resourcePath = (ResourcePath)theEObject;
				T result = caseResourcePath(resourcePath);
				if (result == null) result = caseBaseConfig(resourcePath);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMConfigPackage.MAIL_INFO: {
				MailInfo mailInfo = (MailInfo)theEObject;
				T result = caseMailInfo(mailInfo);
				if (result == null) result = caseBaseConfig(mailInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMConfigPackage.TASK_COMMAND_CONFIG: {
				TaskCommandConfig taskCommandConfig = (TaskCommandConfig)theEObject;
				T result = caseTaskCommandConfig(taskCommandConfig);
				if (result == null) result = caseBaseConfig(taskCommandConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMConfigPackage.PARAM: {
				Param param = (Param)theEObject;
				T result = caseParam(param);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMConfigPackage.BASE_CONFIG: {
				BaseConfig baseConfig = (BaseConfig)theEObject;
				T result = caseBaseConfig(baseConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMConfigPackage.TASK_COMMAND_DEFINITION: {
				TaskCommandDefinition taskCommandDefinition = (TaskCommandDefinition)theEObject;
				T result = caseTaskCommandDefinition(taskCommandDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMConfigPackage.SCRIPT_LANGUAGE_CONFIG: {
				ScriptLanguageConfig scriptLanguageConfig = (ScriptLanguageConfig)theEObject;
				T result = caseScriptLanguageConfig(scriptLanguageConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMConfigPackage.SCRIPT_LANGUAGE: {
				ScriptLanguage scriptLanguage = (ScriptLanguage)theEObject;
				T result = caseScriptLanguage(scriptLanguage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMConfigPackage.EVENT_LISTENER_CONFIG: {
				EventListenerConfig eventListenerConfig = (EventListenerConfig)theEObject;
				T result = caseEventListenerConfig(eventListenerConfig);
				if (result == null) result = caseBaseConfig(eventListenerConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMConfigPackage.EVENT_LISTENER: {
				EventListener eventListener = (EventListener)theEObject;
				T result = caseEventListener(eventListener);
				if (result == null) result = caseBaseConfig(eventListener);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMConfigPackage.BIZ_DATA_OBJECT_CONFIG: {
				BizDataObjectConfig bizDataObjectConfig = (BizDataObjectConfig)theEObject;
				T result = caseBizDataObjectConfig(bizDataObjectConfig);
				if (result == null) result = caseBaseConfig(bizDataObjectConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMConfigPackage.DATA_OBJECT_BEHAVIOR: {
				DataObjectBehavior dataObjectBehavior = (DataObjectBehavior)theEObject;
				T result = caseDataObjectBehavior(dataObjectBehavior);
				if (result == null) result = caseBaseConfig(dataObjectBehavior);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FoxBPMConfigPackage.COMMAND_PARAM: {
				CommandParam commandParam = (CommandParam)theEObject;
				T result = caseCommandParam(commandParam);
				if (result == null) result = caseParam(commandParam);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fox BPM Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fox BPM Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFoxBPMConfig(FoxBPMConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sys Mail Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sys Mail Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSysMailConfig(SysMailConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connection Management Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection Management Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectionManagementConfig(ConnectionManagementConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connection Management</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection Management</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectionManagement(ConnectionManagement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Path Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Path Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourcePathConfig(ResourcePathConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Path</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Path</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourcePath(ResourcePath object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mail Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mail Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMailInfo(MailInfo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task Command Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task Command Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaskCommandConfig(TaskCommandConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Param</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Param</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParam(Param object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBaseConfig(BaseConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task Command Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task Command Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaskCommandDefinition(TaskCommandDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Script Language Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Script Language Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScriptLanguageConfig(ScriptLanguageConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Script Language</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Script Language</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScriptLanguage(ScriptLanguage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Listener Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Listener Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventListenerConfig(EventListenerConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Listener</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Listener</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventListener(EventListener object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Biz Data Object Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Biz Data Object Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBizDataObjectConfig(BizDataObjectConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Object Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Object Behavior</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataObjectBehavior(DataObjectBehavior object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Command Param</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Command Param</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommandParam(CommandParam object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //FoxBPMConfigSwitch
