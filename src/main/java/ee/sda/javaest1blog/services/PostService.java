package ee.sda.javaest1blog.services;

import ee.sda.javaest1blog.entities.Post;
import ee.sda.javaest1blog.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    final PostRepository repository;
    final UserService userService;

    public List<Post> getAllPosts(){
        List<Post> postList = new ArrayList<>();
        repository.findAll().forEach(postList::add);
        return postList;
    }

    public Post getPostById(String id){
        return repository.findById(Long.valueOf(id)).get();
    }

    public Post savePost(Post post){
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        post.setUser(userService.findByUsername(principal.getName()));
        post.setUpdated(new Date());
        if(post.getId() != null){
            post.setCreated(new Date());
        }
        return repository.save(post);
    }

    public void deletePost(String postId){
        repository.deleteById(Long.valueOf(postId));
    }
}
