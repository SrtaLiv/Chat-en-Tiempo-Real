package org.jpa.chatentiemporeal.service;

import org.jpa.chatentiemporeal.model.User;
import org.jpa.chatentiemporeal.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public ArrayList<User> getUsers() {
        return new ArrayList<>(userRepository.findAll());
    }

    @Override
    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void delete(User user) throws IOException {
        userRepository.delete(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
