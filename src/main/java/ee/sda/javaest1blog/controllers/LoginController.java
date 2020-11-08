package ee.sda.javaest1blog.controllers;

import ee.sda.javaest1blog.entities.Role;
import ee.sda.javaest1blog.entities.User;
import ee.sda.javaest1blog.services.RegisterService;
import ee.sda.javaest1blog.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

@RequiredArgsConstructor
@Controller
public class LoginController {


    final RegisterService registerService;
    final RoleService roleService;

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

    @GetMapping("/create-role")
    String createRole(){
        return "create-role";
    }

    @PostMapping("/create-role")
    String createRole(@ModelAttribute Role role, Model model){
        model.addAttribute("user", roleService.save(role));
        return "redirect:/posts/show-posts";
    }

    @GetMapping("/logout")
    String logout(HttpServletRequest req, HttpServletResponse res){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        new SecurityContextLogoutHandler().logout(req, res, auth);
        return "redirect:/posts/show-posts";
    }

}
