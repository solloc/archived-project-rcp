
package com.novaimpact.project.part;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.novaimpact.project.model.Task;

public class TaskPart {
	private Text textID;
	private Text textName;
	private Text textDescription;
	
	private Task newTask;

	@PostConstruct
	public void postConstruct(Composite parent) {
		parent.setLayout(new GridLayout(2, false));
		
		Label lblId = new Label(parent, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblId.setText("ID");
		
		textID = new Text(parent, SWT.BORDER | SWT.READ_ONLY);
		textID.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblNewLabel = new Label(parent, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("name");
		
		textName = new Text(parent, SWT.BORDER);
		textName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		
		Label lblDescription = new Label(parent, SWT.NONE);
		lblDescription.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		lblDescription.setText("description");
		
		textDescription = new Text(parent, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		GridData gd_textDescription = new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1);
		gd_textDescription.heightHint = 100;
		textDescription.setLayoutData(gd_textDescription);
		
	}
	
	@Focus
	public void focus() {	
	}
	
	public void setTask(Task task) {
		this.newTask = task;
		this.textID.setText(this.newTask.id);
		this.textName.setText(this.newTask.name);
		this.textDescription.setText(this.newTask.description);		
	}
}