package com.aiapp.user;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aiapp.advertisment.Advertisment;
import com.aiapp.advertisment.AdvertismentDTO;
import com.aiapp.advertisment.AdvertismentDtoMapper;

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
	@GetMapping("/{id}")
	public UserDTO getUserById(@PathVariable int id) {
		User user = userService.getUserById(id);
		UserDtoMapper mapper = new UserDtoMapper();
		return mapper.mapToDTO(user);
	}	

}
