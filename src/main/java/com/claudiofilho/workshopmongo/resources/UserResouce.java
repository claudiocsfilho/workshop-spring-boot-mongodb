package com.claudiofilho.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.claudiofilho.workshopmongo.domain.User;
import com.claudiofilho.workshopmongo.services.UserService;

@RestController // para sinalizar que será um controlador REST
@RequestMapping(value = "/users") //caminho do end-point
public class UserResouce {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
