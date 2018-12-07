package com.aiapp.opinion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users/{userId}/opinions")
@RestController
public class OpinionController {
	@Autowired
	private OpinionService opinionService;

	@GetMapping("")
	public List<Opinion> getAllOpinions(@PathVariable int userId) {
		return opinionService.getAllOpinions(userId);
	}

	// TODO check if opinion for bad user can be shown by hacking
	@GetMapping("/{id}")
	public Opinion getOpinionById(@PathVariable int id) {
		return opinionService.getOpinionById(id);
	}

	@PostMapping("")
	public void addOpinion(@RequestBody Opinion opinion, @PathVariable int userId) {
		if (opinion.getEvaluatedUser().getId() == userId)
			opinionService.addOpinion(opinion);
		else
			throw new IllegalArgumentException("evaluatedUser id different from userId");
	}

	@PutMapping("")
	public void updateOpinion(@RequestBody Opinion opinion, @PathVariable int userId) {
		if (opinion.getEvaluatedUser().getId() == userId)
			opinionService.updateOpinion(opinion);
		else
			throw new IllegalArgumentException("evaluatedUser id different from userId");
	}

	@DeleteMapping("/{id}")
	public void deleteOpinion(@PathVariable int id, @PathVariable int userId) {
		if (opinionService.getOpinionById(id).getId() == userId)
			opinionService.deleteOpinion(id);
		else
			throw new IllegalArgumentException("evaluatedUser id different from userId");
	}

}
