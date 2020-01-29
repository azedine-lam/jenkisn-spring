package com.securiteS.box.resources;

import java.lang.annotation.Annotation;
import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.securiteS.box.Exception.ApiExceptionHandler;
import com.securiteS.box.Exception.AppException;
import com.securiteS.box.entities.Todo;
import com.securiteS.box.service.TodoService;

import io.swagger.annotations.Api;


@Component
@Path("/todo")
@Api(value = "Todo resource Version 1", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
public class TodoRessource {
	
	
	@Autowired
	TodoService service;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<Todo>> getTodos(){		
		return new ResponseEntity<>( service.getTodos(),HttpStatus.OK);		
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response getTodo (@PathParam("id") String id) throws AppException {
		 Todo todo = service.getTodo(id);
		 return Response.status(200)
					.entity(todo)
					.header("Access-Control-Allow-Headers", "X-extra-header")
					.allow("OPTIONS").build();
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<Todo> createToto(@Valid Todo todo) throws AppException {
		Todo result =  service.saveTodo(todo);
		return new ResponseEntity<>(result,HttpStatus.CREATED);
	}
}
