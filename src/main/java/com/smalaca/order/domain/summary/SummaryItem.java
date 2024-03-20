package com.smalaca.order.domain.summary;

import com.smalaca.annotation.ddd.DomainEntity;
import com.smalaca.order.domain.amount.Amount;

import java.util.UUID;

@DomainEntity
class SummaryItem {
    // business identifier
    private UUID productId;
    private Amount amount;

    UUID getProductId() {
        return productId;
    }

    Amount getAmount() {
        return amount;
    }
}
