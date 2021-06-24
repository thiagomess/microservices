package com.example.hruser.controllers;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hruser.entities.User;
import com.example.hruser.repositories.UserRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findAById(@PathVariable Long id) throws NotFoundException, ObjectNotFoundException {

		User user = userRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Objeto Não encontrado: Id: " + id));
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/search")
	public ResponseEntity<User> findAByEmail(@RequestParam String email) throws NotFoundException, ObjectNotFoundException {

		User user = userRepository.findByEmail(email);
		return ResponseEntity.ok(user);
	}


}
