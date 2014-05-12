package org.foxbpm.bpmn.designer.ui.propertytab.connector;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMComposite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;

public class ConnectorPropertyComposite extends AbstractFoxBPMComposite{
	private Tree tree;
	private TreeViewer treeViewer;

	public ConnectorPropertyComposite(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public void createUIBindings(EObject eObject) {
		
	}

	@Override
	public Composite createUI(Composite parent) {
		GridLayout gridLayout = (GridLayout) parent.getLayout();
		gridLayout.numColumns = 1;
		Composite detailComposite = new Composite(parent, SWT.NONE);
		detailComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		detailComposite.setLayout(new GridLayout(1, false));
		
		PatternFilter filter = new PatternFilter();
		
		Composite composite = new Composite(detailComposite, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		FilteredTree filteredTree = new FilteredTree(composite, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER, filter, true);
		treeViewer = filteredTree.getViewer();
		tree = treeViewer.getTree();
		
		Composite buttonsComposite = new Composite(composite, SWT.NONE);
		buttonsComposite.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		buttonsComposite.setSize(45, 139);
		GridLayout gl_buttonsComposite = new GridLayout(1, false);
		gl_buttonsComposite.verticalSpacing = 1;
		gl_buttonsComposite.marginWidth = 0;
		gl_buttonsComposite.marginHeight = 0;
		gl_buttonsComposite.horizontalSpacing = 0;
		buttonsComposite.setLayout(gl_buttonsComposite);
		
		Button addButton = new Button(buttonsComposite, SWT.NONE);
		GridData gd_addButton = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_addButton.widthHint = 80;
		addButton.setLayoutData(gd_addButton);
		addButton.setText("添加...");
		
		Button editButton = new Button(buttonsComposite, SWT.NONE);
		editButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		editButton.setText("编辑...");
		
		Button removeButton = new Button(buttonsComposite, SWT.NONE);
		removeButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		removeButton.setText("删除");
		
		Button upButton = new Button(buttonsComposite, SWT.NONE);
		upButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		upButton.setText("向上");
		
		Button downButton = new Button(buttonsComposite, SWT.NONE);
		downButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		downButton.setText("向下");
		
		return parent;
	}

	@Override
	public String setDescId() {
		return "";
	}
}
