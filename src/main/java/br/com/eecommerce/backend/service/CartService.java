package br.com.eecommerce.backend.service;

import br.com.eecommerce.backend.domain.mapper.CartItemsMapper;
import br.com.eecommerce.backend.domain.mapper.CartMapper;
import br.com.eecommerce.backend.domain.mapper.CustomerMapper;
import br.com.eecommerce.backend.domain.model.Cart;
import br.com.eecommerce.backend.domain.model.CartItem;
import br.com.eecommerce.backend.domain.model.Customer;
import br.com.eecommerce.backend.domain.model.Product;
import br.com.eecommerce.backend.domain.repository.CartItemRepository;
import br.com.eecommerce.backend.domain.repository.CartRepository;
import br.com.eecommerce.backend.domain.repository.CustomerRepository;
import br.com.eecommerce.backend.domain.repository.ProductRepository;
import br.com.eecommerce.backend.domain.vo.CartItemVO;
import br.com.eecommerce.backend.domain.vo.CartVO;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    public CartVO create(final CartVO cartVO) {
        final Customer customer =
                customerRepository.findById(cartVO.getCustomer().getId()).orElseThrow();

        cartVO.setCustomer(CustomerMapper.INSTANCE.customerToCustomerVO(customer));

        final Cart entity =
                cartRepository.save(CartMapper.INSTANCE.cartVOToCart(cartVO));

        return CartMapper.INSTANCE.cartToCartVO(entity);
    }

    public CartVO addItemsToCart(final Long cartId, final CartItemVO cartItemVO) {
        final Product product =
                productRepository.findById(cartItemVO.getProduct().getId()).orElseThrow();

        final CartItem cartItem =
                cartItemRepository.save(CartItemsMapper.INSTANCE.cartItemVOToCartItem(cartItemVO));

        final Cart entity =
                cartRepository.findById(cartId).orElseThrow();

        entity.getCartItems().add(cartItem);
        entity.setTotalAmount(entity.getTotalAmount().add(product.getPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity()))));

        cartRepository.save(entity);

        return CartMapper.INSTANCE.cartToCartVO(entity);
    }

    public CartVO findById(final Long cartId) {
        final Cart entity = cartRepository.findById(cartId).orElseThrow();

        return CartMapper.INSTANCE.cartToCartVO(entity);
    }
}
