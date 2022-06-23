package br.com.eecommerce.backend.domain.component;

import br.com.eecommerce.backend.domain.mapper.CartItemsMapper;
import br.com.eecommerce.backend.domain.model.CartItem;
import br.com.eecommerce.backend.domain.repository.CartItemRepository;
import br.com.eecommerce.backend.domain.patterns.bo.CartItemBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartItemsComponent {

    @Autowired
    private CartItemRepository cartItemRepository;

    public CartItemBO create(final CartItemBO cartItemBO) {
        final CartItem entity =
                cartItemRepository.save(CartItemsMapper.INSTANCE.cartItemBOToCartItem(cartItemBO));

        return cartItemToCartItemVO(entity);
    }

    private CartItemBO cartItemToCartItemVO(final CartItem entity) {
        return CartItemsMapper.INSTANCE.catItemToCartItemBO(entity);
    }

    public CartItemBO findById(final Long cartItemId) {
        final CartItem entity = cartItemRepository.findById(cartItemId).orElseThrow();

        return cartItemToCartItemVO(entity);
    }
}
