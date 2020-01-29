package com.securiteS.box.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.securiteS.box.Exception.AppException;
import com.securiteS.box.commons.FileStore;
import com.securiteS.box.entities.Category;
import com.securiteS.box.repository.CategoryRepository;

@Component
public class CategoryService {
	
	@Autowired
	CategoryRepository repository;
	
	
	public Category getCategory(Long id) throws AppException {
		return repository.findById(id).orElseThrow(
				(() ->
				 new AppException(Response.Status.NOT_FOUND.getStatusCode(), 
							404, 
							"The Category you requested with id " + id + " was not found in the database",
							"Verify the existence of the Category with the id " + id + " in the database",""
							))
				);
	}
	
	public List<Category> getAllCategory(){
		return repository.findAll();
	}
	
	public Category saveCategory(Category Category) throws AppException {
		return repository.save(Category);
	}


}
