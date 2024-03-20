package com.smalaca.order.domain.basket;

import com.smalaca.annotation.ddd.ValueObject;

@ValueObject
public class Amount {
    private final int amount;

    private Amount(int amount) {
        this.amount = amount;
    }

    public static Amount from(int amount) {
        if (amount < 1) {
            throw new AmountException(amount);
        }

        return new Amount(amount);
    }

    boolean isGreaterThan(Amount amount) {
        return this.amount > amount.amount;
    }

    Amount minus(Amount amount) {
        return Amount.from(this.amount - amount.amount);
    }
}
