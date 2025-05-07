package org.jpa.chatentiemporeal.config;

import org.jpa.chatentiemporeal.model.Mensaje;
import org.jpa.chatentiemporeal.model.User;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    
    // si se envía un mensaje al /hellodestino, greeting()se llame al método.
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting(
                HtmlUtils.htmlEscape(message.getName()) 
                + ":"
                + HtmlUtils.htmlEscape(message.getMessage()));
    }

    @MessageMapping("/normal")
    // si se envía un mensaje al /hellodestino, greeting()se llame al método.
    @SendTo("/topic/greetings")
    public Greeting normal(User user, Mensaje message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("User:, " + user.getUsername() +
                HtmlUtils.htmlEscape(message.getContenido()));
    }
}