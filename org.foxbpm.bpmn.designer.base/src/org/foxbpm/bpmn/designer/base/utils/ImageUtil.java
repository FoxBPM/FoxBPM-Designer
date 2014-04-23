package org.foxbpm.bpmn.designer.base.utils;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.foxbpm.bpmn.designer.base.Activator;

public class ImageUtil {
	
	/**
	 * 根据图片名称得到一个图像，例：/xxx.ico
	 * 
	 * @param fileName
	 * @return
	 */
	public static Image getImageFromName(String fileName) {
		try {
			String imagePath = "/icons" + fileName; // 要读取的图片文件的路径
			ImageDescriptor descriptor = AbstractUIPlugin
					.imageDescriptorFromPlugin(Activator.PLUGIN_ID, imagePath); 
			return descriptor.createImage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
