
package com.novaimpact.project.part;

import java.util.LinkedList;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

import com.novaimpact.project.model.Task;
import com.novaimpact.project.service.task.TaskService;
import com.novaimpact.project.ui.TaskTableContentProvider;
import com.novaimpact.project.ui.TaskTableLabelProvider;

import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.jface.viewers.TableViewerColumn;

public class TaskListPart {
	private LinkedList<Task> tableData;
	private TableViewer tableViewer;

	@Inject
	private TaskService taskService;

	@PostConstruct
	public void postConstruct(Composite parent) {
		if (this.tableViewer == null) {
			GridLayout gl_parent = new GridLayout(1, false);
			parent.setLayout(gl_parent);
			
			this.tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
//			this.tableViewer.setContentProvider(ArrayContentProvider.getInstance());
			this.tableViewer.setContentProvider(new TaskTableContentProvider());
			this.tableViewer.setLabelProvider(new TaskTableLabelProvider());
			
			Table table = this.tableViewer.getTable();
			table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		}
		
		
//		this.taskService = taskService;
		if (this.taskService != null) {
			this.tableData = this.taskService.getTasks();	
			this.tableViewer.setInput(this.tableData);
//			this.tableViewer.getTable();
		}

	}
	
	@Focus
	public void focus() {
//		this.tableViewer.setInput(this.taskService.getTasks());
//		this.tableViewer.getTable();
	}
	
}