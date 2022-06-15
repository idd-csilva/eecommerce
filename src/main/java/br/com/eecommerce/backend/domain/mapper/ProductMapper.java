package br.com.eecommerce.backend.domain.mapper;

import br.com.eecommerce.backend.domain.model.Product;
import br.com.eecommerce.backend.domain.patterns.bo.ProductBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductBO productToProductVO(Product product);

    Product productVOToProduct(ProductBO productBO);
}
