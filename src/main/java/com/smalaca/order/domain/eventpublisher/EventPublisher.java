package com.smalaca.order.domain.eventpublisher;

import com.smalaca.annotation.architecture.SecondaryPort;
import com.smalaca.order.domain.order.OrderCancelled;
import com.smalaca.order.domain.order.PurchasePaid;

@SecondaryPort
public interface EventPublisher {
    void publish(OrderCancelled orderCancelled);

    void publish(PurchasePaid purchasePaid);
}
