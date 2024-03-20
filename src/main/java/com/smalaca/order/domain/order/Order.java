package com.smalaca.order.domain.order;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;
import jakarta.persistence.Id;

import java.util.Optional;
import java.util.UUID;

import static com.smalaca.order.domain.order.OrderStatus.CANCEL;

@AggregateRoot
public class Order {
    @Id
    private UUID orderId;
    // business identifier
    private String orderNumber;
    private OrderStatus status;
    private String cancellationReason;

    @PrimaryPort
    public void cancel(Optional<String> reason) {
        status = CANCEL;
        reason.ifPresent(presentReason -> this.cancellationReason = presentReason);
    }
}
