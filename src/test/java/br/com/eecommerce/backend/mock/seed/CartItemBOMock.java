package br.com.eecommerce.backend.mock.seed;

import br.com.eecommerce.backend.domain.patterns.bo.CartItemBO;

public class CartItemBOMock extends MockSeeder<CartItemBO> {

    @Override
    public CartItemBO getMock() {
        return super.inflate(CartItemBO.builder().build());
    }
}
