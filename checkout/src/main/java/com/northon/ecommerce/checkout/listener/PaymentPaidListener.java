package com.northon.ecommerce.checkout.listener;

import com.northon.ecommerce.checkout.entity.CheckoutEntity;
import com.northon.ecommerce.checkout.repository.CheckoutRepository;
import com.northon.ecommerce.checkout.streaming.PaymentPaidSink;
import com.northon.ecommerce.payment.event.PaymentCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentPaidListener {

    private final CheckoutRepository checkoutRepository;

    @StreamListener(PaymentPaidSink.INPUT)
    public void handler(PaymentCreatedEvent event){

        final CheckoutEntity checkoutEntity = checkoutRepository.findByCode(event.getCheckoutCode().toString())
                .orElseThrow();

        checkoutEntity.setStatus(CheckoutEntity.Status.APPROVED);

        checkoutRepository.save(checkoutEntity);

        System.out.println(checkoutEntity);

    }
}
