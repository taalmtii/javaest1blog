package ee.sda.javaest1blog.controllers;

import ee.sda.javaest1blog.entities.User;
import ee.sda.javaest1blog.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    RegisterService registerService;

    @GetMapping("/login")
    String login(){
        return "login";
    }

    @GetMapping("/register")
    String register(){
        return "register";
    }

    @PostMapping("/register")
    String createUser(@ModelAttribute User user, Model model){
        model.addAttribute("user", registerService.createUser(user));
        return "created";
    }
}
