package jwt.security.study.service;

import jwt.security.study.user.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//DB에서 찾아보고 있으면 UserDetails 반환
@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

//    private final UserJpaRepository userRepository;

//    public CustomUserDetailsService(UserJpaRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String username) {
        return null;
    }

    private org.springframework.security.core.userdetails.User createUser(String username, User user) {
//
//        List<GrantedAuthority> grantedAuthorities = user.getAuthority().stream()
//                .map(authority -> {
//                    return new SimpleGrantedAuthority(authority.getAuthorityName());
//                })
//                .collect(Collectors.toList());

        return null;
    }


}
