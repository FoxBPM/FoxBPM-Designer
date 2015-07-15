package org.foxbpm.bpmn.designer.ui.actor.runtime.create;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.foxbpm.bpmn.designer.ui.connector.runtime.ConnectorFilter;
import org.foxbpm.bpmn.designer.ui.connector.runtime.create.CommonNewConnectorWizardPage;
import org.foxbpm.bpmn.designer.ui.tree.ActorTreeViewerLabelProvider;
import org.foxbpm.bpmn.designer.ui.tree.ITreeElement;
import org.foxbpm.bpmn.designer.ui.tree.RuntimeTreeViewerFactory;
import org.foxbpm.bpmn.designer.ui.tree.TreeViewerContentProvider;
import org.foxbpm.model.config.connector.ConnectorDefinition;
import org.foxbpm.model.config.connector.Page;

public class SelectNewActorConnectorWizardPage extends WizardPage {

	private ConnectorFilter filter;

	private TreeViewer viewer;

	private AddNewActorConnectorWizard wizard;

	private CommonNewConnectorWizardPage[] commonConnectotWizardPages;

	private CommonNewConnectorWizardPage commonConnectotWizardPage;

//	private OutputNewConnectorWizardPage outputConnectorWizardPage;

	private ConnectorDefinition connector;

	private EObject be;

	/**
	 * @param pageName
	 */
	public SelectNewActorConnectorWizardPage(String pageName) {
		super(pageName);
	}

	/**
	 * @param pageName
	 * @param title
	 * @param titleImage
	 */
	public SelectNewActorConnectorWizardPage(EObject be, String pageName, String title, 
			ImageDescriptor titleImage, AddNewActorConnectorWizard wizard) {
		super(pageName, title, titleImage);
		this.wizard = wizard;

		// title信息
		setTitle(title);

		// 消息信息
		setMessage("选择您想加入的选择器", INFORMATION);

		// 设置图片
		setImageDescriptor(titleImage);

		filter = new ConnectorFilter();

		this.be = be;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets
	 * .Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		// 创建一个底层的Composite，并使用GridLayout布局
		Composite newComposite = new Composite(parent, SWT.NULL);
		newComposite.setLayout(new FillLayout());

		Composite client = new Composite(newComposite, SWT.NULL);
		GridLayout layoutClient = new GridLayout();
		layoutClient.numColumns = 2; // grid分为2列
		client.setLayout(layoutClient);

		Label searchLabel = new Label(client, SWT.NONE);
		searchLabel.setText("搜索: ");

		final Text searchText = new Text(client, SWT.BORDER | SWT.SEARCH);
		searchText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));

		searchText.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				filter.setSearchText(searchText.getText());

				viewer.refresh();
				// 展现第二层
				viewer.expandToLevel(2);

				if (viewer.getSelection().isEmpty()) {
					setPageComplete(false);
				}
			}
		});

		// 占位
		new Label(client, SWT.NONE);

		// 创建TreeViewer，将其放入composite中
		viewer = new TreeViewer(client, SWT.BORDER);
		viewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));
		viewer.addFilter(filter);

		// tableViewer获取数据
		List<ITreeElement> elements = (List<ITreeElement>) RuntimeTreeViewerFactory.reloadActorTree();

		if (elements != null && elements.size() > 0) {
			// 设置内容提供器
			viewer.setContentProvider(new TreeViewerContentProvider());

			// 设置标签提供器
			viewer.setLabelProvider(new ActorTreeViewerLabelProvider());

			// 设置内容
			viewer.setInput(elements);
		}

		viewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(DoubleClickEvent event) {
				// 根据所选的连接器的id动态的加载向导页所需要的页面
				IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
				ITreeElement selectElement = (ITreeElement) selection.getFirstElement();

				if (viewer.getExpandedState(selectElement)) {
					// 如果展开就收起
					viewer.collapseToLevel(selectElement, 1);
				} else {
					// 展现下一层文件夹
					viewer.expandToLevel(selectElement, 1);
				}
			}
		});

		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				// 根据所选的连接器的id动态的加载向导页所需要的页面
				IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
				ITreeElement element = (ITreeElement) selection.getFirstElement();

				// 改变显示规则
				if (element != null && !element.getRealPath().equals("")) {
					setPageComplete(true);

					// 先将之前加入的删除掉
					if (wizard.getPageCount() > 2) {
						for (int i = 2; i < wizard.getPageCount();) {
							wizard.removePage(i);
						}
					}

					// 获取该connetor
					connector = RuntimeTreeViewerFactory.getActorConnector(element.getId());

					if (connector != null) {
						// 获取所有的page
						EList<Page> pages = connector.getPage();
						if (pages != null && pages.size() > 0) {
							commonConnectotWizardPages = new CommonNewConnectorWizardPage[pages.size()];

							for (int i = 0; i < pages.size(); i++) {
								Page page = pages.get(i);
								commonConnectotWizardPage = new CommonNewConnectorWizardPage(be, 
										"commonConnectotWizardPage", page.getName(), page.getNote(), 
										null, page, connector);
								wizard.addPage(commonConnectotWizardPage);

								commonConnectotWizardPages[i] = commonConnectotWizardPage;
							}
						}

						// 获取所有的输出参数
//						if (connector.getOutput() != null) {
//							EList<Output> outputs = connector.getOutput();
//							outputConnectorWizardPage = new OutputNewConnectorWizardPage(be, 
//									"outputConnectorWizardPage", "输出配置", "映射连接器的输出到流程变量中", null, outputs);
//							wizard.addPage(outputConnectorWizardPage);
//						}
					}
				} else {
					setPageComplete(false);
				}
				// MessageDialog.openInformation(getShell(), null,
				// wizard.getPages().length + "");
			}
		});

		// 初始化的时候先使‘完成’按钮不可用
		setPageComplete(false);

		// 必须要的，将新的Composite放入
		setControl(newComposite);
	}

	public CommonNewConnectorWizardPage getCommonConnectotWizardPage() {
		return commonConnectotWizardPage;
	}

	public void setCommonConnectotWizardPage(CommonNewConnectorWizardPage commonConnectotWizardPage) {
		this.commonConnectotWizardPage = commonConnectotWizardPage;
	}

//	public OutputNewConnectorWizardPage getOutputConnectorWizardPage() {
//		return outputConnectorWizardPage;
//	}
//
//	public void setOutputConnectorWizardPage(OutputNewConnectorWizardPage outputConnectorWizardPage) {
//		this.outputConnectorWizardPage = outputConnectorWizardPage;
//	}

	public CommonNewConnectorWizardPage[] getCommonConnectotWizardPages() {
		return commonConnectotWizardPages;
	}

	public void setCommonConnectotWizardPages(CommonNewConnectorWizardPage[] commonConnectotWizardPages) {
		this.commonConnectotWizardPages = commonConnectotWizardPages;
	}

	public ConnectorDefinition getConnector() {
		return connector;
	}

	public void setConnector(ConnectorDefinition connector) {
		this.connector = connector;
	}

	@Override
	public IWizardPage getPreviousPage() {
		return null;
	}
}
