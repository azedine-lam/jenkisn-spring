package com.securiteS.box.service;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.securiteS.box.Exception.AppException;
import com.securiteS.box.entities.Todo;
import com.securiteS.box.repository.TodoRepository;

@Component
public class TodoService {
	
	@Autowired
	TodoRepository repository;
	
	public Todo getTodo(String id) throws AppException {
		return repository.findById(id).orElseThrow(
				(() ->
				 new AppException(Response.Status.NOT_FOUND.getStatusCode(), 
							404, 
							"The todo you requested with id " + id + " was not found in the database",
							"Verify the existence of the todo with the id " + id + " in the database",""
							))
				);
	}
	
	public List<Todo> getTodos(){
		return repository.findAll();
	}
	
	public Todo saveTodo(Todo todo) throws AppException {
		return repository.save(todo);
	}

}
