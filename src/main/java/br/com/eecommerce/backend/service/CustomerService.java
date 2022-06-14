package br.com.eecommerce.backend.service;

import br.com.eecommerce.backend.domain.mapper.CustomerMapper;
import br.com.eecommerce.backend.domain.model.Customer;
import br.com.eecommerce.backend.domain.repository.CustomerRepository;
import br.com.eecommerce.backend.domain.vo.CustomerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerVO create(final CustomerVO customerVO) {
        final Customer entity = customerRepository.save(
                CustomerMapper.INSTANCE.customerVOToCustomer(customerVO)
        );

        return CustomerMapper.INSTANCE.customerToCustomerVO(entity);
    }

    public CustomerVO findById(final Long customerId) {
        final Customer entity = customerRepository.findById(customerId).orElseThrow();

        return CustomerMapper.INSTANCE.customerToCustomerVO(entity);
    }
}
