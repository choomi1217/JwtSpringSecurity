package jwt.security.study.controller;

import jakarta.validation.Valid;
import jwt.security.study.service.SignUp;
import jwt.security.study.service.SignUp.SignUpUsecase.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
