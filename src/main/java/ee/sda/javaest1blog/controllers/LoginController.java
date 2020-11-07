package ee.sda.javaest1blog.controllers;

import ee.sda.javaest1blog.entities.User;
import ee.sda.javaest1blog.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    RegisterService registerService;

    @GetMapping("/login")
    String login(){
        return "login";
    }

    @PreAuthorize("hasAuthority('CREATE_USER')")
    @GetMapping("/register")
    String register(){
        return "register";
    }

    @PostMapping("/register")
    String createUser(@ModelAttribute User user, Model model){
        model.addAttribute("user", registerService.createUser(user));
        return "created";
    }

    @GetMapping(value="/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request,response, auth);
        }
        return "redirect:/posts/show-posts";
    }
}
