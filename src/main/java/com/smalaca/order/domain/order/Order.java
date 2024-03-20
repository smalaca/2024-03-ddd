package com.smalaca.order.domain.order;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;
import jakarta.persistence.Id;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.smalaca.order.domain.order.OrderStatus.CANCEL;
import static com.smalaca.order.domain.order.OrderStatus.CREATED;

@AggregateRoot
public class Order {
    @Id
    private UUID orderId;
    // business identifier
    private final OrderNumber orderNumber;
    private final UUID summaryId;
    private final UUID buyerId;
    private final List<OrderItem> items;
    private OrderStatus status;
    private String cancellationReason;

    public Order(OrderNumber orderNumber, UUID summaryId, UUID buyerId, List<OrderItem> items) {
        this.orderNumber = orderNumber;
        this.summaryId = summaryId;
        this.buyerId = buyerId;
        this.items = items;
        this.status = CREATED;
    }

    @PrimaryPort
    public void cancel(Optional<String> reason) {
        status = CANCEL;
        reason.ifPresent(presentReason -> this.cancellationReason = presentReason);
    }
}
