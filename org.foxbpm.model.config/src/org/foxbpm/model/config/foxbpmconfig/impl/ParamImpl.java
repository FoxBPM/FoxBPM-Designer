/**
 */
package org.foxbpm.model.config.foxbpmconfig.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage;
import org.foxbpm.model.config.foxbpmconfig.Param;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Param</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.ParamImpl#getKey <em>Key</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.ParamImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.ParamImpl#getParams <em>Params</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.ParamImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.foxbpm.model.config.foxbpmconfig.impl.ParamImpl#getMixed <em>Mixed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParamImpl extends MinimalEObjectImpl.Container implements Param {
	/**
	 * The default value of the '{@link #getKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected static final String KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected String key = KEY_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParams() <em>Params</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParams()
	 * @generated
	 * @ordered
	 */
	protected EList<Param> params;

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
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParamImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FoxBPMConfigPackage.Literals.PARAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKey() {
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKey(String newKey) {
		String oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.PARAM__KEY, oldKey, key));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getValue() {
		 if (mixed != null && !mixed.isEmpty()) {
	            StringBuilder result = new StringBuilder();
	            for (FeatureMap.Entry cur : mixed) {
	                switch (cur.getEStructuralFeature().getFeatureID()) {
	                case XMLTypePackage.XML_TYPE_DOCUMENT_ROOT__CDATA:
	                case XMLTypePackage.XML_TYPE_DOCUMENT_ROOT__TEXT:
	                    result.append(cur.getValue());
	                    break;

	                default:
	                    break;
	                }
	            }
	            return result.toString();
	        }
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setValue(String newValue) {
		getMixed().clear();
        getMixed().add(XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_CDATA(), newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Param> getParams() {
		if (params == null) {
			params = new EObjectContainmentEList<Param>(Param.class, this, FoxBPMConfigPackage.PARAM__PARAMS);
		}
		return params;
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
			eNotify(new ENotificationImpl(this, Notification.SET, FoxBPMConfigPackage.PARAM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, FoxBPMConfigPackage.PARAM__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FoxBPMConfigPackage.PARAM__PARAMS:
				return ((InternalEList<?>)getParams()).basicRemove(otherEnd, msgs);
			case FoxBPMConfigPackage.PARAM__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
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
			case FoxBPMConfigPackage.PARAM__KEY:
				return getKey();
			case FoxBPMConfigPackage.PARAM__VALUE:
				return getValue();
			case FoxBPMConfigPackage.PARAM__PARAMS:
				return getParams();
			case FoxBPMConfigPackage.PARAM__NAME:
				return getName();
			case FoxBPMConfigPackage.PARAM__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
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
			case FoxBPMConfigPackage.PARAM__KEY:
				setKey((String)newValue);
				return;
			case FoxBPMConfigPackage.PARAM__VALUE:
				setValue((String)newValue);
				return;
			case FoxBPMConfigPackage.PARAM__PARAMS:
				getParams().clear();
				getParams().addAll((Collection<? extends Param>)newValue);
				return;
			case FoxBPMConfigPackage.PARAM__NAME:
				setName((String)newValue);
				return;
			case FoxBPMConfigPackage.PARAM__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
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
			case FoxBPMConfigPackage.PARAM__KEY:
				setKey(KEY_EDEFAULT);
				return;
			case FoxBPMConfigPackage.PARAM__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case FoxBPMConfigPackage.PARAM__PARAMS:
				getParams().clear();
				return;
			case FoxBPMConfigPackage.PARAM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FoxBPMConfigPackage.PARAM__MIXED:
				getMixed().clear();
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
			case FoxBPMConfigPackage.PARAM__KEY:
				return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
			case FoxBPMConfigPackage.PARAM__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case FoxBPMConfigPackage.PARAM__PARAMS:
				return params != null && !params.isEmpty();
			case FoxBPMConfigPackage.PARAM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FoxBPMConfigPackage.PARAM__MIXED:
				return mixed != null && !mixed.isEmpty();
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
		result.append(" (key: ");
		result.append(key);
		result.append(", value: ");
		result.append(value);
		result.append(", name: ");
		result.append(name);
		result.append(", mixed: ");
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //ParamImpl
