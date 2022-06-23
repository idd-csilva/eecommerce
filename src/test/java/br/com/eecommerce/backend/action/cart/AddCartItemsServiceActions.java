package br.com.eecommerce.backend.action.cart;

import br.com.eecommerce.backend.action.Action;
import br.com.eecommerce.backend.domain.component.CartComponent;
import br.com.eecommerce.backend.domain.component.ProductComponent;
import br.com.eecommerce.backend.domain.patterns.bo.CartBO;
import br.com.eecommerce.backend.domain.patterns.bo.ProductBO;
import br.com.eecommerce.backend.domain.patterns.dto.CartAddItemDto;
import br.com.eecommerce.backend.mock.cart.AddCartItemsServiceMocks;
import br.com.eecommerce.backend.service.cart.AddCartItemsService;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.stereotype.Service;
import org.springframework.test.util.ReflectionTestUtils;

@Service
public class AddCartItemsServiceActions implements Action<CartBO> {

    private final CartComponent cartComponent = Mockito.mock(CartComponent.class);

    private final ProductComponent productComponent = Mockito.mock(ProductComponent.class);

    public AddCartItemsServiceActions mockProductFindById() {
        BDDMockito.given(productComponent.findById(AddCartItemsServiceMocks.getProductBO().getId()))
                .willReturn(AddCartItemsServiceMocks.getProductBO());

        return this;
    }

    public AddCartItemsServiceActions mockProductFindById(final ProductBO productBO) {
        BDDMockito.given(productComponent.findById(productBO.getId()))
                .willReturn(productBO);

        return this;
    }

    public AddCartItemsServiceActions mockCartFindById() {
        BDDMockito.given(cartComponent.findById(AddCartItemsServiceMocks.getCartBO().getId()))
                .willReturn(AddCartItemsServiceMocks.getCartBO());

        return this;
    }

    public AddCartItemsServiceActions mockCartFindById(final CartBO cartBO) {
        BDDMockito.given(cartComponent.findById(cartBO.getId()))
                .willReturn(cartBO);

        return this;
    }

    public AddCartItemsServiceActions mockCartUpdate() {
        BDDMockito.given(cartComponent.update(AddCartItemsServiceMocks.getExpectedCartBO()))
                .willReturn(AddCartItemsServiceMocks.getExpectedCartBO());

        return this;
    }

    public AddCartItemsServiceActions mockCartUpdate(final CartBO cartBO) {
        BDDMockito.given(cartComponent.update(cartBO))
                .willReturn(cartBO);

        return this;
    }

    public AddCartItemsServiceActions and() {
        return this;
    }

    @Override
    public CartBO perform(final Object... params) {
        final AddCartItemsService addCartItemsService = new AddCartItemsService();

        ReflectionTestUtils.setField(addCartItemsService, "cartComponent", cartComponent);
        ReflectionTestUtils.setField(addCartItemsService, "productComponent", productComponent);

        return addCartItemsService.addItem((Long) params[0], (CartAddItemDto) params[1]);
    }
}
