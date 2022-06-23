package br.com.eecommerce.backend.mock.seed;

import br.com.eecommerce.backend.domain.patterns.bo.CartBO;
import java.util.List;

public class CartBOMock extends MockSeeder<CartBO> {

    @Override
    public CartBO getMock() {
        final CartBO mock = super.inflate(CartBO.builder().build());
        mock.setCustomer(new CustomerBOMock().getMock());
        mock.setCartItems(List.of(
                new CartItemBOMock().getMock(),
                new CartItemBOMock().getMock()
        ));

        return mock;
    }
}
