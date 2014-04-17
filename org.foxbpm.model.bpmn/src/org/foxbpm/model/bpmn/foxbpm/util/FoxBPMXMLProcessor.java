/**
 */
package org.foxbpm.model.bpmn.foxbpm.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FoxBPMXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FoxBPMXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		FoxBPMPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the FoxBPMResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new FoxBPMResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new FoxBPMResourceFactoryImpl());
		}
		return registrations;
	}

} //FoxBPMXMLProcessor
