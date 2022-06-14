package br.com.eecommerce.backend.domain.repository;

import br.com.eecommerce.backend.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
