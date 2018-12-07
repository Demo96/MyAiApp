package com.aiapp.advertisment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.aiapp.user.User;

@Entity
public class Advertisment {
	@Id
	@GeneratedValue
	private Integer id;
	private String title;
	private String description;
	private int price;
	@ManyToOne
	private User user;

	public Advertisment() {
	}

	public Advertisment(Integer id, String title, String description, int price, User user) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDecsription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
