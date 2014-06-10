/**
 */
package org.foxbpm.model.config.style;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fix Flow Style Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.style.FixFlowStyleConfig#getElementStyleConfig <em>Element Style Config</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.config.style.StylePackage#getFixFlowStyleConfig()
 * @model extendedMetaData="name='fixFlowStyleConfig'"
 * @generated
 */
public interface FixFlowStyleConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Element Style Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Style Config</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Style Config</em>' containment reference.
	 * @see #setElementStyleConfig(ElementStyleConfig)
	 * @see org.foxbpm.model.config.style.StylePackage#getFixFlowStyleConfig_ElementStyleConfig()
	 * @model containment="true"
	 *        extendedMetaData="name='elementStyleConfig' namespace='' kind='element'"
	 * @generated
	 */
	ElementStyleConfig getElementStyleConfig();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.style.FixFlowStyleConfig#getElementStyleConfig <em>Element Style Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Style Config</em>' containment reference.
	 * @see #getElementStyleConfig()
	 * @generated
	 */
	void setElementStyleConfig(ElementStyleConfig value);

} // FixFlowStyleConfig
