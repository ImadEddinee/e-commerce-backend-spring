package ma.uca.ensas.ecommercebackendspring.repositories;

import ma.uca.ensas.ecommercebackendspring.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
