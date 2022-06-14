package br.com.eecommerce.backend.controller;

import br.com.eecommerce.backend.domain.vo.CustomerVO;
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
    public ResponseEntity<CustomerVO> create(@RequestBody final CustomerVO customerVO) {
        return ResponseEntity.ok(customerComponent.create(customerVO));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerVO> findById(@PathVariable final Long customerId) {
        return ResponseEntity.ok(customerComponent.findById(customerId));
    }
}
