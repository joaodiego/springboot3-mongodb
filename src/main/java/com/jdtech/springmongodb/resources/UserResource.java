package com.jdtech.springmongodb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdtech.springmongodb.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User joao = new User("1", "joao", "joao@email.com");
		User maria = new User("2","maria","maria@email.com");
		ArrayList<User> users = new ArrayList<>();
		users.addAll(Arrays.asList(joao,maria));
		return ResponseEntity.ok().body(users);		
	}

}
