package org.foxbpm.bpmn.designer.ui.actor.runtime.modify;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.foxbpm.model.bpmn.foxbpm.ConnectorInstance;

public class ModifyRenameConnectorWizardPage extends WizardPage {

	private Label namelabel;
	
	private Text connectNameText;

	private Text connectDescriptionText;

	private ConnectorInstance connectorInstance;

	private EObject be;
	private Label label_1;

	/**
	 * @param pageName
	 * @wbp.parser.constructor
	 */
	public ModifyRenameConnectorWizardPage(String pageName) {
		super(pageName);
	}

	/**
	 * @param pageName
	 * @param title
	 * @param titleImage
	 */
	public ModifyRenameConnectorWizardPage(EObject be, String pageName, String title, ImageDescriptor titleImage, ConnectorInstance connectorInstance) {
		super(pageName, title, titleImage);
		this.connectorInstance = connectorInstance;
		this.be = be;

		// title信息
		setTitle(title);

		// 消息信息
		setMessage("指定选择器的参数", INFORMATION);

		// 设置图片
		setImageDescriptor(titleImage);
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
		// 创建一个底层的Composite，并使用GridLayout布局
		Composite newComposite = new Composite(parent, SWT.NULL);
		newComposite.setLayout(new FillLayout());

		// 创建布局
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2; // grid分为2列

		// 创建一个组
		Group proGroup = new Group(newComposite, SWT.NONE);
		proGroup.setLayout(gridLayout);
		proGroup.setText("连接器详细设置");

		// 创建label
		Label label = new Label(proGroup, SWT.NONE);
		label.setText("名称");

		// 创建文本框
		connectNameText = new Text(proGroup, SWT.BORDER);
		connectNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL)); // 布局
		connectNameText.setText(connectorInstance.getConnectorInstanceName());
		connectNameText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				if (connectNameText.getText().equals("")) {
					namelabel.setText("(       )");
				} else {
					namelabel.setText("( " + connectNameText.getText() + " )");
				}

				// 验证输入内容
				setPageComplete(isPageComplete());
			}
		});

		new Label(proGroup, SWT.NONE);

		namelabel = new Label(proGroup, SWT.NONE);
		namelabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL)); // 布局
		namelabel.setText("(    " + connectorInstance.getConnectorInstanceName() + "    )");

		label_1 = new Label(proGroup, SWT.NONE);
		label_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1));
		label_1.setText("描述");

		// 创建文本框
		connectDescriptionText = new Text(proGroup, SWT.BORDER | SWT.WRAP);
		GridData gd_connectDescriptionText = new GridData(400, 60);
		gd_connectDescriptionText.grabExcessVerticalSpace = true;
		gd_connectDescriptionText.verticalAlignment = SWT.FILL;
		gd_connectDescriptionText.horizontalAlignment = SWT.FILL;
		connectDescriptionText.setLayoutData(gd_connectDescriptionText); // 布局
		connectDescriptionText.setText(connectorInstance.getDocumentation().getValue() == null ? "" : connectorInstance.getDocumentation().getValue());
		connectDescriptionText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {

			}
		});


		// 初始化的时候先使‘完成’按钮不可用
		// setPageComplete(false);

		// 必须要的，将新的Composite放入
		setControl(newComposite);
	}

	/**
	 * 验证输入内容
	 */
	/*
	 * private void dataChange() {
	 * if(connectNameText.getText().trim().equals("")) {
	 * setErrorMessage("名称输入不能空"); //提示错误信息 setPageComplete(false);
	 * //使‘完成’和‘下一步’两个按钮不可用 return; }
	 * if(connectExceptionCombo.getSelectionIndex() == 2 &&
	 * connectNameErrorText.getText().equals("")) {
	 * setErrorMessage("'命名错误'不能空"); //提示错误信息 setPageComplete(false);
	 * //使‘完成’和‘下一步’两个按钮不可用 return; }
	 * 
	 * setErrorMessage(null); //清空错误信息 setPageComplete(true);
	 * //使‘完成’和‘下一步’两个按钮可用 }
	 */

	/**
	 * 重写验证
	 */
	@Override
	public boolean isPageComplete() {
		StringBuffer sb = new StringBuffer();

		if (null == connectNameText.getText() || connectNameText.getText().trim().equals("")) {
			sb.append("名称为空");
		}
//		if (connectExceptionCombo.getSelectionIndex() == 2 && (null == connectNameErrorText.getText() || connectNameErrorText.getText().equals(""))) {
//			if (sb.length() > 0)
//				sb.append(",");
//			sb.append("命名错误为空");
//		}

		if (sb.length() > 0) {
			ModifyRenameConnectorWizardPage.this.setErrorMessage(sb.toString());
			return false;
		} else {
			ModifyRenameConnectorWizardPage.this.setErrorMessage(null);
			return true;
		}
	}

	@Override
	public IWizardPage getPreviousPage() {
		return null;
	}

	public Text getConnectNameText() {
		return connectNameText;
	}

	public void setConnectNameText(Text connectNameText) {
		this.connectNameText = connectNameText;
	}

	public Text getConnectDescriptionText() {
		return connectDescriptionText;
	}

	public void setConnectDescriptionText(Text connectDescriptionText) {
		this.connectDescriptionText = connectDescriptionText;
	}

}
