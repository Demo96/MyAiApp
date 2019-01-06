package com.aiapp.user;

import com.aiapp.user.User;

public class UserDtoMapper {

	UserDTO mapToDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setUserName(user.getUserName());
		userDTO.setPhoneNumber(user.getPhoneNumber());
		userDTO.setFirstName(user.getFirstName());
		userDTO.setSureName(user.getSureName());
		userDTO.setCity(user.getCity());
		userDTO.setAddress(user.getAddress());
		return userDTO;
	}

}
