package org.foxbpm.bpmn.designer.ui.propertytab.usertask;

import org.eclipse.bpmn2.UserTask;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMComposite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.swt.layout.FillLayout;

public class UserTaskTaskCommandComposite extends AbstractFoxBPMComposite {
	private UserTask userTask;
	private Tree tree;
	private TreeViewer treeViewer;
	private Button editButton;
	private Button removeButton;
	private Button upButton;
	private Button downButton;

	public UserTaskTaskCommandComposite(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public String setDescId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Composite createUI(Composite parent) {
		Composite detailComposite=new Composite(parent, SWT.NONE);
		detailComposite.setLayout(new GridLayout(2, false));
		detailComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		
		PatternFilter filter=new PatternFilter();
		FilteredTree filteredTree=new FilteredTree(detailComposite, SWT.SINGLE|SWT.H_SCROLL|SWT.V_SCROLL|SWT.BORDER, filter,true);
		treeViewer=filteredTree.getViewer();
		tree=treeViewer.getTree();
		
		Composite buttonComposite=new Composite(detailComposite, SWT.NONE);
		buttonComposite.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		buttonComposite.setLayout(new GridLayout(1, false));
		Button addButton=new Button(buttonComposite, SWT.PUSH);
		addButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		addButton.setText("创建...");
		editButton=new Button(buttonComposite, SWT.PUSH);
		editButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		editButton.setText("编辑...");
		removeButton=new Button(buttonComposite, SWT.PUSH);
		removeButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		removeButton.setText("移除");
		upButton=new Button(buttonComposite, SWT.PUSH);
		upButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		upButton.setText("向上");
		downButton=new Button(buttonComposite, SWT.PUSH);
		downButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		downButton.setText("向下");
		
		return parent;
	}

	@Override
	public void createUIBindings(EObject eObject) {
		userTask=(UserTask)eObject;

	}

}
