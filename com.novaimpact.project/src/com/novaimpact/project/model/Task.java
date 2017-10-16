package com.novaimpact.project.model;

import org.eclipse.core.databinding.observable.value.WritableValue;

public class Task {
	
//	public WritableValue<String> id = new WritableValue<>();
	
	public String id = "";
	public String name = "";
	public String creator = "";
	public String description = "";
	
	public Task(String id) {
//		this.id.setValue(id);
		this.id = id;
	}
	
	public Task(String id, String name, String creator, String description) {
//		this.id.setValue(id);
		this.id = id;
		this.name = name;
		this.creator = creator;
		this.description = description;
	}
	
	public String getName() {
		return this.name;
	}
	
}
