package com.aiapp.chat;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("/messages")
@RestController
public class ChatMessageController {
	@Autowired
	private ChatMessageService chatMessageService;
	
	@GetMapping("")
	public List<ChatMessageDTO> getAllMessages() {
		List<ChatMessage> msgList = chatMessageService.getAllMessages();
		List<ChatMessageDTO> DTOList = new LinkedList<ChatMessageDTO>();
		ChatMessageDtoMapper mapper = new ChatMessageDtoMapper();
		for (ChatMessage msg : msgList)
			DTOList.add(mapper.mapToDTO(msg));
		return DTOList;
	}
}
