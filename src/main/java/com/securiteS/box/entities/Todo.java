package com.securiteS.box.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Todo {
	

	    @Id
	    private String id;

	    @NotNull(message = "Title is required")
	    @Size(min = 3, message = "Title must be at least 3 characters long")
	    private String title;

	    @NotNull(message = "Description is required")
	    private String description;

	    private long timestamp;

	    private String userId;
	    
	    public Todo() {
	        this.timestamp = System.currentTimeMillis();
	    }
	    
	    public Todo(String id, String title, String description) {
	        this.id = id;
	        this.title = title;
	        this.description = description;
	        this.timestamp = System.currentTimeMillis();
	    }

	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public long getTimestamp() {
	        return timestamp;
	    }

	    public void setTimestamp(long timestamp) {
	        this.timestamp = timestamp;
	    }

	    public String getUserId() {
	        return userId;
	    }

	    public void setUserId(String userId) {
	        this.userId = userId;
	    }

}
