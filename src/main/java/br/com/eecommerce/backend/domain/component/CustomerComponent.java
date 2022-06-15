package br.com.eecommerce.backend.domain.component;

import br.com.eecommerce.backend.domain.mapper.CustomerMapper;
import br.com.eecommerce.backend.domain.model.Customer;
import br.com.eecommerce.backend.domain.repository.CustomerRepository;
import br.com.eecommerce.backend.domain.patterns.bo.CustomerBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerComponent {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerBO create(final CustomerBO customerBO) {
        final Customer entity = customerRepository.save(CustomerMapper.INSTANCE.customerVOToCustomer(customerBO));

        return customerToCustomerVO(entity);
    }

    private CustomerBO customerToCustomerVO(final Customer entity) {
        return CustomerMapper.INSTANCE.customerToCustomerVO(entity);
    }

    public CustomerBO findById(final Long customerId) {
        final Customer entity = customerRepository.findById(customerId).orElseThrow();

        return customerToCustomerVO(entity);
    }
}
