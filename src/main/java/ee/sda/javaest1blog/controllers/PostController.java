package ee.sda.javaest1blog.controllers;

import ee.sda.javaest1blog.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
public class PostController {

    final PostService service;

    String showPosts(Model model){
        model.addAttribute("posts", service.getAllPosts());
        return "show-posts";
    }
}
