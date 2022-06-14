package br.com.eecommerce.backend.domain.repository;

import br.com.eecommerce.backend.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
