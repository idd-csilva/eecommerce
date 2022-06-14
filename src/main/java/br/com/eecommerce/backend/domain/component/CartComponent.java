package br.com.eecommerce.backend.domain.component;

import br.com.eecommerce.backend.domain.mapper.CartMapper;
import br.com.eecommerce.backend.domain.model.Cart;
import br.com.eecommerce.backend.domain.repository.CartRepository;
import br.com.eecommerce.backend.domain.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartComponent {

    @Autowired
    private CartRepository cartRepository;

    public CartVO create(final CartVO cartVO) {
        final Cart entity =
                cartRepository.save(CartMapper.INSTANCE.cartVOToCart(cartVO));

        return cartToCartVO(entity);
    }

    private CartVO cartToCartVO(final Cart entity) {
        return CartMapper.INSTANCE.cartToCartVO(entity);
    }

    public CartVO findById(final Long cartId) {
        final Cart entity = cartRepository.findById(cartId).orElseThrow();

        return cartToCartVO(entity);
    }

    public CartVO update(final CartVO cartVO) {
        final Cart entity =
                cartRepository.save(CartMapper.INSTANCE.cartVOToCart(cartVO));

        return cartToCartVO(entity);
    }
}
