package jwt.security.study.service;

import jwt.security.study.dto.UserDto;
import jwt.security.study.entity.Authority;
import jwt.security.study.entity.User;
import jwt.security.study.repository.UserRepository;
import jwt.security.study.util.SecurityUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signUp(UserDto userDto){
        User findUser = userRepository.findOneWithAuthoritiesByUsername(userDto.getUsername())
                        .orElse(null);

        if( findUser != null){
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }

        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        User user = User.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .nickname(userDto.getNickname())
                .authority(Collections.singleton(authority))
                .activated(true)
                .build();

        return userRepository.save(user);
    }

    @Transactional
    public Optional<User> getUserWithAuthorities(String username){
        return userRepository.findOneWithAuthoritiesByUsername(username);
    }

    @Transactional
    public Optional<User> getUserWithAuthorities(){
        return SecurityUtil.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUsername);
    }

}
