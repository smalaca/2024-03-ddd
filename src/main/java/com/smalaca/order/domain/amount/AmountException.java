package com.smalaca.order.domain.amount;

class AmountException extends RuntimeException {
    private final int amount;

    AmountException(int amount) {
        this.amount = amount;
    }
}
