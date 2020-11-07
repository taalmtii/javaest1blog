package ee.sda.javaest1blog.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
public class User {

    @GeneratedValue
    @Id
    Long id;
    String username;
    String password;
    String email;
    Date created;
    Date lastLogin;
    String firstName;
    String lastName;

    @OneToMany(mappedBy = "user")
    List<Post> postList;

}