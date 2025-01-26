package com.RestaurantWebApp.controller;

import com.RestaurantWebApp.config.UserSession;
import com.RestaurantWebApp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final UserSession userSession;
    private final UserService userService;

    public HomeController(UserSession userSession, UserService userService) {
        this.userSession = userSession;
        this.userService = userService;
    }

    @GetMapping("/")
    public String nonLoggedIndex() {
        if (userSession.isLoggedIn()) {
            return "redirect:/home";
        }

        return "index";
    }

    @GetMapping("/home")
    @Transactional
    public String loggedInIndex(Model model) {
        if (!userSession.isLoggedIn()) {
            return "redirect:/";
        }



        return "home";
    }
}
