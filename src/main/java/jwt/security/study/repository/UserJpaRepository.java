package jwt.security.study.repository;

import jwt.security.study.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface UserJpaRepository extends JpaRepository<User, Long> {
    Optional<User> findOneWithAuthoritiesByUsername(String username);

    boolean existsByUsername(String username);
}

