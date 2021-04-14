package com.northon.ecommerce.payment.listener;

import com.northon.ecommerce.checkout.event.CheckoutCreatedEvent;
import com.northon.ecommerce.payment.event.PaymentCreatedEvent;
import com.northon.ecommerce.payment.streaming.CheckoutProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CheckoutCreatedListener {

    private final CheckoutProcessor checkoutProcessor;

    @StreamListener(CheckoutProcessor.INPUT)
    public void handler(CheckoutCreatedEvent event){
        // Processa pagamento
        // Salvar dados de pagamento
        // Enviar o evento do pagamento processado
        final PaymentCreatedEvent paymentCreatedEvent = PaymentCreatedEvent.newBuilder()
                .setCheckoutCode(event.getCheckoutCode())
                .setPaymentCode(UUID.randomUUID().toString())
                .build();
        System.out.println(paymentCreatedEvent);
        checkoutProcessor.output().send(MessageBuilder.withPayload(paymentCreatedEvent).build());

    }
}
