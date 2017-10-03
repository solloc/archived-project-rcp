package com.novaimpact.project.service;

import java.util.Arrays;
import java.util.List;

public class TaskService {
	
	private List<String> taskList;
	
	public TaskService() {
		this.taskList = Arrays.asList("task-1","task-2","task-3");
	}
	
	public List<String> getTasks() {
		return this.taskList;
	}

}
