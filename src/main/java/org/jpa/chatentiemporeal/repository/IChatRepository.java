package org.jpa.chatentiemporeal.repository;

import org.jpa.chatentiemporeal.model.Chat;
import org.jpa.chatentiemporeal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IChatRepository extends JpaRepository<Chat, Long> {
    
    @Query("SELECT c FROM Chat c JOIN c.usuarios u WHERE u = ?1")
    List<Chat> findByUsuariosContaining(User user);
}