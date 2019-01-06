package com.aiapp.message;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	@Autowired
	private MessageRepository messageRepository;

	public List<Message> getAllMessages(int userId) {
		List<Message> messageList = new ArrayList<>();
		return messageList;
	}

	public void addMessage(Message message) {
		messageRepository.save(message);
	}
}
