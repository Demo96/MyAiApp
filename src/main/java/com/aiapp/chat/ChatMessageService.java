package com.aiapp.chat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
   

	public List<ChatMessage> getAllMessages() {
		List<ChatMessage> msgList = new ArrayList<>();
		chatMessageRepository.findAll().forEach(msgList::add);
		return msgList;
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
