package jwt.security.study.user.repository;

import jwt.security.study.user.SignupRequest;
import jwt.security.study.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static jwt.security.study.user.entity.User.init;

@FunctionalInterface
public interface UserRepository {
    User signUp(SignupRequest request);


    static SignupRequest format(String username, String nickname, String password){
        return new SignupRequest(username,nickname,password);
    }

    @Service
    @RequiredArgsConstructor
    class UserRdbmsRepository implements UserRepository{
        private final UserJpaRepository userJpaRepository;
        private final PasswordEncoder passwordEncoder;

        @Override
        public User signUp(SignupRequest request){
            if( userJpaRepository.existsByUsername(request.username())){
                throw new IllegalArgumentException("이미 가입되어 있는 유저입니다.");
            }

            User user = init(request.username(),request.nickname(), request.encrypt(passwordEncoder));

            return userJpaRepository.save(user);
        }
    }

}
