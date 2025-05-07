package org.jpa.chatentiemporeal.controller;

import org.jpa.chatentiemporeal.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

}
