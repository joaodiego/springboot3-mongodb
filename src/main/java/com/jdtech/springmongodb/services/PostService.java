package com.jdtech.springmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdtech.springmongodb.domain.Post;
import com.jdtech.springmongodb.repositories.PostRepository;
import com.jdtech.springmongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public List<Post> findAll() {
		return repo.findAll();
	}

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);

	}

	public Post insert(Post obj) {
		return repo.save(obj);
	}

}
