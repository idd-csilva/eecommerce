package br.com.eecommerce.backend.controller;

import br.com.eecommerce.backend.domain.patterns.bo.ProductBO;
import br.com.eecommerce.backend.domain.component.ProductComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductsController {

    @Autowired
    private ProductComponent productComponent;

    @PostMapping
    public ResponseEntity<ProductBO> create(@RequestBody final ProductBO productBO) {
        return ResponseEntity.ok(productComponent.create(productBO));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductBO> findById(@PathVariable final Long productId) {
        return ResponseEntity.ok(productComponent.findById(productId));
    }
}
