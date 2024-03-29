package com.smalaca.shopmanagement.domain.assortment;

import com.smalaca.annotation.ddd.DomainEntity;
import com.smalaca.annotation.ddd.Factory;

@DomainEntity
class AssortmentItem {
    private final Amount amount;
    // business identifier
    private final String serialNumber;
    private final Product product;

    private AssortmentItem(Amount amount, String serialNumber, Product product) {
        this.amount = amount;
        this.serialNumber = serialNumber;
        this.product = product;
    }

    @Factory
    static AssortmentItem from(Amount amount, AddProductCommand command) {
        return new AssortmentItem(amount, command.serialNumber(), Product.from(command));
    }
}
