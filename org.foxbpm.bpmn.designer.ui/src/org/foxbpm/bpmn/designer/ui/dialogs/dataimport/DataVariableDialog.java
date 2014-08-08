package org.foxbpm.bpmn.designer.ui.dialogs.dataimport;

import java.util.List;

import org.eclipse.bpmn2.FormalExpression;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.foxbpm.bpmn.designer.base.utils.FoxBPMDesignerUtil;
import org.foxbpm.bpmn.designer.ui.dialogs.DataVarTo;
import org.foxbpm.bpmn.designer.ui.expdialog.ExpressionChangedEvent;
import org.foxbpm.bpmn.designer.ui.expdialog.FoxBPMExpViewer;
import org.foxbpm.bpmn.designer.ui.expdialog.IExpressionChangedListener;
import org.foxbpm.bpmn.designer.ui.utils.DataVarUtil;
import org.foxbpm.model.bpmn.foxbpm.DataVariable;
import org.foxbpm.model.bpmn.foxbpm.Documentation;
import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;
import org.foxbpm.model.config.variableconfig.DataTypeDef;
import org.foxbpm.model.config.variableconfig.DataVariableBizType;

public class DataVariableDialog extends TitleAreaDialog {
	@SuppressWarnings("unused")
	private DataBindingContext m_bindingContext;
	private Text nametext;
	private Text desctext;
	private Button istransientCheckButton;
	private Button ismutiCheckButton;
	private DataVariable dataVariable;
	// private Expression expression;
	FoxBPMExpViewer expressionComboViewer;
	private Combo typecombo;
	private ComboViewer typecomboViewer;
	private String openType;
	private EObject be;
	ComboViewer bizTypeCV;
	Combo bizTypeCombo;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 * @wbp.parser.constructor
	 */
	public DataVariableDialog(EObject be, Shell parentShell) {
		super(parentShell);
		setHelpAvailable(false);
		setShellStyle(SWT.RESIZE | SWT.TITLE | SWT.PRIMARY_MODAL);
		dataVariable = FoxBPMFactory.eINSTANCE.createDataVariable();
		this.openType = "open";
		this.be = be;
	}

	/**
	 * 修改时构造函数
	 * 
	 * @param parentShell
	 */
	public DataVariableDialog(EObject be, Shell parentShell, DataVariable dataVariable) {

		super(parentShell);
		setHelpAvailable(false);
		setShellStyle(SWT.RESIZE | SWT.TITLE | SWT.PRIMARY_MODAL);
		this.dataVariable = dataVariable;
		this.openType = "modify";
		this.be = be;
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("创建数据变量");

		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		GridLayout gl_container = new GridLayout(8, false);
		gl_container.marginBottom = 20;
		gl_container.verticalSpacing = 10;
		gl_container.marginHeight = 20;
		gl_container.marginRight = 30;
		gl_container.marginLeft = 30;
		container.setLayout(gl_container);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		Label nameLabel = new Label(container, SWT.NONE);
		nameLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		nameLabel.setText("名称");

		nametext = new Text(container, SWT.BORDER);
		nametext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 7, 1));

		Label typeLabel = new Label(container, SWT.NONE);
		typeLabel.setText("数据类型");

		typecomboViewer = new ComboViewer(container, SWT.READ_ONLY);
		typecomboViewer.setContentProvider(new ArrayContentProvider());
		typecomboViewer.setLabelProvider(new ViewerLabelProvider());
		typecomboViewer.setInput(FoxBPMDesignerUtil.getDataVariableConfig().getDataVariableDataType().getDataTypeDef());

		typecombo = typecomboViewer.getCombo();
		typecombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 7, 1));
		if ((List<DataTypeDef>) (typecomboViewer.getInput()) != null && ((List<DataTypeDef>) (typecomboViewer.getInput())).size() > 0) {
			typecombo.select(0);
		}

		Label istransientLabel = new Label(container, SWT.NONE);
		istransientLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		istransientLabel.setText("持久化");

		istransientCheckButton = new Button(container, SWT.CHECK);

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setText("业务类型");

		bizTypeCV = new ComboViewer(container, SWT.READ_ONLY);
		bizTypeCV.setContentProvider(new ArrayContentProvider());
		bizTypeCV.setLabelProvider(new ViewerLabelProviderType());
		bizTypeCV.setInput(FoxBPMDesignerUtil.getDataVariableConfig().getDataVariableBizTypeConfig().getDataVariableBizType());

		bizTypeCombo = bizTypeCV.getCombo();
		bizTypeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1));

		Label expLabel = new Label(container, SWT.NONE);
		expLabel.setText("默认值");

		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		GridData gd_composite = new GridData(SWT.FILL, SWT.CENTER, false, false, 7, 1);
		gd_composite.widthHint = 280;
		composite.setLayoutData(gd_composite);

		expressionComboViewer = new FoxBPMExpViewer(composite, SWT.BORDER, be);
		expressionComboViewer.addExpressionChangedListeners(new IExpressionChangedListener() {

			@Override
			public void expressionChanged(final ExpressionChangedEvent event) {
				FormalExpression formalExpression = event.getFormalExpression();
				Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
				if(formalExpression!=null) {
					Object expName = formalExpression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME);
					expression.setName(expName==null?"":expName.toString());
					expression.setValue(formalExpression.getBody());
				}
				
				//传递表达式对象
				expressionComboViewer.setExpression(expression);
			}
		});
		
		Label descLabel = new Label(container, SWT.NONE);
		descLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
		descLabel.setText("描述");

		desctext = new Text(container, SWT.BORDER | SWT.WRAP);
		GridData gd_desctext = new GridData(SWT.FILL, SWT.FILL, false, true, 7, 1);
		gd_desctext.heightHint = 50;
		desctext.setLayoutData(gd_desctext);

		ismutiCheckButton = new Button(container, SWT.CHECK);
		ismutiCheckButton.setEnabled(false);
		GridData gd_ismutiCheckButton = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_ismutiCheckButton.widthHint = 30;
		ismutiCheckButton.setLayoutData(gd_ismutiCheckButton);
		ismutiCheckButton.setVisible(false);
		new Label(container, SWT.NONE);

		Label ismutiLabel = new Label(container, SWT.NONE);
		ismutiLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		ismutiLabel.setText("多个");
		ismutiLabel.setVisible(false);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		init();

		return area;
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		Button button = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		button.setText("确定");
		Button button_1 = createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
		button_1.setText("取消");
		m_bindingContext = initDataBindings();
	}

	@Override
	protected void okPressed() {
		// 做数据变量名称唯一性验证
		if (openType.equals("open")) {
			List<DataVarTo> dataVarTos = DataVarUtil.getDataVarTos(be);
			for (DataVarTo dataVarTo : dataVarTos) {
				if (nametext.getText() != null && dataVarTo.getId() != null) {
					if (dataVarTo.getId().equals(nametext.getText())) {
						MessageDialog.openWarning(null, "警告", "已存在的数据变量ID，请更换ID");
						return;
					}
				}
			}
		}

		if (openType.equals("modify") && !(nametext.getText().equals(dataVariable.getId()))) {
			List<DataVarTo> dataVarTos = DataVarUtil.getDataVarTos(be);
			for (DataVarTo dataVarTo : dataVarTos) {
				if (nametext.getText() != null) {
					if (dataVarTo.getId().equals(nametext.getText())) {
						MessageDialog.openWarning(null, "警告", "已存在的数据变量ID，请更换ID");
						return;
					}
				}
			}
		}

		dataVariable = FoxBPMFactory.eINSTANCE.createDataVariable();
		dataVariable.setId(nametext.getText() == null ? "" : nametext.getText());
		dataVariable.setIsList(ismutiCheckButton.getSelection());
		dataVariable.setIsPersistence(istransientCheckButton.getSelection());
		dataVariable.setDataType(((DataTypeDef) ((IStructuredSelection) typecomboViewer.getSelection()).getFirstElement()) == null ? "" : ((DataTypeDef) ((IStructuredSelection) typecomboViewer
				.getSelection()).getFirstElement()).getId());

		Expression expressionTo = expressionComboViewer.getExpression();
		if (expressionTo != null) {
			Expression expression = FoxBPMFactory.eINSTANCE.createExpression();
			expression.setName(expressionTo.getName());
			expression.setValue(expressionTo.getValue());
			dataVariable.setExpression(expression);
		}

		Documentation documentation = FoxBPMFactory.eINSTANCE.createDocumentation();
		documentation.setValue(desctext.getText() == null ? "" : desctext.getText());
		dataVariable.getDocumentation().add(documentation);

		dataVariable.setBizType(FoxBPMDesignerUtil.getDataVariableConfig().getDataVariableBizTypeConfig().getDataVariableBizType().get(bizTypeCombo.getSelectionIndex()).getTypeId());

		super.okPressed();
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(430, 380);
	}

	public DataVariable getDataVariable() {
		return dataVariable;
	}

	public void setDataVariable(DataVariable dataVariable) {
		this.dataVariable = dataVariable;
	}

	public Text getDesctext() {
		return desctext;
	}

	public void setDesctext(Text desctext) {
		this.desctext = desctext;
	}

	private class ViewerLabelProvider extends LabelProvider {
		public Image getImage(Object element) {
			return super.getImage(element);
		}

		public String getText(Object element) {
			DataTypeDef dataTypeDef = (DataTypeDef) element;
			return dataTypeDef.getName();
		}
	}

	private class ViewerLabelProviderType extends LabelProvider {
		public Image getImage(Object element) {
			return super.getImage(element);
		}

		public String getText(Object element) {
			DataVariableBizType dataVariableBizType = (DataVariableBizType) element;
			return dataVariableBizType.getTypeName();
		}
	}

	/**
	 * 初始化
	 */
	public void init() {
		if (dataVariable != null) {

			nametext.setText(dataVariable.getId() == null ? "" : dataVariable.getId());

			istransientCheckButton.setSelection(dataVariable.isIsPersistence());

			ismutiCheckButton.setSelection(dataVariable.isIsList());

			DataTypeDef dataTypeDef = DataVarUtil.getDataTypeDefByDataVariableDataType(dataVariable.getDataType());
			for (int i=0; i< ((List<DataTypeDef>)typecomboViewer.getInput()).size(); i++) {
				if(((List<DataTypeDef>)typecomboViewer.getInput()).get(i).getId().equals(dataTypeDef.getId())) {
					typecomboViewer.getCombo().select(i);
					break;
				}
			}
			typecomboViewer.setSelection(new StructuredSelection(dataTypeDef));

			if (dataVariable.getExpression() != null) {
				Expression expressionTo = FoxBPMFactory.eINSTANCE.createExpression();
				expressionTo.setName(dataVariable.getExpression().getName()==null?"":dataVariable.getExpression().getName());
				expressionTo.setValue(dataVariable.getExpression().getValue()==null?"":dataVariable.getExpression().getValue());
				expressionComboViewer.setExpression(expressionTo);
			}

			desctext.setText(dataVariable.getDocumentation().size() > 0 ? dataVariable.getDocumentation().get(0).getValue() : "");

			List<DataVariableBizType> dataVariableBizTypes = FoxBPMDesignerUtil.getDataVariableConfig().getDataVariableBizTypeConfig().getDataVariableBizType();

			if (dataVariable.getBizType() == null || dataVariable.getBizType().equals("")) {
				for (int i = 0; i < dataVariableBizTypes.size(); i++) {
					if (dataVariableBizTypes.get(i).getTypeId().equals("customVariable")) {
						bizTypeCombo.select(i);
						break;
					}
				}
			} else {
				for (int i = 0; i < dataVariableBizTypes.size(); i++) {
					if (dataVariableBizTypes.get(i).getTypeId().equals(dataVariable.getBizType())) {
						bizTypeCombo.select(i);
						break;
					}
				}
			}

		} else {

		}
	}

	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		return bindingContext;
	}
}
