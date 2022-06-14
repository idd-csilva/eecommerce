package br.com.eecommerce.backend.domain.repository;

import br.com.eecommerce.backend.domain.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
