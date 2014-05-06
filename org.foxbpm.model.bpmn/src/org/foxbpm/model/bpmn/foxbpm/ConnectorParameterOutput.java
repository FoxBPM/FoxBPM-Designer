/**
 */
package org.foxbpm.model.bpmn.foxbpm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connector Parameter Output</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutput#getVariableTarget <em>Variable Target</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutput#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutput#getOutputId <em>Output Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getConnectorParameterOutput()
 * @model extendedMetaData="name='ConnectorParameterOutput'"
 * @generated
 */
public interface ConnectorParameterOutput extends EObject {
	/**
	 * Returns the value of the '<em><b>Variable Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Target</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Target</em>' attribute.
	 * @see #setVariableTarget(String)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getConnectorParameterOutput_VariableTarget()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getVariableTarget();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutput#getVariableTarget <em>Variable Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Target</em>' attribute.
	 * @see #getVariableTarget()
	 * @generated
	 */
	void setVariableTarget(String value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(Expression)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getConnectorParameterOutput_Expression()
	 * @model containment="true"
	 *        extendedMetaData="name='expression' namespace='##targetNamespace' kind='element'"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutput#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>Output Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Id</em>' attribute.
	 * @see #setOutputId(String)
	 * @see org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage#getConnectorParameterOutput_OutputId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='output'"
	 * @generated
	 */
	String getOutputId();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutput#getOutputId <em>Output Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Id</em>' attribute.
	 * @see #getOutputId()
	 * @generated
	 */
	void setOutputId(String value);

} // ConnectorParameterOutput
