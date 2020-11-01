package ee.sda.javaest1blog.repositories;

import ee.sda.javaest1blog.entities.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
