package jwt.security.study.repository;

import jwt.security.study.entity.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static jwt.security.study.entity.User.init;

public interface UserRepository {


    User signUp(UserRdbmsRepository.SignupRequest request);


    static UserRdbmsRepository.SignupRequest format(String username, String nickname, String password){
        return new UserRdbmsRepository.SignupRequest(username,nickname,password);
    }
    @Service
    @RequiredArgsConstructor
    class UserRdbmsRepository implements UserRepository{

        private final UserJpaRepository userRepository;
        private final PasswordEncoder passwordEncoder;

        @Override
        public User signUp(SignupRequest request){
            if( userRepository.existsByUsername(request.username)){
                throw new IllegalArgumentException("이미 가입되어 있는 유저입니다.");
            }
            return userRepository.save(init(request.username,request.nickname,request.encrypt(passwordEncoder)));
        }


        @AllArgsConstructor
        private static class SignupRequest{
            private String username;
            private String nickname;
            private String password;

            private String encrypt(PasswordEncoder encoder){
                return encoder.encode(password);
            }
        }
    }

}
