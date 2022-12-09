package jwt.security.study.util;

import jwt.security.study.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

/**
 * Security context에서 Authentication 객체에서 username을 꺼내 리턴
 * */
public class SecurityUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityUtil.class);

    private SecurityUtil() {}

    public static Optional<String> getCurrentUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication == null){
            LOGGER.debug(" Security Context에 인증 정보가 없습니다. ");
            return Optional.empty();
        }
        String username = null;
        if(authentication.getPrincipal() instanceof UserDto){
            UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
            username = springSecurityUser.getUsername();
        }else if(authentication.getPrincipal() instanceof String){
            username = (String) authentication.getPrincipal();
        }

        return Optional.ofNullable(username);

    }

}
