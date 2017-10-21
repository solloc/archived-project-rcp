package com.novaimpact.project.model;

public class Task extends ModelObject {
	
	private String id = "";
	private String name = "";
	private String creator = "";
	private String description = "";
	
	public Task(String id) {
		this.setId(id);
	}
	
	public Task(String id, String name, String creator, String description) {
		this.setId(id);
		this.setName(name);
		this.setCreator(creator);
		this.setDescription(description);
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
//		this.name = name;
		firePropertyChange("name", this.name, this.name = name);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
//		this.id = id;
		firePropertyChange("id", this.id, this.id = id);
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
//		this.creator = creator;
		firePropertyChange("creator", this.creator, this.creator = creator);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
//		this.description = description;
		firePropertyChange("description", this.description, this.description = description);
	}
	
}
