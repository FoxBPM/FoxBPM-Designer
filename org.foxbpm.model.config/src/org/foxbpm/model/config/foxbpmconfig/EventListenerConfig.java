/**
 */
package org.foxbpm.model.config.foxbpmconfig;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Listener Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 事件监听配置
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.EventListenerConfig#getEventListener <em>Event Listener</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getEventListenerConfig()
 * @model
 * @generated
 */
public interface EventListenerConfig extends BaseConfig {
	/**
	 * Returns the value of the '<em><b>Event Listener</b></em>' containment reference list.
	 * The list contents are of type {@link org.foxbpm.model.config.foxbpmconfig.EventListener}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Listener</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Listener</em>' containment reference list.
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getEventListenerConfig_EventListener()
	 * @model containment="true"
	 *        extendedMetaData="name='eventListener' kind='element'"
	 * @generated
	 */
	EList<EventListener> getEventListener();

} // EventListenerConfig
