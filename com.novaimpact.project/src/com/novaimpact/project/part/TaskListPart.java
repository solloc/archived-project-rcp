
package com.novaimpact.project.part;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.databinding.viewers.ViewerSupport;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.novaimpact.project.model.Task;
import com.novaimpact.project.service.task.TaskService;

@SuppressWarnings("restriction")
public class TaskListPart {
	private TableViewer tableViewer;

	@PostConstruct
	public void postConstruct(Composite parent, TaskService taskService, ECommandService commandService, EHandlerService handlerService) {
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
			
			this.tableViewer.addDoubleClickListener(new IDoubleClickListener() {
				
				@Override
				public void doubleClick(DoubleClickEvent event) {
					System.out.println(event.getSelection());
					
					StructuredSelection selection = (StructuredSelection)event.getSelection();
					Task selectedTask = (Task)selection.getFirstElement();
					
					Map<String, Object> parameter = new HashMap<>();

					parameter.put("com.novaimpact.project.commandparameter.taskid", selectedTask.getId());
		
					Command command = commandService.getCommand("com.novaimpact.project.command.opentaskcommand");
					ParameterizedCommand pcmd = ParameterizedCommand.generateCommand(command, parameter);
					
					handlerService.executeHandler(pcmd);				
				}
			});
			
			ViewerSupport.bind(this.tableViewer, taskService.getTasks(), BeanProperties.values(Task.class, new String[] {"id","name"}));
	}
	
	@Focus
	public void focus() {
	}
}