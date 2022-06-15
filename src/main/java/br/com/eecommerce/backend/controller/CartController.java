package br.com.eecommerce.backend.controller;

import br.com.eecommerce.backend.domain.patterns.bo.CartBO;
import br.com.eecommerce.backend.domain.patterns.bo.CartItemBO;
import br.com.eecommerce.backend.domain.component.CartComponent;
import br.com.eecommerce.backend.domain.patterns.dto.CartAddItemDto;
import br.com.eecommerce.backend.domain.patterns.dto.CartCreateDto;
import br.com.eecommerce.backend.service.cart.AddCartItemsService;
import br.com.eecommerce.backend.service.cart.CreateCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("carts")
public class CartController {

    @Autowired
    private CreateCartService createCartService;

    @Autowired
    private CartComponent cartComponent;

    @Autowired
    private AddCartItemsService addCartItemsService;

    @PostMapping
    public ResponseEntity<CartBO> create(@RequestBody final CartCreateDto cartCreateDto) {
        return ResponseEntity.ok(createCartService.create(cartCreateDto));
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<CartBO> findById(@PathVariable final Long cartId) {
        return ResponseEntity.ok(cartComponent.findById(cartId));
    }

    @PostMapping("/{cartId}/items")
    public ResponseEntity<CartBO> addItemsToCart(
            @PathVariable final Long cartId,
            @RequestBody final CartAddItemDto cartAddItemDto
    ) {
        return ResponseEntity.ok(addCartItemsService.addItem(cartId, cartAddItemDto));
    }
}
