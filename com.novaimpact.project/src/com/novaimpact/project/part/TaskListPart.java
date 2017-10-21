
package com.novaimpact.project.part;

import javax.annotation.PostConstruct;

import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
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
//	private LinkedList<Task> tableData;
	private TableViewer tableViewer;

	@PostConstruct
	public void postConstruct(Composite parent, TaskService taskService) {
			GridLayout gl_parent = new GridLayout(1, false);
			parent.setLayout(gl_parent);
			
			this.tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
//			this.tableViewer.setContentProvider(new ObservableListContentProvider());
//			this.tableViewer.setContentProvider(new TaskTableContentProvider());
//			this.tableViewer.setLabelProvider(new TaskTableLabelProvider());
			
			
			Table table = this.tableViewer.getTable();
			table.setLinesVisible(true);
			table.setHeaderVisible(true);
			table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
			
			TableColumn tblclmnId = new TableColumn(table, SWT.NONE);
			tblclmnId.setWidth(250);
			tblclmnId.setText("ID");
//			
			TableColumn tblclmnName = new TableColumn(table, SWT.NONE);
			tblclmnName.setWidth(100);
			tblclmnName.setText("name");
			
			
			
			
//			this.tableData = taskService.getTasks();
//			IObservableList<Task> input = new WritableList<Task>(taskService.getTasks(), Task.class);
			IObservableList<Task> input = taskService.getTasks();
			
//			IObservableList input = Properties.selfSet(Task.class).observe(taskService.getTasks());
			
//			ViewerSupport.bin
			
//			ViewerSupport.bind(this.tableViewer, input, BeanProperties.value(Task.class, "name"));
			ViewerSupport.bind(this.tableViewer, input, BeanProperties.values(Task.class, new String[] {"id","name"}));
			
			
//			input.add(new Task("abc"));
//			input.add(new Task("def"));
//			input.add(new Task("ghi"));
//			input.add(new Task("jkl"));
		
			
//			this.tableViewer.setInput(this.tableData);
//			this.tableViewer.setInput(input);
	}
	
	@Focus
	public void focus() {
	}
}