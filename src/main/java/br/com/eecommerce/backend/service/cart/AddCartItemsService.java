package br.com.eecommerce.backend.service.cart;

import br.com.eecommerce.backend.domain.component.CartComponent;
import br.com.eecommerce.backend.domain.component.CartItemsComponent;
import br.com.eecommerce.backend.domain.component.ProductComponent;
import br.com.eecommerce.backend.domain.vo.CartItemVO;
import br.com.eecommerce.backend.domain.vo.CartVO;
import br.com.eecommerce.backend.domain.vo.ProductVO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddCartItemsService {

    @Autowired
    private CartComponent cartComponent;

    @Autowired
    private CartItemsComponent cartItemsComponent;

    @Autowired
    private ProductComponent productComponent;

    public CartVO addItem(final Long cartId, final CartItemVO cartItemVO) {
        final ProductVO productVO = productComponent.findById(cartItemVO.getProduct().getId());
        final CartVO cartVO = cartComponent.findById(cartId);

        cartItemVO.setProduct(productVO);
        final CartItemVO addedCartItem = cartItemsComponent.create(cartItemVO);

        cartVO.setCartItems(Optional.ofNullable(cartVO.getCartItems()).orElse(new ArrayList<>()));
        cartVO.getCartItems().add(addedCartItem);
        cartVO.setTotalAmount(calculateAmount(cartVO, cartItemVO));

        return cartComponent.update(cartVO);
    }

    private BigDecimal calculateAmount(final CartVO cartVO, final CartItemVO cartItemVO) {
        final BigDecimal productPrice = cartItemVO.getProduct().getPrice();
        final BigDecimal productQuantity = BigDecimal.valueOf(cartItemVO.getQuantity());
        final BigDecimal cartCurrentAmount = cartVO.getTotalAmount();

        return cartCurrentAmount.add(productPrice.multiply(productQuantity));
    }
}
