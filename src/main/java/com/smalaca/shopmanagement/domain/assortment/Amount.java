package com.smalaca.shopmanagement.domain.assortment;

import com.smalaca.annotation.ddd.ValueObject;

@ValueObject
public class Amount {
    private final int amount;

    public Amount(int amount) {
        this.amount = amount;
    }
}
