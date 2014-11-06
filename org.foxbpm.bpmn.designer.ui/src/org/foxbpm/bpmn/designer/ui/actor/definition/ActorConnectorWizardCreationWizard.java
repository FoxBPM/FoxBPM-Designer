package org.foxbpm.bpmn.designer.ui.actor.definition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jdt.internal.core.PackageFragment;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.foxbpm.bpmn.designer.base.utils.EMFUtil;
import org.foxbpm.bpmn.designer.base.utils.FileUtil;
import org.foxbpm.bpmn.designer.base.utils.FoxBPMDesignerUtil;
import org.foxbpm.bpmn.designer.ui.connector.definition.CreateFlowConnectorJava;
import org.foxbpm.bpmn.designer.ui.utils.DefinitionConnectorUtil;
import org.foxbpm.model.config.connector.ConnectorDefinition;
import org.foxbpm.model.config.connectormenu.Connector;
import org.foxbpm.model.config.connectormenu.ConnectormenuFactory;
import org.foxbpm.model.config.connectormenu.Menu;
import org.foxbpm.model.config.connectormenu.Node;

public class ActorConnectorWizardCreationWizard extends Wizard implements INewWizard {
	private ConfigureActorConnectorWizardPage ccwd;
	private ConnectorDefinition newConnector;
	private IStructuredSelection selection;
	private IWorkspaceRoot fWorkspaceRoot;
	private String projectName;
	private String packagePath;
	private String packageAbsolutePath;
	
	/**
	 * 添加时构造函数
	 */
	public ActorConnectorWizardCreationWizard() {
	}

	/**
	 * 编辑时构造函数
	 * 
	 * @param connector
	 */
	public ActorConnectorWizardCreationWizard(ConnectorDefinition newConnector) {
		this.newConnector = newConnector;
		this.fWorkspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
	}

	@Override
	public void addPages() {
		StringBuffer packageName = new StringBuffer();
		boolean isDefault = false;
		TreeSelection treeSelection = (TreeSelection) this.selection;
		if(treeSelection!=null) {
			if(treeSelection.getFirstElement() instanceof PackageFragment) {
				PackageFragment packageFragment = (PackageFragment) treeSelection.getFirstElement();
				projectName = packageFragment.getResource().getProject().getName();
				if(projectName.equals("foxbpm-connector")) {
					isDefault = true;
				}
				for (int i=0;i<packageFragment.names.length;i++) {
					packageName.append(packageFragment.names[i]+".");
				}
				this.packagePath = packageFragment.getPath().toString().substring(1).substring(packageFragment.getPath().toString().substring(1).indexOf("/")+1);
				this.packageAbsolutePath = packageFragment.getResource().getLocation().toFile().getAbsolutePath();
			}else{
				MessageDialog.openInformation(null, "提示", "暂不支持在包外的目录创建连接器或选择器");
				return;
			}
		}
		if (newConnector == null)
			ccwd = new ConfigureActorConnectorWizardPage(true, "创建选择器", packageName.toString(), isDefault);
		else
			ccwd = new ConfigureActorConnectorWizardPage(true, "编辑选择器", newConnector, packageName.toString(), isDefault);
		addPage(ccwd);
	}

	@Override
	public boolean performFinish() {
		if (ccwd.getOpenType().equals("edit")) {
			boolean b = MessageDialog.openConfirm(getShell(), "提示", "使用此编辑方式会导致处理者选择器java文件重写，确定要这么做吗？");
			if (!b)
				return false;
		}

		// As of here we preparing to save the model content

		// 下面写新连接器代码保存,在保存之前只要维护好里面的menuConnector就可以了。直接保存xml就不会有问题
		// 先得到连接器对应的MenuConnector
		ConnectorDefinition connector = ((ConfigureActorConnectorWizardPage) ccwd).getNewConnector();
		// 取得连接器之后立马改掉Icon
		connector.setIcon(connector.getId() + "." + FileUtil.getExtensionName(FileUtil.getFileName(connector.getIcon())));
		Connector menuConnector = ConnectormenuFactory.eINSTANCE.createConnector();
		menuConnector.setId(connector.getId());
		menuConnector.setName(connector.getName());
		menuConnector.setNote(connector.getNote());
		menuConnector.setIco(connector.getIcon());
		menuConnector.setPackage(connector.getDefinitionImpl().getPackageName().replace(".", "/"));
		// node根据id可以获取到对应的menu里面的哪个Node,然后再在对应的Node下面加上menuConnector就可以保存了
		Menu menu = ((ConfigureActorConnectorWizardPage) ccwd).getMenu();
		Node node = ((ConfigureActorConnectorWizardPage) ccwd).getNode();
		// 下面得到menu里面真正的node
		for (Node nod : EMFUtil.getAll(menu.eResource(), Node.class)) {
			if (nod.getId().equals(node.getId())) {
				node = nod;
				break;
			}
		}

		// 如果是创建连接器
		if (((ConfigureActorConnectorWizardPage) ccwd).getOpenType().equals("create")) {
			/**
			 * 验证连接器ID唯一
			 */
			Iterator<Node> iter = menu.getActorConnector().getNode().iterator();
			while (iter.hasNext()) {
				Node nd = iter.next();
				for (Connector mc : nd.getConnector()) {
					if (mc.getId() != null) {
						if (mc.getId().equals(connector.getId())) {
							MessageDialog.openWarning(null, "提示", "已存在此ID的连接器，请更换ID!");
							return false;
						}
					}
				}
			}

			node.getConnector().add(menuConnector);
		}

		// 如果是编辑连接器
		if (((ConfigureActorConnectorWizardPage) ccwd).getOpenType().equals("edit")) {
			/*
			 * File file = new
			 * File(ConnectorUtil.getConnectorPathById(ccwd.getConnector
			 * ().getConnectorId())); deleteFile(file);
			 */
			int idx = 0;
			List<Connector> menuConnectors = new ArrayList<Connector>();
			for (Connector menuConnector2 : node.getConnector()) {
				if (menuConnector2.getId().equals(menuConnector.getId())) {
					menuConnectors.add(menuConnector2);
					idx = node.getConnector().indexOf(menuConnector2);
				}
			}
			node.getConnector().removeAll(menuConnectors);
			node.getConnector().add(idx, menuConnector);
		}

		// 传入getNewCreateCategoryID()是为了保存哪些是新建的分类。供保存方法识别并更新保存到xml
		if (menu != null) {
			DefinitionConnectorUtil.saveActorConnectorMenu(menu, ((ConfigureActorConnectorWizardPage) ccwd).getNewCreateCategoryID(),
					((ConfigureActorConnectorWizardPage) ccwd).getConnectorMenuPath());
		}

		// Register the XMI resource factory for the .website extension

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xml", new XMIResourceFactoryImpl());

		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();

		// Create a resource
		String path = DefinitionConnectorUtil.getActorConnectorXmlPath(packageAbsolutePath, connector);
		XMIResource resource = (XMIResource) resSet.createResource(URI.createFileURI(path));
		resource.setEncoding("UTF-8");

		resource.getContents().add(connector);
		// Now save the content.
		try {
			resource.save(Collections.EMPTY_MAP);

			// 一次读取1024个字节，当byteread为-1时表示文件已经读完
			int byteread = 0;// 读取的位数
			byte[] buffer = new byte[1024];
			// 写入图标文件
			FileInputStream fis = null;
			if (((ConfigureActorConnectorWizardPage) ccwd).getIconPath()==null || ((ConfigureActorConnectorWizardPage) ccwd).getIconPath().equals("connector.png")) {
				// 打开原文件（connector图标）
				fis = new FileInputStream(DefinitionConnectorUtil.getDefaultActorConnectorIcoPath(((ConfigureActorConnectorWizardPage) ccwd).getConnectorMenuPath()));
			}else {
				// 打开原文件（connector图标）
				fis = new FileInputStream(((ConfigureActorConnectorWizardPage) ccwd).getIconPath());
			}
			// 打开连接到目标文件的输出流
			File outfile = new File(packageAbsolutePath + "/" + connector.getId() + "/" + connector.getIcon());
			FileOutputStream outStream = new FileOutputStream(outfile);

			while ((byteread = fis.read(buffer)) != -1) {
				// 将读取的字节写入输出流
				outStream.write(buffer, 0, byteread);
			}
			fis.close();
			outStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (((ConfigureActorConnectorWizardPage) ccwd).getOpenType().equals("create"))
			MessageDialog.openInformation(null, "提示", "处理者选择器创建成功");
		if (((ConfigureActorConnectorWizardPage) ccwd).getOpenType().equals("edit"))
			MessageDialog.openInformation(null, "提示", "处理者选择器修改成功");
		// 生成java代码
		InputStream is = CreateFlowConnectorJava.CreateActorConnectorJavaClassReturnInputStream(connector);
		File file = new File(packageAbsolutePath + "/" + connector.getId() + "/" + connector.getId() + ".java");
		FileOutputStream javafileOutputStream = null;
		try {
			javafileOutputStream = new FileOutputStream(file);
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}

		// 一次读取1024个字节，当byteread为-1时表示文件已经读完
		int byteread = 0;// 读取的位数
		byte[] buffer = new byte[1024];

		try {
			while ((byteread = is.read(buffer)) != -1) {
				// 将读取的字节写入输出流
				javafileOutputStream.write(buffer, 0, byteread);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			javafileOutputStream.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// 刷新连接器目录
		FoxBPMDesignerUtil
						.refresh(projectName, packagePath, org.eclipse.core.internal.resources.Resource.FOLDER);
		
//		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
//		try {
//			// 打开编辑器
//			IFileStore fileStore = EFS.getLocalFileSystem().getStore(new Path(file.getAbsolutePath()));
//			IDE.openEditorOnFileStore(page, fileStore);
//		} catch (PartInitException e) {
//		}
		
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		IFile ifile = (IFile) project.getFile(Path.fromOSString(packagePath + "/" + connector.getId() + "/" + file.getName()));

		try {
			// 打开编辑器
			IDE.openEditor(page, ifile);
		} catch (PartInitException e) {
		}
		return true;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;		
	}

	public IWorkspaceRoot getfWorkspaceRoot() {
		return fWorkspaceRoot;
	}
}
