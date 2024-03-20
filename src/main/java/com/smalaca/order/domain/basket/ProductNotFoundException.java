package com.smalaca.order.domain.basket;

import java.util.UUID;

class ProductNotFoundException extends RuntimeException {
    private final UUID productId;

    ProductNotFoundException(UUID productId) {
        this.productId = productId;
    }
}
