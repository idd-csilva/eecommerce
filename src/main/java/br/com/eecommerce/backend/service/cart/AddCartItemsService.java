package br.com.eecommerce.backend.service.cart;

import br.com.eecommerce.backend.domain.component.CartComponent;
import br.com.eecommerce.backend.domain.component.ProductComponent;
import br.com.eecommerce.backend.domain.patterns.bo.CartBO;
import br.com.eecommerce.backend.domain.patterns.bo.CartItemBO;
import br.com.eecommerce.backend.domain.patterns.bo.ProductBO;
import br.com.eecommerce.backend.domain.patterns.dto.CartAddItemDto;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AddCartItemsService {

    @Autowired
    private CartComponent cartComponent;

    @Autowired
    private ProductComponent productComponent;

    public CartBO addItem(final Long cartId, final CartAddItemDto cartAddItemDto) {
        final ProductBO productBO = productComponent.findById(cartAddItemDto.getProductId());
        final CartItemBO cartItemBO = CartItemBO.builder()
                .product(productBO)
                .quantity(cartAddItemDto.getQuantity())
                .build();

        final CartBO cartBO = cartComponent.findById(cartId);

        cartBO.addItem(cartItemBO);
        cartBO.calculateAmount(cartItemBO);

        final CartBO cartBoUpdated = cartComponent.update(cartBO);

        if (cartBoUpdated.getId() == 5) {
            throw new RuntimeException();
        }

        return cartBoUpdated;
    }
}
