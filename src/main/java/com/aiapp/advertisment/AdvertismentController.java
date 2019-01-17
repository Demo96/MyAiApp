package com.aiapp.advertisment;

import java.util.LinkedList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

	
	
	@GetMapping("")
	public List<AdvertismentDTO> getAllAdvertisments() {
		return advertismentService.getAllAdvertisments();
	}
	
	@GetMapping("/{id}")
	public AdvertismentDTO getAdvertismentById(@PathVariable int id) {
		return advertismentService.getAdvertismentById(id);
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("")
	public void addAdvertisment(@RequestBody AdvertismentDTO advertisment) {
		
		advertismentService.addAdvertisment(advertisment);
	}
	
	@PreAuthorize("isAuthenticated()")
	@PutMapping("/{id}")
	public void updateAdvertisment(@RequestBody AdvertismentDTO advertisment, @PathVariable int id) {

		advertismentService.updateAdvertisment(advertisment, id);
	}
	
	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/{id}")
	public void deleteAdvertisment(@PathVariable int id) {
		advertismentService.deleteAdvertisment(id);
	}

}
