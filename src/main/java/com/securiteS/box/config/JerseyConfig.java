package com.securiteS.box.config;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.securiteS.box.resources.ProductRessource;

import io.swagger.jaxrs.listing.SwaggerSerializers;

import io.swagger.jaxrs.listing.ApiListingResource;

@Configuration
@ApplicationPath("api")
public class JerseyConfig extends ResourceConfig {
	
	
	public JerseyConfig() {		
	}
	
	  @PostConstruct
	    public void setUp() {
		  packages("com.securiteS.box");
		  register(ProductRessource.class);
		  register(MultiPartFeature.class);
          register(SwaggerSerializers.class);
          register(ApiListingResource.class);
	    }

}