package com.novaimpact.project.service.task;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TaskService implements ITaskService {
	
	protected LinkedList<String> tasks;
	
	public TaskService() {
		this.tasks = new LinkedList<>(Arrays.asList("abc","def","ghi"));
	}

	@Override
	public List<String> getTasks() {
		return this.tasks;
	}

	@Override
	public String createTask(String name) {
		this.tasks.add(name);
		return name;
	}

}
