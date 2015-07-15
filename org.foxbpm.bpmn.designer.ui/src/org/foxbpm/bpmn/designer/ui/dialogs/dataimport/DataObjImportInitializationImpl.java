package org.foxbpm.bpmn.designer.ui.dialogs.dataimport;

import java.util.List;



public class DataObjImportInitializationImpl implements DataObjImportInitialization {

	@Override
	public List<DataObjImport> init() {
		return DataObjCache.getDataObjImports();
	}

}
