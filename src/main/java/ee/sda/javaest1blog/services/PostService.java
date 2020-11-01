package ee.sda.javaest1blog.services;

import ee.sda.javaest1blog.entities.Post;
import ee.sda.javaest1blog.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    final PostRepository repository;

    public List<Post> getAllPosts(){
        List<Post> postList = new ArrayList<>();
        repository.findAll().forEach(postList::add);
        return postList;
    }
}
