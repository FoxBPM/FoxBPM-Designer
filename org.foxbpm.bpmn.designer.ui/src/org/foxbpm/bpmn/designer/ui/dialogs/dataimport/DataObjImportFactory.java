package org.foxbpm.bpmn.designer.ui.dialogs.dataimport;

import java.util.List;

public class DataObjImportFactory {
	
	public static List<DataObjImport> createDataObjImports()
	{
		DataObjImportInitialization dataObjImportInitialization=new DataObjImportInitializationImpl();
		return dataObjImportInitialization.init();
	}
	
}