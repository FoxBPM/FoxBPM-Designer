package org.foxbpm.bpmn.designer.core.runtime;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

import org.eclipse.bpmn2.BaseElement;
import org.eclipse.bpmn2.Bpmn2Factory;
import org.eclipse.bpmn2.Documentation;
import org.eclipse.bpmn2.GatewayDirection;
import org.eclipse.bpmn2.ParallelGateway;
import org.eclipse.bpmn2.modeler.core.Bpmn2TabbedPropertySheetPage;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.ListAndDetailCompositeBase;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.ui.editor.BPMN2Editor;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.IValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.foxbpm.bpmn.designer.base.utils.PropertiesUtil;
import org.osgi.framework.Bundle;

public abstract class AbstractFoxBPMComposite extends Composite {
	protected EObject businessObject;
	protected DiagramEditor diagramEditor;
	protected AbstractFoxBPMPropertySection propertySection;
	protected FormToolkit formToolkit;
	private Label label;
	protected ISWTObservableValue observable;

	public AbstractFoxBPMComposite(Composite parent, int style) {
		super(parent, style);
		formToolkit = new FormToolkit(Display.getDefault());
		formToolkit.adapt(this);
		setLayout(new GridLayout(1, false));
		setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1));

		// 描述section
		Section sctnNewSection = formToolkit.createSection(this, Section.EXPANDED | Section.TWISTIE | Section.TITLE_BAR);
		sctnNewSection.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1));

		Composite composite = new Composite(sctnNewSection, SWT.NONE);
		GridLayout gl_composite = new GridLayout(1, false);
		gl_composite.verticalSpacing = 0;
		gl_composite.marginWidth = 0;
		gl_composite.marginHeight = 0;
		gl_composite.horizontalSpacing = 0;
		composite.setLayout(gl_composite);
		label = new Label(composite, SWT.V_SCROLL);
		label.setText(getDescFromProperties(setDescId()) == null ? "" : getDescFromProperties(setDescId()));
		GridData gd_text_1 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text_1.heightHint = 50;
		label.setLayoutData(gd_text_1);
		formToolkit.adapt(label, true, true);
		sctnNewSection.setClient(composite);
		sctnNewSection.setText("描述");
		sctnNewSection.setExpanded(false);

		// 详细属性页section
		Section detailSection = formToolkit.createSection(this, Section.NO_TITLE);
		detailSection.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1));

		Composite detailComposite = new Composite(detailSection, SWT.NONE);
		detailComposite.setLayout(new GridLayout(2, false));
		formToolkit.adapt(detailComposite);
		detailSection.setClient(detailComposite);

		adaptAllcontrols(createUI((Composite) detailSection.getClient()));

		formToolkit.paintBordersFor(sctnNewSection);
	}

	private void adaptAllcontrols(Control c) {
		if(c instanceof Composite) {
			Composite composite = (Composite) c;
			for (Control c1 : composite.getChildren()) {
				adaptAllcontrols(c1);
			}
			formToolkit.adapt(composite);
		}else {
			formToolkit.adapt(c, true, true);
		}
	}

	private String getDescFromProperties(String id) {
		if(id==null || id.equals(""))
			return "暂无信息";
		Bundle bundle = Platform.getBundle("org.foxbpm.bpmn.designer.base");
		// 为了WB能展现加的这句话
		if (bundle == null)
			return "";
		String proPath = null;
		try {
			proPath = FileLocator.resolve(bundle.getEntry("resources/description.properties")).getPath();
			if (proPath == null)
				return "";
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			return new String(PropertiesUtil.readProperties(proPath).get(id).toString().getBytes("ISO8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public abstract String setDescId();

	public abstract Composite createUI(Composite parent);

	public abstract void createUIBindings(EObject eObject);

	public void refresh() {

	}

	public EObject getBusinessObject() {
		return businessObject;
	}

	public void setBusinessObject(final EObject businessObject) {
		getDiagramEditor();
		if (diagramEditor == null)
			diagramEditor = ModelUtil.getEditor(businessObject);
		this.businessObject = businessObject;

		if (businessObject != null) {
			createUIBindings(businessObject);
			redrawPage();
		}

		// Do initial validation to force display of error message if any
		Notification n = new ENotificationImpl((InternalEObject) businessObject, 0, null, null, null, false);
		validate(n);
	}

	@Override
	public void dispose() {
		ModelUtil.disposeChildWidgets(this);
		super.dispose();
	}

	protected void cleanBindings() {
		ModelUtil.disposeChildWidgets(this);
	}

	public DiagramEditor getDiagramEditor() {

		if (diagramEditor != null)
			return diagramEditor;
		// if (getPropertySection()!=null)
		// return (DiagramEditor)getPropertySection().getDiagramEditor();
		// Composite parent = getParent();
		// while (parent!=null && !(parent instanceof
		// ListAndDetailCompositeBase))
		// parent = parent.getParent();
		// if (parent instanceof ListAndDetailCompositeBase)
		// return diagramEditor =
		// ((ListAndDetailCompositeBase)parent).getDiagramEditor();

		IWorkbenchPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
		if (part instanceof DiagramEditor)
			diagramEditor = (DiagramEditor) part;
		else if (part instanceof IEditorPart) {
			diagramEditor = (DiagramEditor) ((IEditorPart) part).getAdapter(DiagramEditor.class);
		} else if (part instanceof PropertySheet) {
			TabbedPropertySheetPage page = (TabbedPropertySheetPage) ((PropertySheet) part).getCurrentPage();
			if (page instanceof Bpmn2TabbedPropertySheetPage) {
				diagramEditor = ((Bpmn2TabbedPropertySheetPage) page).getDiagramEditor();
			}
		}
		return diagramEditor;
	}

	public void setDiagramEditor(DiagramEditor diagramEditor) {
		this.diagramEditor = diagramEditor;
	}

	protected void validate(Notification notification) {
		IValidator<Notification> validator = ModelValidationService.getInstance().newValidator(EvaluationMode.LIVE);
		validator.validate(notification);
	}

	public AbstractFoxBPMPropertySection getPropertySection() {
		if (propertySection != null)
			return propertySection;
		Composite parent = getParent();
		while (parent != null && !(parent instanceof ListAndDetailCompositeBase))
			parent = parent.getParent();
		if (parent instanceof ListAndDetailCompositeBase)
			return ((AbstractFoxBPMComposite) parent).getPropertySection();
		return null;
	}

	public void redrawPage() {
		if (getPropertySection() != null) {
			getPropertySection().layout();
			getParent().layout();
			layout();
		} else {
			ModelUtil.recursivelayout(getParent());
		}
	}

	protected void bindDocumentation(final EStructuralFeature a, final Text text) {
		final EObject be = this.getBusinessObject();
		final BaseElement baseElement = (BaseElement) be;

		if (baseElement.getDocumentation().size() == 0 || baseElement.getDocumentation().get(0).getText() == null) {
			text.setText("");
		} else {
			text.setText(baseElement.getDocumentation().get(0).getText());
		}

		IObservableValue textObserver = WidgetProperties.text(SWT.Modify).observe(text);
		textObserver.addValueChangeListener(new IValueChangeListener() {

			@Override
			public void handleValueChange(final ValueChangeEvent e) {
				TransactionalEditingDomainImpl editingDomain = (TransactionalEditingDomainImpl) getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						if (baseElement.getDocumentation().size() == 0) {
							final Documentation value = Bpmn2Factory.eINSTANCE.createDocumentation();
							ModelUtil.setID(value, be.eResource());
							value.setText(e.diff.getNewValue().toString());
							baseElement.getDocumentation().add(value);
						} else {
							baseElement.getDocumentation().get(0).setText(e.diff.getNewValue().toString());
						}
					}
				});
				if (((BPMN2Editor) getDiagramEditor()).getDiagnostics() != null) {
					// revert the change and display error status message.
					List<Documentation> documentationList = baseElement.getDocumentation();
					if (!text.getText().equals(documentationList.get(0).getText())) {

						documentationList.get(0).setText(e.diff.getNewValue().toString());
					}
					// bpmn2Editor.showErrorMessage(bpmn2Editor.getDiagnostics().getMessage());
				}
			}
		});
	}
	
	protected void bindDocumentation(final EStructuralFeature a, final Text text, final EObject be) {
		final BaseElement baseElement = (BaseElement) be;

		if (baseElement.getDocumentation().size() == 0 || baseElement.getDocumentation().get(0).getText() == null) {
			text.setText("");
		} else {
			text.setText(baseElement.getDocumentation().get(0).getText());
		}

		IObservableValue textObserver = WidgetProperties.text(SWT.Modify).observe(text);
		textObserver.addValueChangeListener(new IValueChangeListener() {

			@Override
			public void handleValueChange(final ValueChangeEvent e) {
				TransactionalEditingDomainImpl editingDomain = (TransactionalEditingDomainImpl) getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						if (baseElement.getDocumentation().size() == 0) {
							final Documentation value = Bpmn2Factory.eINSTANCE.createDocumentation();
							ModelUtil.setID(value, be.eResource());
							value.setText(e.diff.getNewValue().toString());
							baseElement.getDocumentation().add(value);
						} else {
							baseElement.getDocumentation().get(0).setText(e.diff.getNewValue().toString());
						}
					}
				});
				if (((BPMN2Editor) getDiagramEditor()).getDiagnostics() != null) {
					// revert the change and display error status message.
					List<Documentation> documentationList = baseElement.getDocumentation();
					if (!text.getText().equals(documentationList.get(0).getText())) {

						documentationList.get(0).setText(e.diff.getNewValue().toString());
					}
					// bpmn2Editor.showErrorMessage(bpmn2Editor.getDiagnostics().getMessage());
				}
			}
		});
	}

	protected void bindText(EStructuralFeature a, Text text, final EObject element) {
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();

		IObservableValue uiObserveValue = EMFEditObservables.observeValue(getDiagramEditor().getEditingDomain(), element, a);

		observable = SWTObservables.observeDelayedValue(400, SWTObservables.observeText(text, SWT.Modify));

		observable.addChangeListener(new IChangeListener() {

			public void handleChange(ChangeEvent event) {
				if (element != null) {
					IEditorPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
					if (part instanceof BPMN2Editor) {
						((BPMN2Editor) getDiagramEditor()).refresh();
					}
				}
			}
		});

		bindingContext.bindValue(observable, uiObserveValue, null, null);
	}
	
	protected void bindTextWithNoDelay(EStructuralFeature a, Text text, final EObject element) {
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();

		IObservableValue uiObserveValue = EMFEditObservables.observeValue(getDiagramEditor().getEditingDomain(), element, a);

		observable = SWTObservables.observeDelayedValue(0, SWTObservables.observeText(text, SWT.Modify));

		observable.addChangeListener(new IChangeListener() {

			public void handleChange(ChangeEvent event) {
				if (element != null) {
					IEditorPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
					if (part instanceof BPMN2Editor) {
						((BPMN2Editor) getDiagramEditor()).refresh();
					}
				}
			}
		});

		bindingContext.bindValue(observable, uiObserveValue, null, null);
	}
	
	protected void bindCombo(EStructuralFeature a, Combo combo, final EObject element) {
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();

		IObservableValue uiObserveValue = EMFEditObservables.observeValue(getDiagramEditor().getEditingDomain(), element, a);

		observable = SWTObservables.observeDelayedValue(0, WidgetProperties.text().observe(combo));

		observable.addChangeListener(new IChangeListener() {

			public void handleChange(ChangeEvent event) {
				if (element != null) {
					IEditorPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
					if (part instanceof BPMN2Editor) {
						((BPMN2Editor) getDiagramEditor()).refresh();
					}
				}
			}
		});

		bindingContext.bindValue(observable, uiObserveValue, null, null);
	}
	
	protected void bindGatewayDirection(final Combo combo) {
		final ParallelGateway parallelGateway = (ParallelGateway) getBusinessObject();
		GatewayDirection gatewayDirection = parallelGateway.getGatewayDirection();
		// Unspecified
		if (gatewayDirection == GatewayDirection.UNSPECIFIED) {
			combo.select(0);
			TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
				@Override
				protected void doExecute() {
					parallelGateway.setGatewayDirection(GatewayDirection.DIVERGING);
				}
			});
		}
		// 分
		if (gatewayDirection == GatewayDirection.DIVERGING) {
			combo.select(0);
		}
		// 合
		if (gatewayDirection == GatewayDirection.CONVERGING) {
			combo.select(1);
		}

		IObservableValue textObserver = SWTObservables.observeText(combo);
		textObserver.addValueChangeListener(new IValueChangeListener() {

			@Override
			public void handleValueChange(final ValueChangeEvent e) {
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						if (combo.getSelectionIndex() == 0) {
							parallelGateway.setGatewayDirection(GatewayDirection.DIVERGING);
						} else {
							parallelGateway.setGatewayDirection(GatewayDirection.CONVERGING);
						}
					}
				});
			}
		});
	}
	
	/**
	 * 增加灯泡
	 * 
	 * @param control
	 * @param id
	 */
	protected void addDecorate(Control control, String id) {
		Bundle bundle = Platform.getBundle("org.foxbpm.bpmn.designer.ui");
		Class<?> theClass = null;
		Object[] params = {control, id};  
		try {
			theClass = bundle.loadClass("org.foxbpm.bpmn.designer.ui.utils.ControlDecorateUtil");
			Method method = theClass.getMethod("addDecorate", Control.class, String.class);
			method.invoke(theClass, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
