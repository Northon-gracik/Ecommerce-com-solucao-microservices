package com.northon.ecommerce.checkout.controller.checkout;


import com.northon.ecommerce.checkout.model.checkout.Checkout;
import com.northon.ecommerce.checkout.entity.CheckoutEntity;
import com.northon.ecommerce.checkout.service.CheckoutService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/v1/checkout")
@RequiredArgsConstructor
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    @RequestMapping("/")
    public String find(){
        return "Teste";
    }

    @PostMapping("/")
    public ResponseEntity<CheckoutResponse> create(@RequestBody Checkout checkoutModel) {
        final CheckoutEntity checkoutEntity =  checkoutService.create(checkoutModel).orElseThrow();
        final CheckoutResponse checkoutResponse = CheckoutResponse.builder()
                .code(checkoutEntity.getCode())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(checkoutResponse);
    }

}
