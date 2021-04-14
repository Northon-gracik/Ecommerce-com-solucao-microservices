package com.northon.ecommerce.checkout.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class CheckoutEntity {

    @Id
    private String id;

    private String code;

    private Status status;

    public enum Status {
        CREATED,
        APPROVED
    }
}
