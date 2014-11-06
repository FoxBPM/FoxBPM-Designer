package org.foxbpm.bpmn.designer.ui.connector.definition;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.internal.resources.Project;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.jdt.ui.wizards.NewTypeWizardPage;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.foxbpm.bpmn.designer.base.utils.EMFUtil;
import org.foxbpm.bpmn.designer.base.utils.FileUtil;
import org.foxbpm.bpmn.designer.base.utils.FoxBPMDesignerUtil;
import org.foxbpm.bpmn.designer.ui.dialogs.ProjectContentProvider;
import org.foxbpm.bpmn.designer.ui.dialogs.TreeSelectionDialog;
import org.foxbpm.bpmn.designer.ui.tree.DefinitionTreeViewerFactory;
import org.foxbpm.bpmn.designer.ui.tree.ITreeElement;
import org.foxbpm.bpmn.designer.ui.tree.TreeViewerContentProvider;
import org.foxbpm.bpmn.designer.ui.tree.TreeViewerLabelProvider;
import org.foxbpm.bpmn.designer.ui.utils.DefinitionConnectorUtil;
import org.foxbpm.model.config.connector.ConnectorDefinition;
import org.foxbpm.model.config.connector.ConnectorFactory;
import org.foxbpm.model.config.connector.ConnectorPackage.Literals;
import org.foxbpm.model.config.connector.DefinitionImpl;
import org.foxbpm.model.config.connector.Input;
import org.foxbpm.model.config.connector.Output;
import org.foxbpm.model.config.connector.Page;
import org.foxbpm.model.config.connectormenu.ConnectormenuFactory;
import org.foxbpm.model.config.connectormenu.Menu;
import org.foxbpm.model.config.connectormenu.Node;
import org.foxbpm.model.config.foxbpmconfig.ResourcePath;

public class ConfigureNewConnectorWizardPage extends NewTypeWizardPage {
	private DataBindingContext m_bindingContext;
	private Text connectorclassnametext;
	private Text connectorpackagenametext;
	private Table pagetable;
	private Table outputtable;
	private TableViewer pagetableViewer;
	private TableViewer outputtableViewer;
	private Text connectoridtext;
	private Text connectornametext;
	private Text connectordesctext;
	private Button connectoriconButton;
	private String iconPath;
	private String customCategoryIconPath;
	private Composite composite;
	private Button inputcreateButton;
	private Button inputupButton;
	private Button inputdownButton;
	private Button inputdeleteButton;
	private Button pagecreateButton;
	private Button pageeditButton;
	private Button pageupButton;
	private Button pagedownButton;
	private Button pagedeleteButton;
	private Button outputcreateButton;
	private Button outputupButton;
	private Button outputdownButton;
	private Button outputdeleteButton;
	private String openType;
	private FileInputStream is;
	private Table table;
	private TableViewer tableViewer;
	private Tree categorytree;
	private TreeViewer categorytreeViewer;
	private List<String> newCreateCategoryID;
	private List<Page> pages;
	private ConnectorDefinition connectorDefinition;
	private Node node;
	private Menu menu;
	private Composite categoryComposite;
	private Button createCateButton;
	private List<Node> nodelist;
	private List<ITreeElement> categorytreeElements;
	private static String CONNECTORDEFAULTICON = "category.png";
	private String packageName;
	private String connectorMenuPath;

	/**
	 * 构造函数
	 * 
	 * @param isClass
	 * @param pageName
	 * @wbp.parser.constructor
	 */
	public ConfigureNewConnectorWizardPage(boolean isClass, String pageName, String packageName, boolean isDefault) {
		super(isClass, pageName);
		setDescription("设置连接器的描述信息");
		setTitle(pageName);

		// 初始化model
		connectorDefinition = ConnectorFactory.eINSTANCE.createConnectorDefinition();
		DefinitionImpl definitionImpl = ConnectorFactory.eINSTANCE.createDefinitionImpl();
		connectorDefinition.setDefinitionImpl(definitionImpl);
		ConnectormenuFactory menufactory = ConnectormenuFactory.eINSTANCE;
		node = menufactory.createNode();
		node.setName("");

		pages = new ArrayList<Page>();
		this.newCreateCategoryID = new ArrayList<String>();

		nodelist = new ArrayList<Node>();
		this.openType = "create";
		this.packageName = packageName;
		connectorMenuPath = DefinitionConnectorUtil.getConnectorMenuPath(isDefault);
		File file = new File(connectorMenuPath);
		if(file.exists()) {
			menu = DefinitionConnectorUtil.getConnectorMenu(connectorMenuPath);
		}else {
			MessageDialog.openWarning(null, "提示", "连接器菜单文件路径有误，请检查");
			return;
		}
	}

	/**
	 * 修改时构造函数
	 * 
	 * @param isClass
	 * @param pageName
	 * @param connector
	 */

	public ConfigureNewConnectorWizardPage(boolean isClass, String pageName, ConnectorDefinition connector, String packageName, boolean isDefault) {
		super(isClass, pageName);
		setDescription("设置连接器的描述信息");
		setTitle("编辑连接器");

		// 初始化model
		this.connectorDefinition = connector;
		this.newCreateCategoryID = new ArrayList<String>();
		connectorMenuPath = DefinitionConnectorUtil.getConnectorMenuPath(isDefault);
		menu = DefinitionConnectorUtil.getConnectorMenu(connectorMenuPath);
		nodelist = EMFUtil.getAll(menu.eResource(), Node.class);

		for (Node nd : nodelist) {
			if (nd.getId().equals(connector.getCategoryId())) {
				this.node = nd;
			}
		}

		this.openType = "edit";
		this.packageName = packageName;
	}

	@Override
	public void createControl(Composite parent) {
		Composite mainComposite = new Composite(parent, SWT.NONE);
		mainComposite.setLayout(new FillLayout(SWT.HORIZONTAL));

		composite = new Composite(mainComposite, SWT.NONE);
		GridLayout gl_composite = new GridLayout(4, false);
		gl_composite.marginRight = 10;
		gl_composite.marginHeight = 0;
		gl_composite.marginLeft = 10;
		composite.setLayout(gl_composite);

		Label connectoridLabel = new Label(composite, SWT.NONE);
		connectoridLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		connectoridLabel.setText("连接器ID");

		connectoridtext = new Text(composite, SWT.BORDER);
		connectoridtext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
		connectoridtext.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				connectorclassnametext.setText(connectoridtext.getText());
				connectorpackagenametext.setText(packageName + connectoridtext.getText());
				setPageComplete(isPageComplete());
			}
		});
		
		Label connectornameLabel = new Label(composite, SWT.NONE);
		connectornameLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		connectornameLabel.setText("名称");

		connectornametext = new Text(composite, SWT.BORDER);
		connectornametext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));

		connectornametext.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				setPageComplete(isPageComplete());
			}
		});

		Label connectordescLabel = new Label(composite, SWT.NONE);
		connectordescLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		connectordescLabel.setText("描述");

		connectordesctext = new Text(composite, SWT.BORDER);
		connectordesctext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));

		connectordesctext.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				setPageComplete(isPageComplete());
			}
		});

		Label connectorclassnameLabel = new Label(composite, SWT.NONE);
		connectorclassnameLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		connectorclassnameLabel.setText("类名");

		connectorclassnametext = new Text(composite, SWT.BORDER);
		connectorclassnametext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
		connectorclassnametext.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				setPageComplete(isPageComplete());
			}
		});
		
		Label connectorpackagenameLabel = new Label(composite, SWT.NONE);
		connectorpackagenameLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		connectorpackagenameLabel.setText("包名");

		connectorpackagenametext = new Text(composite, SWT.BORDER | SWT.READ_ONLY);
		connectorpackagenametext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
		connectorpackagenametext.setEnabled(false);
		
//		Button connectorpakageButton = new Button(composite, SWT.NONE);
//		connectorpakageButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
//		connectorpakageButton.setText("浏览");
//		connectorpakageButton.addListener(SWT.Selection, new Listener() {
//			public void handleEvent(Event event) {
//				packageName = null;
//				TreeSelectionDialog dlg = new TreeSelectionDialog(getShell(), ResourcesPlugin.getWorkspace().getRoot(), new ProjectContentProvider(), new WorkbenchLabelProvider(), "选择项目:");
//				dlg.setTitle("Project Selection");
//				if (dlg != null && dlg.open() == InputDialog.OK) {
//					String projectName = ((Project)dlg.getSelection()).getName();
//					for (ResourcePath resourcePath : FoxBPMDesignerUtil.getFoxBPMConfig().getResourcePathConfig().getResourcePath()) {
//						if(resourcePath.getProjectName().equals(projectName) && resourcePath.getType().equals("flowConnector")) {
//							packageName = resourcePath.getSrc().replace("/", ".");
//							ConfigureNewConnectorWizardPage.this.resourcePath = resourcePath;
//							break;
//						}
//					}
//					connectorpackagenametext.setText(packageName == null?"找不到项目对应的包名，请在配置文件中配置":packageName + connectoridtext.getText());
//				
//					((TreeViewerLabelProvider)categorytreeViewer.getLabelProvider()).setResourcePath(resourcePath);
//					categorytreeElements = (List<ITreeElement>) DefinitionTreeViewerFactory.reloadTreeNodes(resourcePath);
//					categorytreeViewer.setInput(categorytreeElements);
//					categorytreeViewer.refresh();
//					
//					connectorDefinition.setCategoryId(null);
//					
//					menu = DefinitionConnectorUtil.getFlowConnectorMenu(resourcePath);
//					nodelist = EMFUtil.getAll(menu.eResource(), Node.class);
//					
//					if(connectorDefinition.getCategoryId() == null) {
//						//默认选择分类树上第一个节点
//						for (ITreeElement treeElement : categorytreeElements) {
//							if (treeElement.getId().equals(nodelist.get(0).getId())) {
//								categorytreeViewer.setSelection(new StructuredSelection(treeElement));
//								break;
//							}
//						}
//					}
//					
//					createCateButton.setEnabled(true);
//				}
//				
//				setPageComplete(isPageComplete());
//			}
//		});

		Label connectoriconLabel = new Label(composite, SWT.NONE);
		connectoriconLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		connectoriconLabel.setText("图标");

		connectoriconButton = new Button(composite, SWT.NONE);
		GridData gd_connectoriconButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1);
		gd_connectoriconButton.widthHint = 43;
		connectoriconButton.setLayoutData(gd_connectoriconButton);
		connectoriconButton.setText("...");

		connectoriconButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				FileDialog dialog = new FileDialog(getShell(), SWT.OPEN | SWT.SINGLE);
				dialog.setFilterExtensions(new String[] { "*.jpg;*.jpeg;*.gif;*.png;*.bmp;*.ico" });
				dialog.setFilterPath(System.getProperty("user.home"));
				String res = dialog.open();
				if (res != null) {
					ConfigureNewConnectorWizardPage.this.iconPath = res;
					try {
						connectoriconButton.setText("");
						is = new FileInputStream(res);
						if (connectoriconButton.getImage() != null && !connectoriconButton.getImage().isDisposed()) {
							connectoriconButton.getImage().dispose();
						}
						connectoriconButton.setImage(new Image(PlatformUI.getWorkbench().getDisplay(), new ImageData(is).scaledTo(16, 16)));
						is.close();
					} catch (Exception ex) {
						connectoriconButton.setImage(null);
						connectoriconButton.setText("...");
					}
					// 这个连接器的图标名称需要改成和连接器ID一样的名字，由于这个里面可能还没有输入id所以改成到保存代码再修改
					 connectorDefinition.setIcon(new File(res).getName());
				}
			}
		});

		if (connectorDefinition.getIcon() != null) {
			try {
				connectoriconButton.setText("");
				is = new FileInputStream(DefinitionConnectorUtil.getActorConnectorIconPathByIconName(connectorDefinition.getId(), connectorDefinition.getIcon(), node.getId()));
				if (connectoriconButton.getImage() != null && !connectoriconButton.getImage().isDisposed()) {
					connectoriconButton.getImage().dispose();
				}
				connectoriconButton.setImage(new Image(PlatformUI.getWorkbench().getDisplay(), new ImageData(is).scaledTo(16, 16)));
				is.close();
			} catch (Exception ex) {
				connectoriconButton.setImage(null);
				connectoriconButton.setText("...");
			}
		} else {
			// 如果是创建就给connectoriconButton一个默认图标
			this.setIconPath(CONNECTORDEFAULTICON);
			connectorDefinition.setIcon(FileUtil.getFileName(iconPath));
			if (new File(this.getIconPath()).exists()) {
				try {
					is = new FileInputStream(this.getIconPath());
					if (connectoriconButton.getImage() != null && !connectoriconButton.getImage().isDisposed()) {
						connectoriconButton.getImage().dispose();
					}
					connectoriconButton.setText("");
					connectoriconButton.setImage(new Image(PlatformUI.getWorkbench().getDisplay(), new ImageData(is).scaledTo(16, 16)));
					is.close();
				} catch (Exception ex) {
					connectoriconButton.setImage(null);
					connectoriconButton.setText("...");
				}
			}
		}
		
		Label labelcategory = new Label(composite, SWT.NONE);
		labelcategory.setText("分类");

		// treeViewer获取数据
		categorytreeElements = new ArrayList<ITreeElement>();
		categorytreeViewer = new TreeViewer(composite, SWT.BORDER);
		categorytreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				ITreeElement treeElementselect = (ITreeElement) ((IStructuredSelection) categorytreeViewer.getSelection()).getFirstElement();
				if (treeElementselect != null && openType.equals("create")) {
					connectorDefinition.setCategoryId(treeElementselect.getId());
					node.setId(treeElementselect.getId());
					node.setName(treeElementselect.getName());
				}
				setPageComplete(isPageComplete());
			}
		});
		categorytree = categorytreeViewer.getTree();
		GridData gd_categorytree = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		gd_categorytree.heightHint = 55;
		categorytree.setLayoutData(gd_categorytree);

		categoryComposite = new Composite(composite, SWT.NONE);
		GridLayout gl_categoryComposite = new GridLayout(1, false);
		gl_categoryComposite.verticalSpacing = 1;
		gl_categoryComposite.marginWidth = 0;
		gl_categoryComposite.marginHeight = 0;
		gl_categoryComposite.horizontalSpacing = 0;
		categoryComposite.setLayout(gl_categoryComposite);

		createCateButton = new Button(categoryComposite, SWT.NONE);
		createCateButton.setText("创建");
//		createCateButton.setEnabled(false);
		createCateButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {

				// 这个里面弹出来新建分类的
				String selName = "";
				ITreeElement treeElementselect = (ITreeElement) ((IStructuredSelection) categorytreeViewer.getSelection()).getFirstElement();
				if (treeElementselect != null) {
					// selName = treeElementselect.getName();
					connectorDefinition.setCategoryId(treeElementselect.getId());
				}
				CategoryCreateDialog dialog = new CategoryCreateDialog(getShell(), treeElementselect, categorytreeElements, "connector", connectorMenuPath);
				if (dialog.open() == InputDialog.OK) {
					// 回填到界面上,新增一个树节点出来
					if (dialog.getSelTreeElement() != null) {
						Node node = ConnectormenuFactory.eINSTANCE.createNode();
						node.setId(dialog.getSelTreeElement().getId());
						node.setName(dialog.getSelTreeElement().getName());
						node.setIco(dialog.getSelTreeElement().getIcon());
						// 把新建的分类对应的ID记录保存起来，供保存menu时候去刷新图标
						newCreateCategoryID.add(dialog.getSelTreeElement().getId());
						if (!nodelist.contains(node)) {
							if (nodelist.size() > 0)
								nodelist.add(nodelist.size() - 1, node);
							else
								nodelist.add(node);
						}
						categorytreeElements = dialog.getTreeElements();
						// 选中刚才创建的分类
						categorytreeViewer.refresh();
						categorytreeViewer.expandToLevel(treeElementselect, 1);
						categorytreeViewer.setSelection(new StructuredSelection(dialog.getSelTreeElement()));
						// 这个里面还需要根据categorytreeElements对menu进行实时更改
						modifyMenuByTreeElement(ConfigureNewConnectorWizardPage.this.menu, dialog.getSelTreeElement());
					}
				}
			}
		});

		categorytreeElements = (List<ITreeElement>) DefinitionTreeViewerFactory.reloadTreeNodes(connectorMenuPath);
		
		// 设置标签提供器
		categorytreeViewer.setLabelProvider(new TreeViewerLabelProvider());
		((TreeViewerLabelProvider)categorytreeViewer.getLabelProvider()).setConnectorMenuPath(connectorMenuPath);
		// 设置内容提供器
		categorytreeViewer.setContentProvider(new TreeViewerContentProvider());
		// 设置内容
		categorytreeViewer.setInput(categorytreeElements);
		
		categorytreeViewer.refresh();
		
		connectorDefinition.setCategoryId(null);
		
		nodelist = EMFUtil.getAll(menu.eResource(), Node.class);
		
		if(connectorDefinition.getCategoryId() == null) {
			//默认选择分类树上第一个节点
			for (ITreeElement treeElement : categorytreeElements) {
				if (treeElement.getId().equals(nodelist.get(0).getId())) {
					categorytreeViewer.setSelection(new StructuredSelection(treeElement));
					break;
				}
			}
		}

		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setText("输入");

		tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				updateButtons();
			}
		});
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		GridData gd_table = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
		gd_table.heightHint = 62;
		table.setLayoutData(gd_table);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(88);
		tblclmnNewColumn.setText("输入ID");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_1 = tableViewerColumn_1.getColumn();
		tblclmnNewColumn_1.setWidth(88);
		tblclmnNewColumn_1.setText("强制");

		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_4 = tableViewerColumn_4.getColumn();
		tblclmnNewColumn_4.setWidth(88);
		tblclmnNewColumn_4.setText("执行");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_2 = tableViewerColumn_2.getColumn();
		tblclmnNewColumn_2.setWidth(88);
		tblclmnNewColumn_2.setText("类型");

		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_3 = tableViewerColumn_3.getColumn();
		tblclmnNewColumn_3.setWidth(88);
		tblclmnNewColumn_3.setText("默认值");

		tableViewer.setLabelProvider(new TableLabelProvider());
		tableViewer.setContentProvider(new ContentProvider_1());
		tableViewer.setInput(this.connectorDefinition.getInput());

		Composite inputcomposite = new Composite(composite, SWT.NONE);
		GridLayout gl_composite_1 = new GridLayout(1, false);
		gl_composite_1.verticalSpacing = 0;
		gl_composite_1.horizontalSpacing = 0;
		gl_composite_1.marginWidth = 0;
		gl_composite_1.marginHeight = 0;
		inputcomposite.setLayout(gl_composite_1);
		inputcomposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));

		inputcreateButton = new Button(inputcomposite, SWT.NONE);
		GridData gd_inputcreateButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_inputcreateButton.heightHint = 20;
		inputcreateButton.setLayoutData(gd_inputcreateButton);
		inputcreateButton.setText("创建");
		inputcreateButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				Input input = ConnectorFactory.eINSTANCE.createInput();
				input.setId("inputId" + ((List) tableViewer.getInput()).size());
				input.setMandatory("Mandatory");
				input.setIsExecute("true");
				input.setType("java.lang.String");
				input.setDefaultValue("");
				connectorDefinition.getInput().add(input);

				tableViewer.refresh();
				tableViewer.editElement(input, 0);
				setPageComplete(isPageComplete());
				updateButtons();

			}
		});

		inputupButton = new Button(inputcomposite, SWT.NONE);
		GridData gd_inputupButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_inputupButton.heightHint = 20;
		inputupButton.setLayoutData(gd_inputupButton);
		inputupButton.setText("向上");
		inputupButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				IStructuredSelection selection = (IStructuredSelection) tableViewer.getSelection();
				Input inputSel = (Input) selection.getFirstElement();
				int idx = ((List<Input>) tableViewer.getInput()).indexOf(inputSel);
				if (idx != 0) {
					((List<Input>) tableViewer.getInput()).remove(inputSel);
					((List<Input>) tableViewer.getInput()).add(idx - 1, inputSel);
				}
				tableViewer.refresh();
				if (selection != null)
					tableViewer.setSelection(selection);
				updateButtons();

			}
		});

		inputdownButton = new Button(inputcomposite, SWT.NONE);
		GridData gd_inputdownButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_inputdownButton.heightHint = 20;
		inputdownButton.setLayoutData(gd_inputdownButton);
		inputdownButton.setText("向下");
		inputdownButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				IStructuredSelection selection = (IStructuredSelection) tableViewer.getSelection();
				Input inputTo = (Input) selection.getFirstElement();
				int idx = ((List<Input>) tableViewer.getInput()).indexOf(inputTo);
				if (idx != ((List<Input>) tableViewer.getInput()).size() - 1) {
					((List<Input>) tableViewer.getInput()).remove(inputTo);
					((List<Input>) tableViewer.getInput()).add(idx + 1, inputTo);
				}
				tableViewer.refresh();
				if (selection != null)
					tableViewer.setSelection(selection);
				updateButtons();

			}
		});

		inputdeleteButton = new Button(inputcomposite, SWT.NONE);
		GridData gd_inputdeleteButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_inputdeleteButton.heightHint = 20;
		inputdeleteButton.setLayoutData(gd_inputdeleteButton);
		inputdeleteButton.setText("移除");
		inputdeleteButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection sel = tableViewer.getSelection();
				if (sel == null)
					return;
				Object[] objs = ((IStructuredSelection) sel).toArray();
				if (objs == null || objs.length == 0)
					return;
				boolean b = MessageDialog.openConfirm(null, "警告", "你确认要删除吗？");
				if (!b)
					return;

				for (int i = 0; i < objs.length; i++) {
					Input colInput = (Input) objs[i];
					connectorDefinition.getInput().remove(colInput);
				}
				tableViewer.refresh();
				setPageComplete(isPageComplete());
				updateButtons();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});

		Label connectorpageLabel = new Label(composite, SWT.NONE);
		connectorpageLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		connectorpageLabel.setText("页面");

		pagetableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		pagetableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				updateButtons();
			}
		});

		pagetable = pagetableViewer.getTable();
		pagetable.setLinesVisible(true);
		pagetable.setHeaderVisible(true);
		pagetable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));

		pagetable.addListener(SWT.MeasureItem, new Listener() {
			public void handleEvent(Event event) {
				// 设置行高度
				event.height = (int) Math.floor(event.gc.getFontMetrics().getHeight() * 1.5);
			}
		});

		TableViewerColumn idcolumn = new TableViewerColumn(pagetableViewer, SWT.NONE);
		idcolumn.getColumn().setWidth(88);
		idcolumn.getColumn().setText("页面ID");
		idcolumn.getColumn().setMoveable(true);
		idcolumn.setLabelProvider(new CellLabelProvider() {

			@Override
			public void update(ViewerCell cell) {
				cell.setText(((Page) cell.getElement()).getId());
			}
		});

		TableViewerColumn titlecolumn = new TableViewerColumn(pagetableViewer, SWT.NONE);
		titlecolumn.getColumn().setWidth(264);
		titlecolumn.getColumn().setText("页面标题");
		titlecolumn.getColumn().setMoveable(true);
		titlecolumn.setLabelProvider(new CellLabelProvider() {

			@Override
			public void update(ViewerCell cell) {
				// 这个里面先用getName试试，后面问了具体再改
				cell.setText(((Page) cell.getElement()).getName());
			}
		});

		TableViewerColumn numcolumn = new TableViewerColumn(pagetableViewer, SWT.NONE);
		numcolumn.getColumn().setWidth(88);
		numcolumn.getColumn().setText("输入的个数");
		numcolumn.getColumn().setMoveable(true);
		numcolumn.setLabelProvider(new CellLabelProvider() {

			@Override
			public void update(ViewerCell cell) {
				cell.setText(((Page) cell.getElement()).getWidget().size() + "");
			}
		});

		pagetableViewer.setContentProvider(new ArrayContentProvider());
		pagetableViewer.setInput(this.connectorDefinition.getPage());

		Composite pagecomposite = new Composite(composite, SWT.NONE);
		GridLayout gl_pagecomposite = new GridLayout(1, false);
		gl_pagecomposite.verticalSpacing = 0;
		gl_pagecomposite.horizontalSpacing = 0;
		gl_pagecomposite.marginWidth = 0;
		gl_pagecomposite.marginHeight = 0;
		pagecomposite.setLayout(gl_pagecomposite);
		pagecomposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		pagecreateButton = new Button(pagecomposite, SWT.NONE);
		GridData gd_pagecreateButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_pagecreateButton.heightHint = 20;
		pagecreateButton.setLayoutData(gd_pagecreateButton);
		pagecreateButton.setText("创建");
		pagecreateButton.addListener(SWT.Selection, new Listener() {
			@SuppressWarnings("unchecked")
			public void handleEvent(Event event) {
				CreateNewPageDialog cpd = new CreateNewPageDialog(getShell(), connectorDefinition);
				cpd.setBlockOnOpen(true);
				if (cpd != null && cpd.open() == InputDialog.OK) {
					connectorDefinition.getPage().add(cpd.getPage());
					((EList<Page>) pagetableViewer.getInput()).add(cpd.getPage());
					pagetableViewer.refresh();
					setPageComplete(isPageComplete());
					updateButtons();
				}

			}
		});

		pageeditButton = new Button(pagecomposite, SWT.NONE);
		GridData gd_pageeditButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_pageeditButton.heightHint = 20;
		pageeditButton.setLayoutData(gd_pageeditButton);
		pageeditButton.setEnabled(false);
		pageeditButton.setText("编辑");
		pageeditButton.addListener(SWT.Selection, new Listener() {

			@SuppressWarnings("unchecked")
			@Override
			public void handleEvent(Event event) {
				// 先注释了，改好了那个Dialog就放出来
				if (!pagetableViewer.getSelection().isEmpty()) {
					IStructuredSelection selection = (IStructuredSelection) pagetableViewer.getSelection();
					Page page = (Page) selection.getFirstElement();
					CreateNewPageDialog cpd = new CreateNewPageDialog(getShell(), page, connectorDefinition);
					cpd.setBlockOnOpen(true);
					if (cpd != null && cpd.open() == InputDialog.OK) {
						connectorDefinition.getPage().remove(page);
						connectorDefinition.getPage().add(cpd.getPage());
						int index = ((List<Page>) pagetableViewer.getInput()).indexOf(page);
						((List<Page>) pagetableViewer.getInput()).remove(page);
						((List<Page>) pagetableViewer.getInput()).add(index, cpd.getPage());
						pagetableViewer.refresh();
						setPageComplete(isPageComplete());
					}
				}

			}
		});

		pageupButton = new Button(pagecomposite, SWT.NONE);
		GridData gd_pageupButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_pageupButton.heightHint = 20;
		pageupButton.setLayoutData(gd_pageupButton);
		pageupButton.setText("向上");
		pageupButton.addListener(SWT.Selection, new Listener() {

			@SuppressWarnings("unchecked")
			@Override
			public void handleEvent(Event event) {
				IStructuredSelection selection = (IStructuredSelection) pagetableViewer.getSelection();
				Page page = (Page) selection.getFirstElement();
				int idx = ((List<Page>) pagetableViewer.getInput()).indexOf(page);
				if (idx != 0) {
					((List<Page>) pagetableViewer.getInput()).remove(page);
					((List<Page>) pagetableViewer.getInput()).add(idx - 1, page);
				}
				pagetableViewer.refresh();
				if (selection != null)
					pagetableViewer.setSelection(selection);
				updateButtons();

			}
		});

		pagedownButton = new Button(pagecomposite, SWT.NONE);
		GridData gd_pagedownButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_pagedownButton.heightHint = 20;
		pagedownButton.setLayoutData(gd_pagedownButton);
		pagedownButton.setText("向下");
		pagedownButton.addListener(SWT.Selection, new Listener() {

			@SuppressWarnings("unchecked")
			@Override
			public void handleEvent(Event event) {
				IStructuredSelection selection = (IStructuredSelection) pagetableViewer.getSelection();
				Page pageTo = (Page) selection.getFirstElement();
				int idx = ((List<Page>) pagetableViewer.getInput()).indexOf(pageTo);
				if (idx != ((List<Page>) pagetableViewer.getInput()).size() - 1) {
					((List<Page>) pagetableViewer.getInput()).remove(pageTo);
					((List<Page>) pagetableViewer.getInput()).add(idx + 1, pageTo);
				}
				pagetableViewer.refresh();
				if (selection != null)
					pagetableViewer.setSelection(selection);
				updateButtons();

			}
		});

		pagedeleteButton = new Button(pagecomposite, SWT.NONE);
		GridData gd_pagedeleteButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_pagedeleteButton.heightHint = 20;
		pagedeleteButton.setLayoutData(gd_pagedeleteButton);
		pagedeleteButton.setText("移除");
		pagedeleteButton.addListener(SWT.Selection, new Listener() {

			@SuppressWarnings("unchecked")
			@Override
			public void handleEvent(Event event) {
				ISelection sel = pagetableViewer.getSelection();
				if (sel == null)
					return;
				Object[] objs = ((IStructuredSelection) sel).toArray();
				if (objs == null || objs.length == 0)
					return;
				boolean b = MessageDialog.openConfirm(null, "警告", "你确认要删除吗？");
				if (!b)
					return;

				for (int i = 0; i < objs.length; i++) {
					Page col = (Page) objs[i];
					((List<Page>) pagetableViewer.getInput()).remove(col);
					connectorDefinition.getPage().remove(col);
				}
				pagetableViewer.refresh();
				setPageComplete(isPageComplete());
				updateButtons();

			}
		});

		Label connectoroutputLabel = new Label(composite, SWT.NONE);
		connectoroutputLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, true, 1, 1));
		connectoroutputLabel.setText("输出");

		outputtableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		outputtableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				updateButtons();
			}
		});

		outputtable = outputtableViewer.getTable();
		outputtable.setLinesVisible(true);
		outputtable.setHeaderVisible(true);
		outputtable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 2, 1));

		outputtable.addListener(SWT.MeasureItem, new Listener() {
			public void handleEvent(Event event) {
				// 设置行高度
				event.height = (int) Math.floor(event.gc.getFontMetrics().getHeight() * 1.5);
			}
		});

		TableColumn fieldcolumn = new TableColumn(outputtable, SWT.NONE);
		fieldcolumn.setWidth(88);
		fieldcolumn.setText("字段名");
		fieldcolumn.setMoveable(true);

		TableColumn displaycolumn = new TableColumn(outputtable, SWT.NONE);
		displaycolumn.setWidth(264);
		displaycolumn.setText("显示名");
		displaycolumn.setMoveable(true);

		TableColumn datatypecolumn = new TableColumn(outputtable, SWT.NONE);
		datatypecolumn.setWidth(88);
		datatypecolumn.setText("数据类型");
		datatypecolumn.setMoveable(true);

		Composite outputcomposite = new Composite(composite, SWT.NONE);
		GridLayout gl_outputcomposite = new GridLayout(1, false);
		gl_outputcomposite.verticalSpacing = 0;
		gl_outputcomposite.horizontalSpacing = 0;
		gl_outputcomposite.marginHeight = 0;
		gl_outputcomposite.marginWidth = 0;
		outputcomposite.setLayout(gl_outputcomposite);
		outputcomposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, true, 1, 1));

		outputcreateButton = new Button(outputcomposite, SWT.NONE);
		GridData gd_outputcreateButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_outputcreateButton.heightHint = 20;
		outputcreateButton.setLayoutData(gd_outputcreateButton);
		outputcreateButton.setText("创建");
		outputcreateButton.addListener(SWT.Selection, new Listener() {

			@SuppressWarnings("rawtypes")
			@Override
			public void handleEvent(Event event) {
				Output output = ConnectorFactory.eINSTANCE.createOutput();

				if (connectorDefinition.getOutput() == null) {
					connectorDefinition.getOutput().add(output);
				}

				output.setId("outputfield" + ((List) outputtableViewer.getInput()).size());
				output.setName("name" + ((List) outputtableViewer.getInput()).size());
				output.setType("java.lang.String");

				connectorDefinition.getOutput().add(output);

				outputtableViewer.refresh();
				outputtableViewer.editElement(output, 0);
				setPageComplete(isPageComplete());
				updateButtons();

			}
		});

		outputupButton = new Button(outputcomposite, SWT.NONE);
		GridData gd_outputupButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_outputupButton.heightHint = 20;
		outputupButton.setLayoutData(gd_outputupButton);
		outputupButton.setEnabled(false);
		outputupButton.setText("向上");
		outputupButton.addListener(SWT.Selection, new Listener() {

			@SuppressWarnings("unchecked")
			@Override
			public void handleEvent(Event event) {
				IStructuredSelection selection = (IStructuredSelection) outputtableViewer.getSelection();
				Output output = (Output) selection.getFirstElement();
				int idx = connectorDefinition.getOutput().indexOf(output);
				if (idx != 0) {
					connectorDefinition.getOutput().remove(output);
					connectorDefinition.getOutput().add(idx - 1, output);
				}
				outputtableViewer.refresh();
				if (selection != null)
					outputtableViewer.setSelection(selection);
				updateButtons();

			}
		});

		outputdownButton = new Button(outputcomposite, SWT.NONE);
		GridData gd_outputdownButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_outputdownButton.heightHint = 20;
		outputdownButton.setLayoutData(gd_outputdownButton);
		outputdownButton.setEnabled(false);
		outputdownButton.setText("向下");
		outputdownButton.addListener(SWT.Selection, new Listener() {

			@SuppressWarnings("unchecked")
			@Override
			public void handleEvent(Event event) {
				IStructuredSelection selection = (IStructuredSelection) outputtableViewer.getSelection();
				Output output = (Output) selection.getFirstElement();
				int idx = ((List<Output>) outputtableViewer.getInput()).indexOf(output);
				if (idx != ((List<Output>) outputtableViewer.getInput()).size() - 1) {
					((List<Output>) outputtableViewer.getInput()).remove(output);
					((List<Output>) outputtableViewer.getInput()).add(idx + 1, output);
				}
				outputtableViewer.refresh();
				if (selection != null)
					outputtableViewer.setSelection(selection);
				updateButtons();

			}
		});

		outputdeleteButton = new Button(outputcomposite, SWT.NONE);
		GridData gd_outputdeleteButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_outputdeleteButton.heightHint = 20;
		outputdeleteButton.setLayoutData(gd_outputdeleteButton);
		outputdeleteButton.setEnabled(false);
		outputdeleteButton.setText("移除");
		outputdeleteButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				ISelection sel = outputtableViewer.getSelection();
				if (sel == null)
					return;
				Object[] objs = ((IStructuredSelection) sel).toArray();
				if (objs == null || objs.length == 0)
					return;
				boolean b = MessageDialog.openConfirm(null, "警告", "你确认要删除吗？");
				if (!b)
					return;

				for (int i = 0; i < objs.length; i++) {
					Output col = (Output) objs[i];
					connectorDefinition.getOutput().remove(col);
				}
				outputtableViewer.refresh();
				setPageComplete(isPageComplete());
				updateButtons();

			}
		});

		// 如果是编辑时，不允许更改ID，防止保存时验证ID唯一时麻烦
		if (openType.equals("edit")) {
			connectoridtext.setEnabled(false);
			connectorclassnametext.setEnabled(false);
//			connectorpakageButton.setEnabled(false);
			categorytreeElements = (List<ITreeElement>) DefinitionTreeViewerFactory.reloadTreeNodes(connectorMenuPath);
			categorytreeViewer.setInput(categorytreeElements);
			categorytreeViewer.refresh();
			categorytreeViewer.getTree().setEnabled(false);
			
			menu = DefinitionConnectorUtil.getConnectorMenu(connectorMenuPath);
			nodelist = EMFUtil.getAll(menu.eResource(), Node.class);
		}

		createCellModifierInput();
		createCellModifierOutput();

		updateButtons();
		setControl(mainComposite);
		m_bindingContext = initDataBindings();
	}

	private void createCellModifierInput() {
		final CellEditor[] cellEditorInPut = new CellEditor[table.getColumnCount()];
		// ID,强制，类型，默认值
		cellEditorInPut[0] = new TextCellEditor(table);

		cellEditorInPut[1] = new ComboBoxViewerCellEditor(table, SWT.READ_ONLY);

		cellEditorInPut[2] = new ComboBoxViewerCellEditor(table, SWT.READ_ONLY);

		cellEditorInPut[3] = new ComboBoxViewerCellEditor(table, SWT.READ_ONLY);
		// ((ComboBoxViewerCellEditor)cellEditorInPut[3]).setInput(DataVarUtil.getFixFlowDataVariableConfig().getDataVariableDataType().getDataTypeDef());

		cellEditorInPut[4] = new TextCellEditor(table);
		((ComboBoxViewerCellEditor) cellEditorInPut[1]).setContenProvider(new ArrayContentProvider());
		((ComboBoxViewerCellEditor) cellEditorInPut[1]).setLabelProvider(new TableLabelProvider());
		((ComboBoxViewerCellEditor) cellEditorInPut[1]).setInput(new String[] { "是", "否" });
		((ComboBoxViewerCellEditor) cellEditorInPut[2]).setContenProvider(new ArrayContentProvider());
		((ComboBoxViewerCellEditor) cellEditorInPut[2]).setLabelProvider(new TableLabelProvider());
		((ComboBoxViewerCellEditor) cellEditorInPut[2]).setInput(new String[] { "是", "否" });
		((ComboBoxViewerCellEditor) cellEditorInPut[3]).setContenProvider(new ArrayContentProvider());
		((ComboBoxViewerCellEditor) cellEditorInPut[3]).setLabelProvider(new ViewerLabelProvider1());

		tableViewer.setColumnProperties(new String[] { "INPUTID", "INPUTMANDATORY", "ISEXCUTE", "INPUTTYPE", "INPUTDEFAULT" });
		tableViewer.setCellEditors(cellEditorInPut);
		tableViewer.setCellModifier(new ICellModifier() {

			@Override
			public void modify(Object element, String property, Object value) {
				TableItem tableitem = (TableItem) element;
				Input input = (Input) tableitem.getData();
				if (property.equals("INPUTID")) {
					input.setId((String) value);
				}
				if (property.equals("INPUTMANDATORY")) {
					if (((String) value).equals("是"))
						input.setMandatory("Mandatory");
					else if (((String) value).equals("否"))
						input.setMandatory("Optional");
				}
				if (property.equals("ISEXCUTE")) {
					if (((String) value).equals("是"))
						input.setIsExecute("true");
					else if (((String) value).equals("否")) {
						input.setIsExecute("false");

						((ComboBoxViewerCellEditor) cellEditorInPut[3]).setValue("java.lang.String");
						input.setType("java.lang.String");
					}
				}
				if (property.equals("INPUTTYPE")) {
					if (value == null) {
						input.setType("");
					} else {
						// input.setType(((DataTypeDef) value).getTypeValue());
						// if (!((DataTypeDef)
						// value).getTypeValue().equals("java.lang.String")) {
						// ((ComboBoxViewerCellEditor)
						// cellEditorInPut[2]).setValue("true");
						// input.setIsExecute("true");
						// }
					}
				}
				if (property.equals("INPUTDEFAULT")) {
					input.setDefaultValue((String) value);
				}
				setPageComplete(isPageComplete());
				tableViewer.refresh();

			}

			@Override
			public Object getValue(Object element, String property) {
				Input input = (Input) element;

				if (property.equals("INPUTID")) {
					return input.getId();
				}
				if (property.equals("INPUTMANDATORY")) {
					if (input.getMandatory().equals("Optional"))
						return "否";
					else
						return "是";
				}
				if (property.equals("ISEXCUTE")) {
					if (input.getIsExecute().equals("false"))
						return "否";
					else
						return "是";
				}
				if (property.equals("INPUTTYPE")) {
					// return
					// DataVarUtil.getDataTypeDefByDataVariableDataType(input.getType());
				}
				if (property.equals("INPUTDEFAULT")) {
					return input.getDefaultValue();
				}

				return null;
			}

			@Override
			public boolean canModify(Object element, String property) {
				// return element instanceof Input;
				return true;
			}
		});
	}

	private void createCellModifierOutput() {
		final String[] sources = new String[] { "java.lang.String" };

		final CellEditor[] cellEditor = new CellEditor[outputtable.getColumnCount()];
		cellEditor[0] = new TextCellEditor(outputtable);
		cellEditor[1] = new TextCellEditor(outputtable);
		cellEditor[2] = new ComboBoxViewerCellEditor(outputtable, SWT.READ_ONLY);
		((ComboBoxViewerCellEditor) cellEditor[2]).setContenProvider(new ArrayContentProvider());
		((ComboBoxViewerCellEditor) cellEditor[2]).setLabelProvider(new ViewerLabelProvider1());
		// ((ComboBoxViewerCellEditor)cellEditor[2]).setInput(DataVarUtil.getFixFlowDataVariableConfig().getDataVariableDataType().getDataTypeDef());

		outputtableViewer.setColumnProperties(new String[] { "PARAID", "PARANAME", "PARATYPE" });
		outputtableViewer.setCellEditors(cellEditor);
		outputtableViewer.setCellModifier(new ICellModifier() {

			public void modify(Object element, String property, Object value) {
				TableItem tableitem = (TableItem) element;
				Output output = (Output) tableitem.getData();
				if (property.equals("PARAID")) {
					output.setId((String) value);
				}
				if (property.equals("PARANAME")) {
					output.setName((String) value);
				}
				if (property.equals("PARATYPE")) {
					if (value == null) {
						output.setType("");
					} else {
						// output.setType(((DataTypeDef)value).getTypeValue());
					}
				}
				setPageComplete(isPageComplete());
				outputtableViewer.refresh();
			}

			public Object getValue(Object element, String property) {
				Output output = (Output) element;

				if (property.equals("PARAID")) {
					return output.getId();
				}
				if (property.equals("PARANAME")) {
					return output.getName();
				}
				if (property.equals("PARATYPE")) {
					// return
					// DataVarUtil.getDataTypeDefByDataVariableDataType(output.getType());
				}

				return null;
			}

			public boolean canModify(Object element, String property) {
				// return element instanceof Output;
				return true;
			}
		});
		outputtableViewer.setLabelProvider(new TableLabelProvider_1());
		outputtableViewer.setContentProvider(new ContentProvider_2());
		outputtableViewer.setInput(this.connectorDefinition.getOutput());
	}

	// 获取到新连接器用于保存到文件
	/*
	 * public ConnectorDefinition getNewConnector() { return newConnector; }
	 */

	// 获取到新连接器对应的分类menu用于保存到文件
	/*
	 * public Menu getMenu() { return menu; }
	 */

	// 获取新增加的分类的ID
	public List<String> getNewCreateCategoryID() {
		return newCreateCategoryID;
	}

	// 对传入的treeElement先得到对应的父节点的ID，根据父节点ID去menu中所有nodes中找出对应的node，然后在该node下加一个node出来
	/*
	 * private void modifyMenuByTreeElement(Menu menu, ITreeElement treeElement)
	 * { if (treeElement != null) { Node nodeitem =
	 * ConnectormenuFactory.eINSTANCE.createNode();
	 * nodeitem.setId(treeElement.getId());
	 * nodeitem.setIco(treeElement.getIcon());
	 * nodeitem.setName(treeElement.getName()); if (treeElement.getParent() !=
	 * null) { for (Node node : EMFUtil.getAll(menu.eResource(), Node.class)) {
	 * if (node.getId().equals(treeElement.getParent().getId())) {
	 * node.getNode().add(nodeitem); break; } } } else {
	 * menu.getNode().add(nodeitem); } } }
	 */

	private class TableLabelProvider extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			Input input = (Input) element;
			switch (columnIndex) {
			case 0:
				return input.getId();
			case 1:
				if (input.getMandatory().equals("Optional"))
					return "否";
				else
					// if (input.getMandatory().equals("Mandatory"))
					return "是";
			case 2:
				if (input.getIsExecute() != null && input.getIsExecute().equals("false"))
					return "否";
				else
					return "是";
			case 3:
				return input.getType();
			case 4:
				return input.getDefaultValue();
			}
			return null;
		}
	}

	private static class ContentProvider_1 implements IStructuredContentProvider {
		public Object[] getElements(Object inputElement) {
			if (inputElement != null) {
				return ((List<Input>) inputElement).toArray();
			}
			return new Object[0];
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}

	// outputtableviewer
	private class TableLabelProvider_1 extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			Output output = (Output) element;
			switch (columnIndex) {
			case 0:
				return output.getId();
			case 1:
				return output.getName();
			case 2:
				return output.getType();
			}
			return null;
		}
	}

	private static class ContentProvider_2 implements IStructuredContentProvider {
		public Object[] getElements(Object inputElement) {
			if (inputElement != null) {
				return ((List<Output>) inputElement).toArray();
			}
			return new Object[0];
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}

	private static class ContentProvider implements IStructuredContentProvider {
		@SuppressWarnings("unchecked")
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof List) {

				@SuppressWarnings("rawtypes")
				List list = (List) inputElement;
				Node node = ConnectormenuFactory.eINSTANCE.createNode();
				node.setName("创建...");
				if (!list.contains(node))
					list.add(node);
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

	private static class ViewerLabelProvider extends LabelProvider {
		public Image getImage(Object element) {
			return super.getImage(element);
		}

		public String getText(Object element) {
			Node treeElement = (Node) element;
			return treeElement.getName();
		}
	}

	private class ViewerLabelProvider1 extends LabelProvider {
		public Image getImage(Object element) {
			return super.getImage(element);
		}

		public String getText(Object element) {
			// DataTypeDef dataTypeDef = (DataTypeDef) element;
			// return dataTypeDef.getName();
			return "";
		}
	}

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	public String getCustomCategoryIconPath() {
		return customCategoryIconPath;
	}

	public void setCustomCategoryIconPath(String customCategoryIconPath) {
		this.customCategoryIconPath = customCategoryIconPath;
	}

	/**
	 * 拿到所有的输入参数
	 * 
	 * @return
	 */

	public List<Input> getinputs() {
		List<Input> getinputs = new ArrayList<Input>();
		for (Input input : connectorDefinition.getInput()) {
			getinputs.add(input);
		}
		return getinputs;
	}

	@Override
	public boolean isPageComplete() {

		boolean OutputNamesAreUnique = allParaNamesAreUnique(getinputs(), connectorDefinition.getOutput());
		boolean PageIdAreUnique = allPageIdUnique();

		StringBuffer sb = new StringBuffer();
		if (connectoridtext.getText() == null || connectoridtext.getText().equals(""))
			sb.append("连接器ID为空");
		if (connectoridtext.getText() != null && !(connectoridtext.getText().equals(""))) {
			Pattern pattern = Pattern.compile("^[A-Z][A-Za-z0-9]+$");
			Pattern pattern1 = Pattern.compile("^[A-Z]$");
			Matcher matcher = null;

			if (connectoridtext.getText().length() > 1) {
				matcher = pattern.matcher(connectoridtext.getText());
			} else {
				matcher = pattern1.matcher(connectoridtext.getText());
			}

			if (!matcher.matches()) {
				if (sb.length() > 0)
					sb.append(",");
				sb.append("连接器ID的名称应遵循java类的命名规范\n");
			}
		}
		if (connectornametext.getText() == null || connectornametext.getText().equals("")) {
			if (sb.length() > 0)
				sb.append(",");
			sb.append("连接器名称为空");
		}
		if (connectorclassnametext.getText() == null || connectorclassnametext.getText().equals("")) {
			if (sb.length() > 0)
				sb.append(",");
			sb.append("连接器类名为空");
		}
		if (connectorpackagenametext.getText() == null || connectorpackagenametext.getText().equals("") || connectorpackagenametext.getText().equals("找不到项目对应的包名，请在配置文件中配置") || connectorpackagenametext.getText().indexOf("请选择项目来确定包名")!=-1) {
			if (sb.length() > 0)
				sb.append(",");
			sb.append("连接器包名为空");
		}
		if (connectordesctext.getText() == null || connectordesctext.getText().equals("")) {
			if (sb.length() > 0)
				sb.append(",");
			sb.append("连接器描述为空");
		}
		// if(customCategoryComposite.getVisible() &&
		// (categoryNameText.getText() == null ||
		// categoryNameText.getText().equals(""))){
		// if(sb.length()>0)
		// sb.append(",");
		// sb.append("分类目录为空");
		// }
		// if(customCategoryComposite.getVisible() && hassamecat == true){
		// if(sb.length()>0)
		// sb.append(",");
		// sb.append("已存在该分类名称");
		// }
		// 上面两个先弃用，但是控件还保留在界面上，后期需要全部删除的
		// if (null == ((IStructuredSelection)
		// categorytreeViewer.getSelection()).getFirstElement()) {
		// if (sb.length() > 0)
		// sb.append(",");
		// sb.append("请选择分类");
		// }
		if (!OutputNamesAreUnique) {
			if (sb.length() > 0)
				sb.append(",");
			sb.append("存在相同的字段名");
		}
		if (!PageIdAreUnique) {
			if (sb.length() > 0)
				sb.append(",");
			sb.append("存在相同的页面名");
		}

		if (sb.length() > 0) {
			ConfigureNewConnectorWizardPage.this.setErrorMessage(sb.toString());
			return false;
		} else {
			ConfigureNewConnectorWizardPage.this.setErrorMessage(null);
			return true;
		}
	}

	/**
	 * 验证页ID唯一
	 * 
	 * @return
	 */

	private boolean allPageIdUnique() {
		List<Page> pageList = connectorDefinition.getPage();
		Set<String> pageIds = new HashSet<String>();
		for (Page page : pageList) {
			if (pageIds.contains(page.getId())) {
				return false;
			} else {
				pageIds.add(page.getId());
			}
		}
		return true;
	}

	/**
	 * 验证字段唯一
	 * 
	 * @return
	 */

	private boolean allParaNamesAreUnique(List<Input> inputs, List<Output> outputs) {
		Set<String> parameterNames = new HashSet<String>();
		for (Input inputParameter : inputs) {
			if (parameterNames.contains(inputParameter.getId())) {
				return false;
			} else {
				parameterNames.add(inputParameter.getId());
			}
		}
		for (Output outputParameter : outputs) {
			if (parameterNames.contains(outputParameter.getId())) {
				return false;
			} else {
				parameterNames.add(outputParameter.getId());
			}
		}
		return true;
	}

	/**
	 * 设置按钮可用性
	 */
	@SuppressWarnings("unchecked")
	public void updateButtons() {

		Object[] objs = null;
		ISelection sel = pagetableViewer.getSelection();
		if (sel != null) {
			objs = ((IStructuredSelection) sel).toArray();
		}
		Object selectedPage = ((IStructuredSelection) pagetableViewer.getSelection()).getFirstElement();
		int index = 0;
		while (selectedPage != null && pagetableViewer.getElementAt(index) != null && !selectedPage.equals(pagetableViewer.getElementAt(index))) {
			index++;
		}
		pagedeleteButton.setEnabled(selectedPage != null);
		pageeditButton.setEnabled(selectedPage != null && objs != null && objs.length < 2);
		pageupButton.setEnabled(selectedPage != null && index != 0 && objs != null && objs.length < 2);
		pagedownButton.setEnabled(selectedPage != null && index != pagetableViewer.getTable().getItemCount() - 1 && objs != null && objs.length < 2);

		if (outputtableViewer != null) {
			Object[] objs1 = null;
			ISelection sel1 = outputtableViewer.getSelection();
			if (sel1 != null) {
				objs1 = ((IStructuredSelection) sel1).toArray();
			}
			Object selectedPage1 = ((IStructuredSelection) outputtableViewer.getSelection()).getFirstElement();
			index = 0;
			while (selectedPage != null && selectedPage1 != null && outputtableViewer.getElementAt(index) != null && !selectedPage1.equals(outputtableViewer.getElementAt(index))) {
				index++;
			}
			outputdownButton.setEnabled(selectedPage1 != null && index != outputtableViewer.getTable().getItemCount() - 1 && objs1 != null && objs1.length < 2);
			outputupButton.setEnabled(selectedPage1 != null && index != 0 && objs1 != null && objs1.length < 2);
		}

		Object[] objs1 = null;
		ISelection sel1 = outputtableViewer.getSelection();
		if (sel1 != null) {
			objs1 = ((IStructuredSelection) sel1).toArray();
		}
		Output outputparameter = (Output) ((IStructuredSelection) outputtableViewer.getSelection()).getFirstElement();
		index = -1;
		if (outputparameter != null) {
			index = ((List<Output>) outputtableViewer.getInput()).indexOf(outputparameter);
		}
		if (outputdeleteButton != null) {
			outputdeleteButton.setEnabled(outputparameter != null);
		}
		if (outputdownButton != null) {
			outputdownButton.setEnabled(outputparameter != null && index < ((List<Output>) outputtableViewer.getInput()).size() - 1 && objs1 != null && objs1.length < 2);
		}
		if (outputupButton != null) {
			outputupButton.setEnabled(outputparameter != null && index > 0 && objs1 != null && objs1.length < 2);
		}

		// 输入按钮对应状态
		Object[] objsInPut = null;
		ISelection selInPut = tableViewer.getSelection();
		if (selInPut != null) {
			objsInPut = ((IStructuredSelection) selInPut).toArray();
		}
		Input input = (Input) ((IStructuredSelection) tableViewer.getSelection()).getFirstElement();
		index = -1;
		if (input != null) {
			index = ((List<Input>) tableViewer.getInput()).indexOf(input);
		}
		if (inputdeleteButton != null) {
			inputdeleteButton.setEnabled(input != null);
		}
		if (inputdownButton != null) {
			inputdownButton.setEnabled(input != null && index < ((List<Input>) tableViewer.getInput()).size() - 1 && objsInPut != null && objsInPut.length < 2);
		}
		if (inputupButton != null) {
			inputupButton.setEnabled(input != null && index > 0 && objsInPut != null && objsInPut.length < 2);
		}
	}

	public String getOpenType() {
		return openType;
	}

	public FileInputStream getIs() {
		return is;
	}

	public ConnectorDefinition getConnectorDefinition() {
		return connectorDefinition;
	}

	public Node getNode() {
		return node;
	}

	public Menu getMenu() {
		return menu;
	}

	// 对传入的treeElement先得到对应的父节点的ID，根据父节点ID去menu中所有nodes中找出对应的node，然后在该node下加一个node出来
	private void modifyMenuByTreeElement(Menu menu, ITreeElement treeElement) {
		if (treeElement != null) {
			Node nodeitem = ConnectormenuFactory.eINSTANCE.createNode();
			nodeitem.setId(treeElement.getId());
			nodeitem.setIco(treeElement.getIcon());
			nodeitem.setName(treeElement.getName());
			if (treeElement.getParent() != null) {
				for (Node node : EMFUtil.getAll(menu.eResource(), Node.class)) {
					if (node.getId().equals(treeElement.getParent().getId())) {
						node.getNode().add(nodeitem);
						break;
					}
				}
			} else {
				menu.getFlowConnector().getNode().add(nodeitem);
			}
		}
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextConnectoridtextObserveWidget = WidgetProperties.text(SWT.Modify).observe(connectoridtext);
		IObservableValue connectorDefinitionIdObserveValue = EMFObservables.observeValue(connectorDefinition, Literals.CONNECTOR_DEFINITION__ID);
		bindingContext.bindValue(observeTextConnectoridtextObserveWidget, connectorDefinitionIdObserveValue, null, null);
		//
		IObservableValue observeTextConnectornametextObserveWidget = WidgetProperties.text(SWT.Modify).observe(connectornametext);
		IObservableValue connectorDefinitionNameObserveValue = EMFObservables.observeValue(connectorDefinition, Literals.CONNECTOR_DEFINITION__NAME);
		bindingContext.bindValue(observeTextConnectornametextObserveWidget, connectorDefinitionNameObserveValue, null, null);
		//
		IObservableValue observeTextConnectordesctextObserveWidget = WidgetProperties.text(SWT.Modify).observe(connectordesctext);
		IObservableValue connectorDefinitionNoteObserveValue = EMFObservables.observeValue(connectorDefinition, Literals.CONNECTOR_DEFINITION__NOTE);
		bindingContext.bindValue(observeTextConnectordesctextObserveWidget, connectorDefinitionNoteObserveValue, null, null);
		//
		IObservableValue observeTextConnectorpackagenametextObserveWidget = WidgetProperties.text(SWT.Modify).observe(connectorpackagenametext);
		IObservableValue connectorDefinitionPackageNameObserveValue = EMFProperties.value(FeaturePath.fromList(Literals.CONNECTOR_DEFINITION__DEFINITION_IMPL, Literals.DEFINITION_IMPL__PACKAGE_NAME)).observe(connectorDefinition);
		bindingContext.bindValue(observeTextConnectorpackagenametextObserveWidget, connectorDefinitionPackageNameObserveValue, null, null);
		//
		IObservableValue observeTextConnectorclassnametextObserveWidget = WidgetProperties.text(SWT.Modify).observe(connectorclassnametext);
		IObservableValue connectorDefinitionClassNameObserveValue = EMFProperties.value(FeaturePath.fromList(Literals.CONNECTOR_DEFINITION__DEFINITION_IMPL, Literals.DEFINITION_IMPL__CLASS_NAME)).observe(connectorDefinition);
		bindingContext.bindValue(observeTextConnectorclassnametextObserveWidget, connectorDefinitionClassNameObserveValue, null, null);
		//
		return bindingContext;
	}

	public String getConnectorMenuPath() {
		return connectorMenuPath;
	}

}
