package jwt.security.study.service;

import jwt.security.study.user.repository.User;
import jwt.security.study.user.SignUp;
import jwt.security.study.user.SignUp.SignUpUsecase.SignupRequest;
import org.junit.jupiter.api.Test;

class SignUpTest {
    SignUp signUp = new SignUp.SignUpUsecase(user -> new User());

    @Test
    void signUp() {
        signUp.signUp(new SignupRequest("test", "test", "test"));
    }
}