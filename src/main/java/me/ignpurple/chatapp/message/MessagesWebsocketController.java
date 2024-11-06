package me.ignpurple.chatapp.message;

import me.ignpurple.chatapp.model.UserMessage;
import me.ignpurple.chatapp.repository.UserMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MessagesWebsocketController {
    @Autowired
    private UserMessageRepository messageRepository;

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public UserMessage message(UserMessage message) {
        this.messageRepository.save(message).subscribe();
        return message;
    }
}
