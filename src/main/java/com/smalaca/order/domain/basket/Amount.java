package com.smalaca.order.domain.basket;

import com.smalaca.annotation.ddd.ValueObject;

@ValueObject
public class Amount {
    private final int amount;

    public Amount(int amount) {
        this.amount = amount;
    }
}
