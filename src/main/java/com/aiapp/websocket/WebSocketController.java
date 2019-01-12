package com.aiapp.websocket;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
 
    private final SimpMessagingTemplate template;
 
    @Autowired
    public WebSocketController(final SimpMessagingTemplate template) {
        this.template = template;
    }
 
    @MessageMapping("/send/message")
    public void onReceiveMessage(final String message) {
        this.template.convertAndSend("/chat",
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + " ;" + message);
    }
}