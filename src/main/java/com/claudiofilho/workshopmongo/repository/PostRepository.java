package com.claudiofilho.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.claudiofilho.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

	//QUERY Methods
	//Apenas esta declaração faz com que o Spring data faça a consulta.
	List<Post> findByTitleContainingIgnoreCase(String text);
	
}
