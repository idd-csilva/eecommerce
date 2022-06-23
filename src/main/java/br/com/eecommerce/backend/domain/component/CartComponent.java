package br.com.eecommerce.backend.domain.component;

import br.com.eecommerce.backend.domain.mapper.CartMapper;
import br.com.eecommerce.backend.domain.model.Cart;
import br.com.eecommerce.backend.domain.patterns.bo.CartBO;
import br.com.eecommerce.backend.domain.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartComponent {

    @Autowired
    private CartRepository cartRepository;

    public CartBO create(final CartBO cartBO) {
        final Cart entity =
                cartRepository.save(CartMapper.INSTANCE.cartBOToCart(cartBO));

        return cartToCartVO(entity);
    }

    private CartBO cartToCartVO(final Cart entity) {
        return CartMapper.INSTANCE.cartToCartBO(entity);
    }

    public CartBO findById(final Long cartId) {
        final Cart entity = cartRepository.findById(cartId).orElseThrow();

        return cartToCartVO(entity);
    }

    public CartBO update(final CartBO cartBO) {
        final Cart entity =
                cartRepository.save(CartMapper.INSTANCE.cartBOToCart(cartBO));

        return cartToCartVO(entity);
    }
}
