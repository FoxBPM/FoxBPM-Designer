package org.foxbpm.bpmn.designer.ui.connector.definition;

import org.foxbpm.bpmn.designer.ui.utils.FlowConnectorConfigUtil;
import org.foxbpm.model.config.connector.Checkbox;
import org.foxbpm.model.config.connector.Group;
import org.foxbpm.model.config.connector.Password;
import org.foxbpm.model.config.connector.RadioGroup;
import org.foxbpm.model.config.connector.ScriptEditor;
import org.foxbpm.model.config.connector.Select;
import org.foxbpm.model.config.connector.Table;
import org.foxbpm.model.config.connector.Text;
import org.foxbpm.model.config.connector.TextArea;
import org.foxbpm.model.config.connector.Widget;

public class Constant {
    /***
     * 私有构造方法，防止外部创建对象
     */
    private Constant() {
        // Nothing to do here
    }

    public static final class WidgetConstant extends Constant {
        /***
         * 私有构造方法，防止外部创建对象
         */
        private WidgetConstant() {
            super();
        }
        
        /**
         * 通过字符串返回类型
         * @param type
         * @return
         */
        public static Widget getWidgetType(String type) {
    		if(type.equals(WIDGET_ARRAY[0]))
    			return FlowConnectorConfigUtil.createWidgetText();
    		if(type.equals(WIDGET_ARRAY[1]))
    			return FlowConnectorConfigUtil.createWidgetTextArea();
    		if(type.equals(WIDGET_ARRAY[2]))
    			return FlowConnectorConfigUtil.createWidgetPassword();
    		if(type.equals(WIDGET_ARRAY[3]))
    			return FlowConnectorConfigUtil.createWidgetCheckbox();
    		if(type.equals(WIDGET_ARRAY[4]))
    			return FlowConnectorConfigUtil.createWidgetSelect();
    		if(type.equals(WIDGET_ARRAY[5]))
    			return FlowConnectorConfigUtil.createWidgetGroup();
    		if(type.equals(WIDGET_ARRAY[6]))
    			return FlowConnectorConfigUtil.createWidgetRadioGroup();
    		if(type.equals(WIDGET_ARRAY[7]))
    			return FlowConnectorConfigUtil.createWidgetScriptEditor();
    		if(type.equals(WIDGET_ARRAY[8]))
    			return FlowConnectorConfigUtil.createWidgetTable();
    		return null;
    	}
        
        /**
         * 通过类型返回字符串
         * @param widget
         * @return
         */
        public static String getTypeWidget(Widget widget) {
        	if(widget instanceof Text)
				return WIDGET_ARRAY[0];
			if(widget instanceof TextArea)
				return WIDGET_ARRAY[1];
			if(widget instanceof Password)
				return WIDGET_ARRAY[2];
			if(widget instanceof Checkbox)
				return WIDGET_ARRAY[3];
			if(widget instanceof Select)
				return WIDGET_ARRAY[4];
			if(widget instanceof Group)
				return WIDGET_ARRAY[5];
			if(widget instanceof RadioGroup)
				return WIDGET_ARRAY[6];
			if(widget instanceof ScriptEditor)
				return WIDGET_ARRAY[7];
			if(widget instanceof Table)
				return WIDGET_ARRAY[8];
			return "";
    	}

        /***
         * 获得常量Array
         * 
         * @return 常量Array
         */
        public static String[] getArray() {
            return WIDGET_ARRAY;
        }

        /** 控件Array */
        private static final String[] WIDGET_ARRAY = initArray();

        /***
         * 初始化控件Array
         * 
         * @return 常量Array
         */
        private static String[] initArray() {
            return new String[] {"Text", "TextArea", "Password", "Checkbox", "Select", "Group", "RadioGroup",
            		"ScriptEditor", "Table"};
        }
    }
}
