package org.foxbpm.bpmn.designer.ui.propertytab.usertask;

import org.eclipse.bpmn2.Activity;
import org.eclipse.bpmn2.Bpmn2Factory;
import org.eclipse.bpmn2.DataInput;
import org.eclipse.bpmn2.DataOutput;
import org.eclipse.bpmn2.ExtensionAttributeValue;
import org.eclipse.bpmn2.FormalExpression;
import org.eclipse.bpmn2.MultiInstanceLoopCharacteristics;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl.SimpleFeatureMapEntry;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.foxbpm.bpmn.designer.core.runtime.AbstractFoxBPMComposite;
import org.foxbpm.bpmn.designer.ui.expdialog.ExpressionChangedEvent;
import org.foxbpm.bpmn.designer.ui.expdialog.FoxBPMExpViewer;
import org.foxbpm.bpmn.designer.ui.expdialog.IExpressionChangedListener;
import org.foxbpm.model.bpmn.foxbpm.Expression;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMFactory;
import org.foxbpm.model.bpmn.foxbpm.FoxBPMPackage;
import org.foxbpm.model.bpmn.foxbpm.LoopDataInputCollection;
import org.foxbpm.model.bpmn.foxbpm.LoopDataOutputCollection;

public class ActivityAdvancedPropertyComposite extends AbstractFoxBPMComposite {
	private Activity activity;
	private FoxBPMExpViewer inputDatasetViewer;//输入数据集
	private FoxBPMExpViewer inputItemViewer;//输入数据集
	private FoxBPMExpViewer outputItemViewer;//输入数据集
	private FoxBPMExpViewer outputDatasetViewer;//输入数据集
	private FoxBPMExpViewer fulfillConditionViewer;//输入数据集
	private MultiInstanceLoopCharacteristics multiInstanceLoopCharacteristics;
	private Expression inputDataExp = FoxBPMFactory.eINSTANCE.createExpression();
	private Expression outputDataExp = FoxBPMFactory.eINSTANCE.createExpression();
	private Expression inputDatasExp = FoxBPMFactory.eINSTANCE.createExpression();
	private Expression outputDatasExp = FoxBPMFactory.eINSTANCE.createExpression();
	private Expression completeExp = FoxBPMFactory.eINSTANCE.createExpression();
	private Button nullRadio;
	private Button multiInstanceRadio;
	private Composite multiComposite;
	private Composite detailComposite;
	private Button sequenceRadio;
	private Button conrurrentRadio;

	public ActivityAdvancedPropertyComposite(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public String setDescId() {
		return null;
	}

	@Override
	public Composite createUI(Composite parent) {
		Composite containerComposite=new Composite(parent, SWT.NONE);
		containerComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		containerComposite.setLayout(new GridLayout(1,false));
		
		detailComposite=new Composite(containerComposite, SWT.NONE);
		detailComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		detailComposite.setLayout(new GridLayout(2, false));
		
		nullRadio = new Button(detailComposite, SWT.RADIO);
		GridData gd_nullRadio = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_nullRadio.widthHint = 60;
		nullRadio.setLayoutData(gd_nullRadio);
		nullRadio.setText("无");
		nullRadio.setSelection(true);
		multiInstanceRadio = new Button(detailComposite, SWT.RADIO);
		GridData gd_multiInstanceRadio = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_multiInstanceRadio.widthHint = 60;
		multiInstanceRadio.setLayoutData(gd_multiInstanceRadio);
		multiInstanceRadio.setText("多实例");
		
		multiComposite=new Composite(containerComposite, SWT.NONE);
		multiComposite.setLayout(new GridLayout(4, false));
		multiComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		multiComposite.setVisible(false);//默认不可见
		
		conrurrentRadio = new Button(multiComposite, SWT.RADIO);
		GridData gd_conrurrentRadio = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_conrurrentRadio.widthHint = 60;
		conrurrentRadio.setLayoutData(gd_conrurrentRadio);
		conrurrentRadio.setText("并行");
		
		sequenceRadio = new Button(multiComposite, SWT.RADIO);
		GridData gd_sequenceRadio = new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1);
		gd_sequenceRadio.widthHint = 60;
		sequenceRadio.setLayoutData(gd_sequenceRadio);
		sequenceRadio.setText("顺序");
		
		Label inputDataSetLabel = new Label(multiComposite, SWT.NONE);
		inputDataSetLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		inputDataSetLabel.setAlignment(SWT.RIGHT);
		inputDataSetLabel.setText("输入数据集");
		inputDatasetViewer=new FoxBPMExpViewer(multiComposite, SWT.BORDER);
		Control control = inputDatasetViewer.getControl();
		control.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		
		Label inputItemLabel = new Label(multiComposite, SWT.NONE);
		inputItemLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		inputItemLabel.setText("输入项");
		inputItemViewer=new FoxBPMExpViewer(multiComposite, SWT.BORDER);
		Control control_1 = inputItemViewer.getControl();
		control_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label outputItemLabel = new Label(multiComposite, SWT.NONE);
		outputItemLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		outputItemLabel.setText("输出项");
		outputItemViewer=new FoxBPMExpViewer(multiComposite, SWT.BORDER);
		Control control_2 = outputItemViewer.getControl();
		control_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label outputDataSetLabel = new Label(multiComposite, SWT.NONE);
		outputDataSetLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		outputDataSetLabel.setAlignment(SWT.RIGHT);
		outputDataSetLabel.setText("输出数据集");
		outputDatasetViewer=new FoxBPMExpViewer(multiComposite, SWT.BORDER);
		Control control_3 = outputDatasetViewer.getControl();
		control_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		
		Label fulfillConditionLabel = new Label(multiComposite, SWT.NONE);
		fulfillConditionLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		fulfillConditionLabel.setAlignment(SWT.RIGHT);
		fulfillConditionLabel.setText("完成条件");
		fulfillConditionViewer=new FoxBPMExpViewer(multiComposite, SWT.BORDER);
		Control control_4 = fulfillConditionViewer.getControl();
		control_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		
		return parent;
	}

	@Override
	public void createUIBindings(EObject eObject) {
		activity=(Activity)eObject;
		
		multiInstanceLoopCharacteristics = (MultiInstanceLoopCharacteristics) activity.getLoopCharacteristics();
		
		if(multiInstanceLoopCharacteristics!=null && multiInstanceLoopCharacteristics.isIsSequential()) {
			sequenceRadio.setSelection(true);
			conrurrentRadio.setSelection(false);
		}else{
			conrurrentRadio.setSelection(true);
			sequenceRadio.setSelection(false);
		}
		
		sequenceRadio.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						multiInstanceLoopCharacteristics.setIsSequential(true);
					}
				});
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
		
		conrurrentRadio.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						multiInstanceLoopCharacteristics.setIsSequential(false);
					}
				});
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
		
		nullRadio.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				multiComposite.setVisible(false);
				
				inputDatasetViewer.cleanData();
				outputItemViewer.cleanData();
				inputItemViewer.cleanData();
				outputDatasetViewer.cleanData();
				fulfillConditionViewer.cleanData();
				
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						activity.setLoopCharacteristics(null);
					}
				});
			}
		});
		
		multiInstanceRadio.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				multiComposite.setVisible(true);
			}
		});
		
		
		if(multiInstanceLoopCharacteristics!=null) {
			nullRadio.setSelection(false);
			multiInstanceRadio.setSelection(true);
			multiComposite.setVisible(true);
			
			
			//输入数据项
			DataInput dataInput = multiInstanceLoopCharacteristics.getInputDataItem();
			if(dataInput!=null) {
				for (ExtensionAttributeValue extensionAttributeValue : dataInput.getExtensionValues()) {
					FeatureMap extensionElements = extensionAttributeValue.getValue();
					for (Entry entry : extensionElements) {
						if (entry.getValue() instanceof Expression) {
							Expression expression = (Expression) entry.getValue();
							inputDataExp = expression;
							inputItemViewer.setExpression(inputDataExp);
							break;
						}
					}
					
				}
			}
			
			//输出数据项
			DataOutput dataOutput = multiInstanceLoopCharacteristics.getOutputDataItem();
			if(dataOutput!=null) {
				for (ExtensionAttributeValue extensionAttributeValue : dataOutput.getExtensionValues()) {
					FeatureMap extensionElements = extensionAttributeValue.getValue();
					for (Entry entry : extensionElements) {
						if (entry.getValue() instanceof Expression) {
							Expression expression = (Expression) entry.getValue();
							outputDataExp = expression;
							outputItemViewer.setExpression(outputDataExp);
							break;
						}
					}
					
				}
			}
			
			if (multiInstanceLoopCharacteristics.getExtensionValues().size() > 0) {
				//输入数据集、输出数据集
				for (ExtensionAttributeValue extensionAttributeValue : multiInstanceLoopCharacteristics.getExtensionValues()) {

					FeatureMap extensionElements = extensionAttributeValue.getValue();
					for (Entry entry : extensionElements) {
						if (entry.getValue() instanceof LoopDataInputCollection) {
							LoopDataInputCollection loopDataInputCollection = (LoopDataInputCollection) entry.getValue();
							if(loopDataInputCollection.getExpression()!=null) {
								inputDatasExp = loopDataInputCollection.getExpression();
							}else {
								inputDatasExp.setName("");
								inputDatasExp.setValue("");
							}
							inputDatasetViewer.setExpression(inputDatasExp);
						}
						else if (entry.getValue() instanceof LoopDataOutputCollection) {
							LoopDataOutputCollection loopDataOutputCollection = (LoopDataOutputCollection) entry.getValue();
							if(loopDataOutputCollection.getExpression()!=null) {
								outputDatasExp = loopDataOutputCollection.getExpression();
							}else {
								outputDatasExp.setName("");
								outputDatasExp.setValue("");
							}
							outputDatasetViewer.setExpression(outputDatasExp);
						}
					}

				}
			}
			
			//完成表达式
 			FormalExpression expression = (FormalExpression) multiInstanceLoopCharacteristics.getCompletionCondition();
			if(expression!=null) {
				String name = expression.eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString();
				completeExp.setName(name);
				completeExp.setValue(expression.getBody());
				fulfillConditionViewer.setExpression(completeExp);
			}
		}
		
		inputItemViewer.seteObject(activity);
		inputItemViewer.addExpressionChangedListeners(new IExpressionChangedListener() {
			
			@Override
			public void expressionChanged(final ExpressionChangedEvent event) {
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						if(multiInstanceLoopCharacteristics==null) {
							multiInstanceLoopCharacteristics = Bpmn2Factory.eINSTANCE.createMultiInstanceLoopCharacteristics();
						}
						
						if (event.getFormalExpression() != null) {
							inputDataExp.setName(event.getFormalExpression().eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
							inputDataExp.setValue(event.getFormalExpression().getBody());
							DataInput dataInput = Bpmn2Factory.eINSTANCE.createDataInput();
							ExtensionAttributeValue extensionAttributeValue = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
							FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry(
									(org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.RESOURCE_FILTER__EXPRESSION, inputDataExp);
							extensionAttributeValue.getValue().add(extensionElementEntry);
							dataInput.getExtensionValues().add(extensionAttributeValue);
							multiInstanceLoopCharacteristics.setInputDataItem(dataInput);
						} else {
							inputDataExp.setName("");
							inputDataExp.setValue("");
							DataInput dataInput = Bpmn2Factory.eINSTANCE.createDataInput();
							ExtensionAttributeValue extensionAttributeValue = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
							FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry(
									(org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.RESOURCE_FILTER__EXPRESSION, inputDataExp);
							extensionAttributeValue.getValue().add(extensionElementEntry);
							dataInput.getExtensionValues().add(extensionAttributeValue);
							multiInstanceLoopCharacteristics.setInputDataItem(dataInput);
						}
						activity.setLoopCharacteristics(multiInstanceLoopCharacteristics);
						//传递表达式对象
						inputItemViewer.setExpression(inputDataExp);
					}
				});
			}
		});
		
		outputItemViewer.seteObject(activity);
		outputItemViewer.addExpressionChangedListeners(new IExpressionChangedListener() {
			
			@Override
			public void expressionChanged(final ExpressionChangedEvent event) {
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						if(multiInstanceLoopCharacteristics==null) {
							multiInstanceLoopCharacteristics = Bpmn2Factory.eINSTANCE.createMultiInstanceLoopCharacteristics();
						}
						
						if (event.getFormalExpression() != null) {
							outputDataExp.setName(event.getFormalExpression().eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
							outputDataExp.setValue(event.getFormalExpression().getBody());
							DataOutput dataOutput = Bpmn2Factory.eINSTANCE.createDataOutput();
							ExtensionAttributeValue extensionAttributeValue = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
							FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry(
									(org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.RESOURCE_FILTER__EXPRESSION, outputDataExp);
							extensionAttributeValue.getValue().add(extensionElementEntry);
							dataOutput.getExtensionValues().add(extensionAttributeValue);
							multiInstanceLoopCharacteristics.setOutputDataItem(dataOutput);
						} else {
							outputDataExp.setName("");
							outputDataExp.setValue("");
							DataOutput dataOutput = Bpmn2Factory.eINSTANCE.createDataOutput();
							ExtensionAttributeValue extensionAttributeValue = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
							FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry(
									(org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.RESOURCE_FILTER__EXPRESSION, outputDataExp);
							extensionAttributeValue.getValue().add(extensionElementEntry);
							dataOutput.getExtensionValues().add(extensionAttributeValue);
							multiInstanceLoopCharacteristics.setOutputDataItem(dataOutput);
						}
						activity.setLoopCharacteristics(multiInstanceLoopCharacteristics);
						//传递表达式对象
						outputItemViewer.setExpression(outputDataExp);
					}
				});
			}
		});
		
		inputDatasetViewer.seteObject(activity);
		inputDatasetViewer.addExpressionChangedListeners(new IExpressionChangedListener() {
			
			@Override
			public void expressionChanged(final ExpressionChangedEvent event) {
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						if(multiInstanceLoopCharacteristics==null) {
							multiInstanceLoopCharacteristics = Bpmn2Factory.eINSTANCE.createMultiInstanceLoopCharacteristics();
						}
						
						if(event.getFormalExpression()==null)
						{
							multiInstanceLoopCharacteristics.getExtensionValues().clear();
							inputDatasetViewer.setExpression(inputDatasExp);
							inputDatasExp.setName("");
							inputDatasExp.setValue("");
							return;
						}

						if (multiInstanceLoopCharacteristics.getExtensionValues().size() > 0) {

							for (ExtensionAttributeValue extensionAttributeValue : multiInstanceLoopCharacteristics.getExtensionValues()) {

								FeatureMap extensionElements = extensionAttributeValue.getValue();
								for (Entry entry : extensionElements) {
									if (entry.getValue() instanceof LoopDataInputCollection) {
										LoopDataInputCollection loopDataInputCollection = (LoopDataInputCollection) entry.getValue();
										loopDataInputCollection.setExpression(inputDatasExp);
										loopDataInputCollection.getExpression().setName(event.getFormalExpression().eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
										loopDataInputCollection.getExpression().setValue(event.getFormalExpression().getBody());
										
										FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry(
												(org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__LOOP_DATA_INPUT_COLLECTION, loopDataInputCollection);
										multiInstanceLoopCharacteristics.getExtensionValues().get(0).getValue().add(extensionElementEntry);
									}else {
										inputDatasExp.setName(event.getFormalExpression().eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
										inputDatasExp.setValue(event.getFormalExpression().getBody());

										LoopDataInputCollection authors = FoxBPMFactory.eINSTANCE.createLoopDataInputCollection();
										authors.setExpression(inputDatasExp);
										FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry(
												(org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__LOOP_DATA_INPUT_COLLECTION, authors);
										multiInstanceLoopCharacteristics.getExtensionValues().get(0).getValue().add(extensionElementEntry);
									}
								}

							}
						} else {
							inputDatasExp.setName(event.getFormalExpression().eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
							inputDatasExp.setValue(event.getFormalExpression().getBody());

							LoopDataInputCollection authors = FoxBPMFactory.eINSTANCE.createLoopDataInputCollection();
							authors.setExpression(inputDatasExp);
							ExtensionAttributeValue extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
							FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry(
									(org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__LOOP_DATA_INPUT_COLLECTION, authors);
							extensionElement.getValue().add(extensionElementEntry);
							multiInstanceLoopCharacteristics.getExtensionValues().add(extensionElement);
						}
						activity.setLoopCharacteristics(multiInstanceLoopCharacteristics);
						//传递表达式对象
						inputDatasetViewer.setExpression(inputDatasExp);
					}
				});
			}
		});
		
		outputDatasetViewer.seteObject(activity);
		outputDatasetViewer.addExpressionChangedListeners(new IExpressionChangedListener() {
			
			@Override
			public void expressionChanged(final ExpressionChangedEvent event) {
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						if(multiInstanceLoopCharacteristics==null) {
							multiInstanceLoopCharacteristics = Bpmn2Factory.eINSTANCE.createMultiInstanceLoopCharacteristics();
						}
						
						if(event.getFormalExpression()==null)
						{
							multiInstanceLoopCharacteristics.getExtensionValues().clear();
							outputDatasExp.setName("");
							outputDatasExp.setValue("");
							outputDatasetViewer.setExpression(outputDatasExp);
							return;
						}

						if (multiInstanceLoopCharacteristics.getExtensionValues().size() > 0) {

							for (ExtensionAttributeValue extensionAttributeValue : multiInstanceLoopCharacteristics.getExtensionValues()) {

								FeatureMap extensionElements = extensionAttributeValue.getValue();
								for (Entry entry : extensionElements) {
									if (entry.getValue() instanceof LoopDataOutputCollection) {
										LoopDataOutputCollection loopDataOutputCollection = (LoopDataOutputCollection) entry.getValue();
										loopDataOutputCollection.setExpression(outputDatasExp);
										loopDataOutputCollection.getExpression().setName(event.getFormalExpression().eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
										loopDataOutputCollection.getExpression().setValue(event.getFormalExpression().getBody());
									
										FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry(
												(org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__LOOP_DATA_OUTPUT_COLLECTION, loopDataOutputCollection);
										multiInstanceLoopCharacteristics.getExtensionValues().get(0).getValue().add(extensionElementEntry);
									}else {
										outputDatasExp.setName(event.getFormalExpression().eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
										outputDatasExp.setValue(event.getFormalExpression().getBody());

										LoopDataOutputCollection authors = FoxBPMFactory.eINSTANCE.createLoopDataOutputCollection();
										authors.setExpression(outputDatasExp);
										FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry(
												(org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__LOOP_DATA_OUTPUT_COLLECTION, authors);
										multiInstanceLoopCharacteristics.getExtensionValues().get(0).getValue().add(extensionElementEntry);
									}
								}

							}
						} else {
							outputDatasExp.setName(event.getFormalExpression().eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
							outputDatasExp.setValue(event.getFormalExpression().getBody());

							LoopDataOutputCollection authors = FoxBPMFactory.eINSTANCE.createLoopDataOutputCollection();
							authors.setExpression(outputDatasExp);
							ExtensionAttributeValue extensionElement = Bpmn2Factory.eINSTANCE.createExtensionAttributeValue();
							FeatureMap.Entry extensionElementEntry = new SimpleFeatureMapEntry(
									(org.eclipse.emf.ecore.EStructuralFeature.Internal) FoxBPMPackage.Literals.DOCUMENT_ROOT__LOOP_DATA_OUTPUT_COLLECTION, authors);
							extensionElement.getValue().add(extensionElementEntry);
							multiInstanceLoopCharacteristics.getExtensionValues().add(extensionElement);
						}
						activity.setLoopCharacteristics(multiInstanceLoopCharacteristics);
						//传递表达式对象
						outputDatasetViewer.setExpression(outputDatasExp);
					}
				});
			}
		});
		
		fulfillConditionViewer.seteObject(activity);
		fulfillConditionViewer.addExpressionChangedListeners(new IExpressionChangedListener() {
			
			@Override
			public void expressionChanged(final ExpressionChangedEvent event) {
				TransactionalEditingDomain editingDomain = getDiagramEditor().getEditingDomain();
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						if(multiInstanceLoopCharacteristics==null) {
							multiInstanceLoopCharacteristics = Bpmn2Factory.eINSTANCE.createMultiInstanceLoopCharacteristics();
							completeExp.setName("");
							completeExp.setValue("");
							fulfillConditionViewer.setExpression(completeExp);
						}
						
						multiInstanceLoopCharacteristics.setCompletionCondition(event.getFormalExpression());
						activity.setLoopCharacteristics(multiInstanceLoopCharacteristics);
						//传递表达式对象
						if(event.getFormalExpression()!=null) {
							completeExp.setName(event.getFormalExpression().eGet(FoxBPMPackage.Literals.DOCUMENT_ROOT__NAME).toString());
							completeExp.setValue(event.getFormalExpression().getBody());
						}else {
							completeExp.setName("");
							completeExp.setValue("");
							fulfillConditionViewer.setExpression(completeExp);
						}
					}
				});
			}
		});
	}
}
