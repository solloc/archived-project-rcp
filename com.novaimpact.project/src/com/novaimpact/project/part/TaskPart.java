
package com.novaimpact.project.part;

import javax.annotation.PostConstruct;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;

public class TaskPart {
	private Text txtAbc;

	@PostConstruct
	public void postConstruct(Composite parent) {
		parent.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		txtAbc = new Text(parent, SWT.BORDER);
		txtAbc.setText("TaskPart");
		
	}
}