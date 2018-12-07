package com.aiapp.advertisment;

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
@CrossOrigin
@RequestMapping("/advertisments")
@RestController
public class AdvertismentController {
	@Autowired
	private AdvertismentService advertismentService;

	@GetMapping("")
	public List<Advertisment> getAllAdvertisments() {
		return advertismentService.getAllAdvertisments();
	}

	@GetMapping("/{id}")
	public Advertisment getAdvertismentById(@PathVariable int id) {
		return advertismentService.getAdvertismentById(id);
	}

	@PostMapping("")
	public void addAdvertisment(@RequestBody Advertisment advertisment) {
			advertismentService.addAdvertisment(advertisment);

	}

	@PutMapping("")
	public void updateOpinion(@RequestBody Advertisment advertisment) {
			advertismentService.updateAdvertisment(advertisment);
	}

	@DeleteMapping("/{id}")
	public void deleteOpinion(@PathVariable int id) {
			advertismentService.deleteAdvertisment(id);
	}

}
