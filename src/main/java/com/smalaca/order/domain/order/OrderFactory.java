package com.smalaca.order.domain.order;

import com.smalaca.annotation.ddd.Factory;

import java.util.UUID;

@Factory
public class OrderFactory {
    public Order create(UUID summaryId, UUID buyerId) {
        return new Order(OrderNumber.from(buyerId), summaryId, buyerId);
    }
}
