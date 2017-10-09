package com.novaimpact.project.service.task;

import java.util.List;

public interface ITaskService {
	public List<String> getTasks();
	
	public String createTask(String name);
}
