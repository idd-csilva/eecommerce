package br.com.eecommerce.backend.domain.component;

import br.com.eecommerce.backend.domain.mapper.CartItemsMapper;
import br.com.eecommerce.backend.domain.model.CartItem;
import br.com.eecommerce.backend.domain.repository.CartItemRepository;
import br.com.eecommerce.backend.domain.vo.CartItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartItemsComponent {

    @Autowired
    private CartItemRepository cartItemRepository;

    public CartItemVO create(final CartItemVO cartItemVO) {
        final CartItem entity =
                cartItemRepository.save(CartItemsMapper.INSTANCE.cartItemVOToCartItem(cartItemVO));

        return cartItemToCartItemVO(entity);
    }

    private CartItemVO cartItemToCartItemVO(final CartItem entity) {
        return CartItemsMapper.INSTANCE.catItemToCartItemVO(entity);
    }

    public CartItemVO findById(final Long cartItemId) {
        final CartItem entity = cartItemRepository.findById(cartItemId).orElseThrow();

        return cartItemToCartItemVO(entity);
    }
}
