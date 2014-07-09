/**
 */
package org.foxbpm.model.config.foxbpmconfig;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Listener</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 事件监听
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.EventListener#getEventType <em>Event Type</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.EventListener#getListenerClass <em>Listener Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getEventListener()
 * @model
 * @generated
 */
public interface EventListener extends BaseConfig {
	/**
	 * Returns the value of the '<em><b>Event Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 事件类型
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Event Type</em>' attribute.
	 * @see #setEventType(String)
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getEventListener_EventType()
	 * @model extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getEventType();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.foxbpmconfig.EventListener#getEventType <em>Event Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Type</em>' attribute.
	 * @see #getEventType()
	 * @generated
	 */
	void setEventType(String value);

	/**
	 * Returns the value of the '<em><b>Listener Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 监听类
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Listener Class</em>' attribute.
	 * @see #setListenerClass(String)
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getEventListener_ListenerClass()
	 * @model extendedMetaData="kind='attribute' name='listenerClass'"
	 * @generated
	 */
	String getListenerClass();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.foxbpmconfig.EventListener#getListenerClass <em>Listener Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Listener Class</em>' attribute.
	 * @see #getListenerClass()
	 * @generated
	 */
	void setListenerClass(String value);

} // EventListener
