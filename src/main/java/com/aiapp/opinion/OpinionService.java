package com.aiapp.opinion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class OpinionService {
	@Autowired
	private OpinionRepository opinionRepository;

	public List<Opinion> getAllOpinions(int userId) {
		List<Opinion> opinionList = new ArrayList<>();
		opinionRepository.findByEvaluatedUserId(userId).forEach(opinionList::add);
		return opinionList;
	}

	public Opinion getOpinionById(int id) {
		return opinionRepository.findOne(id);
	}

	public void addOpinion(Opinion opinion) {
		opinionRepository.save(opinion);
	}

	public void updateOpinion(Opinion opinion) {
		opinionRepository.save(opinion);
	}

	public void deleteOpinion(int id) {
		opinionRepository.delete(id);
	}

}
