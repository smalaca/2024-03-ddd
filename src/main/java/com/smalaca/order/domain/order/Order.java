package com.smalaca.order.domain.order;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;

@AggregateRoot
public class Order {
    @PrimaryPort
    public void cancel() {

    }
}
