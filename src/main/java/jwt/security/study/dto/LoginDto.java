package jwt.security.study.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    @NotNull
    @Size(max = 50, min = 3)
    private String username;

    @NotNull
    @Size(min = 3, max = 100)
    private String password;

}
