package br.com.eecommerce.backend.mock.seed;

import br.com.eecommerce.backend.domain.patterns.dto.CartAddItemDto;

public class CartAddItemDtoMock extends MockSeeder<CartAddItemDto> {

    @Override
    public CartAddItemDto getMock() {
        return super.inflate(CartAddItemDto.builder().build());
    }
}
