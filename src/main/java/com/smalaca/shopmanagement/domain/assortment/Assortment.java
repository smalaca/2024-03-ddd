package com.smalaca.shopmanagement.domain.assortment;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;
import jakarta.persistence.Id;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@AggregateRoot
public class Assortment {
    @Id
    private UUID assortmentId;

    // bussiness identifier
    private UUID sellerId;

    private Map<Product, Amount> products = new HashMap<>();

    @PrimaryPort
    public void addProduct(Amount amount, AddProductCommand command) {
        products.put(Product.from(command), amount);
    }
}
