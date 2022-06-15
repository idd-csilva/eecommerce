package br.com.eecommerce.backend.controller;

import br.com.eecommerce.backend.domain.patterns.bo.CustomerBO;
import br.com.eecommerce.backend.domain.component.CustomerComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerComponent customerComponent;

    @PostMapping
    public ResponseEntity<CustomerBO> create(@RequestBody final CustomerBO customerBO) {
        return ResponseEntity.ok(customerComponent.create(customerBO));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerBO> findById(@PathVariable final Long customerId) {
        return ResponseEntity.ok(customerComponent.findById(customerId));
    }
}
