package org.foxbpm.bpmn.designer.ui.actor.runtime.create;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.foxbpm.bpmn.designer.base.utils.RuntimeConnectorUtil;
import org.foxbpm.bpmn.designer.ui.connector.runtime.DynamicPageWizard;
import org.foxbpm.bpmn.designer.ui.connector.runtime.create.CommonNewConnectorWizardPage;
import org.foxbpm.bpmn.designer.ui.expdialog.FoxBPMExpViewer;
import org.foxbpm.bpmn.designer.ui.expdialog.widget.ContentAssistText;
import org.foxbpm.bpmn.designer.ui.tree.RuntimeTreeViewerFactory;
import org.foxbpm.model.bpmn.foxbpm.ConnectorInstance;
import org.foxbpm.model.bpmn.foxbpm.ConnectorParameterInput;
import org.foxbpm.model.bpmn.foxbpm.Documentation;
import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;
import org.foxbpm.model.bpmn.foxbpm.SkipComment;
import org.foxbpm.model.config.connector.Input;
import org.foxbpm.model.config.connector.Widget;

public class AddNewActorConnectorWizard extends DynamicPageWizard {

	private SelectNewActorConnectorWizardPage selectNewConnectorWizardPage;

	private RenameConnectorWizardPage renameConnectorWizardPage;

	private EObject be;

	private ConnectorInstance connectorInstance;

	/**
	 * 
	 */
	public AddNewActorConnectorWizard(EObject be) {
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
//		if (this.getContainer().getCurrentPage() != selectNewConnectorWizardPage.getOutputConnectorWizardPage()) { // 最后一个页面
//			return false;
//		}
		
//		if(selectNewConnectorWizardPage.getCommonConnectotWizardPages() == null)
//			return false;
		
		if(selectNewConnectorWizardPage.getCommonConnectotWizardPages() != null)
			if (this.getContainer().getCurrentPage() != selectNewConnectorWizardPage
					.getCommonConnectotWizardPages()[selectNewConnectorWizardPage
					.getCommonConnectotWizardPages().length - 1])
				return false;
		
		return super.canFinish();
	}

	@Override
	public void addPages() {
		// 实例化向导页面
		selectNewConnectorWizardPage = new SelectNewActorConnectorWizardPage(be, "selectNewConnectorWizardPage", "选择器", null, this);

		renameConnectorWizardPage = new RenameConnectorWizardPage(be, "renameConnectorWizardPage", "给选择器命名", null);

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
//		String event = renameConnectorWizardPage.getLifeCycle().getEvent().trim();
//		String exception = renameConnectorWizardPage.getConnectExceptionCombo().getText();
//		String errorName = renameConnectorWizardPage.getConnectNameErrorText().getText().trim();
		String className = selectNewConnectorWizardPage.getConnector().getDefinitionImpl().getClassName();
		String packageName = selectNewConnectorWizardPage.getConnector().getDefinitionImpl().getPackageName();
//		ExpressionTo expressionTo = renameConnectorWizardPage.getExpressionComboViewer().getExpressionCombo().getExpressionTo();
//		String expName = expressionTo == null ? "" : expressionTo.getName();
//		String expValue = expressionTo == null ? "" : expressionTo.getExpressionText();

		// 跳过策略
		Expression skipexpression = FoxBPMFactory.eINSTANCE.createExpression();
//		skipexpression.setName(expName);
//		skipexpression.setValue(expValue);
		skipexpression.setName("");
		skipexpression.setValue("");
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

//		connectorInstance.setEventType(event);
//		connectorInstance.setErrorHandling(exception);
		connectorInstance.setErrorHandling("");
//		connectorInstance.setErrorCode(errorName);
		connectorInstance.setType("actorconnector");

		// 增加跳过策略
		if(skipComment.getExpression().getValue()!=null&&!skipComment.getExpression().getValue().equals("")){
			connectorInstance.setSkipComment(skipComment);
		}else{
			connectorInstance.setSkipComment(null);
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
							Input input = RuntimeConnectorUtil.getInputFromId(RuntimeTreeViewerFactory
											.getActorConnector(connectorInstance.getConnectorId()),
												((Widget) label.getData()).getInputId());
							
							connectorParameterInput = FoxBPMFactory.eINSTANCE.createConnectorParameterInput();
							connectorParameterInput.setId(((Widget) label.getData()).getInputId());
							connectorParameterInput.setName(((Widget) label.getData()).getName());
							connectorParameterInput.setIsExecute(input.getIsExecute());
							connectorParameterInput.setDataType(input.getType());
							continue;
						}

						if (control instanceof Text) {
							if(control.getParent() instanceof ContentAssistText) {
								FoxBPMExpViewer foxBPMExpViewer = ((ContentAssistText) control.getParent()).getFoxBPMExpViewer();
								expression = foxBPMExpViewer.getExpression();
							} else{
								Text text = (Text) control;
								expression.setValue(text.getText().trim());
							}
						} 
						else if (control instanceof Button) {
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

		return connectorInstance;
	}

	public ConnectorInstance getConnectorInstance() {
		return connectorInstance;
	}

	public void setConnectorInstance(ConnectorInstance connectorInstance) {
		this.connectorInstance = connectorInstance;
	}

}
