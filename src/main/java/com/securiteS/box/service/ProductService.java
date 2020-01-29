package com.securiteS.box.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.securiteS.box.Exception.AppException;
import com.securiteS.box.commons.FileStore;
import com.securiteS.box.entities.Product;
import com.securiteS.box.repository.ProductRepository;

@Component
public class ProductService {
	
	@Autowired
	ProductRepository repository;
	
	@Autowired
	FileStore fileStore;
	
	public Product getProduct(Long id) throws AppException {
		return repository.findById(id).orElseThrow(
				(() ->
				 new AppException(Response.Status.NOT_FOUND.getStatusCode(), 
							404, 
							"The Product you requested with id " + id + " was not found in the database",
							"Verify the existence of the Product with the id " + id + " in the database",""
							))
				);
	}
	
	public List<Product> getAllProduct(){
		return repository.findAll();
	}
	
	public Product saveProduct(Product Product) throws AppException {
		return repository.save(Product);
	}

	public void saveImage(Long id, InputStream file) throws IOException {
		fileStore.save(id.toString(), file);
		
	}

}
