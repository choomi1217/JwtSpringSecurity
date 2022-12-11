package jwt.security.study.repository;

import jwt.security.study.entity.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static jwt.security.study.entity.User.init;

@FunctionalInterface
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
        public record SignupRequest(String username, String nickname, String password){
            public SignupRequest {
                if (username == null || username.isBlank()) {
                    throw new IllegalArgumentException("username은 필수값입니다.");
                }
                if (nickname == null || nickname.isBlank()) {
                    throw new IllegalArgumentException("nickname은 필수값입니다.");
                }
                if (password == null || password.isBlank()) {
                    throw new IllegalArgumentException("password는 필수값입니다.");
                }
            }

            private String encrypt(PasswordEncoder passwordEncoder){
                return passwordEncoder.encode(password);
            }
        }
    }

}
