package org.foxbpm.bpmn.designer.ui.dialogs.dataimport;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.foxbpm.model.bpmn.foxbpm.DataVariable;



public interface DataObjImport {
	
	/**
	 * 获取业务对象的编号
	 * @return
	 */
	String getId();
	
	/**
	 * 获取业务对象的名称
	 * @return
	 */
	String getName();
	
	/**
	 * 获取业务对象的类型
	 * @return
	 */
	String getType();
	
	/**
	 * 获取业务对象中的数据变量集合
	 * @return 数据变量集合
	 */
	List<DataVariableImport> getDataVariableList(EObject be, String type);
	
	/**
	 * 获取业务对象的路径
	 * @return 业务对象的路径
	 */
	String getFilePath();
	
	/**
	 * 获取业务对象中的数据变量集合
	 * @return
	 */
	List<DataVariable> getDataVariables();

}
