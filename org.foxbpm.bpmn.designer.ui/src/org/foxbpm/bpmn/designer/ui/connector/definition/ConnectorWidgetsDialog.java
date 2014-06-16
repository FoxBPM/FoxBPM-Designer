package org.foxbpm.bpmn.designer.ui.connector.definition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.foxbpm.bpmn.designer.ui.utils.DefinitionConnectorUtil;
import org.foxbpm.model.config.connector.ConnectorDefinition;
import org.foxbpm.model.config.connector.ConnectorFactory;
import org.foxbpm.model.config.connector.Input;
import org.foxbpm.model.config.connector.Page;
import org.foxbpm.model.config.connector.Widget;
import org.foxbpm.model.config.connector.WidgetExpression;

public class ConnectorWidgetsDialog extends TitleAreaDialog {
	private Text idText;
	private Text nameText;
	private Combo typeCombo;
	private Combo inputCombo;
	private Text descText;
	private List<Input> list;
	private ConnectorFactory ffactory;
	private ConnectorDefinition connector;
	private Page page;
	private boolean isEditor;
	private Widget widget;
	private Button okButton;
	private Button calButton;
//	private ExpressionComboViewer expressionComboViewer;
	
	@Override
	protected void okPressed() {
		if(setValue())	 
			super.okPressed();
	}

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public ConnectorWidgetsDialog(Shell parentShell,
			ConnectorDefinition connector, Page page, boolean isEditor, Widget widget) {
		super(parentShell);
		setHelpAvailable(false);
		this.list = connector.getInput();	//获取输入变量
		this.connector = connector;
		this.page = page;
		this.isEditor = isEditor;
		this.widget = widget;
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setMessage("连接器部件编辑");
		setTitle("部件");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(2, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("部件编号");
		
		idText = new Text(container, SWT.BORDER);
		idText.setEditable(false);
		idText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_1.setText("部件类型");
		
		typeCombo = new Combo(container, SWT.READ_ONLY);
		typeCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				widget = Constant.WidgetConstant.getWidgetType(typeCombo.getText());
			}
		});
		typeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblNewLabel_2 = new Label(container, SWT.NONE);
		lblNewLabel_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_2.setText("输入参数");
		
		inputCombo = new Combo(container, SWT.READ_ONLY);
		inputCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblNewLabel_3 = new Label(container, SWT.NONE);
		lblNewLabel_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_3.setText("显示名称");
		
		nameText = new Text(container, SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblNewLabel_4 = new Label(container, SWT.NONE);
		lblNewLabel_4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_4.setText("表达式");
		
		descText = new Text(container, SWT.BORDER | SWT.READ_ONLY);
		descText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ExpressionDialog dialog = new ExpressionDialog(getShell(), 
						descText.getText().trim());
				if(dialog.open() == Dialog.OK) {
					descText.setText(dialog.getValue());
				}
			}
		});
//		gd_text_2.heightHint = 84;
//		combo_1.setLayoutData(gd_text_2);
		descText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		
		//初始化数据
		initValue();

		return area;
	}
	
	private void initValue() {
		idText.setText(autoWidgetId());
		typeCombo.setItems(Constant.WidgetConstant.getArray());
		typeCombo.select(0);
		inputCombo.setItems(buildItems(list));
		
		if(isEditor) {
			idText.setText(widget.getId().trim());
			idText.setEditable(false);
			typeCombo.setText(Constant.WidgetConstant.getTypeWidget(widget));
			nameText.setText(widget.getName());
			inputCombo.setText(widget.getInputId());
			descText.setText(widget.getWidgetExpression().getExpressionValue());
		} 
		
		if(inputCombo.getText() == null || inputCombo.getText().equals("")) {
//			getButton(IDialogConstants.OK_ID).setEnabled(false);
		}
		
		if(widget == null)
			widget = Constant.WidgetConstant.getWidgetType(typeCombo.getText());
	}
	
	private boolean setValue() {
		if(inputCombo.getText().equals("")) {
			setErrorMessage("请选择输入参数");
			return false;
		}
		if(idText.getText().equals("")) {
			setErrorMessage("请输入编号");
			return false;
		}
		if(nameText.getText().equals("")) {
			setErrorMessage("请输入名称");
			return false;
		}
		if(!typeCombo.getText().equals("Text")) {
			setErrorMessage("目前FixFlow暂时仅支持Text部件类型");
			return false;
		}
		if(!isEditor) {
			EList<Page> pages = connector.getPage();
			if(pages != null && pages.size() > 0)
				for (Iterator iterator = pages.iterator(); iterator.hasNext();) {
					Page page = (Page) iterator.next();
					EList<Widget> widgets = page.getWidget();
					if(widgets != null && widgets.size() > 0)
						for (Iterator iterator2 = widgets.iterator(); iterator2
								.hasNext();) {
							Widget widget2 = (Widget) iterator2.next();
							if(widget2.getId().equals(idText.getText().trim())) {
								setErrorMessage("已存在相同编号的组件");
								return false;
							}
						}
				}
			else {
				EList<Widget> widgets = page.getWidget();
				if(widgets != null && widgets.size() > 0)
					for (Iterator iterator2 = widgets.iterator(); iterator2
							.hasNext();) {
						Widget widget2 = (Widget) iterator2.next();
						if(widget2.getId().equals(idText.getText().trim())) {
							setErrorMessage("已存在相同编号的组件");
							return false;
						}
					}
			}
		}
		
		setErrorMessage(null);	
		
		widget.setId(idText.getText().trim());
		widget.setName(nameText.getText().trim());
		widget.setInputId(inputCombo.getText());
		
		WidgetExpression expression = DefinitionConnectorUtil.createWidgetExpression();
		expression.setExpressionValue(descText.getText().trim());
		widget.setWidgetExpression(expression);
		
		return true;
	}
	
	/**
	 * 自动填充widget编号
	 * @return
	 */
	private String autoWidgetId() {
		List<String> widgetIds = new ArrayList<String>();
		EList<Page> pages = connector.getPage();
		if(pages != null && pages.size() > 0)
			for (Iterator iterator = pages.iterator(); iterator.hasNext();) {
				Page page = (Page) iterator.next();
				EList<Widget> widgets = page.getWidget();
				if(widgets != null && widgets.size() > 0)
					for (Iterator iterator2 = widgets.iterator(); iterator2
							.hasNext();) {
						Widget widget2 = (Widget) iterator2.next();
						if(!widgetIds.contains(widget2.getId())
								&& widget2.getId().startsWith("Widget_"))
							widgetIds.add(widget2.getId());
					}
			}
		else {
			EList<Widget> widgets = page.getWidget();
			if(widgets != null && widgets.size() > 0)
				for (Iterator iterator2 = widgets.iterator(); iterator2
						.hasNext();) {
					Widget widget2 = (Widget) iterator2.next();
					if(!widgetIds.contains(widget2.getId())
							&& widget2.getId().startsWith("Widget_"))
						widgetIds.add(widget2.getId());
				}
		}
		
		if(widgetIds.size() <= 0) {
			return "Widget_0";
		}
		
		String maxWidgetId = Collections.max(widgetIds, new Comparator<String>() {	//取最大的
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		
		return maxWidgetId.substring(0, maxWidgetId.lastIndexOf("_") + 1) +
				(Integer.parseInt(maxWidgetId.substring(maxWidgetId.lastIndexOf("_") + 1)) + 1);
	}

	private String[] buildItems(List<Input> list) {
		String[] array = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i).getId();
		}
		return array;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		okButton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		okButton.setText("确定");
		calButton = createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
		calButton.setText("取消");
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 346);
	}

	public Widget getValue() {
		return widget;
	}
	
}
