package com.smalaca.shopmanagement.domain.assortment;

import com.smalaca.annotation.ddd.Factory;
import com.smalaca.annotation.ddd.ValueObject;

@ValueObject
public class Amount {
    private final int amount;

    private Amount(int amount) {
        this.amount = amount;
    }

    @Factory
    public static Amount from(int amount) {
        if (amount < 1) {
            throw new AmountException(amount);
        }

        return new Amount(amount);
    }
}
