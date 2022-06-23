package br.com.eecommerce.backend.domain.mapper;

import br.com.eecommerce.backend.domain.model.Customer;
import br.com.eecommerce.backend.domain.patterns.bo.CustomerBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerBO customerToCustomerBO(Customer customer);

    Customer customerBOToCustomer(CustomerBO customer);
}
