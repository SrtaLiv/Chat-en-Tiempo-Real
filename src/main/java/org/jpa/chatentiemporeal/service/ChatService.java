package org.jpa.chatentiemporeal.service;

import org.jpa.chatentiemporeal.model.Chat;
import org.jpa.chatentiemporeal.model.User;
import org.jpa.chatentiemporeal.repository.IChatRepository;
import org.jpa.chatentiemporeal.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChatService implements IChatService {

    private final IChatRepository chatRepository;
    private final IUserRepository userRepository;

    public ChatService(IChatRepository chatRepository, IUserRepository userRepository) {
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Chat save(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public List<Chat> findAll() {
        return chatRepository.findAll();
    }

    @Override
    public Optional<Chat> findById(Long id) {
        return chatRepository.findById(id);
    }

    @Override
    public List<Chat> findChatsByUser(User user) {
        return chatRepository.findAll().stream()
                .filter(chat -> chat.getUsuarios().contains(user))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Chat chat) {
        chatRepository.delete(chat);
    }

    @Override
    public Chat updateChat(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public void addUserToChat(Long chatId, Long userId) {
        Optional<Chat> chatOpt = chatRepository.findById(chatId);
        Optional<User> userOpt = userRepository.findById(userId);
        
        if (chatOpt.isPresent() && userOpt.isPresent()) {
            Chat chat = chatOpt.get();
            User user = userOpt.get();
            
            if (!chat.getUsuarios().contains(user)) {
                chat.getUsuarios().add(user);
                chatRepository.save(chat);
            }
        }
    }

    @Override
    public void removeUserFromChat(Long chatId, Long userId) {
        Optional<Chat> chatOpt = chatRepository.findById(chatId);
        Optional<User> userOpt = userRepository.findById(userId);
        
        if (chatOpt.isPresent() && userOpt.isPresent()) {
            Chat chat = chatOpt.get();
            User user = userOpt.get();
            
            chat.getUsuarios().remove(user);
            chatRepository.save(chat);
        }
    }
}