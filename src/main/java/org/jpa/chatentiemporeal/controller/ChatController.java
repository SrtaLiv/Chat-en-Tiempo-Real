package org.jpa.chatentiemporeal.controller;

import org.jpa.chatentiemporeal.model.Chat;
import org.jpa.chatentiemporeal.service.IChatService;
import org.jpa.chatentiemporeal.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatController {

    private final IChatService chatService;
    private final IUserService userService;

    public ChatController(IChatService chatService, IUserService userService) {
        this.chatService = chatService;
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createChat(@RequestBody List<Long> userIds) {
        Chat chat = new Chat();
        for (Long userId : userIds) {
            userService.getById(userId).ifPresent(user -> chat.getUsuarios().add(user));
        }
        Chat savedChat = chatService.save(chat);
        return ResponseEntity.ok(savedChat);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserChats(@PathVariable Long userId) {
        return userService.getById(userId)
                .map(user -> ResponseEntity.ok(chatService.findChatsByUser(user)))
                .orElse(ResponseEntity.notFound().build());
    }
}