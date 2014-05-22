/**
 */
package org.foxbpm.model.config.foxbpmconfig;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 引擎资源
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.ResourcePath#getId <em>Id</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.ResourcePath#getName <em>Name</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.ResourcePath#getSrc <em>Src</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.ResourcePath#getPhysicalPath <em>Physical Path</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.ResourcePath#getVirtualPath <em>Virtual Path</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.ResourcePath#getProjectName <em>Project Name</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.ResourcePath#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getResourcePath()
 * @model
 * @generated
 */
public interface ResourcePath extends BaseConfig {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 资源编号
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getResourcePath_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.foxbpmconfig.ResourcePath#getId <em>Id</em>}' attribute.
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
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 名称
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getResourcePath_Name()
	 * @model extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.foxbpmconfig.ResourcePath#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Src</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * java虚拟机路径
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Src</em>' attribute.
	 * @see #setSrc(String)
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getResourcePath_Src()
	 * @model extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getSrc();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.foxbpmconfig.ResourcePath#getSrc <em>Src</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src</em>' attribute.
	 * @see #getSrc()
	 * @generated
	 */
	void setSrc(String value);

	/**
	 * Returns the value of the '<em><b>Physical Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 物理路径
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Physical Path</em>' attribute.
	 * @see #setPhysicalPath(String)
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getResourcePath_PhysicalPath()
	 * @model extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getPhysicalPath();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.foxbpmconfig.ResourcePath#getPhysicalPath <em>Physical Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Physical Path</em>' attribute.
	 * @see #getPhysicalPath()
	 * @generated
	 */
	void setPhysicalPath(String value);

	/**
	 * Returns the value of the '<em><b>Virtual Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 虚拟路径
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Virtual Path</em>' attribute.
	 * @see #setVirtualPath(String)
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getResourcePath_VirtualPath()
	 * @model extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getVirtualPath();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.foxbpmconfig.ResourcePath#getVirtualPath <em>Virtual Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Virtual Path</em>' attribute.
	 * @see #getVirtualPath()
	 * @generated
	 */
	void setVirtualPath(String value);

	/**
	 * Returns the value of the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 项目名称
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Project Name</em>' attribute.
	 * @see #setProjectName(String)
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getResourcePath_ProjectName()
	 * @model extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getProjectName();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.foxbpmconfig.ResourcePath#getProjectName <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Name</em>' attribute.
	 * @see #getProjectName()
	 * @generated
	 */
	void setProjectName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage#getResourcePath_Type()
	 * @model extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.foxbpm.model.config.foxbpmconfig.ResourcePath#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // ResourcePath
