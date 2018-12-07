package com.aiapp.opinion;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.aiapp.user.User;
//TODO user can not add opinion twice for same user
@Entity
public class Opinion {
	@Id
	private Integer id;
	private String decsription;
	private int rating;
	@ManyToOne
	private User evaluatedUser;
	@ManyToOne
	private User evaluatingUser;

	public Opinion() {
	}

	public Opinion(Integer id, String decsription, int rating, User evaluatedUser, User evaluatingUser) {
		this.id = id;
		this.decsription = decsription;
		this.rating = rating;
		this.evaluatedUser = evaluatedUser;
		this.evaluatingUser = evaluatingUser;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDecsription() {
		return decsription;
	}

	public void setDecsription(String decsription) {
		this.decsription = decsription;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public User getEvaluatedUser() {
		return evaluatedUser;
	}

	public void setEvaluatedUser(User evaluatedUser) {
		this.evaluatedUser = evaluatedUser;
	}

	public User getEvaluatingUser() {
		return evaluatingUser;
	}

	public void setEvaluatingUser(User evaluatingUser) {
		this.evaluatingUser = evaluatingUser;
	}
}
