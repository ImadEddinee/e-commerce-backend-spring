package ma.uca.ensas.ecommercebackendspring.repositories;

import ma.uca.ensas.ecommercebackendspring.entities.ProductExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductExperienceRepository extends JpaRepository<ProductExperience,Long> {
}
