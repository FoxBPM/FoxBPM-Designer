/**
 */
package org.foxbpm.model.config.style.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.foxbpm.model.config.style.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StyleFactoryImpl extends EFactoryImpl implements StyleFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StyleFactory init() {
		try {
			StyleFactory theStyleFactory = (StyleFactory)EPackage.Registry.INSTANCE.getEFactory(StylePackage.eNS_URI);
			if (theStyleFactory != null) {
				return theStyleFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StyleFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StyleFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case StylePackage.FOX_BPM_STYLE_CONFIG: return createFoxBPMStyleConfig();
			case StylePackage.ELEMENT_STYLE_CONFIG: return createElementStyleConfig();
			case StylePackage.ELEMENT_STYLE: return createElementStyle();
			case StylePackage.STYLE: return createStyle();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FoxBPMStyleConfig createFoxBPMStyleConfig() {
		FoxBPMStyleConfigImpl foxBPMStyleConfig = new FoxBPMStyleConfigImpl();
		return foxBPMStyleConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementStyleConfig createElementStyleConfig() {
		ElementStyleConfigImpl elementStyleConfig = new ElementStyleConfigImpl();
		return elementStyleConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementStyle createElementStyle() {
		ElementStyleImpl elementStyle = new ElementStyleImpl();
		return elementStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Style createStyle() {
		StyleImpl style = new StyleImpl();
		return style;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StylePackage getStylePackage() {
		return (StylePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StylePackage getPackage() {
		return StylePackage.eINSTANCE;
	}

} //StyleFactoryImpl
