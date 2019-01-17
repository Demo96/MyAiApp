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


    @MessageMapping("/send/message")
    public void onReceiveMessage(final String message) {
    	chatMessageService.addChatMessage(message);
    }
}