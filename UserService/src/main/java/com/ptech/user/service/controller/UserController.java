package com.ptech.user.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ptech.user.service.entities.User;
import com.ptech.user.service.request.dto.UserRequestDTO;
import com.ptech.user.service.service.UserService;
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody UserRequestDTO dto){
		return new ResponseEntity<User>(this.userService.createUser(dto),HttpStatus.OK);
	}
	@PutMapping("/user")
	public ResponseEntity<User> updateUser(@RequestBody UserRequestDTO dto){
		return new ResponseEntity<User>(this.userService.updateUser(dto),HttpStatus.OK);
	}
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable Integer id){
		this.userService.deleteUser(id);
	}
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id){
		return new ResponseEntity<User>(this.userService.getUser(id),HttpStatus.OK);
	}
}
