/**
 */
package org.foxbpm.model.bpmn.foxbpm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expected Execution Time</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ExpectedExecutionTime#getDay <em>Day</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ExpectedExecutionTime#getHour <em>Hour</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ExpectedExecutionTime#getMinute <em>Minute</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ExpectedExecutionTime#getSecond <em>Second</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getExpectedExecutionTime()
 * @model
 * @generated
 */
public interface ExpectedExecutionTime extends EObject {
	/**
	 * Returns the value of the '<em><b>Day</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Day</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Day</em>' attribute.
	 * @see #setDay(int)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getExpectedExecutionTime_Day()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 *        extendedMetaData="kind='attribute'"
	 * @generated
	 */
	int getDay();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.ExpectedExecutionTime#getDay <em>Day</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Day</em>' attribute.
	 * @see #getDay()
	 * @generated
	 */
	void setDay(int value);

	/**
	 * Returns the value of the '<em><b>Hour</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hour</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hour</em>' attribute.
	 * @see #setHour(int)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getExpectedExecutionTime_Hour()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 *        extendedMetaData="kind='attribute'"
	 * @generated
	 */
	int getHour();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.ExpectedExecutionTime#getHour <em>Hour</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hour</em>' attribute.
	 * @see #getHour()
	 * @generated
	 */
	void setHour(int value);

	/**
	 * Returns the value of the '<em><b>Minute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minute</em>' attribute.
	 * @see #setMinute(int)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getExpectedExecutionTime_Minute()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 *        extendedMetaData="kind='attribute'"
	 * @generated
	 */
	int getMinute();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.ExpectedExecutionTime#getMinute <em>Minute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minute</em>' attribute.
	 * @see #getMinute()
	 * @generated
	 */
	void setMinute(int value);

	/**
	 * Returns the value of the '<em><b>Second</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Second</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Second</em>' attribute.
	 * @see #setSecond(int)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getExpectedExecutionTime_Second()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 *        extendedMetaData="kind='attribute'"
	 * @generated
	 */
	int getSecond();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.ExpectedExecutionTime#getSecond <em>Second</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second</em>' attribute.
	 * @see #getSecond()
	 * @generated
	 */
	void setSecond(int value);

} // ExpectedExecutionTime
