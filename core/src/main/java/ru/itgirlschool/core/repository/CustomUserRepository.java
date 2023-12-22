package ru.itgirlschool.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itgirlschool.core.entity.CustomUser;

import java.util.Optional;

@Repository
public interface CustomUserRepository extends JpaRepository<CustomUser, Long> {

    Optional<CustomUser> findByLogin(String login);

    Optional<CustomUser> findByEmail(String email);

    Boolean existsByLogin(String login);

    Boolean existsByEmail(String email);
}
