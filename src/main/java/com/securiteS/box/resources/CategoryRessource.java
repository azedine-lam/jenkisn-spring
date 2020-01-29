package com.securiteS.box.resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.securiteS.box.Exception.AppException;
import com.securiteS.box.entities.Category;
import com.securiteS.box.service.CategoryService;


@Component
@Path("/categories")
@CrossOrigin(origins = {"http://localhost:3000","http://localhost:6061"})
public class CategoryRessource {
	
	
	@Autowired
	CategoryService service;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<Category>> getCategorys(){		
		return new ResponseEntity<>(service.getAllCategory(),HttpStatus.OK);		
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public ResponseEntity<Category> getCategory (@PathParam("id") Long id) throws AppException {
		 //Category Category = service.getCategory(id);
		 return new ResponseEntity<Category>(service.getCategory(id),HttpStatus.OK);		
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<Category> createCategory(@Valid Category Category) throws AppException {
		//Category result = null;
		Category.setId(new Long(1985));
		Category result =  service.saveCategory(Category);
		return new ResponseEntity<>(result,HttpStatus.CREATED);
	}
	
}
