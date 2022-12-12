package jwt.security.study.user;

import jwt.security.study.user.entity.User;
import jwt.security.study.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface SignUp{
    User signUp(SignupRequest request);

    @Service
    @RequiredArgsConstructor
    class SignUpUsecase implements SignUp {

        private final UserRepository repository;

        @Override
        public User signUp(SignupRequest request){
            return  repository.signUp(UserRepository.format(request.username(), request.nickname(), request.password()));
        }
    }
}

