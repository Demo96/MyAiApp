package com.aiapp.advertisment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aiapp.user.User;
import com.aiapp.user.UserRepository;
import com.aiapp.user.UserService;
@Service
public class AdvertismentService {
	@Autowired
	private AdvertismentRepository advertismentRepository;
	@Autowired
	private UserRepository userRepository;
	public List<AdvertismentDTO> getAllAdvertisments() {
		List<Advertisment> advertismentList = new ArrayList<>();
		advertismentRepository.findAll().forEach(advertismentList::add);
		List<AdvertismentDTO> DTOList = new LinkedList<AdvertismentDTO>();
		AdvertismentDtoMapper mapper = new AdvertismentDtoMapper();
		for (Advertisment adv : advertismentList)
			DTOList.add(mapper.mapToDTO(adv));
		return DTOList;
	}

	public AdvertismentDTO getAdvertismentById(int id) {
		Advertisment advertisment= advertismentRepository.findOne(id);
		AdvertismentDtoMapper mapper = new AdvertismentDtoMapper();
		 return mapper.mapToDTO(advertisment);
	}

	public void addAdvertisment(AdvertismentDTO advertismentDTO) {
		AdvertismentDtoMapper mapper = new AdvertismentDtoMapper();
		User user = userRepository.findByUserName(advertismentDTO.getUserName()).orElseThrow(() -> new UsernameNotFoundException(
				"User Not Found with -> username or email : " + advertismentDTO.getUserName()));
		Advertisment adv =mapper.mapFromDTO(advertismentDTO, user);
		advertismentRepository.save(adv);
	}

	public void updateAdvertisment(AdvertismentDTO advertismentDTO, int id) {
		AdvertismentDtoMapper mapper = new AdvertismentDtoMapper();
		User user = userRepository.findByUserName(advertismentDTO.getUserName()).orElseThrow(() -> new UsernameNotFoundException(
				"User Not Found with -> username or email : " + advertismentDTO.getUserName()));
		Advertisment adv =mapper.mapFromDTO(advertismentDTO, user);
		adv.setId(id);
		advertismentRepository.save(adv);
	}

	public void deleteAdvertisment(int id) {
		advertismentRepository.delete(id);
	}

}
