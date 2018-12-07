package com.aiapp.message;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.aiapp.user.User;

@Entity
public class Message {
	@Id
	private Integer id;
	private String body;
	@ManyToOne
	private User sender;
	@ManyToOne
	private User reciver;

	public Message() {
	}

	public Message(Integer id, String body, User sender, User reciver) {
		this.id = id;
		this.body = body;
		this.sender = sender;
		this.reciver = reciver;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReciver() {
		return reciver;
	}

	public void setReciver(User reciver) {
		this.reciver = reciver;
	}

}
