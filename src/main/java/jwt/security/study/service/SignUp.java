package jwt.security.study.service;

import jwt.security.study.dto.UserDto;
import jwt.security.study.entity.User;
import jwt.security.study.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface SignUp{
    User signUp(UserDto userDto);

    @RequiredArgsConstructor
    class SignUpUsecase implements SignUp {

        private final UserRepository repository;
        private final PasswordEncoder passwordEncoder;

        @Override
        public User signUp(UserDto userDto){
            return  repository.signUp(UserRepository.format(userDto.getUsername(), userDto.getNickname(), userDto.getPassword()));
        }
    }
}

