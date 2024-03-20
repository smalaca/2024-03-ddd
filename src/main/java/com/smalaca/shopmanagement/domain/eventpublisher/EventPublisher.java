package com.smalaca.shopmanagement.domain.eventpublisher;

import com.smalaca.annotation.architecture.SecondaryPort;
import com.smalaca.shopmanagement.domain.assortment.NotAcceptableProductRecognized;

@SecondaryPort
public interface EventPublisher {
    void publish(NotAcceptableProductRecognized event);
}
