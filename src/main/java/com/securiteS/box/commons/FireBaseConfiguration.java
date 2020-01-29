package com.securiteS.box.commons;

import java.io.FileInputStream;
import java.io.IOException;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.collect.Lists;

@Configuration
public class FireBaseConfiguration {
	

 
    @Value("${credentials}")
    private String configPath;
    
    @Value("${buckName}")
    public String buckName;
    
 
    @Bean
    public GoogleCredentials fireApp() throws IOException {
    	
    	
    	/**
    	 * https://firebase.google.com/docs/server/setup
    	 * 
    	 * Create service account , download json
    	 */
    	
    	
    	  GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(configPath))
    		        .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
			return credentials;
			
			
    	/*FileInputStream serviceAccount =  new FileInputStream("src/main/resources/product-images.json");
    			FirebaseOptions options = new FirebaseOptions.Builder()
    			  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
    			  .setDatabaseUrl("https://product-images-ac2fc.firebaseio.com")
    			  .build();
    	return FirebaseApp.initializeApp(options);
    			
        InputStream inputStream = FireBaseConfiguration.class.getClassLoader().getResourceAsStream(configPath);
 
        FirebaseOptions options = new FirebaseOptions.Builder().setServiceAccount(inputStream)
                .setDatabaseUrl(databaseUrl).build();
        FirebaseApp.initializeApp(options);*/
 
    }

}
