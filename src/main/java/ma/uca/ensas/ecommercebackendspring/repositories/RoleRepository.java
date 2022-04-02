package ma.uca.ensas.ecommercebackendspring.repositories;

import ma.uca.ensas.ecommercebackendspring.entities.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(String name);
    Optional<Role> findById(Long id);
}
