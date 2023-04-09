package com.ptech.user.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ptech.user.service.entities.User;
import com.ptech.user.service.request.dto.UserRequestDTO;
import com.ptech.user.service.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody UserRequestDTO dto){
		return new ResponseEntity<User>(this.userService.createUser(dto),HttpStatus.OK);
	}
	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody UserRequestDTO dto){
		return new ResponseEntity<User>(this.userService.updateUser(dto),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Integer id){
		this.userService.deleteUser(id);
	}
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id){
		return new ResponseEntity<User>(this.userService.getUser(id),HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<List<User>>((this.userService.getAllUsers()),HttpStatus.OK);
	}
}
