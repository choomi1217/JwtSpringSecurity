package jwt.security.study.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

import static java.util.Collections.singletonList;
import static jwt.security.study.entity.Authorities.defaultAuthority;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "username", length = 50, unique = true)
    private String username;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "nickname", length = 50)
    private String nickname;

    @Column(name = "activated")
    private Boolean activated;

    @ElementCollection
    private List<Authorities> authority;


    private User(String username,
                 String password,
                 String nickname,
                 Boolean activated,
                 List<Authorities> authority) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.activated = activated;
        this.authority = authority;
    }

    public static User init(
            String username,
            String nickname,
            String password
    ){
        return new User(
                username,
                nickname,
                password,
                Boolean.TRUE,
                defautAuthority()
        );
    }
    private static List<Authorities> defautAuthority(){
        return singletonList(defaultAuthority());
    }
}
