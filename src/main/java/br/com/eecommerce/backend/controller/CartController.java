package br.com.eecommerce.backend.controller;

import br.com.eecommerce.backend.domain.vo.CartItemVO;
import br.com.eecommerce.backend.domain.vo.CartVO;
import br.com.eecommerce.backend.domain.vo.CustomerVO;
import br.com.eecommerce.backend.service.CartService;
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
    private CartService cartService;

    @PostMapping
    public ResponseEntity<CartVO> create(@RequestBody final CartVO cartVO) {
        return ResponseEntity.ok(cartService.create(cartVO));
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<CartVO> findById(@PathVariable final Long cartId) {
        return ResponseEntity.ok(cartService.findById(cartId));
    }

    @PostMapping("/{cartId}/items")
    public ResponseEntity<CartVO> addItemsToCart(
            @PathVariable final Long cartId,
            @RequestBody final CartItemVO cartItemVO
    ) {
        return ResponseEntity.ok(cartService.addItemsToCart(cartId, cartItemVO));
    }
}
