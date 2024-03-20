package com.smalaca.order.domain.eventpublisher;

import com.smalaca.annotation.architecture.SecondaryPort;
import com.smalaca.order.domain.order.OrderCancelled;

@SecondaryPort
public interface EventPublisher {
    void publish(OrderCancelled orderCancelled);
}
