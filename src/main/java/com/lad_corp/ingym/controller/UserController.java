package com.lad_corp.ingym.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lad_corp.ingym.payload.UserDTO;
import com.lad_corp.ingym.service.UserService;

@RestController
@RequestMapping(value="/api/users")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		return new ResponseEntity<List<UserDTO>>(userService.getAllUsers(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDto){
		return new ResponseEntity<UserDTO>(userService.createUser(userDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUserByid(@PathVariable(name ="id") Long id){
		return new ResponseEntity<UserDTO>(userService.getUserByid(id),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> updatePost( @RequestBody UserDTO userDto, @PathVariable(name="id") Long id){
		return new ResponseEntity<UserDTO>(userService.updateUser(userDto, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePost(@PathVariable(name="id") Long id){
		userService.getUserByid(id);
		return new ResponseEntity<String>("User deleted sucessfully.", HttpStatus.OK);
	}
	
}
