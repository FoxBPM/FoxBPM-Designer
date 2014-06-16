/**
 */
package org.foxbpm.model.config.style;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.foxbpm.model.config.style.StyleFactory
 * @model kind="package"
 * @generated
 */
public interface StylePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "style";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.foxbpm.org/style";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "style";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StylePackage eINSTANCE = org.foxbpm.model.config.style.impl.StylePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.style.impl.FoxBPMStyleConfigImpl <em>Fox BPM Style Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.style.impl.FoxBPMStyleConfigImpl
	 * @see org.foxbpm.model.config.style.impl.StylePackageImpl#getFoxBPMStyleConfig()
	 * @generated
	 */
	int FOX_BPM_STYLE_CONFIG = 0;

	/**
	 * The feature id for the '<em><b>Element Style Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOX_BPM_STYLE_CONFIG__ELEMENT_STYLE_CONFIG = 0;

	/**
	 * The number of structural features of the '<em>Fox BPM Style Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOX_BPM_STYLE_CONFIG_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Fox BPM Style Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOX_BPM_STYLE_CONFIG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.style.impl.ElementStyleConfigImpl <em>Element Style Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.style.impl.ElementStyleConfigImpl
	 * @see org.foxbpm.model.config.style.impl.StylePackageImpl#getElementStyleConfig()
	 * @generated
	 */
	int ELEMENT_STYLE_CONFIG = 1;

	/**
	 * The feature id for the '<em><b>Element Style</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_STYLE_CONFIG__ELEMENT_STYLE = 0;

	/**
	 * The feature id for the '<em><b>Current Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_STYLE_CONFIG__CURRENT_STYLE = 1;

	/**
	 * The number of structural features of the '<em>Element Style Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_STYLE_CONFIG_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Element Style Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_STYLE_CONFIG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.style.impl.ElementStyleImpl <em>Element Style</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.style.impl.ElementStyleImpl
	 * @see org.foxbpm.model.config.style.impl.StylePackageImpl#getElementStyle()
	 * @generated
	 */
	int ELEMENT_STYLE = 2;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_STYLE__STYLE = 0;

	/**
	 * The feature id for the '<em><b>Style Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_STYLE__STYLE_ID = 1;

	/**
	 * The feature id for the '<em><b>Style Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_STYLE__STYLE_NAME = 2;

	/**
	 * The number of structural features of the '<em>Element Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_STYLE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Element Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_STYLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foxbpm.model.config.style.impl.StyleImpl <em>Style</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foxbpm.model.config.style.impl.StyleImpl
	 * @see org.foxbpm.model.config.style.impl.StylePackageImpl#getStyle()
	 * @generated
	 */
	int STYLE = 3;

	/**
	 * The feature id for the '<em><b>Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE__OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Foreground</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE__FOREGROUND = 1;

	/**
	 * The feature id for the '<em><b>Background</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE__BACKGROUND = 2;

	/**
	 * The feature id for the '<em><b>Text Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE__TEXT_COLOR = 3;

	/**
	 * The feature id for the '<em><b>Font</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE__FONT = 4;

	/**
	 * The feature id for the '<em><b>Mulit Selected Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE__MULIT_SELECTED_COLOR = 5;

	/**
	 * The feature id for the '<em><b>Selected Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE__SELECTED_COLOR = 6;

	/**
	 * The number of structural features of the '<em>Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.style.FoxBPMStyleConfig <em>Fox BPM Style Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fox BPM Style Config</em>'.
	 * @see org.foxbpm.model.config.style.FoxBPMStyleConfig
	 * @generated
	 */
	EClass getFoxBPMStyleConfig();

	/**
	 * Returns the meta object for the containment reference '{@link org.foxbpm.model.config.style.FoxBPMStyleConfig#getElementStyleConfig <em>Element Style Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Element Style Config</em>'.
	 * @see org.foxbpm.model.config.style.FoxBPMStyleConfig#getElementStyleConfig()
	 * @see #getFoxBPMStyleConfig()
	 * @generated
	 */
	EReference getFoxBPMStyleConfig_ElementStyleConfig();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.style.ElementStyleConfig <em>Element Style Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Style Config</em>'.
	 * @see org.foxbpm.model.config.style.ElementStyleConfig
	 * @generated
	 */
	EClass getElementStyleConfig();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.config.style.ElementStyleConfig#getElementStyle <em>Element Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Element Style</em>'.
	 * @see org.foxbpm.model.config.style.ElementStyleConfig#getElementStyle()
	 * @see #getElementStyleConfig()
	 * @generated
	 */
	EReference getElementStyleConfig_ElementStyle();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.style.ElementStyleConfig#getCurrentStyle <em>Current Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Style</em>'.
	 * @see org.foxbpm.model.config.style.ElementStyleConfig#getCurrentStyle()
	 * @see #getElementStyleConfig()
	 * @generated
	 */
	EAttribute getElementStyleConfig_CurrentStyle();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.style.ElementStyle <em>Element Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Style</em>'.
	 * @see org.foxbpm.model.config.style.ElementStyle
	 * @generated
	 */
	EClass getElementStyle();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foxbpm.model.config.style.ElementStyle#getStyle <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Style</em>'.
	 * @see org.foxbpm.model.config.style.ElementStyle#getStyle()
	 * @see #getElementStyle()
	 * @generated
	 */
	EReference getElementStyle_Style();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.style.ElementStyle#getStyleId <em>Style Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Style Id</em>'.
	 * @see org.foxbpm.model.config.style.ElementStyle#getStyleId()
	 * @see #getElementStyle()
	 * @generated
	 */
	EAttribute getElementStyle_StyleId();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.style.ElementStyle#getStyleName <em>Style Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Style Name</em>'.
	 * @see org.foxbpm.model.config.style.ElementStyle#getStyleName()
	 * @see #getElementStyle()
	 * @generated
	 */
	EAttribute getElementStyle_StyleName();

	/**
	 * Returns the meta object for class '{@link org.foxbpm.model.config.style.Style <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Style</em>'.
	 * @see org.foxbpm.model.config.style.Style
	 * @generated
	 */
	EClass getStyle();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.style.Style#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Object</em>'.
	 * @see org.foxbpm.model.config.style.Style#getObject()
	 * @see #getStyle()
	 * @generated
	 */
	EAttribute getStyle_Object();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.style.Style#getForeground <em>Foreground</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Foreground</em>'.
	 * @see org.foxbpm.model.config.style.Style#getForeground()
	 * @see #getStyle()
	 * @generated
	 */
	EAttribute getStyle_Foreground();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.style.Style#getBackground <em>Background</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Background</em>'.
	 * @see org.foxbpm.model.config.style.Style#getBackground()
	 * @see #getStyle()
	 * @generated
	 */
	EAttribute getStyle_Background();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.style.Style#getTextColor <em>Text Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text Color</em>'.
	 * @see org.foxbpm.model.config.style.Style#getTextColor()
	 * @see #getStyle()
	 * @generated
	 */
	EAttribute getStyle_TextColor();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.style.Style#getFont <em>Font</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Font</em>'.
	 * @see org.foxbpm.model.config.style.Style#getFont()
	 * @see #getStyle()
	 * @generated
	 */
	EAttribute getStyle_Font();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.style.Style#getMulitSelectedColor <em>Mulit Selected Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mulit Selected Color</em>'.
	 * @see org.foxbpm.model.config.style.Style#getMulitSelectedColor()
	 * @see #getStyle()
	 * @generated
	 */
	EAttribute getStyle_MulitSelectedColor();

	/**
	 * Returns the meta object for the attribute '{@link org.foxbpm.model.config.style.Style#getSelectedColor <em>Selected Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selected Color</em>'.
	 * @see org.foxbpm.model.config.style.Style#getSelectedColor()
	 * @see #getStyle()
	 * @generated
	 */
	EAttribute getStyle_SelectedColor();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StyleFactory getStyleFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.style.impl.FoxBPMStyleConfigImpl <em>Fox BPM Style Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.style.impl.FoxBPMStyleConfigImpl
		 * @see org.foxbpm.model.config.style.impl.StylePackageImpl#getFoxBPMStyleConfig()
		 * @generated
		 */
		EClass FOX_BPM_STYLE_CONFIG = eINSTANCE.getFoxBPMStyleConfig();

		/**
		 * The meta object literal for the '<em><b>Element Style Config</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOX_BPM_STYLE_CONFIG__ELEMENT_STYLE_CONFIG = eINSTANCE.getFoxBPMStyleConfig_ElementStyleConfig();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.style.impl.ElementStyleConfigImpl <em>Element Style Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.style.impl.ElementStyleConfigImpl
		 * @see org.foxbpm.model.config.style.impl.StylePackageImpl#getElementStyleConfig()
		 * @generated
		 */
		EClass ELEMENT_STYLE_CONFIG = eINSTANCE.getElementStyleConfig();

		/**
		 * The meta object literal for the '<em><b>Element Style</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_STYLE_CONFIG__ELEMENT_STYLE = eINSTANCE.getElementStyleConfig_ElementStyle();

		/**
		 * The meta object literal for the '<em><b>Current Style</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_STYLE_CONFIG__CURRENT_STYLE = eINSTANCE.getElementStyleConfig_CurrentStyle();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.style.impl.ElementStyleImpl <em>Element Style</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.style.impl.ElementStyleImpl
		 * @see org.foxbpm.model.config.style.impl.StylePackageImpl#getElementStyle()
		 * @generated
		 */
		EClass ELEMENT_STYLE = eINSTANCE.getElementStyle();

		/**
		 * The meta object literal for the '<em><b>Style</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_STYLE__STYLE = eINSTANCE.getElementStyle_Style();

		/**
		 * The meta object literal for the '<em><b>Style Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_STYLE__STYLE_ID = eINSTANCE.getElementStyle_StyleId();

		/**
		 * The meta object literal for the '<em><b>Style Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_STYLE__STYLE_NAME = eINSTANCE.getElementStyle_StyleName();

		/**
		 * The meta object literal for the '{@link org.foxbpm.model.config.style.impl.StyleImpl <em>Style</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foxbpm.model.config.style.impl.StyleImpl
		 * @see org.foxbpm.model.config.style.impl.StylePackageImpl#getStyle()
		 * @generated
		 */
		EClass STYLE = eINSTANCE.getStyle();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE__OBJECT = eINSTANCE.getStyle_Object();

		/**
		 * The meta object literal for the '<em><b>Foreground</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE__FOREGROUND = eINSTANCE.getStyle_Foreground();

		/**
		 * The meta object literal for the '<em><b>Background</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE__BACKGROUND = eINSTANCE.getStyle_Background();

		/**
		 * The meta object literal for the '<em><b>Text Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE__TEXT_COLOR = eINSTANCE.getStyle_TextColor();

		/**
		 * The meta object literal for the '<em><b>Font</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE__FONT = eINSTANCE.getStyle_Font();

		/**
		 * The meta object literal for the '<em><b>Mulit Selected Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE__MULIT_SELECTED_COLOR = eINSTANCE.getStyle_MulitSelectedColor();

		/**
		 * The meta object literal for the '<em><b>Selected Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE__SELECTED_COLOR = eINSTANCE.getStyle_SelectedColor();

	}

} //StylePackage
