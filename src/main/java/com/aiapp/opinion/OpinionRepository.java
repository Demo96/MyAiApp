package com.aiapp.opinion;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OpinionRepository extends CrudRepository<Opinion, Integer> {
	public List<Opinion> findByEvaluatedUserId(int userId);
	//public List<Opinion> findByEvaluatingUserId(int userId);
}
