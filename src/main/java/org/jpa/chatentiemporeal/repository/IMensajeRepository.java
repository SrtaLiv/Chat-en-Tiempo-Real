package org.jpa.chatentiemporeal.repository;

import org.jpa.chatentiemporeal.model.Chat;
import org.jpa.chatentiemporeal.model.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMensajeRepository extends JpaRepository<Mensaje, Long> {
    
    List<Mensaje> findByChatOrderByFechaEnvioDesc(Chat chat);
    
    @Query("SELECT m FROM Mensaje m WHERE m.chat = ?1 AND m.contenido LIKE %?2%")
    List<Mensaje> searchMessages(Chat chat, String keyword);
}