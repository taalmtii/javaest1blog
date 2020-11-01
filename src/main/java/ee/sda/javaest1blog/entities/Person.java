package ee.sda.javaest1blog.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue
    Long id;
    String name;
    @OneToMany(mappedBy = "author")
    List<Post> postList;
}
