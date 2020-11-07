package ee.sda.javaest1blog.services;

import ee.sda.javaest1blog.entities.User;
import ee.sda.javaest1blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RegisterService {

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    UserRepository userRepository;

    public User createUser(User user){
        user.setCreated(new Date());
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
