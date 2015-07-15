package org.foxbpm.bpmn.designer.ui.connector.runtime.create;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.foxbpm.bpmn.designer.base.utils.RuntimeConnectorUtil;
import org.foxbpm.bpmn.designer.ui.connector.runtime.DynamicPageWizard;
import org.foxbpm.bpmn.designer.ui.expdialog.FoxBPMExpViewer;
import org.foxbpm.bpmn.designer.ui.expdialog.widget.ContentAssistText;
import org.foxbpm.model.bpmn.foxbpm.ConnectorInstance;
import org.foxbpm.model.bpmn.foxbpm.ConnectorParameterInput;
import org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutput;
import org.foxbpm.model.bpmn.foxbpm.ConnectorParameterOutputDef;
import org.foxbpm.model.bpmn.foxbpm.Documentation;
import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;
import org.foxbpm.model.bpmn.foxbpm.SkipComment;
import org.foxbpm.model.bpmn.foxbpm.TimeExpression;
import org.foxbpm.model.bpmn.foxbpm.TimeSkipExpression;
import org.foxbpm.model.config.connector.Input;
import org.foxbpm.model.config.connector.Output;
import org.foxbpm.model.config.connector.Widget;

public class AddNewConnectorWizard extends DynamicPageWizard {

	private SelectNewConnectorWizardPage selectNewConnectorWizardPage;

	private RenameConnectorWizardPage renameConnectorWizardPage;

	private EObject be;

	private ConnectorInstance connectorInstance;

	/**
	 * 
	 */
	public AddNewConnectorWizard(EObject be) {
		this.be = be;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		ConnectorInstance connectorInstance = save();
		this.connectorInstance = connectorInstance;
		return true;
	}

	@Override
	public boolean canFinish() {
		// 当没有到最后一页时‘完成’按钮不可用
		if (this.getContainer().getCurrentPage() != selectNewConnectorWizardPage.getOutputConnectorWizardPage()) { // 最后一个页面
			return false;
		}
		return super.canFinish();
	}

	@Override
	public void addPages() {
		// 实例化向导页面
		selectNewConnectorWizardPage = new SelectNewConnectorWizardPage(be, "selectNewConnectorWizardPage", "选择连接器", null, this);

		renameConnectorWizardPage = new RenameConnectorWizardPage(be, "renameConnectorWizardPage", "给连接器命名", null);

		addPage(selectNewConnectorWizardPage);
		addPage(renameConnectorWizardPage);

		super.addPages();
	}

	/**
	 * 保存
	 */
	private ConnectorInstance save() {
		// 封装连接器页面数据
		String name = renameConnectorWizardPage.getConnectNameText().getText().trim();
		String description = renameConnectorWizardPage.getConnectDescriptionText().getText().trim();
		String event = renameConnectorWizardPage.getLifeCycle().getEvent().trim();
		String exception = renameConnectorWizardPage.getConnectExceptionCombo().getText();
		String errorName = renameConnectorWizardPage.getConnectNameErrorText().getText().trim();
		String className = selectNewConnectorWizardPage.getConnector().getDefinitionImpl().getClassName();
		String packageName = selectNewConnectorWizardPage.getConnector().getDefinitionImpl().getPackageName();
		// 跳过策略
		Expression skipexpression = renameConnectorWizardPage.getFoxBPMExpViewer().getExpression();
		SkipComment skipComment = FoxBPMFactory.eINSTANCE.createSkipComment();
		skipComment.setExpression(skipexpression);

		ConnectorInstance connectorInstance = FoxBPMFactory.eINSTANCE.createConnectorInstance();
		connectorInstance.setConnectorId(selectNewConnectorWizardPage.getConnector().getId());
		connectorInstance.setConnectorInstanceId(UUID.randomUUID().toString());
		connectorInstance.setConnectorInstanceName(name);

		connectorInstance.setClassName(className);
		connectorInstance.setPackageName(packageName);

		Documentation documentation = FoxBPMFactory.eINSTANCE.createDocumentation();
		documentation.setValue(description);
		connectorInstance.setDocumentation(documentation);

		connectorInstance.setEventType(event);
		connectorInstance.setErrorHandling(exception);
		connectorInstance.setErrorCode(errorName);
		connectorInstance.setType("flowconnector");

		// 增加跳过策略
		if (skipComment.getExpression() != null && skipComment.getExpression().getValue() != null && !skipComment.getExpression().getValue().equals("")) {
			connectorInstance.setSkipComment(skipComment);
		} else {
			connectorInstance.setSkipComment(null);
		}

		boolean isTimeExecute = renameConnectorWizardPage.getCheckButton().getSelection();

		connectorInstance.setIsTimeExecute(isTimeExecute);

		if (isTimeExecute) {
			TimeExpression timeExpression = FoxBPMFactory.eINSTANCE.createTimeExpression();
			Expression expressionTime = renameConnectorWizardPage.getTimeFoxBPMExpViewer().getExpression();
			timeExpression.setExpression(expressionTime);
			connectorInstance.setTimeExpression(timeExpression);

			TimeSkipExpression timeExpressionSkip = FoxBPMFactory.eINSTANCE.createTimeSkipExpression();
			Expression expressionTimeSkip = renameConnectorWizardPage.getSkipFoxBPMExpViewer().getExpression();
			timeExpressionSkip.setExpression(expressionTimeSkip);
			connectorInstance.setTimeSkipExpression(timeExpressionSkip);

		} else {
			connectorInstance.setTimeExpression(null);
			connectorInstance.setTimeSkipExpression(null);
		}

		// 封装一个或多个输入页面数据
		// 获取所有的输入页面
		CommonNewConnectorWizardPage[] commonConnectotWizardPages = selectNewConnectorWizardPage.getCommonConnectotWizardPages();
		if (commonConnectotWizardPages != null && commonConnectotWizardPages.length > 0) {
			for (int i = 0; i < commonConnectotWizardPages.length; i++) {
				CommonNewConnectorWizardPage commonConnectotWizardPage = commonConnectotWizardPages[i];

				ConnectorParameterInput connectorParameterInput = null;

				// 获取每页所有的控件control
				List<Control> controls = commonConnectotWizardPage.getControls();
				if (controls != null && controls.size() > 0) {
					for (Iterator iterator = controls.iterator(); iterator.hasNext();) {
						Control control = (Control) iterator.next();

						Expression expression = FoxBPMFactory.eINSTANCE.createExpression();

						// 分类进行数据处理
						if (control instanceof Label) {
							Label label = (Label) control;
							Input input = RuntimeConnectorUtil.getInputFromId(RuntimeConnectorUtil.getFlowConnectorByMenuConnectorId(connectorInstance.getConnectorId()),
									((Widget) label.getData()).getInputId());

							connectorParameterInput = FoxBPMFactory.eINSTANCE.createConnectorParameterInput();
							connectorParameterInput.setId(((Widget) label.getData()).getInputId());
							connectorParameterInput.setName(((Widget) label.getData()).getName());
							connectorParameterInput.setIsExecute(input.getIsExecute());
							connectorParameterInput.setDataType(input.getType());
							continue;
						}

						if (control instanceof Text) {
							if (control.getParent() instanceof ContentAssistText) {
								FoxBPMExpViewer foxBPMExpViewer = ((ContentAssistText) control.getParent()).getFoxBPMExpViewer();
								expression = foxBPMExpViewer.getExpression();
							} else {
								Text text = (Text) control;
								expression.setValue(text.getText().trim());
							}
						} else if (control instanceof Button) {
							Button button = (Button) control;
							expression.setValue(button.getText().trim());
						}

						connectorParameterInput.setExpression(expression);

						connectorInstance.getConnectorParameterInputs().add(connectorParameterInput);
						// 重新实例化
						connectorParameterInput = FoxBPMFactory.eINSTANCE.createConnectorParameterInput();
					}
				}
			}
		}

		// 封装输出页面数据
		List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();

		OutputNewConnectorWizardPage outputConnectorWizardPage = selectNewConnectorWizardPage.getOutputConnectorWizardPage();
		// 获取所有的输出控件
		List<Combo> combos = new ArrayList<Combo>();
		Control[] controls = outputConnectorWizardPage.getGridComposite().getChildren();
		if (controls != null && controls.length > 0) {
			for (int i = 0; i < controls.length; i++) {
				Control control = controls[i];
				// 控件必须是combo才有效
				if (control instanceof Combo) {
					Combo combo = (Combo) control;
					combos.add(combo);
				}
			}
		}

		// 重新组织combo控件
		for (int i = 0; i < combos.size(); i = i + 2) {
			Map<String, Object> map = new HashMap<String, Object>();

			Combo combo = (Combo) combos.get(i);
			Combo comboNext = (Combo) combos.get(i + 1);

			if (combo.getData("type").toString().equals("expression")) {
//				Expression outExpression = FoxBPMFactory.eINSTANCE.createExpression();
//				outExpression.setValue(combo.getText().trim());
//				map.put("expression", outExpression);
				map.put("expression", combo.getText().trim());
			} else if (combo.getData("type").toString().equals("target")) {
				map.put("target", combo.getText().trim());
			}

			if (comboNext.getData("type").toString().equals("expression")) {
				Expression outExpression = FoxBPMFactory.eINSTANCE.createExpression();
				outExpression.setValue(comboNext.getText().trim());
				map.put("expression", outExpression);
			} else if (comboNext.getData("type").toString().equals("target")) {
				map.put("target", comboNext.getText().trim());
			}

			maps.add(map);
		}

		// 将数据组织封装成为connectorParameterOutputs
		for (Iterator iterator = maps.iterator(); iterator.hasNext();) {
			Map<String, Object> map = (Map<String, Object>) iterator.next();
			ConnectorParameterOutput connectorParameterOutput = FoxBPMFactory.eINSTANCE.createConnectorParameterOutput();
//			connectorParameterOutput.setExpression((Expression) map.get("expression"));
			connectorParameterOutput.setOutputId(map.get("expression").toString());
			connectorParameterOutput.setVariableTarget(String.valueOf(map.get("target")));
			connectorInstance.getConnectorParameterOutputs().add(connectorParameterOutput);
		}

		// 存输出参数，后来添加
		List<ConnectorParameterOutputDef> connectorParameterOutputDefs = new ArrayList<ConnectorParameterOutputDef>();

		List<Output> outputParameters = selectNewConnectorWizardPage.getConnector().getOutput();

		for (Output outputParameter : outputParameters) {
			ConnectorParameterOutputDef connectorParameterOutputDef = FoxBPMFactory.eINSTANCE.createConnectorParameterOutputDef();
			connectorParameterOutputDef.setId(outputParameter.getId());
			connectorParameterOutputDef.setName(outputParameter.getName());
			connectorParameterOutputDef.setDataType(outputParameter.getType());
			connectorParameterOutputDefs.add(connectorParameterOutputDef);
		}

		connectorInstance.getConnectorParameterOutputsDef().addAll(connectorParameterOutputDefs);

		return connectorInstance;
	}

	public ConnectorInstance getConnectorInstance() {
		return connectorInstance;
	}

	public void setConnectorInstance(ConnectorInstance connectorInstance) {
		this.connectorInstance = connectorInstance;
	}

}
