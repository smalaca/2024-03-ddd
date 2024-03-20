package com.smalaca.order.domain.order;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.order.domain.eventpublisher.EventPublisher;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.smalaca.order.domain.order.OrderStatus.ACCEPTED;
import static com.smalaca.order.domain.order.OrderStatus.CANCEL;
import static com.smalaca.order.domain.order.OrderStatus.CREATED;

@AggregateRoot
@Entity
@Table
public class Order {
    @Id
    @GeneratedValue
    private UUID orderId;
    // business identifier
    @Embedded
    private final OrderNumber orderNumber;
    private final UUID summaryId;
    private final UUID buyerId;
    @OneToMany
    private final List<OrderItem> items;
    @Embedded
    private final Address deliveryAddress;
    private OrderStatus status;
    private String cancellationReason;

    Order(OrderNumber orderNumber, UUID summaryId, UUID buyerId, List<OrderItem> items, Address deliveryAddress) {
        this.orderNumber = orderNumber;
        this.summaryId = summaryId;
        this.buyerId = buyerId;
        this.items = items;
        this.deliveryAddress = deliveryAddress;
        this.status = CREATED;
    }

    @PrimaryPort
    public void cancel(Optional<String> reason, EventPublisher eventPublisher) {
        status = CANCEL;
        reason.ifPresent(presentReason -> this.cancellationReason = presentReason);
        eventPublisher.publish(OrderCancelled.create(orderId, orderNumber));
    }

    @PrimaryPort
    public void accept(EventPublisher eventPublisher) {
        status = ACCEPTED;
        eventPublisher.publish(PurchasePaid.create(orderId));
    }
}
