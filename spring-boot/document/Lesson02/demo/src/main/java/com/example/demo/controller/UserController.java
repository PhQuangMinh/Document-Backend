package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/intro")
    private String intro(Model model) {
        User user = new User("Minh", 20, "NA", "example@gmail.com");
        model.addAttribute("user", user);
        return "index";
    }
}
