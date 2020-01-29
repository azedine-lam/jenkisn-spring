package com.securiteS.box;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter;
import com.securiteS.box.commons.FileStore;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.RequestContextFilter;

@SpringBootApplication
public class BoxApplication implements CommandLineRunner {

	@Autowired
	FileStore fileStore;
	
	public static void main(String[] args) {
		SpringApplication.run(BoxApplication.class, args);
	}

	
	@Bean
	public RequestContextFilter requestContextFilter() {
		OrderedRequestContextFilter filter = new OrderedRequestContextFilter();
		filter.setOrder(-100001);
		return filter;
	}
	
	@Override
	public void run(String... args) throws Exception {
		InputStream testFile = new FileInputStream(new File("src/main/resources/product2.jpg"));
		fileStore.save("testtest",testFile);
	}
	
	 
}
