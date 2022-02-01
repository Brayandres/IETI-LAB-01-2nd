package edu.eci.ieti.secondrestfullapi.data;

import edu.eci.ieti.secondrestfullapi.dto.TaskDto;
import edu.eci.ieti.secondrestfullapi.model.Status;

public class Task {
	
	private String id;
	private String name;
	private String description;
	private Status status;
	private String assignedTo;
	private String dueDate;
	private String created;
	
	public Task() {
		
	}
	
	public Task(TaskDto taskDto) {
		this.name = taskDto.getName();
		this.description = taskDto.getDescription();
		this.status = taskDto.getStatus();
		this.assignedTo = taskDto.getAssignedTo();
		this.dueDate = taskDto.getDueDate(); 
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}
}