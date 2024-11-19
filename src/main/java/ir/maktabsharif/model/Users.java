package ir.maktabsharif.model;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;




@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQuery(name = "User.findByUsernameAndPassword",query = "select u from Users u where username = ?1 and password = ?2")
public abstract class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;


}
