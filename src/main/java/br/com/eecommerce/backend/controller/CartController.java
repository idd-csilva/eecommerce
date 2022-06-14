package br.com.eecommerce.backend.controller;

import br.com.eecommerce.backend.domain.vo.CartItemVO;
import br.com.eecommerce.backend.domain.vo.CartVO;
import br.com.eecommerce.backend.domain.component.CartComponent;
import br.com.eecommerce.backend.service.cart.AddCartItemsService;
import br.com.eecommerce.backend.service.cart.CreateCartService;
import br.com.eecommerce.backend.service.cart.FindCartService;
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
    public ResponseEntity<CartVO> create(@RequestBody final CartVO cartVO) {
        return ResponseEntity.ok(createCartService.create(cartVO));
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<CartVO> findById(@PathVariable final Long cartId) {
        return ResponseEntity.ok(cartComponent.findById(cartId));
    }

    @PostMapping("/{cartId}/items")
    public ResponseEntity<CartVO> addItemsToCart(
            @PathVariable final Long cartId,
            @RequestBody final CartItemVO cartItemVO
    ) {
        return ResponseEntity.ok(addCartItemsService.addItem(cartId, cartItemVO));
    }
}
