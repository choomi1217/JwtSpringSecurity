package jwt.security.study.service;

import jwt.security.study.entity.User;
import jwt.security.study.repository.UserRepository;
import lombok.RequiredArgsConstructor;

public interface SignUp{
    User signUp(SignUpUsecase.SignupRequest request);

    @RequiredArgsConstructor
    class SignUpUsecase implements SignUp {

        private final UserRepository repository;

        @Override
        public User signUp(UserDto userDto){
            return  repository.signUp(UserRepository.format(userDto.getUsername(), userDto.getNickname(), userDto.getPassword()));
        }

        public record SignupRequest(String username, String nickname, String password){
            public SignupRequest{
                if(username.length() > 50 || nickname.length() > 100 || password.length() > 50){
                    throw new IllegalArgumentException("확인");
                }
            }
        }
    }
}

