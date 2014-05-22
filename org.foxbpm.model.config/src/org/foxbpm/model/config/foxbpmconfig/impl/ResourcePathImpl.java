/**
 */
package org.foxbpm.model.config.foxbpmconfig.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage;
import org.foxbpm.model.config.foxbpmconfig.ResourcePath;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Path</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.ResourcePathImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.ResourcePathImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.ResourcePathImpl#getSrc <em>Src</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.ResourcePathImpl#getPhysicalPath <em>Physical Path</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.ResourcePathImpl#getVirtualPath <em>Virtual Path</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.ResourcePathImpl#getProjectName <em>Project Name</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.ResourcePathImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourcePathImpl extends BaseConfigImpl implements ResourcePath {
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
	 * The default value of the '{@link #getSrc() <em>Src</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrc()
	 * @generated
	 * @ordered
	 */
	protected static final String SRC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSrc() <em>Src</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrc()
	 * @generated
	 * @ordered
	 */
	protected String src = SRC_EDEFAULT;

	/**
	 * The default value of the '{@link #getPhysicalPath() <em>Physical Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhysicalPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PHYSICAL_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPhysicalPath() <em>Physical Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhysicalPath()
	 * @generated
	 * @ordered
	 */
	protected String physicalPath = PHYSICAL_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getVirtualPath() <em>Virtual Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVirtualPath()
	 * @generated
	 * @ordered
	 */
	protected static final String VIRTUAL_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVirtualPath() <em>Virtual Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVirtualPath()
	 * @generated
	 * @ordered
	 */
	protected String virtualPath = VIRTUAL_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getProjectName() <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProjectName() <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectName()
	 * @generated
	 * @ordered
	 */
	protected String projectName = PROJECT_NAME_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourcePathImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FoxBPMConfigPackage.Literals.RESOURCE_PATH;
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
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.RESOURCE_PATH__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.RESOURCE_PATH__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSrc() {
		return src;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSrc(String newSrc) {
		String oldSrc = src;
		src = newSrc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.RESOURCE_PATH__SRC, oldSrc, src));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPhysicalPath() {
		return physicalPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhysicalPath(String newPhysicalPath) {
		String oldPhysicalPath = physicalPath;
		physicalPath = newPhysicalPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.RESOURCE_PATH__PHYSICAL_PATH, oldPhysicalPath, physicalPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVirtualPath() {
		return virtualPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVirtualPath(String newVirtualPath) {
		String oldVirtualPath = virtualPath;
		virtualPath = newVirtualPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.RESOURCE_PATH__VIRTUAL_PATH, oldVirtualPath, virtualPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectName(String newProjectName) {
		String oldProjectName = projectName;
		projectName = newProjectName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.RESOURCE_PATH__PROJECT_NAME, oldProjectName, projectName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.RESOURCE_PATH__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FoxBPMConfigPackage.RESOURCE_PATH__ID:
				return getId();
			case FoxBPMConfigPackage.RESOURCE_PATH__NAME:
				return getName();
			case FoxBPMConfigPackage.RESOURCE_PATH__SRC:
				return getSrc();
			case FoxBPMConfigPackage.RESOURCE_PATH__PHYSICAL_PATH:
				return getPhysicalPath();
			case FoxBPMConfigPackage.RESOURCE_PATH__VIRTUAL_PATH:
				return getVirtualPath();
			case FoxBPMConfigPackage.RESOURCE_PATH__PROJECT_NAME:
				return getProjectName();
			case FoxBPMConfigPackage.RESOURCE_PATH__TYPE:
				return getType();
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
			case FoxBPMConfigPackage.RESOURCE_PATH__ID:
				setId((String)newValue);
				return;
			case FoxBPMConfigPackage.RESOURCE_PATH__NAME:
				setName((String)newValue);
				return;
			case FoxBPMConfigPackage.RESOURCE_PATH__SRC:
				setSrc((String)newValue);
				return;
			case FoxBPMConfigPackage.RESOURCE_PATH__PHYSICAL_PATH:
				setPhysicalPath((String)newValue);
				return;
			case FoxBPMConfigPackage.RESOURCE_PATH__VIRTUAL_PATH:
				setVirtualPath((String)newValue);
				return;
			case FoxBPMConfigPackage.RESOURCE_PATH__PROJECT_NAME:
				setProjectName((String)newValue);
				return;
			case FoxBPMConfigPackage.RESOURCE_PATH__TYPE:
				setType((String)newValue);
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
			case FoxBPMConfigPackage.RESOURCE_PATH__ID:
				setId(ID_EDEFAULT);
				return;
			case FoxBPMConfigPackage.RESOURCE_PATH__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FoxBPMConfigPackage.RESOURCE_PATH__SRC:
				setSrc(SRC_EDEFAULT);
				return;
			case FoxBPMConfigPackage.RESOURCE_PATH__PHYSICAL_PATH:
				setPhysicalPath(PHYSICAL_PATH_EDEFAULT);
				return;
			case FoxBPMConfigPackage.RESOURCE_PATH__VIRTUAL_PATH:
				setVirtualPath(VIRTUAL_PATH_EDEFAULT);
				return;
			case FoxBPMConfigPackage.RESOURCE_PATH__PROJECT_NAME:
				setProjectName(PROJECT_NAME_EDEFAULT);
				return;
			case FoxBPMConfigPackage.RESOURCE_PATH__TYPE:
				setType(TYPE_EDEFAULT);
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
			case FoxBPMConfigPackage.RESOURCE_PATH__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case FoxBPMConfigPackage.RESOURCE_PATH__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FoxBPMConfigPackage.RESOURCE_PATH__SRC:
				return SRC_EDEFAULT == null ? src != null : !SRC_EDEFAULT.equals(src);
			case FoxBPMConfigPackage.RESOURCE_PATH__PHYSICAL_PATH:
				return PHYSICAL_PATH_EDEFAULT == null ? physicalPath != null : !PHYSICAL_PATH_EDEFAULT.equals(physicalPath);
			case FoxBPMConfigPackage.RESOURCE_PATH__VIRTUAL_PATH:
				return VIRTUAL_PATH_EDEFAULT == null ? virtualPath != null : !VIRTUAL_PATH_EDEFAULT.equals(virtualPath);
			case FoxBPMConfigPackage.RESOURCE_PATH__PROJECT_NAME:
				return PROJECT_NAME_EDEFAULT == null ? projectName != null : !PROJECT_NAME_EDEFAULT.equals(projectName);
			case FoxBPMConfigPackage.RESOURCE_PATH__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
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
		result.append(", src: ");
		result.append(src);
		result.append(", physicalPath: ");
		result.append(physicalPath);
		result.append(", virtualPath: ");
		result.append(virtualPath);
		result.append(", projectName: ");
		result.append(projectName);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //ResourcePathImpl
