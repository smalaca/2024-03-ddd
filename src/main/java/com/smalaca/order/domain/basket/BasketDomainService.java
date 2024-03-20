package com.smalaca.order.domain.basket;

import com.smalaca.annotation.architecture.PrimaryPort;

import java.util.UUID;

public class BasketDomainService {
    @PrimaryPort
    public void moveProduct(Basket basketOne, Basket basketTwo, UUID productId) {

    }
}
