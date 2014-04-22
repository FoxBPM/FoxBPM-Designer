package org.foxbpm.bpmn.designer.core.runtime;

import org.eclipse.bpmn2.modeler.core.Bpmn2TabbedPropertySheetPage;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

public abstract class AbstractFoxBPMComposite extends Composite {
	private EObject businessObject;
	private DiagramEditor diagramEditor;

	public AbstractFoxBPMComposite(Composite parent, int style) {
		super(parent, style);
	}
	
	public abstract void createUIBindings(EObject eObject);

	public void refresh() {/*

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
		});*/
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
	
}
