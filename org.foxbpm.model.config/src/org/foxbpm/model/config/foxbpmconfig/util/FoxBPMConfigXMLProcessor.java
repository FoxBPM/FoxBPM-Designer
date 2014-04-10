/**
 */
package org.foxbpm.model.config.foxbpmconfig.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FoxBPMConfigXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FoxBPMConfigXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		FoxBPMConfigPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the FoxBPMConfigResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new FoxBPMConfigResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new FoxBPMConfigResourceFactoryImpl());
		}
		return registrations;
	}

} //FoxBPMConfigXMLProcessor
