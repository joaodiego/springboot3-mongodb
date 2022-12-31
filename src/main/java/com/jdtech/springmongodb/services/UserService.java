package com.jdtech.springmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdtech.springmongodb.domain.User;
import com.jdtech.springmongodb.dto.UserDTO;
import com.jdtech.springmongodb.repositories.UserRepository;
import com.jdtech.springmongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);

	}

	public User insert(User obj) {
		return repo.save(obj);
	}

	public User update(User obj) {
		Optional<User> newObj = repo.findById(obj.getId());
		udtateData(newObj, obj);
		repo.save(newObj.get());
		return newObj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

	}

	private void udtateData(Optional<User> newObj, User obj) {
		newObj.orElse(obj).setNome(obj.getNome());
		newObj.orElse(obj).setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getNome(), objDto.getEmail());
	}
}
