package org.foxbpm.bpmn.designer.ui.custom;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.foxbpm.bpmn.designer.ui.expdialog.FoxBPMExpDialog;
import org.foxbpm.model.bpmn.foxbpm.Expression;

public class ExpDialogCellEditor extends DialogCellEditor {
	private Shell shell;
	private Expression expression;
	private Text text;

	public ExpDialogCellEditor(Composite parent, Shell shell) {
		super(parent);
		this.shell = shell;
		this.text = new Text(shell, SWT.NONE);
	}

	@Override
	protected Object openDialogBox(Control cellEditorWindow) {
		FoxBPMExpDialog foxBPMExpDialog = new FoxBPMExpDialog(shell, expression, text);
		if(InputDialog.OK == foxBPMExpDialog.open()) {
			expression = foxBPMExpDialog.getExpression();
		}
		return expression.getName();
	}

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
		this.text.setText(expression.getName());
	}

}
