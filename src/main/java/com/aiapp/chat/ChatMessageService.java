package com.aiapp.chat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aiapp.user.User;
import com.aiapp.user.UserRepository;

@Service
public class ChatMessageService {
	@Autowired
	private ChatMessageRepository chatMessageRepository;
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
    private SimpMessagingTemplate template;
   

	public List<ChatMessageDTO> getAllMessages() {
		List<ChatMessage> msgList = new ArrayList<>();
		chatMessageRepository.findAll().forEach(msgList::add);
		List<ChatMessageDTO> DTOList = new LinkedList<ChatMessageDTO>();
		ChatMessageDtoMapper mapper = new ChatMessageDtoMapper();
		for (ChatMessage msg : msgList)
			DTOList.add(mapper.mapToDTO(msg));
		return DTOList;
	}
	
	public void addChatMessage(String message) {
		ChatMessage msg = new ChatMessage();
    	String date=LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    	String username=message.split(";")[0];
    	msg.setMessage(message.split(";")[1]);
    	msg.setDate(date);
    	User user = userRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException(
				"User Not Found with -> username or email : " + username));
    	msg.setUser(user);
		chatMessageRepository.save(msg);
        this.template.convertAndSend("/chat",
                date + ";" + message);
	}
	
}
