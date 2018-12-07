package com.aiapp.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<>();
		userRepository.findAll().forEach(userList::add);
		return userList;
	}

	public User getUserById(int id) {
		return userRepository.findOne(id);
	}

	public void addUser(User user) {
		userRepository.save(user);
	}

	public void updateUser(int id, User user) {
		user.setId(id);
		userRepository.save(user);
	}

	public void deleteUser(int id) {
		userRepository.delete(id);
	}

}
