package com.smalaca.order.domain.order;

import com.smalaca.order.domain.eventpublisher.EventId;

import java.util.UUID;

public class PurchasePaid {
    private final EventId eventId;
    private final UUID orderId;

    private PurchasePaid(EventId eventId, UUID orderId) {
        this.eventId = eventId;
        this.orderId = orderId;
    }

    static PurchasePaid create(UUID orderId) {
        return new PurchasePaid(EventId.create(), orderId);
    }
}
