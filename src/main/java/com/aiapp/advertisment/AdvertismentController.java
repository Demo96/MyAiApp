package com.aiapp.advertisment;

import java.util.LinkedList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aiapp.user.User;
import com.aiapp.user.UserService;

@CrossOrigin
@RequestMapping("/advertisments")
@RestController
public class AdvertismentController {
	@Autowired
	private AdvertismentService advertismentService;
	@Autowired
	private UserService userService;
	@GetMapping("")
	public List<AdvertismentDTO> getAllAdvertisments() {
		List<Advertisment> advList = advertismentService.getAllAdvertisments();
		List<AdvertismentDTO> DTOList = new LinkedList<AdvertismentDTO>();
		AdvertismentDtoMapper mapper = new AdvertismentDtoMapper();
		for (Advertisment adv : advList)
			DTOList.add(mapper.mapToDTO(adv));
		return DTOList;
	}

	@GetMapping("/{id}")
	public AdvertismentDTO getAdvertismentById(@PathVariable int id) {
		Advertisment adv = advertismentService.getAdvertismentById(id);
		AdvertismentDtoMapper mapper = new AdvertismentDtoMapper();
		return mapper.mapToDTO(adv);
	}

	@PostMapping("")
	public void addAdvertisment(@RequestBody AdvertismentDTO advertisment) {
		AdvertismentDtoMapper mapper = new AdvertismentDtoMapper();
		User user = userService.getUserByUserName(advertisment.getUserName()).orElseThrow(() -> new UsernameNotFoundException(
				"User Not Found with -> username or email : " + advertisment.getUserName()));
		Advertisment adv =mapper.mapFromDTO(advertisment, user);
		advertismentService.addAdvertisment(adv);
	}

	@PutMapping("")
	public void updateOpinion(@RequestBody AdvertismentDTO advertisment) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		advertismentService.updateAdvertisment(modelMapper.map(advertisment, Advertisment.class));
	}

	@DeleteMapping("/{id}")
	public void deleteOpinion(@PathVariable int id) {
		advertismentService.deleteAdvertisment(id);
	}

}
