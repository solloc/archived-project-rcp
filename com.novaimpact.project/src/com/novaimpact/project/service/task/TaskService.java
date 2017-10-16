package com.novaimpact.project.service.task;

import java.util.LinkedList;
import java.util.UUID;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Creatable;

import com.novaimpact.project.model.Task;

@Creatable
public class TaskService {
	
	private LinkedList<Task> tasks;
	
//	@Inject
	private IEclipseContext context;
	
	@Inject
	public TaskService(IEclipseContext context) {
		this.context = context;
		
		this.context.set(TaskService.class.getName(), this);
		
		this.tasks = new LinkedList<Task>();
		
		Task task1 = new Task(UUID.randomUUID().toString(), "task-1", "user-1", "descr-1");
		Task task2 = new Task(UUID.randomUUID().toString(), "task-2", "user-2", "descr-2");
		Task task3 = new Task(UUID.randomUUID().toString(), "task-3", "user-1", "descr-3");
		Task task4 = new Task(UUID.randomUUID().toString(), "task-4", "user-1", "descr-4");
		
		this.tasks.add(task1);
		this.tasks.add(task2);
		this.tasks.add(task3);
		this.tasks.add(task4);
	}

	public LinkedList<Task> getTasks() {
		return this.tasks;
	}

	public Task createTask() {
		
		Task task = new Task(UUID.randomUUID().toString());
		this.tasks.add(task);
		return task;
	}

}
