package com.smalaca.order.domain.basket;

class AmountException extends RuntimeException {
    private final int amount;

    AmountException(int amount) {
        this.amount = amount;
    }
}
