
package com.novaimpact.project.part;

import javax.annotation.PostConstruct;

import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.databinding.viewers.ViewerSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.novaimpact.project.model.Task;
import com.novaimpact.project.service.task.TaskService;

public class TaskListPart {
	private TableViewer tableViewer;

	@PostConstruct
	public void postConstruct(Composite parent, TaskService taskService) {
			GridLayout gl_parent = new GridLayout(1, false);
			parent.setLayout(gl_parent);
			
			this.tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
			
			Table table = this.tableViewer.getTable();
			table.setLinesVisible(true);
			table.setHeaderVisible(true);
			table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
			
			TableColumn tblclmnId = new TableColumn(table, SWT.NONE);
			tblclmnId.setWidth(250);
			tblclmnId.setText("ID");

			TableColumn tblclmnName = new TableColumn(table, SWT.NONE);
			tblclmnName.setWidth(100);
			tblclmnName.setText("name");

			IObservableList<Task> input = taskService.getTasks();
			
			ViewerSupport.bind(this.tableViewer, input, BeanProperties.values(Task.class, new String[] {"id","name"}));
	}
	
	@Focus
	public void focus() {
	}
}