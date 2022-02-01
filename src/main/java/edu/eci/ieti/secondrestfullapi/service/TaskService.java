package edu.eci.ieti.secondrestfullapi.service;

import java.util.List;

import edu.eci.ieti.secondrestfullapi.data.Task;
import edu.eci.ieti.secondrestfullapi.dto.TaskDto;

public interface TaskService {
	
	Task create( Task task );

    Task findById( String id );
    
    List<Task> getAll();

    boolean deleteById( String id );

    Task update( TaskDto taskDto, String id );
}