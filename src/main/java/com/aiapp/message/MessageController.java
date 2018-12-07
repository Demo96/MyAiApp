package com.aiapp.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//TODO get and add and reqmap url(so all todo to be sure xD)
@RequestMapping("/users/{userId}/messages/{userId2}")
@RestController
public class MessageController {
	@Autowired
	private MessageService messageService;

	@GetMapping("")
	public List<Message> getAllMessages(@PathVariable int userId,@PathVariable int userId2) {
		return messageService.getAllMessages(userId);
	}

	@PostMapping("")
	public void addMessage(@RequestBody Message message, @PathVariable int userId,@PathVariable int userId2) {
		if (message.getSender().getId() == userId)
			messageService.addMessage(message);
		else
			throw new IllegalArgumentException("evaluatedUser id different from userId");
	}
}
