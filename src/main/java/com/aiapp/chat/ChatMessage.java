package com.aiapp.chat;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.aiapp.user.User;

@Entity
public class ChatMessage {
	@Id
	@GeneratedValue
	private Integer id;
	private String date;
	private String message;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	private User user;
	
	public ChatMessage() {
		
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
