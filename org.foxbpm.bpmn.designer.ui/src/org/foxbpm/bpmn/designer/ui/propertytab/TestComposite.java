package org.foxbpm.bpmn.designer.ui.propertytab;

import org.eclipse.bpmn2.Bpmn2Package.Literals;
import org.eclipse.bpmn2.StartEvent;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTResourceManager;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMComposite;

public class TestComposite extends AbstractFoxBPMComposite{
	private DataBindingContext m_bindingContext;
	private Text text;
	private StartEvent startEvent;

	public TestComposite(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public void createUIBindings(EObject eObject) {
		System.out.println("BIND我执行了");
		startEvent = (StartEvent) eObject;
//		bind(Bpmn2Package.Literals.BASE_ELEMENT__ID, text);
//		m_bindingContext = initDataBindings();
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(text);
		IObservableValue startEventIdObserveValue = EMFObservables.observeValue(startEvent, Literals.BASE_ELEMENT__ID);
		bindingContext.bindValue(observeTextTextObserveWidget, startEventIdObserveValue, null, null);
		//
		return bindingContext;
	}

	@Override
	public Composite createUI(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		composite.setLayout(new GridLayout(2, false));
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("测试");
		
		text = new Text(composite, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		return composite;
	}

	@Override
	public String setSectionTitle() {
		return "测试属性";
	}
}
