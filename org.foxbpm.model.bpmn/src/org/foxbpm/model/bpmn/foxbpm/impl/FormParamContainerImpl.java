/**
 */
package org.foxbpm.model.bpmn.foxbpm.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.foxbpm.model.bpmn.foxbpm.FormParam;
import org.foxbpm.model.bpmn.foxbpm.FormParamContainer;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Form Param Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foxbpm.model.bpmn.foxbpm.impl.FormParamContainerImpl#getFormParam <em>Form Param</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FormParamContainerImpl extends MinimalEObjectImpl.Container implements FormParamContainer {
	/**
	 * The cached value of the '{@link #getFormParam() <em>Form Param</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormParam()
	 * @generated
	 * @ordered
	 */
	protected EList<FormParam> formParam;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FormParamContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FoxBPMPackage.Literals.FORM_PARAM_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FormParam> getFormParam() {
		if (formParam == null) {
			formParam = new EObjectContainmentEList<FormParam>(FormParam.class, this, FoxBPMPackage.FORM_PARAM_CONTAINER__FORM_PARAM);
		}
		return formParam;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FoxBPMPackage.FORM_PARAM_CONTAINER__FORM_PARAM:
				return ((InternalEList<?>)getFormParam()).basicRemove(otherEnd, msgs);
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
			case FoxBPMPackage.FORM_PARAM_CONTAINER__FORM_PARAM:
				return getFormParam();
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
			case FoxBPMPackage.FORM_PARAM_CONTAINER__FORM_PARAM:
				getFormParam().clear();
				getFormParam().addAll((Collection<? extends FormParam>)newValue);
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
			case FoxBPMPackage.FORM_PARAM_CONTAINER__FORM_PARAM:
				getFormParam().clear();
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
			case FoxBPMPackage.FORM_PARAM_CONTAINER__FORM_PARAM:
				return formParam != null && !formParam.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FormParamContainerImpl
