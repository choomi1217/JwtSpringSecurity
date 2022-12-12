package jwt.security.study.user.repository;

import jwt.security.study.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Long> {
    Optional<User> findOneWithAuthoritiesByUsername(String username);

    boolean existsByUsername(String username);
}

