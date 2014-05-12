/**
 */
package org.foxbpm.model.config.connector.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.foxbpm.model.config.connector.ConnectorDefinition;
import org.foxbpm.model.config.connector.ConnectorPackage;
import org.foxbpm.model.config.connector.DefinitionImpl;
import org.foxbpm.model.config.connector.Input;
import org.foxbpm.model.config.connector.Output;
import org.foxbpm.model.config.connector.Page;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.connector.impl.ConnectorDefinitionImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.impl.ConnectorDefinitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.impl.ConnectorDefinitionImpl#getNote <em>Note</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.impl.ConnectorDefinitionImpl#getCategoryId <em>Category Id</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.impl.ConnectorDefinitionImpl#getIcon <em>Icon</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.impl.ConnectorDefinitionImpl#getInput <em>Input</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.impl.ConnectorDefinitionImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.impl.ConnectorDefinitionImpl#getPage <em>Page</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.impl.ConnectorDefinitionImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.impl.ConnectorDefinitionImpl#getDefinitionImpl <em>Definition Impl</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.impl.ConnectorDefinitionImpl#getConnrctorType <em>Connrctor Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectorDefinitionImpl extends MinimalEObjectImpl.Container implements ConnectorDefinition {
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
	 * The default value of the '{@link #getCategoryId() <em>Category Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategoryId()
	 * @generated
	 * @ordered
	 */
	protected static final String CATEGORY_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCategoryId() <em>Category Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategoryId()
	 * @generated
	 * @ordered
	 */
	protected String categoryId = CATEGORY_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getIcon() <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIcon() <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected String icon = ICON_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInput() <em>Input</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected EList<Input> input;

	/**
	 * The cached value of the '{@link #getOutput() <em>Output</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutput()
	 * @generated
	 * @ordered
	 */
	protected EList<Output> output;

	/**
	 * The cached value of the '{@link #getPage() <em>Page</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPage()
	 * @generated
	 * @ordered
	 */
	protected EList<Page> page;

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
	 * The cached value of the '{@link #getDefinitionImpl() <em>Definition Impl</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinitionImpl()
	 * @generated
	 * @ordered
	 */
	protected DefinitionImpl definitionImpl;

	/**
	 * The default value of the '{@link #getConnrctorType() <em>Connrctor Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnrctorType()
	 * @generated
	 * @ordered
	 */
	protected static final String CONNRCTOR_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConnrctorType() <em>Connrctor Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnrctorType()
	 * @generated
	 * @ordered
	 */
	protected String connrctorType = CONNRCTOR_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectorDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConnectorPackage.Literals.CONNECTOR_DEFINITION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConnectorPackage.CONNECTOR_DEFINITION__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConnectorPackage.CONNECTOR_DEFINITION__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConnectorPackage.CONNECTOR_DEFINITION__NOTE, oldNote, note));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCategoryId() {
		return categoryId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCategoryId(String newCategoryId) {
		String oldCategoryId = categoryId;
		categoryId = newCategoryId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConnectorPackage.CONNECTOR_DEFINITION__CATEGORY_ID, oldCategoryId, categoryId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIcon(String newIcon) {
		String oldIcon = icon;
		icon = newIcon;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConnectorPackage.CONNECTOR_DEFINITION__ICON, oldIcon, icon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Input> getInput() {
		if (input == null) {
			input = new EObjectContainmentEList<Input>(Input.class, this, ConnectorPackage.CONNECTOR_DEFINITION__INPUT);
		}
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Output> getOutput() {
		if (output == null) {
			output = new EObjectContainmentEList<Output>(Output.class, this, ConnectorPackage.CONNECTOR_DEFINITION__OUTPUT);
		}
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Page> getPage() {
		if (page == null) {
			page = new EObjectContainmentEList<Page>(Page.class, this, ConnectorPackage.CONNECTOR_DEFINITION__PAGE);
		}
		return page;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConnectorPackage.CONNECTOR_DEFINITION__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefinitionImpl getDefinitionImpl() {
		return definitionImpl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefinitionImpl(DefinitionImpl newDefinitionImpl, NotificationChain msgs) {
		DefinitionImpl oldDefinitionImpl = definitionImpl;
		definitionImpl = newDefinitionImpl;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConnectorPackage.CONNECTOR_DEFINITION__DEFINITION_IMPL, oldDefinitionImpl, newDefinitionImpl);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefinitionImpl(DefinitionImpl newDefinitionImpl) {
		if (newDefinitionImpl != definitionImpl) {
			NotificationChain msgs = null;
			if (definitionImpl != null)
				msgs = ((InternalEObject)definitionImpl).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConnectorPackage.CONNECTOR_DEFINITION__DEFINITION_IMPL, null, msgs);
			if (newDefinitionImpl != null)
				msgs = ((InternalEObject)newDefinitionImpl).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConnectorPackage.CONNECTOR_DEFINITION__DEFINITION_IMPL, null, msgs);
			msgs = basicSetDefinitionImpl(newDefinitionImpl, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConnectorPackage.CONNECTOR_DEFINITION__DEFINITION_IMPL, newDefinitionImpl, newDefinitionImpl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConnrctorType() {
		return connrctorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnrctorType(String newConnrctorType) {
		String oldConnrctorType = connrctorType;
		connrctorType = newConnrctorType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConnectorPackage.CONNECTOR_DEFINITION__CONNRCTOR_TYPE, oldConnrctorType, connrctorType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConnectorPackage.CONNECTOR_DEFINITION__INPUT:
				return ((InternalEList<?>)getInput()).basicRemove(otherEnd, msgs);
			case ConnectorPackage.CONNECTOR_DEFINITION__OUTPUT:
				return ((InternalEList<?>)getOutput()).basicRemove(otherEnd, msgs);
			case ConnectorPackage.CONNECTOR_DEFINITION__PAGE:
				return ((InternalEList<?>)getPage()).basicRemove(otherEnd, msgs);
			case ConnectorPackage.CONNECTOR_DEFINITION__DEFINITION_IMPL:
				return basicSetDefinitionImpl(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConnectorPackage.CONNECTOR_DEFINITION__ID:
				return getId();
			case ConnectorPackage.CONNECTOR_DEFINITION__NAME:
				return getName();
			case ConnectorPackage.CONNECTOR_DEFINITION__NOTE:
				return getNote();
			case ConnectorPackage.CONNECTOR_DEFINITION__CATEGORY_ID:
				return getCategoryId();
			case ConnectorPackage.CONNECTOR_DEFINITION__ICON:
				return getIcon();
			case ConnectorPackage.CONNECTOR_DEFINITION__INPUT:
				return getInput();
			case ConnectorPackage.CONNECTOR_DEFINITION__OUTPUT:
				return getOutput();
			case ConnectorPackage.CONNECTOR_DEFINITION__PAGE:
				return getPage();
			case ConnectorPackage.CONNECTOR_DEFINITION__VERSION:
				return getVersion();
			case ConnectorPackage.CONNECTOR_DEFINITION__DEFINITION_IMPL:
				return getDefinitionImpl();
			case ConnectorPackage.CONNECTOR_DEFINITION__CONNRCTOR_TYPE:
				return getConnrctorType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConnectorPackage.CONNECTOR_DEFINITION__ID:
				setId((String)newValue);
				return;
			case ConnectorPackage.CONNECTOR_DEFINITION__NAME:
				setName((String)newValue);
				return;
			case ConnectorPackage.CONNECTOR_DEFINITION__NOTE:
				setNote((String)newValue);
				return;
			case ConnectorPackage.CONNECTOR_DEFINITION__CATEGORY_ID:
				setCategoryId((String)newValue);
				return;
			case ConnectorPackage.CONNECTOR_DEFINITION__ICON:
				setIcon((String)newValue);
				return;
			case ConnectorPackage.CONNECTOR_DEFINITION__INPUT:
				getInput().clear();
				getInput().addAll((Collection<? extends Input>)newValue);
				return;
			case ConnectorPackage.CONNECTOR_DEFINITION__OUTPUT:
				getOutput().clear();
				getOutput().addAll((Collection<? extends Output>)newValue);
				return;
			case ConnectorPackage.CONNECTOR_DEFINITION__PAGE:
				getPage().clear();
				getPage().addAll((Collection<? extends Page>)newValue);
				return;
			case ConnectorPackage.CONNECTOR_DEFINITION__VERSION:
				setVersion((String)newValue);
				return;
			case ConnectorPackage.CONNECTOR_DEFINITION__DEFINITION_IMPL:
				setDefinitionImpl((DefinitionImpl)newValue);
				return;
			case ConnectorPackage.CONNECTOR_DEFINITION__CONNRCTOR_TYPE:
				setConnrctorType((String)newValue);
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
			case ConnectorPackage.CONNECTOR_DEFINITION__ID:
				setId(ID_EDEFAULT);
				return;
			case ConnectorPackage.CONNECTOR_DEFINITION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConnectorPackage.CONNECTOR_DEFINITION__NOTE:
				setNote(NOTE_EDEFAULT);
				return;
			case ConnectorPackage.CONNECTOR_DEFINITION__CATEGORY_ID:
				setCategoryId(CATEGORY_ID_EDEFAULT);
				return;
			case ConnectorPackage.CONNECTOR_DEFINITION__ICON:
				setIcon(ICON_EDEFAULT);
				return;
			case ConnectorPackage.CONNECTOR_DEFINITION__INPUT:
				getInput().clear();
				return;
			case ConnectorPackage.CONNECTOR_DEFINITION__OUTPUT:
				getOutput().clear();
				return;
			case ConnectorPackage.CONNECTOR_DEFINITION__PAGE:
				getPage().clear();
				return;
			case ConnectorPackage.CONNECTOR_DEFINITION__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case ConnectorPackage.CONNECTOR_DEFINITION__DEFINITION_IMPL:
				setDefinitionImpl((DefinitionImpl)null);
				return;
			case ConnectorPackage.CONNECTOR_DEFINITION__CONNRCTOR_TYPE:
				setConnrctorType(CONNRCTOR_TYPE_EDEFAULT);
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
			case ConnectorPackage.CONNECTOR_DEFINITION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ConnectorPackage.CONNECTOR_DEFINITION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConnectorPackage.CONNECTOR_DEFINITION__NOTE:
				return NOTE_EDEFAULT == null ? note != null : !NOTE_EDEFAULT.equals(note);
			case ConnectorPackage.CONNECTOR_DEFINITION__CATEGORY_ID:
				return CATEGORY_ID_EDEFAULT == null ? categoryId != null : !CATEGORY_ID_EDEFAULT.equals(categoryId);
			case ConnectorPackage.CONNECTOR_DEFINITION__ICON:
				return ICON_EDEFAULT == null ? icon != null : !ICON_EDEFAULT.equals(icon);
			case ConnectorPackage.CONNECTOR_DEFINITION__INPUT:
				return input != null && !input.isEmpty();
			case ConnectorPackage.CONNECTOR_DEFINITION__OUTPUT:
				return output != null && !output.isEmpty();
			case ConnectorPackage.CONNECTOR_DEFINITION__PAGE:
				return page != null && !page.isEmpty();
			case ConnectorPackage.CONNECTOR_DEFINITION__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case ConnectorPackage.CONNECTOR_DEFINITION__DEFINITION_IMPL:
				return definitionImpl != null;
			case ConnectorPackage.CONNECTOR_DEFINITION__CONNRCTOR_TYPE:
				return CONNRCTOR_TYPE_EDEFAULT == null ? connrctorType != null : !CONNRCTOR_TYPE_EDEFAULT.equals(connrctorType);
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
		result.append(", categoryId: ");
		result.append(categoryId);
		result.append(", icon: ");
		result.append(icon);
		result.append(", version: ");
		result.append(version);
		result.append(", connrctorType: ");
		result.append(connrctorType);
		result.append(')');
		return result.toString();
	}

} //ConnectorDefinitionImpl
