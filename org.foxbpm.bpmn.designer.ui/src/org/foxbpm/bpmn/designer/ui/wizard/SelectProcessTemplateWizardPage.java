/**
 * Copyright 1996-2014 FoxBPM ORG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * @author MAENLIANG
 */
package org.foxbpm.bpmn.designer.ui.wizard;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

import org.eclipse.bpmn2.modeler.core.utils.ModelUtil.Bpmn2DiagramType;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.foxbpm.bpmn.designer.base.utils.WizardUtil;

/**
 * 选择流程定义模版
 * 
 * @author MAENLIANG
 * 
 */
public class SelectProcessTemplateWizardPage extends WizardPage {
	private Bpmn2DiagramType diagramType = Bpmn2DiagramType.NONE;
	private final ISelection selection;
	private String fixDiagramType;
	private Map<String, Object> map;
	private Text descText;
	private Combo chooseModelCombo;
	private Label modelImageLabel;
	private String modelPath;
	
	/**
	 * Create the wizard.
	 */
	public SelectProcessTemplateWizardPage(ISelection selection) {
		super("wizardPage");
		setTitle("创建向导");
		setDescription("请选择一个需要创建的流程定义模板");
		this.selection = selection;
	}
	
	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);
		
		Point sz = parent.getSize();
		int labelWidth = (int) (0.5 * sz.x);
		GridData data;
		
		setControl(container);
		
		Label chooseModelLabel = new Label(container, SWT.NONE);
		chooseModelLabel.setText("请选择一个模板：");
		
		chooseModelCombo = new Combo(container, SWT.READ_ONLY);
		map = WizardUtil.getModelInfoForWizard(chooseModelCombo);
		chooseModelCombo.setItems((String[]) map.get("comboStrs"));
		chooseModelCombo.select(0);
		setFixDiagramType(chooseModelCombo.getText());
		chooseModelCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		modelImageLabel = new Label(container, SWT.NONE);
		modelImageLabel.setAlignment(SWT.CENTER);
		modelImageLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 2, 1));
		
		Label descLabel = new Label(container, SWT.NONE);
		descLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		descLabel.setText("描述：");
		
		descText = new Text(container, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.MULTI);
		descText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		
		chooseModelCombo.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				changeSelection();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
		
		changeSelection();
	}
	
	@Override
	public boolean isPageComplete() {
		return fixDiagramType != null && !fixDiagramType.equals("");
	}
	
	@Override
	public boolean canFlipToNextPage() {
		return fixDiagramType != null && !fixDiagramType.equals("");
	}
	
	public String getFixDiagramType() {
		return fixDiagramType;
	}
	
	public void setFixDiagramType(String fixDiagramType) {
		this.fixDiagramType = fixDiagramType;
	}
	
	public void changeSelection() {
		setFixDiagramType(chooseModelCombo.getText());
		String modelId = (String) chooseModelCombo.getData(chooseModelCombo.getText());
		Map<String, Object> modelinfomap = (Map<String, Object>) map.get(modelId);
		String modelImage = null;
		modelImage = new String(modelinfomap.get("model_image_name").toString());
		String imagePath = WizardUtil.getModelPath() + modelId + "/" + modelImage;
		if (imagePath.equals("") || imagePath == null) {
			imagePath = WizardUtil.getModelPath() + "/process.gif";
		}
		try {
			modelImageLabel.setImage(new Image(PlatformUI.getWorkbench().getDisplay(), new ImageData(new FileInputStream(imagePath))));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		String modelDesc = null;
		String modelFile = null;
		modelDesc = new String(modelinfomap.get("model_description").toString());
		modelFile = new String(modelinfomap.get("model_file").toString());
		
		descText.setText(modelDesc);
		
		modelPath = WizardUtil.getModelPath() + modelId + "/" + modelFile;
		setModelPath(modelPath);
	}
	
	public String getModelPath() {
		return modelPath;
	}
	
	public void setModelPath(String modelPath) {
		this.modelPath = modelPath;
	}
	
}
