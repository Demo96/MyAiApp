package com.aiapp.advertisment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AdvertismentService {
	@Autowired
	private AdvertismentRepository advertismentRepository;

	public List<Advertisment> getAllAdvertisments() {
		List<Advertisment> advertismentList = new ArrayList<>();
		advertismentRepository.findAll().forEach(advertismentList::add);
		return advertismentList;
	}

	public Advertisment getAdvertismentById(int id) {
		return advertismentRepository.findOne(id);
	}

	public void addAdvertisment(Advertisment advertisment) {
		advertismentRepository.save(advertisment);
	}

	public void updateAdvertisment(Advertisment advertisment) {
		advertismentRepository.save(advertisment);
	}

	public void deleteAdvertisment(int id) {
		advertismentRepository.delete(id);
	}

}
