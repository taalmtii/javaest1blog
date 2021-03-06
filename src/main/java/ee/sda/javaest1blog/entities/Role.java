package ee.sda.javaest1blog.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Role {

    @GeneratedValue
    @Id
    Long id;
    String name;

    @ManyToMany
    @JoinTable(
            name = "role_user",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    List<User> users;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    List<Privilege> privileges;


}
