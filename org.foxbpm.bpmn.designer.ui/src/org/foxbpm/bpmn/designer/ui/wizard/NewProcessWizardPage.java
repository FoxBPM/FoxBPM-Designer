package org.foxbpm.bpmn.designer.ui.wizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class NewProcessWizardPage extends WizardPage {
	private Text containerText;
	private Text processIdText;
	private Text processNameText;
	private String validationLevel;
	private Label label_1;

	/**
	 * Create the wizard.
	 */
	public NewProcessWizardPage() {
		super("wizardPage");
		setTitle("创建向导");
		setDescription("创建新的FoxBPM流程");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout gl_container = new GridLayout(2, false);
		gl_container.marginTop = 10;
		gl_container.marginRight = 15;
		gl_container.marginLeft = 15;
		container.setLayout(gl_container);
		
		Label label = new Label(container, SWT.NULL);
		label.setText("文件位置:");
		
				containerText = new Text(container, SWT.BORDER | SWT.SINGLE);
				containerText.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false, 1, 1));
				containerText.addModifyListener(new ModifyListener() {
					@Override
					public void modifyText(ModifyEvent e) {
						
					}
				});
		
		/*String filepath = ResourcesPlugin.getWorkspace().getRoot().getProject().getLocation().toString();
		containerText.setText(filepath+"/src");*/

		/*Button button = new Button(container, SWT.PUSH);
		button.setText("浏览...");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleBrowse();
			}
		});*/
		label_1 = new Label(container, SWT.NULL);
		label_1.setText("流程编号:");
		
				processIdText = new Text(container, SWT.BORDER | SWT.SINGLE);
				processIdText.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false, 1, 1));
				processIdText.addModifyListener(new ModifyListener() {
					@Override
					public void modifyText(ModifyEvent e) {
						
					}
				});
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setText("流程名称:");
		
		processNameText = new Text(container, SWT.BORDER);
		processNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		processNameText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				
			}
		});
		setControl(container);
	}

}
