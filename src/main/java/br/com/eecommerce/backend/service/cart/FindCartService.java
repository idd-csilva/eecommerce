package br.com.eecommerce.backend.service.cart;

import br.com.eecommerce.backend.domain.component.CartComponent;
import br.com.eecommerce.backend.domain.patterns.bo.CartBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindCartService {

    @Autowired
    private CartComponent cartComponent;

    public CartBO findById(final Long cartId) {
        return cartComponent.findById(cartId);
    }
}
