package com.claudiofilho.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.claudiofilho.workshopmongo.domain.Post;
import com.claudiofilho.workshopmongo.resources.util.URL;
import com.claudiofilho.workshopmongo.services.PostService;

@RestController // para sinalizar que será um controlador REST
@RequestMapping(value = "/posts") //caminho do end-point
public class PostResouce {

	@Autowired
	private PostService service;
	
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value="/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(defaultValue = "") String text ){
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
}
