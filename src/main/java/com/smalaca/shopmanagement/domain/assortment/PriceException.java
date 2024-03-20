package com.smalaca.shopmanagement.domain.assortment;

import java.math.BigDecimal;

class PriceException extends RuntimeException {
    private final BigDecimal price;

    PriceException(BigDecimal price) {
        this.price = price;
    }
}
