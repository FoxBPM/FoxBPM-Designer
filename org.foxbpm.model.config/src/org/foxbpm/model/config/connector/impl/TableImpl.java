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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.foxbpm.model.config.connector.ColsCaption;
import org.foxbpm.model.config.connector.ConnectorPackage;
import org.foxbpm.model.config.connector.Table;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.connector.impl.TableImpl#getColsCaption <em>Cols Caption</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.impl.TableImpl#getCols <em>Cols</em>}</li>
 *   <li>{@link org.foxbpm.model.config.connector.impl.TableImpl#getFixedCols <em>Fixed Cols</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TableImpl extends WidgetImpl implements Table {
	/**
	 * The cached value of the '{@link #getColsCaption() <em>Cols Caption</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColsCaption()
	 * @generated
	 * @ordered
	 */
	protected EList<ColsCaption> colsCaption;

	/**
	 * The default value of the '{@link #getCols() <em>Cols</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCols()
	 * @generated
	 * @ordered
	 */
	protected static final int COLS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCols() <em>Cols</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCols()
	 * @generated
	 * @ordered
	 */
	protected int cols = COLS_EDEFAULT;

	/**
	 * The default value of the '{@link #getFixedCols() <em>Fixed Cols</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixedCols()
	 * @generated
	 * @ordered
	 */
	protected static final String FIXED_COLS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFixedCols() <em>Fixed Cols</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixedCols()
	 * @generated
	 * @ordered
	 */
	protected String fixedCols = FIXED_COLS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConnectorPackage.Literals.TABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ColsCaption> getColsCaption() {
		if (colsCaption == null) {
			colsCaption = new EObjectContainmentEList<ColsCaption>(ColsCaption.class, this, ConnectorPackage.TABLE__COLS_CAPTION);
		}
		return colsCaption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCols() {
		return cols;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCols(int newCols) {
		int oldCols = cols;
		cols = newCols;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConnectorPackage.TABLE__COLS, oldCols, cols));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFixedCols() {
		return fixedCols;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFixedCols(String newFixedCols) {
		String oldFixedCols = fixedCols;
		fixedCols = newFixedCols;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConnectorPackage.TABLE__FIXED_COLS, oldFixedCols, fixedCols));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConnectorPackage.TABLE__COLS_CAPTION:
				return ((InternalEList<?>)getColsCaption()).basicRemove(otherEnd, msgs);
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
			case ConnectorPackage.TABLE__COLS_CAPTION:
				return getColsCaption();
			case ConnectorPackage.TABLE__COLS:
				return getCols();
			case ConnectorPackage.TABLE__FIXED_COLS:
				return getFixedCols();
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
			case ConnectorPackage.TABLE__COLS_CAPTION:
				getColsCaption().clear();
				getColsCaption().addAll((Collection<? extends ColsCaption>)newValue);
				return;
			case ConnectorPackage.TABLE__COLS:
				setCols((Integer)newValue);
				return;
			case ConnectorPackage.TABLE__FIXED_COLS:
				setFixedCols((String)newValue);
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
			case ConnectorPackage.TABLE__COLS_CAPTION:
				getColsCaption().clear();
				return;
			case ConnectorPackage.TABLE__COLS:
				setCols(COLS_EDEFAULT);
				return;
			case ConnectorPackage.TABLE__FIXED_COLS:
				setFixedCols(FIXED_COLS_EDEFAULT);
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
			case ConnectorPackage.TABLE__COLS_CAPTION:
				return colsCaption != null && !colsCaption.isEmpty();
			case ConnectorPackage.TABLE__COLS:
				return cols != COLS_EDEFAULT;
			case ConnectorPackage.TABLE__FIXED_COLS:
				return FIXED_COLS_EDEFAULT == null ? fixedCols != null : !FIXED_COLS_EDEFAULT.equals(fixedCols);
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
		result.append(" (cols: ");
		result.append(cols);
		result.append(", fixedCols: ");
		result.append(fixedCols);
		result.append(')');
		return result.toString();
	}

} //TableImpl
