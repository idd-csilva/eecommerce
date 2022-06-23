package br.com.eecommerce.backend.mock.cart;

import br.com.eecommerce.backend.domain.patterns.bo.CartBO;
import br.com.eecommerce.backend.domain.patterns.bo.CartItemBO;
import br.com.eecommerce.backend.domain.patterns.bo.ProductBO;
import br.com.eecommerce.backend.domain.patterns.dto.CartAddItemDto;
import java.math.BigDecimal;
import java.util.List;

public class AddCartItemsServiceMocks {

    public static ProductBO getProductBO() {
        return ProductBO.builder()
                .id(1L)
                .name("Produto 01")
                .price(BigDecimal.TEN)
                .stockCounter(10)
                .build();
    }

    public static CartBO getCartBO() {
        return CartBO.builder()
                .id(1L)
                .totalAmount(BigDecimal.ZERO)
                .build();
    }

    public static CartAddItemDto getCartAddItemDto() {
        return CartAddItemDto.builder()
                .productId(1L)
                .quantity(10)
                .build();
    }

    public static CartBO getExpectedCartBO() {
        return CartBO.builder()
                .id(1L)
                .totalAmount(BigDecimal.valueOf(100))
                .cartItems(List.of(
                        CartItemBO.builder()
                                .product(getProductBO())
                                .quantity(10)
                                .build()
                ))
                .build();
    }
}
