package org.foxbpm.bpmn.designer.ui.expdialog;

import java.util.EventObject;

import org.eclipse.bpmn2.FormalExpression;

public class ExpressionChangedEvent extends EventObject {

	private static final long serialVersionUID = 1999273206266333243L;

	protected FoxBPMExpViewer eventSource;
	private FormalExpression formalExpression;

	public FormalExpression getFormalExpression() {
		return formalExpression;
	}

	public ExpressionChangedEvent(FoxBPMExpViewer eventSource, FormalExpression formalExpression) {
		super(eventSource);
		this.eventSource = eventSource;
		this.formalExpression = formalExpression;
	}

}
