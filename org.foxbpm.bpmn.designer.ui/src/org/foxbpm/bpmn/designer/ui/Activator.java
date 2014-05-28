package org.foxbpm.bpmn.designer.ui;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.foxbpm.bpmn.designer.base.utils.PropertiesUtil;
import org.foxbpm.bpmn.designer.ui.utils.ConnectorUtil;
import org.foxbpm.bpmn.designer.ui.utils.FoxBPMDesignerUtil;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.foxbpm.bpmn.designer.ui"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		
		Job job = new Job("正在下载连接器") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				// do something long running
				monitor.beginTask("正在初始化资源文件", 3);
				
				File fakeGroovyFile = new File(FoxBPMDesignerUtil.getFakeGroovyFilePath());
				if(!fakeGroovyFile.exists()) {
					try {
						fakeGroovyFile.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				monitor.worked(1);
				
				if(!new File(FoxBPMDesignerUtil.getPropertiesPath()).exists()) {
					PropertiesUtil.writeProperties(FoxBPMDesignerUtil.getPropertiesPath(), "connectorDefinitionPath", "path");
					PropertiesUtil.writeProperties(FoxBPMDesignerUtil.getPropertiesPath(), "service", "path");
				}
				monitor.worked(1);
				// 下载
				try {
					ConnectorUtil.downLoadConnector("start");
				} catch (final Exception e) {
					Display.getDefault().syncExec(new Runnable() {
						
						@Override
						public void run() {
							MessageDialog.openInformation(null, "提示", "下载连接器失败，原因是\n" + e.getMessage());							
						}
					});
					e.printStackTrace();
					return Status.CANCEL_STATUS;
				}
				monitor.worked(1);
				return Status.OK_STATUS;
			}
		};

		// Start the Job
		job.schedule();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

}
