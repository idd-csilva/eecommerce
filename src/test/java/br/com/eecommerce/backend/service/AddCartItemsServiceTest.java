package br.com.eecommerce.backend.service;

import br.com.eecommerce.backend.domain.component.CartComponent;
import br.com.eecommerce.backend.domain.component.CartItemsComponent;
import br.com.eecommerce.backend.domain.component.ProductComponent;
import br.com.eecommerce.backend.domain.patterns.bo.CartBO;
import br.com.eecommerce.backend.domain.patterns.bo.CartItemBO;
import br.com.eecommerce.backend.domain.patterns.bo.ProductBO;
import br.com.eecommerce.backend.service.cart.AddCartItemsService;
import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AddCartItemsServiceTest {

    @InjectMocks
    private AddCartItemsService addCartItemsService;

    @Mock
    private CartComponent cartComponent;

    @Mock
    private CartItemsComponent cartItemsComponent;

    @Mock
    private ProductComponent productComponent;

    @Test
    void shouldCalculateAmountProperly() {
        final var productVO = ProductBO.builder()
                .id(1L)
                .name("Teste")
                .price(BigDecimal.TEN)
                .stockCounter(10)
                .build();
        final var cartVO = CartBO.builder()
                .id(1L)
                .totalAmount(BigDecimal.ZERO)
                .build();
        final var cartItemVO = CartItemBO.builder()
                .id(1L)
                .product(productVO)
                .quantity(5)
                .build();

        BDDMockito.given(productComponent.findById(productVO.getId())).willReturn(productVO);
        BDDMockito.given(cartComponent.findById(cartVO.getId())).willReturn(cartVO);
        BDDMockito.given(cartItemsComponent.create(cartItemVO)).willReturn(cartItemVO);
        BDDMockito.given(cartComponent.update(cartVO)).willReturn(cartVO);

        final CartBO result = addCartItemsService.addItem(cartVO.getId(), cartItemVO);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(BigDecimal.valueOf(50), result.getTotalAmount());
    }
}
