package br.com.eecommerce.backend.domain.mapper;

import br.com.eecommerce.backend.domain.model.Cart;
import br.com.eecommerce.backend.domain.patterns.bo.CartBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CartMapper {

    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    CartBO cartToCartVO(Cart cart);

    Cart cartVOToCart(CartBO cartBO);
}
