package com.aiapp.chat;

public class ChatMessageDTO {

	private String date;
	private String message;
	private String username;
	
	public ChatMessageDTO() {
		
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
