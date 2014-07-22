package org.foxbpm.bpmn.designer.ui.propertytab.boundaryevent;

import org.eclipse.bpmn2.BoundaryEvent;
import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMComposite;

public class BoundaryEventPropertyComposite extends AbstractFoxBPMComposite{
	private BoundaryEvent boundaryEvent;
	private Text idText;
	private Text nameText;
	private Button terminalButton;
	private Text descText;

	public BoundaryEventPropertyComposite(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public void createUIBindings(EObject eObject) {
		boundaryEvent = (BoundaryEvent) eObject;
		
		bindText(Bpmn2Package.Literals.BASE_ELEMENT__ID, idText, boundaryEvent);
		bindText(Bpmn2Package.Literals.FLOW_ELEMENT__NAME, nameText, boundaryEvent);
		bindDocumentation(Bpmn2Package.Literals.BASE_ELEMENT__DOCUMENTATION, descText);
		
		terminalButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {

						if (boundaryEvent.isCancelActivity()) {
							boundaryEvent.setCancelActivity(false);
						} else {
							boundaryEvent.setCancelActivity(true);
						}
					}
				});

			}
		});
		
		if (boundaryEvent.isCancelActivity()) {
			// btnCheckButton.
			terminalButton.setSelection(true);
		} else {
			terminalButton.setSelection(false);
		}
	}

	@Override
	public Composite createUI(Composite parent) {
		Composite detailComposite = new Composite(parent, SWT.NONE);
		detailComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		detailComposite.setLayout(new GridLayout(2, false));
		
		Label idLabel = new Label(detailComposite, SWT.NONE);
		idLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		idLabel.setText("编号");
		
		idText = new Text(detailComposite, SWT.BORDER);
		idText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label nameLabel = new Label(detailComposite, SWT.NONE);
		nameLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		nameLabel.setText("名称");
		
		nameText = new Text(detailComposite, SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label typeLabel = new Label(detailComposite, SWT.NONE);
		typeLabel.setText("类型");
		
		terminalButton = new Button(detailComposite, SWT.CHECK);
		terminalButton.setText("终止活动");
		
		Label descLabel = new Label(detailComposite, SWT.NONE);
		descLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		descLabel.setText("描述");
		
		descText = new Text(detailComposite, SWT.BORDER);
		GridData gd_descText = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_descText.heightHint = 50;
		descText.setLayoutData(gd_descText);
		
		return parent;
	}

	@Override
	public String setDescId() {
		return "";
	}
}
