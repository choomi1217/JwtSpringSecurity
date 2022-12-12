package jwt.security.study.service;

import jwt.security.study.user.SignupRequest;
import jwt.security.study.user.entity.User;
import jwt.security.study.user.SignUp;
import org.junit.jupiter.api.Test;

class SignUpTest {
    SignUp signUp = new SignUp.SignUpUsecase(user -> new User());

    @Test
    void signUp() {
        signUp.signUp(new SignupRequest("test", "test", "test"));
    }
}