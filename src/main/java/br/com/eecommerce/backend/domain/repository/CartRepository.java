package br.com.eecommerce.backend.domain.repository;

import br.com.eecommerce.backend.domain.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
