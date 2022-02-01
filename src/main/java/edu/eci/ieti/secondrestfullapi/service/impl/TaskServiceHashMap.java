package edu.eci.ieti.secondrestfullapi.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import edu.eci.ieti.secondrestfullapi.data.Task;
import edu.eci.ieti.secondrestfullapi.dto.TaskDto;
import edu.eci.ieti.secondrestfullapi.service.TaskService;

@Service
public class TaskServiceHashMap implements TaskService {
	
	private Map<String, Task> tasks;
	
	public TaskServiceHashMap() {
		tasks = new HashMap<String, Task>();
	}
	
	@Override
	public Task create(Task task) {
		tasks.put(task.getId(), task);
		return tasks.get(task.getId());
	}

	@Override
	public Task findById(String id) {
		return tasks.get(id);
	}

	@Override
	public List<Task> getAll() {
		List<Task> allTasks = new ArrayList<Task>(tasks.values());
		return allTasks;
	}

	@Override
	public boolean deleteById(String id) {
		Boolean wasDeleted;
		Task deletedTask = tasks.remove(id);
		if (deletedTask != null) {
			wasDeleted = true;
		}
		else {
			wasDeleted = false;
		}
		return wasDeleted;
	}

	@Override
	public Task update(TaskDto taskDto, String id) {
		Task Task = tasks.get(id);
		Task.setName(taskDto.getName());
		Task.setDescription(taskDto.getDescription());
		Task.setStatus(taskDto.getStatus());
		Task.setAssignedTo(taskDto.getAssignedTo());
		Task.setDueDate(taskDto.getDueDate());
		tasks.put(id, Task);
		return tasks.get(id);
	}
}