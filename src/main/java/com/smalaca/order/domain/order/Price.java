package com.smalaca.order.domain.order;

import com.smalaca.annotation.ddd.ValueObject;

import java.math.BigDecimal;

@ValueObject
class Price {
    private final BigDecimal price;

    Price(BigDecimal price) {
        this.price = price;
    }

    BigDecimal value() {
        return price;
    }
}
