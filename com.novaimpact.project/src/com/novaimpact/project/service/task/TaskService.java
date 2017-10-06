package com.novaimpact.project.service.task;

import java.util.Arrays;
import java.util.List;

public class TaskService implements ITaskService {

	@Override
	public List<String> getTasks() {
		return Arrays.asList("abc","def","ghi");
	}

}
