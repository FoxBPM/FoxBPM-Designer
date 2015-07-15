package org.foxbpm.bpmn.designer.ui.custom;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.foxbpm.bpmn.designer.ui.expdialog.FoxBPMExpDialog;
import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FormParam;

public class ExpDialogCellEditor extends DialogCellEditor {
	private Shell shell;
	private Expression expression;
	private Text text;
	private Table table;
	private TransactionalEditingDomain editingDomain;
	private TableViewer tableViewer;

	public ExpDialogCellEditor(Composite parent, Shell shell, TransactionalEditingDomain editingDomain, TableViewer tableViewer) {
		super(parent);
		this.shell = shell;
		this.text = new Text(shell, SWT.NONE);
		this.table = (Table) parent;
		this.editingDomain = editingDomain;
		this.tableViewer = tableViewer;
	}

	@Override
	protected Object openDialogBox(Control cellEditorWindow) {
		FormParam formParam = (FormParam) table.getSelection()[0].getData();
		FoxBPMExpDialog foxBPMExpDialog = new FoxBPMExpDialog(editingDomain, formParam, shell, expression, text);
		if(InputDialog.OK == foxBPMExpDialog.open()) {
			expression = foxBPMExpDialog.getExpression();
		}
		tableViewer.refresh();
		return expression == null?"":expression.getName();
	}

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
		this.text.setText(expression.getName());
	}
}
