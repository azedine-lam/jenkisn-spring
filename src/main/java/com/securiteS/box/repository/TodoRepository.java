package com.securiteS.box.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securiteS.box.entities.Todo;


public interface TodoRepository extends JpaRepository<Todo, String>{

}
