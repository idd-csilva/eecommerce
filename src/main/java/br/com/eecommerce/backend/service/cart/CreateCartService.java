package br.com.eecommerce.backend.service.cart;

import br.com.eecommerce.backend.domain.component.CartComponent;
import br.com.eecommerce.backend.domain.component.CustomerComponent;
import br.com.eecommerce.backend.domain.patterns.bo.CartBO;
import br.com.eecommerce.backend.domain.patterns.bo.CustomerBO;
import br.com.eecommerce.backend.domain.patterns.dto.CartCreateDto;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCartService {

    @Autowired
    private CartComponent cartComponent;

    @Autowired
    private CustomerComponent customerComponent;

    public CartBO create(final CartCreateDto cartCreateDto) {
        final CustomerBO customerBO = customerComponent.findById(cartCreateDto.getCustomerId());

        final CartBO cartBO = CartBO.builder()
                .customer(customerBO)
                .totalAmount(BigDecimal.ZERO)
                .build();

        return cartComponent.create(cartBO);
    }
}
