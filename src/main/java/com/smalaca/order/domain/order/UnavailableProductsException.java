package com.smalaca.order.domain.order;

class UnavailableProductsException extends RuntimeException {
    UnavailableProductsException(CreateOrderCommand command) {
    }
}
