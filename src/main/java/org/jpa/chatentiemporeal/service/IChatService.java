package org.jpa.chatentiemporeal.service;

import org.jpa.chatentiemporeal.model.Chat;
import org.jpa.chatentiemporeal.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IChatService {
    Chat save(Chat chat);
    List<Chat> findAll();
    Optional<Chat> findById(Long id);
    List<Chat> findChatsByUser(User user);
    void delete(Chat chat);
    Chat updateChat(Chat chat);
    void addUserToChat(Long chatId, Long userId);
    void removeUserFromChat(Long chatId, Long userId);
}