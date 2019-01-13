package com.aiapp.chat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;

import com.aiapp.user.User;
import com.aiapp.user.UserService;

@Controller
public class WebSocketController {
	@Autowired
	private ChatMessageService chatMessageService;
	@Autowired
	private UserService userService;
    private final SimpMessagingTemplate template;
 
    @Autowired
    public WebSocketController(final SimpMessagingTemplate template) {
        this.template = template;
    }
 
    @MessageMapping("/send/message")
    public void onReceiveMessage(final String message) {
    	ChatMessage msg = new ChatMessage();
    	String date=LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    	String username=message.split(";")[0];
    	msg.setMessage(message.split(";")[1]);
    	msg.setDate(date);
    	User user = userService.getUserByUserName(username).orElseThrow(() -> new UsernameNotFoundException(
				"User Not Found with -> username or email : " + username));
    	msg.setUser(user);
    	chatMessageService.addChatMessage(msg);
        this.template.convertAndSend("/chat",
             date + ";" + message);
    }
}