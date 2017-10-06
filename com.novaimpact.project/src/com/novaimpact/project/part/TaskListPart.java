
package com.novaimpact.project.part;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import com.novaimpact.project.service.task.ITaskService;

public class TaskListPart {
	private List<String> tableData;

	@Inject
	private ITaskService taskService;

	@PostConstruct
	public void postConstruct(Composite parent) {
		
		this.tableData = this.taskService.getTasks();		
		
		parent.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		TableViewer tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		tableViewer.setInput(this.tableData);
		tableViewer.getTable();
		
	}
}