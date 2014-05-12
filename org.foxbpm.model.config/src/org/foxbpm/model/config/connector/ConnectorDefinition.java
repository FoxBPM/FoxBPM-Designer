/**
 */
package org.foxbpm.model.config.connector;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.connector.ConnectorDefinition#getId <em>Id</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.ConnectorDefinition#getName <em>Name</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.ConnectorDefinition#getNote <em>Note</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.ConnectorDefinition#getCategoryId <em>Category Id</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.ConnectorDefinition#getIcon <em>Icon</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.ConnectorDefinition#getInput <em>Input</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.ConnectorDefinition#getOutput <em>Output</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.ConnectorDefinition#getPage <em>Page</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.ConnectorDefinition#getVersion <em>Version</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.ConnectorDefinition#getDefinitionImpl <em>Definition Impl</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.ConnectorDefinition#getConnrctorType <em>Connrctor Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.config.connector.ConnectorPackage#getConnectorDefinition()
 * @model
 * @generated
 */
public interface ConnectorDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getConnectorDefinition_Id()
	 * @model required="true"
	 *        extendedMetaData="kind='attribute' name='id'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.connector.ConnectorDefinition#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getConnectorDefinition_Name()
	 * @model extendedMetaData="name='name' kind='attribute'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.connector.ConnectorDefinition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Note</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Note</em>' attribute.
	 * @see #setNote(String)
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getConnectorDefinition_Note()
	 * @model extendedMetaData="name='note' kind='attribute'"
	 * @generated
	 */
	String getNote();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.connector.ConnectorDefinition#getNote <em>Note</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Note</em>' attribute.
	 * @see #getNote()
	 * @generated
	 */
	void setNote(String value);

	/**
	 * Returns the value of the '<em><b>Category Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category Id</em>' attribute.
	 * @see #setCategoryId(String)
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getConnectorDefinition_CategoryId()
	 * @model extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getCategoryId();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.connector.ConnectorDefinition#getCategoryId <em>Category Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category Id</em>' attribute.
	 * @see #getCategoryId()
	 * @generated
	 */
	void setCategoryId(String value);

	/**
	 * Returns the value of the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon</em>' attribute.
	 * @see #setIcon(String)
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getConnectorDefinition_Icon()
	 * @model extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getIcon();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.connector.ConnectorDefinition#getIcon <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon</em>' attribute.
	 * @see #getIcon()
	 * @generated
	 */
	void setIcon(String value);

	/**
	 * Returns the value of the '<em><b>Input</b></em>' containment reference list.
	 * The list contents are of type {@link org.foxbpm.model.config.connector.Input}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input</em>' containment reference list.
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getConnectorDefinition_Input()
	 * @model containment="true"
	 *        extendedMetaData="kind='element'"
	 * @generated
	 */
	EList<Input> getInput();

	/**
	 * Returns the value of the '<em><b>Output</b></em>' containment reference list.
	 * The list contents are of type {@link org.foxbpm.model.config.connector.Output}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output</em>' containment reference list.
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getConnectorDefinition_Output()
	 * @model containment="true"
	 *        extendedMetaData="name='output' kind='element'"
	 * @generated
	 */
	EList<Output> getOutput();

	/**
	 * Returns the value of the '<em><b>Page</b></em>' containment reference list.
	 * The list contents are of type {@link org.foxbpm.model.config.connector.Page}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Page</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Page</em>' containment reference list.
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getConnectorDefinition_Page()
	 * @model containment="true"
	 *        extendedMetaData="name='page' kind='element'"
	 * @generated
	 */
	EList<Page> getPage();

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getConnectorDefinition_Version()
	 * @model extendedMetaData="name='version' kind='attribute'"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.connector.ConnectorDefinition#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Definition Impl</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition Impl</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition Impl</em>' containment reference.
	 * @see #setDefinitionImpl(DefinitionImpl)
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getConnectorDefinition_DefinitionImpl()
	 * @model containment="true"
	 *        extendedMetaData="name='definitionImpl' kind='element'"
	 * @generated
	 */
	DefinitionImpl getDefinitionImpl();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.connector.ConnectorDefinition#getDefinitionImpl <em>Definition Impl</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition Impl</em>' containment reference.
	 * @see #getDefinitionImpl()
	 * @generated
	 */
	void setDefinitionImpl(DefinitionImpl value);

	/**
	 * Returns the value of the '<em><b>Connrctor Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connrctor Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connrctor Type</em>' attribute.
	 * @see #setConnrctorType(String)
	 * @see org.foxbpm.model.config.connector.ConnectorPackage#getConnectorDefinition_ConnrctorType()
	 * @model extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getConnrctorType();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.connector.ConnectorDefinition#getConnrctorType <em>Connrctor Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connrctor Type</em>' attribute.
	 * @see #getConnrctorType()
	 * @generated
	 */
	void setConnrctorType(String value);

} // ConnectorDefinition
