package com.smalaca.shopmanagement.domain.assortment;

import com.smalaca.shopmanagement.domain.eventpublisher.EventId;

import java.util.UUID;

public class NotAcceptableProductRecognized {
    private final EventId eventId;
    private final UUID sellerId;
    private final String serialNumber;

    private NotAcceptableProductRecognized(EventId eventId, UUID sellerId, String serialNumber) {
        this.eventId = eventId;
        this.sellerId = sellerId;
        this.serialNumber = serialNumber;
    }

    static NotAcceptableProductRecognized create(UUID sellerId, String serialNumber) {
        return new NotAcceptableProductRecognized(EventId.create(), sellerId, serialNumber);
    }

    public EventId getEventId() {
        return eventId;
    }

    public UUID getSellerId() {
        return sellerId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
}
