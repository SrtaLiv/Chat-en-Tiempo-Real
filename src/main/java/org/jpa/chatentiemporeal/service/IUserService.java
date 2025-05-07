package org.jpa.chatentiemporeal.service;

import org.jpa.chatentiemporeal.model.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Service
public interface IUserService {
    User save(User user);
    ArrayList<User> getUsers();
    Optional<User> getById(Long id);
    void delete(User user) throws IOException;
    User updateUser(User user);
}
