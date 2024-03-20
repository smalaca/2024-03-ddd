package com.smalaca.order.domain.summary;

import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.order.domain.order.Order;
import com.smalaca.order.domain.order.OrderFactory;
import jakarta.persistence.Id;

import java.util.UUID;

@AggregateRoot
public class Summary {
    @Id
    private UUID summaryId;
    // business identifier
    private UUID buyerId;

    public Order accept() {
        return new OrderFactory().create(summaryId, buyerId);
    }
}
