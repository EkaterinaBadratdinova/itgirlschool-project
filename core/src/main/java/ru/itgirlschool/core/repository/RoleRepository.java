package ru.itgirlschool.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itgirlschool.core.entity.Role;
import ru.itgirlschool.core.entity.RoleType;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRole(RoleType roleType);
}
