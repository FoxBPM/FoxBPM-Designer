package org.foxbpm.bpmn.designer.ui.actor.definition;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class CreateActorConnectorWizardDialog extends WizardDialog {

	public CreateActorConnectorWizardDialog(Shell parentShell, IWizard newWizard) {
		super(parentShell, newWizard);
		setHelpAvailable(false);
	}

	public void showPage(IWizardPage page) {
		super.showPage(page);
	}
	
	@Override
	public void cancelPressed() {
		super.cancelPressed();
	}
		
	/**
	 * Prevent the wizard to close accidentally by pressing escape (or the red cross)
	 * @see org.eclipse.jface.window.Window#canHandleShellCloseEvent()
	 */
	@Override
	protected boolean canHandleShellCloseEvent() {
		return true;
	}

	@Override
	protected Control createContents(Composite parent) {
		 Control c = super.createContents(parent);
		 getButton(IDialogConstants.FINISH_ID).setText("完成"); //完成按钮
	     getButton(IDialogConstants.CANCEL_ID).setText("取消"); //取消按钮
	     try {
	    	 getButton(IDialogConstants.BACK_ID).setText("上一步"); //上一步
	    	 getButton(IDialogConstants.BACK_ID).setEnabled(false);
			 getButton(IDialogConstants.NEXT_ID).setText("下一步"); //下一步
		} catch (Exception e) {}
	     return c;
	}
}
