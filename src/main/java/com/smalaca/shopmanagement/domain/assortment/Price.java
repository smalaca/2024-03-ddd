package com.smalaca.shopmanagement.domain.assortment;

import com.smalaca.annotation.ddd.ValueObject;

import java.math.BigDecimal;

@ValueObject
public class Price {
    private final BigDecimal price;

    public Price(BigDecimal price) {
        this.price = price;
    }
}
