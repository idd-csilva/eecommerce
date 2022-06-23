package br.com.eecommerce.backend.service;

import br.com.eecommerce.backend.action.cart.AddCartItemsServiceActions;
import br.com.eecommerce.backend.domain.patterns.bo.CartBO;
import br.com.eecommerce.backend.domain.patterns.bo.CartItemBO;
import br.com.eecommerce.backend.domain.patterns.dto.CartAddItemDto;
import br.com.eecommerce.backend.mock.seed.CartAddItemDtoMock;
import br.com.eecommerce.backend.mock.seed.CartBOMock;
import br.com.eecommerce.backend.mock.seed.ProductBOMock;
import br.com.eecommerce.backend.mock.cart.AddCartItemsServiceMocks;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AddCartItemsServiceTest {

    @Autowired
    private AddCartItemsServiceActions addCartItemsServiceActions;

    @Test
    void shouldCalculateAmountProperly() {
        var result =
                addCartItemsServiceActions.mockProductFindById()
                        .and().mockCartFindById()
                        .and().mockCartUpdate()
                        .and().perform(1L, AddCartItemsServiceMocks.getCartAddItemDto());

        Assertions.assertNotNull(result);
        Assertions.assertEquals(BigDecimal.valueOf(100), result.getTotalAmount());
    }
}
