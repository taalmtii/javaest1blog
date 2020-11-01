package ee.sda.javaest1blog.controllers;

import ee.sda.javaest1blog.entities.Post;
import ee.sda.javaest1blog.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class PostController {

    final PostService service;

    @GetMapping("/show-posts")
    String showPosts(Model model){
        model.addAttribute("posts", service.getAllPosts());
        return "show-posts";
    }

    @GetMapping("/create-post")
    String createPost(){
        return "create-post";
    }

    @PostMapping("/save-post")
    ModelAndView savePost(@ModelAttribute Post post){
        service.savePost(post);
        return new ModelAndView("redirect:/show-posts");
    }

}
