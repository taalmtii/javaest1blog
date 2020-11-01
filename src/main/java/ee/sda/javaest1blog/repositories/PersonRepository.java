package ee.sda.javaest1blog.repositories;

import ee.sda.javaest1blog.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
