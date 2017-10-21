package com.novaimpact.project.service.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.swt.widgets.Display;

import com.novaimpact.project.model.Task;

@Creatable
public class TaskService {
	
//	private ObservableList<Task> tasks;
	
//	private LinkedList<Task> tasks = new LinkedList<Task>();
	
	private WritableList<Task> tasks; // = WritableList.withElementType(Task.class);
	
	@Inject
	public TaskService(IEclipseContext context) {
		context.set(TaskService.class.getName(), this);
		
//		LinkedList<Task> lTask = new LinkedList<Task>();
//		lTask.add(new Task("123"));
//		IObservableList<Task> lwTask = new WritableList<Task>(lTask,Task.class);
		
		Realm realm = Realm.getDefault();
		if (realm == null) {
			realm = new Realm() {
				
				@Override
				public boolean isCurrent() {
					// TODO Auto-generated method stub
					return true;
				}
			};
		}
		
//		ObservableList<Task> oTasks = new ObservableList<Task>(realm,this.tasks,Task.class) {};
		
//		Display.getDefault().get
//		realm = Realm.getDefault();
//		WritableList<Task> wList = new WritableList<Task>();
		
//		this.tasks = new LinkedList<Task>();
//		this.tasks = new ObservableList<Task>();
		this.tasks = new WritableList<Task>(realm);
		
		Task task1 = new Task(UUID.randomUUID().toString(), "task-1", "user-1", "descr-1");
		Task task2 = new Task(UUID.randomUUID().toString(), "task-2", "user-2", "descr-2");
		Task task3 = new Task(UUID.randomUUID().toString(), "task-3", "user-1", "descr-3");
		Task task4 = new Task(UUID.randomUUID().toString(), "task-4", "user-1", "descr-4");
		
		this.tasks.add(task1);
		this.tasks.add(task2);
		this.tasks.add(task3);
		this.tasks.add(task4);
	}
	
	public WritableList<Task> getTasks() {
		return this.tasks;
	}

//	public LinkedList<Task> getTasks() {
//		return this.tasks;
//	}

	public Task createTask() {
		
		Task task = new Task(UUID.randomUUID().toString());
		this.tasks.add(task);
		return task;
	}

}
