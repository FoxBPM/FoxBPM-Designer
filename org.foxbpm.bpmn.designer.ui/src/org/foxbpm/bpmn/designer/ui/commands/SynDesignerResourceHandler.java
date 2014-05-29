package org.foxbpm.bpmn.designer.ui.commands;

import java.io.File;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.foxbpm.bpmn.designer.base.utils.PropertiesUtil;
import org.foxbpm.bpmn.designer.ui.utils.FoxBPMDesignerUtil;
import org.foxbpm.bpmn.designer.ui.utils.RuntimeConnectorUtil;

public class SynDesignerResourceHandler implements IHandler {

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {

	}

	@Override
	public void dispose() {

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Job job = new Job("正在同步设计器资源") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				// do something long running
				monitor.beginTask("正在同步设计器资源", 2);
				if(!new File(FoxBPMDesignerUtil.getPropertiesPath()).exists())
					PropertiesUtil.writeProperties(FoxBPMDesignerUtil.getPropertiesPath(), "service", "path");
				monitor.worked(1);
				// 下载
				try {
					RuntimeConnectorUtil.downLoadConnector("syn");
				} catch (final Exception e) {
					Display.getDefault().syncExec(new Runnable() {
						
						@Override
						public void run() {
							MessageDialog.openInformation(null, "提示", "同步设计器资源失败，原因是\n" + e.getMessage());
						}
					});
					e.printStackTrace();
					return Status.CANCEL_STATUS;
				}
				monitor.worked(1);
				
				Display.getDefault().syncExec(new Runnable() {
					
					@Override
					public void run() {
						MessageDialog.openInformation(null, "提示", "同步设计器资源成功");
					}
				});
				return Status.OK_STATUS;
			}
		};

		// Start the Job
		job.schedule();
		
		return null;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isHandled() {
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {

	}

}
