package com.smalaca.order.domain.order;

import com.smalaca.order.domain.eventpublisher.EventId;

import java.util.UUID;

public class OrderCancelled {
    private final EventId eventId;
    private final UUID orderId;
    private final OrderNumber orderNumber;

    private OrderCancelled(EventId eventId, UUID orderId, OrderNumber orderNumber) {
        this.eventId = eventId;
        this.orderId = orderId;
        this.orderNumber = orderNumber;
    }

    static OrderCancelled create(UUID orderId, OrderNumber orderNumber) {
        return new OrderCancelled(EventId.create(), orderId, orderNumber);
    }

    public EventId getEventId() {
        return eventId;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public OrderNumber getOrderNumber() {
        return orderNumber;
    }
}
