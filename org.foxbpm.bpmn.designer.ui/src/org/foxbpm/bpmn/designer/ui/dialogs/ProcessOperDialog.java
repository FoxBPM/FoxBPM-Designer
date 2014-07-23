package org.foxbpm.bpmn.designer.ui.dialogs;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.eclipse.bpmn2.Definitions;
import org.eclipse.bpmn2.DocumentRoot;
import org.eclipse.bpmn2.Process;
import org.eclipse.bpmn2.modeler.core.utils.ModelUtil;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.foxbpm.bpmn.designer.base.utils.EMFUtil;
import org.foxbpm.bpmn.designer.base.utils.FileUtil;
import org.foxbpm.bpmn.designer.base.utils.FoxBPMDesignerUtil;
import org.foxbpm.bpmn.designer.base.utils.ZipUtils;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;
import org.restlet.data.ChallengeScheme;
import org.restlet.representation.InputRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class ProcessOperDialog extends TitleAreaDialog {
	private DataBindingContext m_bindingContext;
	private Table table;
	private Text curprotext;
	private List<ProcessTo> processTos;
	private TableViewer tableViewer;
	private IFile iFile;
	private String curProcessId;
	private String dbid = null;
	private Button createNewButton;
	private Button publishButton;
	private Button updateButton;
	private Button downloadButton;
	private Button deleteButton;
	private IPackageFragmentRoot iPackageFragmentRoot;
	private IFolder iFolder;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public ProcessOperDialog(Shell parentShell, IFile iFile) {
		super(parentShell);
		setShellStyle(SWT.DIALOG_TRIM | SWT.RESIZE | SWT.PRIMARY_MODAL);
		setHelpAvailable(false);
		this.iFile = iFile;
		this.curProcessId = iFile.getName();
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public ProcessOperDialog(Shell parentShell, IPackageFragmentRoot iPackageFragmentRoot) {
		super(parentShell);
		setShellStyle(SWT.DIALOG_TRIM | SWT.RESIZE | SWT.PRIMARY_MODAL);
		setHelpAvailable(false);
		this.iFile = null;
		this.curProcessId = null;
		this.iPackageFragmentRoot = iPackageFragmentRoot;
	}
	
	public ProcessOperDialog(Shell parentShell, IFolder iFolder) {
		super(parentShell);
		setShellStyle(SWT.DIALOG_TRIM | SWT.RESIZE | SWT.PRIMARY_MODAL);
		setHelpAvailable(false);
		this.iFile = null;
		this.curProcessId = null;
		this.iFolder = iFolder;
	}
	
	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setMessage("流程的发布与更新操作");
		setTitle("流程发布/更新");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		GridLayout gl_container = new GridLayout(2, false);
		gl_container.marginBottom = 5;
		gl_container.marginRight = 5;
		gl_container.marginLeft = 5;
		container.setLayout(gl_container);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		Label label = new Label(container, SWT.NONE);
		label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		label.setText("当前选中流程");

		curprotext = new Text(container, SWT.BORDER | SWT.READ_ONLY);
		curprotext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		curprotext.setText(curProcessId==null?"":curProcessId);

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		lblNewLabel.setText("流程列表");

		tableViewer = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
		tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				allButtonsDisable();
				
				IStructuredSelection iStructuredSelection = (IStructuredSelection) tableViewer.getSelection();
				Object selected = iStructuredSelection.getFirstElement();
				if(iFile==null) {
					downloadButton.setEnabled(selected!=null);
				}else if(dbid==null) {
					publishButton.setEnabled(true);
					createNewButton.setEnabled(true);
				}
				else if(selected!= null && ((ProcessTo)selected).getProcessId().equals(dbid)) {
					updateButton.setEnabled(true);
					deleteButton.setEnabled(true);
					createNewButton.setEnabled(true);
				}else {
					createNewButton.setEnabled(true);
				}
			}
		});
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn idColumn = tableViewerColumn.getColumn();
		idColumn.setMoveable(true);
		idColumn.setWidth(100);
		idColumn.setText("流程编号");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn nameColumn = tableViewerColumn_2.getColumn();
		nameColumn.setMoveable(true);
		nameColumn.setWidth(100);
		nameColumn.setText("流程名称");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn processKeyColumn = tableViewerColumn_1.getColumn();
		processKeyColumn.setMoveable(true);
		processKeyColumn.setWidth(150);
		processKeyColumn.setText("流程唯一键");

		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn versionColumn = tableViewerColumn_3.getColumn();
		versionColumn.setMoveable(true);
		versionColumn.setWidth(80);
		versionColumn.setText("版本号");

		Composite composite = new Composite(container, SWT.NONE);
		GridLayout gl_composite = new GridLayout(1, false);
		gl_composite.marginWidth = 0;
		gl_composite.verticalSpacing = 1;
		gl_composite.horizontalSpacing = 0;
		gl_composite.marginHeight = 0;
		composite.setLayout(gl_composite);

		createNewButton = new Button(composite, SWT.NONE);
		GridData gd_createNewButton = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_createNewButton.widthHint = 60;
		createNewButton.setLayoutData(gd_createNewButton);
		createNewButton.setBounds(0, 0, 80, 27);
		createNewButton.setText("创建");
		createNewButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				IStructuredSelection selection = (IStructuredSelection) tableViewer.getSelection();
				ProcessTo processTo = (ProcessTo) selection.getFirstElement();
				
				IInputValidator inputValidator = new IInputValidator() {
					@Override
					public String isValid(String newText) {
						if (newText==null || newText.isEmpty())
							return "文件名不能为空";
						if (newText.equals(iFile.getName())) {
							return "文件名称不能相同";
						}
						return null;
					}
						
				};
				
				InputDialog inputDialog = new InputDialog(null, "快速创建流程定义", "请输入流程定义的文件名", "Copy of " + iFile.getName(), inputValidator);
				if(inputDialog.open()==inputDialog.OK) {
					File sourceFile = new File(iFile.getLocationURI().getPath());
					File targetFile = new File(iFile.getParent().getLocationURI().getPath() + "/" + inputDialog.getValue());
					
					File sourcePNGFile = new File(iFile.getLocationURI().getPath().substring(0, iFile.getLocationURI().getPath().lastIndexOf(".")+1) + "png");
					File targetPNGFile = new File(iFile.getParent().getLocationURI().getPath() + "/" + inputDialog.getValue().substring(0, inputDialog.getValue().lastIndexOf(".")+1) + "png");
					try {
						FileUtil.copyFile(sourceFile, targetFile);
						FileUtil.copyFile(sourcePNGFile, targetPNGFile);
						
						//文件置空dbid
						Resource resource = EMFUtil.readEMFFile(iFile.getParent().getLocationURI().getPath() + "/" + inputDialog.getValue());
						DocumentRoot documentRoot = (DocumentRoot) resource.getContents().get(0);
						Definitions definitions = documentRoot.getDefinitions();
						Process process = (Process) definitions.getRootElements().get(0);
						process.eSet(FoxBPMPackage.Literals.DOCUMENT_ROOT__DBID, null);
						resource.save(null);
						
						iFile.getParent().refreshLocal(IResource.DEPTH_INFINITE, null);
						MessageDialog.openInformation(null, "提示", "创建流程成功");
					} catch (IOException e) {
						MessageDialog.openInformation(null, "提示", "创建流程失败，失败原因是:\n" + e.getMessage());
						e.printStackTrace();
					} catch (CoreException e) {
						MessageDialog.openInformation(null, "提示", "创建流程失败，失败原因是:\n" + e.getMessage());
						e.printStackTrace();
					}
				}
			}
		});
		
		publishButton = new Button(composite, SWT.NONE);
		publishButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		publishButton.setText("发布");
		publishButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				publishProcess();
				initTreeViewer();
				initDataBindings();
				tableViewer.refresh();
			}
		});

		updateButton = new Button(composite, SWT.NONE);
		updateButton.setEnabled(false);
		updateButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		updateButton.setText("更新");
		updateButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				if(tableViewer.getSelection()==null) {
					MessageDialog.openInformation(null, "提示", "请先选中一条流程");
					return;
				}
				IStructuredSelection selection = (IStructuredSelection) tableViewer.getSelection();
				ProcessTo processTo = (ProcessTo) selection.getFirstElement();
				updateProcess(processTo);
				initTreeViewer();
				initDataBindings();
				tableViewer.refresh();
			}
		});
		
		downloadButton = new Button(composite, SWT.NONE);
		downloadButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		downloadButton.setText("下载");
		downloadButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				IStructuredSelection selection = (IStructuredSelection) tableViewer.getSelection();
				ProcessTo processTo = (ProcessTo) selection.getFirstElement();
				
				IInputValidator inputValidator = new IInputValidator() {
					@Override
					public String isValid(String newText) {
						IFolder folder = null;
						if(iPackageFragmentRoot!=null) {
							folder = (IFolder) iPackageFragmentRoot.getResource();
						}else if(iFolder!=null) {
							folder = iFolder;
						}
						
						if (newText==null || newText.isEmpty())
							return "文件名不能为空";
						if (!newText.endsWith(".bpmn")) {
							return "后缀名须为.bpmn";
						}
						if (folder.getFile(newText).exists()) {
							return "已存在该名称的流程定义";
						}
						return null;
					}
						
				};
				
				InputDialog inputDialog = new InputDialog(null, "下载流程定义", "请输入流程定义的文件名", "FileName.bpmn", inputValidator);
				if(inputDialog.open()==inputDialog.OK) {
					try {
						ClientResource client = new ClientResource(FoxBPMDesignerUtil.getServicePathPath() + "model/resource/" + processTo.getDeploymentId() + "/" + processTo.getResourceName());
						client.setChallengeResponse(ChallengeScheme.HTTP_BASIC, "111", "111");
						
						String fileName = null;
						if(iPackageFragmentRoot!=null) {
							fileName = iPackageFragmentRoot.getResource().getLocationURI().getPath() + "/" + inputDialog.getValue();
						}else if(iFolder!=null) {
							fileName = iFolder.getLocationURI().getPath() + "/" + inputDialog.getValue();;
						}
						Representation result = client.get();
						InputStream inputStream = result.getStream();
						
						BufferedInputStream inBuff = null;
						BufferedOutputStream outBuff = null;
						try {
							// 新建文件输入流并对它进行缓冲
							inBuff = new BufferedInputStream(inputStream);

							// 新建文件输出流并对它进行缓冲
							outBuff = new BufferedOutputStream(new FileOutputStream(new File(fileName)));

							// 缓冲数组
							byte[] b = new byte[1024 * 5];
							int len;
							while ((len = inBuff.read(b)) != -1) {
								outBuff.write(b, 0, len);
							}
							// 刷新此缓冲的输出流
							outBuff.flush();
						} finally {
							// 关闭流
							if (inBuff != null)
								inBuff.close();
							if (outBuff != null)
								outBuff.close();
						}
						
						if(iPackageFragmentRoot!=null) {
							iPackageFragmentRoot.getCorrespondingResource().refreshLocal(IResource.DEPTH_INFINITE, null);
						}else if(iFolder!=null) {
							iFolder.refreshLocal(IResource.DEPTH_INFINITE, null);
						}
						MessageDialog.openInformation(null, "提示", "下载流程定义成功");
					} catch (IOException e) {
						MessageDialog.openInformation(null, "提示", "下载流程定义失败，失败原因是:\n" + e.getMessage());
						e.printStackTrace();
					} catch (CoreException e) {
						MessageDialog.openInformation(null, "提示", "下载流程定义失败，失败原因是:\n" + e.getMessage());
						e.printStackTrace();
					}
				}
			}
		});
		
		deleteButton = new Button(composite, SWT.NONE);
		deleteButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		deleteButton.setText("删除");
		deleteButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				if(tableViewer.getSelection()==null) {
					MessageDialog.openInformation(null, "提示", "请先选中一条流程定义");
					return;
				}
				IStructuredSelection selection = (IStructuredSelection) tableViewer.getSelection();
				ProcessTo processTo = (ProcessTo) selection.getFirstElement();
				deleteProcess(processTo);
				initTreeViewer();
				initDataBindings();
				tableViewer.refresh();
			}
		});

		initTreeViewer();
		m_bindingContext = initDataBindings();
		return area;
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		Button button = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		button.setText("确定");
		Button button_1 = createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
		button_1.setText("取消");
		m_bindingContext = initDataBindings();
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(561, 473);
	}

	private void publishProcess() {
		dbid = null;
		ClientResource client = new ClientResource(FoxBPMDesignerUtil.getServicePathPath() + "model/deployments");
		client.setChallengeResponse(ChallengeScheme.HTTP_BASIC, "111", "111");
		File file = null;
		try {
			String processPath = iFile.getLocationURI().getPath();
			String pngPath = processPath.substring(0, processPath.lastIndexOf(".")) + ".png";
			String[] files = new String[]{processPath, pngPath};
			file = File.createTempFile(System.currentTimeMillis() + "process", ".zip");
			ZipUtils.zipMultiFile(files, file);

			InputStream input = new FileInputStream(file);

			Representation deployInput = new InputRepresentation(input);
			Representation result = client.post(deployInput);
			dbid = result.getText();
			
			//往文件里面写入dbid
			Resource resource = EMFUtil.readEMFFile(iFile.getLocationURI().getPath());
			DocumentRoot documentRoot = (DocumentRoot) resource.getContents().get(0);
			Definitions definitions = documentRoot.getDefinitions();
			Process process = (Process) definitions.getRootElements().get(0);
			process.eSet(FoxBPMPackage.Literals.DOCUMENT_ROOT__DBID, dbid);
			try {
				resource.save(null);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			iFile.getParent().refreshLocal(IResource.DEPTH_INFINITE, null);
			if(dbid!=null) {
				MessageDialog.openInformation(null, "提示", "发布流程定义成功");
			}
		} catch (IOException e) {
			MessageDialog.openInformation(null, "提示", "发布流程定义失败，失败原因是:\n" + e.getMessage());
			e.printStackTrace();
		} catch (CoreException e) {
			MessageDialog.openInformation(null, "提示", "发布流程定义失败，失败原因是:\n" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void updateProcess(ProcessTo processTo) {
		ClientResource client = new ClientResource(FoxBPMDesignerUtil.getServicePathPath() + "model/deployment/" + processTo.getDeploymentId());
		client.setChallengeResponse(ChallengeScheme.HTTP_BASIC, "111", "111");
		File file = null;
		try {
			String processPath = iFile.getLocationURI().getPath();
			String pngPath = processPath.substring(0, processPath.lastIndexOf(".")) + ".png";
			String[] files = new String[]{processPath, pngPath};
			file = File.createTempFile(System.currentTimeMillis() + "process", ".zip");
			ZipUtils.zipMultiFile(files, file);

			InputStream input = new FileInputStream(file);

			Representation deployInput = new InputRepresentation(input);
			Representation result = client.put(deployInput);
			if(result.getText().equals("SUCCESS")) {
				MessageDialog.openInformation(null, "提示", "更新流程定义成功");
			}
		} catch (IOException e) {
			MessageDialog.openInformation(null, "提示", "更新流程定义失败，失败原因是:\n" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void deleteProcess(ProcessTo processTo) {
		boolean b = MessageDialog.openConfirm(null, "提示", "即将删除此流程定义及和该流程相关的数据，是否确认该操作?");
		if(b) {
			ClientResource client = new ClientResource(FoxBPMDesignerUtil.getServicePathPath() + "model/deployment/" + processTo.getDeploymentId());
			client.setChallengeResponse(ChallengeScheme.HTTP_BASIC, "111", "111");
			File file = null;
			try {
				String processPath = iFile.getLocationURI().getPath();
				String pngPath = processPath.substring(0, processPath.lastIndexOf(".")) + ".png";
				String[] files = new String[]{processPath, pngPath};
				file = File.createTempFile(System.currentTimeMillis() + "process", ".zip");
				ZipUtils.zipMultiFile(files, file);

				Representation result = client.delete();
				if(result.getText().equals("SUCCESS")) {
					MessageDialog.openInformation(null, "提示", "删除流程定义成功");
				}
				
			} catch (IOException e) {
				MessageDialog.openInformation(null, "提示", "删除流程定义失败，失败原因是:\n" + e.getMessage());
				e.printStackTrace();
			}
		} 
	}
	
	private void initTreeViewer() {
		Comparator<ProcessTo> comparator = new Comparator<ProcessTo>() {
			@Override
			public int compare(ProcessTo p1, ProcessTo p2) {
				if(p1.getVersion()>p2.getVersion()) {
					return 0;
				}else {
					return 1;
				}
			}
		};
		allButtonsDisable();
		processTos = new ArrayList<ProcessTo>();
		
		if(iFile!=null) {
			Definitions definitions = ModelUtil.getDefinitions(EMFUtil.readEMFFile(iFile.getLocationURI().getPath()));
			Process process = (Process) definitions.getRootElements().get(0);
			dbid = process.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__DBID)==null?null:process.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__DBID).toString();
			if(dbid == null) {
				Object processDbid = process.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__DBID);
				dbid = processDbid==null?null:processDbid.toString();
				publishButton.setEnabled(true);
			}
			ClientResource client = null;
			client = new ClientResource(FoxBPMDesignerUtil.getServicePathPath() + "process-definitions?key=" + process.getId());
			client.setChallengeResponse(ChallengeScheme.HTTP_BASIC,"111", "111");
			Representation result = client.get();
			try {
				ObjectMapper objectMapper = new ObjectMapper();
				String resultString = result.getText();
				JsonNode object= objectMapper.readTree(resultString);
				System.out.println(resultString);
				ArrayNode dataArray = (ArrayNode)object.get("data");
				
				for(JsonNode json :dataArray){
					ProcessTo processTo = new ProcessTo();
					processTo.setProcessId(json.get("id")==null?"":json.get("id").asText());
					processTo.setProcessKey(json.get("key")==null?"":json.get("key").asText());
					processTo.setProcessName(json.get("name")==null?"":json.get("name").asText());
					processTo.setDeploymentId(json.get("deploymentId")==null?"":json.get("deploymentId").asText());
					processTo.setVersion(json.get("version")==null?-1:json.get("version").asInt());
					processTos.add(processTo);
					Collections.sort(processTos, comparator);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			createNewButton.setEnabled(true);
		}else {
			allButtonsDisable();
			ClientResource client = new ClientResource(FoxBPMDesignerUtil.getServicePathPath() + "process-definitions");
			client.setChallengeResponse(ChallengeScheme.HTTP_BASIC,"111", "111");
			Representation result = client.get();
			try {
				ObjectMapper objectMapper = new ObjectMapper();
				String resultString = result.getText();
				JsonNode object= objectMapper.readTree(resultString);
				System.out.println(resultString);
				ArrayNode dataArray = (ArrayNode)object.get("data");
				
				for(JsonNode json :dataArray){
					ProcessTo processTo = new ProcessTo();
					processTo.setProcessId(json.get("id")==null?"":json.get("id").asText());
					processTo.setProcessKey(json.get("key")==null?"":json.get("key").asText());
					processTo.setProcessName(json.get("name")==null?"":json.get("name").asText());
					processTo.setDeploymentId(json.get("deploymentId")==null?"":json.get("deploymentId").asText());
					processTo.setVersion(json.get("version")==null?-1:json.get("version").asInt());
					processTo.setResourceName(json.get("resourceName")==null?"":json.get("resourceName").asText());
					processTos.add(processTo);
					Collections.sort(processTos, comparator);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			createNewButton.setEnabled(false);
		}
	}
	
	private void allButtonsDisable() {
		createNewButton.setEnabled(false);
		publishButton.setEnabled(false);
		updateButton.setEnabled(false);
		deleteButton.setEnabled(false);
		downloadButton.setEnabled(false);
	}
	
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		IObservableMap[] observeMaps = PojoObservables.observeMaps(listContentProvider.getKnownElements(), ProcessTo.class, new String[]{"processKey", "processName", "processId", "version"});
		tableViewer.setLabelProvider(new ObservableMapLabelProvider(observeMaps));
		tableViewer.setContentProvider(listContentProvider);
		//
		IObservableList selfList = Properties.selfList(ProcessTo.class).observe(processTos);
		tableViewer.setInput(selfList);
		//
		return bindingContext;
	}
}
