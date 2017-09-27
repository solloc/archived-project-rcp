
package com.novaimpact.project.parts;

import javax.annotation.PostConstruct;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;

public class IncidentPart {
	private Text txtIncident;

	@PostConstruct
	public void postConstruct(Composite parent) {
		parent.setLayout(null);
		
		txtIncident = new Text(parent, SWT.BORDER);
		txtIncident.setText("Incident");
		txtIncident.setBounds(10, 10, 76, 21);
		
	}

	@Persist
	public void save() {
		
	}
}