package br.com.eecommerce.backend.service;

import br.com.eecommerce.backend.domain.mapper.CartItemsMapper;
import br.com.eecommerce.backend.domain.mapper.ProductMapper;
import br.com.eecommerce.backend.domain.model.Cart;
import br.com.eecommerce.backend.domain.repository.CartItemRepository;
import br.com.eecommerce.backend.domain.repository.CartRepository;
import br.com.eecommerce.backend.domain.repository.CustomerRepository;
import br.com.eecommerce.backend.domain.repository.ProductRepository;
import br.com.eecommerce.backend.domain.vo.CartItemVO;
import br.com.eecommerce.backend.domain.vo.CartVO;
import br.com.eecommerce.backend.domain.vo.ProductVO;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CartServiceTest {

    @InjectMocks
    private CartService cartService;

    @Mock
    private CartRepository cartRepository;

    @Mock
    private CartItemRepository cartItemRepository;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private ProductRepository productRepository;

    @Test
    void shouldCalculateAmountProperly() {
        final var productVO = ProductVO.builder()
                .id(1L)
                .name("Teste")
                .price(BigDecimal.TEN)
                .stockCounter(10)
                .build();
        final var cartItemVO = CartItemVO.builder()
                .id(1L)
                .product(productVO)
                .quantity(5)
                .build();
        final var cart = Cart.builder()
                .id(1L)
                .totalAmount(BigDecimal.ZERO)
                .build();
        final var product =
                ProductMapper.INSTANCE.productVOToProduct(productVO);
        final var cartItem =
                CartItemsMapper.INSTANCE.cartItemVOToCartItem(cartItemVO);

        BDDMockito.given(productRepository.findById(product.getId())).willReturn(Optional.of(product));
        BDDMockito.given(cartItemRepository.save(cartItem)).willReturn(cartItem);
        BDDMockito.given(cartRepository.findById(cart.getId())).willReturn(Optional.of(cart));

        final CartVO cartVO =
                cartService.addItemsToCart(cart.getId(), cartItemVO);

        BDDMockito.verify(cartRepository, Mockito.times(1)).save(BDDMockito.any());
        Assertions.assertNotNull(cartVO);
        Assertions.assertEquals(BigDecimal.valueOf(50), cartVO.getTotalAmount());
    }
}
