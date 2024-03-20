package com.smalaca.order.domain.basket;

import com.smalaca.annotation.ddd.DomainEntity;

import java.util.UUID;

@DomainEntity
class BasketItem {
    // business identifier
    private final UUID productId;
    private Amount amount;

    BasketItem(UUID productId, Amount amount) {
        this.productId = productId;
        this.amount = amount;
    }

    boolean isFor(UUID productId) {
        return this.productId == productId;
    }

    boolean hasSameAs(Amount amount) {
        return this.amount.sameAs(amount);
    }

    void remove(Amount amount) {
        this.amount = this.amount.minus(amount);
    }
}
