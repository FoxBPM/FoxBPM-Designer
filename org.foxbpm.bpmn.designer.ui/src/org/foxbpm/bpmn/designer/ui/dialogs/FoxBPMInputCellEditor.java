package org.foxbpm.bpmn.designer.ui.dialogs;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class FoxBPMInputCellEditor extends DialogCellEditor {
	private Shell shell;
	public String text;
	
	public FoxBPMInputCellEditor(Composite parent, Shell shell) {
		super(parent);
		this.shell = shell;
	}

	@Override
	protected Object openDialogBox(Control cellEditorWindow) {
		FoxBPMInputCellDialog ffid = new FoxBPMInputCellDialog(shell, text);
		ffid.setBlockOnOpen(true);
		if(ffid != null && ffid.open() == InputDialog.OK) {
			return ffid.getDatatext();
		}
		return null;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
