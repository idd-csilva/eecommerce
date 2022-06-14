package br.com.eecommerce.backend.service.cart;

import br.com.eecommerce.backend.domain.component.CartComponent;
import br.com.eecommerce.backend.domain.component.CustomerComponent;
import br.com.eecommerce.backend.domain.vo.CartVO;
import br.com.eecommerce.backend.domain.vo.CustomerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCartService {

    @Autowired
    private CartComponent cartComponent;

    @Autowired
    private CustomerComponent customerComponent;

    public CartVO create(final CartVO cartVO) {
        final CustomerVO customerVO = customerComponent.findById(cartVO.getCustomer().getId());
        cartVO.setCustomer(customerVO);

        return cartComponent.create(cartVO);
    }
}
