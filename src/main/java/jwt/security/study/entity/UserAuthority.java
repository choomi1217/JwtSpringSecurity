package jwt.security.study.entity;


import jakarta.persistence.*;
import lombok.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
public class UserAuthority {
    @Id
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "authority_name")
    private Long authorityName;
}
