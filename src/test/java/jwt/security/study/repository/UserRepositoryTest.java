package jwt.security.study.repository;

import jakarta.transaction.Transactional;
import jwt.security.study.user.entity.User;
import jwt.security.study.user.repository.UserJpaRepository;
import jwt.security.study.user.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
import static org.springframework.security.crypto.factory.PasswordEncoderFactories.createDelegatingPasswordEncoder;

@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = NONE)
class UserRepositoryTest {

    @Autowired
    private UserJpaRepository jpaRepository;

    UserRepository userRepository;
    @BeforeEach
    void setup(){
        userRepository = new UserRepository.UserRdbmsRepository(jpaRepository, createDelegatingPasswordEncoder());
    }
    @Test
    void signUp() {
        Assertions.assertThatCode(()->{
            User user = userRepository.signUp(UserRepository.format("test", "test", "test"));

            Assertions.assertThat(user).isNotNull();
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "test,test,test",
            "test2,test2,test2"
    }
            ,delimiter = ',')
    void format(String username,
                String nickname,
                String password) {
        UserRepository.format(username,nickname,password);
    }
}