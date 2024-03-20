package com.smalaca.shopmanagement.domain.eventpublisher;

import java.time.LocalDateTime;
import java.util.UUID;

public class EventId {
    private final UUID eventId;
    private final UUID traceId;
    private final UUID correlationId;
    private final LocalDateTime creationDateTime;

    private EventId(UUID eventId, UUID traceId, UUID correlationId, LocalDateTime creationDateTime) {
        this.eventId = eventId;
        this.traceId = traceId;
        this.correlationId = correlationId;
        this.creationDateTime = creationDateTime;
    }

    public static EventId create() {
        return new EventId(id(), id(), id(), now());
    }

    private static LocalDateTime now() {
        return LocalDateTime.now();
    }

    private static UUID id() {
        return UUID.randomUUID();
    }

    public UUID getEventId() {
        return eventId;
    }

    public UUID getTraceId() {
        return traceId;
    }

    public UUID getCorrelationId() {
        return correlationId;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }
}
