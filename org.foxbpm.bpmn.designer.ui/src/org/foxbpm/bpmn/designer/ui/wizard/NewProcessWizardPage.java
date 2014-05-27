package org.foxbpm.bpmn.designer.ui.wizard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;

public class NewProcessWizardPage extends WizardPage {
	private Text containerText;
	private Text processIdText;
	private Text processNameText;
	private String validationLevel;
	private Label label_1;
	private Button btnNewButton;
	private ISelection selection;
	private IResource diagramContainer;
	private Text processVerText;
	private String fileName;

	/**
	 * Create the wizard.
	 */
	public NewProcessWizardPage(ISelection selection) {
		super("wizardPage");
		setTitle("创建向导");
		setDescription("创建新的FoxBPM流程");
		this.selection = selection;
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout gl_container = new GridLayout(3, false);
		gl_container.marginTop = 10;
		gl_container.marginRight = 15;
		gl_container.marginLeft = 15;
		container.setLayout(gl_container);

		Label label = new Label(container, SWT.NULL);
		label.setText("文件位置:");

		containerText = new Text(container, SWT.BORDER | SWT.SINGLE);
		containerText.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false, 1, 1));
		containerText.setEditable(false);
		containerText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {

			}
		});

		btnNewButton = new Button(container, SWT.PUSH);
		btnNewButton.setText("浏览...");
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ContainerSelectionDialog dialog = new ContainerSelectionDialog(getShell(), ResourcesPlugin.getWorkspace().getRoot(), false, "选择目录");
				if (dialog.open() == Window.OK) {
					Object[] result = dialog.getResult();
					if (result.length == 1) {
						selection = new TreeSelection(new TreePath(result));
						containerText.setText(((Path) result[0]).toString());
					}
				}
			}
		});

		label_1 = new Label(container, SWT.NULL);
		label_1.setText("流程编号:");

		processIdText = new Text(container, SWT.BORDER | SWT.SINGLE);
		processIdText.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false, 2, 1));
		processIdText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				dialogChanged(true);
			}
		});

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setText("流程名称:");

		processNameText = new Text(container, SWT.BORDER);
		processNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		processNameText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				dialogChanged(true);
			}
		});
		
		setControl(container);
		
		Label processVerLabel = new Label(container, SWT.NONE);
		processVerLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		processVerLabel.setText("流程版本");
		
		processVerText = new Text(container, SWT.BORDER);
		processVerText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		processVerText.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				updateFilename();
				dialogChanged(true);		
			}
		});
		
		setDescription("创建流程文件");
		updateFilename();
		dialogChanged(true);
	}

	private void dialogChanged(boolean initialize) {
		boolean complete = false;
		if (validateContainer()) {
			diagramContainer = getFileContainer();
			if (validateFileName()) {
				updateStatus(null);
				complete = true;
			}
		}
		setPageComplete(complete);		
	}
	
	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}
	
	private boolean validateFileName() {
		if (!validateContainer())
			return false;
		
		IContainer container = getFileContainer();
		fileName = processIdText.getText() + "_" + getProcessVerText() + ".bpmn";
		if (fileName.length() == 0) {
			setErrorMessage("流程编号不能为空");
			return false;
		}
		if (fileName.replace('\\', '/').indexOf('/', 1) > 0) {
			setErrorMessage("非法流程编号");
			return false;
		}
//		int dotLoc = fileName.lastIndexOf('.');
//		if (dotLoc != -1) {
//			String ext = fileName.substring(dotLoc + 1);
//			if (ext.equalsIgnoreCase("bpmn") == false && ext.equalsIgnoreCase("bpmn2") == false) { //$NON-NLS-1$ //$NON-NLS-2$
//				setErrorMessage("非法流程后缀名");
//				return false;
//			}
//		}
//		else {
//			setErrorMessage("没有流程后缀名");
//			return false;
//		}
		IResource file = container.findMember(fileName);
		if (file!=null) {
			setErrorMessage("已存在该版本的流程文件");
			return false;
		}
		
		if(null == processNameText.getText() || processNameText.getText().equals("")) {
			setErrorMessage("流程名称不能为空");
			return false;
		}
		
		if(null == processVerText.getText() || processVerText.getText().equals("")) {
			setErrorMessage("流程版本不能为空");
			return false;
		}
		
		Pattern pattern = Pattern.compile("^[0-9]+$");
		Matcher matcher = null;

		matcher = pattern.matcher(processVerText.getText());
		
		if (!matcher.matches()) {
			setErrorMessage("版本只能输入数字");
			return false;
		}
		
		return true;
	}
	
	private boolean validateContainer() {
		IContainer container = getFileContainer();
		if (container==null) {
			setErrorMessage("没有目录");
			return false;
		}
		if ((container.getType() & (IResource.PROJECT | IResource.FOLDER)) == 0) {
			setErrorMessage("没有该文件夹");
			return false;
		}
		if (!container.isAccessible()) {
			setErrorMessage("选择目录为只读目录");
			return false;
		}
		return true;
	}

	private void updateFilename() {
		String fileType = "process"; //$NON-NLS-1$
		fileName = getProcessIdText()  + "_" + getProcessVerText() + ".bpmn";
		
		IContainer container = getFileContainer();
		if (container!=null) {
			String text = container.getFullPath().toString();
			if (text!=null && !text.equals(containerText.getText()))
				containerText.setText(text);
//			if(container.findMember(filename)!=null) {
//				for (int i=1; ; ++i) {
//					filename = fileType+"_" + i + ".bpmn"; //$NON-NLS-1$
//					IResource file = container.findMember(filename);
//					if (file==null) {
//						break;
//					}
//				}
//			}
		}

//		String oldFileText = processIdText.getText();
//		if (filename!=null && !filename.equals(oldFileText))
//			processIdText.setText(filename.substring(0, filename.lastIndexOf("_")));
	}
	
	private IContainer getFileContainer() {
		if (selection != null && selection.isEmpty() == false && selection instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) selection;
			if (ssel.size() == 1) {
				Object obj = ssel.getFirstElement();
				if (obj instanceof IAdaptable) {
					Object res = ((IAdaptable)obj).getAdapter(IResource.class);
					if (res!=null)
						obj = res;
				}
				if (obj instanceof Path) {
					obj = ResourcesPlugin.getWorkspace().getRoot().findMember((Path)obj);
				}
				if (obj instanceof IResource) {
					if (obj instanceof IContainer) {
						return (IContainer) obj;
					} else {
						return ((IResource) obj).getParent();
					}
				}
			}
		}
		return null;
	}

	public String getContainerText() {
		return containerText.getText();
	}

	public String getProcessIdText() {
		return processIdText.getText() + ".bpmn";
	}

	public String getProcessNameText() {
		return processNameText.getText();
	}

	public String getValidationLevel() {
		return validationLevel;
	}

	public IResource getDiagramContainer() {
		return diagramContainer;
	}
	
	public String getProcessVerText() {
		return processVerText.getText();
	}

}
