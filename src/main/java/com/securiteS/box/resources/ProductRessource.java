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
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.securiteS.box.Exception.AppException;
import com.securiteS.box.entities.Product;
import com.securiteS.box.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Component
@Path("/")
@Api(value = "Hello resource Version 1", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
public class ProductRessource {
	
	
	@Autowired
	ProductService service;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Find all products")
	public ResponseEntity<List<Product>> getProducts(){	
		System.out.println();
		return new ResponseEntity<>(service.getAllProduct(),HttpStatus.OK);		
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	@ApiOperation("Get product by id")
	public ResponseEntity<Product> getProductByID (
			@PathParam("id") Long id) throws AppException {
		 //Product Product = service.getProduct(id);
		 return new ResponseEntity<Product>(service.getProduct(id),HttpStatus.OK);		
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<Product> createProduct(@Valid Product product) throws AppException {
		Long i =new Long(1);
		//Product result = null;
		product.setDescription("j");
		Product result =  service.saveProduct(product);
		return new ResponseEntity<>(result,HttpStatus.CREATED);
	}
	
	
	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public Response uploadImage(  @FormDataParam("file") InputStream stream) throws IOException {
		
		service.saveImage(1L,stream);
		 return Response.status(200)
					//.entity(todo)
					.header("Access-Control-Allow-Headers", "X-extra-header")
					.allow("OPTIONS").build(); 
		
	}
}
