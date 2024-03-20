package com.smalaca.order.domain.basket;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;
import jakarta.persistence.Id;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@AggregateRoot
public class Basket {
    @Id
    private UUID basketId;
    // business identifier
    private UUID buyerId;

    private final Map<UUID, Amount> products = new HashMap<>();

    @PrimaryPort
    public void addProduct(UUID productId, Amount amount) {
        products.put(productId, amount);
    }

    @PrimaryPort
    public void removeProduct() {

    }
}
