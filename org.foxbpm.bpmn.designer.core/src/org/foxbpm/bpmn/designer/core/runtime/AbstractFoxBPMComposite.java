package org.foxbpm.bpmn.designer.core.runtime;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpmn2.modeler.core.Bpmn2TabbedPropertySheetPage;
import org.eclipse.bpmn2.modeler.core.merrimac.IConstants;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.ListAndDetailCompositeBase;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.bpmn2.modeler.ui.editor.BPMN2Editor;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.IValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

public abstract class AbstractFoxBPMComposite extends Composite implements ResourceSetListener, Adapter{
	protected EObject businessObject;
	protected DiagramEditor diagramEditor;
	protected AbstractFoxBPMPropertySection propertySection;
	protected FormToolkit formToolkit;
	private Text text_1;

	public AbstractFoxBPMComposite(Composite parent, int style) {
		super(parent, style);
		formToolkit = new FormToolkit(Display.getDefault());
		formToolkit.adapt(this);
		setLayout(new GridLayout(1, false));
		setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1));
		
		//描述section
		Section sctnNewSection = formToolkit.createSection(this, Section.EXPANDED | Section.TWISTIE | Section.TITLE_BAR);
		sctnNewSection.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1));
		
		Composite composite = new Composite(sctnNewSection, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		text_1 = new Text(composite, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		GridData gd_text_1 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text_1.heightHint = 50;
		text_1.setLayoutData(gd_text_1);
		formToolkit.adapt(text_1, true, true);
		sctnNewSection.setClient(composite);
		sctnNewSection.setText("描述");
		
		//详细属性页section
		Section detailSection = formToolkit.createSection(this, Section.TITLE_BAR);
		detailSection.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1));
		detailSection.setClient(createUI(detailSection));
		//设置标题
		detailSection.setText(setSectionTitle());
		
		formToolkit.paintBordersFor(sctnNewSection);
	}
	
	public abstract String setSectionTitle();
	public abstract Composite createUI(Composite parent);
	public abstract void createUIBindings(EObject eObject);

	public void refresh() {

		Display.getDefault().asyncExec( new Runnable() {
			public void run() {
				List<Control>kids = new ArrayList<Control>();
				Composite parent = AbstractFoxBPMComposite.this;
				try {
					AbstractFoxBPMPropertySection section = AbstractFoxBPMComposite.this.getPropertySection();
					if (section!=null && section.getTabbedPropertySheetPage()!=null) {
						parent = (Composite)section.getTabbedPropertySheetPage().getControl();
					}
				}
				catch (Exception e) {
				}
				// Send a notification to all listeners about this refresh event.
				// This will cause all children to be refreshed when a property tab switch happens.
				Notification n = new ENotificationImpl(null, -1, -1, 0, 0);
				getAllChildWidgets(parent, kids);
				for (Control c : kids) {
					INotifyChangedListener listener = (INotifyChangedListener)c.getData(
							IConstants.NOTIFY_CHANGE_LISTENER_KEY);
					if (listener!=null) {
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
		this.businessObject = businessObject;
		if (businessObject != null) {
			createUIBindings(businessObject);
		}
	}

	protected void cleanBindings() {
		ModelUtil.disposeChildWidgets(this);
	}
	
	public DiagramEditor getDiagramEditor() {

		if (diagramEditor!=null)
			return diagramEditor;
//		if (getPropertySection()!=null)
//			return (DiagramEditor)getPropertySection().getDiagramEditor();
//		Composite parent = getParent();
//		while (parent!=null && !(parent instanceof ListAndDetailCompositeBase))
//			parent = parent.getParent();
//		if (parent instanceof ListAndDetailCompositeBase)
//			return diagramEditor = ((ListAndDetailCompositeBase)parent).getDiagramEditor();
		
		IWorkbenchPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
		if (part instanceof DiagramEditor)
			diagramEditor = (DiagramEditor)part;
		else if (part instanceof IEditorPart) {
			diagramEditor = (DiagramEditor) ((IEditorPart)part).getAdapter(DiagramEditor.class);
		}
		else if (part instanceof PropertySheet) {
			TabbedPropertySheetPage page = (TabbedPropertySheetPage) ((PropertySheet)part).getCurrentPage();
			if (page instanceof Bpmn2TabbedPropertySheetPage) {
				diagramEditor = ((Bpmn2TabbedPropertySheetPage)page).getDiagramEditor();
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
		// the editor needs to return a "do nothing" filter while a save is in progress
		if (diagramEditor!=null)
			filter = (NotificationFilter)diagramEditor.getAdapter(NotificationFilter.class);
		if (filter==null) {
			filter = NotificationFilter.NOT_TOUCH;
		}
		return filter;
	}

	@Override
	public Command transactionAboutToCommit(ResourceSetChangeEvent event) throws RollbackException {
		return null;
	}

	protected void getAllChildWidgets(Composite parent, List<Control>kids) {
		if (parent!=null && !parent.isDisposed()) {
			Control[] cs = parent.getChildren();
			for (Control c : cs) {
				if (c instanceof Composite) {
					getAllChildWidgets((Composite)c,kids);
				}
				if (!c.isDisposed() &&
					c.getData(IConstants.NOTIFY_CHANGE_LISTENER_KEY) instanceof INotifyChangedListener) {
						kids.add(c);
				}
			}
		}
	}
	
	@Override
	public void resourceSetChanged(ResourceSetChangeEvent event) {

		final List<Notification> notifications = new ArrayList<Notification>();
		List<Notification> eventNotifications = event.getNotifications();
		for (int i=eventNotifications.size()-1; i>=0; --i) {
			Notification n = eventNotifications.get(i);
			if (getFilter().matches(n)) {
				boolean add = true;
				if (n.getFeature() instanceof EStructuralFeature) {
					EStructuralFeature f = (EStructuralFeature)n.getFeature();
					EClass ec = f.getEContainingClass();
					// Attempt to reduce the number of notifications to process:
					// notifications for the XMLTypePackage are inconsequential
					if (ec.getEPackage()==XMLTypePackage.eINSTANCE)
						add = false;
				}
				for (Notification n2 : notifications) {
					if (n2.getNotifier()==n.getNotifier() && n2.getFeature()==n.getFeature()) {
						add = false;
						break;
					}
				}
				if (add)
				{
					notifications.add(n);
				}
			}
		}
//		System.out.println("resource changed: "+this.getClass().getSimpleName()+" "+notifications.size()+" notifications");		
		// run this in the UI thread
		Display.getDefault().asyncExec( new Runnable() {
			public void run() {
				List<Control>kids = new ArrayList<Control>();
				Composite parent = AbstractFoxBPMComposite.this;
				try {
					AbstractFoxBPMPropertySection section = AbstractFoxBPMComposite.this.getPropertySection();
					if (section!=null && section.getTabbedPropertySheetPage()!=null) {
						parent = (Composite)section.getTabbedPropertySheetPage().getControl();
					}
				}
				catch (Exception e) {
					return;
				}

				boolean firstTime = true;
				for (Notification n : notifications) {
					if (getFilter().matches(n)) {
						if (n.getFeature() instanceof EStructuralFeature) {
//							EStructuralFeature f = (EStructuralFeature)n.getFeature();
//							EClass ec = (EClass)f.eContainer();
//							String et;
//							switch (n.getEventType()){
//							case Notification.SET: et = "SET"; break;
//							case Notification.UNSET: et = "UNSET"; break;
//							case Notification.ADD: et = "ADD"; break;
//							case Notification.ADD_MANY: et = "ADD_MANY"; break;
//							case Notification.REMOVE: et = "REMOVE"; break;
//							case Notification.REMOVE_MANY: et = "REMOVE_MANY"; break;
//							default: et = "UNKNOWN";
//							}
//							System.out.println("sending notification: "+
//									ec.getEPackage().getName()+":"+ec.getName()+"."+f.getName()+"   "+et+" old="+n.getOldStringValue()+" new="+n.getNewStringValue());
							if (firstTime) {
								getAllChildWidgets(parent, kids);
								firstTime = false;
							}
							for (Control c : kids) {
								if (!c.isDisposed() && c.isVisible()) {
									INotifyChangedListener listener = (INotifyChangedListener)c.getData(
											IConstants.NOTIFY_CHANGE_LISTENER_KEY);
									if (listener!=null) {
//										System.out.println("    "+listener.getClass().getSimpleName());
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
		if (propertySection!=null)
			return propertySection;
		Composite parent = getParent();
		while (parent!=null && !(parent instanceof ListAndDetailCompositeBase))
			parent = parent.getParent();
		if (parent instanceof ListAndDetailCompositeBase)
			return ((AbstractFoxBPMComposite)parent).getPropertySection();
		return null;
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

		IObservableValue textObserver = SWTObservables.observeText(text, SWT.Modify);
		textObserver.addValueChangeListener(new IValueChangeListener() {

			@Override
			public void handleValueChange(final ValueChangeEvent e) {
				// 为了美观添加长度验证 2012-07-06 wy
				/*
				 * if(text.getText().length()>20 && !(be instanceof
				 * TextAnnotation)) { MessageDialog.openInformation(getShell(),
				 * "提示", "名称长度不能超过20个字符");
				 * text.setText(e.diff.getOldValue().toString()); return; }
				 */

				if (!text.getText().equals(be.eGet(a))) {
					TransactionalEditingDomain editingDomain = ((BPMN2Editor) getDiagramEditor()).getEditingDomain();
					editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
						@Override
						protected void doExecute() {
						
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

	}
}
