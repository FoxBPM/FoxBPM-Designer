package org.foxbpm.bpmn.designer.ui.actor.definition;

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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.ui.wizards.NewTypeWizardPage;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.Dialog;
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
import org.eclipse.swt.events.SelectionAdapter;
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
import org.foxbpm.bpmn.designer.ui.connector.definition.CategoryCreateDialog;
import org.foxbpm.bpmn.designer.ui.connector.definition.CreateNewPageDialog;
import org.foxbpm.bpmn.designer.ui.tree.ITreeElement;
import org.foxbpm.bpmn.designer.ui.tree.TreeViewerContentProvider;
import org.foxbpm.bpmn.designer.ui.tree.TreeViewerLabelProvider;
import org.foxbpm.bpmn.designer.ui.tree.RuntimeTreeViewerFactory;
import org.foxbpm.bpmn.designer.ui.utils.ConnectorUtil;
import org.foxbpm.bpmn.designer.ui.utils.EMFUtil;
import org.foxbpm.model.config.connector.ConnectorDefinition;
import org.foxbpm.model.config.connector.ConnectorFactory;
import org.foxbpm.model.config.connector.ConnectorPackage;
import org.foxbpm.model.config.connector.DefinitionImpl;
import org.foxbpm.model.config.connector.Input;
import org.foxbpm.model.config.connector.Output;
import org.foxbpm.model.config.connector.Page;
import org.foxbpm.model.config.connectormenu.ConnectormenuFactory;
import org.foxbpm.model.config.connectormenu.Menu;
import org.foxbpm.model.config.connectormenu.Node;

public class ConfigureActorConnectorWizardPage extends NewTypeWizardPage {
	
	private static String CONNECTORDEFAULTICON = "connector.png";
	
	private DataBindingContext m_bindingContext;
	private Text connectorclassnametext;
	private Text connectorpackagenametext;
	private Table pagetable;
	private TableViewer pagetableViewer;
	private Text connectoridtext;
	private Text connectornametext;
	private Text connectordesctext;
	private Button connectoriconButton;
	private String iconPath;
	private ConnectorDefinition newConnector;
	private Menu menu;
	private ConnectorFactory newFactory;
	private String customCategoryIconPath;
	private Node node;
	private Composite composite;
	private List<Node> nodelist;
	private Button inputcreateButton;
	private Button inputupButton;
	private Button inputdownButton;
	private Button inputdeleteButton;
	private Button pagecreateButton;
	private Button pageeditButton;
	private Button pageupButton;
	private Button pagedownButton;
	private Button pagedeleteButton;
	private List<Page> pages;
	private String openType;
	private FileInputStream is;
	private Table table;
	private TableViewer tableViewer;
	private Tree categorytree;
	private TreeViewer categorytreeViewer;
	private Button categorycreateButton;
	private List<ITreeElement> categorytreeElements;
	private List<String> newCreateCategoryID;
	
	/**
	 * 构造函数
	 * @param isClass
	 * @param pageName
	 * @wbp.parser.constructor
	 */
	public ConfigureActorConnectorWizardPage(boolean isClass, String pageName) {
		super(isClass, pageName);
		setDescription("设置处理者选择器的描述信息");
		setTitle(pageName);
		
		//初始化model
		ConnectorPackage.eINSTANCE.eClass();
		ConnectorFactory newFactory = ConnectorFactory.eINSTANCE;
		ConnectorDefinition newConnector = newFactory.createConnectorDefinition();
		DefinitionImpl definitionImpl = newFactory.createDefinitionImpl();
		this.newConnector = newConnector;
		this.newFactory = newFactory;
		this.newConnector.setDefinitionImpl(definitionImpl);
		ConnectormenuFactory menufactory = ConnectormenuFactory.eINSTANCE;
		Node node = menufactory.createNode();
		this.node = node;
		this.node.setName("");
		
		this.pages = new ArrayList<Page>();
		this.newCreateCategoryID = new ArrayList<String>();
		//读取Menu的xml
		menu = ConnectorUtil.getActorConnectorMenu();
		//通过下面这一个方法就不需要再递归得到所有节点
		nodelist = EMFUtil.getAll(menu.eResource(), Node.class);
		
		this.openType = "create";
	}
	
	/**
	 * 修改时构造函数
	 * @param isClass
	 * @param pageName
	 * @param connector
	 */
	public ConfigureActorConnectorWizardPage(boolean isClass, String pageName, ConnectorDefinition connector) {
		super(isClass, pageName);
		setDescription("设置处理者选择器的描述信息");
		setTitle("编辑处理者选择器");
		
		// 初始化model
		ConnectorPackage.eINSTANCE.eClass();
		ConnectorFactory newFactory = ConnectorFactory.eINSTANCE;
		this.newConnector = connector;
		this.newFactory = newFactory;
		this.newCreateCategoryID = new ArrayList<String>();
		//读取Menu的xml
		menu = ConnectorUtil.getActorConnectorMenu();
		nodelist = EMFUtil.getAll(menu.eResource(), Node.class);
		
		for (Node nd : nodelist) {
			if (nd.getId().equals(connector.getCategoryId())){
				this.node = nd;
			}
		}
		
		this.openType = "edit";
	}

	@Override
	public void createControl(Composite parent) {
		Composite mainComposite = new Composite(parent, SWT.NONE);
		mainComposite.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		composite = new Composite(mainComposite, SWT.NONE);
		GridLayout gl_composite = new GridLayout(5, false);
		gl_composite.marginRight = 10;
		gl_composite.marginHeight = 0;
		gl_composite.marginLeft = 10;
		composite.setLayout(gl_composite);
		
		Label connectoridLabel = new Label(composite, SWT.NONE);
		connectoridLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		connectoridLabel.setText("选择器ID");
		
		connectoridtext = new Text(composite, SWT.BORDER);
		connectoridtext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
		
		connectoridtext.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				connectorclassnametext.setText(connectoridtext.getText());
				connectorpackagenametext.setText("com.founder.fix.fixflow.expand.actorconnector" + "." + connectoridtext.getText());
				setPageComplete(isPageComplete());
			}
		});
		
		Label connectornameLabel = new Label(composite, SWT.NONE);
		connectornameLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		connectornameLabel.setText("名称");
		
		connectornametext = new Text(composite, SWT.BORDER);
		connectornametext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
		
		connectornametext.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				setPageComplete(isPageComplete());
			}
		});
		
		Label connectordescLabel = new Label(composite, SWT.NONE);
		connectordescLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		connectordescLabel.setText("描述");
		
		connectordesctext = new Text(composite, SWT.BORDER);
		connectordesctext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
		
		connectordesctext.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				setPageComplete(isPageComplete());
			}
		});
		
		Label connectorclassnameLabel = new Label(composite, SWT.NONE);
		connectorclassnameLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		connectorclassnameLabel.setText("类名");
		
		connectorclassnametext = new Text(composite, SWT.BORDER);
		connectorclassnametext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
		
		Label connectorpackagenameLabel = new Label(composite, SWT.NONE);
		connectorpackagenameLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		connectorpackagenameLabel.setText("包名");
		
		connectorpackagenametext = new Text(composite, SWT.BORDER | SWT.READ_ONLY);
		connectorpackagenametext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
		
		Button connectorpakageButton = new Button(composite, SWT.NONE);
		connectorpakageButton.setEnabled(false);
		connectorpakageButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		connectorpakageButton.setText("浏览");
		connectorpakageButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				IPackageFragment selectedPackage = ConfigureActorConnectorWizardPage.this.choosePackage();
				if (selectedPackage != null) {
					connectorpackagenametext.setText(selectedPackage.getElementName());
				}
			}
		});
		
		Label connectoriconLabel = new Label(composite, SWT.NONE);
		connectoriconLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		connectoriconLabel.setText("图标");
		
		connectoriconButton = new Button(composite, SWT.NONE);
		GridData gd_connectoriconButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 4, 1);
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
					ConfigureActorConnectorWizardPage.this.iconPath = res;
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
					//这个连接器的图标名称需要改成和连接器ID一样的名字，由于这个里面可能还没有输入id所以改成到保存代码再修改
					newConnector.setIcon(ConnectorUtil.getConnectorMenuIconName(res));
				}
			}
		});
		
		// 编辑时显示图片
		if (newConnector.getIcon() != null) {
			try {
				connectoriconButton.setText("");
				is = new FileInputStream(ConnectorUtil.getDefinitionActorConnectorIconPathByIconName(newConnector.getId(), newConnector.getIcon()));
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
			this.setIconPath(ConnectorUtil.getConnectorIconPath() + CONNECTORDEFAULTICON);
			newConnector.setIcon(ConnectorUtil.getConnectorMenuIconName(iconPath));
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
		
		//如果是编辑时，不允许更改ID，防止保存时验证ID唯一时麻烦
		if(openType.equals("edit")) {
			connectoridtext.setEnabled(false);
			connectorclassnametext.setEnabled(false);
		}
		
		// treeViewer获取数据
		categorytreeElements = (List<ITreeElement>) RuntimeTreeViewerFactory.reloadActorTreeNodes();
		categorytreeViewer = new TreeViewer(composite, SWT.BORDER);
		categorytreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				ITreeElement treeElementselect = (ITreeElement) ((IStructuredSelection)categorytreeViewer.getSelection()).getFirstElement();
				if (treeElementselect != null && openType.equals("create")) {
					newConnector.setCategoryId(treeElementselect.getId());
					node.setId(treeElementselect.getId());
					node.setName(treeElementselect.getName());
				}
				setPageComplete(isPageComplete());
				//想把选中Node对应的name颜色换成其它颜色醒目些
//				categorytree.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
			}
		});
		categorytree = categorytreeViewer.getTree();
		GridData gd_categorytree = new GridData(SWT.FILL, SWT.TOP, true, true, 3, 1);
		gd_categorytree.heightHint = 83;
		categorytree.setLayoutData(gd_categorytree);
		// 设置标签提供器
		categorytreeViewer.setLabelProvider(new TreeViewerLabelProvider());
		// 设置内容提供器
		categorytreeViewer.setContentProvider(new TreeViewerContentProvider());
		// 设置内容
		categorytreeViewer.setInput(categorytreeElements);
		
		Composite categorycomposite = new Composite(composite, SWT.NONE);
		GridLayout gl_categorycomposite = new GridLayout(1, false);
		gl_categorycomposite.marginWidth = 0;
		gl_categorycomposite.marginHeight = 0;
		categorycomposite.setLayout(gl_categorycomposite);
		categorycreateButton = new Button(categorycomposite, SWT.NONE);
		categorycreateButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//这个里面弹出来新建分类的
				ITreeElement treeElementselect = (ITreeElement) ((IStructuredSelection)categorytreeViewer.getSelection()).getFirstElement();
				if (treeElementselect != null) {
					newConnector.setCategoryId(treeElementselect.getId());
				}
				CategoryCreateDialog dialog = new CategoryCreateDialog(getShell(),treeElementselect,categorytreeElements);
				if(dialog.open() == Dialog.OK) {
					//回填到界面上,新增一个树节点出来
					if (dialog.getSelTreeElement()!=null) {
						Node node = ConnectormenuFactory.eINSTANCE.createNode();
						node.setId(dialog.getSelTreeElement().getId());
						node.setName(dialog.getSelTreeElement().getName());
						node.setIco(dialog.getSelTreeElement().getIcon());
						//把新建的分类对应的ID记录保存起来，供保存menu时候去刷新图标
						newCreateCategoryID.add(dialog.getSelTreeElement().getId());
						if (!nodelist.contains(node)) {
							if (nodelist.size() > 0)
								nodelist.add(nodelist.size() - 1, node);
							else
								nodelist.add(node);
						}
						categorytreeElements = dialog.getTreeElements();
						//选中刚才创建的分类
						categorytreeViewer.refresh();
						categorytreeViewer.expandToLevel(treeElementselect, 1);
						categorytreeViewer.setSelection(new StructuredSelection(dialog.getSelTreeElement()));
						//这个里面还需要根据categorytreeElements对menu进行实时更改
						modifyMenuByTreeElement(ConfigureActorConnectorWizardPage.this.menu,dialog.getSelTreeElement());
					}
				}
			}
		});
		GridData gd_categorycreateButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_categorycreateButton.heightHint = 20;
		categorycreateButton.setLayoutData(gd_categorycreateButton);
		categorycreateButton.setText("创建");
		
		//根如果是编辑的话就需要再设置一些东西
		if(newConnector.getCategoryId() == null) {
			//默认选择分类树上第一个节点
			for (ITreeElement treeElement : categorytreeElements) {
				if (treeElement.getId().equals(nodelist.get(0).getId())) {
					categorytreeViewer.setSelection(new StructuredSelection(treeElement));
					break;
				}
			}
		}else{
			//这个里面没有办法得到对应的子节点下面多层的有问题需要递归得到
			ITreeElement treeElementSel = getCategoryTreeViewerSelectionById(categorytreeElements,newConnector.getCategoryId());
			if (null != treeElementSel) {
				categorytreeViewer.expandAll();
				categorytreeViewer.setSelection(new StructuredSelection(treeElementSel));
//				categorytreeViewer.getTree().setEnabled(false);
				categorycreateButton.setEnabled(false);
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
		GridData gd_table = new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1);
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
		tableViewer.setInput(this.newConnector.getInput());
		
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
//				ConnectorPackage.eINSTANCE.eClass();
//				ConnectorFactory newFactory = ConnectorFactory.eINSTANCE;
				Input input = newFactory.createInput();
				input.setId("inputId"+ ((List)tableViewer.getInput()).size());
				input.setMandatory("Mandatory");
				input.setIsExecute("true");
				input.setType("java.lang.String");
				input.setDefaultValue("");
				newConnector.getInput().add(input);
				
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
				int idx = ((List<Input>)tableViewer.getInput()).indexOf(inputSel);
				if (idx != 0) {
					((List<Input>)tableViewer.getInput()).remove(inputSel);
					((List<Input>)tableViewer.getInput()).add(idx - 1, inputSel);
				}
				tableViewer.refresh();
				if(selection != null)
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
				int idx = ((List<Input>)tableViewer.getInput()).indexOf(inputTo);
				if (idx != ((List<Input>)tableViewer.getInput()).size() - 1) {
					((List<Input>)tableViewer.getInput()).remove(inputTo);
					((List<Input>)tableViewer.getInput()).add(idx + 1, inputTo);
				}
				tableViewer.refresh();
				if(selection != null)
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
					newConnector.getInput().remove(colInput);
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
		pagetable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 3, 1));
		
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
				cell.setText(((Page)cell.getElement()).getId());
			}
		});
		
		TableViewerColumn titlecolumn = new TableViewerColumn(pagetableViewer, SWT.NONE);
		titlecolumn.getColumn().setWidth(264);
		titlecolumn.getColumn().setText("页面标题");
		titlecolumn.getColumn().setMoveable(true);
		titlecolumn.setLabelProvider(new CellLabelProvider() {
			
			@Override
			public void update(ViewerCell cell) {
				//这个里面先用getName试试，后面问了具体再改
				cell.setText(((Page)cell.getElement()).getName());
			}
		});
		
		TableViewerColumn numcolumn = new TableViewerColumn(pagetableViewer, SWT.NONE);
		numcolumn.getColumn().setWidth(88);
		numcolumn.getColumn().setText("输入的个数");
		numcolumn.getColumn().setMoveable(true);
		numcolumn.setLabelProvider(new CellLabelProvider() {
			
			@Override
			public void update(ViewerCell cell) {
				cell.setText(((Page)cell.getElement()).getWidget().size() + "");
			}
		});
		
		pagetableViewer.setContentProvider(new ArrayContentProvider());
		pagetableViewer.setInput(newConnector.getPage());
		
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
				CreateNewPageDialog cpd = new CreateNewPageDialog(getShell(), newConnector);
				cpd.setBlockOnOpen(true);
				if(cpd != null && cpd.open() == InputDialog.OK){
					newConnector.getPage().add(cpd.getPage());
					((EList<Page>)pagetableViewer.getInput()).add(cpd.getPage());
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
				//先注释了，改好了那个Dialog就放出来
				if(!pagetableViewer.getSelection().isEmpty()){
					IStructuredSelection selection = (IStructuredSelection) pagetableViewer.getSelection();
					Page page  = (Page) selection.getFirstElement();
					CreateNewPageDialog cpd = new CreateNewPageDialog(getShell(), page, newConnector);
					cpd.setBlockOnOpen(true);
					if(cpd != null && cpd.open() == InputDialog.OK){
						newConnector.getPage().remove(page);
						newConnector.getPage().add(cpd.getPage());
						int index = ((List<Page>)pagetableViewer.getInput()).indexOf(page);
						((List<Page>)pagetableViewer.getInput()).remove(page);
						((List<Page>)pagetableViewer.getInput()).add(index, cpd.getPage());
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
				int idx = ((List<Page>)pagetableViewer.getInput()).indexOf(page);
				if (idx != 0) {
					((List<Page>)pagetableViewer.getInput()).remove(page);
					((List<Page>)pagetableViewer.getInput()).add(idx - 1, page);
				}
				pagetableViewer.refresh();
				if(selection != null)
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
				int idx = ((List<Page>)pagetableViewer.getInput()).indexOf(pageTo);
				if (idx != ((List<Page>)pagetableViewer.getInput()).size() - 1) {
					((List<Page>)pagetableViewer.getInput()).remove(pageTo);
					((List<Page>)pagetableViewer.getInput()).add(idx + 1, pageTo);
				}
				pagetableViewer.refresh();
				if(selection != null)
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
					((List<Page>)pagetableViewer.getInput()).remove(col);
					newConnector.getPage().remove(col);
				}
				pagetableViewer.refresh();
				setPageComplete(isPageComplete());
				updateButtons();
			}
		});
		
		createCellModifierInput();
		
		updateButtons();
		setControl(mainComposite);
		m_bindingContext = initDataBindings();
	}
	
	private ITreeElement getCategoryTreeViewerSelectionById(List<ITreeElement> iTreeElements, String categoryIdString) {
		ITreeElement treeElementResult = null;
		if (null != iTreeElements && iTreeElements.size()>0) {
			for(ITreeElement iTreeElement : iTreeElements){
				if (iTreeElement.getId().equals(categoryIdString)) {
					treeElementResult = iTreeElement;
					return treeElementResult;
				} else {
					if (iTreeElement.hasChildren()) {
						ITreeElement treeElementTemp = getCategoryTreeViewerSelectionById(iTreeElement.getChildren(),categoryIdString);
						if (null != treeElementTemp) {
							treeElementResult = treeElementTemp;
						}
					}
				}
			}
		}
		return treeElementResult;
	}

	private void createCellModifierInput() {
		final CellEditor[] cellEditorInPut = new CellEditor[table.getColumnCount()];
		//ID,强制，类型，默认值
		cellEditorInPut[0] = new TextCellEditor(table);
		
		cellEditorInPut[1] = new ComboBoxViewerCellEditor(table, SWT.READ_ONLY);
		((ComboBoxViewerCellEditor)cellEditorInPut[1]).setContenProvider(new ArrayContentProvider());
		((ComboBoxViewerCellEditor)cellEditorInPut[1]).setLabelProvider(new TableLabelProvider());
		((ComboBoxViewerCellEditor)cellEditorInPut[1]).setInput(new String[] {"是","否"});
		
		cellEditorInPut[2] = new ComboBoxViewerCellEditor(table, SWT.READ_ONLY);
		((ComboBoxViewerCellEditor)cellEditorInPut[2]).setContenProvider(new ArrayContentProvider());
		((ComboBoxViewerCellEditor)cellEditorInPut[2]).setLabelProvider(new TableLabelProvider());
		((ComboBoxViewerCellEditor)cellEditorInPut[2]).setInput(new String[] {"是","否"});
		
		cellEditorInPut[3] = new ComboBoxViewerCellEditor(table, SWT.READ_ONLY);
		((ComboBoxViewerCellEditor)cellEditorInPut[3]).setContenProvider(new ArrayContentProvider());
		((ComboBoxViewerCellEditor)cellEditorInPut[3]).setLabelProvider(new ViewerLabelProvider1());
		((ComboBoxViewerCellEditor)cellEditorInPut[3]).setInput(new ArrayList<String>());
		
		cellEditorInPut[4] = new TextCellEditor(table);
		
		tableViewer.setColumnProperties(new String[]{"INPUTID", "INPUTMANDATORY", "ISEXCUTE", "INPUTTYPE", 
				"INPUTDEFAULT"});
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
					if(value == null){
						input.setType("");
					}else{
//						input.setType(((DataTypeDef)value).getTypeValue());
//						if(!((DataTypeDef)value).getTypeValue().equals("java.lang.String")) {
//							((ComboBoxViewerCellEditor) cellEditorInPut[2]).setValue("true");
//							input.setIsExecute("true");
//						}
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
//					return DataVarUtil.getDataTypeDefByDataVariableDataType(input.getType());
				}
				if (property.equals("INPUTDEFAULT")) {
					return input.getDefaultValue();
				}
				return null;
			}
			
			@Override
			public boolean canModify(Object element, String property) {
				return element instanceof Input;
			}
		});
	}

	//获取到新连接器用于保存到文件
	public ConnectorDefinition getNewConnector() {
		return newConnector;
	}
	
	//获取到新连接器对应的分类menu用于保存到文件
	public Menu getMenu() {
		return menu;
	}
	
	//获取新增加的分类的ID
	public List<String> getNewCreateCategoryID() {
		return newCreateCategoryID;
	}
	
	//对传入的treeElement先得到对应的父节点的ID，根据父节点ID去menu中所有nodes中找出对应的node，然后在该node下加一个node出来
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
				menu.getNode().add(nodeitem);
			}
		}
	}
	
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
				else //if (input.getMandatory().equals("Mandatory")) 
					return "是";
			case 2:
				if (input.getIsExecute().equals("false")) 
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
			if (inputElement!=null) {
				return ((List<Input>)inputElement).toArray();
			}
			return new Object[0];
		}
		public void dispose() {
		}
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}
	
	//outputtableviewer
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
				return ((List<Output>)inputElement).toArray();
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
				if(!list.contains(node))
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
//			DataTypeDef dataTypeDef = (DataTypeDef) element;
//			return dataTypeDef.getName();
			return "";
		}
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
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
	 * @return
	 */
	public List<Input> getinputs(){
		List<Input> getinputs = new ArrayList<Input>();
		for(Input input : newConnector.getInput()){
			getinputs.add(input);
		}
		return getinputs;
	}
	
	@Override
	public boolean isPageComplete() {
		boolean OutputNamesAreUnique = allParaNamesAreUnique(getinputs(), newConnector.getOutput());
		boolean PageIdAreUnique = allPageIdUnique();
		
		StringBuffer sb = new StringBuffer();
		if(connectoridtext.getText() == null || connectoridtext.getText().equals(""))
			sb.append("选择器ID为空");
		if(connectoridtext.getText() != null && !(connectoridtext.getText().equals(""))) {
			Pattern pattern = Pattern.compile("^[A-Z][A-Za-z0-9]+$");
			Pattern pattern1 = Pattern.compile("^[A-Z]$");
			Matcher matcher = null;
			
			if(connectoridtext.getText().length()>1) {
				matcher = pattern.matcher(connectoridtext.getText());
			}else{
				matcher = pattern1.matcher(connectoridtext.getText());
			}
			
			if(!matcher.matches()){
				if(sb.length()>0)
					sb.append(",");
				sb.append("选择器ID的名称应遵循java类的命名规范\n");
			}
		}
		if(connectornametext.getText() == null || connectornametext.getText().equals("")){
			if(sb.length()>0)
				sb.append(",");
			sb.append("选择器名称为空");
		}
		if(connectorclassnametext.getText() == null || connectorclassnametext.getText().equals("")){
			if(sb.length()>0)
				sb.append(",");
			sb.append("选择器类名为空");
		}
		if(connectordesctext.getText() == null || connectordesctext.getText().equals("")){
			if(sb.length()>0)
				sb.append(",");
			sb.append("选择器描述为空");
		}
		//上面两个先弃用，但是控件还保留在界面上，后期需要全部删除的
		if (null == ((IStructuredSelection)categorytreeViewer.getSelection()).getFirstElement()) {
			if(sb.length()>0)
				sb.append(",");
			sb.append("请选择分类");
		}
		if(!OutputNamesAreUnique){
			if(sb.length()>0)
				sb.append(",");
			sb.append("存在相同的字段名");
		}
		if(!PageIdAreUnique){
			if(sb.length()>0)
				sb.append(",");
			sb.append("存在相同的页面名");
		}
		
		if(sb.length()>0){
			ConfigureActorConnectorWizardPage.this.setErrorMessage(sb.toString());
			return false;
		}else{
			ConfigureActorConnectorWizardPage.this.setErrorMessage(null);
			return true;
		}
	}
	
	/**
	 * 验证页ID唯一
	 * @return
	 */
	private boolean allPageIdUnique() {
		List<Page> pageList = newConnector.getPage();
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
	public void updateButtons(){
		Object[] objs = null;
		ISelection sel = pagetableViewer.getSelection();
		if(sel != null) {
			objs = ((IStructuredSelection) sel).toArray();
		}
		Object selectedPage = ((IStructuredSelection)pagetableViewer.getSelection()).getFirstElement();
		int index = 0;
		while (selectedPage != null && pagetableViewer.getElementAt(index) != null && ! selectedPage.equals(pagetableViewer.getElementAt(index))) {
			index++;
		}
		pagedeleteButton.setEnabled(selectedPage != null);
		pageeditButton.setEnabled(selectedPage != null && objs != null && objs.length<2);
		pageupButton.setEnabled(selectedPage != null && index != 0 && objs != null && objs.length<2);
		pagedownButton.setEnabled(selectedPage != null && index != pagetableViewer.getTable().getItemCount() - 1 && objs != null && objs.length<2);
		
		//输入按钮对应状态
		Object[] objsInPut = null;
		ISelection selInPut = tableViewer.getSelection();
		if(selInPut != null) {
			objsInPut = ((IStructuredSelection) selInPut).toArray();
		}
		Input input = (Input) ((IStructuredSelection)tableViewer.getSelection()).getFirstElement();
		index = -1;
		if(input!=null) {
			index = ((List<Input>)tableViewer.getInput()).indexOf(input);
		}
		if (inputdeleteButton != null) {
			inputdeleteButton.setEnabled(input != null);
		}
		if(inputdownButton != null){
			inputdownButton.setEnabled(input!= null && index < ((List<Input>)tableViewer.getInput()).size()-1 && objsInPut != null && objsInPut.length<2);
		}
		if(inputupButton != null){
			inputupButton.setEnabled(input!= null && index > 0 && objsInPut != null && objsInPut.length<2);
		}
	}
	
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue connectoridtextObserveTextObserveWidget = SWTObservables.observeText(connectoridtext, SWT.Modify);
		IObservableValue connectorConnectorIdObserveValue = EMFObservables.observeValue(newConnector, ConnectorPackage.Literals.CONNECTOR_DEFINITION__ID);
		bindingContext.bindValue(connectoridtextObserveTextObserveWidget, connectorConnectorIdObserveValue, null, null);
		//
		IObservableValue connectornametextObserveTextObserveWidget = SWTObservables.observeText(connectornametext, SWT.Modify);
		IObservableValue connectorConnectorNameObserveValue = EMFObservables.observeValue(newConnector, ConnectorPackage.Literals.CONNECTOR_DEFINITION__NAME);
		bindingContext.bindValue(connectornametextObserveTextObserveWidget, connectorConnectorNameObserveValue, null, null);
		//
		IObservableValue connectordesctextObserveTextObserveWidget = SWTObservables.observeText(connectordesctext, SWT.Modify);
		IObservableValue connectorConnectorNoteObserveValue = EMFObservables.observeValue(newConnector, ConnectorPackage.Literals.CONNECTOR_DEFINITION__NOTE);
		bindingContext.bindValue(connectordesctextObserveTextObserveWidget, connectorConnectorNoteObserveValue, null, null);
		//
		IObservableValue connectorclassnametextObserveTextObserveWidget = SWTObservables.observeText(connectorclassnametext, SWT.Modify);
		IObservableValue connectorClassNameObserveValue = EMFObservables.observeValue(newConnector.getDefinitionImpl(), ConnectorPackage.Literals.DEFINITION_IMPL__CLASS_NAME);
		bindingContext.bindValue(connectorclassnametextObserveTextObserveWidget, connectorClassNameObserveValue, null, null);
		//
		IObservableValue connectorpackagenametextObserveTextObserveWidget = SWTObservables.observeText(connectorpackagenametext, SWT.Modify);
		IObservableValue connectorPackageNameObserveValue = EMFObservables.observeValue(newConnector.getDefinitionImpl(), ConnectorPackage.Literals.DEFINITION_IMPL__PACKAGE_NAME);
		bindingContext.bindValue(connectorpackagenametextObserveTextObserveWidget, connectorPackageNameObserveValue, null, null);
		//
		return bindingContext;
	}

	public String getOpenType() {
		return openType;
	}

	public FileInputStream getIs() {
		return is;
	}
	
}

