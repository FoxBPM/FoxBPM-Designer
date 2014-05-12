/**
 */
package org.foxbpm.model.config.connectormenu.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.foxbpm.model.config.connectormenu.ConnectormenuPackage;
import org.foxbpm.model.config.connectormenu.MenuConnector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Menu Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.connectormenu.impl.MenuConnectorImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connectormenu.impl.MenuConnectorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connectormenu.impl.MenuConnectorImpl#getNote <em>Note</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connectormenu.impl.MenuConnectorImpl#getIco <em>Ico</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connectormenu.impl.MenuConnectorImpl#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MenuConnectorImpl extends MinimalEObjectImpl.Container implements MenuConnector {
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
	 * The default value of the '{@link #getNote() <em>Note</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNote()
	 * @generated
	 * @ordered
	 */
	protected static final String NOTE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNote() <em>Note</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNote()
	 * @generated
	 * @ordered
	 */
	protected String note = NOTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIco() <em>Ico</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIco()
	 * @generated
	 * @ordered
	 */
	protected static final String ICO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIco() <em>Ico</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIco()
	 * @generated
	 * @ordered
	 */
	protected String ico = ICO_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MenuConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConnectormenuPackage.Literals.MENU_CONNECTOR;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConnectormenuPackage.MENU_CONNECTOR__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConnectormenuPackage.MENU_CONNECTOR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNote() {
		return note;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNote(String newNote) {
		String oldNote = note;
		note = newNote;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConnectormenuPackage.MENU_CONNECTOR__NOTE, oldNote, note));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIco() {
		return ico;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIco(String newIco) {
		String oldIco = ico;
		ico = newIco;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConnectormenuPackage.MENU_CONNECTOR__ICO, oldIco, ico));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConnectormenuPackage.MENU_CONNECTOR__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConnectormenuPackage.MENU_CONNECTOR__ID:
				return getId();
			case ConnectormenuPackage.MENU_CONNECTOR__NAME:
				return getName();
			case ConnectormenuPackage.MENU_CONNECTOR__NOTE:
				return getNote();
			case ConnectormenuPackage.MENU_CONNECTOR__ICO:
				return getIco();
			case ConnectormenuPackage.MENU_CONNECTOR__VERSION:
				return getVersion();
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
			case ConnectormenuPackage.MENU_CONNECTOR__ID:
				setId((String)newValue);
				return;
			case ConnectormenuPackage.MENU_CONNECTOR__NAME:
				setName((String)newValue);
				return;
			case ConnectormenuPackage.MENU_CONNECTOR__NOTE:
				setNote((String)newValue);
				return;
			case ConnectormenuPackage.MENU_CONNECTOR__ICO:
				setIco((String)newValue);
				return;
			case ConnectormenuPackage.MENU_CONNECTOR__VERSION:
				setVersion((String)newValue);
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
			case ConnectormenuPackage.MENU_CONNECTOR__ID:
				setId(ID_EDEFAULT);
				return;
			case ConnectormenuPackage.MENU_CONNECTOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConnectormenuPackage.MENU_CONNECTOR__NOTE:
				setNote(NOTE_EDEFAULT);
				return;
			case ConnectormenuPackage.MENU_CONNECTOR__ICO:
				setIco(ICO_EDEFAULT);
				return;
			case ConnectormenuPackage.MENU_CONNECTOR__VERSION:
				setVersion(VERSION_EDEFAULT);
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
			case ConnectormenuPackage.MENU_CONNECTOR__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ConnectormenuPackage.MENU_CONNECTOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConnectormenuPackage.MENU_CONNECTOR__NOTE:
				return NOTE_EDEFAULT == null ? note != null : !NOTE_EDEFAULT.equals(note);
			case ConnectormenuPackage.MENU_CONNECTOR__ICO:
				return ICO_EDEFAULT == null ? ico != null : !ICO_EDEFAULT.equals(ico);
			case ConnectormenuPackage.MENU_CONNECTOR__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
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
		result.append(", note: ");
		result.append(note);
		result.append(", ico: ");
		result.append(ico);
		result.append(", version: ");
		result.append(version);
		result.append(')');
		return result.toString();
	}

} //MenuConnectorImpl
