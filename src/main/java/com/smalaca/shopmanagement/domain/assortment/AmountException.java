package com.smalaca.shopmanagement.domain.assortment;

class AmountException extends RuntimeException {
    private final int amount;

    AmountException(int amount) {
        this.amount = amount;
    }
}
