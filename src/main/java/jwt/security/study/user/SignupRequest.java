package jwt.security.study.user;

import org.springframework.security.crypto.password.PasswordEncoder;

public record SignupRequest (String username, String nickname, String password ){

    public SignupRequest(String username, String nickname, String password){
        if(username.length() > 50 || nickname.length() > 100 || password.length() > 50){
            throw new IllegalArgumentException("확인");
        }
        if (username.isBlank()) {
            throw new IllegalArgumentException("username은 필수값입니다.");
        }
        if (nickname.isBlank()) {
            throw new IllegalArgumentException("nickname은 필수값입니다.");
        }
        if (password.isBlank()) {
            throw new IllegalArgumentException("password는 필수값입니다.");
        }
        this.username = username;
        this.nickname = nickname;
        this.password = password;
    }

    public String encrypt(PasswordEncoder passwordEncoder) {
        return passwordEncoder.encode(this.password);
    }
}
