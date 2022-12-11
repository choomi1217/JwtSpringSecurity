package jwt.security.study.user.web;

import jwt.security.study.user.SignUp;
import jwt.security.study.user.SignUp.SignUpUsecase.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final SignUp signUp;

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity signup(
            @RequestBody SignupRequest request
    ){
        signUp.signUp(request);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
