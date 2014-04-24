package org.foxbpm.bpmn.designer.core.runtime;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpmn2.BaseElement;
import org.eclipse.bpmn2.Bpmn2Factory;
import org.eclipse.bpmn2.Documentation;
import org.eclipse.bpmn2.modeler.core.Bpmn2TabbedPropertySheetPage;
import org.eclipse.bpmn2.modeler.core.merrimac.IConstants;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.ListAndDetailCompositeBase;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.ui.editor.BPMN2Editor;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.IValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
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

public abstract class AbstractFoxBPMComposite extends Composite implements ResourceSetListener, Adapter {
	protected EObject businessObject;
	protected TransactionalEditingDomainImpl editingDomain;
	protected DiagramEditor diagramEditor;
	protected AbstractFoxBPMPropertySection propertySection;
	protected FormToolkit formToolkit;
	private Label label;

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
		Section detailSection = formToolkit.createSection(this, Section.TITLE_BAR);
		detailSection.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1));

		Composite detailComposite = new Composite(detailSection, SWT.NONE);
		detailComposite.setLayout(new GridLayout(2, false));

		detailSection.setClient(detailComposite);

		formToolkit.adapt(createUI((Composite) detailSection.getClient()));

		// 设置标题
		detailSection.setText(setSectionTitle());

		formToolkit.paintBordersFor(sctnNewSection);
	}

	private String getDescFromProperties(String id) {
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

	public abstract String setSectionTitle();

	public abstract Composite createUI(Composite parent);

	public abstract void createUIBindings(EObject eObject);

	public void refresh() {

		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				List<Control> kids = new ArrayList<Control>();
				Composite parent = AbstractFoxBPMComposite.this;
				try {
					AbstractFoxBPMPropertySection section = AbstractFoxBPMComposite.this.getPropertySection();
					if (section != null && section.getTabbedPropertySheetPage() != null) {
						parent = (Composite) section.getTabbedPropertySheetPage().getControl();
					}
				} catch (Exception e) {
				}
				// Send a notification to all listeners about this refresh
				// event.
				// This will cause all children to be refreshed when a property
				// tab switch happens.
				Notification n = new ENotificationImpl(null, -1, -1, 0, 0);
				getAllChildWidgets(parent, kids);
				for (Control c : kids) {
					INotifyChangedListener listener = (INotifyChangedListener) c.getData(IConstants.NOTIFY_CHANGE_LISTENER_KEY);
					if (listener != null) {
						listener.notifyChanged(n);
					}
				}
			}
		});
	}

	public EObject getBusinessObject() {
		return businessObject;
	}

	public void setBusinessObject(EObject businessObject) {
		getDiagramEditor();
		if (diagramEditor == null)
			diagramEditor = ModelUtil.getEditor(businessObject);
		addDomainListener();
		removeChangeListener(businessObject);
		this.businessObject = businessObject;
		addChangeListener(businessObject);

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
		removeDomainListener();
		removeChangeListener(businessObject);

		ModelUtil.disposeChildWidgets(this);
		super.dispose();
	}

	protected void addDomainListener() {
		if (editingDomain == null) {
			editingDomain = (TransactionalEditingDomainImpl) getDiagramEditor().getEditingDomain();
			editingDomain.addResourceSetListener(this);
		}
	}

	protected void removeDomainListener() {
		if (editingDomain != null) {
			editingDomain.removeResourceSetListener(this);
		}
	}

	protected void addChangeListener(EObject object) {
		if (object != null && !object.eAdapters().contains(this))
			object.eAdapters().add(this);
	}

	protected void removeChangeListener(EObject object) {
		if (object != null && object.eAdapters().contains(this)) {
			object.eSetDeliver(false);
			object.eAdapters().remove(this);
			object.eSetDeliver(true);
		}
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

	@Override
	public void notifyChanged(Notification notification) {
		validate(notification);
	}

	@Override
	public Notifier getTarget() {
		return null;
	}

	@Override
	public void setTarget(Notifier newTarget) {

	}

	@Override
	public boolean isAdapterForType(Object type) {
		return false;
	}

	@Override
	public NotificationFilter getFilter() {
		NotificationFilter filter = null;
		// the editor needs to return a "do nothing" filter while a save is in
		// progress
		if (diagramEditor != null)
			filter = (NotificationFilter) diagramEditor.getAdapter(NotificationFilter.class);
		if (filter == null) {
			filter = NotificationFilter.NOT_TOUCH;
		}
		return filter;
	}

	@Override
	public Command transactionAboutToCommit(ResourceSetChangeEvent event) throws RollbackException {
		return null;
	}

	protected void getAllChildWidgets(Composite parent, List<Control> kids) {
		if (parent != null && !parent.isDisposed()) {
			Control[] cs = parent.getChildren();
			for (Control c : cs) {
				if (c instanceof Composite) {
					getAllChildWidgets((Composite) c, kids);
				}
				if (!c.isDisposed() && c.getData(IConstants.NOTIFY_CHANGE_LISTENER_KEY) instanceof INotifyChangedListener) {
					kids.add(c);
				}
			}
		}
	}

	@Override
	public void resourceSetChanged(ResourceSetChangeEvent event) {

		final List<Notification> notifications = new ArrayList<Notification>();
		List<Notification> eventNotifications = event.getNotifications();
		for (int i = eventNotifications.size() - 1; i >= 0; --i) {
			Notification n = eventNotifications.get(i);
			if (getFilter().matches(n)) {
				boolean add = true;
				if (n.getFeature() instanceof EStructuralFeature) {
					EStructuralFeature f = (EStructuralFeature) n.getFeature();
					EClass ec = f.getEContainingClass();
					// Attempt to reduce the number of notifications to process:
					// notifications for the XMLTypePackage are inconsequential
					if (ec.getEPackage() == XMLTypePackage.eINSTANCE)
						add = false;
				}
				for (Notification n2 : notifications) {
					if (n2.getNotifier() == n.getNotifier() && n2.getFeature() == n.getFeature()) {
						add = false;
						break;
					}
				}
				if (add) {
					notifications.add(n);
				}
			}
		}
		// System.out.println("resource changed: "+this.getClass().getSimpleName()+" "+notifications.size()+" notifications");
		// run this in the UI thread
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				List<Control> kids = new ArrayList<Control>();
				Composite parent = AbstractFoxBPMComposite.this;
				try {
					AbstractFoxBPMPropertySection section = AbstractFoxBPMComposite.this.getPropertySection();
					if (section != null && section.getTabbedPropertySheetPage() != null) {
						parent = (Composite) section.getTabbedPropertySheetPage().getControl();
					}
				} catch (Exception e) {
					return;
				}

				boolean firstTime = true;
				for (Notification n : notifications) {
					if (getFilter().matches(n)) {
						if (n.getFeature() instanceof EStructuralFeature) {
							// EStructuralFeature f =
							// (EStructuralFeature)n.getFeature();
							// EClass ec = (EClass)f.eContainer();
							// String et;
							// switch (n.getEventType()){
							// case Notification.SET: et = "SET"; break;
							// case Notification.UNSET: et = "UNSET"; break;
							// case Notification.ADD: et = "ADD"; break;
							// case Notification.ADD_MANY: et = "ADD_MANY";
							// break;
							// case Notification.REMOVE: et = "REMOVE"; break;
							// case Notification.REMOVE_MANY: et =
							// "REMOVE_MANY"; break;
							// default: et = "UNKNOWN";
							// }
							// System.out.println("sending notification: "+
							// ec.getEPackage().getName()+":"+ec.getName()+"."+f.getName()+"   "+et+" old="+n.getOldStringValue()+" new="+n.getNewStringValue());
							if (firstTime) {
								getAllChildWidgets(parent, kids);
								firstTime = false;
							}
							for (Control c : kids) {
								if (!c.isDisposed() && c.isVisible()) {
									INotifyChangedListener listener = (INotifyChangedListener) c.getData(IConstants.NOTIFY_CHANGE_LISTENER_KEY);
									if (listener != null) {
										// System.out.println("    "+listener.getClass().getSimpleName());
										listener.notifyChanged(n);
									}
								}
							}
						}
					}
				}
			}
		});
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

	@Override
	public boolean isAggregatePrecommitListener() {
		return false;
	}

	@Override
	public boolean isPrecommitOnly() {
		return false;
	}

	@Override
	public boolean isPostcommitOnly() {
		return false;
	}

	protected void bind(final EStructuralFeature a, final Text text) {
		final EObject be = this.getBusinessObject();
		Object eGet = be.eGet(a);
		if (eGet != null) {
			text.setText(eGet.toString());
		}

		IObservableValue textObserver = WidgetProperties.text(SWT.Modify).observe(text);
		textObserver.addValueChangeListener(new IValueChangeListener() {

			@Override
			public void handleValueChange(final ValueChangeEvent e) {
				if (!text.getText().equals(be.eGet(a))) {
					TransactionalEditingDomain editingDomain = ((BPMN2Editor) getDiagramEditor()).getEditingDomain();
					editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
						@Override
						protected void doExecute() {
							// System.out.println("ui value is: " +
							// e.diff.getNewValue());
							be.eSet(a, e.diff.getNewValue());
						}
					});
					if (((BPMN2Editor) getDiagramEditor()).getDiagnostics() != null) {
						// revert the change and display error status message.
						text.setText((String) be.eGet(a));
						// bpmn2Editor.showErrorMessage(bpmn2Editor.getDiagnostics().getMessage());
					}

				}
			}
		});

		IObservableValue startEventNameObserveValue = EMFObservables.observeValue(be, a);
		startEventNameObserveValue.addValueChangeListener(new IValueChangeListener() {

			@Override
			public void handleValueChange(ValueChangeEvent event) {
				// System.out.println("model value is: " + (String) be.eGet(a));
				if (!(text.getText().equals((String) be.eGet(a))))
					text.setText((String) be.eGet(a));
				text.setSelection(text.getText().length());
			}
		});
	}

	protected void bind(final EStructuralFeature a, final Combo combo) {
		final EObject be = this.getBusinessObject();
		Object eGet = be.eGet(a);
		if (eGet != null) {
			combo.setText(eGet.toString());
		}

		IObservableValue textObserver = WidgetProperties.text(SWT.Modify).observe(combo);
		textObserver.addValueChangeListener(new IValueChangeListener() {

			@Override
			public void handleValueChange(final ValueChangeEvent e) {
				if (!combo.getText().equals(be.eGet(a))) {
					TransactionalEditingDomain editingDomain = ((BPMN2Editor) getDiagramEditor()).getEditingDomain();
					editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
						@Override
						protected void doExecute() {
							// System.out.println("ui value is: " +
							// e.diff.getNewValue());
							be.eSet(a, e.diff.getNewValue());
						}
					});
					if (((BPMN2Editor) getDiagramEditor()).getDiagnostics() != null) {
						// revert the change and display error status message.
						combo.setText((String) be.eGet(a));
						// bpmn2Editor.showErrorMessage(bpmn2Editor.getDiagnostics().getMessage());
					}

				}
			}
		});

		IObservableValue startEventNameObserveValue = EMFObservables.observeValue(be, a);
		startEventNameObserveValue.addValueChangeListener(new IValueChangeListener() {

			@Override
			public void handleValueChange(ValueChangeEvent event) {
				// System.out.println("model value is: " + (String) be.eGet(a));
				if (!(combo.getText().equals((String) be.eGet(a))))
					combo.setText((String) be.eGet(a));
			}
		});
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
				TransactionalEditingDomain editingDomain = ((BPMN2Editor) getDiagramEditor()).getEditingDomain();
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

		IObservableValue startEventNameObserveValue = EMFObservables.observeValue(be, a);
		startEventNameObserveValue.addValueChangeListener(new IValueChangeListener() {

			@Override
			public void handleValueChange(ValueChangeEvent event) {
				// System.out.println("model value is: " + (String) be.eGet(a));
				List<Documentation> documentationList = baseElement.getDocumentation();
				if (!text.getText().equals(documentationList.get(0).getText())) {

					text.setText(documentationList.get(0).getText());
				}
			}
		});
	}
}
