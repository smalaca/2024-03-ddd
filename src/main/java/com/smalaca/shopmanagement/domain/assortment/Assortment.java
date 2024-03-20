package com.smalaca.shopmanagement.domain.assortment;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AggregateRoot
public class Assortment {
    @Id
    private UUID assortmentId;

    // bussiness identifier
    private UUID sellerId;

    private final List<AssortmentItem> products = new ArrayList<>();

    @PrimaryPort
    public void addProduct(Amount amount, AddProductCommand command) {
        products.add(AssortmentItem.from(amount, command));
    }
}
