package org.jpa.chatentiemporeal.controller;

import org.jpa.chatentiemporeal.model.Mensaje;
import org.jpa.chatentiemporeal.model.User;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class MensajeController {

    private final SimpMessagingTemplate messagingTemplate;

    public MensajeController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/chat.sendMessage")
    public void sendMessage(@Payload Mensaje mensaje) {
        mensaje.setFechaEnvio(LocalDateTime.now());
        messagingTemplate.convertAndSend("/topic/public", mensaje);
    }

    @MessageMapping("/chat.privateMessage")
    public void sendPrivateMessage(@Payload Mensaje mensaje) {
        mensaje.setFechaEnvio(LocalDateTime.now());
        User receptor = mensaje.getChat().getUsuarios().stream()
                .filter(user -> !user.getId().equals(mensaje.getEmisor().getId()))
                .findFirst()
                .orElse(null);
        
        if (receptor != null) {
            messagingTemplate.convertAndSendToUser(
                    receptor.getUsername(),
                    "/queue/messages",
                    mensaje
            );
        }
    }
}