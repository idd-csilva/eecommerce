package br.com.eecommerce.backend.domain.component;

import br.com.eecommerce.backend.domain.mapper.CustomerMapper;
import br.com.eecommerce.backend.domain.model.Customer;
import br.com.eecommerce.backend.domain.repository.CustomerRepository;
import br.com.eecommerce.backend.domain.vo.CustomerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerComponent {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerVO create(final CustomerVO customerVO) {
        final Customer entity = customerRepository.save(CustomerMapper.INSTANCE.customerVOToCustomer(customerVO));

        return customerToCustomerVO(entity);
    }

    private CustomerVO customerToCustomerVO(final Customer entity) {
        return CustomerMapper.INSTANCE.customerToCustomerVO(entity);
    }

    public CustomerVO findById(final Long customerId) {
        final Customer entity = customerRepository.findById(customerId).orElseThrow();

        return customerToCustomerVO(entity);
    }
}
