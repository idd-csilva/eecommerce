package br.com.eecommerce.backend.domain.mapper;

import br.com.eecommerce.backend.domain.model.CartItem;
import br.com.eecommerce.backend.domain.patterns.bo.CartItemBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CartItemsMapper {

    CartItemsMapper INSTANCE = Mappers.getMapper(CartItemsMapper.class);

    CartItemBO catItemToCartItemVO(CartItem cartItem);

    CartItem cartItemVOToCartItem(CartItemBO cartItem);
}
