package com.smalaca.order.domain.order;

import com.smalaca.annotation.ddd.Factory;
import com.smalaca.annotation.ddd.ValueObject;

import java.util.UUID;

@ValueObject
class OrderNumber {
    private final String orderNumber;

    private OrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Factory
    static OrderNumber from(UUID buyerId) {
        return new OrderNumber(orderNumberFor(buyerId));
    }

    private static String orderNumberFor(UUID buyerId) {
        return "ORDER-" + buyerId + "-" + UUID.randomUUID();
    }
}
