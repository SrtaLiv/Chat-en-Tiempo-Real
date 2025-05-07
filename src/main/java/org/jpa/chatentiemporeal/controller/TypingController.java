package org.jpa.chatentiemporeal.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TypingController {

    private final SimpMessagingTemplate messagingTemplate;

    public TypingController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/chat.typing")
    public void notifyTyping(@Payload Map<String, Object> payload) {
        String username = (String) payload.get("username");
        Long chatId = Long.valueOf(payload.get("chatId").toString());
        boolean isTyping = (boolean) payload.get("isTyping");
        
        Map<String, Object> response = new HashMap<>();
        response.put("username", username);
        response.put("isTyping", isTyping);
        
        messagingTemplate.convertAndSend("/topic/chat/" + chatId + "/typing", response);
    }
}