package org.foxbpm.bpmn.designer.ui.connector.runtime.create;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.foxbpm.bpmn.designer.ui.connector.definition.Constant;
import org.foxbpm.bpmn.designer.ui.expdialog.FoxBPMExpViewer;
import org.foxbpm.bpmn.designer.ui.utils.FlowConnectorConfigUtil;
import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;
import org.foxbpm.model.config.connector.ConnectorDefinition;
import org.foxbpm.model.config.connector.Input;
import org.foxbpm.model.config.connector.Page;
import org.foxbpm.model.config.connector.Widget;

public class CommonNewConnectorWizardPage extends WizardPage {

	public static String[] types = Constant.WidgetConstant.getArray();

	private Page page;

	private ConnectorDefinition connector;

	private List<Control> controls;

	private List<Control> isRequiredControl;

	private boolean commonIsRequired;

	private FoxBPMExpViewer foxBPMExpViewer;

	private EObject be;

	/**
	 * @param pageName
	 */
	public CommonNewConnectorWizardPage(EObject be, String pageName) {
		super(pageName);
		this.be = be;
	}

	/**
	 * @param pageName
	 * @param title
	 * @param titleImage
	 */
	public CommonNewConnectorWizardPage(EObject be, String pageName, String title, String desc, ImageDescriptor titleImage, Page page, ConnectorDefinition connector) {
		super(pageName, title, titleImage);
		this.page = page;
		this.connector = connector;

		// title信息
		setTitle(title);

		// 消息信息
		setMessage(desc, INFORMATION);

		// 设置图片
		setImageDescriptor(titleImage);

		this.be = be;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets
	 * .Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		controls = new ArrayList<Control>();
		isRequiredControl = new ArrayList<Control>();

		// 创建一个底层的Composite，并使用GridLayout布局
		Composite newComposite = new Composite(parent, SWT.NULL);
		newComposite.setLayout(new FillLayout());

		// 创建布局
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3; // grid分为2列

		// 创建一个组
		Group proGroup = new Group(newComposite, SWT.NONE);
		proGroup.setLayout(gridLayout);
		proGroup.setText("详细设置");

		// 根据page动态画出控件
		EList<Widget> widgets = page.getWidget();
		if (widgets != null && widgets.size() > 0) {
			for (Iterator iterator = widgets.iterator(); iterator.hasNext();) {
				Widget widget = (Widget) iterator.next();
				final String id = widget.getId();
				String name = widget.getName();
				String type = Constant.WidgetConstant.getTypeWidget(widget);
				Input input = FlowConnectorConfigUtil.getInputFromId(connector, widget.getInputId());

				final boolean isRequired = input.getMandatory().equals("Mandatory") ? true : false;
				// final boolean isRequired = false;
				if (isRequired) {
					commonIsRequired = isRequired;
				}

				// 创建label
				Label label = new Label(proGroup, SWT.NONE);
				label.setText(name == null ? "" : name);
				label.setData(widget);
				if (isRequired) {
					Label label1 = new Label(proGroup, SWT.NONE);
					label1.setText("*");
				} else {
					new Label(proGroup, SWT.NONE);
				}
				controls.add(label);

				if (type.equals(types[0])) {
					// 创建文本框
					foxBPMExpViewer = new FoxBPMExpViewer(proGroup, SWT.NONE, be);

					Text expText = foxBPMExpViewer.getTextControl();

					GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
					gridData.grabExcessHorizontalSpace = true;
					foxBPMExpViewer.getControl().setLayoutData(gridData);

					if (isRequired) {
						isRequiredControl.add(expText);
					}

					expText.addModifyListener(new ModifyListener() {

						@Override
						public void modifyText(ModifyEvent e) {
							// 验证输入内容
							if (isRequired) {
								dataChange();
							}
						}
					});

					Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
					expression.setName(input.getDefaultValue());
					expression.setValue(input.getDefaultValue());
					foxBPMExpViewer.setExpression(expression);
					
//					expText.addModifyListener(null);
					controls.add(expText);
				}

				// 暂时还是跟text一样，保留
				else if (type.equals(types[1])) {
					// 创建文本框
					foxBPMExpViewer = new FoxBPMExpViewer(proGroup, SWT.NONE, be);

					Text expText = foxBPMExpViewer.getTextControl();

					GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
					gridData.grabExcessHorizontalSpace = true;
					foxBPMExpViewer.getControl().setLayoutData(gridData);

					if (isRequired) {
						isRequiredControl.add(expText);
					}

					expText.addModifyListener(new ModifyListener() {

						@Override
						public void modifyText(ModifyEvent e) {
							// 验证输入内容
							if (isRequired) {
								dataChange();
							}
						}
					});
//					expText.addModifyListener(null);
					controls.add(expText);
				}

				else if (type.equals(types[2])) {
					// 创建文本框
					final Text connectNameText = new Text(proGroup, SWT.BORDER | SWT.PASSWORD);
					connectNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL)); // 布局

					if (isRequired) {
						isRequiredControl.add(connectNameText);
					}

					connectNameText.addModifyListener(new ModifyListener() {

						public void modifyText(ModifyEvent e) {
							// 验证输入内容
							if (isRequired) {
								dataChange();
							}
						}
					});
					controls.add(connectNameText);
				} else if (type.equals(types[3])) {
					// 创建
					Button connectNameBtn = new Button(proGroup, SWT.BORDER | SWT.CHECK);
					connectNameBtn.setLayoutData(new GridData(GridData.FILL_HORIZONTAL)); // 布局
					if (isRequired) {
						isRequiredControl.add(connectNameBtn);
					}
					controls.add(connectNameBtn);
				} else if (type.equals(types[4])) {
					// 创建
					Button connectNameBtn = new Button(proGroup, SWT.BORDER | SWT.RADIO);
					connectNameBtn.setLayoutData(new GridData(GridData.FILL_HORIZONTAL)); // 布局
					if (isRequired) {
						isRequiredControl.add(connectNameBtn);
					}
					controls.add(connectNameBtn);
				} else if (type.equals(types[5])) {
					// 创建
					final Combo connectNameCombo = new Combo(proGroup, SWT.BORDER);
					connectNameCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL)); // 布局
					if (isRequired) {
						isRequiredControl.add(connectNameCombo);
					}
					connectNameCombo.addModifyListener(new ModifyListener() {

						public void modifyText(ModifyEvent e) {
							// 验证输入内容
							if (isRequired) {
								dataChange();
							}
						}
					});
					controls.add(connectNameCombo);
				}
			}
		}

		if (commonIsRequired) {
			// 初始化的时候先使‘完成’按钮不可用
			// setPageComplete(false);
		}

		// 必须要的，将新的Composite放入
		setControl(newComposite);
	}

	/**
	 * 验证输入内容
	 */
	private void dataChange() {
		// 循环需要验证控件列表
		for (Iterator iterator = isRequiredControl.iterator(); iterator.hasNext();) {
			Control valcontrol = (Control) iterator.next();
			if (valcontrol instanceof Text) {
				Text text = (Text) valcontrol;
				if (text.getText().trim().equals("")) {
					setErrorMessage("请填写必填信息"); // 提示错误信息
					setPageComplete(false); // 使‘完成’和‘下一步’两个按钮不可用
					return;
				}
			} else if (valcontrol instanceof Text) {
				Text expText = (Text) valcontrol;
				if (expText.getText().trim().equals("")) {
					setErrorMessage("请填写必填信息"); // 提示错误信息
					setPageComplete(false); // 使‘完成’和‘下一步’两个按钮不可用
					return;
				}
			}
		}

		setErrorMessage(null); // 清空错误信息
		setPageComplete(true); // 使‘完成’和‘下一步’两个按钮可用
	}

	public List<Control> getControls() {
		return controls;
	}

	public void setControls(List<Control> controls) {
		this.controls = controls;
	}

}