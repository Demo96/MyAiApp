package com.aiapp.user;

import com.aiapp.user.User;

public class UserDtoMapper {

	UserDTO mapToDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName(user.getUserName());
		userDTO.setPhoneNumber(user.getPhoneNumber());
		userDTO.setFirstName(user.getFirstName());
		userDTO.setSureName(user.getSureName());
		userDTO.setCity(user.getCity());
		userDTO.setAddress(user.getAddress());
		return userDTO;
	}

	public User mapFromDTO(UserDTO userDTO) {
		User user = new User();
		user.setUserName(userDTO.getUserName());
		user.setFirstName(userDTO.getFirstName());
		user.setSureName(userDTO.getSureName());
		user.setPhoneNumber(userDTO.getPhoneNumber());
		user.setCity(userDTO.getCity());
		user.setAddress(userDTO.getAddress());
		return user;
	}

}
