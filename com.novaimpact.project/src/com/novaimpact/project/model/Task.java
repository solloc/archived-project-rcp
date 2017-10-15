package com.novaimpact.project.model;

public class Task {
	
	public String id = "";
	public String name = "";
	public String creator = "";
	public String description = "";
	
	public Task(String id) {
		this.id = id;
	}
	
	public Task(String id, String name, String creator, String description) {
		this.id = id;
		this.name = name;
		this.creator = creator;
		this.description = description;
	}
	
}
