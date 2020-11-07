package ee.sda.javaest1blog.repositories;

import ee.sda.javaest1blog.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    public User findByUsername(String username);
}
