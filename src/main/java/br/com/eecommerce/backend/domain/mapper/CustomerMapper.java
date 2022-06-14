package br.com.eecommerce.backend.domain.mapper;

import br.com.eecommerce.backend.domain.model.Customer;
import br.com.eecommerce.backend.domain.vo.CustomerVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerVO customerToCustomerVO(Customer customer);

    Customer customerVOToCustomer(CustomerVO customer);
}
