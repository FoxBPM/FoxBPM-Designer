package org.foxbpm.bpmn.designer.ui.expdialog;

import org.codehaus.groovy.eclipse.editor.GroovyEditor;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.preference.IPreferenceStore;

public class FoxBPMGroovyEditor extends GroovyEditor {
	public FoxBPMGroovyEditor(IPreferenceStore store){
		setPreferenceStore(store);
	}

	public void editorContextMenuAboutToShow(IMenuManager menu) {
		menu.dispose() ;
	}

	@Override
	protected void createUndoRedoActions() {

	}
}
