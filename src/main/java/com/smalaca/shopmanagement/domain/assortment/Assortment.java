package com.smalaca.shopmanagement.domain.assortment;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;
import jakarta.persistence.Id;

import java.util.UUID;

@AggregateRoot
public class Assortment {
    @Id
    private UUID assortmentId;

    // bussiness identifier
    private UUID sellerId;

    @PrimaryPort
    public void addProduct() {

    }
}
