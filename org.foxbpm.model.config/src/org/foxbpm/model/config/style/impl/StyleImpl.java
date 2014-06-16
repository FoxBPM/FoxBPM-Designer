/**
 */
package org.foxbpm.model.config.style.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.foxbpm.model.config.style.Style;
import org.foxbpm.model.config.style.StylePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Style</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foxbpm.model.config.style.impl.StyleImpl#getObject <em>Object</em>}</li>
 *   <li>{@link org.foxbpm.model.config.style.impl.StyleImpl#getForeground <em>Foreground</em>}</li>
 *   <li>{@link org.foxbpm.model.config.style.impl.StyleImpl#getBackground <em>Background</em>}</li>
 *   <li>{@link org.foxbpm.model.config.style.impl.StyleImpl#getTextColor <em>Text Color</em>}</li>
 *   <li>{@link org.foxbpm.model.config.style.impl.StyleImpl#getFont <em>Font</em>}</li>
 *   <li>{@link org.foxbpm.model.config.style.impl.StyleImpl#getMulitSelectedColor <em>Mulit Selected Color</em>}</li>
 *   <li>{@link org.foxbpm.model.config.style.impl.StyleImpl#getSelectedColor <em>Selected Color</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StyleImpl extends MinimalEObjectImpl.Container implements Style {
	/**
	 * The default value of the '{@link #getObject() <em>Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected static final String OBJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getObject() <em>Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected String object = OBJECT_EDEFAULT;

	/**
	 * The default value of the '{@link #getForeground() <em>Foreground</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForeground()
	 * @generated
	 * @ordered
	 */
	protected static final String FOREGROUND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getForeground() <em>Foreground</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForeground()
	 * @generated
	 * @ordered
	 */
	protected String foreground = FOREGROUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getBackground() <em>Background</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackground()
	 * @generated
	 * @ordered
	 */
	protected static final String BACKGROUND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBackground() <em>Background</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackground()
	 * @generated
	 * @ordered
	 */
	protected String background = BACKGROUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getTextColor() <em>Text Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextColor()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_COLOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTextColor() <em>Text Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextColor()
	 * @generated
	 * @ordered
	 */
	protected String textColor = TEXT_COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getFont() <em>Font</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFont()
	 * @generated
	 * @ordered
	 */
	protected static final String FONT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFont() <em>Font</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFont()
	 * @generated
	 * @ordered
	 */
	protected String font = FONT_EDEFAULT;

	/**
	 * The default value of the '{@link #getMulitSelectedColor() <em>Mulit Selected Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMulitSelectedColor()
	 * @generated
	 * @ordered
	 */
	protected static final String MULIT_SELECTED_COLOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMulitSelectedColor() <em>Mulit Selected Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMulitSelectedColor()
	 * @generated
	 * @ordered
	 */
	protected String mulitSelectedColor = MULIT_SELECTED_COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getSelectedColor() <em>Selected Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectedColor()
	 * @generated
	 * @ordered
	 */
	protected static final String SELECTED_COLOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSelectedColor() <em>Selected Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectedColor()
	 * @generated
	 * @ordered
	 */
	protected String selectedColor = SELECTED_COLOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StyleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StylePackage.Literals.STYLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getObject() {
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObject(String newObject) {
		String oldObject = object;
		object = newObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StylePackage.STYLE__OBJECT, oldObject, object));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getForeground() {
		return foreground;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForeground(String newForeground) {
		String oldForeground = foreground;
		foreground = newForeground;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StylePackage.STYLE__FOREGROUND, oldForeground, foreground));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBackground() {
		return background;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackground(String newBackground) {
		String oldBackground = background;
		background = newBackground;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StylePackage.STYLE__BACKGROUND, oldBackground, background));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTextColor() {
		return textColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextColor(String newTextColor) {
		String oldTextColor = textColor;
		textColor = newTextColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StylePackage.STYLE__TEXT_COLOR, oldTextColor, textColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFont() {
		return font;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFont(String newFont) {
		String oldFont = font;
		font = newFont;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StylePackage.STYLE__FONT, oldFont, font));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMulitSelectedColor() {
		return mulitSelectedColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMulitSelectedColor(String newMulitSelectedColor) {
		String oldMulitSelectedColor = mulitSelectedColor;
		mulitSelectedColor = newMulitSelectedColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StylePackage.STYLE__MULIT_SELECTED_COLOR, oldMulitSelectedColor, mulitSelectedColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSelectedColor() {
		return selectedColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelectedColor(String newSelectedColor) {
		String oldSelectedColor = selectedColor;
		selectedColor = newSelectedColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StylePackage.STYLE__SELECTED_COLOR, oldSelectedColor, selectedColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StylePackage.STYLE__OBJECT:
				return getObject();
			case StylePackage.STYLE__FOREGROUND:
				return getForeground();
			case StylePackage.STYLE__BACKGROUND:
				return getBackground();
			case StylePackage.STYLE__TEXT_COLOR:
				return getTextColor();
			case StylePackage.STYLE__FONT:
				return getFont();
			case StylePackage.STYLE__MULIT_SELECTED_COLOR:
				return getMulitSelectedColor();
			case StylePackage.STYLE__SELECTED_COLOR:
				return getSelectedColor();
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
			case StylePackage.STYLE__OBJECT:
				setObject((String)newValue);
				return;
			case StylePackage.STYLE__FOREGROUND:
				setForeground((String)newValue);
				return;
			case StylePackage.STYLE__BACKGROUND:
				setBackground((String)newValue);
				return;
			case StylePackage.STYLE__TEXT_COLOR:
				setTextColor((String)newValue);
				return;
			case StylePackage.STYLE__FONT:
				setFont((String)newValue);
				return;
			case StylePackage.STYLE__MULIT_SELECTED_COLOR:
				setMulitSelectedColor((String)newValue);
				return;
			case StylePackage.STYLE__SELECTED_COLOR:
				setSelectedColor((String)newValue);
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
			case StylePackage.STYLE__OBJECT:
				setObject(OBJECT_EDEFAULT);
				return;
			case StylePackage.STYLE__FOREGROUND:
				setForeground(FOREGROUND_EDEFAULT);
				return;
			case StylePackage.STYLE__BACKGROUND:
				setBackground(BACKGROUND_EDEFAULT);
				return;
			case StylePackage.STYLE__TEXT_COLOR:
				setTextColor(TEXT_COLOR_EDEFAULT);
				return;
			case StylePackage.STYLE__FONT:
				setFont(FONT_EDEFAULT);
				return;
			case StylePackage.STYLE__MULIT_SELECTED_COLOR:
				setMulitSelectedColor(MULIT_SELECTED_COLOR_EDEFAULT);
				return;
			case StylePackage.STYLE__SELECTED_COLOR:
				setSelectedColor(SELECTED_COLOR_EDEFAULT);
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
			case StylePackage.STYLE__OBJECT:
				return OBJECT_EDEFAULT == null ? object != null : !OBJECT_EDEFAULT.equals(object);
			case StylePackage.STYLE__FOREGROUND:
				return FOREGROUND_EDEFAULT == null ? foreground != null : !FOREGROUND_EDEFAULT.equals(foreground);
			case StylePackage.STYLE__BACKGROUND:
				return BACKGROUND_EDEFAULT == null ? background != null : !BACKGROUND_EDEFAULT.equals(background);
			case StylePackage.STYLE__TEXT_COLOR:
				return TEXT_COLOR_EDEFAULT == null ? textColor != null : !TEXT_COLOR_EDEFAULT.equals(textColor);
			case StylePackage.STYLE__FONT:
				return FONT_EDEFAULT == null ? font != null : !FONT_EDEFAULT.equals(font);
			case StylePackage.STYLE__MULIT_SELECTED_COLOR:
				return MULIT_SELECTED_COLOR_EDEFAULT == null ? mulitSelectedColor != null : !MULIT_SELECTED_COLOR_EDEFAULT.equals(mulitSelectedColor);
			case StylePackage.STYLE__SELECTED_COLOR:
				return SELECTED_COLOR_EDEFAULT == null ? selectedColor != null : !SELECTED_COLOR_EDEFAULT.equals(selectedColor);
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
		result.append(" (object: ");
		result.append(object);
		result.append(", foreground: ");
		result.append(foreground);
		result.append(", background: ");
		result.append(background);
		result.append(", textColor: ");
		result.append(textColor);
		result.append(", font: ");
		result.append(font);
		result.append(", mulitSelectedColor: ");
		result.append(mulitSelectedColor);
		result.append(", selectedColor: ");
		result.append(selectedColor);
		result.append(')');
		return result.toString();
	}

} //StyleImpl
