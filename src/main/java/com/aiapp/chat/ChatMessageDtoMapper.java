package com.aiapp.chat;

import com.aiapp.user.User;

public class ChatMessageDtoMapper {

	ChatMessageDTO mapToDTO(ChatMessage msg) {
		ChatMessageDTO msgDTO = new ChatMessageDTO();
		msgDTO.setUsername(msg.getUser().getUserName());
		msgDTO.setDate(msg.getDate());
		msgDTO.setMessage(msg.getMessage());
		return msgDTO;
	}
	ChatMessage mapFromDTO(ChatMessageDTO msgDTO,User user) {
		ChatMessage msg = new ChatMessage();
		msg.setDate(msgDTO.getDate());
		msg.setMessage(msgDTO.getMessage());
		msg.setUser(user);
		return msg;
	}
}
