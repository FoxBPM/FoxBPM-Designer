package org.foxbpm.bpmn.designer.ui.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.foxbpm.bpmn.designer.ui.dialogs.ProcessOperDialog;

public class ProcessOperHandler implements IHandler {

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {

	}

	@Override
	public void dispose() {

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IFile file = null;
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
	    if (window != null)
	    {
	        IStructuredSelection selection = (IStructuredSelection) window.getSelectionService().getSelection();
	        Object firstElement = selection.getFirstElement();
	        if (firstElement instanceof IFile) {
	        	file = (IFile) ((IAdaptable) firstElement).getAdapter(IFile.class);
//	            
	        	ProcessOperDialog processOperDialog = new ProcessOperDialog(Display.getDefault().getActiveShell(), file);
	    		
	        	try {
					processOperDialog.open();
				} catch (Exception e) {
					MessageDialog.openInformation(null, "提示", "无法打开流程操作对话框，原因是\n" + e.getMessage());
					e.printStackTrace();
				}
	        	
//	        	IProject project = (IProject)((IAdaptable)firstElement).getAdapter(IProject.class);
//	            IPath path = project.getFullPath();
	        }else if(firstElement instanceof IPackageFragmentRoot || firstElement instanceof IFolder) {
	        	IPackageFragmentRoot iPackageFragmentRoot = (IPackageFragmentRoot) ((IAdaptable)firstElement).getAdapter(IPackageFragmentRoot.class);
	        	IFolder iFolder = (IFolder) ((IAdaptable)firstElement).getAdapter(IFolder.class);
	        	if(iPackageFragmentRoot!=null) {
	        		ProcessOperDialog processOperDialog = new ProcessOperDialog(Display.getDefault().getActiveShell(), iPackageFragmentRoot);
		    		processOperDialog.open();
	        	}
	        	else if(iFolder!=null) {
	        		ProcessOperDialog processOperDialog = new ProcessOperDialog(Display.getDefault().getActiveShell(), iFolder);
		    		processOperDialog.open();
	        	}
	        }
	    }
	    
//	    if(file)
	    
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
