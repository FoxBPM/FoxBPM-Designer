package org.foxbpm.bpmn.designer.ui.expdialog;

import org.eclipse.bpmn2.Bpmn2Factory;
import org.eclipse.bpmn2.FormalExpression;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.DefaultToolTip;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.foxbpm.bpmn.designer.ui.expdialog.widget.ContentAssistText;
import org.foxbpm.bpmn.designer.ui.utils.ImageUtil;
import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;

public class FoxBPMExpViewer extends ContentViewer {
	protected Composite control;
	private ContentAssistText contentAssistText;
	private DefaultToolTip textTooltip;
	private Text textControl;
	private ControlDecoration typeDecoration;
	private ControlDecoration messageDecoration;
	protected boolean isPassword;
	private ToolBar toolbar;
	protected ToolItem editControl;
	private ToolItem eraseControl;
	private Expression expression;
	private EObject eObject;

	public FoxBPMExpViewer(Composite composite, int style) {
		createControl(composite, style);
	}
	
	public FoxBPMExpViewer(Composite composite, int style, EObject eObject) {
		createControl(composite, style);
		this.eObject = eObject;
	}

	@Override
	public Control getControl() {
		return control;
	}

	@Override
	public ISelection getSelection() {
		return null;
	}

	@Override
	public void refresh() {

	}

	@Override
	public void setSelection(ISelection selection, boolean reveal) {

	}

	protected void createControl(Composite composite, int style) {
		control = new Composite(composite, SWT.INHERIT_DEFAULT);
//		control.setLayout(new GridLayout(1, false));
//		control.addDisposeListener(disposeListener);
		control.setLayout(GridLayoutFactory.fillDefaults().numColumns(2).margins(0, 0).spacing(0, 0).create());
		createTextControl(style);
		createToolbar(style);
	}
	
	protected void createTextControl(int style) {
		contentAssistText = new ContentAssistText(this, control, style);
		textControl = contentAssistText.getTextControl();
//		textControl.addDisposeListener(disposeListener);
		textTooltip = new DefaultToolTip(textControl) {
			@Override
			protected boolean shouldCreateToolTip(Event event) {
				return super.shouldCreateToolTip(event) && getText(event) != null;
			}
		};
		textTooltip.setShift(new Point(5, 5));
		textTooltip.setRespectMonitorBounds(true);
		textTooltip.setPopupDelay(100);

		Display.getCurrent().asyncExec(new Runnable() {
			
			@Override
			public void run() {
				if(!contentAssistText.isDisposed() && !control.isDisposed()) {
					typeDecoration = new ControlDecoration(contentAssistText.getToolbar(), SWT.LEFT, control);
					typeDecoration.setMarginWidth(0);	
				}
			}
		});

//		messageDecoration = new ControlDecoration(contentAssistText, SWT.LEFT, control);
//		messageDecoration.setShowHover(true);
//		messageDecoration.setMarginWidth(1);
//		messageDecoration.hide();


		int indent = 0;
		if ((style & SWT.PASSWORD) != 0) {
			isPassword = true;
		}
		if ((style & SWT.BORDER) != 0) {
//			indent = 16;
		}
		contentAssistText.setLayoutData(GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).indent(indent, 0)
				.grab(true, false).create());
	}
	
	protected void createToolbar(int style) {
		toolbar = new ToolBar(control, SWT.FLAT | SWT.NO_FOCUS);
		toolbar.setLayoutData(GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(false, false).create());
		editControl = createEditToolItem(toolbar);
		createEraseToolItem(toolbar);
	}
	
	protected ToolItem createEditToolItem(final ToolBar tb) {
		final ToolItem editControl = new ToolItem(tb, SWT.PUSH | SWT.NO_FOCUS);
		editControl.setImage(ImageUtil.getImageFromName("/expwidget/edit.png"));
		editControl.setToolTipText("编辑...");

		/* For test purpose */
		editControl.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
//				boolean connectorEdit = false;
//					for(ToolItem ti : tb.getItems()){
//						connectorEdit = true;
//						ti.notifyListeners(SWT.Selection, event);
//					}
//				if(!connectorEdit){
//					openEditDialog();
//				}
				openEditDialog();
			}
		});

//		editControl.addDisposeListener(disposeListener);
		return editControl;
	}

	protected ToolItem createEraseToolItem(ToolBar tb) {
		eraseControl = new ToolItem(tb, SWT.PUSH | SWT.NO_FOCUS);
		eraseControl.setImage(ImageUtil.getImageFromName("/expwidget/clear.png"));
		eraseControl.setToolTipText("清除...");

		/* For test purpose */
		eraseControl.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				textControl.setText("");
				expression = null;
				FormalExpression formalExpression = Bpmn2Factory.eINSTANCE.createFormalExpression();
				formalExpression.eSet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME, "");
				formalExpression.setBody("");
				fireExpressioChanged(new ExpressionChangedEvent(FoxBPMExpViewer.this, formalExpression));
				refresh();
			}
		});


//		eraseControl.addDisposeListener(disposeListener);
		return eraseControl;
	}
	
	protected void openEditDialog() {
		FoxBPMExpDialog foxBPMExpDialog = new FoxBPMExpDialog(Display.getDefault().getActiveShell(), expression, textControl);
		if(InputDialog.OK == foxBPMExpDialog.open()) {
			expression = foxBPMExpDialog.getExpression();
			FormalExpression formalExpression = Bpmn2Factory.eINSTANCE.createFormalExpression();
			ModelUtil.setID(formalExpression,eObject.eResource());
			formalExpression.eSet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME, expression.getName());
			formalExpression.setBody(expression.getValue());
			fireExpressioChanged(new ExpressionChangedEvent(this, formalExpression));
			
			this.textControl.setText(expression.getName());
		}
	}

	private ListenerList expressionListeners = new ListenerList();

	public void addExpressionChangedListeners(IExpressionChangedListener listener) {
		expressionListeners.add(listener);
		this.textControl.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				if(eObject == null) {
					return;
				}
				if(expression==null) {
					expression = FoxBPMFactory.eINSTANCE.createExpression();
					expression.setName("");
					expression.setValue("");
				}
				if(!((Text)e.getSource()).getText().equals(expression.getName()) && (expression.getName()==null?"":expression.getName()).equals(expression.getValue())) {
					FormalExpression formalExpression = Bpmn2Factory.eINSTANCE.createFormalExpression();
					ModelUtil.setID(formalExpression,eObject.eResource());
					formalExpression.eSet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME, ((Text)e.getSource()).getText());
					formalExpression.setBody(((Text)e.getSource()).getText());
					fireExpressioChanged(new ExpressionChangedEvent(FoxBPMExpViewer.this, formalExpression));
				}
			}
		});
	}
	
	protected void fireExpressioChanged(final ExpressionChangedEvent event) {
		Object[] listeners = expressionListeners.getListeners();
		for (int i = 0; i < listeners.length; ++i) {
			final IExpressionChangedListener l = (IExpressionChangedListener) listeners[i];
			SafeRunnable.run(new SafeRunnable() {
				public void run() {
					l.expressionChanged(event);
				}
			});
		}
	}
	
	public void cleanData() {
		textControl.setText("");
		expression = null;
		fireExpressioChanged(new ExpressionChangedEvent(FoxBPMExpViewer.this, null));
	}
	
	public Expression getExpression() {
		return expression;
	}

	public Text getTextControl() {
		return textControl;
	}

	public void setExpression(Expression expression) {
		//获取光标位置
		int offset = textControl.getCaretPosition();
		
		this.expression = expression;
		if(expression!=null && expression.getValue()!=null && expression.getName()!=null && textControl.getText()!=null && expression.getName()!=expression.getValue()) {
			textControl.setText(expression.getName());
		}else if(expression!=null && expression.getValue()!=null && textControl.getText()!=null && expression.getName()==expression.getValue()) {
			textControl.setText(expression.getValue());
		}
		
		//文本
		String document = textControl.getText();
		//光标前字符串
		String before = document.substring(0, offset);
		//光标后字符串
		String after = document.substring(offset);
		
		StringBuffer sb = new StringBuffer();
		sb.append(before);
		sb.append(after);
		//设置值
		textControl.setText(sb.toString());
		//设置光标位置为当前输入的位置
		textControl.setSelection(before.length());
	}

	public void seteObject(EObject eObject) {
		this.eObject = eObject;
	}
	
	public void setEnabled(boolean isEnable) {
		this.contentAssistText.setEnabled(isEnable);
		this.toolbar.setEnabled(isEnable);
	}
}
