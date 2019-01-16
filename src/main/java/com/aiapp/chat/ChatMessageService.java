package com.aiapp.chat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatMessageService {
	@Autowired
	private ChatMessageRepository chatMessageRepository;

	public List<ChatMessage> getAllMessages() {
		List<ChatMessage> msgList = new ArrayList<>();
		chatMessageRepository.findAll().forEach(msgList::add);
		return msgList;
	}
	
	public void addChatMessage(ChatMessage msg) {
		chatMessageRepository.save(msg);
	}
	
}
