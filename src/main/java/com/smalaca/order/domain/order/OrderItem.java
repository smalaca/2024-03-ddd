package com.smalaca.order.domain.order;

import com.smalaca.annotation.ddd.DomainEntity;
import com.smalaca.order.domain.amount.Amount;

import java.util.UUID;

@DomainEntity
class OrderItem {
    private final UUID productId;
    private final Amount amount;

    OrderItem(UUID productId, Amount amount) {
        this.productId = productId;
        this.amount = amount;
    }
}
