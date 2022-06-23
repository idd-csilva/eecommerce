package br.com.eecommerce.backend.mock.seed;

import br.com.eecommerce.backend.domain.patterns.bo.CustomerBO;

public class CustomerBOMock extends MockSeeder<CustomerBO> {

    @Override
    public CustomerBO getMock() {
        return super.inflate(CustomerBO.builder().build());
    }
}
