package org.foxbpm.bpmn.designer.ui.propertytab;
/*******************************************************************************
 * Copyright (c) 2011, 2012 Red Hat, Inc.
 *  All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Red Hat, Inc. - initial API and implementation
 *
 * @author Bob Brodt
 * @author modified by demonrain
 ******************************************************************************/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;

import org.eclipse.bpmn2.modeler.core.runtime.Bpmn2SectionDescriptor;
import org.eclipse.bpmn2.modeler.core.runtime.Bpmn2TabDescriptor;
import org.eclipse.bpmn2.modeler.core.runtime.TargetRuntime;
import org.eclipse.bpmn2.modeler.core.utils.BusinessObjectUtil;
import org.eclipse.bpmn2.modeler.ui.editor.BPMN2Editor;
import org.eclipse.bpmn2.modeler.ui.property.AdvancedPropertySection;
import org.eclipse.bpmn2.modeler.ui.property.TabDescriptorList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptorProvider;

public class FoxBPMTabDescriptorProvider implements ITabDescriptorProvider {

	// This map caches the Tab Descriptor List. A Tab Descriptor List is built for each EObject and then
	// cached in this map. It is the BPMN2 Editor's responsibility to remove these items from the map
	// when it is disposed().
	// @see PropertyTabDescriptorProvider#disposeTabDescriptors(Resource)
	Hashtable <EObject, TabDescriptorList> tabDescriptorListMap = new Hashtable <EObject, TabDescriptorList>();
	
	public FoxBPMTabDescriptorProvider() {
		super();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ITabDescriptor[] getTabDescriptors(IWorkbenchPart part, ISelection selection) {
		
		// is the Tab Descriptor List already in our cache?
		TabDescriptorList tabDescriptorList = null;
		EObject businessObject = BusinessObjectUtil.getBusinessObjectForSelection(selection);
		if (businessObject!=null) {
			tabDescriptorList = tabDescriptorListMap.get(businessObject);
			if (tabDescriptorList!=null) {
				// Yes! return it.
				
				//标签页排序
				sortList(tabDescriptorList);
				
				return tabDescriptorList.toArray();
			}
		}
		
		// No, we need build the list: get the Target Runtime <propertyTab> contributions
		// and merge with the Default Runtime Tab Descriptors
		TargetRuntime rt = TargetRuntime.getDefaultRuntime();
		Object bpmn2Editor = part.getAdapter(BPMN2Editor.class);
		if (bpmn2Editor instanceof BPMN2Editor) {
			rt = ((BPMN2Editor)bpmn2Editor).getTargetRuntime(this);
		}
		
		List<Bpmn2TabDescriptor> desc = null;
		if (rt!=TargetRuntime.getDefaultRuntime()) {
			desc = TargetRuntime.getDefaultRuntime().getTabDescriptors();
			desc.addAll(rt.getTabDescriptors());
		}
		else
			desc = rt.getTabDescriptors();
		
		// do tab replacement
		ArrayList<Bpmn2TabDescriptor> replaced = new ArrayList<Bpmn2TabDescriptor>();
		for (Bpmn2TabDescriptor d : desc) {
			String replacedId = d.getReplaceTab();
			if (replacedId!=null) {
				String[] replacements = replacedId.split(" "); //$NON-NLS-1$
				// tab replacement is only done if the replacement tab has section descriptors
				// that want the replacement to happen.
				for (String id : replacements) {
					for (Bpmn2SectionDescriptor s : (List<Bpmn2SectionDescriptor>) d.getSectionDescriptors()) {
//						if (s.appliesTo(part, selection)) 
						{
							// ask the section if it wants to replace this tab
							if (s.doReplaceTab(id, part, selection)) {
								// replace the tab whose ID is specified as "replaceTab" in this tab.
								Bpmn2TabDescriptor replacedTab = TargetRuntime.findTabDescriptor(id);
								if (replacedTab!=null) {
									replaced.add(replacedTab);
									int i = desc.indexOf(replacedTab);
									if (i>=0) {
										desc.set(i, d);
									}
								}
							}
						}
					}
				}
			}
		}
		if (replaced.size()>0)
			desc.removeAll(replaced);

		for (int i=desc.size()-1; i>=0; --i) {
			Bpmn2TabDescriptor d = desc.get(i);
			for (int j=i-1; j>=0; --j) {
				if (desc.get(j)==d) {
					desc.remove(i);
					break;
				}
			}
		}
		
		// remove empty tabs
		// also move the advanced tab to end of list
		ArrayList<Bpmn2TabDescriptor> emptyTabs = new ArrayList<Bpmn2TabDescriptor>();
		Bpmn2TabDescriptor advancedPropertyTab = null;
		for (Bpmn2TabDescriptor d : desc) {
			boolean empty = true;
			for (Bpmn2SectionDescriptor s : (List<Bpmn2SectionDescriptor>) d.getSectionDescriptors()) {
				if (s.appliesTo(part, selection)) {
					empty = false;
				}
				//如果是定义类型，则不去掉 --wy
				if(s.getSectionClass().getClass().getSimpleName().contains(("DefinitionPropertySection"))) {
					empty = false;
				}
				if (s.getSectionClass() instanceof AdvancedPropertySection) {
					advancedPropertyTab = d;
				}
			}
			if (empty) {
				emptyTabs.add(d);
			}
		}
		
		if (emptyTabs.size()>0)
			desc.removeAll(emptyTabs);
		
		if (advancedPropertyTab!=null) {
			if (desc.remove(advancedPropertyTab))
				desc.add(advancedPropertyTab);
		}
		
		// make copies of all tab descriptors to prevent cross-talk between editors
		replaced.clear(); // we'll just reuse an ArrayList from before...
		for (Bpmn2TabDescriptor td : desc) {
			// Note that the copy() makes the Tab Descriptor IDs and Section IDs unique.
			// This is important because the TabbedPropertySheetPage uses these IDs to
			// look up the Sections.
			replaced.add(td.copy()); 
		}
		
		// save this in the cache.
		if (businessObject!=null) {
			tabDescriptorList = new TabDescriptorList();
			tabDescriptorList.addAll(replaced);
			tabDescriptorListMap.put(businessObject, tabDescriptorList);
			return tabDescriptorList.toArray();
		}
		
		//标签页排序
		sortList(replaced);
		
		return replaced.toArray(new ITabDescriptor[replaced.size()]);
	}

	/**
	 * This should be called by the editor during dispose() to remove all the items
	 * from the cache.
	 *  
	 * @param resource - the EMF Resource containing the EObjects for which
	 *        Property Tab Descriptors were built.
	 */
	public void disposeTabDescriptors(Resource resource) {
		if (resource!=null) {
			TreeIterator<EObject> iter = resource.getAllContents();
			while (iter.hasNext()) {
				EObject object = iter.next();
				tabDescriptorListMap.remove(object);
			}
		}
	}
	
	private void sortList(List<Bpmn2TabDescriptor> list) {
		Collections.sort(list,new Comparator<Bpmn2TabDescriptor>(){  
            @Override  
            public int compare(Bpmn2TabDescriptor tab1, Bpmn2TabDescriptor tab2) {  
                return tab2.getOrder().compareTo(tab1.getOrder());  
            }  
              
        });  
	}
}
