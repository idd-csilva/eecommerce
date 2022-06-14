package br.com.eecommerce.backend.domain.mapper;

import br.com.eecommerce.backend.domain.model.CartItem;
import br.com.eecommerce.backend.domain.vo.CartItemVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CartItemsMapper {

    CartItemsMapper INSTANCE = Mappers.getMapper(CartItemsMapper.class);

    CartItemVO catItemToCartItemVO(CartItem cartItem);

    CartItem cartItemVOToCartItem(CartItemVO cartItem);
}
