package jwt.security.study.entity;

import jakarta.persistence.*;
import lombok.*;

@Embeddable
public class Authorities {
    private Authority authorityName;

    enum Authority{
    }
}
