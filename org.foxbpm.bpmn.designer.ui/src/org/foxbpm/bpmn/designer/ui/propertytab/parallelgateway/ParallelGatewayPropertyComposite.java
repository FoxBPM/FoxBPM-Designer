package org.foxbpm.bpmn.designer.ui.propertytab.parallelgateway;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.ParallelGateway;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMComposite;

public class ParallelGatewayPropertyComposite extends AbstractFoxBPMComposite {
	private ParallelGateway parallelGateway;
	private Text descText;
	private Text idText;
	private Text nameText;
	private Combo iotypeCombo;
	private Combo mergestrategyCombo;

	public ParallelGatewayPropertyComposite(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public void createUIBindings(EObject eObject) {
		parallelGateway = (ParallelGateway) eObject;
		bindText(Bpmn2Package.Literals.BASE_ELEMENT__ID, idText, parallelGateway);
		bindText(Bpmn2Package.Literals.FLOW_ELEMENT__NAME, nameText, parallelGateway);
		bindDocumentation(Bpmn2Package.Literals.BASE_ELEMENT__DOCUMENTATION, descText);
		bindGatewayDirection(iotypeCombo);
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
		idText.setEditable(false);

		Label nameLabel = new Label(detailComposite, SWT.NONE);
		nameLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		nameLabel.setText("名称");

		nameText = new Text(detailComposite, SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label iotypeLabel = new Label(detailComposite, SWT.NONE);
		iotypeLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		iotypeLabel.setText("进出类型");

		iotypeCombo = new Combo(detailComposite, SWT.NONE);
		iotypeCombo.setItems(new String[] { "分散", "合并" });
		iotypeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		iotypeCombo.select(0);

		Label mergestrategyLabel = new Label(detailComposite, SWT.NONE);
		mergestrategyLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		mergestrategyLabel.setText("合并策略");

		mergestrategyCombo = new Combo(detailComposite, SWT.NONE);
		mergestrategyCombo.setItems(new String[] { "线条数量", "令牌数量" });
		mergestrategyCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		mergestrategyCombo.select(0);

		Label descLabel = new Label(detailComposite, SWT.NONE);
		descLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		descLabel.setText("描述");

		descText = new Text(detailComposite, SWT.BORDER | SWT.WRAP | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL | SWT.MULTI);
		GridData gd_descText = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_descText.heightHint = 50;
		descText.setLayoutData(gd_descText);

		return parent;
	}

	@Override
	public String setDescId() {
		return "parallel_gateway_desc";
	}
}
