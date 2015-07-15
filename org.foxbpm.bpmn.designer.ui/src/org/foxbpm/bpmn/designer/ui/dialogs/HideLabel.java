package org.foxbpm.bpmn.designer.ui.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class HideLabel 
{
    public static void main(String[] args)
    {
        Display display = new Display();
        final Shell shell = new Shell(display);
        shell.setLayout(new GridLayout(1, false));
        shell.setText("Hide Label");

        Label label = new Label(shell, SWT.NONE);
        label.setText("Label 1");

        final Label bHidden = new Label(shell, SWT.NONE);
        bHidden.setText("Label 2");
        GridData data = new GridData();
        data.exclude = false;
        data.horizontalAlignment = SWT.FILL;
        bHidden.setLayoutData(data);

        label = new Label(shell, SWT.NONE);
        label.setText("Label 3");

        Button button = new Button(shell, SWT.CHECK);
        button.setText("hide");
        button.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                Button b = (Button) e.widget;
                GridData data = (GridData) bHidden.getLayoutData();
                data.exclude = b.getSelection();
                bHidden.setVisible(!data.exclude);
                shell.layout(false);
            }
        });
        shell.setSize(200, 200);
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }
}