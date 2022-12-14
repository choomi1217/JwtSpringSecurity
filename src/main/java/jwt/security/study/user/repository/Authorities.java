package jwt.security.study.user.repository;

import jakarta.persistence.*;
import lombok.*;

import static jwt.security.study.user.repository.Authorities.Authority.ROLE_USER;
import static lombok.AccessLevel.PROTECTED;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
public class Authorities {
    private Authority authorityName;

    public static Authorities defaultAuthority(){
        return new Authorities(ROLE_USER);
    }
    enum Authority{
        ROLE_USER
    }
}
