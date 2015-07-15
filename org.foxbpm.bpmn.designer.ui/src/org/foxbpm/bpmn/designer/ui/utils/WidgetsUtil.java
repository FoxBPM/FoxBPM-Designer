package org.foxbpm.bpmn.designer.ui.utils;

import org.eclipse.jface.util.Policy;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.widgets.TableColumn;

public class WidgetsUtil {
	public static TableViewerColumn[] getTableViewerColumns(TableViewer tableViewer) {
	    TableColumn[] columns = tableViewer.getTable().getColumns();
	    TableViewerColumn[] viewerColumns = new TableViewerColumn[columns.length];
	    for (int i = 0; i < columns.length; i++) {
	        TableColumn tableColumn = columns[i];
	        viewerColumns[i] = (TableViewerColumn) tableColumn.getData(Policy.JFACE + ".columnViewer"); //$NON-NLS-1$
	    }
	    return viewerColumns;
	}
}
