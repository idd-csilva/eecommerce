package br.com.eecommerce.backend.service.cart;

import br.com.eecommerce.backend.domain.component.CartComponent;
import br.com.eecommerce.backend.domain.component.CustomerComponent;
import br.com.eecommerce.backend.domain.vo.CartVO;
import br.com.eecommerce.backend.domain.vo.CustomerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindCartService {

    @Autowired
    private CartComponent cartComponent;

    public CartVO findById(final Long cartId) {
        return cartComponent.findById(cartId);
    }
}
