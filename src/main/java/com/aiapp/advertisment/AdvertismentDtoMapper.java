package com.aiapp.advertisment;

import com.aiapp.user.User;

public class AdvertismentDtoMapper {

	AdvertismentDTO mapToDTO(Advertisment adv) {
		AdvertismentDTO advDTO = new AdvertismentDTO();
		User user = adv.getUser();
		advDTO.setId(adv.getId());
		advDTO.setTitle(adv.getTitle());
		advDTO.setDescription(adv.getDescription());
		advDTO.setPrice(adv.getPrice());
		advDTO.setUserName(user.getUserName());
		advDTO.setPhoneNumber(user.getPhoneNumber());
		advDTO.setCity(user.getCity());
		advDTO.setAddress(user.getAddress());
		advDTO.setImage(adv.getImage());
		return advDTO;

	}

	Advertisment mapFromDTO(AdvertismentDTO advDTO, User user) {
		Advertisment adv = new Advertisment();
		adv.setTitle(advDTO.getTitle());
		adv.setDecsription(advDTO.getDescription());
		adv.setPrice(advDTO.getPrice());
		adv.setUser(user);
		adv.setImage(advDTO.getImage());
		return adv;
	}
}
