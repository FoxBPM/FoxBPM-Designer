/**
 * Copyright 1996-2014 FoxBPM ORG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * @author MAENLIANG
 */
package org.foxbpm.bpmn.designer.ui.wizard;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.bpmn2.modeler.ui.editor.BPMN2Editor;
import org.eclipse.bpmn2.modeler.ui.editor.BPMN2MultiPageEditor;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.foxbpm.bpmn.designer.ui.utils.BpmnModelUtil;

/**
 * 新建流程定义对话框
 * 
 * @author MAENLIANG
 * 
 */
public class FoxFlowNewWizard extends Wizard implements INewWizard {
	private ISelection selection;
	/**
	 * 流程定义名称输入
	 */
	private NewProcessWizardPage newProcessWizardPage;
	/**
	 * 流程定义模版选择
	 */
	private SelectProcessTemplateWizardPage selectProcessTemplateWizardPage;
	
	public FoxFlowNewWizard() {
		setNeedsProgressMonitor(true);
	}
	
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}
	
	@Override
	public boolean performFinish() {
		final String fileName = newProcessWizardPage.getProcessIdText();
		final String processName = newProcessWizardPage.getProcessNameText();
		final IResource container = newProcessWizardPage.getDiagramContainer();
		
		IRunnableWithProgress op = new IRunnableWithProgress() {
			@Override
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
					String containerName = container.getFullPath().toOSString();
					IResource resource = root.findMember(new Path(containerName));
					IContainer container = (IContainer) resource;
					final IFile file = container.getFile(new Path(fileName));
					try {
						// 获取模板文件路径
						String iofilePath = selectProcessTemplateWizardPage.getModelPath();
						File iofile = new File(iofilePath);
						InputStream stream = new BufferedInputStream(new FileInputStream(iofile));
						if (file.exists()) {
							file.setContents(stream, true, true, monitor);
						} else {
							file.create(stream, true, monitor);
						}
						if (stream != null)
							stream.close();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (CoreException e) {
						e.printStackTrace();
					}
					
					getShell().getDisplay().asyncExec(new Runnable() {
						public void run() {
							IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
							try {
								IDE.openEditor(page, file, true);
							} catch (PartInitException e) {
							}
						}
					});
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "提示", realException.getMessage());
			return false;
		}
		
		BPMN2MultiPageEditor bpmn2MultiPageEditor = (BPMN2MultiPageEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		BPMN2Editor bpmn2Editor = bpmn2MultiPageEditor.getDesignEditor();
		BpmnModelUtil.updateBpmnModelFile(bpmn2Editor, fileName.substring(0, fileName.lastIndexOf(".")), processName);
		// try {
		bpmn2MultiPageEditor.doSave(new NullProgressMonitor());
		// bpmn2Editor.getDiagramBehavior().getModelHandler().getResource().save(null);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		
		return true;
	}
	
	@Override
	public void addPages() {
		selectProcessTemplateWizardPage = new SelectProcessTemplateWizardPage();
		this.addPage(selectProcessTemplateWizardPage);
		newProcessWizardPage = new NewProcessWizardPage(selection);
		this.addPage(newProcessWizardPage);
	}
}
