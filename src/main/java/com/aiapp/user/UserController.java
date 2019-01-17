package com.aiapp.user;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RequestMapping("/users")
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("")
	public List<UserDTO> getAllUsers() {
		return userService.getAllUsers();
		
	}
	@GetMapping("/{username}")
	public UserDTO getUserByUsername(@PathVariable String username) {
		return userService.getUserByUserName(username);
	}	
	
	@PutMapping("/{username}")
	public void updateUser(@RequestBody UserDTO userDTO, @PathVariable String username) {
		userService.updateUser(userDTO);
	}
}
