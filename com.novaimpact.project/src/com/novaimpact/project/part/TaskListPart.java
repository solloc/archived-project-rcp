
package com.novaimpact.project.part;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

import com.novaimpact.project.service.task.ITaskService;

public class TaskListPart {
	private List<String> tableData;

	@Inject
	private ITaskService taskService;

	@PostConstruct
	public void postConstruct(Composite parent) {
		
		this.tableData = this.taskService.getTasks();
		GridLayout gl_parent = new GridLayout(1, false);
		parent.setLayout(gl_parent);
		
		TableViewer tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		Table table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		tableViewer.setInput(this.tableData);
		tableViewer.getTable();
		
	}
}