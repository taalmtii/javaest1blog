package ee.sda.javaest1blog.services;

import ee.sda.javaest1blog.entities.User;
import ee.sda.javaest1blog.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    final UserRepository repository;

    public User findByUsername(String username){
        return repository.findByUsername(username);
    }
}
