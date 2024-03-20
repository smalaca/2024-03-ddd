package com.smalaca.shopmanagement.domain.assortment;

import com.smalaca.annotation.ddd.Factory;
import com.smalaca.annotation.ddd.ValueObject;

import java.math.BigDecimal;

@ValueObject
public class Price {
    private final BigDecimal price;

    private Price(BigDecimal price) {
        this.price = price;
    }

    @Factory
    public static Price from(BigDecimal price) {
        if (isPriceLowerThanOne(price)) {
            throw new PriceException(price);
        }

        return new Price(price);
    }

    private static boolean isPriceLowerThanOne(BigDecimal price) {
        return false;
    }
}
