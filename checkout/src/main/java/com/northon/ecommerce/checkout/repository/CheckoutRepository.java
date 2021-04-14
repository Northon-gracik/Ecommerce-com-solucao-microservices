package com.northon.ecommerce.checkout.repository;

import com.northon.ecommerce.checkout.entity.CheckoutEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CheckoutRepository extends MongoRepository<CheckoutEntity, Long>{

    Optional<CheckoutEntity> findByCode(String code);

}
