package com.aiapp.user;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RequestMapping("/users")
@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("")
	public List<UserDTO> getAllUsers() {
		List<User> userList = userService.getAllUsers();
		List<UserDTO> DTOList = new LinkedList<UserDTO>();
		UserDtoMapper mapper = new UserDtoMapper();
		for (User user : userList)
			DTOList.add(mapper.mapToDTO(user));
		return DTOList;
	}
	@GetMapping("/{username}")
	public UserDTO getUserByUsername(@PathVariable String username) {
		User user = userService.getUserByUserName(username).orElseThrow(() -> new UsernameNotFoundException(
				"User Not Found with -> username : " + username));
		UserDtoMapper mapper = new UserDtoMapper();
		return mapper.mapToDTO(user);
	}	
	
	@DeleteMapping("/{username}")
	public void deleteAdvertisment(@PathVariable String username) {
		User user = userService.getUserByUserName(username).orElseThrow(() -> new UsernameNotFoundException(
				"User Not Found with -> username : " + username));
		userService.deleteUser(user.getId());
	}
}
