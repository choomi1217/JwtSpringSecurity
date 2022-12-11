package jwt.security.study.service;

import jwt.security.study.entity.User;
import jwt.security.study.service.SignUp.SignUpUsecase.SignupRequest;
import org.junit.jupiter.api.Test;

import static org.springframework.security.crypto.factory.PasswordEncoderFactories.createDelegatingPasswordEncoder;

class SignUpTest {
    SignUp signUp = new SignUp.SignUpUsecase(user -> new User());

    @Test
    void signUp() {
        signUp.signUp(new SignupRequest("test", "test", "test"));
    }
}