package com.aiapp.user;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<UserDTO> getAllUsers() {
		List<User> userList = new ArrayList<>();
		userRepository.findAll().forEach(userList::add);
		List<UserDTO> DTOList = new LinkedList<UserDTO>();
		UserDtoMapper mapper = new UserDtoMapper();
		for (User user : userList)
			DTOList.add(mapper.mapToDTO(user));
		return DTOList;
	}

	public User getUserById(int id) {
		return userRepository.findOne(id);
	}
	
	public UserDTO getUserByUserName(String userName) {
		User user = userRepository.findByUserName(userName).orElseThrow(() -> new UsernameNotFoundException(
				"User Not Found with -> username : " + userName));
		UserDtoMapper mapper = new UserDtoMapper();
		return mapper.mapToDTO(user);
	}

	public void addUser(User user) {
		userRepository.save(user);
	}

	public void updateUser(UserDTO userDTO) {
		UserDtoMapper mapper = new UserDtoMapper();
		User user = userRepository.findByUserName(userDTO.getUserName()).orElseThrow(() -> new UsernameNotFoundException(
				"User Not Found with -> username: " + userDTO.getUserName()));
		User newUser =mapper.mapFromDTO(userDTO);
		newUser.setId(user.getId());
		newUser.setPassword(user.getPassword());
		newUser.setRoles(user.getRoles());
		userRepository.save(newUser);
	}

	public void deleteUser(int id) {
		userRepository.delete(id);
	}

}
