package com.northon.ecommerce.payment.streaming;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CheckoutProcessor {

    String OUTPUT = "payment-paid-output";
    String INPUT = "checkout-created-input";

    @Output(OUTPUT)
    MessageChannel output();

    @Input(INPUT)
    MessageChannel input();
}
