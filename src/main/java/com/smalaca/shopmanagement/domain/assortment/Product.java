package com.smalaca.shopmanagement.domain.assortment;

import com.smalaca.annotation.ddd.DomainEntity;
import com.smalaca.annotation.ddd.Factory;

@DomainEntity
class Product {

    private final String name;

    // business identifier
    private final String serialNumber;
    private final String description;
    private final Price price;

    private Product(String name, String serialNumber, String description, Price price) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.description = description;
        this.price = price;
    }

    @Factory
    static Product from(AddProductCommand command) {
        return new Product(command.name(), command.serialNumber(), command.description(), command.price());
    }
}
