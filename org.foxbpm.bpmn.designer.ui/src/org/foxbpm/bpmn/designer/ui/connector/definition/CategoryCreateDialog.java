package org.foxbpm.bpmn.designer.ui.connector.definition;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.foxbpm.bpmn.designer.ui.tree.EntityElement;
import org.foxbpm.bpmn.designer.ui.tree.ITreeElement;
import org.foxbpm.bpmn.designer.ui.utils.DefinitionConnectorUtil;
import org.foxbpm.model.config.connectormenu.Node;
import org.foxbpm.model.config.foxbpmconfig.ResourcePath;

public class CategoryCreateDialog extends TitleAreaDialog {

	private Text textname;
	private Button buttonicon;
	private Button btnIsCreateRoot;
	private ITreeElement selTreeElement;
	private List<ITreeElement> treeElements;
	private String iconpath;
	private String categoryName;
	private String pareCategoryName = "";
	private FileInputStream is;
	private List<Node> nodelist;
	private Button button;
	private ITreeElement pareElement = null;
	private Text textPareCategory;
	private boolean isCreateRoot;
	private String type;
	private ResourcePath resourcePath;
	
	public ITreeElement getSelTreeElement() {
		return selTreeElement;
	}

	public List<ITreeElement> getTreeElements() {
		return treeElements;
	}

	private static class ViewerLabelProvider extends LabelProvider {
		public Image getImage(Object element) {
			return super.getImage(element);
		}

		public String getText(Object element) {
			Node treeElement = (Node) element;
			return treeElement.getName();
		}
	}

	private static class ContentProvider implements IStructuredContentProvider {
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof List) {
				@SuppressWarnings("rawtypes")
				List list = (List) inputElement;
				return list.toArray();
			} else {
				return new Object[0];
			}
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 * @wbp.parser.constructor
	 */
	public CategoryCreateDialog(Shell parentShell) {
		super(parentShell);
		setHelpAvailable(false);
	}
	
	public CategoryCreateDialog(Shell parentShell,ITreeElement selElement,List<ITreeElement> lists, String type, ResourcePath resourcePath) {
		super(parentShell);
		setHelpAvailable(false);
		this.pareElement = selElement;
		this.treeElements = lists;
		this.type = type;
		this.resourcePath = resourcePath;
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setMessage("用于创建新的分类以及子分类");
		setTitle("创建分类");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new FormLayout());
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		Composite composite = new Composite(container, SWT.NONE);
		GridLayout gl_composite = new GridLayout(2, false);
		gl_composite.marginHeight = 10;
		composite.setLayout(gl_composite);
		FormData fd_composite = new FormData();
		fd_composite.top = new FormAttachment(0, 10);
		fd_composite.left = new FormAttachment(0, 10);
		fd_composite.right = new FormAttachment(100, -10);
		fd_composite.bottom = new FormAttachment(0, 149);
		composite.setLayoutData(fd_composite);

		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_1.setText("名称");

		textname = new Text(composite, SWT.BORDER);
		textname.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (isPageComplete()) {
					CategoryCreateDialog.this.categoryName = textname.getText();
					button.setEnabled(true);
				} else
					button.setEnabled(false);
			}
		});
		textname.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		lblNewLabel_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_2.setText("所属分类");

		textPareCategory = new Text(composite, SWT.BORDER | SWT.READ_ONLY);
		textPareCategory.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		
		
		Label lblNewLabel_3 = new Label(composite, SWT.NONE);
		lblNewLabel_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_3.setText("图标");

		buttonicon = new Button(composite, SWT.NONE);
		GridData gd_buttonicon = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_buttonicon.widthHint = 43;
		buttonicon.setLayoutData(gd_buttonicon);
		buttonicon.setText("...");
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		
		btnIsCreateRoot = new Button(composite, SWT.CHECK);
		btnIsCreateRoot.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				isCreateRoot = btnIsCreateRoot.getSelection();
				if (isCreateRoot)
					textPareCategory.setText("");
				else
					textPareCategory.setText(pareElement.getName());
			}
		});
		GridData gd_btnIsCreateRoot = new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1);
		gd_btnIsCreateRoot.heightHint = 30;
		btnIsCreateRoot.setLayoutData(gd_btnIsCreateRoot);
		btnIsCreateRoot.setText("是否作为根节点创建分类");
		
		if(type!=null && type.equals("connector")) {
			iconpath = DefinitionConnectorUtil.getDefaultFlowConnectorIcoPath(resourcePath);
		}
		else if(type!=null && type.equals("actor")) {
			iconpath = DefinitionConnectorUtil.getDefaultActorConnectorIcoPath(resourcePath);
		}
		if (new File(iconpath).exists()) {
			try {
				is = new FileInputStream(iconpath);
				if (buttonicon.getImage() != null && !buttonicon.getImage().isDisposed()) {
					buttonicon.getImage().dispose();
				}
				buttonicon.setText("");
				buttonicon.setImage(new Image(PlatformUI.getWorkbench().getDisplay(), new ImageData(is).scaledTo(16, 16)));
				is.close();
			} catch (Exception ex) {
				buttonicon.setImage(null);
				buttonicon.setText("...");
			}
		}
		buttonicon.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				FileDialog dialog = new FileDialog(getShell(), SWT.OPEN | SWT.SINGLE);
				dialog.setFilterExtensions(new String[] { "*.jpg;*.jpeg;*.gif;*.png;*.bmp;*.ico" });
				dialog.setFilterPath(System.getProperty("user.home"));
				String res = dialog.open();
				if (res != null) {
					CategoryCreateDialog.this.iconpath = res;
					try {
						buttonicon.setText("");
						is = new FileInputStream(res);
						if (buttonicon.getImage() != null && !buttonicon.getImage().isDisposed()) {
							buttonicon.getImage().dispose();
						}
						buttonicon.setImage(new Image(PlatformUI.getWorkbench().getDisplay(), new ImageData(is).scaledTo(16, 16)));
						is.close();
					} catch (Exception ex) {
						buttonicon.setImage(null);
						buttonicon.setText("...");
					}
				}
			}
		});
		
		if (this.pareElement != null) {
			textPareCategory.setText(pareElement.getName());
			isCreateRoot = false;
		}
		else {
			textPareCategory.setText("");
			btnIsCreateRoot.setSelection(true);
			isCreateRoot = true;
		}

		isPageComplete();
		return area;
	}

	/**
	 * 判断页面填写是否完整
	 * 
	 * @return
	 */
	public boolean isPageComplete() {

		StringBuffer sb = new StringBuffer();
		if (textname.getText() == null || textname.getText().equals(""))
			sb.append("分类名称为空");
		// 需要对这个名称核对唯一性
//		for (Node node : nodelist) {
//			if (node.getName().equals(textname.getText())) {
//				sb.append("分类" + textname.getText() + "已经存在，请重新输入名称。");
//			}
//		}
		if (sb.length() > 0) {
			CategoryCreateDialog.this.setErrorMessage(sb.toString());
			return false;
		} else {
			CategoryCreateDialog.this.setErrorMessage(null);
			return true;
		}

	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		button = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		button.setEnabled(isPageComplete());
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (isCreateRoot) {
					selTreeElement = new EntityElement(null, java.util.UUID.randomUUID().toString(), categoryName, iconpath, "");
					treeElements.add(selTreeElement);
				}
				else {
					selTreeElement = new EntityElement(pareElement, java.util.UUID.randomUUID().toString(), categoryName, iconpath, "");
					pareElement.addChild(selTreeElement);
				}
				// 按OK之后的事件，应该赋值到全局变量selTreeElement里面供主界面所用
				// Node node = ConnectormenuFactory.eINSTANCE.createNode();
				// node.setName(categoryName);
				// if(!nodelist.contains(node))
				// nodelist.add(node);
				// 先根据父类节点名得到对应node，然后再根据node得到对应treeElement
//				getTreeElementByName(treeElements, pareCategoryName);
				// for (ITreeElement iTreeElement : treeElements) {
				// if (iTreeElement.getName().equals(pareCategoryName)) {
				// pareElement = iTreeElement;
				// }
				// else{
				// pareElement =
				// getTreeElementByName(iTreeElement.getChildren(),pareCategoryName);
				// }
				// if (pareElement!=null) {
				// break;
				// }
				// }
			}
		});
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(305, 315);
	}

	/**
	 * 递归用于得到所有树节点下面所有子节点
	 */
	protected void getTreeElementByName(List<ITreeElement> lists, String selname) {
		if (lists != null && lists.size() > 0) {
			for (ITreeElement iTreeElement : lists) {
				if (iTreeElement.getName().equals(selname)) {
					pareElement = iTreeElement;
					break;
				} else {
					getTreeElementByName(iTreeElement.getChildren(), selname);
				}
			}
		}
	}
}
