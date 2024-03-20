package com.smalaca.order.domain.order;

import com.smalaca.annotation.ddd.Factory;

import java.util.UUID;

@Factory
public class OrderFactory {
    public Order create(UUID summaryId, UUID buyerId) {
        return new Order(orderNumber(buyerId), summaryId, buyerId);
    }

    private String orderNumber(UUID buyerId) {
        return "ORDER-" + buyerId + "-" + UUID.randomUUID();
    }
}
