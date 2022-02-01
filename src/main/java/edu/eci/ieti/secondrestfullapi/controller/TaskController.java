package edu.eci.ieti.secondrestfullapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.ieti.secondrestfullapi.data.Task;
import edu.eci.ieti.secondrestfullapi.dto.TaskDto;
import edu.eci.ieti.secondrestfullapi.service.TaskService;

@RestController
@RequestMapping("/v1/task")
public class TaskController {
	
	private final TaskService taskService;
	
	public TaskController(@Autowired TaskService taskService) {
		this.taskService = taskService;
	}
	
	@GetMapping
	public ResponseEntity<List<Task>> getAll() {
		List<Task> response;
		try {
			response = taskService.getAll();
		} catch (Exception e) {
			response = new ArrayList<Task>();
			Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, e);
			return new ResponseEntity<List<Task>>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Task>>(response, HttpStatus.ACCEPTED);
	}
	
	@GetMapping( "/{id}" )
    public ResponseEntity<Task> findById( @PathVariable String id ) {
		Task task = null;
		try {
			task = taskService.findById(id);
		} catch (Exception e) {
			Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, e);
			return new ResponseEntity<Task>(task, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Task>(task, HttpStatus.ACCEPTED);
    }
	
	@PostMapping
    public ResponseEntity<Task> create( @RequestBody TaskDto taskDto ) {
		Task task = null;
        try {
        	task = taskService.create(new Task(taskDto));
        } catch (Exception e) {
        	Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, e);
        	return new ResponseEntity<Task>(task, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Task>(task, HttpStatus.ACCEPTED);
    }
   
    @PutMapping( "/{id}" )
    public ResponseEntity<Task> update( @RequestBody TaskDto taskDto, @PathVariable String id ) {
    	Task task = null;
        try {
        	task = taskService.update(taskDto, id);
        } catch (Exception e) {
        	Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, e);
        	return new ResponseEntity<Task>(task, HttpStatus.NOT_FOUND);
        };
        return new ResponseEntity<Task>(task, HttpStatus.ACCEPTED);
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id ) {
    	Boolean response = false;
        try {
        	response = taskService.deleteById(id);
        } catch (Exception e) {
        	Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, e);
        	return new ResponseEntity<Boolean>(response, HttpStatus.BAD_REQUEST);
        };
        return new ResponseEntity<Boolean>(response, HttpStatus.ACCEPTED);
    }
}