package org.foxbpm.bpmn.designer.ui.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.foxbpm.bpmn.designer.base.utils.PropertiesUtil;
import org.foxbpm.bpmn.designer.base.utils.StringUtil;
import org.osgi.framework.Bundle;

public class ControlDecorateUtil {
	public static final String UTF8 = "UTF-8";
	public static final String GBK = "GBK";
	public static final String GB2312 = "GB2312";
	public static final String ISO88591 = "ISO8859-1";
	
	/**
	 * 增加灯泡
	 * 
	 * @param control
	 * @param id
	 */
	public static void addDecorate(Control control, String id) {
		final ControlDecoration deco = new ControlDecoration(control, SWT.CENTER | SWT.LEFT);
		// Set description and image
		
		Bundle bundle = Platform.getBundle("org.foxbpm.bpmn.designer.base");
		// 为了WB能展现加的这句话
		if (bundle == null)
			return;
		String proPath = null;
		try {
			proPath = FileLocator.resolve(bundle.getEntry("resources/tips.properties")).getPath();
			if (proPath == null)
				return;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Map<String,Object> map = PropertiesUtil.readProperties(proPath);
		
		try {
			deco.setDescriptionText(map.get(id)==null ? "" : new String(StringUtil.getString(map.get(id).toString()).getBytes(ISO88591), UTF8));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		deco.setImage(ImageUtil.getImageFromName("/decoration/smartmode_co.gif"));

		// Always show decoration
		deco.setShowOnlyOnFocus(false);

		// Also if the text UI componet is not empty hide the decoration
		if (control instanceof Text) {
			((Text) control).addModifyListener(new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent e) {
					Text text = (Text) e.getSource();
					if (text.getText().length() > 0) {
						deco.hide();
					} else {
						deco.show();
					}
				}
			});
		} else {

		}
	}
}
