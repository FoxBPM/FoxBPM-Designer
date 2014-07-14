package org.foxbpm.bpmn.designer.ui.propertytab.timerdefinition;

import org.eclipse.bpmn2.StartEvent;
import org.eclipse.bpmn2.TimerEventDefinition;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMComposite;
import org.foxbpm.bpmn.designer.ui.expdialog.FoxBPMExpViewer;
import org.foxbpm.model.bpmn.foxbpm.Documentation;
import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;

public class TimerEventDefinitionPropertyComposite extends AbstractFoxBPMComposite{
	private StartEvent startEvent;

	public TimerEventDefinitionPropertyComposite(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public void createUIBindings(EObject eObject) {
		startEvent = (StartEvent) eObject;
		TimerEventDefinition timerEventDefinition = (TimerEventDefinition) startEvent.getEventDefinitions().get(0);
		org.eclipse.bpmn2.Expression exp1 = timerEventDefinition.getTimeDate();
		org.eclipse.bpmn2.Expression exp2 = timerEventDefinition.getTimeDuration();
		org.eclipse.bpmn2.Expression exp3 = timerEventDefinition.getTimeCycle();
		
		Expression timerdateexp = FoxBPMFactory.eINSTANCE.createExpression();
		Expression timerdurationexp = FoxBPMFactory.eINSTANCE.createExpression();
		Expression timercycleexp = FoxBPMFactory.eINSTANCE.createExpression();
		
		timerdateexp.setName(exp1.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
		timerdateexp.setValue(((Documentation)exp1.getDocumentation().get(0)).getName());
		
		timerdurationexp.setName(((Documentation)exp2.getDocumentation().get(0)).getName());
		timerdurationexp.setValue(((Documentation)exp2.getDocumentation().get(0)).getName());
		
		timercycleexp.setName(((Documentation)exp3.getDocumentation().get(0)).getName());
		timercycleexp.setValue(((Documentation)exp3.getDocumentation().get(0)).getName());
	}

	@Override
	public Composite createUI(Composite parent) {
		Composite detailComposite = new Composite(parent, SWT.NONE);
		detailComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		detailComposite.setLayout(new GridLayout(2, false));
		
		Label timedateLabel = new Label(detailComposite, SWT.NONE);
		timedateLabel.setText("TimeDate");
		
		FoxBPMExpViewer foxBPMExpViewer = new FoxBPMExpViewer(detailComposite, SWT.BORDER);
		Control control = foxBPMExpViewer.getControl();
		control.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label timedurationLabel = new Label(detailComposite, SWT.NONE);
		timedurationLabel.setText("TimeDuration");
		
		FoxBPMExpViewer foxBPMExpViewer_1 = new FoxBPMExpViewer(detailComposite, SWT.BORDER);
		Control control_1 = foxBPMExpViewer_1.getControl();
		control_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label timercycleLabel = new Label(detailComposite, SWT.NONE);
		timercycleLabel.setText("TimerCycle");
		
		FoxBPMExpViewer foxBPMExpViewer_2 = new FoxBPMExpViewer(detailComposite, SWT.BORDER);
		Control control_2 = foxBPMExpViewer_2.getControl();
		control_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		return parent;
	}

	@Override
	public String setDescId() {
		return "start_event_desc";
	}
}
