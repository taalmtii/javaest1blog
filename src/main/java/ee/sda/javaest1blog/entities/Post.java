package ee.sda.javaest1blog.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
public class Post {

    @GeneratedValue
    @Id
    Long id;
    String text;
    Date created;
    Date updated;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
    Boolean isPrivate;
}
