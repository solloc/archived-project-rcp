package com.novaimpact.project.service.task;

import java.util.LinkedList;

import com.novaimpact.project.model.Task;

@Deprecated
public interface ITaskService {
	public LinkedList<Task> getTasks();
	
	public Task createTask();
}
