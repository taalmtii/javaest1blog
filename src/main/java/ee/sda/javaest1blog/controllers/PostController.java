package ee.sda.javaest1blog.controllers;

import ee.sda.javaest1blog.entities.Post;
import ee.sda.javaest1blog.entities.User;
import ee.sda.javaest1blog.repositories.UserRepository;
import ee.sda.javaest1blog.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    final PostService service;
    final UserRepository userRepository;


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
        return new ModelAndView("redirect:/posts/show-posts");
    }

    @GetMapping("/edit-post/{postId}")
    String editPost(@PathVariable String postId, Model model){
        model.addAttribute(service.getPostById(postId));
        return "edit-post";
    }

    @GetMapping("/delete-post/{postId}")
    ModelAndView deletePost(@PathVariable String postId){
        service.deletePost(postId);
        return new ModelAndView("redirect:/posts/show-posts");
    }

}
