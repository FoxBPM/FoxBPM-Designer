/**
 */
package org.foxbpm.model.config.foxbpmconfig.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.foxbpm.model.config.foxbpmconfig.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage
 * @generated
 */
public class FoxBPMConfigAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static FoxBPMConfigPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FoxBPMConfigAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = FoxBPMConfigPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FoxBPMConfigSwitch<Adapter> modelSwitch =
		new FoxBPMConfigSwitch<Adapter>() {
			@Override
			public Adapter caseFoxBPMConfig(FoxBPMConfig object) {
				return createFoxBPMConfigAdapter();
			}
			@Override
			public Adapter caseSysMailConfig(SysMailConfig object) {
				return createSysMailConfigAdapter();
			}
			@Override
			public Adapter caseConnectionManagementConfig(ConnectionManagementConfig object) {
				return createConnectionManagementConfigAdapter();
			}
			@Override
			public Adapter caseConnectionManagement(ConnectionManagement object) {
				return createConnectionManagementAdapter();
			}
			@Override
			public Adapter caseResourcePathConfig(ResourcePathConfig object) {
				return createResourcePathConfigAdapter();
			}
			@Override
			public Adapter caseResourcePath(ResourcePath object) {
				return createResourcePathAdapter();
			}
			@Override
			public Adapter caseMailInfo(MailInfo object) {
				return createMailInfoAdapter();
			}
			@Override
			public Adapter caseTaskCommandConfig(TaskCommandConfig object) {
				return createTaskCommandConfigAdapter();
			}
			@Override
			public Adapter caseParam(Param object) {
				return createParamAdapter();
			}
			@Override
			public Adapter caseBaseConfig(BaseConfig object) {
				return createBaseConfigAdapter();
			}
			@Override
			public Adapter caseTaskCommandDefinition(TaskCommandDefinition object) {
				return createTaskCommandDefinitionAdapter();
			}
			@Override
			public Adapter caseScriptLanguageConfig(ScriptLanguageConfig object) {
				return createScriptLanguageConfigAdapter();
			}
			@Override
			public Adapter caseScriptLanguage(ScriptLanguage object) {
				return createScriptLanguageAdapter();
			}
			@Override
			public Adapter caseEventListenerConfig(EventListenerConfig object) {
				return createEventListenerConfigAdapter();
			}
			@Override
			public Adapter caseEventListener(EventListener object) {
				return createEventListenerAdapter();
			}
			@Override
			public Adapter caseBizDataObjectConfig(BizDataObjectConfig object) {
				return createBizDataObjectConfigAdapter();
			}
			@Override
			public Adapter caseDataObjectBehavior(DataObjectBehavior object) {
				return createDataObjectBehaviorAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig <em>Fox BPM Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig
	 * @generated
	 */
	public Adapter createFoxBPMConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.config.foxbpmconfig.SysMailConfig <em>Sys Mail Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.config.foxbpmconfig.SysMailConfig
	 * @generated
	 */
	public Adapter createSysMailConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.config.foxbpmconfig.ConnectionManagementConfig <em>Connection Management Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.config.foxbpmconfig.ConnectionManagementConfig
	 * @generated
	 */
	public Adapter createConnectionManagementConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.config.foxbpmconfig.ConnectionManagement <em>Connection Management</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.config.foxbpmconfig.ConnectionManagement
	 * @generated
	 */
	public Adapter createConnectionManagementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.config.foxbpmconfig.ResourcePathConfig <em>Resource Path Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.config.foxbpmconfig.ResourcePathConfig
	 * @generated
	 */
	public Adapter createResourcePathConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.config.foxbpmconfig.ResourcePath <em>Resource Path</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.config.foxbpmconfig.ResourcePath
	 * @generated
	 */
	public Adapter createResourcePathAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.config.foxbpmconfig.MailInfo <em>Mail Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.config.foxbpmconfig.MailInfo
	 * @generated
	 */
	public Adapter createMailInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.config.foxbpmconfig.TaskCommandConfig <em>Task Command Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.config.foxbpmconfig.TaskCommandConfig
	 * @generated
	 */
	public Adapter createTaskCommandConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.config.foxbpmconfig.Param <em>Param</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.config.foxbpmconfig.Param
	 * @generated
	 */
	public Adapter createParamAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.config.foxbpmconfig.BaseConfig <em>Base Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.config.foxbpmconfig.BaseConfig
	 * @generated
	 */
	public Adapter createBaseConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.config.foxbpmconfig.TaskCommandDefinition <em>Task Command Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.config.foxbpmconfig.TaskCommandDefinition
	 * @generated
	 */
	public Adapter createTaskCommandDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.config.foxbpmconfig.ScriptLanguageConfig <em>Script Language Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.config.foxbpmconfig.ScriptLanguageConfig
	 * @generated
	 */
	public Adapter createScriptLanguageConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.config.foxbpmconfig.ScriptLanguage <em>Script Language</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.config.foxbpmconfig.ScriptLanguage
	 * @generated
	 */
	public Adapter createScriptLanguageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.config.foxbpmconfig.EventListenerConfig <em>Event Listener Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.config.foxbpmconfig.EventListenerConfig
	 * @generated
	 */
	public Adapter createEventListenerConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.config.foxbpmconfig.EventListener <em>Event Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.config.foxbpmconfig.EventListener
	 * @generated
	 */
	public Adapter createEventListenerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.config.foxbpmconfig.BizDataObjectConfig <em>Biz Data Object Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.config.foxbpmconfig.BizDataObjectConfig
	 * @generated
	 */
	public Adapter createBizDataObjectConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foxbpm.model.config.foxbpmconfig.DataObjectBehavior <em>Data Object Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foxbpm.model.config.foxbpmconfig.DataObjectBehavior
	 * @generated
	 */
	public Adapter createDataObjectBehaviorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //FoxBPMConfigAdapterFactory
